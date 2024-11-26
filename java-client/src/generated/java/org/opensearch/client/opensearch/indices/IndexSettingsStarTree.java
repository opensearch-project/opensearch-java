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

// typedef: indices.IndexSettingsStarTree

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IndexSettingsStarTree
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<IndexSettingsStarTree.Builder, IndexSettingsStarTree> {

    @Nullable
    private final IndexSettingsStarTreeDefault default_;

    @Nullable
    private final IndexSettingsStarTreeField field;

    @Nullable
    private final Integer maxFields;

    // ---------------------------------------------------------------------------------------------

    private IndexSettingsStarTree(Builder builder) {
        this.default_ = builder.default_;
        this.field = builder.field;
        this.maxFields = builder.maxFields;
    }

    public static IndexSettingsStarTree of(Function<IndexSettingsStarTree.Builder, ObjectBuilder<IndexSettingsStarTree>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code default}
     */
    @Nullable
    public final IndexSettingsStarTreeDefault default_() {
        return this.default_;
    }

    /**
     * API name: {@code field}
     */
    @Nullable
    public final IndexSettingsStarTreeField field() {
        return this.field;
    }

    /**
     * API name: {@code max_fields}
     */
    @Nullable
    public final Integer maxFields() {
        return this.maxFields;
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
        if (this.default_ != null) {
            generator.writeKey("default");
            this.default_.serialize(generator, mapper);
        }

        if (this.field != null) {
            generator.writeKey("field");
            this.field.serialize(generator, mapper);
        }

        if (this.maxFields != null) {
            generator.writeKey("max_fields");
            generator.write(this.maxFields);
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
     * Builder for {@link IndexSettingsStarTree}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IndexSettingsStarTree> {
        @Nullable
        private IndexSettingsStarTreeDefault default_;
        @Nullable
        private IndexSettingsStarTreeField field;
        @Nullable
        private Integer maxFields;

        public Builder() {}

        private Builder(IndexSettingsStarTree o) {
            this.default_ = o.default_;
            this.field = o.field;
            this.maxFields = o.maxFields;
        }

        private Builder(Builder o) {
            this.default_ = o.default_;
            this.field = o.field;
            this.maxFields = o.maxFields;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code default}
         */
        @Nonnull
        public final Builder default_(@Nullable IndexSettingsStarTreeDefault value) {
            this.default_ = value;
            return this;
        }

        /**
         * API name: {@code default}
         */
        @Nonnull
        public final Builder default_(Function<IndexSettingsStarTreeDefault.Builder, ObjectBuilder<IndexSettingsStarTreeDefault>> fn) {
            return default_(fn.apply(new IndexSettingsStarTreeDefault.Builder()).build());
        }

        /**
         * API name: {@code field}
         */
        @Nonnull
        public final Builder field(@Nullable IndexSettingsStarTreeField value) {
            this.field = value;
            return this;
        }

        /**
         * API name: {@code field}
         */
        @Nonnull
        public final Builder field(Function<IndexSettingsStarTreeField.Builder, ObjectBuilder<IndexSettingsStarTreeField>> fn) {
            return field(fn.apply(new IndexSettingsStarTreeField.Builder()).build());
        }

        /**
         * API name: {@code max_fields}
         */
        @Nonnull
        public final Builder maxFields(@Nullable Integer value) {
            this.maxFields = value;
            return this;
        }

        /**
         * Builds a {@link IndexSettingsStarTree}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IndexSettingsStarTree build() {
            _checkSingleUse();

            return new IndexSettingsStarTree(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IndexSettingsStarTree}
     */
    public static final JsonpDeserializer<IndexSettingsStarTree> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IndexSettingsStarTree::setupIndexSettingsStarTreeDeserializer
    );

    protected static void setupIndexSettingsStarTreeDeserializer(ObjectDeserializer<IndexSettingsStarTree.Builder> op) {
        op.add(Builder::default_, IndexSettingsStarTreeDefault._DESERIALIZER, "default");
        op.add(Builder::field, IndexSettingsStarTreeField._DESERIALIZER, "field");
        op.add(Builder::maxFields, JsonpDeserializer.integerDeserializer(), "max_fields");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.default_);
        result = 31 * result + Objects.hashCode(this.field);
        result = 31 * result + Objects.hashCode(this.maxFields);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IndexSettingsStarTree other = (IndexSettingsStarTree) o;
        return Objects.equals(this.default_, other.default_)
            && Objects.equals(this.field, other.field)
            && Objects.equals(this.maxFields, other.maxFields);
    }
}
