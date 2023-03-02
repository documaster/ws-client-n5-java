package com.documaster.rms.noark.ws.noarkentities;

import java.util.Date;
import java.util.Optional;

import com.documaster.rms.noark.ws.client.action.LinkAction;
import com.documaster.rms.noark.ws.client.action.UnlinkAction;
import com.documaster.rms.noark.ws.constants.Arkivdelstatus;
import com.documaster.rms.noark.ws.constants.Dokumentmedium;
import com.documaster.rms.noark.ws.constants.Skjerming;
import com.documaster.rms.noark.ws.serialization.CustomDateFormat;
import com.documaster.rms.noark.ws.serialization.NoarkEnumJsonDeserializer;
import com.documaster.rms.noark.ws.serialization.NoarkEnumJsonSerializer;
import com.documaster.rms.noark.ws.serialization.NoarkOptionalEnumJsonSerializer;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Arkivdel extends FinalizedEntityBase<Arkivdel> {

	public static final String ARKIV_LINK = "refArkiv";
	public static final String MAPPE_LINK = "refMappe";
	public static final String REGISTRERING_LINK = "refRegistrering";
	public static final String PRIMAER_KLASSIFIKASJONSSYSTEM_LINK = "refPrimaerKlassifikasjonssystem";
	public static final String SEKUNDAER_KLASSIFIKASJONSSYSTEM_LINK = "refSekundaerKlassifikasjonssystem";

	private String tittel;
	private String beskrivelse;
	private boolean serializeBeskrivelse;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = CustomDateFormat.DATE)
	private Date arkivperiodeStartDato;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = CustomDateFormat.DATE)
	private Date arkivperiodeSluttDato;
	private boolean serializeArkivperiodeSluttDato;

	@JsonSerialize(using = NoarkEnumJsonSerializer.class)
	@JsonDeserialize(using = NoarkEnumJsonDeserializer.class)
	private Arkivdelstatus arkivdelstatus;

	@JsonSerialize(using = NoarkEnumJsonSerializer.class)
	@JsonDeserialize(using = NoarkEnumJsonDeserializer.class)
	private Dokumentmedium dokumentmedium;

	@JsonSerialize(using = NoarkOptionalEnumJsonSerializer.class)
	@JsonDeserialize(using = NoarkEnumJsonDeserializer.class)
	private Skjerming skjerming;

	private boolean serializeSkjerming;

	public Arkivdel(String tittel) {

		this.tittel = tittel;
	}

	@JsonCreator
	private Arkivdel(
			@JsonProperty("id") String id,
			@JsonProperty("uuid") String uuid,
			@JsonProperty("version") String version) {

		super(id, uuid, version);
	}

	public String getTittel() {

		return tittel;
	}

	public void setTittel(String tittel) {

		this.tittel = tittel;
	}

	public String getBeskrivelse() {

		return beskrivelse;
	}

	@JsonProperty("beskrivelse")
	public void setBeskrivelse(String beskrivelse) {

		this.beskrivelse = beskrivelse;
		serializeBeskrivelse = true;
	}

	@JsonProperty("beskrivelse")
	public Optional<String> getBeskrivelseAsOptional() {

		if (serializeBeskrivelse) {

			return Optional.ofNullable(beskrivelse);
		}

		return null;
	}

	public Arkivdelstatus getArkivdelstatus() {

		return arkivdelstatus;
	}

	public void setArkivdelstatus(Arkivdelstatus arkivdelstatus) {

		this.arkivdelstatus = arkivdelstatus;
	}

	public Dokumentmedium getDokumentmedium() {

		return dokumentmedium;
	}

	public void setDokumentmedium(Dokumentmedium dokumentmedium) {

		this.dokumentmedium = dokumentmedium;
	}

	public Date getArkivperiodeStartDato() {

		return arkivperiodeStartDato;
	}

	public void setArkivperiodeStartDato(Date arkivperiodeStartDato) {

		this.arkivperiodeStartDato = arkivperiodeStartDato;
	}

	public Date getArkivperiodeSluttDato() {

		return arkivperiodeSluttDato;
	}

	@JsonProperty("arkivperiodeSluttDato")
	public void setArkivperiodeSluttDato(Date arkivperiodeSluttDato) {

		this.arkivperiodeSluttDato = arkivperiodeSluttDato;
		serializeArkivperiodeSluttDato = true;
	}

	@JsonProperty("arkivperiodeSluttDato")
	public Optional<Date> getArkivperiodeSluttDatoAsOptional() {

		if (serializeArkivperiodeSluttDato) {

			return Optional.ofNullable(arkivperiodeSluttDato);
		}

		return null;
	}

	public Skjerming getSkjerming() {

		return skjerming;
	}

	@JsonProperty("skjerming")
	public void setSkjerming(Skjerming skjerming) {

		this.skjerming = skjerming;
		serializeSkjerming = true;
	}

	@JsonProperty("skjerming")
	public Optional<Skjerming> getSkjermingAsOptional() {

		if (serializeSkjerming) {

			return Optional.ofNullable(skjerming);
		}

		return null;
	}

	public LinkAction<Arkivdel> linkArkiv(String... arkivIds) {

		return link(ARKIV_LINK, arkivIds);
	}

	public LinkAction<Arkivdel> linkArkiv(Arkiv... arkiv) {

		return link(ARKIV_LINK, arkiv);
	}

	public UnlinkAction<Arkivdel> unlinkArkiv(String... arkivIds) {

		return unlink(ARKIV_LINK, arkivIds);
	}

	public UnlinkAction<Arkivdel> unlinkArkiv(Arkiv... arkiv) {

		return unlink(ARKIV_LINK, arkiv);
	}

	public LinkAction<Arkivdel> linkMappe(String... mappeIds) {

		return link(MAPPE_LINK, mappeIds);
	}

	public LinkAction<Arkivdel> linkMappe(AbstraktMappe... mappe) {

		return link(MAPPE_LINK, mappe);
	}

	public UnlinkAction<Arkivdel> unlinkMappe(String... mappeIds) {

		return unlink(MAPPE_LINK, mappeIds);
	}

	public UnlinkAction<Arkivdel> unlinkMappe(AbstraktMappe... mappe) {

		return unlink(MAPPE_LINK, mappe);
	}

	public LinkAction<Arkivdel> linkPrimaerKlassifikasjonssystem(String... ksIds) {

		return link(PRIMAER_KLASSIFIKASJONSSYSTEM_LINK, ksIds);
	}

	public LinkAction<Arkivdel> linkPrimaerKlassifikasjonssystem(Klassifikasjonssystem... ks) {

		return link(PRIMAER_KLASSIFIKASJONSSYSTEM_LINK, ks);
	}

	public UnlinkAction<Arkivdel> unlinkPrimaerKlassifikasjonssystem(String... ksIds) {

		return unlink(PRIMAER_KLASSIFIKASJONSSYSTEM_LINK, ksIds);
	}

	public UnlinkAction<Arkivdel> unlinkPrimaerKlassifikasjonssystem(Klassifikasjonssystem... ks) {

		return unlink(PRIMAER_KLASSIFIKASJONSSYSTEM_LINK, ks);
	}

	public LinkAction<Arkivdel> linkSekundaerKlassifikasjonssystem(String... ksIds) {

		return link(SEKUNDAER_KLASSIFIKASJONSSYSTEM_LINK, ksIds);
	}

	public LinkAction<Arkivdel> linkSekundaerKlassifikasjonssystem(Klassifikasjonssystem... ks) {

		return link(SEKUNDAER_KLASSIFIKASJONSSYSTEM_LINK, ks);
	}

	public UnlinkAction<Arkivdel> unlinkSekundaerKlassifikasjonssystem(String... ksIds) {

		return unlink(SEKUNDAER_KLASSIFIKASJONSSYSTEM_LINK, ksIds);
	}

	public UnlinkAction<Arkivdel> unlinkSekundaerKlassifikasjonssystem(Klassifikasjonssystem... ks) {

		return unlink(SEKUNDAER_KLASSIFIKASJONSSYSTEM_LINK, ks);
	}

	public LinkAction<Arkivdel> linkRegistrering(String... registreringIds) {

		return link(REGISTRERING_LINK, registreringIds);
	}

	public LinkAction<Arkivdel> linkRegistrering(AbstraktRegistrering... registrering) {

		return link(REGISTRERING_LINK, registrering);
	}

	public UnlinkAction<Arkivdel> unlinkRegistrering(String... registreringIds) {

		return unlink(REGISTRERING_LINK, registreringIds);
	}

	public UnlinkAction<Arkivdel> unlinkRegistrering(AbstraktRegistrering... registrering) {

		return unlink(REGISTRERING_LINK, registrering);
	}

	@JsonIgnore
	public String getRefArkiv() {

		return getRef(ARKIV_LINK);
	}

	@JsonIgnore
	public String getRefPrimaerKlassifikasjonssystem() {

		return getRef(PRIMAER_KLASSIFIKASJONSSYSTEM_LINK);
	}
}
