/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.util;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.BitSet;

/**
 * Percent-encoding.
 * <p>
 * Adapted from Apache HttpComponents HttpCore v5's <a href="https://github.com/apache/httpcomponents-core/blob/e009a923eefe79cf3593efbb0c18a3525ae63669/httpcore5/src/main/java/org/apache/hc/core5/net/PercentCodec.java">PercentCodec.java</a>
 * </p>
 */
class PercentCodec {
    private static class Chars {
        private final BitSet set = new BitSet(256);

        public void add(char... chars) {
            for (char c : chars) {
                set.set(c);
            }
        }

        public void addRange(char start, char end) {
            set.set(start, end + 1);
        }

        public void add(Chars set) {
            this.set.or(set.set);
        }

        public boolean contains(int c) {
            return set.get(c);
        }
    }

    private static final Chars RFC3986_GEN_DELIMS_CHARS = new Chars() {
        {
            add(':', '/', '?', '#', '[', ']', '@');
        }
    };
    private static final Chars RFC3986_SUB_DELIMS_CHARS = new Chars() {
        {
            add('!', '$', '&', '\'', '(', ')', '*', '+', ',', ';', '=');
        }
    };
    private static final Chars RFC3986_UNRESERVED_CHARS = new Chars() {
        {
            addRange('a', 'z');
            addRange('A', 'Z');
            addRange('0', '9');
            add('-', '.', '_', '~');
        }
    };
    private static final Chars RFC3986_PATH_NO_COLON_CHARS = new Chars() {
        {
            add(RFC3986_UNRESERVED_CHARS);
            add(RFC3986_SUB_DELIMS_CHARS);
            add('@');
        }
    };
    private static final Chars RFC3986_PATH_CHARS = new Chars() {
        {
            add(RFC3986_PATH_NO_COLON_CHARS);
            add(':');
        }
    };
    private static final Chars RFC3986_URIC_CHARS = new Chars() {
        {
            add(RFC3986_SUB_DELIMS_CHARS);
            add(RFC3986_UNRESERVED_CHARS);
        }
    };

    private static final Chars RFC5987_UNRESERVED_CHARS = new Chars() {
        {
            addRange('a', 'z');
            addRange('A', 'Z');
            addRange('0', '9');
            // Additional characters as per RFC 5987 attr-char
            add('!', '#', '$', '&', '+', '-', '.', '^', '_', '`', '|', '~');
        }
    };

    private static final int RADIX = 16;

    private static void encode(
        final StringBuilder buf,
        final CharSequence content,
        final Charset charset,
        final Chars safeChars,
        final boolean blankAsPlus
    ) {
        if (content == null) {
            return;
        }
        final CharBuffer cb = CharBuffer.wrap(content);
        final ByteBuffer bb = (charset != null ? charset : StandardCharsets.UTF_8).encode(cb);
        while (bb.hasRemaining()) {
            final int b = bb.get() & 0xff;
            if (safeChars.contains(b)) {
                buf.append((char) b);
            } else if (blankAsPlus && b == ' ') {
                buf.append("+");
            } else {
                buf.append("%");
                final char hex1 = Character.toUpperCase(Character.forDigit((b >> 4) & 0xF, RADIX));
                final char hex2 = Character.toUpperCase(Character.forDigit(b & 0xF, RADIX));
                buf.append(hex1);
                buf.append(hex2);
            }
        }
    }

    private static String decode(final CharSequence content, final Charset charset, final boolean plusAsBlank) {
        if (content == null) {
            return null;
        }
        final ByteBuffer bb = ByteBuffer.allocate(content.length());
        final CharBuffer cb = CharBuffer.wrap(content);
        while (cb.hasRemaining()) {
            final char c = cb.get();
            if (c == '%' && cb.remaining() >= 2) {
                final char uc = cb.get();
                final char lc = cb.get();
                final int u = Character.digit(uc, RADIX);
                final int l = Character.digit(lc, RADIX);
                if (u != -1 && l != -1) {
                    bb.put((byte) ((u << 4) + l));
                } else {
                    bb.put((byte) '%');
                    bb.put((byte) uc);
                    bb.put((byte) lc);
                }
            } else if (plusAsBlank && c == '+') {
                bb.put((byte) ' ');
            } else {
                bb.put((byte) c);
            }
        }
        bb.flip();
        return (charset != null ? charset : StandardCharsets.UTF_8).decode(bb).toString();
    }

    public static final PercentCodec RFC3986_UNRESERVED = new PercentCodec(RFC3986_UNRESERVED_CHARS);
    public static final PercentCodec RFC3986_PATH = new PercentCodec(RFC3986_PATH_CHARS);
    public static final PercentCodec RFC5987_UNRESERVED = new PercentCodec(RFC5987_UNRESERVED_CHARS);

    private final Chars unreserved;

    private PercentCodec(final Chars unreserved) {
        this.unreserved = unreserved;
    }

    public void encode(final StringBuilder buf, final CharSequence content) {
        encode(buf, content, StandardCharsets.UTF_8, unreserved, false);
    }

    public String encode(final CharSequence content) {
        if (content == null) {
            return null;
        }
        final StringBuilder buf = new StringBuilder();
        encode(buf, content, StandardCharsets.UTF_8, unreserved, false);
        return buf.toString();
    }

    public String decode(final CharSequence content) {
        return decode(content, StandardCharsets.UTF_8, false);
    }
}
