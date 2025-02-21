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
import java.util.Map;
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

// typedef: ml.get_profile_models.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GetProfileModelsResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<GetProfileModelsResponse.Builder, GetProfileModelsResponse> {

    @Nonnull
    private final Map<String, Node> nodes;

    // ---------------------------------------------------------------------------------------------

    private GetProfileModelsResponse(Builder builder) {
        this.nodes = ApiTypeHelper.unmodifiable(builder.nodes);
    }

    public static GetProfileModelsResponse of(Function<GetProfileModelsResponse.Builder, ObjectBuilder<GetProfileModelsResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code nodes}
     */
    @Nonnull
    public final Map<String, Node> nodes() {
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
        if (ApiTypeHelper.isDefined(this.nodes)) {
            generator.writeKey("nodes");
            generator.writeStartObject();
            for (Map.Entry<String, Node> item0 : this.nodes.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
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
     * Builder for {@link GetProfileModelsResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, GetProfileModelsResponse> {
        @Nullable
        private Map<String, Node> nodes;

        public Builder() {}

        private Builder(GetProfileModelsResponse o) {
            this.nodes = _mapCopy(o.nodes);
        }

        private Builder(Builder o) {
            this.nodes = _mapCopy(o.nodes);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code nodes}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>nodes</code>.
         * </p>
         */
        @Nonnull
        public final Builder nodes(Map<String, Node> map) {
            this.nodes = _mapPutAll(this.nodes, map);
            return this;
        }

        /**
         * API name: {@code nodes}
         *
         * <p>
         * Adds an entry to <code>nodes</code>.
         * </p>
         */
        @Nonnull
        public final Builder nodes(String key, Node value) {
            this.nodes = _mapPut(this.nodes, key, value);
            return this;
        }

        /**
         * API name: {@code nodes}
         *
         * <p>
         * Adds a value to <code>nodes</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder nodes(String key, Function<Node.Builder, ObjectBuilder<Node>> fn) {
            return nodes(key, fn.apply(new Node.Builder()).build());
        }

        /**
         * Builds a {@link GetProfileModelsResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetProfileModelsResponse build() {
            _checkSingleUse();

            return new GetProfileModelsResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GetProfileModelsResponse}
     */
    public static final JsonpDeserializer<GetProfileModelsResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GetProfileModelsResponse::setupGetProfileModelsResponseDeserializer
    );

    protected static void setupGetProfileModelsResponseDeserializer(ObjectDeserializer<GetProfileModelsResponse.Builder> op) {
        op.add(Builder::nodes, JsonpDeserializer.stringMapDeserializer(Node._DESERIALIZER), "nodes");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.nodes);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetProfileModelsResponse other = (GetProfileModelsResponse) o;
        return Objects.equals(this.nodes, other.nodes);
    }
}
