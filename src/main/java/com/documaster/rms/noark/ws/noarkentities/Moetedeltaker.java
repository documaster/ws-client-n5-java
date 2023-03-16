package com.documaster.rms.noark.ws.noarkentities;

import java.util.Optional;

import com.documaster.rms.noark.ws.client.action.LinkAction;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Moetedeltaker extends NoarkEntityBase<Moetedeltaker> {

	public static final String MAPPE_LINK = "refMappe";

	private String navn;
	private String funksjon;
	private boolean serializeFunksjon;

	public Moetedeltaker(String navn) {

		this.navn = navn;
	}

	@JsonCreator
	private Moetedeltaker(
			@JsonProperty("id") String id,
			@JsonProperty("uuid") String uuid,
			@JsonProperty("version") String version) {

		super(id, uuid, version);
	}

	public String getNavn() {

		return navn;
	}

	public void setNavn(String navn) {

		this.navn = navn;
	}

	public String getFunksjon() {

		return funksjon;
	}

	@JsonProperty("funksjon")
	public void setFunksjon(String funksjon) {

		this.funksjon = funksjon;
		serializeFunksjon = true;
	}

	@JsonProperty("funksjon")
	public Optional<String> getFunksjonAsOptional() {

		if (serializeFunksjon) {

			return Optional.ofNullable(funksjon);
		}

		return null;
	}

	public LinkAction<Moetedeltaker> linkMappe(String moetemappeId) {

		return link(MAPPE_LINK, moetemappeId);
	}

	public LinkAction<Moetedeltaker> linkMappe(Moetemappe moetemappe) {

		return link(MAPPE_LINK, moetemappe);
	}

	@JsonIgnore
	public String getRefMappe() {

		return getRef(MAPPE_LINK);
	}
}
