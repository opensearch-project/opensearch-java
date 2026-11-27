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

// typedef: ism.ExplainFilter

/**
 * Filters the managed indexes.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ExplainFilter implements PlainJsonSerializable, ToCopyableBuilder<ExplainFilter.Builder, ExplainFilter> {

    @Nullable
    private final String actionType;

    @Nullable
    private final Boolean failed;

    @Nullable
    private final String policyId;

    @Nullable
    private final String state;

    // ---------------------------------------------------------------------------------------------

    private ExplainFilter(Builder builder) {
        this.actionType = builder.actionType;
        this.failed = builder.failed;
        this.policyId = builder.policyId;
        this.state = builder.state;
    }

    public static ExplainFilter of(Function<ExplainFilter.Builder, ObjectBuilder<ExplainFilter>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Only returns indexes running this action.
     * <p>
     * API name: {@code action_type}
     * </p>
     */
    @Nullable
    public final String actionType() {
        return this.actionType;
    }

    /**
     * Only returns indexes whose policy failed or did not fail.
     * <p>
     * API name: {@code failed}
     * </p>
     */
    @Nullable
    public final Boolean failed() {
        return this.failed;
    }

    /**
     * Only returns indexes managed by this policy.
     * <p>
     * API name: {@code policy_id}
     * </p>
     */
    @Nullable
    public final String policyId() {
        return this.policyId;
    }

    /**
     * Only returns indexes in this state.
     * <p>
     * API name: {@code state}
     * </p>
     */
    @Nullable
    public final String state() {
        return this.state;
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
        if (this.actionType != null) {
            generator.writeKey("action_type");
            generator.write(this.actionType);
        }

        if (this.failed != null) {
            generator.writeKey("failed");
            generator.write(this.failed);
        }

        if (this.policyId != null) {
            generator.writeKey("policy_id");
            generator.write(this.policyId);
        }

        if (this.state != null) {
            generator.writeKey("state");
            generator.write(this.state);
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
     * Builder for {@link ExplainFilter}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ExplainFilter> {
        @Nullable
        private String actionType;
        @Nullable
        private Boolean failed;
        @Nullable
        private String policyId;
        @Nullable
        private String state;

        public Builder() {}

        private Builder(ExplainFilter o) {
            this.actionType = o.actionType;
            this.failed = o.failed;
            this.policyId = o.policyId;
            this.state = o.state;
        }

        private Builder(Builder o) {
            this.actionType = o.actionType;
            this.failed = o.failed;
            this.policyId = o.policyId;
            this.state = o.state;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Only returns indexes running this action.
         * <p>
         * API name: {@code action_type}
         * </p>
         */
        @Nonnull
        public final Builder actionType(@Nullable String value) {
            this.actionType = value;
            return this;
        }

        /**
         * Only returns indexes whose policy failed or did not fail.
         * <p>
         * API name: {@code failed}
         * </p>
         */
        @Nonnull
        public final Builder failed(@Nullable Boolean value) {
            this.failed = value;
            return this;
        }

        /**
         * Only returns indexes managed by this policy.
         * <p>
         * API name: {@code policy_id}
         * </p>
         */
        @Nonnull
        public final Builder policyId(@Nullable String value) {
            this.policyId = value;
            return this;
        }

        /**
         * Only returns indexes in this state.
         * <p>
         * API name: {@code state}
         * </p>
         */
        @Nonnull
        public final Builder state(@Nullable String value) {
            this.state = value;
            return this;
        }

        /**
         * Builds a {@link ExplainFilter}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ExplainFilter build() {
            _checkSingleUse();

            return new ExplainFilter(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ExplainFilter}
     */
    public static final JsonpDeserializer<ExplainFilter> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ExplainFilter::setupExplainFilterDeserializer
    );

    protected static void setupExplainFilterDeserializer(ObjectDeserializer<ExplainFilter.Builder> op) {
        op.add(Builder::actionType, JsonpDeserializer.stringDeserializer(), "action_type");
        op.add(Builder::failed, JsonpDeserializer.booleanDeserializer(), "failed");
        op.add(Builder::policyId, JsonpDeserializer.stringDeserializer(), "policy_id");
        op.add(Builder::state, JsonpDeserializer.stringDeserializer(), "state");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.actionType);
        result = 31 * result + Objects.hashCode(this.failed);
        result = 31 * result + Objects.hashCode(this.policyId);
        result = 31 * result + Objects.hashCode(this.state);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ExplainFilter other = (ExplainFilter) o;
        return Objects.equals(this.actionType, other.actionType)
            && Objects.equals(this.failed, other.failed)
            && Objects.equals(this.policyId, other.policyId)
            && Objects.equals(this.state, other.state);
    }
}
