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

// typedef: ism.Policy

/**
 * The policy defines how an index is managed throughout its lifetime.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Policy implements PlainJsonSerializable, ToCopyableBuilder<Policy.Builder, Policy> {

    @Nullable
    private final String defaultState;

    @Nullable
    private final String description;

    @Nullable
    private final ErrorNotification errorNotification;

    @Nullable
    private final List<IsmTemplate> ismTemplate;

    @Nullable
    private final Long lastUpdatedTime;

    @Nullable
    private final String policyId;

    @Nullable
    private final Number schemaVersion;

    @Nonnull
    private final List<States> states;

    // ---------------------------------------------------------------------------------------------

    private Policy(Builder builder) {
        this.defaultState = builder.defaultState;
        this.description = builder.description;
        this.errorNotification = builder.errorNotification;
        this.ismTemplate = ApiTypeHelper.unmodifiable(builder.ismTemplate);
        this.lastUpdatedTime = builder.lastUpdatedTime;
        this.policyId = builder.policyId;
        this.schemaVersion = builder.schemaVersion;
        this.states = ApiTypeHelper.unmodifiable(builder.states);
    }

    public static Policy of(Function<Policy.Builder, ObjectBuilder<Policy>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The default state an index is in.
     * <p>
     * API name: {@code default_state}
     * </p>
     */
    @Nullable
    public final String defaultState() {
        return this.defaultState;
    }

    /**
     * The description of the policy.
     * <p>
     * API name: {@code description}
     * </p>
     */
    @Nullable
    public final String description() {
        return this.description;
    }

    /**
     * The configuration for error notifications.
     * <p>
     * API name: {@code error_notification}
     * </p>
     */
    @Nullable
    public final ErrorNotification errorNotification() {
        return this.errorNotification;
    }

    /**
     * The ISM template configuration.
     * <p>
     * API name: {@code ism_template}
     * </p>
     */
    @Nullable
    public final List<IsmTemplate> ismTemplate() {
        return this.ismTemplate;
    }

    /**
     * When the policy was last updated.
     * <p>
     * API name: {@code last_updated_time}
     * </p>
     */
    @Nullable
    public final Long lastUpdatedTime() {
        return this.lastUpdatedTime;
    }

    /**
     * The unique identifier for the policy.
     * <p>
     * API name: {@code policy_id}
     * </p>
     */
    @Nullable
    public final String policyId() {
        return this.policyId;
    }

    /**
     * The version of the policy schema.
     * <p>
     * API name: {@code schema_version}
     * </p>
     */
    @Nullable
    public final Number schemaVersion() {
        return this.schemaVersion;
    }

    /**
     * The list of states for the index to transition between.
     * <p>
     * API name: {@code states}
     * </p>
     */
    @Nonnull
    public final List<States> states() {
        return this.states;
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
        if (this.defaultState != null) {
            generator.writeKey("default_state");
            generator.write(this.defaultState);
        }

        if (this.description != null) {
            generator.writeKey("description");
            generator.write(this.description);
        }

        if (this.errorNotification != null) {
            generator.writeKey("error_notification");
            this.errorNotification.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.ismTemplate)) {
            generator.writeKey("ism_template");
            generator.writeStartArray();
            for (IsmTemplate item0 : this.ismTemplate) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.lastUpdatedTime != null) {
            generator.writeKey("last_updated_time");
            generator.write(this.lastUpdatedTime);
        }

        if (this.policyId != null) {
            generator.writeKey("policy_id");
            generator.write(this.policyId);
        }

        if (this.schemaVersion != null) {
            generator.writeKey("schema_version");
            generator.write(this.schemaVersion.doubleValue());
        }

        if (ApiTypeHelper.isDefined(this.states)) {
            generator.writeKey("states");
            generator.writeStartArray();
            for (States item0 : this.states) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
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
     * Builder for {@link Policy}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, Policy> {
        @Nullable
        private String defaultState;
        @Nullable
        private String description;
        @Nullable
        private ErrorNotification errorNotification;
        @Nullable
        private List<IsmTemplate> ismTemplate;
        @Nullable
        private Long lastUpdatedTime;
        @Nullable
        private String policyId;
        @Nullable
        private Number schemaVersion;
        @Nullable
        private List<States> states;

        public Builder() {}

        private Builder(Policy o) {
            this.defaultState = o.defaultState;
            this.description = o.description;
            this.errorNotification = o.errorNotification;
            this.ismTemplate = _listCopy(o.ismTemplate);
            this.lastUpdatedTime = o.lastUpdatedTime;
            this.policyId = o.policyId;
            this.schemaVersion = o.schemaVersion;
            this.states = _listCopy(o.states);
        }

        private Builder(Builder o) {
            this.defaultState = o.defaultState;
            this.description = o.description;
            this.errorNotification = o.errorNotification;
            this.ismTemplate = _listCopy(o.ismTemplate);
            this.lastUpdatedTime = o.lastUpdatedTime;
            this.policyId = o.policyId;
            this.schemaVersion = o.schemaVersion;
            this.states = _listCopy(o.states);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The default state an index is in.
         * <p>
         * API name: {@code default_state}
         * </p>
         */
        @Nonnull
        public final Builder defaultState(@Nullable String value) {
            this.defaultState = value;
            return this;
        }

        /**
         * The description of the policy.
         * <p>
         * API name: {@code description}
         * </p>
         */
        @Nonnull
        public final Builder description(@Nullable String value) {
            this.description = value;
            return this;
        }

        /**
         * The configuration for error notifications.
         * <p>
         * API name: {@code error_notification}
         * </p>
         */
        @Nonnull
        public final Builder errorNotification(@Nullable ErrorNotification value) {
            this.errorNotification = value;
            return this;
        }

        /**
         * The configuration for error notifications.
         * <p>
         * API name: {@code error_notification}
         * </p>
         */
        @Nonnull
        public final Builder errorNotification(Function<ErrorNotification.Builder, ObjectBuilder<ErrorNotification>> fn) {
            return errorNotification(fn.apply(new ErrorNotification.Builder()).build());
        }

        /**
         * The ISM template configuration.
         * <p>
         * API name: {@code ism_template}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>ismTemplate</code>.
         * </p>
         */
        @Nonnull
        public final Builder ismTemplate(List<IsmTemplate> list) {
            if (Objects.nonNull(list)) {
                this.ismTemplate = _listAddAll(this.ismTemplate, list);
            }
            return this;
        }

        /**
         * The ISM template configuration.
         * <p>
         * API name: {@code ism_template}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>ismTemplate</code>.
         * </p>
         */
        @Nonnull
        public final Builder ismTemplate(IsmTemplate value, IsmTemplate... values) {
            this.ismTemplate = _listAdd(this.ismTemplate, value, values);
            return this;
        }

        /**
         * The ISM template configuration.
         * <p>
         * API name: {@code ism_template}
         * </p>
         *
         * <p>
         * Adds a value to <code>ismTemplate</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder ismTemplate(Function<IsmTemplate.Builder, ObjectBuilder<IsmTemplate>> fn) {
            return ismTemplate(fn.apply(new IsmTemplate.Builder()).build());
        }

        /**
         * When the policy was last updated.
         * <p>
         * API name: {@code last_updated_time}
         * </p>
         */
        @Nonnull
        public final Builder lastUpdatedTime(@Nullable Long value) {
            this.lastUpdatedTime = value;
            return this;
        }

        /**
         * The unique identifier for the policy.
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
         * The version of the policy schema.
         * <p>
         * API name: {@code schema_version}
         * </p>
         */
        @Nonnull
        public final Builder schemaVersion(@Nullable Number value) {
            this.schemaVersion = value;
            return this;
        }

        /**
         * The list of states for the index to transition between.
         * <p>
         * API name: {@code states}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>states</code>.
         * </p>
         */
        @Nonnull
        public final Builder states(List<States> list) {
            this.states = _listAddAll(this.states, list);
            return this;
        }

        /**
         * The list of states for the index to transition between.
         * <p>
         * API name: {@code states}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>states</code>.
         * </p>
         */
        @Nonnull
        public final Builder states(States value, States... values) {
            this.states = _listAdd(this.states, value, values);
            return this;
        }

        /**
         * The list of states for the index to transition between.
         * <p>
         * API name: {@code states}
         * </p>
         *
         * <p>
         * Adds a value to <code>states</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder states(Function<States.Builder, ObjectBuilder<States>> fn) {
            return states(fn.apply(new States.Builder()).build());
        }

        /**
         * Builds a {@link Policy}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public Policy build() {
            _checkSingleUse();

            return new Policy(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link Policy}
     */
    public static final JsonpDeserializer<Policy> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        Policy::setupPolicyDeserializer
    );

    protected static void setupPolicyDeserializer(ObjectDeserializer<Policy.Builder> op) {
        op.add(Builder::defaultState, JsonpDeserializer.stringDeserializer(), "default_state");
        op.add(Builder::description, JsonpDeserializer.stringDeserializer(), "description");
        op.add(Builder::errorNotification, ErrorNotification._DESERIALIZER, "error_notification");
        op.add(Builder::ismTemplate, JsonpDeserializer.arrayDeserializer(IsmTemplate._DESERIALIZER), "ism_template");
        op.add(Builder::lastUpdatedTime, JsonpDeserializer.longDeserializer(), "last_updated_time");
        op.add(Builder::policyId, JsonpDeserializer.stringDeserializer(), "policy_id");
        op.add(Builder::schemaVersion, JsonpDeserializer.numberDeserializer(), "schema_version");
        op.add(Builder::states, JsonpDeserializer.arrayDeserializer(States._DESERIALIZER), "states");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.defaultState);
        result = 31 * result + Objects.hashCode(this.description);
        result = 31 * result + Objects.hashCode(this.errorNotification);
        result = 31 * result + Objects.hashCode(this.ismTemplate);
        result = 31 * result + Objects.hashCode(this.lastUpdatedTime);
        result = 31 * result + Objects.hashCode(this.policyId);
        result = 31 * result + Objects.hashCode(this.schemaVersion);
        result = 31 * result + Objects.hashCode(this.states);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Policy other = (Policy) o;
        return Objects.equals(this.defaultState, other.defaultState)
            && Objects.equals(this.description, other.description)
            && Objects.equals(this.errorNotification, other.errorNotification)
            && Objects.equals(this.ismTemplate, other.ismTemplate)
            && Objects.equals(this.lastUpdatedTime, other.lastUpdatedTime)
            && Objects.equals(this.policyId, other.policyId)
            && Objects.equals(this.schemaVersion, other.schemaVersion)
            && Objects.equals(this.states, other.states);
    }
}
