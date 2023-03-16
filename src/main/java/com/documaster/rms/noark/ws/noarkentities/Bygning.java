package com.documaster.rms.noark.ws.noarkentities;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Bygning extends NasjonalIdentifikator<Bygning> {

	private String bygningsnummer;
	private String endringsloepenummer;
	private String bygningsStatus;
	private boolean serializeBygningsStatus;
	private String bygningsType;
	private boolean serializeBygningsType;
	private String bygningsendringsType;
	private boolean serializeBygningsendringsType;
	private String koordinatsystem;
	private boolean serializeKoordinatsystem;
	private String koordX;
	private boolean serializeKoordX;
	private String koordY;
	private boolean serializeKoordY;
	private String koordZ;
	private boolean serializeKoordZ;
	private String etasjeNummer;
	private boolean serializeEtasjeNummer;
	private String etasjeplan;
	private boolean serializeEtasjeplan;
	private String bygningsnavn;
	private boolean serializeBygningsnavn;
	private String bruksenhetLoepenr;
	private boolean serializeBruksenhetLoepenr;

	public Bygning(String bygningsnummer, String endringsloepenummer) {

		this.bygningsnummer = bygningsnummer;
		this.endringsloepenummer = endringsloepenummer;
	}

	@JsonCreator
	private Bygning(
			@JsonProperty("id") String id,
			@JsonProperty("uuid") String uuid,
			@JsonProperty("version") String version) {

		super(id, uuid, version);
	}

	public String getBygningsnummer() {

		return bygningsnummer;
	}

	public void setBygningsnummer(String bygningsnummer) {

		this.bygningsnummer = bygningsnummer;
	}

	public String getEndringsloepenummer() {

		return endringsloepenummer;
	}

	public void setEndringsloepenummer(String endringsloepenummer) {

		this.endringsloepenummer = endringsloepenummer;
	}

	public String getBygningsStatus() {

		return bygningsStatus;
	}

	@JsonProperty("bygningsStatus")
	public void setBygningsStatus(String bygningsStatus) {

		this.bygningsStatus = bygningsStatus;
		serializeBygningsStatus = true;
	}

	@JsonProperty("bygningsStatus")
	public Optional<String> getBygningsStatusAsOptional() {

		if (serializeBygningsStatus) {

			return Optional.ofNullable(bygningsStatus);
		}

		return null;
	}

	public String getBygningsType() {

		return bygningsType;
	}

	@JsonProperty("bygningsType")
	public void setBygningsType(String bygningsType) {

		this.bygningsType = bygningsType;
		serializeBygningsType = true;
	}

	@JsonProperty("bygningsType")
	public Optional<String> getBygningsTypeAsOptional() {

		if (serializeBygningsType) {

			return Optional.ofNullable(bygningsType);
		}

		return null;
	}

	public String getBygningsendringsType() {

		return bygningsendringsType;
	}

	@JsonProperty("bygningsendringsType")
	public void setBygningsendringsType(String bygningsendringsType) {

		this.bygningsendringsType = bygningsendringsType;
		serializeBygningsendringsType = true;
	}

	@JsonProperty("bygningsendringsType")
	public Optional<String> getBygningsendringsTypeAsOptional() {

		if (serializeBygningsendringsType) {

			return Optional.ofNullable(bygningsendringsType);
		}

		return null;
	}

	public String getKoordinatsystem() {

		return koordinatsystem;
	}

	@JsonProperty("koordinatsystem")
	public void setKoordinatsystem(String koordinatsystem) {

		this.koordinatsystem = koordinatsystem;
		serializeKoordinatsystem = true;
	}

	@JsonProperty("koordinatsystem")
	public Optional<String> getKoordinatsystemAsOptional() {

		if (serializeKoordinatsystem) {

			return Optional.ofNullable(koordinatsystem);
		}

		return null;
	}

	public String getKoordX() {

		return koordX;
	}

	@JsonProperty("koordX")
	public void setKoordX(String koordX) {

		this.koordX = koordX;
		serializeKoordX = true;
	}

	@JsonProperty("koordX")
	public Optional<String> getKoordXAsOptional() {

		if (serializeKoordX) {

			return Optional.ofNullable(koordX);
		}

		return null;
	}

	public String getKoordY() {

		return koordY;
	}

	@JsonProperty("koordY")
	public void setKoordY(String koordY) {

		this.koordY = koordY;
		serializeKoordY = true;
	}

	@JsonProperty("koordY")
	public Optional<String> getKoordYAsOptional() {

		if (serializeKoordY) {

			return Optional.ofNullable(koordY);
		}

		return null;
	}

	public String getKoordZ() {

		return koordZ;
	}

	@JsonProperty("koordZ")
	public void setKoordZ(String koordZ) {

		this.koordZ = koordZ;
		serializeKoordZ = true;
	}

	@JsonProperty("koordZ")
	public Optional<String> getKoordZAsOptional() {

		if (serializeKoordZ) {

			return Optional.ofNullable(koordZ);
		}

		return null;
	}

	public String getEtasjeNummer() {

		return etasjeNummer;
	}

	@JsonProperty("etasjeNummer")
	public void setEtasjeNummer(String etasjeNummer) {

		this.etasjeNummer = etasjeNummer;
		serializeEtasjeNummer = true;
	}

	@JsonProperty("etasjeNummer")
	public Optional<String> getEtasjeNummerAsOptional() {

		if (serializeEtasjeNummer) {

			return Optional.ofNullable(etasjeNummer);
		}

		return null;
	}

	public String getEtasjeplan() {

		return etasjeplan;
	}

	@JsonProperty("etasjeplan")
	public void setEtasjeplan(String etasjeplan) {

		this.etasjeplan = etasjeplan;
		serializeEtasjeplan = true;
	}

	@JsonProperty("etasjeplan")
	public Optional<String> getEtasjeplanAsOptional() {

		if (serializeEtasjeplan) {

			return Optional.ofNullable(etasjeplan);
		}

		return null;
	}

	public String getBygningsnavn() {

		return bygningsnavn;
	}

	@JsonProperty("bygningsnavn")
	public void setBygningsnavn(String bygningsnavn) {

		this.bygningsnavn = bygningsnavn;
		serializeBygningsnavn = true;
	}

	@JsonProperty("bygningsnavn")
	public Optional<String> getBygningsnavnAsOptional() {

		if (serializeBygningsnavn) {

			return Optional.ofNullable(bygningsnavn);
		}

		return null;
	}

	public String getBruksenhetLoepenr() {

		return bruksenhetLoepenr;
	}

	@JsonProperty("bruksenhetLoepenr")
	public void setBruksenhetLoepenr(String bruksenhetLoepenr) {

		this.bruksenhetLoepenr = bruksenhetLoepenr;
		serializeBruksenhetLoepenr = true;
	}

	@JsonProperty("bruksenhetLoepenr")
	public Optional<String> getBruksenhetLoepenrAsOptional() {

		if (serializeBruksenhetLoepenr) {

			return Optional.ofNullable(bruksenhetLoepenr);
		}

		return null;
	}
}
