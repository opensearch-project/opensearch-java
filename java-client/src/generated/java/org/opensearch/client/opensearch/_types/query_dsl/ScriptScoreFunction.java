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

package org.opensearch.client.opensearch._types.query_dsl;

import jakarta.json.stream.JsonGenerator;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.opensearch._types.Script;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.query_dsl.ScriptScoreFunction

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ScriptScoreFunction
    implements
        FunctionScoreVariant,
        PlainJsonSerializable,
        ToCopyableBuilder<ScriptScoreFunction.Builder, ScriptScoreFunction> {

    @Nonnull
    private final Script script;

    // ---------------------------------------------------------------------------------------------

    private ScriptScoreFunction(Builder builder) {
        this.script = ApiTypeHelper.requireNonNull(builder.script, this, "script");
    }

    public static ScriptScoreFunction of(Function<ScriptScoreFunction.Builder, ObjectBuilder<ScriptScoreFunction>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link FunctionScore} variant kind.
     */
    @Override
    public FunctionScore.Kind _functionScoreKind() {
        return FunctionScore.Kind.ScriptScore;
    }

    /**
     * Required - API name: {@code script}
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
     * Builder for {@link ScriptScoreFunction}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ScriptScoreFunction> {
        private Script script;

        public Builder() {}

        private Builder(ScriptScoreFunction o) {
            this.script = o.script;
        }

        private Builder(Builder o) {
            this.script = o.script;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code script}
         */
        @Nonnull
        public final Builder script(Script value) {
            this.script = value;
            return this;
        }

        /**
         * Required - API name: {@code script}
         */
        @Nonnull
        public final Builder script(Function<Script.Builder, ObjectBuilder<Script>> fn) {
            return script(fn.apply(new Script.Builder()).build());
        }

        /**
         * Builds a {@link ScriptScoreFunction}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ScriptScoreFunction build() {
            _checkSingleUse();

            return new ScriptScoreFunction(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ScriptScoreFunction}
     */
    public static final JsonpDeserializer<ScriptScoreFunction> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ScriptScoreFunction::setupScriptScoreFunctionDeserializer
    );

    protected static void setupScriptScoreFunctionDeserializer(ObjectDeserializer<ScriptScoreFunction.Builder> op) {
        op.add(Builder::script, Script._DESERIALIZER, "script");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.script.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ScriptScoreFunction other = (ScriptScoreFunction) o;
        return this.script.equals(other.script);
    }
}
