package com.documaster.rms.noark.ws.noarkentities;

import com.documaster.rms.noark.ws.client.action.LinkAction;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EksternId extends NoarkEntityBase<EksternId> {

	public static final String MAPPE_LINK = "refMappe";
	public static final String REGISTRERING_LINK = "refRegistrering";
	public static final String DOKUMENT_LINK = "refDokument";

	private String eksterntSystem;
	private String eksternID;

	public EksternId(String eksterntSystem, String eksternID) {

		this.eksterntSystem = eksterntSystem;
		this.eksternID = eksternID;
	}

	@JsonCreator
	private EksternId(
			@JsonProperty("id") String id,
			@JsonProperty("uuid") String uuid,
			@JsonProperty("version") String version) {

		super(id, uuid, version);
	}

	public String getEksterntSystem() {

		return eksterntSystem;
	}

	public void setEksterntSystem(String eksterntSystem) {

		this.eksterntSystem = eksterntSystem;
	}

	public String getEksternID() {

		return eksternID;
	}

	public void setEksternID(String eksternID) {

		this.eksternID = eksternID;
	}

	public LinkAction<EksternId> linkMappe(String mappeId) {

		return link(MAPPE_LINK, mappeId);
	}

	public LinkAction<EksternId> linkMappe(AbstraktMappe mappe) {

		return link(MAPPE_LINK, mappe);
	}

	public LinkAction<EksternId> linkRegistrering(String registreringId) {

		return link(REGISTRERING_LINK, registreringId);
	}

	public LinkAction<EksternId> linkRegistrering(AbstraktRegistrering registrering) {

		return link(REGISTRERING_LINK, registrering);
	}

	public LinkAction<EksternId> linkDokument(String dokumentId) {

		return link(DOKUMENT_LINK, dokumentId);
	}

	public LinkAction<EksternId> linkDokument(Dokument dokument) {

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
