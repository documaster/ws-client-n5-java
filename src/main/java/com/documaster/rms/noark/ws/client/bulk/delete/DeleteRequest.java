package com.documaster.rms.noark.ws.client.bulk.delete;

import com.documaster.rms.noark.ws.client.Bean;
import com.documaster.rms.noark.ws.noarkentities.NoarkEntity;

public class DeleteRequest implements Bean {

	private final String type;
	private final String id;
	private final String version;
	private final boolean deleteObjectsLinkedToPrecedents;

	public DeleteRequest(NoarkEntity entity) {

		this(entity, false);
	}

	public DeleteRequest(NoarkEntity entity, boolean deleteObjectsLinkedToPrecedents) {

		this.type = entity.getClass().getSimpleName();
		this.id = entity.getId();
		this.version = entity.getVersion();
		this.deleteObjectsLinkedToPrecedents = deleteObjectsLinkedToPrecedents;
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

	public boolean isDeleteObjectsLinkedToPrecedents() {

		return deleteObjectsLinkedToPrecedents;
	}
}
