package com.documaster.rms.noark.ws.noarkentities;

import java.util.Optional;

import com.documaster.rms.noark.ws.constants.Kassasjonshjemmel;
import com.documaster.rms.noark.ws.constants.Kassasjonsvedtak;
import com.documaster.rms.noark.ws.serialization.NoarkEnumJsonDeserializer;
import com.documaster.rms.noark.ws.serialization.NoarkOptionalEnumJsonSerializer;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public abstract class DisposableFinalizedEntityBase<TEntity extends DisposableFinalizedEntityBase<TEntity>>
		extends FinalizedEntityBase<TEntity> {

	@JsonSerialize(using = NoarkOptionalEnumJsonSerializer.class)
	@JsonDeserialize(using = NoarkEnumJsonDeserializer.class)
	private Kassasjonsvedtak kassasjonsvedtak;

	private boolean serializeKassasjonsvedtak;

	@JsonSerialize(using = NoarkOptionalEnumJsonSerializer.class)
	@JsonDeserialize(using = NoarkEnumJsonDeserializer.class)
	private Kassasjonshjemmel kassasjonshjemmel;

	private boolean serializeKassasjonshjemmel;

	private Integer bevaringstid;
	private boolean serializeBevaringstid;

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

	@JsonProperty("kassasjonsvedtak")
	public void setKassasjonsvedtak(Kassasjonsvedtak kassasjonsvedtak) {

		this.kassasjonsvedtak = kassasjonsvedtak;
		serializeKassasjonsvedtak = true;
	}

	@JsonProperty("kassasjonsvedtak")
	public Optional<Kassasjonsvedtak> getKassasjonsvedtakAsOptional() {

		if (serializeKassasjonsvedtak) {

			return Optional.ofNullable(kassasjonsvedtak);
		}

		return null;
	}

	public Kassasjonshjemmel getKassasjonshjemmel() {

		return kassasjonshjemmel;
	}

	@JsonProperty("kassasjonshjemmel")
	public void setKassasjonshjemmel(Kassasjonshjemmel kassasjonshjemmel) {

		this.kassasjonshjemmel = kassasjonshjemmel;
		serializeKassasjonshjemmel = true;
	}

	@JsonProperty("kassasjonshjemmel")
	public Optional<Kassasjonshjemmel> getKassasjonshjemmelAsOptional() {

		if (serializeKassasjonshjemmel) {

			return Optional.ofNullable(kassasjonshjemmel);
		}

		return null;
	}

	public Integer getBevaringstid() {

		return bevaringstid;
	}

	@JsonProperty("bevaringstid")
	public void setBevaringstid(Integer bevaringstid) {

		this.bevaringstid = bevaringstid;
		serializeBevaringstid = true;
	}

	@JsonProperty("bevaringstid")
	public Optional<Integer> getBevaringstidAsOptional() {

		if (serializeBevaringstid) {

			return Optional.ofNullable(bevaringstid);
		}

		return null;
	}
}
