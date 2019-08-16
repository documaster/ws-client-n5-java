package com.documaster.rms.noark.ws.noarkentities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class PartBase<TEntity extends PartBase<TEntity>> extends NoarkEntityBase<TEntity> {

	private String postadresse;
	private String postnummer;
	private String poststed;
	private String land;
	private String epostadresse;
	private String telefonnummer;
	private String kontaktperson;
	private String foedselsnummer;
	private String dnummer;

	protected PartBase() {

	}

	@JsonCreator
	protected PartBase(
			@JsonProperty("id") String id,
			@JsonProperty("uuid") String uuid,
			@JsonProperty("version") String version) {

		super(id, uuid, version);
	}

	public String getPostadresse() {

		return postadresse;
	}

	public void setPostadresse(String postadresse) {

		this.postadresse = postadresse;
	}

	public String getPostnummer() {

		return postnummer;
	}

	public void setPostnummer(String postnummer) {

		this.postnummer = postnummer;
	}

	public String getPoststed() {

		return poststed;
	}

	public void setPoststed(String poststed) {

		this.poststed = poststed;
	}

	public String getLand() {

		return land;
	}

	public void setLand(String land) {

		this.land = land;
	}

	public String getEpostadresse() {

		return epostadresse;
	}

	public void setEpostadresse(String epostadresse) {

		this.epostadresse = epostadresse;
	}

	public String getTelefonnummer() {

		return telefonnummer;
	}

	public void setTelefonnummer(String telefonnummer) {

		this.telefonnummer = telefonnummer;
	}

	public String getKontaktperson() {

		return kontaktperson;
	}

	public void setKontaktperson(String kontaktperson) {

		this.kontaktperson = kontaktperson;
	}

	public String getFoedselsnummer() {

		return foedselsnummer;
	}

	public void setFoedselsnummer(String foedselsnummer) {

		this.foedselsnummer = foedselsnummer;
	}

	public String getDnummer() {

		return dnummer;
	}

	public void setDnummer(String dnummer) {

		this.dnummer = dnummer;
	}
}
