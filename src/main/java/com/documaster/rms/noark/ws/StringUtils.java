package com.documaster.rms.noark.ws;

public class StringUtils {

	public static boolean isBlank(String str) {

		if (str == null || str.length() == 0) {

			return true;
		}

		for (int i = 0; i < str.length(); i++) {

			if (!Character.isWhitespace(str.charAt(i))) {

				return false;
			}
		}

		return true;
	}

	public static boolean isNotBlank(String str) {

		return !isBlank(str);
	}

	/**
	 * Uncapitalizes a String changing the first letter to lowercase. No other letters are changed.
	 */
	public static String uncapitalize(String str) {

		if (str == null || str.length() == 0) {

			return str;
		}

		return new StringBuilder(str.length())
				.append(Character.toLowerCase(str.charAt(0)))
				.append(str.substring(1))
				.toString();
	}

	public static boolean isWhitespace(String str) {

		if (str == null) {

			return false;
		}

		for (int i = 0; i < str.length(); i++) {

			if (!Character.isWhitespace(str.charAt(i))) {

				return false;
			}
		}

		return true;
	}
}
