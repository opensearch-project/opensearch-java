/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch._types.mapping;

import jakarta.json.stream.JsonGenerator;
import java.util.Map;
import java.util.function.Function;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonData;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.JsonpSerializable;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: _types.mapping.KnnVectorMethod

@JsonpDeserializable
public class KnnVectorMethod implements JsonpSerializable {
    /**
     * Builder for {@link KnnVectorMethod}.
     */

    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<KnnVectorMethod> {
        private String name;

        @Nullable
        private String spaceType;

        @Nullable
        private String engine;

        @Nullable
        private Map<String, JsonData> parameters;

        /**
         * Required - API name: {@code name}
         */
        public final Builder name(String value) {
            this.name = value;
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
         * API name: {@code engine}
         */
        public final Builder engine(@Nullable String value) {
            this.engine = value;
            return this;
        }

        /**
         * API name: {@code parameters}
         */
        public final Builder parameters(@Nullable Map<String, JsonData> map) {
            this.parameters = _mapPutAll(this.parameters, map);
            return this;
        }

        /**
         * API name: {@code parameters}
         */
        public final Builder parameters(String key, JsonData value) {
            this.parameters = _mapPut(this.parameters, key, value);
            return this;
        }

        /**
         * Builds a {@link KnnVectorMethod}.
         *
         * @throws NullPointerException
         *                              if some of the required fields are null.
         */
        public KnnVectorMethod build() {
            _checkSingleUse();

            return new KnnVectorMethod(this);
        }
    }

    /**
     * Json deserializer for {@link KnnVectorMethod}
     */
    public static final JsonpDeserializer<KnnVectorMethod> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        KnnVectorMethod::setupKnnVectorMethodDeserializer
    );

    public static KnnVectorMethod of(Function<Builder, ObjectBuilder<KnnVectorMethod>> fn) {
        return fn.apply(new Builder()).build();
    }

    protected static void setupKnnVectorMethodDeserializer(ObjectDeserializer<KnnVectorMethod.Builder> op) {

        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
        op.add(Builder::spaceType, JsonpDeserializer.stringDeserializer(), "space_type");
        op.add(Builder::engine, JsonpDeserializer.stringDeserializer(), "engine");
        op.add(Builder::parameters, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "parameters");

    }

    // ---------------------------------------------------------------------------------------------

    private final String name;

    @Nullable
    private final String spaceType;

    @Nullable
    private final String engine;

    @Nullable
    private final Map<String, JsonData> parameters;

    private KnnVectorMethod(Builder builder) {

        this.name = ApiTypeHelper.requireNonNull(builder.name, this, "name");
        this.spaceType = builder.spaceType;
        this.engine = builder.engine;
        this.parameters = builder.parameters;

    }

    /**
     * Required - API name: {@code name}
     */
    public final String name() {
        return this.name;
    }

    /**
     * API name: {@code space_type}
     */
    @Nullable
    public final String spaceType() {
        return this.spaceType;
    }

    /**
     * API name: {@code engine}
     */
    @Nullable
    public final String engine() {
        return this.engine;
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * API name: {@code parameters}
     */
    @Nullable
    public final Map<String, JsonData> parameters() {
        return this.parameters;
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Serialize this object to JSON.
     */
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {

        generator.writeKey("name");
        generator.write(this.name);

        if (this.spaceType != null) {
            generator.writeKey("space_type");
            generator.write(this.spaceType);
        }

        if (this.engine != null) {
            generator.writeKey("engine");
            generator.write(this.engine);
        }

        if (this.parameters != null) {
            generator.writeKey("parameters");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.parameters.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

    }

}
