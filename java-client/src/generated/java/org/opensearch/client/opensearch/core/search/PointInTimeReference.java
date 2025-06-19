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
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: core.search.PointInTimeReference

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class PointInTimeReference implements PlainJsonSerializable, ToCopyableBuilder<PointInTimeReference.Builder, PointInTimeReference> {

    @Nonnull
    private final String id;

    @Nullable
    private final Time keepAlive;

    // ---------------------------------------------------------------------------------------------

    private PointInTimeReference(Builder builder) {
        this.id = ApiTypeHelper.requireNonNull(builder.id, this, "id");
        this.keepAlive = builder.keepAlive;
    }

    public static PointInTimeReference of(Function<PointInTimeReference.Builder, ObjectBuilder<PointInTimeReference>> fn) {
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
     * API name: {@code keep_alive}
     */
    @Nullable
    public final Time keepAlive() {
        return this.keepAlive;
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

        if (this.keepAlive != null) {
            generator.writeKey("keep_alive");
            this.keepAlive.serialize(generator, mapper);
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
     * Builder for {@link PointInTimeReference}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, PointInTimeReference> {
        private String id;
        @Nullable
        private Time keepAlive;

        public Builder() {}

        private Builder(PointInTimeReference o) {
            this.id = o.id;
            this.keepAlive = o.keepAlive;
        }

        private Builder(Builder o) {
            this.id = o.id;
            this.keepAlive = o.keepAlive;
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
         * API name: {@code keep_alive}
         */
        @Nonnull
        public final Builder keepAlive(@Nullable Time value) {
            this.keepAlive = value;
            return this;
        }

        /**
         * API name: {@code keep_alive}
         */
        @Nonnull
        public final Builder keepAlive(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return keepAlive(fn.apply(new Time.Builder()).build());
        }

        /**
         * Builds a {@link PointInTimeReference}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PointInTimeReference build() {
            _checkSingleUse();

            return new PointInTimeReference(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PointInTimeReference}
     */
    public static final JsonpDeserializer<PointInTimeReference> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PointInTimeReference::setupPointInTimeReferenceDeserializer
    );

    protected static void setupPointInTimeReferenceDeserializer(ObjectDeserializer<PointInTimeReference.Builder> op) {
        op.add(Builder::id, JsonpDeserializer.stringDeserializer(), "id");
        op.add(Builder::keepAlive, Time._DESERIALIZER, "keep_alive");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.id.hashCode();
        result = 31 * result + Objects.hashCode(this.keepAlive);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PointInTimeReference other = (PointInTimeReference) o;
        return this.id.equals(other.id) && Objects.equals(this.keepAlive, other.keepAlive);
    }
}
