package com.documaster.rms.noark.ws.noarkentities;

import java.util.Date;

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

	private Integer journalaar;
	private Integer journalsekvensnummer;
	private Integer journalpostnummer;
	private String journalansvarlig;
	private String journalansvarligBrukerIdent;
	private Date mottattDato;
	private Date sendtDato;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = CustomDateFormat.DATE)
	private Date offentlighetsvurdertDato;

	@JsonSerialize(using = NoarkEnumJsonSerializer.class)
	@JsonDeserialize(using = NoarkEnumJsonDeserializer.class)
	private Journalposttype journalposttype;

	@JsonSerialize(using = NoarkEnumJsonSerializer.class)
	@JsonDeserialize(using = NoarkEnumJsonDeserializer.class)
	private Journalstatus journalstatus;

	private String prefiks;

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

	public void setMottattDato(Date mottattDato) {

		this.mottattDato = mottattDato;
	}

	public Date getSendtDato() {

		return sendtDato;
	}

	public void setSendtDato(Date sendtDato) {

		this.sendtDato = sendtDato;
	}

	public Date getOffentlighetsvurdertDato() {

		return offentlighetsvurdertDato;
	}

	public void setOffentlighetsvurdertDato(Date offentlighetsvurdertDato) {

		this.offentlighetsvurdertDato = offentlighetsvurdertDato;
	}

	public String getPrefiks() {

		return prefiks;
	}

	public void setPrefiks(String prefiks) {

		this.prefiks = prefiks;
	}
}
