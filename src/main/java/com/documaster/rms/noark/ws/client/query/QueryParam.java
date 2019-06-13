package com.documaster.rms.noark.ws.client.query;

import java.util.Date;

import com.documaster.rms.noark.ws.Argument;
import com.fasterxml.jackson.annotation.JsonInclude;

public class QueryParam {

	public String paramName;

	@JsonInclude(JsonInclude.Include.ALWAYS)
	public Object paramValue;

	private QueryParam(String paramName) {

		Argument.notNullOrEmpty("paramName", paramName);
		this.paramName = paramName;
	}

	public QueryParam(String paramName, String paramValue) {

		this(paramName);
		this.paramValue = paramValue;
	}

	public QueryParam(String paramName, int paramValue) {

		this(paramName);
		this.paramValue = paramValue;
	}

	public QueryParam(String paramName, Date paramValue) {

		this(paramName);
		this.paramValue = paramValue;
	}

	public QueryParam(String paramName, long paramValue) {

		this(paramName);
		this.paramValue = paramValue;
	}

	public String getParamName() {

		return paramName;
	}

	public Object getParamValue() {

		return paramValue;
	}
}
