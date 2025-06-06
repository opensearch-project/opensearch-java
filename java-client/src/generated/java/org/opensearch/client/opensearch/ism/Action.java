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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ism.Action

/**
 * An action to perform.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Action implements PlainJsonSerializable, ToCopyableBuilder<Action.Builder, Action> {

    @Nullable
    private final ActionAlias alias;

    @Nullable
    private final ActionAllocation allocation;

    @Nullable
    private final ActionClose close;

    @Nonnull
    private final Map<String, JsonData> custom;

    @Nullable
    private final ActionDelete delete;

    @Nullable
    private final ActionForceMerge forceMerge;

    @Nullable
    private final ActionIndexPriority indexPriority;

    @Nonnull
    private final Map<String, JsonData> notification;

    @Nullable
    private final ActionOpen open;

    @Nullable
    private final ActionReadOnly readOnly;

    @Nullable
    private final ActionReadWrite readWrite;

    @Nullable
    private final ActionReplicaCount replicaCount;

    @Nullable
    private final ActionRetry retry;

    @Nullable
    private final ActionRollover rollover;

    @Nonnull
    private final Map<String, JsonData> rollup;

    @Nonnull
    private final Map<String, JsonData> shrink;

    @Nullable
    private final ActionSnapshot snapshot;

    @Nullable
    private final ActionTimeout timeout;

    @Nonnull
    private final Map<String, JsonData> transform;

    // ---------------------------------------------------------------------------------------------

    private Action(Builder builder) {
        this.alias = builder.alias;
        this.allocation = builder.allocation;
        this.close = builder.close;
        this.custom = ApiTypeHelper.unmodifiable(builder.custom);
        this.delete = builder.delete;
        this.forceMerge = builder.forceMerge;
        this.indexPriority = builder.indexPriority;
        this.notification = ApiTypeHelper.unmodifiable(builder.notification);
        this.open = builder.open;
        this.readOnly = builder.readOnly;
        this.readWrite = builder.readWrite;
        this.replicaCount = builder.replicaCount;
        this.retry = builder.retry;
        this.rollover = builder.rollover;
        this.rollup = ApiTypeHelper.unmodifiable(builder.rollup);
        this.shrink = ApiTypeHelper.unmodifiable(builder.shrink);
        this.snapshot = builder.snapshot;
        this.timeout = builder.timeout;
        this.transform = ApiTypeHelper.unmodifiable(builder.transform);
    }

    public static Action of(Function<Action.Builder, ObjectBuilder<Action>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Adds or removes an index alias.
     * <p>
     * API name: {@code alias}
     * </p>
     */
    @Nullable
    public final ActionAlias alias() {
        return this.alias;
    }

    /**
     * Sets the allocations settings for index.
     * <p>
     * API name: {@code allocation}
     * </p>
     */
    @Nullable
    public final ActionAllocation allocation() {
        return this.allocation;
    }

    /**
     * Closes an index.
     * <p>
     * API name: {@code close}
     * </p>
     */
    @Nullable
    public final ActionClose close() {
        return this.close;
    }

    /**
     * Enables custom operations to be performed on the index.
     * <p>
     * API name: {@code custom}
     * </p>
     */
    @Nonnull
    public final Map<String, JsonData> custom() {
        return this.custom;
    }

    /**
     * Deletes an index.
     * <p>
     * API name: {@code delete}
     * </p>
     */
    @Nullable
    public final ActionDelete delete() {
        return this.delete;
    }

    /**
     * Force merges an index.
     * <p>
     * API name: {@code force_merge}
     * </p>
     */
    @Nullable
    public final ActionForceMerge forceMerge() {
        return this.forceMerge;
    }

    /**
     * The priority level of the index.
     * <p>
     * API name: {@code index_priority}
     * </p>
     */
    @Nullable
    public final ActionIndexPriority indexPriority() {
        return this.indexPriority;
    }

    /**
     * Sets a policy which determines when to send a notification regarding the index.
     * <p>
     * API name: {@code notification}
     * </p>
     */
    @Nonnull
    public final Map<String, JsonData> notification() {
        return this.notification;
    }

    /**
     * Opens an index.
     * <p>
     * API name: {@code open}
     * </p>
     */
    @Nullable
    public final ActionOpen open() {
        return this.open;
    }

    /**
     * Changes the index permissions to read-only.
     * <p>
     * API name: {@code read_only}
     * </p>
     */
    @Nullable
    public final ActionReadOnly readOnly() {
        return this.readOnly;
    }

    /**
     * Changes the index permissions to read-write.
     * <p>
     * API name: {@code read_write}
     * </p>
     */
    @Nullable
    public final ActionReadWrite readWrite() {
        return this.readWrite;
    }

    /**
     * The number of replicas for the index.
     * <p>
     * API name: {@code replica_count}
     * </p>
     */
    @Nullable
    public final ActionReplicaCount replicaCount() {
        return this.replicaCount;
    }

    /**
     * The number of times to retry the action.
     * <p>
     * API name: {@code retry}
     * </p>
     */
    @Nullable
    public final ActionRetry retry() {
        return this.retry;
    }

    /**
     * Sets a rollover policy for the index.
     * <p>
     * API name: {@code rollover}
     * </p>
     */
    @Nullable
    public final ActionRollover rollover() {
        return this.rollover;
    }

    /**
     * Determines when to perform an index rollup.
     * <p>
     * API name: {@code rollup}
     * </p>
     */
    @Nonnull
    public final Map<String, JsonData> rollup() {
        return this.rollup;
    }

    /**
     * Determines when to shrink the index.
     * <p>
     * API name: {@code shrink}
     * </p>
     */
    @Nonnull
    public final Map<String, JsonData> shrink() {
        return this.shrink;
    }

    /**
     * Takes a snapshot of the index.
     * <p>
     * API name: {@code snapshot}
     * </p>
     */
    @Nullable
    public final ActionSnapshot snapshot() {
        return this.snapshot;
    }

    /**
     * The amount of time to wait before the action fails.
     * <p>
     * API name: {@code timeout}
     * </p>
     */
    @Nullable
    public final ActionTimeout timeout() {
        return this.timeout;
    }

    /**
     * Determines when to perform an index transform.
     * <p>
     * API name: {@code transform}
     * </p>
     */
    @Nonnull
    public final Map<String, JsonData> transform() {
        return this.transform;
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
        if (this.alias != null) {
            generator.writeKey("alias");
            this.alias.serialize(generator, mapper);
        }

        if (this.allocation != null) {
            generator.writeKey("allocation");
            this.allocation.serialize(generator, mapper);
        }

        if (this.close != null) {
            generator.writeKey("close");
            this.close.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.custom)) {
            generator.writeKey("custom");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.custom.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.delete != null) {
            generator.writeKey("delete");
            this.delete.serialize(generator, mapper);
        }

        if (this.forceMerge != null) {
            generator.writeKey("force_merge");
            this.forceMerge.serialize(generator, mapper);
        }

        if (this.indexPriority != null) {
            generator.writeKey("index_priority");
            this.indexPriority.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.notification)) {
            generator.writeKey("notification");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.notification.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.open != null) {
            generator.writeKey("open");
            this.open.serialize(generator, mapper);
        }

        if (this.readOnly != null) {
            generator.writeKey("read_only");
            this.readOnly.serialize(generator, mapper);
        }

        if (this.readWrite != null) {
            generator.writeKey("read_write");
            this.readWrite.serialize(generator, mapper);
        }

        if (this.replicaCount != null) {
            generator.writeKey("replica_count");
            this.replicaCount.serialize(generator, mapper);
        }

        if (this.retry != null) {
            generator.writeKey("retry");
            this.retry.serialize(generator, mapper);
        }

        if (this.rollover != null) {
            generator.writeKey("rollover");
            this.rollover.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.rollup)) {
            generator.writeKey("rollup");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.rollup.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.shrink)) {
            generator.writeKey("shrink");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.shrink.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.snapshot != null) {
            generator.writeKey("snapshot");
            this.snapshot.serialize(generator, mapper);
        }

        if (this.timeout != null) {
            generator.writeKey("timeout");
            this.timeout.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.transform)) {
            generator.writeKey("transform");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.transform.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
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
     * Builder for {@link Action}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, Action> {
        @Nullable
        private ActionAlias alias;
        @Nullable
        private ActionAllocation allocation;
        @Nullable
        private ActionClose close;
        @Nullable
        private Map<String, JsonData> custom;
        @Nullable
        private ActionDelete delete;
        @Nullable
        private ActionForceMerge forceMerge;
        @Nullable
        private ActionIndexPriority indexPriority;
        @Nullable
        private Map<String, JsonData> notification;
        @Nullable
        private ActionOpen open;
        @Nullable
        private ActionReadOnly readOnly;
        @Nullable
        private ActionReadWrite readWrite;
        @Nullable
        private ActionReplicaCount replicaCount;
        @Nullable
        private ActionRetry retry;
        @Nullable
        private ActionRollover rollover;
        @Nullable
        private Map<String, JsonData> rollup;
        @Nullable
        private Map<String, JsonData> shrink;
        @Nullable
        private ActionSnapshot snapshot;
        @Nullable
        private ActionTimeout timeout;
        @Nullable
        private Map<String, JsonData> transform;

        public Builder() {}

        private Builder(Action o) {
            this.alias = o.alias;
            this.allocation = o.allocation;
            this.close = o.close;
            this.custom = _mapCopy(o.custom);
            this.delete = o.delete;
            this.forceMerge = o.forceMerge;
            this.indexPriority = o.indexPriority;
            this.notification = _mapCopy(o.notification);
            this.open = o.open;
            this.readOnly = o.readOnly;
            this.readWrite = o.readWrite;
            this.replicaCount = o.replicaCount;
            this.retry = o.retry;
            this.rollover = o.rollover;
            this.rollup = _mapCopy(o.rollup);
            this.shrink = _mapCopy(o.shrink);
            this.snapshot = o.snapshot;
            this.timeout = o.timeout;
            this.transform = _mapCopy(o.transform);
        }

        private Builder(Builder o) {
            this.alias = o.alias;
            this.allocation = o.allocation;
            this.close = o.close;
            this.custom = _mapCopy(o.custom);
            this.delete = o.delete;
            this.forceMerge = o.forceMerge;
            this.indexPriority = o.indexPriority;
            this.notification = _mapCopy(o.notification);
            this.open = o.open;
            this.readOnly = o.readOnly;
            this.readWrite = o.readWrite;
            this.replicaCount = o.replicaCount;
            this.retry = o.retry;
            this.rollover = o.rollover;
            this.rollup = _mapCopy(o.rollup);
            this.shrink = _mapCopy(o.shrink);
            this.snapshot = o.snapshot;
            this.timeout = o.timeout;
            this.transform = _mapCopy(o.transform);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Adds or removes an index alias.
         * <p>
         * API name: {@code alias}
         * </p>
         */
        @Nonnull
        public final Builder alias(@Nullable ActionAlias value) {
            this.alias = value;
            return this;
        }

        /**
         * Adds or removes an index alias.
         * <p>
         * API name: {@code alias}
         * </p>
         */
        @Nonnull
        public final Builder alias(Function<ActionAlias.Builder, ObjectBuilder<ActionAlias>> fn) {
            return alias(fn.apply(new ActionAlias.Builder()).build());
        }

        /**
         * Sets the allocations settings for index.
         * <p>
         * API name: {@code allocation}
         * </p>
         */
        @Nonnull
        public final Builder allocation(@Nullable ActionAllocation value) {
            this.allocation = value;
            return this;
        }

        /**
         * Sets the allocations settings for index.
         * <p>
         * API name: {@code allocation}
         * </p>
         */
        @Nonnull
        public final Builder allocation(Function<ActionAllocation.Builder, ObjectBuilder<ActionAllocation>> fn) {
            return allocation(fn.apply(new ActionAllocation.Builder()).build());
        }

        /**
         * Closes an index.
         * <p>
         * API name: {@code close}
         * </p>
         */
        @Nonnull
        public final Builder close(@Nullable ActionClose value) {
            this.close = value;
            return this;
        }

        /**
         * Closes an index.
         * <p>
         * API name: {@code close}
         * </p>
         */
        @Nonnull
        public final Builder close(Function<ActionClose.Builder, ObjectBuilder<ActionClose>> fn) {
            return close(fn.apply(new ActionClose.Builder()).build());
        }

        /**
         * Enables custom operations to be performed on the index.
         * <p>
         * API name: {@code custom}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>custom</code>.
         * </p>
         */
        @Nonnull
        public final Builder custom(Map<String, JsonData> map) {
            this.custom = _mapPutAll(this.custom, map);
            return this;
        }

        /**
         * Enables custom operations to be performed on the index.
         * <p>
         * API name: {@code custom}
         * </p>
         *
         * <p>
         * Adds an entry to <code>custom</code>.
         * </p>
         */
        @Nonnull
        public final Builder custom(String key, JsonData value) {
            this.custom = _mapPut(this.custom, key, value);
            return this;
        }

        /**
         * Deletes an index.
         * <p>
         * API name: {@code delete}
         * </p>
         */
        @Nonnull
        public final Builder delete(@Nullable ActionDelete value) {
            this.delete = value;
            return this;
        }

        /**
         * Deletes an index.
         * <p>
         * API name: {@code delete}
         * </p>
         */
        @Nonnull
        public final Builder delete(Function<ActionDelete.Builder, ObjectBuilder<ActionDelete>> fn) {
            return delete(fn.apply(new ActionDelete.Builder()).build());
        }

        /**
         * Force merges an index.
         * <p>
         * API name: {@code force_merge}
         * </p>
         */
        @Nonnull
        public final Builder forceMerge(@Nullable ActionForceMerge value) {
            this.forceMerge = value;
            return this;
        }

        /**
         * Force merges an index.
         * <p>
         * API name: {@code force_merge}
         * </p>
         */
        @Nonnull
        public final Builder forceMerge(Function<ActionForceMerge.Builder, ObjectBuilder<ActionForceMerge>> fn) {
            return forceMerge(fn.apply(new ActionForceMerge.Builder()).build());
        }

        /**
         * The priority level of the index.
         * <p>
         * API name: {@code index_priority}
         * </p>
         */
        @Nonnull
        public final Builder indexPriority(@Nullable ActionIndexPriority value) {
            this.indexPriority = value;
            return this;
        }

        /**
         * The priority level of the index.
         * <p>
         * API name: {@code index_priority}
         * </p>
         */
        @Nonnull
        public final Builder indexPriority(Function<ActionIndexPriority.Builder, ObjectBuilder<ActionIndexPriority>> fn) {
            return indexPriority(fn.apply(new ActionIndexPriority.Builder()).build());
        }

        /**
         * Sets a policy which determines when to send a notification regarding the index.
         * <p>
         * API name: {@code notification}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>notification</code>.
         * </p>
         */
        @Nonnull
        public final Builder notification(Map<String, JsonData> map) {
            this.notification = _mapPutAll(this.notification, map);
            return this;
        }

        /**
         * Sets a policy which determines when to send a notification regarding the index.
         * <p>
         * API name: {@code notification}
         * </p>
         *
         * <p>
         * Adds an entry to <code>notification</code>.
         * </p>
         */
        @Nonnull
        public final Builder notification(String key, JsonData value) {
            this.notification = _mapPut(this.notification, key, value);
            return this;
        }

        /**
         * Opens an index.
         * <p>
         * API name: {@code open}
         * </p>
         */
        @Nonnull
        public final Builder open(@Nullable ActionOpen value) {
            this.open = value;
            return this;
        }

        /**
         * Opens an index.
         * <p>
         * API name: {@code open}
         * </p>
         */
        @Nonnull
        public final Builder open(Function<ActionOpen.Builder, ObjectBuilder<ActionOpen>> fn) {
            return open(fn.apply(new ActionOpen.Builder()).build());
        }

        /**
         * Changes the index permissions to read-only.
         * <p>
         * API name: {@code read_only}
         * </p>
         */
        @Nonnull
        public final Builder readOnly(@Nullable ActionReadOnly value) {
            this.readOnly = value;
            return this;
        }

        /**
         * Changes the index permissions to read-only.
         * <p>
         * API name: {@code read_only}
         * </p>
         */
        @Nonnull
        public final Builder readOnly(Function<ActionReadOnly.Builder, ObjectBuilder<ActionReadOnly>> fn) {
            return readOnly(fn.apply(new ActionReadOnly.Builder()).build());
        }

        /**
         * Changes the index permissions to read-write.
         * <p>
         * API name: {@code read_write}
         * </p>
         */
        @Nonnull
        public final Builder readWrite(@Nullable ActionReadWrite value) {
            this.readWrite = value;
            return this;
        }

        /**
         * Changes the index permissions to read-write.
         * <p>
         * API name: {@code read_write}
         * </p>
         */
        @Nonnull
        public final Builder readWrite(Function<ActionReadWrite.Builder, ObjectBuilder<ActionReadWrite>> fn) {
            return readWrite(fn.apply(new ActionReadWrite.Builder()).build());
        }

        /**
         * The number of replicas for the index.
         * <p>
         * API name: {@code replica_count}
         * </p>
         */
        @Nonnull
        public final Builder replicaCount(@Nullable ActionReplicaCount value) {
            this.replicaCount = value;
            return this;
        }

        /**
         * The number of replicas for the index.
         * <p>
         * API name: {@code replica_count}
         * </p>
         */
        @Nonnull
        public final Builder replicaCount(Function<ActionReplicaCount.Builder, ObjectBuilder<ActionReplicaCount>> fn) {
            return replicaCount(fn.apply(new ActionReplicaCount.Builder()).build());
        }

        /**
         * The number of times to retry the action.
         * <p>
         * API name: {@code retry}
         * </p>
         */
        @Nonnull
        public final Builder retry(@Nullable ActionRetry value) {
            this.retry = value;
            return this;
        }

        /**
         * The number of times to retry the action.
         * <p>
         * API name: {@code retry}
         * </p>
         */
        @Nonnull
        public final Builder retry(Function<ActionRetry.Builder, ObjectBuilder<ActionRetry>> fn) {
            return retry(fn.apply(new ActionRetry.Builder()).build());
        }

        /**
         * Sets a rollover policy for the index.
         * <p>
         * API name: {@code rollover}
         * </p>
         */
        @Nonnull
        public final Builder rollover(@Nullable ActionRollover value) {
            this.rollover = value;
            return this;
        }

        /**
         * Sets a rollover policy for the index.
         * <p>
         * API name: {@code rollover}
         * </p>
         */
        @Nonnull
        public final Builder rollover(Function<ActionRollover.Builder, ObjectBuilder<ActionRollover>> fn) {
            return rollover(fn.apply(new ActionRollover.Builder()).build());
        }

        /**
         * Determines when to perform an index rollup.
         * <p>
         * API name: {@code rollup}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>rollup</code>.
         * </p>
         */
        @Nonnull
        public final Builder rollup(Map<String, JsonData> map) {
            this.rollup = _mapPutAll(this.rollup, map);
            return this;
        }

        /**
         * Determines when to perform an index rollup.
         * <p>
         * API name: {@code rollup}
         * </p>
         *
         * <p>
         * Adds an entry to <code>rollup</code>.
         * </p>
         */
        @Nonnull
        public final Builder rollup(String key, JsonData value) {
            this.rollup = _mapPut(this.rollup, key, value);
            return this;
        }

        /**
         * Determines when to shrink the index.
         * <p>
         * API name: {@code shrink}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>shrink</code>.
         * </p>
         */
        @Nonnull
        public final Builder shrink(Map<String, JsonData> map) {
            this.shrink = _mapPutAll(this.shrink, map);
            return this;
        }

        /**
         * Determines when to shrink the index.
         * <p>
         * API name: {@code shrink}
         * </p>
         *
         * <p>
         * Adds an entry to <code>shrink</code>.
         * </p>
         */
        @Nonnull
        public final Builder shrink(String key, JsonData value) {
            this.shrink = _mapPut(this.shrink, key, value);
            return this;
        }

        /**
         * Takes a snapshot of the index.
         * <p>
         * API name: {@code snapshot}
         * </p>
         */
        @Nonnull
        public final Builder snapshot(@Nullable ActionSnapshot value) {
            this.snapshot = value;
            return this;
        }

        /**
         * Takes a snapshot of the index.
         * <p>
         * API name: {@code snapshot}
         * </p>
         */
        @Nonnull
        public final Builder snapshot(Function<ActionSnapshot.Builder, ObjectBuilder<ActionSnapshot>> fn) {
            return snapshot(fn.apply(new ActionSnapshot.Builder()).build());
        }

        /**
         * The amount of time to wait before the action fails.
         * <p>
         * API name: {@code timeout}
         * </p>
         */
        @Nonnull
        public final Builder timeout(@Nullable ActionTimeout value) {
            this.timeout = value;
            return this;
        }

        /**
         * The amount of time to wait before the action fails.
         * <p>
         * API name: {@code timeout}
         * </p>
         */
        @Nonnull
        public final Builder timeout(Function<ActionTimeout.Builder, ObjectBuilder<ActionTimeout>> fn) {
            return timeout(fn.apply(new ActionTimeout.Builder()).build());
        }

        /**
         * Determines when to perform an index transform.
         * <p>
         * API name: {@code transform}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>transform</code>.
         * </p>
         */
        @Nonnull
        public final Builder transform(Map<String, JsonData> map) {
            this.transform = _mapPutAll(this.transform, map);
            return this;
        }

        /**
         * Determines when to perform an index transform.
         * <p>
         * API name: {@code transform}
         * </p>
         *
         * <p>
         * Adds an entry to <code>transform</code>.
         * </p>
         */
        @Nonnull
        public final Builder transform(String key, JsonData value) {
            this.transform = _mapPut(this.transform, key, value);
            return this;
        }

        /**
         * Builds a {@link Action}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public Action build() {
            _checkSingleUse();

            return new Action(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link Action}
     */
    public static final JsonpDeserializer<Action> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        Action::setupActionDeserializer
    );

    protected static void setupActionDeserializer(ObjectDeserializer<Action.Builder> op) {
        op.add(Builder::alias, ActionAlias._DESERIALIZER, "alias");
        op.add(Builder::allocation, ActionAllocation._DESERIALIZER, "allocation");
        op.add(Builder::close, ActionClose._DESERIALIZER, "close");
        op.add(Builder::custom, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "custom");
        op.add(Builder::delete, ActionDelete._DESERIALIZER, "delete");
        op.add(Builder::forceMerge, ActionForceMerge._DESERIALIZER, "force_merge");
        op.add(Builder::indexPriority, ActionIndexPriority._DESERIALIZER, "index_priority");
        op.add(Builder::notification, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "notification");
        op.add(Builder::open, ActionOpen._DESERIALIZER, "open");
        op.add(Builder::readOnly, ActionReadOnly._DESERIALIZER, "read_only");
        op.add(Builder::readWrite, ActionReadWrite._DESERIALIZER, "read_write");
        op.add(Builder::replicaCount, ActionReplicaCount._DESERIALIZER, "replica_count");
        op.add(Builder::retry, ActionRetry._DESERIALIZER, "retry");
        op.add(Builder::rollover, ActionRollover._DESERIALIZER, "rollover");
        op.add(Builder::rollup, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "rollup");
        op.add(Builder::shrink, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "shrink");
        op.add(Builder::snapshot, ActionSnapshot._DESERIALIZER, "snapshot");
        op.add(Builder::timeout, ActionTimeout._DESERIALIZER, "timeout");
        op.add(Builder::transform, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "transform");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.alias);
        result = 31 * result + Objects.hashCode(this.allocation);
        result = 31 * result + Objects.hashCode(this.close);
        result = 31 * result + Objects.hashCode(this.custom);
        result = 31 * result + Objects.hashCode(this.delete);
        result = 31 * result + Objects.hashCode(this.forceMerge);
        result = 31 * result + Objects.hashCode(this.indexPriority);
        result = 31 * result + Objects.hashCode(this.notification);
        result = 31 * result + Objects.hashCode(this.open);
        result = 31 * result + Objects.hashCode(this.readOnly);
        result = 31 * result + Objects.hashCode(this.readWrite);
        result = 31 * result + Objects.hashCode(this.replicaCount);
        result = 31 * result + Objects.hashCode(this.retry);
        result = 31 * result + Objects.hashCode(this.rollover);
        result = 31 * result + Objects.hashCode(this.rollup);
        result = 31 * result + Objects.hashCode(this.shrink);
        result = 31 * result + Objects.hashCode(this.snapshot);
        result = 31 * result + Objects.hashCode(this.timeout);
        result = 31 * result + Objects.hashCode(this.transform);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Action other = (Action) o;
        return Objects.equals(this.alias, other.alias)
            && Objects.equals(this.allocation, other.allocation)
            && Objects.equals(this.close, other.close)
            && Objects.equals(this.custom, other.custom)
            && Objects.equals(this.delete, other.delete)
            && Objects.equals(this.forceMerge, other.forceMerge)
            && Objects.equals(this.indexPriority, other.indexPriority)
            && Objects.equals(this.notification, other.notification)
            && Objects.equals(this.open, other.open)
            && Objects.equals(this.readOnly, other.readOnly)
            && Objects.equals(this.readWrite, other.readWrite)
            && Objects.equals(this.replicaCount, other.replicaCount)
            && Objects.equals(this.retry, other.retry)
            && Objects.equals(this.rollover, other.rollover)
            && Objects.equals(this.rollup, other.rollup)
            && Objects.equals(this.shrink, other.shrink)
            && Objects.equals(this.snapshot, other.snapshot)
            && Objects.equals(this.timeout, other.timeout)
            && Objects.equals(this.transform, other.transform);
    }
}
