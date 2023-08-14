package com.documaster.rms.noark.ws.noarkentities.expand;

import java.util.ArrayList;
import java.util.List;

import com.documaster.rms.noark.ws.client.Bean;
import com.documaster.rms.noark.ws.constants.Journalposttype;
import com.documaster.rms.noark.ws.constants.Journalstatus;
import com.documaster.rms.noark.ws.constants.Korrespondanseparttype;
import com.documaster.rms.noark.ws.serialization.NoarkEnumJsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class UtvidTilJournalpost implements Bean {

	private String id;
	private Journalpost journalpost;
	private List<Korrespondansepart> korrespondansepart = new ArrayList<>();

	public String getId() {

		return id;
	}

	public void setId(String id) {

		this.id = id;
	}

	public Journalpost getJournalpost() {

		return journalpost;
	}

	public void setJournalpost(Journalpost journalpost) {

		this.journalpost = journalpost;
	}

	public List<Korrespondansepart> getKorrespondansepart() {

		return korrespondansepart;
	}

	public void setKorrespondansepart(List<Korrespondansepart> korrespondansepart) {

		this.korrespondansepart = korrespondansepart;
	}

	public static class Journalpost {

		private Integer journalaar;

		private Integer journalsekvensnummer;

		private Integer journalpostnummer;

		private String journalansvarlig;

		private String journalansvarligBrukerIdent;

		@JsonSerialize(using = NoarkEnumJsonSerializer.class)
		private Journalposttype journalposttype;

		@JsonSerialize(using = NoarkEnumJsonSerializer.class)
		private Journalstatus journalstatus;

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
	}

	public static class Korrespondansepart {

		private String korrespondansepartNavn;

		@JsonSerialize(using = NoarkEnumJsonSerializer.class)
		private Korrespondanseparttype korrespondanseparttype;

		public String getKorrespondansepartNavn() {

			return korrespondansepartNavn;
		}

		public void setKorrespondansepartNavn(String korrespondansepartNavn) {

			this.korrespondansepartNavn = korrespondansepartNavn;
		}

		public Korrespondanseparttype getKorrespondanseparttype() {

			return korrespondanseparttype;
		}

		public void setKorrespondanseparttype(Korrespondanseparttype korrespondanseparttype) {

			this.korrespondanseparttype = korrespondanseparttype;
		}
	}
}
