package com.documaster.rms.noark.ws.noarkentities;

import com.documaster.rms.noark.ws.client.action.LinkAction;
import com.documaster.rms.noark.ws.client.action.UnlinkAction;
import com.documaster.rms.noark.ws.constants.Dokumentmedium;
import com.documaster.rms.noark.ws.constants.Dokumentstatus;
import com.documaster.rms.noark.ws.constants.Dokumenttype;
import com.documaster.rms.noark.ws.constants.Skjerming;
import com.documaster.rms.noark.ws.constants.TilknyttetRegistreringSom;
import com.documaster.rms.noark.ws.noarkentities.bsm.BsmGroupsMap;
import com.documaster.rms.noark.ws.serialization.NoarkEnumJsonDeserializer;
import com.documaster.rms.noark.ws.serialization.NoarkEnumJsonSerializer;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Dokument extends NoarkEntityBase<Dokument> {

	public static final String REGISTRERING_LINK = "refRegistrering";
	public static final String EKSTERN_ID_LINK = "refEksternId";
	public static final String DOKUMENTVERSJON_LINK = "refDokumentversjon";
	public static final String MERKNAD_LINK = "refMerknad";

	private String tittel;
	private String beskrivelse;
	private String forfatter;
	private Integer dokumentnummer;
	private BsmGroupsMap virksomhetsspesifikkeMetadata = new BsmGroupsMap();

	@JsonSerialize(using = NoarkEnumJsonSerializer.class)
	@JsonDeserialize(using = NoarkEnumJsonDeserializer.class)
	private Dokumentmedium dokumentmedium;

	@JsonSerialize(using = NoarkEnumJsonSerializer.class)
	@JsonDeserialize(using = NoarkEnumJsonDeserializer.class)
	private TilknyttetRegistreringSom tilknyttetRegistreringSom;

	@JsonSerialize(using = NoarkEnumJsonSerializer.class)
	@JsonDeserialize(using = NoarkEnumJsonDeserializer.class)
	private Dokumenttype dokumenttype;

	@JsonSerialize(using = NoarkEnumJsonSerializer.class)
	@JsonDeserialize(using = NoarkEnumJsonDeserializer.class)
	private Dokumentstatus dokumentstatus;

	@JsonSerialize(using = NoarkEnumJsonSerializer.class)
	@JsonDeserialize(using = NoarkEnumJsonDeserializer.class)
	private Skjerming skjerming;

	public Dokument(String tittel, TilknyttetRegistreringSom tilknyttetRegistreringSom) {

		this(null, tittel, tilknyttetRegistreringSom);
	}

	public Dokument(Dokumenttype dokumenttype, String tittel, TilknyttetRegistreringSom tilknyttetRegistreringSom) {

		this.dokumenttype = dokumenttype;
		this.tittel = tittel;
		this.tilknyttetRegistreringSom = tilknyttetRegistreringSom;
	}

	@JsonCreator
	private Dokument(
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

	public String getForfatter() {

		return forfatter;
	}

	public void setForfatter(String forfatter) {

		this.forfatter = forfatter;
	}

	public Dokumentmedium getDokumentmedium() {

		return dokumentmedium;
	}

	public void setDokumentmedium(Dokumentmedium dokumentmedium) {

		this.dokumentmedium = dokumentmedium;
	}

	public TilknyttetRegistreringSom getTilknyttetRegistreringSom() {

		return tilknyttetRegistreringSom;
	}

	public void setTilknyttetRegistreringSom(
			TilknyttetRegistreringSom tilknyttetRegistreringSom) {

		this.tilknyttetRegistreringSom = tilknyttetRegistreringSom;
	}

	public Integer getDokumentnummer() {

		return dokumentnummer;
	}

	public void setDokumentnummer(Integer dokumentnummer) {

		this.dokumentnummer = dokumentnummer;
	}

	public BsmGroupsMap getVirksomhetsspesifikkeMetadata() {

		return virksomhetsspesifikkeMetadata;
	}

	public void setVirksomhetsspesifikkeMetadata(BsmGroupsMap virksomhetsspesifikkeMetadata) {

		this.virksomhetsspesifikkeMetadata = virksomhetsspesifikkeMetadata;
	}

	public Dokumenttype getDokumenttype() {

		return dokumenttype;
	}

	public void setDokumenttype(Dokumenttype dokumenttype) {

		this.dokumenttype = dokumenttype;
	}

	public Dokumentstatus getDokumentstatus() {

		return dokumentstatus;
	}

	public void setDokumentstatus(Dokumentstatus dokumentstatus) {

		this.dokumentstatus = dokumentstatus;
	}

	public Skjerming getSkjerming() {

		return skjerming;
	}

	public void setSkjerming(Skjerming skjerming) {

		this.skjerming = skjerming;
	}

	public LinkAction<Dokument> linkMerknad(String... merknadIds) {

		return link(MERKNAD_LINK, merknadIds);
	}

	public LinkAction<Dokument> linkMerknad(Merknad... merknad) {

		return link(MERKNAD_LINK, merknad);
	}

	public LinkAction<Dokument> linkRegistrering(String registreringId) {

		return link(REGISTRERING_LINK, registreringId);
	}

	public LinkAction<Dokument> linkRegistrering(AbstraktRegistrering registrering) {

		return link(REGISTRERING_LINK, registrering);
	}

	public UnlinkAction<Dokument> unlinkRegistrering(String registreringId) {

		return unlink(REGISTRERING_LINK, registreringId);
	}

	public UnlinkAction<Dokument> unlinkRegistrering(AbstraktRegistrering registrering) {

		return unlink(REGISTRERING_LINK, registrering);
	}

	public LinkAction<Dokument> linkDokumentversjon(String... dokumentversjonIds) {

		return link(DOKUMENTVERSJON_LINK, dokumentversjonIds);
	}

	public LinkAction<Dokument> linkDokumentversjon(Dokumentversjon... dokumentversjon) {

		return link(DOKUMENTVERSJON_LINK, dokumentversjon);
	}

	public UnlinkAction<Dokument> unlinkDokumentversjon(String... dokumentversjonIds) {

		return unlink(DOKUMENTVERSJON_LINK, dokumentversjonIds);
	}

	public UnlinkAction<Dokument> unlinkDokumentversjon(Dokumentversjon... dokumentversjon) {

		return unlink(DOKUMENTVERSJON_LINK, dokumentversjon);
	}

	public LinkAction<Dokument> linkEksternId(String... eksternIdIds) {

		return link(EKSTERN_ID_LINK, eksternIdIds);
	}

	public LinkAction<Dokument> linkEksternId(EksternId... eksternId) {

		return link(EKSTERN_ID_LINK, eksternId);
	}

	@JsonIgnore
	public String getRefRegistrering() {

		return getRef(REGISTRERING_LINK);
	}
}
