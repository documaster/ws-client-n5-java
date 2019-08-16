package com.documaster.rms.noark.ws.constants;

import java.util.Objects;

import com.documaster.rms.noark.ws.client.codelist.CodeValue;

public abstract class NoarkEnum implements CodeValue {

	private final String code;
	private final String name;
	private String description;

	protected NoarkEnum(String code) {

		this(code, null, null);
	}

	protected NoarkEnum(String code, String name) {

		this(code, name, null);
	}

	protected NoarkEnum(String code, String name, String description) {

		this.code = code;
		this.name = name;
		this.description = description;
	}

	@Override
	public String getCode() {

		return code;
	}

	@Override
	public String getName() {

		return name;
	}

	@Override
	public String getDescription() {

		return description;
	}

	@Override
	public void setDescription(String description) {

		this.description = description;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj) {

			return true;
		}

		if (obj == null || getClass() != obj.getClass()) {

			return false;
		}

		String objCode = ((NoarkEnum) obj).getCode();
		return Objects.equals(code, objCode);
	}

	@Override
	public int hashCode() {

		return Objects.hashCode(code);
	}
}
