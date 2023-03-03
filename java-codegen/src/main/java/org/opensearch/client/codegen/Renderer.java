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
import java.util.function.Function;
import org.apache.commons.text.StringEscapeUtils;
import org.opensearch.client.codegen.exceptions.RenderException;

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
import org.opensearch.client.codegen.utils.Strings;

public class Renderer {
    private static Mustache.Lambda transformer(Function<String, String> transform) {
        return ((frag, out) -> out.write(transform.apply(frag.execute())));
    }

    private static final Map<String, Mustache.Lambda> lambdas = new HashMap<>() {{
        put("quoted", transformer(s -> '\"' + StringEscapeUtils.escapeJava(s) + '\"'));
        put("camelCase", transformer(Strings::toCamelCase));
    }};

    private final Mustache.Compiler compiler;
    private final Formatter formatter;

    public Renderer() {
        compiler = Mustache.compiler().withLoader(name -> {
            InputStream stream = Renderer.class.getResourceAsStream("templates/" + name + ".mustache");
            if (stream == null) {
                throw new MissingResourceException("Unable to find template", Renderer.class.getName(), name);
            }
            return new InputStreamReader(stream);
        });
        formatter = new Formatter(
                JavaFormatterOptions.builder()
                .style(JavaFormatterOptions.Style.AOSP)
                .formatJavadoc(true)
                .build());
    }

    public String render(Object object, String templateName) throws RenderException {
        try {
            Template template = compiler.loadTemplate(templateName);
            Writer writer = new StringWriter();

            template.execute(object, lambdas, writer);

            String output = writer.toString();

            try {
                output = formatter.formatSource(output);
            } catch (FormatterException e) {
                output = "// FAILED FORMATTING: " + e + "\n\n" + output;
            }

            return output;
        } catch (MustacheException e) {
            throw new RenderException("Failed to render: " + object, e);
        }
    }

    public void render(Object object, File outputFile) throws RenderException {
        render(object, object.getClass().getSimpleName(), outputFile);
    }

    public void render(Object object, String templateName, File outputFile) throws RenderException {
        String output = render(object, templateName);
        try (Writer writer = new FileWriter(outputFile)) {
            writer.write(output);
        } catch (IOException e) {
            throw new RenderException("Unable to write rendered output to: " + outputFile, e);
        }
    }
}
