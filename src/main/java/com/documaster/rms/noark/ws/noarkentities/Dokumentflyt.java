package com.documaster.rms.noark.ws.noarkentities;

import java.util.Date;
import java.util.Optional;

import com.documaster.rms.noark.ws.client.action.LinkAction;
import com.documaster.rms.noark.ws.constants.FlytStatus;
import com.documaster.rms.noark.ws.serialization.NoarkEnumJsonDeserializer;
import com.documaster.rms.noark.ws.serialization.NoarkEnumJsonSerializer;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Dokumentflyt extends NoarkEntityBase<Dokumentflyt> {

	public static final String JOURNALPOST_LINK = "refJournalpost";

	private String flytFra;
	private String flytFraBrukerIdent;
	private String flytTil;
	private String flytTilBrukerIdent;
	private Date flytMottattDato;
	private Date flytSendtDato;

	@JsonSerialize(using = NoarkEnumJsonSerializer.class)
	@JsonDeserialize(using = NoarkEnumJsonDeserializer.class)
	private FlytStatus flytStatus;

	private String flytMerknad;
	private boolean serializeFlytMerknad;

	public Dokumentflyt(
			String flytFra, String flytFraBrukerIdent, String flytTil, String flytTilBrukerIdent, Date flytMottattDato,
			Date flytSendtDato, FlytStatus flytStatus) {

		this.flytFra = flytFra;
		this.flytFraBrukerIdent = flytFraBrukerIdent;
		this.flytTil = flytTil;
		this.flytTilBrukerIdent = flytTilBrukerIdent;
		this.flytMottattDato = flytMottattDato;
		this.flytSendtDato = flytSendtDato;
		this.flytStatus = flytStatus;
	}

	@JsonCreator
	private Dokumentflyt(
			@JsonProperty("id") String id,
			@JsonProperty("uuid") String uuid,
			@JsonProperty("version") String version) {

		super(id, uuid, version);
	}

	public String getFlytFra() {

		return flytFra;
	}

	public void setFlytFra(String flytFra) {

		this.flytFra = flytFra;
	}

	public String getFlytFraBrukerIdent() {

		return flytFraBrukerIdent;
	}

	public void setFlytFraBrukerIdent(String flytFraBrukerIdent) {

		this.flytFraBrukerIdent = flytFraBrukerIdent;
	}

	public String getFlytTil() {

		return flytTil;
	}

	public void setFlytTil(String flytTil) {

		this.flytTil = flytTil;
	}

	public String getFlytTilBrukerIdent() {

		return flytTilBrukerIdent;
	}

	public void setFlytTilBrukerIdent(String flytTilBrukerIdent) {

		this.flytTilBrukerIdent = flytTilBrukerIdent;
	}

	public Date getFlytMottattDato() {

		return flytMottattDato;
	}

	public void setFlytMottattDato(Date flytMottattDato) {

		this.flytMottattDato = flytMottattDato;
	}

	public Date getFlytSendtDato() {

		return flytSendtDato;
	}

	public void setFlytSendtDato(Date flytSendtDato) {

		this.flytSendtDato = flytSendtDato;
	}

	public FlytStatus getFlytStatus() {

		return flytStatus;
	}

	public void setFlytStatus(FlytStatus flytStatus) {

		this.flytStatus = flytStatus;
	}

	public String getFlytMerknad() {

		return flytMerknad;
	}

	@JsonProperty("flytMerknad")
	public void setFlytMerknad(String flytMerknad) {

		this.flytMerknad = flytMerknad;
		serializeFlytMerknad = true;
	}

	@JsonProperty("flytMerknad")
	public Optional<String> getFlytMerknadAsOptional() {

		if (serializeFlytMerknad) {

			return Optional.ofNullable(flytMerknad);
		}

		return null;
	}

	public LinkAction<Dokumentflyt> linkJournalpost(String journalpostId) {

		return link(JOURNALPOST_LINK, journalpostId);
	}

	public LinkAction<Dokumentflyt> linkJournalpost(Journalpost journalpost) {

		return link(JOURNALPOST_LINK, journalpost);
	}
}
