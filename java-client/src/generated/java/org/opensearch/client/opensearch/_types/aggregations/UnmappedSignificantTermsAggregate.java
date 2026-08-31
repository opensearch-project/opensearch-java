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

// typedef: _types.aggregations.UnmappedSignificantTermsAggregate

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class UnmappedSignificantTermsAggregate
    implements
        AggregateVariant,
        PlainJsonSerializable,
        ToCopyableBuilder<UnmappedSignificantTermsAggregate.Builder, UnmappedSignificantTermsAggregate> {

    @Nullable
    private final Long bgCount;

    @Nonnull
    private final Buckets<Void> buckets;

    @Nullable
    private final Long docCount;

    @Nonnull
    private final Map<String, JsonData> meta;

    // ---------------------------------------------------------------------------------------------

    private UnmappedSignificantTermsAggregate(Builder builder) {
        this.bgCount = builder.bgCount;
        this.buckets = ApiTypeHelper.requireNonNull(builder.buckets, this, "buckets");
        this.docCount = builder.docCount;
        this.meta = ApiTypeHelper.unmodifiable(builder.meta);
    }

    public static UnmappedSignificantTermsAggregate of(
        Function<UnmappedSignificantTermsAggregate.Builder, ObjectBuilder<UnmappedSignificantTermsAggregate>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Aggregate} variant kind.
     */
    @Override
    public Aggregate.Kind _aggregateKind() {
        return Aggregate.Kind.Umsigterms;
    }

    /**
     * API name: {@code bg_count}
     */
    @Nullable
    public final Long bgCount() {
        return this.bgCount;
    }

    /**
     * Required - API name: {@code buckets}
     */
    @Nonnull
    public final Buckets<Void> buckets() {
        return this.buckets;
    }

    /**
     * API name: {@code doc_count}
     */
    @Nullable
    public final Long docCount() {
        return this.docCount;
    }

    /**
     * API name: {@code meta}
     */
    @Nonnull
    public final Map<String, JsonData> meta() {
        return this.meta;
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
        if (this.bgCount != null) {
            generator.writeKey("bg_count");
            generator.write(this.bgCount);
        }

        generator.writeKey("buckets");
        this.buckets.serialize(generator, mapper);

        if (this.docCount != null) {
            generator.writeKey("doc_count");
            generator.write(this.docCount);
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
     * Builder for {@link UnmappedSignificantTermsAggregate}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, UnmappedSignificantTermsAggregate> {
        @Nullable
        private Long bgCount;
        private Buckets<Void> buckets;
        @Nullable
        private Long docCount;
        @Nullable
        private Map<String, JsonData> meta;

        public Builder() {}

        private Builder(UnmappedSignificantTermsAggregate o) {
            this.bgCount = o.bgCount;
            this.buckets = o.buckets;
            this.docCount = o.docCount;
            this.meta = _mapCopy(o.meta);
        }

        private Builder(Builder o) {
            this.bgCount = o.bgCount;
            this.buckets = o.buckets;
            this.docCount = o.docCount;
            this.meta = _mapCopy(o.meta);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code bg_count}
         */
        @Nonnull
        public final Builder bgCount(@Nullable Long value) {
            this.bgCount = value;
            return this;
        }

        /**
         * Required - API name: {@code buckets}
         */
        @Nonnull
        public final Builder buckets(Buckets<Void> value) {
            this.buckets = value;
            return this;
        }

        /**
         * Required - API name: {@code buckets}
         */
        @Nonnull
        public final Builder buckets(Function<Buckets.Builder<Void>, ObjectBuilder<Buckets<Void>>> fn) {
            return buckets(fn.apply(new Buckets.Builder<Void>()).build());
        }

        /**
         * API name: {@code doc_count}
         */
        @Nonnull
        public final Builder docCount(@Nullable Long value) {
            this.docCount = value;
            return this;
        }

        /**
         * API name: {@code meta}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>meta</code>.
         * </p>
         */
        @Nonnull
        public final Builder meta(Map<String, JsonData> map) {
            this.meta = _mapPutAll(this.meta, map);
            return this;
        }

        /**
         * API name: {@code meta}
         *
         * <p>
         * Adds an entry to <code>meta</code>.
         * </p>
         */
        @Nonnull
        public final Builder meta(String key, JsonData value) {
            this.meta = _mapPut(this.meta, key, value);
            return this;
        }

        /**
         * Builds a {@link UnmappedSignificantTermsAggregate}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public UnmappedSignificantTermsAggregate build() {
            _checkSingleUse();

            return new UnmappedSignificantTermsAggregate(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link UnmappedSignificantTermsAggregate}
     */
    public static final JsonpDeserializer<UnmappedSignificantTermsAggregate> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        UnmappedSignificantTermsAggregate::setupUnmappedSignificantTermsAggregateDeserializer
    );

    protected static void setupUnmappedSignificantTermsAggregateDeserializer(
        ObjectDeserializer<UnmappedSignificantTermsAggregate.Builder> op
    ) {
        op.add(Builder::bgCount, JsonpDeserializer.longDeserializer(), "bg_count");
        op.add(Builder::buckets, Buckets.createBucketsDeserializer(JsonpDeserializer.voidDeserializer()), "buckets");
        op.add(Builder::docCount, JsonpDeserializer.longDeserializer(), "doc_count");
        op.add(Builder::meta, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "meta");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.bgCount);
        result = 31 * result + this.buckets.hashCode();
        result = 31 * result + Objects.hashCode(this.docCount);
        result = 31 * result + Objects.hashCode(this.meta);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        UnmappedSignificantTermsAggregate other = (UnmappedSignificantTermsAggregate) o;
        return Objects.equals(this.bgCount, other.bgCount)
            && this.buckets.equals(other.buckets)
            && Objects.equals(this.docCount, other.docCount)
            && Objects.equals(this.meta, other.meta);
    }
}
