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

package org.opensearch.client.opensearch.indices;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.ExpandWildcard;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: indices.forcemerge.Request

/**
 * Performs the force merge operation on one or more indexes.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ForcemergeRequest extends RequestBase implements ToCopyableBuilder<ForcemergeRequest.Builder, ForcemergeRequest> {

    @Nullable
    private final Boolean allowNoIndices;

    @Nonnull
    private final List<ExpandWildcard> expandWildcards;

    @Nullable
    private final Boolean flush;

    @Nullable
    private final Boolean ignoreUnavailable;

    @Nonnull
    private final List<String> index;

    @Nullable
    private final Long maxNumSegments;

    @Nullable
    private final Boolean onlyExpungeDeletes;

    @Nullable
    private final Boolean primaryOnly;

    @Nullable
    private final Boolean waitForCompletion;

    // ---------------------------------------------------------------------------------------------

    private ForcemergeRequest(Builder builder) {
        this.allowNoIndices = builder.allowNoIndices;
        this.expandWildcards = ApiTypeHelper.unmodifiable(builder.expandWildcards);
        this.flush = builder.flush;
        this.ignoreUnavailable = builder.ignoreUnavailable;
        this.index = ApiTypeHelper.unmodifiable(builder.index);
        this.maxNumSegments = builder.maxNumSegments;
        this.onlyExpungeDeletes = builder.onlyExpungeDeletes;
        this.primaryOnly = builder.primaryOnly;
        this.waitForCompletion = builder.waitForCompletion;
    }

    public static ForcemergeRequest of(Function<ForcemergeRequest.Builder, ObjectBuilder<ForcemergeRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Whether to ignore if a wildcard indexes expression resolves into no concrete indexes. (This includes <code>_all</code> string or when
     * no indexes have been specified)
     * <p>
     * API name: {@code allow_no_indices}
     * </p>
     */
    @Nullable
    public final Boolean allowNoIndices() {
        return this.allowNoIndices;
    }

    /**
     * Whether to expand wildcard expression to concrete indexes that are open, closed or both.
     * <p>
     * API name: {@code expand_wildcards}
     * </p>
     */
    @Nonnull
    public final List<ExpandWildcard> expandWildcards() {
        return this.expandWildcards;
    }

    /**
     * Specify whether the index should be flushed after performing the operation.
     * <p>
     * API name: {@code flush}
     * </p>
     */
    @Nullable
    public final Boolean flush() {
        return this.flush;
    }

    /**
     * Whether specified concrete indexes should be ignored when unavailable (missing or closed)
     * <p>
     * API name: {@code ignore_unavailable}
     * </p>
     */
    @Nullable
    public final Boolean ignoreUnavailable() {
        return this.ignoreUnavailable;
    }

    /**
     * A comma-separated list of index names; use <code>_all</code> or empty string to perform the operation on all indexes
     * <p>
     * API name: {@code index}
     * </p>
     */
    @Nonnull
    public final List<String> index() {
        return this.index;
    }

    /**
     * The number of larger segments into which smaller segments are merged. Set this parameter to 1 to merge all segments into one segment.
     * The default behavior is to perform the merge as necessary.
     * <p>
     * API name: {@code max_num_segments}
     * </p>
     */
    @Nullable
    public final Long maxNumSegments() {
        return this.maxNumSegments;
    }

    /**
     * Specify whether the operation should only expunge deleted documents
     * <p>
     * API name: {@code only_expunge_deletes}
     * </p>
     */
    @Nullable
    public final Boolean onlyExpungeDeletes() {
        return this.onlyExpungeDeletes;
    }

    /**
     * Specify whether the operation should only perform on primary shards. Defaults to false.
     * <p>
     * API name: {@code primary_only}
     * </p>
     */
    @Nullable
    public final Boolean primaryOnly() {
        return this.primaryOnly;
    }

    /**
     * Should the request wait until the force merge is completed.
     * <p>
     * API name: {@code wait_for_completion}
     * </p>
     */
    @Nullable
    public final Boolean waitForCompletion() {
        return this.waitForCompletion;
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
     * Builder for {@link ForcemergeRequest}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ForcemergeRequest> {
        @Nullable
        private Boolean allowNoIndices;
        @Nullable
        private List<ExpandWildcard> expandWildcards;
        @Nullable
        private Boolean flush;
        @Nullable
        private Boolean ignoreUnavailable;
        @Nullable
        private List<String> index;
        @Nullable
        private Long maxNumSegments;
        @Nullable
        private Boolean onlyExpungeDeletes;
        @Nullable
        private Boolean primaryOnly;
        @Nullable
        private Boolean waitForCompletion;

        public Builder() {}

        private Builder(ForcemergeRequest o) {
            this.allowNoIndices = o.allowNoIndices;
            this.expandWildcards = _listCopy(o.expandWildcards);
            this.flush = o.flush;
            this.ignoreUnavailable = o.ignoreUnavailable;
            this.index = _listCopy(o.index);
            this.maxNumSegments = o.maxNumSegments;
            this.onlyExpungeDeletes = o.onlyExpungeDeletes;
            this.primaryOnly = o.primaryOnly;
            this.waitForCompletion = o.waitForCompletion;
        }

        private Builder(Builder o) {
            this.allowNoIndices = o.allowNoIndices;
            this.expandWildcards = _listCopy(o.expandWildcards);
            this.flush = o.flush;
            this.ignoreUnavailable = o.ignoreUnavailable;
            this.index = _listCopy(o.index);
            this.maxNumSegments = o.maxNumSegments;
            this.onlyExpungeDeletes = o.onlyExpungeDeletes;
            this.primaryOnly = o.primaryOnly;
            this.waitForCompletion = o.waitForCompletion;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Whether to ignore if a wildcard indexes expression resolves into no concrete indexes. (This includes <code>_all</code> string or
         * when no indexes have been specified)
         * <p>
         * API name: {@code allow_no_indices}
         * </p>
         */
        @Nonnull
        public final Builder allowNoIndices(@Nullable Boolean value) {
            this.allowNoIndices = value;
            return this;
        }

        /**
         * Whether to expand wildcard expression to concrete indexes that are open, closed or both.
         * <p>
         * API name: {@code expand_wildcards}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>expandWildcards</code>.
         * </p>
         */
        @Nonnull
        public final Builder expandWildcards(List<ExpandWildcard> list) {
            this.expandWildcards = _listAddAll(this.expandWildcards, list);
            return this;
        }

        /**
         * Whether to expand wildcard expression to concrete indexes that are open, closed or both.
         * <p>
         * API name: {@code expand_wildcards}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>expandWildcards</code>.
         * </p>
         */
        @Nonnull
        public final Builder expandWildcards(ExpandWildcard value, ExpandWildcard... values) {
            this.expandWildcards = _listAdd(this.expandWildcards, value, values);
            return this;
        }

        /**
         * Specify whether the index should be flushed after performing the operation.
         * <p>
         * API name: {@code flush}
         * </p>
         */
        @Nonnull
        public final Builder flush(@Nullable Boolean value) {
            this.flush = value;
            return this;
        }

        /**
         * Whether specified concrete indexes should be ignored when unavailable (missing or closed)
         * <p>
         * API name: {@code ignore_unavailable}
         * </p>
         */
        @Nonnull
        public final Builder ignoreUnavailable(@Nullable Boolean value) {
            this.ignoreUnavailable = value;
            return this;
        }

        /**
         * A comma-separated list of index names; use <code>_all</code> or empty string to perform the operation on all indexes
         * <p>
         * API name: {@code index}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>index</code>.
         * </p>
         */
        @Nonnull
        public final Builder index(List<String> list) {
            this.index = _listAddAll(this.index, list);
            return this;
        }

        /**
         * A comma-separated list of index names; use <code>_all</code> or empty string to perform the operation on all indexes
         * <p>
         * API name: {@code index}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>index</code>.
         * </p>
         */
        @Nonnull
        public final Builder index(String value, String... values) {
            this.index = _listAdd(this.index, value, values);
            return this;
        }

        /**
         * The number of larger segments into which smaller segments are merged. Set this parameter to 1 to merge all segments into one
         * segment. The default behavior is to perform the merge as necessary.
         * <p>
         * API name: {@code max_num_segments}
         * </p>
         */
        @Nonnull
        public final Builder maxNumSegments(@Nullable Long value) {
            this.maxNumSegments = value;
            return this;
        }

        /**
         * Specify whether the operation should only expunge deleted documents
         * <p>
         * API name: {@code only_expunge_deletes}
         * </p>
         */
        @Nonnull
        public final Builder onlyExpungeDeletes(@Nullable Boolean value) {
            this.onlyExpungeDeletes = value;
            return this;
        }

        /**
         * Specify whether the operation should only perform on primary shards. Defaults to false.
         * <p>
         * API name: {@code primary_only}
         * </p>
         */
        @Nonnull
        public final Builder primaryOnly(@Nullable Boolean value) {
            this.primaryOnly = value;
            return this;
        }

        /**
         * Should the request wait until the force merge is completed.
         * <p>
         * API name: {@code wait_for_completion}
         * </p>
         */
        @Nonnull
        public final Builder waitForCompletion(@Nullable Boolean value) {
            this.waitForCompletion = value;
            return this;
        }

        /**
         * Builds a {@link ForcemergeRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ForcemergeRequest build() {
            _checkSingleUse();

            return new ForcemergeRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code indices.forcemerge}".
     */
    public static final Endpoint<ForcemergeRequest, ForcemergeResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "POST",
        // Request path
        request -> {
            final int _index = 1 << 0;

            int propsSet = 0;

            if (ApiTypeHelper.isDefined(request.index())) propsSet |= _index;

            if (propsSet == 0) {
                return "/_forcemerge";
            }
            if (propsSet == (_index)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/");
                SimpleEndpoint.pathEncode(String.join(",", request.index), buf);
                buf.append("/_forcemerge");
                return buf.toString();
            }

            throw SimpleEndpoint.noPathTemplateFound("path");
        },
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            if (request.allowNoIndices != null) {
                params.put("allow_no_indices", String.valueOf(request.allowNoIndices));
            }
            if (ApiTypeHelper.isDefined(request.expandWildcards)) {
                params.put("expand_wildcards", request.expandWildcards.stream().map(v -> v.jsonValue()).collect(Collectors.joining(",")));
            }
            if (request.flush != null) {
                params.put("flush", String.valueOf(request.flush));
            }
            if (request.ignoreUnavailable != null) {
                params.put("ignore_unavailable", String.valueOf(request.ignoreUnavailable));
            }
            if (request.maxNumSegments != null) {
                params.put("max_num_segments", String.valueOf(request.maxNumSegments));
            }
            if (request.onlyExpungeDeletes != null) {
                params.put("only_expunge_deletes", String.valueOf(request.onlyExpungeDeletes));
            }
            if (request.primaryOnly != null) {
                params.put("primary_only", String.valueOf(request.primaryOnly));
            }
            if (request.waitForCompletion != null) {
                params.put("wait_for_completion", String.valueOf(request.waitForCompletion));
            }
            return params;
        },
        SimpleEndpoint.emptyMap(),
        false,
        ForcemergeResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.allowNoIndices);
        result = 31 * result + Objects.hashCode(this.expandWildcards);
        result = 31 * result + Objects.hashCode(this.flush);
        result = 31 * result + Objects.hashCode(this.ignoreUnavailable);
        result = 31 * result + Objects.hashCode(this.index);
        result = 31 * result + Objects.hashCode(this.maxNumSegments);
        result = 31 * result + Objects.hashCode(this.onlyExpungeDeletes);
        result = 31 * result + Objects.hashCode(this.primaryOnly);
        result = 31 * result + Objects.hashCode(this.waitForCompletion);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ForcemergeRequest other = (ForcemergeRequest) o;
        return Objects.equals(this.allowNoIndices, other.allowNoIndices)
            && Objects.equals(this.expandWildcards, other.expandWildcards)
            && Objects.equals(this.flush, other.flush)
            && Objects.equals(this.ignoreUnavailable, other.ignoreUnavailable)
            && Objects.equals(this.index, other.index)
            && Objects.equals(this.maxNumSegments, other.maxNumSegments)
            && Objects.equals(this.onlyExpungeDeletes, other.onlyExpungeDeletes)
            && Objects.equals(this.primaryOnly, other.primaryOnly)
            && Objects.equals(this.waitForCompletion, other.waitForCompletion);
    }
}
