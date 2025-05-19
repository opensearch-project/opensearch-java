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

// typedef: core.search.TotalHits

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class TotalHits implements PlainJsonSerializable, ToCopyableBuilder<TotalHits.Builder, TotalHits> {

    @Nonnull
    private final TotalHitsRelation relation;

    private final long value;

    // ---------------------------------------------------------------------------------------------

    private TotalHits(Builder builder) {
        this.relation = ApiTypeHelper.requireNonNull(builder.relation, this, "relation");
        this.value = ApiTypeHelper.requireNonNull(builder.value, this, "value");
    }

    public static TotalHits of(Function<TotalHits.Builder, ObjectBuilder<TotalHits>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code relation}
     */
    @Nonnull
    public final TotalHitsRelation relation() {
        return this.relation;
    }

    /**
     * Required - API name: {@code value}
     */
    public final long value() {
        return this.value;
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
        generator.writeKey("relation");
        this.relation.serialize(generator, mapper);

        generator.writeKey("value");
        generator.write(this.value);
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
     * Builder for {@link TotalHits}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, TotalHits> {
        private TotalHitsRelation relation;
        private Long value;

        public Builder() {}

        private Builder(TotalHits o) {
            this.relation = o.relation;
            this.value = o.value;
        }

        private Builder(Builder o) {
            this.relation = o.relation;
            this.value = o.value;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code relation}
         */
        @Nonnull
        public final Builder relation(TotalHitsRelation value) {
            this.relation = value;
            return this;
        }

        /**
         * Required - API name: {@code value}
         */
        @Nonnull
        public final Builder value(long value) {
            this.value = value;
            return this;
        }

        /**
         * Builds a {@link TotalHits}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public TotalHits build() {
            _checkSingleUse();

            return new TotalHits(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link TotalHits}
     */
    public static final JsonpDeserializer<TotalHits> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        TotalHits::setupTotalHitsDeserializer
    );

    protected static void setupTotalHitsDeserializer(ObjectDeserializer<TotalHits.Builder> op) {
        op.add(Builder::relation, TotalHitsRelation._DESERIALIZER, "relation");
        op.add(Builder::value, JsonpDeserializer.longDeserializer(), "value");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.relation.hashCode();
        result = 31 * result + Long.hashCode(this.value);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        TotalHits other = (TotalHits) o;
        return this.relation.equals(other.relation) && this.value == other.value;
    }
}
