package com.documaster.rms.noark.ws.client.handlers;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import com.documaster.rms.noark.ws.client.HttpClient;
import com.documaster.rms.noark.ws.client.exceptions.BadRequestException;
import com.documaster.rms.noark.ws.client.exceptions.ConflictException;
import com.documaster.rms.noark.ws.client.exceptions.InsufficientPrivilegesException;
import com.documaster.rms.noark.ws.client.exceptions.ResourceNotFoundException;
import com.documaster.rms.noark.ws.client.exceptions.ServiceException;
import com.documaster.rms.noark.ws.client.exceptions.UnauthorizedException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;

public class ErrorResponseHandler {

	private final ObjectMapper mapper;
	private final HttpClient.ErrorResponseType errorResponseType;

	public ErrorResponseHandler() {

		this(null);
	}

	public ErrorResponseHandler(ObjectMapper mapper) {

		this(mapper, null);
	}

	public ErrorResponseHandler(ObjectMapper mapper, HttpClient.ErrorResponseType errorResponseType) {

		this.mapper = mapper;
		this.errorResponseType = errorResponseType;

		if (isApplicationJsonErrorResponseType() && mapper == null) {

			throw new IllegalStateException(
					"The specified object mapper cannot be null when detailed error messages are to be used.");
		}
	}

	<T extends HttpResponse> void throwOnErrorResponse(T response) throws ServiceException {

		if (response == null || response.getStatusLine() == null) {

			throw new ServiceException();
		}

		ServiceException.ErrorMessage errorMessage = null;

		int statusCode = response.getStatusLine().getStatusCode();

		if (statusCode / 100 == 2) {

			return;
		}

		if (isApplicationJsonErrorResponseType()) {

			errorMessage = getErrorMessage(response);
		}

		switch (statusCode) {

			case HttpStatus.SC_BAD_REQUEST:
				throw new BadRequestException(errorMessage);

			case HttpStatus.SC_UNAUTHORIZED:
				throw new UnauthorizedException(errorMessage);

			case HttpStatus.SC_CONFLICT:
				throw new ConflictException(errorMessage);

			case HttpStatus.SC_FORBIDDEN:
				throw new InsufficientPrivilegesException(errorMessage);

			case HttpStatus.SC_NOT_FOUND:
				throw new ResourceNotFoundException("The requested resource was not found", errorMessage);

			case HttpStatus.SC_SERVICE_UNAVAILABLE:
				throw new ServiceException("Service not available", errorMessage);

			default:
				try {

					if (errorMessage != null) {

						throw new ServiceException(errorMessage);

					} else {

						throw new ServiceException(
								IOUtils.toString(response.getEntity().getContent(), StandardCharsets.UTF_8));
					}

				} catch (IOException ex) {

					throw new ServiceException(ex);
				}
		}
	}

	private ServiceException.ErrorMessage getErrorMessage(HttpResponse response) {

		if (response == null || response.getEntity() == null) {

			return null;
		}

		try {

			InputStream content = response.getEntity().getContent();

			if (content == null) {

				return null;
			}

			return mapper.readValue(content, ServiceException.ErrorMessage.class);

		} catch (Exception e) {

			// not in the expected format
			// silence...
			return null;
		}
	}

	private boolean isApplicationJsonErrorResponseType() {

		return HttpClient.ErrorResponseType.APPLICATION_JSON.equals(errorResponseType);
	}
}
