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

// typedef: indices.IndexSettingsStoreFs

/**
 * The filesystem storage configuration.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IndexSettingsStoreFs implements PlainJsonSerializable, ToCopyableBuilder<IndexSettingsStoreFs.Builder, IndexSettingsStoreFs> {

    @Nullable
    private final IndexSettingsStoreFsLock fsLock;

    // ---------------------------------------------------------------------------------------------

    private IndexSettingsStoreFs(Builder builder) {
        this.fsLock = builder.fsLock;
    }

    public static IndexSettingsStoreFs of(Function<IndexSettingsStoreFs.Builder, ObjectBuilder<IndexSettingsStoreFs>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code fs_lock}
     */
    @Nullable
    public final IndexSettingsStoreFsLock fsLock() {
        return this.fsLock;
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
        if (this.fsLock != null) {
            generator.writeKey("fs_lock");
            this.fsLock.serialize(generator, mapper);
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
     * Builder for {@link IndexSettingsStoreFs}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IndexSettingsStoreFs> {
        @Nullable
        private IndexSettingsStoreFsLock fsLock;

        public Builder() {}

        private Builder(IndexSettingsStoreFs o) {
            this.fsLock = o.fsLock;
        }

        private Builder(Builder o) {
            this.fsLock = o.fsLock;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code fs_lock}
         */
        @Nonnull
        public final Builder fsLock(@Nullable IndexSettingsStoreFsLock value) {
            this.fsLock = value;
            return this;
        }

        /**
         * Builds a {@link IndexSettingsStoreFs}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IndexSettingsStoreFs build() {
            _checkSingleUse();

            return new IndexSettingsStoreFs(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IndexSettingsStoreFs}
     */
    public static final JsonpDeserializer<IndexSettingsStoreFs> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IndexSettingsStoreFs::setupIndexSettingsStoreFsDeserializer
    );

    protected static void setupIndexSettingsStoreFsDeserializer(ObjectDeserializer<IndexSettingsStoreFs.Builder> op) {
        op.add(Builder::fsLock, IndexSettingsStoreFsLock._DESERIALIZER, "fs_lock");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.fsLock);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IndexSettingsStoreFs other = (IndexSettingsStoreFs) o;
        return Objects.equals(this.fsLock, other.fsLock);
    }
}
