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

package org.opensearch.client.opensearch.indices;

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

// typedef: indices.IndexSettingsMappingDynamicProperties

/**
 * Limits on dynamically created properties.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IndexSettingsMappingDynamicProperties
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<IndexSettingsMappingDynamicProperties.Builder, IndexSettingsMappingDynamicProperties> {

    @Nullable
    private final IndexSettingsMappingDynamicPropertiesLuceneField luceneField;

    // ---------------------------------------------------------------------------------------------

    private IndexSettingsMappingDynamicProperties(Builder builder) {
        this.luceneField = builder.luceneField;
    }

    public static IndexSettingsMappingDynamicProperties of(
        Function<IndexSettingsMappingDynamicProperties.Builder, ObjectBuilder<IndexSettingsMappingDynamicProperties>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code lucene_field}
     */
    @Nullable
    public final IndexSettingsMappingDynamicPropertiesLuceneField luceneField() {
        return this.luceneField;
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
        if (this.luceneField != null) {
            generator.writeKey("lucene_field");
            this.luceneField.serialize(generator, mapper);
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
     * Builder for {@link IndexSettingsMappingDynamicProperties}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IndexSettingsMappingDynamicProperties> {
        @Nullable
        private IndexSettingsMappingDynamicPropertiesLuceneField luceneField;

        public Builder() {}

        private Builder(IndexSettingsMappingDynamicProperties o) {
            this.luceneField = o.luceneField;
        }

        private Builder(Builder o) {
            this.luceneField = o.luceneField;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code lucene_field}
         */
        @Nonnull
        public final Builder luceneField(@Nullable IndexSettingsMappingDynamicPropertiesLuceneField value) {
            this.luceneField = value;
            return this;
        }

        /**
         * API name: {@code lucene_field}
         */
        @Nonnull
        public final Builder luceneField(
            Function<
                IndexSettingsMappingDynamicPropertiesLuceneField.Builder,
                ObjectBuilder<IndexSettingsMappingDynamicPropertiesLuceneField>> fn
        ) {
            return luceneField(fn.apply(new IndexSettingsMappingDynamicPropertiesLuceneField.Builder()).build());
        }

        /**
         * Builds a {@link IndexSettingsMappingDynamicProperties}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IndexSettingsMappingDynamicProperties build() {
            _checkSingleUse();

            return new IndexSettingsMappingDynamicProperties(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IndexSettingsMappingDynamicProperties}
     */
    public static final JsonpDeserializer<IndexSettingsMappingDynamicProperties> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IndexSettingsMappingDynamicProperties::setupIndexSettingsMappingDynamicPropertiesDeserializer
    );

    protected static void setupIndexSettingsMappingDynamicPropertiesDeserializer(
        ObjectDeserializer<IndexSettingsMappingDynamicProperties.Builder> op
    ) {
        op.add(Builder::luceneField, IndexSettingsMappingDynamicPropertiesLuceneField._DESERIALIZER, "lucene_field");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.luceneField);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IndexSettingsMappingDynamicProperties other = (IndexSettingsMappingDynamicProperties) o;
        return Objects.equals(this.luceneField, other.luceneField);
    }
}
