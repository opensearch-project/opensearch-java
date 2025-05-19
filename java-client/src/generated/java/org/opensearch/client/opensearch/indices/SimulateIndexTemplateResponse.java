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

package org.opensearch.client.opensearch.indices;

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
import org.opensearch.client.opensearch.indices.simulate_template.Overlapping;
import org.opensearch.client.opensearch.indices.simulate_template.Template;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: indices.simulate_index_template.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SimulateIndexTemplateResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<SimulateIndexTemplateResponse.Builder, SimulateIndexTemplateResponse> {

    @Nonnull
    private final List<Overlapping> overlapping;

    @Nullable
    private final Template template;

    // ---------------------------------------------------------------------------------------------

    private SimulateIndexTemplateResponse(Builder builder) {
        this.overlapping = ApiTypeHelper.unmodifiable(builder.overlapping);
        this.template = builder.template;
    }

    public static SimulateIndexTemplateResponse of(
        Function<SimulateIndexTemplateResponse.Builder, ObjectBuilder<SimulateIndexTemplateResponse>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code overlapping}
     */
    @Nonnull
    public final List<Overlapping> overlapping() {
        return this.overlapping;
    }

    /**
     * API name: {@code template}
     */
    @Nullable
    public final Template template() {
        return this.template;
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
        if (ApiTypeHelper.isDefined(this.overlapping)) {
            generator.writeKey("overlapping");
            generator.writeStartArray();
            for (Overlapping item0 : this.overlapping) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.template != null) {
            generator.writeKey("template");
            this.template.serialize(generator, mapper);
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
     * Builder for {@link SimulateIndexTemplateResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, SimulateIndexTemplateResponse> {
        @Nullable
        private List<Overlapping> overlapping;
        @Nullable
        private Template template;

        public Builder() {}

        private Builder(SimulateIndexTemplateResponse o) {
            this.overlapping = _listCopy(o.overlapping);
            this.template = o.template;
        }

        private Builder(Builder o) {
            this.overlapping = _listCopy(o.overlapping);
            this.template = o.template;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code overlapping}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>overlapping</code>.
         * </p>
         */
        @Nonnull
        public final Builder overlapping(List<Overlapping> list) {
            this.overlapping = _listAddAll(this.overlapping, list);
            return this;
        }

        /**
         * API name: {@code overlapping}
         *
         * <p>
         * Adds one or more values to <code>overlapping</code>.
         * </p>
         */
        @Nonnull
        public final Builder overlapping(Overlapping value, Overlapping... values) {
            this.overlapping = _listAdd(this.overlapping, value, values);
            return this;
        }

        /**
         * API name: {@code overlapping}
         *
         * <p>
         * Adds a value to <code>overlapping</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder overlapping(Function<Overlapping.Builder, ObjectBuilder<Overlapping>> fn) {
            return overlapping(fn.apply(new Overlapping.Builder()).build());
        }

        /**
         * API name: {@code template}
         */
        @Nonnull
        public final Builder template(@Nullable Template value) {
            this.template = value;
            return this;
        }

        /**
         * API name: {@code template}
         */
        @Nonnull
        public final Builder template(Function<Template.Builder, ObjectBuilder<Template>> fn) {
            return template(fn.apply(new Template.Builder()).build());
        }

        /**
         * Builds a {@link SimulateIndexTemplateResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SimulateIndexTemplateResponse build() {
            _checkSingleUse();

            return new SimulateIndexTemplateResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SimulateIndexTemplateResponse}
     */
    public static final JsonpDeserializer<SimulateIndexTemplateResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SimulateIndexTemplateResponse::setupSimulateIndexTemplateResponseDeserializer
    );

    protected static void setupSimulateIndexTemplateResponseDeserializer(ObjectDeserializer<SimulateIndexTemplateResponse.Builder> op) {
        op.add(Builder::overlapping, JsonpDeserializer.arrayDeserializer(Overlapping._DESERIALIZER), "overlapping");
        op.add(Builder::template, Template._DESERIALIZER, "template");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.overlapping);
        result = 31 * result + Objects.hashCode(this.template);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SimulateIndexTemplateResponse other = (SimulateIndexTemplateResponse) o;
        return Objects.equals(this.overlapping, other.overlapping) && Objects.equals(this.template, other.template);
    }
}
