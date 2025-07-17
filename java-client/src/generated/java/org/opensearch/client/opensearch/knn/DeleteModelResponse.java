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

package org.opensearch.client.opensearch.knn;

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

// typedef: knn.delete_model.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class DeleteModelResponse implements PlainJsonSerializable, ToCopyableBuilder<DeleteModelResponse.Builder, DeleteModelResponse> {

    @Nonnull
    private final String modelId;

    @Nonnull
    private final DeletionResult result;

    // ---------------------------------------------------------------------------------------------

    private DeleteModelResponse(Builder builder) {
        this.modelId = ApiTypeHelper.requireNonNull(builder.modelId, this, "modelId");
        this.result = ApiTypeHelper.requireNonNull(builder.result, this, "result");
    }

    public static DeleteModelResponse of(Function<DeleteModelResponse.Builder, ObjectBuilder<DeleteModelResponse>> fn) {
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
     * Required - API name: {@code result}
     */
    @Nonnull
    public final DeletionResult result() {
        return this.result;
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

        generator.writeKey("result");
        this.result.serialize(generator, mapper);
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
     * Builder for {@link DeleteModelResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, DeleteModelResponse> {
        private String modelId;
        private DeletionResult result;

        public Builder() {}

        private Builder(DeleteModelResponse o) {
            this.modelId = o.modelId;
            this.result = o.result;
        }

        private Builder(Builder o) {
            this.modelId = o.modelId;
            this.result = o.result;
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
         * Required - API name: {@code result}
         */
        @Nonnull
        public final Builder result(DeletionResult value) {
            this.result = value;
            return this;
        }

        /**
         * Builds a {@link DeleteModelResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DeleteModelResponse build() {
            _checkSingleUse();

            return new DeleteModelResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link DeleteModelResponse}
     */
    public static final JsonpDeserializer<DeleteModelResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        DeleteModelResponse::setupDeleteModelResponseDeserializer
    );

    protected static void setupDeleteModelResponseDeserializer(ObjectDeserializer<DeleteModelResponse.Builder> op) {
        op.add(Builder::modelId, JsonpDeserializer.stringDeserializer(), "model_id");
        op.add(Builder::result, DeletionResult._DESERIALIZER, "result");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.modelId.hashCode();
        result = 31 * result + this.result.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        DeleteModelResponse other = (DeleteModelResponse) o;
        return this.modelId.equals(other.modelId) && this.result.equals(other.result);
    }
}
