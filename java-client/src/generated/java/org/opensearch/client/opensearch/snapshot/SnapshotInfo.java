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

package org.opensearch.client.opensearch.snapshot;

import jakarta.json.stream.JsonGenerator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonData;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.opensearch._types.ShardStatistics;
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: snapshot.SnapshotInfo

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SnapshotInfo implements PlainJsonSerializable {

    @Nonnull
    private final List<String> dataStreams;

    @Nullable
    private final Time duration;

    @Nullable
    private final Long durationInMillis;

    @Nullable
    private final String endTime;

    @Nullable
    private final Long endTimeInMillis;

    @Nonnull
    private final List<SnapshotShardFailure> failures;

    @Nullable
    private final Boolean includeGlobalState;

    @Nonnull
    private final List<String> indices;

    @Nonnull
    private final Map<String, JsonData> metadata;

    @Nullable
    private final Long pinnedTimestamp;

    @Nullable
    private final String reason;

    @Nullable
    private final Boolean remoteStoreIndexShallowCopy;

    @Nullable
    private final ShardStatistics shards;

    @Nonnull
    private final String snapshot;

    @Nullable
    private final String startTime;

    @Nullable
    private final Long startTimeInMillis;

    @Nullable
    private final String state;

    @Nonnull
    private final String uuid;

    @Nullable
    private final String version;

    @Nullable
    private final Long versionId;

    // ---------------------------------------------------------------------------------------------

    private SnapshotInfo(Builder builder) {
        this.dataStreams = ApiTypeHelper.unmodifiableRequired(builder.dataStreams, this, "dataStreams");
        this.duration = builder.duration;
        this.durationInMillis = builder.durationInMillis;
        this.endTime = builder.endTime;
        this.endTimeInMillis = builder.endTimeInMillis;
        this.failures = ApiTypeHelper.unmodifiable(builder.failures);
        this.includeGlobalState = builder.includeGlobalState;
        this.indices = ApiTypeHelper.unmodifiable(builder.indices);
        this.metadata = ApiTypeHelper.unmodifiable(builder.metadata);
        this.pinnedTimestamp = builder.pinnedTimestamp;
        this.reason = builder.reason;
        this.remoteStoreIndexShallowCopy = builder.remoteStoreIndexShallowCopy;
        this.shards = builder.shards;
        this.snapshot = ApiTypeHelper.requireNonNull(builder.snapshot, this, "snapshot");
        this.startTime = builder.startTime;
        this.startTimeInMillis = builder.startTimeInMillis;
        this.state = builder.state;
        this.uuid = ApiTypeHelper.requireNonNull(builder.uuid, this, "uuid");
        this.version = builder.version;
        this.versionId = builder.versionId;
    }

    public static SnapshotInfo of(Function<SnapshotInfo.Builder, ObjectBuilder<SnapshotInfo>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code data_streams}
     */
    @Nonnull
    public final List<String> dataStreams() {
        return this.dataStreams;
    }

    /**
     * API name: {@code duration}
     */
    @Nullable
    public final Time duration() {
        return this.duration;
    }

    /**
     * API name: {@code duration_in_millis}
     */
    @Nullable
    public final Long durationInMillis() {
        return this.durationInMillis;
    }

    /**
     * API name: {@code end_time}
     */
    @Nullable
    public final String endTime() {
        return this.endTime;
    }

    /**
     * API name: {@code end_time_in_millis}
     */
    @Nullable
    public final Long endTimeInMillis() {
        return this.endTimeInMillis;
    }

    /**
     * API name: {@code failures}
     */
    @Nonnull
    public final List<SnapshotShardFailure> failures() {
        return this.failures;
    }

    /**
     * API name: {@code include_global_state}
     */
    @Nullable
    public final Boolean includeGlobalState() {
        return this.includeGlobalState;
    }

    /**
     * API name: {@code indices}
     */
    @Nonnull
    public final List<String> indices() {
        return this.indices;
    }

    /**
     * API name: {@code metadata}
     */
    @Nonnull
    public final Map<String, JsonData> metadata() {
        return this.metadata;
    }

    /**
     * API name: {@code pinned_timestamp}
     */
    @Nullable
    public final Long pinnedTimestamp() {
        return this.pinnedTimestamp;
    }

    /**
     * API name: {@code reason}
     */
    @Nullable
    public final String reason() {
        return this.reason;
    }

    /**
     * API name: {@code remote_store_index_shallow_copy}
     */
    @Nullable
    public final Boolean remoteStoreIndexShallowCopy() {
        return this.remoteStoreIndexShallowCopy;
    }

    /**
     * API name: {@code shards}
     */
    @Nullable
    public final ShardStatistics shards() {
        return this.shards;
    }

    /**
     * Required - API name: {@code snapshot}
     */
    @Nonnull
    public final String snapshot() {
        return this.snapshot;
    }

    /**
     * API name: {@code start_time}
     */
    @Nullable
    public final String startTime() {
        return this.startTime;
    }

    /**
     * API name: {@code start_time_in_millis}
     */
    @Nullable
    public final Long startTimeInMillis() {
        return this.startTimeInMillis;
    }

    /**
     * API name: {@code state}
     */
    @Nullable
    public final String state() {
        return this.state;
    }

    /**
     * Required - API name: {@code uuid}
     */
    @Nonnull
    public final String uuid() {
        return this.uuid;
    }

    /**
     * API name: {@code version}
     */
    @Nullable
    public final String version() {
        return this.version;
    }

    /**
     * API name: {@code version_id}
     */
    @Nullable
    public final Long versionId() {
        return this.versionId;
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
        generator.writeKey("data_streams");
        generator.writeStartArray();
        for (String item0 : this.dataStreams) {
            generator.write(item0);
        }
        generator.writeEnd();

        if (this.duration != null) {
            generator.writeKey("duration");
            this.duration.serialize(generator, mapper);
        }

        if (this.durationInMillis != null) {
            generator.writeKey("duration_in_millis");
            generator.write(this.durationInMillis);
        }

        if (this.endTime != null) {
            generator.writeKey("end_time");
            generator.write(this.endTime);
        }

        if (this.endTimeInMillis != null) {
            generator.writeKey("end_time_in_millis");
            generator.write(this.endTimeInMillis);
        }

        if (ApiTypeHelper.isDefined(this.failures)) {
            generator.writeKey("failures");
            generator.writeStartArray();
            for (SnapshotShardFailure item0 : this.failures) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.includeGlobalState != null) {
            generator.writeKey("include_global_state");
            generator.write(this.includeGlobalState);
        }

        if (ApiTypeHelper.isDefined(this.indices)) {
            generator.writeKey("indices");
            generator.writeStartArray();
            for (String item0 : this.indices) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.metadata)) {
            generator.writeKey("metadata");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.metadata.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.pinnedTimestamp != null) {
            generator.writeKey("pinned_timestamp");
            generator.write(this.pinnedTimestamp);
        }

        if (this.reason != null) {
            generator.writeKey("reason");
            generator.write(this.reason);
        }

        if (this.remoteStoreIndexShallowCopy != null) {
            generator.writeKey("remote_store_index_shallow_copy");
            generator.write(this.remoteStoreIndexShallowCopy);
        }

        if (this.shards != null) {
            generator.writeKey("shards");
            this.shards.serialize(generator, mapper);
        }

        generator.writeKey("snapshot");
        generator.write(this.snapshot);

        if (this.startTime != null) {
            generator.writeKey("start_time");
            generator.write(this.startTime);
        }

        if (this.startTimeInMillis != null) {
            generator.writeKey("start_time_in_millis");
            generator.write(this.startTimeInMillis);
        }

        if (this.state != null) {
            generator.writeKey("state");
            generator.write(this.state);
        }

        generator.writeKey("uuid");
        generator.write(this.uuid);

        if (this.version != null) {
            generator.writeKey("version");
            generator.write(this.version);
        }

        if (this.versionId != null) {
            generator.writeKey("version_id");
            generator.write(this.versionId);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link SnapshotInfo}.
     */
    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<SnapshotInfo> {
        private List<String> dataStreams;
        @Nullable
        private Time duration;
        @Nullable
        private Long durationInMillis;
        @Nullable
        private String endTime;
        @Nullable
        private Long endTimeInMillis;
        @Nullable
        private List<SnapshotShardFailure> failures;
        @Nullable
        private Boolean includeGlobalState;
        @Nullable
        private List<String> indices;
        @Nullable
        private Map<String, JsonData> metadata;
        @Nullable
        private Long pinnedTimestamp;
        @Nullable
        private String reason;
        @Nullable
        private Boolean remoteStoreIndexShallowCopy;
        @Nullable
        private ShardStatistics shards;
        private String snapshot;
        @Nullable
        private String startTime;
        @Nullable
        private Long startTimeInMillis;
        @Nullable
        private String state;
        private String uuid;
        @Nullable
        private String version;
        @Nullable
        private Long versionId;

        /**
         * Required - API name: {@code data_streams}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>dataStreams</code>.
         * </p>
         */
        public final Builder dataStreams(List<String> list) {
            this.dataStreams = _listAddAll(this.dataStreams, list);
            return this;
        }

        /**
         * Required - API name: {@code data_streams}
         *
         * <p>
         * Adds one or more values to <code>dataStreams</code>.
         * </p>
         */
        public final Builder dataStreams(String value, String... values) {
            this.dataStreams = _listAdd(this.dataStreams, value, values);
            return this;
        }

        /**
         * API name: {@code duration}
         */
        public final Builder duration(@Nullable Time value) {
            this.duration = value;
            return this;
        }

        /**
         * API name: {@code duration}
         */
        public final Builder duration(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return duration(fn.apply(new Time.Builder()).build());
        }

        /**
         * API name: {@code duration_in_millis}
         */
        public final Builder durationInMillis(@Nullable Long value) {
            this.durationInMillis = value;
            return this;
        }

        /**
         * API name: {@code end_time}
         */
        public final Builder endTime(@Nullable String value) {
            this.endTime = value;
            return this;
        }

        /**
         * API name: {@code end_time_in_millis}
         */
        public final Builder endTimeInMillis(@Nullable Long value) {
            this.endTimeInMillis = value;
            return this;
        }

        /**
         * API name: {@code failures}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>failures</code>.
         * </p>
         */
        public final Builder failures(List<SnapshotShardFailure> list) {
            this.failures = _listAddAll(this.failures, list);
            return this;
        }

        /**
         * API name: {@code failures}
         *
         * <p>
         * Adds one or more values to <code>failures</code>.
         * </p>
         */
        public final Builder failures(SnapshotShardFailure value, SnapshotShardFailure... values) {
            this.failures = _listAdd(this.failures, value, values);
            return this;
        }

        /**
         * API name: {@code failures}
         *
         * <p>
         * Adds a value to <code>failures</code> using a builder lambda.
         * </p>
         */
        public final Builder failures(Function<SnapshotShardFailure.Builder, ObjectBuilder<SnapshotShardFailure>> fn) {
            return failures(fn.apply(new SnapshotShardFailure.Builder()).build());
        }

        /**
         * API name: {@code include_global_state}
         */
        public final Builder includeGlobalState(@Nullable Boolean value) {
            this.includeGlobalState = value;
            return this;
        }

        /**
         * API name: {@code indices}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>indices</code>.
         * </p>
         */
        public final Builder indices(List<String> list) {
            this.indices = _listAddAll(this.indices, list);
            return this;
        }

        /**
         * API name: {@code indices}
         *
         * <p>
         * Adds one or more values to <code>indices</code>.
         * </p>
         */
        public final Builder indices(String value, String... values) {
            this.indices = _listAdd(this.indices, value, values);
            return this;
        }

        /**
         * API name: {@code metadata}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>metadata</code>.
         * </p>
         */
        public final Builder metadata(Map<String, JsonData> map) {
            this.metadata = _mapPutAll(this.metadata, map);
            return this;
        }

        /**
         * API name: {@code metadata}
         *
         * <p>
         * Adds an entry to <code>metadata</code>.
         * </p>
         */
        public final Builder metadata(String key, JsonData value) {
            this.metadata = _mapPut(this.metadata, key, value);
            return this;
        }

        /**
         * API name: {@code pinned_timestamp}
         */
        public final Builder pinnedTimestamp(@Nullable Long value) {
            this.pinnedTimestamp = value;
            return this;
        }

        /**
         * API name: {@code reason}
         */
        public final Builder reason(@Nullable String value) {
            this.reason = value;
            return this;
        }

        /**
         * API name: {@code remote_store_index_shallow_copy}
         */
        public final Builder remoteStoreIndexShallowCopy(@Nullable Boolean value) {
            this.remoteStoreIndexShallowCopy = value;
            return this;
        }

        /**
         * API name: {@code shards}
         */
        public final Builder shards(@Nullable ShardStatistics value) {
            this.shards = value;
            return this;
        }

        /**
         * API name: {@code shards}
         */
        public final Builder shards(Function<ShardStatistics.Builder, ObjectBuilder<ShardStatistics>> fn) {
            return shards(fn.apply(new ShardStatistics.Builder()).build());
        }

        /**
         * Required - API name: {@code snapshot}
         */
        public final Builder snapshot(String value) {
            this.snapshot = value;
            return this;
        }

        /**
         * API name: {@code start_time}
         */
        public final Builder startTime(@Nullable String value) {
            this.startTime = value;
            return this;
        }

        /**
         * API name: {@code start_time_in_millis}
         */
        public final Builder startTimeInMillis(@Nullable Long value) {
            this.startTimeInMillis = value;
            return this;
        }

        /**
         * API name: {@code state}
         */
        public final Builder state(@Nullable String value) {
            this.state = value;
            return this;
        }

        /**
         * Required - API name: {@code uuid}
         */
        public final Builder uuid(String value) {
            this.uuid = value;
            return this;
        }

        /**
         * API name: {@code version}
         */
        public final Builder version(@Nullable String value) {
            this.version = value;
            return this;
        }

        /**
         * API name: {@code version_id}
         */
        public final Builder versionId(@Nullable Long value) {
            this.versionId = value;
            return this;
        }

        /**
         * Builds a {@link SnapshotInfo}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public SnapshotInfo build() {
            _checkSingleUse();

            return new SnapshotInfo(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SnapshotInfo}
     */
    public static final JsonpDeserializer<SnapshotInfo> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SnapshotInfo::setupSnapshotInfoDeserializer
    );

    protected static void setupSnapshotInfoDeserializer(ObjectDeserializer<SnapshotInfo.Builder> op) {
        op.add(Builder::dataStreams, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "data_streams");
        op.add(Builder::duration, Time._DESERIALIZER, "duration");
        op.add(Builder::durationInMillis, JsonpDeserializer.longDeserializer(), "duration_in_millis");
        op.add(Builder::endTime, JsonpDeserializer.stringDeserializer(), "end_time");
        op.add(Builder::endTimeInMillis, JsonpDeserializer.longDeserializer(), "end_time_in_millis");
        op.add(Builder::failures, JsonpDeserializer.arrayDeserializer(SnapshotShardFailure._DESERIALIZER), "failures");
        op.add(Builder::includeGlobalState, JsonpDeserializer.booleanDeserializer(), "include_global_state");
        op.add(Builder::indices, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "indices");
        op.add(Builder::metadata, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "metadata");
        op.add(Builder::pinnedTimestamp, JsonpDeserializer.longDeserializer(), "pinned_timestamp");
        op.add(Builder::reason, JsonpDeserializer.stringDeserializer(), "reason");
        op.add(Builder::remoteStoreIndexShallowCopy, JsonpDeserializer.booleanDeserializer(), "remote_store_index_shallow_copy");
        op.add(Builder::shards, ShardStatistics._DESERIALIZER, "shards");
        op.add(Builder::snapshot, JsonpDeserializer.stringDeserializer(), "snapshot");
        op.add(Builder::startTime, JsonpDeserializer.stringDeserializer(), "start_time");
        op.add(Builder::startTimeInMillis, JsonpDeserializer.longDeserializer(), "start_time_in_millis");
        op.add(Builder::state, JsonpDeserializer.stringDeserializer(), "state");
        op.add(Builder::uuid, JsonpDeserializer.stringDeserializer(), "uuid");
        op.add(Builder::version, JsonpDeserializer.stringDeserializer(), "version");
        op.add(Builder::versionId, JsonpDeserializer.longDeserializer(), "version_id");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.dataStreams.hashCode();
        result = 31 * result + Objects.hashCode(this.duration);
        result = 31 * result + Objects.hashCode(this.durationInMillis);
        result = 31 * result + Objects.hashCode(this.endTime);
        result = 31 * result + Objects.hashCode(this.endTimeInMillis);
        result = 31 * result + Objects.hashCode(this.failures);
        result = 31 * result + Objects.hashCode(this.includeGlobalState);
        result = 31 * result + Objects.hashCode(this.indices);
        result = 31 * result + Objects.hashCode(this.metadata);
        result = 31 * result + Objects.hashCode(this.pinnedTimestamp);
        result = 31 * result + Objects.hashCode(this.reason);
        result = 31 * result + Objects.hashCode(this.remoteStoreIndexShallowCopy);
        result = 31 * result + Objects.hashCode(this.shards);
        result = 31 * result + this.snapshot.hashCode();
        result = 31 * result + Objects.hashCode(this.startTime);
        result = 31 * result + Objects.hashCode(this.startTimeInMillis);
        result = 31 * result + Objects.hashCode(this.state);
        result = 31 * result + this.uuid.hashCode();
        result = 31 * result + Objects.hashCode(this.version);
        result = 31 * result + Objects.hashCode(this.versionId);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SnapshotInfo other = (SnapshotInfo) o;
        return this.dataStreams.equals(other.dataStreams)
            && Objects.equals(this.duration, other.duration)
            && Objects.equals(this.durationInMillis, other.durationInMillis)
            && Objects.equals(this.endTime, other.endTime)
            && Objects.equals(this.endTimeInMillis, other.endTimeInMillis)
            && Objects.equals(this.failures, other.failures)
            && Objects.equals(this.includeGlobalState, other.includeGlobalState)
            && Objects.equals(this.indices, other.indices)
            && Objects.equals(this.metadata, other.metadata)
            && Objects.equals(this.pinnedTimestamp, other.pinnedTimestamp)
            && Objects.equals(this.reason, other.reason)
            && Objects.equals(this.remoteStoreIndexShallowCopy, other.remoteStoreIndexShallowCopy)
            && Objects.equals(this.shards, other.shards)
            && this.snapshot.equals(other.snapshot)
            && Objects.equals(this.startTime, other.startTime)
            && Objects.equals(this.startTimeInMillis, other.startTimeInMillis)
            && Objects.equals(this.state, other.state)
            && this.uuid.equals(other.uuid)
            && Objects.equals(this.version, other.version)
            && Objects.equals(this.versionId, other.versionId);
    }
}
