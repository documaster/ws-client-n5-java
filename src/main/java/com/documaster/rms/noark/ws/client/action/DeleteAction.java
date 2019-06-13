package com.documaster.rms.noark.ws.client.action;

import com.documaster.rms.noark.ws.noarkentities.NoarkEntity;

public class DeleteAction extends Action {

	private final String type;
	private final String id;
	private final String version;

	public DeleteAction(String type, String id) {

		this(type, id, null);
	}

	public DeleteAction(NoarkEntity noarkEntity) {

		this(noarkEntity.getClass().getSimpleName(), noarkEntity.getId(), noarkEntity.getVersion());
	}

	public DeleteAction(String type, String id, String version) {

		super(ActionName.DELETE);

		this.type = type;
		this.id = id;
		this.version = version;
	}

	public String getType() {

		return type;
	}

	public String getId() {

		return id;
	}

	public String getVersion() {

		return version;
	}
}
