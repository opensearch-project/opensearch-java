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
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.opensearch._types.FieldValue;
import org.opensearch.client.opensearch._types.Script;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: _types.aggregations.MetricAggregationBase

@Generated("org.opensearch.client.codegen.CodeGenerator")
public abstract class MetricAggregationBase implements PlainJsonSerializable {

    @Nullable
    private final String field;

    @Nullable
    private final FieldValue missing;

    @Nullable
    private final Script script;

    // ---------------------------------------------------------------------------------------------

    protected MetricAggregationBase(AbstractBuilder<?> builder) {
        this.field = builder.field;
        this.missing = builder.missing;
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
     * API name: {@code missing}
     */
    @Nullable
    public final FieldValue missing() {
        return this.missing;
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

        if (this.missing != null) {
            generator.writeKey("missing");
            this.missing.serialize(generator, mapper);
        }

        if (this.script != null) {
            generator.writeKey("script");
            this.script.serialize(generator, mapper);
        }
    }

    // ---------------------------------------------------------------------------------------------

    protected abstract static class AbstractBuilder<BuilderT extends AbstractBuilder<BuilderT>> extends ObjectBuilderBase {
        @Nullable
        private String field;
        @Nullable
        private FieldValue missing;
        @Nullable
        private Script script;

        protected AbstractBuilder() {}

        protected AbstractBuilder(MetricAggregationBase o) {
            this.field = o.field;
            this.missing = o.missing;
            this.script = o.script;
        }

        protected AbstractBuilder(AbstractBuilder<BuilderT> o) {
            this.field = o.field;
            this.missing = o.missing;
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
        op.add(AbstractBuilder::missing, FieldValue._DESERIALIZER, "missing");
        op.add(AbstractBuilder::script, Script._DESERIALIZER, "script");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.field);
        result = 31 * result + Objects.hashCode(this.missing);
        result = 31 * result + Objects.hashCode(this.script);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        MetricAggregationBase other = (MetricAggregationBase) o;
        return Objects.equals(this.field, other.field)
            && Objects.equals(this.missing, other.missing)
            && Objects.equals(this.script, other.script);
    }
}
