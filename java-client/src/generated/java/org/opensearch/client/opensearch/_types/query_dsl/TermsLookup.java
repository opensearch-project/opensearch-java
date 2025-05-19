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

package org.opensearch.client.opensearch._types.query_dsl;

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

// typedef: _types.query_dsl.TermsLookup

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class TermsLookup implements PlainJsonSerializable, ToCopyableBuilder<TermsLookup.Builder, TermsLookup> {

    @Nonnull
    private final String id;

    @Nonnull
    private final String index;

    @Nonnull
    private final String path;

    @Nullable
    private final String routing;

    @Nullable
    private final Boolean store;

    // ---------------------------------------------------------------------------------------------

    private TermsLookup(Builder builder) {
        this.id = ApiTypeHelper.requireNonNull(builder.id, this, "id");
        this.index = ApiTypeHelper.requireNonNull(builder.index, this, "index");
        this.path = ApiTypeHelper.requireNonNull(builder.path, this, "path");
        this.routing = builder.routing;
        this.store = builder.store;
    }

    public static TermsLookup of(Function<TermsLookup.Builder, ObjectBuilder<TermsLookup>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code id}
     */
    @Nonnull
    public final String id() {
        return this.id;
    }

    /**
     * Required - API name: {@code index}
     */
    @Nonnull
    public final String index() {
        return this.index;
    }

    /**
     * Required - API name: {@code path}
     */
    @Nonnull
    public final String path() {
        return this.path;
    }

    /**
     * API name: {@code routing}
     */
    @Nullable
    public final String routing() {
        return this.routing;
    }

    /**
     * API name: {@code store}
     */
    @Nullable
    public final Boolean store() {
        return this.store;
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
        generator.writeKey("id");
        generator.write(this.id);

        generator.writeKey("index");
        generator.write(this.index);

        generator.writeKey("path");
        generator.write(this.path);

        if (this.routing != null) {
            generator.writeKey("routing");
            generator.write(this.routing);
        }

        if (this.store != null) {
            generator.writeKey("store");
            generator.write(this.store);
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
     * Builder for {@link TermsLookup}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, TermsLookup> {
        private String id;
        private String index;
        private String path;
        @Nullable
        private String routing;
        @Nullable
        private Boolean store;

        public Builder() {}

        private Builder(TermsLookup o) {
            this.id = o.id;
            this.index = o.index;
            this.path = o.path;
            this.routing = o.routing;
            this.store = o.store;
        }

        private Builder(Builder o) {
            this.id = o.id;
            this.index = o.index;
            this.path = o.path;
            this.routing = o.routing;
            this.store = o.store;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code id}
         */
        @Nonnull
        public final Builder id(String value) {
            this.id = value;
            return this;
        }

        /**
         * Required - API name: {@code index}
         */
        @Nonnull
        public final Builder index(String value) {
            this.index = value;
            return this;
        }

        /**
         * Required - API name: {@code path}
         */
        @Nonnull
        public final Builder path(String value) {
            this.path = value;
            return this;
        }

        /**
         * API name: {@code routing}
         */
        @Nonnull
        public final Builder routing(@Nullable String value) {
            this.routing = value;
            return this;
        }

        /**
         * API name: {@code store}
         */
        @Nonnull
        public final Builder store(@Nullable Boolean value) {
            this.store = value;
            return this;
        }

        /**
         * Builds a {@link TermsLookup}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public TermsLookup build() {
            _checkSingleUse();

            return new TermsLookup(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link TermsLookup}
     */
    public static final JsonpDeserializer<TermsLookup> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        TermsLookup::setupTermsLookupDeserializer
    );

    protected static void setupTermsLookupDeserializer(ObjectDeserializer<TermsLookup.Builder> op) {
        op.add(Builder::id, JsonpDeserializer.stringDeserializer(), "id");
        op.add(Builder::index, JsonpDeserializer.stringDeserializer(), "index");
        op.add(Builder::path, JsonpDeserializer.stringDeserializer(), "path");
        op.add(Builder::routing, JsonpDeserializer.stringDeserializer(), "routing");
        op.add(Builder::store, JsonpDeserializer.booleanDeserializer(), "store");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.id.hashCode();
        result = 31 * result + this.index.hashCode();
        result = 31 * result + this.path.hashCode();
        result = 31 * result + Objects.hashCode(this.routing);
        result = 31 * result + Objects.hashCode(this.store);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        TermsLookup other = (TermsLookup) o;
        return this.id.equals(other.id)
            && this.index.equals(other.index)
            && this.path.equals(other.path)
            && Objects.equals(this.routing, other.routing)
            && Objects.equals(this.store, other.store);
    }
}
