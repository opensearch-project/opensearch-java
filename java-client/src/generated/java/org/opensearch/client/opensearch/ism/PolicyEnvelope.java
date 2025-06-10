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

// typedef: ism.PolicyEnvelope

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class PolicyEnvelope implements PlainJsonSerializable, ToCopyableBuilder<PolicyEnvelope.Builder, PolicyEnvelope> {

    @Nullable
    private final Policy policy;

    // ---------------------------------------------------------------------------------------------

    private PolicyEnvelope(Builder builder) {
        this.policy = builder.policy;
    }

    public static PolicyEnvelope of(Function<PolicyEnvelope.Builder, ObjectBuilder<PolicyEnvelope>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code policy}
     */
    @Nullable
    public final Policy policy() {
        return this.policy;
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
        if (this.policy != null) {
            generator.writeKey("policy");
            this.policy.serialize(generator, mapper);
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
     * Builder for {@link PolicyEnvelope}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, PolicyEnvelope> {
        @Nullable
        private Policy policy;

        public Builder() {}

        private Builder(PolicyEnvelope o) {
            this.policy = o.policy;
        }

        private Builder(Builder o) {
            this.policy = o.policy;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code policy}
         */
        @Nonnull
        public final Builder policy(@Nullable Policy value) {
            this.policy = value;
            return this;
        }

        /**
         * API name: {@code policy}
         */
        @Nonnull
        public final Builder policy(Function<Policy.Builder, ObjectBuilder<Policy>> fn) {
            return policy(fn.apply(new Policy.Builder()).build());
        }

        /**
         * Builds a {@link PolicyEnvelope}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PolicyEnvelope build() {
            _checkSingleUse();

            return new PolicyEnvelope(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PolicyEnvelope}
     */
    public static final JsonpDeserializer<PolicyEnvelope> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PolicyEnvelope::setupPolicyEnvelopeDeserializer
    );

    protected static void setupPolicyEnvelopeDeserializer(ObjectDeserializer<PolicyEnvelope.Builder> op) {
        op.add(Builder::policy, Policy._DESERIALIZER, "policy");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.policy);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PolicyEnvelope other = (PolicyEnvelope) o;
        return Objects.equals(this.policy, other.policy);
    }
}
