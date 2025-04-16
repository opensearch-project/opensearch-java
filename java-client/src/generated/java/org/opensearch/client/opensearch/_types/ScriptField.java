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

// typedef: _types.ScriptField

/**
 * The configuration for a script field.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ScriptField implements PlainJsonSerializable, ToCopyableBuilder<ScriptField.Builder, ScriptField> {

    @Nullable
    private final Boolean ignoreFailure;

    @Nonnull
    private final Script script;

    // ---------------------------------------------------------------------------------------------

    private ScriptField(Builder builder) {
        this.ignoreFailure = builder.ignoreFailure;
        this.script = ApiTypeHelper.requireNonNull(builder.script, this, "script");
    }

    public static ScriptField of(Function<ScriptField.Builder, ObjectBuilder<ScriptField>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Whether to ignore failures during script execution.
     * <p>
     * API name: {@code ignore_failure}
     * </p>
     */
    @Nullable
    public final Boolean ignoreFailure() {
        return this.ignoreFailure;
    }

    /**
     * Required - The script to execute for this field.
     * <p>
     * API name: {@code script}
     * </p>
     */
    @Nonnull
    public final Script script() {
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
        if (this.ignoreFailure != null) {
            generator.writeKey("ignore_failure");
            generator.write(this.ignoreFailure);
        }

        generator.writeKey("script");
        this.script.serialize(generator, mapper);
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
     * Builder for {@link ScriptField}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ScriptField> {
        @Nullable
        private Boolean ignoreFailure;
        private Script script;

        public Builder() {}

        private Builder(ScriptField o) {
            this.ignoreFailure = o.ignoreFailure;
            this.script = o.script;
        }

        private Builder(Builder o) {
            this.ignoreFailure = o.ignoreFailure;
            this.script = o.script;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Whether to ignore failures during script execution.
         * <p>
         * API name: {@code ignore_failure}
         * </p>
         */
        @Nonnull
        public final Builder ignoreFailure(@Nullable Boolean value) {
            this.ignoreFailure = value;
            return this;
        }

        /**
         * Required - The script to execute for this field.
         * <p>
         * API name: {@code script}
         * </p>
         */
        @Nonnull
        public final Builder script(Script value) {
            this.script = value;
            return this;
        }

        /**
         * Required - The script to execute for this field.
         * <p>
         * API name: {@code script}
         * </p>
         */
        @Nonnull
        public final Builder script(Function<Script.Builder, ObjectBuilder<Script>> fn) {
            return script(fn.apply(new Script.Builder()).build());
        }

        /**
         * Builds a {@link ScriptField}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ScriptField build() {
            _checkSingleUse();

            return new ScriptField(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ScriptField}
     */
    public static final JsonpDeserializer<ScriptField> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ScriptField::setupScriptFieldDeserializer
    );

    protected static void setupScriptFieldDeserializer(ObjectDeserializer<ScriptField.Builder> op) {
        op.add(Builder::ignoreFailure, JsonpDeserializer.booleanDeserializer(), "ignore_failure");
        op.add(Builder::script, Script._DESERIALIZER, "script");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.ignoreFailure);
        result = 31 * result + this.script.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ScriptField other = (ScriptField) o;
        return Objects.equals(this.ignoreFailure, other.ignoreFailure) && this.script.equals(other.script);
    }
}
