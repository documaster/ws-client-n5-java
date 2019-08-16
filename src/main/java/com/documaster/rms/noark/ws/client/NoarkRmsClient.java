package com.documaster.rms.noark.ws.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import com.documaster.rms.noark.ws.client.bsm.BsmField;
import com.documaster.rms.noark.ws.client.bsm.BsmGroup;
import com.documaster.rms.noark.ws.client.bsm.BusinessSpecificMetadataInfo;
import com.documaster.rms.noark.ws.client.codelist.CodeList;
import com.documaster.rms.noark.ws.client.codelist.CodeValue;
import com.documaster.rms.noark.ws.client.query.Query;
import com.documaster.rms.noark.ws.client.transaction.Transaction;
import com.documaster.rms.noark.ws.noarkentities.Dokumentfil;
import com.documaster.rms.noark.ws.noarkentities.NoarkEntity;

public interface NoarkRmsClient {

	Transaction transaction();

	<TEntity extends NoarkEntity> Query<TEntity> query(Class<TEntity> entityClass, int limit);

	<TEntity extends NoarkEntity> Query<TEntity> query(Class<TEntity> entityClass, String queryString, int limit);

	Dokumentfil upload(InputStream inputStream, String fileName);

	Dokumentfil upload(String filePath) throws IOException;

	void download(Dokumentfil dokumentfil, OutputStream outputStream);

	void download(Dokumentfil dokumentfil, String saveFilePath) throws IOException;

	List<CodeList> codeLists();

	List<CodeList> codeLists(String type, String field);

	<T extends CodeValue> T saveCodeListValue(T codeListValue);

	void deleteCodeListValue(String listId, String code);

	void deleteCodeListValue(CodeValue codeListValue);

	BusinessSpecificMetadataInfo bsmRegistry();

	BusinessSpecificMetadataInfo bsmRegistry(String groupId, String fieldId);

	BsmGroup saveBsmGroup(BsmGroup bsmGroup);

	void deleteBsmGroup(String groupId);

	BsmField saveBsmField(String groupId, BsmField bsmField);

	void deleteBsmField(String groupId, String fieldId);
}
