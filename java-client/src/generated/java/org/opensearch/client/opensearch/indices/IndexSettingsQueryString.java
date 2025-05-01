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

// typedef: indices.IndexSettingsQueryString

/**
 * The configuration for query string parsing.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IndexSettingsQueryString
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<IndexSettingsQueryString.Builder, IndexSettingsQueryString> {

    @Nullable
    private final Boolean lenient;

    // ---------------------------------------------------------------------------------------------

    private IndexSettingsQueryString(Builder builder) {
        this.lenient = builder.lenient;
    }

    public static IndexSettingsQueryString of(Function<IndexSettingsQueryString.Builder, ObjectBuilder<IndexSettingsQueryString>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code lenient}
     */
    @Nullable
    public final Boolean lenient() {
        return this.lenient;
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
        if (this.lenient != null) {
            generator.writeKey("lenient");
            generator.write(this.lenient);
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
     * Builder for {@link IndexSettingsQueryString}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IndexSettingsQueryString> {
        @Nullable
        private Boolean lenient;

        public Builder() {}

        private Builder(IndexSettingsQueryString o) {
            this.lenient = o.lenient;
        }

        private Builder(Builder o) {
            this.lenient = o.lenient;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code lenient}
         */
        @Nonnull
        public final Builder lenient(@Nullable Boolean value) {
            this.lenient = value;
            return this;
        }

        /**
         * Builds a {@link IndexSettingsQueryString}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IndexSettingsQueryString build() {
            _checkSingleUse();

            return new IndexSettingsQueryString(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IndexSettingsQueryString}
     */
    public static final JsonpDeserializer<IndexSettingsQueryString> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IndexSettingsQueryString::setupIndexSettingsQueryStringDeserializer
    );

    protected static void setupIndexSettingsQueryStringDeserializer(ObjectDeserializer<IndexSettingsQueryString.Builder> op) {
        op.add(Builder::lenient, JsonpDeserializer.booleanDeserializer(), "lenient");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.lenient);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IndexSettingsQueryString other = (IndexSettingsQueryString) o;
        return Objects.equals(this.lenient, other.lenient);
    }
}
