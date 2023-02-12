package org.opensearch.client.codegen;

import com.google.googlejavaformat.java.Formatter;
import com.google.googlejavaformat.java.FormatterException;
import com.google.googlejavaformat.java.JavaFormatterOptions;
import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.MustacheException;
import com.samskivert.mustache.Template;
import org.apache.commons.text.StringEscapeUtils;
import org.opensearch.client.codegen.exceptions.RenderException;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.MissingResourceException;

public class Renderer {
    private static final Map<String, Mustache.Lambda> lambdas = new HashMap<>() {{
        put("dq", (frag, out) -> out.write('\"' + StringEscapeUtils.escapeJava(frag.execute()) + '\"'));
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

    public <T> void render(T object) throws RenderException {
        try {
            Template template = compiler.loadTemplate(object.getClass().getSimpleName());
            Writer writer = new StringWriter();

            template.execute(object, lambdas, writer);

            String output = writer.toString();
            output = true ? formatter.formatSource(output) : output;

            System.out.println(output);
        } catch (MustacheException | FormatterException e) {
            throw new RenderException("Failed to render: " + object, e);
        }
    }
}
