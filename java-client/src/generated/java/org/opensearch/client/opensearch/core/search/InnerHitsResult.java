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

// typedef: core.search.InnerHitsResult

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class InnerHitsResult implements PlainJsonSerializable, ToCopyableBuilder<InnerHitsResult.Builder, InnerHitsResult> {

    @Nonnull
    private final HitsMetadata<JsonData> hits;

    // ---------------------------------------------------------------------------------------------

    private InnerHitsResult(Builder builder) {
        this.hits = ApiTypeHelper.requireNonNull(builder.hits, this, "hits");
    }

    public static InnerHitsResult of(Function<InnerHitsResult.Builder, ObjectBuilder<InnerHitsResult>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code hits}
     */
    @Nonnull
    public final HitsMetadata<JsonData> hits() {
        return this.hits;
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
        generator.writeKey("hits");
        this.hits.serialize(generator, mapper);
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
     * Builder for {@link InnerHitsResult}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, InnerHitsResult> {
        private HitsMetadata<JsonData> hits;

        public Builder() {}

        private Builder(InnerHitsResult o) {
            this.hits = o.hits;
        }

        private Builder(Builder o) {
            this.hits = o.hits;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code hits}
         */
        @Nonnull
        public final Builder hits(HitsMetadata<JsonData> value) {
            this.hits = value;
            return this;
        }

        /**
         * Required - API name: {@code hits}
         */
        @Nonnull
        public final Builder hits(Function<HitsMetadata.Builder<JsonData>, ObjectBuilder<HitsMetadata<JsonData>>> fn) {
            return hits(fn.apply(new HitsMetadata.Builder<JsonData>()).build());
        }

        /**
         * Builds a {@link InnerHitsResult}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public InnerHitsResult build() {
            _checkSingleUse();

            return new InnerHitsResult(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link InnerHitsResult}
     */
    public static final JsonpDeserializer<InnerHitsResult> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        InnerHitsResult::setupInnerHitsResultDeserializer
    );

    protected static void setupInnerHitsResultDeserializer(ObjectDeserializer<InnerHitsResult.Builder> op) {
        op.add(Builder::hits, HitsMetadata.createHitsMetadataDeserializer(JsonData._DESERIALIZER), "hits");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.hits.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        InnerHitsResult other = (InnerHitsResult) o;
        return this.hits.equals(other.hits);
    }
}
