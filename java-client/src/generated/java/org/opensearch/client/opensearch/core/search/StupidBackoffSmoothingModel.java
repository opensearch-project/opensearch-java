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

// typedef: core.search.StupidBackoffSmoothingModel

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class StupidBackoffSmoothingModel
    implements
        SmoothingModelVariant,
        PlainJsonSerializable,
        ToCopyableBuilder<StupidBackoffSmoothingModel.Builder, StupidBackoffSmoothingModel> {

    private final double discount;

    // ---------------------------------------------------------------------------------------------

    private StupidBackoffSmoothingModel(Builder builder) {
        this.discount = ApiTypeHelper.requireNonNull(builder.discount, this, "discount");
    }

    public static StupidBackoffSmoothingModel of(
        Function<StupidBackoffSmoothingModel.Builder, ObjectBuilder<StupidBackoffSmoothingModel>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link SmoothingModel} variant kind.
     */
    @Override
    public SmoothingModel.Kind _smoothingModelKind() {
        return SmoothingModel.Kind.StupidBackoff;
    }

    /**
     * Required - API name: {@code discount}
     */
    public final double discount() {
        return this.discount;
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
        generator.writeKey("discount");
        generator.write(this.discount);
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
     * Builder for {@link StupidBackoffSmoothingModel}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, StupidBackoffSmoothingModel> {
        private Double discount;

        public Builder() {}

        private Builder(StupidBackoffSmoothingModel o) {
            this.discount = o.discount;
        }

        private Builder(Builder o) {
            this.discount = o.discount;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code discount}
         */
        @Nonnull
        public final Builder discount(double value) {
            this.discount = value;
            return this;
        }

        /**
         * Builds a {@link StupidBackoffSmoothingModel}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public StupidBackoffSmoothingModel build() {
            _checkSingleUse();

            return new StupidBackoffSmoothingModel(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link StupidBackoffSmoothingModel}
     */
    public static final JsonpDeserializer<StupidBackoffSmoothingModel> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        StupidBackoffSmoothingModel::setupStupidBackoffSmoothingModelDeserializer
    );

    protected static void setupStupidBackoffSmoothingModelDeserializer(ObjectDeserializer<StupidBackoffSmoothingModel.Builder> op) {
        op.add(Builder::discount, JsonpDeserializer.doubleDeserializer(), "discount");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Double.hashCode(this.discount);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        StupidBackoffSmoothingModel other = (StupidBackoffSmoothingModel) o;
        return this.discount == other.discount;
    }
}
