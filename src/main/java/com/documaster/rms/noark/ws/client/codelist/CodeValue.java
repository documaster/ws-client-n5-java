package com.documaster.rms.noark.ws.client.codelist;

import com.documaster.rms.noark.ws.client.Bean;
import com.fasterxml.jackson.annotation.JsonIgnore;

public interface CodeValue extends Bean {

	@JsonIgnore
	String getCode();

	String getName();

	String getDescription();

	void setDescription(String description);
}
