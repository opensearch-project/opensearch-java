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

// typedef: security.PatchOperation

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class PatchOperation implements PlainJsonSerializable, ToCopyableBuilder<PatchOperation.Builder, PatchOperation> {

    @Nonnull
    private final String op;

    @Nonnull
    private final String path;

    @Nullable
    private final JsonData value;

    // ---------------------------------------------------------------------------------------------

    private PatchOperation(Builder builder) {
        this.op = ApiTypeHelper.requireNonNull(builder.op, this, "op");
        this.path = ApiTypeHelper.requireNonNull(builder.path, this, "path");
        this.value = builder.value;
    }

    public static PatchOperation of(Function<PatchOperation.Builder, ObjectBuilder<PatchOperation>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The operation to perform, such as <code>remove</code>, <code>add</code>, <code>replace</code>, <code>move</code>,
     * <code>copy</code>, or <code>test</code>.
     * <p>
     * API name: {@code op}
     * </p>
     */
    @Nonnull
    public final String op() {
        return this.op;
    }

    /**
     * Required - The path to the resource.
     * <p>
     * API name: {@code path}
     * </p>
     */
    @Nonnull
    public final String path() {
        return this.path;
    }

    /**
     * The new values used for the update.
     * <p>
     * API name: {@code value}
     * </p>
     */
    @Nullable
    public final JsonData value() {
        return this.value;
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
        generator.writeKey("op");
        generator.write(this.op);

        generator.writeKey("path");
        generator.write(this.path);

        if (this.value != null) {
            generator.writeKey("value");
            this.value.serialize(generator, mapper);
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
     * Builder for {@link PatchOperation}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, PatchOperation> {
        private String op;
        private String path;
        @Nullable
        private JsonData value;

        public Builder() {}

        private Builder(PatchOperation o) {
            this.op = o.op;
            this.path = o.path;
            this.value = o.value;
        }

        private Builder(Builder o) {
            this.op = o.op;
            this.path = o.path;
            this.value = o.value;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - The operation to perform, such as <code>remove</code>, <code>add</code>, <code>replace</code>, <code>move</code>,
         * <code>copy</code>, or <code>test</code>.
         * <p>
         * API name: {@code op}
         * </p>
         */
        @Nonnull
        public final Builder op(String value) {
            this.op = value;
            return this;
        }

        /**
         * Required - The path to the resource.
         * <p>
         * API name: {@code path}
         * </p>
         */
        @Nonnull
        public final Builder path(String value) {
            this.path = value;
            return this;
        }

        /**
         * The new values used for the update.
         * <p>
         * API name: {@code value}
         * </p>
         */
        @Nonnull
        public final Builder value(@Nullable JsonData value) {
            this.value = value;
            return this;
        }

        /**
         * Builds a {@link PatchOperation}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PatchOperation build() {
            _checkSingleUse();

            return new PatchOperation(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PatchOperation}
     */
    public static final JsonpDeserializer<PatchOperation> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PatchOperation::setupPatchOperationDeserializer
    );

    protected static void setupPatchOperationDeserializer(ObjectDeserializer<PatchOperation.Builder> op) {
        op.add(Builder::op, JsonpDeserializer.stringDeserializer(), "op");
        op.add(Builder::path, JsonpDeserializer.stringDeserializer(), "path");
        op.add(Builder::value, JsonData._DESERIALIZER, "value");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.op.hashCode();
        result = 31 * result + this.path.hashCode();
        result = 31 * result + Objects.hashCode(this.value);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PatchOperation other = (PatchOperation) o;
        return this.op.equals(other.op) && this.path.equals(other.path) && Objects.equals(this.value, other.value);
    }
}
