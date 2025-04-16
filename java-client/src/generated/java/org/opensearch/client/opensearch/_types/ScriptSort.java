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

// typedef: _types.ScriptSort

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ScriptSort implements SortOptionsVariant, PlainJsonSerializable, ToCopyableBuilder<ScriptSort.Builder, ScriptSort> {

    @Nullable
    private final SortMode mode;

    @Nullable
    private final NestedSortValue nested;

    @Nullable
    private final SortOrder order;

    @Nonnull
    private final Script script;

    @Nullable
    private final ScriptSortType type;

    // ---------------------------------------------------------------------------------------------

    private ScriptSort(Builder builder) {
        this.mode = builder.mode;
        this.nested = builder.nested;
        this.order = builder.order;
        this.script = ApiTypeHelper.requireNonNull(builder.script, this, "script");
        this.type = builder.type;
    }

    public static ScriptSort of(Function<ScriptSort.Builder, ObjectBuilder<ScriptSort>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link SortOptions} variant kind.
     */
    @Override
    public SortOptions.Kind _sortOptionsKind() {
        return SortOptions.Kind.Script;
    }

    /**
     * The mode for sorting on array or multi-valued fields.
     * <p>
     * API name: {@code mode}
     * </p>
     */
    @Nullable
    public final SortMode mode() {
        return this.mode;
    }

    /**
     * The nested path and filter for nested sorting.
     * <p>
     * API name: {@code nested}
     * </p>
     */
    @Nullable
    public final NestedSortValue nested() {
        return this.nested;
    }

    /**
     * API name: {@code order}
     */
    @Nullable
    public final SortOrder order() {
        return this.order;
    }

    /**
     * Required - The script to use for sorting.
     * <p>
     * API name: {@code script}
     * </p>
     */
    @Nonnull
    public final Script script() {
        return this.script;
    }

    /**
     * The type of the script sort value.
     * <p>
     * API name: {@code type}
     * </p>
     */
    @Nullable
    public final ScriptSortType type() {
        return this.type;
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
        if (this.mode != null) {
            generator.writeKey("mode");
            this.mode.serialize(generator, mapper);
        }

        if (this.nested != null) {
            generator.writeKey("nested");
            this.nested.serialize(generator, mapper);
        }

        if (this.order != null) {
            generator.writeKey("order");
            this.order.serialize(generator, mapper);
        }

        generator.writeKey("script");
        this.script.serialize(generator, mapper);

        if (this.type != null) {
            generator.writeKey("type");
            this.type.serialize(generator, mapper);
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
     * Builder for {@link ScriptSort}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ScriptSort> {
        @Nullable
        private SortMode mode;
        @Nullable
        private NestedSortValue nested;
        @Nullable
        private SortOrder order;
        private Script script;
        @Nullable
        private ScriptSortType type;

        public Builder() {}

        private Builder(ScriptSort o) {
            this.mode = o.mode;
            this.nested = o.nested;
            this.order = o.order;
            this.script = o.script;
            this.type = o.type;
        }

        private Builder(Builder o) {
            this.mode = o.mode;
            this.nested = o.nested;
            this.order = o.order;
            this.script = o.script;
            this.type = o.type;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The mode for sorting on array or multi-valued fields.
         * <p>
         * API name: {@code mode}
         * </p>
         */
        @Nonnull
        public final Builder mode(@Nullable SortMode value) {
            this.mode = value;
            return this;
        }

        /**
         * The nested path and filter for nested sorting.
         * <p>
         * API name: {@code nested}
         * </p>
         */
        @Nonnull
        public final Builder nested(@Nullable NestedSortValue value) {
            this.nested = value;
            return this;
        }

        /**
         * The nested path and filter for nested sorting.
         * <p>
         * API name: {@code nested}
         * </p>
         */
        @Nonnull
        public final Builder nested(Function<NestedSortValue.Builder, ObjectBuilder<NestedSortValue>> fn) {
            return nested(fn.apply(new NestedSortValue.Builder()).build());
        }

        /**
         * API name: {@code order}
         */
        @Nonnull
        public final Builder order(@Nullable SortOrder value) {
            this.order = value;
            return this;
        }

        /**
         * Required - The script to use for sorting.
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
         * Required - The script to use for sorting.
         * <p>
         * API name: {@code script}
         * </p>
         */
        @Nonnull
        public final Builder script(Function<Script.Builder, ObjectBuilder<Script>> fn) {
            return script(fn.apply(new Script.Builder()).build());
        }

        /**
         * The type of the script sort value.
         * <p>
         * API name: {@code type}
         * </p>
         */
        @Nonnull
        public final Builder type(@Nullable ScriptSortType value) {
            this.type = value;
            return this;
        }

        /**
         * Builds a {@link ScriptSort}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ScriptSort build() {
            _checkSingleUse();

            return new ScriptSort(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ScriptSort}
     */
    public static final JsonpDeserializer<ScriptSort> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ScriptSort::setupScriptSortDeserializer
    );

    protected static void setupScriptSortDeserializer(ObjectDeserializer<ScriptSort.Builder> op) {
        op.add(Builder::mode, SortMode._DESERIALIZER, "mode");
        op.add(Builder::nested, NestedSortValue._DESERIALIZER, "nested");
        op.add(Builder::order, SortOrder._DESERIALIZER, "order");
        op.add(Builder::script, Script._DESERIALIZER, "script");
        op.add(Builder::type, ScriptSortType._DESERIALIZER, "type");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.mode);
        result = 31 * result + Objects.hashCode(this.nested);
        result = 31 * result + Objects.hashCode(this.order);
        result = 31 * result + this.script.hashCode();
        result = 31 * result + Objects.hashCode(this.type);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ScriptSort other = (ScriptSort) o;
        return Objects.equals(this.mode, other.mode)
            && Objects.equals(this.nested, other.nested)
            && Objects.equals(this.order, other.order)
            && this.script.equals(other.script)
            && Objects.equals(this.type, other.type);
    }
}
