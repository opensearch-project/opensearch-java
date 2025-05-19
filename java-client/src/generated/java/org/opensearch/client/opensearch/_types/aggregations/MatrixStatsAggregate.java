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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.aggregations.MatrixStatsAggregate

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class MatrixStatsAggregate extends AggregateBase
    implements
        AggregateVariant,
        ToCopyableBuilder<MatrixStatsAggregate.Builder, MatrixStatsAggregate> {

    private final long docCount;

    @Nonnull
    private final List<MatrixStatsFields> fields;

    // ---------------------------------------------------------------------------------------------

    private MatrixStatsAggregate(Builder builder) {
        super(builder);
        this.docCount = ApiTypeHelper.requireNonNull(builder.docCount, this, "docCount");
        this.fields = ApiTypeHelper.unmodifiable(builder.fields);
    }

    public static MatrixStatsAggregate of(Function<MatrixStatsAggregate.Builder, ObjectBuilder<MatrixStatsAggregate>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Aggregate} variant kind.
     */
    @Override
    public Aggregate.Kind _aggregateKind() {
        return Aggregate.Kind.MatrixStats;
    }

    /**
     * Required - API name: {@code doc_count}
     */
    public final long docCount() {
        return this.docCount;
    }

    /**
     * API name: {@code fields}
     */
    @Nonnull
    public final List<MatrixStatsFields> fields() {
        return this.fields;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        generator.writeKey("doc_count");
        generator.write(this.docCount);

        if (ApiTypeHelper.isDefined(this.fields)) {
            generator.writeKey("fields");
            generator.writeStartArray();
            for (MatrixStatsFields item0 : this.fields) {
                item0.serialize(generator, mapper);
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
     * Builder for {@link MatrixStatsAggregate}.
     */
    public static class Builder extends AggregateBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, MatrixStatsAggregate> {
        private Long docCount;
        @Nullable
        private List<MatrixStatsFields> fields;

        public Builder() {}

        private Builder(MatrixStatsAggregate o) {
            super(o);
            this.docCount = o.docCount;
            this.fields = _listCopy(o.fields);
        }

        private Builder(Builder o) {
            super(o);
            this.docCount = o.docCount;
            this.fields = _listCopy(o.fields);
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
         * Required - API name: {@code doc_count}
         */
        @Nonnull
        public final Builder docCount(long value) {
            this.docCount = value;
            return this;
        }

        /**
         * API name: {@code fields}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>fields</code>.
         * </p>
         */
        @Nonnull
        public final Builder fields(List<MatrixStatsFields> list) {
            this.fields = _listAddAll(this.fields, list);
            return this;
        }

        /**
         * API name: {@code fields}
         *
         * <p>
         * Adds one or more values to <code>fields</code>.
         * </p>
         */
        @Nonnull
        public final Builder fields(MatrixStatsFields value, MatrixStatsFields... values) {
            this.fields = _listAdd(this.fields, value, values);
            return this;
        }

        /**
         * API name: {@code fields}
         *
         * <p>
         * Adds a value to <code>fields</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder fields(Function<MatrixStatsFields.Builder, ObjectBuilder<MatrixStatsFields>> fn) {
            return fields(fn.apply(new MatrixStatsFields.Builder()).build());
        }

        /**
         * Builds a {@link MatrixStatsAggregate}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public MatrixStatsAggregate build() {
            _checkSingleUse();

            return new MatrixStatsAggregate(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link MatrixStatsAggregate}
     */
    public static final JsonpDeserializer<MatrixStatsAggregate> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        MatrixStatsAggregate::setupMatrixStatsAggregateDeserializer
    );

    protected static void setupMatrixStatsAggregateDeserializer(ObjectDeserializer<MatrixStatsAggregate.Builder> op) {
        setupAggregateBaseDeserializer(op);
        op.add(Builder::docCount, JsonpDeserializer.longDeserializer(), "doc_count");
        op.add(Builder::fields, JsonpDeserializer.arrayDeserializer(MatrixStatsFields._DESERIALIZER), "fields");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Long.hashCode(this.docCount);
        result = 31 * result + Objects.hashCode(this.fields);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        MatrixStatsAggregate other = (MatrixStatsAggregate) o;
        return this.docCount == other.docCount && Objects.equals(this.fields, other.fields);
    }
}
