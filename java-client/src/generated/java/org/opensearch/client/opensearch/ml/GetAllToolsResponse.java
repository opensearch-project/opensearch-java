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
import java.util.List;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ml.get_all_tools.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GetAllToolsResponse implements PlainJsonSerializable, ToCopyableBuilder<GetAllToolsResponse.Builder, GetAllToolsResponse> {

    @Nonnull
    private final List<Tool> valueBody;

    // ---------------------------------------------------------------------------------------------

    private GetAllToolsResponse(Builder builder) {
        this.valueBody = ApiTypeHelper.unmodifiableRequired(builder.valueBody, this, "valueBody");
    }

    public static GetAllToolsResponse of(Function<GetAllToolsResponse.Builder, ObjectBuilder<GetAllToolsResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - Response value.
     */
    @Nonnull
    public final List<Tool> valueBody() {
        return this.valueBody;
    }

    /**
     * Serialize this value to JSON.
     */
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartArray();
        for (Tool item0 : this.valueBody) {
            item0.serialize(generator, mapper);
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
     * Builder for {@link GetAllToolsResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, GetAllToolsResponse> {
        private List<Tool> valueBody;

        public Builder() {}

        private Builder(GetAllToolsResponse o) {
            this.valueBody = _listCopy(o.valueBody);
        }

        private Builder(Builder o) {
            this.valueBody = _listCopy(o.valueBody);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - Response value.
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>valueBody</code>.
         * </p>
         */
        @Nonnull
        public final Builder valueBody(List<Tool> list) {
            this.valueBody = _listAddAll(this.valueBody, list);
            return this;
        }

        /**
         * Required - Response value.
         *
         * <p>
         * Adds one or more values to <code>valueBody</code>.
         * </p>
         */
        @Nonnull
        public final Builder valueBody(Tool value, Tool... values) {
            this.valueBody = _listAdd(this.valueBody, value, values);
            return this;
        }

        /**
         * Required - Response value.
         *
         * <p>
         * Adds a value to <code>valueBody</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder valueBody(Function<Tool.Builder, ObjectBuilder<Tool>> fn) {
            return valueBody(fn.apply(new Tool.Builder()).build());
        }

        /**
         * Builds a {@link GetAllToolsResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetAllToolsResponse build() {
            _checkSingleUse();

            return new GetAllToolsResponse(this);
        }
    }

    public static final JsonpDeserializer<GetAllToolsResponse> _DESERIALIZER = createGetAllToolsResponseDeserializer();

    protected static JsonpDeserializer<GetAllToolsResponse> createGetAllToolsResponseDeserializer() {
        JsonpDeserializer<List<Tool>> valueDeserializer = JsonpDeserializer.arrayDeserializer(Tool._DESERIALIZER);

        return JsonpDeserializer.of(
            valueDeserializer.acceptedEvents(),
            (parser, mapper) -> new Builder().valueBody(valueDeserializer.deserialize(parser, mapper)).build()
        );
    }
}
