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

package org.opensearch.client.opensearch.ingest;

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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ingest.Pipeline

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Pipeline implements PlainJsonSerializable, ToCopyableBuilder<Pipeline.Builder, Pipeline> {

    @Nullable
    private final String description;

    @Nonnull
    private final Map<String, JsonData> meta;

    @Nonnull
    private final List<Processor> onFailure;

    @Nonnull
    private final List<Processor> processors;

    @Nullable
    private final Long version;

    // ---------------------------------------------------------------------------------------------

    private Pipeline(Builder builder) {
        this.description = builder.description;
        this.meta = ApiTypeHelper.unmodifiable(builder.meta);
        this.onFailure = ApiTypeHelper.unmodifiable(builder.onFailure);
        this.processors = ApiTypeHelper.unmodifiable(builder.processors);
        this.version = builder.version;
    }

    public static Pipeline of(Function<Pipeline.Builder, ObjectBuilder<Pipeline>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Description of the ingest pipeline.
     * <p>
     * API name: {@code description}
     * </p>
     */
    @Nullable
    public final String description() {
        return this.description;
    }

    /**
     * API name: {@code _meta}
     */
    @Nonnull
    public final Map<String, JsonData> meta() {
        return this.meta;
    }

    /**
     * Processors to run immediately after a processor failure.
     * <p>
     * API name: {@code on_failure}
     * </p>
     */
    @Nonnull
    public final List<Processor> onFailure() {
        return this.onFailure;
    }

    /**
     * Processors used to perform transformations on documents before indexing. Processors run sequentially in the order specified.
     * <p>
     * API name: {@code processors}
     * </p>
     */
    @Nonnull
    public final List<Processor> processors() {
        return this.processors;
    }

    /**
     * API name: {@code version}
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
        if (this.description != null) {
            generator.writeKey("description");
            generator.write(this.description);
        }

        if (ApiTypeHelper.isDefined(this.meta)) {
            generator.writeKey("_meta");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.meta.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.onFailure)) {
            generator.writeKey("on_failure");
            generator.writeStartArray();
            for (Processor item0 : this.onFailure) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.processors)) {
            generator.writeKey("processors");
            generator.writeStartArray();
            for (Processor item0 : this.processors) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
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
     * Builder for {@link Pipeline}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, Pipeline> {
        @Nullable
        private String description;
        @Nullable
        private Map<String, JsonData> meta;
        @Nullable
        private List<Processor> onFailure;
        @Nullable
        private List<Processor> processors;
        @Nullable
        private Long version;

        public Builder() {}

        private Builder(Pipeline o) {
            this.description = o.description;
            this.meta = _mapCopy(o.meta);
            this.onFailure = _listCopy(o.onFailure);
            this.processors = _listCopy(o.processors);
            this.version = o.version;
        }

        private Builder(Builder o) {
            this.description = o.description;
            this.meta = _mapCopy(o.meta);
            this.onFailure = _listCopy(o.onFailure);
            this.processors = _listCopy(o.processors);
            this.version = o.version;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Description of the ingest pipeline.
         * <p>
         * API name: {@code description}
         * </p>
         */
        @Nonnull
        public final Builder description(@Nullable String value) {
            this.description = value;
            return this;
        }

        /**
         * API name: {@code _meta}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>meta</code>.
         * </p>
         */
        @Nonnull
        public final Builder meta(Map<String, JsonData> map) {
            this.meta = _mapPutAll(this.meta, map);
            return this;
        }

        /**
         * API name: {@code _meta}
         *
         * <p>
         * Adds an entry to <code>meta</code>.
         * </p>
         */
        @Nonnull
        public final Builder meta(String key, JsonData value) {
            this.meta = _mapPut(this.meta, key, value);
            return this;
        }

        /**
         * Processors to run immediately after a processor failure.
         * <p>
         * API name: {@code on_failure}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>onFailure</code>.
         * </p>
         */
        @Nonnull
        public final Builder onFailure(List<Processor> list) {
            this.onFailure = _listAddAll(this.onFailure, list);
            return this;
        }

        /**
         * Processors to run immediately after a processor failure.
         * <p>
         * API name: {@code on_failure}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>onFailure</code>.
         * </p>
         */
        @Nonnull
        public final Builder onFailure(Processor value, Processor... values) {
            this.onFailure = _listAdd(this.onFailure, value, values);
            return this;
        }

        /**
         * Processors to run immediately after a processor failure.
         * <p>
         * API name: {@code on_failure}
         * </p>
         *
         * <p>
         * Adds a value to <code>onFailure</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder onFailure(Function<Processor.Builder, ObjectBuilder<Processor>> fn) {
            return onFailure(fn.apply(new Processor.Builder()).build());
        }

        /**
         * Processors used to perform transformations on documents before indexing. Processors run sequentially in the order specified.
         * <p>
         * API name: {@code processors}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>processors</code>.
         * </p>
         */
        @Nonnull
        public final Builder processors(List<Processor> list) {
            this.processors = _listAddAll(this.processors, list);
            return this;
        }

        /**
         * Processors used to perform transformations on documents before indexing. Processors run sequentially in the order specified.
         * <p>
         * API name: {@code processors}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>processors</code>.
         * </p>
         */
        @Nonnull
        public final Builder processors(Processor value, Processor... values) {
            this.processors = _listAdd(this.processors, value, values);
            return this;
        }

        /**
         * Processors used to perform transformations on documents before indexing. Processors run sequentially in the order specified.
         * <p>
         * API name: {@code processors}
         * </p>
         *
         * <p>
         * Adds a value to <code>processors</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder processors(Function<Processor.Builder, ObjectBuilder<Processor>> fn) {
            return processors(fn.apply(new Processor.Builder()).build());
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
         * Builds a {@link Pipeline}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public Pipeline build() {
            _checkSingleUse();

            return new Pipeline(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link Pipeline}
     */
    public static final JsonpDeserializer<Pipeline> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        Pipeline::setupPipelineDeserializer
    );

    protected static void setupPipelineDeserializer(ObjectDeserializer<Pipeline.Builder> op) {
        op.add(Builder::description, JsonpDeserializer.stringDeserializer(), "description");
        op.add(Builder::meta, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "_meta");
        op.add(Builder::onFailure, JsonpDeserializer.arrayDeserializer(Processor._DESERIALIZER), "on_failure");
        op.add(Builder::processors, JsonpDeserializer.arrayDeserializer(Processor._DESERIALIZER), "processors");
        op.add(Builder::version, JsonpDeserializer.longDeserializer(), "version");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.description);
        result = 31 * result + Objects.hashCode(this.meta);
        result = 31 * result + Objects.hashCode(this.onFailure);
        result = 31 * result + Objects.hashCode(this.processors);
        result = 31 * result + Objects.hashCode(this.version);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Pipeline other = (Pipeline) o;
        return Objects.equals(this.description, other.description)
            && Objects.equals(this.meta, other.meta)
            && Objects.equals(this.onFailure, other.onFailure)
            && Objects.equals(this.processors, other.processors)
            && Objects.equals(this.version, other.version);
    }
}
