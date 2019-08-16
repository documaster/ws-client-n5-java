package com.documaster.rms.noark.ws.client.query;

import com.documaster.rms.noark.ws.Argument;

public class SortOrder {

	private String field;
	private Order order = Order.ASCENDING;

	public SortOrder(String field) {

		setField(field);
	}

	public SortOrder(String field, Order order) {

		this(field);
		setOrder(order);
	}

	public String getField() {

		return field;
	}

	private void setField(String field) {

		Argument.notNullOrEmpty("field", field);
		this.field = field;
	}

	public Order getOrder() {

		return order;
	}

	public void setOrder(Order order) {

		Argument.notNull("order", order);
		this.order = order;
	}
}
