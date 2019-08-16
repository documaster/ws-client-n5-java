package com.documaster.rms.noark.ws.noarkentities;

import com.documaster.rms.noark.ws.client.action.LinkAction;
import com.documaster.rms.noark.ws.constants.AdministrativEnhet;
import com.documaster.rms.noark.ws.constants.Ekspederingskanal;
import com.documaster.rms.noark.ws.constants.Korrespondanseparttype;
import com.documaster.rms.noark.ws.serialization.NoarkEnumJsonDeserializer;
import com.documaster.rms.noark.ws.serialization.NoarkEnumJsonSerializer;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Korrespondansepart extends PartBase<Korrespondansepart> {

	public static final String REGISTRERING_LINK = "refRegistrering";

	private String korrespondansepartNavn;
	private String saksbehandler;

	@JsonSerialize(using = NoarkEnumJsonSerializer.class)
	@JsonDeserialize(using = NoarkEnumJsonDeserializer.class)
	private Korrespondanseparttype korrespondanseparttype;

	@JsonSerialize(using = NoarkEnumJsonSerializer.class)
	@JsonDeserialize(using = NoarkEnumJsonDeserializer.class)
	private AdministrativEnhet administrativEnhet;

	@JsonSerialize(using = NoarkEnumJsonSerializer.class)
	@JsonDeserialize(using = NoarkEnumJsonDeserializer.class)
	private Ekspederingskanal ekspederingskanal;

	public Korrespondansepart(Korrespondanseparttype type, String korrespondansepartNavn) {

		this.korrespondanseparttype = type;
		this.korrespondansepartNavn = korrespondansepartNavn;
	}

	@JsonCreator
	private Korrespondansepart(
			@JsonProperty("id") String id,
			@JsonProperty("uuid") String uuid,
			@JsonProperty("version") String version) {

		super(id, uuid, version);
	}

	public Korrespondanseparttype getKorrespondanseparttype() {

		return korrespondanseparttype;
	}

	public void setKorrespondanseparttype(Korrespondanseparttype korrespondanseparttype) {

		this.korrespondanseparttype = korrespondanseparttype;
	}

	public String getKorrespondansepartNavn() {

		return korrespondansepartNavn;
	}

	public void setKorrespondansepartNavn(String korrespondansepartNavn) {

		this.korrespondansepartNavn = korrespondansepartNavn;
	}

	public AdministrativEnhet getAdministrativEnhet() {

		return administrativEnhet;
	}

	public void setAdministrativEnhet(AdministrativEnhet administrativEnhet) {

		this.administrativEnhet = administrativEnhet;
	}

	public String getSaksbehandler() {

		return saksbehandler;
	}

	public void setSaksbehandler(String saksbehandler) {

		this.saksbehandler = saksbehandler;
	}

	public Ekspederingskanal getEkspederingskanal() {

		return ekspederingskanal;
	}

	public void setEkspederingskanal(Ekspederingskanal ekspederingskanal) {

		this.ekspederingskanal = ekspederingskanal;
	}

	public LinkAction<Korrespondansepart> linkRegistrering(String registreringId) {

		return link(REGISTRERING_LINK, registreringId);
	}

	public LinkAction<Korrespondansepart> linkRegistrering(AbstraktRegistrering registrering) {

		return link(REGISTRERING_LINK, registrering);
	}

	@JsonIgnore
	public String getRefRegistrering() {

		return getRef(REGISTRERING_LINK);
	}
}
