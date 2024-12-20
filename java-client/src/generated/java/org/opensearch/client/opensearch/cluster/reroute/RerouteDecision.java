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

// typedef: cluster.reroute.RerouteDecision

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RerouteDecision implements PlainJsonSerializable, ToCopyableBuilder<RerouteDecision.Builder, RerouteDecision> {

    @Nonnull
    private final String decider;

    @Nonnull
    private final String decision;

    @Nonnull
    private final String explanation;

    // ---------------------------------------------------------------------------------------------

    private RerouteDecision(Builder builder) {
        this.decider = ApiTypeHelper.requireNonNull(builder.decider, this, "decider");
        this.decision = ApiTypeHelper.requireNonNull(builder.decision, this, "decision");
        this.explanation = ApiTypeHelper.requireNonNull(builder.explanation, this, "explanation");
    }

    public static RerouteDecision of(Function<RerouteDecision.Builder, ObjectBuilder<RerouteDecision>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code decider}
     */
    @Nonnull
    public final String decider() {
        return this.decider;
    }

    /**
     * Required - API name: {@code decision}
     */
    @Nonnull
    public final String decision() {
        return this.decision;
    }

    /**
     * Required - API name: {@code explanation}
     */
    @Nonnull
    public final String explanation() {
        return this.explanation;
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
        generator.writeKey("decider");
        generator.write(this.decider);

        generator.writeKey("decision");
        generator.write(this.decision);

        generator.writeKey("explanation");
        generator.write(this.explanation);
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
     * Builder for {@link RerouteDecision}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, RerouteDecision> {
        private String decider;
        private String decision;
        private String explanation;

        public Builder() {}

        private Builder(RerouteDecision o) {
            this.decider = o.decider;
            this.decision = o.decision;
            this.explanation = o.explanation;
        }

        private Builder(Builder o) {
            this.decider = o.decider;
            this.decision = o.decision;
            this.explanation = o.explanation;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code decider}
         */
        @Nonnull
        public final Builder decider(String value) {
            this.decider = value;
            return this;
        }

        /**
         * Required - API name: {@code decision}
         */
        @Nonnull
        public final Builder decision(String value) {
            this.decision = value;
            return this;
        }

        /**
         * Required - API name: {@code explanation}
         */
        @Nonnull
        public final Builder explanation(String value) {
            this.explanation = value;
            return this;
        }

        /**
         * Builds a {@link RerouteDecision}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RerouteDecision build() {
            _checkSingleUse();

            return new RerouteDecision(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RerouteDecision}
     */
    public static final JsonpDeserializer<RerouteDecision> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RerouteDecision::setupRerouteDecisionDeserializer
    );

    protected static void setupRerouteDecisionDeserializer(ObjectDeserializer<RerouteDecision.Builder> op) {
        op.add(Builder::decider, JsonpDeserializer.stringDeserializer(), "decider");
        op.add(Builder::decision, JsonpDeserializer.stringDeserializer(), "decision");
        op.add(Builder::explanation, JsonpDeserializer.stringDeserializer(), "explanation");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.decider.hashCode();
        result = 31 * result + this.decision.hashCode();
        result = 31 * result + this.explanation.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RerouteDecision other = (RerouteDecision) o;
        return this.decider.equals(other.decider) && this.decision.equals(other.decision) && this.explanation.equals(other.explanation);
    }
}
