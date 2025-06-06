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
import java.util.List;
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
import org.opensearch.client.opensearch._types.ShardStatistics;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ism.refresh_search_analyzers.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RefreshSearchAnalyzersResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<RefreshSearchAnalyzersResponse.Builder, RefreshSearchAnalyzersResponse> {

    @Nullable
    private final ShardStatistics shards;

    @Nonnull
    private final List<RefreshSearchAnalyzersResponseDetails> successfulRefreshDetails;

    // ---------------------------------------------------------------------------------------------

    private RefreshSearchAnalyzersResponse(Builder builder) {
        this.shards = builder.shards;
        this.successfulRefreshDetails = ApiTypeHelper.unmodifiable(builder.successfulRefreshDetails);
    }

    public static RefreshSearchAnalyzersResponse of(
        Function<RefreshSearchAnalyzersResponse.Builder, ObjectBuilder<RefreshSearchAnalyzersResponse>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code _shards}
     */
    @Nullable
    public final ShardStatistics shards() {
        return this.shards;
    }

    /**
     * The details of successful analyzer refreshes.
     * <p>
     * API name: {@code successful_refresh_details}
     * </p>
     */
    @Nonnull
    public final List<RefreshSearchAnalyzersResponseDetails> successfulRefreshDetails() {
        return this.successfulRefreshDetails;
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
        if (this.shards != null) {
            generator.writeKey("_shards");
            this.shards.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.successfulRefreshDetails)) {
            generator.writeKey("successful_refresh_details");
            generator.writeStartArray();
            for (RefreshSearchAnalyzersResponseDetails item0 : this.successfulRefreshDetails) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
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
     * Builder for {@link RefreshSearchAnalyzersResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, RefreshSearchAnalyzersResponse> {
        @Nullable
        private ShardStatistics shards;
        @Nullable
        private List<RefreshSearchAnalyzersResponseDetails> successfulRefreshDetails;

        public Builder() {}

        private Builder(RefreshSearchAnalyzersResponse o) {
            this.shards = o.shards;
            this.successfulRefreshDetails = _listCopy(o.successfulRefreshDetails);
        }

        private Builder(Builder o) {
            this.shards = o.shards;
            this.successfulRefreshDetails = _listCopy(o.successfulRefreshDetails);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code _shards}
         */
        @Nonnull
        public final Builder shards(@Nullable ShardStatistics value) {
            this.shards = value;
            return this;
        }

        /**
         * API name: {@code _shards}
         */
        @Nonnull
        public final Builder shards(Function<ShardStatistics.Builder, ObjectBuilder<ShardStatistics>> fn) {
            return shards(fn.apply(new ShardStatistics.Builder()).build());
        }

        /**
         * The details of successful analyzer refreshes.
         * <p>
         * API name: {@code successful_refresh_details}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>successfulRefreshDetails</code>.
         * </p>
         */
        @Nonnull
        public final Builder successfulRefreshDetails(List<RefreshSearchAnalyzersResponseDetails> list) {
            this.successfulRefreshDetails = _listAddAll(this.successfulRefreshDetails, list);
            return this;
        }

        /**
         * The details of successful analyzer refreshes.
         * <p>
         * API name: {@code successful_refresh_details}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>successfulRefreshDetails</code>.
         * </p>
         */
        @Nonnull
        public final Builder successfulRefreshDetails(
            RefreshSearchAnalyzersResponseDetails value,
            RefreshSearchAnalyzersResponseDetails... values
        ) {
            this.successfulRefreshDetails = _listAdd(this.successfulRefreshDetails, value, values);
            return this;
        }

        /**
         * The details of successful analyzer refreshes.
         * <p>
         * API name: {@code successful_refresh_details}
         * </p>
         *
         * <p>
         * Adds a value to <code>successfulRefreshDetails</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder successfulRefreshDetails(
            Function<RefreshSearchAnalyzersResponseDetails.Builder, ObjectBuilder<RefreshSearchAnalyzersResponseDetails>> fn
        ) {
            return successfulRefreshDetails(fn.apply(new RefreshSearchAnalyzersResponseDetails.Builder()).build());
        }

        /**
         * Builds a {@link RefreshSearchAnalyzersResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RefreshSearchAnalyzersResponse build() {
            _checkSingleUse();

            return new RefreshSearchAnalyzersResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RefreshSearchAnalyzersResponse}
     */
    public static final JsonpDeserializer<RefreshSearchAnalyzersResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RefreshSearchAnalyzersResponse::setupRefreshSearchAnalyzersResponseDeserializer
    );

    protected static void setupRefreshSearchAnalyzersResponseDeserializer(ObjectDeserializer<RefreshSearchAnalyzersResponse.Builder> op) {
        op.add(Builder::shards, ShardStatistics._DESERIALIZER, "_shards");
        op.add(
            Builder::successfulRefreshDetails,
            JsonpDeserializer.arrayDeserializer(RefreshSearchAnalyzersResponseDetails._DESERIALIZER),
            "successful_refresh_details"
        );
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.shards);
        result = 31 * result + Objects.hashCode(this.successfulRefreshDetails);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RefreshSearchAnalyzersResponse other = (RefreshSearchAnalyzersResponse) o;
        return Objects.equals(this.shards, other.shards) && Objects.equals(this.successfulRefreshDetails, other.successfulRefreshDetails);
    }
}
