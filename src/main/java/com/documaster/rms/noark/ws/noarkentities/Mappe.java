package com.documaster.rms.noark.ws.noarkentities;

import com.documaster.rms.noark.ws.client.action.LinkAction;
import com.documaster.rms.noark.ws.client.action.UnlinkAction;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Mappe extends MappeBase<Mappe> {

	public static final String FORELDER_MAPPE_LINK = "refForelderMappe";
	public static final String BARN_MAPPE_LINK = "refBarnMappe";

	public Mappe(String tittel) {

		setTittel(tittel);
	}

	@JsonCreator
	private Mappe(
			@JsonProperty("id") String id,
			@JsonProperty("uuid") String uuid,
			@JsonProperty("version") String version) {

		super(id, uuid, version);
	}

	public LinkAction<Mappe> linkRegistrering(String... registreringIds) {

		return link(REGISTRERING_LINK, registreringIds);
	}

	public LinkAction<Mappe> linkRegistrering(AbstraktRegistrering... registrering) {

		return link(REGISTRERING_LINK, registrering);
	}

	public UnlinkAction<Mappe> unlinkRegistrering(String... registreringIds) {

		return unlink(REGISTRERING_LINK, registreringIds);
	}

	public UnlinkAction<Mappe> unlinkRegistrering(AbstraktRegistrering... registrering) {

		return unlink(REGISTRERING_LINK, registrering);
	}

	public LinkAction<Mappe> linkForelderMappe(String forelderMappeId) {

		return link(FORELDER_MAPPE_LINK, forelderMappeId);
	}

	public LinkAction<Mappe> linkForelderMappe(Mappe forelderMappe) {

		return link(FORELDER_MAPPE_LINK, forelderMappe);
	}

	public UnlinkAction<Mappe> unlinkForelderMappe(String forelderMappeId) {

		return unlink(FORELDER_MAPPE_LINK, forelderMappeId);
	}

	public UnlinkAction<Mappe> unlinkForelderMappe(Mappe forelderMappe) {

		return unlink(FORELDER_MAPPE_LINK, forelderMappe);
	}

	public LinkAction<Mappe> linkBarnMappe(String... barnMappeIds) {

		return link(BARN_MAPPE_LINK, barnMappeIds);
	}

	public LinkAction<Mappe> linkBarnMappe(Mappe... barnMappe) {

		return link(BARN_MAPPE_LINK, barnMappe);
	}

	public UnlinkAction<Mappe> unlinkBarnMappe(String... barnMappeIds) {

		return unlink(BARN_MAPPE_LINK, barnMappeIds);
	}

	public UnlinkAction<Mappe> unlinkBarnMappe(Mappe... barnMappe) {

		return unlink(BARN_MAPPE_LINK, barnMappe);
	}

	@JsonIgnore
	public String getRefForelderMappe() {

		return getRef(FORELDER_MAPPE_LINK);
	}
}
