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

package org.opensearch.client.opensearch.ism;

import jakarta.json.stream.JsonGenerator;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.json.JsonData;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ism.exists_policy.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ExistsPolicyResponse implements PlainJsonSerializable, ToCopyableBuilder<ExistsPolicyResponse.Builder, ExistsPolicyResponse> {

    @Nonnull
    private final JsonData valueBody;

    // ---------------------------------------------------------------------------------------------

    private ExistsPolicyResponse(Builder builder) {
        this.valueBody = ApiTypeHelper.requireNonNull(builder.valueBody, this, "valueBody");
    }

    public static ExistsPolicyResponse of(Function<ExistsPolicyResponse.Builder, ObjectBuilder<ExistsPolicyResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - Response value.
     */
    @Nonnull
    public final JsonData valueBody() {
        return this.valueBody;
    }

    /**
     * Serialize this value to JSON.
     */
    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        this.valueBody.serialize(generator, mapper);
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
     * Builder for {@link ExistsPolicyResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ExistsPolicyResponse> {
        private JsonData valueBody;

        public Builder() {}

        private Builder(ExistsPolicyResponse o) {
            this.valueBody = o.valueBody;
        }

        private Builder(Builder o) {
            this.valueBody = o.valueBody;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - Response value.
         */
        @Nonnull
        public final Builder valueBody(JsonData value) {
            this.valueBody = value;
            return this;
        }

        /**
         * Builds a {@link ExistsPolicyResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ExistsPolicyResponse build() {
            _checkSingleUse();

            return new ExistsPolicyResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ExistsPolicyResponse}
     */
    public static final JsonpDeserializer<ExistsPolicyResponse> _DESERIALIZER = createExistsPolicyResponseDeserializer();

    protected static JsonpDeserializer<ExistsPolicyResponse> createExistsPolicyResponseDeserializer() {
        JsonpDeserializer<JsonData> valueDeserializer = JsonData._DESERIALIZER;
        return JsonpDeserializer.of(
            valueDeserializer.acceptedEvents(),
            (parser, mapper) -> new Builder().valueBody(valueDeserializer.deserialize(parser, mapper)).build()
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
        ExistsPolicyResponse other = (ExistsPolicyResponse) o;
        return this.valueBody.equals(other.valueBody);
    }
}
