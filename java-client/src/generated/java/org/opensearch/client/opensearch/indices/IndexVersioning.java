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
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: indices.IndexVersioning

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IndexVersioning implements PlainJsonSerializable, ToCopyableBuilder<IndexVersioning.Builder, IndexVersioning> {

    @Nullable
    private final String created;

    @Nullable
    private final String createdString;

    // ---------------------------------------------------------------------------------------------

    private IndexVersioning(Builder builder) {
        this.created = builder.created;
        this.createdString = builder.createdString;
    }

    public static IndexVersioning of(Function<IndexVersioning.Builder, ObjectBuilder<IndexVersioning>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code created}
     */
    @Nullable
    public final String created() {
        return this.created;
    }

    /**
     * API name: {@code created_string}
     */
    @Nullable
    public final String createdString() {
        return this.createdString;
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
        if (this.created != null) {
            generator.writeKey("created");
            generator.write(this.created);
        }

        if (this.createdString != null) {
            generator.writeKey("created_string");
            generator.write(this.createdString);
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
     * Builder for {@link IndexVersioning}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IndexVersioning> {
        @Nullable
        private String created;
        @Nullable
        private String createdString;

        public Builder() {}

        private Builder(IndexVersioning o) {
            this.created = o.created;
            this.createdString = o.createdString;
        }

        private Builder(Builder o) {
            this.created = o.created;
            this.createdString = o.createdString;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code created}
         */
        @Nonnull
        public final Builder created(@Nullable String value) {
            this.created = value;
            return this;
        }

        /**
         * API name: {@code created_string}
         */
        @Nonnull
        public final Builder createdString(@Nullable String value) {
            this.createdString = value;
            return this;
        }

        /**
         * Builds a {@link IndexVersioning}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IndexVersioning build() {
            _checkSingleUse();

            return new IndexVersioning(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IndexVersioning}
     */
    public static final JsonpDeserializer<IndexVersioning> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IndexVersioning::setupIndexVersioningDeserializer
    );

    protected static void setupIndexVersioningDeserializer(ObjectDeserializer<IndexVersioning.Builder> op) {
        op.add(Builder::created, JsonpDeserializer.stringDeserializer(), "created");
        op.add(Builder::createdString, JsonpDeserializer.stringDeserializer(), "created_string");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.created);
        result = 31 * result + Objects.hashCode(this.createdString);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IndexVersioning other = (IndexVersioning) o;
        return Objects.equals(this.created, other.created) && Objects.equals(this.createdString, other.createdString);
    }
}
