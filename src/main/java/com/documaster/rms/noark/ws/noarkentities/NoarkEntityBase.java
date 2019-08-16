package com.documaster.rms.noark.ws.noarkentities;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import com.documaster.rms.noark.ws.Argument;
import com.documaster.rms.noark.ws.client.action.LinkAction;
import com.documaster.rms.noark.ws.client.action.UnlinkAction;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class NoarkEntityBase<TEntity extends NoarkEntityBase<TEntity>> implements NoarkEntity {

	private final String id;
	private final String uuid;
	private final String version;

	private Date opprettetDato;
	private String opprettetAv;
	private String opprettetAvBrukerIdent;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Map<String, String> links;

	protected NoarkEntityBase() {

		this(UUID.randomUUID().toString(), null, null);
	}

	@JsonCreator
	protected NoarkEntityBase(
			@JsonProperty("id") String id,
			@JsonProperty("uuid") String uuid,
			@JsonProperty("version") String version) {

		this.id = id;
		this.uuid = uuid;
		this.version = version;
	}

	@Override
	public String getId() {

		return id;
	}

	@JsonIgnore
	public String getUuid() {

		return uuid;
	}

	@Override
	public String getVersion() {

		return version;
	}

	public Date getOpprettetDato() {

		return opprettetDato;
	}

	public void setOpprettetDato(Date opprettetDato) {

		this.opprettetDato = opprettetDato;
	}

	public String getOpprettetAv() {

		return opprettetAv;
	}

	public void setOpprettetAv(String opprettetAv) {

		this.opprettetAv = opprettetAv;
	}

	public String getOpprettetAvBrukerIdent() {

		return opprettetAvBrukerIdent;
	}

	public void setOpprettetAvBrukerIdent(String opprettetAvBrukerIdent) {

		this.opprettetAvBrukerIdent = opprettetAvBrukerIdent;
	}

	protected String getRef(String refName) {

		return links != null ? links.get(refName) : null;
	}

	protected LinkAction<TEntity> link(String refField, String... linkToIds) {

		Argument.notNullOrEmpty("linkToIds", linkToIds);

		// The cast is safe the way we use it - TEntity is always of the same type as this.
		@SuppressWarnings("unchecked")
		TEntity entity = (TEntity) this;

		return new LinkAction<>(entity, refField, linkToIds);
	}

	protected LinkAction<TEntity> link(String refField, NoarkEntity... linkToEntities) {

		Argument.notNullOrEmpty("linkToEntities", linkToEntities);

		String[] linkToIds = Arrays.stream(linkToEntities)
				.map(linkEntity -> linkEntity.getId())
				.toArray(size -> new String[size]);

		return link(refField, linkToIds);
	}

	protected UnlinkAction<TEntity> unlink(String refField, String... unlinkFromIds) {

		Argument.notNullOrEmpty("unlinkFromIds", unlinkFromIds);

		// The cast is safe the way we use it - TEntity is always of the same type as this.
		@SuppressWarnings("unchecked")
		TEntity entity = (TEntity) this;

		return new UnlinkAction<>(entity, refField, unlinkFromIds);
	}

	protected UnlinkAction<TEntity> unlink(String refField, NoarkEntity... unlinkEntities) {

		Argument.notNullOrEmpty("unlinkEntities", unlinkEntities);

		String[] unlinkFromIds = Arrays.stream(unlinkEntities)
				.map(unlinkEntity -> unlinkEntity.getId())
				.toArray(size -> new String[size]);

		return unlink(refField, unlinkFromIds);
	}
}
