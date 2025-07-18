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
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonData;
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

// typedef: ltr.StoreDetails

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class StoreDetails implements PlainJsonSerializable, ToCopyableBuilder<StoreDetails.Builder, StoreDetails> {

    @Nonnull
    private final Map<String, JsonData> counts;

    @Nullable
    private final String index;

    @Nullable
    private final String store;

    @Nullable
    private final Integer version;

    // ---------------------------------------------------------------------------------------------

    private StoreDetails(Builder builder) {
        this.counts = ApiTypeHelper.unmodifiable(builder.counts);
        this.index = builder.index;
        this.store = builder.store;
        this.version = builder.version;
    }

    public static StoreDetails of(Function<StoreDetails.Builder, ObjectBuilder<StoreDetails>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Count statistics for this store.
     * <p>
     * API name: {@code counts}
     * </p>
     */
    @Nonnull
    public final Map<String, JsonData> counts() {
        return this.counts;
    }

    /**
     * The index name for this store.
     * <p>
     * API name: {@code index}
     * </p>
     */
    @Nullable
    public final String index() {
        return this.index;
    }

    /**
     * The name of the store.
     * <p>
     * API name: {@code store}
     * </p>
     */
    @Nullable
    public final String store() {
        return this.store;
    }

    /**
     * Store version.
     * <p>
     * API name: {@code version}
     * </p>
     */
    @Nullable
    public final Integer version() {
        return this.version;
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
        if (ApiTypeHelper.isDefined(this.counts)) {
            generator.writeKey("counts");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.counts.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.index != null) {
            generator.writeKey("index");
            generator.write(this.index);
        }

        if (this.store != null) {
            generator.writeKey("store");
            generator.write(this.store);
        }

        if (this.version != null) {
            generator.writeKey("version");
            generator.write(this.version);
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
     * Builder for {@link StoreDetails}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, StoreDetails> {
        @Nullable
        private Map<String, JsonData> counts;
        @Nullable
        private String index;
        @Nullable
        private String store;
        @Nullable
        private Integer version;

        public Builder() {}

        private Builder(StoreDetails o) {
            this.counts = _mapCopy(o.counts);
            this.index = o.index;
            this.store = o.store;
            this.version = o.version;
        }

        private Builder(Builder o) {
            this.counts = _mapCopy(o.counts);
            this.index = o.index;
            this.store = o.store;
            this.version = o.version;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Count statistics for this store.
         * <p>
         * API name: {@code counts}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>counts</code>.
         * </p>
         */
        @Nonnull
        public final Builder counts(Map<String, JsonData> map) {
            this.counts = _mapPutAll(this.counts, map);
            return this;
        }

        /**
         * Count statistics for this store.
         * <p>
         * API name: {@code counts}
         * </p>
         *
         * <p>
         * Adds an entry to <code>counts</code>.
         * </p>
         */
        @Nonnull
        public final Builder counts(String key, JsonData value) {
            this.counts = _mapPut(this.counts, key, value);
            return this;
        }

        /**
         * The index name for this store.
         * <p>
         * API name: {@code index}
         * </p>
         */
        @Nonnull
        public final Builder index(@Nullable String value) {
            this.index = value;
            return this;
        }

        /**
         * The name of the store.
         * <p>
         * API name: {@code store}
         * </p>
         */
        @Nonnull
        public final Builder store(@Nullable String value) {
            this.store = value;
            return this;
        }

        /**
         * Store version.
         * <p>
         * API name: {@code version}
         * </p>
         */
        @Nonnull
        public final Builder version(@Nullable Integer value) {
            this.version = value;
            return this;
        }

        /**
         * Builds a {@link StoreDetails}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public StoreDetails build() {
            _checkSingleUse();

            return new StoreDetails(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link StoreDetails}
     */
    public static final JsonpDeserializer<StoreDetails> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        StoreDetails::setupStoreDetailsDeserializer
    );

    protected static void setupStoreDetailsDeserializer(ObjectDeserializer<StoreDetails.Builder> op) {
        op.add(Builder::counts, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "counts");
        op.add(Builder::index, JsonpDeserializer.stringDeserializer(), "index");
        op.add(Builder::store, JsonpDeserializer.stringDeserializer(), "store");
        op.add(Builder::version, JsonpDeserializer.integerDeserializer(), "version");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.counts);
        result = 31 * result + Objects.hashCode(this.index);
        result = 31 * result + Objects.hashCode(this.store);
        result = 31 * result + Objects.hashCode(this.version);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        StoreDetails other = (StoreDetails) o;
        return Objects.equals(this.counts, other.counts)
            && Objects.equals(this.index, other.index)
            && Objects.equals(this.store, other.store)
            && Objects.equals(this.version, other.version);
    }
}
