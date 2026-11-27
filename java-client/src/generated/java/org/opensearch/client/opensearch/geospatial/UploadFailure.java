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

package org.opensearch.client.opensearch.geospatial;

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

// typedef: geospatial.UploadFailure

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class UploadFailure implements PlainJsonSerializable, ToCopyableBuilder<UploadFailure.Builder, UploadFailure> {

    @Nullable
    private final String id;

    @Nullable
    private final String message;

    @Nullable
    private final Integer status;

    // ---------------------------------------------------------------------------------------------

    private UploadFailure(Builder builder) {
        this.id = builder.id;
        this.message = builder.message;
        this.status = builder.status;
    }

    public static UploadFailure of(Function<UploadFailure.Builder, ObjectBuilder<UploadFailure>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The document ID that failed.
     * <p>
     * API name: {@code id}
     * </p>
     */
    @Nullable
    public final String id() {
        return this.id;
    }

    /**
     * The failure message.
     * <p>
     * API name: {@code message}
     * </p>
     */
    @Nullable
    public final String message() {
        return this.message;
    }

    /**
     * The HTTP status code of the failure.
     * <p>
     * API name: {@code status}
     * </p>
     */
    @Nullable
    public final Integer status() {
        return this.status;
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
        if (this.id != null) {
            generator.writeKey("id");
            generator.write(this.id);
        }

        if (this.message != null) {
            generator.writeKey("message");
            generator.write(this.message);
        }

        if (this.status != null) {
            generator.writeKey("status");
            generator.write(this.status);
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
     * Builder for {@link UploadFailure}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, UploadFailure> {
        @Nullable
        private String id;
        @Nullable
        private String message;
        @Nullable
        private Integer status;

        public Builder() {}

        private Builder(UploadFailure o) {
            this.id = o.id;
            this.message = o.message;
            this.status = o.status;
        }

        private Builder(Builder o) {
            this.id = o.id;
            this.message = o.message;
            this.status = o.status;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The document ID that failed.
         * <p>
         * API name: {@code id}
         * </p>
         */
        @Nonnull
        public final Builder id(@Nullable String value) {
            this.id = value;
            return this;
        }

        /**
         * The failure message.
         * <p>
         * API name: {@code message}
         * </p>
         */
        @Nonnull
        public final Builder message(@Nullable String value) {
            this.message = value;
            return this;
        }

        /**
         * The HTTP status code of the failure.
         * <p>
         * API name: {@code status}
         * </p>
         */
        @Nonnull
        public final Builder status(@Nullable Integer value) {
            this.status = value;
            return this;
        }

        /**
         * Builds a {@link UploadFailure}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public UploadFailure build() {
            _checkSingleUse();

            return new UploadFailure(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link UploadFailure}
     */
    public static final JsonpDeserializer<UploadFailure> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        UploadFailure::setupUploadFailureDeserializer
    );

    protected static void setupUploadFailureDeserializer(ObjectDeserializer<UploadFailure.Builder> op) {
        op.add(Builder::id, JsonpDeserializer.stringDeserializer(), "id");
        op.add(Builder::message, JsonpDeserializer.stringDeserializer(), "message");
        op.add(Builder::status, JsonpDeserializer.integerDeserializer(), "status");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.id);
        result = 31 * result + Objects.hashCode(this.message);
        result = 31 * result + Objects.hashCode(this.status);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        UploadFailure other = (UploadFailure) o;
        return Objects.equals(this.id, other.id)
            && Objects.equals(this.message, other.message)
            && Objects.equals(this.status, other.status);
    }
}
