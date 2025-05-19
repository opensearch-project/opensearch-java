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
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: indices.SearchIdle

/**
 * The configuration for search idle behavior.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SearchIdle implements PlainJsonSerializable, ToCopyableBuilder<SearchIdle.Builder, SearchIdle> {

    @Nullable
    private final Time after;

    // ---------------------------------------------------------------------------------------------

    private SearchIdle(Builder builder) {
        this.after = builder.after;
    }

    public static SearchIdle of(Function<SearchIdle.Builder, ObjectBuilder<SearchIdle>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code after}
     */
    @Nullable
    public final Time after() {
        return this.after;
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
        if (this.after != null) {
            generator.writeKey("after");
            this.after.serialize(generator, mapper);
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
     * Builder for {@link SearchIdle}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, SearchIdle> {
        @Nullable
        private Time after;

        public Builder() {}

        private Builder(SearchIdle o) {
            this.after = o.after;
        }

        private Builder(Builder o) {
            this.after = o.after;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code after}
         */
        @Nonnull
        public final Builder after(@Nullable Time value) {
            this.after = value;
            return this;
        }

        /**
         * API name: {@code after}
         */
        @Nonnull
        public final Builder after(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return after(fn.apply(new Time.Builder()).build());
        }

        /**
         * Builds a {@link SearchIdle}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SearchIdle build() {
            _checkSingleUse();

            return new SearchIdle(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SearchIdle}
     */
    public static final JsonpDeserializer<SearchIdle> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SearchIdle::setupSearchIdleDeserializer
    );

    protected static void setupSearchIdleDeserializer(ObjectDeserializer<SearchIdle.Builder> op) {
        op.add(Builder::after, Time._DESERIALIZER, "after");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.after);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SearchIdle other = (SearchIdle) o;
        return Objects.equals(this.after, other.after);
    }
}
