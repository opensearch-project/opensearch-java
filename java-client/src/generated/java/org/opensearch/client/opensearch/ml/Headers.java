/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

//----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------

package org.opensearch.client.opensearch.ml;

import jakarta.json.stream.JsonGenerator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import javax.annotation.Generated;
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

// typedef: ml.Headers

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Headers implements PlainJsonSerializable {

    @Nullable
    private final String contentType;

    private final Map<String, JsonData> metadata;

    // ---------------------------------------------------------------------------------------------

    private Headers(Builder builder) {
        this.contentType = builder.contentType;
        this.metadata = ApiTypeHelper.unmodifiable(builder.metadata);
    }

    public static Headers of(Function<Headers.Builder, ObjectBuilder<Headers>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code content_type}
     */
    @Nullable
    public final String contentType() {
        return this.contentType;
    }

    /**
                                    */
    public final Map<String, JsonData> metadata() {
        return this.metadata;
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
        for (Map.Entry<String, JsonData> item0 : this.metadata.entrySet()) {
            generator.writeKey(item0.getKey());
            item0.getValue().serialize(generator, mapper);
        }
        if (this.contentType != null) {
            generator.writeKey("content_type");
            generator.write(this.contentType);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link Headers}.
     */
    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<Headers> {
        @Nullable
        private String contentType;
        @Nullable
        private Map<String, JsonData> metadata;

        /**
         * API name: {@code content_type}
         */
        public final Builder contentType(@Nullable String value) {
            this.contentType = value;
            return this;
        }

        /**
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>metadata</code>.
         * </p>
         */
        public final Builder metadata(Map<String, JsonData> map) {
            this.metadata = _mapPutAll(this.metadata, map);
            return this;
        }

        /**
         *
         * <p>
         * Adds an entry to <code>metadata</code>.
         * </p>
         */
        public final Builder metadata(String key, JsonData value) {
            this.metadata = _mapPut(this.metadata, key, value);
            return this;
        }

        /**
         * Builds a {@link Headers}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public Headers build() {
            _checkSingleUse();

            return new Headers(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link Headers}
     */
    public static final JsonpDeserializer<Headers> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        Headers::setupHeadersDeserializer
    );

    protected static void setupHeadersDeserializer(ObjectDeserializer<Headers.Builder> op) {
        op.add(Builder::contentType, JsonpDeserializer.stringDeserializer(), "content_type");
        op.setUnknownFieldHandler((builder, name, parser, mapper) -> {
            if (builder.metadata == null) {
                builder.metadata = new HashMap<>();
            }
            builder.metadata.put(name, JsonData._DESERIALIZER.deserialize(parser, mapper));
        });
    }
}
