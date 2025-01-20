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

package org.opensearch.client.opensearch._types.aggregations;

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
import org.opensearch.client.opensearch._types.Script;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.aggregations.ScriptedMetricAggregation

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ScriptedMetricAggregation extends MetricAggregationBase
    implements
        AggregationVariant,
        ToCopyableBuilder<ScriptedMetricAggregation.Builder, ScriptedMetricAggregation> {

    @Nullable
    private final Script combineScript;

    @Nullable
    private final Script initScript;

    @Nullable
    private final Script mapScript;

    @Nonnull
    private final Map<String, JsonData> params;

    @Nullable
    private final Script reduceScript;

    // ---------------------------------------------------------------------------------------------

    private ScriptedMetricAggregation(Builder builder) {
        super(builder);
        this.combineScript = builder.combineScript;
        this.initScript = builder.initScript;
        this.mapScript = builder.mapScript;
        this.params = ApiTypeHelper.unmodifiable(builder.params);
        this.reduceScript = builder.reduceScript;
    }

    public static ScriptedMetricAggregation of(Function<ScriptedMetricAggregation.Builder, ObjectBuilder<ScriptedMetricAggregation>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Aggregation} variant kind.
     */
    @Override
    public Aggregation.Kind _aggregationKind() {
        return Aggregation.Kind.ScriptedMetric;
    }

    /**
     * API name: {@code combine_script}
     */
    @Nullable
    public final Script combineScript() {
        return this.combineScript;
    }

    /**
     * API name: {@code init_script}
     */
    @Nullable
    public final Script initScript() {
        return this.initScript;
    }

    /**
     * API name: {@code map_script}
     */
    @Nullable
    public final Script mapScript() {
        return this.mapScript;
    }

    /**
     * A global object with script parameters for <code>init</code>, <code>map</code> and <code>combine</code> scripts. It is shared between
     * the scripts.
     * <p>
     * API name: {@code params}
     * </p>
     */
    @Nonnull
    public final Map<String, JsonData> params() {
        return this.params;
    }

    /**
     * API name: {@code reduce_script}
     */
    @Nullable
    public final Script reduceScript() {
        return this.reduceScript;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.combineScript != null) {
            generator.writeKey("combine_script");
            this.combineScript.serialize(generator, mapper);
        }

        if (this.initScript != null) {
            generator.writeKey("init_script");
            this.initScript.serialize(generator, mapper);
        }

        if (this.mapScript != null) {
            generator.writeKey("map_script");
            this.mapScript.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.params)) {
            generator.writeKey("params");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.params.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.reduceScript != null) {
            generator.writeKey("reduce_script");
            this.reduceScript.serialize(generator, mapper);
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
     * Builder for {@link ScriptedMetricAggregation}.
     */
    public static class Builder extends MetricAggregationBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, ScriptedMetricAggregation> {
        @Nullable
        private Script combineScript;
        @Nullable
        private Script initScript;
        @Nullable
        private Script mapScript;
        @Nullable
        private Map<String, JsonData> params;
        @Nullable
        private Script reduceScript;

        public Builder() {}

        private Builder(ScriptedMetricAggregation o) {
            super(o);
            this.combineScript = o.combineScript;
            this.initScript = o.initScript;
            this.mapScript = o.mapScript;
            this.params = _mapCopy(o.params);
            this.reduceScript = o.reduceScript;
        }

        private Builder(Builder o) {
            super(o);
            this.combineScript = o.combineScript;
            this.initScript = o.initScript;
            this.mapScript = o.mapScript;
            this.params = _mapCopy(o.params);
            this.reduceScript = o.reduceScript;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        @Override
        @Nonnull
        protected Builder self() {
            return this;
        }

        /**
         * API name: {@code combine_script}
         */
        @Nonnull
        public final Builder combineScript(@Nullable Script value) {
            this.combineScript = value;
            return this;
        }

        /**
         * API name: {@code combine_script}
         */
        @Nonnull
        public final Builder combineScript(Function<Script.Builder, ObjectBuilder<Script>> fn) {
            return combineScript(fn.apply(new Script.Builder()).build());
        }

        /**
         * API name: {@code init_script}
         */
        @Nonnull
        public final Builder initScript(@Nullable Script value) {
            this.initScript = value;
            return this;
        }

        /**
         * API name: {@code init_script}
         */
        @Nonnull
        public final Builder initScript(Function<Script.Builder, ObjectBuilder<Script>> fn) {
            return initScript(fn.apply(new Script.Builder()).build());
        }

        /**
         * API name: {@code map_script}
         */
        @Nonnull
        public final Builder mapScript(@Nullable Script value) {
            this.mapScript = value;
            return this;
        }

        /**
         * API name: {@code map_script}
         */
        @Nonnull
        public final Builder mapScript(Function<Script.Builder, ObjectBuilder<Script>> fn) {
            return mapScript(fn.apply(new Script.Builder()).build());
        }

        /**
         * A global object with script parameters for <code>init</code>, <code>map</code> and <code>combine</code> scripts. It is shared
         * between the scripts.
         * <p>
         * API name: {@code params}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>params</code>.
         * </p>
         */
        @Nonnull
        public final Builder params(Map<String, JsonData> map) {
            this.params = _mapPutAll(this.params, map);
            return this;
        }

        /**
         * A global object with script parameters for <code>init</code>, <code>map</code> and <code>combine</code> scripts. It is shared
         * between the scripts.
         * <p>
         * API name: {@code params}
         * </p>
         *
         * <p>
         * Adds an entry to <code>params</code>.
         * </p>
         */
        @Nonnull
        public final Builder params(String key, JsonData value) {
            this.params = _mapPut(this.params, key, value);
            return this;
        }

        /**
         * API name: {@code reduce_script}
         */
        @Nonnull
        public final Builder reduceScript(@Nullable Script value) {
            this.reduceScript = value;
            return this;
        }

        /**
         * API name: {@code reduce_script}
         */
        @Nonnull
        public final Builder reduceScript(Function<Script.Builder, ObjectBuilder<Script>> fn) {
            return reduceScript(fn.apply(new Script.Builder()).build());
        }

        /**
         * Builds a {@link ScriptedMetricAggregation}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ScriptedMetricAggregation build() {
            _checkSingleUse();

            return new ScriptedMetricAggregation(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ScriptedMetricAggregation}
     */
    public static final JsonpDeserializer<ScriptedMetricAggregation> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ScriptedMetricAggregation::setupScriptedMetricAggregationDeserializer
    );

    protected static void setupScriptedMetricAggregationDeserializer(ObjectDeserializer<ScriptedMetricAggregation.Builder> op) {
        setupMetricAggregationBaseDeserializer(op);
        op.add(Builder::combineScript, Script._DESERIALIZER, "combine_script");
        op.add(Builder::initScript, Script._DESERIALIZER, "init_script");
        op.add(Builder::mapScript, Script._DESERIALIZER, "map_script");
        op.add(Builder::params, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "params");
        op.add(Builder::reduceScript, Script._DESERIALIZER, "reduce_script");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.combineScript);
        result = 31 * result + Objects.hashCode(this.initScript);
        result = 31 * result + Objects.hashCode(this.mapScript);
        result = 31 * result + Objects.hashCode(this.params);
        result = 31 * result + Objects.hashCode(this.reduceScript);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ScriptedMetricAggregation other = (ScriptedMetricAggregation) o;
        return Objects.equals(this.combineScript, other.combineScript)
            && Objects.equals(this.initScript, other.initScript)
            && Objects.equals(this.mapScript, other.mapScript)
            && Objects.equals(this.params, other.params)
            && Objects.equals(this.reduceScript, other.reduceScript);
    }
}
