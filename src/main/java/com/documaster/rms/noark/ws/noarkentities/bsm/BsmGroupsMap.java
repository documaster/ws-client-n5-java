package com.documaster.rms.noark.ws.noarkentities.bsm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import com.documaster.rms.noark.ws.Argument;

public class BsmGroupsMap extends HashMap<String, BsmFieldsMap> {

	public boolean addBsmFieldValues(String groupId, String fieldId, Object... values) {

		Argument.notNullOrEmpty("groupId", groupId);
		Argument.notNullOrEmpty("fieldId", fieldId);
		Argument.notNullOrEmpty("values", values);

		BsmFieldsMap groupFields = computeIfAbsent(groupId, key -> new BsmFieldsMap());
		if (groupFields.containsKey(fieldId)) {

			return false;
		}

		groupFields.put(fieldId, new BsmFieldValues(new HashSet<>(Arrays.asList(values))));
		return true;
	}

	public boolean updateBsmFieldValues(String groupId, String fieldId, Object... values) {

		Argument.notNullOrEmpty("groupId", groupId);
		Argument.notNullOrEmpty("fieldId", fieldId);
		Argument.notNullOrEmpty("values", values);

		if (!containsKey(groupId)) {

			return false;
		}

		BsmFieldsMap groupFields = get(groupId);
		if (!groupFields.containsKey(fieldId)) {

			return false;
		}

		groupFields.put(fieldId, new BsmFieldValues(new HashSet<>(Arrays.asList(values))));
		return true;
	}

	public boolean deleteBsmGroup(String groupId) {

		Argument.notNullOrEmpty("groupId", groupId);

		if (!containsKey(groupId)) {

			return false;
		}

		put(groupId, new BsmFieldsMap());
		return true;
	}

	public boolean deleteBsmField(String groupId, String fieldId) {

		Argument.notNullOrEmpty("groupId", groupId);
		Argument.notNullOrEmpty("fieldId", fieldId);

		if (!containsKey(groupId)) {

			return false;
		}

		BsmFieldsMap groupFields = get(groupId);
		if (!groupFields.containsKey(fieldId)) {

			return false;
		}

		groupFields.put(fieldId, new BsmFieldValues());
		return true;
	}

	public boolean deleteBsmFieldValue(String groupId, String fieldId, Object value) {

		Argument.notNullOrEmpty("groupId", groupId);
		Argument.notNullOrEmpty("fieldId", fieldId);
		Argument.notNull("value", value);

		if (!containsKey(groupId)) {

			return false;
		}

		BsmFieldsMap groupFields = get(groupId);
		if (!groupFields.containsKey(fieldId)) {

			return false;
		}

		return groupFields.get(fieldId).getValues().remove(value);
	}
}
