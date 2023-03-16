package com.documaster.rms.noark.ws.noarkentities;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Adresse extends NasjonalIdentifikator<Adresse> {

	private String adresseKnr;
	private String postnr;
	private boolean serializePostnr;
	private String poststed;
	private boolean serializePoststed;
	private String adressenavn;
	private String nummer;
	private boolean serializeNummer;
	private String adressekode;
	private boolean serializeAdressekode;
	private String alternativAdresse;
	private boolean serializeAlternativAdresse;

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

	@JsonProperty("postnr")
	public void setPostnr(String postnr) {

		this.postnr = postnr;
		serializePostnr = true;
	}

	@JsonProperty("postnr")
	public Optional<String> getPostnrAsOptional() {

		if (serializePostnr) {

			return Optional.ofNullable(postnr);
		}

		return null;
	}

	public String getPoststed() {

		return poststed;
	}

	@JsonProperty("poststed")
	public void setPoststed(String poststed) {

		this.poststed = poststed;
		serializePoststed = true;
	}

	@JsonProperty("poststed")
	public Optional<String> getPoststedAsOptional() {

		if (serializePoststed) {

			return Optional.ofNullable(poststed);
		}

		return null;
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

	@JsonProperty("nummer")
	public void setNummer(String nummer) {

		this.nummer = nummer;
		serializeNummer = true;
	}

	@JsonProperty("nummer")
	public Optional<String> getNummerAsOptional() {

		if (serializeNummer) {

			return Optional.ofNullable(nummer);
		}

		return null;
	}

	public String getAdressekode() {

		return adressekode;
	}

	@JsonProperty("adressekode")
	public void setAdressekode(String adressekode) {

		this.adressekode = adressekode;
		serializeAdressekode = true;
	}

	@JsonProperty("adressekode")
	public Optional<String> getAdressekodeAsOptional() {

		if (serializeAdressekode) {

			return Optional.ofNullable(adressekode);
		}

		return null;
	}

	public String getAlternativAdresse() {

		return alternativAdresse;
	}

	@JsonProperty("alternativAdresse")
	public void setAlternativAdresse(String alternativAdresse) {

		this.alternativAdresse = alternativAdresse;
		serializeAlternativAdresse = true;
	}

	@JsonProperty("alternativAdresse")
	public Optional<String> getAlternativAdresseAsOptional() {

		if (serializeAlternativAdresse) {

			return Optional.ofNullable(alternativAdresse);
		}

		return null;
	}
}
