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
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonData;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.opensearch._types.FieldValue;
import org.opensearch.client.opensearch._types.Script;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: _types.aggregations.MetricAggregationBase

@Generated("org.opensearch.client.codegen.CodeGenerator")
public abstract class MetricAggregationBase implements PlainJsonSerializable {

    @Nullable
    private final String field;

    @Nonnull
    private final Map<String, JsonData> meta;

    @Nullable
    private final FieldValue missing;

    @Nullable
    private final String name;

    @Nullable
    private final Script script;

    // ---------------------------------------------------------------------------------------------

    protected MetricAggregationBase(AbstractBuilder<?> builder) {
        this.field = builder.field;
        this.meta = ApiTypeHelper.unmodifiable(builder.meta);
        this.missing = builder.missing;
        this.name = builder.name;
        this.script = builder.script;
    }

    /**
     * API name: {@code field}
     */
    @Nullable
    public final String field() {
        return this.field;
    }

    /**
     * API name: {@code meta}
     */
    @Nonnull
    public final Map<String, JsonData> meta() {
        return this.meta;
    }

    /**
     * API name: {@code missing}
     */
    @Nullable
    public final FieldValue missing() {
        return this.missing;
    }

    /**
     * API name: {@code name}
     */
    @Nullable
    public final String name() {
        return this.name;
    }

    /**
     * API name: {@code script}
     */
    @Nullable
    public final Script script() {
        return this.script;
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
        if (this.field != null) {
            generator.writeKey("field");
            generator.write(this.field);
        }

        if (ApiTypeHelper.isDefined(this.meta)) {
            generator.writeKey("meta");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.meta.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.missing != null) {
            generator.writeKey("missing");
            this.missing.serialize(generator, mapper);
        }

        if (this.name != null) {
            generator.writeKey("name");
            generator.write(this.name);
        }

        if (this.script != null) {
            generator.writeKey("script");
            this.script.serialize(generator, mapper);
        }
    }

    // ---------------------------------------------------------------------------------------------

    public abstract static class AbstractBuilder<BuilderT extends AbstractBuilder<BuilderT>> extends ObjectBuilderBase {
        @Nullable
        private String field;
        @Nullable
        private Map<String, JsonData> meta;
        @Nullable
        private FieldValue missing;
        @Nullable
        private String name;
        @Nullable
        private Script script;

        protected AbstractBuilder() {}

        protected AbstractBuilder(MetricAggregationBase o) {
            this.field = o.field;
            this.meta = _mapCopy(o.meta);
            this.missing = o.missing;
            this.name = o.name;
            this.script = o.script;
        }

        protected AbstractBuilder(AbstractBuilder<BuilderT> o) {
            this.field = o.field;
            this.meta = _mapCopy(o.meta);
            this.missing = o.missing;
            this.name = o.name;
            this.script = o.script;
        }

        @Nonnull
        protected abstract BuilderT self();

        /**
         * API name: {@code field}
         */
        @Nonnull
        public final BuilderT field(@Nullable String value) {
            this.field = value;
            return self();
        }

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
         * API name: {@code missing}
         */
        @Nonnull
        public final BuilderT missing(@Nullable FieldValue value) {
            this.missing = value;
            return self();
        }

        /**
         * API name: {@code missing}
         */
        @Nonnull
        public final BuilderT missing(Function<FieldValue.Builder, ObjectBuilder<FieldValue>> fn) {
            return missing(fn.apply(new FieldValue.Builder()).build());
        }

        /**
         * API name: {@code name}
         */
        @Nonnull
        public final BuilderT name(@Nullable String value) {
            this.name = value;
            return self();
        }

        /**
         * API name: {@code script}
         */
        @Nonnull
        public final BuilderT script(@Nullable Script value) {
            this.script = value;
            return self();
        }

        /**
         * API name: {@code script}
         */
        @Nonnull
        public final BuilderT script(Function<Script.Builder, ObjectBuilder<Script>> fn) {
            return script(fn.apply(new Script.Builder()).build());
        }
    }

    // ---------------------------------------------------------------------------------------------

    protected static <BuilderT extends AbstractBuilder<BuilderT>> void setupMetricAggregationBaseDeserializer(
        ObjectDeserializer<BuilderT> op
    ) {
        op.add(AbstractBuilder::field, JsonpDeserializer.stringDeserializer(), "field");
        op.add(AbstractBuilder::meta, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "meta");
        op.add(AbstractBuilder::missing, FieldValue._DESERIALIZER, "missing");
        op.add(AbstractBuilder::name, JsonpDeserializer.stringDeserializer(), "name");
        op.add(AbstractBuilder::script, Script._DESERIALIZER, "script");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.field);
        result = 31 * result + Objects.hashCode(this.meta);
        result = 31 * result + Objects.hashCode(this.missing);
        result = 31 * result + Objects.hashCode(this.name);
        result = 31 * result + Objects.hashCode(this.script);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        MetricAggregationBase other = (MetricAggregationBase) o;
        return Objects.equals(this.field, other.field)
            && Objects.equals(this.meta, other.meta)
            && Objects.equals(this.missing, other.missing)
            && Objects.equals(this.name, other.name)
            && Objects.equals(this.script, other.script);
    }
}
