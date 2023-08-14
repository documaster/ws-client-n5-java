package com.documaster.rms.noark.ws.noarkentities;

import java.util.Optional;

import com.documaster.rms.noark.ws.client.action.LinkAction;
import com.documaster.rms.noark.ws.client.action.UnlinkAction;
import com.documaster.rms.noark.ws.constants.Arkivstatus;
import com.documaster.rms.noark.ws.constants.Dokumentmedium;
import com.documaster.rms.noark.ws.serialization.NoarkEnumJsonDeserializer;
import com.documaster.rms.noark.ws.serialization.NoarkEnumJsonSerializer;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Arkiv extends FinalizedEntityBase<Arkiv> {

	public static final String ARKIVSKAPER_LINK = "refArkivskaper";
	public static final String ARKIVDEL_LINK = "refArkivdel";

	private String tittel;
	private String beskrivelse;
	private boolean serializeBeskrivelse;

	@JsonSerialize(using = NoarkEnumJsonSerializer.class)
	@JsonDeserialize(using = NoarkEnumJsonDeserializer.class)
	private Arkivstatus arkivstatus;

	@JsonSerialize(using = NoarkEnumJsonSerializer.class)
	@JsonDeserialize(using = NoarkEnumJsonDeserializer.class)
	private Dokumentmedium dokumentmedium;

	public Arkiv(String tittel) {

		this.tittel = tittel;
	}

	@JsonCreator
	private Arkiv(
			@JsonProperty("id") String id,
			@JsonProperty("uuid") String uuid,
			@JsonProperty("version") String version) {

		super(id, uuid, version);
	}

	public String getTittel() {

		return tittel;
	}

	public void setTittel(String tittel) {

		this.tittel = tittel;
	}

	public String getBeskrivelse() {

		return beskrivelse;
	}

	@JsonProperty("beskrivelse")
	public void setBeskrivelse(String beskrivelse) {

		this.beskrivelse = beskrivelse;
		serializeBeskrivelse = true;
	}

	@JsonProperty("beskrivelse")
	public Optional<String> getBeskrivelseAsOptional() {

		if (serializeBeskrivelse) {

			return Optional.ofNullable(beskrivelse);
		}

		return null;
	}

	public Arkivstatus getArkivstatus() {

		return arkivstatus;
	}

	public void setArkivstatus(Arkivstatus arkivstatus) {

		this.arkivstatus = arkivstatus;
	}

	public Dokumentmedium getDokumentmedium() {

		return dokumentmedium;
	}

	public void setDokumentmedium(Dokumentmedium dokumentmedium) {

		this.dokumentmedium = dokumentmedium;
	}

	public LinkAction<Arkiv> linkArkivdel(String... arkivdelIds) {

		return link(ARKIVDEL_LINK, arkivdelIds);
	}

	public LinkAction<Arkiv> linkArkivdel(Arkivdel... arkivdels) {

		return link(ARKIVDEL_LINK, arkivdels);
	}

	public UnlinkAction<Arkiv> unlinkArkivdel(String... arkivdelIds) {

		return unlink(ARKIVDEL_LINK, arkivdelIds);
	}

	public UnlinkAction<Arkiv> unlinkArkivdel(Arkivdel... arkivdel) {

		return unlink(ARKIVDEL_LINK, arkivdel);
	}

	public LinkAction<Arkiv> linkArkivskaper(String... arkivskaperIds) {

		return link(ARKIVSKAPER_LINK, arkivskaperIds);
	}

	public LinkAction<Arkiv> linkArkivskaper(Arkivskaper... arkivskaper) {

		return link(ARKIVSKAPER_LINK, arkivskaper);
	}
}
