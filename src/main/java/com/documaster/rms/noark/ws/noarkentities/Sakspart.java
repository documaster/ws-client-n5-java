package com.documaster.rms.noark.ws.noarkentities;

import com.documaster.rms.noark.ws.client.action.LinkAction;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Sakspart extends PartBase<Sakspart> {

	public static final String MAPPE_LINK = "refMappe";

	private String sakspartNavn;
	private String sakspartRolle;
	private String sakspartIdent;

	public Sakspart(String sakspartNavn, String sakspartRolle) {

		this.sakspartNavn = sakspartNavn;
		this.sakspartRolle = sakspartRolle;
	}

	@JsonCreator
	private Sakspart(
			@JsonProperty("id") String id,
			@JsonProperty("uuid") String uuid,
			@JsonProperty("version") String version) {

		super(id, uuid, version);
	}

	public String getSakspartNavn() {

		return sakspartNavn;
	}

	public void setSakspartNavn(String sakspartNavn) {

		this.sakspartNavn = sakspartNavn;
	}

	public String getSakspartRolle() {

		return sakspartRolle;
	}

	public void setSakspartRolle(String sakspartRolle) {

		this.sakspartRolle = sakspartRolle;
	}

	public String getSakspartIdent() {

		return sakspartIdent;
	}

	public void setSakspartIdent(String sakspartIdent) {

		this.sakspartIdent = sakspartIdent;
	}

	public LinkAction<Sakspart> linkMappe(String mappeId) {

		return link(MAPPE_LINK, mappeId);
	}

	public LinkAction<Sakspart> linkMappe(Saksmappe mappe) {

		return link(MAPPE_LINK, mappe);
	}

	@JsonIgnore
	public String getRefMappe() {

		return getRef(MAPPE_LINK);
	}
}
