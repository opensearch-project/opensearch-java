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

package org.opensearch.client.opensearch._types;

import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: _types.RequestBase

public abstract class RequestBase {
    @Nullable
    private final Boolean errorTrace;
    @Nullable
    private final Boolean human;

    // TODO: Remove once all request classes are generated
    protected RequestBase() {
        this.errorTrace = null;
        this.human = null;
    }

    protected RequestBase(AbstractBuilder<?> builder) {
        this.errorTrace = builder.errorTrace;
        this.human = builder.human;
    }

    /**
     * Whether to include the stack trace of returned errors.
     * <p>
     * API name: {@code error_trace}
     * </p>
     */
    @Nullable
    public Boolean errorTrace() {
        return this.errorTrace;
    }

    /**
     * Whether to return human readable values for statistics.
     * <p>
     * API name: {@code human}
     * </p>
     */
    @Nullable
    public Boolean human() {
        return this.human;
    }

    public abstract static class AbstractBuilder<BuilderT extends AbstractBuilder<BuilderT>> extends ObjectBuilderBase {
        @Nullable
        private Boolean errorTrace;
        @Nullable
        private Boolean human;

        protected AbstractBuilder() {}

        protected AbstractBuilder(RequestBase o) {
            this.errorTrace = o.errorTrace;
            this.human = o.human;
        }

        protected AbstractBuilder(AbstractBuilder<BuilderT> o) {
            this.errorTrace = o.errorTrace;
            this.human = o.human;
        }

        @Nonnull
        protected abstract BuilderT self();

        /**
         * Whether to include the stack trace of returned errors.
         * <p>
         * API name: {@code error_trace}
         * </p>
         */
        @Nonnull
        public BuilderT errorTrace(@Nullable Boolean value) {
            this.errorTrace = value;
            return self();
        }

        /**
         * Whether to return human readable values for statistics.
         * <p>
         * API name: {@code human}
         * </p>
         */
        @Nonnull
        public BuilderT human(@Nullable Boolean value) {
            this.human = value;
            return self();
        }
    }

    protected void applyQueryParameters(@Nonnull Map<String, String> params) {
        if (errorTrace != null) {
            params.put("error_trace", String.valueOf(errorTrace));
        }
        if (human != null) {
            params.put("human", String.valueOf(human));
        }
    }
}
