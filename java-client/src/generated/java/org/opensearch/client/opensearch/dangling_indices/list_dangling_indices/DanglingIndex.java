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

package org.opensearch.client.opensearch.dangling_indices.list_dangling_indices;

import jakarta.json.stream.JsonGenerator;
import java.util.List;
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

// typedef: dangling_indices.list_dangling_indices.DanglingIndex

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class DanglingIndex implements PlainJsonSerializable, ToCopyableBuilder<DanglingIndex.Builder, DanglingIndex> {

    @Nullable
    private final String creationDate;

    private final long creationDateMillis;

    @Nonnull
    private final String indexName;

    @Nonnull
    private final String indexUuid;

    @Nonnull
    private final List<String> nodeIds;

    // ---------------------------------------------------------------------------------------------

    private DanglingIndex(Builder builder) {
        this.creationDate = builder.creationDate;
        this.creationDateMillis = ApiTypeHelper.requireNonNull(builder.creationDateMillis, this, "creationDateMillis");
        this.indexName = ApiTypeHelper.requireNonNull(builder.indexName, this, "indexName");
        this.indexUuid = ApiTypeHelper.requireNonNull(builder.indexUuid, this, "indexUuid");
        this.nodeIds = ApiTypeHelper.unmodifiableRequired(builder.nodeIds, this, "nodeIds");
    }

    public static DanglingIndex of(Function<DanglingIndex.Builder, ObjectBuilder<DanglingIndex>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code creation_date}
     */
    @Nullable
    public final String creationDate() {
        return this.creationDate;
    }

    /**
     * Required - API name: {@code creation_date_millis}
     */
    public final long creationDateMillis() {
        return this.creationDateMillis;
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
     * Required - API name: {@code node_ids}
     */
    @Nonnull
    public final List<String> nodeIds() {
        return this.nodeIds;
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
        if (this.creationDate != null) {
            generator.writeKey("creation_date");
            generator.write(this.creationDate);
        }

        generator.writeKey("creation_date_millis");
        generator.write(this.creationDateMillis);

        generator.writeKey("index_name");
        generator.write(this.indexName);

        generator.writeKey("index_uuid");
        generator.write(this.indexUuid);

        generator.writeKey("node_ids");
        generator.writeStartArray();
        for (String item0 : this.nodeIds) {
            generator.write(item0);
        }
        generator.writeEnd();
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
     * Builder for {@link DanglingIndex}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, DanglingIndex> {
        @Nullable
        private String creationDate;
        private Long creationDateMillis;
        private String indexName;
        private String indexUuid;
        private List<String> nodeIds;

        public Builder() {}

        private Builder(DanglingIndex o) {
            this.creationDate = o.creationDate;
            this.creationDateMillis = o.creationDateMillis;
            this.indexName = o.indexName;
            this.indexUuid = o.indexUuid;
            this.nodeIds = _listCopy(o.nodeIds);
        }

        private Builder(Builder o) {
            this.creationDate = o.creationDate;
            this.creationDateMillis = o.creationDateMillis;
            this.indexName = o.indexName;
            this.indexUuid = o.indexUuid;
            this.nodeIds = _listCopy(o.nodeIds);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code creation_date}
         */
        @Nonnull
        public final Builder creationDate(@Nullable String value) {
            this.creationDate = value;
            return this;
        }

        /**
         * Required - API name: {@code creation_date_millis}
         */
        @Nonnull
        public final Builder creationDateMillis(long value) {
            this.creationDateMillis = value;
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
         * Required - API name: {@code node_ids}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>nodeIds</code>.
         * </p>
         */
        @Nonnull
        public final Builder nodeIds(List<String> list) {
            this.nodeIds = _listAddAll(this.nodeIds, list);
            return this;
        }

        /**
         * Required - API name: {@code node_ids}
         *
         * <p>
         * Adds one or more values to <code>nodeIds</code>.
         * </p>
         */
        @Nonnull
        public final Builder nodeIds(String value, String... values) {
            this.nodeIds = _listAdd(this.nodeIds, value, values);
            return this;
        }

        /**
         * Builds a {@link DanglingIndex}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DanglingIndex build() {
            _checkSingleUse();

            return new DanglingIndex(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link DanglingIndex}
     */
    public static final JsonpDeserializer<DanglingIndex> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        DanglingIndex::setupDanglingIndexDeserializer
    );

    protected static void setupDanglingIndexDeserializer(ObjectDeserializer<DanglingIndex.Builder> op) {
        op.add(Builder::creationDate, JsonpDeserializer.stringDeserializer(), "creation_date");
        op.add(Builder::creationDateMillis, JsonpDeserializer.longDeserializer(), "creation_date_millis");
        op.add(Builder::indexName, JsonpDeserializer.stringDeserializer(), "index_name");
        op.add(Builder::indexUuid, JsonpDeserializer.stringDeserializer(), "index_uuid");
        op.add(Builder::nodeIds, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "node_ids");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.creationDate);
        result = 31 * result + Long.hashCode(this.creationDateMillis);
        result = 31 * result + this.indexName.hashCode();
        result = 31 * result + this.indexUuid.hashCode();
        result = 31 * result + this.nodeIds.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        DanglingIndex other = (DanglingIndex) o;
        return Objects.equals(this.creationDate, other.creationDate)
            && this.creationDateMillis == other.creationDateMillis
            && this.indexName.equals(other.indexName)
            && this.indexUuid.equals(other.indexUuid)
            && this.nodeIds.equals(other.nodeIds);
    }
}
