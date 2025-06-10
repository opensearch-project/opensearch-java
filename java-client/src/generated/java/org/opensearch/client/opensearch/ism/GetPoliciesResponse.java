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

// typedef: ism.get_policies.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GetPoliciesResponse implements PlainJsonSerializable, ToCopyableBuilder<GetPoliciesResponse.Builder, GetPoliciesResponse> {

    @Nonnull
    private final List<PolicyWithMetadata> policies;

    @Nullable
    private final Number totalPolicies;

    // ---------------------------------------------------------------------------------------------

    private GetPoliciesResponse(Builder builder) {
        this.policies = ApiTypeHelper.unmodifiable(builder.policies);
        this.totalPolicies = builder.totalPolicies;
    }

    public static GetPoliciesResponse of(Function<GetPoliciesResponse.Builder, ObjectBuilder<GetPoliciesResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The list of policies.
     * <p>
     * API name: {@code policies}
     * </p>
     */
    @Nonnull
    public final List<PolicyWithMetadata> policies() {
        return this.policies;
    }

    /**
     * The total number of policies.
     * <p>
     * API name: {@code total_policies}
     * </p>
     */
    @Nullable
    public final Number totalPolicies() {
        return this.totalPolicies;
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
        if (ApiTypeHelper.isDefined(this.policies)) {
            generator.writeKey("policies");
            generator.writeStartArray();
            for (PolicyWithMetadata item0 : this.policies) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.totalPolicies != null) {
            generator.writeKey("total_policies");
            generator.write(this.totalPolicies.doubleValue());
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
     * Builder for {@link GetPoliciesResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, GetPoliciesResponse> {
        @Nullable
        private List<PolicyWithMetadata> policies;
        @Nullable
        private Number totalPolicies;

        public Builder() {}

        private Builder(GetPoliciesResponse o) {
            this.policies = _listCopy(o.policies);
            this.totalPolicies = o.totalPolicies;
        }

        private Builder(Builder o) {
            this.policies = _listCopy(o.policies);
            this.totalPolicies = o.totalPolicies;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The list of policies.
         * <p>
         * API name: {@code policies}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>policies</code>.
         * </p>
         */
        @Nonnull
        public final Builder policies(List<PolicyWithMetadata> list) {
            this.policies = _listAddAll(this.policies, list);
            return this;
        }

        /**
         * The list of policies.
         * <p>
         * API name: {@code policies}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>policies</code>.
         * </p>
         */
        @Nonnull
        public final Builder policies(PolicyWithMetadata value, PolicyWithMetadata... values) {
            this.policies = _listAdd(this.policies, value, values);
            return this;
        }

        /**
         * The list of policies.
         * <p>
         * API name: {@code policies}
         * </p>
         *
         * <p>
         * Adds a value to <code>policies</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder policies(Function<PolicyWithMetadata.Builder, ObjectBuilder<PolicyWithMetadata>> fn) {
            return policies(fn.apply(new PolicyWithMetadata.Builder()).build());
        }

        /**
         * The total number of policies.
         * <p>
         * API name: {@code total_policies}
         * </p>
         */
        @Nonnull
        public final Builder totalPolicies(@Nullable Number value) {
            this.totalPolicies = value;
            return this;
        }

        /**
         * Builds a {@link GetPoliciesResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetPoliciesResponse build() {
            _checkSingleUse();

            return new GetPoliciesResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GetPoliciesResponse}
     */
    public static final JsonpDeserializer<GetPoliciesResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GetPoliciesResponse::setupGetPoliciesResponseDeserializer
    );

    protected static void setupGetPoliciesResponseDeserializer(ObjectDeserializer<GetPoliciesResponse.Builder> op) {
        op.add(Builder::policies, JsonpDeserializer.arrayDeserializer(PolicyWithMetadata._DESERIALIZER), "policies");
        op.add(Builder::totalPolicies, JsonpDeserializer.numberDeserializer(), "total_policies");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.policies);
        result = 31 * result + Objects.hashCode(this.totalPolicies);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetPoliciesResponse other = (GetPoliciesResponse) o;
        return Objects.equals(this.policies, other.policies) && Objects.equals(this.totalPolicies, other.totalPolicies);
    }
}
