package com.documaster.rms.noark.ws.noarkentities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Eiendom extends NasjonalIdentifikator<Eiendom> {

	private String knr;
	private String gnr;
	private String bnr;
	private String fnr;
	private String snr;
	private String bruksnavn;

	public static Eiendom createEiendom(String knr, String gnr, String bnr) {

		Eiendom eiendom = new Eiendom();

		eiendom.setKnr(knr);
		eiendom.setGnr(gnr);
		eiendom.setBnr(bnr);

		return eiendom;
	}

	private Eiendom() {

	}

	@JsonCreator
	private Eiendom(
			@JsonProperty("id") String id,
			@JsonProperty("uuid") String uuid,
			@JsonProperty("version") String version) {

		super(id, uuid, version);
	}

	public String getKnr() {

		return knr;
	}

	public void setKnr(String knr) {

		this.knr = knr;
	}

	public String getGnr() {

		return gnr;
	}

	public void setGnr(String gnr) {

		this.gnr = gnr;
	}

	public String getBnr() {

		return bnr;
	}

	public void setBnr(String bnr) {

		this.bnr = bnr;
	}

	public String getFnr() {

		return fnr;
	}

	public void setFnr(String fnr) {

		this.fnr = fnr;
	}

	public String getSnr() {

		return snr;
	}

	public void setSnr(String snr) {

		this.snr = snr;
	}

	public String getBruksnavn() {

		return bruksnavn;
	}

	public void setBruksnavn(String bruksnavn) {

		this.bruksnavn = bruksnavn;
	}
}
