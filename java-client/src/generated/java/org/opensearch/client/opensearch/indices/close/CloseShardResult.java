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

package org.opensearch.client.opensearch.indices.close;

import jakarta.json.stream.JsonGenerator;
import java.util.List;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.opensearch._types.ShardFailure;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: indices.close.CloseShardResult

/**
 * The result of closing shards in an index.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class CloseShardResult implements PlainJsonSerializable, ToCopyableBuilder<CloseShardResult.Builder, CloseShardResult> {

    @Nonnull
    private final List<ShardFailure> failures;

    // ---------------------------------------------------------------------------------------------

    private CloseShardResult(Builder builder) {
        this.failures = ApiTypeHelper.unmodifiableRequired(builder.failures, this, "failures");
    }

    public static CloseShardResult of(Function<CloseShardResult.Builder, ObjectBuilder<CloseShardResult>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The list of failures that occurred while closing shards.
     * <p>
     * API name: {@code failures}
     * </p>
     */
    @Nonnull
    public final List<ShardFailure> failures() {
        return this.failures;
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
        generator.writeKey("failures");
        generator.writeStartArray();
        for (ShardFailure item0 : this.failures) {
            item0.serialize(generator, mapper);
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
     * Builder for {@link CloseShardResult}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, CloseShardResult> {
        private List<ShardFailure> failures;

        public Builder() {}

        private Builder(CloseShardResult o) {
            this.failures = _listCopy(o.failures);
        }

        private Builder(Builder o) {
            this.failures = _listCopy(o.failures);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - The list of failures that occurred while closing shards.
         * <p>
         * API name: {@code failures}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>failures</code>.
         * </p>
         */
        @Nonnull
        public final Builder failures(List<ShardFailure> list) {
            this.failures = _listAddAll(this.failures, list);
            return this;
        }

        /**
         * Required - The list of failures that occurred while closing shards.
         * <p>
         * API name: {@code failures}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>failures</code>.
         * </p>
         */
        @Nonnull
        public final Builder failures(ShardFailure value, ShardFailure... values) {
            this.failures = _listAdd(this.failures, value, values);
            return this;
        }

        /**
         * Required - The list of failures that occurred while closing shards.
         * <p>
         * API name: {@code failures}
         * </p>
         *
         * <p>
         * Adds a value to <code>failures</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder failures(Function<ShardFailure.Builder, ObjectBuilder<ShardFailure>> fn) {
            return failures(fn.apply(new ShardFailure.Builder()).build());
        }

        /**
         * Builds a {@link CloseShardResult}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public CloseShardResult build() {
            _checkSingleUse();

            return new CloseShardResult(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link CloseShardResult}
     */
    public static final JsonpDeserializer<CloseShardResult> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CloseShardResult::setupCloseShardResultDeserializer
    );

    protected static void setupCloseShardResultDeserializer(ObjectDeserializer<CloseShardResult.Builder> op) {
        op.add(Builder::failures, JsonpDeserializer.arrayDeserializer(ShardFailure._DESERIALIZER), "failures");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.failures.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CloseShardResult other = (CloseShardResult) o;
        return this.failures.equals(other.failures);
    }
}
