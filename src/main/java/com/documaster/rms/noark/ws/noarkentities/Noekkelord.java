package com.documaster.rms.noark.ws.noarkentities;

import com.documaster.rms.noark.ws.client.action.LinkAction;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Noekkelord extends NoarkEntityBase<Noekkelord> {

	public static final String MAPPE_LINK = "refMappe";
	public static final String REGISTRERING_LINK = "refRegistrering";

	private String verdi;

	public Noekkelord(String verdi) {

		this.verdi = verdi;
	}

	@JsonCreator
	private Noekkelord(
			@JsonProperty("id") String id,
			@JsonProperty("uuid") String uuid,
			@JsonProperty("version") String version) {

		super(id, uuid, version);
	}

	public String getVerdi() {

		return verdi;
	}

	public void setVerdi(String verdi) {

		this.verdi = verdi;
	}

	public LinkAction<Noekkelord> linkMappe(String mappeId) {

		return link(MAPPE_LINK, mappeId);
	}

	public LinkAction<Noekkelord> linkMappe(AbstraktMappe mappe) {

		return link(MAPPE_LINK, mappe);
	}

	public LinkAction<Noekkelord> linkRegistrering(String registreringId) {

		return link(REGISTRERING_LINK, registreringId);
	}

	public LinkAction<Noekkelord> linkRegistrering(AbstraktRegistrering registrering) {

		return link(REGISTRERING_LINK, registrering);
	}

	@JsonIgnore
	public String getRefMappe() {

		return getRef(MAPPE_LINK);
	}

	@JsonIgnore
	public String getRefRegistrering() {

		return getRef(REGISTRERING_LINK);
	}
}
