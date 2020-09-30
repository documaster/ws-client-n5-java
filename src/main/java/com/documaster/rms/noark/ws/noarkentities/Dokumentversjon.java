package com.documaster.rms.noark.ws.noarkentities;

import com.documaster.rms.noark.ws.client.action.LinkAction;
import com.documaster.rms.noark.ws.constants.Variantformat;
import com.documaster.rms.noark.ws.serialization.NoarkEnumJsonDeserializer;
import com.documaster.rms.noark.ws.serialization.NoarkEnumJsonSerializer;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Dokumentversjon extends NoarkEntityBase<Dokumentversjon> {

	public static final String DOKUMENT_LINK = "refDokument";

	@JsonIgnore
	public Dokumentfil dokumentfil;

	@JsonIgnore
	public String sjekksum;

	@JsonIgnore
	public String sjekksumAlgoritme;

	@JsonIgnore
	public Long filstoerrelse;

	@JsonIgnore
	private String filnavn;

	public Integer versjonsnummer;
	public String format;
	public String formatDetaljer;
	public Boolean kryptertDokument;

	@JsonSerialize(using = NoarkEnumJsonSerializer.class)
	@JsonDeserialize(using = NoarkEnumJsonDeserializer.class)
	public Variantformat variantformat;

	public Dokumentversjon(Variantformat variantformat, String format, Dokumentfil dokumentfil) {

		this.variantformat = variantformat;
		this.format = format;
		this.dokumentfil = dokumentfil;
	}

	@JsonCreator
	private Dokumentversjon(
			@JsonProperty("id") String id,
			@JsonProperty("uuid") String uuid,
			@JsonProperty("version") String version,
			@JsonProperty("referanseDokumentfil") String referanseDokumentfil,
			@JsonProperty("sjekksum") String sjekksum,
			@JsonProperty("sjekksumAlgoritme") String sjekksumAlgoritme,
			@JsonProperty("filstoerrelse") long filstoerrelse,
			@JsonProperty("filnavn") String filnavn) {

		super(id, uuid, version);

		this.dokumentfil = new Dokumentfil(referanseDokumentfil);
		this.sjekksum = sjekksum;
		this.sjekksumAlgoritme = sjekksumAlgoritme;
		this.filstoerrelse = filstoerrelse;
		this.filnavn = filnavn;
	}

	public Dokumentfil getDokumentfil() {

		return dokumentfil;
	}

	public void setDokumentfil(Dokumentfil dokumentfil) {

		this.dokumentfil = dokumentfil;
	}

	public String getReferanseDokumentfil() {

		return dokumentfil != null ? dokumentfil.getId() : null;
	}

	public String getSjekksum() {

		return sjekksum;
	}

	public String getSjekksumAlgoritme() {

		return sjekksumAlgoritme;
	}

	public Long getFilstoerrelse() {

		return filstoerrelse;
	}

	public String getFilnavn() {

		return filnavn;
	}

	public Variantformat getVariantformat() {

		return variantformat;
	}

	public void setVariantformat(Variantformat variantformat) {

		this.variantformat = variantformat;
	}

	public Integer getVersjonsnummer() {

		return versjonsnummer;
	}

	public void setVersjonsnummer(Integer versjonsnummer) {

		this.versjonsnummer = versjonsnummer;
	}

	public String getFormat() {

		return format;
	}

	public void setFormat(String format) {

		this.format = format;
	}

	public String getFormatDetaljer() {

		return formatDetaljer;
	}

	public void setFormatDetaljer(String formatDetaljer) {

		this.formatDetaljer = formatDetaljer;
	}

	public Boolean getKryptertDokument() {

		return kryptertDokument;
	}

	public void setKryptertDokument(Boolean kryptertDokument) {

		this.kryptertDokument = kryptertDokument;
	}

	public LinkAction<Dokumentversjon> linkDokument(String dokumentId) {

		return link(DOKUMENT_LINK, dokumentId);
	}

	public LinkAction<Dokumentversjon> linkDokument(Dokument dokument) {

		return link(DOKUMENT_LINK, dokument);
	}

	@JsonIgnore
	public String getRefDokument() {

		return getRef(DOKUMENT_LINK);
	}
}
