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

package org.opensearch.client.opensearch.core;

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
import org.opensearch.client.opensearch._types.StoredScript;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _global.get_script.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GetScriptResponse implements PlainJsonSerializable, ToCopyableBuilder<GetScriptResponse.Builder, GetScriptResponse> {

    private final boolean found;

    @Nonnull
    private final String id;

    @Nullable
    private final StoredScript script;

    // ---------------------------------------------------------------------------------------------

    private GetScriptResponse(Builder builder) {
        this.found = ApiTypeHelper.requireNonNull(builder.found, this, "found");
        this.id = ApiTypeHelper.requireNonNull(builder.id, this, "id");
        this.script = builder.script;
    }

    public static GetScriptResponse of(Function<GetScriptResponse.Builder, ObjectBuilder<GetScriptResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code found}
     */
    public final boolean found() {
        return this.found;
    }

    /**
     * Required - API name: {@code _id}
     */
    @Nonnull
    public final String id() {
        return this.id;
    }

    /**
     * API name: {@code script}
     */
    @Nullable
    public final StoredScript script() {
        return this.script;
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
        generator.writeKey("found");
        generator.write(this.found);

        generator.writeKey("_id");
        generator.write(this.id);

        if (this.script != null) {
            generator.writeKey("script");
            this.script.serialize(generator, mapper);
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
     * Builder for {@link GetScriptResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, GetScriptResponse> {
        private Boolean found;
        private String id;
        @Nullable
        private StoredScript script;

        public Builder() {}

        private Builder(GetScriptResponse o) {
            this.found = o.found;
            this.id = o.id;
            this.script = o.script;
        }

        private Builder(Builder o) {
            this.found = o.found;
            this.id = o.id;
            this.script = o.script;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code found}
         */
        @Nonnull
        public final Builder found(boolean value) {
            this.found = value;
            return this;
        }

        /**
         * Required - API name: {@code _id}
         */
        @Nonnull
        public final Builder id(String value) {
            this.id = value;
            return this;
        }

        /**
         * API name: {@code script}
         */
        @Nonnull
        public final Builder script(@Nullable StoredScript value) {
            this.script = value;
            return this;
        }

        /**
         * API name: {@code script}
         */
        @Nonnull
        public final Builder script(Function<StoredScript.Builder, ObjectBuilder<StoredScript>> fn) {
            return script(fn.apply(new StoredScript.Builder()).build());
        }

        /**
         * Builds a {@link GetScriptResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetScriptResponse build() {
            _checkSingleUse();

            return new GetScriptResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GetScriptResponse}
     */
    public static final JsonpDeserializer<GetScriptResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GetScriptResponse::setupGetScriptResponseDeserializer
    );

    protected static void setupGetScriptResponseDeserializer(ObjectDeserializer<GetScriptResponse.Builder> op) {
        op.add(Builder::found, JsonpDeserializer.booleanDeserializer(), "found");
        op.add(Builder::id, JsonpDeserializer.stringDeserializer(), "_id");
        op.add(Builder::script, StoredScript._DESERIALIZER, "script");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Boolean.hashCode(this.found);
        result = 31 * result + this.id.hashCode();
        result = 31 * result + Objects.hashCode(this.script);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetScriptResponse other = (GetScriptResponse) o;
        return this.found == other.found && this.id.equals(other.id) && Objects.equals(this.script, other.script);
    }
}
