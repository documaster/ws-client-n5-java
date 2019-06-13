package com.documaster.rms.noark.ws;

public class Argument {

	public static void notNullOrEmpty(String argName, String value) {

		notNull(argName, value);

		if (StringUtils.isWhitespace(value)) {

			throw new IllegalArgumentException(
					String.format("Value cannot be empty string. Parameter name: %s", argName));
		}
	}

	public static void notNullOrEmpty(String argName, Object... value) {

		notNull(argName, value);

		if (value.length == 0) {

			throw new IllegalArgumentException(
					String.format("Value cannot be empty varargs. Parameter name: %s", argName));

		}

		for (int index = 0; index < value.length; index++) {

			Argument.notNull(String.format("%s[%d]", argName, index), value[index]);
		}
	}

	public static void notNullOrEmpty(String argName, String... value) {

		notNull(argName, value);

		if (value.length == 0) {

			throw new IllegalArgumentException(
					String.format("Value cannot be empty varargs. Parameter name: %s", argName));

		}

		for (int index = 0; index < value.length; index++) {

			Argument.notNullOrEmpty(String.format("%s[%d]", argName, index), value[index]);
		}
	}

	public static void notNull(String argName, Object value) {

		if (value == null) {

			throw new IllegalArgumentException("Argument " + argName + " must not be null.");
		}
	}

	public static void assertFail(String argName, String message) {

		throw new IllegalArgumentException(String.format("%s. Parameter name: %s", message, argName));
	}
}
