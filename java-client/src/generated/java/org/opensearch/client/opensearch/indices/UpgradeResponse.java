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
import org.opensearch.client.opensearch._types.ShardsOperationResponseBase;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: indices.upgrade.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class UpgradeResponse extends ShardsOperationResponseBase implements ToCopyableBuilder<UpgradeResponse.Builder, UpgradeResponse> {

    @Nonnull
    private final Map<String, UpgradeVersionStatus> upgradedIndices;

    // ---------------------------------------------------------------------------------------------

    private UpgradeResponse(Builder builder) {
        super(builder);
        this.upgradedIndices = ApiTypeHelper.unmodifiable(builder.upgradedIndices);
    }

    public static UpgradeResponse of(Function<UpgradeResponse.Builder, ObjectBuilder<UpgradeResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code upgraded_indices}
     */
    @Nonnull
    public final Map<String, UpgradeVersionStatus> upgradedIndices() {
        return this.upgradedIndices;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (ApiTypeHelper.isDefined(this.upgradedIndices)) {
            generator.writeKey("upgraded_indices");
            generator.writeStartObject();
            for (Map.Entry<String, UpgradeVersionStatus> item0 : this.upgradedIndices.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
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
     * Builder for {@link UpgradeResponse}.
     */
    public static class Builder extends ShardsOperationResponseBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, UpgradeResponse> {
        @Nullable
        private Map<String, UpgradeVersionStatus> upgradedIndices;

        public Builder() {}

        private Builder(UpgradeResponse o) {
            super(o);
            this.upgradedIndices = _mapCopy(o.upgradedIndices);
        }

        private Builder(Builder o) {
            super(o);
            this.upgradedIndices = _mapCopy(o.upgradedIndices);
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
         * API name: {@code upgraded_indices}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>upgradedIndices</code>.
         * </p>
         */
        @Nonnull
        public final Builder upgradedIndices(Map<String, UpgradeVersionStatus> map) {
            this.upgradedIndices = _mapPutAll(this.upgradedIndices, map);
            return this;
        }

        /**
         * API name: {@code upgraded_indices}
         *
         * <p>
         * Adds an entry to <code>upgradedIndices</code>.
         * </p>
         */
        @Nonnull
        public final Builder upgradedIndices(String key, UpgradeVersionStatus value) {
            this.upgradedIndices = _mapPut(this.upgradedIndices, key, value);
            return this;
        }

        /**
         * API name: {@code upgraded_indices}
         *
         * <p>
         * Adds a value to <code>upgradedIndices</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder upgradedIndices(String key, Function<UpgradeVersionStatus.Builder, ObjectBuilder<UpgradeVersionStatus>> fn) {
            return upgradedIndices(key, fn.apply(new UpgradeVersionStatus.Builder()).build());
        }

        /**
         * Builds a {@link UpgradeResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public UpgradeResponse build() {
            _checkSingleUse();

            return new UpgradeResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link UpgradeResponse}
     */
    public static final JsonpDeserializer<UpgradeResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        UpgradeResponse::setupUpgradeResponseDeserializer
    );

    protected static void setupUpgradeResponseDeserializer(ObjectDeserializer<UpgradeResponse.Builder> op) {
        setupShardsOperationResponseBaseDeserializer(op);
        op.add(Builder::upgradedIndices, JsonpDeserializer.stringMapDeserializer(UpgradeVersionStatus._DESERIALIZER), "upgraded_indices");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.upgradedIndices);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        UpgradeResponse other = (UpgradeResponse) o;
        return Objects.equals(this.upgradedIndices, other.upgradedIndices);
    }
}
