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

package org.opensearch.client.opensearch.search_pipeline;

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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.TaggedUnion;
import org.opensearch.client.util.TaggedUnionUtils;

// typedef: search_pipeline.SearchPipelineRef

/**
 * A search pipeline specified either as the name of a stored pipeline or as an inline pipeline definition.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SearchPipelineRef implements TaggedUnion<SearchPipelineRef.Kind, Object>, PlainJsonSerializable {
    /**
     * {@link SearchPipelineRef} variant kinds.
     */
    public enum Kind {
        PipelineDefinition,
        PipelineName
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

    private SearchPipelineRef(Kind kind, Object value) {
        this._kind = kind;
        this._value = value;
    }

    private SearchPipelineRef(Builder builder) {
        this._kind = ApiTypeHelper.requireNonNull(builder._kind, builder, "<variant kind>");
        this._value = ApiTypeHelper.requireNonNull(builder._value, builder, "<variant value>");
    }

    public static SearchPipelineRef of(Function<SearchPipelineRef.Builder, ObjectBuilder<SearchPipelineRef>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Is this variant instance of kind {@code pipeline_definition}?
     */
    public boolean isPipelineDefinition() {
        return _kind == Kind.PipelineDefinition;
    }

    /**
     * Get the {@code pipeline_definition} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code pipeline_definition} kind.
     */
    public SearchPipelineStructure pipelineDefinition() {
        return TaggedUnionUtils.get(this, Kind.PipelineDefinition);
    }

    /**
     * Is this variant instance of kind {@code pipeline_name}?
     */
    public boolean isPipelineName() {
        return _kind == Kind.PipelineName;
    }

    /**
     * Get the {@code pipeline_name} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code pipeline_name} kind.
     */
    public String pipelineName() {
        return TaggedUnionUtils.get(this, Kind.PipelineName);
    }

    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        if (_value instanceof JsonpSerializable) {
            ((JsonpSerializable) _value).serialize(generator, mapper);
        } else {
            switch (_kind) {
                case PipelineName:
                    generator.write(((String) this._value));
                    break;
            }
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

    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<SearchPipelineRef> {
        private Kind _kind;
        private Object _value;

        public Builder() {}

        private Builder(SearchPipelineRef o) {
            this._kind = o._kind;
            this._value = o._value;
        }

        public ObjectBuilder<SearchPipelineRef> pipelineDefinition(SearchPipelineStructure v) {
            this._kind = Kind.PipelineDefinition;
            this._value = v;
            return this;
        }

        public ObjectBuilder<SearchPipelineRef> pipelineDefinition(
            Function<SearchPipelineStructure.Builder, ObjectBuilder<SearchPipelineStructure>> fn
        ) {
            return this.pipelineDefinition(fn.apply(new SearchPipelineStructure.Builder()).build());
        }

        public ObjectBuilder<SearchPipelineRef> pipelineName(String v) {
            this._kind = Kind.PipelineName;
            this._value = v;
            return this;
        }

        @Override
        public SearchPipelineRef build() {
            _checkSingleUse();
            return new SearchPipelineRef(this);
        }
    }

    private static JsonpDeserializer<SearchPipelineRef> buildSearchPipelineRefDeserializer() {
        return new UnionDeserializer.Builder<SearchPipelineRef, Kind, Object>(SearchPipelineRef::new, false).addMember(
            Kind.PipelineDefinition,
            SearchPipelineStructure._DESERIALIZER
        ).addMember(Kind.PipelineName, JsonpDeserializer.stringDeserializer()).build();
    }

    public static final JsonpDeserializer<SearchPipelineRef> _DESERIALIZER = JsonpDeserializer.lazy(
        SearchPipelineRef::buildSearchPipelineRefDeserializer
    );

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
        SearchPipelineRef other = (SearchPipelineRef) o;
        return Objects.equals(this._kind, other._kind) && Objects.equals(this._value, other._value);
    }
}
