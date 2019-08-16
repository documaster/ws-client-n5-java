package com.documaster.rms.noark.ws.noarkentities;

import com.documaster.rms.noark.ws.client.action.LinkAction;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Arkivskaper extends NoarkEntityBase<Arkivskaper> {

	public static final String ARKIV_LINK = "refArkiv";

	private String arkivskaperIdent;
	private String arkivskaperNavn;
	private String beskrivelse;

	public Arkivskaper(String arkivskaperIdent, String arkivskaperNavn) {

		this.arkivskaperIdent = arkivskaperIdent;
		this.arkivskaperNavn = arkivskaperNavn;
	}

	@JsonCreator
	private Arkivskaper(
			@JsonProperty("id") String id,
			@JsonProperty("uuid") String uuid,
			@JsonProperty("version") String version) {

		super(id, uuid, version);
	}

	public String getArkivskaperIdent() {

		return arkivskaperIdent;
	}

	public void setArkivskaperIdent(String arkivskaperIdent) {

		this.arkivskaperIdent = arkivskaperIdent;
	}

	public String getArkivskaperNavn() {

		return arkivskaperNavn;
	}

	public void setArkivskaperNavn(String arkivskaperNavn) {

		this.arkivskaperNavn = arkivskaperNavn;
	}

	public String getBeskrivelse() {

		return beskrivelse;
	}

	public void setBeskrivelse(String beskrivelse) {

		this.beskrivelse = beskrivelse;
	}

	public LinkAction<Arkivskaper> linkArkiv(String arkivId) {

		return link(ARKIV_LINK, arkivId);
	}

	public LinkAction<Arkivskaper> linkArkiv(Arkiv arkiv) {

		return link(ARKIV_LINK, arkiv);
	}

	@JsonIgnore
	public String getRefArkiv() {

		return getRef(ARKIV_LINK);
	}
}
