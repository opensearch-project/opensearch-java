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

package org.opensearch.client.opensearch.core.termvectors;

import jakarta.json.stream.JsonGenerator;
import java.util.Map;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
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

// typedef: core.termvectors.TermVector

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class TermVector implements PlainJsonSerializable, ToCopyableBuilder<TermVector.Builder, TermVector> {

    @Nonnull
    private final FieldStatistics fieldStatistics;

    @Nonnull
    private final Map<String, Term> terms;

    // ---------------------------------------------------------------------------------------------

    private TermVector(Builder builder) {
        this.fieldStatistics = ApiTypeHelper.requireNonNull(builder.fieldStatistics, this, "fieldStatistics");
        this.terms = ApiTypeHelper.unmodifiableRequired(builder.terms, this, "terms");
    }

    public static TermVector of(Function<TermVector.Builder, ObjectBuilder<TermVector>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code field_statistics}
     */
    @Nonnull
    public final FieldStatistics fieldStatistics() {
        return this.fieldStatistics;
    }

    /**
     * Required - API name: {@code terms}
     */
    @Nonnull
    public final Map<String, Term> terms() {
        return this.terms;
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
        generator.writeKey("field_statistics");
        this.fieldStatistics.serialize(generator, mapper);

        generator.writeKey("terms");
        generator.writeStartObject();
        for (Map.Entry<String, Term> item0 : this.terms.entrySet()) {
            generator.writeKey(item0.getKey());
            item0.getValue().serialize(generator, mapper);
        }
        generator.writeEnd();
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
     * Builder for {@link TermVector}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, TermVector> {
        private FieldStatistics fieldStatistics;
        private Map<String, Term> terms;

        public Builder() {}

        private Builder(TermVector o) {
            this.fieldStatistics = o.fieldStatistics;
            this.terms = _mapCopy(o.terms);
        }

        private Builder(Builder o) {
            this.fieldStatistics = o.fieldStatistics;
            this.terms = _mapCopy(o.terms);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code field_statistics}
         */
        @Nonnull
        public final Builder fieldStatistics(FieldStatistics value) {
            this.fieldStatistics = value;
            return this;
        }

        /**
         * Required - API name: {@code field_statistics}
         */
        @Nonnull
        public final Builder fieldStatistics(Function<FieldStatistics.Builder, ObjectBuilder<FieldStatistics>> fn) {
            return fieldStatistics(fn.apply(new FieldStatistics.Builder()).build());
        }

        /**
         * Required - API name: {@code terms}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>terms</code>.
         * </p>
         */
        @Nonnull
        public final Builder terms(Map<String, Term> map) {
            this.terms = _mapPutAll(this.terms, map);
            return this;
        }

        /**
         * Required - API name: {@code terms}
         *
         * <p>
         * Adds an entry to <code>terms</code>.
         * </p>
         */
        @Nonnull
        public final Builder terms(String key, Term value) {
            this.terms = _mapPut(this.terms, key, value);
            return this;
        }

        /**
         * Required - API name: {@code terms}
         *
         * <p>
         * Adds a value to <code>terms</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder terms(String key, Function<Term.Builder, ObjectBuilder<Term>> fn) {
            return terms(key, fn.apply(new Term.Builder()).build());
        }

        /**
         * Builds a {@link TermVector}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public TermVector build() {
            _checkSingleUse();

            return new TermVector(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link TermVector}
     */
    public static final JsonpDeserializer<TermVector> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        TermVector::setupTermVectorDeserializer
    );

    protected static void setupTermVectorDeserializer(ObjectDeserializer<TermVector.Builder> op) {
        op.add(Builder::fieldStatistics, FieldStatistics._DESERIALIZER, "field_statistics");
        op.add(Builder::terms, JsonpDeserializer.stringMapDeserializer(Term._DESERIALIZER), "terms");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.fieldStatistics.hashCode();
        result = 31 * result + this.terms.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        TermVector other = (TermVector) o;
        return this.fieldStatistics.equals(other.fieldStatistics) && this.terms.equals(other.terms);
    }
}
