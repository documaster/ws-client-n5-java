package com.documaster.rms.noark.ws.client.handlers;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import com.documaster.rms.noark.ws.client.exceptions.ConflictException;
import com.documaster.rms.noark.ws.client.exceptions.InsufficientPrivilegesException;
import com.documaster.rms.noark.ws.client.exceptions.ServiceException;
import com.documaster.rms.noark.ws.client.exceptions.UnauthorizedException;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;

class ErrorResponseHandler {

	<T extends HttpResponse> void throwOnErrorResponse(T response) throws ServiceException {

		if (response == null || response.getStatusLine() == null) {

			throw new ServiceException();
		}

		switch (response.getStatusLine().getStatusCode()) {

			case HttpStatus.SC_OK:
			case HttpStatus.SC_CREATED:
			case HttpStatus.SC_NO_CONTENT:
				return;

			case HttpStatus.SC_UNAUTHORIZED:
				throw new UnauthorizedException();

			case HttpStatus.SC_CONFLICT:
				throw new ConflictException();

			case HttpStatus.SC_FORBIDDEN:
				throw new InsufficientPrivilegesException();

			case HttpStatus.SC_NOT_FOUND:
				throw new ServiceException("The requested resource was not found");

			case HttpStatus.SC_SERVICE_UNAVAILABLE:
				throw new ServiceException("Service not available");

			default:
				try {

					throw new ServiceException(
							IOUtils.toString(response.getEntity().getContent(), StandardCharsets.UTF_8));

				} catch (IOException ex) {

					throw new ServiceException(ex);
				}
		}
	}
}
