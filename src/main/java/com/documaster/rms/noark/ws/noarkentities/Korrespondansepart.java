package com.documaster.rms.noark.ws.noarkentities;

import java.util.Optional;

import com.documaster.rms.noark.ws.client.action.LinkAction;
import com.documaster.rms.noark.ws.constants.AdministrativEnhet;
import com.documaster.rms.noark.ws.constants.Ekspederingskanal;
import com.documaster.rms.noark.ws.constants.Korrespondanseparttype;
import com.documaster.rms.noark.ws.serialization.NoarkEnumJsonDeserializer;
import com.documaster.rms.noark.ws.serialization.NoarkEnumJsonSerializer;
import com.documaster.rms.noark.ws.serialization.NoarkOptionalEnumJsonSerializer;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Korrespondansepart extends PartBase<Korrespondansepart> {

	public static final String REGISTRERING_LINK = "refRegistrering";
	public static final String EKSTERN_ID_LINK = "refEksternId";

	private String korrespondansepartNavn;
	private String saksbehandler;
	private boolean serializeSaksbehandler;

	private Boolean erPerson;

	private String eksternReferanse;
	private boolean serializeEksternReferanse;

	private Boolean skjermEInnsyn;

	@JsonSerialize(using = NoarkEnumJsonSerializer.class)
	@JsonDeserialize(using = NoarkEnumJsonDeserializer.class)
	private Korrespondanseparttype korrespondanseparttype;

	@JsonSerialize(using = NoarkOptionalEnumJsonSerializer.class)
	@JsonDeserialize(using = NoarkEnumJsonDeserializer.class)
	private AdministrativEnhet administrativEnhet;

	private boolean serializeAdministrativEnhet;

	@JsonSerialize(using = NoarkOptionalEnumJsonSerializer.class)
	@JsonDeserialize(using = NoarkEnumJsonDeserializer.class)
	private Ekspederingskanal ekspederingskanal;

	private boolean serializeEkspederingskanal;

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

	@JsonProperty("administrativEnhet")
	public void setAdministrativEnhet(AdministrativEnhet administrativEnhet) {

		this.administrativEnhet = administrativEnhet;
		serializeAdministrativEnhet = true;
	}

	@JsonProperty("administrativEnhet")
	public Optional<AdministrativEnhet> getAdministrativEnhetAsOptional() {

		if (serializeAdministrativEnhet) {

			return Optional.ofNullable(administrativEnhet);
		}

		return null;
	}

	public String getSaksbehandler() {

		return saksbehandler;
	}

	@JsonProperty("saksbehandler")
	public void setSaksbehandler(String saksbehandler) {

		this.saksbehandler = saksbehandler;
		serializeSaksbehandler = true;
	}

	@JsonProperty("saksbehandler")
	public Optional<String> getSaksbehandlerAsOptional() {

		if (serializeSaksbehandler) {

			return Optional.ofNullable(saksbehandler);
		}

		return null;
	}

	public Boolean getErPerson() {

		return erPerson;
	}

	public void setErPerson(Boolean erPerson) {

		this.erPerson = erPerson;
	}

	public String getEksternReferanse() {

		return eksternReferanse;
	}

	@JsonProperty("eksternReferanse")
	public void setEksternReferanse(String eksternReferanse) {

		this.eksternReferanse = eksternReferanse;
		serializeEksternReferanse = true;
	}

	@JsonProperty("eksternReferanse")
	public Optional<String> getEksternReferanseAsOptional() {

		if (serializeEksternReferanse) {

			return Optional.ofNullable(eksternReferanse);
		}

		return null;
	}

	public Boolean getSkjermEInnsyn() {

		return skjermEInnsyn;
	}

	public void setSkjermEInnsyn(Boolean skjermEInnsyn) {

		this.skjermEInnsyn = skjermEInnsyn;
	}

	public Ekspederingskanal getEkspederingskanal() {

		return ekspederingskanal;
	}

	@JsonProperty("ekspederingskanal")
	public void setEkspederingskanal(Ekspederingskanal ekspederingskanal) {

		this.ekspederingskanal = ekspederingskanal;
		serializeEkspederingskanal = true;
	}

	@JsonProperty("ekspederingskanal")
	public Optional<Ekspederingskanal> getEkspederingskanalAsOptional() {

		if (serializeEkspederingskanal) {

			return Optional.ofNullable(ekspederingskanal);
		}

		return null;
	}

	public LinkAction<Korrespondansepart> linkRegistrering(String registreringId) {

		return link(REGISTRERING_LINK, registreringId);
	}

	public LinkAction<Korrespondansepart> linkRegistrering(AbstraktRegistrering registrering) {

		return link(REGISTRERING_LINK, registrering);
	}

	public LinkAction<Korrespondansepart> linkEksternId(String... eksternIdIds) {

		return link(EKSTERN_ID_LINK, eksternIdIds);
	}

	public LinkAction<Korrespondansepart> linkEksternId(EksternId... eksternId) {

		return link(EKSTERN_ID_LINK, eksternId);
	}

	@JsonIgnore
	public String getRefRegistrering() {

		return getRef(REGISTRERING_LINK);
	}
}
