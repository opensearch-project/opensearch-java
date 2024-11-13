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

package org.opensearch.client.opensearch.indices;

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

// typedef: indices.IndexSettingsSimilarityBm25

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IndexSettingsSimilarityBm25
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<IndexSettingsSimilarityBm25.Builder, IndexSettingsSimilarityBm25> {

    private final float b;

    private final boolean discountOverlaps;

    private final float k1;

    @Nonnull
    private final String type;

    // ---------------------------------------------------------------------------------------------

    private IndexSettingsSimilarityBm25(Builder builder) {
        this.b = ApiTypeHelper.requireNonNull(builder.b, this, "b");
        this.discountOverlaps = ApiTypeHelper.requireNonNull(builder.discountOverlaps, this, "discountOverlaps");
        this.k1 = ApiTypeHelper.requireNonNull(builder.k1, this, "k1");
        this.type = ApiTypeHelper.requireNonNull(builder.type, this, "type");
    }

    public static IndexSettingsSimilarityBm25 of(
        Function<IndexSettingsSimilarityBm25.Builder, ObjectBuilder<IndexSettingsSimilarityBm25>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code b}
     */
    public final float b() {
        return this.b;
    }

    /**
     * Required - API name: {@code discount_overlaps}
     */
    public final boolean discountOverlaps() {
        return this.discountOverlaps;
    }

    /**
     * Required - API name: {@code k1}
     */
    public final float k1() {
        return this.k1;
    }

    /**
     * Required - API name: {@code type}
     */
    @Nonnull
    public final String type() {
        return this.type;
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
        generator.writeKey("b");
        generator.write(this.b);

        generator.writeKey("discount_overlaps");
        generator.write(this.discountOverlaps);

        generator.writeKey("k1");
        generator.write(this.k1);

        generator.writeKey("type");
        generator.write(this.type);
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
     * Builder for {@link IndexSettingsSimilarityBm25}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IndexSettingsSimilarityBm25> {
        private Float b;
        private Boolean discountOverlaps;
        private Float k1;
        private String type;

        public Builder() {}

        private Builder(IndexSettingsSimilarityBm25 o) {
            this.b = o.b;
            this.discountOverlaps = o.discountOverlaps;
            this.k1 = o.k1;
            this.type = o.type;
        }

        private Builder(Builder o) {
            this.b = o.b;
            this.discountOverlaps = o.discountOverlaps;
            this.k1 = o.k1;
            this.type = o.type;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code b}
         */
        @Nonnull
        public final Builder b(float value) {
            this.b = value;
            return this;
        }

        /**
         * Required - API name: {@code discount_overlaps}
         */
        @Nonnull
        public final Builder discountOverlaps(boolean value) {
            this.discountOverlaps = value;
            return this;
        }

        /**
         * Required - API name: {@code k1}
         */
        @Nonnull
        public final Builder k1(float value) {
            this.k1 = value;
            return this;
        }

        /**
         * Required - API name: {@code type}
         */
        @Nonnull
        public final Builder type(String value) {
            this.type = value;
            return this;
        }

        /**
         * Builds a {@link IndexSettingsSimilarityBm25}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IndexSettingsSimilarityBm25 build() {
            _checkSingleUse();

            return new IndexSettingsSimilarityBm25(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IndexSettingsSimilarityBm25}
     */
    public static final JsonpDeserializer<IndexSettingsSimilarityBm25> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IndexSettingsSimilarityBm25::setupIndexSettingsSimilarityBm25Deserializer
    );

    protected static void setupIndexSettingsSimilarityBm25Deserializer(ObjectDeserializer<IndexSettingsSimilarityBm25.Builder> op) {
        op.add(Builder::b, JsonpDeserializer.floatDeserializer(), "b");
        op.add(Builder::discountOverlaps, JsonpDeserializer.booleanDeserializer(), "discount_overlaps");
        op.add(Builder::k1, JsonpDeserializer.floatDeserializer(), "k1");
        op.add(Builder::type, JsonpDeserializer.stringDeserializer(), "type");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Float.hashCode(this.b);
        result = 31 * result + Boolean.hashCode(this.discountOverlaps);
        result = 31 * result + Float.hashCode(this.k1);
        result = 31 * result + this.type.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IndexSettingsSimilarityBm25 other = (IndexSettingsSimilarityBm25) o;
        return this.b == other.b && this.discountOverlaps == other.discountOverlaps && this.k1 == other.k1 && this.type.equals(other.type);
    }
}
