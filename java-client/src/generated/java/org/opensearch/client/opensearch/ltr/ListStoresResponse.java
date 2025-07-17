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

package org.opensearch.client.opensearch.ltr;

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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ltr.list_stores.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ListStoresResponse implements PlainJsonSerializable, ToCopyableBuilder<ListStoresResponse.Builder, ListStoresResponse> {

    @Nonnull
    private final Map<String, StoreDetails> stores;

    // ---------------------------------------------------------------------------------------------

    private ListStoresResponse(Builder builder) {
        this.stores = ApiTypeHelper.unmodifiableRequired(builder.stores, this, "stores");
    }

    public static ListStoresResponse of(Function<ListStoresResponse.Builder, ObjectBuilder<ListStoresResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - Map of available feature stores.
     * <p>
     * API name: {@code stores}
     * </p>
     */
    @Nonnull
    public final Map<String, StoreDetails> stores() {
        return this.stores;
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
        generator.writeKey("stores");
        generator.writeStartObject();
        for (Map.Entry<String, StoreDetails> item0 : this.stores.entrySet()) {
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
     * Builder for {@link ListStoresResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ListStoresResponse> {
        private Map<String, StoreDetails> stores;

        public Builder() {}

        private Builder(ListStoresResponse o) {
            this.stores = _mapCopy(o.stores);
        }

        private Builder(Builder o) {
            this.stores = _mapCopy(o.stores);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - Map of available feature stores.
         * <p>
         * API name: {@code stores}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>stores</code>.
         * </p>
         */
        @Nonnull
        public final Builder stores(Map<String, StoreDetails> map) {
            this.stores = _mapPutAll(this.stores, map);
            return this;
        }

        /**
         * Required - Map of available feature stores.
         * <p>
         * API name: {@code stores}
         * </p>
         *
         * <p>
         * Adds an entry to <code>stores</code>.
         * </p>
         */
        @Nonnull
        public final Builder stores(String key, StoreDetails value) {
            this.stores = _mapPut(this.stores, key, value);
            return this;
        }

        /**
         * Required - Map of available feature stores.
         * <p>
         * API name: {@code stores}
         * </p>
         *
         * <p>
         * Adds a value to <code>stores</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder stores(String key, Function<StoreDetails.Builder, ObjectBuilder<StoreDetails>> fn) {
            return stores(key, fn.apply(new StoreDetails.Builder()).build());
        }

        /**
         * Builds a {@link ListStoresResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ListStoresResponse build() {
            _checkSingleUse();

            return new ListStoresResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ListStoresResponse}
     */
    public static final JsonpDeserializer<ListStoresResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ListStoresResponse::setupListStoresResponseDeserializer
    );

    protected static void setupListStoresResponseDeserializer(ObjectDeserializer<ListStoresResponse.Builder> op) {
        op.add(Builder::stores, JsonpDeserializer.stringMapDeserializer(StoreDetails._DESERIALIZER), "stores");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.stores.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ListStoresResponse other = (ListStoresResponse) o;
        return this.stores.equals(other.stores);
    }
}
