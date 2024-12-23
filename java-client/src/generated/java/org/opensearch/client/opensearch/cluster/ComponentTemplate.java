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

// typedef: cluster.ComponentTemplate

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ComponentTemplate implements PlainJsonSerializable, ToCopyableBuilder<ComponentTemplate.Builder, ComponentTemplate> {

    @Nonnull
    private final ComponentTemplateNode componentTemplate;

    @Nonnull
    private final String name;

    // ---------------------------------------------------------------------------------------------

    private ComponentTemplate(Builder builder) {
        this.componentTemplate = ApiTypeHelper.requireNonNull(builder.componentTemplate, this, "componentTemplate");
        this.name = ApiTypeHelper.requireNonNull(builder.name, this, "name");
    }

    public static ComponentTemplate of(Function<ComponentTemplate.Builder, ObjectBuilder<ComponentTemplate>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code component_template}
     */
    @Nonnull
    public final ComponentTemplateNode componentTemplate() {
        return this.componentTemplate;
    }

    /**
     * Required - API name: {@code name}
     */
    @Nonnull
    public final String name() {
        return this.name;
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
        generator.writeKey("component_template");
        this.componentTemplate.serialize(generator, mapper);

        generator.writeKey("name");
        generator.write(this.name);
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
     * Builder for {@link ComponentTemplate}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ComponentTemplate> {
        private ComponentTemplateNode componentTemplate;
        private String name;

        public Builder() {}

        private Builder(ComponentTemplate o) {
            this.componentTemplate = o.componentTemplate;
            this.name = o.name;
        }

        private Builder(Builder o) {
            this.componentTemplate = o.componentTemplate;
            this.name = o.name;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code component_template}
         */
        @Nonnull
        public final Builder componentTemplate(ComponentTemplateNode value) {
            this.componentTemplate = value;
            return this;
        }

        /**
         * Required - API name: {@code component_template}
         */
        @Nonnull
        public final Builder componentTemplate(Function<ComponentTemplateNode.Builder, ObjectBuilder<ComponentTemplateNode>> fn) {
            return componentTemplate(fn.apply(new ComponentTemplateNode.Builder()).build());
        }

        /**
         * Required - API name: {@code name}
         */
        @Nonnull
        public final Builder name(String value) {
            this.name = value;
            return this;
        }

        /**
         * Builds a {@link ComponentTemplate}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ComponentTemplate build() {
            _checkSingleUse();

            return new ComponentTemplate(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ComponentTemplate}
     */
    public static final JsonpDeserializer<ComponentTemplate> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ComponentTemplate::setupComponentTemplateDeserializer
    );

    protected static void setupComponentTemplateDeserializer(ObjectDeserializer<ComponentTemplate.Builder> op) {
        op.add(Builder::componentTemplate, ComponentTemplateNode._DESERIALIZER, "component_template");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.componentTemplate.hashCode();
        result = 31 * result + this.name.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ComponentTemplate other = (ComponentTemplate) o;
        return this.componentTemplate.equals(other.componentTemplate) && this.name.equals(other.name);
    }
}
