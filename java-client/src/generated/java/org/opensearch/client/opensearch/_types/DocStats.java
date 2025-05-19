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

package org.opensearch.client.opensearch._types;

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

// typedef: _types.DocStats

/**
 * The document-level statistics.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class DocStats implements PlainJsonSerializable, ToCopyableBuilder<DocStats.Builder, DocStats> {

    private final long count;

    @Nullable
    private final Long deleted;

    // ---------------------------------------------------------------------------------------------

    private DocStats(Builder builder) {
        this.count = ApiTypeHelper.requireNonNull(builder.count, this, "count");
        this.deleted = builder.deleted;
    }

    public static DocStats of(Function<DocStats.Builder, ObjectBuilder<DocStats>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The total number of non-deleted documents across all primary shards assigned to the selected nodes. This number is based
     * on documents in Lucene segments and may include documents from nested fields.
     * <p>
     * API name: {@code count}
     * </p>
     */
    public final long count() {
        return this.count;
    }

    /**
     * The total number of deleted documents across all primary shards assigned to the selected nodes. This number is based on the number of
     * documents stored in Lucene segments. OpenSearch reclaims the disk space previously occupied by the deleted Lucene documents when a
     * segment is merged.
     * <p>
     * API name: {@code deleted}
     * </p>
     */
    @Nullable
    public final Long deleted() {
        return this.deleted;
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
        generator.writeKey("count");
        generator.write(this.count);

        if (this.deleted != null) {
            generator.writeKey("deleted");
            generator.write(this.deleted);
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
     * Builder for {@link DocStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, DocStats> {
        private Long count;
        @Nullable
        private Long deleted;

        public Builder() {}

        private Builder(DocStats o) {
            this.count = o.count;
            this.deleted = o.deleted;
        }

        private Builder(Builder o) {
            this.count = o.count;
            this.deleted = o.deleted;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - The total number of non-deleted documents across all primary shards assigned to the selected nodes. This number is
         * based on documents in Lucene segments and may include documents from nested fields.
         * <p>
         * API name: {@code count}
         * </p>
         */
        @Nonnull
        public final Builder count(long value) {
            this.count = value;
            return this;
        }

        /**
         * The total number of deleted documents across all primary shards assigned to the selected nodes. This number is based on the
         * number of documents stored in Lucene segments. OpenSearch reclaims the disk space previously occupied by the deleted Lucene
         * documents when a segment is merged.
         * <p>
         * API name: {@code deleted}
         * </p>
         */
        @Nonnull
        public final Builder deleted(@Nullable Long value) {
            this.deleted = value;
            return this;
        }

        /**
         * Builds a {@link DocStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DocStats build() {
            _checkSingleUse();

            return new DocStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link DocStats}
     */
    public static final JsonpDeserializer<DocStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        DocStats::setupDocStatsDeserializer
    );

    protected static void setupDocStatsDeserializer(ObjectDeserializer<DocStats.Builder> op) {
        op.add(Builder::count, JsonpDeserializer.longDeserializer(), "count");
        op.add(Builder::deleted, JsonpDeserializer.longDeserializer(), "deleted");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Long.hashCode(this.count);
        result = 31 * result + Objects.hashCode(this.deleted);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        DocStats other = (DocStats) o;
        return this.count == other.count && Objects.equals(this.deleted, other.deleted);
    }
}
