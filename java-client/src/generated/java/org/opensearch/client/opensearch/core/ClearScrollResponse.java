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

package org.opensearch.client.opensearch.core;

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

// typedef: clear_scroll.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ClearScrollResponse implements PlainJsonSerializable, ToCopyableBuilder<ClearScrollResponse.Builder, ClearScrollResponse> {

    private final int numFreed;

    private final boolean succeeded;

    // ---------------------------------------------------------------------------------------------

    private ClearScrollResponse(Builder builder) {
        this.numFreed = ApiTypeHelper.requireNonNull(builder.numFreed, this, "numFreed");
        this.succeeded = ApiTypeHelper.requireNonNull(builder.succeeded, this, "succeeded");
    }

    public static ClearScrollResponse of(Function<ClearScrollResponse.Builder, ObjectBuilder<ClearScrollResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code num_freed}
     */
    public final int numFreed() {
        return this.numFreed;
    }

    /**
     * Required - API name: {@code succeeded}
     */
    public final boolean succeeded() {
        return this.succeeded;
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
        generator.writeKey("num_freed");
        generator.write(this.numFreed);

        generator.writeKey("succeeded");
        generator.write(this.succeeded);
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
     * Builder for {@link ClearScrollResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ClearScrollResponse> {
        private Integer numFreed;
        private Boolean succeeded;

        public Builder() {}

        private Builder(ClearScrollResponse o) {
            this.numFreed = o.numFreed;
            this.succeeded = o.succeeded;
        }

        private Builder(Builder o) {
            this.numFreed = o.numFreed;
            this.succeeded = o.succeeded;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code num_freed}
         */
        @Nonnull
        public final Builder numFreed(int value) {
            this.numFreed = value;
            return this;
        }

        /**
         * Required - API name: {@code succeeded}
         */
        @Nonnull
        public final Builder succeeded(boolean value) {
            this.succeeded = value;
            return this;
        }

        /**
         * Builds a {@link ClearScrollResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ClearScrollResponse build() {
            _checkSingleUse();

            return new ClearScrollResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ClearScrollResponse}
     */
    public static final JsonpDeserializer<ClearScrollResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ClearScrollResponse::setupClearScrollResponseDeserializer
    );

    protected static void setupClearScrollResponseDeserializer(ObjectDeserializer<ClearScrollResponse.Builder> op) {
        op.add(Builder::numFreed, JsonpDeserializer.integerDeserializer(), "num_freed");
        op.add(Builder::succeeded, JsonpDeserializer.booleanDeserializer(), "succeeded");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Integer.hashCode(this.numFreed);
        result = 31 * result + Boolean.hashCode(this.succeeded);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ClearScrollResponse other = (ClearScrollResponse) o;
        return this.numFreed == other.numFreed && this.succeeded == other.succeeded;
    }
}
