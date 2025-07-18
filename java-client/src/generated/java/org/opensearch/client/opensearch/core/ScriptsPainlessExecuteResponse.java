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
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _global.scripts_painless_execute.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ScriptsPainlessExecuteResponse<TResult>
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ScriptsPainlessExecuteResponse.Builder<TResult>, ScriptsPainlessExecuteResponse<TResult>> {

    @Nonnull
    private final TResult result;

    @Nullable
    private final JsonpSerializer<TResult> tResultSerializer;

    // ---------------------------------------------------------------------------------------------

    private ScriptsPainlessExecuteResponse(Builder<TResult> builder) {
        this.result = ApiTypeHelper.requireNonNull(builder.result, this, "result");
        this.tResultSerializer = builder.tResultSerializer;
    }

    public static <TResult> ScriptsPainlessExecuteResponse<TResult> of(
        Function<ScriptsPainlessExecuteResponse.Builder<TResult>, ObjectBuilder<ScriptsPainlessExecuteResponse<TResult>>> fn
    ) {
        return fn.apply(new Builder<>()).build();
    }

    /**
     * Required - API name: {@code result}
     */
    @Nonnull
    public final TResult result() {
        return this.result;
    }

    /**
     * Serializer for {@code TResult}. If not set, an attempt will be made to find a serializer from the JSON context.
     */
    @Nullable
    public final JsonpSerializer<TResult> tResultSerializer() {
        return this.tResultSerializer;
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
        generator.writeKey("result");
        JsonpUtils.serialize(this.result, generator, tResultSerializer, mapper);
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    @Nonnull
    public Builder<TResult> toBuilder() {
        return new Builder<>(this);
    }

    @Nonnull
    public static <TResult> Builder builder() {
        return new Builder<>();
    }

    /**
     * Builder for {@link ScriptsPainlessExecuteResponse}.
     */
    public static class Builder<TResult> extends ObjectBuilderBase
        implements
            CopyableBuilder<Builder<TResult>, ScriptsPainlessExecuteResponse<TResult>> {
        private TResult result;
        @Nullable
        private JsonpSerializer<TResult> tResultSerializer;

        public Builder() {}

        private Builder(ScriptsPainlessExecuteResponse<TResult> o) {
            this.result = o.result;
            this.tResultSerializer = o.tResultSerializer;
        }

        private Builder(Builder<TResult> o) {
            this.result = o.result;
            this.tResultSerializer = o.tResultSerializer;
        }

        @Override
        @Nonnull
        public Builder<TResult> copy() {
            return new Builder<>(this);
        }

        /**
         * Required - API name: {@code result}
         */
        @Nonnull
        public final Builder<TResult> result(TResult value) {
            this.result = value;
            return this;
        }

        /**
         * Serializer for {@code TResult}. If not set, an attempt will be made to find a serializer from the JSON context.
         */
        @Nonnull
        public final Builder<TResult> tResultSerializer(@Nullable JsonpSerializer<TResult> value) {
            this.tResultSerializer = value;
            return this;
        }

        /**
         * Builds a {@link ScriptsPainlessExecuteResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ScriptsPainlessExecuteResponse<TResult> build() {
            _checkSingleUse();

            return new ScriptsPainlessExecuteResponse<>(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Create a JSON deserializer for ScriptsPainlessExecuteResponse.
     */
    public static <TResult> JsonpDeserializer<ScriptsPainlessExecuteResponse<TResult>> createScriptsPainlessExecuteResponseDeserializer(
        JsonpDeserializer<TResult> tResultDeserializer
    ) {
        return ObjectBuilderDeserializer.createForObject(
            Builder<TResult>::new,
            op -> ScriptsPainlessExecuteResponse.setupScriptsPainlessExecuteResponseDeserializer(op, tResultDeserializer)
        );
    }

    /**
     * Json deserializer for {@link ScriptsPainlessExecuteResponse} based on named deserializers provided by the calling {@code JsonMapper}.
     */
    public static final JsonpDeserializer<ScriptsPainlessExecuteResponse<Object>> _DESERIALIZER =
        createScriptsPainlessExecuteResponseDeserializer(
            new NamedDeserializer<>("org.opensearch.client:Deserializer:_global.scripts_painless_execute.TResult")
        );

    protected static <TResult> void setupScriptsPainlessExecuteResponseDeserializer(
        ObjectDeserializer<ScriptsPainlessExecuteResponse.Builder<TResult>> op,
        JsonpDeserializer<TResult> tResultDeserializer
    ) {
        op.add(Builder::result, tResultDeserializer, "result");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.result.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ScriptsPainlessExecuteResponse<?> other = (ScriptsPainlessExecuteResponse<?>) o;
        return this.result.equals(other.result);
    }
}
