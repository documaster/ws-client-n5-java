package com.documaster.rms.noark.ws.client;

import com.documaster.rms.noark.ws.serialization.CustomObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpClient {

	private final String serverAddress;
	private final ObjectMapper mapper;
	private String keystorePath;
	private char[] keystorePassword;
	private String truststorePath;
	private char[] truststorePassword;
	private String authToken;
	private boolean ignoreCertificateErrors;

	public HttpClient(String serverAddress) {

		this.serverAddress = !serverAddress.endsWith("/") && !serverAddress.endsWith("\\")
							 ? serverAddress + "/" : serverAddress;

		this.mapper = CustomObjectMapper.INSTANCE.getMapper();
	}

	public String getServerAddress() {

		return serverAddress;
	}

	public String getAuthToken() {

		return authToken;
	}

	public void setAuthToken(String authToken) {

		this.authToken = authToken;
	}

	public ObjectMapper getMapper() {

		return mapper;
	}

	public boolean getTrustSelfSignedCerts() {

		return ignoreCertificateErrors;
	}

	public void setTrustSelfSignedCerts(boolean trustSelfSignedCerts) {

		this.ignoreCertificateErrors = trustSelfSignedCerts;
	}

	public String getKeystorePath() {

		return keystorePath;
	}

	public void setKeystorePath(String keystorePath) {

		this.keystorePath = keystorePath;
	}

	public char[] getKeystorePassword() {

		return keystorePassword;
	}

	public void setKeystorePassword(char[] keystorePassword) {

		this.keystorePassword = keystorePassword;
	}

	public String getTruststorePath() {

		return truststorePath;
	}

	public void setTruststorePath(String truststorePath) {

		this.truststorePath = truststorePath;
	}

	public char[] getTruststorePassword() {

		return truststorePassword;
	}

	public void setTruststorePassword(char[] truststorePassword) {

		this.truststorePassword = truststorePassword;
	}

	public void setClientKeystore(String keystorePath, char[] keystorePass) {

		setKeystorePath(keystorePath);
		setKeystorePassword(keystorePass);
	}

	public void setClientTruststore(String truststorePath, char[] truststorePass) {

		setTruststorePath(truststorePath);
		setTruststorePassword(truststorePass);
	}
}

