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

package org.opensearch.client.opensearch._types.query_dsl;

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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.query_dsl.PercolateQuery

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class PercolateQuery extends QueryBase implements QueryVariant, ToCopyableBuilder<PercolateQuery.Builder, PercolateQuery> {

    @Nullable
    private final JsonData document;

    @Nonnull
    private final List<JsonData> documents;

    @Nonnull
    private final String field;

    @Nullable
    private final String id;

    @Nullable
    private final String index;

    @Nullable
    private final String name;

    @Nullable
    private final String preference;

    @Nullable
    private final String routing;

    @Nullable
    private final Long version;

    // ---------------------------------------------------------------------------------------------

    private PercolateQuery(Builder builder) {
        super(builder);
        this.document = builder.document;
        this.documents = ApiTypeHelper.unmodifiable(builder.documents);
        this.field = ApiTypeHelper.requireNonNull(builder.field, this, "field");
        this.id = builder.id;
        this.index = builder.index;
        this.name = builder.name;
        this.preference = builder.preference;
        this.routing = builder.routing;
        this.version = builder.version;
    }

    public static PercolateQuery of(Function<PercolateQuery.Builder, ObjectBuilder<PercolateQuery>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Query} variant kind.
     */
    @Override
    public Query.Kind _queryKind() {
        return Query.Kind.Percolate;
    }

    /**
     * The source of the document being percolated.
     * <p>
     * API name: {@code document}
     * </p>
     */
    @Nullable
    public final JsonData document() {
        return this.document;
    }

    /**
     * An array of sources of the documents being percolated.
     * <p>
     * API name: {@code documents}
     * </p>
     */
    @Nonnull
    public final List<JsonData> documents() {
        return this.documents;
    }

    /**
     * Required - API name: {@code field}
     */
    @Nonnull
    public final String field() {
        return this.field;
    }

    /**
     * API name: {@code id}
     */
    @Nullable
    public final String id() {
        return this.id;
    }

    /**
     * API name: {@code index}
     */
    @Nullable
    public final String index() {
        return this.index;
    }

    /**
     * The suffix used for the <code>_percolator_document_slot</code> field when multiple <code>percolate</code> queries are specified.
     * <p>
     * API name: {@code name}
     * </p>
     */
    @Nullable
    public final String name() {
        return this.name;
    }

    /**
     * Preference used to fetch document to percolate.
     * <p>
     * API name: {@code preference}
     * </p>
     */
    @Nullable
    public final String preference() {
        return this.preference;
    }

    /**
     * API name: {@code routing}
     */
    @Nullable
    public final String routing() {
        return this.routing;
    }

    /**
     * API name: {@code version}
     */
    @Nullable
    public final Long version() {
        return this.version;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.document != null) {
            generator.writeKey("document");
            this.document.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.documents)) {
            generator.writeKey("documents");
            generator.writeStartArray();
            for (JsonData item0 : this.documents) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        generator.writeKey("field");
        generator.write(this.field);

        if (this.id != null) {
            generator.writeKey("id");
            generator.write(this.id);
        }

        if (this.index != null) {
            generator.writeKey("index");
            generator.write(this.index);
        }

        if (this.name != null) {
            generator.writeKey("name");
            generator.write(this.name);
        }

        if (this.preference != null) {
            generator.writeKey("preference");
            generator.write(this.preference);
        }

        if (this.routing != null) {
            generator.writeKey("routing");
            generator.write(this.routing);
        }

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
     * Builder for {@link PercolateQuery}.
     */
    public static class Builder extends QueryBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, PercolateQuery> {
        @Nullable
        private JsonData document;
        @Nullable
        private List<JsonData> documents;
        private String field;
        @Nullable
        private String id;
        @Nullable
        private String index;
        @Nullable
        private String name;
        @Nullable
        private String preference;
        @Nullable
        private String routing;
        @Nullable
        private Long version;

        public Builder() {}

        private Builder(PercolateQuery o) {
            super(o);
            this.document = o.document;
            this.documents = _listCopy(o.documents);
            this.field = o.field;
            this.id = o.id;
            this.index = o.index;
            this.name = o.name;
            this.preference = o.preference;
            this.routing = o.routing;
            this.version = o.version;
        }

        private Builder(Builder o) {
            super(o);
            this.document = o.document;
            this.documents = _listCopy(o.documents);
            this.field = o.field;
            this.id = o.id;
            this.index = o.index;
            this.name = o.name;
            this.preference = o.preference;
            this.routing = o.routing;
            this.version = o.version;
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
         * The source of the document being percolated.
         * <p>
         * API name: {@code document}
         * </p>
         */
        @Nonnull
        public final Builder document(@Nullable JsonData value) {
            this.document = value;
            return this;
        }

        /**
         * An array of sources of the documents being percolated.
         * <p>
         * API name: {@code documents}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>documents</code>.
         * </p>
         */
        @Nonnull
        public final Builder documents(List<JsonData> list) {
            this.documents = _listAddAll(this.documents, list);
            return this;
        }

        /**
         * An array of sources of the documents being percolated.
         * <p>
         * API name: {@code documents}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>documents</code>.
         * </p>
         */
        @Nonnull
        public final Builder documents(JsonData value, JsonData... values) {
            this.documents = _listAdd(this.documents, value, values);
            return this;
        }

        /**
         * Required - API name: {@code field}
         */
        @Nonnull
        public final Builder field(String value) {
            this.field = value;
            return this;
        }

        /**
         * API name: {@code id}
         */
        @Nonnull
        public final Builder id(@Nullable String value) {
            this.id = value;
            return this;
        }

        /**
         * API name: {@code index}
         */
        @Nonnull
        public final Builder index(@Nullable String value) {
            this.index = value;
            return this;
        }

        /**
         * The suffix used for the <code>_percolator_document_slot</code> field when multiple <code>percolate</code> queries are specified.
         * <p>
         * API name: {@code name}
         * </p>
         */
        @Nonnull
        public final Builder name(@Nullable String value) {
            this.name = value;
            return this;
        }

        /**
         * Preference used to fetch document to percolate.
         * <p>
         * API name: {@code preference}
         * </p>
         */
        @Nonnull
        public final Builder preference(@Nullable String value) {
            this.preference = value;
            return this;
        }

        /**
         * API name: {@code routing}
         */
        @Nonnull
        public final Builder routing(@Nullable String value) {
            this.routing = value;
            return this;
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
         * Builds a {@link PercolateQuery}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PercolateQuery build() {
            _checkSingleUse();

            return new PercolateQuery(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PercolateQuery}
     */
    public static final JsonpDeserializer<PercolateQuery> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PercolateQuery::setupPercolateQueryDeserializer
    );

    protected static void setupPercolateQueryDeserializer(ObjectDeserializer<PercolateQuery.Builder> op) {
        setupQueryBaseDeserializer(op);
        op.add(Builder::document, JsonData._DESERIALIZER, "document");
        op.add(Builder::documents, JsonpDeserializer.arrayDeserializer(JsonData._DESERIALIZER), "documents");
        op.add(Builder::field, JsonpDeserializer.stringDeserializer(), "field");
        op.add(Builder::id, JsonpDeserializer.stringDeserializer(), "id");
        op.add(Builder::index, JsonpDeserializer.stringDeserializer(), "index");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
        op.add(Builder::preference, JsonpDeserializer.stringDeserializer(), "preference");
        op.add(Builder::routing, JsonpDeserializer.stringDeserializer(), "routing");
        op.add(Builder::version, JsonpDeserializer.longDeserializer(), "version");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.document);
        result = 31 * result + Objects.hashCode(this.documents);
        result = 31 * result + this.field.hashCode();
        result = 31 * result + Objects.hashCode(this.id);
        result = 31 * result + Objects.hashCode(this.index);
        result = 31 * result + Objects.hashCode(this.name);
        result = 31 * result + Objects.hashCode(this.preference);
        result = 31 * result + Objects.hashCode(this.routing);
        result = 31 * result + Objects.hashCode(this.version);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PercolateQuery other = (PercolateQuery) o;
        return Objects.equals(this.document, other.document)
            && Objects.equals(this.documents, other.documents)
            && this.field.equals(other.field)
            && Objects.equals(this.id, other.id)
            && Objects.equals(this.index, other.index)
            && Objects.equals(this.name, other.name)
            && Objects.equals(this.preference, other.preference)
            && Objects.equals(this.routing, other.routing)
            && Objects.equals(this.version, other.version);
    }
}
