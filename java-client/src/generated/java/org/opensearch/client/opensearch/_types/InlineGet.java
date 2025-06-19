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

package org.opensearch.client.opensearch._types;

import jakarta.json.stream.JsonGenerator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonData;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.JsonpSerializer;
import org.opensearch.client.json.JsonpUtils;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.InlineGet

/**
 * The result of an inline get operation.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class InlineGet<TDocument> implements PlainJsonSerializable, ToCopyableBuilder<InlineGet.Builder<TDocument>, InlineGet<TDocument>> {

    @Nonnull
    private final Map<String, JsonData> fields;

    private final boolean found;

    @Nonnull
    private final Map<String, JsonData> metadata;

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

    // ---------------------------------------------------------------------------------------------

    private InlineGet(Builder<TDocument> builder) {
        this.fields = ApiTypeHelper.unmodifiable(builder.fields);
        this.found = ApiTypeHelper.requireNonNull(builder.found, this, "found");
        this.metadata = ApiTypeHelper.unmodifiable(builder.metadata);
        this.primaryTerm = builder.primaryTerm;
        this.routing = builder.routing;
        this.seqNo = builder.seqNo;
        this.source = builder.source;
        this.tDocumentSerializer = builder.tDocumentSerializer;
    }

    public static <TDocument> InlineGet<TDocument> of(Function<InlineGet.Builder<TDocument>, ObjectBuilder<InlineGet<TDocument>>> fn) {
        return fn.apply(new Builder<>()).build();
    }

    /**
     * The fields retrieved from the document.
     * <p>
     * API name: {@code fields}
     * </p>
     */
    @Nonnull
    public final Map<String, JsonData> fields() {
        return this.fields;
    }

    /**
     * Required - Whether the document was found.
     * <p>
     * API name: {@code found}
     * </p>
     */
    public final boolean found() {
        return this.found;
    }

    @Nonnull
    public final Map<String, JsonData> metadata() {
        return this.metadata;
    }

    /**
     * The primary term of the document.
     * <p>
     * API name: {@code _primary_term}
     * </p>
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
     * The source of the document.
     * <p>
     * API name: {@code _source}
     * </p>
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
     * Serialize this object to JSON.
     */
    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        for (Map.Entry<String, JsonData> item0 : this.metadata.entrySet()) {
            generator.writeKey(item0.getKey());
            item0.getValue().serialize(generator, mapper);
        }
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
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    @Nonnull
    public Builder<TDocument> toBuilder() {
        return new Builder<>(this);
    }

    @Nonnull
    public static <TDocument> Builder builder() {
        return new Builder<>();
    }

    /**
     * Builder for {@link InlineGet}.
     */
    public static class Builder<TDocument> extends ObjectBuilderBase implements CopyableBuilder<Builder<TDocument>, InlineGet<TDocument>> {
        @Nullable
        private Map<String, JsonData> fields;
        private Boolean found;
        @Nullable
        private Map<String, JsonData> metadata;
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

        public Builder() {}

        private Builder(InlineGet<TDocument> o) {
            this.fields = _mapCopy(o.fields);
            this.found = o.found;
            this.metadata = _mapCopy(o.metadata);
            this.primaryTerm = o.primaryTerm;
            this.routing = o.routing;
            this.seqNo = o.seqNo;
            this.source = o.source;
            this.tDocumentSerializer = o.tDocumentSerializer;
        }

        private Builder(Builder<TDocument> o) {
            this.fields = _mapCopy(o.fields);
            this.found = o.found;
            this.metadata = _mapCopy(o.metadata);
            this.primaryTerm = o.primaryTerm;
            this.routing = o.routing;
            this.seqNo = o.seqNo;
            this.source = o.source;
            this.tDocumentSerializer = o.tDocumentSerializer;
        }

        @Override
        @Nonnull
        public Builder<TDocument> copy() {
            return new Builder<>(this);
        }

        /**
         * The fields retrieved from the document.
         * <p>
         * API name: {@code fields}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>fields</code>.
         * </p>
         */
        @Nonnull
        public final Builder<TDocument> fields(Map<String, JsonData> map) {
            this.fields = _mapPutAll(this.fields, map);
            return this;
        }

        /**
         * The fields retrieved from the document.
         * <p>
         * API name: {@code fields}
         * </p>
         *
         * <p>
         * Adds an entry to <code>fields</code>.
         * </p>
         */
        @Nonnull
        public final Builder<TDocument> fields(String key, JsonData value) {
            this.fields = _mapPut(this.fields, key, value);
            return this;
        }

        /**
         * Required - Whether the document was found.
         * <p>
         * API name: {@code found}
         * </p>
         */
        @Nonnull
        public final Builder<TDocument> found(boolean value) {
            this.found = value;
            return this;
        }

        /**
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>metadata</code>.
         * </p>
         */
        @Nonnull
        public final Builder<TDocument> metadata(Map<String, JsonData> map) {
            this.metadata = _mapPutAll(this.metadata, map);
            return this;
        }

        /**
         *
         * <p>
         * Adds an entry to <code>metadata</code>.
         * </p>
         */
        @Nonnull
        public final Builder<TDocument> metadata(String key, JsonData value) {
            this.metadata = _mapPut(this.metadata, key, value);
            return this;
        }

        /**
         * The primary term of the document.
         * <p>
         * API name: {@code _primary_term}
         * </p>
         */
        @Nonnull
        public final Builder<TDocument> primaryTerm(@Nullable Long value) {
            this.primaryTerm = value;
            return this;
        }

        /**
         * API name: {@code _routing}
         */
        @Nonnull
        public final Builder<TDocument> routing(@Nullable String value) {
            this.routing = value;
            return this;
        }

        /**
         * API name: {@code _seq_no}
         */
        @Nonnull
        public final Builder<TDocument> seqNo(@Nullable Long value) {
            this.seqNo = value;
            return this;
        }

        /**
         * The source of the document.
         * <p>
         * API name: {@code _source}
         * </p>
         */
        @Nonnull
        public final Builder<TDocument> source(@Nullable TDocument value) {
            this.source = value;
            return this;
        }

        /**
         * Serializer for {@code TDocument}. If not set, an attempt will be made to find a serializer from the JSON context.
         */
        @Nonnull
        public final Builder<TDocument> tDocumentSerializer(@Nullable JsonpSerializer<TDocument> value) {
            this.tDocumentSerializer = value;
            return this;
        }

        /**
         * Builds a {@link InlineGet}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public InlineGet<TDocument> build() {
            _checkSingleUse();

            return new InlineGet<>(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Create a JSON deserializer for InlineGet.
     */
    public static <TDocument> JsonpDeserializer<InlineGet<TDocument>> createInlineGetDeserializer(
        JsonpDeserializer<TDocument> tDocumentDeserializer
    ) {
        return ObjectBuilderDeserializer.createForObject(
            Builder<TDocument>::new,
            op -> InlineGet.setupInlineGetDeserializer(op, tDocumentDeserializer)
        );
    }

    protected static <TDocument> void setupInlineGetDeserializer(
        ObjectDeserializer<InlineGet.Builder<TDocument>> op,
        JsonpDeserializer<TDocument> tDocumentDeserializer
    ) {
        op.add(Builder::fields, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "fields");
        op.add(Builder::found, JsonpDeserializer.booleanDeserializer(), "found");
        op.add(Builder::primaryTerm, JsonpDeserializer.longDeserializer(), "_primary_term");
        op.add(Builder::routing, JsonpDeserializer.stringDeserializer(), "_routing");
        op.add(Builder::seqNo, JsonpDeserializer.longDeserializer(), "_seq_no");
        op.add(Builder::source, tDocumentDeserializer, "_source");
        op.setUnknownFieldHandler((builder, name, parser, mapper) -> {
            if (builder.metadata == null) {
                builder.metadata = new HashMap<>();
            }
            builder.metadata.put(name, JsonData._DESERIALIZER.deserialize(parser, mapper));
        });
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.fields);
        result = 31 * result + Boolean.hashCode(this.found);
        result = 31 * result + Objects.hashCode(this.metadata);
        result = 31 * result + Objects.hashCode(this.primaryTerm);
        result = 31 * result + Objects.hashCode(this.routing);
        result = 31 * result + Objects.hashCode(this.seqNo);
        result = 31 * result + Objects.hashCode(this.source);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        InlineGet<?> other = (InlineGet<?>) o;
        return Objects.equals(this.fields, other.fields)
            && this.found == other.found
            && Objects.equals(this.metadata, other.metadata)
            && Objects.equals(this.primaryTerm, other.primaryTerm)
            && Objects.equals(this.routing, other.routing)
            && Objects.equals(this.seqNo, other.seqNo)
            && Objects.equals(this.source, other.source);
    }
}
