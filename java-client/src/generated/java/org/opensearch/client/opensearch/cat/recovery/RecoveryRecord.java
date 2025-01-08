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

package org.opensearch.client.opensearch.cat.recovery;

import jakarta.json.stream.JsonGenerator;
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
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: cat.recovery.RecoveryRecord

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RecoveryRecord implements PlainJsonSerializable, ToCopyableBuilder<RecoveryRecord.Builder, RecoveryRecord> {

    @Nullable
    private final String bytes;

    @Nullable
    private final String bytesPercent;

    @Nullable
    private final String bytesRecovered;

    @Nullable
    private final String bytesTotal;

    @Nullable
    private final String files;

    @Nullable
    private final String filesPercent;

    @Nullable
    private final String filesRecovered;

    @Nullable
    private final String filesTotal;

    @Nullable
    private final String index;

    @Nullable
    private final String repository;

    @Nullable
    private final String shard;

    @Nullable
    private final String snapshot;

    @Nullable
    private final String sourceHost;

    @Nullable
    private final String sourceNode;

    @Nullable
    private final String stage;

    @Nullable
    private final String startTime;

    @Nullable
    private final Long startTimeMillis;

    @Nullable
    private final String stopTime;

    @Nullable
    private final Long stopTimeMillis;

    @Nullable
    private final String targetHost;

    @Nullable
    private final String targetNode;

    @Nullable
    private final Time time;

    @Nullable
    private final String translogOps;

    @Nullable
    private final String translogOpsPercent;

    @Nullable
    private final String translogOpsRecovered;

    @Nullable
    private final String type;

    // ---------------------------------------------------------------------------------------------

    private RecoveryRecord(Builder builder) {
        this.bytes = builder.bytes;
        this.bytesPercent = builder.bytesPercent;
        this.bytesRecovered = builder.bytesRecovered;
        this.bytesTotal = builder.bytesTotal;
        this.files = builder.files;
        this.filesPercent = builder.filesPercent;
        this.filesRecovered = builder.filesRecovered;
        this.filesTotal = builder.filesTotal;
        this.index = builder.index;
        this.repository = builder.repository;
        this.shard = builder.shard;
        this.snapshot = builder.snapshot;
        this.sourceHost = builder.sourceHost;
        this.sourceNode = builder.sourceNode;
        this.stage = builder.stage;
        this.startTime = builder.startTime;
        this.startTimeMillis = builder.startTimeMillis;
        this.stopTime = builder.stopTime;
        this.stopTimeMillis = builder.stopTimeMillis;
        this.targetHost = builder.targetHost;
        this.targetNode = builder.targetNode;
        this.time = builder.time;
        this.translogOps = builder.translogOps;
        this.translogOpsPercent = builder.translogOpsPercent;
        this.translogOpsRecovered = builder.translogOpsRecovered;
        this.type = builder.type;
    }

    public static RecoveryRecord of(Function<RecoveryRecord.Builder, ObjectBuilder<RecoveryRecord>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The number of bytes to recover.
     * <p>
     * API name: {@code bytes}
     * </p>
     */
    @Nullable
    public final String bytes() {
        return this.bytes;
    }

    /**
     * API name: {@code bytes_percent}
     */
    @Nullable
    public final String bytesPercent() {
        return this.bytesPercent;
    }

    /**
     * The bytes recovered.
     * <p>
     * API name: {@code bytes_recovered}
     * </p>
     */
    @Nullable
    public final String bytesRecovered() {
        return this.bytesRecovered;
    }

    /**
     * The total number of bytes.
     * <p>
     * API name: {@code bytes_total}
     * </p>
     */
    @Nullable
    public final String bytesTotal() {
        return this.bytesTotal;
    }

    /**
     * The number of files to recover.
     * <p>
     * API name: {@code files}
     * </p>
     */
    @Nullable
    public final String files() {
        return this.files;
    }

    /**
     * API name: {@code files_percent}
     */
    @Nullable
    public final String filesPercent() {
        return this.filesPercent;
    }

    /**
     * The files recovered.
     * <p>
     * API name: {@code files_recovered}
     * </p>
     */
    @Nullable
    public final String filesRecovered() {
        return this.filesRecovered;
    }

    /**
     * The total number of files.
     * <p>
     * API name: {@code files_total}
     * </p>
     */
    @Nullable
    public final String filesTotal() {
        return this.filesTotal;
    }

    /**
     * API name: {@code index}
     */
    @Nullable
    public final String index() {
        return this.index;
    }

    /**
     * The repository name.
     * <p>
     * API name: {@code repository}
     * </p>
     */
    @Nullable
    public final String repository() {
        return this.repository;
    }

    /**
     * The shard name.
     * <p>
     * API name: {@code shard}
     * </p>
     */
    @Nullable
    public final String shard() {
        return this.shard;
    }

    /**
     * The snapshot name.
     * <p>
     * API name: {@code snapshot}
     * </p>
     */
    @Nullable
    public final String snapshot() {
        return this.snapshot;
    }

    /**
     * The source host.
     * <p>
     * API name: {@code source_host}
     * </p>
     */
    @Nullable
    public final String sourceHost() {
        return this.sourceHost;
    }

    /**
     * The source node name.
     * <p>
     * API name: {@code source_node}
     * </p>
     */
    @Nullable
    public final String sourceNode() {
        return this.sourceNode;
    }

    /**
     * The recovery stage.
     * <p>
     * API name: {@code stage}
     * </p>
     */
    @Nullable
    public final String stage() {
        return this.stage;
    }

    /**
     * API name: {@code start_time}
     */
    @Nullable
    public final String startTime() {
        return this.startTime;
    }

    /**
     * API name: {@code start_time_millis}
     */
    @Nullable
    public final Long startTimeMillis() {
        return this.startTimeMillis;
    }

    /**
     * API name: {@code stop_time}
     */
    @Nullable
    public final String stopTime() {
        return this.stopTime;
    }

    /**
     * API name: {@code stop_time_millis}
     */
    @Nullable
    public final Long stopTimeMillis() {
        return this.stopTimeMillis;
    }

    /**
     * The target host.
     * <p>
     * API name: {@code target_host}
     * </p>
     */
    @Nullable
    public final String targetHost() {
        return this.targetHost;
    }

    /**
     * The target node name.
     * <p>
     * API name: {@code target_node}
     * </p>
     */
    @Nullable
    public final String targetNode() {
        return this.targetNode;
    }

    /**
     * API name: {@code time}
     */
    @Nullable
    public final Time time() {
        return this.time;
    }

    /**
     * The number of translog operations to recover.
     * <p>
     * API name: {@code translog_ops}
     * </p>
     */
    @Nullable
    public final String translogOps() {
        return this.translogOps;
    }

    /**
     * API name: {@code translog_ops_percent}
     */
    @Nullable
    public final String translogOpsPercent() {
        return this.translogOpsPercent;
    }

    /**
     * The translog operations recovered.
     * <p>
     * API name: {@code translog_ops_recovered}
     * </p>
     */
    @Nullable
    public final String translogOpsRecovered() {
        return this.translogOpsRecovered;
    }

    /**
     * The recovery type.
     * <p>
     * API name: {@code type}
     * </p>
     */
    @Nullable
    public final String type() {
        return this.type;
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
        if (this.bytes != null) {
            generator.writeKey("bytes");
            generator.write(this.bytes);
        }

        if (this.bytesPercent != null) {
            generator.writeKey("bytes_percent");
            generator.write(this.bytesPercent);
        }

        if (this.bytesRecovered != null) {
            generator.writeKey("bytes_recovered");
            generator.write(this.bytesRecovered);
        }

        if (this.bytesTotal != null) {
            generator.writeKey("bytes_total");
            generator.write(this.bytesTotal);
        }

        if (this.files != null) {
            generator.writeKey("files");
            generator.write(this.files);
        }

        if (this.filesPercent != null) {
            generator.writeKey("files_percent");
            generator.write(this.filesPercent);
        }

        if (this.filesRecovered != null) {
            generator.writeKey("files_recovered");
            generator.write(this.filesRecovered);
        }

        if (this.filesTotal != null) {
            generator.writeKey("files_total");
            generator.write(this.filesTotal);
        }

        if (this.index != null) {
            generator.writeKey("index");
            generator.write(this.index);
        }

        if (this.repository != null) {
            generator.writeKey("repository");
            generator.write(this.repository);
        }

        if (this.shard != null) {
            generator.writeKey("shard");
            generator.write(this.shard);
        }

        if (this.snapshot != null) {
            generator.writeKey("snapshot");
            generator.write(this.snapshot);
        }

        if (this.sourceHost != null) {
            generator.writeKey("source_host");
            generator.write(this.sourceHost);
        }

        if (this.sourceNode != null) {
            generator.writeKey("source_node");
            generator.write(this.sourceNode);
        }

        if (this.stage != null) {
            generator.writeKey("stage");
            generator.write(this.stage);
        }

        if (this.startTime != null) {
            generator.writeKey("start_time");
            generator.write(this.startTime);
        }

        if (this.startTimeMillis != null) {
            generator.writeKey("start_time_millis");
            generator.write(this.startTimeMillis);
        }

        if (this.stopTime != null) {
            generator.writeKey("stop_time");
            generator.write(this.stopTime);
        }

        if (this.stopTimeMillis != null) {
            generator.writeKey("stop_time_millis");
            generator.write(this.stopTimeMillis);
        }

        if (this.targetHost != null) {
            generator.writeKey("target_host");
            generator.write(this.targetHost);
        }

        if (this.targetNode != null) {
            generator.writeKey("target_node");
            generator.write(this.targetNode);
        }

        if (this.time != null) {
            generator.writeKey("time");
            this.time.serialize(generator, mapper);
        }

        if (this.translogOps != null) {
            generator.writeKey("translog_ops");
            generator.write(this.translogOps);
        }

        if (this.translogOpsPercent != null) {
            generator.writeKey("translog_ops_percent");
            generator.write(this.translogOpsPercent);
        }

        if (this.translogOpsRecovered != null) {
            generator.writeKey("translog_ops_recovered");
            generator.write(this.translogOpsRecovered);
        }

        if (this.type != null) {
            generator.writeKey("type");
            generator.write(this.type);
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
     * Builder for {@link RecoveryRecord}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, RecoveryRecord> {
        @Nullable
        private String bytes;
        @Nullable
        private String bytesPercent;
        @Nullable
        private String bytesRecovered;
        @Nullable
        private String bytesTotal;
        @Nullable
        private String files;
        @Nullable
        private String filesPercent;
        @Nullable
        private String filesRecovered;
        @Nullable
        private String filesTotal;
        @Nullable
        private String index;
        @Nullable
        private String repository;
        @Nullable
        private String shard;
        @Nullable
        private String snapshot;
        @Nullable
        private String sourceHost;
        @Nullable
        private String sourceNode;
        @Nullable
        private String stage;
        @Nullable
        private String startTime;
        @Nullable
        private Long startTimeMillis;
        @Nullable
        private String stopTime;
        @Nullable
        private Long stopTimeMillis;
        @Nullable
        private String targetHost;
        @Nullable
        private String targetNode;
        @Nullable
        private Time time;
        @Nullable
        private String translogOps;
        @Nullable
        private String translogOpsPercent;
        @Nullable
        private String translogOpsRecovered;
        @Nullable
        private String type;

        public Builder() {}

        private Builder(RecoveryRecord o) {
            this.bytes = o.bytes;
            this.bytesPercent = o.bytesPercent;
            this.bytesRecovered = o.bytesRecovered;
            this.bytesTotal = o.bytesTotal;
            this.files = o.files;
            this.filesPercent = o.filesPercent;
            this.filesRecovered = o.filesRecovered;
            this.filesTotal = o.filesTotal;
            this.index = o.index;
            this.repository = o.repository;
            this.shard = o.shard;
            this.snapshot = o.snapshot;
            this.sourceHost = o.sourceHost;
            this.sourceNode = o.sourceNode;
            this.stage = o.stage;
            this.startTime = o.startTime;
            this.startTimeMillis = o.startTimeMillis;
            this.stopTime = o.stopTime;
            this.stopTimeMillis = o.stopTimeMillis;
            this.targetHost = o.targetHost;
            this.targetNode = o.targetNode;
            this.time = o.time;
            this.translogOps = o.translogOps;
            this.translogOpsPercent = o.translogOpsPercent;
            this.translogOpsRecovered = o.translogOpsRecovered;
            this.type = o.type;
        }

        private Builder(Builder o) {
            this.bytes = o.bytes;
            this.bytesPercent = o.bytesPercent;
            this.bytesRecovered = o.bytesRecovered;
            this.bytesTotal = o.bytesTotal;
            this.files = o.files;
            this.filesPercent = o.filesPercent;
            this.filesRecovered = o.filesRecovered;
            this.filesTotal = o.filesTotal;
            this.index = o.index;
            this.repository = o.repository;
            this.shard = o.shard;
            this.snapshot = o.snapshot;
            this.sourceHost = o.sourceHost;
            this.sourceNode = o.sourceNode;
            this.stage = o.stage;
            this.startTime = o.startTime;
            this.startTimeMillis = o.startTimeMillis;
            this.stopTime = o.stopTime;
            this.stopTimeMillis = o.stopTimeMillis;
            this.targetHost = o.targetHost;
            this.targetNode = o.targetNode;
            this.time = o.time;
            this.translogOps = o.translogOps;
            this.translogOpsPercent = o.translogOpsPercent;
            this.translogOpsRecovered = o.translogOpsRecovered;
            this.type = o.type;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The number of bytes to recover.
         * <p>
         * API name: {@code bytes}
         * </p>
         */
        @Nonnull
        public final Builder bytes(@Nullable String value) {
            this.bytes = value;
            return this;
        }

        /**
         * API name: {@code bytes_percent}
         */
        @Nonnull
        public final Builder bytesPercent(@Nullable String value) {
            this.bytesPercent = value;
            return this;
        }

        /**
         * The bytes recovered.
         * <p>
         * API name: {@code bytes_recovered}
         * </p>
         */
        @Nonnull
        public final Builder bytesRecovered(@Nullable String value) {
            this.bytesRecovered = value;
            return this;
        }

        /**
         * The total number of bytes.
         * <p>
         * API name: {@code bytes_total}
         * </p>
         */
        @Nonnull
        public final Builder bytesTotal(@Nullable String value) {
            this.bytesTotal = value;
            return this;
        }

        /**
         * The number of files to recover.
         * <p>
         * API name: {@code files}
         * </p>
         */
        @Nonnull
        public final Builder files(@Nullable String value) {
            this.files = value;
            return this;
        }

        /**
         * API name: {@code files_percent}
         */
        @Nonnull
        public final Builder filesPercent(@Nullable String value) {
            this.filesPercent = value;
            return this;
        }

        /**
         * The files recovered.
         * <p>
         * API name: {@code files_recovered}
         * </p>
         */
        @Nonnull
        public final Builder filesRecovered(@Nullable String value) {
            this.filesRecovered = value;
            return this;
        }

        /**
         * The total number of files.
         * <p>
         * API name: {@code files_total}
         * </p>
         */
        @Nonnull
        public final Builder filesTotal(@Nullable String value) {
            this.filesTotal = value;
            return this;
        }

        /**
         * API name: {@code index}
         */
        @Nonnull
        public final Builder index(@Nullable String value) {
            this.index = value;
            return this;
        }

        /**
         * The repository name.
         * <p>
         * API name: {@code repository}
         * </p>
         */
        @Nonnull
        public final Builder repository(@Nullable String value) {
            this.repository = value;
            return this;
        }

        /**
         * The shard name.
         * <p>
         * API name: {@code shard}
         * </p>
         */
        @Nonnull
        public final Builder shard(@Nullable String value) {
            this.shard = value;
            return this;
        }

        /**
         * The snapshot name.
         * <p>
         * API name: {@code snapshot}
         * </p>
         */
        @Nonnull
        public final Builder snapshot(@Nullable String value) {
            this.snapshot = value;
            return this;
        }

        /**
         * The source host.
         * <p>
         * API name: {@code source_host}
         * </p>
         */
        @Nonnull
        public final Builder sourceHost(@Nullable String value) {
            this.sourceHost = value;
            return this;
        }

        /**
         * The source node name.
         * <p>
         * API name: {@code source_node}
         * </p>
         */
        @Nonnull
        public final Builder sourceNode(@Nullable String value) {
            this.sourceNode = value;
            return this;
        }

        /**
         * The recovery stage.
         * <p>
         * API name: {@code stage}
         * </p>
         */
        @Nonnull
        public final Builder stage(@Nullable String value) {
            this.stage = value;
            return this;
        }

        /**
         * API name: {@code start_time}
         */
        @Nonnull
        public final Builder startTime(@Nullable String value) {
            this.startTime = value;
            return this;
        }

        /**
         * API name: {@code start_time_millis}
         */
        @Nonnull
        public final Builder startTimeMillis(@Nullable Long value) {
            this.startTimeMillis = value;
            return this;
        }

        /**
         * API name: {@code stop_time}
         */
        @Nonnull
        public final Builder stopTime(@Nullable String value) {
            this.stopTime = value;
            return this;
        }

        /**
         * API name: {@code stop_time_millis}
         */
        @Nonnull
        public final Builder stopTimeMillis(@Nullable Long value) {
            this.stopTimeMillis = value;
            return this;
        }

        /**
         * The target host.
         * <p>
         * API name: {@code target_host}
         * </p>
         */
        @Nonnull
        public final Builder targetHost(@Nullable String value) {
            this.targetHost = value;
            return this;
        }

        /**
         * The target node name.
         * <p>
         * API name: {@code target_node}
         * </p>
         */
        @Nonnull
        public final Builder targetNode(@Nullable String value) {
            this.targetNode = value;
            return this;
        }

        /**
         * API name: {@code time}
         */
        @Nonnull
        public final Builder time(@Nullable Time value) {
            this.time = value;
            return this;
        }

        /**
         * API name: {@code time}
         */
        @Nonnull
        public final Builder time(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return time(fn.apply(new Time.Builder()).build());
        }

        /**
         * The number of translog operations to recover.
         * <p>
         * API name: {@code translog_ops}
         * </p>
         */
        @Nonnull
        public final Builder translogOps(@Nullable String value) {
            this.translogOps = value;
            return this;
        }

        /**
         * API name: {@code translog_ops_percent}
         */
        @Nonnull
        public final Builder translogOpsPercent(@Nullable String value) {
            this.translogOpsPercent = value;
            return this;
        }

        /**
         * The translog operations recovered.
         * <p>
         * API name: {@code translog_ops_recovered}
         * </p>
         */
        @Nonnull
        public final Builder translogOpsRecovered(@Nullable String value) {
            this.translogOpsRecovered = value;
            return this;
        }

        /**
         * The recovery type.
         * <p>
         * API name: {@code type}
         * </p>
         */
        @Nonnull
        public final Builder type(@Nullable String value) {
            this.type = value;
            return this;
        }

        /**
         * Builds a {@link RecoveryRecord}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RecoveryRecord build() {
            _checkSingleUse();

            return new RecoveryRecord(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RecoveryRecord}
     */
    public static final JsonpDeserializer<RecoveryRecord> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RecoveryRecord::setupRecoveryRecordDeserializer
    );

    protected static void setupRecoveryRecordDeserializer(ObjectDeserializer<RecoveryRecord.Builder> op) {
        op.add(Builder::bytes, JsonpDeserializer.stringDeserializer(), "bytes");
        op.add(Builder::bytesPercent, JsonpDeserializer.stringDeserializer(), "bytes_percent");
        op.add(Builder::bytesRecovered, JsonpDeserializer.stringDeserializer(), "bytes_recovered");
        op.add(Builder::bytesTotal, JsonpDeserializer.stringDeserializer(), "bytes_total");
        op.add(Builder::files, JsonpDeserializer.stringDeserializer(), "files");
        op.add(Builder::filesPercent, JsonpDeserializer.stringDeserializer(), "files_percent");
        op.add(Builder::filesRecovered, JsonpDeserializer.stringDeserializer(), "files_recovered");
        op.add(Builder::filesTotal, JsonpDeserializer.stringDeserializer(), "files_total");
        op.add(Builder::index, JsonpDeserializer.stringDeserializer(), "index");
        op.add(Builder::repository, JsonpDeserializer.stringDeserializer(), "repository");
        op.add(Builder::shard, JsonpDeserializer.stringDeserializer(), "shard");
        op.add(Builder::snapshot, JsonpDeserializer.stringDeserializer(), "snapshot");
        op.add(Builder::sourceHost, JsonpDeserializer.stringDeserializer(), "source_host");
        op.add(Builder::sourceNode, JsonpDeserializer.stringDeserializer(), "source_node");
        op.add(Builder::stage, JsonpDeserializer.stringDeserializer(), "stage");
        op.add(Builder::startTime, JsonpDeserializer.stringDeserializer(), "start_time");
        op.add(Builder::startTimeMillis, JsonpDeserializer.longDeserializer(), "start_time_millis");
        op.add(Builder::stopTime, JsonpDeserializer.stringDeserializer(), "stop_time");
        op.add(Builder::stopTimeMillis, JsonpDeserializer.longDeserializer(), "stop_time_millis");
        op.add(Builder::targetHost, JsonpDeserializer.stringDeserializer(), "target_host");
        op.add(Builder::targetNode, JsonpDeserializer.stringDeserializer(), "target_node");
        op.add(Builder::time, Time._DESERIALIZER, "time");
        op.add(Builder::translogOps, JsonpDeserializer.stringDeserializer(), "translog_ops");
        op.add(Builder::translogOpsPercent, JsonpDeserializer.stringDeserializer(), "translog_ops_percent");
        op.add(Builder::translogOpsRecovered, JsonpDeserializer.stringDeserializer(), "translog_ops_recovered");
        op.add(Builder::type, JsonpDeserializer.stringDeserializer(), "type");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.bytes);
        result = 31 * result + Objects.hashCode(this.bytesPercent);
        result = 31 * result + Objects.hashCode(this.bytesRecovered);
        result = 31 * result + Objects.hashCode(this.bytesTotal);
        result = 31 * result + Objects.hashCode(this.files);
        result = 31 * result + Objects.hashCode(this.filesPercent);
        result = 31 * result + Objects.hashCode(this.filesRecovered);
        result = 31 * result + Objects.hashCode(this.filesTotal);
        result = 31 * result + Objects.hashCode(this.index);
        result = 31 * result + Objects.hashCode(this.repository);
        result = 31 * result + Objects.hashCode(this.shard);
        result = 31 * result + Objects.hashCode(this.snapshot);
        result = 31 * result + Objects.hashCode(this.sourceHost);
        result = 31 * result + Objects.hashCode(this.sourceNode);
        result = 31 * result + Objects.hashCode(this.stage);
        result = 31 * result + Objects.hashCode(this.startTime);
        result = 31 * result + Objects.hashCode(this.startTimeMillis);
        result = 31 * result + Objects.hashCode(this.stopTime);
        result = 31 * result + Objects.hashCode(this.stopTimeMillis);
        result = 31 * result + Objects.hashCode(this.targetHost);
        result = 31 * result + Objects.hashCode(this.targetNode);
        result = 31 * result + Objects.hashCode(this.time);
        result = 31 * result + Objects.hashCode(this.translogOps);
        result = 31 * result + Objects.hashCode(this.translogOpsPercent);
        result = 31 * result + Objects.hashCode(this.translogOpsRecovered);
        result = 31 * result + Objects.hashCode(this.type);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RecoveryRecord other = (RecoveryRecord) o;
        return Objects.equals(this.bytes, other.bytes)
            && Objects.equals(this.bytesPercent, other.bytesPercent)
            && Objects.equals(this.bytesRecovered, other.bytesRecovered)
            && Objects.equals(this.bytesTotal, other.bytesTotal)
            && Objects.equals(this.files, other.files)
            && Objects.equals(this.filesPercent, other.filesPercent)
            && Objects.equals(this.filesRecovered, other.filesRecovered)
            && Objects.equals(this.filesTotal, other.filesTotal)
            && Objects.equals(this.index, other.index)
            && Objects.equals(this.repository, other.repository)
            && Objects.equals(this.shard, other.shard)
            && Objects.equals(this.snapshot, other.snapshot)
            && Objects.equals(this.sourceHost, other.sourceHost)
            && Objects.equals(this.sourceNode, other.sourceNode)
            && Objects.equals(this.stage, other.stage)
            && Objects.equals(this.startTime, other.startTime)
            && Objects.equals(this.startTimeMillis, other.startTimeMillis)
            && Objects.equals(this.stopTime, other.stopTime)
            && Objects.equals(this.stopTimeMillis, other.stopTimeMillis)
            && Objects.equals(this.targetHost, other.targetHost)
            && Objects.equals(this.targetNode, other.targetNode)
            && Objects.equals(this.time, other.time)
            && Objects.equals(this.translogOps, other.translogOps)
            && Objects.equals(this.translogOpsPercent, other.translogOpsPercent)
            && Objects.equals(this.translogOpsRecovered, other.translogOpsRecovered)
            && Objects.equals(this.type, other.type);
    }
}
