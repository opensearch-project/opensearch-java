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

package org.opensearch.client.opensearch.security;

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

// typedef: security.create_action_group.Request

/**
 * Creates or replaces the specified action group.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class CreateActionGroupRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<CreateActionGroupRequest.Builder, CreateActionGroupRequest> {

    @Nonnull
    private final String actionGroup;

    @Nonnull
    private final List<String> allowedActions;

    @Nullable
    private final String description;

    @Nullable
    private final Boolean hidden;

    @Nullable
    private final Boolean reserved;

    @Nullable
    private final Boolean static_;

    @Nullable
    private final String type;

    // ---------------------------------------------------------------------------------------------

    private CreateActionGroupRequest(Builder builder) {
        super(builder);
        this.actionGroup = ApiTypeHelper.requireNonNull(builder.actionGroup, this, "actionGroup");
        this.allowedActions = ApiTypeHelper.unmodifiable(builder.allowedActions);
        this.description = builder.description;
        this.hidden = builder.hidden;
        this.reserved = builder.reserved;
        this.static_ = builder.static_;
        this.type = builder.type;
    }

    public static CreateActionGroupRequest of(Function<CreateActionGroupRequest.Builder, ObjectBuilder<CreateActionGroupRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The name of the action group to create or replace.
     * <p>
     * API name: {@code action_group}
     * </p>
     */
    @Nonnull
    public final String actionGroup() {
        return this.actionGroup;
    }

    /**
     * API name: {@code allowed_actions}
     */
    @Nonnull
    public final List<String> allowedActions() {
        return this.allowedActions;
    }

    /**
     * API name: {@code description}
     */
    @Nullable
    public final String description() {
        return this.description;
    }

    /**
     * API name: {@code hidden}
     */
    @Nullable
    public final Boolean hidden() {
        return this.hidden;
    }

    /**
     * API name: {@code reserved}
     */
    @Nullable
    public final Boolean reserved() {
        return this.reserved;
    }

    /**
     * API name: {@code static}
     */
    @Nullable
    public final Boolean static_() {
        return this.static_;
    }

    /**
     * API name: {@code type}
     */
    @Nullable
    public final String type() {
        return this.type;
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
        if (ApiTypeHelper.isDefined(this.allowedActions)) {
            generator.writeKey("allowed_actions");
            generator.writeStartArray();
            for (String item0 : this.allowedActions) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.description != null) {
            generator.writeKey("description");
            generator.write(this.description);
        }

        if (this.hidden != null) {
            generator.writeKey("hidden");
            generator.write(this.hidden);
        }

        if (this.reserved != null) {
            generator.writeKey("reserved");
            generator.write(this.reserved);
        }

        if (this.static_ != null) {
            generator.writeKey("static");
            generator.write(this.static_);
        }

        if (this.type != null) {
            generator.writeKey("type");
            generator.write(this.type);
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
     * Builder for {@link CreateActionGroupRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, CreateActionGroupRequest> {
        private String actionGroup;
        @Nullable
        private List<String> allowedActions;
        @Nullable
        private String description;
        @Nullable
        private Boolean hidden;
        @Nullable
        private Boolean reserved;
        @Nullable
        private Boolean static_;
        @Nullable
        private String type;

        public Builder() {}

        private Builder(CreateActionGroupRequest o) {
            super(o);
            this.actionGroup = o.actionGroup;
            this.allowedActions = _listCopy(o.allowedActions);
            this.description = o.description;
            this.hidden = o.hidden;
            this.reserved = o.reserved;
            this.static_ = o.static_;
            this.type = o.type;
        }

        private Builder(Builder o) {
            super(o);
            this.actionGroup = o.actionGroup;
            this.allowedActions = _listCopy(o.allowedActions);
            this.description = o.description;
            this.hidden = o.hidden;
            this.reserved = o.reserved;
            this.static_ = o.static_;
            this.type = o.type;
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
         * Required - The name of the action group to create or replace.
         * <p>
         * API name: {@code action_group}
         * </p>
         */
        @Nonnull
        public final Builder actionGroup(String value) {
            this.actionGroup = value;
            return this;
        }

        /**
         * API name: {@code allowed_actions}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>allowedActions</code>.
         * </p>
         */
        @Nonnull
        public final Builder allowedActions(List<String> list) {
            this.allowedActions = _listAddAll(this.allowedActions, list);
            return this;
        }

        /**
         * API name: {@code allowed_actions}
         *
         * <p>
         * Adds one or more values to <code>allowedActions</code>.
         * </p>
         */
        @Nonnull
        public final Builder allowedActions(String value, String... values) {
            this.allowedActions = _listAdd(this.allowedActions, value, values);
            return this;
        }

        /**
         * API name: {@code description}
         */
        @Nonnull
        public final Builder description(@Nullable String value) {
            this.description = value;
            return this;
        }

        /**
         * API name: {@code hidden}
         */
        @Nonnull
        public final Builder hidden(@Nullable Boolean value) {
            this.hidden = value;
            return this;
        }

        /**
         * API name: {@code reserved}
         */
        @Nonnull
        public final Builder reserved(@Nullable Boolean value) {
            this.reserved = value;
            return this;
        }

        /**
         * API name: {@code static}
         */
        @Nonnull
        public final Builder static_(@Nullable Boolean value) {
            this.static_ = value;
            return this;
        }

        /**
         * API name: {@code type}
         */
        @Nonnull
        public final Builder type(@Nullable String value) {
            this.type = value;
            return this;
        }

        /**
         * Builds a {@link CreateActionGroupRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public CreateActionGroupRequest build() {
            _checkSingleUse();

            return new CreateActionGroupRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link CreateActionGroupRequest}
     */
    public static final JsonpDeserializer<CreateActionGroupRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CreateActionGroupRequest::setupCreateActionGroupRequestDeserializer
    );

    protected static void setupCreateActionGroupRequestDeserializer(ObjectDeserializer<CreateActionGroupRequest.Builder> op) {
        op.add(Builder::allowedActions, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "allowed_actions");
        op.add(Builder::description, JsonpDeserializer.stringDeserializer(), "description");
        op.add(Builder::hidden, JsonpDeserializer.booleanDeserializer(), "hidden");
        op.add(Builder::reserved, JsonpDeserializer.booleanDeserializer(), "reserved");
        op.add(Builder::static_, JsonpDeserializer.booleanDeserializer(), "static");
        op.add(Builder::type, JsonpDeserializer.stringDeserializer(), "type");
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code security.create_action_group}".
     */
    public static final Endpoint<CreateActionGroupRequest, CreateActionGroupResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "PUT",
        // Request path
        request -> {
            StringBuilder buf = new StringBuilder();
            buf.append("/_plugins/_security/api/actiongroups/");
            SimpleEndpoint.pathEncode(request.actionGroup, buf);
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
        CreateActionGroupResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.actionGroup.hashCode();
        result = 31 * result + Objects.hashCode(this.allowedActions);
        result = 31 * result + Objects.hashCode(this.description);
        result = 31 * result + Objects.hashCode(this.hidden);
        result = 31 * result + Objects.hashCode(this.reserved);
        result = 31 * result + Objects.hashCode(this.static_);
        result = 31 * result + Objects.hashCode(this.type);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CreateActionGroupRequest other = (CreateActionGroupRequest) o;
        return this.actionGroup.equals(other.actionGroup)
            && Objects.equals(this.allowedActions, other.allowedActions)
            && Objects.equals(this.description, other.description)
            && Objects.equals(this.hidden, other.hidden)
            && Objects.equals(this.reserved, other.reserved)
            && Objects.equals(this.static_, other.static_)
            && Objects.equals(this.type, other.type);
    }
}
