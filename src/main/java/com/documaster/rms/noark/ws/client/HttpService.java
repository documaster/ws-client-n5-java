package com.documaster.rms.noark.ws.client;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import javax.net.ssl.HostnameVerifier;

import com.documaster.rms.noark.ws.StringUtils;
import com.documaster.rms.noark.ws.client.exceptions.ClientConfigurationException;
import com.documaster.rms.noark.ws.client.exceptions.ServiceException;
import com.documaster.rms.noark.ws.client.handlers.Response;
import com.documaster.rms.noark.ws.codec.RFC5987Codec;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.conn.ssl.DefaultHostnameVerifier;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.ssl.SSLContextBuilder;

public abstract class HttpService<TC extends HttpClient> {

	private static final String HEADER_AUTHORIZATION = "Authorization";
	private static final String AUTHORIZATION_PREFIX = "Bearer ";

	private static final String HEADER_ERROR_RESPONSE_TYPE = "X-Documaster-Error-Response-Type";

	private final TC client;
	private final CloseableHttpClient sslClient;

	public HttpService(TC client) {

		if (client == null) {

			throw new IllegalArgumentException("client");
		}

		this.client = client;
		this.sslClient = getSslClient(this.client);
	}

	private CloseableHttpClient getSslClient(TC client) {

		try {

			final SSLContextBuilder sslContextBuilder = new SSLContextBuilder();
			if (StringUtils.isNotBlank(client.getKeystorePath())) {

				sslContextBuilder.loadKeyMaterial(
						new File(client.getKeystorePath()), client.getKeystorePassword(),
						client.getKeystorePassword());
			}

			if (StringUtils.isNotBlank(client.getTruststorePath())) {

				sslContextBuilder
						.loadTrustMaterial(new File(client.getTruststorePath()), client.getTruststorePassword());
			}

			HostnameVerifier hostnameVerifier = client.getTrustSelfSignedCerts()
												? new NoopHostnameVerifier() : new DefaultHostnameVerifier();

			SSLConnectionSocketFactory connectionFactory =
					new SSLConnectionSocketFactory(sslContextBuilder.build(), hostnameVerifier);

			return HttpClientBuilder.create()
					.setSSLSocketFactory(connectionFactory)
					.build();

		} catch (Exception ex) {

			throw new ClientConfigurationException("Failed to configure ssl client.", ex);
		}
	}

	protected TC getClient() {

		return this.client;
	}

	protected <T extends Response> T call(
			String address, String action, HttpMethod method, ResponseHandler<T> responseHandler) {

		return call(address, action, method, null, responseHandler);
	}

	protected <T extends Response> T call(
			String address, String action, HttpMethod method, Object body, ResponseHandler<T> responseHandler) {

		return call(address, action, method, body, null, responseHandler);
	}

	protected <T extends Response> T call(
			String address, String action, HttpMethod method, Object body, String name,
			ResponseHandler<T> responseHandler) {

		return getHttpsResponse(address, action, method, body, name, responseHandler);
	}

	private <T extends Response> T getHttpsResponse(
			String address, String action, HttpMethod method, Object body, String name,
			ResponseHandler<T> responseHandler) {

		Request req = createRequest(address, action, method);

		try {

			if (body instanceof Bean) {

				req.bodyString(getClient().getMapper().writeValueAsString(body), ContentType.APPLICATION_JSON);

			} else if (body instanceof InputStream) {

				if (name == null) {

					throw new ServiceException("file name cannot be null");
				}

				String cdHeader = "attachment; filename*=utf-8''" + RFC5987Codec.encode(name, StandardCharsets.UTF_8);
				req.setHeader("Content-Disposition", cdHeader);

				req.bodyStream((InputStream) body, ContentType.APPLICATION_OCTET_STREAM);
			}

			Executor executor = Executor.newInstance(sslClient);

			return executor.execute(req).handleResponse(responseHandler);

		} catch (IOException e) {

			throw new ServiceException(e);
		}
	}

	private Request createRequest(String address, String action, HttpMethod method) {

		Request request = method.getRequest(address + action);

		setAuthorizationHeader(request);
		setErrorResponseTypeHeader(request);

		return request;
	}

	private void setAuthorizationHeader(Request request) {

		if (this.client.getAuthToken() != null) {

			request.addHeader(HEADER_AUTHORIZATION, AUTHORIZATION_PREFIX + this.client.getAuthToken());
		}
	}

	private void setErrorResponseTypeHeader(Request request) {

		if (getClient().getErrorResponseType() != null) {

			request.addHeader(HEADER_ERROR_RESPONSE_TYPE, getClient().getErrorResponseType().getValue());
		}
	}
}
