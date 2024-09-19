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
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: ml.undeploy_model.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class UndeployModelResponse implements PlainJsonSerializable {

    private final Map<String, UndeployModelNode> nodes;

    // ---------------------------------------------------------------------------------------------

    private UndeployModelResponse(Builder builder) {
        this.nodes = ApiTypeHelper.unmodifiable(builder.nodes);
    }

    public static UndeployModelResponse of(Function<UndeployModelResponse.Builder, ObjectBuilder<UndeployModelResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
                                    */
    public final Map<String, UndeployModelNode> nodes() {
        return this.nodes;
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
        for (Map.Entry<String, UndeployModelNode> item0 : this.nodes.entrySet()) {
            generator.writeKey(item0.getKey());
            item0.getValue().serialize(generator, mapper);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link UndeployModelResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<UndeployModelResponse> {
        @Nullable
        private Map<String, UndeployModelNode> nodes;

        /**
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>nodes</code>.
         * </p>
         */
        public final Builder nodes(Map<String, UndeployModelNode> map) {
            this.nodes = _mapPutAll(this.nodes, map);
            return this;
        }

        /**
         *
         * <p>
         * Adds an entry to <code>nodes</code>.
         * </p>
         */
        public final Builder nodes(String key, UndeployModelNode value) {
            this.nodes = _mapPut(this.nodes, key, value);
            return this;
        }

        /**
         *
         * <p>
         * Adds a value to <code>nodes</code> using a builder lambda.
         * </p>
         */
        public final Builder nodes(String key, Function<UndeployModelNode.Builder, ObjectBuilder<UndeployModelNode>> fn) {
            return nodes(key, fn.apply(new UndeployModelNode.Builder()).build());
        }

        /**
         * Builds a {@link UndeployModelResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public UndeployModelResponse build() {
            _checkSingleUse();

            return new UndeployModelResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link UndeployModelResponse}
     */
    public static final JsonpDeserializer<UndeployModelResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        UndeployModelResponse::setupUndeployModelResponseDeserializer
    );

    protected static void setupUndeployModelResponseDeserializer(ObjectDeserializer<UndeployModelResponse.Builder> op) {
        op.setUnknownFieldHandler((builder, name, parser, mapper) -> {
            if (builder.nodes == null) {
                builder.nodes = new HashMap<>();
            }
            builder.nodes.put(name, UndeployModelNode._DESERIALIZER.deserialize(parser, mapper));
        });
    }

    public int hashCode() {
        int result = 17;
        result = 31 * result + (nodes != null ? this.nodes.hashCode() : 0);
        return result;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (this.getClass() != o.getClass()) return false;
        UndeployModelResponse other = (UndeployModelResponse) o;
        if (!this.nodes().equals(other.nodes())) {
            return false;
        }
        return true;
    }
}
