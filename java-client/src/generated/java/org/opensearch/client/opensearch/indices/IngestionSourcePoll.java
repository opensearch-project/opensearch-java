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

// typedef: indices.IngestionSourcePoll

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IngestionSourcePoll implements PlainJsonSerializable, ToCopyableBuilder<IngestionSourcePoll.Builder, IngestionSourcePoll> {

    @Nullable
    private final Long maxBatchSize;

    @Nullable
    private final Integer timeout;

    // ---------------------------------------------------------------------------------------------

    private IngestionSourcePoll(Builder builder) {
        this.maxBatchSize = builder.maxBatchSize;
        this.timeout = builder.timeout;
    }

    public static IngestionSourcePoll of(Function<IngestionSourcePoll.Builder, ObjectBuilder<IngestionSourcePoll>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The maximum number of records to retrieve in each poll operation.
     * <p>
     * API name: {@code max_batch_size}
     * </p>
     */
    @Nullable
    public final Long maxBatchSize() {
        return this.maxBatchSize;
    }

    /**
     * Determines the Poll timeout value.
     * <p>
     * API name: {@code timeout}
     * </p>
     */
    @Nullable
    public final Integer timeout() {
        return this.timeout;
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
        if (this.maxBatchSize != null) {
            generator.writeKey("max_batch_size");
            generator.write(this.maxBatchSize);
        }

        if (this.timeout != null) {
            generator.writeKey("timeout");
            generator.write(this.timeout);
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
     * Builder for {@link IngestionSourcePoll}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IngestionSourcePoll> {
        @Nullable
        private Long maxBatchSize;
        @Nullable
        private Integer timeout;

        public Builder() {}

        private Builder(IngestionSourcePoll o) {
            this.maxBatchSize = o.maxBatchSize;
            this.timeout = o.timeout;
        }

        private Builder(Builder o) {
            this.maxBatchSize = o.maxBatchSize;
            this.timeout = o.timeout;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The maximum number of records to retrieve in each poll operation.
         * <p>
         * API name: {@code max_batch_size}
         * </p>
         */
        @Nonnull
        public final Builder maxBatchSize(@Nullable Long value) {
            this.maxBatchSize = value;
            return this;
        }

        /**
         * Determines the Poll timeout value.
         * <p>
         * API name: {@code timeout}
         * </p>
         */
        @Nonnull
        public final Builder timeout(@Nullable Integer value) {
            this.timeout = value;
            return this;
        }

        /**
         * Builds a {@link IngestionSourcePoll}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IngestionSourcePoll build() {
            _checkSingleUse();

            return new IngestionSourcePoll(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IngestionSourcePoll}
     */
    public static final JsonpDeserializer<IngestionSourcePoll> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IngestionSourcePoll::setupIngestionSourcePollDeserializer
    );

    protected static void setupIngestionSourcePollDeserializer(ObjectDeserializer<IngestionSourcePoll.Builder> op) {
        op.add(Builder::maxBatchSize, JsonpDeserializer.longDeserializer(), "max_batch_size");
        op.add(Builder::timeout, JsonpDeserializer.integerDeserializer(), "timeout");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.maxBatchSize);
        result = 31 * result + Objects.hashCode(this.timeout);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IngestionSourcePoll other = (IngestionSourcePoll) o;
        return Objects.equals(this.maxBatchSize, other.maxBatchSize) && Objects.equals(this.timeout, other.timeout);
    }
}
