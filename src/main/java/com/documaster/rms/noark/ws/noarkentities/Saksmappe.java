package com.documaster.rms.noark.ws.noarkentities;

import java.util.Date;
import java.util.Optional;

import com.documaster.rms.noark.ws.client.action.LinkAction;
import com.documaster.rms.noark.ws.client.action.UnlinkAction;
import com.documaster.rms.noark.ws.constants.AdministrativEnhet;
import com.documaster.rms.noark.ws.constants.Saksstatus;
import com.documaster.rms.noark.ws.serialization.CustomDateFormat;
import com.documaster.rms.noark.ws.serialization.NoarkEnumJsonDeserializer;
import com.documaster.rms.noark.ws.serialization.NoarkEnumJsonSerializer;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Saksmappe extends MappeBase<Saksmappe> {

	public static final String SAKSPART_LINK = "refSakspart";

	private Integer saksaar;
	private Integer sakssekvensnummer;
	private String saksansvarlig;
	private String saksansvarligBrukerIdent;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = CustomDateFormat.DATE)
	private Date saksdato;

	@JsonSerialize(using = NoarkEnumJsonSerializer.class)
	@JsonDeserialize(using = NoarkEnumJsonDeserializer.class)
	private AdministrativEnhet administrativEnhet;

	@JsonSerialize(using = NoarkEnumJsonSerializer.class)
	@JsonDeserialize(using = NoarkEnumJsonDeserializer.class)
	private Saksstatus saksstatus;

	private String prefiks;
	private boolean serializePrefiks;

	public Saksmappe(String tittel, AdministrativEnhet administrativEnhet) {

		setTittel(tittel);
		this.administrativEnhet = administrativEnhet;
	}

	@JsonCreator
	private Saksmappe(
			@JsonProperty("id") String id,
			@JsonProperty("uuid") String uuid,
			@JsonProperty("version") String version) {

		super(id, uuid, version);
	}

	public Integer getSaksaar() {

		return saksaar;
	}

	public void setSaksaar(Integer saksaar) {

		this.saksaar = saksaar;
	}

	public Integer getSakssekvensnummer() {

		return sakssekvensnummer;
	}

	public void setSakssekvensnummer(Integer sakssekvensnummer) {

		this.sakssekvensnummer = sakssekvensnummer;
	}

	public Date getSaksdato() {

		return saksdato;
	}

	public void setSaksdato(Date saksdato) {

		this.saksdato = saksdato;
	}

	public AdministrativEnhet getAdministrativEnhet() {

		return administrativEnhet;
	}

	public void setAdministrativEnhet(AdministrativEnhet administrativEnhet) {

		this.administrativEnhet = administrativEnhet;
	}

	public String getSaksansvarlig() {

		return saksansvarlig;
	}

	public void setSaksansvarlig(String saksansvarlig) {

		this.saksansvarlig = saksansvarlig;
	}

	public String getSaksansvarligBrukerIdent() {

		return saksansvarligBrukerIdent;
	}

	public void setSaksansvarligBrukerIdent(String saksansvarligBrukerIdent) {

		this.saksansvarligBrukerIdent = saksansvarligBrukerIdent;
	}

	public Saksstatus getSaksstatus() {

		return saksstatus;
	}

	public void setSaksstatus(Saksstatus saksstatus) {

		this.saksstatus = saksstatus;
	}

	public String getPrefiks() {

		return prefiks;
	}

	@JsonProperty("prefiks")
	public void setPrefiks(String prefiks) {

		this.prefiks = prefiks;
		serializePrefiks = true;
	}

	@JsonProperty("prefiks")
	public Optional<String> getPrefiksAsOptional() {

		if (serializePrefiks) {

			return Optional.ofNullable(prefiks);
		}

		return null;
	}

	public LinkAction<Saksmappe> linkRegistrering(String... registreringIds) {

		return link(REGISTRERING_LINK, registreringIds);
	}

	public LinkAction<Saksmappe> linkRegistrering(AbstraktRegistrering... registrering) {

		return link(REGISTRERING_LINK, registrering);
	}

	public UnlinkAction<Saksmappe> unlinkRegistrering(String... registreringIds) {

		return unlink(REGISTRERING_LINK, registreringIds);
	}

	public UnlinkAction<Saksmappe> unlinkRegistrering(AbstraktRegistrering... registrering) {

		return unlink(REGISTRERING_LINK, registrering);
	}

	public LinkAction<Saksmappe> linkSakspart(String... sakspartIds) {

		return link(SAKSPART_LINK, sakspartIds);
	}

	public LinkAction<Saksmappe> linkSakspart(Sakspart... sakspart) {

		return link(SAKSPART_LINK, sakspart);
	}
}
