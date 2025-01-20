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
import java.util.List;
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
import org.opensearch.client.opensearch._types.FieldValue;
import org.opensearch.client.opensearch._types.Script;
import org.opensearch.client.opensearch._types.SortOrder;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.aggregations.TermsAggregation

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class TermsAggregation extends BucketAggregationBase
    implements
        AggregationVariant,
        ToCopyableBuilder<TermsAggregation.Builder, TermsAggregation> {

    @Nullable
    private final TermsAggregationCollectMode collectMode;

    @Nullable
    private final TermsExclude exclude;

    @Nullable
    private final TermsAggregationExecutionHint executionHint;

    @Nullable
    private final String field;

    @Nullable
    private final String format;

    @Nullable
    private final TermsInclude include;

    @Nullable
    private final Integer minDocCount;

    @Nullable
    private final FieldValue missing;

    @Nullable
    private final Boolean missingBucket;

    @Nullable
    private final MissingOrder missingOrder;

    @Nonnull
    private final List<Map<String, SortOrder>> order;

    @Nullable
    private final Script script;

    @Nullable
    private final Integer shardSize;

    @Nullable
    private final Boolean showTermDocCountError;

    @Nullable
    private final Integer size;

    @Nullable
    private final String valueType;

    // ---------------------------------------------------------------------------------------------

    private TermsAggregation(Builder builder) {
        super(builder);
        this.collectMode = builder.collectMode;
        this.exclude = builder.exclude;
        this.executionHint = builder.executionHint;
        this.field = builder.field;
        this.format = builder.format;
        this.include = builder.include;
        this.minDocCount = builder.minDocCount;
        this.missing = builder.missing;
        this.missingBucket = builder.missingBucket;
        this.missingOrder = builder.missingOrder;
        this.order = ApiTypeHelper.unmodifiable(builder.order);
        this.script = builder.script;
        this.shardSize = builder.shardSize;
        this.showTermDocCountError = builder.showTermDocCountError;
        this.size = builder.size;
        this.valueType = builder.valueType;
    }

    public static TermsAggregation of(Function<TermsAggregation.Builder, ObjectBuilder<TermsAggregation>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Aggregation} variant kind.
     */
    @Override
    public Aggregation.Kind _aggregationKind() {
        return Aggregation.Kind.Terms;
    }

    /**
     * API name: {@code collect_mode}
     */
    @Nullable
    public final TermsAggregationCollectMode collectMode() {
        return this.collectMode;
    }

    /**
     * API name: {@code exclude}
     */
    @Nullable
    public final TermsExclude exclude() {
        return this.exclude;
    }

    /**
     * API name: {@code execution_hint}
     */
    @Nullable
    public final TermsAggregationExecutionHint executionHint() {
        return this.executionHint;
    }

    /**
     * API name: {@code field}
     */
    @Nullable
    public final String field() {
        return this.field;
    }

    /**
     * API name: {@code format}
     */
    @Nullable
    public final String format() {
        return this.format;
    }

    /**
     * API name: {@code include}
     */
    @Nullable
    public final TermsInclude include() {
        return this.include;
    }

    /**
     * Only return values that are found in more than <code>min_doc_count</code> hits.
     * <p>
     * API name: {@code min_doc_count}
     * </p>
     */
    @Nullable
    public final Integer minDocCount() {
        return this.minDocCount;
    }

    /**
     * API name: {@code missing}
     */
    @Nullable
    public final FieldValue missing() {
        return this.missing;
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
    @Nonnull
    public final List<Map<String, SortOrder>> order() {
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
     * The number of candidate terms produced by each shard. By default, <code>shard_size</code> will be automatically estimated based on
     * the number of shards and the <code>size</code> parameter.
     * <p>
     * API name: {@code shard_size}
     * </p>
     */
    @Nullable
    public final Integer shardSize() {
        return this.shardSize;
    }

    /**
     * Set to <code>true</code> to return the <code>doc_count_error_upper_bound</code>, which is an upper bound to the error on the
     * <code>doc_count</code> returned by each shard.
     * <p>
     * API name: {@code show_term_doc_count_error}
     * </p>
     */
    @Nullable
    public final Boolean showTermDocCountError() {
        return this.showTermDocCountError;
    }

    /**
     * The number of buckets returned out of the overall terms list.
     * <p>
     * API name: {@code size}
     * </p>
     */
    @Nullable
    public final Integer size() {
        return this.size;
    }

    /**
     * Coerced unmapped fields into the specified type.
     * <p>
     * API name: {@code value_type}
     * </p>
     */
    @Nullable
    public final String valueType() {
        return this.valueType;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.collectMode != null) {
            generator.writeKey("collect_mode");
            this.collectMode.serialize(generator, mapper);
        }

        if (this.exclude != null) {
            generator.writeKey("exclude");
            this.exclude.serialize(generator, mapper);
        }

        if (this.executionHint != null) {
            generator.writeKey("execution_hint");
            this.executionHint.serialize(generator, mapper);
        }

        if (this.field != null) {
            generator.writeKey("field");
            generator.write(this.field);
        }

        if (this.format != null) {
            generator.writeKey("format");
            generator.write(this.format);
        }

        if (this.include != null) {
            generator.writeKey("include");
            this.include.serialize(generator, mapper);
        }

        if (this.minDocCount != null) {
            generator.writeKey("min_doc_count");
            generator.write(this.minDocCount);
        }

        if (this.missing != null) {
            generator.writeKey("missing");
            this.missing.serialize(generator, mapper);
        }

        if (this.missingBucket != null) {
            generator.writeKey("missing_bucket");
            generator.write(this.missingBucket);
        }

        if (this.missingOrder != null) {
            generator.writeKey("missing_order");
            this.missingOrder.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.order)) {
            generator.writeKey("order");
            generator.writeStartArray();
            for (Map<String, SortOrder> item0 : this.order) {
                generator.writeStartObject();
                if (item0 != null) {
                    for (Map.Entry<String, SortOrder> item1 : item0.entrySet()) {
                        generator.writeKey(item1.getKey());
                        item1.getValue().serialize(generator, mapper);
                    }
                }
                generator.writeEnd();
            }
            generator.writeEnd();
        }

        if (this.script != null) {
            generator.writeKey("script");
            this.script.serialize(generator, mapper);
        }

        if (this.shardSize != null) {
            generator.writeKey("shard_size");
            generator.write(this.shardSize);
        }

        if (this.showTermDocCountError != null) {
            generator.writeKey("show_term_doc_count_error");
            generator.write(this.showTermDocCountError);
        }

        if (this.size != null) {
            generator.writeKey("size");
            generator.write(this.size);
        }

        if (this.valueType != null) {
            generator.writeKey("value_type");
            generator.write(this.valueType);
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
     * Builder for {@link TermsAggregation}.
     */
    public static class Builder extends BucketAggregationBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, TermsAggregation> {
        @Nullable
        private TermsAggregationCollectMode collectMode;
        @Nullable
        private TermsExclude exclude;
        @Nullable
        private TermsAggregationExecutionHint executionHint;
        @Nullable
        private String field;
        @Nullable
        private String format;
        @Nullable
        private TermsInclude include;
        @Nullable
        private Integer minDocCount;
        @Nullable
        private FieldValue missing;
        @Nullable
        private Boolean missingBucket;
        @Nullable
        private MissingOrder missingOrder;
        @Nullable
        private List<Map<String, SortOrder>> order;
        @Nullable
        private Script script;
        @Nullable
        private Integer shardSize;
        @Nullable
        private Boolean showTermDocCountError;
        @Nullable
        private Integer size;
        @Nullable
        private String valueType;

        public Builder() {}

        private Builder(TermsAggregation o) {
            super(o);
            this.collectMode = o.collectMode;
            this.exclude = o.exclude;
            this.executionHint = o.executionHint;
            this.field = o.field;
            this.format = o.format;
            this.include = o.include;
            this.minDocCount = o.minDocCount;
            this.missing = o.missing;
            this.missingBucket = o.missingBucket;
            this.missingOrder = o.missingOrder;
            this.order = _listCopy(o.order);
            this.script = o.script;
            this.shardSize = o.shardSize;
            this.showTermDocCountError = o.showTermDocCountError;
            this.size = o.size;
            this.valueType = o.valueType;
        }

        private Builder(Builder o) {
            super(o);
            this.collectMode = o.collectMode;
            this.exclude = o.exclude;
            this.executionHint = o.executionHint;
            this.field = o.field;
            this.format = o.format;
            this.include = o.include;
            this.minDocCount = o.minDocCount;
            this.missing = o.missing;
            this.missingBucket = o.missingBucket;
            this.missingOrder = o.missingOrder;
            this.order = _listCopy(o.order);
            this.script = o.script;
            this.shardSize = o.shardSize;
            this.showTermDocCountError = o.showTermDocCountError;
            this.size = o.size;
            this.valueType = o.valueType;
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
         * API name: {@code collect_mode}
         */
        @Nonnull
        public final Builder collectMode(@Nullable TermsAggregationCollectMode value) {
            this.collectMode = value;
            return this;
        }

        /**
         * API name: {@code exclude}
         */
        @Nonnull
        public final Builder exclude(@Nullable TermsExclude value) {
            this.exclude = value;
            return this;
        }

        /**
         * API name: {@code exclude}
         */
        @Nonnull
        public final Builder exclude(Function<TermsExclude.Builder, ObjectBuilder<TermsExclude>> fn) {
            return exclude(fn.apply(new TermsExclude.Builder()).build());
        }

        /**
         * API name: {@code execution_hint}
         */
        @Nonnull
        public final Builder executionHint(@Nullable TermsAggregationExecutionHint value) {
            this.executionHint = value;
            return this;
        }

        /**
         * API name: {@code field}
         */
        @Nonnull
        public final Builder field(@Nullable String value) {
            this.field = value;
            return this;
        }

        /**
         * API name: {@code format}
         */
        @Nonnull
        public final Builder format(@Nullable String value) {
            this.format = value;
            return this;
        }

        /**
         * API name: {@code include}
         */
        @Nonnull
        public final Builder include(@Nullable TermsInclude value) {
            this.include = value;
            return this;
        }

        /**
         * API name: {@code include}
         */
        @Nonnull
        public final Builder include(Function<TermsInclude.Builder, ObjectBuilder<TermsInclude>> fn) {
            return include(fn.apply(new TermsInclude.Builder()).build());
        }

        /**
         * Only return values that are found in more than <code>min_doc_count</code> hits.
         * <p>
         * API name: {@code min_doc_count}
         * </p>
         */
        @Nonnull
        public final Builder minDocCount(@Nullable Integer value) {
            this.minDocCount = value;
            return this;
        }

        /**
         * API name: {@code missing}
         */
        @Nonnull
        public final Builder missing(@Nullable FieldValue value) {
            this.missing = value;
            return this;
        }

        /**
         * API name: {@code missing}
         */
        @Nonnull
        public final Builder missing(Function<FieldValue.Builder, ObjectBuilder<FieldValue>> fn) {
            return missing(fn.apply(new FieldValue.Builder()).build());
        }

        /**
         * API name: {@code missing_bucket}
         */
        @Nonnull
        public final Builder missingBucket(@Nullable Boolean value) {
            this.missingBucket = value;
            return this;
        }

        /**
         * API name: {@code missing_order}
         */
        @Nonnull
        public final Builder missingOrder(@Nullable MissingOrder value) {
            this.missingOrder = value;
            return this;
        }

        /**
         * API name: {@code order}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>order</code>.
         * </p>
         */
        @Nonnull
        public final Builder order(List<Map<String, SortOrder>> list) {
            this.order = _listAddAll(this.order, list);
            return this;
        }

        /**
         * API name: {@code order}
         *
         * <p>
         * Adds one or more values to <code>order</code>.
         * </p>
         */
        @Nonnull
        public final Builder order(Map<String, SortOrder> value, Map<String, SortOrder>... values) {
            this.order = _listAdd(this.order, value, values);
            return this;
        }

        /**
         * API name: {@code script}
         */
        @Nonnull
        public final Builder script(@Nullable Script value) {
            this.script = value;
            return this;
        }

        /**
         * API name: {@code script}
         */
        @Nonnull
        public final Builder script(Function<Script.Builder, ObjectBuilder<Script>> fn) {
            return script(fn.apply(new Script.Builder()).build());
        }

        /**
         * The number of candidate terms produced by each shard. By default, <code>shard_size</code> will be automatically estimated based
         * on the number of shards and the <code>size</code> parameter.
         * <p>
         * API name: {@code shard_size}
         * </p>
         */
        @Nonnull
        public final Builder shardSize(@Nullable Integer value) {
            this.shardSize = value;
            return this;
        }

        /**
         * Set to <code>true</code> to return the <code>doc_count_error_upper_bound</code>, which is an upper bound to the error on the
         * <code>doc_count</code> returned by each shard.
         * <p>
         * API name: {@code show_term_doc_count_error}
         * </p>
         */
        @Nonnull
        public final Builder showTermDocCountError(@Nullable Boolean value) {
            this.showTermDocCountError = value;
            return this;
        }

        /**
         * The number of buckets returned out of the overall terms list.
         * <p>
         * API name: {@code size}
         * </p>
         */
        @Nonnull
        public final Builder size(@Nullable Integer value) {
            this.size = value;
            return this;
        }

        /**
         * Coerced unmapped fields into the specified type.
         * <p>
         * API name: {@code value_type}
         * </p>
         */
        @Nonnull
        public final Builder valueType(@Nullable String value) {
            this.valueType = value;
            return this;
        }

        /**
         * Builds a {@link TermsAggregation}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public TermsAggregation build() {
            _checkSingleUse();

            return new TermsAggregation(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link TermsAggregation}
     */
    public static final JsonpDeserializer<TermsAggregation> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        TermsAggregation::setupTermsAggregationDeserializer
    );

    protected static void setupTermsAggregationDeserializer(ObjectDeserializer<TermsAggregation.Builder> op) {
        setupBucketAggregationBaseDeserializer(op);
        op.add(Builder::collectMode, TermsAggregationCollectMode._DESERIALIZER, "collect_mode");
        op.add(Builder::exclude, TermsExclude._DESERIALIZER, "exclude");
        op.add(Builder::executionHint, TermsAggregationExecutionHint._DESERIALIZER, "execution_hint");
        op.add(Builder::field, JsonpDeserializer.stringDeserializer(), "field");
        op.add(Builder::format, JsonpDeserializer.stringDeserializer(), "format");
        op.add(Builder::include, TermsInclude._DESERIALIZER, "include");
        op.add(Builder::minDocCount, JsonpDeserializer.integerDeserializer(), "min_doc_count");
        op.add(Builder::missing, FieldValue._DESERIALIZER, "missing");
        op.add(Builder::missingBucket, JsonpDeserializer.booleanDeserializer(), "missing_bucket");
        op.add(Builder::missingOrder, MissingOrder._DESERIALIZER, "missing_order");
        op.add(
            Builder::order,
            JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringMapDeserializer(SortOrder._DESERIALIZER)),
            "order"
        );
        op.add(Builder::script, Script._DESERIALIZER, "script");
        op.add(Builder::shardSize, JsonpDeserializer.integerDeserializer(), "shard_size");
        op.add(Builder::showTermDocCountError, JsonpDeserializer.booleanDeserializer(), "show_term_doc_count_error");
        op.add(Builder::size, JsonpDeserializer.integerDeserializer(), "size");
        op.add(Builder::valueType, JsonpDeserializer.stringDeserializer(), "value_type");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.collectMode);
        result = 31 * result + Objects.hashCode(this.exclude);
        result = 31 * result + Objects.hashCode(this.executionHint);
        result = 31 * result + Objects.hashCode(this.field);
        result = 31 * result + Objects.hashCode(this.format);
        result = 31 * result + Objects.hashCode(this.include);
        result = 31 * result + Objects.hashCode(this.minDocCount);
        result = 31 * result + Objects.hashCode(this.missing);
        result = 31 * result + Objects.hashCode(this.missingBucket);
        result = 31 * result + Objects.hashCode(this.missingOrder);
        result = 31 * result + Objects.hashCode(this.order);
        result = 31 * result + Objects.hashCode(this.script);
        result = 31 * result + Objects.hashCode(this.shardSize);
        result = 31 * result + Objects.hashCode(this.showTermDocCountError);
        result = 31 * result + Objects.hashCode(this.size);
        result = 31 * result + Objects.hashCode(this.valueType);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        TermsAggregation other = (TermsAggregation) o;
        return Objects.equals(this.collectMode, other.collectMode)
            && Objects.equals(this.exclude, other.exclude)
            && Objects.equals(this.executionHint, other.executionHint)
            && Objects.equals(this.field, other.field)
            && Objects.equals(this.format, other.format)
            && Objects.equals(this.include, other.include)
            && Objects.equals(this.minDocCount, other.minDocCount)
            && Objects.equals(this.missing, other.missing)
            && Objects.equals(this.missingBucket, other.missingBucket)
            && Objects.equals(this.missingOrder, other.missingOrder)
            && Objects.equals(this.order, other.order)
            && Objects.equals(this.script, other.script)
            && Objects.equals(this.shardSize, other.shardSize)
            && Objects.equals(this.showTermDocCountError, other.showTermDocCountError)
            && Objects.equals(this.size, other.size)
            && Objects.equals(this.valueType, other.valueType);
    }
}
