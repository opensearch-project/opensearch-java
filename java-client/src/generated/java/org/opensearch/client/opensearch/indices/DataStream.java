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

package org.opensearch.client.opensearch.indices;

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
import org.opensearch.client.opensearch._types.HealthStatus;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: indices.DataStream

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class DataStream implements PlainJsonSerializable, ToCopyableBuilder<DataStream.Builder, DataStream> {

    @Nullable
    private final Boolean allowCustomRouting;

    private final long generation;

    @Nullable
    private final Boolean hidden;

    @Nullable
    private final String ilmPolicy;

    @Nonnull
    private final List<DataStreamIndex> indices;

    @Nonnull
    private final Map<String, JsonData> meta;

    @Nonnull
    private final String name;

    @Nullable
    private final ManagedBy nextGenerationManagedBy;

    @Nullable
    private final Boolean preferIlm;

    @Nullable
    private final Boolean replicated;

    @Nonnull
    private final HealthStatus status;

    @Nullable
    private final Boolean system;

    @Nonnull
    private final String template;

    @Nonnull
    private final DataStreamTimestampField timestampField;

    // ---------------------------------------------------------------------------------------------

    private DataStream(Builder builder) {
        this.allowCustomRouting = builder.allowCustomRouting;
        this.generation = ApiTypeHelper.requireNonNull(builder.generation, this, "generation");
        this.hidden = builder.hidden;
        this.ilmPolicy = builder.ilmPolicy;
        this.indices = ApiTypeHelper.unmodifiableRequired(builder.indices, this, "indices");
        this.meta = ApiTypeHelper.unmodifiable(builder.meta);
        this.name = ApiTypeHelper.requireNonNull(builder.name, this, "name");
        this.nextGenerationManagedBy = builder.nextGenerationManagedBy;
        this.preferIlm = builder.preferIlm;
        this.replicated = builder.replicated;
        this.status = ApiTypeHelper.requireNonNull(builder.status, this, "status");
        this.system = builder.system;
        this.template = ApiTypeHelper.requireNonNull(builder.template, this, "template");
        this.timestampField = ApiTypeHelper.requireNonNull(builder.timestampField, this, "timestampField");
    }

    public static DataStream of(Function<DataStream.Builder, ObjectBuilder<DataStream>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * If <code>true</code>, the data stream allows custom routing on write request.
     * <p>
     * API name: {@code allow_custom_routing}
     * </p>
     */
    @Nullable
    public final Boolean allowCustomRouting() {
        return this.allowCustomRouting;
    }

    /**
     * Required - Current generation for the data stream. This number acts as a cumulative count of the stream's rollovers, starting at 1.
     * <p>
     * API name: {@code generation}
     * </p>
     */
    public final long generation() {
        return this.generation;
    }

    /**
     * If <code>true</code>, the data stream is hidden.
     * <p>
     * API name: {@code hidden}
     * </p>
     */
    @Nullable
    public final Boolean hidden() {
        return this.hidden;
    }

    /**
     * API name: {@code ilm_policy}
     */
    @Nullable
    public final String ilmPolicy() {
        return this.ilmPolicy;
    }

    /**
     * Required - Array of objects containing information about the data stream's backing indexes. The last item in this array contains
     * information about the stream's current write index.
     * <p>
     * API name: {@code indices}
     * </p>
     */
    @Nonnull
    public final List<DataStreamIndex> indices() {
        return this.indices;
    }

    /**
     * API name: {@code _meta}
     */
    @Nonnull
    public final Map<String, JsonData> meta() {
        return this.meta;
    }

    /**
     * Required - API name: {@code name}
     */
    @Nonnull
    public final String name() {
        return this.name;
    }

    /**
     * API name: {@code next_generation_managed_by}
     */
    @Nullable
    public final ManagedBy nextGenerationManagedBy() {
        return this.nextGenerationManagedBy;
    }

    /**
     * Indicates if ILM should take precedence over DSL in case both are configured to managed this data stream.
     * <p>
     * API name: {@code prefer_ilm}
     * </p>
     */
    @Nullable
    public final Boolean preferIlm() {
        return this.preferIlm;
    }

    /**
     * If <code>true</code>, the data stream is created and managed by cross-cluster replication and the local cluster can not write into
     * this data stream or change its mappings.
     * <p>
     * API name: {@code replicated}
     * </p>
     */
    @Nullable
    public final Boolean replicated() {
        return this.replicated;
    }

    /**
     * Required - API name: {@code status}
     */
    @Nonnull
    public final HealthStatus status() {
        return this.status;
    }

    /**
     * If <code>true</code>, the data stream is created and managed by an OpenSearch stack component and cannot be modified through normal
     * user interaction.
     * <p>
     * API name: {@code system}
     * </p>
     */
    @Nullable
    public final Boolean system() {
        return this.system;
    }

    /**
     * Required - API name: {@code template}
     */
    @Nonnull
    public final String template() {
        return this.template;
    }

    /**
     * Required - API name: {@code timestamp_field}
     */
    @Nonnull
    public final DataStreamTimestampField timestampField() {
        return this.timestampField;
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
        if (this.allowCustomRouting != null) {
            generator.writeKey("allow_custom_routing");
            generator.write(this.allowCustomRouting);
        }

        generator.writeKey("generation");
        generator.write(this.generation);

        if (this.hidden != null) {
            generator.writeKey("hidden");
            generator.write(this.hidden);
        }

        if (this.ilmPolicy != null) {
            generator.writeKey("ilm_policy");
            generator.write(this.ilmPolicy);
        }

        generator.writeKey("indices");
        generator.writeStartArray();
        for (DataStreamIndex item0 : this.indices) {
            item0.serialize(generator, mapper);
        }
        generator.writeEnd();

        if (ApiTypeHelper.isDefined(this.meta)) {
            generator.writeKey("_meta");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.meta.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        generator.writeKey("name");
        generator.write(this.name);

        if (this.nextGenerationManagedBy != null) {
            generator.writeKey("next_generation_managed_by");
            this.nextGenerationManagedBy.serialize(generator, mapper);
        }

        if (this.preferIlm != null) {
            generator.writeKey("prefer_ilm");
            generator.write(this.preferIlm);
        }

        if (this.replicated != null) {
            generator.writeKey("replicated");
            generator.write(this.replicated);
        }

        generator.writeKey("status");
        this.status.serialize(generator, mapper);

        if (this.system != null) {
            generator.writeKey("system");
            generator.write(this.system);
        }

        generator.writeKey("template");
        generator.write(this.template);

        generator.writeKey("timestamp_field");
        this.timestampField.serialize(generator, mapper);
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
     * Builder for {@link DataStream}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, DataStream> {
        @Nullable
        private Boolean allowCustomRouting;
        private Long generation;
        @Nullable
        private Boolean hidden;
        @Nullable
        private String ilmPolicy;
        private List<DataStreamIndex> indices;
        @Nullable
        private Map<String, JsonData> meta;
        private String name;
        @Nullable
        private ManagedBy nextGenerationManagedBy;
        @Nullable
        private Boolean preferIlm;
        @Nullable
        private Boolean replicated;
        private HealthStatus status;
        @Nullable
        private Boolean system;
        private String template;
        private DataStreamTimestampField timestampField;

        public Builder() {}

        private Builder(DataStream o) {
            this.allowCustomRouting = o.allowCustomRouting;
            this.generation = o.generation;
            this.hidden = o.hidden;
            this.ilmPolicy = o.ilmPolicy;
            this.indices = _listCopy(o.indices);
            this.meta = _mapCopy(o.meta);
            this.name = o.name;
            this.nextGenerationManagedBy = o.nextGenerationManagedBy;
            this.preferIlm = o.preferIlm;
            this.replicated = o.replicated;
            this.status = o.status;
            this.system = o.system;
            this.template = o.template;
            this.timestampField = o.timestampField;
        }

        private Builder(Builder o) {
            this.allowCustomRouting = o.allowCustomRouting;
            this.generation = o.generation;
            this.hidden = o.hidden;
            this.ilmPolicy = o.ilmPolicy;
            this.indices = _listCopy(o.indices);
            this.meta = _mapCopy(o.meta);
            this.name = o.name;
            this.nextGenerationManagedBy = o.nextGenerationManagedBy;
            this.preferIlm = o.preferIlm;
            this.replicated = o.replicated;
            this.status = o.status;
            this.system = o.system;
            this.template = o.template;
            this.timestampField = o.timestampField;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * If <code>true</code>, the data stream allows custom routing on write request.
         * <p>
         * API name: {@code allow_custom_routing}
         * </p>
         */
        @Nonnull
        public final Builder allowCustomRouting(@Nullable Boolean value) {
            this.allowCustomRouting = value;
            return this;
        }

        /**
         * Required - Current generation for the data stream. This number acts as a cumulative count of the stream's rollovers, starting at
         * 1.
         * <p>
         * API name: {@code generation}
         * </p>
         */
        @Nonnull
        public final Builder generation(long value) {
            this.generation = value;
            return this;
        }

        /**
         * If <code>true</code>, the data stream is hidden.
         * <p>
         * API name: {@code hidden}
         * </p>
         */
        @Nonnull
        public final Builder hidden(@Nullable Boolean value) {
            this.hidden = value;
            return this;
        }

        /**
         * API name: {@code ilm_policy}
         */
        @Nonnull
        public final Builder ilmPolicy(@Nullable String value) {
            this.ilmPolicy = value;
            return this;
        }

        /**
         * Required - Array of objects containing information about the data stream's backing indexes. The last item in this array contains
         * information about the stream's current write index.
         * <p>
         * API name: {@code indices}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>indices</code>.
         * </p>
         */
        @Nonnull
        public final Builder indices(List<DataStreamIndex> list) {
            this.indices = _listAddAll(this.indices, list);
            return this;
        }

        /**
         * Required - Array of objects containing information about the data stream's backing indexes. The last item in this array contains
         * information about the stream's current write index.
         * <p>
         * API name: {@code indices}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>indices</code>.
         * </p>
         */
        @Nonnull
        public final Builder indices(DataStreamIndex value, DataStreamIndex... values) {
            this.indices = _listAdd(this.indices, value, values);
            return this;
        }

        /**
         * Required - Array of objects containing information about the data stream's backing indexes. The last item in this array contains
         * information about the stream's current write index.
         * <p>
         * API name: {@code indices}
         * </p>
         *
         * <p>
         * Adds a value to <code>indices</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder indices(Function<DataStreamIndex.Builder, ObjectBuilder<DataStreamIndex>> fn) {
            return indices(fn.apply(new DataStreamIndex.Builder()).build());
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
         * Required - API name: {@code name}
         */
        @Nonnull
        public final Builder name(String value) {
            this.name = value;
            return this;
        }

        /**
         * API name: {@code next_generation_managed_by}
         */
        @Nonnull
        public final Builder nextGenerationManagedBy(@Nullable ManagedBy value) {
            this.nextGenerationManagedBy = value;
            return this;
        }

        /**
         * Indicates if ILM should take precedence over DSL in case both are configured to managed this data stream.
         * <p>
         * API name: {@code prefer_ilm}
         * </p>
         */
        @Nonnull
        public final Builder preferIlm(@Nullable Boolean value) {
            this.preferIlm = value;
            return this;
        }

        /**
         * If <code>true</code>, the data stream is created and managed by cross-cluster replication and the local cluster can not write
         * into this data stream or change its mappings.
         * <p>
         * API name: {@code replicated}
         * </p>
         */
        @Nonnull
        public final Builder replicated(@Nullable Boolean value) {
            this.replicated = value;
            return this;
        }

        /**
         * Required - API name: {@code status}
         */
        @Nonnull
        public final Builder status(HealthStatus value) {
            this.status = value;
            return this;
        }

        /**
         * If <code>true</code>, the data stream is created and managed by an OpenSearch stack component and cannot be modified through
         * normal user interaction.
         * <p>
         * API name: {@code system}
         * </p>
         */
        @Nonnull
        public final Builder system(@Nullable Boolean value) {
            this.system = value;
            return this;
        }

        /**
         * Required - API name: {@code template}
         */
        @Nonnull
        public final Builder template(String value) {
            this.template = value;
            return this;
        }

        /**
         * Required - API name: {@code timestamp_field}
         */
        @Nonnull
        public final Builder timestampField(DataStreamTimestampField value) {
            this.timestampField = value;
            return this;
        }

        /**
         * Required - API name: {@code timestamp_field}
         */
        @Nonnull
        public final Builder timestampField(Function<DataStreamTimestampField.Builder, ObjectBuilder<DataStreamTimestampField>> fn) {
            return timestampField(fn.apply(new DataStreamTimestampField.Builder()).build());
        }

        /**
         * Builds a {@link DataStream}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DataStream build() {
            _checkSingleUse();

            return new DataStream(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link DataStream}
     */
    public static final JsonpDeserializer<DataStream> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        DataStream::setupDataStreamDeserializer
    );

    protected static void setupDataStreamDeserializer(ObjectDeserializer<DataStream.Builder> op) {
        op.add(Builder::allowCustomRouting, JsonpDeserializer.booleanDeserializer(), "allow_custom_routing");
        op.add(Builder::generation, JsonpDeserializer.longDeserializer(), "generation");
        op.add(Builder::hidden, JsonpDeserializer.booleanDeserializer(), "hidden");
        op.add(Builder::ilmPolicy, JsonpDeserializer.stringDeserializer(), "ilm_policy");
        op.add(Builder::indices, JsonpDeserializer.arrayDeserializer(DataStreamIndex._DESERIALIZER), "indices");
        op.add(Builder::meta, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "_meta");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
        op.add(Builder::nextGenerationManagedBy, ManagedBy._DESERIALIZER, "next_generation_managed_by");
        op.add(Builder::preferIlm, JsonpDeserializer.booleanDeserializer(), "prefer_ilm");
        op.add(Builder::replicated, JsonpDeserializer.booleanDeserializer(), "replicated");
        op.add(Builder::status, HealthStatus._DESERIALIZER, "status");
        op.add(Builder::system, JsonpDeserializer.booleanDeserializer(), "system");
        op.add(Builder::template, JsonpDeserializer.stringDeserializer(), "template");
        op.add(Builder::timestampField, DataStreamTimestampField._DESERIALIZER, "timestamp_field");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.allowCustomRouting);
        result = 31 * result + Long.hashCode(this.generation);
        result = 31 * result + Objects.hashCode(this.hidden);
        result = 31 * result + Objects.hashCode(this.ilmPolicy);
        result = 31 * result + this.indices.hashCode();
        result = 31 * result + Objects.hashCode(this.meta);
        result = 31 * result + this.name.hashCode();
        result = 31 * result + Objects.hashCode(this.nextGenerationManagedBy);
        result = 31 * result + Objects.hashCode(this.preferIlm);
        result = 31 * result + Objects.hashCode(this.replicated);
        result = 31 * result + this.status.hashCode();
        result = 31 * result + Objects.hashCode(this.system);
        result = 31 * result + this.template.hashCode();
        result = 31 * result + this.timestampField.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        DataStream other = (DataStream) o;
        return Objects.equals(this.allowCustomRouting, other.allowCustomRouting)
            && this.generation == other.generation
            && Objects.equals(this.hidden, other.hidden)
            && Objects.equals(this.ilmPolicy, other.ilmPolicy)
            && this.indices.equals(other.indices)
            && Objects.equals(this.meta, other.meta)
            && this.name.equals(other.name)
            && Objects.equals(this.nextGenerationManagedBy, other.nextGenerationManagedBy)
            && Objects.equals(this.preferIlm, other.preferIlm)
            && Objects.equals(this.replicated, other.replicated)
            && this.status.equals(other.status)
            && Objects.equals(this.system, other.system)
            && this.template.equals(other.template)
            && this.timestampField.equals(other.timestampField);
    }
}
