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
import org.opensearch.client.opensearch._types.Conflicts;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.Refresh;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.opensearch._types.Script;
import org.opensearch.client.opensearch._types.Slices;
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.opensearch._types.WaitForActiveShards;
import org.opensearch.client.opensearch.core.reindex.Destination;
import org.opensearch.client.opensearch.core.reindex.Source;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _global.reindex.Request

/**
 * Allows to copy documents from one index to another, optionally filtering the source documents by a query, changing the destination index
 * settings, or fetching the documents from a remote cluster.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class ReindexRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ReindexRequest.Builder, ReindexRequest> {

    @Nullable
    private final Conflicts conflicts;

    @Nonnull
    private final Destination dest;

    @Nullable
    private final Integer maxDocs;

    @Nullable
    private final Refresh refresh;

    @Nullable
    private final Float requestsPerSecond;

    @Nullable
    private final Boolean requireAlias;

    @Nullable
    private final Script script;

    @Nullable
    private final Time scroll;

    @Nullable
    private final Integer size;

    @Nullable
    private final Slices slices;

    @Nonnull
    private final Source source;

    @Nullable
    private final Time timeout;

    @Nullable
    private final WaitForActiveShards waitForActiveShards;

    @Nullable
    private final Boolean waitForCompletion;

    // ---------------------------------------------------------------------------------------------

    private ReindexRequest(Builder builder) {
        super(builder);
        this.conflicts = builder.conflicts;
        this.dest = ApiTypeHelper.requireNonNull(builder.dest, this, "dest");
        this.maxDocs = builder.maxDocs;
        this.refresh = builder.refresh;
        this.requestsPerSecond = builder.requestsPerSecond;
        this.requireAlias = builder.requireAlias;
        this.script = builder.script;
        this.scroll = builder.scroll;
        this.size = builder.size;
        this.slices = builder.slices;
        this.source = ApiTypeHelper.requireNonNull(builder.source, this, "source");
        this.timeout = builder.timeout;
        this.waitForActiveShards = builder.waitForActiveShards;
        this.waitForCompletion = builder.waitForCompletion;
    }

    public static ReindexRequest of(Function<ReindexRequest.Builder, ObjectBuilder<ReindexRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code conflicts}
     */
    @Nullable
    public final Conflicts conflicts() {
        return this.conflicts;
    }

    /**
     * Required - API name: {@code dest}
     */
    @Nonnull
    public final Destination dest() {
        return this.dest;
    }

    /**
     * The maximum number of documents to reindex.
     * <p>
     * API name: {@code max_docs}
     * </p>
     */
    @Nullable
    public final Integer maxDocs() {
        return this.maxDocs;
    }

    /**
     * If <code>true</code>, the request refreshes affected shards to make this operation visible to search.
     * <p>
     * API name: {@code refresh}
     * </p>
     */
    @Nullable
    public final Refresh refresh() {
        return this.refresh;
    }

    /**
     * The throttle for this request in sub-requests per second. Defaults to no throttle.
     * <p>
     * API name: {@code requests_per_second}
     * </p>
     */
    @Nullable
    public final Float requestsPerSecond() {
        return this.requestsPerSecond;
    }

    /**
     * API name: {@code require_alias}
     */
    @Nullable
    public final Boolean requireAlias() {
        return this.requireAlias;
    }

    /**
     * API name: {@code script}
     */
    @Nullable
    public final Script script() {
        return this.script;
    }

    /**
     * Specifies how long a consistent view of the index should be maintained for scrolled search.
     * <p>
     * API name: {@code scroll}
     * </p>
     */
    @Nullable
    public final Time scroll() {
        return this.scroll;
    }

    /**
     * API name: {@code size}
     */
    @Nullable
    public final Integer size() {
        return this.size;
    }

    /**
     * The number of slices this task should be divided into. Defaults to 1 slice, meaning the task isn't sliced into subtasks.
     * <p>
     * API name: {@code slices}
     * </p>
     */
    @Nullable
    public final Slices slices() {
        return this.slices;
    }

    /**
     * Required - API name: {@code source}
     */
    @Nonnull
    public final Source source() {
        return this.source;
    }

    /**
     * Period each indexing waits for automatic index creation, dynamic mapping updates, and waiting for active shards.
     * <p>
     * API name: {@code timeout}
     * </p>
     */
    @Nullable
    public final Time timeout() {
        return this.timeout;
    }

    /**
     * The number of shard copies that must be active before proceeding with the operation. Set to <code>all</code> or any positive integer
     * up to the total number of shards in the index (<code>number_of_replicas+1</code>).
     * <p>
     * API name: {@code wait_for_active_shards}
     * </p>
     */
    @Nullable
    public final WaitForActiveShards waitForActiveShards() {
        return this.waitForActiveShards;
    }

    /**
     * If <code>true</code>, the request blocks until the operation is complete.
     * <p>
     * API name: {@code wait_for_completion}
     * </p>
     */
    @Nullable
    public final Boolean waitForCompletion() {
        return this.waitForCompletion;
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
        if (this.conflicts != null) {
            generator.writeKey("conflicts");
            this.conflicts.serialize(generator, mapper);
        }

        generator.writeKey("dest");
        this.dest.serialize(generator, mapper);

        if (this.maxDocs != null) {
            generator.writeKey("max_docs");
            generator.write(this.maxDocs);
        }

        if (this.script != null) {
            generator.writeKey("script");
            this.script.serialize(generator, mapper);
        }

        if (this.size != null) {
            generator.writeKey("size");
            generator.write(this.size);
        }

        generator.writeKey("source");
        this.source.serialize(generator, mapper);
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
     * Builder for {@link ReindexRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, ReindexRequest> {
        @Nullable
        private Conflicts conflicts;
        private Destination dest;
        @Nullable
        private Integer maxDocs;
        @Nullable
        private Refresh refresh;
        @Nullable
        private Float requestsPerSecond;
        @Nullable
        private Boolean requireAlias;
        @Nullable
        private Script script;
        @Nullable
        private Time scroll;
        @Nullable
        private Integer size;
        @Nullable
        private Slices slices;
        private Source source;
        @Nullable
        private Time timeout;
        @Nullable
        private WaitForActiveShards waitForActiveShards;
        @Nullable
        private Boolean waitForCompletion;

        public Builder() {}

        private Builder(ReindexRequest o) {
            super(o);
            this.conflicts = o.conflicts;
            this.dest = o.dest;
            this.maxDocs = o.maxDocs;
            this.refresh = o.refresh;
            this.requestsPerSecond = o.requestsPerSecond;
            this.requireAlias = o.requireAlias;
            this.script = o.script;
            this.scroll = o.scroll;
            this.size = o.size;
            this.slices = o.slices;
            this.source = o.source;
            this.timeout = o.timeout;
            this.waitForActiveShards = o.waitForActiveShards;
            this.waitForCompletion = o.waitForCompletion;
        }

        private Builder(Builder o) {
            super(o);
            this.conflicts = o.conflicts;
            this.dest = o.dest;
            this.maxDocs = o.maxDocs;
            this.refresh = o.refresh;
            this.requestsPerSecond = o.requestsPerSecond;
            this.requireAlias = o.requireAlias;
            this.script = o.script;
            this.scroll = o.scroll;
            this.size = o.size;
            this.slices = o.slices;
            this.source = o.source;
            this.timeout = o.timeout;
            this.waitForActiveShards = o.waitForActiveShards;
            this.waitForCompletion = o.waitForCompletion;
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
         * API name: {@code conflicts}
         */
        @Nonnull
        public final Builder conflicts(@Nullable Conflicts value) {
            this.conflicts = value;
            return this;
        }

        /**
         * Required - API name: {@code dest}
         */
        @Nonnull
        public final Builder dest(Destination value) {
            this.dest = value;
            return this;
        }

        /**
         * Required - API name: {@code dest}
         */
        @Nonnull
        public final Builder dest(Function<Destination.Builder, ObjectBuilder<Destination>> fn) {
            return dest(fn.apply(new Destination.Builder()).build());
        }

        /**
         * The maximum number of documents to reindex.
         * <p>
         * API name: {@code max_docs}
         * </p>
         */
        @Nonnull
        public final Builder maxDocs(@Nullable Integer value) {
            this.maxDocs = value;
            return this;
        }

        /**
         * If <code>true</code>, the request refreshes affected shards to make this operation visible to search.
         * <p>
         * API name: {@code refresh}
         * </p>
         */
        @Nonnull
        public final Builder refresh(@Nullable Refresh value) {
            this.refresh = value;
            return this;
        }

        /**
         * The throttle for this request in sub-requests per second. Defaults to no throttle.
         * <p>
         * API name: {@code requests_per_second}
         * </p>
         */
        @Nonnull
        public final Builder requestsPerSecond(@Nullable Float value) {
            this.requestsPerSecond = value;
            return this;
        }

        /**
         * API name: {@code require_alias}
         */
        @Nonnull
        public final Builder requireAlias(@Nullable Boolean value) {
            this.requireAlias = value;
            return this;
        }

        /**
         * API name: {@code script}
         */
        @Nonnull
        public final Builder script(@Nullable Script value) {
            this.script = value;
            return this;
        }

        /**
         * API name: {@code script}
         */
        @Nonnull
        public final Builder script(Function<Script.Builder, ObjectBuilder<Script>> fn) {
            return script(fn.apply(new Script.Builder()).build());
        }

        /**
         * Specifies how long a consistent view of the index should be maintained for scrolled search.
         * <p>
         * API name: {@code scroll}
         * </p>
         */
        @Nonnull
        public final Builder scroll(@Nullable Time value) {
            this.scroll = value;
            return this;
        }

        /**
         * Specifies how long a consistent view of the index should be maintained for scrolled search.
         * <p>
         * API name: {@code scroll}
         * </p>
         */
        @Nonnull
        public final Builder scroll(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return scroll(fn.apply(new Time.Builder()).build());
        }

        /**
         * API name: {@code size}
         */
        @Nonnull
        public final Builder size(@Nullable Integer value) {
            this.size = value;
            return this;
        }

        /**
         * The number of slices this task should be divided into. Defaults to 1 slice, meaning the task isn't sliced into subtasks.
         * <p>
         * API name: {@code slices}
         * </p>
         */
        @Nonnull
        public final Builder slices(@Nullable Slices value) {
            this.slices = value;
            return this;
        }

        /**
         * The number of slices this task should be divided into. Defaults to 1 slice, meaning the task isn't sliced into subtasks.
         * <p>
         * API name: {@code slices}
         * </p>
         */
        @Nonnull
        public final Builder slices(Function<Slices.Builder, ObjectBuilder<Slices>> fn) {
            return slices(fn.apply(new Slices.Builder()).build());
        }

        /**
         * Required - API name: {@code source}
         */
        @Nonnull
        public final Builder source(Source value) {
            this.source = value;
            return this;
        }

        /**
         * Required - API name: {@code source}
         */
        @Nonnull
        public final Builder source(Function<Source.Builder, ObjectBuilder<Source>> fn) {
            return source(fn.apply(new Source.Builder()).build());
        }

        /**
         * Period each indexing waits for automatic index creation, dynamic mapping updates, and waiting for active shards.
         * <p>
         * API name: {@code timeout}
         * </p>
         */
        @Nonnull
        public final Builder timeout(@Nullable Time value) {
            this.timeout = value;
            return this;
        }

        /**
         * Period each indexing waits for automatic index creation, dynamic mapping updates, and waiting for active shards.
         * <p>
         * API name: {@code timeout}
         * </p>
         */
        @Nonnull
        public final Builder timeout(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return timeout(fn.apply(new Time.Builder()).build());
        }

        /**
         * The number of shard copies that must be active before proceeding with the operation. Set to <code>all</code> or any positive
         * integer up to the total number of shards in the index (<code>number_of_replicas+1</code>).
         * <p>
         * API name: {@code wait_for_active_shards}
         * </p>
         */
        @Nonnull
        public final Builder waitForActiveShards(@Nullable WaitForActiveShards value) {
            this.waitForActiveShards = value;
            return this;
        }

        /**
         * The number of shard copies that must be active before proceeding with the operation. Set to <code>all</code> or any positive
         * integer up to the total number of shards in the index (<code>number_of_replicas+1</code>).
         * <p>
         * API name: {@code wait_for_active_shards}
         * </p>
         */
        @Nonnull
        public final Builder waitForActiveShards(Function<WaitForActiveShards.Builder, ObjectBuilder<WaitForActiveShards>> fn) {
            return waitForActiveShards(fn.apply(new WaitForActiveShards.Builder()).build());
        }

        /**
         * If <code>true</code>, the request blocks until the operation is complete.
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
         * Builds a {@link ReindexRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ReindexRequest build() {
            _checkSingleUse();

            return new ReindexRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ReindexRequest}
     */
    public static final JsonpDeserializer<ReindexRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ReindexRequest::setupReindexRequestDeserializer
    );

    protected static void setupReindexRequestDeserializer(ObjectDeserializer<ReindexRequest.Builder> op) {
        op.add(Builder::conflicts, Conflicts._DESERIALIZER, "conflicts");
        op.add(Builder::dest, Destination._DESERIALIZER, "dest");
        op.add(Builder::maxDocs, JsonpDeserializer.integerDeserializer(), "max_docs");
        op.add(Builder::script, Script._DESERIALIZER, "script");
        op.add(Builder::size, JsonpDeserializer.integerDeserializer(), "size");
        op.add(Builder::source, Source._DESERIALIZER, "source");
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    protected void applyQueryParameters(@Nonnull Map<String, String> params) {
        super.applyQueryParameters(params);
        if (this.refresh != null) {
            params.put("refresh", this.refresh.jsonValue());
        }
        if (this.requestsPerSecond != null) {
            params.put("requests_per_second", String.valueOf(this.requestsPerSecond));
        }
        if (this.requireAlias != null) {
            params.put("require_alias", String.valueOf(this.requireAlias));
        }
        if (this.scroll != null) {
            params.put("scroll", this.scroll._toJsonString());
        }
        if (this.slices != null) {
            params.put("slices", this.slices._toJsonString());
        }
        if (this.timeout != null) {
            params.put("timeout", this.timeout._toJsonString());
        }
        if (this.waitForActiveShards != null) {
            params.put("wait_for_active_shards", this.waitForActiveShards._toJsonString());
        }
        if (this.waitForCompletion != null) {
            params.put("wait_for_completion", String.valueOf(this.waitForCompletion));
        }
    }

    /**
     * Endpoint "{@code reindex}".
     */
    public static final Endpoint<ReindexRequest, ReindexResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "POST",
        // Request path
        request -> "/_reindex",
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap(),
        true,
        ReindexResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.conflicts);
        result = 31 * result + this.dest.hashCode();
        result = 31 * result + Objects.hashCode(this.maxDocs);
        result = 31 * result + Objects.hashCode(this.refresh);
        result = 31 * result + Objects.hashCode(this.requestsPerSecond);
        result = 31 * result + Objects.hashCode(this.requireAlias);
        result = 31 * result + Objects.hashCode(this.script);
        result = 31 * result + Objects.hashCode(this.scroll);
        result = 31 * result + Objects.hashCode(this.size);
        result = 31 * result + Objects.hashCode(this.slices);
        result = 31 * result + this.source.hashCode();
        result = 31 * result + Objects.hashCode(this.timeout);
        result = 31 * result + Objects.hashCode(this.waitForActiveShards);
        result = 31 * result + Objects.hashCode(this.waitForCompletion);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ReindexRequest other = (ReindexRequest) o;
        return Objects.equals(this.conflicts, other.conflicts)
            && this.dest.equals(other.dest)
            && Objects.equals(this.maxDocs, other.maxDocs)
            && Objects.equals(this.refresh, other.refresh)
            && Objects.equals(this.requestsPerSecond, other.requestsPerSecond)
            && Objects.equals(this.requireAlias, other.requireAlias)
            && Objects.equals(this.script, other.script)
            && Objects.equals(this.scroll, other.scroll)
            && Objects.equals(this.size, other.size)
            && Objects.equals(this.slices, other.slices)
            && this.source.equals(other.source)
            && Objects.equals(this.timeout, other.timeout)
            && Objects.equals(this.waitForActiveShards, other.waitForActiveShards)
            && Objects.equals(this.waitForCompletion, other.waitForCompletion);
    }
}
