/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

// ----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
// ----------------------------------------------------

package org.opensearch.client.opensearch;

import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.JsonpSerializable;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.opensearch.*;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import jakarta.json.stream.JsonGenerator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import javax.annotation.Nullable;

@JsonpDeserializable
public class CatSegmentReplicationRecord implements JsonpSerializable {

    @Nullable private final String bytes;

    @Nullable private final String bytesBehind;

    @Nullable private final String bytesFetched;

    @Nullable private final String bytesPercent;

    @Nullable private final String bytesTotal;

    @Nullable private final String checkpointsBehind;

    @Nullable private final String currentLag;

    @Nullable private final String fileDiffStageTimeTaken;

    @Nullable private final String files;

    @Nullable private final String filesFetched;

    @Nullable private final String filesPercent;

    @Nullable private final String filesTotal;

    @Nullable private final String finalizeReplicationStageTimeTaken;

    @Nullable private final String getCheckpointInfoStageTimeTaken;

    @Nullable private final String getFilesStageTimeTaken;

    @Nullable private final String lastCompletedLag;

    @Nullable private final String rejectedRequests;

    @Nullable private final String replicatingStageTimeTaken;

    @Nullable private final String shardId;

    @Nullable private final String stage;

    @Nullable private final String startTime;

    @Nullable private final String stopTime;

    @Nullable private final String targetHost;

    @Nullable private final String targetNode;

    @Nullable private final String time;

    public CatSegmentReplicationRecord(Builder builder) {
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

    public static CatSegmentReplicationRecord of(
            Function<Builder, ObjectBuilder<CatSegmentReplicationRecord>> fn) {
        return fn.apply(new Builder()).build();
    }

    public final String bytes() {
        return this.bytes;
    }

    public final String bytesBehind() {
        return this.bytesBehind;
    }

    public final String bytesFetched() {
        return this.bytesFetched;
    }

    public final String bytesPercent() {
        return this.bytesPercent;
    }

    public final String bytesTotal() {
        return this.bytesTotal;
    }

    public final String checkpointsBehind() {
        return this.checkpointsBehind;
    }

    public final String currentLag() {
        return this.currentLag;
    }

    public final String fileDiffStageTimeTaken() {
        return this.fileDiffStageTimeTaken;
    }

    public final String files() {
        return this.files;
    }

    public final String filesFetched() {
        return this.filesFetched;
    }

    public final String filesPercent() {
        return this.filesPercent;
    }

    public final String filesTotal() {
        return this.filesTotal;
    }

    public final String finalizeReplicationStageTimeTaken() {
        return this.finalizeReplicationStageTimeTaken;
    }

    public final String getCheckpointInfoStageTimeTaken() {
        return this.getCheckpointInfoStageTimeTaken;
    }

    public final String getFilesStageTimeTaken() {
        return this.getFilesStageTimeTaken;
    }

    public final String lastCompletedLag() {
        return this.lastCompletedLag;
    }

    public final String rejectedRequests() {
        return this.rejectedRequests;
    }

    public final String replicatingStageTimeTaken() {
        return this.replicatingStageTimeTaken;
    }

    public final String shardId() {
        return this.shardId;
    }

    public final String stage() {
        return this.stage;
    }

    public final String startTime() {
        return this.startTime;
    }

    public final String stopTime() {
        return this.stopTime;
    }

    public final String targetHost() {
        return this.targetHost;
    }

    public final String targetNode() {
        return this.targetNode;
    }

    public final String time() {
        return this.time;
    }

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

    /** Builder for {@link CatSegmentReplicationRecord}. */
    public static class Builder extends ObjectBuilderBase
            implements ObjectBuilder<CatSegmentReplicationRecord> {
        private String bytes;
        private String bytesBehind;
        private String bytesFetched;
        private String bytesPercent;
        private String bytesTotal;
        private String checkpointsBehind;
        private String currentLag;
        private String fileDiffStageTimeTaken;
        private String files;
        private String filesFetched;
        private String filesPercent;
        private String filesTotal;
        private String finalizeReplicationStageTimeTaken;
        private String getCheckpointInfoStageTimeTaken;
        private String getFilesStageTimeTaken;
        private String lastCompletedLag;
        private String rejectedRequests;
        private String replicatingStageTimeTaken;
        private String shardId;
        private String stage;
        private String startTime;
        private String stopTime;
        private String targetHost;
        private String targetNode;
        private String time;

        public final Builder bytes(String value) {
            this.bytes = value;
            return this;
        }

        public final Builder bytesBehind(String value) {
            this.bytesBehind = value;
            return this;
        }

        public final Builder bytesFetched(String value) {
            this.bytesFetched = value;
            return this;
        }

        public final Builder bytesPercent(String value) {
            this.bytesPercent = value;
            return this;
        }

        public final Builder bytesTotal(String value) {
            this.bytesTotal = value;
            return this;
        }

        public final Builder checkpointsBehind(String value) {
            this.checkpointsBehind = value;
            return this;
        }

        public final Builder currentLag(String value) {
            this.currentLag = value;
            return this;
        }

        public final Builder fileDiffStageTimeTaken(String value) {
            this.fileDiffStageTimeTaken = value;
            return this;
        }

        public final Builder files(String value) {
            this.files = value;
            return this;
        }

        public final Builder filesFetched(String value) {
            this.filesFetched = value;
            return this;
        }

        public final Builder filesPercent(String value) {
            this.filesPercent = value;
            return this;
        }

        public final Builder filesTotal(String value) {
            this.filesTotal = value;
            return this;
        }

        public final Builder finalizeReplicationStageTimeTaken(String value) {
            this.finalizeReplicationStageTimeTaken = value;
            return this;
        }

        public final Builder getCheckpointInfoStageTimeTaken(String value) {
            this.getCheckpointInfoStageTimeTaken = value;
            return this;
        }

        public final Builder getFilesStageTimeTaken(String value) {
            this.getFilesStageTimeTaken = value;
            return this;
        }

        public final Builder lastCompletedLag(String value) {
            this.lastCompletedLag = value;
            return this;
        }

        public final Builder rejectedRequests(String value) {
            this.rejectedRequests = value;
            return this;
        }

        public final Builder replicatingStageTimeTaken(String value) {
            this.replicatingStageTimeTaken = value;
            return this;
        }

        public final Builder shardId(String value) {
            this.shardId = value;
            return this;
        }

        public final Builder stage(String value) {
            this.stage = value;
            return this;
        }

        public final Builder startTime(String value) {
            this.startTime = value;
            return this;
        }

        public final Builder stopTime(String value) {
            this.stopTime = value;
            return this;
        }

        public final Builder targetHost(String value) {
            this.targetHost = value;
            return this;
        }

        public final Builder targetNode(String value) {
            this.targetNode = value;
            return this;
        }

        public final Builder time(String value) {
            this.time = value;
            return this;
        }

        /**
         * Builds a {@link CatSegmentReplicationRecord}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public CatSegmentReplicationRecord build() {
            _checkSingleUse();

            return new CatSegmentReplicationRecord(this);
        }
    }

    public static final JsonpDeserializer<CatSegmentReplicationRecord> _DESERIALIZER =
            ObjectBuilderDeserializer.lazy(
                    Builder::new,
                    CatSegmentReplicationRecord::setupCatSegmentReplicationRecordDeserializer);

    protected static void setupCatSegmentReplicationRecordDeserializer(
            ObjectDeserializer<CatSegmentReplicationRecord.Builder> op) {
        op.add(Builder::bytes, JsonpDeserializer.stringDeserializer(), "bytes");
        op.add(Builder::bytesBehind, JsonpDeserializer.stringDeserializer(), "bytes_behind");
        op.add(Builder::bytesFetched, JsonpDeserializer.stringDeserializer(), "bytes_fetched");
        op.add(Builder::bytesPercent, JsonpDeserializer.stringDeserializer(), "bytes_percent");
        op.add(Builder::bytesTotal, JsonpDeserializer.stringDeserializer(), "bytes_total");
        op.add(
                Builder::checkpointsBehind,
                JsonpDeserializer.stringDeserializer(),
                "checkpoints_behind");
        op.add(Builder::currentLag, JsonpDeserializer.stringDeserializer(), "current_lag");
        op.add(
                Builder::fileDiffStageTimeTaken,
                JsonpDeserializer.stringDeserializer(),
                "file_diff_stage_time_taken");
        op.add(Builder::files, JsonpDeserializer.stringDeserializer(), "files");
        op.add(Builder::filesFetched, JsonpDeserializer.stringDeserializer(), "files_fetched");
        op.add(Builder::filesPercent, JsonpDeserializer.stringDeserializer(), "files_percent");
        op.add(Builder::filesTotal, JsonpDeserializer.stringDeserializer(), "files_total");
        op.add(
                Builder::finalizeReplicationStageTimeTaken,
                JsonpDeserializer.stringDeserializer(),
                "finalize_replication_stage_time_taken");
        op.add(
                Builder::getCheckpointInfoStageTimeTaken,
                JsonpDeserializer.stringDeserializer(),
                "get_checkpoint_info_stage_time_taken");
        op.add(
                Builder::getFilesStageTimeTaken,
                JsonpDeserializer.stringDeserializer(),
                "get_files_stage_time_taken");
        op.add(
                Builder::lastCompletedLag,
                JsonpDeserializer.stringDeserializer(),
                "last_completed_lag");
        op.add(
                Builder::rejectedRequests,
                JsonpDeserializer.stringDeserializer(),
                "rejected_requests");
        op.add(
                Builder::replicatingStageTimeTaken,
                JsonpDeserializer.stringDeserializer(),
                "replicating_stage_time_taken");
        op.add(Builder::shardId, JsonpDeserializer.stringDeserializer(), "shardId");
        op.add(Builder::stage, JsonpDeserializer.stringDeserializer(), "stage");
        op.add(Builder::startTime, JsonpDeserializer.stringDeserializer(), "start_time");
        op.add(Builder::stopTime, JsonpDeserializer.stringDeserializer(), "stop_time");
        op.add(Builder::targetHost, JsonpDeserializer.stringDeserializer(), "target_host");
        op.add(Builder::targetNode, JsonpDeserializer.stringDeserializer(), "target_node");
        op.add(Builder::time, JsonpDeserializer.stringDeserializer(), "time");
    }
}
