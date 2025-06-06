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

// typedef: ism.PolicyWithMetadata

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class PolicyWithMetadata implements PlainJsonSerializable, ToCopyableBuilder<PolicyWithMetadata.Builder, PolicyWithMetadata> {

    @Nullable
    private final Policy policy;

    // ---------------------------------------------------------------------------------------------

    private PolicyWithMetadata(Builder builder) {
        this.policy = builder.policy;
    }

    public static PolicyWithMetadata of(Function<PolicyWithMetadata.Builder, ObjectBuilder<PolicyWithMetadata>> fn) {
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
     * Builder for {@link PolicyWithMetadata}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, PolicyWithMetadata> {
        @Nullable
        private Policy policy;

        public Builder() {}

        private Builder(PolicyWithMetadata o) {
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
         * Builds a {@link PolicyWithMetadata}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PolicyWithMetadata build() {
            _checkSingleUse();

            return new PolicyWithMetadata(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PolicyWithMetadata}
     */
    public static final JsonpDeserializer<PolicyWithMetadata> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PolicyWithMetadata::setupPolicyWithMetadataDeserializer
    );

    protected static void setupPolicyWithMetadataDeserializer(ObjectDeserializer<PolicyWithMetadata.Builder> op) {
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
        PolicyWithMetadata other = (PolicyWithMetadata) o;
        return Objects.equals(this.policy, other.policy);
    }
}
