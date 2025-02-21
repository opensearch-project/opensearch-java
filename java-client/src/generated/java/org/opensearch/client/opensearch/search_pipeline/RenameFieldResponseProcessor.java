/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

/*
 * Licensed to Elasticsearch B.V. under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch B.V. licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

/*
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
 */

//----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------

package org.opensearch.client.opensearch.search_pipeline;

import jakarta.json.stream.JsonGenerator;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: search_pipeline.RenameFieldResponseProcessor

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RenameFieldResponseProcessor
    implements
        ResponseProcessorVariant,
        PlainJsonSerializable,
        ToCopyableBuilder<RenameFieldResponseProcessor.Builder, RenameFieldResponseProcessor> {

    @Nullable
    private final String description;

    @Nonnull
    private final String field;

    @Nullable
    private final Boolean ignoreFailure;

    @Nullable
    private final String tag;

    @Nonnull
    private final String targetField;

    // ---------------------------------------------------------------------------------------------

    private RenameFieldResponseProcessor(Builder builder) {
        this.description = builder.description;
        this.field = ApiTypeHelper.requireNonNull(builder.field, this, "field");
        this.ignoreFailure = builder.ignoreFailure;
        this.tag = builder.tag;
        this.targetField = ApiTypeHelper.requireNonNull(builder.targetField, this, "targetField");
    }

    public static RenameFieldResponseProcessor of(
        Function<RenameFieldResponseProcessor.Builder, ObjectBuilder<RenameFieldResponseProcessor>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link ResponseProcessor} variant kind.
     */
    @Override
    public ResponseProcessor.Kind _responseProcessorKind() {
        return ResponseProcessor.Kind.RenameField;
    }

    /**
     * API name: {@code description}
     */
    @Nullable
    public final String description() {
        return this.description;
    }

    /**
     * Required - API name: {@code field}
     */
    @Nonnull
    public final String field() {
        return this.field;
    }

    /**
     * API name: {@code ignore_failure}
     */
    @Nullable
    public final Boolean ignoreFailure() {
        return this.ignoreFailure;
    }

    /**
     * API name: {@code tag}
     */
    @Nullable
    public final String tag() {
        return this.tag;
    }

    /**
     * Required - API name: {@code target_field}
     */
    @Nonnull
    public final String targetField() {
        return this.targetField;
    }

    /**
     * Serialize this object to JSON.
     */
    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        if (this.description != null) {
            generator.writeKey("description");
            generator.write(this.description);
        }

        generator.writeKey("field");
        generator.write(this.field);

        if (this.ignoreFailure != null) {
            generator.writeKey("ignore_failure");
            generator.write(this.ignoreFailure);
        }

        if (this.tag != null) {
            generator.writeKey("tag");
            generator.write(this.tag);
        }

        generator.writeKey("target_field");
        generator.write(this.targetField);
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    @Nonnull
    public Builder toBuilder() {
        return new Builder(this);
    }

    @Nonnull
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builder for {@link RenameFieldResponseProcessor}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, RenameFieldResponseProcessor> {
        @Nullable
        private String description;
        private String field;
        @Nullable
        private Boolean ignoreFailure;
        @Nullable
        private String tag;
        private String targetField;

        public Builder() {}

        private Builder(RenameFieldResponseProcessor o) {
            this.description = o.description;
            this.field = o.field;
            this.ignoreFailure = o.ignoreFailure;
            this.tag = o.tag;
            this.targetField = o.targetField;
        }

        private Builder(Builder o) {
            this.description = o.description;
            this.field = o.field;
            this.ignoreFailure = o.ignoreFailure;
            this.tag = o.tag;
            this.targetField = o.targetField;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code description}
         */
        @Nonnull
        public final Builder description(@Nullable String value) {
            this.description = value;
            return this;
        }

        /**
         * Required - API name: {@code field}
         */
        @Nonnull
        public final Builder field(String value) {
            this.field = value;
            return this;
        }

        /**
         * API name: {@code ignore_failure}
         */
        @Nonnull
        public final Builder ignoreFailure(@Nullable Boolean value) {
            this.ignoreFailure = value;
            return this;
        }

        /**
         * API name: {@code tag}
         */
        @Nonnull
        public final Builder tag(@Nullable String value) {
            this.tag = value;
            return this;
        }

        /**
         * Required - API name: {@code target_field}
         */
        @Nonnull
        public final Builder targetField(String value) {
            this.targetField = value;
            return this;
        }

        /**
         * Builds a {@link RenameFieldResponseProcessor}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RenameFieldResponseProcessor build() {
            _checkSingleUse();

            return new RenameFieldResponseProcessor(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RenameFieldResponseProcessor}
     */
    public static final JsonpDeserializer<RenameFieldResponseProcessor> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RenameFieldResponseProcessor::setupRenameFieldResponseProcessorDeserializer
    );

    protected static void setupRenameFieldResponseProcessorDeserializer(ObjectDeserializer<RenameFieldResponseProcessor.Builder> op) {
        op.add(Builder::description, JsonpDeserializer.stringDeserializer(), "description");
        op.add(Builder::field, JsonpDeserializer.stringDeserializer(), "field");
        op.add(Builder::ignoreFailure, JsonpDeserializer.booleanDeserializer(), "ignore_failure");
        op.add(Builder::tag, JsonpDeserializer.stringDeserializer(), "tag");
        op.add(Builder::targetField, JsonpDeserializer.stringDeserializer(), "target_field");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.description);
        result = 31 * result + this.field.hashCode();
        result = 31 * result + Objects.hashCode(this.ignoreFailure);
        result = 31 * result + Objects.hashCode(this.tag);
        result = 31 * result + this.targetField.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RenameFieldResponseProcessor other = (RenameFieldResponseProcessor) o;
        return Objects.equals(this.description, other.description)
            && this.field.equals(other.field)
            && Objects.equals(this.ignoreFailure, other.ignoreFailure)
            && Objects.equals(this.tag, other.tag)
            && this.targetField.equals(other.targetField);
    }
}
