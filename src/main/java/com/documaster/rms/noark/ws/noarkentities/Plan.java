package com.documaster.rms.noark.ws.noarkentities;

import java.util.Optional;

import com.documaster.rms.noark.ws.constants.Lovreferanse;
import com.documaster.rms.noark.ws.constants.Planstatus;
import com.documaster.rms.noark.ws.constants.Plantype;
import com.documaster.rms.noark.ws.serialization.NoarkEnumJsonDeserializer;
import com.documaster.rms.noark.ws.serialization.NoarkOptionalEnumJsonSerializer;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Plan extends NasjonalIdentifikator<Plan> {

	private String planident;
	private String planKommunenummer;
	private boolean serializePlanKommunenummer;
	private String planLandskode;
	private boolean serializePlanLandskode;
	private String planFylkesnummer;
	private boolean serializePlanFylkesnummer;
	private String plannavn;
	private boolean serializePlannavn;

	@JsonSerialize(using = NoarkOptionalEnumJsonSerializer.class)
	@JsonDeserialize(using = NoarkEnumJsonDeserializer.class)
	private Plantype plantype;

	private boolean serializePlantype;

	@JsonSerialize(using = NoarkOptionalEnumJsonSerializer.class)
	@JsonDeserialize(using = NoarkEnumJsonDeserializer.class)
	private Planstatus planstatus;

	private boolean serializePlanstatus;

	@JsonSerialize(using = NoarkOptionalEnumJsonSerializer.class)
	@JsonDeserialize(using = NoarkEnumJsonDeserializer.class)
	private Lovreferanse lovreferanse;

	private boolean serializeLovreferanse;

	public static Plan createPlanWithLandskode(String planident, String planLandskode) {

		Plan plan = new Plan(planident);

		plan.setPlanLandskode(planLandskode);

		return plan;
	}

	public static Plan createPlanWithKommunenummer(String planident, String planKommunenummer) {

		Plan plan = new Plan(planident);

		plan.setPlanKommunenummer(planKommunenummer);

		return plan;
	}

	public static Plan createPlanWithFylkesnummer(String planident, String planFylkesnummer) {

		Plan plan = new Plan(planident);

		plan.setPlanFylkesnummer(planFylkesnummer);

		return plan;
	}

	private Plan(String planident) {

		this.planident = planident;
	}

	@JsonCreator
	private Plan(
			@JsonProperty("id") String id,
			@JsonProperty("uuid") String uuid,
			@JsonProperty("version") String version) {

		super(id, uuid, version);
	}

	public String getPlanident() {

		return planident;
	}

	public void setPlanident(String planident) {

		this.planident = planident;
	}

	public String getPlanKommunenummer() {

		return planKommunenummer;
	}

	@JsonProperty("planKommunenummer")
	public void setPlanKommunenummer(String planKommunenummer) {

		this.planKommunenummer = planKommunenummer;
		serializePlanKommunenummer = true;
	}

	@JsonProperty("planKommunenummer")
	public Optional<String> getPlanKommunenummerAsOptional() {

		if (serializePlanKommunenummer) {

			return Optional.ofNullable(planKommunenummer);
		}

		return null;
	}

	public String getPlanLandskode() {

		return planLandskode;
	}

	@JsonProperty("planLandskode")
	public void setPlanLandskode(String planLandskode) {

		this.planLandskode = planLandskode;
		serializePlanLandskode = true;
	}

	@JsonProperty("planLandskode")
	public Optional<String> getPlanLandskodeAsOptional() {

		if (serializePlanLandskode) {

			return Optional.ofNullable(planLandskode);
		}

		return null;
	}

	public String getPlanFylkesnummer() {

		return planFylkesnummer;
	}

	@JsonProperty("planFylkesnummer")
	public void setPlanFylkesnummer(String planFylkesnummer) {

		this.planFylkesnummer = planFylkesnummer;
		serializePlanFylkesnummer = true;
	}

	@JsonProperty("planFylkesnummer")
	public Optional<String> getPlanFylkesnummerAsOptional() {

		if (serializePlanFylkesnummer) {

			return Optional.ofNullable(planFylkesnummer);
		}

		return null;
	}

	public String getPlannavn() {

		return plannavn;
	}

	@JsonProperty("plannavn")
	public void setPlannavn(String plannavn) {

		this.plannavn = plannavn;
		serializePlannavn = true;
	}

	@JsonProperty("plannavn")
	public Optional<String> getPlannavnAsOptional() {

		if (serializePlannavn) {

			return Optional.ofNullable(plannavn);
		}

		return null;
	}

	public Plantype getPlantype() {

		return plantype;
	}

	@JsonProperty("plantype")
	public void setPlantype(Plantype plantype) {

		this.plantype = plantype;
		serializePlantype = true;
	}

	@JsonProperty("plantype")
	public Optional<Plantype> getPlantypeAsOptional() {

		if (serializePlantype) {

			return Optional.ofNullable(plantype);
		}

		return null;
	}

	public Planstatus getPlanstatus() {

		return planstatus;
	}

	@JsonProperty("planstatus")
	public void setPlanstatus(Planstatus planstatus) {

		this.planstatus = planstatus;
		serializePlanstatus = true;
	}

	@JsonProperty("planstatus")
	public Optional<Planstatus> getPlanstatusAsOptional() {

		if (serializePlanstatus) {

			return Optional.ofNullable(planstatus);
		}

		return null;
	}

	public Lovreferanse getLovreferanse() {

		return lovreferanse;
	}

	@JsonProperty("lovreferanse")
	public void setLovreferanse(Lovreferanse lovreferanse) {

		this.lovreferanse = lovreferanse;
		serializeLovreferanse = true;
	}

	@JsonProperty("lovreferanse")
	public Optional<Lovreferanse> getLovreferanseAsOptional() {

		if (serializeLovreferanse) {

			return Optional.ofNullable(lovreferanse);
		}

		return null;
	}
}
