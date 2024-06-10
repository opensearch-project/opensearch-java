/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.renderer.lambdas;

import com.samskivert.mustache.Template;
import java.util.Objects;
import javax.annotation.Nonnull;
import org.opensearch.client.codegen.model.Type;
import org.opensearch.client.codegen.utils.Strings;

public final class TypeQueryParamifyLambda extends TemplateRenderingLambda {
    @Nonnull
    private final Type type;

    public TypeQueryParamifyLambda(Type type) {
        super("Type/queryParamify");
        this.type = Objects.requireNonNull(type, "type must not be null");
    }

    @Override
    public Object getContext(Template.Fragment fragment) {
        return new Context(type, fragment.execute());
    }

    public static final class Context {
        @Nonnull
        private final Type type;
        @Nonnull
        private final String value;

        private Context(@Nonnull Type type, @Nonnull String value) {
            this.type = Objects.requireNonNull(type, "type must not be null");
            this.value = Strings.requireNonBlank(value, "value must not be blank");
        }

        @Nonnull
        public Type getType() {
            return type;
        }

        @Nonnull
        public String getValue() {
            return value;
        }
    }
}
