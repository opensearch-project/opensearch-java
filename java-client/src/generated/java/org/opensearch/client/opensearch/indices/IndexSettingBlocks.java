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

// typedef: indices.IndexSettingBlocks

/**
 * The block settings that control index operations.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IndexSettingBlocks implements PlainJsonSerializable, ToCopyableBuilder<IndexSettingBlocks.Builder, IndexSettingBlocks> {

    @Nullable
    private final Boolean metadata;

    @Nullable
    private final Boolean read;

    @Nullable
    private final Boolean readOnly;

    @Nullable
    private final Boolean readOnlyAllowDelete;

    @Nullable
    private final Boolean searchOnly;

    @Nullable
    private final Boolean write;

    // ---------------------------------------------------------------------------------------------

    private IndexSettingBlocks(Builder builder) {
        this.metadata = builder.metadata;
        this.read = builder.read;
        this.readOnly = builder.readOnly;
        this.readOnlyAllowDelete = builder.readOnlyAllowDelete;
        this.searchOnly = builder.searchOnly;
        this.write = builder.write;
    }

    public static IndexSettingBlocks of(Function<IndexSettingBlocks.Builder, ObjectBuilder<IndexSettingBlocks>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code metadata}
     */
    @Nullable
    public final Boolean metadata() {
        return this.metadata;
    }

    /**
     * API name: {@code read}
     */
    @Nullable
    public final Boolean read() {
        return this.read;
    }

    /**
     * API name: {@code read_only}
     */
    @Nullable
    public final Boolean readOnly() {
        return this.readOnly;
    }

    /**
     * API name: {@code read_only_allow_delete}
     */
    @Nullable
    public final Boolean readOnlyAllowDelete() {
        return this.readOnlyAllowDelete;
    }

    /**
     * When true, the index is in search-only mode, allowing only read operations
     * <p>
     * API name: {@code search_only}
     * </p>
     */
    @Nullable
    public final Boolean searchOnly() {
        return this.searchOnly;
    }

    /**
     * API name: {@code write}
     */
    @Nullable
    public final Boolean write() {
        return this.write;
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
        if (this.metadata != null) {
            generator.writeKey("metadata");
            generator.write(this.metadata);
        }

        if (this.read != null) {
            generator.writeKey("read");
            generator.write(this.read);
        }

        if (this.readOnly != null) {
            generator.writeKey("read_only");
            generator.write(this.readOnly);
        }

        if (this.readOnlyAllowDelete != null) {
            generator.writeKey("read_only_allow_delete");
            generator.write(this.readOnlyAllowDelete);
        }

        if (this.searchOnly != null) {
            generator.writeKey("search_only");
            generator.write(this.searchOnly);
        }

        if (this.write != null) {
            generator.writeKey("write");
            generator.write(this.write);
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
     * Builder for {@link IndexSettingBlocks}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IndexSettingBlocks> {
        @Nullable
        private Boolean metadata;
        @Nullable
        private Boolean read;
        @Nullable
        private Boolean readOnly;
        @Nullable
        private Boolean readOnlyAllowDelete;
        @Nullable
        private Boolean searchOnly;
        @Nullable
        private Boolean write;

        public Builder() {}

        private Builder(IndexSettingBlocks o) {
            this.metadata = o.metadata;
            this.read = o.read;
            this.readOnly = o.readOnly;
            this.readOnlyAllowDelete = o.readOnlyAllowDelete;
            this.searchOnly = o.searchOnly;
            this.write = o.write;
        }

        private Builder(Builder o) {
            this.metadata = o.metadata;
            this.read = o.read;
            this.readOnly = o.readOnly;
            this.readOnlyAllowDelete = o.readOnlyAllowDelete;
            this.searchOnly = o.searchOnly;
            this.write = o.write;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code metadata}
         */
        @Nonnull
        public final Builder metadata(@Nullable Boolean value) {
            this.metadata = value;
            return this;
        }

        /**
         * API name: {@code read}
         */
        @Nonnull
        public final Builder read(@Nullable Boolean value) {
            this.read = value;
            return this;
        }

        /**
         * API name: {@code read_only}
         */
        @Nonnull
        public final Builder readOnly(@Nullable Boolean value) {
            this.readOnly = value;
            return this;
        }

        /**
         * API name: {@code read_only_allow_delete}
         */
        @Nonnull
        public final Builder readOnlyAllowDelete(@Nullable Boolean value) {
            this.readOnlyAllowDelete = value;
            return this;
        }

        /**
         * When true, the index is in search-only mode, allowing only read operations
         * <p>
         * API name: {@code search_only}
         * </p>
         */
        @Nonnull
        public final Builder searchOnly(@Nullable Boolean value) {
            this.searchOnly = value;
            return this;
        }

        /**
         * API name: {@code write}
         */
        @Nonnull
        public final Builder write(@Nullable Boolean value) {
            this.write = value;
            return this;
        }

        /**
         * Builds a {@link IndexSettingBlocks}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IndexSettingBlocks build() {
            _checkSingleUse();

            return new IndexSettingBlocks(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IndexSettingBlocks}
     */
    public static final JsonpDeserializer<IndexSettingBlocks> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IndexSettingBlocks::setupIndexSettingBlocksDeserializer
    );

    protected static void setupIndexSettingBlocksDeserializer(ObjectDeserializer<IndexSettingBlocks.Builder> op) {
        op.add(Builder::metadata, JsonpDeserializer.booleanDeserializer(), "metadata");
        op.add(Builder::read, JsonpDeserializer.booleanDeserializer(), "read");
        op.add(Builder::readOnly, JsonpDeserializer.booleanDeserializer(), "read_only");
        op.add(Builder::readOnlyAllowDelete, JsonpDeserializer.booleanDeserializer(), "read_only_allow_delete");
        op.add(Builder::searchOnly, JsonpDeserializer.booleanDeserializer(), "search_only");
        op.add(Builder::write, JsonpDeserializer.booleanDeserializer(), "write");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.metadata);
        result = 31 * result + Objects.hashCode(this.read);
        result = 31 * result + Objects.hashCode(this.readOnly);
        result = 31 * result + Objects.hashCode(this.readOnlyAllowDelete);
        result = 31 * result + Objects.hashCode(this.searchOnly);
        result = 31 * result + Objects.hashCode(this.write);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IndexSettingBlocks other = (IndexSettingBlocks) o;
        return Objects.equals(this.metadata, other.metadata)
            && Objects.equals(this.read, other.read)
            && Objects.equals(this.readOnly, other.readOnly)
            && Objects.equals(this.readOnlyAllowDelete, other.readOnlyAllowDelete)
            && Objects.equals(this.searchOnly, other.searchOnly)
            && Objects.equals(this.write, other.write);
    }
}
