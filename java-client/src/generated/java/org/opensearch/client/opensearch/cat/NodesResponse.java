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

package org.opensearch.client.opensearch.cat;

import jakarta.json.stream.JsonGenerator;
import java.util.List;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.opensearch.cat.nodes.NodesRecord;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: cat.nodes.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NodesResponse implements PlainJsonSerializable, ToCopyableBuilder<NodesResponse.Builder, NodesResponse> {

    @Nonnull
    private final List<NodesRecord> valueBody;

    // ---------------------------------------------------------------------------------------------

    private NodesResponse(Builder builder) {
        this.valueBody = ApiTypeHelper.unmodifiableRequired(builder.valueBody, this, "valueBody");
    }

    public static NodesResponse of(Function<NodesResponse.Builder, ObjectBuilder<NodesResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - Response value.
     */
    @Nonnull
    public final List<NodesRecord> valueBody() {
        return this.valueBody;
    }

    /**
     * Serialize this value to JSON.
     */
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartArray();
        for (NodesRecord item0 : this.valueBody) {
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
     * Builder for {@link NodesResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, NodesResponse> {
        private List<NodesRecord> valueBody;

        public Builder() {}

        private Builder(NodesResponse o) {
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
        public final Builder valueBody(List<NodesRecord> list) {
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
        public final Builder valueBody(NodesRecord value, NodesRecord... values) {
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
        public final Builder valueBody(Function<NodesRecord.Builder, ObjectBuilder<NodesRecord>> fn) {
            return valueBody(fn.apply(new NodesRecord.Builder()).build());
        }

        /**
         * Builds a {@link NodesResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NodesResponse build() {
            _checkSingleUse();

            return new NodesResponse(this);
        }
    }

    public static final JsonpDeserializer<NodesResponse> _DESERIALIZER = createNodesResponseDeserializer();

    protected static JsonpDeserializer<NodesResponse> createNodesResponseDeserializer() {
        JsonpDeserializer<List<NodesRecord>> valueDeserializer = JsonpDeserializer.arrayDeserializer(NodesRecord._DESERIALIZER);

        return JsonpDeserializer.of(
            valueDeserializer.acceptedEvents(),
            (parser, mapper) -> new Builder().valueBody(valueDeserializer.deserialize(parser, mapper)).build()
        );
    }
}
