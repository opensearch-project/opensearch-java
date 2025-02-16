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
import java.util.List;
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

// typedef: core.search.FetchProfileDebug

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class FetchProfileDebug implements PlainJsonSerializable, ToCopyableBuilder<FetchProfileDebug.Builder, FetchProfileDebug> {

    @Nullable
    private final Integer fastPath;

    @Nonnull
    private final List<String> storedFields;

    // ---------------------------------------------------------------------------------------------

    private FetchProfileDebug(Builder builder) {
        this.fastPath = builder.fastPath;
        this.storedFields = ApiTypeHelper.unmodifiable(builder.storedFields);
    }

    public static FetchProfileDebug of(Function<FetchProfileDebug.Builder, ObjectBuilder<FetchProfileDebug>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code fast_path}
     */
    @Nullable
    public final Integer fastPath() {
        return this.fastPath;
    }

    /**
     * API name: {@code stored_fields}
     */
    @Nonnull
    public final List<String> storedFields() {
        return this.storedFields;
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
        if (this.fastPath != null) {
            generator.writeKey("fast_path");
            generator.write(this.fastPath);
        }

        if (ApiTypeHelper.isDefined(this.storedFields)) {
            generator.writeKey("stored_fields");
            generator.writeStartArray();
            for (String item0 : this.storedFields) {
                generator.write(item0);
            }
            generator.writeEnd();
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
     * Builder for {@link FetchProfileDebug}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, FetchProfileDebug> {
        @Nullable
        private Integer fastPath;
        @Nullable
        private List<String> storedFields;

        public Builder() {}

        private Builder(FetchProfileDebug o) {
            this.fastPath = o.fastPath;
            this.storedFields = _listCopy(o.storedFields);
        }

        private Builder(Builder o) {
            this.fastPath = o.fastPath;
            this.storedFields = _listCopy(o.storedFields);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code fast_path}
         */
        @Nonnull
        public final Builder fastPath(@Nullable Integer value) {
            this.fastPath = value;
            return this;
        }

        /**
         * API name: {@code stored_fields}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>storedFields</code>.
         * </p>
         */
        @Nonnull
        public final Builder storedFields(List<String> list) {
            this.storedFields = _listAddAll(this.storedFields, list);
            return this;
        }

        /**
         * API name: {@code stored_fields}
         *
         * <p>
         * Adds one or more values to <code>storedFields</code>.
         * </p>
         */
        @Nonnull
        public final Builder storedFields(String value, String... values) {
            this.storedFields = _listAdd(this.storedFields, value, values);
            return this;
        }

        /**
         * Builds a {@link FetchProfileDebug}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public FetchProfileDebug build() {
            _checkSingleUse();

            return new FetchProfileDebug(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link FetchProfileDebug}
     */
    public static final JsonpDeserializer<FetchProfileDebug> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        FetchProfileDebug::setupFetchProfileDebugDeserializer
    );

    protected static void setupFetchProfileDebugDeserializer(ObjectDeserializer<FetchProfileDebug.Builder> op) {
        op.add(Builder::fastPath, JsonpDeserializer.integerDeserializer(), "fast_path");
        op.add(Builder::storedFields, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "stored_fields");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.fastPath);
        result = 31 * result + Objects.hashCode(this.storedFields);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        FetchProfileDebug other = (FetchProfileDebug) o;
        return Objects.equals(this.fastPath, other.fastPath) && Objects.equals(this.storedFields, other.storedFields);
    }
}
