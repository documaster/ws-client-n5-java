package com.documaster.rms.noark.ws.noarkentities;

import com.documaster.rms.noark.ws.client.action.LinkAction;
import com.documaster.rms.noark.ws.client.action.UnlinkAction;
import com.documaster.rms.noark.ws.constants.Avskrivningsmaate;
import com.documaster.rms.noark.ws.serialization.NoarkEnumJsonDeserializer;
import com.documaster.rms.noark.ws.serialization.NoarkEnumJsonSerializer;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Avskrivning extends NoarkEntityBase<Avskrivning> {

	public static final String JOURNALPOST_LINK = "refJournalpost";
	public static final String TILKNYTTET_JOURNALPOST_LINK = "refTilknyttetJournalpost";

	@JsonSerialize(using = NoarkEnumJsonSerializer.class)
	@JsonDeserialize(using = NoarkEnumJsonDeserializer.class)
	private Avskrivningsmaate avskrivningsmaate;

	public Avskrivning(Avskrivningsmaate avskrivningsmaate) {

		this.avskrivningsmaate = avskrivningsmaate;
	}

	@JsonCreator
	private Avskrivning(
			@JsonProperty("id") String id,
			@JsonProperty("uuid") String uuid,
			@JsonProperty("version") String version) {

		super(id, uuid, version);
	}

	public Avskrivningsmaate getAvskrivningsmaate() {

		return avskrivningsmaate;
	}

	public void setAvskrivningsmaate(Avskrivningsmaate avskrivningsmaate) {

		this.avskrivningsmaate = avskrivningsmaate;
	}

	public LinkAction<Avskrivning> linkJournalpost(String journalpostId) {

		return link(JOURNALPOST_LINK, journalpostId);
	}

	public LinkAction<Avskrivning> linkJournalpost(Journalpost journalpost) {

		return link(JOURNALPOST_LINK, journalpost);
	}

	public LinkAction<Avskrivning> linkTilknyttetJournalpost(String... journalpostIds) {

		return link(TILKNYTTET_JOURNALPOST_LINK, journalpostIds);
	}

	public LinkAction<Avskrivning> linkTilknyttetJournalpost(Journalpost... journalposts) {

		return link(TILKNYTTET_JOURNALPOST_LINK, journalposts);
	}

	public UnlinkAction<Avskrivning> unlinkTilknyttetJournalpost(String... journalpostIds) {

		return unlink(TILKNYTTET_JOURNALPOST_LINK, journalpostIds);
	}

	public UnlinkAction<Avskrivning> unlinkTilknyttetJournalpost(Journalpost... journalposts) {

		return unlink(TILKNYTTET_JOURNALPOST_LINK, journalposts);
	}

	@JsonIgnore
	public String getRefJournalpost() {

		return getRef(JOURNALPOST_LINK);
	}
}
