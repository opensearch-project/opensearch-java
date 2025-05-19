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

package org.opensearch.client.opensearch.cluster.reroute;

import jakarta.json.stream.JsonGenerator;
import java.util.List;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
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

// typedef: cluster.reroute.RerouteExplanation

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RerouteExplanation implements PlainJsonSerializable, ToCopyableBuilder<RerouteExplanation.Builder, RerouteExplanation> {

    @Nonnull
    private final String command;

    @Nonnull
    private final List<RerouteDecision> decisions;

    @Nonnull
    private final RerouteParameters parameters;

    // ---------------------------------------------------------------------------------------------

    private RerouteExplanation(Builder builder) {
        this.command = ApiTypeHelper.requireNonNull(builder.command, this, "command");
        this.decisions = ApiTypeHelper.unmodifiableRequired(builder.decisions, this, "decisions");
        this.parameters = ApiTypeHelper.requireNonNull(builder.parameters, this, "parameters");
    }

    public static RerouteExplanation of(Function<RerouteExplanation.Builder, ObjectBuilder<RerouteExplanation>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code command}
     */
    @Nonnull
    public final String command() {
        return this.command;
    }

    /**
     * Required - API name: {@code decisions}
     */
    @Nonnull
    public final List<RerouteDecision> decisions() {
        return this.decisions;
    }

    /**
     * Required - API name: {@code parameters}
     */
    @Nonnull
    public final RerouteParameters parameters() {
        return this.parameters;
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
        generator.writeKey("command");
        generator.write(this.command);

        generator.writeKey("decisions");
        generator.writeStartArray();
        for (RerouteDecision item0 : this.decisions) {
            item0.serialize(generator, mapper);
        }
        generator.writeEnd();

        generator.writeKey("parameters");
        this.parameters.serialize(generator, mapper);
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
     * Builder for {@link RerouteExplanation}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, RerouteExplanation> {
        private String command;
        private List<RerouteDecision> decisions;
        private RerouteParameters parameters;

        public Builder() {}

        private Builder(RerouteExplanation o) {
            this.command = o.command;
            this.decisions = _listCopy(o.decisions);
            this.parameters = o.parameters;
        }

        private Builder(Builder o) {
            this.command = o.command;
            this.decisions = _listCopy(o.decisions);
            this.parameters = o.parameters;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code command}
         */
        @Nonnull
        public final Builder command(String value) {
            this.command = value;
            return this;
        }

        /**
         * Required - API name: {@code decisions}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>decisions</code>.
         * </p>
         */
        @Nonnull
        public final Builder decisions(List<RerouteDecision> list) {
            this.decisions = _listAddAll(this.decisions, list);
            return this;
        }

        /**
         * Required - API name: {@code decisions}
         *
         * <p>
         * Adds one or more values to <code>decisions</code>.
         * </p>
         */
        @Nonnull
        public final Builder decisions(RerouteDecision value, RerouteDecision... values) {
            this.decisions = _listAdd(this.decisions, value, values);
            return this;
        }

        /**
         * Required - API name: {@code decisions}
         *
         * <p>
         * Adds a value to <code>decisions</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder decisions(Function<RerouteDecision.Builder, ObjectBuilder<RerouteDecision>> fn) {
            return decisions(fn.apply(new RerouteDecision.Builder()).build());
        }

        /**
         * Required - API name: {@code parameters}
         */
        @Nonnull
        public final Builder parameters(RerouteParameters value) {
            this.parameters = value;
            return this;
        }

        /**
         * Required - API name: {@code parameters}
         */
        @Nonnull
        public final Builder parameters(Function<RerouteParameters.Builder, ObjectBuilder<RerouteParameters>> fn) {
            return parameters(fn.apply(new RerouteParameters.Builder()).build());
        }

        /**
         * Builds a {@link RerouteExplanation}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RerouteExplanation build() {
            _checkSingleUse();

            return new RerouteExplanation(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RerouteExplanation}
     */
    public static final JsonpDeserializer<RerouteExplanation> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RerouteExplanation::setupRerouteExplanationDeserializer
    );

    protected static void setupRerouteExplanationDeserializer(ObjectDeserializer<RerouteExplanation.Builder> op) {
        op.add(Builder::command, JsonpDeserializer.stringDeserializer(), "command");
        op.add(Builder::decisions, JsonpDeserializer.arrayDeserializer(RerouteDecision._DESERIALIZER), "decisions");
        op.add(Builder::parameters, RerouteParameters._DESERIALIZER, "parameters");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.command.hashCode();
        result = 31 * result + this.decisions.hashCode();
        result = 31 * result + this.parameters.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RerouteExplanation other = (RerouteExplanation) o;
        return this.command.equals(other.command) && this.decisions.equals(other.decisions) && this.parameters.equals(other.parameters);
    }
}
