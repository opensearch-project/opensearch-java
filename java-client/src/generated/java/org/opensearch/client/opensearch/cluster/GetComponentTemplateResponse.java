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

// typedef: cluster.get_component_template.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GetComponentTemplateResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<GetComponentTemplateResponse.Builder, GetComponentTemplateResponse> {

    @Nonnull
    private final List<ComponentTemplate> componentTemplates;

    // ---------------------------------------------------------------------------------------------

    private GetComponentTemplateResponse(Builder builder) {
        this.componentTemplates = ApiTypeHelper.unmodifiableRequired(builder.componentTemplates, this, "componentTemplates");
    }

    public static GetComponentTemplateResponse of(
        Function<GetComponentTemplateResponse.Builder, ObjectBuilder<GetComponentTemplateResponse>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code component_templates}
     */
    @Nonnull
    public final List<ComponentTemplate> componentTemplates() {
        return this.componentTemplates;
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
        generator.writeKey("component_templates");
        generator.writeStartArray();
        for (ComponentTemplate item0 : this.componentTemplates) {
            item0.serialize(generator, mapper);
        }
        generator.writeEnd();
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
     * Builder for {@link GetComponentTemplateResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, GetComponentTemplateResponse> {
        private List<ComponentTemplate> componentTemplates;

        public Builder() {}

        private Builder(GetComponentTemplateResponse o) {
            this.componentTemplates = _listCopy(o.componentTemplates);
        }

        private Builder(Builder o) {
            this.componentTemplates = _listCopy(o.componentTemplates);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code component_templates}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>componentTemplates</code>.
         * </p>
         */
        @Nonnull
        public final Builder componentTemplates(List<ComponentTemplate> list) {
            this.componentTemplates = _listAddAll(this.componentTemplates, list);
            return this;
        }

        /**
         * Required - API name: {@code component_templates}
         *
         * <p>
         * Adds one or more values to <code>componentTemplates</code>.
         * </p>
         */
        @Nonnull
        public final Builder componentTemplates(ComponentTemplate value, ComponentTemplate... values) {
            this.componentTemplates = _listAdd(this.componentTemplates, value, values);
            return this;
        }

        /**
         * Required - API name: {@code component_templates}
         *
         * <p>
         * Adds a value to <code>componentTemplates</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder componentTemplates(Function<ComponentTemplate.Builder, ObjectBuilder<ComponentTemplate>> fn) {
            return componentTemplates(fn.apply(new ComponentTemplate.Builder()).build());
        }

        /**
         * Builds a {@link GetComponentTemplateResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetComponentTemplateResponse build() {
            _checkSingleUse();

            return new GetComponentTemplateResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GetComponentTemplateResponse}
     */
    public static final JsonpDeserializer<GetComponentTemplateResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GetComponentTemplateResponse::setupGetComponentTemplateResponseDeserializer
    );

    protected static void setupGetComponentTemplateResponseDeserializer(ObjectDeserializer<GetComponentTemplateResponse.Builder> op) {
        op.add(Builder::componentTemplates, JsonpDeserializer.arrayDeserializer(ComponentTemplate._DESERIALIZER), "component_templates");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.componentTemplates.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetComponentTemplateResponse other = (GetComponentTemplateResponse) o;
        return this.componentTemplates.equals(other.componentTemplates);
    }
}
