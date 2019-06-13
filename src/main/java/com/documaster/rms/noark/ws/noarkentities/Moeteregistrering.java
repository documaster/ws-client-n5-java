package com.documaster.rms.noark.ws.noarkentities;

import com.documaster.rms.noark.ws.constants.AdministrativEnhet;
import com.documaster.rms.noark.ws.constants.Moeteregistreringsstatus;
import com.documaster.rms.noark.ws.constants.Moeteregistreringstype;
import com.documaster.rms.noark.ws.constants.Moetesakstype;
import com.documaster.rms.noark.ws.serialization.NoarkEnumJsonDeserializer;
import com.documaster.rms.noark.ws.serialization.NoarkEnumJsonSerializer;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Moeteregistrering extends RegistreringBase<Moeteregistrering> {

	private String saksbehandler;

	@JsonSerialize(using = NoarkEnumJsonSerializer.class)
	@JsonDeserialize(using = NoarkEnumJsonDeserializer.class)
	private AdministrativEnhet administrativEnhet;

	@JsonSerialize(using = NoarkEnumJsonSerializer.class)
	@JsonDeserialize(using = NoarkEnumJsonDeserializer.class)
	private Moeteregistreringstype moeteregistreringstype;

	@JsonSerialize(using = NoarkEnumJsonSerializer.class)
	@JsonDeserialize(using = NoarkEnumJsonDeserializer.class)
	private Moetesakstype moetesakstype;

	@JsonSerialize(using = NoarkEnumJsonSerializer.class)
	@JsonDeserialize(using = NoarkEnumJsonDeserializer.class)
	private Moeteregistreringsstatus moeteregistreringsstatus;

	public Moeteregistrering(
			String tittel, String saksbehandler, AdministrativEnhet administrativEnhet,
			Moeteregistreringstype moeteregistreringstype) {

		setTittel(tittel);
		this.saksbehandler = saksbehandler;
		this.administrativEnhet = administrativEnhet;
		this.moeteregistreringstype = moeteregistreringstype;
	}

	@JsonCreator
	private Moeteregistrering(
			@JsonProperty("id") String id,
			@JsonProperty("uuid") String uuid,
			@JsonProperty("version") String version) {

		super(id, uuid, version);
	}

	public String getSaksbehandler() {

		return saksbehandler;
	}

	public void setSaksbehandler(String saksbehandler) {

		this.saksbehandler = saksbehandler;
	}

	public AdministrativEnhet getAdministrativEnhet() {

		return administrativEnhet;
	}

	public void setAdministrativEnhet(AdministrativEnhet administrativEnhet) {

		this.administrativEnhet = administrativEnhet;
	}

	public Moeteregistreringstype getMoeteregistreringstype() {

		return moeteregistreringstype;
	}

	public void setMoeteregistreringstype(Moeteregistreringstype moeteregistreringstype) {

		this.moeteregistreringstype = moeteregistreringstype;
	}

	public Moetesakstype getMoetesakstype() {

		return moetesakstype;
	}

	public void setMoetesakstype(Moetesakstype moetesakstype) {

		this.moetesakstype = moetesakstype;
	}

	public Moeteregistreringsstatus getMoeteregistreringsstatus() {

		return moeteregistreringsstatus;
	}

	public void setMoeteregistreringsstatus(
			Moeteregistreringsstatus moeteregistreringsstatus) {

		this.moeteregistreringsstatus = moeteregistreringsstatus;
	}
}
