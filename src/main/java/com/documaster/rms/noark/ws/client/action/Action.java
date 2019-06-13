package com.documaster.rms.noark.ws.client.action;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Action {

	@JsonProperty("action")
	private final ActionName name;

	public Action(ActionName name) {

		this.name = name;
	}

	public ActionName getName() {

		return name;
	}
}
