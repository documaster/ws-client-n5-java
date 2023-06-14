package com.documaster.rms.noark.ws.noarkentities;

import java.util.Optional;

import com.documaster.rms.noark.ws.client.action.LinkAction;
import com.documaster.rms.noark.ws.client.action.UnlinkAction;
import com.documaster.rms.noark.ws.constants.Dokumentmedium;
import com.documaster.rms.noark.ws.constants.Mappetype;
import com.documaster.rms.noark.ws.constants.Skjerming;
import com.documaster.rms.noark.ws.noarkentities.bsm.BsmGroupsMap;
import com.documaster.rms.noark.ws.serialization.NoarkEnumJsonDeserializer;
import com.documaster.rms.noark.ws.serialization.NoarkEnumJsonSerializer;
import com.documaster.rms.noark.ws.serialization.NoarkOptionalEnumJsonSerializer;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public abstract class MappeBase<TEntity extends MappeBase<TEntity>> extends DisposableFinalizedEntityBase<TEntity>
		implements AbstraktMappe {

	public static final String ARKIVDEL_LINK = "refArkivdel";
	public static final String PRIMAER_KLASSE_LINK = "refPrimaerKlasse";
	public static final String SEKUNDAER_KLASSE_LINK = "refSekundaerKlasse";
	public static final String EKSTERN_ID_LINK = "refEksternId";
	public static final String REGISTRERING_LINK = "refRegistrering";
	public static final String NOEKKELORD_LINK = "refNoekkelord";
	public static final String MERKNAD_LINK = "refMerknad";
	public static final String NASJONAL_IDENTIFIKATOR_LINK = "refNasjonalIdentifikator";
	public static final String POSISJON_LINK = "refPosisjon";
	public static final String PERSON_IDENTIFIKATOR_LINK = "refPersonIdentifikator";
	public static final String KRYSSREFERANSE_TIL_MAPPE_LINK = "refKryssreferanseTilMappe";
	public static final String KRYSSREFERANSE_FRA_MAPPE_LINK = "refKryssreferanseFraMappe";
	public static final String KRYSSREFERANSE_TIL_REGISTRERING_LINK = "refKryssreferanseTilRegistrering";
	public static final String KRYSSREFERANSE_FRA_REGISTRERING_LINK = "refKryssreferanseFraRegistrering";

	private String mappeIdent;
	private String tittel;
	private String offentligTittel;
	private boolean serializeOffentligTittel;
	private String beskrivelse;
	private boolean serializeBeskrivelse;
	private BsmGroupsMap virksomhetsspesifikkeMetadata = new BsmGroupsMap();

	@JsonSerialize(using = NoarkEnumJsonSerializer.class)
	@JsonDeserialize(using = NoarkEnumJsonDeserializer.class)
	private Dokumentmedium dokumentmedium;

	@JsonSerialize(using = NoarkOptionalEnumJsonSerializer.class)
	@JsonDeserialize(using = NoarkEnumJsonDeserializer.class)
	private Skjerming skjerming;

	private boolean serializeSkjerming;

	@JsonSerialize(using = NoarkOptionalEnumJsonSerializer.class)
	@JsonDeserialize(using = NoarkEnumJsonDeserializer.class)
	private Mappetype mappetype;

	private boolean serializeMappetype;

	protected MappeBase() {

	}

	@JsonCreator
	protected MappeBase(
			@JsonProperty("id") String id,
			@JsonProperty("uuid") String uuid,
			@JsonProperty("version") String version) {

		super(id, uuid, version);
	}

	public String getMappeIdent() {

		return mappeIdent;
	}

	public void setMappeIdent(String mappeIdent) {

		this.mappeIdent = mappeIdent;
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

	public BsmGroupsMap getVirksomhetsspesifikkeMetadata() {

		return virksomhetsspesifikkeMetadata;
	}

	public void setVirksomhetsspesifikkeMetadata(BsmGroupsMap virksomhetsspesifikkeMetadata) {

		this.virksomhetsspesifikkeMetadata = virksomhetsspesifikkeMetadata;
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

	public Mappetype getMappetype() {

		return mappetype;
	}

	@JsonProperty("mappetype")
	public void setMappetype(Mappetype mappetype) {

		this.mappetype = mappetype;
		serializeMappetype = true;
	}

	@JsonProperty("mappetype")
	public Optional<Mappetype> getMappetypeAsOptional() {

		if (serializeMappetype) {

			return Optional.ofNullable(mappetype);
		}

		return null;
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

	public LinkAction<TEntity> linkArkivdel(String arkivdelIds) {

		return link(ARKIVDEL_LINK, arkivdelIds);
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

	public LinkAction<TEntity> linkEksternId(String... eksternIdIds) {

		return link(EKSTERN_ID_LINK, eksternIdIds);
	}

	public LinkAction<TEntity> linkEksternId(EksternId... eksternId) {

		return link(EKSTERN_ID_LINK, eksternId);
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

	public LinkAction<TEntity> linkPersonIdentifikator(String... personIdentifikatorIds) {

		return link(PERSON_IDENTIFIKATOR_LINK, personIdentifikatorIds);
	}

	public LinkAction<TEntity> linkPersonIdentifikator(PersonIdentifikator<?>... personIdentifikator) {

		return link(PERSON_IDENTIFIKATOR_LINK, personIdentifikator);
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
	public String getRefPrimaerKlasse() {

		return getRef(PRIMAER_KLASSE_LINK);
	}
}
