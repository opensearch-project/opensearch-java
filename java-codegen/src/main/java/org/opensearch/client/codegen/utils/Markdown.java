/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.utils;

import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

public final class Markdown {
    private Markdown() {}

    private static final Parser PARSER = Parser.builder().build();
    private static final HtmlRenderer RENDERER = HtmlRenderer.builder().omitSingleParagraphP(true).build();

    public static String toJavaDocHtml(String markdown) {
        return RENDERER.render(PARSER.parse(markdown)).strip();
    }
}
