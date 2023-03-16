package com.documaster.rms.noark.ws.noarkentities;

import java.util.Date;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class FinalizedEntityBase<TEntity extends FinalizedEntityBase<TEntity>>
		extends NoarkEntityBase<TEntity> {

	private Date avsluttetDato;
	private boolean serializeAvsluttetDato;
	private String avsluttetAv;
	private boolean serializeAvsluttetAv;
	private String avsluttetAvBrukerIdent;
	private boolean serializeAvsluttetAvBrukerIdent;

	protected FinalizedEntityBase() {

	}

	@JsonCreator
	protected FinalizedEntityBase(
			@JsonProperty("id") String id,
			@JsonProperty("uuid") String uuid,
			@JsonProperty("version") String version) {

		super(id, uuid, version);
	}

	public Date getAvsluttetDato() {

		return avsluttetDato;
	}

	@JsonProperty("avsluttetDato")
	public void setAvsluttetDato(Date avsluttetDato) {

		this.avsluttetDato = avsluttetDato;
		serializeAvsluttetDato = true;
	}

	@JsonProperty("avsluttetDato")
	public Optional<Date> getAvsluttetDatoAsOptional() {

		if (serializeAvsluttetDato) {

			return Optional.ofNullable(avsluttetDato);
		}

		return null;
	}

	public String getAvsluttetAv() {

		return avsluttetAv;
	}

	@JsonProperty("avsluttetAv")
	public void setAvsluttetAv(String avsluttetAv) {

		this.avsluttetAv = avsluttetAv;
		serializeAvsluttetAv = true;
	}

	@JsonProperty("avsluttetAv")
	public Optional<String> getAvsluttetAvAsOptional() {

		if (serializeAvsluttetAv) {

			return Optional.ofNullable(avsluttetAv);
		}

		return null;
	}

	public String getAvsluttetAvBrukerIdent() {

		return avsluttetAvBrukerIdent;
	}

	@JsonProperty("avsluttetAvBrukerIdent")
	public void setAvsluttetAvBrukerIdent(String avsluttetAvBrukerIdent) {

		this.avsluttetAvBrukerIdent = avsluttetAvBrukerIdent;
		serializeAvsluttetAvBrukerIdent = true;
	}

	@JsonProperty("avsluttetAvBrukerIdent")
	public Optional<String> getAvsluttetAvBrukerIdentAsOptional() {

		if (serializeAvsluttetAvBrukerIdent) {

			return Optional.ofNullable(avsluttetAvBrukerIdent);
		}

		return null;
	}
}
