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

package org.opensearch.client.opensearch.core;

import jakarta.json.stream.JsonGenerator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.opensearch.core.field_caps.FieldCapability;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _global.field_caps.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class FieldCapsResponse implements PlainJsonSerializable, ToCopyableBuilder<FieldCapsResponse.Builder, FieldCapsResponse> {

    @Nonnull
    private final Map<String, Map<String, FieldCapability>> fields;

    @Nonnull
    private final List<String> indices;

    // ---------------------------------------------------------------------------------------------

    private FieldCapsResponse(Builder builder) {
        this.fields = ApiTypeHelper.unmodifiableRequired(builder.fields, this, "fields");
        this.indices = ApiTypeHelper.unmodifiableRequired(builder.indices, this, "indices");
    }

    public static FieldCapsResponse of(Function<FieldCapsResponse.Builder, ObjectBuilder<FieldCapsResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code fields}
     */
    @Nonnull
    public final Map<String, Map<String, FieldCapability>> fields() {
        return this.fields;
    }

    /**
     * Required - API name: {@code indices}
     */
    @Nonnull
    public final List<String> indices() {
        return this.indices;
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
        generator.writeKey("fields");
        generator.writeStartObject();
        for (Map.Entry<String, Map<String, FieldCapability>> item0 : this.fields.entrySet()) {
            generator.writeKey(item0.getKey());
            generator.writeStartObject();
            for (Map.Entry<String, FieldCapability> item1 : item0.getValue().entrySet()) {
                generator.writeKey(item1.getKey());
                item1.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }
        generator.writeEnd();

        generator.writeKey("indices");
        generator.writeStartArray();
        for (String item0 : this.indices) {
            generator.write(item0);
        }
        generator.writeEnd();
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
     * Builder for {@link FieldCapsResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, FieldCapsResponse> {
        private Map<String, Map<String, FieldCapability>> fields;
        private List<String> indices;

        public Builder() {}

        private Builder(FieldCapsResponse o) {
            this.fields = _mapCopy(o.fields);
            this.indices = _listCopy(o.indices);
        }

        private Builder(Builder o) {
            this.fields = _mapCopy(o.fields);
            this.indices = _listCopy(o.indices);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code fields}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>fields</code>.
         * </p>
         */
        @Nonnull
        public final Builder fields(Map<String, Map<String, FieldCapability>> map) {
            this.fields = _mapPutAll(this.fields, map);
            return this;
        }

        /**
         * Required - API name: {@code fields}
         *
         * <p>
         * Adds an entry to <code>fields</code>.
         * </p>
         */
        @Nonnull
        public final Builder fields(String key, Map<String, FieldCapability> value) {
            this.fields = _mapPut(this.fields, key, value);
            return this;
        }

        /**
         * Required - API name: {@code indices}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>indices</code>.
         * </p>
         */
        @Nonnull
        public final Builder indices(List<String> list) {
            this.indices = _listAddAll(this.indices, list);
            return this;
        }

        /**
         * Required - API name: {@code indices}
         *
         * <p>
         * Adds one or more values to <code>indices</code>.
         * </p>
         */
        @Nonnull
        public final Builder indices(String value, String... values) {
            this.indices = _listAdd(this.indices, value, values);
            return this;
        }

        /**
         * Builds a {@link FieldCapsResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public FieldCapsResponse build() {
            _checkSingleUse();

            return new FieldCapsResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link FieldCapsResponse}
     */
    public static final JsonpDeserializer<FieldCapsResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        FieldCapsResponse::setupFieldCapsResponseDeserializer
    );

    protected static void setupFieldCapsResponseDeserializer(ObjectDeserializer<FieldCapsResponse.Builder> op) {
        op.add(
            Builder::fields,
            JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.stringMapDeserializer(FieldCapability._DESERIALIZER)),
            "fields"
        );
        op.add(Builder::indices, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "indices");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.fields.hashCode();
        result = 31 * result + this.indices.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        FieldCapsResponse other = (FieldCapsResponse) o;
        return this.fields.equals(other.fields) && this.indices.equals(other.indices);
    }
}
