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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: nodes.stats.IoStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IoStats implements PlainJsonSerializable, ToCopyableBuilder<IoStats.Builder, IoStats> {

    @Nonnull
    private final List<IoStatDevice> devices;

    @Nullable
    private final IoStatDevice total;

    // ---------------------------------------------------------------------------------------------

    private IoStats(Builder builder) {
        this.devices = ApiTypeHelper.unmodifiable(builder.devices);
        this.total = builder.total;
    }

    public static IoStats of(Function<IoStats.Builder, ObjectBuilder<IoStats>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Array of disk metrics for each device that is backing an OpenSearch data path. These disk metrics are probed periodically and
     * averages between the last probe and the current probe are computed.
     * <p>
     * API name: {@code devices}
     * </p>
     */
    @Nonnull
    public final List<IoStatDevice> devices() {
        return this.devices;
    }

    /**
     * API name: {@code total}
     */
    @Nullable
    public final IoStatDevice total() {
        return this.total;
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
        if (ApiTypeHelper.isDefined(this.devices)) {
            generator.writeKey("devices");
            generator.writeStartArray();
            for (IoStatDevice item0 : this.devices) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.total != null) {
            generator.writeKey("total");
            this.total.serialize(generator, mapper);
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
     * Builder for {@link IoStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IoStats> {
        @Nullable
        private List<IoStatDevice> devices;
        @Nullable
        private IoStatDevice total;

        public Builder() {}

        private Builder(IoStats o) {
            this.devices = _listCopy(o.devices);
            this.total = o.total;
        }

        private Builder(Builder o) {
            this.devices = _listCopy(o.devices);
            this.total = o.total;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Array of disk metrics for each device that is backing an OpenSearch data path. These disk metrics are probed periodically and
         * averages between the last probe and the current probe are computed.
         * <p>
         * API name: {@code devices}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>devices</code>.
         * </p>
         */
        @Nonnull
        public final Builder devices(List<IoStatDevice> list) {
            this.devices = _listAddAll(this.devices, list);
            return this;
        }

        /**
         * Array of disk metrics for each device that is backing an OpenSearch data path. These disk metrics are probed periodically and
         * averages between the last probe and the current probe are computed.
         * <p>
         * API name: {@code devices}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>devices</code>.
         * </p>
         */
        @Nonnull
        public final Builder devices(IoStatDevice value, IoStatDevice... values) {
            this.devices = _listAdd(this.devices, value, values);
            return this;
        }

        /**
         * Array of disk metrics for each device that is backing an OpenSearch data path. These disk metrics are probed periodically and
         * averages between the last probe and the current probe are computed.
         * <p>
         * API name: {@code devices}
         * </p>
         *
         * <p>
         * Adds a value to <code>devices</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder devices(Function<IoStatDevice.Builder, ObjectBuilder<IoStatDevice>> fn) {
            return devices(fn.apply(new IoStatDevice.Builder()).build());
        }

        /**
         * API name: {@code total}
         */
        @Nonnull
        public final Builder total(@Nullable IoStatDevice value) {
            this.total = value;
            return this;
        }

        /**
         * API name: {@code total}
         */
        @Nonnull
        public final Builder total(Function<IoStatDevice.Builder, ObjectBuilder<IoStatDevice>> fn) {
            return total(fn.apply(new IoStatDevice.Builder()).build());
        }

        /**
         * Builds a {@link IoStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IoStats build() {
            _checkSingleUse();

            return new IoStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IoStats}
     */
    public static final JsonpDeserializer<IoStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IoStats::setupIoStatsDeserializer
    );

    protected static void setupIoStatsDeserializer(ObjectDeserializer<IoStats.Builder> op) {
        op.add(Builder::devices, JsonpDeserializer.arrayDeserializer(IoStatDevice._DESERIALIZER), "devices");
        op.add(Builder::total, IoStatDevice._DESERIALIZER, "total");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.devices);
        result = 31 * result + Objects.hashCode(this.total);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IoStats other = (IoStats) o;
        return Objects.equals(this.devices, other.devices) && Objects.equals(this.total, other.total);
    }
}
