package com.documaster.rms.noark.ws.client.transaction;

import java.util.LinkedList;
import java.util.List;

import com.documaster.rms.noark.ws.client.Bean;
import com.documaster.rms.noark.ws.client.action.Action;

public class TransactionRequest implements Bean {

	private final List<Action> actions = new LinkedList<>();

	public List<Action> getActions() {

		return actions;
	}
}
