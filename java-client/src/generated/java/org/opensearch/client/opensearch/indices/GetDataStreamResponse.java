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

package org.opensearch.client.opensearch.indices;

import jakarta.json.stream.JsonGenerator;
import java.util.List;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
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

// typedef: indices.get_data_stream.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GetDataStreamResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<GetDataStreamResponse.Builder, GetDataStreamResponse> {

    @Nonnull
    private final List<DataStream> dataStreams;

    // ---------------------------------------------------------------------------------------------

    private GetDataStreamResponse(Builder builder) {
        this.dataStreams = ApiTypeHelper.unmodifiableRequired(builder.dataStreams, this, "dataStreams");
    }

    public static GetDataStreamResponse of(Function<GetDataStreamResponse.Builder, ObjectBuilder<GetDataStreamResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code data_streams}
     */
    @Nonnull
    public final List<DataStream> dataStreams() {
        return this.dataStreams;
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
        generator.writeKey("data_streams");
        generator.writeStartArray();
        for (DataStream item0 : this.dataStreams) {
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
     * Builder for {@link GetDataStreamResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, GetDataStreamResponse> {
        private List<DataStream> dataStreams;

        public Builder() {}

        private Builder(GetDataStreamResponse o) {
            this.dataStreams = _listCopy(o.dataStreams);
        }

        private Builder(Builder o) {
            this.dataStreams = _listCopy(o.dataStreams);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code data_streams}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>dataStreams</code>.
         * </p>
         */
        @Nonnull
        public final Builder dataStreams(List<DataStream> list) {
            this.dataStreams = _listAddAll(this.dataStreams, list);
            return this;
        }

        /**
         * Required - API name: {@code data_streams}
         *
         * <p>
         * Adds one or more values to <code>dataStreams</code>.
         * </p>
         */
        @Nonnull
        public final Builder dataStreams(DataStream value, DataStream... values) {
            this.dataStreams = _listAdd(this.dataStreams, value, values);
            return this;
        }

        /**
         * Required - API name: {@code data_streams}
         *
         * <p>
         * Adds a value to <code>dataStreams</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder dataStreams(Function<DataStream.Builder, ObjectBuilder<DataStream>> fn) {
            return dataStreams(fn.apply(new DataStream.Builder()).build());
        }

        /**
         * Builds a {@link GetDataStreamResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetDataStreamResponse build() {
            _checkSingleUse();

            return new GetDataStreamResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GetDataStreamResponse}
     */
    public static final JsonpDeserializer<GetDataStreamResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GetDataStreamResponse::setupGetDataStreamResponseDeserializer
    );

    protected static void setupGetDataStreamResponseDeserializer(ObjectDeserializer<GetDataStreamResponse.Builder> op) {
        op.add(Builder::dataStreams, JsonpDeserializer.arrayDeserializer(DataStream._DESERIALIZER), "data_streams");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.dataStreams.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetDataStreamResponse other = (GetDataStreamResponse) o;
        return this.dataStreams.equals(other.dataStreams);
    }
}
