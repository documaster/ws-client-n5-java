package com.documaster.rms.noark.ws.client.action;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ActionName {

	@JsonProperty("save")
	SAVE,

	@JsonProperty("delete")
	DELETE,

	@JsonProperty("link")
	LINK,

	@JsonProperty("unlink")
	UNLINK;
}
