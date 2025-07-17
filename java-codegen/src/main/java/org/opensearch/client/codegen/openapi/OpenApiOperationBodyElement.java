/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.openapi;

import static org.opensearch.client.codegen.utils.Functional.ifNonnull;

import io.swagger.v3.oas.models.media.Content;
import java.util.Optional;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.codegen.utils.Clone;
import org.opensearch.client.codegen.utils.json.JsonGenerator;

public abstract class OpenApiOperationBodyElement<Self extends OpenApiOperationBodyElement<Self>> extends OpenApiRefElement<Self> {
    @Nullable
    private OpenApiContent content;

    OpenApiOperationBodyElement(@Nonnull AbstractBuilder<Self, ?> builder, @Nonnull Class<Self> clazz) {
        super(builder, clazz);
        setContent(builder.content);
    }

    OpenApiOperationBodyElement(@Nullable String $ref, @Nullable Content content, @Nonnull Class<Self> clazz) {
        super($ref, clazz);
        setContent(ifNonnull(content, OpenApiContent::new));
    }

    @Override
    void initialize(@Nullable OpenApiElement<?> parent, @Nonnull JsonPointer pointer) {
        super.initialize(parent, pointer);
        initializeChild("content", content);
    }

    @Nonnull
    public Optional<OpenApiContent> getContent() {
        return Optional.ofNullable(content);
    }

    public void setContent(@Nullable OpenApiContent content) {
        this.content = content;
        initializeChild("content", content);
    }

    @Override
    protected void toJsonInner(JsonGenerator generator) {
        super.toJsonInner(generator);
        if (content != null) {
            generator.writeField("content", content);
        }
    }

    @Nonnull
    <Builder extends AbstractBuilder<Self, Builder>> Builder toBuilder(@Nonnull Builder builder) {
        return super.toBuilder(builder).withContent(ifNonnull(content, Clone::clone));
    }

    protected static abstract class AbstractBuilder<
        Element extends OpenApiOperationBodyElement<Element>,
        Builder extends AbstractBuilder<Element, Builder>> extends OpenApiRefElement.AbstractBuilder<Element, Builder> {
        @Nullable
        private OpenApiContent content;

        AbstractBuilder() {}

        @Nonnull
        public Builder withContent(@Nullable OpenApiContent content) {
            this.content = content;
            return self();
        }
    }
}
