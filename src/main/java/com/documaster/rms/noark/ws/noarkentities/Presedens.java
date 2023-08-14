package com.documaster.rms.noark.ws.noarkentities;

import java.util.Date;
import java.util.Optional;

import com.documaster.rms.noark.ws.client.action.LinkAction;
import com.documaster.rms.noark.ws.client.action.UnlinkAction;
import com.documaster.rms.noark.ws.constants.PresedensHjemmel;
import com.documaster.rms.noark.ws.constants.PresedensStatus;
import com.documaster.rms.noark.ws.constants.Rettskildefaktor;
import com.documaster.rms.noark.ws.serialization.CustomDateFormat;
import com.documaster.rms.noark.ws.serialization.NoarkEnumJsonDeserializer;
import com.documaster.rms.noark.ws.serialization.NoarkEnumJsonSerializer;
import com.documaster.rms.noark.ws.serialization.NoarkOptionalEnumJsonSerializer;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Presedens extends FinalizedEntityBase<Presedens> {

	public static final String SAKSMAPPE_LINK = "refSaksmappe";
	public static final String JOURNALPOST_LINK = "refJournalpost";

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = CustomDateFormat.DATE)
	private Date presedensDato;
	private String tittel;
	private String beskrivelse;
	private boolean serializeBeskrivelse;
	private Date presedensGodkjentDato;
	private boolean serializePresedensGodkjentDato;
	private String presedensGodkjentAv;
	private boolean serializePresedensGodkjentAv;
	private String presedensGodkjentAvBrukerIdent;
	private boolean serializePresedensGodkjentAvBrukerIdent;

	@JsonSerialize(using = NoarkOptionalEnumJsonSerializer.class)
	@JsonDeserialize(using = NoarkEnumJsonDeserializer.class)
	private PresedensHjemmel presedensHjemmel;

	private boolean serializePresedensHjemmel;

	@JsonSerialize(using = NoarkEnumJsonSerializer.class)
	@JsonDeserialize(using = NoarkEnumJsonDeserializer.class)
	private Rettskildefaktor rettskildefaktor;

	@JsonSerialize(using = NoarkEnumJsonSerializer.class)
	@JsonDeserialize(using = NoarkEnumJsonDeserializer.class)
	private PresedensStatus presedensStatus;

	@JsonCreator
	private Presedens(
			@JsonProperty("id") String id,
			@JsonProperty("uuid") String uuid,
			@JsonProperty("version") String version) {

		super(id, uuid, version);
	}

	public Presedens(
			Date presedensDato, String tittel, Rettskildefaktor rettskildefaktor, PresedensStatus presedensStatus) {

		this.presedensDato = presedensDato;
		this.tittel = tittel;
		this.rettskildefaktor = rettskildefaktor;
		this.presedensStatus = presedensStatus;
	}

	public Date getPresedensDato() {

		return presedensDato;
	}

	public void setPresedensDato(Date presedensDato) {

		this.presedensDato = presedensDato;
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

	public Date getPresedensGodkjentDato() {

		return presedensGodkjentDato;
	}

	@JsonProperty("presedensGodkjentDato")
	public void setPresedensGodkjentDato(Date presedensGodkjentDato) {

		this.presedensGodkjentDato = presedensGodkjentDato;
		serializePresedensGodkjentDato = true;
	}

	@JsonProperty("presedensGodkjentDato")
	public Optional<Date> getPresedensGodkjentDatoAsOptional() {

		if (serializePresedensGodkjentDato) {

			return Optional.ofNullable(presedensGodkjentDato);
		}

		return null;
	}

	public String getPresedensGodkjentAv() {

		return presedensGodkjentAv;
	}

	@JsonProperty("presedensGodkjentAv")
	public void setPresedensGodkjentAv(String presedensGodkjentAv) {

		this.presedensGodkjentAv = presedensGodkjentAv;
		serializePresedensGodkjentAv = true;
	}

	@JsonProperty("presedensGodkjentAv")
	public Optional<String> getPresedensGodkjentAvAsOptional() {

		if (serializePresedensGodkjentAv) {

			return Optional.ofNullable(presedensGodkjentAv);
		}

		return null;
	}

	public String getPresedensGodkjentAvBrukerIdent() {

		return presedensGodkjentAvBrukerIdent;
	}

	@JsonProperty("presedensGodkjentAvBrukerIdent")
	public void setPresedensGodkjentAvBrukerIdent(String presedensGodkjentAvBrukerIdent) {

		this.presedensGodkjentAvBrukerIdent = presedensGodkjentAvBrukerIdent;
		serializePresedensGodkjentAvBrukerIdent = true;
	}

	@JsonProperty("presedensGodkjentAvBrukerIdent")
	public Optional<String> getPresedensGodkjentAvBrukerIdentAsOptional() {

		if (serializePresedensGodkjentAvBrukerIdent) {

			return Optional.ofNullable(presedensGodkjentAvBrukerIdent);
		}

		return null;
	}

	public PresedensHjemmel getPresedensHjemmel() {

		return presedensHjemmel;
	}

	@JsonProperty("presedensHjemmel")
	public void setPresedensHjemmel(PresedensHjemmel presedensHjemmel) {

		this.presedensHjemmel = presedensHjemmel;
		serializePresedensHjemmel = true;
	}

	@JsonProperty("presedensHjemmel")
	public Optional<PresedensHjemmel> getPresedensHjemmelAsOptional() {

		if (serializePresedensHjemmel) {

			return Optional.ofNullable(presedensHjemmel);
		}

		return null;
	}

	public Rettskildefaktor getRettskildefaktor() {

		return rettskildefaktor;
	}

	public void setRettskildefaktor(Rettskildefaktor rettskildefaktor) {

		this.rettskildefaktor = rettskildefaktor;
	}

	public PresedensStatus getPresedensStatus() {

		return presedensStatus;
	}

	public void setPresedensStatus(PresedensStatus presedensStatus) {

		this.presedensStatus = presedensStatus;
	}

	public LinkAction<Presedens> linkSaksmappe(String... saksmappeIds) {

		return link(SAKSMAPPE_LINK, saksmappeIds);
	}

	public LinkAction<Presedens> linkSaksmappe(Saksmappe... saksmappes) {

		return link(SAKSMAPPE_LINK, saksmappes);
	}

	public UnlinkAction<Presedens> unlinkSaksmappe(String... saksmappeIds) {

		return unlink(SAKSMAPPE_LINK, saksmappeIds);
	}

	public UnlinkAction<Presedens> unlinkSaksmappe(Saksmappe... saksmappes) {

		return unlink(SAKSMAPPE_LINK, saksmappes);
	}

	public LinkAction<Presedens> linkJournalpost(String... journalpostIds) {

		return link(JOURNALPOST_LINK, journalpostIds);
	}

	public LinkAction<Presedens> linkJournalpost(Journalpost... journalposts) {

		return link(JOURNALPOST_LINK, journalposts);
	}

	public UnlinkAction<Presedens> unlinkJournalpost(String... journalpostIds) {

		return unlink(JOURNALPOST_LINK, journalpostIds);
	}

	public UnlinkAction<Presedens> unlinkJournalpost(Journalpost... journalposts) {

		return unlink(JOURNALPOST_LINK, journalposts);
	}
}
