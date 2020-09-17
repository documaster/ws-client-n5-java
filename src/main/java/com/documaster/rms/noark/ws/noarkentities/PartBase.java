package com.documaster.rms.noark.ws.noarkentities;

import com.documaster.rms.noark.ws.noarkentities.bsm.BsmGroupsMap;
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
	private String organisasjonsnummer;
	private String dnummer;

	private BsmGroupsMap virksomhetsspesifikkeMetadata = new BsmGroupsMap();

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

	public String getOrganisasjonsnummer() {

		return organisasjonsnummer;
	}

	public void setOrganisasjonsnummer(String organisasjonsnummer) {

		this.organisasjonsnummer = organisasjonsnummer;
	}

	public String getDnummer() {

		return dnummer;
	}

	public void setDnummer(String dnummer) {

		this.dnummer = dnummer;
	}

	public BsmGroupsMap getVirksomhetsspesifikkeMetadata() {

		return virksomhetsspesifikkeMetadata;
	}

	public void setVirksomhetsspesifikkeMetadata(
			BsmGroupsMap virksomhetsspesifikkeMetadata) {

		this.virksomhetsspesifikkeMetadata = virksomhetsspesifikkeMetadata;
	}
}
