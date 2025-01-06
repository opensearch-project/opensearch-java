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

// typedef: nodes.stats.IoStatDevice

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IoStatDevice implements PlainJsonSerializable, ToCopyableBuilder<IoStatDevice.Builder, IoStatDevice> {

    @Nullable
    private final String deviceName;

    @Nullable
    private final Long ioTimeInMillis;

    @Nullable
    private final Long operations;

    @Nullable
    private final Long queueSize;

    @Nullable
    private final Long readKilobytes;

    @Nullable
    private final Long readOperations;

    @Nullable
    private final Long readTime;

    @Nullable
    private final Long writeKilobytes;

    @Nullable
    private final Long writeOperations;

    @Nullable
    private final Long writeTime;

    // ---------------------------------------------------------------------------------------------

    private IoStatDevice(Builder builder) {
        this.deviceName = builder.deviceName;
        this.ioTimeInMillis = builder.ioTimeInMillis;
        this.operations = builder.operations;
        this.queueSize = builder.queueSize;
        this.readKilobytes = builder.readKilobytes;
        this.readOperations = builder.readOperations;
        this.readTime = builder.readTime;
        this.writeKilobytes = builder.writeKilobytes;
        this.writeOperations = builder.writeOperations;
        this.writeTime = builder.writeTime;
    }

    public static IoStatDevice of(Function<IoStatDevice.Builder, ObjectBuilder<IoStatDevice>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The Linux device name.
     * <p>
     * API name: {@code device_name}
     * </p>
     */
    @Nullable
    public final String deviceName() {
        return this.deviceName;
    }

    /**
     * API name: {@code io_time_in_millis}
     */
    @Nullable
    public final Long ioTimeInMillis() {
        return this.ioTimeInMillis;
    }

    /**
     * The total number of read and write operations for the device completed since starting OpenSearch.
     * <p>
     * API name: {@code operations}
     * </p>
     */
    @Nullable
    public final Long operations() {
        return this.operations;
    }

    /**
     * API name: {@code queue_size}
     */
    @Nullable
    public final Long queueSize() {
        return this.queueSize;
    }

    /**
     * The total number of kilobytes read for the device since starting OpenSearch.
     * <p>
     * API name: {@code read_kilobytes}
     * </p>
     */
    @Nullable
    public final Long readKilobytes() {
        return this.readKilobytes;
    }

    /**
     * The total number of read operations for the device completed since starting OpenSearch.
     * <p>
     * API name: {@code read_operations}
     * </p>
     */
    @Nullable
    public final Long readOperations() {
        return this.readOperations;
    }

    /**
     * API name: {@code read_time}
     */
    @Nullable
    public final Long readTime() {
        return this.readTime;
    }

    /**
     * The total number of kilobytes written for the device since starting OpenSearch.
     * <p>
     * API name: {@code write_kilobytes}
     * </p>
     */
    @Nullable
    public final Long writeKilobytes() {
        return this.writeKilobytes;
    }

    /**
     * The total number of write operations for the device completed since starting OpenSearch.
     * <p>
     * API name: {@code write_operations}
     * </p>
     */
    @Nullable
    public final Long writeOperations() {
        return this.writeOperations;
    }

    /**
     * API name: {@code write_time}
     */
    @Nullable
    public final Long writeTime() {
        return this.writeTime;
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
        if (this.deviceName != null) {
            generator.writeKey("device_name");
            generator.write(this.deviceName);
        }

        if (this.ioTimeInMillis != null) {
            generator.writeKey("io_time_in_millis");
            generator.write(this.ioTimeInMillis);
        }

        if (this.operations != null) {
            generator.writeKey("operations");
            generator.write(this.operations);
        }

        if (this.queueSize != null) {
            generator.writeKey("queue_size");
            generator.write(this.queueSize);
        }

        if (this.readKilobytes != null) {
            generator.writeKey("read_kilobytes");
            generator.write(this.readKilobytes);
        }

        if (this.readOperations != null) {
            generator.writeKey("read_operations");
            generator.write(this.readOperations);
        }

        if (this.readTime != null) {
            generator.writeKey("read_time");
            generator.write(this.readTime);
        }

        if (this.writeKilobytes != null) {
            generator.writeKey("write_kilobytes");
            generator.write(this.writeKilobytes);
        }

        if (this.writeOperations != null) {
            generator.writeKey("write_operations");
            generator.write(this.writeOperations);
        }

        if (this.writeTime != null) {
            generator.writeKey("write_time");
            generator.write(this.writeTime);
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
     * Builder for {@link IoStatDevice}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IoStatDevice> {
        @Nullable
        private String deviceName;
        @Nullable
        private Long ioTimeInMillis;
        @Nullable
        private Long operations;
        @Nullable
        private Long queueSize;
        @Nullable
        private Long readKilobytes;
        @Nullable
        private Long readOperations;
        @Nullable
        private Long readTime;
        @Nullable
        private Long writeKilobytes;
        @Nullable
        private Long writeOperations;
        @Nullable
        private Long writeTime;

        public Builder() {}

        private Builder(IoStatDevice o) {
            this.deviceName = o.deviceName;
            this.ioTimeInMillis = o.ioTimeInMillis;
            this.operations = o.operations;
            this.queueSize = o.queueSize;
            this.readKilobytes = o.readKilobytes;
            this.readOperations = o.readOperations;
            this.readTime = o.readTime;
            this.writeKilobytes = o.writeKilobytes;
            this.writeOperations = o.writeOperations;
            this.writeTime = o.writeTime;
        }

        private Builder(Builder o) {
            this.deviceName = o.deviceName;
            this.ioTimeInMillis = o.ioTimeInMillis;
            this.operations = o.operations;
            this.queueSize = o.queueSize;
            this.readKilobytes = o.readKilobytes;
            this.readOperations = o.readOperations;
            this.readTime = o.readTime;
            this.writeKilobytes = o.writeKilobytes;
            this.writeOperations = o.writeOperations;
            this.writeTime = o.writeTime;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The Linux device name.
         * <p>
         * API name: {@code device_name}
         * </p>
         */
        @Nonnull
        public final Builder deviceName(@Nullable String value) {
            this.deviceName = value;
            return this;
        }

        /**
         * API name: {@code io_time_in_millis}
         */
        @Nonnull
        public final Builder ioTimeInMillis(@Nullable Long value) {
            this.ioTimeInMillis = value;
            return this;
        }

        /**
         * The total number of read and write operations for the device completed since starting OpenSearch.
         * <p>
         * API name: {@code operations}
         * </p>
         */
        @Nonnull
        public final Builder operations(@Nullable Long value) {
            this.operations = value;
            return this;
        }

        /**
         * API name: {@code queue_size}
         */
        @Nonnull
        public final Builder queueSize(@Nullable Long value) {
            this.queueSize = value;
            return this;
        }

        /**
         * The total number of kilobytes read for the device since starting OpenSearch.
         * <p>
         * API name: {@code read_kilobytes}
         * </p>
         */
        @Nonnull
        public final Builder readKilobytes(@Nullable Long value) {
            this.readKilobytes = value;
            return this;
        }

        /**
         * The total number of read operations for the device completed since starting OpenSearch.
         * <p>
         * API name: {@code read_operations}
         * </p>
         */
        @Nonnull
        public final Builder readOperations(@Nullable Long value) {
            this.readOperations = value;
            return this;
        }

        /**
         * API name: {@code read_time}
         */
        @Nonnull
        public final Builder readTime(@Nullable Long value) {
            this.readTime = value;
            return this;
        }

        /**
         * The total number of kilobytes written for the device since starting OpenSearch.
         * <p>
         * API name: {@code write_kilobytes}
         * </p>
         */
        @Nonnull
        public final Builder writeKilobytes(@Nullable Long value) {
            this.writeKilobytes = value;
            return this;
        }

        /**
         * The total number of write operations for the device completed since starting OpenSearch.
         * <p>
         * API name: {@code write_operations}
         * </p>
         */
        @Nonnull
        public final Builder writeOperations(@Nullable Long value) {
            this.writeOperations = value;
            return this;
        }

        /**
         * API name: {@code write_time}
         */
        @Nonnull
        public final Builder writeTime(@Nullable Long value) {
            this.writeTime = value;
            return this;
        }

        /**
         * Builds a {@link IoStatDevice}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IoStatDevice build() {
            _checkSingleUse();

            return new IoStatDevice(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IoStatDevice}
     */
    public static final JsonpDeserializer<IoStatDevice> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IoStatDevice::setupIoStatDeviceDeserializer
    );

    protected static void setupIoStatDeviceDeserializer(ObjectDeserializer<IoStatDevice.Builder> op) {
        op.add(Builder::deviceName, JsonpDeserializer.stringDeserializer(), "device_name");
        op.add(Builder::ioTimeInMillis, JsonpDeserializer.longDeserializer(), "io_time_in_millis");
        op.add(Builder::operations, JsonpDeserializer.longDeserializer(), "operations");
        op.add(Builder::queueSize, JsonpDeserializer.longDeserializer(), "queue_size");
        op.add(Builder::readKilobytes, JsonpDeserializer.longDeserializer(), "read_kilobytes");
        op.add(Builder::readOperations, JsonpDeserializer.longDeserializer(), "read_operations");
        op.add(Builder::readTime, JsonpDeserializer.longDeserializer(), "read_time");
        op.add(Builder::writeKilobytes, JsonpDeserializer.longDeserializer(), "write_kilobytes");
        op.add(Builder::writeOperations, JsonpDeserializer.longDeserializer(), "write_operations");
        op.add(Builder::writeTime, JsonpDeserializer.longDeserializer(), "write_time");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.deviceName);
        result = 31 * result + Objects.hashCode(this.ioTimeInMillis);
        result = 31 * result + Objects.hashCode(this.operations);
        result = 31 * result + Objects.hashCode(this.queueSize);
        result = 31 * result + Objects.hashCode(this.readKilobytes);
        result = 31 * result + Objects.hashCode(this.readOperations);
        result = 31 * result + Objects.hashCode(this.readTime);
        result = 31 * result + Objects.hashCode(this.writeKilobytes);
        result = 31 * result + Objects.hashCode(this.writeOperations);
        result = 31 * result + Objects.hashCode(this.writeTime);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IoStatDevice other = (IoStatDevice) o;
        return Objects.equals(this.deviceName, other.deviceName)
            && Objects.equals(this.ioTimeInMillis, other.ioTimeInMillis)
            && Objects.equals(this.operations, other.operations)
            && Objects.equals(this.queueSize, other.queueSize)
            && Objects.equals(this.readKilobytes, other.readKilobytes)
            && Objects.equals(this.readOperations, other.readOperations)
            && Objects.equals(this.readTime, other.readTime)
            && Objects.equals(this.writeKilobytes, other.writeKilobytes)
            && Objects.equals(this.writeOperations, other.writeOperations)
            && Objects.equals(this.writeTime, other.writeTime);
    }
}
