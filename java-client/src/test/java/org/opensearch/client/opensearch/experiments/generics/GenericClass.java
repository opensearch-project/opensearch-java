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

package org.opensearch.client.opensearch.experiments.generics;

import jakarta.json.stream.JsonGenerator;
import java.util.function.Supplier;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.JsonpSerializable;
import org.opensearch.client.json.JsonpSerializer;
import org.opensearch.client.json.JsonpUtils;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ObjectBuilder;

public class GenericClass<GenParam> implements JsonpSerializable {

    // Serializers for generic parameters
    private final JsonpSerializer<GenParam> genParamSerializer;

    // Properties
    private final GenParam genParam;

    protected GenericClass(Builder<GenParam> builder) {
        this.genParamSerializer = builder.genParamSerializer;
        this.genParam = builder.genParam;
    }

    public GenParam genParam() {
        return this.genParam;
    }

    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        generator.writeKey("genParam");
        JsonpUtils.serialize(genParam, generator, genParamSerializer, mapper);
        generator.writeEnd();
    }

    public static class Builder<GenParam> implements ObjectBuilder<GenericClass<GenParam>> {
        private GenParam genParam;
        private JsonpSerializer<GenParam> genParamSerializer;

        /**
         * Sets the JSON serializer for {@link GenParam} values. If not set, the client will try to find a suitable
         * serializer in the {@link JsonpMapper} and will fail if none is found.
         */
        // Internal generic parameters always call this method to avoid runtime lookup
        public Builder<GenParam> genParamSerializer(JsonpSerializer<GenParam> value) {
            this.genParamSerializer = value;
            return this;
        }

        public Builder<GenParam> genParam(GenParam value) {
            this.genParam = value;
            return this;
        }

        @Override
        public GenericClass<GenParam> build() {
            return null;
        }
    }

    public static <GenParam> JsonpDeserializer<GenericClass<GenParam>> parser(
        // A deserializer for each generic parameter
        JsonpDeserializer<GenParam> getParamDeserializer
    ) {

        return ObjectBuilderDeserializer.createForObject(
            (Supplier<Builder<GenParam>>) Builder::new,
            (op) -> GenericClass.setupParser(op, getParamDeserializer)
        );
    }

    private static <GenParam> void setupParser(ObjectDeserializer<Builder<GenParam>> op, JsonpDeserializer<GenParam> deserializer) {
        op.add(Builder::genParam, deserializer, "genParam");
    }

    public static <GenParam> Endpoint<Boolean, GenericClass<GenParam>, ErrorResponse> endpoint(
        JsonpDeserializer<GenParam> genParamDeserializer
    ) {
        return new SimpleEndpoint<>(
            // Request method
            request -> "GET",

            // Request path
            request -> "/genclass",

            // Request parameters
            SimpleEndpoint.emptyMap(),
            SimpleEndpoint.emptyMap(),
            true,
            GenericClass.parser(genParamDeserializer)
        );
    }

}
