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

package org.opensearch.client.opensearch._types;

import jakarta.json.stream.JsonGenerator;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.StoredScriptId

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class StoredScriptId extends ScriptBase implements ToCopyableBuilder<StoredScriptId.Builder, StoredScriptId> {

    @Nonnull
    private final String id;

    // ---------------------------------------------------------------------------------------------

    private StoredScriptId(Builder builder) {
        super(builder);
        this.id = ApiTypeHelper.requireNonNull(builder.id, this, "id");
    }

    public static StoredScriptId of(Function<StoredScriptId.Builder, ObjectBuilder<StoredScriptId>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code id}
     */
    @Nonnull
    public final String id() {
        return this.id;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        generator.writeKey("id");
        generator.write(this.id);
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
     * Builder for {@link StoredScriptId}.
     */
    public static class Builder extends ScriptBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, StoredScriptId> {
        private String id;

        public Builder() {}

        private Builder(StoredScriptId o) {
            super(o);
            this.id = o.id;
        }

        private Builder(Builder o) {
            super(o);
            this.id = o.id;
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
         * Required - API name: {@code id}
         */
        @Nonnull
        public final Builder id(String value) {
            this.id = value;
            return this;
        }

        /**
         * Builds a {@link StoredScriptId}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public StoredScriptId build() {
            _checkSingleUse();

            return new StoredScriptId(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link StoredScriptId}
     */
    public static final JsonpDeserializer<StoredScriptId> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        StoredScriptId::setupStoredScriptIdDeserializer
    );

    protected static void setupStoredScriptIdDeserializer(ObjectDeserializer<StoredScriptId.Builder> op) {
        setupScriptBaseDeserializer(op);
        op.add(Builder::id, JsonpDeserializer.stringDeserializer(), "id");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + this.id.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        StoredScriptId other = (StoredScriptId) o;
        return this.id.equals(other.id);
    }
}
