package com.documaster.rms.noark.ws.noarkentities;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface NoarkEntity {

	@JsonIgnore
	String getId();

	@JsonIgnore
	String getVersion();
}
