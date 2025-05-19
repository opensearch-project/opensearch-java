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

package org.opensearch.client.opensearch._types;

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

// typedef: _types.Retries

/**
 * The retry statistics for bulk and search operations.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Retries implements PlainJsonSerializable, ToCopyableBuilder<Retries.Builder, Retries> {

    private final long bulk;

    private final long search;

    // ---------------------------------------------------------------------------------------------

    private Retries(Builder builder) {
        this.bulk = ApiTypeHelper.requireNonNull(builder.bulk, this, "bulk");
        this.search = ApiTypeHelper.requireNonNull(builder.search, this, "search");
    }

    public static Retries of(Function<Retries.Builder, ObjectBuilder<Retries>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The number of bulk operation retries.
     * <p>
     * API name: {@code bulk}
     * </p>
     */
    public final long bulk() {
        return this.bulk;
    }

    /**
     * Required - The number of search operation retries.
     * <p>
     * API name: {@code search}
     * </p>
     */
    public final long search() {
        return this.search;
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
        generator.writeKey("bulk");
        generator.write(this.bulk);

        generator.writeKey("search");
        generator.write(this.search);
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
     * Builder for {@link Retries}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, Retries> {
        private Long bulk;
        private Long search;

        public Builder() {}

        private Builder(Retries o) {
            this.bulk = o.bulk;
            this.search = o.search;
        }

        private Builder(Builder o) {
            this.bulk = o.bulk;
            this.search = o.search;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - The number of bulk operation retries.
         * <p>
         * API name: {@code bulk}
         * </p>
         */
        @Nonnull
        public final Builder bulk(long value) {
            this.bulk = value;
            return this;
        }

        /**
         * Required - The number of search operation retries.
         * <p>
         * API name: {@code search}
         * </p>
         */
        @Nonnull
        public final Builder search(long value) {
            this.search = value;
            return this;
        }

        /**
         * Builds a {@link Retries}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public Retries build() {
            _checkSingleUse();

            return new Retries(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link Retries}
     */
    public static final JsonpDeserializer<Retries> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        Retries::setupRetriesDeserializer
    );

    protected static void setupRetriesDeserializer(ObjectDeserializer<Retries.Builder> op) {
        op.add(Builder::bulk, JsonpDeserializer.longDeserializer(), "bulk");
        op.add(Builder::search, JsonpDeserializer.longDeserializer(), "search");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Long.hashCode(this.bulk);
        result = 31 * result + Long.hashCode(this.search);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Retries other = (Retries) o;
        return this.bulk == other.bulk && this.search == other.search;
    }
}
