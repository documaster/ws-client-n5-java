package com.documaster.rms.noark.ws.noarkentities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Bygning extends NasjonalIdentifikator<Bygning> {

	private String bygningsnummer;
	private String endringsloepenummer;
	private String bygningsStatus;
	private String bygningsType;
	private String bygningsendringsType;
	private String koordinatsystem;
	private String koordX;
	private String koordY;
	private String koordZ;
	private String etasjeNummer;
	private String etasjeplan;
	private String bygningsnavn;
	private String bruksenhetLoepenr;

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

	public void setBygningsStatus(String bygningsStatus) {

		this.bygningsStatus = bygningsStatus;
	}

	public String getBygningsType() {

		return bygningsType;
	}

	public void setBygningsType(String bygningsType) {

		this.bygningsType = bygningsType;
	}

	public String getBygningsendringsType() {

		return bygningsendringsType;
	}

	public void setBygningsendringsType(String bygningsendringsType) {

		this.bygningsendringsType = bygningsendringsType;
	}

	public String getKoordinatsystem() {

		return koordinatsystem;
	}

	public void setKoordinatsystem(String koordinatsystem) {

		this.koordinatsystem = koordinatsystem;
	}

	public String getKoordX() {

		return koordX;
	}

	public void setKoordX(String koordX) {

		this.koordX = koordX;
	}

	public String getKoordY() {

		return koordY;
	}

	public void setKoordY(String koordY) {

		this.koordY = koordY;
	}

	public String getKoordZ() {

		return koordZ;
	}

	public void setKoordZ(String koordZ) {

		this.koordZ = koordZ;
	}

	public String getEtasjeNummer() {

		return etasjeNummer;
	}

	public void setEtasjeNummer(String etasjeNummer) {

		this.etasjeNummer = etasjeNummer;
	}

	public String getEtasjeplan() {

		return etasjeplan;
	}

	public void setEtasjeplan(String etasjeplan) {

		this.etasjeplan = etasjeplan;
	}

	public String getBygningsnavn() {

		return bygningsnavn;
	}

	public void setBygningsnavn(String bygningsnavn) {

		this.bygningsnavn = bygningsnavn;
	}

	public String getBruksenhetLoepenr() {

		return bruksenhetLoepenr;
	}

	public void setBruksenhetLoepenr(String bruksenhetLoepenr) {

		this.bruksenhetLoepenr = bruksenhetLoepenr;
	}
}
