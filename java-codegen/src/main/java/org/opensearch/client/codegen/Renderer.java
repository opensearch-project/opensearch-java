/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen;

import com.google.googlejavaformat.java.Formatter;
import com.google.googlejavaformat.java.FormatterException;
import com.google.googlejavaformat.java.JavaFormatterOptions;
import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.MustacheException;
import com.samskivert.mustache.Template;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.function.Function;
import org.apache.commons.text.StringEscapeUtils;
import org.opensearch.client.codegen.exceptions.RenderException;
import org.opensearch.client.codegen.utils.Strings;

public class Renderer {
    public static final Renderer INSTANCE = new Renderer();

    public static Mustache.Lambda transformer(Function<String, String> transform) {
        return ((frag, out) -> out.write(transform.apply(frag.execute())));
    }

    public static Mustache.Lambda templateLambda(String templateName, Function<Template.Fragment, Object> contextGetter) {
        return (frag, out) -> {
            try {
                Renderer.INSTANCE.render(templateName, contextGetter.apply(frag), out);
            } catch (RenderException e) {
                throw new RuntimeException(e);
            }
        };
    }

    private static final Map<String, Mustache.Lambda> lambdas = new HashMap<>() {{
        put("quoted", transformer(s -> '\"' + StringEscapeUtils.escapeJava(s) + '\"'));
        put("camelCase", transformer(Strings::toCamelCase));
        put("toLower", transformer(String::toLowerCase));
    }};

    private final Mustache.Compiler compiler;
    private final Formatter formatter;

    private Renderer() {
        compiler = Mustache.compiler()
                .escapeHTML(false)
                .withLoader(name -> {
                            InputStream stream = Renderer.class.getResourceAsStream("templates/" + name + ".mustache");
                            if (stream == null) {
                                throw new MissingResourceException("Unable to find template", Renderer.class.getName(), name);
                            }
                            return new InputStreamReader(stream);
                        }
                );

        formatter = new Formatter(
                JavaFormatterOptions.builder()
                        .style(JavaFormatterOptions.Style.AOSP)
                        .formatJavadoc(true)
                        .build());
    }

    public void render(String templateName, Object context, Writer out) throws RenderException {
        try {
            compiler.loadTemplate(templateName)
                    .execute(context, lambdas, out);
        } catch (MustacheException e) {
            throw new RenderException("Failed to render: " + context, e);
        }
    }

    public String renderJava(String templateName, Object context) throws RenderException {
        Writer writer = new StringWriter();

        render(templateName, context, writer);

        String output = writer.toString();

        try {
            return formatter.formatSource(output);
        } catch (FormatterException e) {
            return "// FAILED FORMATTING: " + e + "\n\n" + output;
        }
    }

    public void renderJava(Object context, File outputFile) throws RenderException {
        renderJava(context.getClass().getSimpleName(), context, outputFile);
    }

    public void renderJava(String templateName, Object context, File outputFile) throws RenderException {
        String output = renderJava(templateName, context);
        try (Writer writer = new FileWriter(outputFile)) {
            writer.write(output);
        } catch (IOException e) {
            throw new RenderException("Unable to write rendered output to: " + outputFile, e);
        }
    }
}
