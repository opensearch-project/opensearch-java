/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.renderer.lambdas;

import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;
import java.io.IOException;
import java.io.Writer;
import javax.annotation.Nonnull;
import org.opensearch.client.codegen.exceptions.RenderException;
import org.opensearch.client.codegen.renderer.TemplateFragmentUtils;
import org.opensearch.client.codegen.renderer.TemplateGlobalContext;
import org.opensearch.client.codegen.utils.Strings;

public abstract class TemplateRenderingLambda implements Mustache.Lambda {
    @Nonnull
    private final String templateName;

    protected TemplateRenderingLambda(@Nonnull String templateName) {
        this.templateName = Strings.requireNonBlank(templateName, "templateName must not be blank");
    }

    @Override
    public void execute(Template.Fragment fragment, Writer out) throws IOException {
        var renderer = TemplateFragmentUtils.findParentContext(fragment, TemplateGlobalContext.class).orElseThrow().getRenderer();

        try {
            var content = renderer.render(templateName, getContext(fragment));
            out.write(content.strip());
        } catch (RenderException e) {
            throw new RuntimeException(e);
        }
    }

    public abstract Object getContext(Template.Fragment fragment);
}
