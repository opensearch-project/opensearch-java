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

package org.opensearch.client.opensearch.core.reindex;

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
import org.opensearch.client.opensearch._types.OpType;
import org.opensearch.client.opensearch._types.VersionType;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: core.reindex.Destination

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Destination implements PlainJsonSerializable, ToCopyableBuilder<Destination.Builder, Destination> {

    @Nonnull
    private final String index;

    @Nullable
    private final OpType opType;

    @Nullable
    private final String pipeline;

    @Nullable
    private final String routing;

    @Nullable
    private final VersionType versionType;

    // ---------------------------------------------------------------------------------------------

    private Destination(Builder builder) {
        this.index = ApiTypeHelper.requireNonNull(builder.index, this, "index");
        this.opType = builder.opType;
        this.pipeline = builder.pipeline;
        this.routing = builder.routing;
        this.versionType = builder.versionType;
    }

    public static Destination of(Function<Destination.Builder, ObjectBuilder<Destination>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code index}
     */
    @Nonnull
    public final String index() {
        return this.index;
    }

    /**
     * API name: {@code op_type}
     */
    @Nullable
    public final OpType opType() {
        return this.opType;
    }

    /**
     * The name of the pipeline to use.
     * <p>
     * API name: {@code pipeline}
     * </p>
     */
    @Nullable
    public final String pipeline() {
        return this.pipeline;
    }

    /**
     * API name: {@code routing}
     */
    @Nullable
    public final String routing() {
        return this.routing;
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
        generator.writeKey("index");
        generator.write(this.index);

        if (this.opType != null) {
            generator.writeKey("op_type");
            this.opType.serialize(generator, mapper);
        }

        if (this.pipeline != null) {
            generator.writeKey("pipeline");
            generator.write(this.pipeline);
        }

        if (this.routing != null) {
            generator.writeKey("routing");
            generator.write(this.routing);
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
     * Builder for {@link Destination}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, Destination> {
        private String index;
        @Nullable
        private OpType opType;
        @Nullable
        private String pipeline;
        @Nullable
        private String routing;
        @Nullable
        private VersionType versionType;

        public Builder() {}

        private Builder(Destination o) {
            this.index = o.index;
            this.opType = o.opType;
            this.pipeline = o.pipeline;
            this.routing = o.routing;
            this.versionType = o.versionType;
        }

        private Builder(Builder o) {
            this.index = o.index;
            this.opType = o.opType;
            this.pipeline = o.pipeline;
            this.routing = o.routing;
            this.versionType = o.versionType;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code index}
         */
        @Nonnull
        public final Builder index(String value) {
            this.index = value;
            return this;
        }

        /**
         * API name: {@code op_type}
         */
        @Nonnull
        public final Builder opType(@Nullable OpType value) {
            this.opType = value;
            return this;
        }

        /**
         * The name of the pipeline to use.
         * <p>
         * API name: {@code pipeline}
         * </p>
         */
        @Nonnull
        public final Builder pipeline(@Nullable String value) {
            this.pipeline = value;
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
         * API name: {@code version_type}
         */
        @Nonnull
        public final Builder versionType(@Nullable VersionType value) {
            this.versionType = value;
            return this;
        }

        /**
         * Builds a {@link Destination}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public Destination build() {
            _checkSingleUse();

            return new Destination(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link Destination}
     */
    public static final JsonpDeserializer<Destination> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        Destination::setupDestinationDeserializer
    );

    protected static void setupDestinationDeserializer(ObjectDeserializer<Destination.Builder> op) {
        op.add(Builder::index, JsonpDeserializer.stringDeserializer(), "index");
        op.add(Builder::opType, OpType._DESERIALIZER, "op_type");
        op.add(Builder::pipeline, JsonpDeserializer.stringDeserializer(), "pipeline");
        op.add(Builder::routing, JsonpDeserializer.stringDeserializer(), "routing");
        op.add(Builder::versionType, VersionType._DESERIALIZER, "version_type");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.index.hashCode();
        result = 31 * result + Objects.hashCode(this.opType);
        result = 31 * result + Objects.hashCode(this.pipeline);
        result = 31 * result + Objects.hashCode(this.routing);
        result = 31 * result + Objects.hashCode(this.versionType);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Destination other = (Destination) o;
        return this.index.equals(other.index)
            && Objects.equals(this.opType, other.opType)
            && Objects.equals(this.pipeline, other.pipeline)
            && Objects.equals(this.routing, other.routing)
            && Objects.equals(this.versionType, other.versionType);
    }
}
