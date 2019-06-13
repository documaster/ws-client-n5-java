package com.documaster.rms.noark.ws.noarkentities;

import com.documaster.rms.noark.ws.client.action.LinkAction;
import com.documaster.rms.noark.ws.client.action.UnlinkAction;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Klassifikasjonssystem extends FinalizedEntityBase<Klassifikasjonssystem> {

	public static final String KLASSE_LINK = "refKlasse";
	public static final String ARKIVDEL_SOM_PRIMAER_LINK = "refArkivdelSomPrimaer";
	public static final String ARKIVDEL_SOM_SEKUNDAER_LINK = "refArkivdelSomSekundaer";

	private String tittel;
	private String beskrivelse;
	private String klassifikasjonstype;

	public Klassifikasjonssystem(String tittel) {

		this.tittel = tittel;
	}

	@JsonCreator
	private Klassifikasjonssystem(
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

	public void setBeskrivelse(String beskrivelse) {

		this.beskrivelse = beskrivelse;
	}

	public String getKlassifikasjonstype() {

		return klassifikasjonstype;
	}

	public void setKlassifikasjonstype(String klassifikasjonstype) {

		this.klassifikasjonstype = klassifikasjonstype;
	}

	public LinkAction<Klassifikasjonssystem> linkKlasse(String... klasseIds) {

		return link(KLASSE_LINK, klasseIds);
	}

	public LinkAction<Klassifikasjonssystem> linkKlasse(Klasse... klasse) {

		return link(KLASSE_LINK, klasse);
	}

	public UnlinkAction<Klassifikasjonssystem> unlinkKlasse(String... klasseIds) {

		return unlink(KLASSE_LINK, klasseIds);
	}

	public UnlinkAction<Klassifikasjonssystem> unlinkKlasse(Klasse... klasse) {

		return unlink(KLASSE_LINK, klasse);
	}

	public LinkAction<Klassifikasjonssystem> linkArkivdel(boolean isSecondaryKS, String... arkivdelIds) {

		return link(isSecondaryKS ? ARKIVDEL_SOM_SEKUNDAER_LINK : ARKIVDEL_SOM_PRIMAER_LINK, arkivdelIds);
	}

	public LinkAction<Klassifikasjonssystem> linkArkivdel(boolean isSecondaryKS, Arkivdel... arkivdel) {

		return link(isSecondaryKS ? ARKIVDEL_SOM_SEKUNDAER_LINK : ARKIVDEL_SOM_PRIMAER_LINK, arkivdel);
	}

	public UnlinkAction<Klassifikasjonssystem> unlinkArkivdel(boolean isSecondaryKS, String... arkivdelIds) {

		return unlink(isSecondaryKS ? ARKIVDEL_SOM_SEKUNDAER_LINK : ARKIVDEL_SOM_PRIMAER_LINK, arkivdelIds);
	}

	public UnlinkAction<Klassifikasjonssystem> unlinkArkivdel(boolean isSecondaryKS, Arkivdel... arkivdel) {

		return unlink(isSecondaryKS ? ARKIVDEL_SOM_SEKUNDAER_LINK : ARKIVDEL_SOM_PRIMAER_LINK, arkivdel);
	}
}
