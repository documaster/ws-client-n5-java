package com.documaster.rms.noark.ws.noarkentities;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Eiendom extends NasjonalIdentifikator<Eiendom> {

	private String knr;
	private String gnr;
	private String bnr;
	private String fnr;
	private boolean serializeFnr;
	private String snr;
	private boolean serializeSnr;
	private String bruksnavn;
	private boolean serializeBruksnavn;

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

	@JsonProperty("fnr")
	public void setFnr(String fnr) {

		this.fnr = fnr;
		serializeFnr = true;
	}

	@JsonProperty("fnr")
	public Optional<String> getFnrAsOptional() {

		if (serializeFnr) {

			return Optional.ofNullable(fnr);
		}

		return null;
	}

	public String getSnr() {

		return snr;
	}

	@JsonProperty("snr")
	public void setSnr(String snr) {

		this.snr = snr;
		serializeSnr = true;
	}

	@JsonProperty("snr")
	public Optional<String> getSnrAsOptional() {

		if (serializeSnr) {

			return Optional.ofNullable(snr);
		}

		return null;
	}

	public String getBruksnavn() {

		return bruksnavn;
	}

	@JsonProperty("bruksnavn")
	public void setBruksnavn(String bruksnavn) {

		this.bruksnavn = bruksnavn;
		serializeBruksnavn = true;
	}

	@JsonProperty("bruksnavn")
	public Optional<String> getBruksnavnAsOptional() {

		if (serializeBruksnavn) {

			return Optional.ofNullable(bruksnavn);
		}

		return null;
	}
}
