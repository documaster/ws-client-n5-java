package com.documaster.rms.noark.ws.noarkentities;

import com.documaster.rms.noark.ws.constants.Kassasjonshjemmel;
import com.documaster.rms.noark.ws.constants.Kassasjonsvedtak;
import com.documaster.rms.noark.ws.serialization.NoarkEnumJsonDeserializer;
import com.documaster.rms.noark.ws.serialization.NoarkEnumJsonSerializer;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public abstract class DisposableFinalizedEntityBase<TEntity extends DisposableFinalizedEntityBase<TEntity>>
		extends FinalizedEntityBase<TEntity> {

	@JsonSerialize(using = NoarkEnumJsonSerializer.class)
	@JsonDeserialize(using = NoarkEnumJsonDeserializer.class)
	private Kassasjonsvedtak kassasjonsvedtak;

	@JsonSerialize(using = NoarkEnumJsonSerializer.class)
	@JsonDeserialize(using = NoarkEnumJsonDeserializer.class)
	private Kassasjonshjemmel kassasjonshjemmel;

	private Integer bevaringstid;

	protected DisposableFinalizedEntityBase() {

	}

	@JsonCreator
	protected DisposableFinalizedEntityBase(
			@JsonProperty("id") String id,
			@JsonProperty("uuid") String uuid,
			@JsonProperty("version") String version) {

		super(id, uuid, version);
	}

	public Kassasjonsvedtak getKassasjonsvedtak() {

		return kassasjonsvedtak;
	}

	public void setKassasjonsvedtak(Kassasjonsvedtak kassasjonsvedtak) {

		this.kassasjonsvedtak = kassasjonsvedtak;
	}

	public Kassasjonshjemmel getKassasjonshjemmel() {

		return kassasjonshjemmel;
	}

	public void setKassasjonshjemmel(Kassasjonshjemmel kassasjonshjemmel) {

		this.kassasjonshjemmel = kassasjonshjemmel;
	}

	public Integer getBevaringstid() {

		return bevaringstid;
	}

	public void setBevaringstid(Integer bevaringstid) {

		this.bevaringstid = bevaringstid;
	}
}
