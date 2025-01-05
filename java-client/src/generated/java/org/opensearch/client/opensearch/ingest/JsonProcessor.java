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

package org.opensearch.client.opensearch.ingest;

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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ingest.JsonProcessor

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class JsonProcessor extends ProcessorBase implements ProcessorVariant, ToCopyableBuilder<JsonProcessor.Builder, JsonProcessor> {

    @Nullable
    private final Boolean addToRoot;

    @Nullable
    private final JsonProcessorConflictStrategy addToRootConflictStrategy;

    @Nullable
    private final Boolean allowDuplicateKeys;

    @Nonnull
    private final String field;

    @Nullable
    private final String targetField;

    // ---------------------------------------------------------------------------------------------

    private JsonProcessor(Builder builder) {
        super(builder);
        this.addToRoot = builder.addToRoot;
        this.addToRootConflictStrategy = builder.addToRootConflictStrategy;
        this.allowDuplicateKeys = builder.allowDuplicateKeys;
        this.field = ApiTypeHelper.requireNonNull(builder.field, this, "field");
        this.targetField = builder.targetField;
    }

    public static JsonProcessor of(Function<JsonProcessor.Builder, ObjectBuilder<JsonProcessor>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Processor} variant kind.
     */
    @Override
    public Processor.Kind _processorKind() {
        return Processor.Kind.Json;
    }

    /**
     * Flag that forces the parsed JSON to be added at the top level of the document. <code>target_field</code> must not be set when this
     * option is chosen.
     * <p>
     * API name: {@code add_to_root}
     * </p>
     */
    @Nullable
    public final Boolean addToRoot() {
        return this.addToRoot;
    }

    /**
     * API name: {@code add_to_root_conflict_strategy}
     */
    @Nullable
    public final JsonProcessorConflictStrategy addToRootConflictStrategy() {
        return this.addToRootConflictStrategy;
    }

    /**
     * When set to <code>true</code>, the JSON parser will not fail if the JSON contains duplicate keys. Instead, the last encountered value
     * for any duplicate key wins.
     * <p>
     * API name: {@code allow_duplicate_keys}
     * </p>
     */
    @Nullable
    public final Boolean allowDuplicateKeys() {
        return this.allowDuplicateKeys;
    }

    /**
     * Required - API name: {@code field}
     */
    @Nonnull
    public final String field() {
        return this.field;
    }

    /**
     * API name: {@code target_field}
     */
    @Nullable
    public final String targetField() {
        return this.targetField;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.addToRoot != null) {
            generator.writeKey("add_to_root");
            generator.write(this.addToRoot);
        }

        if (this.addToRootConflictStrategy != null) {
            generator.writeKey("add_to_root_conflict_strategy");
            this.addToRootConflictStrategy.serialize(generator, mapper);
        }

        if (this.allowDuplicateKeys != null) {
            generator.writeKey("allow_duplicate_keys");
            generator.write(this.allowDuplicateKeys);
        }

        generator.writeKey("field");
        generator.write(this.field);

        if (this.targetField != null) {
            generator.writeKey("target_field");
            generator.write(this.targetField);
        }
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
     * Builder for {@link JsonProcessor}.
     */
    public static class Builder extends ProcessorBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, JsonProcessor> {
        @Nullable
        private Boolean addToRoot;
        @Nullable
        private JsonProcessorConflictStrategy addToRootConflictStrategy;
        @Nullable
        private Boolean allowDuplicateKeys;
        private String field;
        @Nullable
        private String targetField;

        public Builder() {}

        private Builder(JsonProcessor o) {
            super(o);
            this.addToRoot = o.addToRoot;
            this.addToRootConflictStrategy = o.addToRootConflictStrategy;
            this.allowDuplicateKeys = o.allowDuplicateKeys;
            this.field = o.field;
            this.targetField = o.targetField;
        }

        private Builder(Builder o) {
            super(o);
            this.addToRoot = o.addToRoot;
            this.addToRootConflictStrategy = o.addToRootConflictStrategy;
            this.allowDuplicateKeys = o.allowDuplicateKeys;
            this.field = o.field;
            this.targetField = o.targetField;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        @Override
        @Nonnull
        protected Builder self() {
            return this;
        }

        /**
         * Flag that forces the parsed JSON to be added at the top level of the document. <code>target_field</code> must not be set when
         * this option is chosen.
         * <p>
         * API name: {@code add_to_root}
         * </p>
         */
        @Nonnull
        public final Builder addToRoot(@Nullable Boolean value) {
            this.addToRoot = value;
            return this;
        }

        /**
         * API name: {@code add_to_root_conflict_strategy}
         */
        @Nonnull
        public final Builder addToRootConflictStrategy(@Nullable JsonProcessorConflictStrategy value) {
            this.addToRootConflictStrategy = value;
            return this;
        }

        /**
         * When set to <code>true</code>, the JSON parser will not fail if the JSON contains duplicate keys. Instead, the last encountered
         * value for any duplicate key wins.
         * <p>
         * API name: {@code allow_duplicate_keys}
         * </p>
         */
        @Nonnull
        public final Builder allowDuplicateKeys(@Nullable Boolean value) {
            this.allowDuplicateKeys = value;
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
         * API name: {@code target_field}
         */
        @Nonnull
        public final Builder targetField(@Nullable String value) {
            this.targetField = value;
            return this;
        }

        /**
         * Builds a {@link JsonProcessor}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public JsonProcessor build() {
            _checkSingleUse();

            return new JsonProcessor(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link JsonProcessor}
     */
    public static final JsonpDeserializer<JsonProcessor> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        JsonProcessor::setupJsonProcessorDeserializer
    );

    protected static void setupJsonProcessorDeserializer(ObjectDeserializer<JsonProcessor.Builder> op) {
        setupProcessorBaseDeserializer(op);
        op.add(Builder::addToRoot, JsonpDeserializer.booleanDeserializer(), "add_to_root");
        op.add(Builder::addToRootConflictStrategy, JsonProcessorConflictStrategy._DESERIALIZER, "add_to_root_conflict_strategy");
        op.add(Builder::allowDuplicateKeys, JsonpDeserializer.booleanDeserializer(), "allow_duplicate_keys");
        op.add(Builder::field, JsonpDeserializer.stringDeserializer(), "field");
        op.add(Builder::targetField, JsonpDeserializer.stringDeserializer(), "target_field");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.addToRoot);
        result = 31 * result + Objects.hashCode(this.addToRootConflictStrategy);
        result = 31 * result + Objects.hashCode(this.allowDuplicateKeys);
        result = 31 * result + this.field.hashCode();
        result = 31 * result + Objects.hashCode(this.targetField);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        JsonProcessor other = (JsonProcessor) o;
        return Objects.equals(this.addToRoot, other.addToRoot)
            && Objects.equals(this.addToRootConflictStrategy, other.addToRootConflictStrategy)
            && Objects.equals(this.allowDuplicateKeys, other.allowDuplicateKeys)
            && this.field.equals(other.field)
            && Objects.equals(this.targetField, other.targetField);
    }
}
