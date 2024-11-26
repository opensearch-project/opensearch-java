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

package org.opensearch.client.opensearch.indices;

import jakarta.json.stream.JsonGenerator;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
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

// typedef: indices.IndexSettingsMergePolicy

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IndexSettingsMergePolicy implements TaggedUnion<IndexSettingsMergePolicy.Kind, Object>, PlainJsonSerializable {
    /**
     * {@link IndexSettingsMergePolicy} variant kinds.
     */
    public enum Kind {
        Name,
        TieredPolicyConfig
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

    private IndexSettingsMergePolicy(Kind kind, Object value) {
        this._kind = kind;
        this._value = value;
    }

    private IndexSettingsMergePolicy(Builder builder) {
        this._kind = ApiTypeHelper.requireNonNull(builder._kind, builder, "<variant kind>");
        this._value = ApiTypeHelper.requireNonNull(builder._value, builder, "<variant value>");
    }

    public static IndexSettingsMergePolicy of(Function<IndexSettingsMergePolicy.Builder, ObjectBuilder<IndexSettingsMergePolicy>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Is this variant instance of kind {@code name}?
     */
    public boolean isName() {
        return _kind == Kind.Name;
    }

    /**
     * Get the {@code name} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code name} kind.
     */
    public IndexSettingsMergePolicyName name() {
        return TaggedUnionUtils.get(this, Kind.Name);
    }

    /**
     * Is this variant instance of kind {@code tiered_policy_config}?
     */
    public boolean isTieredPolicyConfig() {
        return _kind == Kind.TieredPolicyConfig;
    }

    /**
     * Get the {@code tiered_policy_config} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code tiered_policy_config} kind.
     */
    public IndexSettingsMergeTieredPolicy tieredPolicyConfig() {
        return TaggedUnionUtils.get(this, Kind.TieredPolicyConfig);
    }

    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        if (_value instanceof JsonpSerializable) {
            ((JsonpSerializable) _value).serialize(generator, mapper);
        }
    }

    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<IndexSettingsMergePolicy> {
        private Kind _kind;
        private Object _value;

        public ObjectBuilder<IndexSettingsMergePolicy> name(IndexSettingsMergePolicyName v) {
            this._kind = Kind.Name;
            this._value = v;
            return this;
        }

        public ObjectBuilder<IndexSettingsMergePolicy> tieredPolicyConfig(IndexSettingsMergeTieredPolicy v) {
            this._kind = Kind.TieredPolicyConfig;
            this._value = v;
            return this;
        }

        public ObjectBuilder<IndexSettingsMergePolicy> tieredPolicyConfig(
            Function<IndexSettingsMergeTieredPolicy.Builder, ObjectBuilder<IndexSettingsMergeTieredPolicy>> fn
        ) {
            return this.tieredPolicyConfig(fn.apply(new IndexSettingsMergeTieredPolicy.Builder()).build());
        }

        @Override
        public IndexSettingsMergePolicy build() {
            _checkSingleUse();
            return new IndexSettingsMergePolicy(this);
        }
    }

    private static JsonpDeserializer<IndexSettingsMergePolicy> buildIndexSettingsMergePolicyDeserializer() {
        return new UnionDeserializer.Builder<IndexSettingsMergePolicy, Kind, Object>(IndexSettingsMergePolicy::new, false).addMember(
            Kind.Name,
            IndexSettingsMergePolicyName._DESERIALIZER
        ).addMember(Kind.TieredPolicyConfig, IndexSettingsMergeTieredPolicy._DESERIALIZER).build();
    }

    public static final JsonpDeserializer<IndexSettingsMergePolicy> _DESERIALIZER = JsonpDeserializer.lazy(
        IndexSettingsMergePolicy::buildIndexSettingsMergePolicyDeserializer
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
        IndexSettingsMergePolicy other = (IndexSettingsMergePolicy) o;
        return Objects.equals(this._kind, other._kind) && Objects.equals(this._value, other._value);
    }
}
