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
import org.opensearch.client.opensearch.core.get_script_context.Context;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _global.get_script_context.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GetScriptContextResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<GetScriptContextResponse.Builder, GetScriptContextResponse> {

    @Nonnull
    private final List<Context> contexts;

    // ---------------------------------------------------------------------------------------------

    private GetScriptContextResponse(Builder builder) {
        this.contexts = ApiTypeHelper.unmodifiableRequired(builder.contexts, this, "contexts");
    }

    public static GetScriptContextResponse of(Function<GetScriptContextResponse.Builder, ObjectBuilder<GetScriptContextResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code contexts}
     */
    @Nonnull
    public final List<Context> contexts() {
        return this.contexts;
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
        generator.writeKey("contexts");
        generator.writeStartArray();
        for (Context item0 : this.contexts) {
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
     * Builder for {@link GetScriptContextResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, GetScriptContextResponse> {
        private List<Context> contexts;

        public Builder() {}

        private Builder(GetScriptContextResponse o) {
            this.contexts = _listCopy(o.contexts);
        }

        private Builder(Builder o) {
            this.contexts = _listCopy(o.contexts);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code contexts}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>contexts</code>.
         * </p>
         */
        @Nonnull
        public final Builder contexts(List<Context> list) {
            this.contexts = _listAddAll(this.contexts, list);
            return this;
        }

        /**
         * Required - API name: {@code contexts}
         *
         * <p>
         * Adds one or more values to <code>contexts</code>.
         * </p>
         */
        @Nonnull
        public final Builder contexts(Context value, Context... values) {
            this.contexts = _listAdd(this.contexts, value, values);
            return this;
        }

        /**
         * Required - API name: {@code contexts}
         *
         * <p>
         * Adds a value to <code>contexts</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder contexts(Function<Context.Builder, ObjectBuilder<Context>> fn) {
            return contexts(fn.apply(new Context.Builder()).build());
        }

        /**
         * Builds a {@link GetScriptContextResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetScriptContextResponse build() {
            _checkSingleUse();

            return new GetScriptContextResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GetScriptContextResponse}
     */
    public static final JsonpDeserializer<GetScriptContextResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GetScriptContextResponse::setupGetScriptContextResponseDeserializer
    );

    protected static void setupGetScriptContextResponseDeserializer(ObjectDeserializer<GetScriptContextResponse.Builder> op) {
        op.add(Builder::contexts, JsonpDeserializer.arrayDeserializer(Context._DESERIALIZER), "contexts");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.contexts.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetScriptContextResponse other = (GetScriptContextResponse) o;
        return this.contexts.equals(other.contexts);
    }
}
