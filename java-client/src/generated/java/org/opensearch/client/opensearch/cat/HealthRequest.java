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

package org.opensearch.client.opensearch.cat;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.TimeUnit;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: cat.health.Request

/**
 * Returns a concise representation of the cluster health.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class HealthRequest extends CatRequestBase implements ToCopyableBuilder<HealthRequest.Builder, HealthRequest> {

    @Nullable
    private final TimeUnit time;

    @Nullable
    private final Boolean ts;

    // ---------------------------------------------------------------------------------------------

    private HealthRequest(Builder builder) {
        super(builder);
        this.time = builder.time;
        this.ts = builder.ts;
    }

    public static HealthRequest of(Function<HealthRequest.Builder, ObjectBuilder<HealthRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The unit used to display time values.
     * <p>
     * API name: {@code time}
     * </p>
     */
    @Nullable
    public final TimeUnit time() {
        return this.time;
    }

    /**
     * When <code>true</code>, returns <code>HH:MM:SS</code> and Unix epoch timestamps.
     * <p>
     * API name: {@code ts}
     * </p>
     */
    @Nullable
    public final Boolean ts() {
        return this.ts;
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
     * Builder for {@link HealthRequest}.
     */
    public static class Builder extends CatRequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, HealthRequest> {
        @Nullable
        private TimeUnit time;
        @Nullable
        private Boolean ts;

        public Builder() {}

        private Builder(HealthRequest o) {
            super(o);
            this.time = o.time;
            this.ts = o.ts;
        }

        private Builder(Builder o) {
            super(o);
            this.time = o.time;
            this.ts = o.ts;
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
         * The unit used to display time values.
         * <p>
         * API name: {@code time}
         * </p>
         */
        @Nonnull
        public final Builder time(@Nullable TimeUnit value) {
            this.time = value;
            return this;
        }

        /**
         * When <code>true</code>, returns <code>HH:MM:SS</code> and Unix epoch timestamps.
         * <p>
         * API name: {@code ts}
         * </p>
         */
        @Nonnull
        public final Builder ts(@Nullable Boolean value) {
            this.ts = value;
            return this;
        }

        /**
         * Builds a {@link HealthRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public HealthRequest build() {
            _checkSingleUse();

            return new HealthRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    protected void applyQueryParameters(@Nonnull Map<String, String> params) {
        super.applyQueryParameters(params);
        if (this.time != null) {
            params.put("time", this.time.jsonValue());
        }
        if (this.ts != null) {
            params.put("ts", String.valueOf(this.ts));
        }
    }

    /**
     * Endpoint "{@code cat.health}".
     */
    public static final Endpoint<HealthRequest, HealthResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "GET",
        // Request path
        request -> "/_cat/health",
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap(),
        false,
        HealthResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.time);
        result = 31 * result + Objects.hashCode(this.ts);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        HealthRequest other = (HealthRequest) o;
        return Objects.equals(this.time, other.time) && Objects.equals(this.ts, other.ts);
    }
}
