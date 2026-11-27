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

package org.opensearch.client.opensearch.ism;

import jakarta.json.stream.JsonGenerator;
import java.util.List;
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
import org.opensearch.client.opensearch._types.Script;
import org.opensearch.client.opensearch.indices.Alias;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ism.ActionShrink

/**
 * The shrink action configuration. Requires exactly one of <code>num_new_shards</code>, <code>max_shard_size</code> or
 * <code>percentage_of_source_shards</code>.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ActionShrink implements PlainJsonSerializable, ToCopyableBuilder<ActionShrink.Builder, ActionShrink> {

    @Nonnull
    private final List<Alias> aliases;

    @Nullable
    private final Boolean forceUnsafe;

    @Nullable
    private final String maxShardSize;

    @Nullable
    private final Integer numNewShards;

    @Nullable
    private final Double percentageOfSourceShards;

    @Nullable
    private final Boolean switchAliases;

    @Nullable
    private final Script targetIndexNameTemplate;

    // ---------------------------------------------------------------------------------------------

    private ActionShrink(Builder builder) {
        this.aliases = ApiTypeHelper.unmodifiable(builder.aliases);
        this.forceUnsafe = builder.forceUnsafe;
        this.maxShardSize = builder.maxShardSize;
        this.numNewShards = builder.numNewShards;
        this.percentageOfSourceShards = builder.percentageOfSourceShards;
        this.switchAliases = builder.switchAliases;
        this.targetIndexNameTemplate = builder.targetIndexNameTemplate;
    }

    public static ActionShrink of(Function<ActionShrink.Builder, ObjectBuilder<ActionShrink>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The aliases to add to the shrunken index.
     * <p>
     * API name: {@code aliases}
     * </p>
     */
    @Nonnull
    public final List<Alias> aliases() {
        return this.aliases;
    }

    /**
     * Whether to shrink the index even if it has no replicas.
     * <p>
     * API name: {@code force_unsafe}
     * </p>
     */
    @Nullable
    public final Boolean forceUnsafe() {
        return this.forceUnsafe;
    }

    /**
     * API name: {@code max_shard_size}
     */
    @Nullable
    public final String maxShardSize() {
        return this.maxShardSize;
    }

    /**
     * The number of primary shards of the shrunken index.
     * <p>
     * API name: {@code num_new_shards}
     * </p>
     */
    @Nullable
    public final Integer numNewShards() {
        return this.numNewShards;
    }

    /**
     * The number of primary shards of the shrunken index as a fraction of the source shards.
     * <p>
     * API name: {@code percentage_of_source_shards}
     * </p>
     */
    @Nullable
    public final Double percentageOfSourceShards() {
        return this.percentageOfSourceShards;
    }

    /**
     * Whether to move the aliases of the source index to the shrunken index.
     * <p>
     * API name: {@code switch_aliases}
     * </p>
     */
    @Nullable
    public final Boolean switchAliases() {
        return this.switchAliases;
    }

    /**
     * API name: {@code target_index_name_template}
     */
    @Nullable
    public final Script targetIndexNameTemplate() {
        return this.targetIndexNameTemplate;
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
        if (ApiTypeHelper.isDefined(this.aliases)) {
            generator.writeKey("aliases");
            generator.writeStartArray();
            for (Alias item0 : this.aliases) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.forceUnsafe != null) {
            generator.writeKey("force_unsafe");
            generator.write(this.forceUnsafe);
        }

        if (this.maxShardSize != null) {
            generator.writeKey("max_shard_size");
            generator.write(this.maxShardSize);
        }

        if (this.numNewShards != null) {
            generator.writeKey("num_new_shards");
            generator.write(this.numNewShards);
        }

        if (this.percentageOfSourceShards != null) {
            generator.writeKey("percentage_of_source_shards");
            generator.write(this.percentageOfSourceShards);
        }

        if (this.switchAliases != null) {
            generator.writeKey("switch_aliases");
            generator.write(this.switchAliases);
        }

        if (this.targetIndexNameTemplate != null) {
            generator.writeKey("target_index_name_template");
            this.targetIndexNameTemplate.serialize(generator, mapper);
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
     * Builder for {@link ActionShrink}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ActionShrink> {
        @Nullable
        private List<Alias> aliases;
        @Nullable
        private Boolean forceUnsafe;
        @Nullable
        private String maxShardSize;
        @Nullable
        private Integer numNewShards;
        @Nullable
        private Double percentageOfSourceShards;
        @Nullable
        private Boolean switchAliases;
        @Nullable
        private Script targetIndexNameTemplate;

        public Builder() {}

        private Builder(ActionShrink o) {
            this.aliases = _listCopy(o.aliases);
            this.forceUnsafe = o.forceUnsafe;
            this.maxShardSize = o.maxShardSize;
            this.numNewShards = o.numNewShards;
            this.percentageOfSourceShards = o.percentageOfSourceShards;
            this.switchAliases = o.switchAliases;
            this.targetIndexNameTemplate = o.targetIndexNameTemplate;
        }

        private Builder(Builder o) {
            this.aliases = _listCopy(o.aliases);
            this.forceUnsafe = o.forceUnsafe;
            this.maxShardSize = o.maxShardSize;
            this.numNewShards = o.numNewShards;
            this.percentageOfSourceShards = o.percentageOfSourceShards;
            this.switchAliases = o.switchAliases;
            this.targetIndexNameTemplate = o.targetIndexNameTemplate;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The aliases to add to the shrunken index.
         * <p>
         * API name: {@code aliases}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>aliases</code>.
         * </p>
         */
        @Nonnull
        public final Builder aliases(List<Alias> list) {
            this.aliases = _listAddAll(this.aliases, list);
            return this;
        }

        /**
         * The aliases to add to the shrunken index.
         * <p>
         * API name: {@code aliases}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>aliases</code>.
         * </p>
         */
        @Nonnull
        public final Builder aliases(Alias value, Alias... values) {
            this.aliases = _listAdd(this.aliases, value, values);
            return this;
        }

        /**
         * The aliases to add to the shrunken index.
         * <p>
         * API name: {@code aliases}
         * </p>
         *
         * <p>
         * Adds a value to <code>aliases</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder aliases(Function<Alias.Builder, ObjectBuilder<Alias>> fn) {
            return aliases(fn.apply(new Alias.Builder()).build());
        }

        /**
         * Whether to shrink the index even if it has no replicas.
         * <p>
         * API name: {@code force_unsafe}
         * </p>
         */
        @Nonnull
        public final Builder forceUnsafe(@Nullable Boolean value) {
            this.forceUnsafe = value;
            return this;
        }

        /**
         * API name: {@code max_shard_size}
         */
        @Nonnull
        public final Builder maxShardSize(@Nullable String value) {
            this.maxShardSize = value;
            return this;
        }

        /**
         * The number of primary shards of the shrunken index.
         * <p>
         * API name: {@code num_new_shards}
         * </p>
         */
        @Nonnull
        public final Builder numNewShards(@Nullable Integer value) {
            this.numNewShards = value;
            return this;
        }

        /**
         * The number of primary shards of the shrunken index as a fraction of the source shards.
         * <p>
         * API name: {@code percentage_of_source_shards}
         * </p>
         */
        @Nonnull
        public final Builder percentageOfSourceShards(@Nullable Double value) {
            this.percentageOfSourceShards = value;
            return this;
        }

        /**
         * Whether to move the aliases of the source index to the shrunken index.
         * <p>
         * API name: {@code switch_aliases}
         * </p>
         */
        @Nonnull
        public final Builder switchAliases(@Nullable Boolean value) {
            this.switchAliases = value;
            return this;
        }

        /**
         * API name: {@code target_index_name_template}
         */
        @Nonnull
        public final Builder targetIndexNameTemplate(@Nullable Script value) {
            this.targetIndexNameTemplate = value;
            return this;
        }

        /**
         * API name: {@code target_index_name_template}
         */
        @Nonnull
        public final Builder targetIndexNameTemplate(Function<Script.Builder, ObjectBuilder<Script>> fn) {
            return targetIndexNameTemplate(fn.apply(new Script.Builder()).build());
        }

        /**
         * Builds a {@link ActionShrink}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ActionShrink build() {
            _checkSingleUse();

            return new ActionShrink(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ActionShrink}
     */
    public static final JsonpDeserializer<ActionShrink> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ActionShrink::setupActionShrinkDeserializer
    );

    protected static void setupActionShrinkDeserializer(ObjectDeserializer<ActionShrink.Builder> op) {
        op.add(Builder::aliases, JsonpDeserializer.arrayDeserializer(Alias._DESERIALIZER), "aliases");
        op.add(Builder::forceUnsafe, JsonpDeserializer.booleanDeserializer(), "force_unsafe");
        op.add(Builder::maxShardSize, JsonpDeserializer.stringDeserializer(), "max_shard_size");
        op.add(Builder::numNewShards, JsonpDeserializer.integerDeserializer(), "num_new_shards");
        op.add(Builder::percentageOfSourceShards, JsonpDeserializer.doubleDeserializer(), "percentage_of_source_shards");
        op.add(Builder::switchAliases, JsonpDeserializer.booleanDeserializer(), "switch_aliases");
        op.add(Builder::targetIndexNameTemplate, Script._DESERIALIZER, "target_index_name_template");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.aliases);
        result = 31 * result + Objects.hashCode(this.forceUnsafe);
        result = 31 * result + Objects.hashCode(this.maxShardSize);
        result = 31 * result + Objects.hashCode(this.numNewShards);
        result = 31 * result + Objects.hashCode(this.percentageOfSourceShards);
        result = 31 * result + Objects.hashCode(this.switchAliases);
        result = 31 * result + Objects.hashCode(this.targetIndexNameTemplate);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ActionShrink other = (ActionShrink) o;
        return Objects.equals(this.aliases, other.aliases)
            && Objects.equals(this.forceUnsafe, other.forceUnsafe)
            && Objects.equals(this.maxShardSize, other.maxShardSize)
            && Objects.equals(this.numNewShards, other.numNewShards)
            && Objects.equals(this.percentageOfSourceShards, other.percentageOfSourceShards)
            && Objects.equals(this.switchAliases, other.switchAliases)
            && Objects.equals(this.targetIndexNameTemplate, other.targetIndexNameTemplate);
    }
}
