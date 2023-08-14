package com.documaster.rms.noark.ws.noarkentities.expand;

import java.util.Date;

import com.documaster.rms.noark.ws.client.Bean;
import com.documaster.rms.noark.ws.constants.AdministrativEnhet;
import com.documaster.rms.noark.ws.constants.Saksstatus;
import com.documaster.rms.noark.ws.serialization.CustomDateFormat;
import com.documaster.rms.noark.ws.serialization.NoarkEnumJsonSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class UtvidTilSaksmappe implements Bean {

	private String id;
	private Saksmappe saksmappe;

	public String getId() {

		return id;
	}

	public void setId(String id) {

		this.id = id;
	}

	public Saksmappe getSaksmappe() {

		return saksmappe;
	}

	public void setSaksmappe(Saksmappe saksmappe) {

		this.saksmappe = saksmappe;
	}

	public static class Saksmappe {

		private String mappeIdent;

		private Integer saksaar;

		private Integer sakssekvensnummer;

		private String saksansvarlig;

		private String saksansvarligBrukerIdent;

		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = CustomDateFormat.DATE)
		private Date saksdato;

		@JsonSerialize(using = NoarkEnumJsonSerializer.class)
		private AdministrativEnhet administrativEnhet;

		@JsonSerialize(using = NoarkEnumJsonSerializer.class)
		private Saksstatus saksstatus;

		public String getMappeIdent() {

			return mappeIdent;
		}

		public void setMappeIdent(String mappeIdent) {

			this.mappeIdent = mappeIdent;
		}

		public Integer getSaksaar() {

			return saksaar;
		}

		public void setSaksaar(Integer saksaar) {

			this.saksaar = saksaar;
		}

		public Integer getSakssekvensnummer() {

			return sakssekvensnummer;
		}

		public void setSakssekvensnummer(Integer sakssekvensnummer) {

			this.sakssekvensnummer = sakssekvensnummer;
		}

		public String getSaksansvarlig() {

			return saksansvarlig;
		}

		public void setSaksansvarlig(String saksansvarlig) {

			this.saksansvarlig = saksansvarlig;
		}

		public String getSaksansvarligBrukerIdent() {

			return saksansvarligBrukerIdent;
		}

		public void setSaksansvarligBrukerIdent(String saksansvarligBrukerIdent) {

			this.saksansvarligBrukerIdent = saksansvarligBrukerIdent;
		}

		public Date getSaksdato() {

			return saksdato;
		}

		public void setSaksdato(Date saksdato) {

			this.saksdato = saksdato;
		}

		public AdministrativEnhet getAdministrativEnhet() {

			return administrativEnhet;
		}

		public void setAdministrativEnhet(AdministrativEnhet administrativEnhet) {

			this.administrativEnhet = administrativEnhet;
		}

		public Saksstatus getSaksstatus() {

			return saksstatus;
		}

		public void setSaksstatus(Saksstatus saksstatus) {

			this.saksstatus = saksstatus;
		}
	}
}
