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

package org.opensearch.client.opensearch.snapshot;

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
import org.opensearch.client.opensearch.snapshot.verify_repository.CompactNodeInfo;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: snapshot.verify_repository.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class VerifyRepositoryResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<VerifyRepositoryResponse.Builder, VerifyRepositoryResponse> {

    @Nonnull
    private final Map<String, CompactNodeInfo> nodes;

    // ---------------------------------------------------------------------------------------------

    private VerifyRepositoryResponse(Builder builder) {
        this.nodes = ApiTypeHelper.unmodifiableRequired(builder.nodes, this, "nodes");
    }

    public static VerifyRepositoryResponse of(Function<VerifyRepositoryResponse.Builder, ObjectBuilder<VerifyRepositoryResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code nodes}
     */
    @Nonnull
    public final Map<String, CompactNodeInfo> nodes() {
        return this.nodes;
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
        generator.writeKey("nodes");
        generator.writeStartObject();
        for (Map.Entry<String, CompactNodeInfo> item0 : this.nodes.entrySet()) {
            generator.writeKey(item0.getKey());
            item0.getValue().serialize(generator, mapper);
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
     * Builder for {@link VerifyRepositoryResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, VerifyRepositoryResponse> {
        private Map<String, CompactNodeInfo> nodes;

        public Builder() {}

        private Builder(VerifyRepositoryResponse o) {
            this.nodes = _mapCopy(o.nodes);
        }

        private Builder(Builder o) {
            this.nodes = _mapCopy(o.nodes);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code nodes}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>nodes</code>.
         * </p>
         */
        @Nonnull
        public final Builder nodes(Map<String, CompactNodeInfo> map) {
            this.nodes = _mapPutAll(this.nodes, map);
            return this;
        }

        /**
         * Required - API name: {@code nodes}
         *
         * <p>
         * Adds an entry to <code>nodes</code>.
         * </p>
         */
        @Nonnull
        public final Builder nodes(String key, CompactNodeInfo value) {
            this.nodes = _mapPut(this.nodes, key, value);
            return this;
        }

        /**
         * Required - API name: {@code nodes}
         *
         * <p>
         * Adds a value to <code>nodes</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder nodes(String key, Function<CompactNodeInfo.Builder, ObjectBuilder<CompactNodeInfo>> fn) {
            return nodes(key, fn.apply(new CompactNodeInfo.Builder()).build());
        }

        /**
         * Builds a {@link VerifyRepositoryResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public VerifyRepositoryResponse build() {
            _checkSingleUse();

            return new VerifyRepositoryResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link VerifyRepositoryResponse}
     */
    public static final JsonpDeserializer<VerifyRepositoryResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        VerifyRepositoryResponse::setupVerifyRepositoryResponseDeserializer
    );

    protected static void setupVerifyRepositoryResponseDeserializer(ObjectDeserializer<VerifyRepositoryResponse.Builder> op) {
        op.add(Builder::nodes, JsonpDeserializer.stringMapDeserializer(CompactNodeInfo._DESERIALIZER), "nodes");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.nodes.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        VerifyRepositoryResponse other = (VerifyRepositoryResponse) o;
        return this.nodes.equals(other.nodes);
    }
}
