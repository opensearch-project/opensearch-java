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

package org.opensearch.client.opensearch._types.mapping;

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
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.mapping.SemanticModelSelection

/**
 * Resolves the model to use for a semantic field from cluster settings instead of a hard-coded <code>model_id</code>. The
 * <code>model_type</code> and <code>language_option</code> pair maps to the cluster setting
 * <code>plugins.neural_search.model_selection.model_id.&lt;model_type&gt;.&lt;language_option&gt;</code> (lower-cased), whose value is the
 * resolved model id.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SemanticModelSelection
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<SemanticModelSelection.Builder, SemanticModelSelection> {

    @Nullable
    private final SemanticModelLanguageOption languageOption;

    @Nullable
    private final SemanticModelType modelType;

    // ---------------------------------------------------------------------------------------------

    private SemanticModelSelection(Builder builder) {
        this.languageOption = builder.languageOption;
        this.modelType = builder.modelType;
    }

    public static SemanticModelSelection of(Function<SemanticModelSelection.Builder, ObjectBuilder<SemanticModelSelection>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code language_option}
     */
    @Nullable
    public final SemanticModelLanguageOption languageOption() {
        return this.languageOption;
    }

    /**
     * API name: {@code model_type}
     */
    @Nullable
    public final SemanticModelType modelType() {
        return this.modelType;
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
        if (this.languageOption != null) {
            generator.writeKey("language_option");
            this.languageOption.serialize(generator, mapper);
        }

        if (this.modelType != null) {
            generator.writeKey("model_type");
            this.modelType.serialize(generator, mapper);
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
     * Builder for {@link SemanticModelSelection}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, SemanticModelSelection> {
        @Nullable
        private SemanticModelLanguageOption languageOption;
        @Nullable
        private SemanticModelType modelType;

        public Builder() {}

        private Builder(SemanticModelSelection o) {
            this.languageOption = o.languageOption;
            this.modelType = o.modelType;
        }

        private Builder(Builder o) {
            this.languageOption = o.languageOption;
            this.modelType = o.modelType;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code language_option}
         */
        @Nonnull
        public final Builder languageOption(@Nullable SemanticModelLanguageOption value) {
            this.languageOption = value;
            return this;
        }

        /**
         * API name: {@code model_type}
         */
        @Nonnull
        public final Builder modelType(@Nullable SemanticModelType value) {
            this.modelType = value;
            return this;
        }

        /**
         * Builds a {@link SemanticModelSelection}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SemanticModelSelection build() {
            _checkSingleUse();

            return new SemanticModelSelection(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SemanticModelSelection}
     */
    public static final JsonpDeserializer<SemanticModelSelection> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SemanticModelSelection::setupSemanticModelSelectionDeserializer
    );

    protected static void setupSemanticModelSelectionDeserializer(ObjectDeserializer<SemanticModelSelection.Builder> op) {
        op.add(Builder::languageOption, SemanticModelLanguageOption._DESERIALIZER, "language_option");
        op.add(Builder::modelType, SemanticModelType._DESERIALIZER, "model_type");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.languageOption);
        result = 31 * result + Objects.hashCode(this.modelType);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SemanticModelSelection other = (SemanticModelSelection) o;
        return Objects.equals(this.languageOption, other.languageOption) && Objects.equals(this.modelType, other.modelType);
    }
}
