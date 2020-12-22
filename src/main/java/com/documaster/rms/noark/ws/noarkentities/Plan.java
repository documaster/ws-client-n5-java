package com.documaster.rms.noark.ws.noarkentities;

import com.documaster.rms.noark.ws.constants.Planstatus;
import com.documaster.rms.noark.ws.constants.Plantype;
import com.documaster.rms.noark.ws.constants.Lovreferanse;
import com.documaster.rms.noark.ws.serialization.NoarkEnumJsonDeserializer;
import com.documaster.rms.noark.ws.serialization.NoarkEnumJsonSerializer;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Plan extends NasjonalIdentifikator<Plan> {

	private String planident;
	private String planKommunenummer;
	private String planLandskode;
	private String planFylkesnummer;
	private String plannavn;

	@JsonSerialize(using = NoarkEnumJsonSerializer.class)
	@JsonDeserialize(using = NoarkEnumJsonDeserializer.class)
	private Plantype plantype;

	@JsonSerialize(using = NoarkEnumJsonSerializer.class)
	@JsonDeserialize(using = NoarkEnumJsonDeserializer.class)
	private Planstatus planstatus;

	@JsonSerialize(using = NoarkEnumJsonSerializer.class)
	@JsonDeserialize(using = NoarkEnumJsonDeserializer.class)
	private Lovreferanse lovreferanse;

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

	public void setPlanKommunenummer(String planKommunenummer) {

		this.planKommunenummer = planKommunenummer;
	}

	public String getPlanLandskode() {

		return planLandskode;
	}

	public void setPlanLandskode(String planLandskode) {

		this.planLandskode = planLandskode;
	}

	public String getPlanFylkesnummer() {

		return planFylkesnummer;
	}

	public void setPlanFylkesnummer(String planFylkesnummer) {

		this.planFylkesnummer = planFylkesnummer;
	}

	public String getPlannavn() {

		return plannavn;
	}

	public void setPlannavn(String plannavn) {

		this.plannavn = plannavn;
	}

	public Plantype getPlantype() {

		return plantype;
	}

	public void setPlantype(Plantype plantype) {

		this.plantype = plantype;
	}

	public Planstatus getPlanstatus() {

		return planstatus;
	}

	public void setPlanstatus(Planstatus planstatus) {

		this.planstatus = planstatus;
	}

	public Lovreferanse getLovreferanse() {

		return lovreferanse;
	}

	public void setLovreferanse(Lovreferanse lovreferanse) {

		this.lovreferanse = lovreferanse;
	}
}
