package com.documaster.rms.noark.ws.client.action;

import com.documaster.rms.noark.ws.Argument;
import com.documaster.rms.noark.ws.noarkentities.NoarkEntity;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SaveAction extends Action {

	@JsonProperty("fields")
	private final NoarkEntity entity;

	public SaveAction(NoarkEntity entity) {

		super(ActionName.SAVE);

		Argument.notNull("entity", entity);
		this.entity = entity;
	}

	public String getId() {

		return entity.getId();
	}

	public String getType() {

		return entity.getClass().getSimpleName();
	}

	public String getVersion() {

		return entity.getVersion();
	}

	public NoarkEntity getEntity() {

		return entity;
	}
}
