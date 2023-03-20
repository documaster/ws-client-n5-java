package com.documaster.rms.noark.ws.serialization;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.documaster.rms.noark.ws.StringUtils;
import com.documaster.rms.noark.ws.client.codelist.CodeValue;
import com.documaster.rms.noark.ws.constants.AdministrativEnhet;
import com.documaster.rms.noark.ws.constants.Arkivdelstatus;
import com.documaster.rms.noark.ws.constants.Arkivstatus;
import com.documaster.rms.noark.ws.constants.Avskrivningsmaate;
import com.documaster.rms.noark.ws.constants.Dokumentmedium;
import com.documaster.rms.noark.ws.constants.Dokumentstatus;
import com.documaster.rms.noark.ws.constants.Dokumenttype;
import com.documaster.rms.noark.ws.constants.Ekspederingskanal;
import com.documaster.rms.noark.ws.constants.FlytStatus;
import com.documaster.rms.noark.ws.constants.Journalposttype;
import com.documaster.rms.noark.ws.constants.Journalstatus;
import com.documaster.rms.noark.ws.constants.Kassasjonshjemmel;
import com.documaster.rms.noark.ws.constants.Kassasjonsvedtak;
import com.documaster.rms.noark.ws.constants.Korrespondanseparttype;
import com.documaster.rms.noark.ws.constants.Lovreferanse;
import com.documaster.rms.noark.ws.constants.Mappetype;
import com.documaster.rms.noark.ws.constants.Merknadstype;
import com.documaster.rms.noark.ws.constants.Moeteregistreringsstatus;
import com.documaster.rms.noark.ws.constants.Moeteregistreringstype;
import com.documaster.rms.noark.ws.constants.Moetesakstype;
import com.documaster.rms.noark.ws.constants.Planstatus;
import com.documaster.rms.noark.ws.constants.Plantype;
import com.documaster.rms.noark.ws.constants.PresedensHjemmel;
import com.documaster.rms.noark.ws.constants.PresedensStatus;
import com.documaster.rms.noark.ws.constants.Rettskildefaktor;
import com.documaster.rms.noark.ws.constants.Saksstatus;
import com.documaster.rms.noark.ws.constants.Skjerming;
import com.documaster.rms.noark.ws.constants.TilknyttetRegistreringSom;
import com.documaster.rms.noark.ws.constants.Variantformat;
import com.documaster.rms.noark.ws.noarkentities.Adresse;
import com.documaster.rms.noark.ws.noarkentities.Arkiv;
import com.documaster.rms.noark.ws.noarkentities.Arkivdel;
import com.documaster.rms.noark.ws.noarkentities.Arkivskaper;
import com.documaster.rms.noark.ws.noarkentities.Avskrivning;
import com.documaster.rms.noark.ws.noarkentities.Basisregistrering;
import com.documaster.rms.noark.ws.noarkentities.Bygning;
import com.documaster.rms.noark.ws.noarkentities.Dokument;
import com.documaster.rms.noark.ws.noarkentities.Dokumentversjon;
import com.documaster.rms.noark.ws.noarkentities.Eiendom;
import com.documaster.rms.noark.ws.noarkentities.EksternId;
import com.documaster.rms.noark.ws.noarkentities.Journalpost;
import com.documaster.rms.noark.ws.noarkentities.Klasse;
import com.documaster.rms.noark.ws.noarkentities.Klassifikasjonssystem;
import com.documaster.rms.noark.ws.noarkentities.Korrespondansepart;
import com.documaster.rms.noark.ws.noarkentities.Mappe;
import com.documaster.rms.noark.ws.noarkentities.Merknad;
import com.documaster.rms.noark.ws.noarkentities.Moetedeltaker;
import com.documaster.rms.noark.ws.noarkentities.Moetemappe;
import com.documaster.rms.noark.ws.noarkentities.Moeteregistrering;
import com.documaster.rms.noark.ws.noarkentities.NoarkEntity;
import com.documaster.rms.noark.ws.noarkentities.Noekkelord;
import com.documaster.rms.noark.ws.noarkentities.Plan;
import com.documaster.rms.noark.ws.noarkentities.Saksmappe;
import com.documaster.rms.noark.ws.noarkentities.Sakspart;

public enum NoarkObjectMappings {

	INSTANCE;

	private final Map<String, Class<? extends NoarkEntity>> typeMappings;
	private final Map<String, Class<? extends CodeValue>> codeValueMappings;
	private final Map<String, Set<String>> typeCodeValueMappings;

	NoarkObjectMappings() {

		this.typeMappings = createTypeMappings();
		this.codeValueMappings = createCodeValueMappings();
		this.typeCodeValueMappings = createTypeCodeValueMappings(this.typeMappings);
	}

	private Map<String, Class<? extends NoarkEntity>> createTypeMappings() {

		Map<String, Class<? extends NoarkEntity>> typeMappings = new HashMap<>();

		putTypeMapping(typeMappings, Arkiv.class);
		putTypeMapping(typeMappings, Arkivdel.class);
		putTypeMapping(typeMappings, Arkivskaper.class);
		putTypeMapping(typeMappings, Avskrivning.class);
		putTypeMapping(typeMappings, Basisregistrering.class);
		putTypeMapping(typeMappings, Dokument.class);
		putTypeMapping(typeMappings, Dokumentversjon.class);
		putTypeMapping(typeMappings, EksternId.class);
		putTypeMapping(typeMappings, Journalpost.class);
		putTypeMapping(typeMappings, Klasse.class);
		putTypeMapping(typeMappings, Klassifikasjonssystem.class);
		putTypeMapping(typeMappings, Korrespondansepart.class);
		putTypeMapping(typeMappings, Mappe.class);
		putTypeMapping(typeMappings, Noekkelord.class);
		putTypeMapping(typeMappings, Saksmappe.class);
		putTypeMapping(typeMappings, Sakspart.class);
		putTypeMapping(typeMappings, Moetemappe.class);
		putTypeMapping(typeMappings, Moetedeltaker.class);
		putTypeMapping(typeMappings, Moeteregistrering.class);
		putTypeMapping(typeMappings, Merknad.class);
		putTypeMapping(typeMappings, Adresse.class);
		putTypeMapping(typeMappings, Bygning.class);
		putTypeMapping(typeMappings, Eiendom.class);
		putTypeMapping(typeMappings, Plan.class);

		return Collections.unmodifiableMap(typeMappings);
	}

	private void putTypeMapping(
			Map<String, Class<? extends NoarkEntity>> typeMappings, Class<? extends NoarkEntity> clazz) {

		typeMappings.put(clazz.getSimpleName(), clazz);
	}

	private Map<String, Class<? extends CodeValue>> createCodeValueMappings() {

		Map<String, Class<? extends CodeValue>> codeValueMappings = new HashMap<>();

		putCodeValueMapping(codeValueMappings, AdministrativEnhet.class);
		putCodeValueMapping(codeValueMappings, Arkivdelstatus.class);
		putCodeValueMapping(codeValueMappings, Arkivstatus.class);
		putCodeValueMapping(codeValueMappings, Avskrivningsmaate.class);
		putCodeValueMapping(codeValueMappings, Dokumentmedium.class);
		putCodeValueMapping(codeValueMappings, Dokumentstatus.class);
		putCodeValueMapping(codeValueMappings, Dokumenttype.class);
		putCodeValueMapping(codeValueMappings, Ekspederingskanal.class);
		putCodeValueMapping(codeValueMappings, FlytStatus.class);
		putCodeValueMapping(codeValueMappings, Journalposttype.class);
		putCodeValueMapping(codeValueMappings, Journalstatus.class);
		putCodeValueMapping(codeValueMappings, Korrespondanseparttype.class);
		putCodeValueMapping(codeValueMappings, Mappetype.class);
		putCodeValueMapping(codeValueMappings, Saksstatus.class);
		putCodeValueMapping(codeValueMappings, Skjerming.class);
		putCodeValueMapping(codeValueMappings, TilknyttetRegistreringSom.class);
		putCodeValueMapping(codeValueMappings, Variantformat.class);
		putCodeValueMapping(codeValueMappings, Moeteregistreringstype.class);
		putCodeValueMapping(codeValueMappings, Moeteregistreringsstatus.class);
		putCodeValueMapping(codeValueMappings, Moetesakstype.class);
		putCodeValueMapping(codeValueMappings, Merknadstype.class);
		putCodeValueMapping(codeValueMappings, Plantype.class);
		putCodeValueMapping(codeValueMappings, Planstatus.class);
		putCodeValueMapping(codeValueMappings, Lovreferanse.class);
		putCodeValueMapping(codeValueMappings, Kassasjonshjemmel.class);
		putCodeValueMapping(codeValueMappings, Kassasjonsvedtak.class);
		putCodeValueMapping(codeValueMappings, PresedensHjemmel.class);
		putCodeValueMapping(codeValueMappings, PresedensStatus.class);
		putCodeValueMapping(codeValueMappings, Rettskildefaktor.class);

		return Collections.unmodifiableMap(codeValueMappings);
	}

	private void putCodeValueMapping(
			Map<String, Class<? extends CodeValue>> codeValueMappings, Class<? extends CodeValue> clazz) {

		codeValueMappings.put(getCodeValueFieldName(clazz), clazz);
	}

	private Map<String, Set<String>> createTypeCodeValueMappings(
			Map<String, Class<? extends NoarkEntity>> typeMappings) {

		Map<String, Set<String>> typeCodeValueMappings = new HashMap<>();

		for (Class<? extends NoarkEntity> entityClass : typeMappings.values()) {

			gatherCodeValueFields(typeCodeValueMappings, entityClass);
		}

		return Collections.unmodifiableMap(typeCodeValueMappings);
	}

	private void gatherCodeValueFields(
			Map<String, Set<String>> typeCodeValueMappings,
			Class<? extends NoarkEntity> entityClass) {

		Class<?> clazz = entityClass;

		while (clazz != Object.class) {

			Field[] declaredFields = clazz.getDeclaredFields();
			for (Field field : declaredFields) {

				if (CodeValue.class.isAssignableFrom(field.getType())) {

					typeCodeValueMappings
							.computeIfAbsent(entityClass.getSimpleName(), key -> new HashSet<>())
							.add(getCodeValueFieldName(field.getType().asSubclass(CodeValue.class)));
				}
			}

			clazz = clazz.getSuperclass();
		}
	}

	private String getCodeValueFieldName(Class<? extends CodeValue> clazz) {

		return StringUtils.uncapitalize(clazz.getSimpleName());
	}

	public Map<String, Class<? extends NoarkEntity>> getTypeMappings() {

		return typeMappings;
	}

	public Map<String, Class<? extends CodeValue>> getCodeValueMappings() {

		return codeValueMappings;
	}

	public Map<String, Set<String>> getTypeCodeValueMappings() {

		return typeCodeValueMappings;
	}
}
