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
import org.opensearch.client.opensearch._types.Result;
import org.opensearch.client.opensearch._types.ShardStatistics;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ism.delete_policy.Response

/**
 * The base response for write operations.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class DeletePolicyResponse implements PlainJsonSerializable, ToCopyableBuilder<DeletePolicyResponse.Builder, DeletePolicyResponse> {

    @Nullable
    private final Boolean forcedRefresh;

    @Nonnull
    private final String id;

    @Nonnull
    private final String index;

    private final long primaryTerm;

    @Nonnull
    private final Result result;

    private final long seqNo;

    @Nonnull
    private final ShardStatistics shards;

    private final long version;

    // ---------------------------------------------------------------------------------------------

    private DeletePolicyResponse(Builder builder) {
        this.forcedRefresh = builder.forcedRefresh;
        this.id = ApiTypeHelper.requireNonNull(builder.id, this, "id");
        this.index = ApiTypeHelper.requireNonNull(builder.index, this, "index");
        this.primaryTerm = ApiTypeHelper.requireNonNull(builder.primaryTerm, this, "primaryTerm");
        this.result = ApiTypeHelper.requireNonNull(builder.result, this, "result");
        this.seqNo = ApiTypeHelper.requireNonNull(builder.seqNo, this, "seqNo");
        this.shards = ApiTypeHelper.requireNonNull(builder.shards, this, "shards");
        this.version = ApiTypeHelper.requireNonNull(builder.version, this, "version");
    }

    public static DeletePolicyResponse of(Function<DeletePolicyResponse.Builder, ObjectBuilder<DeletePolicyResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code forced_refresh}
     */
    @Nullable
    public final Boolean forcedRefresh() {
        return this.forcedRefresh;
    }

    /**
     * Required - API name: {@code _id}
     */
    @Nonnull
    public final String id() {
        return this.id;
    }

    /**
     * Required - API name: {@code _index}
     */
    @Nonnull
    public final String index() {
        return this.index;
    }

    /**
     * Required - The primary term of the document.
     * <p>
     * API name: {@code _primary_term}
     * </p>
     */
    public final long primaryTerm() {
        return this.primaryTerm;
    }

    /**
     * Required - API name: {@code result}
     */
    @Nonnull
    public final Result result() {
        return this.result;
    }

    /**
     * Required - API name: {@code _seq_no}
     */
    public final long seqNo() {
        return this.seqNo;
    }

    /**
     * Required - API name: {@code _shards}
     */
    @Nonnull
    public final ShardStatistics shards() {
        return this.shards;
    }

    /**
     * Required - API name: {@code _version}
     */
    public final long version() {
        return this.version;
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
        if (this.forcedRefresh != null) {
            generator.writeKey("forced_refresh");
            generator.write(this.forcedRefresh);
        }

        generator.writeKey("_id");
        generator.write(this.id);

        generator.writeKey("_index");
        generator.write(this.index);

        generator.writeKey("_primary_term");
        generator.write(this.primaryTerm);

        generator.writeKey("result");
        this.result.serialize(generator, mapper);

        generator.writeKey("_seq_no");
        generator.write(this.seqNo);

        generator.writeKey("_shards");
        this.shards.serialize(generator, mapper);

        generator.writeKey("_version");
        generator.write(this.version);
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
     * Builder for {@link DeletePolicyResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, DeletePolicyResponse> {
        @Nullable
        private Boolean forcedRefresh;
        private String id;
        private String index;
        private Long primaryTerm;
        private Result result;
        private Long seqNo;
        private ShardStatistics shards;
        private Long version;

        public Builder() {}

        private Builder(DeletePolicyResponse o) {
            this.forcedRefresh = o.forcedRefresh;
            this.id = o.id;
            this.index = o.index;
            this.primaryTerm = o.primaryTerm;
            this.result = o.result;
            this.seqNo = o.seqNo;
            this.shards = o.shards;
            this.version = o.version;
        }

        private Builder(Builder o) {
            this.forcedRefresh = o.forcedRefresh;
            this.id = o.id;
            this.index = o.index;
            this.primaryTerm = o.primaryTerm;
            this.result = o.result;
            this.seqNo = o.seqNo;
            this.shards = o.shards;
            this.version = o.version;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code forced_refresh}
         */
        @Nonnull
        public final Builder forcedRefresh(@Nullable Boolean value) {
            this.forcedRefresh = value;
            return this;
        }

        /**
         * Required - API name: {@code _id}
         */
        @Nonnull
        public final Builder id(String value) {
            this.id = value;
            return this;
        }

        /**
         * Required - API name: {@code _index}
         */
        @Nonnull
        public final Builder index(String value) {
            this.index = value;
            return this;
        }

        /**
         * Required - The primary term of the document.
         * <p>
         * API name: {@code _primary_term}
         * </p>
         */
        @Nonnull
        public final Builder primaryTerm(long value) {
            this.primaryTerm = value;
            return this;
        }

        /**
         * Required - API name: {@code result}
         */
        @Nonnull
        public final Builder result(Result value) {
            this.result = value;
            return this;
        }

        /**
         * Required - API name: {@code _seq_no}
         */
        @Nonnull
        public final Builder seqNo(long value) {
            this.seqNo = value;
            return this;
        }

        /**
         * Required - API name: {@code _shards}
         */
        @Nonnull
        public final Builder shards(ShardStatistics value) {
            this.shards = value;
            return this;
        }

        /**
         * Required - API name: {@code _shards}
         */
        @Nonnull
        public final Builder shards(Function<ShardStatistics.Builder, ObjectBuilder<ShardStatistics>> fn) {
            return shards(fn.apply(new ShardStatistics.Builder()).build());
        }

        /**
         * Required - API name: {@code _version}
         */
        @Nonnull
        public final Builder version(long value) {
            this.version = value;
            return this;
        }

        /**
         * Builds a {@link DeletePolicyResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DeletePolicyResponse build() {
            _checkSingleUse();

            return new DeletePolicyResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link DeletePolicyResponse}
     */
    public static final JsonpDeserializer<DeletePolicyResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        DeletePolicyResponse::setupDeletePolicyResponseDeserializer
    );

    protected static void setupDeletePolicyResponseDeserializer(ObjectDeserializer<DeletePolicyResponse.Builder> op) {
        op.add(Builder::forcedRefresh, JsonpDeserializer.booleanDeserializer(), "forced_refresh");
        op.add(Builder::id, JsonpDeserializer.stringDeserializer(), "_id");
        op.add(Builder::index, JsonpDeserializer.stringDeserializer(), "_index");
        op.add(Builder::primaryTerm, JsonpDeserializer.longDeserializer(), "_primary_term");
        op.add(Builder::result, Result._DESERIALIZER, "result");
        op.add(Builder::seqNo, JsonpDeserializer.longDeserializer(), "_seq_no");
        op.add(Builder::shards, ShardStatistics._DESERIALIZER, "_shards");
        op.add(Builder::version, JsonpDeserializer.longDeserializer(), "_version");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.forcedRefresh);
        result = 31 * result + this.id.hashCode();
        result = 31 * result + this.index.hashCode();
        result = 31 * result + Long.hashCode(this.primaryTerm);
        result = 31 * result + this.result.hashCode();
        result = 31 * result + Long.hashCode(this.seqNo);
        result = 31 * result + this.shards.hashCode();
        result = 31 * result + Long.hashCode(this.version);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        DeletePolicyResponse other = (DeletePolicyResponse) o;
        return Objects.equals(this.forcedRefresh, other.forcedRefresh)
            && this.id.equals(other.id)
            && this.index.equals(other.index)
            && this.primaryTerm == other.primaryTerm
            && this.result.equals(other.result)
            && this.seqNo == other.seqNo
            && this.shards.equals(other.shards)
            && this.version == other.version;
    }
}
