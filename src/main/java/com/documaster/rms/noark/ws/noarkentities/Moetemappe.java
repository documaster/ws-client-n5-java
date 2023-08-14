package com.documaster.rms.noark.ws.noarkentities;

import java.util.Date;
import java.util.Optional;

import com.documaster.rms.noark.ws.client.action.LinkAction;
import com.documaster.rms.noark.ws.client.action.UnlinkAction;
import com.documaster.rms.noark.ws.serialization.CustomDateFormat;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Moetemappe extends MappeBase<Moetemappe> {

	public static final String MOETEDELTALKER_LINK = "refMoetedeltaker";

	private String moetenummer;
	private String utvalg;
	private String moetested;
	private boolean serializeMoetested;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = CustomDateFormat.DATE)
	private Date moetedato;

	public Moetemappe(String tittel, String moetenummer, String utvalg, String moetested, Date moetedato) {

		setTittel(tittel);
		this.moetenummer = moetenummer;
		this.utvalg = utvalg;
		this.moetested = moetested;
		this.moetedato = moetedato;
	}

	@JsonCreator
	private Moetemappe(
			@JsonProperty("id") String id,
			@JsonProperty("uuid") String uuid,
			@JsonProperty("version") String version) {

		super(id, uuid, version);
	}

	public String getMoetenummer() {

		return moetenummer;
	}

	public void setMoetenummer(String moetenummer) {

		this.moetenummer = moetenummer;
	}

	public String getUtvalg() {

		return utvalg;
	}

	public void setUtvalg(String utvalg) {

		this.utvalg = utvalg;
	}

	public String getMoetested() {

		return moetested;
	}

	@JsonProperty("moetested")
	public void setMoetested(String moetested) {

		this.moetested = moetested;
		serializeMoetested = true;
	}

	@JsonProperty("moetested")
	public Optional<String> getMoetestedAsOptional() {

		if (serializeMoetested) {

			return Optional.ofNullable(moetested);
		}

		return null;
	}

	public Date getMoetedato() {

		return moetedato;
	}

	public void setMoetedato(Date moetedato) {

		this.moetedato = moetedato;
	}

	public LinkAction<Moetemappe> linkRegistrering(String... moeteregistreringIds) {

		return link(REGISTRERING_LINK, moeteregistreringIds);
	}

	public LinkAction<Moetemappe> linkRegistrering(Moeteregistrering... moeteregistrering) {

		return link(REGISTRERING_LINK, moeteregistrering);
	}

	public UnlinkAction<Moetemappe> unlinkRegistrering(String... moeteregistreringIds) {

		return unlink(REGISTRERING_LINK, moeteregistreringIds);
	}

	public UnlinkAction<Moetemappe> unlinkRegistrering(AbstraktRegistrering... moeteregistrering) {

		return unlink(REGISTRERING_LINK, moeteregistrering);
	}

	public LinkAction<Moetemappe> linkMoetedeltaker(String... moetedetalkerIds) {

		return link(MOETEDELTALKER_LINK, moetedetalkerIds);
	}

	public LinkAction<Moetemappe> linkMoetedeltaker(Moetedeltaker... moetedeltaker) {

		return link(MOETEDELTALKER_LINK, moetedeltaker);
	}
}
