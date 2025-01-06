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

package org.opensearch.client.opensearch.nodes.stats;

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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: nodes.stats.ScriptCacheStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ScriptCacheStats implements PlainJsonSerializable, ToCopyableBuilder<ScriptCacheStats.Builder, ScriptCacheStats> {

    @Nonnull
    private final List<ScriptContextStats> contexts;

    @Nonnull
    private final ScriptStats sum;

    // ---------------------------------------------------------------------------------------------

    private ScriptCacheStats(Builder builder) {
        this.contexts = ApiTypeHelper.unmodifiable(builder.contexts);
        this.sum = ApiTypeHelper.requireNonNull(builder.sum, this, "sum");
    }

    public static ScriptCacheStats of(Function<ScriptCacheStats.Builder, ObjectBuilder<ScriptCacheStats>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code contexts}
     */
    @Nonnull
    public final List<ScriptContextStats> contexts() {
        return this.contexts;
    }

    /**
     * Required - API name: {@code sum}
     */
    @Nonnull
    public final ScriptStats sum() {
        return this.sum;
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
        if (ApiTypeHelper.isDefined(this.contexts)) {
            generator.writeKey("contexts");
            generator.writeStartArray();
            for (ScriptContextStats item0 : this.contexts) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        generator.writeKey("sum");
        this.sum.serialize(generator, mapper);
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
     * Builder for {@link ScriptCacheStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ScriptCacheStats> {
        @Nullable
        private List<ScriptContextStats> contexts;
        private ScriptStats sum;

        public Builder() {}

        private Builder(ScriptCacheStats o) {
            this.contexts = _listCopy(o.contexts);
            this.sum = o.sum;
        }

        private Builder(Builder o) {
            this.contexts = _listCopy(o.contexts);
            this.sum = o.sum;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code contexts}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>contexts</code>.
         * </p>
         */
        @Nonnull
        public final Builder contexts(List<ScriptContextStats> list) {
            this.contexts = _listAddAll(this.contexts, list);
            return this;
        }

        /**
         * API name: {@code contexts}
         *
         * <p>
         * Adds one or more values to <code>contexts</code>.
         * </p>
         */
        @Nonnull
        public final Builder contexts(ScriptContextStats value, ScriptContextStats... values) {
            this.contexts = _listAdd(this.contexts, value, values);
            return this;
        }

        /**
         * API name: {@code contexts}
         *
         * <p>
         * Adds a value to <code>contexts</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder contexts(Function<ScriptContextStats.Builder, ObjectBuilder<ScriptContextStats>> fn) {
            return contexts(fn.apply(new ScriptContextStats.Builder()).build());
        }

        /**
         * Required - API name: {@code sum}
         */
        @Nonnull
        public final Builder sum(ScriptStats value) {
            this.sum = value;
            return this;
        }

        /**
         * Required - API name: {@code sum}
         */
        @Nonnull
        public final Builder sum(Function<ScriptStats.Builder, ObjectBuilder<ScriptStats>> fn) {
            return sum(fn.apply(new ScriptStats.Builder()).build());
        }

        /**
         * Builds a {@link ScriptCacheStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ScriptCacheStats build() {
            _checkSingleUse();

            return new ScriptCacheStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ScriptCacheStats}
     */
    public static final JsonpDeserializer<ScriptCacheStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ScriptCacheStats::setupScriptCacheStatsDeserializer
    );

    protected static void setupScriptCacheStatsDeserializer(ObjectDeserializer<ScriptCacheStats.Builder> op) {
        op.add(Builder::contexts, JsonpDeserializer.arrayDeserializer(ScriptContextStats._DESERIALIZER), "contexts");
        op.add(Builder::sum, ScriptStats._DESERIALIZER, "sum");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.contexts);
        result = 31 * result + this.sum.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ScriptCacheStats other = (ScriptCacheStats) o;
        return Objects.equals(this.contexts, other.contexts) && this.sum.equals(other.sum);
    }
}
