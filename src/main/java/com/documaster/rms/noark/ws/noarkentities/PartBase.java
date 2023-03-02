package com.documaster.rms.noark.ws.noarkentities;

import java.util.Optional;

import com.documaster.rms.noark.ws.noarkentities.bsm.BsmGroupsMap;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class PartBase<TEntity extends PartBase<TEntity>> extends NoarkEntityBase<TEntity> {

	private String postadresse;
	private boolean serializePostadresse;
	private String postnummer;
	private boolean serializePostnummer;
	private String poststed;
	private boolean serializePoststed;
	private String land;
	private boolean serializeLand;
	private String epostadresse;
	private boolean serializeEpostadresse;
	private String telefonnummer;
	private boolean serializeTelefonnummer;
	private String kontaktperson;
	private boolean serializeKontaktperson;
	private String foedselsnummer;
	private boolean serializeFoedselsnummer;
	private String organisasjonsnummer;
	private boolean serializeOrganisasjonsnummer;
	private String dnummer;
	private boolean serializeDnummer;

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

	@JsonProperty("postadresse")
	public void setPostadresse(String postadresse) {

		this.postadresse = postadresse;
		serializePostadresse = true;
	}

	@JsonProperty("postadresse")
	public Optional<String> getPostadresseAsOptional() {

		if (serializePostadresse) {

			return Optional.ofNullable(postadresse);
		}

		return null;
	}

	public String getPostnummer() {

		return postnummer;
	}

	@JsonProperty("postnummer")
	public void setPostnummer(String postnummer) {

		this.postnummer = postnummer;
		serializePostnummer = true;
	}

	@JsonProperty("postnummer")
	public Optional<String> getPostnummerAsOptional() {

		if (serializePostnummer) {

			return Optional.ofNullable(postnummer);
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

	public String getLand() {

		return land;
	}

	@JsonProperty("land")
	public void setLand(String land) {

		this.land = land;
		serializeLand = true;
	}

	@JsonProperty("land")
	public Optional<String> getLandAsOptional() {

		if (serializeLand) {

			return Optional.ofNullable(land);
		}

		return null;
	}

	public String getEpostadresse() {

		return epostadresse;
	}

	@JsonProperty("epostadresse")
	public void setEpostadresse(String epostadresse) {

		this.epostadresse = epostadresse;
		serializeEpostadresse = true;
	}

	@JsonProperty("epostadresse")
	public Optional<String> getEpostadresseAsOptional() {

		if (serializeEpostadresse) {

			return Optional.ofNullable(epostadresse);
		}

		return null;
	}

	public String getTelefonnummer() {

		return telefonnummer;
	}

	@JsonProperty("telefonnummer")
	public void setTelefonnummer(String telefonnummer) {

		this.telefonnummer = telefonnummer;
		serializeTelefonnummer = true;
	}

	@JsonProperty("telefonnummer")
	public Optional<String> getTelefonnummerAsOptional() {

		if (serializeTelefonnummer) {

			return Optional.ofNullable(telefonnummer);
		}

		return null;
	}

	public String getKontaktperson() {

		return kontaktperson;
	}

	@JsonProperty("kontaktperson")
	public void setKontaktperson(String kontaktperson) {

		this.kontaktperson = kontaktperson;
		serializeKontaktperson = true;
	}

	@JsonProperty("kontaktperson")
	public Optional<String> getKontaktpersonAsOptional() {

		if (serializeKontaktperson) {

			return Optional.ofNullable(kontaktperson);
		}

		return null;
	}

	public String getFoedselsnummer() {

		return foedselsnummer;
	}

	@JsonProperty("foedselsnummer")
	public void setFoedselsnummer(String foedselsnummer) {

		this.foedselsnummer = foedselsnummer;
		serializeFoedselsnummer = true;
	}

	@JsonProperty("foedselsnummer")
	public Optional<String> getFoedselsnummerAsOptional() {

		if (serializeFoedselsnummer) {

			return Optional.ofNullable(foedselsnummer);
		}

		return null;
	}

	public String getOrganisasjonsnummer() {

		return organisasjonsnummer;
	}

	@JsonProperty("organisasjonsnummer")
	public void setOrganisasjonsnummer(String organisasjonsnummer) {

		this.organisasjonsnummer = organisasjonsnummer;
		serializeOrganisasjonsnummer = true;
	}

	@JsonProperty("organisasjonsnummer")
	public Optional<String> getOrganisasjonsnummerAsOptional() {

		if (serializeOrganisasjonsnummer) {

			return Optional.ofNullable(organisasjonsnummer);
		}

		return null;
	}

	public String getDnummer() {

		return dnummer;
	}

	@JsonProperty("dnummer")
	public void setDnummer(String dnummer) {

		this.dnummer = dnummer;
		serializeDnummer = true;
	}

	@JsonProperty("dnummer")
	public Optional<String> getDnummerAsOptional() {

		if (serializeDnummer) {

			return Optional.ofNullable(dnummer);
		}

		return null;
	}

	public BsmGroupsMap getVirksomhetsspesifikkeMetadata() {

		return virksomhetsspesifikkeMetadata;
	}

	public void setVirksomhetsspesifikkeMetadata(
			BsmGroupsMap virksomhetsspesifikkeMetadata) {

		this.virksomhetsspesifikkeMetadata = virksomhetsspesifikkeMetadata;
	}
}
