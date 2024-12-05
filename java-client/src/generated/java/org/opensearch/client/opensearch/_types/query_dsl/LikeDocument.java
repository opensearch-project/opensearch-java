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
import org.opensearch.client.opensearch._types.VersionType;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.query_dsl.LikeDocument

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class LikeDocument implements PlainJsonSerializable, ToCopyableBuilder<LikeDocument.Builder, LikeDocument> {

    @Nullable
    private final JsonData doc;

    @Nonnull
    private final List<String> fields;

    @Nullable
    private final String id;

    @Nullable
    private final String index;

    @Nonnull
    private final Map<String, String> perFieldAnalyzer;

    @Nullable
    private final String routing;

    @Nullable
    private final Long version;

    @Nullable
    private final VersionType versionType;

    // ---------------------------------------------------------------------------------------------

    private LikeDocument(Builder builder) {
        this.doc = builder.doc;
        this.fields = ApiTypeHelper.unmodifiable(builder.fields);
        this.id = builder.id;
        this.index = builder.index;
        this.perFieldAnalyzer = ApiTypeHelper.unmodifiable(builder.perFieldAnalyzer);
        this.routing = builder.routing;
        this.version = builder.version;
        this.versionType = builder.versionType;
    }

    public static LikeDocument of(Function<LikeDocument.Builder, ObjectBuilder<LikeDocument>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * A document not present in the index.
     * <p>
     * API name: {@code doc}
     * </p>
     */
    @Nullable
    public final JsonData doc() {
        return this.doc;
    }

    /**
     * API name: {@code fields}
     */
    @Nonnull
    public final List<String> fields() {
        return this.fields;
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
     * API name: {@code per_field_analyzer}
     */
    @Nonnull
    public final Map<String, String> perFieldAnalyzer() {
        return this.perFieldAnalyzer;
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

    /**
     * API name: {@code version_type}
     */
    @Nullable
    public final VersionType versionType() {
        return this.versionType;
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
        if (this.doc != null) {
            generator.writeKey("doc");
            this.doc.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.fields)) {
            generator.writeKey("fields");
            generator.writeStartArray();
            for (String item0 : this.fields) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.id != null) {
            generator.writeKey("_id");
            generator.write(this.id);
        }

        if (this.index != null) {
            generator.writeKey("_index");
            generator.write(this.index);
        }

        if (ApiTypeHelper.isDefined(this.perFieldAnalyzer)) {
            generator.writeKey("per_field_analyzer");
            generator.writeStartObject();
            for (Map.Entry<String, String> item0 : this.perFieldAnalyzer.entrySet()) {
                generator.writeKey(item0.getKey());
                generator.write(item0.getValue());
            }
            generator.writeEnd();
        }

        if (this.routing != null) {
            generator.writeKey("routing");
            generator.write(this.routing);
        }

        if (this.version != null) {
            generator.writeKey("version");
            generator.write(this.version);
        }

        if (this.versionType != null) {
            generator.writeKey("version_type");
            this.versionType.serialize(generator, mapper);
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
     * Builder for {@link LikeDocument}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, LikeDocument> {
        @Nullable
        private JsonData doc;
        @Nullable
        private List<String> fields;
        @Nullable
        private String id;
        @Nullable
        private String index;
        @Nullable
        private Map<String, String> perFieldAnalyzer;
        @Nullable
        private String routing;
        @Nullable
        private Long version;
        @Nullable
        private VersionType versionType;

        public Builder() {}

        private Builder(LikeDocument o) {
            this.doc = o.doc;
            this.fields = _listCopy(o.fields);
            this.id = o.id;
            this.index = o.index;
            this.perFieldAnalyzer = _mapCopy(o.perFieldAnalyzer);
            this.routing = o.routing;
            this.version = o.version;
            this.versionType = o.versionType;
        }

        private Builder(Builder o) {
            this.doc = o.doc;
            this.fields = _listCopy(o.fields);
            this.id = o.id;
            this.index = o.index;
            this.perFieldAnalyzer = _mapCopy(o.perFieldAnalyzer);
            this.routing = o.routing;
            this.version = o.version;
            this.versionType = o.versionType;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * A document not present in the index.
         * <p>
         * API name: {@code doc}
         * </p>
         */
        @Nonnull
        public final Builder doc(@Nullable JsonData value) {
            this.doc = value;
            return this;
        }

        /**
         * API name: {@code fields}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>fields</code>.
         * </p>
         */
        @Nonnull
        public final Builder fields(List<String> list) {
            this.fields = _listAddAll(this.fields, list);
            return this;
        }

        /**
         * API name: {@code fields}
         *
         * <p>
         * Adds one or more values to <code>fields</code>.
         * </p>
         */
        @Nonnull
        public final Builder fields(String value, String... values) {
            this.fields = _listAdd(this.fields, value, values);
            return this;
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
         * API name: {@code per_field_analyzer}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>perFieldAnalyzer</code>.
         * </p>
         */
        @Nonnull
        public final Builder perFieldAnalyzer(Map<String, String> map) {
            this.perFieldAnalyzer = _mapPutAll(this.perFieldAnalyzer, map);
            return this;
        }

        /**
         * API name: {@code per_field_analyzer}
         *
         * <p>
         * Adds an entry to <code>perFieldAnalyzer</code>.
         * </p>
         */
        @Nonnull
        public final Builder perFieldAnalyzer(String key, String value) {
            this.perFieldAnalyzer = _mapPut(this.perFieldAnalyzer, key, value);
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
         * API name: {@code version_type}
         */
        @Nonnull
        public final Builder versionType(@Nullable VersionType value) {
            this.versionType = value;
            return this;
        }

        /**
         * Builds a {@link LikeDocument}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public LikeDocument build() {
            _checkSingleUse();

            return new LikeDocument(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link LikeDocument}
     */
    public static final JsonpDeserializer<LikeDocument> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        LikeDocument::setupLikeDocumentDeserializer
    );

    protected static void setupLikeDocumentDeserializer(ObjectDeserializer<LikeDocument.Builder> op) {
        op.add(Builder::doc, JsonData._DESERIALIZER, "doc");
        op.add(Builder::fields, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "fields");
        op.add(Builder::id, JsonpDeserializer.stringDeserializer(), "_id");
        op.add(Builder::index, JsonpDeserializer.stringDeserializer(), "_index");
        op.add(
            Builder::perFieldAnalyzer,
            JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.stringDeserializer()),
            "per_field_analyzer"
        );
        op.add(Builder::routing, JsonpDeserializer.stringDeserializer(), "routing");
        op.add(Builder::version, JsonpDeserializer.longDeserializer(), "version");
        op.add(Builder::versionType, VersionType._DESERIALIZER, "version_type");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.doc);
        result = 31 * result + Objects.hashCode(this.fields);
        result = 31 * result + Objects.hashCode(this.id);
        result = 31 * result + Objects.hashCode(this.index);
        result = 31 * result + Objects.hashCode(this.perFieldAnalyzer);
        result = 31 * result + Objects.hashCode(this.routing);
        result = 31 * result + Objects.hashCode(this.version);
        result = 31 * result + Objects.hashCode(this.versionType);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        LikeDocument other = (LikeDocument) o;
        return Objects.equals(this.doc, other.doc)
            && Objects.equals(this.fields, other.fields)
            && Objects.equals(this.id, other.id)
            && Objects.equals(this.index, other.index)
            && Objects.equals(this.perFieldAnalyzer, other.perFieldAnalyzer)
            && Objects.equals(this.routing, other.routing)
            && Objects.equals(this.version, other.version)
            && Objects.equals(this.versionType, other.versionType);
    }
}
