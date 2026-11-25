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
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonData;
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

// typedef: ism.ExplainPolicy

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ExplainPolicy implements PlainJsonSerializable, ToCopyableBuilder<ExplainPolicy.Builder, ExplainPolicy> {

    @Nullable
    private final ExplainActionMetadata action;

    @Nullable
    private final Boolean enabled;

    @Nullable
    private final String index;

    @Nullable
    private final Long indexCreationDate;

    @Nullable
    private final String indexOpendistroIndexStateManagementPolicyId;

    @Nullable
    private final String indexPluginsIndexStateManagementPolicyId;

    @Nullable
    private final String indexUuid;

    @Nonnull
    private final Map<String, JsonData> info;

    @Nullable
    private final Policy policy;

    @Nullable
    private final Boolean policyCompleted;

    @Nullable
    private final String policyId;

    @Nullable
    private final Long policyPrimaryTerm;

    @Nullable
    private final Long policySeqNo;

    @Nullable
    private final ExplainRetryInfo retryInfo;

    @Nullable
    private final Boolean rolledOver;

    @Nullable
    private final String rolledOverIndexName;

    @Nullable
    private final ExplainStateMetadata state;

    @Nullable
    private final ExplainStepMetadata step;

    @Nullable
    private final String transitionTo;

    @Nullable
    private final ExplainValidationResult validate;

    // ---------------------------------------------------------------------------------------------

    private ExplainPolicy(Builder builder) {
        this.action = builder.action;
        this.enabled = builder.enabled;
        this.index = builder.index;
        this.indexCreationDate = builder.indexCreationDate;
        this.indexOpendistroIndexStateManagementPolicyId = builder.indexOpendistroIndexStateManagementPolicyId;
        this.indexPluginsIndexStateManagementPolicyId = builder.indexPluginsIndexStateManagementPolicyId;
        this.indexUuid = builder.indexUuid;
        this.info = ApiTypeHelper.unmodifiable(builder.info);
        this.policy = builder.policy;
        this.policyCompleted = builder.policyCompleted;
        this.policyId = builder.policyId;
        this.policyPrimaryTerm = builder.policyPrimaryTerm;
        this.policySeqNo = builder.policySeqNo;
        this.retryInfo = builder.retryInfo;
        this.rolledOver = builder.rolledOver;
        this.rolledOverIndexName = builder.rolledOverIndexName;
        this.state = builder.state;
        this.step = builder.step;
        this.transitionTo = builder.transitionTo;
        this.validate = builder.validate;
    }

    public static ExplainPolicy of(Function<ExplainPolicy.Builder, ObjectBuilder<ExplainPolicy>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code action}
     */
    @Nullable
    public final ExplainActionMetadata action() {
        return this.action;
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
     * The name of the managed index.
     * <p>
     * API name: {@code index}
     * </p>
     */
    @Nullable
    public final String index() {
        return this.index;
    }

    /**
     * API name: {@code index_creation_date}
     */
    @Nullable
    public final Long indexCreationDate() {
        return this.indexCreationDate;
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
     * The UUID of the managed index.
     * <p>
     * API name: {@code index_uuid}
     * </p>
     */
    @Nullable
    public final String indexUuid() {
        return this.indexUuid;
    }

    /**
     * Additional information about the current status of the managed index.
     * <p>
     * API name: {@code info}
     * </p>
     */
    @Nonnull
    public final Map<String, JsonData> info() {
        return this.info;
    }

    /**
     * API name: {@code policy}
     */
    @Nullable
    public final Policy policy() {
        return this.policy;
    }

    /**
     * Whether the policy has completed for the index.
     * <p>
     * API name: {@code policy_completed}
     * </p>
     */
    @Nullable
    public final Boolean policyCompleted() {
        return this.policyCompleted;
    }

    /**
     * The ID of the policy applied to the index.
     * <p>
     * API name: {@code policy_id}
     * </p>
     */
    @Nullable
    public final String policyId() {
        return this.policyId;
    }

    /**
     * The primary term of the policy applied to the index.
     * <p>
     * API name: {@code policy_primary_term}
     * </p>
     */
    @Nullable
    public final Long policyPrimaryTerm() {
        return this.policyPrimaryTerm;
    }

    /**
     * API name: {@code policy_seq_no}
     */
    @Nullable
    public final Long policySeqNo() {
        return this.policySeqNo;
    }

    /**
     * API name: {@code retry_info}
     */
    @Nullable
    public final ExplainRetryInfo retryInfo() {
        return this.retryInfo;
    }

    /**
     * Whether the index has been rolled over.
     * <p>
     * API name: {@code rolled_over}
     * </p>
     */
    @Nullable
    public final Boolean rolledOver() {
        return this.rolledOver;
    }

    /**
     * The name of the index the managed index was rolled over to.
     * <p>
     * API name: {@code rolled_over_index_name}
     * </p>
     */
    @Nullable
    public final String rolledOverIndexName() {
        return this.rolledOverIndexName;
    }

    /**
     * API name: {@code state}
     */
    @Nullable
    public final ExplainStateMetadata state() {
        return this.state;
    }

    /**
     * API name: {@code step}
     */
    @Nullable
    public final ExplainStepMetadata step() {
        return this.step;
    }

    /**
     * The state the index is transitioning to.
     * <p>
     * API name: {@code transition_to}
     * </p>
     */
    @Nullable
    public final String transitionTo() {
        return this.transitionTo;
    }

    /**
     * API name: {@code validate}
     */
    @Nullable
    public final ExplainValidationResult validate() {
        return this.validate;
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
        if (this.action != null) {
            generator.writeKey("action");
            this.action.serialize(generator, mapper);
        }

        if (this.enabled != null) {
            generator.writeKey("enabled");
            generator.write(this.enabled);
        }

        if (this.index != null) {
            generator.writeKey("index");
            generator.write(this.index);
        }

        if (this.indexCreationDate != null) {
            generator.writeKey("index_creation_date");
            generator.write(this.indexCreationDate);
        }

        if (this.indexOpendistroIndexStateManagementPolicyId != null) {
            generator.writeKey("index.opendistro.index_state_management.policy_id");
            generator.write(this.indexOpendistroIndexStateManagementPolicyId);
        }

        if (this.indexPluginsIndexStateManagementPolicyId != null) {
            generator.writeKey("index.plugins.index_state_management.policy_id");
            generator.write(this.indexPluginsIndexStateManagementPolicyId);
        }

        if (this.indexUuid != null) {
            generator.writeKey("index_uuid");
            generator.write(this.indexUuid);
        }

        if (ApiTypeHelper.isDefined(this.info)) {
            generator.writeKey("info");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.info.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.policy != null) {
            generator.writeKey("policy");
            this.policy.serialize(generator, mapper);
        }

        if (this.policyCompleted != null) {
            generator.writeKey("policy_completed");
            generator.write(this.policyCompleted);
        }

        if (this.policyId != null) {
            generator.writeKey("policy_id");
            generator.write(this.policyId);
        }

        if (this.policyPrimaryTerm != null) {
            generator.writeKey("policy_primary_term");
            generator.write(this.policyPrimaryTerm);
        }

        if (this.policySeqNo != null) {
            generator.writeKey("policy_seq_no");
            generator.write(this.policySeqNo);
        }

        if (this.retryInfo != null) {
            generator.writeKey("retry_info");
            this.retryInfo.serialize(generator, mapper);
        }

        if (this.rolledOver != null) {
            generator.writeKey("rolled_over");
            generator.write(this.rolledOver);
        }

        if (this.rolledOverIndexName != null) {
            generator.writeKey("rolled_over_index_name");
            generator.write(this.rolledOverIndexName);
        }

        if (this.state != null) {
            generator.writeKey("state");
            this.state.serialize(generator, mapper);
        }

        if (this.step != null) {
            generator.writeKey("step");
            this.step.serialize(generator, mapper);
        }

        if (this.transitionTo != null) {
            generator.writeKey("transition_to");
            generator.write(this.transitionTo);
        }

        if (this.validate != null) {
            generator.writeKey("validate");
            this.validate.serialize(generator, mapper);
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
        private ExplainActionMetadata action;
        @Nullable
        private Boolean enabled;
        @Nullable
        private String index;
        @Nullable
        private Long indexCreationDate;
        @Nullable
        private String indexOpendistroIndexStateManagementPolicyId;
        @Nullable
        private String indexPluginsIndexStateManagementPolicyId;
        @Nullable
        private String indexUuid;
        @Nullable
        private Map<String, JsonData> info;
        @Nullable
        private Policy policy;
        @Nullable
        private Boolean policyCompleted;
        @Nullable
        private String policyId;
        @Nullable
        private Long policyPrimaryTerm;
        @Nullable
        private Long policySeqNo;
        @Nullable
        private ExplainRetryInfo retryInfo;
        @Nullable
        private Boolean rolledOver;
        @Nullable
        private String rolledOverIndexName;
        @Nullable
        private ExplainStateMetadata state;
        @Nullable
        private ExplainStepMetadata step;
        @Nullable
        private String transitionTo;
        @Nullable
        private ExplainValidationResult validate;

        public Builder() {}

        private Builder(ExplainPolicy o) {
            this.action = o.action;
            this.enabled = o.enabled;
            this.index = o.index;
            this.indexCreationDate = o.indexCreationDate;
            this.indexOpendistroIndexStateManagementPolicyId = o.indexOpendistroIndexStateManagementPolicyId;
            this.indexPluginsIndexStateManagementPolicyId = o.indexPluginsIndexStateManagementPolicyId;
            this.indexUuid = o.indexUuid;
            this.info = _mapCopy(o.info);
            this.policy = o.policy;
            this.policyCompleted = o.policyCompleted;
            this.policyId = o.policyId;
            this.policyPrimaryTerm = o.policyPrimaryTerm;
            this.policySeqNo = o.policySeqNo;
            this.retryInfo = o.retryInfo;
            this.rolledOver = o.rolledOver;
            this.rolledOverIndexName = o.rolledOverIndexName;
            this.state = o.state;
            this.step = o.step;
            this.transitionTo = o.transitionTo;
            this.validate = o.validate;
        }

        private Builder(Builder o) {
            this.action = o.action;
            this.enabled = o.enabled;
            this.index = o.index;
            this.indexCreationDate = o.indexCreationDate;
            this.indexOpendistroIndexStateManagementPolicyId = o.indexOpendistroIndexStateManagementPolicyId;
            this.indexPluginsIndexStateManagementPolicyId = o.indexPluginsIndexStateManagementPolicyId;
            this.indexUuid = o.indexUuid;
            this.info = _mapCopy(o.info);
            this.policy = o.policy;
            this.policyCompleted = o.policyCompleted;
            this.policyId = o.policyId;
            this.policyPrimaryTerm = o.policyPrimaryTerm;
            this.policySeqNo = o.policySeqNo;
            this.retryInfo = o.retryInfo;
            this.rolledOver = o.rolledOver;
            this.rolledOverIndexName = o.rolledOverIndexName;
            this.state = o.state;
            this.step = o.step;
            this.transitionTo = o.transitionTo;
            this.validate = o.validate;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code action}
         */
        @Nonnull
        public final Builder action(@Nullable ExplainActionMetadata value) {
            this.action = value;
            return this;
        }

        /**
         * API name: {@code action}
         */
        @Nonnull
        public final Builder action(Function<ExplainActionMetadata.Builder, ObjectBuilder<ExplainActionMetadata>> fn) {
            return action(fn.apply(new ExplainActionMetadata.Builder()).build());
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
         * The name of the managed index.
         * <p>
         * API name: {@code index}
         * </p>
         */
        @Nonnull
        public final Builder index(@Nullable String value) {
            this.index = value;
            return this;
        }

        /**
         * API name: {@code index_creation_date}
         */
        @Nonnull
        public final Builder indexCreationDate(@Nullable Long value) {
            this.indexCreationDate = value;
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
         * The UUID of the managed index.
         * <p>
         * API name: {@code index_uuid}
         * </p>
         */
        @Nonnull
        public final Builder indexUuid(@Nullable String value) {
            this.indexUuid = value;
            return this;
        }

        /**
         * Additional information about the current status of the managed index.
         * <p>
         * API name: {@code info}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>info</code>.
         * </p>
         */
        @Nonnull
        public final Builder info(Map<String, JsonData> map) {
            this.info = _mapPutAll(this.info, map);
            return this;
        }

        /**
         * Additional information about the current status of the managed index.
         * <p>
         * API name: {@code info}
         * </p>
         *
         * <p>
         * Adds an entry to <code>info</code>.
         * </p>
         */
        @Nonnull
        public final Builder info(String key, JsonData value) {
            this.info = _mapPut(this.info, key, value);
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
         * Whether the policy has completed for the index.
         * <p>
         * API name: {@code policy_completed}
         * </p>
         */
        @Nonnull
        public final Builder policyCompleted(@Nullable Boolean value) {
            this.policyCompleted = value;
            return this;
        }

        /**
         * The ID of the policy applied to the index.
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
         * The primary term of the policy applied to the index.
         * <p>
         * API name: {@code policy_primary_term}
         * </p>
         */
        @Nonnull
        public final Builder policyPrimaryTerm(@Nullable Long value) {
            this.policyPrimaryTerm = value;
            return this;
        }

        /**
         * API name: {@code policy_seq_no}
         */
        @Nonnull
        public final Builder policySeqNo(@Nullable Long value) {
            this.policySeqNo = value;
            return this;
        }

        /**
         * API name: {@code retry_info}
         */
        @Nonnull
        public final Builder retryInfo(@Nullable ExplainRetryInfo value) {
            this.retryInfo = value;
            return this;
        }

        /**
         * API name: {@code retry_info}
         */
        @Nonnull
        public final Builder retryInfo(Function<ExplainRetryInfo.Builder, ObjectBuilder<ExplainRetryInfo>> fn) {
            return retryInfo(fn.apply(new ExplainRetryInfo.Builder()).build());
        }

        /**
         * Whether the index has been rolled over.
         * <p>
         * API name: {@code rolled_over}
         * </p>
         */
        @Nonnull
        public final Builder rolledOver(@Nullable Boolean value) {
            this.rolledOver = value;
            return this;
        }

        /**
         * The name of the index the managed index was rolled over to.
         * <p>
         * API name: {@code rolled_over_index_name}
         * </p>
         */
        @Nonnull
        public final Builder rolledOverIndexName(@Nullable String value) {
            this.rolledOverIndexName = value;
            return this;
        }

        /**
         * API name: {@code state}
         */
        @Nonnull
        public final Builder state(@Nullable ExplainStateMetadata value) {
            this.state = value;
            return this;
        }

        /**
         * API name: {@code state}
         */
        @Nonnull
        public final Builder state(Function<ExplainStateMetadata.Builder, ObjectBuilder<ExplainStateMetadata>> fn) {
            return state(fn.apply(new ExplainStateMetadata.Builder()).build());
        }

        /**
         * API name: {@code step}
         */
        @Nonnull
        public final Builder step(@Nullable ExplainStepMetadata value) {
            this.step = value;
            return this;
        }

        /**
         * API name: {@code step}
         */
        @Nonnull
        public final Builder step(Function<ExplainStepMetadata.Builder, ObjectBuilder<ExplainStepMetadata>> fn) {
            return step(fn.apply(new ExplainStepMetadata.Builder()).build());
        }

        /**
         * The state the index is transitioning to.
         * <p>
         * API name: {@code transition_to}
         * </p>
         */
        @Nonnull
        public final Builder transitionTo(@Nullable String value) {
            this.transitionTo = value;
            return this;
        }

        /**
         * API name: {@code validate}
         */
        @Nonnull
        public final Builder validate(@Nullable ExplainValidationResult value) {
            this.validate = value;
            return this;
        }

        /**
         * API name: {@code validate}
         */
        @Nonnull
        public final Builder validate(Function<ExplainValidationResult.Builder, ObjectBuilder<ExplainValidationResult>> fn) {
            return validate(fn.apply(new ExplainValidationResult.Builder()).build());
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
        op.add(Builder::action, ExplainActionMetadata._DESERIALIZER, "action");
        op.add(Builder::enabled, JsonpDeserializer.booleanDeserializer(), "enabled");
        op.add(Builder::index, JsonpDeserializer.stringDeserializer(), "index");
        op.add(Builder::indexCreationDate, JsonpDeserializer.longDeserializer(), "index_creation_date");
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
        op.add(Builder::indexUuid, JsonpDeserializer.stringDeserializer(), "index_uuid");
        op.add(Builder::info, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "info");
        op.add(Builder::policy, Policy._DESERIALIZER, "policy");
        op.add(Builder::policyCompleted, JsonpDeserializer.booleanDeserializer(), "policy_completed");
        op.add(Builder::policyId, JsonpDeserializer.stringDeserializer(), "policy_id");
        op.add(Builder::policyPrimaryTerm, JsonpDeserializer.longDeserializer(), "policy_primary_term");
        op.add(Builder::policySeqNo, JsonpDeserializer.longDeserializer(), "policy_seq_no");
        op.add(Builder::retryInfo, ExplainRetryInfo._DESERIALIZER, "retry_info");
        op.add(Builder::rolledOver, JsonpDeserializer.booleanDeserializer(), "rolled_over");
        op.add(Builder::rolledOverIndexName, JsonpDeserializer.stringDeserializer(), "rolled_over_index_name");
        op.add(Builder::state, ExplainStateMetadata._DESERIALIZER, "state");
        op.add(Builder::step, ExplainStepMetadata._DESERIALIZER, "step");
        op.add(Builder::transitionTo, JsonpDeserializer.stringDeserializer(), "transition_to");
        op.add(Builder::validate, ExplainValidationResult._DESERIALIZER, "validate");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.action);
        result = 31 * result + Objects.hashCode(this.enabled);
        result = 31 * result + Objects.hashCode(this.index);
        result = 31 * result + Objects.hashCode(this.indexCreationDate);
        result = 31 * result + Objects.hashCode(this.indexOpendistroIndexStateManagementPolicyId);
        result = 31 * result + Objects.hashCode(this.indexPluginsIndexStateManagementPolicyId);
        result = 31 * result + Objects.hashCode(this.indexUuid);
        result = 31 * result + Objects.hashCode(this.info);
        result = 31 * result + Objects.hashCode(this.policy);
        result = 31 * result + Objects.hashCode(this.policyCompleted);
        result = 31 * result + Objects.hashCode(this.policyId);
        result = 31 * result + Objects.hashCode(this.policyPrimaryTerm);
        result = 31 * result + Objects.hashCode(this.policySeqNo);
        result = 31 * result + Objects.hashCode(this.retryInfo);
        result = 31 * result + Objects.hashCode(this.rolledOver);
        result = 31 * result + Objects.hashCode(this.rolledOverIndexName);
        result = 31 * result + Objects.hashCode(this.state);
        result = 31 * result + Objects.hashCode(this.step);
        result = 31 * result + Objects.hashCode(this.transitionTo);
        result = 31 * result + Objects.hashCode(this.validate);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ExplainPolicy other = (ExplainPolicy) o;
        return Objects.equals(this.action, other.action)
            && Objects.equals(this.enabled, other.enabled)
            && Objects.equals(this.index, other.index)
            && Objects.equals(this.indexCreationDate, other.indexCreationDate)
            && Objects.equals(this.indexOpendistroIndexStateManagementPolicyId, other.indexOpendistroIndexStateManagementPolicyId)
            && Objects.equals(this.indexPluginsIndexStateManagementPolicyId, other.indexPluginsIndexStateManagementPolicyId)
            && Objects.equals(this.indexUuid, other.indexUuid)
            && Objects.equals(this.info, other.info)
            && Objects.equals(this.policy, other.policy)
            && Objects.equals(this.policyCompleted, other.policyCompleted)
            && Objects.equals(this.policyId, other.policyId)
            && Objects.equals(this.policyPrimaryTerm, other.policyPrimaryTerm)
            && Objects.equals(this.policySeqNo, other.policySeqNo)
            && Objects.equals(this.retryInfo, other.retryInfo)
            && Objects.equals(this.rolledOver, other.rolledOver)
            && Objects.equals(this.rolledOverIndexName, other.rolledOverIndexName)
            && Objects.equals(this.state, other.state)
            && Objects.equals(this.step, other.step)
            && Objects.equals(this.transitionTo, other.transitionTo)
            && Objects.equals(this.validate, other.validate);
    }
}
