package com.documaster.rms.noark.ws.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.documaster.rms.noark.ws.Argument;
import com.documaster.rms.noark.ws.StringUtils;
import com.documaster.rms.noark.ws.client.accesslog.AccessLogRequest;
import com.documaster.rms.noark.ws.client.accesslog.AccessLogResponse;
import com.documaster.rms.noark.ws.client.bsm.BsmField;
import com.documaster.rms.noark.ws.client.bsm.BsmGroup;
import com.documaster.rms.noark.ws.client.bsm.BusinessSpecificMetadataInfo;
import com.documaster.rms.noark.ws.client.bulk.delete.DeleteRequest;
import com.documaster.rms.noark.ws.client.changelog.ChangeLogRequest;
import com.documaster.rms.noark.ws.client.changelog.ChangeLogResponse;
import com.documaster.rms.noark.ws.client.codelist.CodeList;
import com.documaster.rms.noark.ws.client.codelist.CodeListResponse;
import com.documaster.rms.noark.ws.client.codelist.CodeValue;
import com.documaster.rms.noark.ws.client.exceptions.ServiceException;
import com.documaster.rms.noark.ws.client.fulltextsearch.FullTextRequest;
import com.documaster.rms.noark.ws.client.fulltextsearch.FullTextResponse;
import com.documaster.rms.noark.ws.client.handlers.BeanResponseHandler;
import com.documaster.rms.noark.ws.client.handlers.ErrorResponseHandler;
import com.documaster.rms.noark.ws.client.handlers.OutputStreamResponseHandler;
import com.documaster.rms.noark.ws.client.handlers.VoidResponseHandler;
import com.documaster.rms.noark.ws.client.info.MyInfoResponse;
import com.documaster.rms.noark.ws.client.query.Query;
import com.documaster.rms.noark.ws.client.transaction.Transaction;
import com.documaster.rms.noark.ws.noarkentities.Dokumentfil;
import com.documaster.rms.noark.ws.noarkentities.NoarkEntity;
import com.documaster.rms.noark.ws.noarkentities.expand.UtvidTilJournalpost;
import com.documaster.rms.noark.ws.noarkentities.expand.UtvidTilSaksmappe;

public class NoarkClient extends HttpService<RmsClient> implements NoarkRmsClient {

	public static final String SERVICE_VERSION = "v1";
	public static final String SERVICE_PROVIDER = "rms";
	public static final String NOARK_VERSION = "noark5";

	public static final String NOARK_SERVICE_PATH =
			String.format("/%s/api/public/%s/%s", SERVICE_PROVIDER, NOARK_VERSION, SERVICE_VERSION);

	public static final String TRANSACTION_ACTION_PATH = NOARK_SERVICE_PATH + "/transaction";
	public static final String QUERY_PATH = NOARK_SERVICE_PATH + "/query";
	public static final String DOWNLOAD_PATH = NOARK_SERVICE_PATH + "/download";
	public static final String UPLOAD_PATH = NOARK_SERVICE_PATH + "/upload";
	public static final String FULL_TEXT_SEARCH_PATH = NOARK_SERVICE_PATH + "/full-text/search";

	public static final String CODE_LISTS_PATH = NOARK_SERVICE_PATH + "/code-lists";
	public static final String CODE_LISTS_SAVE_LIST_VALUE_PATH = CODE_LISTS_PATH + "/{listId}/{code}";
	public static final String CODE_LISTS_DELETE_LIST_VALUE_PATH = CODE_LISTS_PATH + "/{listId}/{code}";

	public static final String BSM_REGISTRY_PATH = NOARK_SERVICE_PATH + "/bsm-registry";
	public static final String BSM_REGISTRY_SAVE_GROUP_PATH = BSM_REGISTRY_PATH + "/group/{groupId}";
	public static final String BSM_REGISTRY_DELETE_GROUP_PATH = BSM_REGISTRY_PATH + "/group/{groupId}";
	public static final String BSM_REGISTRY_SAVE_FIELD_PATH = BSM_REGISTRY_PATH + "/group/{groupId}/field/{fieldId}";
	public static final String BSM_REGISTRY_DELETE_FIELD_PATH = BSM_REGISTRY_PATH + "/group/{groupId}/field/{fieldId}";
	public static final String EXPAND_PATH = NOARK_SERVICE_PATH + "/expand";
	public static final String EXPAND_FOLDER_PATH = EXPAND_PATH + "/folder";
	public static final String EXPAND_BASIC_RECORD_PATH = EXPAND_PATH + "/record";

	public static final String BULK_OPERATIONS_PATH = NOARK_SERVICE_PATH + "/bulk";
	public static final String BULK_DELETE_PATH = BULK_OPERATIONS_PATH + "/delete";

	public static final String CHANGE_LOG_PATH = NOARK_SERVICE_PATH + "/logs/change-log";
	public static final String ACCESS_LOG_PATH = NOARK_SERVICE_PATH + "/logs/access-log";

	public static final String INFO_PATH = NOARK_SERVICE_PATH + "/info";
	public static final String ME_PATH = INFO_PATH + "/me";

	public NoarkClient(RmsClient client) {

		super(client);
	}

	public String getAuthToken() {

		return getClient().getAuthToken();
	}

	public void setAuthToken(String authToken) {

		getClient().setAuthToken(authToken);
	}

	@Override
	public Transaction transaction() {

		return new Transaction(getClient());
	}

	@Override
	public <TEntity extends NoarkEntity> Query<TEntity> query(Class<TEntity> entityClass, int limit) {

		Argument.notNull("entityClass", entityClass);

		if (limit <= 0) {

			Argument.assertFail("limit", "Value should be greater than 0");
		}

		return new Query<>(getClient(), entityClass, limit);
	}

	@Override
	public <TEntity extends NoarkEntity> Query<TEntity> query(
			Class<TEntity> entityClass, String queryString, int limit) {

		Argument.notNull("entityClass", entityClass);
		Argument.notNull("queryString", queryString);

		if (limit <= 0) {

			Argument.assertFail("limit", "Value should be greater than 0");
		}

		return new Query<>(getClient(), entityClass, queryString, limit);
	}

	@Override
	public FullTextResponse fullTextSearch(FullTextRequest request) {

		return call(getClient().getServerAddress(), FULL_TEXT_SEARCH_PATH, HttpMethod.POST, request,
				new BeanResponseHandler<>(getClient().getMapper(), FullTextResponse.class, getErrorHandler()))
				.getBean();
	}

	@Override
	public Dokumentfil upload(InputStream inputStream, String fileName) {

		Argument.notNull("inputStream", inputStream);
		Argument.notNullOrEmpty("fileName", fileName);

		return call(getClient().getServerAddress(), UPLOAD_PATH, HttpMethod.POST, inputStream, fileName,
				new BeanResponseHandler<>(getClient().getMapper(), Dokumentfil.class, getErrorHandler())).getBean();
	}

	@Override
	public Dokumentfil upload(String filePath) throws IOException {

		Argument.notNullOrEmpty("filePath", filePath);

		Path path = Paths.get(filePath);

		try (InputStream stream = Files.newInputStream(path)) {

			return upload(stream, path.getFileName().toString());
		}
	}

	@Override
	public void download(Dokumentfil dokumentfil, OutputStream outputStream) {

		Argument.notNull("dokumentfil", dokumentfil);
		Argument.notNullOrEmpty("dokumentfil.Id", dokumentfil.getId());
		Argument.notNull("outputStream", outputStream);

		String actionPath = DOWNLOAD_PATH + "?id=" + dokumentfil.getId();

		call(getClient().getServerAddress(), actionPath, HttpMethod.GET,
				new OutputStreamResponseHandler(outputStream, getErrorHandler()));
	}

	@Override
	public void download(Dokumentfil dokumentfil, String saveFilePath) throws IOException {

		Argument.notNull("dokumentfil", dokumentfil);
		Argument.notNullOrEmpty("dokumentfil.Id", dokumentfil.getId());
		Argument.notNullOrEmpty("saveFilePath", saveFilePath);

		try (final OutputStream stream = Files.newOutputStream(Paths.get(saveFilePath))) {

			download(dokumentfil, stream);
		}
	}

	@Override
	public List<CodeList> codeLists() {

		return codeLists(null, null);
	}

	@Override
	public List<CodeList> codeLists(String type, String field) {

		StringBuilder actionPathBuilder = new StringBuilder();
		actionPathBuilder.append(CODE_LISTS_PATH);

		boolean hasTypeParameter = StringUtils.isNotBlank(type);
		boolean hasFieldParameter = StringUtils.isNotBlank(field);
		if (hasTypeParameter || hasFieldParameter) {

			List<String> parameters = new ArrayList<>();

			if (hasTypeParameter) {

				parameters.add(urlEncode("type", type));
			}

			if (hasFieldParameter) {

				parameters.add(urlEncode("field", field));
			}

			actionPathBuilder
					.append('?')
					.append(String.join("&", parameters));
		}

		return call(getClient().getServerAddress(), actionPathBuilder.toString(), HttpMethod.GET,
				new BeanResponseHandler<>(getClient().getMapper(), CodeListResponse.class, getErrorHandler())).getBean()
				.getResults();
	}

	@Override
	public <T extends CodeValue> T saveCodeListValue(T codeListValue) {

		Argument.notNull("codeListValue", codeListValue);
		Argument.notNullOrEmpty("codeListValue.code", codeListValue.getCode());

		String actionPath = CODE_LISTS_SAVE_LIST_VALUE_PATH
				.replace("{listId}", urlEncode(StringUtils.uncapitalize(codeListValue.getClass().getSimpleName())))
				.replace("{code}", urlEncode(codeListValue.getCode()));

		@SuppressWarnings("unchecked")
		T bean = (T) call(getClient().getServerAddress(), actionPath, HttpMethod.PUT, codeListValue,
				new BeanResponseHandler<>(getClient().getMapper(), codeListValue.getClass(), getErrorHandler()))
				.getBean();

		return bean;
	}

	@Override
	public void deleteCodeListValue(String listId, String code) {

		Argument.notNullOrEmpty("listId", listId);
		Argument.notNullOrEmpty("code", code);

		String actionPath = CODE_LISTS_DELETE_LIST_VALUE_PATH
				.replace("{listId}", urlEncode(listId))
				.replace("{code}", urlEncode(code));

		call(getClient().getServerAddress(), actionPath, HttpMethod.DELETE,
				new VoidResponseHandler(getErrorHandler()));
	}

	@Override
	public void deleteCodeListValue(CodeValue codeListValue) {

		Argument.notNull("codeListValue", codeListValue);
		Argument.notNullOrEmpty("codeListValue.code", codeListValue.getCode());

		String listId = StringUtils.uncapitalize(codeListValue.getClass().getSimpleName());
		String code = codeListValue.getCode();

		deleteCodeListValue(listId, code);
	}

	@Override
	public BusinessSpecificMetadataInfo bsmRegistry() {

		return bsmRegistry(null, null);
	}

	@Override
	public BusinessSpecificMetadataInfo bsmRegistry(String groupId, String fieldId) {

		return bsmRegistryCall(groupId, fieldId);
	}

	private BusinessSpecificMetadataInfo bsmRegistryCall(String groupId, String fieldId) {

		StringBuilder actionPathBuilder = new StringBuilder();
		actionPathBuilder.append(BSM_REGISTRY_PATH);

		boolean hasGroupIdParameter = StringUtils.isNotBlank(groupId);
		boolean hasFieldIdParameter = StringUtils.isNotBlank(fieldId);
		if (hasGroupIdParameter || hasFieldIdParameter) {

			List<String> parameters = new ArrayList<>();

			if (hasGroupIdParameter) {

				parameters.add(urlEncode("groupId", groupId));
			}

			if (hasFieldIdParameter) {

				parameters.add(urlEncode("fieldId", fieldId));
			}

			actionPathBuilder
					.append('?')
					.append(String.join("&", parameters));
		}

		return call(getClient().getServerAddress(), actionPathBuilder.toString(), HttpMethod.GET,
				new BeanResponseHandler<>(
						getClient().getMapper(), BusinessSpecificMetadataInfo.class, getErrorHandler())).getBean();
	}

	@Override
	public BsmGroup saveBsmGroup(BsmGroup bsmGroup) {

		Argument.notNull("bsmGroup", bsmGroup);
		Argument.notNullOrEmpty("bsmGroup.groupId", bsmGroup.getGroupId());

		String actionPath = BSM_REGISTRY_SAVE_GROUP_PATH
				.replace("{groupId}", urlEncode(bsmGroup.getGroupId()));

		return call(getClient().getServerAddress(), actionPath, HttpMethod.PUT, bsmGroup,
				new BeanResponseHandler<>(getClient().getMapper(), BsmGroup.class, getErrorHandler())).getBean();
	}

	@Override
	public void deleteBsmGroup(String groupId) {

		Argument.notNullOrEmpty("groupId", groupId);

		String actionPath = BSM_REGISTRY_DELETE_GROUP_PATH.replace("{groupId}", urlEncode(groupId));

		call(getClient().getServerAddress(), actionPath, HttpMethod.DELETE,
				new VoidResponseHandler(getErrorHandler()));
	}

	@Override
	public BsmField saveBsmField(String groupId, BsmField bsmField) {

		Argument.notNullOrEmpty("groupId", groupId);
		Argument.notNull("bsmField", bsmField);
		Argument.notNullOrEmpty("bsmField.fieldId", bsmField.getFieldId());

		String actionPath = BSM_REGISTRY_SAVE_FIELD_PATH
				.replace("{groupId}", urlEncode(groupId))
				.replace("{fieldId}", urlEncode(bsmField.getFieldId()));

		return call(getClient().getServerAddress(), actionPath, HttpMethod.PUT, bsmField,
				new BeanResponseHandler<>(getClient().getMapper(), BsmField.class, getErrorHandler())).getBean();
	}

	@Override
	public void deleteBsmField(String groupId, String fieldId) {

		Argument.notNullOrEmpty("groupId", groupId);
		Argument.notNullOrEmpty("fieldId", fieldId);

		String actionPath = BSM_REGISTRY_DELETE_FIELD_PATH
				.replace("{groupId}", urlEncode(groupId))
				.replace("{fieldId}", urlEncode(fieldId));

		call(getClient().getServerAddress(), actionPath, HttpMethod.DELETE, new VoidResponseHandler(getErrorHandler()));
	}

	@Override
	public void expandFolder(String id, UtvidTilSaksmappe request) {

		Argument.notNullOrEmpty("id", id);

		call(
				getClient().getServerAddress(), EXPAND_FOLDER_PATH, HttpMethod.POST, request,
				new VoidResponseHandler(getErrorHandler()));
	}

	@Override
	public void expandBasicRecord(String id, UtvidTilJournalpost request) {

		Argument.notNullOrEmpty("id", id);

		call(
				getClient().getServerAddress(), EXPAND_BASIC_RECORD_PATH, HttpMethod.POST, request,
				new VoidResponseHandler(getErrorHandler()));
	}

	@Override
	public void bulkDelete(DeleteRequest request) {

		Argument.notNullOrEmpty("request", request);

		call(
				getClient().getServerAddress(), BULK_DELETE_PATH, HttpMethod.POST, request,
				new VoidResponseHandler(getErrorHandler()));
	}

	@Override
	public ChangeLogResponse changeLog(ChangeLogRequest request) {

		return call(getClient().getServerAddress(), CHANGE_LOG_PATH, HttpMethod.POST, request,
				new BeanResponseHandler<>(getClient().getMapper(), ChangeLogResponse.class, getErrorHandler()))
				.getBean();
	}

	@Override
	public AccessLogResponse accessLog(AccessLogRequest request) {

		return call(getClient().getServerAddress(), ACCESS_LOG_PATH, HttpMethod.POST, request,
				new BeanResponseHandler<>(getClient().getMapper(), AccessLogResponse.class, getErrorHandler()))
				.getBean();
	}

	@Override
	public MyInfoResponse myInfo() {

		return call(getClient().getServerAddress(), ME_PATH, HttpMethod.GET,
				new BeanResponseHandler<>(getClient().getMapper(), MyInfoResponse.class, getErrorHandler()))
				.getBean();
	}

	private ErrorResponseHandler getErrorHandler() {

		return new ErrorResponseHandler(getClient().getMapper(), getClient().getErrorResponseType());
	}

	private String urlEncode(String parameter, String value) {

		return String.format("%s=%s", parameter, urlEncode(value));
	}

	private String urlEncode(String value) {

		try {

			return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());

		} catch (UnsupportedEncodingException ex) {

			throw new ServiceException(ex);
		}
	}
}
