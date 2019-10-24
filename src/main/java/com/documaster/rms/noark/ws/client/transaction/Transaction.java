package com.documaster.rms.noark.ws.client.transaction;

import com.documaster.rms.noark.ws.Argument;
import com.documaster.rms.noark.ws.client.HttpMethod;
import com.documaster.rms.noark.ws.client.HttpService;
import com.documaster.rms.noark.ws.client.NoarkClient;
import com.documaster.rms.noark.ws.client.RmsClient;
import com.documaster.rms.noark.ws.client.action.DeleteAction;
import com.documaster.rms.noark.ws.client.action.LinkAction;
import com.documaster.rms.noark.ws.client.action.SaveAction;
import com.documaster.rms.noark.ws.client.action.UnlinkAction;
import com.documaster.rms.noark.ws.client.handlers.BeanResponseHandler;
import com.documaster.rms.noark.ws.client.handlers.ErrorResponseHandler;
import com.documaster.rms.noark.ws.noarkentities.NoarkEntity;
import com.documaster.rms.noark.ws.noarkentities.NoarkEntityBase;

public class Transaction extends HttpService<RmsClient> {

	private final TransactionRequest req = new TransactionRequest();

	public Transaction(RmsClient client) {

		super(client);
	}

	public <TEntity extends NoarkEntity> Transaction save(TEntity noarkEntity) {

		this.req.getActions().add(new SaveAction(noarkEntity));

		return this;
	}

	public <TEntity extends NoarkEntityBase<TEntity>> Transaction link(LinkAction<TEntity> link) {

		Argument.notNull("link", link);

		this.req.getActions().add(link);

		return this;
	}

	public <TEntity extends NoarkEntityBase<TEntity>> Transaction unlink(UnlinkAction<TEntity> unlink) {

		Argument.notNull("unlink", unlink);

		this.req.getActions().add(unlink);

		return this;
	}

	public TransactionResponse commit() {

		ErrorResponseHandler errorHandler =
				new ErrorResponseHandler(getClient().getMapper(), getClient().getErrorResponseType());

		return call(getClient().getServerAddress(), NoarkClient.TRANSACTION_ACTION_PATH, HttpMethod.POST, this.req,
				new BeanResponseHandler<>(getClient().getMapper(), TransactionResponse.class, errorHandler)).getBean();
	}

	public <TEntity extends NoarkEntity> Transaction delete(TEntity noarkEntity) {

		Argument.notNull("noarkEntity", noarkEntity);

		this.req.getActions().add(new DeleteAction(noarkEntity));

		return this;
	}

	public Transaction delete(String type, String id) {

		Argument.notNullOrEmpty("id", id);
		Argument.notNullOrEmpty("type", id);

		this.req.getActions().add(new DeleteAction(type, id));

		return this;
	}

	public Transaction delete(String type, String id, String version) {

		Argument.notNullOrEmpty("id", type);
		Argument.notNullOrEmpty("type", id);
		Argument.notNullOrEmpty("version", version);

		this.req.getActions().add(new DeleteAction(type, id, version));

		return this;
	}
}
