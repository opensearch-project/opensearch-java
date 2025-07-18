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

// typedef: geospatial.UploadStatsMetric

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class UploadStatsMetric implements PlainJsonSerializable, ToCopyableBuilder<UploadStatsMetric.Builder, UploadStatsMetric> {

    private final long duration;

    private final int failed;

    @Nonnull
    private final String id;

    @Nonnull
    private final String nodeId;

    private final int success;

    @Nonnull
    private final String type;

    private final int upload;

    // ---------------------------------------------------------------------------------------------

    private UploadStatsMetric(Builder builder) {
        this.duration = ApiTypeHelper.requireNonNull(builder.duration, this, "duration");
        this.failed = ApiTypeHelper.requireNonNull(builder.failed, this, "failed");
        this.id = ApiTypeHelper.requireNonNull(builder.id, this, "id");
        this.nodeId = ApiTypeHelper.requireNonNull(builder.nodeId, this, "nodeId");
        this.success = ApiTypeHelper.requireNonNull(builder.success, this, "success");
        this.type = ApiTypeHelper.requireNonNull(builder.type, this, "type");
        this.upload = ApiTypeHelper.requireNonNull(builder.upload, this, "upload");
    }

    public static UploadStatsMetric of(Function<UploadStatsMetric.Builder, ObjectBuilder<UploadStatsMetric>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code duration}
     */
    public final long duration() {
        return this.duration;
    }

    /**
     * Required - Number of failed features in this upload.
     * <p>
     * API name: {@code failed}
     * </p>
     */
    public final int failed() {
        return this.failed;
    }

    /**
     * Required - API name: {@code id}
     */
    @Nonnull
    public final String id() {
        return this.id;
    }

    /**
     * Required - API name: {@code node_id}
     */
    @Nonnull
    public final String nodeId() {
        return this.nodeId;
    }

    /**
     * Required - Number of successful features in this upload.
     * <p>
     * API name: {@code success}
     * </p>
     */
    public final int success() {
        return this.success;
    }

    /**
     * Required - Type of upload (such as &quot;GeoJSON&quot;).
     * <p>
     * API name: {@code type}
     * </p>
     */
    @Nonnull
    public final String type() {
        return this.type;
    }

    /**
     * Required - Number of features in this upload.
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

        generator.writeKey("id");
        generator.write(this.id);

        generator.writeKey("node_id");
        generator.write(this.nodeId);

        generator.writeKey("success");
        generator.write(this.success);

        generator.writeKey("type");
        generator.write(this.type);

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
     * Builder for {@link UploadStatsMetric}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, UploadStatsMetric> {
        private Long duration;
        private Integer failed;
        private String id;
        private String nodeId;
        private Integer success;
        private String type;
        private Integer upload;

        public Builder() {}

        private Builder(UploadStatsMetric o) {
            this.duration = o.duration;
            this.failed = o.failed;
            this.id = o.id;
            this.nodeId = o.nodeId;
            this.success = o.success;
            this.type = o.type;
            this.upload = o.upload;
        }

        private Builder(Builder o) {
            this.duration = o.duration;
            this.failed = o.failed;
            this.id = o.id;
            this.nodeId = o.nodeId;
            this.success = o.success;
            this.type = o.type;
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
         * Required - Number of failed features in this upload.
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
         * Required - API name: {@code id}
         */
        @Nonnull
        public final Builder id(String value) {
            this.id = value;
            return this;
        }

        /**
         * Required - API name: {@code node_id}
         */
        @Nonnull
        public final Builder nodeId(String value) {
            this.nodeId = value;
            return this;
        }

        /**
         * Required - Number of successful features in this upload.
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
         * Required - Type of upload (such as &quot;GeoJSON&quot;).
         * <p>
         * API name: {@code type}
         * </p>
         */
        @Nonnull
        public final Builder type(String value) {
            this.type = value;
            return this;
        }

        /**
         * Required - Number of features in this upload.
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
         * Builds a {@link UploadStatsMetric}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public UploadStatsMetric build() {
            _checkSingleUse();

            return new UploadStatsMetric(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link UploadStatsMetric}
     */
    public static final JsonpDeserializer<UploadStatsMetric> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        UploadStatsMetric::setupUploadStatsMetricDeserializer
    );

    protected static void setupUploadStatsMetricDeserializer(ObjectDeserializer<UploadStatsMetric.Builder> op) {
        op.add(Builder::duration, JsonpDeserializer.longDeserializer(), "duration");
        op.add(Builder::failed, JsonpDeserializer.integerDeserializer(), "failed");
        op.add(Builder::id, JsonpDeserializer.stringDeserializer(), "id");
        op.add(Builder::nodeId, JsonpDeserializer.stringDeserializer(), "node_id");
        op.add(Builder::success, JsonpDeserializer.integerDeserializer(), "success");
        op.add(Builder::type, JsonpDeserializer.stringDeserializer(), "type");
        op.add(Builder::upload, JsonpDeserializer.integerDeserializer(), "upload");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Long.hashCode(this.duration);
        result = 31 * result + Integer.hashCode(this.failed);
        result = 31 * result + this.id.hashCode();
        result = 31 * result + this.nodeId.hashCode();
        result = 31 * result + Integer.hashCode(this.success);
        result = 31 * result + this.type.hashCode();
        result = 31 * result + Integer.hashCode(this.upload);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        UploadStatsMetric other = (UploadStatsMetric) o;
        return this.duration == other.duration
            && this.failed == other.failed
            && this.id.equals(other.id)
            && this.nodeId.equals(other.nodeId)
            && this.success == other.success
            && this.type.equals(other.type)
            && this.upload == other.upload;
    }
}
