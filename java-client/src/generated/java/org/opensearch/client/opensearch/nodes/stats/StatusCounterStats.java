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

// typedef: nodes.stats.StatusCounterStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class StatusCounterStats implements PlainJsonSerializable, ToCopyableBuilder<StatusCounterStats.Builder, StatusCounterStats> {

    @Nullable
    private final Long success;

    @Nullable
    private final Long systemFailure;

    @Nullable
    private final Long userError;

    // ---------------------------------------------------------------------------------------------

    private StatusCounterStats(Builder builder) {
        this.success = builder.success;
        this.systemFailure = builder.systemFailure;
        this.userError = builder.userError;
    }

    public static StatusCounterStats of(Function<StatusCounterStats.Builder, ObjectBuilder<StatusCounterStats>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code success}
     */
    @Nullable
    public final Long success() {
        return this.success;
    }

    /**
     * API name: {@code system_failure}
     */
    @Nullable
    public final Long systemFailure() {
        return this.systemFailure;
    }

    /**
     * API name: {@code user_error}
     */
    @Nullable
    public final Long userError() {
        return this.userError;
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
        if (this.success != null) {
            generator.writeKey("success");
            generator.write(this.success);
        }

        if (this.systemFailure != null) {
            generator.writeKey("system_failure");
            generator.write(this.systemFailure);
        }

        if (this.userError != null) {
            generator.writeKey("user_error");
            generator.write(this.userError);
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
     * Builder for {@link StatusCounterStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, StatusCounterStats> {
        @Nullable
        private Long success;
        @Nullable
        private Long systemFailure;
        @Nullable
        private Long userError;

        public Builder() {}

        private Builder(StatusCounterStats o) {
            this.success = o.success;
            this.systemFailure = o.systemFailure;
            this.userError = o.userError;
        }

        private Builder(Builder o) {
            this.success = o.success;
            this.systemFailure = o.systemFailure;
            this.userError = o.userError;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code success}
         */
        @Nonnull
        public final Builder success(@Nullable Long value) {
            this.success = value;
            return this;
        }

        /**
         * API name: {@code system_failure}
         */
        @Nonnull
        public final Builder systemFailure(@Nullable Long value) {
            this.systemFailure = value;
            return this;
        }

        /**
         * API name: {@code user_error}
         */
        @Nonnull
        public final Builder userError(@Nullable Long value) {
            this.userError = value;
            return this;
        }

        /**
         * Builds a {@link StatusCounterStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public StatusCounterStats build() {
            _checkSingleUse();

            return new StatusCounterStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link StatusCounterStats}
     */
    public static final JsonpDeserializer<StatusCounterStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        StatusCounterStats::setupStatusCounterStatsDeserializer
    );

    protected static void setupStatusCounterStatsDeserializer(ObjectDeserializer<StatusCounterStats.Builder> op) {
        op.add(Builder::success, JsonpDeserializer.longDeserializer(), "success");
        op.add(Builder::systemFailure, JsonpDeserializer.longDeserializer(), "system_failure");
        op.add(Builder::userError, JsonpDeserializer.longDeserializer(), "user_error");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.success);
        result = 31 * result + Objects.hashCode(this.systemFailure);
        result = 31 * result + Objects.hashCode(this.userError);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        StatusCounterStats other = (StatusCounterStats) o;
        return Objects.equals(this.success, other.success)
            && Objects.equals(this.systemFailure, other.systemFailure)
            && Objects.equals(this.userError, other.userError);
    }
}
