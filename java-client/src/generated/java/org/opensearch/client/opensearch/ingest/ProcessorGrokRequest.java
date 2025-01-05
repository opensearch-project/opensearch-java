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

package org.opensearch.client.opensearch.ingest;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ingest.processor_grok.Request

/**
 * Returns a list of the built-in patterns.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ProcessorGrokRequest extends RequestBase implements ToCopyableBuilder<ProcessorGrokRequest.Builder, ProcessorGrokRequest> {

    @Nullable
    private final Boolean s;

    // ---------------------------------------------------------------------------------------------

    private ProcessorGrokRequest(Builder builder) {
        this.s = builder.s;
    }

    public static ProcessorGrokRequest of(Function<ProcessorGrokRequest.Builder, ObjectBuilder<ProcessorGrokRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Sort returned patterns by key name.
     * <p>
     * API name: {@code s}
     * </p>
     */
    @Nullable
    public final Boolean s() {
        return this.s;
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
     * Builder for {@link ProcessorGrokRequest}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ProcessorGrokRequest> {
        @Nullable
        private Boolean s;

        public Builder() {}

        private Builder(ProcessorGrokRequest o) {
            this.s = o.s;
        }

        private Builder(Builder o) {
            this.s = o.s;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Sort returned patterns by key name.
         * <p>
         * API name: {@code s}
         * </p>
         */
        @Nonnull
        public final Builder s(@Nullable Boolean value) {
            this.s = value;
            return this;
        }

        /**
         * Builds a {@link ProcessorGrokRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ProcessorGrokRequest build() {
            _checkSingleUse();

            return new ProcessorGrokRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code ingest.processor_grok}".
     */
    public static final Endpoint<ProcessorGrokRequest, ProcessorGrokResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "GET",
        // Request path
        request -> "/_ingest/processor/grok",
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            if (request.s != null) {
                params.put("s", String.valueOf(request.s));
            }
            return params;
        },
        SimpleEndpoint.emptyMap(),
        false,
        ProcessorGrokResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.s);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ProcessorGrokRequest other = (ProcessorGrokRequest) o;
        return Objects.equals(this.s, other.s);
    }
}
