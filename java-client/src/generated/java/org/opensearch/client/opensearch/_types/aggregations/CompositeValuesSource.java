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
import org.opensearch.client.opensearch._types.Script;
import org.opensearch.client.opensearch._types.SortOrder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: _types.aggregations.CompositeValuesSource

@Generated("org.opensearch.client.codegen.CodeGenerator")
public abstract class CompositeValuesSource implements PlainJsonSerializable {

    @Nullable
    private final String field;

    @Nullable
    private final Boolean missingBucket;

    @Nullable
    private final MissingOrder missingOrder;

    @Nullable
    private final SortOrder order;

    @Nullable
    private final Script script;

    @Nullable
    private final ValueType valueType;

    // ---------------------------------------------------------------------------------------------

    protected CompositeValuesSource(AbstractBuilder<?> builder) {
        this.field = builder.field;
        this.missingBucket = builder.missingBucket;
        this.missingOrder = builder.missingOrder;
        this.order = builder.order;
        this.script = builder.script;
        this.valueType = builder.valueType;
    }

    /**
     * API name: {@code field}
     */
    @Nullable
    public final String field() {
        return this.field;
    }

    /**
     * API name: {@code missing_bucket}
     */
    @Nullable
    public final Boolean missingBucket() {
        return this.missingBucket;
    }

    /**
     * API name: {@code missing_order}
     */
    @Nullable
    public final MissingOrder missingOrder() {
        return this.missingOrder;
    }

    /**
     * API name: {@code order}
     */
    @Nullable
    public final SortOrder order() {
        return this.order;
    }

    /**
     * API name: {@code script}
     */
    @Nullable
    public final Script script() {
        return this.script;
    }

    /**
     * API name: {@code value_type}
     */
    @Nullable
    public final ValueType valueType() {
        return this.valueType;
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

        if (this.missingBucket != null) {
            generator.writeKey("missing_bucket");
            generator.write(this.missingBucket);
        }

        if (this.missingOrder != null) {
            generator.writeKey("missing_order");
            this.missingOrder.serialize(generator, mapper);
        }

        if (this.order != null) {
            generator.writeKey("order");
            this.order.serialize(generator, mapper);
        }

        if (this.script != null) {
            generator.writeKey("script");
            this.script.serialize(generator, mapper);
        }

        if (this.valueType != null) {
            generator.writeKey("value_type");
            this.valueType.serialize(generator, mapper);
        }
    }

    // ---------------------------------------------------------------------------------------------

    public abstract static class AbstractBuilder<BuilderT extends AbstractBuilder<BuilderT>> extends ObjectBuilderBase {
        @Nullable
        private String field;
        @Nullable
        private Boolean missingBucket;
        @Nullable
        private MissingOrder missingOrder;
        @Nullable
        private SortOrder order;
        @Nullable
        private Script script;
        @Nullable
        private ValueType valueType;

        protected AbstractBuilder() {}

        protected AbstractBuilder(CompositeValuesSource o) {
            this.field = o.field;
            this.missingBucket = o.missingBucket;
            this.missingOrder = o.missingOrder;
            this.order = o.order;
            this.script = o.script;
            this.valueType = o.valueType;
        }

        protected AbstractBuilder(AbstractBuilder<BuilderT> o) {
            this.field = o.field;
            this.missingBucket = o.missingBucket;
            this.missingOrder = o.missingOrder;
            this.order = o.order;
            this.script = o.script;
            this.valueType = o.valueType;
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
         * API name: {@code missing_bucket}
         */
        @Nonnull
        public final BuilderT missingBucket(@Nullable Boolean value) {
            this.missingBucket = value;
            return self();
        }

        /**
         * API name: {@code missing_order}
         */
        @Nonnull
        public final BuilderT missingOrder(@Nullable MissingOrder value) {
            this.missingOrder = value;
            return self();
        }

        /**
         * API name: {@code order}
         */
        @Nonnull
        public final BuilderT order(@Nullable SortOrder value) {
            this.order = value;
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

        /**
         * API name: {@code value_type}
         */
        @Nonnull
        public final BuilderT valueType(@Nullable ValueType value) {
            this.valueType = value;
            return self();
        }
    }

    // ---------------------------------------------------------------------------------------------

    protected static <BuilderT extends AbstractBuilder<BuilderT>> void setupCompositeValuesSourceDeserializer(
        ObjectDeserializer<BuilderT> op
    ) {
        op.add(AbstractBuilder::field, JsonpDeserializer.stringDeserializer(), "field");
        op.add(AbstractBuilder::missingBucket, JsonpDeserializer.booleanDeserializer(), "missing_bucket");
        op.add(AbstractBuilder::missingOrder, MissingOrder._DESERIALIZER, "missing_order");
        op.add(AbstractBuilder::order, SortOrder._DESERIALIZER, "order");
        op.add(AbstractBuilder::script, Script._DESERIALIZER, "script");
        op.add(AbstractBuilder::valueType, ValueType._DESERIALIZER, "value_type");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.field);
        result = 31 * result + Objects.hashCode(this.missingBucket);
        result = 31 * result + Objects.hashCode(this.missingOrder);
        result = 31 * result + Objects.hashCode(this.order);
        result = 31 * result + Objects.hashCode(this.script);
        result = 31 * result + Objects.hashCode(this.valueType);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CompositeValuesSource other = (CompositeValuesSource) o;
        return Objects.equals(this.field, other.field)
            && Objects.equals(this.missingBucket, other.missingBucket)
            && Objects.equals(this.missingOrder, other.missingOrder)
            && Objects.equals(this.order, other.order)
            && Objects.equals(this.script, other.script)
            && Objects.equals(this.valueType, other.valueType);
    }
}
