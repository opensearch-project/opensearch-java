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
import org.opensearch.client.opensearch._types.ShardStatistics;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: indices.forcemerge.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ForcemergeResponse implements PlainJsonSerializable, ToCopyableBuilder<ForcemergeResponse.Builder, ForcemergeResponse> {

    @Nullable
    private final ShardStatistics shards;

    @Nullable
    private final String task;

    // ---------------------------------------------------------------------------------------------

    private ForcemergeResponse(Builder builder) {
        this.shards = builder.shards;
        this.task = builder.task;
    }

    public static ForcemergeResponse of(Function<ForcemergeResponse.Builder, ObjectBuilder<ForcemergeResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code _shards}
     */
    @Nullable
    public final ShardStatistics shards() {
        return this.shards;
    }

    /**
     * Task contains a task id returned when <code>wait_for_completion=false</code>, you can use the <code>task_id</code> to get the status
     * of the task at _tasks/&lt;task_id&gt;.
     * <p>
     * API name: {@code task}
     * </p>
     */
    @Nullable
    public final String task() {
        return this.task;
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
        if (this.shards != null) {
            generator.writeKey("_shards");
            this.shards.serialize(generator, mapper);
        }

        if (this.task != null) {
            generator.writeKey("task");
            generator.write(this.task);
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
     * Builder for {@link ForcemergeResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ForcemergeResponse> {
        @Nullable
        private ShardStatistics shards;
        @Nullable
        private String task;

        public Builder() {}

        private Builder(ForcemergeResponse o) {
            this.shards = o.shards;
            this.task = o.task;
        }

        private Builder(Builder o) {
            this.shards = o.shards;
            this.task = o.task;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code _shards}
         */
        @Nonnull
        public final Builder shards(@Nullable ShardStatistics value) {
            this.shards = value;
            return this;
        }

        /**
         * API name: {@code _shards}
         */
        @Nonnull
        public final Builder shards(Function<ShardStatistics.Builder, ObjectBuilder<ShardStatistics>> fn) {
            return shards(fn.apply(new ShardStatistics.Builder()).build());
        }

        /**
         * Task contains a task id returned when <code>wait_for_completion=false</code>, you can use the <code>task_id</code> to get the
         * status of the task at _tasks/&lt;task_id&gt;.
         * <p>
         * API name: {@code task}
         * </p>
         */
        @Nonnull
        public final Builder task(@Nullable String value) {
            this.task = value;
            return this;
        }

        /**
         * Builds a {@link ForcemergeResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ForcemergeResponse build() {
            _checkSingleUse();

            return new ForcemergeResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ForcemergeResponse}
     */
    public static final JsonpDeserializer<ForcemergeResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ForcemergeResponse::setupForcemergeResponseDeserializer
    );

    protected static void setupForcemergeResponseDeserializer(ObjectDeserializer<ForcemergeResponse.Builder> op) {
        op.add(Builder::shards, ShardStatistics._DESERIALIZER, "_shards");
        op.add(Builder::task, JsonpDeserializer.stringDeserializer(), "task");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.shards);
        result = 31 * result + Objects.hashCode(this.task);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ForcemergeResponse other = (ForcemergeResponse) o;
        return Objects.equals(this.shards, other.shards) && Objects.equals(this.task, other.task);
    }
}
