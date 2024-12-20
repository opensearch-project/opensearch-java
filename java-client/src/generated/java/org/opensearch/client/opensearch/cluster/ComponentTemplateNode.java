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
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: cluster.ComponentTemplateNode

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ComponentTemplateNode
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ComponentTemplateNode.Builder, ComponentTemplateNode> {

    @Nonnull
    private final Map<String, JsonData> meta;

    @Nonnull
    private final ComponentTemplateSummary template;

    @Nullable
    private final Long version;

    // ---------------------------------------------------------------------------------------------

    private ComponentTemplateNode(Builder builder) {
        this.meta = ApiTypeHelper.unmodifiable(builder.meta);
        this.template = ApiTypeHelper.requireNonNull(builder.template, this, "template");
        this.version = builder.version;
    }

    public static ComponentTemplateNode of(Function<ComponentTemplateNode.Builder, ObjectBuilder<ComponentTemplateNode>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code _meta}
     */
    @Nonnull
    public final Map<String, JsonData> meta() {
        return this.meta;
    }

    /**
     * Required - API name: {@code template}
     */
    @Nonnull
    public final ComponentTemplateSummary template() {
        return this.template;
    }

    /**
     * API name: {@code version}
     */
    @Nullable
    public final Long version() {
        return this.version;
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
        if (ApiTypeHelper.isDefined(this.meta)) {
            generator.writeKey("_meta");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.meta.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        generator.writeKey("template");
        this.template.serialize(generator, mapper);

        if (this.version != null) {
            generator.writeKey("version");
            generator.write(this.version);
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
     * Builder for {@link ComponentTemplateNode}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ComponentTemplateNode> {
        @Nullable
        private Map<String, JsonData> meta;
        private ComponentTemplateSummary template;
        @Nullable
        private Long version;

        public Builder() {}

        private Builder(ComponentTemplateNode o) {
            this.meta = _mapCopy(o.meta);
            this.template = o.template;
            this.version = o.version;
        }

        private Builder(Builder o) {
            this.meta = _mapCopy(o.meta);
            this.template = o.template;
            this.version = o.version;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code _meta}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>meta</code>.
         * </p>
         */
        @Nonnull
        public final Builder meta(Map<String, JsonData> map) {
            this.meta = _mapPutAll(this.meta, map);
            return this;
        }

        /**
         * API name: {@code _meta}
         *
         * <p>
         * Adds an entry to <code>meta</code>.
         * </p>
         */
        @Nonnull
        public final Builder meta(String key, JsonData value) {
            this.meta = _mapPut(this.meta, key, value);
            return this;
        }

        /**
         * Required - API name: {@code template}
         */
        @Nonnull
        public final Builder template(ComponentTemplateSummary value) {
            this.template = value;
            return this;
        }

        /**
         * Required - API name: {@code template}
         */
        @Nonnull
        public final Builder template(Function<ComponentTemplateSummary.Builder, ObjectBuilder<ComponentTemplateSummary>> fn) {
            return template(fn.apply(new ComponentTemplateSummary.Builder()).build());
        }

        /**
         * API name: {@code version}
         */
        @Nonnull
        public final Builder version(@Nullable Long value) {
            this.version = value;
            return this;
        }

        /**
         * Builds a {@link ComponentTemplateNode}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ComponentTemplateNode build() {
            _checkSingleUse();

            return new ComponentTemplateNode(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ComponentTemplateNode}
     */
    public static final JsonpDeserializer<ComponentTemplateNode> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ComponentTemplateNode::setupComponentTemplateNodeDeserializer
    );

    protected static void setupComponentTemplateNodeDeserializer(ObjectDeserializer<ComponentTemplateNode.Builder> op) {
        op.add(Builder::meta, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "_meta");
        op.add(Builder::template, ComponentTemplateSummary._DESERIALIZER, "template");
        op.add(Builder::version, JsonpDeserializer.longDeserializer(), "version");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.meta);
        result = 31 * result + this.template.hashCode();
        result = 31 * result + Objects.hashCode(this.version);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ComponentTemplateNode other = (ComponentTemplateNode) o;
        return Objects.equals(this.meta, other.meta) && this.template.equals(other.template) && Objects.equals(this.version, other.version);
    }
}
