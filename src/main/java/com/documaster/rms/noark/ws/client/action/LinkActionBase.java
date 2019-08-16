package com.documaster.rms.noark.ws.client.action;

import java.util.Arrays;
import java.util.List;

import com.documaster.rms.noark.ws.Argument;
import com.documaster.rms.noark.ws.noarkentities.NoarkEntityBase;

public abstract class LinkActionBase<TEntity extends NoarkEntityBase<TEntity>> extends Action {

	private String type;
	private String id;
	private String ref;
	protected List<String> refId;

	protected LinkActionBase(ActionName action, String id, String type, String refField, String... refId) {

		super(action);

		initialize(id, type, refField, refId);
	}

	protected LinkActionBase(ActionName action, TEntity entity, String refField, String... refId) {

		super(action);

		Argument.notNull("entity", entity);

		initialize(entity.getId(), entity.getClass().getSimpleName(), refField, refId);
	}

	private void initialize(String id, String type, String refField, String... refId) {

		Argument.notNullOrEmpty("id", id);
		Argument.notNullOrEmpty("refField", refField);
		Argument.notNullOrEmpty("linkToId", refId);

		this.id = id;
		this.type = type;
		this.ref = refField;
	}

	public String getType() {

		return type;
	}

	public String getId() {

		return id;
	}

	public String getRef() {

		return ref;
	}

	public abstract List<String> getRefId();

	protected abstract void setRefId(List<String> refId);

	protected void initializeRefId(String... linkToId) {

		for (String linkId : linkToId) {

			Argument.notNullOrEmpty("linktToId", linkId);
		}

		setRefId(Arrays.asList(linkToId));
	}
}
