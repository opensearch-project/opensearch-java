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

package org.opensearch.client.opensearch._types.mapping;

import jakarta.json.stream.JsonGenerator;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonData;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: _types.mapping.KnnVectorMethod

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class KnnVectorMethod implements PlainJsonSerializable {

    @Nullable
    private final String engine;

    @Nonnull
    private final String name;

    @Nonnull
    private final Map<String, JsonData> parameters;

    @Nullable
    private final String spaceType;

    // ---------------------------------------------------------------------------------------------

    private KnnVectorMethod(Builder builder) {
        this.engine = builder.engine;
        this.name = ApiTypeHelper.requireNonNull(builder.name, this, "name");
        this.parameters = ApiTypeHelper.unmodifiable(builder.parameters);
        this.spaceType = builder.spaceType;
    }

    public static KnnVectorMethod of(Function<KnnVectorMethod.Builder, ObjectBuilder<KnnVectorMethod>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code engine}
     */
    @Nullable
    public final String engine() {
        return this.engine;
    }

    /**
     * Required - API name: {@code name}
     */
    @Nonnull
    public final String name() {
        return this.name;
    }

    /**
     * API name: {@code parameters}
     */
    @Nonnull
    public final Map<String, JsonData> parameters() {
        return this.parameters;
    }

    /**
     * API name: {@code space_type}
     */
    @Nullable
    public final String spaceType() {
        return this.spaceType;
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
        if (this.engine != null) {
            generator.writeKey("engine");
            generator.write(this.engine);
        }

        generator.writeKey("name");
        generator.write(this.name);

        if (ApiTypeHelper.isDefined(this.parameters)) {
            generator.writeKey("parameters");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.parameters.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.spaceType != null) {
            generator.writeKey("space_type");
            generator.write(this.spaceType);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link KnnVectorMethod}.
     */
    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<KnnVectorMethod> {
        @Nullable
        private String engine;
        private String name;
        @Nullable
        private Map<String, JsonData> parameters;
        @Nullable
        private String spaceType;

        /**
         * API name: {@code engine}
         */
        public final Builder engine(@Nullable String value) {
            this.engine = value;
            return this;
        }

        /**
         * Required - API name: {@code name}
         */
        public final Builder name(String value) {
            this.name = value;
            return this;
        }

        /**
         * API name: {@code parameters}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>parameters</code>.
         * </p>
         */
        public final Builder parameters(Map<String, JsonData> map) {
            this.parameters = _mapPutAll(this.parameters, map);
            return this;
        }

        /**
         * API name: {@code parameters}
         *
         * <p>
         * Adds an entry to <code>parameters</code>.
         * </p>
         */
        public final Builder parameters(String key, JsonData value) {
            this.parameters = _mapPut(this.parameters, key, value);
            return this;
        }

        /**
         * API name: {@code space_type}
         */
        public final Builder spaceType(@Nullable String value) {
            this.spaceType = value;
            return this;
        }

        /**
         * Builds a {@link KnnVectorMethod}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public KnnVectorMethod build() {
            _checkSingleUse();

            return new KnnVectorMethod(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link KnnVectorMethod}
     */
    public static final JsonpDeserializer<KnnVectorMethod> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        KnnVectorMethod::setupKnnVectorMethodDeserializer
    );

    protected static void setupKnnVectorMethodDeserializer(ObjectDeserializer<KnnVectorMethod.Builder> op) {
        op.add(Builder::engine, JsonpDeserializer.stringDeserializer(), "engine");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
        op.add(Builder::parameters, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "parameters");
        op.add(Builder::spaceType, JsonpDeserializer.stringDeserializer(), "space_type");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.engine);
        result = 31 * result + this.name.hashCode();
        result = 31 * result + Objects.hashCode(this.parameters);
        result = 31 * result + Objects.hashCode(this.spaceType);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        KnnVectorMethod other = (KnnVectorMethod) o;
        return Objects.equals(this.engine, other.engine)
            && this.name.equals(other.name)
            && Objects.equals(this.parameters, other.parameters)
            && Objects.equals(this.spaceType, other.spaceType);
    }
}
