package com.documaster.rms.noark.ws.noarkentities;

import java.util.Optional;

import com.documaster.rms.noark.ws.client.action.LinkAction;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Posisjon extends NoarkEntityBase<Posisjon> {

	public static final String MAPPE_LINK = "refMappe";
	public static final String REGISTRERING_LINK = "refRegistrering";

	private String koordinatsystem;
	private String koordX;
	private String koordY;
	private String koordZ;
	private boolean serializeKoordZ;

	public Posisjon(String koordinatsystem, String koordX, String koordY, String koordZ) {

		this.koordinatsystem = koordinatsystem;
		this.koordX = koordX;
		this.koordY = koordY;
		setKoordZ(koordZ);
	}

	@JsonCreator
	private Posisjon(
			@JsonProperty("id") String id,
			@JsonProperty("uuid") String uuid,
			@JsonProperty("version") String version) {

		super(id, uuid, version);
	}

	public String getKoordinatsystem() {

		return koordinatsystem;
	}

	public void setKoordinatsystem(String koordinatsystem) {

		this.koordinatsystem = koordinatsystem;
	}

	public String getKoordX() {

		return koordX;
	}

	public void setKoordX(String koordX) {

		this.koordX = koordX;
	}

	public String getKoordY() {

		return koordY;
	}

	public void setKoordY(String koordY) {

		this.koordY = koordY;
	}

	public String getKoordZ() {

		return koordZ;
	}

	@JsonProperty("koordZ")
	public void setKoordZ(String koordZ) {

		this.koordZ = koordZ;
		serializeKoordZ = true;
	}

	@JsonProperty("koordZ")
	public Optional<String> getKoordZAsOptional() {

		if (serializeKoordZ) {

			return Optional.ofNullable(koordZ);
		}

		return null;
	}

	public LinkAction<Posisjon> linkMappe(String mappeId) {

		return link(MAPPE_LINK, mappeId);
	}

	public LinkAction<Posisjon> linkMappe(AbstraktMappe mappe) {

		return link(MAPPE_LINK, mappe);
	}

	public LinkAction<Posisjon> linkRegistrering(String registreringId) {

		return link(REGISTRERING_LINK, registreringId);
	}

	public LinkAction<Posisjon> linkRegistrering(AbstraktRegistrering registrering) {

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
