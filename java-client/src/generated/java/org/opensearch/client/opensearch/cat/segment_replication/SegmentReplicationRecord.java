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

package org.opensearch.client.opensearch.cat.segment_replication;

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
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: cat.segment_replication.SegmentReplicationRecord

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SegmentReplicationRecord
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<SegmentReplicationRecord.Builder, SegmentReplicationRecord> {

    @Nullable
    private final String bytes;

    @Nullable
    private final String bytesBehind;

    @Nullable
    private final String bytesFetched;

    @Nullable
    private final String bytesPercent;

    @Nullable
    private final String bytesTotal;

    @Nullable
    private final String checkpointsBehind;

    @Nullable
    private final String currentLag;

    @Nullable
    private final String fileDiffStageTimeTaken;

    @Nullable
    private final String files;

    @Nullable
    private final String filesFetched;

    @Nullable
    private final String filesPercent;

    @Nullable
    private final String filesTotal;

    @Nullable
    private final String finalizeReplicationStageTimeTaken;

    @Nullable
    private final String getCheckpointInfoStageTimeTaken;

    @Nullable
    private final String getFilesStageTimeTaken;

    @Nullable
    private final String lastCompletedLag;

    @Nullable
    private final String rejectedRequests;

    @Nullable
    private final String replicatingStageTimeTaken;

    @Nullable
    private final String shardId;

    @Nullable
    private final String stage;

    @Nullable
    private final String startTime;

    @Nullable
    private final String stopTime;

    @Nullable
    private final String targetHost;

    @Nullable
    private final String targetNode;

    @Nullable
    private final String time;

    // ---------------------------------------------------------------------------------------------

    private SegmentReplicationRecord(Builder builder) {
        this.bytes = builder.bytes;
        this.bytesBehind = builder.bytesBehind;
        this.bytesFetched = builder.bytesFetched;
        this.bytesPercent = builder.bytesPercent;
        this.bytesTotal = builder.bytesTotal;
        this.checkpointsBehind = builder.checkpointsBehind;
        this.currentLag = builder.currentLag;
        this.fileDiffStageTimeTaken = builder.fileDiffStageTimeTaken;
        this.files = builder.files;
        this.filesFetched = builder.filesFetched;
        this.filesPercent = builder.filesPercent;
        this.filesTotal = builder.filesTotal;
        this.finalizeReplicationStageTimeTaken = builder.finalizeReplicationStageTimeTaken;
        this.getCheckpointInfoStageTimeTaken = builder.getCheckpointInfoStageTimeTaken;
        this.getFilesStageTimeTaken = builder.getFilesStageTimeTaken;
        this.lastCompletedLag = builder.lastCompletedLag;
        this.rejectedRequests = builder.rejectedRequests;
        this.replicatingStageTimeTaken = builder.replicatingStageTimeTaken;
        this.shardId = builder.shardId;
        this.stage = builder.stage;
        this.startTime = builder.startTime;
        this.stopTime = builder.stopTime;
        this.targetHost = builder.targetHost;
        this.targetNode = builder.targetNode;
        this.time = builder.time;
    }

    public static SegmentReplicationRecord of(Function<SegmentReplicationRecord.Builder, ObjectBuilder<SegmentReplicationRecord>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code bytes}
     */
    @Nullable
    public final String bytes() {
        return this.bytes;
    }

    /**
     * API name: {@code bytes_behind}
     */
    @Nullable
    public final String bytesBehind() {
        return this.bytesBehind;
    }

    /**
     * API name: {@code bytes_fetched}
     */
    @Nullable
    public final String bytesFetched() {
        return this.bytesFetched;
    }

    /**
     * API name: {@code bytes_percent}
     */
    @Nullable
    public final String bytesPercent() {
        return this.bytesPercent;
    }

    /**
     * API name: {@code bytes_total}
     */
    @Nullable
    public final String bytesTotal() {
        return this.bytesTotal;
    }

    /**
     * API name: {@code checkpoints_behind}
     */
    @Nullable
    public final String checkpointsBehind() {
        return this.checkpointsBehind;
    }

    /**
     * API name: {@code current_lag}
     */
    @Nullable
    public final String currentLag() {
        return this.currentLag;
    }

    /**
     * API name: {@code file_diff_stage_time_taken}
     */
    @Nullable
    public final String fileDiffStageTimeTaken() {
        return this.fileDiffStageTimeTaken;
    }

    /**
     * API name: {@code files}
     */
    @Nullable
    public final String files() {
        return this.files;
    }

    /**
     * API name: {@code files_fetched}
     */
    @Nullable
    public final String filesFetched() {
        return this.filesFetched;
    }

    /**
     * API name: {@code files_percent}
     */
    @Nullable
    public final String filesPercent() {
        return this.filesPercent;
    }

    /**
     * API name: {@code files_total}
     */
    @Nullable
    public final String filesTotal() {
        return this.filesTotal;
    }

    /**
     * API name: {@code finalize_replication_stage_time_taken}
     */
    @Nullable
    public final String finalizeReplicationStageTimeTaken() {
        return this.finalizeReplicationStageTimeTaken;
    }

    /**
     * API name: {@code get_checkpoint_info_stage_time_taken}
     */
    @Nullable
    public final String getCheckpointInfoStageTimeTaken() {
        return this.getCheckpointInfoStageTimeTaken;
    }

    /**
     * API name: {@code get_files_stage_time_taken}
     */
    @Nullable
    public final String getFilesStageTimeTaken() {
        return this.getFilesStageTimeTaken;
    }

    /**
     * API name: {@code last_completed_lag}
     */
    @Nullable
    public final String lastCompletedLag() {
        return this.lastCompletedLag;
    }

    /**
     * API name: {@code rejected_requests}
     */
    @Nullable
    public final String rejectedRequests() {
        return this.rejectedRequests;
    }

    /**
     * API name: {@code replicating_stage_time_taken}
     */
    @Nullable
    public final String replicatingStageTimeTaken() {
        return this.replicatingStageTimeTaken;
    }

    /**
     * API name: {@code shardId}
     */
    @Nullable
    public final String shardId() {
        return this.shardId;
    }

    /**
     * API name: {@code stage}
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
     * API name: {@code stop_time}
     */
    @Nullable
    public final String stopTime() {
        return this.stopTime;
    }

    /**
     * API name: {@code target_host}
     */
    @Nullable
    public final String targetHost() {
        return this.targetHost;
    }

    /**
     * API name: {@code target_node}
     */
    @Nullable
    public final String targetNode() {
        return this.targetNode;
    }

    /**
     * API name: {@code time}
     */
    @Nullable
    public final String time() {
        return this.time;
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

        if (this.bytesBehind != null) {
            generator.writeKey("bytes_behind");
            generator.write(this.bytesBehind);
        }

        if (this.bytesFetched != null) {
            generator.writeKey("bytes_fetched");
            generator.write(this.bytesFetched);
        }

        if (this.bytesPercent != null) {
            generator.writeKey("bytes_percent");
            generator.write(this.bytesPercent);
        }

        if (this.bytesTotal != null) {
            generator.writeKey("bytes_total");
            generator.write(this.bytesTotal);
        }

        if (this.checkpointsBehind != null) {
            generator.writeKey("checkpoints_behind");
            generator.write(this.checkpointsBehind);
        }

        if (this.currentLag != null) {
            generator.writeKey("current_lag");
            generator.write(this.currentLag);
        }

        if (this.fileDiffStageTimeTaken != null) {
            generator.writeKey("file_diff_stage_time_taken");
            generator.write(this.fileDiffStageTimeTaken);
        }

        if (this.files != null) {
            generator.writeKey("files");
            generator.write(this.files);
        }

        if (this.filesFetched != null) {
            generator.writeKey("files_fetched");
            generator.write(this.filesFetched);
        }

        if (this.filesPercent != null) {
            generator.writeKey("files_percent");
            generator.write(this.filesPercent);
        }

        if (this.filesTotal != null) {
            generator.writeKey("files_total");
            generator.write(this.filesTotal);
        }

        if (this.finalizeReplicationStageTimeTaken != null) {
            generator.writeKey("finalize_replication_stage_time_taken");
            generator.write(this.finalizeReplicationStageTimeTaken);
        }

        if (this.getCheckpointInfoStageTimeTaken != null) {
            generator.writeKey("get_checkpoint_info_stage_time_taken");
            generator.write(this.getCheckpointInfoStageTimeTaken);
        }

        if (this.getFilesStageTimeTaken != null) {
            generator.writeKey("get_files_stage_time_taken");
            generator.write(this.getFilesStageTimeTaken);
        }

        if (this.lastCompletedLag != null) {
            generator.writeKey("last_completed_lag");
            generator.write(this.lastCompletedLag);
        }

        if (this.rejectedRequests != null) {
            generator.writeKey("rejected_requests");
            generator.write(this.rejectedRequests);
        }

        if (this.replicatingStageTimeTaken != null) {
            generator.writeKey("replicating_stage_time_taken");
            generator.write(this.replicatingStageTimeTaken);
        }

        if (this.shardId != null) {
            generator.writeKey("shardId");
            generator.write(this.shardId);
        }

        if (this.stage != null) {
            generator.writeKey("stage");
            generator.write(this.stage);
        }

        if (this.startTime != null) {
            generator.writeKey("start_time");
            generator.write(this.startTime);
        }

        if (this.stopTime != null) {
            generator.writeKey("stop_time");
            generator.write(this.stopTime);
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
            generator.write(this.time);
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
     * Builder for {@link SegmentReplicationRecord}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, SegmentReplicationRecord> {
        @Nullable
        private String bytes;
        @Nullable
        private String bytesBehind;
        @Nullable
        private String bytesFetched;
        @Nullable
        private String bytesPercent;
        @Nullable
        private String bytesTotal;
        @Nullable
        private String checkpointsBehind;
        @Nullable
        private String currentLag;
        @Nullable
        private String fileDiffStageTimeTaken;
        @Nullable
        private String files;
        @Nullable
        private String filesFetched;
        @Nullable
        private String filesPercent;
        @Nullable
        private String filesTotal;
        @Nullable
        private String finalizeReplicationStageTimeTaken;
        @Nullable
        private String getCheckpointInfoStageTimeTaken;
        @Nullable
        private String getFilesStageTimeTaken;
        @Nullable
        private String lastCompletedLag;
        @Nullable
        private String rejectedRequests;
        @Nullable
        private String replicatingStageTimeTaken;
        @Nullable
        private String shardId;
        @Nullable
        private String stage;
        @Nullable
        private String startTime;
        @Nullable
        private String stopTime;
        @Nullable
        private String targetHost;
        @Nullable
        private String targetNode;
        @Nullable
        private String time;

        public Builder() {}

        private Builder(SegmentReplicationRecord o) {
            this.bytes = o.bytes;
            this.bytesBehind = o.bytesBehind;
            this.bytesFetched = o.bytesFetched;
            this.bytesPercent = o.bytesPercent;
            this.bytesTotal = o.bytesTotal;
            this.checkpointsBehind = o.checkpointsBehind;
            this.currentLag = o.currentLag;
            this.fileDiffStageTimeTaken = o.fileDiffStageTimeTaken;
            this.files = o.files;
            this.filesFetched = o.filesFetched;
            this.filesPercent = o.filesPercent;
            this.filesTotal = o.filesTotal;
            this.finalizeReplicationStageTimeTaken = o.finalizeReplicationStageTimeTaken;
            this.getCheckpointInfoStageTimeTaken = o.getCheckpointInfoStageTimeTaken;
            this.getFilesStageTimeTaken = o.getFilesStageTimeTaken;
            this.lastCompletedLag = o.lastCompletedLag;
            this.rejectedRequests = o.rejectedRequests;
            this.replicatingStageTimeTaken = o.replicatingStageTimeTaken;
            this.shardId = o.shardId;
            this.stage = o.stage;
            this.startTime = o.startTime;
            this.stopTime = o.stopTime;
            this.targetHost = o.targetHost;
            this.targetNode = o.targetNode;
            this.time = o.time;
        }

        private Builder(Builder o) {
            this.bytes = o.bytes;
            this.bytesBehind = o.bytesBehind;
            this.bytesFetched = o.bytesFetched;
            this.bytesPercent = o.bytesPercent;
            this.bytesTotal = o.bytesTotal;
            this.checkpointsBehind = o.checkpointsBehind;
            this.currentLag = o.currentLag;
            this.fileDiffStageTimeTaken = o.fileDiffStageTimeTaken;
            this.files = o.files;
            this.filesFetched = o.filesFetched;
            this.filesPercent = o.filesPercent;
            this.filesTotal = o.filesTotal;
            this.finalizeReplicationStageTimeTaken = o.finalizeReplicationStageTimeTaken;
            this.getCheckpointInfoStageTimeTaken = o.getCheckpointInfoStageTimeTaken;
            this.getFilesStageTimeTaken = o.getFilesStageTimeTaken;
            this.lastCompletedLag = o.lastCompletedLag;
            this.rejectedRequests = o.rejectedRequests;
            this.replicatingStageTimeTaken = o.replicatingStageTimeTaken;
            this.shardId = o.shardId;
            this.stage = o.stage;
            this.startTime = o.startTime;
            this.stopTime = o.stopTime;
            this.targetHost = o.targetHost;
            this.targetNode = o.targetNode;
            this.time = o.time;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code bytes}
         */
        @Nonnull
        public final Builder bytes(@Nullable String value) {
            this.bytes = value;
            return this;
        }

        /**
         * API name: {@code bytes_behind}
         */
        @Nonnull
        public final Builder bytesBehind(@Nullable String value) {
            this.bytesBehind = value;
            return this;
        }

        /**
         * API name: {@code bytes_fetched}
         */
        @Nonnull
        public final Builder bytesFetched(@Nullable String value) {
            this.bytesFetched = value;
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
         * API name: {@code bytes_total}
         */
        @Nonnull
        public final Builder bytesTotal(@Nullable String value) {
            this.bytesTotal = value;
            return this;
        }

        /**
         * API name: {@code checkpoints_behind}
         */
        @Nonnull
        public final Builder checkpointsBehind(@Nullable String value) {
            this.checkpointsBehind = value;
            return this;
        }

        /**
         * API name: {@code current_lag}
         */
        @Nonnull
        public final Builder currentLag(@Nullable String value) {
            this.currentLag = value;
            return this;
        }

        /**
         * API name: {@code file_diff_stage_time_taken}
         */
        @Nonnull
        public final Builder fileDiffStageTimeTaken(@Nullable String value) {
            this.fileDiffStageTimeTaken = value;
            return this;
        }

        /**
         * API name: {@code files}
         */
        @Nonnull
        public final Builder files(@Nullable String value) {
            this.files = value;
            return this;
        }

        /**
         * API name: {@code files_fetched}
         */
        @Nonnull
        public final Builder filesFetched(@Nullable String value) {
            this.filesFetched = value;
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
         * API name: {@code files_total}
         */
        @Nonnull
        public final Builder filesTotal(@Nullable String value) {
            this.filesTotal = value;
            return this;
        }

        /**
         * API name: {@code finalize_replication_stage_time_taken}
         */
        @Nonnull
        public final Builder finalizeReplicationStageTimeTaken(@Nullable String value) {
            this.finalizeReplicationStageTimeTaken = value;
            return this;
        }

        /**
         * API name: {@code get_checkpoint_info_stage_time_taken}
         */
        @Nonnull
        public final Builder getCheckpointInfoStageTimeTaken(@Nullable String value) {
            this.getCheckpointInfoStageTimeTaken = value;
            return this;
        }

        /**
         * API name: {@code get_files_stage_time_taken}
         */
        @Nonnull
        public final Builder getFilesStageTimeTaken(@Nullable String value) {
            this.getFilesStageTimeTaken = value;
            return this;
        }

        /**
         * API name: {@code last_completed_lag}
         */
        @Nonnull
        public final Builder lastCompletedLag(@Nullable String value) {
            this.lastCompletedLag = value;
            return this;
        }

        /**
         * API name: {@code rejected_requests}
         */
        @Nonnull
        public final Builder rejectedRequests(@Nullable String value) {
            this.rejectedRequests = value;
            return this;
        }

        /**
         * API name: {@code replicating_stage_time_taken}
         */
        @Nonnull
        public final Builder replicatingStageTimeTaken(@Nullable String value) {
            this.replicatingStageTimeTaken = value;
            return this;
        }

        /**
         * API name: {@code shardId}
         */
        @Nonnull
        public final Builder shardId(@Nullable String value) {
            this.shardId = value;
            return this;
        }

        /**
         * API name: {@code stage}
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
         * API name: {@code stop_time}
         */
        @Nonnull
        public final Builder stopTime(@Nullable String value) {
            this.stopTime = value;
            return this;
        }

        /**
         * API name: {@code target_host}
         */
        @Nonnull
        public final Builder targetHost(@Nullable String value) {
            this.targetHost = value;
            return this;
        }

        /**
         * API name: {@code target_node}
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
        public final Builder time(@Nullable String value) {
            this.time = value;
            return this;
        }

        /**
         * Builds a {@link SegmentReplicationRecord}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SegmentReplicationRecord build() {
            _checkSingleUse();

            return new SegmentReplicationRecord(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SegmentReplicationRecord}
     */
    public static final JsonpDeserializer<SegmentReplicationRecord> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SegmentReplicationRecord::setupSegmentReplicationRecordDeserializer
    );

    protected static void setupSegmentReplicationRecordDeserializer(ObjectDeserializer<SegmentReplicationRecord.Builder> op) {
        op.add(Builder::bytes, JsonpDeserializer.stringDeserializer(), "bytes");
        op.add(Builder::bytesBehind, JsonpDeserializer.stringDeserializer(), "bytes_behind");
        op.add(Builder::bytesFetched, JsonpDeserializer.stringDeserializer(), "bytes_fetched");
        op.add(Builder::bytesPercent, JsonpDeserializer.stringDeserializer(), "bytes_percent");
        op.add(Builder::bytesTotal, JsonpDeserializer.stringDeserializer(), "bytes_total");
        op.add(Builder::checkpointsBehind, JsonpDeserializer.stringDeserializer(), "checkpoints_behind");
        op.add(Builder::currentLag, JsonpDeserializer.stringDeserializer(), "current_lag");
        op.add(Builder::fileDiffStageTimeTaken, JsonpDeserializer.stringDeserializer(), "file_diff_stage_time_taken");
        op.add(Builder::files, JsonpDeserializer.stringDeserializer(), "files");
        op.add(Builder::filesFetched, JsonpDeserializer.stringDeserializer(), "files_fetched");
        op.add(Builder::filesPercent, JsonpDeserializer.stringDeserializer(), "files_percent");
        op.add(Builder::filesTotal, JsonpDeserializer.stringDeserializer(), "files_total");
        op.add(Builder::finalizeReplicationStageTimeTaken, JsonpDeserializer.stringDeserializer(), "finalize_replication_stage_time_taken");
        op.add(Builder::getCheckpointInfoStageTimeTaken, JsonpDeserializer.stringDeserializer(), "get_checkpoint_info_stage_time_taken");
        op.add(Builder::getFilesStageTimeTaken, JsonpDeserializer.stringDeserializer(), "get_files_stage_time_taken");
        op.add(Builder::lastCompletedLag, JsonpDeserializer.stringDeserializer(), "last_completed_lag");
        op.add(Builder::rejectedRequests, JsonpDeserializer.stringDeserializer(), "rejected_requests");
        op.add(Builder::replicatingStageTimeTaken, JsonpDeserializer.stringDeserializer(), "replicating_stage_time_taken");
        op.add(Builder::shardId, JsonpDeserializer.stringDeserializer(), "shardId");
        op.add(Builder::stage, JsonpDeserializer.stringDeserializer(), "stage");
        op.add(Builder::startTime, JsonpDeserializer.stringDeserializer(), "start_time");
        op.add(Builder::stopTime, JsonpDeserializer.stringDeserializer(), "stop_time");
        op.add(Builder::targetHost, JsonpDeserializer.stringDeserializer(), "target_host");
        op.add(Builder::targetNode, JsonpDeserializer.stringDeserializer(), "target_node");
        op.add(Builder::time, JsonpDeserializer.stringDeserializer(), "time");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.bytes);
        result = 31 * result + Objects.hashCode(this.bytesBehind);
        result = 31 * result + Objects.hashCode(this.bytesFetched);
        result = 31 * result + Objects.hashCode(this.bytesPercent);
        result = 31 * result + Objects.hashCode(this.bytesTotal);
        result = 31 * result + Objects.hashCode(this.checkpointsBehind);
        result = 31 * result + Objects.hashCode(this.currentLag);
        result = 31 * result + Objects.hashCode(this.fileDiffStageTimeTaken);
        result = 31 * result + Objects.hashCode(this.files);
        result = 31 * result + Objects.hashCode(this.filesFetched);
        result = 31 * result + Objects.hashCode(this.filesPercent);
        result = 31 * result + Objects.hashCode(this.filesTotal);
        result = 31 * result + Objects.hashCode(this.finalizeReplicationStageTimeTaken);
        result = 31 * result + Objects.hashCode(this.getCheckpointInfoStageTimeTaken);
        result = 31 * result + Objects.hashCode(this.getFilesStageTimeTaken);
        result = 31 * result + Objects.hashCode(this.lastCompletedLag);
        result = 31 * result + Objects.hashCode(this.rejectedRequests);
        result = 31 * result + Objects.hashCode(this.replicatingStageTimeTaken);
        result = 31 * result + Objects.hashCode(this.shardId);
        result = 31 * result + Objects.hashCode(this.stage);
        result = 31 * result + Objects.hashCode(this.startTime);
        result = 31 * result + Objects.hashCode(this.stopTime);
        result = 31 * result + Objects.hashCode(this.targetHost);
        result = 31 * result + Objects.hashCode(this.targetNode);
        result = 31 * result + Objects.hashCode(this.time);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SegmentReplicationRecord other = (SegmentReplicationRecord) o;
        return Objects.equals(this.bytes, other.bytes)
            && Objects.equals(this.bytesBehind, other.bytesBehind)
            && Objects.equals(this.bytesFetched, other.bytesFetched)
            && Objects.equals(this.bytesPercent, other.bytesPercent)
            && Objects.equals(this.bytesTotal, other.bytesTotal)
            && Objects.equals(this.checkpointsBehind, other.checkpointsBehind)
            && Objects.equals(this.currentLag, other.currentLag)
            && Objects.equals(this.fileDiffStageTimeTaken, other.fileDiffStageTimeTaken)
            && Objects.equals(this.files, other.files)
            && Objects.equals(this.filesFetched, other.filesFetched)
            && Objects.equals(this.filesPercent, other.filesPercent)
            && Objects.equals(this.filesTotal, other.filesTotal)
            && Objects.equals(this.finalizeReplicationStageTimeTaken, other.finalizeReplicationStageTimeTaken)
            && Objects.equals(this.getCheckpointInfoStageTimeTaken, other.getCheckpointInfoStageTimeTaken)
            && Objects.equals(this.getFilesStageTimeTaken, other.getFilesStageTimeTaken)
            && Objects.equals(this.lastCompletedLag, other.lastCompletedLag)
            && Objects.equals(this.rejectedRequests, other.rejectedRequests)
            && Objects.equals(this.replicatingStageTimeTaken, other.replicatingStageTimeTaken)
            && Objects.equals(this.shardId, other.shardId)
            && Objects.equals(this.stage, other.stage)
            && Objects.equals(this.startTime, other.startTime)
            && Objects.equals(this.stopTime, other.stopTime)
            && Objects.equals(this.targetHost, other.targetHost)
            && Objects.equals(this.targetNode, other.targetNode)
            && Objects.equals(this.time, other.time);
    }
}
