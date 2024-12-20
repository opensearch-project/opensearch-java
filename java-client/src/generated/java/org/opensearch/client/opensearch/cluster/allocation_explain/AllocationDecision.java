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

package org.opensearch.client.opensearch.cluster.allocation_explain;

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

// typedef: cluster.allocation_explain.AllocationDecision

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class AllocationDecision implements PlainJsonSerializable, ToCopyableBuilder<AllocationDecision.Builder, AllocationDecision> {

    @Nonnull
    private final String decider;

    @Nonnull
    private final AllocationExplainDecision decision;

    @Nonnull
    private final String explanation;

    // ---------------------------------------------------------------------------------------------

    private AllocationDecision(Builder builder) {
        this.decider = ApiTypeHelper.requireNonNull(builder.decider, this, "decider");
        this.decision = ApiTypeHelper.requireNonNull(builder.decision, this, "decision");
        this.explanation = ApiTypeHelper.requireNonNull(builder.explanation, this, "explanation");
    }

    public static AllocationDecision of(Function<AllocationDecision.Builder, ObjectBuilder<AllocationDecision>> fn) {
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
    public final AllocationExplainDecision decision() {
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
        this.decision.serialize(generator, mapper);

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
     * Builder for {@link AllocationDecision}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, AllocationDecision> {
        private String decider;
        private AllocationExplainDecision decision;
        private String explanation;

        public Builder() {}

        private Builder(AllocationDecision o) {
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
        public final Builder decision(AllocationExplainDecision value) {
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
         * Builds a {@link AllocationDecision}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public AllocationDecision build() {
            _checkSingleUse();

            return new AllocationDecision(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link AllocationDecision}
     */
    public static final JsonpDeserializer<AllocationDecision> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        AllocationDecision::setupAllocationDecisionDeserializer
    );

    protected static void setupAllocationDecisionDeserializer(ObjectDeserializer<AllocationDecision.Builder> op) {
        op.add(Builder::decider, JsonpDeserializer.stringDeserializer(), "decider");
        op.add(Builder::decision, AllocationExplainDecision._DESERIALIZER, "decision");
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
        AllocationDecision other = (AllocationDecision) o;
        return this.decider.equals(other.decider) && this.decision.equals(other.decision) && this.explanation.equals(other.explanation);
    }
}
