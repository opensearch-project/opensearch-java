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

package org.opensearch.client.opensearch.core.get;

import jakarta.json.stream.JsonGenerator;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonData;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.JsonpSerializer;
import org.opensearch.client.json.JsonpUtils;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: core.get.GetResultBase

@Generated("org.opensearch.client.codegen.CodeGenerator")
public abstract class GetResultBase<TDocument> implements PlainJsonSerializable {

    @Nonnull
    private final Map<String, JsonData> fields;

    private final boolean found;

    @Nonnull
    private final String id;

    @Nonnull
    private final String index;

    @Nullable
    private final Long primaryTerm;

    @Nullable
    private final String routing;

    @Nullable
    private final Long seqNo;

    @Nullable
    private final TDocument source;

    @Nullable
    private final JsonpSerializer<TDocument> tDocumentSerializer;

    @Nullable
    private final Long version;

    // ---------------------------------------------------------------------------------------------

    protected GetResultBase(AbstractBuilder<TDocument, ?> builder) {
        this.fields = ApiTypeHelper.unmodifiable(builder.fields);
        this.found = ApiTypeHelper.requireNonNull(builder.found, this, "found");
        this.id = ApiTypeHelper.requireNonNull(builder.id, this, "id");
        this.index = ApiTypeHelper.requireNonNull(builder.index, this, "index");
        this.primaryTerm = builder.primaryTerm;
        this.routing = builder.routing;
        this.seqNo = builder.seqNo;
        this.source = builder.source;
        this.tDocumentSerializer = builder.tDocumentSerializer;
        this.version = builder.version;
    }

    /**
     * API name: {@code fields}
     */
    @Nonnull
    public final Map<String, JsonData> fields() {
        return this.fields;
    }

    /**
     * Required - API name: {@code found}
     */
    public final boolean found() {
        return this.found;
    }

    /**
     * Required - API name: {@code _id}
     */
    @Nonnull
    public final String id() {
        return this.id;
    }

    /**
     * Required - API name: {@code _index}
     */
    @Nonnull
    public final String index() {
        return this.index;
    }

    /**
     * API name: {@code _primary_term}
     */
    @Nullable
    public final Long primaryTerm() {
        return this.primaryTerm;
    }

    /**
     * API name: {@code _routing}
     */
    @Nullable
    public final String routing() {
        return this.routing;
    }

    /**
     * API name: {@code _seq_no}
     */
    @Nullable
    public final Long seqNo() {
        return this.seqNo;
    }

    /**
     * API name: {@code _source}
     */
    @Nullable
    public final TDocument source() {
        return this.source;
    }

    /**
     * Serializer for {@code TDocument}. If not set, an attempt will be made to find a serializer from the JSON context.
     */
    @Nullable
    public final JsonpSerializer<TDocument> tDocumentSerializer() {
        return this.tDocumentSerializer;
    }

    /**
     * API name: {@code _version}
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
        if (ApiTypeHelper.isDefined(this.fields)) {
            generator.writeKey("fields");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.fields.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        generator.writeKey("found");
        generator.write(this.found);

        generator.writeKey("_id");
        generator.write(this.id);

        generator.writeKey("_index");
        generator.write(this.index);

        if (this.primaryTerm != null) {
            generator.writeKey("_primary_term");
            generator.write(this.primaryTerm);
        }

        if (this.routing != null) {
            generator.writeKey("_routing");
            generator.write(this.routing);
        }

        if (this.seqNo != null) {
            generator.writeKey("_seq_no");
            generator.write(this.seqNo);
        }

        if (this.source != null) {
            generator.writeKey("_source");
            JsonpUtils.serialize(this.source, generator, tDocumentSerializer, mapper);
        }

        if (this.version != null) {
            generator.writeKey("_version");
            generator.write(this.version);
        }
    }

    // ---------------------------------------------------------------------------------------------

    public abstract static class AbstractBuilder<TDocument, BuilderT extends AbstractBuilder<TDocument, BuilderT>> extends
        ObjectBuilderBase {
        @Nullable
        private Map<String, JsonData> fields;
        private Boolean found;
        private String id;
        private String index;
        @Nullable
        private Long primaryTerm;
        @Nullable
        private String routing;
        @Nullable
        private Long seqNo;
        @Nullable
        private TDocument source;
        @Nullable
        private JsonpSerializer<TDocument> tDocumentSerializer;
        @Nullable
        private Long version;

        protected AbstractBuilder() {}

        protected AbstractBuilder(GetResultBase<TDocument> o) {
            this.fields = _mapCopy(o.fields);
            this.found = o.found;
            this.id = o.id;
            this.index = o.index;
            this.primaryTerm = o.primaryTerm;
            this.routing = o.routing;
            this.seqNo = o.seqNo;
            this.source = o.source;
            this.tDocumentSerializer = o.tDocumentSerializer;
            this.version = o.version;
        }

        protected AbstractBuilder(AbstractBuilder<TDocument, BuilderT> o) {
            this.fields = _mapCopy(o.fields);
            this.found = o.found;
            this.id = o.id;
            this.index = o.index;
            this.primaryTerm = o.primaryTerm;
            this.routing = o.routing;
            this.seqNo = o.seqNo;
            this.source = o.source;
            this.tDocumentSerializer = o.tDocumentSerializer;
            this.version = o.version;
        }

        @Nonnull
        protected abstract BuilderT self();

        /**
         * API name: {@code fields}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>fields</code>.
         * </p>
         */
        @Nonnull
        public final BuilderT fields(Map<String, JsonData> map) {
            this.fields = _mapPutAll(this.fields, map);
            return self();
        }

        /**
         * API name: {@code fields}
         *
         * <p>
         * Adds an entry to <code>fields</code>.
         * </p>
         */
        @Nonnull
        public final BuilderT fields(String key, JsonData value) {
            this.fields = _mapPut(this.fields, key, value);
            return self();
        }

        /**
         * Required - API name: {@code found}
         */
        @Nonnull
        public final BuilderT found(boolean value) {
            this.found = value;
            return self();
        }

        /**
         * Required - API name: {@code _id}
         */
        @Nonnull
        public final BuilderT id(String value) {
            this.id = value;
            return self();
        }

        /**
         * Required - API name: {@code _index}
         */
        @Nonnull
        public final BuilderT index(String value) {
            this.index = value;
            return self();
        }

        /**
         * API name: {@code _primary_term}
         */
        @Nonnull
        public final BuilderT primaryTerm(@Nullable Long value) {
            this.primaryTerm = value;
            return self();
        }

        /**
         * API name: {@code _routing}
         */
        @Nonnull
        public final BuilderT routing(@Nullable String value) {
            this.routing = value;
            return self();
        }

        /**
         * API name: {@code _seq_no}
         */
        @Nonnull
        public final BuilderT seqNo(@Nullable Long value) {
            this.seqNo = value;
            return self();
        }

        /**
         * API name: {@code _source}
         */
        @Nonnull
        public final BuilderT source(@Nullable TDocument value) {
            this.source = value;
            return self();
        }

        /**
         * Serializer for {@code TDocument}. If not set, an attempt will be made to find a serializer from the JSON context.
         */
        @Nonnull
        public final BuilderT tDocumentSerializer(@Nullable JsonpSerializer<TDocument> value) {
            this.tDocumentSerializer = value;
            return self();
        }

        /**
         * API name: {@code _version}
         */
        @Nonnull
        public final BuilderT version(@Nullable Long value) {
            this.version = value;
            return self();
        }
    }

    // ---------------------------------------------------------------------------------------------

    protected static <TDocument, BuilderT extends AbstractBuilder<TDocument, BuilderT>> void setupGetResultBaseDeserializer(
        ObjectDeserializer<BuilderT> op,
        JsonpDeserializer<TDocument> tDocumentDeserializer
    ) {
        op.add(AbstractBuilder::fields, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "fields");
        op.add(AbstractBuilder::found, JsonpDeserializer.booleanDeserializer(), "found");
        op.add(AbstractBuilder::id, JsonpDeserializer.stringDeserializer(), "_id");
        op.add(AbstractBuilder::index, JsonpDeserializer.stringDeserializer(), "_index");
        op.add(AbstractBuilder::primaryTerm, JsonpDeserializer.longDeserializer(), "_primary_term");
        op.add(AbstractBuilder::routing, JsonpDeserializer.stringDeserializer(), "_routing");
        op.add(AbstractBuilder::seqNo, JsonpDeserializer.longDeserializer(), "_seq_no");
        op.add(AbstractBuilder::source, tDocumentDeserializer, "_source");
        op.add(AbstractBuilder::version, JsonpDeserializer.longDeserializer(), "_version");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.fields);
        result = 31 * result + Boolean.hashCode(this.found);
        result = 31 * result + this.id.hashCode();
        result = 31 * result + this.index.hashCode();
        result = 31 * result + Objects.hashCode(this.primaryTerm);
        result = 31 * result + Objects.hashCode(this.routing);
        result = 31 * result + Objects.hashCode(this.seqNo);
        result = 31 * result + Objects.hashCode(this.source);
        result = 31 * result + Objects.hashCode(this.version);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetResultBase<?> other = (GetResultBase<?>) o;
        return Objects.equals(this.fields, other.fields)
            && this.found == other.found
            && this.id.equals(other.id)
            && this.index.equals(other.index)
            && Objects.equals(this.primaryTerm, other.primaryTerm)
            && Objects.equals(this.routing, other.routing)
            && Objects.equals(this.seqNo, other.seqNo)
            && Objects.equals(this.source, other.source)
            && Objects.equals(this.version, other.version);
    }
}
