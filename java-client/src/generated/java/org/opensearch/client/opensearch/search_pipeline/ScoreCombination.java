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

// typedef: search_pipeline.ScoreCombination

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ScoreCombination implements PlainJsonSerializable, ToCopyableBuilder<ScoreCombination.Builder, ScoreCombination> {

    @Nonnull
    private final List<Float> parameters;

    @Nullable
    private final ScoreCombinationTechnique technique;

    // ---------------------------------------------------------------------------------------------

    private ScoreCombination(Builder builder) {
        this.parameters = ApiTypeHelper.unmodifiable(builder.parameters);
        this.technique = builder.technique;
    }

    public static ScoreCombination of(Function<ScoreCombination.Builder, ObjectBuilder<ScoreCombination>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code parameters}
     */
    @Nonnull
    public final List<Float> parameters() {
        return this.parameters;
    }

    /**
     * API name: {@code technique}
     */
    @Nullable
    public final ScoreCombinationTechnique technique() {
        return this.technique;
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
        if (ApiTypeHelper.isDefined(this.parameters)) {
            generator.writeKey("parameters");
            generator.writeStartArray();
            for (Float item0 : this.parameters) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.technique != null) {
            generator.writeKey("technique");
            this.technique.serialize(generator, mapper);
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
     * Builder for {@link ScoreCombination}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ScoreCombination> {
        @Nullable
        private List<Float> parameters;
        @Nullable
        private ScoreCombinationTechnique technique;

        public Builder() {}

        private Builder(ScoreCombination o) {
            this.parameters = _listCopy(o.parameters);
            this.technique = o.technique;
        }

        private Builder(Builder o) {
            this.parameters = _listCopy(o.parameters);
            this.technique = o.technique;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code parameters}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>parameters</code>.
         * </p>
         */
        @Nonnull
        public final Builder parameters(List<Float> list) {
            this.parameters = _listAddAll(this.parameters, list);
            return this;
        }

        /**
         * API name: {@code parameters}
         *
         * <p>
         * Adds one or more values to <code>parameters</code>.
         * </p>
         */
        @Nonnull
        public final Builder parameters(Float value, Float... values) {
            this.parameters = _listAdd(this.parameters, value, values);
            return this;
        }

        /**
         * API name: {@code technique}
         */
        @Nonnull
        public final Builder technique(@Nullable ScoreCombinationTechnique value) {
            this.technique = value;
            return this;
        }

        /**
         * Builds a {@link ScoreCombination}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ScoreCombination build() {
            _checkSingleUse();

            return new ScoreCombination(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ScoreCombination}
     */
    public static final JsonpDeserializer<ScoreCombination> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ScoreCombination::setupScoreCombinationDeserializer
    );

    protected static void setupScoreCombinationDeserializer(ObjectDeserializer<ScoreCombination.Builder> op) {
        op.add(Builder::parameters, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.floatDeserializer()), "parameters");
        op.add(Builder::technique, ScoreCombinationTechnique._DESERIALIZER, "technique");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.parameters);
        result = 31 * result + Objects.hashCode(this.technique);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ScoreCombination other = (ScoreCombination) o;
        return Objects.equals(this.parameters, other.parameters) && Objects.equals(this.technique, other.technique);
    }
}
