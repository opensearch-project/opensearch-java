/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.utils;

import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

public final class Markdown {
    private Markdown() {}

    private static final Parser PARSER = Parser.builder().build();
    private static final HtmlRenderer RENDERER = HtmlRenderer.builder().escapeHtml(true).omitSingleParagraphP(true).build();

    private static final Pattern SITE_URL_PLACEHOLDER = Pattern.compile("\\{\\{site.url}}");
    private static final String SITE_URL_REPLACEMENT = "https://opensearch.org";
    private static final Pattern SITE_BASE_URL_PLACEHOLDER = Pattern.compile("\\{\\{site.baseurl}}");
    private static final String SITE_BASE_URL_REPLACEMENT = "/docs/latest";

    @Nonnull
    public static String toJavaDocHtml(@Nonnull String markdown) {
        var html = RENDERER.render(PARSER.parse(markdown)).strip();
        html = SITE_URL_PLACEHOLDER.matcher(html).replaceAll(SITE_URL_REPLACEMENT);
        html = SITE_BASE_URL_PLACEHOLDER.matcher(html).replaceAll(SITE_BASE_URL_REPLACEMENT);
        return html;
    }
}
