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

// typedef: indices.TranslogBatchAppend

/**
 * The translog batch append configuration.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class TranslogBatchAppend implements PlainJsonSerializable, ToCopyableBuilder<TranslogBatchAppend.Builder, TranslogBatchAppend> {

    @Nullable
    private final Boolean enabled;

    @Nullable
    private final Integer maxOperations;

    @Nullable
    private final String maxSize;

    // ---------------------------------------------------------------------------------------------

    private TranslogBatchAppend(Builder builder) {
        this.enabled = builder.enabled;
        this.maxOperations = builder.maxOperations;
        this.maxSize = builder.maxSize;
    }

    public static TranslogBatchAppend of(Function<TranslogBatchAppend.Builder, ObjectBuilder<TranslogBatchAppend>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Whether successful primary index operations are appended to the translog in bounded batches instead of one write per operation. Only
     * takes effect on remote-backed indexes that use segment replication and a remote translog. Default is <code>false</code>.
     * <p>
     * API name: {@code enabled}
     * </p>
     */
    @Nullable
    public final Boolean enabled() {
        return this.enabled;
    }

    /**
     * The maximum number of operations in one batched translog append. Valid values are <code>1</code> to <code>100000</code>. Default is
     * <code>1000</code>.
     * <p>
     * API name: {@code max_operations}
     * </p>
     */
    @Nullable
    public final Integer maxOperations() {
        return this.maxOperations;
    }

    /**
     * The maximum serialized size of one batched translog append. Valid values are <code>4kb</code> to <code>64mb</code>. Default is
     * <code>1mb</code>.
     * <p>
     * API name: {@code max_size}
     * </p>
     */
    @Nullable
    public final String maxSize() {
        return this.maxSize;
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
        if (this.enabled != null) {
            generator.writeKey("enabled");
            generator.write(this.enabled);
        }

        if (this.maxOperations != null) {
            generator.writeKey("max_operations");
            generator.write(this.maxOperations);
        }

        if (this.maxSize != null) {
            generator.writeKey("max_size");
            generator.write(this.maxSize);
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
     * Builder for {@link TranslogBatchAppend}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, TranslogBatchAppend> {
        @Nullable
        private Boolean enabled;
        @Nullable
        private Integer maxOperations;
        @Nullable
        private String maxSize;

        public Builder() {}

        private Builder(TranslogBatchAppend o) {
            this.enabled = o.enabled;
            this.maxOperations = o.maxOperations;
            this.maxSize = o.maxSize;
        }

        private Builder(Builder o) {
            this.enabled = o.enabled;
            this.maxOperations = o.maxOperations;
            this.maxSize = o.maxSize;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Whether successful primary index operations are appended to the translog in bounded batches instead of one write per operation.
         * Only takes effect on remote-backed indexes that use segment replication and a remote translog. Default is <code>false</code>.
         * <p>
         * API name: {@code enabled}
         * </p>
         */
        @Nonnull
        public final Builder enabled(@Nullable Boolean value) {
            this.enabled = value;
            return this;
        }

        /**
         * The maximum number of operations in one batched translog append. Valid values are <code>1</code> to <code>100000</code>. Default
         * is <code>1000</code>.
         * <p>
         * API name: {@code max_operations}
         * </p>
         */
        @Nonnull
        public final Builder maxOperations(@Nullable Integer value) {
            this.maxOperations = value;
            return this;
        }

        /**
         * The maximum serialized size of one batched translog append. Valid values are <code>4kb</code> to <code>64mb</code>. Default is
         * <code>1mb</code>.
         * <p>
         * API name: {@code max_size}
         * </p>
         */
        @Nonnull
        public final Builder maxSize(@Nullable String value) {
            this.maxSize = value;
            return this;
        }

        /**
         * Builds a {@link TranslogBatchAppend}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public TranslogBatchAppend build() {
            _checkSingleUse();

            return new TranslogBatchAppend(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link TranslogBatchAppend}
     */
    public static final JsonpDeserializer<TranslogBatchAppend> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        TranslogBatchAppend::setupTranslogBatchAppendDeserializer
    );

    protected static void setupTranslogBatchAppendDeserializer(ObjectDeserializer<TranslogBatchAppend.Builder> op) {
        op.add(Builder::enabled, JsonpDeserializer.booleanDeserializer(), "enabled");
        op.add(Builder::maxOperations, JsonpDeserializer.integerDeserializer(), "max_operations");
        op.add(Builder::maxSize, JsonpDeserializer.stringDeserializer(), "max_size");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.enabled);
        result = 31 * result + Objects.hashCode(this.maxOperations);
        result = 31 * result + Objects.hashCode(this.maxSize);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        TranslogBatchAppend other = (TranslogBatchAppend) o;
        return Objects.equals(this.enabled, other.enabled)
            && Objects.equals(this.maxOperations, other.maxOperations)
            && Objects.equals(this.maxSize, other.maxSize);
    }
}
