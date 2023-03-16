package com.documaster.rms.noark.ws.noarkentities;

import java.util.Date;
import java.util.Optional;

import com.documaster.rms.noark.ws.client.action.LinkAction;
import com.documaster.rms.noark.ws.client.action.UnlinkAction;
import com.documaster.rms.noark.ws.constants.Journalposttype;
import com.documaster.rms.noark.ws.constants.Journalstatus;
import com.documaster.rms.noark.ws.serialization.CustomDateFormat;
import com.documaster.rms.noark.ws.serialization.NoarkEnumJsonDeserializer;
import com.documaster.rms.noark.ws.serialization.NoarkEnumJsonSerializer;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Journalpost extends RegistreringBase<Journalpost> {

	public static final String AVSKRIVNING_LINK = "refAvskrivning";
	public static final String TILKNYTTET_AVSKRIVNING_LINK = "refTilknyttetAvskrivning";

	private Integer journalaar;
	private Integer journalsekvensnummer;
	private Integer journalpostnummer;
	private String journalansvarlig;
	private String journalansvarligBrukerIdent;
	private Date mottattDato;
	private boolean serializeMottattDato;
	private Date sendtDato;
	private boolean serializeSendtDato;
	private Boolean skjermKorrespondanseParterEInnsyn;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = CustomDateFormat.DATE)
	private Date offentlighetsvurdertDato;
	private boolean serializeOffentlighetsvurdertDato;

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

	public String getJournalansvarlig() {

		return journalansvarlig;
	}

	public void setJournalansvarlig(String journalansvarlig) {

		this.journalansvarlig = journalansvarlig;
	}

	public String getJournalansvarligBrukerIdent() {

		return journalansvarligBrukerIdent;
	}

	public void setJournalansvarligBrukerIdent(String journalansvarligBrukerIdent) {

		this.journalansvarligBrukerIdent = journalansvarligBrukerIdent;
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

	public Boolean getSkjermKorrespondanseParterEInnsyn() {

		return skjermKorrespondanseParterEInnsyn;
	}

	public void setSkjermKorrespondanseParterEInnsyn(Boolean skjermKorrespondanseParterEInnsyn) {

		this.skjermKorrespondanseParterEInnsyn = skjermKorrespondanseParterEInnsyn;
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
}
