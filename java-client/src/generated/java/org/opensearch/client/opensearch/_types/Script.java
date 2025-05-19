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
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.JsonpSerializable;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.json.UnionDeserializer;
import org.opensearch.client.opensearch._types.query_dsl.IntervalsFilter;
import org.opensearch.client.opensearch._types.query_dsl.IntervalsFilterVariant;
import org.opensearch.client.opensearch.ingest.Processor;
import org.opensearch.client.opensearch.ingest.ProcessorVariant;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.TaggedUnion;
import org.opensearch.client.util.TaggedUnionUtils;

// typedef: _types.Script

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Script implements TaggedUnion<Script.Kind, Object>, IntervalsFilterVariant, ProcessorVariant, PlainJsonSerializable {
    /**
     * {@link Script} variant kinds.
     */
    public enum Kind {
        Inline,
        Stored
    }

    /**
     * {@link IntervalsFilter} variant kind.
     */
    @Override
    public IntervalsFilter.Kind _intervalsFilterKind() {
        return IntervalsFilter.Kind.Script;
    }

    /**
     * {@link Processor} variant kind.
     */
    @Override
    public Processor.Kind _processorKind() {
        return Processor.Kind.Script;
    }

    private final Kind _kind;
    private final Object _value;

    @Override
    public final Kind _kind() {
        return _kind;
    }

    @Override
    public final Object _get() {
        return _value;
    }

    private Script(Kind kind, Object value) {
        this._kind = kind;
        this._value = value;
    }

    private Script(Builder builder) {
        this._kind = ApiTypeHelper.requireNonNull(builder._kind, builder, "<variant kind>");
        this._value = ApiTypeHelper.requireNonNull(builder._value, builder, "<variant value>");
    }

    public static Script of(Function<Script.Builder, ObjectBuilder<Script>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Is this variant instance of kind {@code inline}?
     */
    public boolean isInline() {
        return _kind == Kind.Inline;
    }

    /**
     * Get the {@code inline} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code inline} kind.
     */
    public InlineScript inline() {
        return TaggedUnionUtils.get(this, Kind.Inline);
    }

    /**
     * Is this variant instance of kind {@code stored}?
     */
    public boolean isStored() {
        return _kind == Kind.Stored;
    }

    /**
     * Get the {@code stored} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code stored} kind.
     */
    public StoredScriptId stored() {
        return TaggedUnionUtils.get(this, Kind.Stored);
    }

    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        if (_value instanceof JsonpSerializable) {
            ((JsonpSerializable) _value).serialize(generator, mapper);
        }
    }

    @Nonnull
    public Builder toBuilder() {
        return new Builder(this);
    }

    @Nonnull
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<Script> {
        private Kind _kind;
        private Object _value;

        public Builder() {}

        private Builder(Script o) {
            this._kind = o._kind;
            this._value = o._value;
        }

        public ObjectBuilder<Script> inline(InlineScript v) {
            this._kind = Kind.Inline;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Script> inline(Function<InlineScript.Builder, ObjectBuilder<InlineScript>> fn) {
            return this.inline(fn.apply(new InlineScript.Builder()).build());
        }

        public ObjectBuilder<Script> stored(StoredScriptId v) {
            this._kind = Kind.Stored;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Script> stored(Function<StoredScriptId.Builder, ObjectBuilder<StoredScriptId>> fn) {
            return this.stored(fn.apply(new StoredScriptId.Builder()).build());
        }

        @Override
        public Script build() {
            _checkSingleUse();
            return new Script(this);
        }
    }

    private static JsonpDeserializer<Script> buildScriptDeserializer() {
        return new UnionDeserializer.Builder<Script, Kind, Object>(Script::new, false).addMember(Kind.Inline, InlineScript._DESERIALIZER)
            .addMember(Kind.Stored, StoredScriptId._DESERIALIZER)
            .build();
    }

    public static final JsonpDeserializer<Script> _DESERIALIZER = JsonpDeserializer.lazy(Script::buildScriptDeserializer);

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this._kind);
        result = 31 * result + Objects.hashCode(this._value);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Script other = (Script) o;
        return Objects.equals(this._kind, other._kind) && Objects.equals(this._value, other._value);
    }
}
