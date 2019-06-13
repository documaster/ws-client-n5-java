package com.documaster.rms.noark.ws.client.bsm;

import java.util.List;

public class BsmGroupInfo extends BsmGroup {

	private List<BsmField> fields;

	public List<BsmField> getFields() {

		return fields;
	}

	private void setFields(List<BsmField> fields) {

		this.fields = fields;
	}
}
