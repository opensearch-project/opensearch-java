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

package org.opensearch.client.opensearch.geospatial;

import jakarta.json.stream.JsonGenerator;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
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

// typedef: geospatial.UploadStatsTotal

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class UploadStatsTotal implements PlainJsonSerializable, ToCopyableBuilder<UploadStatsTotal.Builder, UploadStatsTotal> {

    private final long duration;

    private final int failed;

    private final int requestCount;

    private final int success;

    private final int upload;

    // ---------------------------------------------------------------------------------------------

    private UploadStatsTotal(Builder builder) {
        this.duration = ApiTypeHelper.requireNonNull(builder.duration, this, "duration");
        this.failed = ApiTypeHelper.requireNonNull(builder.failed, this, "failed");
        this.requestCount = ApiTypeHelper.requireNonNull(builder.requestCount, this, "requestCount");
        this.success = ApiTypeHelper.requireNonNull(builder.success, this, "success");
        this.upload = ApiTypeHelper.requireNonNull(builder.upload, this, "upload");
    }

    public static UploadStatsTotal of(Function<UploadStatsTotal.Builder, ObjectBuilder<UploadStatsTotal>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code duration}
     */
    public final long duration() {
        return this.duration;
    }

    /**
     * Required - Total failed uploads.
     * <p>
     * API name: {@code failed}
     * </p>
     */
    public final int failed() {
        return this.failed;
    }

    /**
     * Required - Total number of upload requests.
     * <p>
     * API name: {@code request_count}
     * </p>
     */
    public final int requestCount() {
        return this.requestCount;
    }

    /**
     * Required - Total successful uploads.
     * <p>
     * API name: {@code success}
     * </p>
     */
    public final int success() {
        return this.success;
    }

    /**
     * Required - Total number of uploads.
     * <p>
     * API name: {@code upload}
     * </p>
     */
    public final int upload() {
        return this.upload;
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
        generator.writeKey("duration");
        generator.write(this.duration);

        generator.writeKey("failed");
        generator.write(this.failed);

        generator.writeKey("request_count");
        generator.write(this.requestCount);

        generator.writeKey("success");
        generator.write(this.success);

        generator.writeKey("upload");
        generator.write(this.upload);
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
     * Builder for {@link UploadStatsTotal}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, UploadStatsTotal> {
        private Long duration;
        private Integer failed;
        private Integer requestCount;
        private Integer success;
        private Integer upload;

        public Builder() {}

        private Builder(UploadStatsTotal o) {
            this.duration = o.duration;
            this.failed = o.failed;
            this.requestCount = o.requestCount;
            this.success = o.success;
            this.upload = o.upload;
        }

        private Builder(Builder o) {
            this.duration = o.duration;
            this.failed = o.failed;
            this.requestCount = o.requestCount;
            this.success = o.success;
            this.upload = o.upload;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code duration}
         */
        @Nonnull
        public final Builder duration(long value) {
            this.duration = value;
            return this;
        }

        /**
         * Required - Total failed uploads.
         * <p>
         * API name: {@code failed}
         * </p>
         */
        @Nonnull
        public final Builder failed(int value) {
            this.failed = value;
            return this;
        }

        /**
         * Required - Total number of upload requests.
         * <p>
         * API name: {@code request_count}
         * </p>
         */
        @Nonnull
        public final Builder requestCount(int value) {
            this.requestCount = value;
            return this;
        }

        /**
         * Required - Total successful uploads.
         * <p>
         * API name: {@code success}
         * </p>
         */
        @Nonnull
        public final Builder success(int value) {
            this.success = value;
            return this;
        }

        /**
         * Required - Total number of uploads.
         * <p>
         * API name: {@code upload}
         * </p>
         */
        @Nonnull
        public final Builder upload(int value) {
            this.upload = value;
            return this;
        }

        /**
         * Builds a {@link UploadStatsTotal}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public UploadStatsTotal build() {
            _checkSingleUse();

            return new UploadStatsTotal(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link UploadStatsTotal}
     */
    public static final JsonpDeserializer<UploadStatsTotal> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        UploadStatsTotal::setupUploadStatsTotalDeserializer
    );

    protected static void setupUploadStatsTotalDeserializer(ObjectDeserializer<UploadStatsTotal.Builder> op) {
        op.add(Builder::duration, JsonpDeserializer.longDeserializer(), "duration");
        op.add(Builder::failed, JsonpDeserializer.integerDeserializer(), "failed");
        op.add(Builder::requestCount, JsonpDeserializer.integerDeserializer(), "request_count");
        op.add(Builder::success, JsonpDeserializer.integerDeserializer(), "success");
        op.add(Builder::upload, JsonpDeserializer.integerDeserializer(), "upload");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Long.hashCode(this.duration);
        result = 31 * result + Integer.hashCode(this.failed);
        result = 31 * result + Integer.hashCode(this.requestCount);
        result = 31 * result + Integer.hashCode(this.success);
        result = 31 * result + Integer.hashCode(this.upload);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        UploadStatsTotal other = (UploadStatsTotal) o;
        return this.duration == other.duration
            && this.failed == other.failed
            && this.requestCount == other.requestCount
            && this.success == other.success
            && this.upload == other.upload;
    }
}
