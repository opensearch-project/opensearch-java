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

// typedef: ingest.simulate.DocumentSimulation

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class DocumentSimulation implements PlainJsonSerializable, ToCopyableBuilder<DocumentSimulation.Builder, DocumentSimulation> {

    @Nonnull
    private final String id;

    @Nonnull
    private final String index;

    @Nonnull
    private final Ingest ingest;

    @Nullable
    private final String routing;

    @Nonnull
    private final Map<String, JsonData> source;

    @Nullable
    private final Long version;

    @Nullable
    private final VersionType versionType;

    // ---------------------------------------------------------------------------------------------

    private DocumentSimulation(Builder builder) {
        this.id = ApiTypeHelper.requireNonNull(builder.id, this, "id");
        this.index = ApiTypeHelper.requireNonNull(builder.index, this, "index");
        this.ingest = ApiTypeHelper.requireNonNull(builder.ingest, this, "ingest");
        this.routing = builder.routing;
        this.source = ApiTypeHelper.unmodifiableRequired(builder.source, this, "source");
        this.version = builder.version;
        this.versionType = builder.versionType;
    }

    public static DocumentSimulation of(Function<DocumentSimulation.Builder, ObjectBuilder<DocumentSimulation>> fn) {
        return fn.apply(new Builder()).build();
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
     * Required - API name: {@code _ingest}
     */
    @Nonnull
    public final Ingest ingest() {
        return this.ingest;
    }

    /**
     * Value used to send the document to a specific primary shard.
     * <p>
     * API name: {@code _routing}
     * </p>
     */
    @Nullable
    public final String routing() {
        return this.routing;
    }

    /**
     * Required - JSON body for the document.
     * <p>
     * API name: {@code _source}
     * </p>
     */
    @Nonnull
    public final Map<String, JsonData> source() {
        return this.source;
    }

    /**
     * API name: {@code _version}
     */
    @Nullable
    public final Long version() {
        return this.version;
    }

    /**
     * API name: {@code _version_type}
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
        generator.writeKey("_id");
        generator.write(this.id);

        generator.writeKey("_index");
        generator.write(this.index);

        generator.writeKey("_ingest");
        this.ingest.serialize(generator, mapper);

        if (this.routing != null) {
            generator.writeKey("_routing");
            generator.write(this.routing);
        }

        generator.writeKey("_source");
        generator.writeStartObject();
        for (Map.Entry<String, JsonData> item0 : this.source.entrySet()) {
            generator.writeKey(item0.getKey());
            item0.getValue().serialize(generator, mapper);
        }
        generator.writeEnd();

        if (this.version != null) {
            generator.writeKey("_version");
            generator.write(this.version);
        }

        if (this.versionType != null) {
            generator.writeKey("_version_type");
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
     * Builder for {@link DocumentSimulation}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, DocumentSimulation> {
        private String id;
        private String index;
        private Ingest ingest;
        @Nullable
        private String routing;
        private Map<String, JsonData> source;
        @Nullable
        private Long version;
        @Nullable
        private VersionType versionType;

        public Builder() {}

        private Builder(DocumentSimulation o) {
            this.id = o.id;
            this.index = o.index;
            this.ingest = o.ingest;
            this.routing = o.routing;
            this.source = _mapCopy(o.source);
            this.version = o.version;
            this.versionType = o.versionType;
        }

        private Builder(Builder o) {
            this.id = o.id;
            this.index = o.index;
            this.ingest = o.ingest;
            this.routing = o.routing;
            this.source = _mapCopy(o.source);
            this.version = o.version;
            this.versionType = o.versionType;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
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
         * Required - API name: {@code _index}
         */
        @Nonnull
        public final Builder index(String value) {
            this.index = value;
            return this;
        }

        /**
         * Required - API name: {@code _ingest}
         */
        @Nonnull
        public final Builder ingest(Ingest value) {
            this.ingest = value;
            return this;
        }

        /**
         * Required - API name: {@code _ingest}
         */
        @Nonnull
        public final Builder ingest(Function<Ingest.Builder, ObjectBuilder<Ingest>> fn) {
            return ingest(fn.apply(new Ingest.Builder()).build());
        }

        /**
         * Value used to send the document to a specific primary shard.
         * <p>
         * API name: {@code _routing}
         * </p>
         */
        @Nonnull
        public final Builder routing(@Nullable String value) {
            this.routing = value;
            return this;
        }

        /**
         * Required - JSON body for the document.
         * <p>
         * API name: {@code _source}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>source</code>.
         * </p>
         */
        @Nonnull
        public final Builder source(Map<String, JsonData> map) {
            this.source = _mapPutAll(this.source, map);
            return this;
        }

        /**
         * Required - JSON body for the document.
         * <p>
         * API name: {@code _source}
         * </p>
         *
         * <p>
         * Adds an entry to <code>source</code>.
         * </p>
         */
        @Nonnull
        public final Builder source(String key, JsonData value) {
            this.source = _mapPut(this.source, key, value);
            return this;
        }

        /**
         * API name: {@code _version}
         */
        @Nonnull
        public final Builder version(@Nullable Long value) {
            this.version = value;
            return this;
        }

        /**
         * API name: {@code _version_type}
         */
        @Nonnull
        public final Builder versionType(@Nullable VersionType value) {
            this.versionType = value;
            return this;
        }

        /**
         * Builds a {@link DocumentSimulation}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DocumentSimulation build() {
            _checkSingleUse();

            return new DocumentSimulation(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link DocumentSimulation}
     */
    public static final JsonpDeserializer<DocumentSimulation> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        DocumentSimulation::setupDocumentSimulationDeserializer
    );

    protected static void setupDocumentSimulationDeserializer(ObjectDeserializer<DocumentSimulation.Builder> op) {
        op.add(Builder::id, JsonpDeserializer.stringDeserializer(), "_id");
        op.add(Builder::index, JsonpDeserializer.stringDeserializer(), "_index");
        op.add(Builder::ingest, Ingest._DESERIALIZER, "_ingest");
        op.add(Builder::routing, JsonpDeserializer.stringDeserializer(), "_routing");
        op.add(Builder::source, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "_source");
        op.add(Builder::version, JsonpDeserializer.longDeserializer(), "_version");
        op.add(Builder::versionType, VersionType._DESERIALIZER, "_version_type");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.id.hashCode();
        result = 31 * result + this.index.hashCode();
        result = 31 * result + this.ingest.hashCode();
        result = 31 * result + Objects.hashCode(this.routing);
        result = 31 * result + this.source.hashCode();
        result = 31 * result + Objects.hashCode(this.version);
        result = 31 * result + Objects.hashCode(this.versionType);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        DocumentSimulation other = (DocumentSimulation) o;
        return this.id.equals(other.id)
            && this.index.equals(other.index)
            && this.ingest.equals(other.ingest)
            && Objects.equals(this.routing, other.routing)
            && this.source.equals(other.source)
            && Objects.equals(this.version, other.version)
            && Objects.equals(this.versionType, other.versionType);
    }
}
