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
import java.util.HashMap;
import java.util.Map;
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

// typedef: ism.explain_policy.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ExplainPolicyResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ExplainPolicyResponse.Builder, ExplainPolicyResponse> {

    @Nonnull
    private final Map<String, ExplainPolicy> metadata;

    @Nullable
    private final Number totalManagedIndices;

    // ---------------------------------------------------------------------------------------------

    private ExplainPolicyResponse(Builder builder) {
        this.metadata = ApiTypeHelper.unmodifiable(builder.metadata);
        this.totalManagedIndices = builder.totalManagedIndices;
    }

    public static ExplainPolicyResponse of(Function<ExplainPolicyResponse.Builder, ObjectBuilder<ExplainPolicyResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    @Nonnull
    public final Map<String, ExplainPolicy> metadata() {
        return this.metadata;
    }

    /**
     * The total number of managed indices.
     * <p>
     * API name: {@code total_managed_indices}
     * </p>
     */
    @Nullable
    public final Number totalManagedIndices() {
        return this.totalManagedIndices;
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
        for (Map.Entry<String, ExplainPolicy> item0 : this.metadata.entrySet()) {
            generator.writeKey(item0.getKey());
            item0.getValue().serialize(generator, mapper);
        }
        if (this.totalManagedIndices != null) {
            generator.writeKey("total_managed_indices");
            generator.write(this.totalManagedIndices.doubleValue());
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
     * Builder for {@link ExplainPolicyResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ExplainPolicyResponse> {
        @Nullable
        private Map<String, ExplainPolicy> metadata;
        @Nullable
        private Number totalManagedIndices;

        public Builder() {}

        private Builder(ExplainPolicyResponse o) {
            this.metadata = _mapCopy(o.metadata);
            this.totalManagedIndices = o.totalManagedIndices;
        }

        private Builder(Builder o) {
            this.metadata = _mapCopy(o.metadata);
            this.totalManagedIndices = o.totalManagedIndices;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>metadata</code>.
         * </p>
         */
        @Nonnull
        public final Builder metadata(Map<String, ExplainPolicy> map) {
            this.metadata = _mapPutAll(this.metadata, map);
            return this;
        }

        /**
         *
         * <p>
         * Adds an entry to <code>metadata</code>.
         * </p>
         */
        @Nonnull
        public final Builder metadata(String key, ExplainPolicy value) {
            this.metadata = _mapPut(this.metadata, key, value);
            return this;
        }

        /**
         *
         * <p>
         * Adds a value to <code>metadata</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder metadata(String key, Function<ExplainPolicy.Builder, ObjectBuilder<ExplainPolicy>> fn) {
            return metadata(key, fn.apply(new ExplainPolicy.Builder()).build());
        }

        /**
         * The total number of managed indices.
         * <p>
         * API name: {@code total_managed_indices}
         * </p>
         */
        @Nonnull
        public final Builder totalManagedIndices(@Nullable Number value) {
            this.totalManagedIndices = value;
            return this;
        }

        /**
         * Builds a {@link ExplainPolicyResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ExplainPolicyResponse build() {
            _checkSingleUse();

            return new ExplainPolicyResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ExplainPolicyResponse}
     */
    public static final JsonpDeserializer<ExplainPolicyResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ExplainPolicyResponse::setupExplainPolicyResponseDeserializer
    );

    protected static void setupExplainPolicyResponseDeserializer(ObjectDeserializer<ExplainPolicyResponse.Builder> op) {
        op.add(Builder::totalManagedIndices, JsonpDeserializer.numberDeserializer(), "total_managed_indices");
        op.setUnknownFieldHandler((builder, name, parser, mapper) -> {
            if (builder.metadata == null) {
                builder.metadata = new HashMap<>();
            }
            builder.metadata.put(name, ExplainPolicy._DESERIALIZER.deserialize(parser, mapper));
        });
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.metadata);
        result = 31 * result + Objects.hashCode(this.totalManagedIndices);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ExplainPolicyResponse other = (ExplainPolicyResponse) o;
        return Objects.equals(this.metadata, other.metadata) && Objects.equals(this.totalManagedIndices, other.totalManagedIndices);
    }
}
