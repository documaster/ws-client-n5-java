package com.documaster.rms.noark.ws.client.action;

import java.util.List;

import com.documaster.rms.noark.ws.noarkentities.NoarkEntityBase;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UnlinkAction<TEntity extends NoarkEntityBase<TEntity>> extends LinkActionBase<TEntity> {

	public UnlinkAction(TEntity entity, String refField, String... unlinkFromId) {

		super(ActionName.UNLINK, entity, refField, unlinkFromId);

		initializeRefId(unlinkFromId);
	}

	public UnlinkAction(String id, String type, String refField, String... unlinkFromId) {

		super(ActionName.UNLINK, id, type, refField, unlinkFromId);

		initializeRefId(unlinkFromId);
	}

	@JsonProperty("unlinkFromId")
	@Override
	public List<String> getRefId() {

		return refId;
	}

	@Override
	protected void setRefId(List<String> refId) {

		this.refId = refId;
	}
}
