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
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: core.search.Rescore

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Rescore implements PlainJsonSerializable, ToCopyableBuilder<Rescore.Builder, Rescore> {

    @Nonnull
    private final RescoreQuery query;

    @Nullable
    private final Integer windowSize;

    // ---------------------------------------------------------------------------------------------

    private Rescore(Builder builder) {
        this.query = ApiTypeHelper.requireNonNull(builder.query, this, "query");
        this.windowSize = builder.windowSize;
    }

    public static Rescore of(Function<Rescore.Builder, ObjectBuilder<Rescore>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code query}
     */
    @Nonnull
    public final RescoreQuery query() {
        return this.query;
    }

    /**
     * API name: {@code window_size}
     */
    @Nullable
    public final Integer windowSize() {
        return this.windowSize;
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
        generator.writeKey("query");
        this.query.serialize(generator, mapper);

        if (this.windowSize != null) {
            generator.writeKey("window_size");
            generator.write(this.windowSize);
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
     * Builder for {@link Rescore}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, Rescore> {
        private RescoreQuery query;
        @Nullable
        private Integer windowSize;

        public Builder() {}

        private Builder(Rescore o) {
            this.query = o.query;
            this.windowSize = o.windowSize;
        }

        private Builder(Builder o) {
            this.query = o.query;
            this.windowSize = o.windowSize;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code query}
         */
        @Nonnull
        public final Builder query(RescoreQuery value) {
            this.query = value;
            return this;
        }

        /**
         * Required - API name: {@code query}
         */
        @Nonnull
        public final Builder query(Function<RescoreQuery.Builder, ObjectBuilder<RescoreQuery>> fn) {
            return query(fn.apply(new RescoreQuery.Builder()).build());
        }

        /**
         * API name: {@code window_size}
         */
        @Nonnull
        public final Builder windowSize(@Nullable Integer value) {
            this.windowSize = value;
            return this;
        }

        /**
         * Builds a {@link Rescore}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public Rescore build() {
            _checkSingleUse();

            return new Rescore(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link Rescore}
     */
    public static final JsonpDeserializer<Rescore> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        Rescore::setupRescoreDeserializer
    );

    protected static void setupRescoreDeserializer(ObjectDeserializer<Rescore.Builder> op) {
        op.add(Builder::query, RescoreQuery._DESERIALIZER, "query");
        op.add(Builder::windowSize, JsonpDeserializer.integerDeserializer(), "window_size");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.query.hashCode();
        result = 31 * result + Objects.hashCode(this.windowSize);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Rescore other = (Rescore) o;
        return this.query.equals(other.query) && Objects.equals(this.windowSize, other.windowSize);
    }
}
