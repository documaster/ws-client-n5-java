package com.documaster.rms.noark.ws.client.action;

import java.util.List;

import com.documaster.rms.noark.ws.noarkentities.NoarkEntityBase;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LinkAction<TEntity extends NoarkEntityBase<TEntity>> extends LinkActionBase<TEntity> {

	public LinkAction(TEntity entity, String refField, String... linkToId) {

		super(ActionName.LINK, entity, refField, linkToId);

		initializeRefId(linkToId);
	}

	public LinkAction(String id, String type, String refField, String... linkToId) {

		super(ActionName.LINK, id, type, refField, linkToId);

		initializeRefId(linkToId);
	}

	@JsonProperty("linkToId")
	@Override
	public List<String> getRefId() {

		return refId;
	}

	@Override
	protected void setRefId(List<String> refId) {

		this.refId = refId;
	}
}
