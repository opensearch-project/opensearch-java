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

package org.opensearch.client.opensearch.indices;

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

// typedef: indices.SoftDeletes

/**
 * The configuration for soft deletes.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SoftDeletes implements PlainJsonSerializable, ToCopyableBuilder<SoftDeletes.Builder, SoftDeletes> {

    @Nullable
    private final Boolean enabled;

    @Nullable
    private final SoftDeletesRetention retention;

    @Nullable
    private final RetentionLease retentionLease;

    // ---------------------------------------------------------------------------------------------

    private SoftDeletes(Builder builder) {
        this.enabled = builder.enabled;
        this.retention = builder.retention;
        this.retentionLease = builder.retentionLease;
    }

    public static SoftDeletes of(Function<SoftDeletes.Builder, ObjectBuilder<SoftDeletes>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Whether soft deletes are enabled on the index.
     * <p>
     * API name: {@code enabled}
     * </p>
     */
    @Nullable
    public final Boolean enabled() {
        return this.enabled;
    }

    /**
     * API name: {@code retention}
     */
    @Nullable
    public final SoftDeletesRetention retention() {
        return this.retention;
    }

    /**
     * API name: {@code retention_lease}
     */
    @Nullable
    public final RetentionLease retentionLease() {
        return this.retentionLease;
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
        if (this.enabled != null) {
            generator.writeKey("enabled");
            generator.write(this.enabled);
        }

        if (this.retention != null) {
            generator.writeKey("retention");
            this.retention.serialize(generator, mapper);
        }

        if (this.retentionLease != null) {
            generator.writeKey("retention_lease");
            this.retentionLease.serialize(generator, mapper);
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
     * Builder for {@link SoftDeletes}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, SoftDeletes> {
        @Nullable
        private Boolean enabled;
        @Nullable
        private SoftDeletesRetention retention;
        @Nullable
        private RetentionLease retentionLease;

        public Builder() {}

        private Builder(SoftDeletes o) {
            this.enabled = o.enabled;
            this.retention = o.retention;
            this.retentionLease = o.retentionLease;
        }

        private Builder(Builder o) {
            this.enabled = o.enabled;
            this.retention = o.retention;
            this.retentionLease = o.retentionLease;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Whether soft deletes are enabled on the index.
         * <p>
         * API name: {@code enabled}
         * </p>
         */
        @Nonnull
        public final Builder enabled(@Nullable Boolean value) {
            this.enabled = value;
            return this;
        }

        /**
         * API name: {@code retention}
         */
        @Nonnull
        public final Builder retention(@Nullable SoftDeletesRetention value) {
            this.retention = value;
            return this;
        }

        /**
         * API name: {@code retention}
         */
        @Nonnull
        public final Builder retention(Function<SoftDeletesRetention.Builder, ObjectBuilder<SoftDeletesRetention>> fn) {
            return retention(fn.apply(new SoftDeletesRetention.Builder()).build());
        }

        /**
         * API name: {@code retention_lease}
         */
        @Nonnull
        public final Builder retentionLease(@Nullable RetentionLease value) {
            this.retentionLease = value;
            return this;
        }

        /**
         * API name: {@code retention_lease}
         */
        @Nonnull
        public final Builder retentionLease(Function<RetentionLease.Builder, ObjectBuilder<RetentionLease>> fn) {
            return retentionLease(fn.apply(new RetentionLease.Builder()).build());
        }

        /**
         * Builds a {@link SoftDeletes}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SoftDeletes build() {
            _checkSingleUse();

            return new SoftDeletes(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SoftDeletes}
     */
    public static final JsonpDeserializer<SoftDeletes> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SoftDeletes::setupSoftDeletesDeserializer
    );

    protected static void setupSoftDeletesDeserializer(ObjectDeserializer<SoftDeletes.Builder> op) {
        op.add(Builder::enabled, JsonpDeserializer.booleanDeserializer(), "enabled");
        op.add(Builder::retention, SoftDeletesRetention._DESERIALIZER, "retention");
        op.add(Builder::retentionLease, RetentionLease._DESERIALIZER, "retention_lease");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.enabled);
        result = 31 * result + Objects.hashCode(this.retention);
        result = 31 * result + Objects.hashCode(this.retentionLease);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SoftDeletes other = (SoftDeletes) o;
        return Objects.equals(this.enabled, other.enabled)
            && Objects.equals(this.retention, other.retention)
            && Objects.equals(this.retentionLease, other.retentionLease);
    }
}
