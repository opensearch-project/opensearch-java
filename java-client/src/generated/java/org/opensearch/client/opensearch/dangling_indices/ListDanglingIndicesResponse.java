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

package org.opensearch.client.opensearch.dangling_indices;

import jakarta.json.stream.JsonGenerator;
import java.util.List;
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
import org.opensearch.client.opensearch.dangling_indices.list_dangling_indices.DanglingIndex;
import org.opensearch.client.opensearch.nodes.NodesResponseBase;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: dangling_indices.list_dangling_indices.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ListDanglingIndicesResponse extends NodesResponseBase
    implements
        ToCopyableBuilder<ListDanglingIndicesResponse.Builder, ListDanglingIndicesResponse> {

    @Nullable
    private final String clusterName;

    @Nonnull
    private final List<DanglingIndex> danglingIndices;

    // ---------------------------------------------------------------------------------------------

    private ListDanglingIndicesResponse(Builder builder) {
        super(builder);
        this.clusterName = builder.clusterName;
        this.danglingIndices = ApiTypeHelper.unmodifiableRequired(builder.danglingIndices, this, "danglingIndices");
    }

    public static ListDanglingIndicesResponse of(
        Function<ListDanglingIndicesResponse.Builder, ObjectBuilder<ListDanglingIndicesResponse>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code cluster_name}
     */
    @Nullable
    public final String clusterName() {
        return this.clusterName;
    }

    /**
     * Required - API name: {@code dangling_indices}
     */
    @Nonnull
    public final List<DanglingIndex> danglingIndices() {
        return this.danglingIndices;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.clusterName != null) {
            generator.writeKey("cluster_name");
            generator.write(this.clusterName);
        }

        generator.writeKey("dangling_indices");
        generator.writeStartArray();
        for (DanglingIndex item0 : this.danglingIndices) {
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
     * Builder for {@link ListDanglingIndicesResponse}.
     */
    public static class Builder extends NodesResponseBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, ListDanglingIndicesResponse> {
        @Nullable
        private String clusterName;
        private List<DanglingIndex> danglingIndices;

        public Builder() {}

        private Builder(ListDanglingIndicesResponse o) {
            super(o);
            this.clusterName = o.clusterName;
            this.danglingIndices = _listCopy(o.danglingIndices);
        }

        private Builder(Builder o) {
            super(o);
            this.clusterName = o.clusterName;
            this.danglingIndices = _listCopy(o.danglingIndices);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        @Override
        @Nonnull
        protected Builder self() {
            return this;
        }

        /**
         * API name: {@code cluster_name}
         */
        @Nonnull
        public final Builder clusterName(@Nullable String value) {
            this.clusterName = value;
            return this;
        }

        /**
         * Required - API name: {@code dangling_indices}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>danglingIndices</code>.
         * </p>
         */
        @Nonnull
        public final Builder danglingIndices(List<DanglingIndex> list) {
            this.danglingIndices = _listAddAll(this.danglingIndices, list);
            return this;
        }

        /**
         * Required - API name: {@code dangling_indices}
         *
         * <p>
         * Adds one or more values to <code>danglingIndices</code>.
         * </p>
         */
        @Nonnull
        public final Builder danglingIndices(DanglingIndex value, DanglingIndex... values) {
            this.danglingIndices = _listAdd(this.danglingIndices, value, values);
            return this;
        }

        /**
         * Required - API name: {@code dangling_indices}
         *
         * <p>
         * Adds a value to <code>danglingIndices</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder danglingIndices(Function<DanglingIndex.Builder, ObjectBuilder<DanglingIndex>> fn) {
            return danglingIndices(fn.apply(new DanglingIndex.Builder()).build());
        }

        /**
         * Builds a {@link ListDanglingIndicesResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ListDanglingIndicesResponse build() {
            _checkSingleUse();

            return new ListDanglingIndicesResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ListDanglingIndicesResponse}
     */
    public static final JsonpDeserializer<ListDanglingIndicesResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ListDanglingIndicesResponse::setupListDanglingIndicesResponseDeserializer
    );

    protected static void setupListDanglingIndicesResponseDeserializer(ObjectDeserializer<ListDanglingIndicesResponse.Builder> op) {
        setupNodesResponseBaseDeserializer(op);
        op.add(Builder::clusterName, JsonpDeserializer.stringDeserializer(), "cluster_name");
        op.add(Builder::danglingIndices, JsonpDeserializer.arrayDeserializer(DanglingIndex._DESERIALIZER), "dangling_indices");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.clusterName);
        result = 31 * result + this.danglingIndices.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ListDanglingIndicesResponse other = (ListDanglingIndicesResponse) o;
        return Objects.equals(this.clusterName, other.clusterName) && this.danglingIndices.equals(other.danglingIndices);
    }
}
