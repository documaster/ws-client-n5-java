package com.documaster.rms.noark.ws.noarkentities;

import com.documaster.rms.noark.ws.client.action.LinkAction;
import com.documaster.rms.noark.ws.constants.Merknadstype;
import com.documaster.rms.noark.ws.serialization.NoarkEnumJsonDeserializer;
import com.documaster.rms.noark.ws.serialization.NoarkEnumJsonSerializer;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Merknad extends NoarkEntityBase<Merknad> {

	public static final String MAPPE_LINK = "refMappe";
	public static final String REGISTRERING_LINK = "refRegistrering";
	public static final String DOKUMENT_LINK = "refDokument";

	private String tekst;

	@JsonSerialize(using = NoarkEnumJsonSerializer.class)
	@JsonDeserialize(using = NoarkEnumJsonDeserializer.class)
	private Merknadstype merknadstype;

	public Merknad(String tekst, Merknadstype merknadstype) {

		this.tekst = tekst;
		this.merknadstype = merknadstype;
	}

	@JsonCreator
	private Merknad(
			@JsonProperty("id") String id,
			@JsonProperty("uuid") String uuid,
			@JsonProperty("version") String version) {

		super(id, uuid, version);
	}

	public String getTekst() {

		return tekst;
	}

	public void setTekst(String tekst) {

		this.tekst = tekst;
	}

	public Merknadstype getMerknadstype() {

		return merknadstype;
	}

	public void setMerknadstype(Merknadstype merknadstype) {

		this.merknadstype = merknadstype;
	}

	public LinkAction<Merknad> linkMappe(String mappeId) {

		return link(MAPPE_LINK, mappeId);
	}

	public LinkAction<Merknad> linkMappe(AbstraktMappe mappe) {

		return link(MAPPE_LINK, mappe);
	}

	public LinkAction<Merknad> linkRegistrering(String registreringId) {

		return link(REGISTRERING_LINK, registreringId);
	}

	public LinkAction<Merknad> linkRegistrering(AbstraktRegistrering registrering) {

		return link(REGISTRERING_LINK, registrering);
	}

	public LinkAction<Merknad> linkDokument(String dokumentId) {

		return link(DOKUMENT_LINK, dokumentId);
	}

	public LinkAction<Merknad> linkDokument(Dokument dokument) {

		return link(DOKUMENT_LINK, dokument);
	}

	@JsonIgnore
	public String getRefMappe() {

		return getRef(MAPPE_LINK);
	}

	@JsonIgnore
	public String getRefRegistrering() {

		return getRef(REGISTRERING_LINK);
	}

	@JsonIgnore
	public String getRefDokument() {

		return getRef(DOKUMENT_LINK);
	}
}
