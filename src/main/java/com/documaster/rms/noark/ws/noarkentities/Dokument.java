package com.documaster.rms.noark.ws.noarkentities;

import java.util.Date;
import java.util.Optional;

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
import com.documaster.rms.noark.ws.serialization.NoarkOptionalEnumJsonSerializer;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Dokument extends DisposableFinalizedEntityBase<Dokument> {

	public static final String REGISTRERING_LINK = "refRegistrering";
	public static final String EKSTERN_ID_LINK = "refEksternId";
	public static final String DOKUMENTVERSJON_LINK = "refDokumentversjon";
	public static final String MERKNAD_LINK = "refMerknad";

	private String tittel;
	private String beskrivelse;
	private boolean serializeBeskrivelse;
	private String forfatter;
	private boolean serializeForfatter;
	private Integer dokumentnummer;

	private Date kassertDato;

	private String kassertAv;

	private String kassertAvBrukerIdent;

	private BsmGroupsMap virksomhetsspesifikkeMetadata = new BsmGroupsMap();

	@JsonSerialize(using = NoarkEnumJsonSerializer.class)
	@JsonDeserialize(using = NoarkEnumJsonDeserializer.class)
	private Dokumentmedium dokumentmedium;

	@JsonSerialize(using = NoarkEnumJsonSerializer.class)
	@JsonDeserialize(using = NoarkEnumJsonDeserializer.class)
	private TilknyttetRegistreringSom tilknyttetRegistreringSom;

	@JsonSerialize(using = NoarkOptionalEnumJsonSerializer.class)
	@JsonDeserialize(using = NoarkEnumJsonDeserializer.class)
	private Dokumenttype dokumenttype;

	private boolean serializeDokumenttype;

	@JsonSerialize(using = NoarkEnumJsonSerializer.class)
	@JsonDeserialize(using = NoarkEnumJsonDeserializer.class)
	private Dokumentstatus dokumentstatus;

	@JsonSerialize(using = NoarkOptionalEnumJsonSerializer.class)
	@JsonDeserialize(using = NoarkEnumJsonDeserializer.class)
	private Skjerming skjerming;

	private boolean serializeSkjerming;

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
			@JsonProperty("version") String version,
			@JsonProperty("kassertDato") Date kassertDato,
			@JsonProperty("kassertAv") String kassertAv,
			@JsonProperty("kassertAvBrukerIdent") String kassertAvBrukerIdent) {

		super(id, uuid, version);
		this.kassertDato = kassertDato;
		this.kassertAv = kassertAv;
		this.kassertAvBrukerIdent = kassertAvBrukerIdent;
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

	public String getForfatter() {

		return forfatter;
	}

	@JsonProperty("forfatter")
	public void setForfatter(String forfatter) {

		this.forfatter = forfatter;
		serializeForfatter = true;
	}

	@JsonProperty("forfatter")
	public Optional<String> getForfatterAsOptional() {

		if (serializeForfatter) {

			return Optional.ofNullable(forfatter);
		}

		return null;
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

	public Date getKassertDato() {

		return kassertDato;
	}

	public String getKassertAv() {

		return kassertAv;
	}

	public String getKassertAvBrukerIdent() {

		return kassertAvBrukerIdent;
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

	@JsonProperty("dokumenttype")
	public void setDokumenttype(Dokumenttype dokumenttype) {

		this.dokumenttype = dokumenttype;
		serializeDokumenttype = true;
	}

	@JsonProperty("dokumenttype")
	public Optional<Dokumenttype> getDokumenttypeAsOptional() {

		if (serializeDokumenttype) {

			return Optional.ofNullable(dokumenttype);
		}

		return null;
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
