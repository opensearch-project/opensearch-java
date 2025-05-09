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
import java.util.HashMap;
import java.util.Map;
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
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.InlineScript;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.opensearch.core.scripts_painless_execute.PainlessContextSetup;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _global.scripts_painless_execute.Request

/**
 * Allows an arbitrary script to be executed and a result to be returned.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class ScriptsPainlessExecuteRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ScriptsPainlessExecuteRequest.Builder, ScriptsPainlessExecuteRequest> {

    @Nullable
    private final String context;

    @Nullable
    private final PainlessContextSetup contextSetup;

    @Nullable
    private final InlineScript script;

    // ---------------------------------------------------------------------------------------------

    private ScriptsPainlessExecuteRequest(Builder builder) {
        super(builder);
        this.context = builder.context;
        this.contextSetup = builder.contextSetup;
        this.script = builder.script;
    }

    public static ScriptsPainlessExecuteRequest of(
        Function<ScriptsPainlessExecuteRequest.Builder, ObjectBuilder<ScriptsPainlessExecuteRequest>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The context that the script should run in.
     * <p>
     * API name: {@code context}
     * </p>
     */
    @Nullable
    public final String context() {
        return this.context;
    }

    /**
     * API name: {@code context_setup}
     */
    @Nullable
    public final PainlessContextSetup contextSetup() {
        return this.contextSetup;
    }

    /**
     * API name: {@code script}
     */
    @Nullable
    public final InlineScript script() {
        return this.script;
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
        if (this.context != null) {
            generator.writeKey("context");
            generator.write(this.context);
        }

        if (this.contextSetup != null) {
            generator.writeKey("context_setup");
            this.contextSetup.serialize(generator, mapper);
        }

        if (this.script != null) {
            generator.writeKey("script");
            this.script.serialize(generator, mapper);
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
     * Builder for {@link ScriptsPainlessExecuteRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, ScriptsPainlessExecuteRequest> {
        @Nullable
        private String context;
        @Nullable
        private PainlessContextSetup contextSetup;
        @Nullable
        private InlineScript script;

        public Builder() {}

        private Builder(ScriptsPainlessExecuteRequest o) {
            super(o);
            this.context = o.context;
            this.contextSetup = o.contextSetup;
            this.script = o.script;
        }

        private Builder(Builder o) {
            super(o);
            this.context = o.context;
            this.contextSetup = o.contextSetup;
            this.script = o.script;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        @Override
        @Nonnull
        protected Builder self() {
            return this;
        }

        /**
         * The context that the script should run in.
         * <p>
         * API name: {@code context}
         * </p>
         */
        @Nonnull
        public final Builder context(@Nullable String value) {
            this.context = value;
            return this;
        }

        /**
         * API name: {@code context_setup}
         */
        @Nonnull
        public final Builder contextSetup(@Nullable PainlessContextSetup value) {
            this.contextSetup = value;
            return this;
        }

        /**
         * API name: {@code context_setup}
         */
        @Nonnull
        public final Builder contextSetup(Function<PainlessContextSetup.Builder, ObjectBuilder<PainlessContextSetup>> fn) {
            return contextSetup(fn.apply(new PainlessContextSetup.Builder()).build());
        }

        /**
         * API name: {@code script}
         */
        @Nonnull
        public final Builder script(@Nullable InlineScript value) {
            this.script = value;
            return this;
        }

        /**
         * API name: {@code script}
         */
        @Nonnull
        public final Builder script(Function<InlineScript.Builder, ObjectBuilder<InlineScript>> fn) {
            return script(fn.apply(new InlineScript.Builder()).build());
        }

        /**
         * Builds a {@link ScriptsPainlessExecuteRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ScriptsPainlessExecuteRequest build() {
            _checkSingleUse();

            return new ScriptsPainlessExecuteRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ScriptsPainlessExecuteRequest}
     */
    public static final JsonpDeserializer<ScriptsPainlessExecuteRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ScriptsPainlessExecuteRequest::setupScriptsPainlessExecuteRequestDeserializer
    );

    protected static void setupScriptsPainlessExecuteRequestDeserializer(ObjectDeserializer<ScriptsPainlessExecuteRequest.Builder> op) {
        op.add(Builder::context, JsonpDeserializer.stringDeserializer(), "context");
        op.add(Builder::contextSetup, PainlessContextSetup._DESERIALIZER, "context_setup");
        op.add(Builder::script, InlineScript._DESERIALIZER, "script");
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code scripts_painless_execute}".
     */
    public static final SimpleEndpoint<ScriptsPainlessExecuteRequest, ?> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "POST",
        // Request path
        request -> "/_scripts/painless/_execute",
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap(),
        true,
        ScriptsPainlessExecuteResponse._DESERIALIZER
    );

    /**
     * Create an "{@code scripts_painless_execute}" endpoint.
     */
    public static <
        TResult>
        Endpoint<ScriptsPainlessExecuteRequest, ScriptsPainlessExecuteResponse<TResult>, ErrorResponse>
        createScriptsPainlessExecuteEndpoint(JsonpDeserializer<TResult> tResultDeserializer) {
        return _ENDPOINT.withResponseDeserializer(
            ScriptsPainlessExecuteResponse.createScriptsPainlessExecuteResponseDeserializer(tResultDeserializer)
        );
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.context);
        result = 31 * result + Objects.hashCode(this.contextSetup);
        result = 31 * result + Objects.hashCode(this.script);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ScriptsPainlessExecuteRequest other = (ScriptsPainlessExecuteRequest) o;
        return Objects.equals(this.context, other.context)
            && Objects.equals(this.contextSetup, other.contextSetup)
            && Objects.equals(this.script, other.script);
    }
}
