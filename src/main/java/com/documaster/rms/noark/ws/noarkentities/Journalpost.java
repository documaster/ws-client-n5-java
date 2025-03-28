package com.documaster.rms.noark.ws.noarkentities;

import java.util.Optional;

import com.documaster.rms.noark.ws.client.action.LinkAction;
import com.documaster.rms.noark.ws.client.action.UnlinkAction;
import com.documaster.rms.noark.ws.constants.Journalposttype;
import com.documaster.rms.noark.ws.constants.Journalstatus;
import com.documaster.rms.noark.ws.serialization.NoarkEnumJsonDeserializer;
import com.documaster.rms.noark.ws.serialization.NoarkEnumJsonSerializer;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Journalpost extends RegistreringBase<Journalpost> {

	public static final String AVSKRIVNING_LINK = "refAvskrivning";
	public static final String TILKNYTTET_AVSKRIVNING_LINK = "refTilknyttetAvskrivning";
	public static final String DOKUMENTFLYT_LINK = "refDokumentflyt";
	public static final String PRESEDENS_LINK = "refPresedens";

	private Integer journalaar;
	private Integer journalsekvensnummer;
	private Integer journalpostnummer;
	private Boolean skjermKorrespondanseParterEInnsyn;

	@JsonSerialize(using = NoarkEnumJsonSerializer.class)
	@JsonDeserialize(using = NoarkEnumJsonDeserializer.class)
	private Journalposttype journalposttype;

	@JsonSerialize(using = NoarkEnumJsonSerializer.class)
	@JsonDeserialize(using = NoarkEnumJsonDeserializer.class)
	private Journalstatus journalstatus;

	private String prefiks;
	private boolean serializePrefiks;

	public Journalpost(String tittel, Journalposttype type) {

		setTittel(tittel);
		this.journalposttype = type;
	}

	@JsonCreator
	private Journalpost(
			@JsonProperty("id") String id,
			@JsonProperty("uuid") String uuid,
			@JsonProperty("version") String version) {

		super(id, uuid, version);
	}

	public Integer getJournalaar() {

		return journalaar;
	}

	public void setJournalaar(Integer journalaar) {

		this.journalaar = journalaar;
	}

	public Integer getJournalsekvensnummer() {

		return journalsekvensnummer;
	}

	public void setJournalsekvensnummer(Integer journalsekvensnummer) {

		this.journalsekvensnummer = journalsekvensnummer;
	}

	public Integer getJournalpostnummer() {

		return journalpostnummer;
	}

	public void setJournalpostnummer(Integer journalpostnummer) {

		this.journalpostnummer = journalpostnummer;
	}

	public Journalposttype getJournalposttype() {

		return journalposttype;
	}

	public void setJournalposttype(Journalposttype journalposttype) {

		this.journalposttype = journalposttype;
	}

	public Journalstatus getJournalstatus() {

		return journalstatus;
	}

	public void setJournalstatus(Journalstatus journalstatus) {

		this.journalstatus = journalstatus;
	}

	public Boolean getSkjermKorrespondanseParterEInnsyn() {

		return skjermKorrespondanseParterEInnsyn;
	}

	public void setSkjermKorrespondanseParterEInnsyn(Boolean skjermKorrespondanseParterEInnsyn) {

		this.skjermKorrespondanseParterEInnsyn = skjermKorrespondanseParterEInnsyn;
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

	public LinkAction<Journalpost> linkAvskrivning(String... avskrivningIds) {

		return link(AVSKRIVNING_LINK, avskrivningIds);
	}

	public LinkAction<Journalpost> linkAvskrivning(Avskrivning... avskrivnings) {

		return link(AVSKRIVNING_LINK, avskrivnings);
	}

	public LinkAction<Journalpost> linkTilknyttetAvskrivning(String... avskrivningIds) {

		return link(TILKNYTTET_AVSKRIVNING_LINK, avskrivningIds);
	}

	public LinkAction<Journalpost> linkTilknyttetAvskrivning(Avskrivning... avskrivnings) {

		return link(TILKNYTTET_AVSKRIVNING_LINK, avskrivnings);
	}

	public UnlinkAction<Journalpost> unlinkTilknyttetAvskrivning(String... avskrivningIds) {

		return unlink(TILKNYTTET_AVSKRIVNING_LINK, avskrivningIds);
	}

	public UnlinkAction<Journalpost> unlinkTilknyttetAvskrivning(Avskrivning... avskrivnings) {

		return unlink(TILKNYTTET_AVSKRIVNING_LINK, avskrivnings);
	}

	public LinkAction<Journalpost> linkDokumentflyt(String... dokumentflytIds) {

		return link(DOKUMENTFLYT_LINK, dokumentflytIds);
	}

	public LinkAction<Journalpost> linkDokumentflyt(Dokumentflyt... dokumentflyts) {

		return link(DOKUMENTFLYT_LINK, dokumentflyts);
	}

	public LinkAction<Journalpost> linkPresedens(String... presedensIds) {

		return link(PRESEDENS_LINK, presedensIds);
	}

	public LinkAction<Journalpost> linkPresedens(Presedens... presedens) {

		return link(PRESEDENS_LINK, presedens);
	}

	public UnlinkAction<Journalpost> unlinkPresedens(String... presedensIds) {

		return unlink(PRESEDENS_LINK, presedensIds);
	}

	public UnlinkAction<Journalpost> unlinkPresedens(Presedens... presedens) {

		return unlink(PRESEDENS_LINK, presedens);
	}
}
