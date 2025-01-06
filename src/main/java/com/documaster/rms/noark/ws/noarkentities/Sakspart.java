package com.documaster.rms.noark.ws.noarkentities;

import java.util.Optional;

import com.documaster.rms.noark.ws.client.action.LinkAction;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Sakspart extends PartBase<Sakspart> {

	public static final String MAPPE_LINK = "refMappe";
	public static final String EKSTERN_ID_LINK = "refEksternId";

	private String sakspartNavn;
	private String sakspartRolle;
	private String sakspartRolleBeskrivelse;
	private Boolean serializeSakspartRolleBeskrivelse;
	private String sakspartIdent;
	private boolean serializeSakspartIdent;
	private Boolean erSkjermet;
	private boolean serializeErSkjermet;

	public Sakspart(String sakspartNavn, String sakspartRolle) {

		this.sakspartNavn = sakspartNavn;
		this.sakspartRolle = sakspartRolle;
	}

	@JsonCreator
	private Sakspart(
			@JsonProperty("id") String id,
			@JsonProperty("uuid") String uuid,
			@JsonProperty("version") String version) {

		super(id, uuid, version);
	}

	public String getSakspartNavn() {

		return sakspartNavn;
	}

	public void setSakspartNavn(String sakspartNavn) {

		this.sakspartNavn = sakspartNavn;
	}

	public String getSakspartRolle() {

		return sakspartRolle;
	}

	public void setSakspartRolle(String sakspartRolle) {

		this.sakspartRolle = sakspartRolle;
	}

	public String getSakspartRolleBeskrivelse() {

		return sakspartRolleBeskrivelse;
	}

	@JsonProperty("sakspartRolleBeskrivelse")
	public void setSakspartRolleBeskrivelse(String sakspartRolleBeskrivelse) {

		this.sakspartRolleBeskrivelse = sakspartRolleBeskrivelse;
		this.serializeSakspartRolleBeskrivelse = true;
	}

	@JsonProperty("sakspartRolleBeskrivelse")
	public Optional<String> getSakspartRolleBeskrivelseAsOptional() {

		if (serializeSakspartRolleBeskrivelse) {

			return Optional.ofNullable(sakspartRolleBeskrivelse);
		}

		return null;
	}

	public String getSakspartIdent() {

		return sakspartIdent;
	}

	@JsonProperty("sakspartIdent")
	public void setSakspartIdent(String sakspartIdent) {

		this.sakspartIdent = sakspartIdent;
		serializeSakspartIdent = true;
	}

	@JsonProperty("sakspartIdent")
	public Optional<String> getSakspartIdentAsOptional() {

		if (serializeSakspartIdent) {

			return Optional.ofNullable(sakspartIdent);
		}

		return null;
	}

	public Boolean getErSkjermet() {

		return erSkjermet;
	}

	@JsonProperty("erSkjermet")
	public void setErSkjermet(Boolean erSkjermet) {

		this.erSkjermet = erSkjermet;
		serializeErSkjermet = true;
	}

	@JsonProperty("erSkjermet")
	public Optional<Boolean> getErSkjermetAsOptional() {

		if (serializeErSkjermet) {

			return Optional.ofNullable(erSkjermet);
		}

		return null;
	}

	public LinkAction<Sakspart> linkMappe(String mappeId) {

		return link(MAPPE_LINK, mappeId);
	}

	public LinkAction<Sakspart> linkMappe(Saksmappe mappe) {

		return link(MAPPE_LINK, mappe);
	}

	public LinkAction<Sakspart> linkEksternId(String... eksternIdIds) {

		return link(EKSTERN_ID_LINK, eksternIdIds);
	}

	public LinkAction<Sakspart> linkEksternId(EksternId... eksternId) {

		return link(EKSTERN_ID_LINK, eksternId);
	}

	@JsonIgnore
	public String getRefMappe() {

		return getRef(MAPPE_LINK);
	}
}
