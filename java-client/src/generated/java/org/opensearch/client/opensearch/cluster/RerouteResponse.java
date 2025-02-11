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

package org.opensearch.client.opensearch.cluster;

import jakarta.json.stream.JsonGenerator;
import java.util.List;
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
import org.opensearch.client.opensearch._types.AcknowledgedResponseBase;
import org.opensearch.client.opensearch.cluster.reroute.RerouteExplanation;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: cluster.reroute.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RerouteResponse extends AcknowledgedResponseBase implements ToCopyableBuilder<RerouteResponse.Builder, RerouteResponse> {

    @Nonnull
    private final List<RerouteExplanation> explanations;

    @Nullable
    private final JsonData state;

    // ---------------------------------------------------------------------------------------------

    private RerouteResponse(Builder builder) {
        super(builder);
        this.explanations = ApiTypeHelper.unmodifiable(builder.explanations);
        this.state = builder.state;
    }

    public static RerouteResponse of(Function<RerouteResponse.Builder, ObjectBuilder<RerouteResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code explanations}
     */
    @Nonnull
    public final List<RerouteExplanation> explanations() {
        return this.explanations;
    }

    /**
     * Shows the internal representation of the structure, which can differ from the external representation.
     * <p>
     * API name: {@code state}
     * </p>
     */
    @Nullable
    public final JsonData state() {
        return this.state;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (ApiTypeHelper.isDefined(this.explanations)) {
            generator.writeKey("explanations");
            generator.writeStartArray();
            for (RerouteExplanation item0 : this.explanations) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.state != null) {
            generator.writeKey("state");
            this.state.serialize(generator, mapper);
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
     * Builder for {@link RerouteResponse}.
     */
    public static class Builder extends AcknowledgedResponseBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, RerouteResponse> {
        @Nullable
        private List<RerouteExplanation> explanations;
        @Nullable
        private JsonData state;

        public Builder() {}

        private Builder(RerouteResponse o) {
            super(o);
            this.explanations = _listCopy(o.explanations);
            this.state = o.state;
        }

        private Builder(Builder o) {
            super(o);
            this.explanations = _listCopy(o.explanations);
            this.state = o.state;
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
         * API name: {@code explanations}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>explanations</code>.
         * </p>
         */
        @Nonnull
        public final Builder explanations(List<RerouteExplanation> list) {
            this.explanations = _listAddAll(this.explanations, list);
            return this;
        }

        /**
         * API name: {@code explanations}
         *
         * <p>
         * Adds one or more values to <code>explanations</code>.
         * </p>
         */
        @Nonnull
        public final Builder explanations(RerouteExplanation value, RerouteExplanation... values) {
            this.explanations = _listAdd(this.explanations, value, values);
            return this;
        }

        /**
         * API name: {@code explanations}
         *
         * <p>
         * Adds a value to <code>explanations</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder explanations(Function<RerouteExplanation.Builder, ObjectBuilder<RerouteExplanation>> fn) {
            return explanations(fn.apply(new RerouteExplanation.Builder()).build());
        }

        /**
         * Shows the internal representation of the structure, which can differ from the external representation.
         * <p>
         * API name: {@code state}
         * </p>
         */
        @Nonnull
        public final Builder state(@Nullable JsonData value) {
            this.state = value;
            return this;
        }

        /**
         * Builds a {@link RerouteResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RerouteResponse build() {
            _checkSingleUse();

            return new RerouteResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RerouteResponse}
     */
    public static final JsonpDeserializer<RerouteResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RerouteResponse::setupRerouteResponseDeserializer
    );

    protected static void setupRerouteResponseDeserializer(ObjectDeserializer<RerouteResponse.Builder> op) {
        setupAcknowledgedResponseBaseDeserializer(op);
        op.add(Builder::explanations, JsonpDeserializer.arrayDeserializer(RerouteExplanation._DESERIALIZER), "explanations");
        op.add(Builder::state, JsonData._DESERIALIZER, "state");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.explanations);
        result = 31 * result + Objects.hashCode(this.state);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RerouteResponse other = (RerouteResponse) o;
        return Objects.equals(this.explanations, other.explanations) && Objects.equals(this.state, other.state);
    }
}
