package com.documaster.rms.noark.ws.noarkentities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Adresse extends NasjonalIdentifikator<Adresse> {

	private String adresseKnr;
	private String postnr;
	private String poststed;
	private String adressenavn;
	private String nummer;
	private String adressekode;
	private String alternativAdresse;

	public Adresse(String adresseKnr, String adressenavn) {

		this.adresseKnr = adresseKnr;
		this.adressenavn = adressenavn;
	}

	@JsonCreator
	private Adresse(
			@JsonProperty("id") String id,
			@JsonProperty("uuid") String uuid,
			@JsonProperty("version") String version) {

		super(id, uuid, version);
	}

	public String getAdresseKnr() {

		return adresseKnr;
	}

	public void setAdresseKnr(String adresseKnr) {

		this.adresseKnr = adresseKnr;
	}

	public String getPostnr() {

		return postnr;
	}

	public void setPostnr(String postnr) {

		this.postnr = postnr;
	}

	public String getPoststed() {

		return poststed;
	}

	public void setPoststed(String poststed) {

		this.poststed = poststed;
	}

	public String getAdressenavn() {

		return adressenavn;
	}

	public void setAdressenavn(String adressenavn) {

		this.adressenavn = adressenavn;
	}

	public String getNummer() {

		return nummer;
	}

	public void setNummer(String nummer) {

		this.nummer = nummer;
	}

	public String getAdressekode() {

		return adressekode;
	}

	public void setAdressekode(String adressekode) {

		this.adressekode = adressekode;
	}

	public String getAlternativAdresse() {

		return alternativAdresse;
	}

	public void setAlternativAdresse(String alternativAdresse) {

		this.alternativAdresse = alternativAdresse;
	}
}
