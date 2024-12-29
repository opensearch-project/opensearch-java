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
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.opensearch._types.ErrorCause;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: nodes.reload_secure_settings.NodeReloadError

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NodeReloadError extends NodeReloadResultBase implements ToCopyableBuilder<NodeReloadError.Builder, NodeReloadError> {

    @Nonnull
    private final ErrorCause reloadException;

    // ---------------------------------------------------------------------------------------------

    private NodeReloadError(Builder builder) {
        super(builder);
        this.reloadException = ApiTypeHelper.requireNonNull(builder.reloadException, this, "reloadException");
    }

    public static NodeReloadError of(Function<NodeReloadError.Builder, ObjectBuilder<NodeReloadError>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code reload_exception}
     */
    @Nonnull
    public final ErrorCause reloadException() {
        return this.reloadException;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        generator.writeKey("reload_exception");
        this.reloadException.serialize(generator, mapper);
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
     * Builder for {@link NodeReloadError}.
     */
    public static class Builder extends NodeReloadResultBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, NodeReloadError> {
        private ErrorCause reloadException;

        public Builder() {}

        private Builder(NodeReloadError o) {
            super(o);
            this.reloadException = o.reloadException;
        }

        private Builder(Builder o) {
            super(o);
            this.reloadException = o.reloadException;
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
         * Required - API name: {@code reload_exception}
         */
        @Nonnull
        public final Builder reloadException(ErrorCause value) {
            this.reloadException = value;
            return this;
        }

        /**
         * Required - API name: {@code reload_exception}
         */
        @Nonnull
        public final Builder reloadException(Function<ErrorCause.Builder, ObjectBuilder<ErrorCause>> fn) {
            return reloadException(fn.apply(new ErrorCause.Builder()).build());
        }

        /**
         * Builds a {@link NodeReloadError}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NodeReloadError build() {
            _checkSingleUse();

            return new NodeReloadError(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NodeReloadError}
     */
    public static final JsonpDeserializer<NodeReloadError> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NodeReloadError::setupNodeReloadErrorDeserializer
    );

    protected static void setupNodeReloadErrorDeserializer(ObjectDeserializer<NodeReloadError.Builder> op) {
        setupNodeReloadResultBaseDeserializer(op);
        op.add(Builder::reloadException, ErrorCause._DESERIALIZER, "reload_exception");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + this.reloadException.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NodeReloadError other = (NodeReloadError) o;
        return this.reloadException.equals(other.reloadException);
    }
}
