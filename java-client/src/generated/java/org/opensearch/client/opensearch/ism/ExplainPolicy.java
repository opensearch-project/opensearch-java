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

// typedef: ism.ExplainPolicy

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ExplainPolicy implements PlainJsonSerializable, ToCopyableBuilder<ExplainPolicy.Builder, ExplainPolicy> {

    @Nullable
    private final Boolean enabled;

    @Nullable
    private final String indexOpendistroIndexStateManagementPolicyId;

    @Nullable
    private final String indexPluginsIndexStateManagementPolicyId;

    // ---------------------------------------------------------------------------------------------

    private ExplainPolicy(Builder builder) {
        this.enabled = builder.enabled;
        this.indexOpendistroIndexStateManagementPolicyId = builder.indexOpendistroIndexStateManagementPolicyId;
        this.indexPluginsIndexStateManagementPolicyId = builder.indexPluginsIndexStateManagementPolicyId;
    }

    public static ExplainPolicy of(Function<ExplainPolicy.Builder, ObjectBuilder<ExplainPolicy>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Whether the policy is enabled for the index.
     * <p>
     * API name: {@code enabled}
     * </p>
     */
    @Nullable
    public final Boolean enabled() {
        return this.enabled;
    }

    /**
     * The ID of the OpenDistro policy applied to the index.
     * <p>
     * API name: {@code index.opendistro.index_state_management.policy_id}
     * </p>
     */
    @Nullable
    public final String indexOpendistroIndexStateManagementPolicyId() {
        return this.indexOpendistroIndexStateManagementPolicyId;
    }

    /**
     * The ID of the policy applied to the index.
     * <p>
     * API name: {@code index.plugins.index_state_management.policy_id}
     * </p>
     */
    @Nullable
    public final String indexPluginsIndexStateManagementPolicyId() {
        return this.indexPluginsIndexStateManagementPolicyId;
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

        if (this.indexOpendistroIndexStateManagementPolicyId != null) {
            generator.writeKey("index.opendistro.index_state_management.policy_id");
            generator.write(this.indexOpendistroIndexStateManagementPolicyId);
        }

        if (this.indexPluginsIndexStateManagementPolicyId != null) {
            generator.writeKey("index.plugins.index_state_management.policy_id");
            generator.write(this.indexPluginsIndexStateManagementPolicyId);
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
     * Builder for {@link ExplainPolicy}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ExplainPolicy> {
        @Nullable
        private Boolean enabled;
        @Nullable
        private String indexOpendistroIndexStateManagementPolicyId;
        @Nullable
        private String indexPluginsIndexStateManagementPolicyId;

        public Builder() {}

        private Builder(ExplainPolicy o) {
            this.enabled = o.enabled;
            this.indexOpendistroIndexStateManagementPolicyId = o.indexOpendistroIndexStateManagementPolicyId;
            this.indexPluginsIndexStateManagementPolicyId = o.indexPluginsIndexStateManagementPolicyId;
        }

        private Builder(Builder o) {
            this.enabled = o.enabled;
            this.indexOpendistroIndexStateManagementPolicyId = o.indexOpendistroIndexStateManagementPolicyId;
            this.indexPluginsIndexStateManagementPolicyId = o.indexPluginsIndexStateManagementPolicyId;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Whether the policy is enabled for the index.
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
         * The ID of the OpenDistro policy applied to the index.
         * <p>
         * API name: {@code index.opendistro.index_state_management.policy_id}
         * </p>
         */
        @Nonnull
        public final Builder indexOpendistroIndexStateManagementPolicyId(@Nullable String value) {
            this.indexOpendistroIndexStateManagementPolicyId = value;
            return this;
        }

        /**
         * The ID of the policy applied to the index.
         * <p>
         * API name: {@code index.plugins.index_state_management.policy_id}
         * </p>
         */
        @Nonnull
        public final Builder indexPluginsIndexStateManagementPolicyId(@Nullable String value) {
            this.indexPluginsIndexStateManagementPolicyId = value;
            return this;
        }

        /**
         * Builds a {@link ExplainPolicy}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ExplainPolicy build() {
            _checkSingleUse();

            return new ExplainPolicy(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ExplainPolicy}
     */
    public static final JsonpDeserializer<ExplainPolicy> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ExplainPolicy::setupExplainPolicyDeserializer
    );

    protected static void setupExplainPolicyDeserializer(ObjectDeserializer<ExplainPolicy.Builder> op) {
        op.add(Builder::enabled, JsonpDeserializer.booleanDeserializer(), "enabled");
        op.add(
            Builder::indexOpendistroIndexStateManagementPolicyId,
            JsonpDeserializer.stringDeserializer(),
            "index.opendistro.index_state_management.policy_id"
        );
        op.add(
            Builder::indexPluginsIndexStateManagementPolicyId,
            JsonpDeserializer.stringDeserializer(),
            "index.plugins.index_state_management.policy_id"
        );
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.enabled);
        result = 31 * result + Objects.hashCode(this.indexOpendistroIndexStateManagementPolicyId);
        result = 31 * result + Objects.hashCode(this.indexPluginsIndexStateManagementPolicyId);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ExplainPolicy other = (ExplainPolicy) o;
        return Objects.equals(this.enabled, other.enabled)
            && Objects.equals(this.indexOpendistroIndexStateManagementPolicyId, other.indexOpendistroIndexStateManagementPolicyId)
            && Objects.equals(this.indexPluginsIndexStateManagementPolicyId, other.indexPluginsIndexStateManagementPolicyId);
    }
}
