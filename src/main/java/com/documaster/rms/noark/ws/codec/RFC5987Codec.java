package com.documaster.rms.noark.ws.codec;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.BitSet;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.codec.net.URLCodec;

/**
 * Implements the encoding scheme specified in
 * <a href="https://tools.ietf.org/html/rfc5987#section-3.2">RFC 5987, Section 3.2</a>.
 */
public class RFC5987Codec {

	private static final byte ESCAPE_CHAR = '%';

	private static final int RADIX = 16;

	/**
	 * BitSet of safe characters (RFC 5987, Section 3.2)
	 */
	private static final BitSet RFC_5987 = new BitSet(256);

	// static initializer for RFC_5987
	static {

		// alpha characters
		for (int i = 'a'; i <= 'z'; i++) {

			RFC_5987.set(i);
		}

		for (int i = 'A'; i <= 'Z'; i++) {

			RFC_5987.set(i);
		}

		// numeric characters
		for (int i = '0'; i <= '9'; i++) {

			RFC_5987.set(i);
		}

		// other safe characters
		RFC_5987.set('!');
		RFC_5987.set('#');
		RFC_5987.set('$');
		RFC_5987.set('&');
		RFC_5987.set('+');
		RFC_5987.set('-');
		RFC_5987.set('.');
		RFC_5987.set('^');
		RFC_5987.set('_');
		RFC_5987.set('`');
		RFC_5987.set('|');
		RFC_5987.set('~');
	}

	/**
	 * Encodes a string. Unsafe characters are escaped.
	 *
	 * @param str
	 * 		string to encode
	 * @param charset
	 * 		the charset for str
	 * @return encoded string
	 */
	public static String encode(final String str, final String charset) throws UnsupportedEncodingException {

		if (str == null) {

			return null;
		}

		return StringUtils.newStringUsAscii(URLCodec.encodeUrl(RFC_5987, str.getBytes(charset)));
	}

	/**
	 * Encodes a string. Unsafe characters are escaped.
	 *
	 * @param str
	 * 		string to encode
	 * @param charset
	 * 		the charset for str
	 * @return encoded string
	 */
	public static String encode(final String str, final Charset charset) {

		if (str == null) {

			return null;
		}

		return StringUtils.newStringUsAscii(URLCodec.encodeUrl(RFC_5987, str.getBytes(charset)));
	}

	/**
	 * Decodes a string into its original form. Escaped characters are converted back to their
	 * original representation.
	 *
	 * @param str
	 * 		string to convert to its original form
	 * @param charset
	 * 		the original string charset
	 * @return original string
	 */
	public static String decode(final String str, final String charset)
			throws DecoderException, UnsupportedEncodingException {

		return decode(str, Charset.forName(charset));
	}

	/**
	 * Decodes a string into its original form. Escaped characters are converted back to their
	 * original representation.
	 *
	 * @param str
	 * 		string to convert to its original form
	 * @param charset
	 * 		the original string charset
	 * @return original string
	 */
	public static String decode(final String str, final Charset charset) throws DecoderException {

		byte[] bytes = StringUtils.getBytesUsAscii(str);

		if (bytes == null) {

			return null;
		}

		final ByteArrayOutputStream buffer = new ByteArrayOutputStream();

		for (int i = 0; i < bytes.length; i++) {

			final int b = bytes[i];

			if (b == ESCAPE_CHAR) {

				try {

					final int u = digit16(bytes[++i]);
					final int l = digit16(bytes[++i]);
					buffer.write((char) ((u << 4) + l));

				} catch (final ArrayIndexOutOfBoundsException e) {

					throw new DecoderException("Invalid encoding: ", e);
				}

			} else {

				buffer.write(b);
			}
		}

		return new String(buffer.toByteArray(), charset);
	}

	private static int digit16(final byte b) throws DecoderException {

		final int i = Character.digit((char) b, RADIX);

		if (i == -1) {

			throw new DecoderException("Invalid encoding: not a valid digit (radix " + RADIX + "): " + b);
		}

		return i;
	}

}
