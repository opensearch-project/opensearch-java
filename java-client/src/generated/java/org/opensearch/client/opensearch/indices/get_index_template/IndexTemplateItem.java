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

package org.opensearch.client.opensearch.indices.get_index_template;

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
import org.opensearch.client.opensearch.indices.IndexTemplate;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: indices.get_index_template.IndexTemplateItem

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IndexTemplateItem implements PlainJsonSerializable {

    @Nonnull
    private final IndexTemplate indexTemplate;

    @Nonnull
    private final String name;

    // ---------------------------------------------------------------------------------------------

    private IndexTemplateItem(Builder builder) {
        this.indexTemplate = ApiTypeHelper.requireNonNull(builder.indexTemplate, this, "indexTemplate");
        this.name = ApiTypeHelper.requireNonNull(builder.name, this, "name");
    }

    public static IndexTemplateItem of(Function<IndexTemplateItem.Builder, ObjectBuilder<IndexTemplateItem>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code index_template}
     */
    @Nonnull
    public final IndexTemplate indexTemplate() {
        return this.indexTemplate;
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
        generator.writeKey("index_template");
        this.indexTemplate.serialize(generator, mapper);

        generator.writeKey("name");
        generator.write(this.name);
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link IndexTemplateItem}.
     */
    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<IndexTemplateItem> {
        private IndexTemplate indexTemplate;
        private String name;

        /**
         * Required - API name: {@code index_template}
         */
        public final Builder indexTemplate(IndexTemplate value) {
            this.indexTemplate = value;
            return this;
        }

        /**
         * Required - API name: {@code index_template}
         */
        public final Builder indexTemplate(Function<IndexTemplate.Builder, ObjectBuilder<IndexTemplate>> fn) {
            return indexTemplate(fn.apply(new IndexTemplate.Builder()).build());
        }

        /**
         * Required - API name: {@code name}
         */
        public final Builder name(String value) {
            this.name = value;
            return this;
        }

        /**
         * Builds a {@link IndexTemplateItem}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public IndexTemplateItem build() {
            _checkSingleUse();

            return new IndexTemplateItem(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IndexTemplateItem}
     */
    public static final JsonpDeserializer<IndexTemplateItem> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IndexTemplateItem::setupIndexTemplateItemDeserializer
    );

    protected static void setupIndexTemplateItemDeserializer(ObjectDeserializer<IndexTemplateItem.Builder> op) {
        op.add(Builder::indexTemplate, IndexTemplate._DESERIALIZER, "index_template");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.indexTemplate.hashCode();
        result = 31 * result + this.name.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IndexTemplateItem other = (IndexTemplateItem) o;
        return this.indexTemplate.equals(other.indexTemplate) && this.name.equals(other.name);
    }
}
