/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.utils;

import javax.annotation.Nonnull;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

public final class Markdown {
    private Markdown() {}

    private static final Parser PARSER = Parser.builder().build();
    private static final HtmlRenderer RENDERER = HtmlRenderer.builder().escapeHtml(true).omitSingleParagraphP(true).build();

    @Nonnull
    public static String toJavaDocHtml(@Nonnull String markdown) {
        return RENDERER.render(PARSER.parse(markdown)).strip();
    }
}
