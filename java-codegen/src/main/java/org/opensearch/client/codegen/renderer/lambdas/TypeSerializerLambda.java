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
import org.opensearch.client.codegen.model.types.TypeRef;
import org.opensearch.client.codegen.renderer.TemplateFragmentUtils;
import org.opensearch.client.codegen.utils.Strings;

public final class TypeSerializerLambda extends TemplateRenderingLambda {
    @Nonnull
    private final TypeRef type;

    public TypeSerializerLambda(TypeRef type, boolean direct) {
        super("Type/" + (direct ? "directSerializer" : "serializer"));
        this.type = Objects.requireNonNull(type, "type must not be null");
    }

    @Override
    public Object getContext(Template.Fragment fragment) {
        var depth = TemplateFragmentUtils.findParentContext(fragment, Context.class).map(ctx -> ctx.depth + 1).orElse(0);
        return new Context(type, fragment.execute(), depth);
    }

    public static final class Context {
        @Nonnull
        private final TypeRef type;
        @Nonnull
        private final String value;
        private final int depth;

        private Context(@Nonnull TypeRef type, @Nonnull String value, int depth) {
            this.type = Objects.requireNonNull(type, "type must not be null");
            this.value = Strings.requireNonBlank(value, "value must not be blank");
            this.depth = depth;
        }

        @Nonnull
        public TypeRef getType() {
            return type;
        }

        @Nonnull
        public String getValue() {
            return value;
        }

        public int getDepth() {
            return depth;
        }
    }
}
