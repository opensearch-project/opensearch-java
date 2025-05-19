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

package org.opensearch.client.opensearch.core.search;

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

// typedef: core.search.PhraseSuggestCollate

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class PhraseSuggestCollate implements PlainJsonSerializable, ToCopyableBuilder<PhraseSuggestCollate.Builder, PhraseSuggestCollate> {

    @Nonnull
    private final Map<String, JsonData> params;

    @Nullable
    private final Boolean prune;

    @Nonnull
    private final PhraseSuggestCollateQuery query;

    // ---------------------------------------------------------------------------------------------

    private PhraseSuggestCollate(Builder builder) {
        this.params = ApiTypeHelper.unmodifiable(builder.params);
        this.prune = builder.prune;
        this.query = ApiTypeHelper.requireNonNull(builder.query, this, "query");
    }

    public static PhraseSuggestCollate of(Function<PhraseSuggestCollate.Builder, ObjectBuilder<PhraseSuggestCollate>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code params}
     */
    @Nonnull
    public final Map<String, JsonData> params() {
        return this.params;
    }

    /**
     * API name: {@code prune}
     */
    @Nullable
    public final Boolean prune() {
        return this.prune;
    }

    /**
     * Required - API name: {@code query}
     */
    @Nonnull
    public final PhraseSuggestCollateQuery query() {
        return this.query;
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
        if (ApiTypeHelper.isDefined(this.params)) {
            generator.writeKey("params");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.params.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.prune != null) {
            generator.writeKey("prune");
            generator.write(this.prune);
        }

        generator.writeKey("query");
        this.query.serialize(generator, mapper);
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
     * Builder for {@link PhraseSuggestCollate}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, PhraseSuggestCollate> {
        @Nullable
        private Map<String, JsonData> params;
        @Nullable
        private Boolean prune;
        private PhraseSuggestCollateQuery query;

        public Builder() {}

        private Builder(PhraseSuggestCollate o) {
            this.params = _mapCopy(o.params);
            this.prune = o.prune;
            this.query = o.query;
        }

        private Builder(Builder o) {
            this.params = _mapCopy(o.params);
            this.prune = o.prune;
            this.query = o.query;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code params}
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
         * API name: {@code params}
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
         * API name: {@code prune}
         */
        @Nonnull
        public final Builder prune(@Nullable Boolean value) {
            this.prune = value;
            return this;
        }

        /**
         * Required - API name: {@code query}
         */
        @Nonnull
        public final Builder query(PhraseSuggestCollateQuery value) {
            this.query = value;
            return this;
        }

        /**
         * Required - API name: {@code query}
         */
        @Nonnull
        public final Builder query(Function<PhraseSuggestCollateQuery.Builder, ObjectBuilder<PhraseSuggestCollateQuery>> fn) {
            return query(fn.apply(new PhraseSuggestCollateQuery.Builder()).build());
        }

        /**
         * Builds a {@link PhraseSuggestCollate}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PhraseSuggestCollate build() {
            _checkSingleUse();

            return new PhraseSuggestCollate(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PhraseSuggestCollate}
     */
    public static final JsonpDeserializer<PhraseSuggestCollate> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PhraseSuggestCollate::setupPhraseSuggestCollateDeserializer
    );

    protected static void setupPhraseSuggestCollateDeserializer(ObjectDeserializer<PhraseSuggestCollate.Builder> op) {
        op.add(Builder::params, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "params");
        op.add(Builder::prune, JsonpDeserializer.booleanDeserializer(), "prune");
        op.add(Builder::query, PhraseSuggestCollateQuery._DESERIALIZER, "query");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.params);
        result = 31 * result + Objects.hashCode(this.prune);
        result = 31 * result + this.query.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PhraseSuggestCollate other = (PhraseSuggestCollate) o;
        return Objects.equals(this.params, other.params) && Objects.equals(this.prune, other.prune) && this.query.equals(other.query);
    }
}
