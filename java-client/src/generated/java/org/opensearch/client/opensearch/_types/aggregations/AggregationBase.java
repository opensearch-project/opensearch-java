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

package org.opensearch.client.opensearch._types.aggregations;

import jakarta.json.stream.JsonGenerator;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonData;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: _types.aggregations.Aggregation

@Generated("org.opensearch.client.codegen.CodeGenerator")
public abstract class AggregationBase implements PlainJsonSerializable {

    @Nonnull
    private final Map<String, JsonData> meta;

    @Nullable
    private final String name;

    // ---------------------------------------------------------------------------------------------

    protected AggregationBase(AbstractBuilder<?> builder) {
        this.meta = ApiTypeHelper.unmodifiable(builder.meta);
        this.name = builder.name;
    }

    /**
     * API name: {@code meta}
     */
    @Nonnull
    public final Map<String, JsonData> meta() {
        return this.meta;
    }

    /**
     * API name: {@code name}
     */
    @Nullable
    public final String name() {
        return this.name;
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
        if (ApiTypeHelper.isDefined(this.meta)) {
            generator.writeKey("meta");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.meta.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.name != null) {
            generator.writeKey("name");
            generator.write(this.name);
        }
    }

    // ---------------------------------------------------------------------------------------------

    public abstract static class AbstractBuilder<BuilderT extends AbstractBuilder<BuilderT>> extends ObjectBuilderBase {
        @Nullable
        private Map<String, JsonData> meta;
        @Nullable
        private String name;

        protected AbstractBuilder() {}

        protected AbstractBuilder(AggregationBase o) {
            this.meta = _mapCopy(o.meta);
            this.name = o.name;
        }

        protected AbstractBuilder(AbstractBuilder<BuilderT> o) {
            this.meta = _mapCopy(o.meta);
            this.name = o.name;
        }

        @Nonnull
        protected abstract BuilderT self();

        /**
         * API name: {@code meta}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>meta</code>.
         * </p>
         */
        @Nonnull
        public final BuilderT meta(Map<String, JsonData> map) {
            this.meta = _mapPutAll(this.meta, map);
            return self();
        }

        /**
         * API name: {@code meta}
         *
         * <p>
         * Adds an entry to <code>meta</code>.
         * </p>
         */
        @Nonnull
        public final BuilderT meta(String key, JsonData value) {
            this.meta = _mapPut(this.meta, key, value);
            return self();
        }

        /**
         * API name: {@code name}
         */
        @Nonnull
        public final BuilderT name(@Nullable String value) {
            this.name = value;
            return self();
        }
    }

    // ---------------------------------------------------------------------------------------------

    protected static <BuilderT extends AbstractBuilder<BuilderT>> void setupAggregationBaseDeserializer(ObjectDeserializer<BuilderT> op) {
        op.add(AbstractBuilder::meta, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "meta");
        op.add(AbstractBuilder::name, JsonpDeserializer.stringDeserializer(), "name");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.meta);
        result = 31 * result + Objects.hashCode(this.name);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        AggregationBase other = (AggregationBase) o;
        return Objects.equals(this.meta, other.meta) && Objects.equals(this.name, other.name);
    }
}
