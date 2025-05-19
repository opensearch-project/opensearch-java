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

package org.opensearch.client.opensearch.nodes.info;

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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: nodes.info.NodeProcessInfo

/**
 * Provides process-related information for the node.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NodeProcessInfo implements PlainJsonSerializable, ToCopyableBuilder<NodeProcessInfo.Builder, NodeProcessInfo> {

    private final long id;

    private final boolean mlockall;

    @Nullable
    private final Time refreshInterval;

    private final long refreshIntervalInMillis;

    // ---------------------------------------------------------------------------------------------

    private NodeProcessInfo(Builder builder) {
        this.id = ApiTypeHelper.requireNonNull(builder.id, this, "id");
        this.mlockall = ApiTypeHelper.requireNonNull(builder.mlockall, this, "mlockall");
        this.refreshInterval = builder.refreshInterval;
        this.refreshIntervalInMillis = ApiTypeHelper.requireNonNull(builder.refreshIntervalInMillis, this, "refreshIntervalInMillis");
    }

    public static NodeProcessInfo of(Function<NodeProcessInfo.Builder, ObjectBuilder<NodeProcessInfo>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The process identifier (PID)
     * <p>
     * API name: {@code id}
     * </p>
     */
    public final long id() {
        return this.id;
    }

    /**
     * Required - Indicates if the process address space has been successfully locked in memory.
     * <p>
     * API name: {@code mlockall}
     * </p>
     */
    public final boolean mlockall() {
        return this.mlockall;
    }

    /**
     * API name: {@code refresh_interval}
     */
    @Nullable
    public final Time refreshInterval() {
        return this.refreshInterval;
    }

    /**
     * Required - API name: {@code refresh_interval_in_millis}
     */
    public final long refreshIntervalInMillis() {
        return this.refreshIntervalInMillis;
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
        generator.writeKey("id");
        generator.write(this.id);

        generator.writeKey("mlockall");
        generator.write(this.mlockall);

        if (this.refreshInterval != null) {
            generator.writeKey("refresh_interval");
            this.refreshInterval.serialize(generator, mapper);
        }

        generator.writeKey("refresh_interval_in_millis");
        generator.write(this.refreshIntervalInMillis);
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
     * Builder for {@link NodeProcessInfo}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, NodeProcessInfo> {
        private Long id;
        private Boolean mlockall;
        @Nullable
        private Time refreshInterval;
        private Long refreshIntervalInMillis;

        public Builder() {}

        private Builder(NodeProcessInfo o) {
            this.id = o.id;
            this.mlockall = o.mlockall;
            this.refreshInterval = o.refreshInterval;
            this.refreshIntervalInMillis = o.refreshIntervalInMillis;
        }

        private Builder(Builder o) {
            this.id = o.id;
            this.mlockall = o.mlockall;
            this.refreshInterval = o.refreshInterval;
            this.refreshIntervalInMillis = o.refreshIntervalInMillis;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - The process identifier (PID)
         * <p>
         * API name: {@code id}
         * </p>
         */
        @Nonnull
        public final Builder id(long value) {
            this.id = value;
            return this;
        }

        /**
         * Required - Indicates if the process address space has been successfully locked in memory.
         * <p>
         * API name: {@code mlockall}
         * </p>
         */
        @Nonnull
        public final Builder mlockall(boolean value) {
            this.mlockall = value;
            return this;
        }

        /**
         * API name: {@code refresh_interval}
         */
        @Nonnull
        public final Builder refreshInterval(@Nullable Time value) {
            this.refreshInterval = value;
            return this;
        }

        /**
         * API name: {@code refresh_interval}
         */
        @Nonnull
        public final Builder refreshInterval(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return refreshInterval(fn.apply(new Time.Builder()).build());
        }

        /**
         * Required - API name: {@code refresh_interval_in_millis}
         */
        @Nonnull
        public final Builder refreshIntervalInMillis(long value) {
            this.refreshIntervalInMillis = value;
            return this;
        }

        /**
         * Builds a {@link NodeProcessInfo}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NodeProcessInfo build() {
            _checkSingleUse();

            return new NodeProcessInfo(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NodeProcessInfo}
     */
    public static final JsonpDeserializer<NodeProcessInfo> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NodeProcessInfo::setupNodeProcessInfoDeserializer
    );

    protected static void setupNodeProcessInfoDeserializer(ObjectDeserializer<NodeProcessInfo.Builder> op) {
        op.add(Builder::id, JsonpDeserializer.longDeserializer(), "id");
        op.add(Builder::mlockall, JsonpDeserializer.booleanDeserializer(), "mlockall");
        op.add(Builder::refreshInterval, Time._DESERIALIZER, "refresh_interval");
        op.add(Builder::refreshIntervalInMillis, JsonpDeserializer.longDeserializer(), "refresh_interval_in_millis");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Long.hashCode(this.id);
        result = 31 * result + Boolean.hashCode(this.mlockall);
        result = 31 * result + Objects.hashCode(this.refreshInterval);
        result = 31 * result + Long.hashCode(this.refreshIntervalInMillis);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NodeProcessInfo other = (NodeProcessInfo) o;
        return this.id == other.id
            && this.mlockall == other.mlockall
            && Objects.equals(this.refreshInterval, other.refreshInterval)
            && this.refreshIntervalInMillis == other.refreshIntervalInMillis;
    }
}
