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

package org.opensearch.client.opensearch.nodes.reload_secure_settings;

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
import org.opensearch.client.opensearch._types.ErrorCause;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: nodes.reload_secure_settings.NodeReloadResult

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NodeReloadResult implements PlainJsonSerializable, ToCopyableBuilder<NodeReloadResult.Builder, NodeReloadResult> {

    @Nonnull
    private final String name;

    @Nullable
    private final ErrorCause reloadException;

    // ---------------------------------------------------------------------------------------------

    private NodeReloadResult(Builder builder) {
        this.name = ApiTypeHelper.requireNonNull(builder.name, this, "name");
        this.reloadException = builder.reloadException;
    }

    public static NodeReloadResult of(Function<NodeReloadResult.Builder, ObjectBuilder<NodeReloadResult>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code name}
     */
    @Nonnull
    public final String name() {
        return this.name;
    }

    /**
     * API name: {@code reload_exception}
     */
    @Nullable
    public final ErrorCause reloadException() {
        return this.reloadException;
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
        generator.writeKey("name");
        generator.write(this.name);

        if (this.reloadException != null) {
            generator.writeKey("reload_exception");
            this.reloadException.serialize(generator, mapper);
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
     * Builder for {@link NodeReloadResult}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, NodeReloadResult> {
        private String name;
        @Nullable
        private ErrorCause reloadException;

        public Builder() {}

        private Builder(NodeReloadResult o) {
            this.name = o.name;
            this.reloadException = o.reloadException;
        }

        private Builder(Builder o) {
            this.name = o.name;
            this.reloadException = o.reloadException;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code name}
         */
        @Nonnull
        public final Builder name(String value) {
            this.name = value;
            return this;
        }

        /**
         * API name: {@code reload_exception}
         */
        @Nonnull
        public final Builder reloadException(@Nullable ErrorCause value) {
            this.reloadException = value;
            return this;
        }

        /**
         * API name: {@code reload_exception}
         */
        @Nonnull
        public final Builder reloadException(Function<ErrorCause.Builder, ObjectBuilder<ErrorCause>> fn) {
            return reloadException(fn.apply(new ErrorCause.Builder()).build());
        }

        /**
         * Builds a {@link NodeReloadResult}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NodeReloadResult build() {
            _checkSingleUse();

            return new NodeReloadResult(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NodeReloadResult}
     */
    public static final JsonpDeserializer<NodeReloadResult> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NodeReloadResult::setupNodeReloadResultDeserializer
    );

    protected static void setupNodeReloadResultDeserializer(ObjectDeserializer<NodeReloadResult.Builder> op) {
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
        op.add(Builder::reloadException, ErrorCause._DESERIALIZER, "reload_exception");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.name.hashCode();
        result = 31 * result + Objects.hashCode(this.reloadException);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NodeReloadResult other = (NodeReloadResult) o;
        return this.name.equals(other.name) && Objects.equals(this.reloadException, other.reloadException);
    }
}
