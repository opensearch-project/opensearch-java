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

package org.opensearch.client.opensearch.core.mtermvectors;

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
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.opensearch._types.VersionType;
import org.opensearch.client.opensearch.core.termvectors.Filter;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: core.mtermvectors.Operation

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class MultiTermVectorsOperation
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<MultiTermVectorsOperation.Builder, MultiTermVectorsOperation> {

    @Nullable
    private final JsonData doc;

    @Nullable
    private final Boolean fieldStatistics;

    @Nonnull
    private final List<String> fields;

    @Nullable
    private final Filter filter;

    @Nonnull
    private final String id;

    @Nullable
    private final String index;

    @Nullable
    private final Boolean offsets;

    @Nullable
    private final Boolean payloads;

    @Nullable
    private final Boolean positions;

    @Nullable
    private final String routing;

    @Nullable
    private final Boolean termStatistics;

    @Nullable
    private final Long version;

    @Nullable
    private final VersionType versionType;

    // ---------------------------------------------------------------------------------------------

    private MultiTermVectorsOperation(Builder builder) {
        this.doc = builder.doc;
        this.fieldStatistics = builder.fieldStatistics;
        this.fields = ApiTypeHelper.unmodifiable(builder.fields);
        this.filter = builder.filter;
        this.id = ApiTypeHelper.requireNonNull(builder.id, this, "id");
        this.index = builder.index;
        this.offsets = builder.offsets;
        this.payloads = builder.payloads;
        this.positions = builder.positions;
        this.routing = builder.routing;
        this.termStatistics = builder.termStatistics;
        this.version = builder.version;
        this.versionType = builder.versionType;
    }

    public static MultiTermVectorsOperation of(Function<MultiTermVectorsOperation.Builder, ObjectBuilder<MultiTermVectorsOperation>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * An artificial document for which you want to retrieve term vectors.
     * <p>
     * API name: {@code doc}
     * </p>
     */
    @Nullable
    public final JsonData doc() {
        return this.doc;
    }

    /**
     * When <code>true</code>, the response includes the document count, the sum of the document frequencies, and the sum of the term
     * frequencies.
     * <p>
     * API name: {@code field_statistics}
     * </p>
     */
    @Nullable
    public final Boolean fieldStatistics() {
        return this.fieldStatistics;
    }

    /**
     * API name: {@code fields}
     */
    @Nonnull
    public final List<String> fields() {
        return this.fields;
    }

    /**
     * API name: {@code filter}
     */
    @Nullable
    public final Filter filter() {
        return this.filter;
    }

    /**
     * Required - API name: {@code _id}
     */
    @Nonnull
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
     * When <code>true</code>, the response includes the term offsets.
     * <p>
     * API name: {@code offsets}
     * </p>
     */
    @Nullable
    public final Boolean offsets() {
        return this.offsets;
    }

    /**
     * When <code>true</code>, the response includes the term payloads.
     * <p>
     * API name: {@code payloads}
     * </p>
     */
    @Nullable
    public final Boolean payloads() {
        return this.payloads;
    }

    /**
     * When <code>true</code>, the response includes the term positions.
     * <p>
     * API name: {@code positions}
     * </p>
     */
    @Nullable
    public final Boolean positions() {
        return this.positions;
    }

    /**
     * API name: {@code routing}
     */
    @Nullable
    public final String routing() {
        return this.routing;
    }

    /**
     * When <code>true</code>, the response includes the term frequency and the document frequency.
     * <p>
     * API name: {@code term_statistics}
     * </p>
     */
    @Nullable
    public final Boolean termStatistics() {
        return this.termStatistics;
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

        if (this.fieldStatistics != null) {
            generator.writeKey("field_statistics");
            generator.write(this.fieldStatistics);
        }

        if (ApiTypeHelper.isDefined(this.fields)) {
            generator.writeKey("fields");
            generator.writeStartArray();
            for (String item0 : this.fields) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.filter != null) {
            generator.writeKey("filter");
            this.filter.serialize(generator, mapper);
        }

        generator.writeKey("_id");
        generator.write(this.id);

        if (this.index != null) {
            generator.writeKey("_index");
            generator.write(this.index);
        }

        if (this.offsets != null) {
            generator.writeKey("offsets");
            generator.write(this.offsets);
        }

        if (this.payloads != null) {
            generator.writeKey("payloads");
            generator.write(this.payloads);
        }

        if (this.positions != null) {
            generator.writeKey("positions");
            generator.write(this.positions);
        }

        if (this.routing != null) {
            generator.writeKey("routing");
            generator.write(this.routing);
        }

        if (this.termStatistics != null) {
            generator.writeKey("term_statistics");
            generator.write(this.termStatistics);
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
     * Builder for {@link MultiTermVectorsOperation}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, MultiTermVectorsOperation> {
        @Nullable
        private JsonData doc;
        @Nullable
        private Boolean fieldStatistics;
        @Nullable
        private List<String> fields;
        @Nullable
        private Filter filter;
        private String id;
        @Nullable
        private String index;
        @Nullable
        private Boolean offsets;
        @Nullable
        private Boolean payloads;
        @Nullable
        private Boolean positions;
        @Nullable
        private String routing;
        @Nullable
        private Boolean termStatistics;
        @Nullable
        private Long version;
        @Nullable
        private VersionType versionType;

        public Builder() {}

        private Builder(MultiTermVectorsOperation o) {
            this.doc = o.doc;
            this.fieldStatistics = o.fieldStatistics;
            this.fields = _listCopy(o.fields);
            this.filter = o.filter;
            this.id = o.id;
            this.index = o.index;
            this.offsets = o.offsets;
            this.payloads = o.payloads;
            this.positions = o.positions;
            this.routing = o.routing;
            this.termStatistics = o.termStatistics;
            this.version = o.version;
            this.versionType = o.versionType;
        }

        private Builder(Builder o) {
            this.doc = o.doc;
            this.fieldStatistics = o.fieldStatistics;
            this.fields = _listCopy(o.fields);
            this.filter = o.filter;
            this.id = o.id;
            this.index = o.index;
            this.offsets = o.offsets;
            this.payloads = o.payloads;
            this.positions = o.positions;
            this.routing = o.routing;
            this.termStatistics = o.termStatistics;
            this.version = o.version;
            this.versionType = o.versionType;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * An artificial document for which you want to retrieve term vectors.
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
         * When <code>true</code>, the response includes the document count, the sum of the document frequencies, and the sum of the term
         * frequencies.
         * <p>
         * API name: {@code field_statistics}
         * </p>
         */
        @Nonnull
        public final Builder fieldStatistics(@Nullable Boolean value) {
            this.fieldStatistics = value;
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
         * API name: {@code filter}
         */
        @Nonnull
        public final Builder filter(@Nullable Filter value) {
            this.filter = value;
            return this;
        }

        /**
         * API name: {@code filter}
         */
        @Nonnull
        public final Builder filter(Function<Filter.Builder, ObjectBuilder<Filter>> fn) {
            return filter(fn.apply(new Filter.Builder()).build());
        }

        /**
         * Required - API name: {@code _id}
         */
        @Nonnull
        public final Builder id(String value) {
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
         * When <code>true</code>, the response includes the term offsets.
         * <p>
         * API name: {@code offsets}
         * </p>
         */
        @Nonnull
        public final Builder offsets(@Nullable Boolean value) {
            this.offsets = value;
            return this;
        }

        /**
         * When <code>true</code>, the response includes the term payloads.
         * <p>
         * API name: {@code payloads}
         * </p>
         */
        @Nonnull
        public final Builder payloads(@Nullable Boolean value) {
            this.payloads = value;
            return this;
        }

        /**
         * When <code>true</code>, the response includes the term positions.
         * <p>
         * API name: {@code positions}
         * </p>
         */
        @Nonnull
        public final Builder positions(@Nullable Boolean value) {
            this.positions = value;
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
         * When <code>true</code>, the response includes the term frequency and the document frequency.
         * <p>
         * API name: {@code term_statistics}
         * </p>
         */
        @Nonnull
        public final Builder termStatistics(@Nullable Boolean value) {
            this.termStatistics = value;
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
         * Builds a {@link MultiTermVectorsOperation}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public MultiTermVectorsOperation build() {
            _checkSingleUse();

            return new MultiTermVectorsOperation(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link MultiTermVectorsOperation}
     */
    public static final JsonpDeserializer<MultiTermVectorsOperation> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        MultiTermVectorsOperation::setupMultiTermVectorsOperationDeserializer
    );

    protected static void setupMultiTermVectorsOperationDeserializer(ObjectDeserializer<MultiTermVectorsOperation.Builder> op) {
        op.add(Builder::doc, JsonData._DESERIALIZER, "doc");
        op.add(Builder::fieldStatistics, JsonpDeserializer.booleanDeserializer(), "field_statistics");
        op.add(Builder::fields, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "fields");
        op.add(Builder::filter, Filter._DESERIALIZER, "filter");
        op.add(Builder::id, JsonpDeserializer.stringDeserializer(), "_id");
        op.add(Builder::index, JsonpDeserializer.stringDeserializer(), "_index");
        op.add(Builder::offsets, JsonpDeserializer.booleanDeserializer(), "offsets");
        op.add(Builder::payloads, JsonpDeserializer.booleanDeserializer(), "payloads");
        op.add(Builder::positions, JsonpDeserializer.booleanDeserializer(), "positions");
        op.add(Builder::routing, JsonpDeserializer.stringDeserializer(), "routing");
        op.add(Builder::termStatistics, JsonpDeserializer.booleanDeserializer(), "term_statistics");
        op.add(Builder::version, JsonpDeserializer.longDeserializer(), "version");
        op.add(Builder::versionType, VersionType._DESERIALIZER, "version_type");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.doc);
        result = 31 * result + Objects.hashCode(this.fieldStatistics);
        result = 31 * result + Objects.hashCode(this.fields);
        result = 31 * result + Objects.hashCode(this.filter);
        result = 31 * result + this.id.hashCode();
        result = 31 * result + Objects.hashCode(this.index);
        result = 31 * result + Objects.hashCode(this.offsets);
        result = 31 * result + Objects.hashCode(this.payloads);
        result = 31 * result + Objects.hashCode(this.positions);
        result = 31 * result + Objects.hashCode(this.routing);
        result = 31 * result + Objects.hashCode(this.termStatistics);
        result = 31 * result + Objects.hashCode(this.version);
        result = 31 * result + Objects.hashCode(this.versionType);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        MultiTermVectorsOperation other = (MultiTermVectorsOperation) o;
        return Objects.equals(this.doc, other.doc)
            && Objects.equals(this.fieldStatistics, other.fieldStatistics)
            && Objects.equals(this.fields, other.fields)
            && Objects.equals(this.filter, other.filter)
            && this.id.equals(other.id)
            && Objects.equals(this.index, other.index)
            && Objects.equals(this.offsets, other.offsets)
            && Objects.equals(this.payloads, other.payloads)
            && Objects.equals(this.positions, other.positions)
            && Objects.equals(this.routing, other.routing)
            && Objects.equals(this.termStatistics, other.termStatistics)
            && Objects.equals(this.version, other.version)
            && Objects.equals(this.versionType, other.versionType);
    }
}
