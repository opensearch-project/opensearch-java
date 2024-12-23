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

package org.opensearch.client.opensearch.cluster.allocation_explain;

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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: cluster.allocation_explain.UnassignedInformation

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class UnassignedInformation
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<UnassignedInformation.Builder, UnassignedInformation> {

    @Nullable
    private final String allocationStatus;

    @Nonnull
    private final String at;

    @Nullable
    private final Boolean delayed;

    @Nullable
    private final String details;

    @Nullable
    private final Integer failedAllocationAttempts;

    @Nullable
    private final String lastAllocationStatus;

    @Nonnull
    private final UnassignedInformationReason reason;

    // ---------------------------------------------------------------------------------------------

    private UnassignedInformation(Builder builder) {
        this.allocationStatus = builder.allocationStatus;
        this.at = ApiTypeHelper.requireNonNull(builder.at, this, "at");
        this.delayed = builder.delayed;
        this.details = builder.details;
        this.failedAllocationAttempts = builder.failedAllocationAttempts;
        this.lastAllocationStatus = builder.lastAllocationStatus;
        this.reason = ApiTypeHelper.requireNonNull(builder.reason, this, "reason");
    }

    public static UnassignedInformation of(Function<UnassignedInformation.Builder, ObjectBuilder<UnassignedInformation>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code allocation_status}
     */
    @Nullable
    public final String allocationStatus() {
        return this.allocationStatus;
    }

    /**
     * Required - API name: {@code at}
     */
    @Nonnull
    public final String at() {
        return this.at;
    }

    /**
     * API name: {@code delayed}
     */
    @Nullable
    public final Boolean delayed() {
        return this.delayed;
    }

    /**
     * API name: {@code details}
     */
    @Nullable
    public final String details() {
        return this.details;
    }

    /**
     * API name: {@code failed_allocation_attempts}
     */
    @Nullable
    public final Integer failedAllocationAttempts() {
        return this.failedAllocationAttempts;
    }

    /**
     * API name: {@code last_allocation_status}
     */
    @Nullable
    public final String lastAllocationStatus() {
        return this.lastAllocationStatus;
    }

    /**
     * Required - API name: {@code reason}
     */
    @Nonnull
    public final UnassignedInformationReason reason() {
        return this.reason;
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
        if (this.allocationStatus != null) {
            generator.writeKey("allocation_status");
            generator.write(this.allocationStatus);
        }

        generator.writeKey("at");
        generator.write(this.at);

        if (this.delayed != null) {
            generator.writeKey("delayed");
            generator.write(this.delayed);
        }

        if (this.details != null) {
            generator.writeKey("details");
            generator.write(this.details);
        }

        if (this.failedAllocationAttempts != null) {
            generator.writeKey("failed_allocation_attempts");
            generator.write(this.failedAllocationAttempts);
        }

        if (this.lastAllocationStatus != null) {
            generator.writeKey("last_allocation_status");
            generator.write(this.lastAllocationStatus);
        }

        generator.writeKey("reason");
        this.reason.serialize(generator, mapper);
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
     * Builder for {@link UnassignedInformation}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, UnassignedInformation> {
        @Nullable
        private String allocationStatus;
        private String at;
        @Nullable
        private Boolean delayed;
        @Nullable
        private String details;
        @Nullable
        private Integer failedAllocationAttempts;
        @Nullable
        private String lastAllocationStatus;
        private UnassignedInformationReason reason;

        public Builder() {}

        private Builder(UnassignedInformation o) {
            this.allocationStatus = o.allocationStatus;
            this.at = o.at;
            this.delayed = o.delayed;
            this.details = o.details;
            this.failedAllocationAttempts = o.failedAllocationAttempts;
            this.lastAllocationStatus = o.lastAllocationStatus;
            this.reason = o.reason;
        }

        private Builder(Builder o) {
            this.allocationStatus = o.allocationStatus;
            this.at = o.at;
            this.delayed = o.delayed;
            this.details = o.details;
            this.failedAllocationAttempts = o.failedAllocationAttempts;
            this.lastAllocationStatus = o.lastAllocationStatus;
            this.reason = o.reason;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code allocation_status}
         */
        @Nonnull
        public final Builder allocationStatus(@Nullable String value) {
            this.allocationStatus = value;
            return this;
        }

        /**
         * Required - API name: {@code at}
         */
        @Nonnull
        public final Builder at(String value) {
            this.at = value;
            return this;
        }

        /**
         * API name: {@code delayed}
         */
        @Nonnull
        public final Builder delayed(@Nullable Boolean value) {
            this.delayed = value;
            return this;
        }

        /**
         * API name: {@code details}
         */
        @Nonnull
        public final Builder details(@Nullable String value) {
            this.details = value;
            return this;
        }

        /**
         * API name: {@code failed_allocation_attempts}
         */
        @Nonnull
        public final Builder failedAllocationAttempts(@Nullable Integer value) {
            this.failedAllocationAttempts = value;
            return this;
        }

        /**
         * API name: {@code last_allocation_status}
         */
        @Nonnull
        public final Builder lastAllocationStatus(@Nullable String value) {
            this.lastAllocationStatus = value;
            return this;
        }

        /**
         * Required - API name: {@code reason}
         */
        @Nonnull
        public final Builder reason(UnassignedInformationReason value) {
            this.reason = value;
            return this;
        }

        /**
         * Builds a {@link UnassignedInformation}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public UnassignedInformation build() {
            _checkSingleUse();

            return new UnassignedInformation(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link UnassignedInformation}
     */
    public static final JsonpDeserializer<UnassignedInformation> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        UnassignedInformation::setupUnassignedInformationDeserializer
    );

    protected static void setupUnassignedInformationDeserializer(ObjectDeserializer<UnassignedInformation.Builder> op) {
        op.add(Builder::allocationStatus, JsonpDeserializer.stringDeserializer(), "allocation_status");
        op.add(Builder::at, JsonpDeserializer.stringDeserializer(), "at");
        op.add(Builder::delayed, JsonpDeserializer.booleanDeserializer(), "delayed");
        op.add(Builder::details, JsonpDeserializer.stringDeserializer(), "details");
        op.add(Builder::failedAllocationAttempts, JsonpDeserializer.integerDeserializer(), "failed_allocation_attempts");
        op.add(Builder::lastAllocationStatus, JsonpDeserializer.stringDeserializer(), "last_allocation_status");
        op.add(Builder::reason, UnassignedInformationReason._DESERIALIZER, "reason");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.allocationStatus);
        result = 31 * result + this.at.hashCode();
        result = 31 * result + Objects.hashCode(this.delayed);
        result = 31 * result + Objects.hashCode(this.details);
        result = 31 * result + Objects.hashCode(this.failedAllocationAttempts);
        result = 31 * result + Objects.hashCode(this.lastAllocationStatus);
        result = 31 * result + this.reason.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        UnassignedInformation other = (UnassignedInformation) o;
        return Objects.equals(this.allocationStatus, other.allocationStatus)
            && this.at.equals(other.at)
            && Objects.equals(this.delayed, other.delayed)
            && Objects.equals(this.details, other.details)
            && Objects.equals(this.failedAllocationAttempts, other.failedAllocationAttempts)
            && Objects.equals(this.lastAllocationStatus, other.lastAllocationStatus)
            && this.reason.equals(other.reason);
    }
}
