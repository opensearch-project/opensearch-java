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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ism.change_policy.Request

/**
 * Updates the managed index policy to a new policy.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class ChangePolicyRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ChangePolicyRequest.Builder, ChangePolicyRequest> {

    @Nonnull
    private final List<IncludeState> include;

    @Nullable
    private final String index;

    @Nonnull
    private final String policyId;

    @Nullable
    private final String state;

    // ---------------------------------------------------------------------------------------------

    private ChangePolicyRequest(Builder builder) {
        super(builder);
        this.include = ApiTypeHelper.unmodifiable(builder.include);
        this.index = builder.index;
        this.policyId = ApiTypeHelper.requireNonNull(builder.policyId, this, "policyId");
        this.state = builder.state;
    }

    public static ChangePolicyRequest of(Function<ChangePolicyRequest.Builder, ObjectBuilder<ChangePolicyRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The states to include in the policy change.
     * <p>
     * API name: {@code include}
     * </p>
     */
    @Nonnull
    public final List<IncludeState> include() {
        return this.include;
    }

    /**
     * API name: {@code index}
     */
    @Nullable
    public final String index() {
        return this.index;
    }

    /**
     * Required - The ID of the new policy.
     * <p>
     * API name: {@code policy_id}
     * </p>
     */
    @Nonnull
    public final String policyId() {
        return this.policyId;
    }

    /**
     * The state to transition to.
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
        if (ApiTypeHelper.isDefined(this.include)) {
            generator.writeKey("include");
            generator.writeStartArray();
            for (IncludeState item0 : this.include) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        generator.writeKey("policy_id");
        generator.write(this.policyId);

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
     * Builder for {@link ChangePolicyRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, ChangePolicyRequest> {
        @Nullable
        private List<IncludeState> include;
        @Nullable
        private String index;
        private String policyId;
        @Nullable
        private String state;

        public Builder() {}

        private Builder(ChangePolicyRequest o) {
            super(o);
            this.include = _listCopy(o.include);
            this.index = o.index;
            this.policyId = o.policyId;
            this.state = o.state;
        }

        private Builder(Builder o) {
            super(o);
            this.include = _listCopy(o.include);
            this.index = o.index;
            this.policyId = o.policyId;
            this.state = o.state;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        @Override
        @Nonnull
        protected Builder self() {
            return this;
        }

        /**
         * The states to include in the policy change.
         * <p>
         * API name: {@code include}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>include</code>.
         * </p>
         */
        @Nonnull
        public final Builder include(List<IncludeState> list) {
            this.include = _listAddAll(this.include, list);
            return this;
        }

        /**
         * The states to include in the policy change.
         * <p>
         * API name: {@code include}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>include</code>.
         * </p>
         */
        @Nonnull
        public final Builder include(IncludeState value, IncludeState... values) {
            this.include = _listAdd(this.include, value, values);
            return this;
        }

        /**
         * The states to include in the policy change.
         * <p>
         * API name: {@code include}
         * </p>
         *
         * <p>
         * Adds a value to <code>include</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder include(Function<IncludeState.Builder, ObjectBuilder<IncludeState>> fn) {
            return include(fn.apply(new IncludeState.Builder()).build());
        }

        /**
         * API name: {@code index}
         */
        @Nonnull
        public final Builder index(@Nullable String value) {
            this.index = value;
            return this;
        }

        /**
         * Required - The ID of the new policy.
         * <p>
         * API name: {@code policy_id}
         * </p>
         */
        @Nonnull
        public final Builder policyId(String value) {
            this.policyId = value;
            return this;
        }

        /**
         * The state to transition to.
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
         * Builds a {@link ChangePolicyRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ChangePolicyRequest build() {
            _checkSingleUse();

            return new ChangePolicyRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ChangePolicyRequest}
     */
    public static final JsonpDeserializer<ChangePolicyRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ChangePolicyRequest::setupChangePolicyRequestDeserializer
    );

    protected static void setupChangePolicyRequestDeserializer(ObjectDeserializer<ChangePolicyRequest.Builder> op) {
        op.add(Builder::include, JsonpDeserializer.arrayDeserializer(IncludeState._DESERIALIZER), "include");
        op.add(Builder::policyId, JsonpDeserializer.stringDeserializer(), "policy_id");
        op.add(Builder::state, JsonpDeserializer.stringDeserializer(), "state");
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code ism.change_policy}".
     */
    public static final Endpoint<ChangePolicyRequest, ChangePolicyResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "POST",
        // Request path
        request -> {
            final int _index = 1 << 0;

            int propsSet = 0;

            if (request.index() != null) propsSet |= _index;

            if (propsSet == 0) {
                return "/_plugins/_ism/change_policy";
            }
            if (propsSet == (_index)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/_plugins/_ism/change_policy/");
                SimpleEndpoint.pathEncode(request.index, buf);
                return buf.toString();
            }

            throw SimpleEndpoint.noPathTemplateFound("path");
        },
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap(),
        true,
        ChangePolicyResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.include);
        result = 31 * result + Objects.hashCode(this.index);
        result = 31 * result + this.policyId.hashCode();
        result = 31 * result + Objects.hashCode(this.state);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ChangePolicyRequest other = (ChangePolicyRequest) o;
        return Objects.equals(this.include, other.include)
            && Objects.equals(this.index, other.index)
            && this.policyId.equals(other.policyId)
            && Objects.equals(this.state, other.state);
    }
}
