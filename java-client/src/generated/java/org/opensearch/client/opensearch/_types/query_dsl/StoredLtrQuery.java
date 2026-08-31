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

package org.opensearch.client.opensearch._types.query_dsl;

import jakarta.json.stream.JsonGenerator;
import java.util.List;
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

// typedef: _types.query_dsl.StoredLtrQuery

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class StoredLtrQuery implements QueryVariant, PlainJsonSerializable, ToCopyableBuilder<StoredLtrQuery.Builder, StoredLtrQuery> {

    @Nonnull
    private final List<String> activeFeatures;

    @Nullable
    private final Float boost;

    @Nullable
    private final Boolean cache;

    @Nullable
    private final String featureset;

    @Nullable
    private final String model;

    @Nullable
    private final String name;

    @Nonnull
    private final Map<String, JsonData> params;

    @Nullable
    private final String store;

    // ---------------------------------------------------------------------------------------------

    private StoredLtrQuery(Builder builder) {
        this.activeFeatures = ApiTypeHelper.unmodifiable(builder.activeFeatures);
        this.boost = builder.boost;
        this.cache = builder.cache;
        this.featureset = builder.featureset;
        this.model = builder.model;
        this.name = builder.name;
        this.params = ApiTypeHelper.unmodifiableRequired(builder.params, this, "params");
        this.store = builder.store;
    }

    public static StoredLtrQuery of(Function<StoredLtrQuery.Builder, ObjectBuilder<StoredLtrQuery>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Query} variant kind.
     */
    @Override
    public Query.Kind _queryKind() {
        return Query.Kind.Sltr;
    }

    /**
     * API name: {@code active_features}
     */
    @Nonnull
    public final List<String> activeFeatures() {
        return this.activeFeatures;
    }

    /**
     * API name: {@code boost}
     */
    @Nullable
    public final Float boost() {
        return this.boost;
    }

    /**
     * API name: {@code cache}
     */
    @Nullable
    public final Boolean cache() {
        return this.cache;
    }

    /**
     * API name: {@code featureset}
     */
    @Nullable
    public final String featureset() {
        return this.featureset;
    }

    /**
     * API name: {@code model}
     */
    @Nullable
    public final String model() {
        return this.model;
    }

    /**
     * API name: {@code _name}
     */
    @Nullable
    public final String name() {
        return this.name;
    }

    /**
     * Required - API name: {@code params}
     */
    @Nonnull
    public final Map<String, JsonData> params() {
        return this.params;
    }

    /**
     * API name: {@code store}
     */
    @Nullable
    public final String store() {
        return this.store;
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
        if (ApiTypeHelper.isDefined(this.activeFeatures)) {
            generator.writeKey("active_features");
            generator.writeStartArray();
            for (String item0 : this.activeFeatures) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.boost != null) {
            generator.writeKey("boost");
            generator.write(this.boost);
        }

        if (this.cache != null) {
            generator.writeKey("cache");
            generator.write(this.cache);
        }

        if (this.featureset != null) {
            generator.writeKey("featureset");
            generator.write(this.featureset);
        }

        if (this.model != null) {
            generator.writeKey("model");
            generator.write(this.model);
        }

        if (this.name != null) {
            generator.writeKey("_name");
            generator.write(this.name);
        }

        generator.writeKey("params");
        generator.writeStartObject();
        for (Map.Entry<String, JsonData> item0 : this.params.entrySet()) {
            generator.writeKey(item0.getKey());
            item0.getValue().serialize(generator, mapper);
        }
        generator.writeEnd();

        if (this.store != null) {
            generator.writeKey("store");
            generator.write(this.store);
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
     * Builder for {@link StoredLtrQuery}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, StoredLtrQuery> {
        @Nullable
        private List<String> activeFeatures;
        @Nullable
        private Float boost;
        @Nullable
        private Boolean cache;
        @Nullable
        private String featureset;
        @Nullable
        private String model;
        @Nullable
        private String name;
        private Map<String, JsonData> params;
        @Nullable
        private String store;

        public Builder() {}

        private Builder(StoredLtrQuery o) {
            this.activeFeatures = _listCopy(o.activeFeatures);
            this.boost = o.boost;
            this.cache = o.cache;
            this.featureset = o.featureset;
            this.model = o.model;
            this.name = o.name;
            this.params = _mapCopy(o.params);
            this.store = o.store;
        }

        private Builder(Builder o) {
            this.activeFeatures = _listCopy(o.activeFeatures);
            this.boost = o.boost;
            this.cache = o.cache;
            this.featureset = o.featureset;
            this.model = o.model;
            this.name = o.name;
            this.params = _mapCopy(o.params);
            this.store = o.store;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code active_features}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>activeFeatures</code>.
         * </p>
         */
        @Nonnull
        public final Builder activeFeatures(List<String> list) {
            this.activeFeatures = _listAddAll(this.activeFeatures, list);
            return this;
        }

        /**
         * API name: {@code active_features}
         *
         * <p>
         * Adds one or more values to <code>activeFeatures</code>.
         * </p>
         */
        @Nonnull
        public final Builder activeFeatures(String value, String... values) {
            this.activeFeatures = _listAdd(this.activeFeatures, value, values);
            return this;
        }

        /**
         * API name: {@code boost}
         */
        @Nonnull
        public final Builder boost(@Nullable Float value) {
            this.boost = value;
            return this;
        }

        /**
         * API name: {@code cache}
         */
        @Nonnull
        public final Builder cache(@Nullable Boolean value) {
            this.cache = value;
            return this;
        }

        /**
         * API name: {@code featureset}
         */
        @Nonnull
        public final Builder featureset(@Nullable String value) {
            this.featureset = value;
            return this;
        }

        /**
         * API name: {@code model}
         */
        @Nonnull
        public final Builder model(@Nullable String value) {
            this.model = value;
            return this;
        }

        /**
         * API name: {@code _name}
         */
        @Nonnull
        public final Builder name(@Nullable String value) {
            this.name = value;
            return this;
        }

        /**
         * Required - API name: {@code params}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>params</code>.
         * </p>
         */
        @Nonnull
        public final Builder params(Map<String, JsonData> map) {
            this.params = _mapPutAll(this.params, map);
            return this;
        }

        /**
         * Required - API name: {@code params}
         *
         * <p>
         * Adds an entry to <code>params</code>.
         * </p>
         */
        @Nonnull
        public final Builder params(String key, JsonData value) {
            this.params = _mapPut(this.params, key, value);
            return this;
        }

        /**
         * API name: {@code store}
         */
        @Nonnull
        public final Builder store(@Nullable String value) {
            this.store = value;
            return this;
        }

        /**
         * Builds a {@link StoredLtrQuery}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public StoredLtrQuery build() {
            _checkSingleUse();

            return new StoredLtrQuery(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link StoredLtrQuery}
     */
    public static final JsonpDeserializer<StoredLtrQuery> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        StoredLtrQuery::setupStoredLtrQueryDeserializer
    );

    protected static void setupStoredLtrQueryDeserializer(ObjectDeserializer<StoredLtrQuery.Builder> op) {
        op.add(Builder::activeFeatures, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "active_features");
        op.add(Builder::boost, JsonpDeserializer.floatDeserializer(), "boost");
        op.add(Builder::cache, JsonpDeserializer.booleanDeserializer(), "cache");
        op.add(Builder::featureset, JsonpDeserializer.stringDeserializer(), "featureset");
        op.add(Builder::model, JsonpDeserializer.stringDeserializer(), "model");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "_name");
        op.add(Builder::params, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "params");
        op.add(Builder::store, JsonpDeserializer.stringDeserializer(), "store");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.activeFeatures);
        result = 31 * result + Objects.hashCode(this.boost);
        result = 31 * result + Objects.hashCode(this.cache);
        result = 31 * result + Objects.hashCode(this.featureset);
        result = 31 * result + Objects.hashCode(this.model);
        result = 31 * result + Objects.hashCode(this.name);
        result = 31 * result + this.params.hashCode();
        result = 31 * result + Objects.hashCode(this.store);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        StoredLtrQuery other = (StoredLtrQuery) o;
        return Objects.equals(this.activeFeatures, other.activeFeatures)
            && Objects.equals(this.boost, other.boost)
            && Objects.equals(this.cache, other.cache)
            && Objects.equals(this.featureset, other.featureset)
            && Objects.equals(this.model, other.model)
            && Objects.equals(this.name, other.name)
            && this.params.equals(other.params)
            && Objects.equals(this.store, other.store);
    }
}
