package com.documaster.rms.noark.ws.noarkentities;

import java.util.Date;
import java.util.Optional;

import com.documaster.rms.noark.ws.client.action.LinkAction;
import com.documaster.rms.noark.ws.client.action.UnlinkAction;
import com.documaster.rms.noark.ws.constants.Dokumentmedium;
import com.documaster.rms.noark.ws.constants.EInnsynState;
import com.documaster.rms.noark.ws.constants.PublishingState;
import com.documaster.rms.noark.ws.constants.Skjerming;
import com.documaster.rms.noark.ws.noarkentities.bsm.BsmGroupsMap;
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

public abstract class RegistreringBase<TEntity extends RegistreringBase<TEntity>>
		extends DisposableFinalizedEntityBase<TEntity>
		implements AbstraktRegistrering {

	public static final String MAPPE_LINK = "refMappe";
	public static final String EKSTERN_ID_LINK = "refEksternId";
	public static final String ARKIVDEL_LINK = "refArkivdel";
	public static final String PRIMAER_KLASSE_LINK = "refPrimaerKlasse";
	public static final String SEKUNDAER_KLASSE_LINK = "refSekundaerKlasse";
	public static final String KORRESPONDANSEPART_LINK = "refKorrespondansepart";
	public static final String DOKUMENT_LINK = "refDokument";
	public static final String NOEKKELORD_LINK = "refNoekkelord";
	public static final String MERKNAD_LINK = "refMerknad";
	public static final String NASJONAL_IDENTIFIKATOR_LINK = "refNasjonalIdentifikator";
	public static final String POSISJON_LINK = "refPosisjon";
	public static final String PERSON_IDENTIFIKATOR_LINK = "refPersonIdentifikator";
	public static final String KRYSSREFERANSE_TIL_MAPPE_LINK = "refKryssreferanseTilMappe";
	public static final String KRYSSREFERANSE_FRA_MAPPE_LINK = "refKryssreferanseFraMappe";
	public static final String KRYSSREFERANSE_TIL_REGISTRERING_LINK = "refKryssreferanseTilRegistrering";
	public static final String KRYSSREFERANSE_FRA_REGISTRERING_LINK = "refKryssreferanseFraRegistrering";

	private String registreringsIdent;
	private String tittel;
	private String offentligTittel;
	private boolean serializeOffentligTittel;
	private String beskrivelse;
	private boolean serializeBeskrivelse;
	private String forfatter;
	private boolean serializeForfatter;
	private String journalansvarlig;
	private boolean serializeJournalansvarlig;
	private String journalansvarligBrukerIdent;
	private boolean serializeJournalansvarligBrukerIdent;
	private Boolean publisereSkjermedeOffentligeDokumenter;
	private boolean serializePublisereSkjermedeOffentligeDokumenter;
	private BsmGroupsMap virksomhetsspesifikkeMetadata = new BsmGroupsMap();

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = CustomDateFormat.DATE)
	private Date registreringsDato;
	private boolean serializeRegistreringsDato;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = CustomDateFormat.DATE)
	private Date dokumentetsDato;
	private boolean serializeDokumentetsDato;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = CustomDateFormat.DATE)
	private Date forfallsdato;
	private boolean serializeForfallsdato;
	private Date mottattDato;
	private boolean serializeMottattDato;
	private Date sendtDato;
	private boolean serializeSendtDato;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = CustomDateFormat.DATE)
	private Date offentlighetsvurdertDato;
	private boolean serializeOffentlighetsvurdertDato;

	private EInnsynState eInnsynStatus;

	private PublishingState publiseringsstatus;

	@JsonSerialize(using = NoarkEnumJsonSerializer.class)
	@JsonDeserialize(using = NoarkEnumJsonDeserializer.class)
	private Dokumentmedium dokumentmedium;

	@JsonSerialize(using = NoarkOptionalEnumJsonSerializer.class)
	@JsonDeserialize(using = NoarkEnumJsonDeserializer.class)
	private Skjerming skjerming;

	private boolean serializeSkjerming;

	protected RegistreringBase() {

	}

	@JsonCreator
	protected RegistreringBase(
			@JsonProperty("id") String id,
			@JsonProperty("uuid") String uuid,
			@JsonProperty("version") String version) {

		super(id, uuid, version);
	}

	public String getRegistreringsIdent() {

		return registreringsIdent;
	}

	public void setRegistreringsIdent(String registreringsIdent) {

		this.registreringsIdent = registreringsIdent;
	}

	public String getTittel() {

		return tittel;
	}

	public void setTittel(String tittel) {

		this.tittel = tittel;
	}

	public String getOffentligTittel() {

		return offentligTittel;
	}

	@JsonProperty("offentligTittel")
	public void setOffentligTittel(String offentligTittel) {

		this.offentligTittel = offentligTittel;
		serializeOffentligTittel = true;
	}

	@JsonProperty("offentligTittel")
	public Optional<String> getOffentligTittelAsOptional() {

		if (serializeOffentligTittel) {

			return Optional.ofNullable(offentligTittel);
		}

		return null;
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

	public String getJournalansvarlig() {

		return journalansvarlig;
	}

	@JsonProperty("journalansvarlig")
	public void setJournalansvarlig(String journalansvarlig) {

		this.journalansvarlig = journalansvarlig;
		serializeJournalansvarlig = true;
	}

	@JsonProperty("journalansvarlig")
	public Optional<String> getJournalansvarligAsOptional() {

		if (serializeJournalansvarlig) {

			return Optional.ofNullable(journalansvarlig);
		}

		return null;
	}

	public String getJournalansvarligBrukerIdent() {

		return journalansvarligBrukerIdent;
	}

	@JsonProperty("journalansvarligBrukerIdent")
	public void setJournalansvarligBrukerIdent(String journalansvarligBrukerIdent) {

		this.journalansvarligBrukerIdent = journalansvarligBrukerIdent;
		serializeJournalansvarligBrukerIdent = true;
	}

	@JsonProperty("journalansvarligBrukerIdent")
	public Optional<String> getJournalansvarligBrukerIdentAsOptional() {

		if (serializeJournalansvarligBrukerIdent) {

			return Optional.ofNullable(journalansvarligBrukerIdent);
		}

		return null;
	}

	public Boolean getPublisereSkjermedeOffentligeDokumenter() {

		return publisereSkjermedeOffentligeDokumenter;
	}

	@JsonProperty("publisereSkjermedeOffentligeDokumenter")
	public void setPublisereSkjermedeOffentligeDokumenter(Boolean publisereSkjermedeOffentligeDokumenter) {

		this.publisereSkjermedeOffentligeDokumenter = publisereSkjermedeOffentligeDokumenter;
		serializePublisereSkjermedeOffentligeDokumenter = true;
	}

	@JsonProperty("publisereSkjermedeOffentligeDokumenter")
	public Optional<Boolean> getPublisereSkjermedeOffentligeDokumenterAsOptional() {

		if (serializePublisereSkjermedeOffentligeDokumenter) {

			return Optional.ofNullable(publisereSkjermedeOffentligeDokumenter);
		}

		return null;
	}

	public BsmGroupsMap getVirksomhetsspesifikkeMetadata() {

		return virksomhetsspesifikkeMetadata;
	}

	public void setVirksomhetsspesifikkeMetadata(
			BsmGroupsMap virksomhetsspesifikkeMetadata) {

		this.virksomhetsspesifikkeMetadata = virksomhetsspesifikkeMetadata;
	}

	public Date getRegistreringsDato() {

		return registreringsDato;
	}

	@JsonProperty("registreringsDato")
	public void setRegistreringsDato(Date registreringsDato) {

		this.registreringsDato = registreringsDato;
		serializeRegistreringsDato = true;
	}

	@JsonProperty("registreringsDato")
	public Optional<Date> getRegistreringsDatoAsOptional() {

		if (serializeRegistreringsDato) {

			return Optional.ofNullable(registreringsDato);
		}

		return null;
	}

	public Date getDokumentetsDato() {

		return dokumentetsDato;
	}

	@JsonProperty("dokumentetsDato")
	public void setDokumentetsDato(Date dokumentetsDato) {

		this.dokumentetsDato = dokumentetsDato;
		serializeDokumentetsDato = true;
	}

	@JsonProperty("dokumentetsDato")
	public Optional<Date> getDokumentetsDatoAsOptional() {

		if (serializeDokumentetsDato) {

			return Optional.ofNullable(dokumentetsDato);
		}

		return null;
	}

	public Date getForfallsdato() {

		return forfallsdato;
	}

	@JsonProperty("forfallsdato")
	public void setForfallsdato(Date forfallsdato) {

		this.forfallsdato = forfallsdato;
		serializeForfallsdato = true;
	}

	@JsonProperty("forfallsdato")
	public Optional<Date> getForfallsdatoAsOptional() {

		if (serializeForfallsdato) {

			return Optional.ofNullable(forfallsdato);
		}

		return null;
	}

	public Date getMottattDato() {

		return mottattDato;
	}

	@JsonProperty("mottattDato")
	public void setMottattDato(Date mottattDato) {

		this.mottattDato = mottattDato;
		serializeMottattDato = true;
	}

	@JsonProperty("mottattDato")
	public Optional<Date> getMottattDatoAsOptional() {

		if (serializeMottattDato) {

			return Optional.ofNullable(mottattDato);
		}

		return null;
	}

	public Date getSendtDato() {

		return sendtDato;
	}

	@JsonProperty("sendtDato")
	public void setSendtDato(Date sendtDato) {

		this.sendtDato = sendtDato;
		serializeSendtDato = true;
	}

	@JsonProperty("sendtDato")
	public Optional<Date> getSendtDatoAsOptional() {

		if (serializeSendtDato) {

			return Optional.ofNullable(sendtDato);
		}

		return null;
	}

	public Date getOffentlighetsvurdertDato() {

		return offentlighetsvurdertDato;
	}

	@JsonProperty("offentlighetsvurdertDato")
	public void setOffentlighetsvurdertDato(Date offentlighetsvurdertDato) {

		this.offentlighetsvurdertDato = offentlighetsvurdertDato;
		serializeOffentlighetsvurdertDato = true;
	}

	@JsonProperty("offentlighetsvurdertDato")
	public Optional<Date> getOffentlighetsvurdertDatoAsOptional() {

		if (serializeOffentlighetsvurdertDato) {

			return Optional.ofNullable(offentlighetsvurdertDato);
		}

		return null;
	}

	public PublishingState getPubliseringsstatus() {

		return publiseringsstatus;
	}

	public void setPubliseringsstatus(PublishingState publiseringsstatus) {

		this.publiseringsstatus = publiseringsstatus;
	}

	public EInnsynState geteInnsynStatus() {

		return eInnsynStatus;
	}

	public void seteInnsynStatus(EInnsynState eInnsynStatus) {

		this.eInnsynStatus = eInnsynStatus;
	}

	public Dokumentmedium getDokumentmedium() {

		return dokumentmedium;
	}

	public void setDokumentmedium(Dokumentmedium dokumentmedium) {

		this.dokumentmedium = dokumentmedium;
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

	public LinkAction<TEntity> linkDokument(String... dokumentIds) {

		return link(DOKUMENT_LINK, dokumentIds);
	}

	public LinkAction<TEntity> linkDokument(Dokument... dokument) {

		return link(DOKUMENT_LINK, dokument);
	}

	public UnlinkAction<TEntity> unlinkDokument(String... dokumentIds) {

		return unlink(DOKUMENT_LINK, dokumentIds);
	}

	public UnlinkAction<TEntity> unlinkDokument(Dokument... dokument) {

		return unlink(DOKUMENT_LINK, dokument);
	}

	public LinkAction<TEntity> linkArkivdel(String arkivdelId) {

		return link(ARKIVDEL_LINK, arkivdelId);
	}

	public LinkAction<TEntity> linkArkivdel(Arkivdel arkivdel) {

		return link(ARKIVDEL_LINK, arkivdel);
	}

	public UnlinkAction<TEntity> unlinkArkivdel(String arkivdelId) {

		return unlink(ARKIVDEL_LINK, arkivdelId);
	}

	public UnlinkAction<TEntity> unlinkArkivdel(Arkivdel arkivdel) {

		return unlink(ARKIVDEL_LINK, arkivdel);
	}

	public LinkAction<TEntity> linkPrimaerKlasse(String klasseId) {

		return link(PRIMAER_KLASSE_LINK, klasseId);
	}

	public LinkAction<TEntity> linkPrimaerKlasse(Klasse klasse) {

		return link(PRIMAER_KLASSE_LINK, klasse);
	}

	public UnlinkAction<TEntity> unlinkPrimaerKlasse(String klasseId) {

		return unlink(PRIMAER_KLASSE_LINK, klasseId);
	}

	public UnlinkAction<TEntity> unlinkPrimaerKlasse(Klasse klasse) {

		return unlink(PRIMAER_KLASSE_LINK, klasse);
	}

	public LinkAction<TEntity> linkSekundaerKlasse(String... klasseIds) {

		return link(SEKUNDAER_KLASSE_LINK, klasseIds);
	}

	public LinkAction<TEntity> linkSekundaerKlasse(Klasse... klasse) {

		return link(SEKUNDAER_KLASSE_LINK, klasse);
	}

	public UnlinkAction<TEntity> unlinkSekundaerKlasse(String... klasseIds) {

		return unlink(SEKUNDAER_KLASSE_LINK, klasseIds);
	}

	public UnlinkAction<TEntity> unlinkSekundaerKlasse(Klasse... klasse) {

		return unlink(SEKUNDAER_KLASSE_LINK, klasse);
	}

	public LinkAction<TEntity> linkEksternId(String... eksternIdIds) {

		return link(EKSTERN_ID_LINK, eksternIdIds);
	}

	public LinkAction<TEntity> linkEksternId(EksternId... eksternId) {

		return link(EKSTERN_ID_LINK, eksternId);
	}

	public LinkAction<TEntity> linkKorrespondansepart(String... korrespondansepartIds) {

		return link(KORRESPONDANSEPART_LINK, korrespondansepartIds);
	}

	public LinkAction<TEntity> linkKorrespondansepart(Korrespondansepart... korrespondansepart) {

		return link(KORRESPONDANSEPART_LINK, korrespondansepart);
	}

	public LinkAction<TEntity> linkNoekkelord(String... noekkelordIds) {

		return link(NOEKKELORD_LINK, noekkelordIds);
	}

	public LinkAction<TEntity> linkNoekkelord(Noekkelord... noekkelord) {

		return link(NOEKKELORD_LINK, noekkelord);
	}

	public LinkAction<TEntity> linkMerknad(String... merknadIds) {

		return link(MERKNAD_LINK, merknadIds);
	}

	public LinkAction<TEntity> linkMerknad(Merknad... merknad) {

		return link(MERKNAD_LINK, merknad);
	}

	public LinkAction<TEntity> linkNasjonalIdentifikator(String... nasjonalIdentifikatorIds) {

		return link(NASJONAL_IDENTIFIKATOR_LINK, nasjonalIdentifikatorIds);
	}

	public LinkAction<TEntity> linkNasjonalIdentifikator(NasjonalIdentifikator<?>... nasjonalIdentifikator) {

		return link(NASJONAL_IDENTIFIKATOR_LINK, nasjonalIdentifikator);
	}

	public LinkAction<TEntity> linkPosisjon(String... posisjonIds) {

		return link(POSISJON_LINK, posisjonIds);
	}

	public LinkAction<TEntity> linkPosisjon(Posisjon... posisjon) {

		return link(POSISJON_LINK, posisjon);
	}

	public LinkAction<TEntity> linkPersonIdentifikator(String... personIdentifikator) {

		return link(PERSON_IDENTIFIKATOR_LINK, personIdentifikator);
	}

	public LinkAction<TEntity> linkPersonIdentifikator(PersonIdentifikator<?>... personIdentifikator) {

		return link(PERSON_IDENTIFIKATOR_LINK, personIdentifikator);
	}

	public LinkAction<TEntity> linkMappe(String mappeId) {

		return link(MAPPE_LINK, mappeId);
	}

	public LinkAction<TEntity> linkMappe(AbstraktMappe mappe) {

		return link(MAPPE_LINK, mappe);
	}

	public UnlinkAction<TEntity> unlinkMappe(String mappeId) {

		return unlink(MAPPE_LINK, mappeId);
	}

	public UnlinkAction<TEntity> unlinkMappe(AbstraktMappe mappe) {

		return unlink(MAPPE_LINK, mappe);
	}

	public LinkAction<TEntity> addKryssreferanseTilMappe(String... mappeIds) {

		return link(KRYSSREFERANSE_TIL_MAPPE_LINK, mappeIds);
	}

	public LinkAction<TEntity> addKryssreferanseTilMappe(AbstraktMappe... mappe) {

		return link(KRYSSREFERANSE_TIL_MAPPE_LINK, mappe);
	}

	public UnlinkAction<TEntity> removeKryssreferanseTilMappe(String... mappeIds) {

		return unlink(KRYSSREFERANSE_TIL_MAPPE_LINK, mappeIds);
	}

	public UnlinkAction<TEntity> removeKryssreferanseTilMappe(AbstraktMappe... mappe) {

		return unlink(KRYSSREFERANSE_TIL_MAPPE_LINK, mappe);
	}

	public LinkAction<TEntity> addKryssreferanseFraMappe(String... mappeIds) {

		return link(KRYSSREFERANSE_FRA_MAPPE_LINK, mappeIds);
	}

	public LinkAction<TEntity> addKryssreferanseFraMappe(AbstraktMappe... mappe) {

		return link(KRYSSREFERANSE_FRA_MAPPE_LINK, mappe);
	}

	public UnlinkAction<TEntity> removeKryssreferanseFraMappe(String... mappeIds) {

		return unlink(KRYSSREFERANSE_FRA_MAPPE_LINK, mappeIds);
	}

	public UnlinkAction<TEntity> removeKryssreferanseFraMappe(AbstraktMappe... mappe) {

		return unlink(KRYSSREFERANSE_FRA_MAPPE_LINK, mappe);
	}

	public LinkAction<TEntity> addKryssreferanseTilRegistrering(String... registreringIds) {

		return link(KRYSSREFERANSE_TIL_REGISTRERING_LINK, registreringIds);
	}

	public LinkAction<TEntity> addKryssreferanseTilRegistrering(AbstraktRegistrering... registrering) {

		return link(KRYSSREFERANSE_TIL_REGISTRERING_LINK, registrering);
	}

	public UnlinkAction<TEntity> removeKryssreferanseTilRegistrering(String... registreringIds) {

		return unlink(KRYSSREFERANSE_TIL_REGISTRERING_LINK, registreringIds);
	}

	public UnlinkAction<TEntity> removeKryssreferanseTilRegistrering(AbstraktRegistrering... registrering) {

		return unlink(KRYSSREFERANSE_TIL_REGISTRERING_LINK, registrering);
	}

	public LinkAction<TEntity> addKryssreferanseFraRegistrering(String... registreringIds) {

		return link(KRYSSREFERANSE_FRA_REGISTRERING_LINK, registreringIds);
	}

	public LinkAction<TEntity> addKryssreferanseFraRegistrering(AbstraktRegistrering... registrering) {

		return link(KRYSSREFERANSE_FRA_REGISTRERING_LINK, registrering);
	}

	public UnlinkAction<TEntity> removeKryssreferanseFraRegistrering(String... registreringIds) {

		return unlink(KRYSSREFERANSE_FRA_REGISTRERING_LINK, registreringIds);
	}

	public UnlinkAction<TEntity> removeKryssreferanseFraRegistrering(AbstraktRegistrering... registrering) {

		return unlink(KRYSSREFERANSE_FRA_REGISTRERING_LINK, registrering);
	}

	@JsonIgnore
	public String getRefArkivdel() {

		return getRef(ARKIVDEL_LINK);
	}

	@JsonIgnore
	public String getRefMappe() {

		return getRef(MAPPE_LINK);
	}

	@JsonIgnore
	public String getRefPrimaerKlasse() {

		return getRef(PRIMAER_KLASSE_LINK);
	}
}
