package com.documaster.rms.noark.ws.noarkentities;

import com.documaster.rms.noark.ws.client.action.LinkAction;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Moetedeltaker extends NoarkEntityBase<Moetedeltaker> {

	public static final String MAPPE_LINK = "refMappe";

	private String navn;
	private String funksjon;

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

	public void setFunksjon(String funksjon) {

		this.funksjon = funksjon;
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
