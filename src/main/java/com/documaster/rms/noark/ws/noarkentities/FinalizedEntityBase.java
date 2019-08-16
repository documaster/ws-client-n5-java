package com.documaster.rms.noark.ws.noarkentities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class FinalizedEntityBase<TEntity extends FinalizedEntityBase<TEntity>>
		extends NoarkEntityBase<TEntity> {

	private Date avsluttetDato;
	private String avsluttetAv;
	private String avsluttetAvBrukerIdent;

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

	public void setAvsluttetDato(Date avsluttetDato) {

		this.avsluttetDato = avsluttetDato;
	}

	public String getAvsluttetAv() {

		return avsluttetAv;
	}

	public void setAvsluttetAv(String avsluttetAv) {

		this.avsluttetAv = avsluttetAv;
	}

	public String getAvsluttetAvBrukerIdent() {

		return avsluttetAvBrukerIdent;
	}

	public void setAvsluttetAvBrukerIdent(String avsluttetAvBrukerIdent) {

		this.avsluttetAvBrukerIdent = avsluttetAvBrukerIdent;
	}
}
