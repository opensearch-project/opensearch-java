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

package org.opensearch.client.opensearch.nodes.stats;

import jakarta.json.stream.JsonGenerator;
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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: nodes.stats.RepositoryStatsSnapshot

/**
 * Statistics snapshot about a repository.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RepositoryStatsSnapshot
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<RepositoryStatsSnapshot.Builder, RepositoryStatsSnapshot> {

    @Nonnull
    private final Map<String, String> repositoryLocation;

    @Nullable
    private final String repositoryName;

    @Nullable
    private final String repositoryType;

    @Nonnull
    private final Map<String, Long> requestCounts;

    @Nonnull
    private final Map<String, Long> requestFailuresTotal;

    @Nonnull
    private final Map<String, Long> requestRetryCountTotal;

    @Nonnull
    private final Map<String, Long> requestSuccessTotal;

    @Nonnull
    private final Map<String, Long> requestTimeInMillis;

    // ---------------------------------------------------------------------------------------------

    private RepositoryStatsSnapshot(Builder builder) {
        this.repositoryLocation = ApiTypeHelper.unmodifiable(builder.repositoryLocation);
        this.repositoryName = builder.repositoryName;
        this.repositoryType = builder.repositoryType;
        this.requestCounts = ApiTypeHelper.unmodifiable(builder.requestCounts);
        this.requestFailuresTotal = ApiTypeHelper.unmodifiable(builder.requestFailuresTotal);
        this.requestRetryCountTotal = ApiTypeHelper.unmodifiable(builder.requestRetryCountTotal);
        this.requestSuccessTotal = ApiTypeHelper.unmodifiable(builder.requestSuccessTotal);
        this.requestTimeInMillis = ApiTypeHelper.unmodifiable(builder.requestTimeInMillis);
    }

    public static RepositoryStatsSnapshot of(Function<RepositoryStatsSnapshot.Builder, ObjectBuilder<RepositoryStatsSnapshot>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The location configuration of the repository.
     * <p>
     * API name: {@code repository_location}
     * </p>
     */
    @Nonnull
    public final Map<String, String> repositoryLocation() {
        return this.repositoryLocation;
    }

    /**
     * The name of the repository.
     * <p>
     * API name: {@code repository_name}
     * </p>
     */
    @Nullable
    public final String repositoryName() {
        return this.repositoryName;
    }

    /**
     * The type of the repository.
     * <p>
     * API name: {@code repository_type}
     * </p>
     */
    @Nullable
    public final String repositoryType() {
        return this.repositoryType;
    }

    /**
     * The count of requests by operation type (when detailed mode is disabled).
     * <p>
     * API name: {@code request_counts}
     * </p>
     */
    @Nonnull
    public final Map<String, Long> requestCounts() {
        return this.requestCounts;
    }

    /**
     * The count of failed requests by operation type (when detailed mode is enabled).
     * <p>
     * API name: {@code request_failures_total}
     * </p>
     */
    @Nonnull
    public final Map<String, Long> requestFailuresTotal() {
        return this.requestFailuresTotal;
    }

    /**
     * The total retry count by operation type (when detailed mode is enabled).
     * <p>
     * API name: {@code request_retry_count_total}
     * </p>
     */
    @Nonnull
    public final Map<String, Long> requestRetryCountTotal() {
        return this.requestRetryCountTotal;
    }

    /**
     * The count of successful requests by operation type (when detailed mode is enabled).
     * <p>
     * API name: {@code request_success_total}
     * </p>
     */
    @Nonnull
    public final Map<String, Long> requestSuccessTotal() {
        return this.requestSuccessTotal;
    }

    /**
     * The total request time in milliseconds by operation type (when detailed mode is enabled).
     * <p>
     * API name: {@code request_time_in_millis}
     * </p>
     */
    @Nonnull
    public final Map<String, Long> requestTimeInMillis() {
        return this.requestTimeInMillis;
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
        if (ApiTypeHelper.isDefined(this.repositoryLocation)) {
            generator.writeKey("repository_location");
            generator.writeStartObject();
            for (Map.Entry<String, String> item0 : this.repositoryLocation.entrySet()) {
                generator.writeKey(item0.getKey());
                generator.write(item0.getValue());
            }
            generator.writeEnd();
        }

        if (this.repositoryName != null) {
            generator.writeKey("repository_name");
            generator.write(this.repositoryName);
        }

        if (this.repositoryType != null) {
            generator.writeKey("repository_type");
            generator.write(this.repositoryType);
        }

        if (ApiTypeHelper.isDefined(this.requestCounts)) {
            generator.writeKey("request_counts");
            generator.writeStartObject();
            for (Map.Entry<String, Long> item0 : this.requestCounts.entrySet()) {
                generator.writeKey(item0.getKey());
                generator.write(item0.getValue());
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.requestFailuresTotal)) {
            generator.writeKey("request_failures_total");
            generator.writeStartObject();
            for (Map.Entry<String, Long> item0 : this.requestFailuresTotal.entrySet()) {
                generator.writeKey(item0.getKey());
                generator.write(item0.getValue());
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.requestRetryCountTotal)) {
            generator.writeKey("request_retry_count_total");
            generator.writeStartObject();
            for (Map.Entry<String, Long> item0 : this.requestRetryCountTotal.entrySet()) {
                generator.writeKey(item0.getKey());
                generator.write(item0.getValue());
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.requestSuccessTotal)) {
            generator.writeKey("request_success_total");
            generator.writeStartObject();
            for (Map.Entry<String, Long> item0 : this.requestSuccessTotal.entrySet()) {
                generator.writeKey(item0.getKey());
                generator.write(item0.getValue());
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.requestTimeInMillis)) {
            generator.writeKey("request_time_in_millis");
            generator.writeStartObject();
            for (Map.Entry<String, Long> item0 : this.requestTimeInMillis.entrySet()) {
                generator.writeKey(item0.getKey());
                generator.write(item0.getValue());
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
     * Builder for {@link RepositoryStatsSnapshot}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, RepositoryStatsSnapshot> {
        @Nullable
        private Map<String, String> repositoryLocation;
        @Nullable
        private String repositoryName;
        @Nullable
        private String repositoryType;
        @Nullable
        private Map<String, Long> requestCounts;
        @Nullable
        private Map<String, Long> requestFailuresTotal;
        @Nullable
        private Map<String, Long> requestRetryCountTotal;
        @Nullable
        private Map<String, Long> requestSuccessTotal;
        @Nullable
        private Map<String, Long> requestTimeInMillis;

        public Builder() {}

        private Builder(RepositoryStatsSnapshot o) {
            this.repositoryLocation = _mapCopy(o.repositoryLocation);
            this.repositoryName = o.repositoryName;
            this.repositoryType = o.repositoryType;
            this.requestCounts = _mapCopy(o.requestCounts);
            this.requestFailuresTotal = _mapCopy(o.requestFailuresTotal);
            this.requestRetryCountTotal = _mapCopy(o.requestRetryCountTotal);
            this.requestSuccessTotal = _mapCopy(o.requestSuccessTotal);
            this.requestTimeInMillis = _mapCopy(o.requestTimeInMillis);
        }

        private Builder(Builder o) {
            this.repositoryLocation = _mapCopy(o.repositoryLocation);
            this.repositoryName = o.repositoryName;
            this.repositoryType = o.repositoryType;
            this.requestCounts = _mapCopy(o.requestCounts);
            this.requestFailuresTotal = _mapCopy(o.requestFailuresTotal);
            this.requestRetryCountTotal = _mapCopy(o.requestRetryCountTotal);
            this.requestSuccessTotal = _mapCopy(o.requestSuccessTotal);
            this.requestTimeInMillis = _mapCopy(o.requestTimeInMillis);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The location configuration of the repository.
         * <p>
         * API name: {@code repository_location}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>repositoryLocation</code>.
         * </p>
         */
        @Nonnull
        public final Builder repositoryLocation(Map<String, String> map) {
            this.repositoryLocation = _mapPutAll(this.repositoryLocation, map);
            return this;
        }

        /**
         * The location configuration of the repository.
         * <p>
         * API name: {@code repository_location}
         * </p>
         *
         * <p>
         * Adds an entry to <code>repositoryLocation</code>.
         * </p>
         */
        @Nonnull
        public final Builder repositoryLocation(String key, String value) {
            this.repositoryLocation = _mapPut(this.repositoryLocation, key, value);
            return this;
        }

        /**
         * The name of the repository.
         * <p>
         * API name: {@code repository_name}
         * </p>
         */
        @Nonnull
        public final Builder repositoryName(@Nullable String value) {
            this.repositoryName = value;
            return this;
        }

        /**
         * The type of the repository.
         * <p>
         * API name: {@code repository_type}
         * </p>
         */
        @Nonnull
        public final Builder repositoryType(@Nullable String value) {
            this.repositoryType = value;
            return this;
        }

        /**
         * The count of requests by operation type (when detailed mode is disabled).
         * <p>
         * API name: {@code request_counts}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>requestCounts</code>.
         * </p>
         */
        @Nonnull
        public final Builder requestCounts(Map<String, Long> map) {
            this.requestCounts = _mapPutAll(this.requestCounts, map);
            return this;
        }

        /**
         * The count of requests by operation type (when detailed mode is disabled).
         * <p>
         * API name: {@code request_counts}
         * </p>
         *
         * <p>
         * Adds an entry to <code>requestCounts</code>.
         * </p>
         */
        @Nonnull
        public final Builder requestCounts(String key, Long value) {
            this.requestCounts = _mapPut(this.requestCounts, key, value);
            return this;
        }

        /**
         * The count of failed requests by operation type (when detailed mode is enabled).
         * <p>
         * API name: {@code request_failures_total}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>requestFailuresTotal</code>.
         * </p>
         */
        @Nonnull
        public final Builder requestFailuresTotal(Map<String, Long> map) {
            this.requestFailuresTotal = _mapPutAll(this.requestFailuresTotal, map);
            return this;
        }

        /**
         * The count of failed requests by operation type (when detailed mode is enabled).
         * <p>
         * API name: {@code request_failures_total}
         * </p>
         *
         * <p>
         * Adds an entry to <code>requestFailuresTotal</code>.
         * </p>
         */
        @Nonnull
        public final Builder requestFailuresTotal(String key, Long value) {
            this.requestFailuresTotal = _mapPut(this.requestFailuresTotal, key, value);
            return this;
        }

        /**
         * The total retry count by operation type (when detailed mode is enabled).
         * <p>
         * API name: {@code request_retry_count_total}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>requestRetryCountTotal</code>.
         * </p>
         */
        @Nonnull
        public final Builder requestRetryCountTotal(Map<String, Long> map) {
            this.requestRetryCountTotal = _mapPutAll(this.requestRetryCountTotal, map);
            return this;
        }

        /**
         * The total retry count by operation type (when detailed mode is enabled).
         * <p>
         * API name: {@code request_retry_count_total}
         * </p>
         *
         * <p>
         * Adds an entry to <code>requestRetryCountTotal</code>.
         * </p>
         */
        @Nonnull
        public final Builder requestRetryCountTotal(String key, Long value) {
            this.requestRetryCountTotal = _mapPut(this.requestRetryCountTotal, key, value);
            return this;
        }

        /**
         * The count of successful requests by operation type (when detailed mode is enabled).
         * <p>
         * API name: {@code request_success_total}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>requestSuccessTotal</code>.
         * </p>
         */
        @Nonnull
        public final Builder requestSuccessTotal(Map<String, Long> map) {
            this.requestSuccessTotal = _mapPutAll(this.requestSuccessTotal, map);
            return this;
        }

        /**
         * The count of successful requests by operation type (when detailed mode is enabled).
         * <p>
         * API name: {@code request_success_total}
         * </p>
         *
         * <p>
         * Adds an entry to <code>requestSuccessTotal</code>.
         * </p>
         */
        @Nonnull
        public final Builder requestSuccessTotal(String key, Long value) {
            this.requestSuccessTotal = _mapPut(this.requestSuccessTotal, key, value);
            return this;
        }

        /**
         * The total request time in milliseconds by operation type (when detailed mode is enabled).
         * <p>
         * API name: {@code request_time_in_millis}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>requestTimeInMillis</code>.
         * </p>
         */
        @Nonnull
        public final Builder requestTimeInMillis(Map<String, Long> map) {
            this.requestTimeInMillis = _mapPutAll(this.requestTimeInMillis, map);
            return this;
        }

        /**
         * The total request time in milliseconds by operation type (when detailed mode is enabled).
         * <p>
         * API name: {@code request_time_in_millis}
         * </p>
         *
         * <p>
         * Adds an entry to <code>requestTimeInMillis</code>.
         * </p>
         */
        @Nonnull
        public final Builder requestTimeInMillis(String key, Long value) {
            this.requestTimeInMillis = _mapPut(this.requestTimeInMillis, key, value);
            return this;
        }

        /**
         * Builds a {@link RepositoryStatsSnapshot}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RepositoryStatsSnapshot build() {
            _checkSingleUse();

            return new RepositoryStatsSnapshot(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RepositoryStatsSnapshot}
     */
    public static final JsonpDeserializer<RepositoryStatsSnapshot> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RepositoryStatsSnapshot::setupRepositoryStatsSnapshotDeserializer
    );

    protected static void setupRepositoryStatsSnapshotDeserializer(ObjectDeserializer<RepositoryStatsSnapshot.Builder> op) {
        op.add(
            Builder::repositoryLocation,
            JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.stringDeserializer()),
            "repository_location"
        );
        op.add(Builder::repositoryName, JsonpDeserializer.stringDeserializer(), "repository_name");
        op.add(Builder::repositoryType, JsonpDeserializer.stringDeserializer(), "repository_type");
        op.add(Builder::requestCounts, JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.longDeserializer()), "request_counts");
        op.add(
            Builder::requestFailuresTotal,
            JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.longDeserializer()),
            "request_failures_total"
        );
        op.add(
            Builder::requestRetryCountTotal,
            JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.longDeserializer()),
            "request_retry_count_total"
        );
        op.add(
            Builder::requestSuccessTotal,
            JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.longDeserializer()),
            "request_success_total"
        );
        op.add(
            Builder::requestTimeInMillis,
            JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.longDeserializer()),
            "request_time_in_millis"
        );
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.repositoryLocation);
        result = 31 * result + Objects.hashCode(this.repositoryName);
        result = 31 * result + Objects.hashCode(this.repositoryType);
        result = 31 * result + Objects.hashCode(this.requestCounts);
        result = 31 * result + Objects.hashCode(this.requestFailuresTotal);
        result = 31 * result + Objects.hashCode(this.requestRetryCountTotal);
        result = 31 * result + Objects.hashCode(this.requestSuccessTotal);
        result = 31 * result + Objects.hashCode(this.requestTimeInMillis);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RepositoryStatsSnapshot other = (RepositoryStatsSnapshot) o;
        return Objects.equals(this.repositoryLocation, other.repositoryLocation)
            && Objects.equals(this.repositoryName, other.repositoryName)
            && Objects.equals(this.repositoryType, other.repositoryType)
            && Objects.equals(this.requestCounts, other.requestCounts)
            && Objects.equals(this.requestFailuresTotal, other.requestFailuresTotal)
            && Objects.equals(this.requestRetryCountTotal, other.requestRetryCountTotal)
            && Objects.equals(this.requestSuccessTotal, other.requestSuccessTotal)
            && Objects.equals(this.requestTimeInMillis, other.requestTimeInMillis);
    }
}
