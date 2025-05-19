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

package org.opensearch.client.opensearch.indices.segments;

import jakarta.json.stream.JsonGenerator;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
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

// typedef: indices.segments.Segment

/**
 * The detailed information about a segment.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Segment implements PlainJsonSerializable, ToCopyableBuilder<Segment.Builder, Segment> {

    @Nonnull
    private final Map<String, String> attributes;

    private final boolean committed;

    private final boolean compound;

    private final int deletedDocs;

    private final int generation;

    @Nullable
    private final String memory;

    @Nullable
    private final Long memoryInBytes;

    private final int numDocs;

    private final boolean search;

    @Nullable
    private final String size;

    private final long sizeInBytes;

    @Nonnull
    private final String version;

    // ---------------------------------------------------------------------------------------------

    private Segment(Builder builder) {
        this.attributes = ApiTypeHelper.unmodifiableRequired(builder.attributes, this, "attributes");
        this.committed = ApiTypeHelper.requireNonNull(builder.committed, this, "committed");
        this.compound = ApiTypeHelper.requireNonNull(builder.compound, this, "compound");
        this.deletedDocs = ApiTypeHelper.requireNonNull(builder.deletedDocs, this, "deletedDocs");
        this.generation = ApiTypeHelper.requireNonNull(builder.generation, this, "generation");
        this.memory = builder.memory;
        this.memoryInBytes = builder.memoryInBytes;
        this.numDocs = ApiTypeHelper.requireNonNull(builder.numDocs, this, "numDocs");
        this.search = ApiTypeHelper.requireNonNull(builder.search, this, "search");
        this.size = builder.size;
        this.sizeInBytes = ApiTypeHelper.requireNonNull(builder.sizeInBytes, this, "sizeInBytes");
        this.version = ApiTypeHelper.requireNonNull(builder.version, this, "version");
    }

    public static Segment of(Function<Segment.Builder, ObjectBuilder<Segment>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The attributes of the segment.
     * <p>
     * API name: {@code attributes}
     * </p>
     */
    @Nonnull
    public final Map<String, String> attributes() {
        return this.attributes;
    }

    /**
     * Required - Whether the segment is committed.
     * <p>
     * API name: {@code committed}
     * </p>
     */
    public final boolean committed() {
        return this.committed;
    }

    /**
     * Required - Whether the segment is compound.
     * <p>
     * API name: {@code compound}
     * </p>
     */
    public final boolean compound() {
        return this.compound;
    }

    /**
     * Required - The number of deleted documents in the segment.
     * <p>
     * API name: {@code deleted_docs}
     * </p>
     */
    public final int deletedDocs() {
        return this.deletedDocs;
    }

    /**
     * Required - The generation number of the segment.
     * <p>
     * API name: {@code generation}
     * </p>
     */
    public final int generation() {
        return this.generation;
    }

    /**
     * API name: {@code memory}
     */
    @Nullable
    public final String memory() {
        return this.memory;
    }

    /**
     * API name: {@code memory_in_bytes}
     */
    @Nullable
    public final Long memoryInBytes() {
        return this.memoryInBytes;
    }

    /**
     * Required - The number of documents in the segment.
     * <p>
     * API name: {@code num_docs}
     * </p>
     */
    public final int numDocs() {
        return this.numDocs;
    }

    /**
     * Required - Whether the segment is searchable.
     * <p>
     * API name: {@code search}
     * </p>
     */
    public final boolean search() {
        return this.search;
    }

    /**
     * API name: {@code size}
     */
    @Nullable
    public final String size() {
        return this.size;
    }

    /**
     * Required - API name: {@code size_in_bytes}
     */
    public final long sizeInBytes() {
        return this.sizeInBytes;
    }

    /**
     * Required - API name: {@code version}
     */
    @Nonnull
    public final String version() {
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
        generator.writeKey("attributes");
        generator.writeStartObject();
        for (Map.Entry<String, String> item0 : this.attributes.entrySet()) {
            generator.writeKey(item0.getKey());
            generator.write(item0.getValue());
        }
        generator.writeEnd();

        generator.writeKey("committed");
        generator.write(this.committed);

        generator.writeKey("compound");
        generator.write(this.compound);

        generator.writeKey("deleted_docs");
        generator.write(this.deletedDocs);

        generator.writeKey("generation");
        generator.write(this.generation);

        if (this.memory != null) {
            generator.writeKey("memory");
            generator.write(this.memory);
        }

        if (this.memoryInBytes != null) {
            generator.writeKey("memory_in_bytes");
            generator.write(this.memoryInBytes);
        }

        generator.writeKey("num_docs");
        generator.write(this.numDocs);

        generator.writeKey("search");
        generator.write(this.search);

        if (this.size != null) {
            generator.writeKey("size");
            generator.write(this.size);
        }

        generator.writeKey("size_in_bytes");
        generator.write(this.sizeInBytes);

        generator.writeKey("version");
        generator.write(this.version);
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
     * Builder for {@link Segment}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, Segment> {
        private Map<String, String> attributes;
        private Boolean committed;
        private Boolean compound;
        private Integer deletedDocs;
        private Integer generation;
        @Nullable
        private String memory;
        @Nullable
        private Long memoryInBytes;
        private Integer numDocs;
        private Boolean search;
        @Nullable
        private String size;
        private Long sizeInBytes;
        private String version;

        public Builder() {}

        private Builder(Segment o) {
            this.attributes = _mapCopy(o.attributes);
            this.committed = o.committed;
            this.compound = o.compound;
            this.deletedDocs = o.deletedDocs;
            this.generation = o.generation;
            this.memory = o.memory;
            this.memoryInBytes = o.memoryInBytes;
            this.numDocs = o.numDocs;
            this.search = o.search;
            this.size = o.size;
            this.sizeInBytes = o.sizeInBytes;
            this.version = o.version;
        }

        private Builder(Builder o) {
            this.attributes = _mapCopy(o.attributes);
            this.committed = o.committed;
            this.compound = o.compound;
            this.deletedDocs = o.deletedDocs;
            this.generation = o.generation;
            this.memory = o.memory;
            this.memoryInBytes = o.memoryInBytes;
            this.numDocs = o.numDocs;
            this.search = o.search;
            this.size = o.size;
            this.sizeInBytes = o.sizeInBytes;
            this.version = o.version;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - The attributes of the segment.
         * <p>
         * API name: {@code attributes}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>attributes</code>.
         * </p>
         */
        @Nonnull
        public final Builder attributes(Map<String, String> map) {
            this.attributes = _mapPutAll(this.attributes, map);
            return this;
        }

        /**
         * Required - The attributes of the segment.
         * <p>
         * API name: {@code attributes}
         * </p>
         *
         * <p>
         * Adds an entry to <code>attributes</code>.
         * </p>
         */
        @Nonnull
        public final Builder attributes(String key, String value) {
            this.attributes = _mapPut(this.attributes, key, value);
            return this;
        }

        /**
         * Required - Whether the segment is committed.
         * <p>
         * API name: {@code committed}
         * </p>
         */
        @Nonnull
        public final Builder committed(boolean value) {
            this.committed = value;
            return this;
        }

        /**
         * Required - Whether the segment is compound.
         * <p>
         * API name: {@code compound}
         * </p>
         */
        @Nonnull
        public final Builder compound(boolean value) {
            this.compound = value;
            return this;
        }

        /**
         * Required - The number of deleted documents in the segment.
         * <p>
         * API name: {@code deleted_docs}
         * </p>
         */
        @Nonnull
        public final Builder deletedDocs(int value) {
            this.deletedDocs = value;
            return this;
        }

        /**
         * Required - The generation number of the segment.
         * <p>
         * API name: {@code generation}
         * </p>
         */
        @Nonnull
        public final Builder generation(int value) {
            this.generation = value;
            return this;
        }

        /**
         * API name: {@code memory}
         */
        @Nonnull
        public final Builder memory(@Nullable String value) {
            this.memory = value;
            return this;
        }

        /**
         * API name: {@code memory_in_bytes}
         */
        @Nonnull
        public final Builder memoryInBytes(@Nullable Long value) {
            this.memoryInBytes = value;
            return this;
        }

        /**
         * Required - The number of documents in the segment.
         * <p>
         * API name: {@code num_docs}
         * </p>
         */
        @Nonnull
        public final Builder numDocs(int value) {
            this.numDocs = value;
            return this;
        }

        /**
         * Required - Whether the segment is searchable.
         * <p>
         * API name: {@code search}
         * </p>
         */
        @Nonnull
        public final Builder search(boolean value) {
            this.search = value;
            return this;
        }

        /**
         * API name: {@code size}
         */
        @Nonnull
        public final Builder size(@Nullable String value) {
            this.size = value;
            return this;
        }

        /**
         * Required - API name: {@code size_in_bytes}
         */
        @Nonnull
        public final Builder sizeInBytes(long value) {
            this.sizeInBytes = value;
            return this;
        }

        /**
         * Required - API name: {@code version}
         */
        @Nonnull
        public final Builder version(String value) {
            this.version = value;
            return this;
        }

        /**
         * Builds a {@link Segment}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public Segment build() {
            _checkSingleUse();

            return new Segment(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link Segment}
     */
    public static final JsonpDeserializer<Segment> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        Segment::setupSegmentDeserializer
    );

    protected static void setupSegmentDeserializer(ObjectDeserializer<Segment.Builder> op) {
        op.add(Builder::attributes, JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.stringDeserializer()), "attributes");
        op.add(Builder::committed, JsonpDeserializer.booleanDeserializer(), "committed");
        op.add(Builder::compound, JsonpDeserializer.booleanDeserializer(), "compound");
        op.add(Builder::deletedDocs, JsonpDeserializer.integerDeserializer(), "deleted_docs");
        op.add(Builder::generation, JsonpDeserializer.integerDeserializer(), "generation");
        op.add(Builder::memory, JsonpDeserializer.stringDeserializer(), "memory");
        op.add(Builder::memoryInBytes, JsonpDeserializer.longDeserializer(), "memory_in_bytes");
        op.add(Builder::numDocs, JsonpDeserializer.integerDeserializer(), "num_docs");
        op.add(Builder::search, JsonpDeserializer.booleanDeserializer(), "search");
        op.add(Builder::size, JsonpDeserializer.stringDeserializer(), "size");
        op.add(Builder::sizeInBytes, JsonpDeserializer.longDeserializer(), "size_in_bytes");
        op.add(Builder::version, JsonpDeserializer.stringDeserializer(), "version");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.attributes.hashCode();
        result = 31 * result + Boolean.hashCode(this.committed);
        result = 31 * result + Boolean.hashCode(this.compound);
        result = 31 * result + Integer.hashCode(this.deletedDocs);
        result = 31 * result + Integer.hashCode(this.generation);
        result = 31 * result + Objects.hashCode(this.memory);
        result = 31 * result + Objects.hashCode(this.memoryInBytes);
        result = 31 * result + Integer.hashCode(this.numDocs);
        result = 31 * result + Boolean.hashCode(this.search);
        result = 31 * result + Objects.hashCode(this.size);
        result = 31 * result + Long.hashCode(this.sizeInBytes);
        result = 31 * result + this.version.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Segment other = (Segment) o;
        return this.attributes.equals(other.attributes)
            && this.committed == other.committed
            && this.compound == other.compound
            && this.deletedDocs == other.deletedDocs
            && this.generation == other.generation
            && Objects.equals(this.memory, other.memory)
            && Objects.equals(this.memoryInBytes, other.memoryInBytes)
            && this.numDocs == other.numDocs
            && this.search == other.search
            && Objects.equals(this.size, other.size)
            && this.sizeInBytes == other.sizeInBytes
            && this.version.equals(other.version);
    }
}
