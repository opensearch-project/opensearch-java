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

// typedef: snapshot.RepositorySettings

/**
 * The settings for the snapshot repository.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RepositorySettings implements PlainJsonSerializable, ToCopyableBuilder<RepositorySettings.Builder, RepositorySettings> {

    @Nullable
    private final String chunkSize;

    @Nullable
    private final Boolean compress;

    @Nullable
    private final Integer concurrentStreams;

    @Nullable
    private final String location;

    @Nullable
    private final Boolean readOnly;

    // ---------------------------------------------------------------------------------------------

    private RepositorySettings(Builder builder) {
        this.chunkSize = builder.chunkSize;
        this.compress = builder.compress;
        this.concurrentStreams = builder.concurrentStreams;
        this.location = builder.location;
        this.readOnly = builder.readOnly;
    }

    public static RepositorySettings of(Function<RepositorySettings.Builder, ObjectBuilder<RepositorySettings>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The chunk size for the repository.
     * <p>
     * API name: {@code chunk_size}
     * </p>
     */
    @Nullable
    public final String chunkSize() {
        return this.chunkSize;
    }

    /**
     * Whether compression is enabled for the repository.
     * <p>
     * API name: {@code compress}
     * </p>
     */
    @Nullable
    public final Boolean compress() {
        return this.compress;
    }

    /**
     * The number of concurrent streams for the repository.
     * <p>
     * API name: {@code concurrent_streams}
     * </p>
     */
    @Nullable
    public final Integer concurrentStreams() {
        return this.concurrentStreams;
    }

    /**
     * The location where snapshots are stored.
     * <p>
     * API name: {@code location}
     * </p>
     */
    @Nullable
    public final String location() {
        return this.location;
    }

    /**
     * Whether the repository is read-only.
     * <p>
     * API name: {@code read_only}
     * </p>
     */
    @Nullable
    public final Boolean readOnly() {
        return this.readOnly;
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
        if (this.chunkSize != null) {
            generator.writeKey("chunk_size");
            generator.write(this.chunkSize);
        }

        if (this.compress != null) {
            generator.writeKey("compress");
            generator.write(this.compress);
        }

        if (this.concurrentStreams != null) {
            generator.writeKey("concurrent_streams");
            generator.write(this.concurrentStreams);
        }

        if (this.location != null) {
            generator.writeKey("location");
            generator.write(this.location);
        }

        if (this.readOnly != null) {
            generator.writeKey("read_only");
            generator.write(this.readOnly);
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
     * Builder for {@link RepositorySettings}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, RepositorySettings> {
        @Nullable
        private String chunkSize;
        @Nullable
        private Boolean compress;
        @Nullable
        private Integer concurrentStreams;
        @Nullable
        private String location;
        @Nullable
        private Boolean readOnly;

        public Builder() {}

        private Builder(RepositorySettings o) {
            this.chunkSize = o.chunkSize;
            this.compress = o.compress;
            this.concurrentStreams = o.concurrentStreams;
            this.location = o.location;
            this.readOnly = o.readOnly;
        }

        private Builder(Builder o) {
            this.chunkSize = o.chunkSize;
            this.compress = o.compress;
            this.concurrentStreams = o.concurrentStreams;
            this.location = o.location;
            this.readOnly = o.readOnly;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The chunk size for the repository.
         * <p>
         * API name: {@code chunk_size}
         * </p>
         */
        @Nonnull
        public final Builder chunkSize(@Nullable String value) {
            this.chunkSize = value;
            return this;
        }

        /**
         * Whether compression is enabled for the repository.
         * <p>
         * API name: {@code compress}
         * </p>
         */
        @Nonnull
        public final Builder compress(@Nullable Boolean value) {
            this.compress = value;
            return this;
        }

        /**
         * The number of concurrent streams for the repository.
         * <p>
         * API name: {@code concurrent_streams}
         * </p>
         */
        @Nonnull
        public final Builder concurrentStreams(@Nullable Integer value) {
            this.concurrentStreams = value;
            return this;
        }

        /**
         * The location where snapshots are stored.
         * <p>
         * API name: {@code location}
         * </p>
         */
        @Nonnull
        public final Builder location(@Nullable String value) {
            this.location = value;
            return this;
        }

        /**
         * Whether the repository is read-only.
         * <p>
         * API name: {@code read_only}
         * </p>
         */
        @Nonnull
        public final Builder readOnly(@Nullable Boolean value) {
            this.readOnly = value;
            return this;
        }

        /**
         * Builds a {@link RepositorySettings}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RepositorySettings build() {
            _checkSingleUse();

            return new RepositorySettings(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RepositorySettings}
     */
    public static final JsonpDeserializer<RepositorySettings> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RepositorySettings::setupRepositorySettingsDeserializer
    );

    protected static void setupRepositorySettingsDeserializer(ObjectDeserializer<RepositorySettings.Builder> op) {
        op.add(Builder::chunkSize, JsonpDeserializer.stringDeserializer(), "chunk_size");
        op.add(Builder::compress, JsonpDeserializer.booleanDeserializer(), "compress");
        op.add(Builder::concurrentStreams, JsonpDeserializer.integerDeserializer(), "concurrent_streams");
        op.add(Builder::location, JsonpDeserializer.stringDeserializer(), "location");
        op.add(Builder::readOnly, JsonpDeserializer.booleanDeserializer(), "read_only");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.chunkSize);
        result = 31 * result + Objects.hashCode(this.compress);
        result = 31 * result + Objects.hashCode(this.concurrentStreams);
        result = 31 * result + Objects.hashCode(this.location);
        result = 31 * result + Objects.hashCode(this.readOnly);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RepositorySettings other = (RepositorySettings) o;
        return Objects.equals(this.chunkSize, other.chunkSize)
            && Objects.equals(this.compress, other.compress)
            && Objects.equals(this.concurrentStreams, other.concurrentStreams)
            && Objects.equals(this.location, other.location)
            && Objects.equals(this.readOnly, other.readOnly);
    }
}
