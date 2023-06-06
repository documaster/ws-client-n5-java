package com.documaster.rms.noark.ws.noarkentities;

import com.documaster.rms.noark.ws.client.action.LinkAction;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class PersonIdentifikator<TEntity extends PersonIdentifikator<TEntity>>
		extends NoarkEntityBase<TEntity> {

	public static final String MAPPE_LINK = "refMappe";
	public static final String REGISTRERING_LINK = "refRegistrering";

	protected PersonIdentifikator() {

	}

	@JsonCreator
	protected PersonIdentifikator(
			@JsonProperty("id") String id,
			@JsonProperty("uuid") String uuid,
			@JsonProperty("version") String version) {

		super(id, uuid, version);
	}

	public LinkAction<TEntity> linkMappe(String mappeId) {

		return link(MAPPE_LINK, mappeId);
	}

	public LinkAction<TEntity> linkMappe(AbstraktMappe mappe) {

		return link(MAPPE_LINK, mappe);
	}

	public LinkAction<TEntity> linkRegistrering(String registreringId) {

		return link(REGISTRERING_LINK, registreringId);
	}

	public LinkAction<TEntity> linkRegistrering(AbstraktRegistrering registrering) {

		return link(REGISTRERING_LINK, registrering);
	}

	@JsonIgnore
	public String getRefMappe() {

		return getRef(MAPPE_LINK);
	}

	@JsonIgnore
	public String getRefRegistrering() {

		return getRef(REGISTRERING_LINK);
	}
}
