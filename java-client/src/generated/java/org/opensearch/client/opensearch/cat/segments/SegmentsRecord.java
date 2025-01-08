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

package org.opensearch.client.opensearch.cat.segments;

import jakarta.json.stream.JsonGenerator;
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
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: cat.segments.SegmentsRecord

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SegmentsRecord implements PlainJsonSerializable, ToCopyableBuilder<SegmentsRecord.Builder, SegmentsRecord> {

    @Nullable
    private final String committed;

    @Nullable
    private final String compound;

    @Nullable
    private final String docsCount;

    @Nullable
    private final String docsDeleted;

    @Nullable
    private final String generation;

    @Nullable
    private final String id;

    @Nullable
    private final String index;

    @Nullable
    private final String ip;

    @Nullable
    private final String prirep;

    @Nullable
    private final String searchable;

    @Nullable
    private final String segment;

    @Nullable
    private final String shard;

    @Nullable
    private final String size;

    @Nullable
    private final String sizeMemory;

    @Nullable
    private final String version;

    // ---------------------------------------------------------------------------------------------

    private SegmentsRecord(Builder builder) {
        this.committed = builder.committed;
        this.compound = builder.compound;
        this.docsCount = builder.docsCount;
        this.docsDeleted = builder.docsDeleted;
        this.generation = builder.generation;
        this.id = builder.id;
        this.index = builder.index;
        this.ip = builder.ip;
        this.prirep = builder.prirep;
        this.searchable = builder.searchable;
        this.segment = builder.segment;
        this.shard = builder.shard;
        this.size = builder.size;
        this.sizeMemory = builder.sizeMemory;
        this.version = builder.version;
    }

    public static SegmentsRecord of(Function<SegmentsRecord.Builder, ObjectBuilder<SegmentsRecord>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * If <code>true</code>, the segment is synced to disk. Segments that are synced can survive a hard reboot. If <code>false</code>, the
     * data from uncommitted segments is also stored in the transaction log so that OpenSearch is able to replay changes on the next start.
     * <p>
     * API name: {@code committed}
     * </p>
     */
    @Nullable
    public final String committed() {
        return this.committed;
    }

    /**
     * If <code>true</code>, the segment is stored in a compound file. This means Lucene merged all files from the segment in a single file
     * to save file descriptors.
     * <p>
     * API name: {@code compound}
     * </p>
     */
    @Nullable
    public final String compound() {
        return this.compound;
    }

    /**
     * The number of documents in the segment. This excludes deleted documents and counts any nested documents separately from their
     * parents. It also excludes documents which were indexed recently and do not yet belong to a segment.
     * <p>
     * API name: {@code docs.count}
     * </p>
     */
    @Nullable
    public final String docsCount() {
        return this.docsCount;
    }

    /**
     * The number of deleted documents in the segment, which might be higher or lower than the number of delete operations you have
     * performed. This number excludes deletes that were performed recently and do not yet belong to a segment. Deleted documents are
     * cleaned up by the automatic merge process if it makes sense to do so. Also, OpenSearch creates extra deleted documents to internally
     * track the recent history of operations on a shard.
     * <p>
     * API name: {@code docs.deleted}
     * </p>
     */
    @Nullable
    public final String docsDeleted() {
        return this.docsDeleted;
    }

    /**
     * The segment generation number. OpenSearch increments this generation number for each segment written then uses this number to derive
     * the segment name.
     * <p>
     * API name: {@code generation}
     * </p>
     */
    @Nullable
    public final String generation() {
        return this.generation;
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
     * The IP address of the node where it lives.
     * <p>
     * API name: {@code ip}
     * </p>
     */
    @Nullable
    public final String ip() {
        return this.ip;
    }

    /**
     * The shard type: <code>primary</code> or <code>replica</code>.
     * <p>
     * API name: {@code prirep}
     * </p>
     */
    @Nullable
    public final String prirep() {
        return this.prirep;
    }

    /**
     * If <code>true</code>, the segment is searchable. If <code>false</code>, the segment has most likely been written to disk but needs a
     * refresh to be searchable.
     * <p>
     * API name: {@code searchable}
     * </p>
     */
    @Nullable
    public final String searchable() {
        return this.searchable;
    }

    /**
     * The segment name, which is derived from the segment generation and used internally to create file names in the directory of the
     * shard.
     * <p>
     * API name: {@code segment}
     * </p>
     */
    @Nullable
    public final String segment() {
        return this.segment;
    }

    /**
     * The shard name.
     * <p>
     * API name: {@code shard}
     * </p>
     */
    @Nullable
    public final String shard() {
        return this.shard;
    }

    /**
     * API name: {@code size}
     */
    @Nullable
    public final String size() {
        return this.size;
    }

    /**
     * API name: {@code size.memory}
     */
    @Nullable
    public final String sizeMemory() {
        return this.sizeMemory;
    }

    /**
     * API name: {@code version}
     */
    @Nullable
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
        if (this.committed != null) {
            generator.writeKey("committed");
            generator.write(this.committed);
        }

        if (this.compound != null) {
            generator.writeKey("compound");
            generator.write(this.compound);
        }

        if (this.docsCount != null) {
            generator.writeKey("docs.count");
            generator.write(this.docsCount);
        }

        if (this.docsDeleted != null) {
            generator.writeKey("docs.deleted");
            generator.write(this.docsDeleted);
        }

        if (this.generation != null) {
            generator.writeKey("generation");
            generator.write(this.generation);
        }

        if (this.id != null) {
            generator.writeKey("id");
            generator.write(this.id);
        }

        if (this.index != null) {
            generator.writeKey("index");
            generator.write(this.index);
        }

        if (this.ip != null) {
            generator.writeKey("ip");
            generator.write(this.ip);
        }

        if (this.prirep != null) {
            generator.writeKey("prirep");
            generator.write(this.prirep);
        }

        if (this.searchable != null) {
            generator.writeKey("searchable");
            generator.write(this.searchable);
        }

        if (this.segment != null) {
            generator.writeKey("segment");
            generator.write(this.segment);
        }

        if (this.shard != null) {
            generator.writeKey("shard");
            generator.write(this.shard);
        }

        if (this.size != null) {
            generator.writeKey("size");
            generator.write(this.size);
        }

        if (this.sizeMemory != null) {
            generator.writeKey("size.memory");
            generator.write(this.sizeMemory);
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
     * Builder for {@link SegmentsRecord}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, SegmentsRecord> {
        @Nullable
        private String committed;
        @Nullable
        private String compound;
        @Nullable
        private String docsCount;
        @Nullable
        private String docsDeleted;
        @Nullable
        private String generation;
        @Nullable
        private String id;
        @Nullable
        private String index;
        @Nullable
        private String ip;
        @Nullable
        private String prirep;
        @Nullable
        private String searchable;
        @Nullable
        private String segment;
        @Nullable
        private String shard;
        @Nullable
        private String size;
        @Nullable
        private String sizeMemory;
        @Nullable
        private String version;

        public Builder() {}

        private Builder(SegmentsRecord o) {
            this.committed = o.committed;
            this.compound = o.compound;
            this.docsCount = o.docsCount;
            this.docsDeleted = o.docsDeleted;
            this.generation = o.generation;
            this.id = o.id;
            this.index = o.index;
            this.ip = o.ip;
            this.prirep = o.prirep;
            this.searchable = o.searchable;
            this.segment = o.segment;
            this.shard = o.shard;
            this.size = o.size;
            this.sizeMemory = o.sizeMemory;
            this.version = o.version;
        }

        private Builder(Builder o) {
            this.committed = o.committed;
            this.compound = o.compound;
            this.docsCount = o.docsCount;
            this.docsDeleted = o.docsDeleted;
            this.generation = o.generation;
            this.id = o.id;
            this.index = o.index;
            this.ip = o.ip;
            this.prirep = o.prirep;
            this.searchable = o.searchable;
            this.segment = o.segment;
            this.shard = o.shard;
            this.size = o.size;
            this.sizeMemory = o.sizeMemory;
            this.version = o.version;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * If <code>true</code>, the segment is synced to disk. Segments that are synced can survive a hard reboot. If <code>false</code>,
         * the data from uncommitted segments is also stored in the transaction log so that OpenSearch is able to replay changes on the next
         * start.
         * <p>
         * API name: {@code committed}
         * </p>
         */
        @Nonnull
        public final Builder committed(@Nullable String value) {
            this.committed = value;
            return this;
        }

        /**
         * If <code>true</code>, the segment is stored in a compound file. This means Lucene merged all files from the segment in a single
         * file to save file descriptors.
         * <p>
         * API name: {@code compound}
         * </p>
         */
        @Nonnull
        public final Builder compound(@Nullable String value) {
            this.compound = value;
            return this;
        }

        /**
         * The number of documents in the segment. This excludes deleted documents and counts any nested documents separately from their
         * parents. It also excludes documents which were indexed recently and do not yet belong to a segment.
         * <p>
         * API name: {@code docs.count}
         * </p>
         */
        @Nonnull
        public final Builder docsCount(@Nullable String value) {
            this.docsCount = value;
            return this;
        }

        /**
         * The number of deleted documents in the segment, which might be higher or lower than the number of delete operations you have
         * performed. This number excludes deletes that were performed recently and do not yet belong to a segment. Deleted documents are
         * cleaned up by the automatic merge process if it makes sense to do so. Also, OpenSearch creates extra deleted documents to
         * internally track the recent history of operations on a shard.
         * <p>
         * API name: {@code docs.deleted}
         * </p>
         */
        @Nonnull
        public final Builder docsDeleted(@Nullable String value) {
            this.docsDeleted = value;
            return this;
        }

        /**
         * The segment generation number. OpenSearch increments this generation number for each segment written then uses this number to
         * derive the segment name.
         * <p>
         * API name: {@code generation}
         * </p>
         */
        @Nonnull
        public final Builder generation(@Nullable String value) {
            this.generation = value;
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
         * The IP address of the node where it lives.
         * <p>
         * API name: {@code ip}
         * </p>
         */
        @Nonnull
        public final Builder ip(@Nullable String value) {
            this.ip = value;
            return this;
        }

        /**
         * The shard type: <code>primary</code> or <code>replica</code>.
         * <p>
         * API name: {@code prirep}
         * </p>
         */
        @Nonnull
        public final Builder prirep(@Nullable String value) {
            this.prirep = value;
            return this;
        }

        /**
         * If <code>true</code>, the segment is searchable. If <code>false</code>, the segment has most likely been written to disk but
         * needs a refresh to be searchable.
         * <p>
         * API name: {@code searchable}
         * </p>
         */
        @Nonnull
        public final Builder searchable(@Nullable String value) {
            this.searchable = value;
            return this;
        }

        /**
         * The segment name, which is derived from the segment generation and used internally to create file names in the directory of the
         * shard.
         * <p>
         * API name: {@code segment}
         * </p>
         */
        @Nonnull
        public final Builder segment(@Nullable String value) {
            this.segment = value;
            return this;
        }

        /**
         * The shard name.
         * <p>
         * API name: {@code shard}
         * </p>
         */
        @Nonnull
        public final Builder shard(@Nullable String value) {
            this.shard = value;
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
         * API name: {@code size.memory}
         */
        @Nonnull
        public final Builder sizeMemory(@Nullable String value) {
            this.sizeMemory = value;
            return this;
        }

        /**
         * API name: {@code version}
         */
        @Nonnull
        public final Builder version(@Nullable String value) {
            this.version = value;
            return this;
        }

        /**
         * Builds a {@link SegmentsRecord}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SegmentsRecord build() {
            _checkSingleUse();

            return new SegmentsRecord(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SegmentsRecord}
     */
    public static final JsonpDeserializer<SegmentsRecord> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SegmentsRecord::setupSegmentsRecordDeserializer
    );

    protected static void setupSegmentsRecordDeserializer(ObjectDeserializer<SegmentsRecord.Builder> op) {
        op.add(Builder::committed, JsonpDeserializer.stringDeserializer(), "committed");
        op.add(Builder::compound, JsonpDeserializer.stringDeserializer(), "compound");
        op.add(Builder::docsCount, JsonpDeserializer.stringDeserializer(), "docs.count");
        op.add(Builder::docsDeleted, JsonpDeserializer.stringDeserializer(), "docs.deleted");
        op.add(Builder::generation, JsonpDeserializer.stringDeserializer(), "generation");
        op.add(Builder::id, JsonpDeserializer.stringDeserializer(), "id");
        op.add(Builder::index, JsonpDeserializer.stringDeserializer(), "index");
        op.add(Builder::ip, JsonpDeserializer.stringDeserializer(), "ip");
        op.add(Builder::prirep, JsonpDeserializer.stringDeserializer(), "prirep");
        op.add(Builder::searchable, JsonpDeserializer.stringDeserializer(), "searchable");
        op.add(Builder::segment, JsonpDeserializer.stringDeserializer(), "segment");
        op.add(Builder::shard, JsonpDeserializer.stringDeserializer(), "shard");
        op.add(Builder::size, JsonpDeserializer.stringDeserializer(), "size");
        op.add(Builder::sizeMemory, JsonpDeserializer.stringDeserializer(), "size.memory");
        op.add(Builder::version, JsonpDeserializer.stringDeserializer(), "version");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.committed);
        result = 31 * result + Objects.hashCode(this.compound);
        result = 31 * result + Objects.hashCode(this.docsCount);
        result = 31 * result + Objects.hashCode(this.docsDeleted);
        result = 31 * result + Objects.hashCode(this.generation);
        result = 31 * result + Objects.hashCode(this.id);
        result = 31 * result + Objects.hashCode(this.index);
        result = 31 * result + Objects.hashCode(this.ip);
        result = 31 * result + Objects.hashCode(this.prirep);
        result = 31 * result + Objects.hashCode(this.searchable);
        result = 31 * result + Objects.hashCode(this.segment);
        result = 31 * result + Objects.hashCode(this.shard);
        result = 31 * result + Objects.hashCode(this.size);
        result = 31 * result + Objects.hashCode(this.sizeMemory);
        result = 31 * result + Objects.hashCode(this.version);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SegmentsRecord other = (SegmentsRecord) o;
        return Objects.equals(this.committed, other.committed)
            && Objects.equals(this.compound, other.compound)
            && Objects.equals(this.docsCount, other.docsCount)
            && Objects.equals(this.docsDeleted, other.docsDeleted)
            && Objects.equals(this.generation, other.generation)
            && Objects.equals(this.id, other.id)
            && Objects.equals(this.index, other.index)
            && Objects.equals(this.ip, other.ip)
            && Objects.equals(this.prirep, other.prirep)
            && Objects.equals(this.searchable, other.searchable)
            && Objects.equals(this.segment, other.segment)
            && Objects.equals(this.shard, other.shard)
            && Objects.equals(this.size, other.size)
            && Objects.equals(this.sizeMemory, other.sizeMemory)
            && Objects.equals(this.version, other.version);
    }
}
