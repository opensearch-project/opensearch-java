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

// typedef: ism.put_policy.Request

/**
 * Creates or updates a policy.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class PutPolicyRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<PutPolicyRequest.Builder, PutPolicyRequest> {

    @Nullable
    private final Number ifPrimaryTerm;

    @Nullable
    private final Long ifSeqNo;

    @Nullable
    private final Policy policy;

    @Nonnull
    private final String policyId;

    // ---------------------------------------------------------------------------------------------

    private PutPolicyRequest(Builder builder) {
        super(builder);
        this.ifPrimaryTerm = builder.ifPrimaryTerm;
        this.ifSeqNo = builder.ifSeqNo;
        this.policy = builder.policy;
        this.policyId = ApiTypeHelper.requireNonNull(builder.policyId, this, "policyId");
    }

    public static PutPolicyRequest of(Function<PutPolicyRequest.Builder, ObjectBuilder<PutPolicyRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Only perform the operation if the document has this primary term.
     * <p>
     * API name: {@code if_primary_term}
     * </p>
     */
    @Nullable
    public final Number ifPrimaryTerm() {
        return this.ifPrimaryTerm;
    }

    /**
     * Only perform the operation if the document has this sequence number.
     * <p>
     * API name: {@code if_seq_no}
     * </p>
     */
    @Nullable
    public final Long ifSeqNo() {
        return this.ifSeqNo;
    }

    /**
     * API name: {@code policy}
     */
    @Nullable
    public final Policy policy() {
        return this.policy;
    }

    /**
     * Required - API name: {@code policy_id}
     */
    @Nonnull
    public final String policyId() {
        return this.policyId;
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
     * Builder for {@link PutPolicyRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, PutPolicyRequest> {
        @Nullable
        private Number ifPrimaryTerm;
        @Nullable
        private Long ifSeqNo;
        @Nullable
        private Policy policy;
        private String policyId;

        public Builder() {}

        private Builder(PutPolicyRequest o) {
            super(o);
            this.ifPrimaryTerm = o.ifPrimaryTerm;
            this.ifSeqNo = o.ifSeqNo;
            this.policy = o.policy;
            this.policyId = o.policyId;
        }

        private Builder(Builder o) {
            super(o);
            this.ifPrimaryTerm = o.ifPrimaryTerm;
            this.ifSeqNo = o.ifSeqNo;
            this.policy = o.policy;
            this.policyId = o.policyId;
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
         * Only perform the operation if the document has this primary term.
         * <p>
         * API name: {@code if_primary_term}
         * </p>
         */
        @Nonnull
        public final Builder ifPrimaryTerm(@Nullable Number value) {
            this.ifPrimaryTerm = value;
            return this;
        }

        /**
         * Only perform the operation if the document has this sequence number.
         * <p>
         * API name: {@code if_seq_no}
         * </p>
         */
        @Nonnull
        public final Builder ifSeqNo(@Nullable Long value) {
            this.ifSeqNo = value;
            return this;
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
         * Required - API name: {@code policy_id}
         */
        @Nonnull
        public final Builder policyId(String value) {
            this.policyId = value;
            return this;
        }

        /**
         * Builds a {@link PutPolicyRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PutPolicyRequest build() {
            _checkSingleUse();

            return new PutPolicyRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PutPolicyRequest}
     */
    public static final JsonpDeserializer<PutPolicyRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PutPolicyRequest::setupPutPolicyRequestDeserializer
    );

    protected static void setupPutPolicyRequestDeserializer(ObjectDeserializer<PutPolicyRequest.Builder> op) {
        op.add(Builder::policy, Policy._DESERIALIZER, "policy");
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    protected void applyQueryParameters(@Nonnull Map<String, String> params) {
        super.applyQueryParameters(params);
        if (this.ifPrimaryTerm != null) {
            params.put("if_primary_term", String.valueOf(this.ifPrimaryTerm));
        }
        if (this.ifSeqNo != null) {
            params.put("if_seq_no", String.valueOf(this.ifSeqNo));
        }
    }

    /**
     * Endpoint "{@code ism.put_policy}".
     */
    public static final Endpoint<PutPolicyRequest, PutPolicyResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "PUT",
        // Request path
        request -> {
            StringBuilder buf = new StringBuilder();
            buf.append("/_plugins/_ism/policies/");
            SimpleEndpoint.pathEncode(request.policyId, buf);
            return buf.toString();
        },
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap(),
        true,
        PutPolicyResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.ifPrimaryTerm);
        result = 31 * result + Objects.hashCode(this.ifSeqNo);
        result = 31 * result + Objects.hashCode(this.policy);
        result = 31 * result + this.policyId.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PutPolicyRequest other = (PutPolicyRequest) o;
        return Objects.equals(this.ifPrimaryTerm, other.ifPrimaryTerm)
            && Objects.equals(this.ifSeqNo, other.ifSeqNo)
            && Objects.equals(this.policy, other.policy)
            && this.policyId.equals(other.policyId);
    }
}
