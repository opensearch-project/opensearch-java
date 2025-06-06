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
import java.util.Map;
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

// typedef: ism.ActionAllocation

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ActionAllocation implements PlainJsonSerializable, ToCopyableBuilder<ActionAllocation.Builder, ActionAllocation> {

    @Nonnull
    private final Map<String, JsonData> exclude;

    @Nonnull
    private final Map<String, JsonData> include;

    @Nonnull
    private final Map<String, JsonData> require;

    @Nullable
    private final Boolean waitFor;

    // ---------------------------------------------------------------------------------------------

    private ActionAllocation(Builder builder) {
        this.exclude = ApiTypeHelper.unmodifiable(builder.exclude);
        this.include = ApiTypeHelper.unmodifiable(builder.include);
        this.require = ApiTypeHelper.unmodifiable(builder.require);
        this.waitFor = builder.waitFor;
    }

    public static ActionAllocation of(Function<ActionAllocation.Builder, ObjectBuilder<ActionAllocation>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The excluded allocation attributes.
     * <p>
     * API name: {@code exclude}
     * </p>
     */
    @Nonnull
    public final Map<String, JsonData> exclude() {
        return this.exclude;
    }

    /**
     * The included allocation attributes.
     * <p>
     * API name: {@code include}
     * </p>
     */
    @Nonnull
    public final Map<String, JsonData> include() {
        return this.include;
    }

    /**
     * The required allocation attributes.
     * <p>
     * API name: {@code require}
     * </p>
     */
    @Nonnull
    public final Map<String, JsonData> require() {
        return this.require;
    }

    /**
     * Whether to wait for the allocation to complete.
     * <p>
     * API name: {@code wait_for}
     * </p>
     */
    @Nullable
    public final Boolean waitFor() {
        return this.waitFor;
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
        if (ApiTypeHelper.isDefined(this.exclude)) {
            generator.writeKey("exclude");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.exclude.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.include)) {
            generator.writeKey("include");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.include.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.require)) {
            generator.writeKey("require");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.require.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.waitFor != null) {
            generator.writeKey("wait_for");
            generator.write(this.waitFor);
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
     * Builder for {@link ActionAllocation}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ActionAllocation> {
        @Nullable
        private Map<String, JsonData> exclude;
        @Nullable
        private Map<String, JsonData> include;
        @Nullable
        private Map<String, JsonData> require;
        @Nullable
        private Boolean waitFor;

        public Builder() {}

        private Builder(ActionAllocation o) {
            this.exclude = _mapCopy(o.exclude);
            this.include = _mapCopy(o.include);
            this.require = _mapCopy(o.require);
            this.waitFor = o.waitFor;
        }

        private Builder(Builder o) {
            this.exclude = _mapCopy(o.exclude);
            this.include = _mapCopy(o.include);
            this.require = _mapCopy(o.require);
            this.waitFor = o.waitFor;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The excluded allocation attributes.
         * <p>
         * API name: {@code exclude}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>exclude</code>.
         * </p>
         */
        @Nonnull
        public final Builder exclude(Map<String, JsonData> map) {
            this.exclude = _mapPutAll(this.exclude, map);
            return this;
        }

        /**
         * The excluded allocation attributes.
         * <p>
         * API name: {@code exclude}
         * </p>
         *
         * <p>
         * Adds an entry to <code>exclude</code>.
         * </p>
         */
        @Nonnull
        public final Builder exclude(String key, JsonData value) {
            this.exclude = _mapPut(this.exclude, key, value);
            return this;
        }

        /**
         * The included allocation attributes.
         * <p>
         * API name: {@code include}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>include</code>.
         * </p>
         */
        @Nonnull
        public final Builder include(Map<String, JsonData> map) {
            this.include = _mapPutAll(this.include, map);
            return this;
        }

        /**
         * The included allocation attributes.
         * <p>
         * API name: {@code include}
         * </p>
         *
         * <p>
         * Adds an entry to <code>include</code>.
         * </p>
         */
        @Nonnull
        public final Builder include(String key, JsonData value) {
            this.include = _mapPut(this.include, key, value);
            return this;
        }

        /**
         * The required allocation attributes.
         * <p>
         * API name: {@code require}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>require</code>.
         * </p>
         */
        @Nonnull
        public final Builder require(Map<String, JsonData> map) {
            this.require = _mapPutAll(this.require, map);
            return this;
        }

        /**
         * The required allocation attributes.
         * <p>
         * API name: {@code require}
         * </p>
         *
         * <p>
         * Adds an entry to <code>require</code>.
         * </p>
         */
        @Nonnull
        public final Builder require(String key, JsonData value) {
            this.require = _mapPut(this.require, key, value);
            return this;
        }

        /**
         * Whether to wait for the allocation to complete.
         * <p>
         * API name: {@code wait_for}
         * </p>
         */
        @Nonnull
        public final Builder waitFor(@Nullable Boolean value) {
            this.waitFor = value;
            return this;
        }

        /**
         * Builds a {@link ActionAllocation}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ActionAllocation build() {
            _checkSingleUse();

            return new ActionAllocation(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ActionAllocation}
     */
    public static final JsonpDeserializer<ActionAllocation> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ActionAllocation::setupActionAllocationDeserializer
    );

    protected static void setupActionAllocationDeserializer(ObjectDeserializer<ActionAllocation.Builder> op) {
        op.add(Builder::exclude, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "exclude");
        op.add(Builder::include, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "include");
        op.add(Builder::require, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "require");
        op.add(Builder::waitFor, JsonpDeserializer.booleanDeserializer(), "wait_for");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.exclude);
        result = 31 * result + Objects.hashCode(this.include);
        result = 31 * result + Objects.hashCode(this.require);
        result = 31 * result + Objects.hashCode(this.waitFor);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ActionAllocation other = (ActionAllocation) o;
        return Objects.equals(this.exclude, other.exclude)
            && Objects.equals(this.include, other.include)
            && Objects.equals(this.require, other.require)
            && Objects.equals(this.waitFor, other.waitFor);
    }
}
