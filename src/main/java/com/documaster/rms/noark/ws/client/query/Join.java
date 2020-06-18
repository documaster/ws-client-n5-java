package com.documaster.rms.noark.ws.client.query;

import com.documaster.rms.noark.ws.Argument;

public class Join {

	private final String alias;
	private final String reference;

	public Join(String alias, String reference) {

		Argument.notNullOrEmpty("alias", alias);
		Argument.notNullOrEmpty("reference", reference);

		this.alias = alias;
		this.reference = reference;
	}

	public String getAlias() {

		return alias;
	}

	public String getReference() {

		return reference;
	}
}
