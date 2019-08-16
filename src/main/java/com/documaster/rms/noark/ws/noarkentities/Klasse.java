package com.documaster.rms.noark.ws.noarkentities;

import com.documaster.rms.noark.ws.client.action.LinkAction;
import com.documaster.rms.noark.ws.client.action.UnlinkAction;
import com.documaster.rms.noark.ws.constants.Skjerming;
import com.documaster.rms.noark.ws.serialization.NoarkEnumJsonDeserializer;
import com.documaster.rms.noark.ws.serialization.NoarkEnumJsonSerializer;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Klasse extends FinalizedEntityBase<Klasse> {

	public static final String KLASSIFIKASJONSSYSTEM_LINK = "refKlassifikasjonssystem";
	public static final String FORELDER_KLASSE_LINK = "refForelderKlasse";
	public static final String MAPPE_LINK_SOM_PRIMAER = "refMappeSomPrimaer";
	public static final String MAPPE_LINK_SOM_SEKUNDAER = "refMappeSomSekundaer";
	public static final String REGISTRERING_SOM_PRIMAER_LINK = "refRegistreringSomPrimaer";
	public static final String REGISTRERING_SOM_SEKUNDAER_LINK = "refRegistreringSomSekundaer";
	public static final String BARN_KLASSE_LINK = "refBarnKlasse";

	private String klasseIdent;
	private String tittel;
	private String beskrivelse;

	@JsonSerialize(using = NoarkEnumJsonSerializer.class)
	@JsonDeserialize(using = NoarkEnumJsonDeserializer.class)
	private Skjerming skjerming;

	public Klasse(String klasseIdent, String tittel) {

		this.klasseIdent = klasseIdent;
		this.tittel = tittel;
	}

	@JsonCreator
	private Klasse(
			@JsonProperty("id") String id,
			@JsonProperty("uuid") String uuid,
			@JsonProperty("version") String version) {

		super(id, uuid, version);
	}

	public String getKlasseIdent() {

		return klasseIdent;
	}

	public void setKlasseIdent(String klasseIdent) {

		this.klasseIdent = klasseIdent;
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

	public void setBeskrivelse(String beskrivelse) {

		this.beskrivelse = beskrivelse;
	}

	public Skjerming getSkjerming() {

		return skjerming;
	}

	public void setSkjerming(Skjerming skjerming) {

		this.skjerming = skjerming;
	}

	public LinkAction<Klasse> linkKlassifikasjonssystem(String ksId) {

		return link(KLASSIFIKASJONSSYSTEM_LINK, ksId);
	}

	public LinkAction<Klasse> linkKlassifikasjonssystem(Klassifikasjonssystem ks) {

		return link(KLASSIFIKASJONSSYSTEM_LINK, ks);
	}

	public UnlinkAction<Klasse> unlinkKlassifikasjonssystem(String ksId) {

		return unlink(KLASSIFIKASJONSSYSTEM_LINK, ksId);
	}

	public UnlinkAction<Klasse> unlinkKlassifikasjonssystem(Klassifikasjonssystem ks) {

		return unlink(KLASSIFIKASJONSSYSTEM_LINK, ks);
	}

	public LinkAction<Klasse> linkForelderKlasse(String forelderKlasseId) {

		return link(FORELDER_KLASSE_LINK, forelderKlasseId);
	}

	public LinkAction<Klasse> linkForelderKlasse(Klasse forelderKlasse) {

		return link(FORELDER_KLASSE_LINK, forelderKlasse);
	}

	public UnlinkAction<Klasse> unlinkForelderKlasse(String forelderKlasseId) {

		return unlink(FORELDER_KLASSE_LINK, forelderKlasseId);
	}

	public UnlinkAction<Klasse> unlinkForelderKlasse(Klasse forelderKlasse) {

		return unlink(FORELDER_KLASSE_LINK, forelderKlasse);
	}

	public LinkAction<Klasse> linkBarnKlasse(String... barnKlasseIds) {

		return link(BARN_KLASSE_LINK, barnKlasseIds);
	}

	public LinkAction<Klasse> linkBarnKlasse(Klasse... barnKlasse) {

		return link(BARN_KLASSE_LINK, barnKlasse);
	}

	public UnlinkAction<Klasse> unlinkBarnKlasse(String... barnKlasseIds) {

		return unlink(BARN_KLASSE_LINK, barnKlasseIds);
	}

	public UnlinkAction<Klasse> unlinkBarnKlasse(Klasse... barnKlasse) {

		return unlink(BARN_KLASSE_LINK, barnKlasse);
	}

	public LinkAction<Klasse> linkMappe(boolean isSecondaryClass, String... mappeIds) {

		return link(isSecondaryClass ? MAPPE_LINK_SOM_SEKUNDAER : MAPPE_LINK_SOM_PRIMAER, mappeIds);
	}

	public LinkAction<Klasse> linkMappe(boolean isSecondaryClass, AbstraktMappe... mappe) {

		return link(isSecondaryClass ? MAPPE_LINK_SOM_SEKUNDAER : MAPPE_LINK_SOM_PRIMAER, mappe);
	}

	public UnlinkAction<Klasse> unlinkMappe(boolean isSecondaryClass, String... mappeIds) {

		return unlink(isSecondaryClass ? MAPPE_LINK_SOM_SEKUNDAER : MAPPE_LINK_SOM_PRIMAER, mappeIds);
	}

	public UnlinkAction<Klasse> unlinkMappe(boolean isSecondaryClass, AbstraktMappe... mappe) {

		return unlink(isSecondaryClass ? MAPPE_LINK_SOM_SEKUNDAER : MAPPE_LINK_SOM_PRIMAER, mappe);
	}

	public LinkAction<Klasse> linkRegistrering(boolean isSecondaryClass, String... registreringIds) {

		return link(
				isSecondaryClass ? REGISTRERING_SOM_SEKUNDAER_LINK : REGISTRERING_SOM_PRIMAER_LINK, registreringIds);
	}

	public LinkAction<Klasse> linkRegistrering(boolean isSecondaryClass, AbstraktRegistrering... registrering) {

		return link(isSecondaryClass ? REGISTRERING_SOM_SEKUNDAER_LINK : REGISTRERING_SOM_PRIMAER_LINK, registrering);
	}

	public UnlinkAction<Klasse> unlinkRegistrering(boolean isSecondaryClass, String... registreringIds) {

		return unlink(
				isSecondaryClass ? REGISTRERING_SOM_SEKUNDAER_LINK : REGISTRERING_SOM_PRIMAER_LINK, registreringIds);
	}

	public UnlinkAction<Klasse> unlinkRegistrering(boolean isSecondaryClass, AbstraktRegistrering... registrering) {

		return unlink(isSecondaryClass ? REGISTRERING_SOM_SEKUNDAER_LINK : REGISTRERING_SOM_PRIMAER_LINK, registrering);
	}

	@JsonIgnore
	public String getRefKlassifikasjonssystem() {

		return getRef(KLASSIFIKASJONSSYSTEM_LINK);
	}

	@JsonIgnore
	public String getRefForelderKlasse() {

		return getRef(FORELDER_KLASSE_LINK);
	}
}
