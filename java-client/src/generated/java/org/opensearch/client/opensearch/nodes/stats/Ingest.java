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

package org.opensearch.client.opensearch.nodes.stats;

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

// typedef: nodes.stats.Ingest

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Ingest implements PlainJsonSerializable, ToCopyableBuilder<Ingest.Builder, Ingest> {

    @Nonnull
    private final Map<String, IngestTotal> pipelines;

    @Nullable
    private final IngestTotal total;

    // ---------------------------------------------------------------------------------------------

    private Ingest(Builder builder) {
        this.pipelines = ApiTypeHelper.unmodifiable(builder.pipelines);
        this.total = builder.total;
    }

    public static Ingest of(Function<Ingest.Builder, ObjectBuilder<Ingest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Contains statistics about ingest pipelines for the node.
     * <p>
     * API name: {@code pipelines}
     * </p>
     */
    @Nonnull
    public final Map<String, IngestTotal> pipelines() {
        return this.pipelines;
    }

    /**
     * API name: {@code total}
     */
    @Nullable
    public final IngestTotal total() {
        return this.total;
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
        if (ApiTypeHelper.isDefined(this.pipelines)) {
            generator.writeKey("pipelines");
            generator.writeStartObject();
            for (Map.Entry<String, IngestTotal> item0 : this.pipelines.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.total != null) {
            generator.writeKey("total");
            this.total.serialize(generator, mapper);
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
     * Builder for {@link Ingest}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, Ingest> {
        @Nullable
        private Map<String, IngestTotal> pipelines;
        @Nullable
        private IngestTotal total;

        public Builder() {}

        private Builder(Ingest o) {
            this.pipelines = _mapCopy(o.pipelines);
            this.total = o.total;
        }

        private Builder(Builder o) {
            this.pipelines = _mapCopy(o.pipelines);
            this.total = o.total;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Contains statistics about ingest pipelines for the node.
         * <p>
         * API name: {@code pipelines}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>pipelines</code>.
         * </p>
         */
        @Nonnull
        public final Builder pipelines(Map<String, IngestTotal> map) {
            this.pipelines = _mapPutAll(this.pipelines, map);
            return this;
        }

        /**
         * Contains statistics about ingest pipelines for the node.
         * <p>
         * API name: {@code pipelines}
         * </p>
         *
         * <p>
         * Adds an entry to <code>pipelines</code>.
         * </p>
         */
        @Nonnull
        public final Builder pipelines(String key, IngestTotal value) {
            this.pipelines = _mapPut(this.pipelines, key, value);
            return this;
        }

        /**
         * Contains statistics about ingest pipelines for the node.
         * <p>
         * API name: {@code pipelines}
         * </p>
         *
         * <p>
         * Adds a value to <code>pipelines</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder pipelines(String key, Function<IngestTotal.Builder, ObjectBuilder<IngestTotal>> fn) {
            return pipelines(key, fn.apply(new IngestTotal.Builder()).build());
        }

        /**
         * API name: {@code total}
         */
        @Nonnull
        public final Builder total(@Nullable IngestTotal value) {
            this.total = value;
            return this;
        }

        /**
         * API name: {@code total}
         */
        @Nonnull
        public final Builder total(Function<IngestTotal.Builder, ObjectBuilder<IngestTotal>> fn) {
            return total(fn.apply(new IngestTotal.Builder()).build());
        }

        /**
         * Builds a {@link Ingest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public Ingest build() {
            _checkSingleUse();

            return new Ingest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link Ingest}
     */
    public static final JsonpDeserializer<Ingest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        Ingest::setupIngestDeserializer
    );

    protected static void setupIngestDeserializer(ObjectDeserializer<Ingest.Builder> op) {
        op.add(Builder::pipelines, JsonpDeserializer.stringMapDeserializer(IngestTotal._DESERIALIZER), "pipelines");
        op.add(Builder::total, IngestTotal._DESERIALIZER, "total");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.pipelines);
        result = 31 * result + Objects.hashCode(this.total);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Ingest other = (Ingest) o;
        return Objects.equals(this.pipelines, other.pipelines) && Objects.equals(this.total, other.total);
    }
}
