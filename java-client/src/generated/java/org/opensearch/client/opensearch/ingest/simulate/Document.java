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

package org.opensearch.client.opensearch.ingest.simulate;

import jakarta.json.stream.JsonGenerator;
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

// typedef: ingest.simulate.Document

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Document implements PlainJsonSerializable, ToCopyableBuilder<Document.Builder, Document> {

    @Nullable
    private final String id;

    @Nullable
    private final String index;

    @Nonnull
    private final JsonData source;

    // ---------------------------------------------------------------------------------------------

    private Document(Builder builder) {
        this.id = builder.id;
        this.index = builder.index;
        this.source = ApiTypeHelper.requireNonNull(builder.source, this, "source");
    }

    public static Document of(Function<Document.Builder, ObjectBuilder<Document>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code _id}
     */
    @Nullable
    public final String id() {
        return this.id;
    }

    /**
     * API name: {@code _index}
     */
    @Nullable
    public final String index() {
        return this.index;
    }

    /**
     * Required - JSON body for the document.
     * <p>
     * API name: {@code _source}
     * </p>
     */
    @Nonnull
    public final JsonData source() {
        return this.source;
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
        if (this.id != null) {
            generator.writeKey("_id");
            generator.write(this.id);
        }

        if (this.index != null) {
            generator.writeKey("_index");
            generator.write(this.index);
        }

        generator.writeKey("_source");
        this.source.serialize(generator, mapper);
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
     * Builder for {@link Document}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, Document> {
        @Nullable
        private String id;
        @Nullable
        private String index;
        private JsonData source;

        public Builder() {}

        private Builder(Document o) {
            this.id = o.id;
            this.index = o.index;
            this.source = o.source;
        }

        private Builder(Builder o) {
            this.id = o.id;
            this.index = o.index;
            this.source = o.source;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code _id}
         */
        @Nonnull
        public final Builder id(@Nullable String value) {
            this.id = value;
            return this;
        }

        /**
         * API name: {@code _index}
         */
        @Nonnull
        public final Builder index(@Nullable String value) {
            this.index = value;
            return this;
        }

        /**
         * Required - JSON body for the document.
         * <p>
         * API name: {@code _source}
         * </p>
         */
        @Nonnull
        public final Builder source(JsonData value) {
            this.source = value;
            return this;
        }

        /**
         * Builds a {@link Document}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public Document build() {
            _checkSingleUse();

            return new Document(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link Document}
     */
    public static final JsonpDeserializer<Document> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        Document::setupDocumentDeserializer
    );

    protected static void setupDocumentDeserializer(ObjectDeserializer<Document.Builder> op) {
        op.add(Builder::id, JsonpDeserializer.stringDeserializer(), "_id");
        op.add(Builder::index, JsonpDeserializer.stringDeserializer(), "_index");
        op.add(Builder::source, JsonData._DESERIALIZER, "_source");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.id);
        result = 31 * result + Objects.hashCode(this.index);
        result = 31 * result + this.source.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Document other = (Document) o;
        return Objects.equals(this.id, other.id) && Objects.equals(this.index, other.index) && this.source.equals(other.source);
    }
}
