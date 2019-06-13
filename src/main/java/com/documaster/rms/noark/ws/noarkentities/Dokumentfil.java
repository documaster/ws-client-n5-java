package com.documaster.rms.noark.ws.noarkentities;

import com.documaster.rms.noark.ws.client.Bean;

public class Dokumentfil implements Bean {

	private String id;

	public Dokumentfil() {

	}

	public Dokumentfil(String id) {

		this.id = id;
	}

	public String getId() {

		return id;
	}
}
