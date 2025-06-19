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
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.JsonpSerializer;
import org.opensearch.client.json.JsonpUtils;
import org.opensearch.client.json.NamedDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _global.get_source.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GetSourceResponse<TDocument>
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<GetSourceResponse.Builder<TDocument>, GetSourceResponse<TDocument>> {

    @Nullable
    private final JsonpSerializer<TDocument> tDocumentSerializer;

    @Nonnull
    private final TDocument valueBody;

    // ---------------------------------------------------------------------------------------------

    private GetSourceResponse(Builder<TDocument> builder) {
        this.tDocumentSerializer = builder.tDocumentSerializer;
        this.valueBody = ApiTypeHelper.requireNonNull(builder.valueBody, this, "valueBody");
    }

    public static <TDocument> GetSourceResponse<TDocument> of(
        Function<GetSourceResponse.Builder<TDocument>, ObjectBuilder<GetSourceResponse<TDocument>>> fn
    ) {
        return fn.apply(new Builder<>()).build();
    }

    /**
     * Serializer for {@code TDocument}. If not set, an attempt will be made to find a serializer from the JSON context.
     */
    @Nullable
    public final JsonpSerializer<TDocument> tDocumentSerializer() {
        return this.tDocumentSerializer;
    }

    /**
     * Required - Response value.
     */
    @Nonnull
    public final TDocument valueBody() {
        return this.valueBody;
    }

    /**
     * Serialize this value to JSON.
     */
    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        JsonpUtils.serialize(this.valueBody, generator, tDocumentSerializer, mapper);
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    @Nonnull
    public Builder<TDocument> toBuilder() {
        return new Builder<>(this);
    }

    @Nonnull
    public static <TDocument> Builder builder() {
        return new Builder<>();
    }

    /**
     * Builder for {@link GetSourceResponse}.
     */
    public static class Builder<TDocument> extends ObjectBuilderBase
        implements
            CopyableBuilder<Builder<TDocument>, GetSourceResponse<TDocument>> {
        @Nullable
        private JsonpSerializer<TDocument> tDocumentSerializer;
        private TDocument valueBody;

        public Builder() {}

        private Builder(GetSourceResponse<TDocument> o) {
            this.tDocumentSerializer = o.tDocumentSerializer;
            this.valueBody = o.valueBody;
        }

        private Builder(Builder<TDocument> o) {
            this.tDocumentSerializer = o.tDocumentSerializer;
            this.valueBody = o.valueBody;
        }

        @Override
        @Nonnull
        public Builder<TDocument> copy() {
            return new Builder<>(this);
        }

        /**
         * Serializer for {@code TDocument}. If not set, an attempt will be made to find a serializer from the JSON context.
         */
        @Nonnull
        public final Builder<TDocument> tDocumentSerializer(@Nullable JsonpSerializer<TDocument> value) {
            this.tDocumentSerializer = value;
            return this;
        }

        /**
         * Required - Response value.
         */
        @Nonnull
        public final Builder<TDocument> valueBody(TDocument value) {
            this.valueBody = value;
            return this;
        }

        /**
         * Builds a {@link GetSourceResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetSourceResponse<TDocument> build() {
            _checkSingleUse();

            return new GetSourceResponse<>(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GetSourceResponse} based on named deserializers provided by the calling {@code JsonMapper}.
     */
    public static final JsonpDeserializer<GetSourceResponse<Object>> _DESERIALIZER = createGetSourceResponseDeserializer(
        new NamedDeserializer<>("org.opensearch.client:Deserializer:_global.get_source.TDocument")
    );

    /**
     * Create a JSON deserializer for GetSourceResponse.
     */
    public static <TDocument> JsonpDeserializer<GetSourceResponse<TDocument>> createGetSourceResponseDeserializer(
        JsonpDeserializer<TDocument> tDocumentDeserializer
    ) {
        JsonpDeserializer<TDocument> valueDeserializer = tDocumentDeserializer;
        return JsonpDeserializer.of(
            valueDeserializer.acceptedEvents(),
            (parser, mapper) -> new Builder<TDocument>().valueBody(valueDeserializer.deserialize(parser, mapper)).build()
        );
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.valueBody.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetSourceResponse<?> other = (GetSourceResponse<?>) o;
        return this.valueBody.equals(other.valueBody);
    }
}
