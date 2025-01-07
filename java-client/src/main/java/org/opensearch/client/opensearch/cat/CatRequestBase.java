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

package org.opensearch.client.opensearch.cat;

import java.util.List;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.util.ApiTypeHelper;

// typedef: cat._types.CatRequestBase

public abstract class CatRequestBase extends RequestBase {
    @Nonnull
    private final List<String> headers;
    @Nonnull
    private final List<String> sort;

    // TODO: remove me once all cat operations are generated
    protected CatRequestBase() {
        this.headers = ApiTypeHelper.undefinedList();
        this.sort = ApiTypeHelper.undefinedList();
    }

    protected CatRequestBase(AbstractBuilder<?> builder) {
        super(builder);
        this.headers = ApiTypeHelper.unmodifiable(builder.headers);
        this.sort = ApiTypeHelper.unmodifiable(builder.sort);
    }

    /**
     * A comma-separated list of headers to limit the returned information
     * <p>
     * API name: {@code h}
     */
    @Nonnull
    public final List<String> headers() {
        return this.headers;
    }

    /**
     * A comma-separated list of headers to sort the returned information
     * <p>
     * API name: {@code s}
     * <p>
     */
    @Nonnull
    public final List<String> sort() {
        return this.sort;
    }

    protected abstract static class AbstractBuilder<BuilderT extends AbstractBuilder<BuilderT>> extends RequestBase.AbstractBuilder<
        BuilderT> {
        @Nullable
        protected List<String> headers;
        @Nullable
        protected List<String> sort;

        protected AbstractBuilder() {}

        protected AbstractBuilder(CatRequestBase o) {
            super(o);
            this.headers = _listCopy(o.headers);
            this.sort = _listCopy(o.sort);
        }

        protected AbstractBuilder(AbstractBuilder<BuilderT> o) {
            super(o);
            this.headers = _listCopy(o.headers);
            this.sort = _listCopy(o.sort);
        }

        /**
         * A comma-separated list of specific headers to limits the output
         * <p>
         * API name: {@code h}
         * <p>
         */
        @Nonnull
        public final BuilderT headers(List<String> values) {
            this.headers = _listAddAll(this.headers, values);
            return self();
        }

        /**
         * A comma-separated list of specific headers to limits the output
         * <p>
         * API name: {@code h}
         * <p>
         */
        @Nonnull
        public final BuilderT headers(String value, String... values) {
            this.headers = _listAdd(this.headers, value, values);
            return self();
        }

        /**
         * A comma-separated list of headers to sort the returned information
         * <p>
         * API name: {@code s}
         * <p>
         */
        @Nonnull
        public final BuilderT sort(List<String> values) {
            this.sort = _listAddAll(this.sort, values);
            return self();
        }

        /**
         * A comma-separated list of headers to sort the returned information
         * <p>
         * API name: {@code s}
         * <p>
         */
        @Nonnull
        public final BuilderT sort(String value, String... values) {
            this.sort = _listAdd(this.sort, value, values);
            return self();
        }
    }

    @Override
    protected void applyQueryParameters(@Nonnull Map<String, String> params) {
        super.applyQueryParameters(params);
        if (ApiTypeHelper.isDefined(headers)) {
            params.put("h", String.join(",", headers));
        }
        if (ApiTypeHelper.isDefined(sort)) {
            params.put("s", String.join(",", sort));
        }
        params.put("format", "json");
    }
}
