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

package org.opensearch.client.opensearch.ism;

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

// typedef: ism.FailedIndex

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class FailedIndex implements PlainJsonSerializable, ToCopyableBuilder<FailedIndex.Builder, FailedIndex> {

    @Nullable
    private final String indexName;

    @Nullable
    private final String indexUuid;

    @Nullable
    private final String reason;

    // ---------------------------------------------------------------------------------------------

    private FailedIndex(Builder builder) {
        this.indexName = builder.indexName;
        this.indexUuid = builder.indexUuid;
        this.reason = builder.reason;
    }

    public static FailedIndex of(Function<FailedIndex.Builder, ObjectBuilder<FailedIndex>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The name of the failed index.
     * <p>
     * API name: {@code index_name}
     * </p>
     */
    @Nullable
    public final String indexName() {
        return this.indexName;
    }

    /**
     * The UUID of the failed index.
     * <p>
     * API name: {@code index_uuid}
     * </p>
     */
    @Nullable
    public final String indexUuid() {
        return this.indexUuid;
    }

    /**
     * The reason for the failure.
     * <p>
     * API name: {@code reason}
     * </p>
     */
    @Nullable
    public final String reason() {
        return this.reason;
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
        if (this.indexName != null) {
            generator.writeKey("index_name");
            generator.write(this.indexName);
        }

        if (this.indexUuid != null) {
            generator.writeKey("index_uuid");
            generator.write(this.indexUuid);
        }

        if (this.reason != null) {
            generator.writeKey("reason");
            generator.write(this.reason);
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
     * Builder for {@link FailedIndex}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, FailedIndex> {
        @Nullable
        private String indexName;
        @Nullable
        private String indexUuid;
        @Nullable
        private String reason;

        public Builder() {}

        private Builder(FailedIndex o) {
            this.indexName = o.indexName;
            this.indexUuid = o.indexUuid;
            this.reason = o.reason;
        }

        private Builder(Builder o) {
            this.indexName = o.indexName;
            this.indexUuid = o.indexUuid;
            this.reason = o.reason;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The name of the failed index.
         * <p>
         * API name: {@code index_name}
         * </p>
         */
        @Nonnull
        public final Builder indexName(@Nullable String value) {
            this.indexName = value;
            return this;
        }

        /**
         * The UUID of the failed index.
         * <p>
         * API name: {@code index_uuid}
         * </p>
         */
        @Nonnull
        public final Builder indexUuid(@Nullable String value) {
            this.indexUuid = value;
            return this;
        }

        /**
         * The reason for the failure.
         * <p>
         * API name: {@code reason}
         * </p>
         */
        @Nonnull
        public final Builder reason(@Nullable String value) {
            this.reason = value;
            return this;
        }

        /**
         * Builds a {@link FailedIndex}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public FailedIndex build() {
            _checkSingleUse();

            return new FailedIndex(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link FailedIndex}
     */
    public static final JsonpDeserializer<FailedIndex> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        FailedIndex::setupFailedIndexDeserializer
    );

    protected static void setupFailedIndexDeserializer(ObjectDeserializer<FailedIndex.Builder> op) {
        op.add(Builder::indexName, JsonpDeserializer.stringDeserializer(), "index_name");
        op.add(Builder::indexUuid, JsonpDeserializer.stringDeserializer(), "index_uuid");
        op.add(Builder::reason, JsonpDeserializer.stringDeserializer(), "reason");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.indexName);
        result = 31 * result + Objects.hashCode(this.indexUuid);
        result = 31 * result + Objects.hashCode(this.reason);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        FailedIndex other = (FailedIndex) o;
        return Objects.equals(this.indexName, other.indexName)
            && Objects.equals(this.indexUuid, other.indexUuid)
            && Objects.equals(this.reason, other.reason);
    }
}
