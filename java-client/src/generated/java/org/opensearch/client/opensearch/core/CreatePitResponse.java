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

package org.opensearch.client.opensearch.core;

import jakarta.json.stream.JsonGenerator;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.opensearch._types.ShardStatistics;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _global.create_pit.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class CreatePitResponse implements PlainJsonSerializable, ToCopyableBuilder<CreatePitResponse.Builder, CreatePitResponse> {

    private final long creationTime;

    @Nonnull
    private final String pitId;

    @Nonnull
    private final ShardStatistics shards;

    // ---------------------------------------------------------------------------------------------

    private CreatePitResponse(Builder builder) {
        this.creationTime = ApiTypeHelper.requireNonNull(builder.creationTime, this, "creationTime");
        this.pitId = ApiTypeHelper.requireNonNull(builder.pitId, this, "pitId");
        this.shards = ApiTypeHelper.requireNonNull(builder.shards, this, "shards");
    }

    public static CreatePitResponse of(Function<CreatePitResponse.Builder, ObjectBuilder<CreatePitResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code creation_time}
     */
    public final long creationTime() {
        return this.creationTime;
    }

    /**
     * Required - API name: {@code pit_id}
     */
    @Nonnull
    public final String pitId() {
        return this.pitId;
    }

    /**
     * Required - API name: {@code _shards}
     */
    @Nonnull
    public final ShardStatistics shards() {
        return this.shards;
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
        generator.writeKey("creation_time");
        generator.write(this.creationTime);

        generator.writeKey("pit_id");
        generator.write(this.pitId);

        generator.writeKey("_shards");
        this.shards.serialize(generator, mapper);
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
     * Builder for {@link CreatePitResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, CreatePitResponse> {
        private Long creationTime;
        private String pitId;
        private ShardStatistics shards;

        public Builder() {}

        private Builder(CreatePitResponse o) {
            this.creationTime = o.creationTime;
            this.pitId = o.pitId;
            this.shards = o.shards;
        }

        private Builder(Builder o) {
            this.creationTime = o.creationTime;
            this.pitId = o.pitId;
            this.shards = o.shards;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code creation_time}
         */
        @Nonnull
        public final Builder creationTime(long value) {
            this.creationTime = value;
            return this;
        }

        /**
         * Required - API name: {@code pit_id}
         */
        @Nonnull
        public final Builder pitId(String value) {
            this.pitId = value;
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
         * Builds a {@link CreatePitResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public CreatePitResponse build() {
            _checkSingleUse();

            return new CreatePitResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link CreatePitResponse}
     */
    public static final JsonpDeserializer<CreatePitResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CreatePitResponse::setupCreatePitResponseDeserializer
    );

    protected static void setupCreatePitResponseDeserializer(ObjectDeserializer<CreatePitResponse.Builder> op) {
        op.add(Builder::creationTime, JsonpDeserializer.longDeserializer(), "creation_time");
        op.add(Builder::pitId, JsonpDeserializer.stringDeserializer(), "pit_id");
        op.add(Builder::shards, ShardStatistics._DESERIALIZER, "_shards");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Long.hashCode(this.creationTime);
        result = 31 * result + this.pitId.hashCode();
        result = 31 * result + this.shards.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CreatePitResponse other = (CreatePitResponse) o;
        return this.creationTime == other.creationTime && this.pitId.equals(other.pitId) && this.shards.equals(other.shards);
    }
}
