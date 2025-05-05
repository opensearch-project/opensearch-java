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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: indices.DataStreamIndex

/**
 * The configuration for a data stream's backing index.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class DataStreamIndex implements PlainJsonSerializable, ToCopyableBuilder<DataStreamIndex.Builder, DataStreamIndex> {

    @Nullable
    private final String ilmPolicy;

    @Nonnull
    private final String indexName;

    @Nonnull
    private final String indexUuid;

    @Nullable
    private final ManagedBy managedBy;

    @Nullable
    private final Boolean preferIlm;

    // ---------------------------------------------------------------------------------------------

    private DataStreamIndex(Builder builder) {
        this.ilmPolicy = builder.ilmPolicy;
        this.indexName = ApiTypeHelper.requireNonNull(builder.indexName, this, "indexName");
        this.indexUuid = ApiTypeHelper.requireNonNull(builder.indexUuid, this, "indexUuid");
        this.managedBy = builder.managedBy;
        this.preferIlm = builder.preferIlm;
    }

    public static DataStreamIndex of(Function<DataStreamIndex.Builder, ObjectBuilder<DataStreamIndex>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code ilm_policy}
     */
    @Nullable
    public final String ilmPolicy() {
        return this.ilmPolicy;
    }

    /**
     * Required - API name: {@code index_name}
     */
    @Nonnull
    public final String indexName() {
        return this.indexName;
    }

    /**
     * Required - API name: {@code index_uuid}
     */
    @Nonnull
    public final String indexUuid() {
        return this.indexUuid;
    }

    /**
     * API name: {@code managed_by}
     */
    @Nullable
    public final ManagedBy managedBy() {
        return this.managedBy;
    }

    /**
     * Indicates if ILM should take precedence over DSL in case both are configured to manage this index.
     * <p>
     * API name: {@code prefer_ilm}
     * </p>
     */
    @Nullable
    public final Boolean preferIlm() {
        return this.preferIlm;
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
        if (this.ilmPolicy != null) {
            generator.writeKey("ilm_policy");
            generator.write(this.ilmPolicy);
        }

        generator.writeKey("index_name");
        generator.write(this.indexName);

        generator.writeKey("index_uuid");
        generator.write(this.indexUuid);

        if (this.managedBy != null) {
            generator.writeKey("managed_by");
            this.managedBy.serialize(generator, mapper);
        }

        if (this.preferIlm != null) {
            generator.writeKey("prefer_ilm");
            generator.write(this.preferIlm);
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
     * Builder for {@link DataStreamIndex}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, DataStreamIndex> {
        @Nullable
        private String ilmPolicy;
        private String indexName;
        private String indexUuid;
        @Nullable
        private ManagedBy managedBy;
        @Nullable
        private Boolean preferIlm;

        public Builder() {}

        private Builder(DataStreamIndex o) {
            this.ilmPolicy = o.ilmPolicy;
            this.indexName = o.indexName;
            this.indexUuid = o.indexUuid;
            this.managedBy = o.managedBy;
            this.preferIlm = o.preferIlm;
        }

        private Builder(Builder o) {
            this.ilmPolicy = o.ilmPolicy;
            this.indexName = o.indexName;
            this.indexUuid = o.indexUuid;
            this.managedBy = o.managedBy;
            this.preferIlm = o.preferIlm;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code ilm_policy}
         */
        @Nonnull
        public final Builder ilmPolicy(@Nullable String value) {
            this.ilmPolicy = value;
            return this;
        }

        /**
         * Required - API name: {@code index_name}
         */
        @Nonnull
        public final Builder indexName(String value) {
            this.indexName = value;
            return this;
        }

        /**
         * Required - API name: {@code index_uuid}
         */
        @Nonnull
        public final Builder indexUuid(String value) {
            this.indexUuid = value;
            return this;
        }

        /**
         * API name: {@code managed_by}
         */
        @Nonnull
        public final Builder managedBy(@Nullable ManagedBy value) {
            this.managedBy = value;
            return this;
        }

        /**
         * Indicates if ILM should take precedence over DSL in case both are configured to manage this index.
         * <p>
         * API name: {@code prefer_ilm}
         * </p>
         */
        @Nonnull
        public final Builder preferIlm(@Nullable Boolean value) {
            this.preferIlm = value;
            return this;
        }

        /**
         * Builds a {@link DataStreamIndex}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DataStreamIndex build() {
            _checkSingleUse();

            return new DataStreamIndex(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link DataStreamIndex}
     */
    public static final JsonpDeserializer<DataStreamIndex> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        DataStreamIndex::setupDataStreamIndexDeserializer
    );

    protected static void setupDataStreamIndexDeserializer(ObjectDeserializer<DataStreamIndex.Builder> op) {
        op.add(Builder::ilmPolicy, JsonpDeserializer.stringDeserializer(), "ilm_policy");
        op.add(Builder::indexName, JsonpDeserializer.stringDeserializer(), "index_name");
        op.add(Builder::indexUuid, JsonpDeserializer.stringDeserializer(), "index_uuid");
        op.add(Builder::managedBy, ManagedBy._DESERIALIZER, "managed_by");
        op.add(Builder::preferIlm, JsonpDeserializer.booleanDeserializer(), "prefer_ilm");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.ilmPolicy);
        result = 31 * result + this.indexName.hashCode();
        result = 31 * result + this.indexUuid.hashCode();
        result = 31 * result + Objects.hashCode(this.managedBy);
        result = 31 * result + Objects.hashCode(this.preferIlm);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        DataStreamIndex other = (DataStreamIndex) o;
        return Objects.equals(this.ilmPolicy, other.ilmPolicy)
            && this.indexName.equals(other.indexName)
            && this.indexUuid.equals(other.indexUuid)
            && Objects.equals(this.managedBy, other.managedBy)
            && Objects.equals(this.preferIlm, other.preferIlm);
    }
}
