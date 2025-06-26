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

// typedef: _types.DocStatus

/**
 * The item level HTTP response status code during indexing.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class DocStatus implements PlainJsonSerializable, ToCopyableBuilder<DocStatus.Builder, DocStatus> {

    @Nullable
    private final Long _1xx;

    @Nullable
    private final Long _2xx;

    @Nullable
    private final Long _3xx;

    @Nullable
    private final Long _4xx;

    @Nullable
    private final Long _5xx;

    // ---------------------------------------------------------------------------------------------

    private DocStatus(Builder builder) {
        this._1xx = builder._1xx;
        this._2xx = builder._2xx;
        this._3xx = builder._3xx;
        this._4xx = builder._4xx;
        this._5xx = builder._5xx;
    }

    public static DocStatus of(Function<DocStatus.Builder, ObjectBuilder<DocStatus>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The number of informational responses.
     * <p>
     * API name: {@code 1xx}
     * </p>
     */
    @Nullable
    public final Long _1xx() {
        return this._1xx;
    }

    /**
     * The number of successful responses.
     * <p>
     * API name: {@code 2xx}
     * </p>
     */
    @Nullable
    public final Long _2xx() {
        return this._2xx;
    }

    /**
     * The number of redirection responses.
     * <p>
     * API name: {@code 3xx}
     * </p>
     */
    @Nullable
    public final Long _3xx() {
        return this._3xx;
    }

    /**
     * The number of client error responses.
     * <p>
     * API name: {@code 4xx}
     * </p>
     */
    @Nullable
    public final Long _4xx() {
        return this._4xx;
    }

    /**
     * The number of server error responses.
     * <p>
     * API name: {@code 5xx}
     * </p>
     */
    @Nullable
    public final Long _5xx() {
        return this._5xx;
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
        if (this._1xx != null) {
            generator.writeKey("1xx");
            generator.write(this._1xx);
        }

        if (this._2xx != null) {
            generator.writeKey("2xx");
            generator.write(this._2xx);
        }

        if (this._3xx != null) {
            generator.writeKey("3xx");
            generator.write(this._3xx);
        }

        if (this._4xx != null) {
            generator.writeKey("4xx");
            generator.write(this._4xx);
        }

        if (this._5xx != null) {
            generator.writeKey("5xx");
            generator.write(this._5xx);
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
     * Builder for {@link DocStatus}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, DocStatus> {
        @Nullable
        private Long _1xx;
        @Nullable
        private Long _2xx;
        @Nullable
        private Long _3xx;
        @Nullable
        private Long _4xx;
        @Nullable
        private Long _5xx;

        public Builder() {}

        private Builder(DocStatus o) {
            this._1xx = o._1xx;
            this._2xx = o._2xx;
            this._3xx = o._3xx;
            this._4xx = o._4xx;
            this._5xx = o._5xx;
        }

        private Builder(Builder o) {
            this._1xx = o._1xx;
            this._2xx = o._2xx;
            this._3xx = o._3xx;
            this._4xx = o._4xx;
            this._5xx = o._5xx;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The number of informational responses.
         * <p>
         * API name: {@code 1xx}
         * </p>
         */
        @Nonnull
        public final Builder _1xx(@Nullable Long value) {
            this._1xx = value;
            return this;
        }

        /**
         * The number of successful responses.
         * <p>
         * API name: {@code 2xx}
         * </p>
         */
        @Nonnull
        public final Builder _2xx(@Nullable Long value) {
            this._2xx = value;
            return this;
        }

        /**
         * The number of redirection responses.
         * <p>
         * API name: {@code 3xx}
         * </p>
         */
        @Nonnull
        public final Builder _3xx(@Nullable Long value) {
            this._3xx = value;
            return this;
        }

        /**
         * The number of client error responses.
         * <p>
         * API name: {@code 4xx}
         * </p>
         */
        @Nonnull
        public final Builder _4xx(@Nullable Long value) {
            this._4xx = value;
            return this;
        }

        /**
         * The number of server error responses.
         * <p>
         * API name: {@code 5xx}
         * </p>
         */
        @Nonnull
        public final Builder _5xx(@Nullable Long value) {
            this._5xx = value;
            return this;
        }

        /**
         * Builds a {@link DocStatus}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DocStatus build() {
            _checkSingleUse();

            return new DocStatus(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link DocStatus}
     */
    public static final JsonpDeserializer<DocStatus> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        DocStatus::setupDocStatusDeserializer
    );

    protected static void setupDocStatusDeserializer(ObjectDeserializer<DocStatus.Builder> op) {
        op.add(Builder::_1xx, JsonpDeserializer.longDeserializer(), "1xx");
        op.add(Builder::_2xx, JsonpDeserializer.longDeserializer(), "2xx");
        op.add(Builder::_3xx, JsonpDeserializer.longDeserializer(), "3xx");
        op.add(Builder::_4xx, JsonpDeserializer.longDeserializer(), "4xx");
        op.add(Builder::_5xx, JsonpDeserializer.longDeserializer(), "5xx");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this._1xx);
        result = 31 * result + Objects.hashCode(this._2xx);
        result = 31 * result + Objects.hashCode(this._3xx);
        result = 31 * result + Objects.hashCode(this._4xx);
        result = 31 * result + Objects.hashCode(this._5xx);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        DocStatus other = (DocStatus) o;
        return Objects.equals(this._1xx, other._1xx)
            && Objects.equals(this._2xx, other._2xx)
            && Objects.equals(this._3xx, other._3xx)
            && Objects.equals(this._4xx, other._4xx)
            && Objects.equals(this._5xx, other._5xx);
    }
}
