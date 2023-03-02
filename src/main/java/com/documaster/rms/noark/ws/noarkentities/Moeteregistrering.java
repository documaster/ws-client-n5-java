package com.documaster.rms.noark.ws.noarkentities;

import java.util.Optional;

import com.documaster.rms.noark.ws.constants.AdministrativEnhet;
import com.documaster.rms.noark.ws.constants.Moeteregistreringsstatus;
import com.documaster.rms.noark.ws.constants.Moeteregistreringstype;
import com.documaster.rms.noark.ws.constants.Moetesakstype;
import com.documaster.rms.noark.ws.serialization.NoarkEnumJsonDeserializer;
import com.documaster.rms.noark.ws.serialization.NoarkEnumJsonSerializer;
import com.documaster.rms.noark.ws.serialization.NoarkOptionalEnumJsonSerializer;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Moeteregistrering extends RegistreringBase<Moeteregistrering> {

	private String saksbehandler;

	private String saksnummer;
	private boolean serializeSaksnummer;

	@JsonSerialize(using = NoarkEnumJsonSerializer.class)
	@JsonDeserialize(using = NoarkEnumJsonDeserializer.class)
	private AdministrativEnhet administrativEnhet;

	@JsonSerialize(using = NoarkEnumJsonSerializer.class)
	@JsonDeserialize(using = NoarkEnumJsonDeserializer.class)
	private Moeteregistreringstype moeteregistreringstype;

	@JsonSerialize(using = NoarkOptionalEnumJsonSerializer.class)
	@JsonDeserialize(using = NoarkEnumJsonDeserializer.class)
	private Moetesakstype moetesakstype;

	private boolean serializeMoetesakstype;

	@JsonSerialize(using = NoarkOptionalEnumJsonSerializer.class)
	@JsonDeserialize(using = NoarkEnumJsonDeserializer.class)
	private Moeteregistreringsstatus moeteregistreringsstatus;

	private boolean serializeMoeteregistreringsstatus;

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

	public String getSaksnummer() {

		return saksnummer;
	}

	@JsonProperty("saksnummer")
	public void setSaksnummer(String saksnummer) {

		this.saksnummer = saksnummer;
		serializeSaksnummer = true;
	}

	@JsonProperty("saksnummer")
	public Optional<String> getSaksnummerAsOptional() {

		if (serializeSaksnummer) {

			return Optional.ofNullable(saksnummer);
		}

		return null;
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

	@JsonProperty("moetesakstype")
	public void setMoetesakstype(Moetesakstype moetesakstype) {

		this.moetesakstype = moetesakstype;
		serializeMoetesakstype = true;
	}

	@JsonProperty("moetesakstype")
	public Optional<Moetesakstype> getMoetesakstypeAsOptional() {

		if (serializeMoetesakstype) {

			return Optional.ofNullable(moetesakstype);
		}

		return null;
	}

	public Moeteregistreringsstatus getMoeteregistreringsstatus() {

		return moeteregistreringsstatus;
	}

	@JsonProperty("moeteregistreringsstatus")
	public void setMoeteregistreringsstatus(Moeteregistreringsstatus moeteregistreringsstatus) {

		this.moeteregistreringsstatus = moeteregistreringsstatus;
		serializeMoeteregistreringsstatus = true;
	}

	@JsonProperty("moeteregistreringsstatus")
	public Optional<Moeteregistreringsstatus> getMoeteregistreringsstatusAsOptional() {

		if (serializeMoeteregistreringsstatus) {

			return Optional.ofNullable(moeteregistreringsstatus);
		}

		return null;
	}
}
