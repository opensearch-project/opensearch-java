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

// typedef: search_pipeline.MLOpenSearchReranker

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class MLOpenSearchReranker implements PlainJsonSerializable, ToCopyableBuilder<MLOpenSearchReranker.Builder, MLOpenSearchReranker> {

    @Nonnull
    private final String modelId;

    // ---------------------------------------------------------------------------------------------

    private MLOpenSearchReranker(Builder builder) {
        this.modelId = ApiTypeHelper.requireNonNull(builder.modelId, this, "modelId");
    }

    public static MLOpenSearchReranker of(Function<MLOpenSearchReranker.Builder, ObjectBuilder<MLOpenSearchReranker>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code model_id}
     */
    @Nonnull
    public final String modelId() {
        return this.modelId;
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
        generator.writeKey("model_id");
        generator.write(this.modelId);
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
     * Builder for {@link MLOpenSearchReranker}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, MLOpenSearchReranker> {
        private String modelId;

        public Builder() {}

        private Builder(MLOpenSearchReranker o) {
            this.modelId = o.modelId;
        }

        private Builder(Builder o) {
            this.modelId = o.modelId;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code model_id}
         */
        @Nonnull
        public final Builder modelId(String value) {
            this.modelId = value;
            return this;
        }

        /**
         * Builds a {@link MLOpenSearchReranker}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public MLOpenSearchReranker build() {
            _checkSingleUse();

            return new MLOpenSearchReranker(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link MLOpenSearchReranker}
     */
    public static final JsonpDeserializer<MLOpenSearchReranker> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        MLOpenSearchReranker::setupMLOpenSearchRerankerDeserializer
    );

    protected static void setupMLOpenSearchRerankerDeserializer(ObjectDeserializer<MLOpenSearchReranker.Builder> op) {
        op.add(Builder::modelId, JsonpDeserializer.stringDeserializer(), "model_id");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.modelId.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        MLOpenSearchReranker other = (MLOpenSearchReranker) o;
        return this.modelId.equals(other.modelId);
    }
}
