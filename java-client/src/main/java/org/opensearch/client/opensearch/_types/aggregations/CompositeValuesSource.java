/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch._types.aggregations;

import jakarta.json.stream.JsonGenerator;
import java.util.function.Function;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.JsonpSerializable;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.opensearch._types.Script;
import org.opensearch.client.opensearch._types.SortOrder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

public abstract class CompositeValuesSource implements JsonpSerializable {

    @Nullable
    private final String field;

    @Nullable
    private final Script script;

    @Nullable
    private final ValueType valueType;

    @Nullable
    private Boolean missingBucket;

    @Nullable
    private MissingOrder missingOrder;

    @Nullable
    private SortOrder order;

    @Nullable
    private String format;

    protected CompositeValuesSource(AbstractBuilder<?> builder) {
        this.field = builder.field;
        this.script = builder.script;
        this.valueType = builder.valueType;
        this.missingBucket = builder.missingBucket;
        this.missingOrder = builder.missingOrder;
        this.order = builder.order;
        this.format = builder.format;
    }

    /**
     * API name: {@code field}
     */
    @Nullable
    public final String field() {
        return this.field;
    }

    /**
     * API name: {@code script}
     */
    @Nullable
    public final Script script() {
        return this.script;
    }

    /**
     * API name: {@code date_histogram}
     */
    @Nullable
    public final ValueType valueType() {
        return this.valueType;
    }

    /**
     * API name: {@code missingBucket}
     */
    @Nullable
    public final Boolean missingBucket() {
        return this.missingBucket;
    }

    /**
     * API name: {@code missingOrder}
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
     * API name: {@code format}
     */
    @Nullable
    public final String format() {
        return this.format;
    }

    /**
     * Serialize this object to JSON.
     */
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

        if (this.script != null) {
            generator.writeKey("script");
            this.script.serialize(generator, mapper);

        }
        if (this.valueType != null) {
            generator.writeKey("value_type");
            this.valueType.serialize(generator, mapper);

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
        if (this.format != null) {
            generator.writeKey("format");
            generator.write(this.format);
        }
    }

    /**
     * Builder for {@link CompositeValuesSource}.
     */

    protected abstract static class AbstractBuilder<BuilderT extends AbstractBuilder<BuilderT>> extends ObjectBuilderBase {

        @Nullable
        private String field;

        @Nullable
        private Script script;

        @Nullable
        private ValueType valueType;

        @Nullable
        private Boolean missingBucket;

        @Nullable
        private MissingOrder missingOrder;

        @Nullable
        private SortOrder order;

        @Nullable
        private String format;

        /**
         * API name: {@code field}
         */
        public final BuilderT field(@Nullable String field) {
            this.field = field;
            return self();
        }

        /**
         * API name: {@code script}
         */
        public final BuilderT script(@Nullable Script script) {
            this.script = script;
            return self();
        }

        /**
         * API name: {@code script}
         */
        public final BuilderT script(Function<Script.Builder, ObjectBuilder<Script>> fn) {
            return this.script(fn.apply(new Script.Builder()).build());
        }

        /**
         * API name: {@code valueType}
         */
        public final BuilderT valueType(@Nullable ValueType valueType) {
            this.valueType = valueType;
            return self();
        }

        /**
         * API name: {@code missingBucket}
         */
        public final BuilderT missingBucket(@Nullable Boolean missingBucket) {
            this.missingBucket = missingBucket;
            return self();
        }

        /**
         * API name: {@code missingOrder}
         */
        public final BuilderT missingOrder(@Nullable MissingOrder missingOrder) {
            this.missingOrder = missingOrder;
            return self();
        }

        /**
         * API name: {@code order}
         */
        public final BuilderT order(@Nullable SortOrder order) {
            this.order = order;
            return self();
        }

        /**
         * API name: {@code format}
         */
        public final BuilderT format(@Nullable String format) {
            this.format = format;
            return self();
        }

        protected abstract BuilderT self();
    }

    protected static <BuilderT extends AbstractBuilder<BuilderT>> void setupCompositeValuesSourceDeserializer(
        ObjectDeserializer<BuilderT> op
    ) {
        op.add(AbstractBuilder::field, JsonpDeserializer.stringDeserializer(), "field");
        op.add(AbstractBuilder::script, Script._DESERIALIZER, "script");
        op.add(AbstractBuilder::valueType, ValueType._DESERIALIZER, "value_type");
        op.add(AbstractBuilder::missingBucket, JsonpDeserializer.booleanDeserializer(), "missing_bucket");
        op.add(AbstractBuilder::missingOrder, MissingOrder._DESERIALIZER, "missing_order");
        op.add(AbstractBuilder::order, SortOrder._DESERIALIZER, "order");
        op.add(AbstractBuilder::format, JsonpDeserializer.stringDeserializer(), "format");
    }

}
