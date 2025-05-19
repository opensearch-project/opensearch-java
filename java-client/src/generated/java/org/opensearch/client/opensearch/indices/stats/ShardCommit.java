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

package org.opensearch.client.opensearch.indices.stats;

import jakarta.json.stream.JsonGenerator;
import java.util.Map;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
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

// typedef: indices.stats.ShardCommit

/**
 * The commit information for a shard.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ShardCommit implements PlainJsonSerializable, ToCopyableBuilder<ShardCommit.Builder, ShardCommit> {

    private final int generation;

    @Nonnull
    private final String id;

    private final long numDocs;

    @Nonnull
    private final Map<String, String> userData;

    // ---------------------------------------------------------------------------------------------

    private ShardCommit(Builder builder) {
        this.generation = ApiTypeHelper.requireNonNull(builder.generation, this, "generation");
        this.id = ApiTypeHelper.requireNonNull(builder.id, this, "id");
        this.numDocs = ApiTypeHelper.requireNonNull(builder.numDocs, this, "numDocs");
        this.userData = ApiTypeHelper.unmodifiableRequired(builder.userData, this, "userData");
    }

    public static ShardCommit of(Function<ShardCommit.Builder, ObjectBuilder<ShardCommit>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The generation number of the commit.
     * <p>
     * API name: {@code generation}
     * </p>
     */
    public final int generation() {
        return this.generation;
    }

    /**
     * Required - API name: {@code id}
     */
    @Nonnull
    public final String id() {
        return this.id;
    }

    /**
     * Required - The number of documents in the commit.
     * <p>
     * API name: {@code num_docs}
     * </p>
     */
    public final long numDocs() {
        return this.numDocs;
    }

    /**
     * Required - The user-defined data associated with the commit.
     * <p>
     * API name: {@code user_data}
     * </p>
     */
    @Nonnull
    public final Map<String, String> userData() {
        return this.userData;
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
        generator.writeKey("generation");
        generator.write(this.generation);

        generator.writeKey("id");
        generator.write(this.id);

        generator.writeKey("num_docs");
        generator.write(this.numDocs);

        generator.writeKey("user_data");
        generator.writeStartObject();
        for (Map.Entry<String, String> item0 : this.userData.entrySet()) {
            generator.writeKey(item0.getKey());
            generator.write(item0.getValue());
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
     * Builder for {@link ShardCommit}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ShardCommit> {
        private Integer generation;
        private String id;
        private Long numDocs;
        private Map<String, String> userData;

        public Builder() {}

        private Builder(ShardCommit o) {
            this.generation = o.generation;
            this.id = o.id;
            this.numDocs = o.numDocs;
            this.userData = _mapCopy(o.userData);
        }

        private Builder(Builder o) {
            this.generation = o.generation;
            this.id = o.id;
            this.numDocs = o.numDocs;
            this.userData = _mapCopy(o.userData);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - The generation number of the commit.
         * <p>
         * API name: {@code generation}
         * </p>
         */
        @Nonnull
        public final Builder generation(int value) {
            this.generation = value;
            return this;
        }

        /**
         * Required - API name: {@code id}
         */
        @Nonnull
        public final Builder id(String value) {
            this.id = value;
            return this;
        }

        /**
         * Required - The number of documents in the commit.
         * <p>
         * API name: {@code num_docs}
         * </p>
         */
        @Nonnull
        public final Builder numDocs(long value) {
            this.numDocs = value;
            return this;
        }

        /**
         * Required - The user-defined data associated with the commit.
         * <p>
         * API name: {@code user_data}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>userData</code>.
         * </p>
         */
        @Nonnull
        public final Builder userData(Map<String, String> map) {
            this.userData = _mapPutAll(this.userData, map);
            return this;
        }

        /**
         * Required - The user-defined data associated with the commit.
         * <p>
         * API name: {@code user_data}
         * </p>
         *
         * <p>
         * Adds an entry to <code>userData</code>.
         * </p>
         */
        @Nonnull
        public final Builder userData(String key, String value) {
            this.userData = _mapPut(this.userData, key, value);
            return this;
        }

        /**
         * Builds a {@link ShardCommit}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ShardCommit build() {
            _checkSingleUse();

            return new ShardCommit(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ShardCommit}
     */
    public static final JsonpDeserializer<ShardCommit> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ShardCommit::setupShardCommitDeserializer
    );

    protected static void setupShardCommitDeserializer(ObjectDeserializer<ShardCommit.Builder> op) {
        op.add(Builder::generation, JsonpDeserializer.integerDeserializer(), "generation");
        op.add(Builder::id, JsonpDeserializer.stringDeserializer(), "id");
        op.add(Builder::numDocs, JsonpDeserializer.longDeserializer(), "num_docs");
        op.add(Builder::userData, JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.stringDeserializer()), "user_data");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Integer.hashCode(this.generation);
        result = 31 * result + this.id.hashCode();
        result = 31 * result + Long.hashCode(this.numDocs);
        result = 31 * result + this.userData.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ShardCommit other = (ShardCommit) o;
        return this.generation == other.generation
            && this.id.equals(other.id)
            && this.numDocs == other.numDocs
            && this.userData.equals(other.userData);
    }
}
