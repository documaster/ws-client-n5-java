package com.documaster.rms.noark.ws.client.exceptions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private ErrorMessage detailedErrorMessage;

	public ServiceException() {

		super();
	}

	public ServiceException(String message, Throwable cause) {

		super(message, cause);
	}

	public ServiceException(String message) {

		super(message);
	}

	public ServiceException(Throwable cause) {

		super(cause);
	}

	public ServiceException(ErrorMessage detailedErrorMessage) {

		this(detailedErrorMessage != null ? detailedErrorMessage.getDescription() : null, detailedErrorMessage);
	}

	public ServiceException(String message, ErrorMessage detailedErrorMessage) {

		super(message);

		this.detailedErrorMessage = detailedErrorMessage;
	}

	public ErrorMessage getDetailedErrorMessage() {

		return detailedErrorMessage;
	}

	public static class ErrorMessage {

		private final String errorId;
		private final String description;
		private final Integer status;

		@JsonCreator
		public ErrorMessage(
				@JsonProperty("errorId") String errorId,
				@JsonProperty("description") String description,
				@JsonProperty("status") Integer status) {

			this.errorId = errorId;
			this.description = description;
			this.status = status;
		}

		public String getErrorId() {

			return errorId;
		}

		public String getDescription() {

			return description;
		}

		public Integer getStatus() {

			return status;
		}
	}
}
