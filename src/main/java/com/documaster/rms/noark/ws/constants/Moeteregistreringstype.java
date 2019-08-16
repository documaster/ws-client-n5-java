package com.documaster.rms.noark.ws.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Moeteregistreringstype extends NoarkEnum {

	public static final Moeteregistreringstype MOETEINKALLING = new Moeteregistreringstype("MI", "Møteinnkalling");
	public static final Moeteregistreringstype VEDLEGG_TIL_MOETESAK =
			new Moeteregistreringstype("VL", "Vedlegg til møtesak");
	public static final Moeteregistreringstype VEDTAK_I_MOETESAK =
			new Moeteregistreringstype("D", "Vedtak i møtesak");
	public static final Moeteregistreringstype NOTAT_TIL_POLITISK_UTVALG =
			new Moeteregistreringstype("N", "Notat til politisk utvalg");
	public static final Moeteregistreringstype SAKSLISTE = new Moeteregistreringstype("SL", "Saksliste");
	public static final Moeteregistreringstype MOETEBOK = new Moeteregistreringstype("B", "Møtebok");
	public static final Moeteregistreringstype MOETEPROTOKOLL = new Moeteregistreringstype("MP", "Møteprotokoll");
	public static final Moeteregistreringstype MOETEREFERAT = new Moeteregistreringstype("M", "Møtereferat");
	public static final Moeteregistreringstype SAKSPROTOKOLL = new Moeteregistreringstype("SP", "Saksprotokoll");
	public static final Moeteregistreringstype OVERSIKT_OVER_DELTAKERE = new Moeteregistreringstype(
			"O",
			"Oversikt over deltakere, representanter og medlemmer i utvalg, råd og møter");
	public static final Moeteregistreringstype SAKSFRAMLEGG = new Moeteregistreringstype("SF", "Saksframlegg");

	public Moeteregistreringstype(String code) {

		super(code);
	}

	public Moeteregistreringstype(String code, String name) {

		super(code, name);
	}

	@JsonCreator
	public Moeteregistreringstype(
			@JsonProperty("code") String code,
			@JsonProperty("name") String name,
			@JsonProperty("description") String description) {

		super(code, name, description);
	}
}
