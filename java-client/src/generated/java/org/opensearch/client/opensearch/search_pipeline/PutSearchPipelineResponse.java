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

package org.opensearch.client.opensearch.search_pipeline;

import jakarta.json.stream.JsonGenerator;
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
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: search_pipeline.put.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class PutSearchPipelineResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<PutSearchPipelineResponse.Builder, PutSearchPipelineResponse> {

    @Nullable
    private final Boolean acknowledged;

    // ---------------------------------------------------------------------------------------------

    private PutSearchPipelineResponse(Builder builder) {
        this.acknowledged = builder.acknowledged;
    }

    public static PutSearchPipelineResponse of(Function<PutSearchPipelineResponse.Builder, ObjectBuilder<PutSearchPipelineResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code acknowledged}
     */
    @Nullable
    public final Boolean acknowledged() {
        return this.acknowledged;
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
        if (this.acknowledged != null) {
            generator.writeKey("acknowledged");
            generator.write(this.acknowledged);
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
     * Builder for {@link PutSearchPipelineResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, PutSearchPipelineResponse> {
        @Nullable
        private Boolean acknowledged;

        public Builder() {}

        private Builder(PutSearchPipelineResponse o) {
            this.acknowledged = o.acknowledged;
        }

        private Builder(Builder o) {
            this.acknowledged = o.acknowledged;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code acknowledged}
         */
        @Nonnull
        public final Builder acknowledged(@Nullable Boolean value) {
            this.acknowledged = value;
            return this;
        }

        /**
         * Builds a {@link PutSearchPipelineResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PutSearchPipelineResponse build() {
            _checkSingleUse();

            return new PutSearchPipelineResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PutSearchPipelineResponse}
     */
    public static final JsonpDeserializer<PutSearchPipelineResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PutSearchPipelineResponse::setupPutSearchPipelineResponseDeserializer
    );

    protected static void setupPutSearchPipelineResponseDeserializer(ObjectDeserializer<PutSearchPipelineResponse.Builder> op) {
        op.add(Builder::acknowledged, JsonpDeserializer.booleanDeserializer(), "acknowledged");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.acknowledged);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PutSearchPipelineResponse other = (PutSearchPipelineResponse) o;
        return Objects.equals(this.acknowledged, other.acknowledged);
    }
}
