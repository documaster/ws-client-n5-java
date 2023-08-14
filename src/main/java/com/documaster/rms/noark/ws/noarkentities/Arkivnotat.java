package com.documaster.rms.noark.ws.noarkentities;

import com.documaster.rms.noark.ws.client.action.LinkAction;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Arkivnotat extends RegistreringBase<Arkivnotat> {

	public static final String DOKUMENTFLYT_LINK = "refArkivnotatDokumentflyt";

	public Arkivnotat(String tittel) {

		setTittel(tittel);
	}

	@JsonCreator
	private Arkivnotat(
			@JsonProperty("id") String id,
			@JsonProperty("uuid") String uuid,
			@JsonProperty("version") String version) {

		super(id, uuid, version);
	}

	public LinkAction<Arkivnotat> linkDokumentflyt(String... dokumentflytIds) {

		return link(DOKUMENTFLYT_LINK, dokumentflytIds);
	}

	public LinkAction<Arkivnotat> linkDokumentflyt(Dokumentflyt... dokumentflyts) {

		return link(DOKUMENTFLYT_LINK, dokumentflyts);
	}
}
