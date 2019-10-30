package com.documaster.rms.noark.ws.client.query;

import java.util.Collections;
import java.util.Date;

import com.documaster.rms.noark.ws.Argument;
import com.documaster.rms.noark.ws.client.HttpMethod;
import com.documaster.rms.noark.ws.client.HttpService;
import com.documaster.rms.noark.ws.client.NoarkClient;
import com.documaster.rms.noark.ws.client.RmsClient;
import com.documaster.rms.noark.ws.client.handlers.BeanResponseHandler;
import com.documaster.rms.noark.ws.client.handlers.ErrorResponseHandler;
import com.documaster.rms.noark.ws.noarkentities.NoarkEntity;

public class Query<TEntity extends NoarkEntity> extends HttpService<RmsClient> {

	private final NoarkQuery<TEntity> query;

	public Query(RmsClient client, Class<TEntity> entityClass, int limit) {

		super(client);
		this.query = new NoarkQuery<>(entityClass, limit);
	}

	public Query(RmsClient client, Class<TEntity> entityClass, String query, int limit) {

		super(client);
		this.query = new NoarkQuery<>(entityClass, query, limit);
	}

	public int getOffset() {

		return this.query.getOffset();
	}

	public Query<TEntity> setOffset(int offset) {

		if (offset < 0) {

			Argument.assertFail("offset", "Value should be equal or greater than 0");
		}

		this.query.setOffset(offset);

		return this;
	}

	public Query<TEntity> setPublicUse(boolean publicUse) {

		this.query.setPublicUse(publicUse);
		return this;
	}

	public boolean getPublicUse() {

		return this.query.getPublicUse();
	}

	public Query<TEntity> addQueryParam(String paramName, String paramValue) {

		this.query.getParameters().add(new QueryParam(paramName, paramValue));
		return this;
	}

	public Query<TEntity> addQueryParam(String paramName, int paramValue) {

		this.query.getParameters().add(new QueryParam(paramName, paramValue));
		return this;
	}

	public Query<TEntity> addQueryParam(String paramName, long paramValue) {

		this.query.getParameters().add(new QueryParam(paramName, paramValue));
		return this;
	}

	public Query<TEntity> addQueryParam(String paramName, Date paramValue) {

		this.query.getParameters().add(new QueryParam(paramName, paramValue));
		return this;
	}

	public Query<TEntity> addQueryParams(QueryParam... queryParams) {

		Collections.addAll(this.query.getParameters(), queryParams);
		return this;
	}

	public Query<TEntity> addSortOrder(String field) {

		addSortOrder(field, Order.ASCENDING);
		return this;
	}

	public Query<TEntity> addSortOrder(String field, Order order) {

		this.query.getSortOrder().add(new SortOrder(field, order));
		return this;
	}

	public Query<TEntity> addSortOrders(SortOrder... sortOrders) {

		Collections.addAll(this.query.getSortOrder(), sortOrders);
		return this;
	}

	public QueryResponse<TEntity> execute() {

		ErrorResponseHandler errorHandler =
				new ErrorResponseHandler(getClient().getMapper(), getClient().getErrorResponseType());

		return call(getClient().getServerAddress(), NoarkClient.QUERY_PATH, HttpMethod.POST, this.query,
				new BeanResponseHandler<>(getClient().getMapper(), QueryResponse.class, errorHandler)).getBean();
	}
}
