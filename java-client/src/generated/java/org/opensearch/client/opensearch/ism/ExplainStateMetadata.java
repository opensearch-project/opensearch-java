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

package org.opensearch.client.opensearch.ism;

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

// typedef: ism.ExplainStateMetadata

/**
 * The current state of the managed index.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ExplainStateMetadata implements PlainJsonSerializable, ToCopyableBuilder<ExplainStateMetadata.Builder, ExplainStateMetadata> {

    @Nullable
    private final String name;

    @Nullable
    private final Long startTime;

    // ---------------------------------------------------------------------------------------------

    private ExplainStateMetadata(Builder builder) {
        this.name = builder.name;
        this.startTime = builder.startTime;
    }

    public static ExplainStateMetadata of(Function<ExplainStateMetadata.Builder, ObjectBuilder<ExplainStateMetadata>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The name of the state.
     * <p>
     * API name: {@code name}
     * </p>
     */
    @Nullable
    public final String name() {
        return this.name;
    }

    /**
     * API name: {@code start_time}
     */
    @Nullable
    public final Long startTime() {
        return this.startTime;
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
        if (this.name != null) {
            generator.writeKey("name");
            generator.write(this.name);
        }

        if (this.startTime != null) {
            generator.writeKey("start_time");
            generator.write(this.startTime);
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
     * Builder for {@link ExplainStateMetadata}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ExplainStateMetadata> {
        @Nullable
        private String name;
        @Nullable
        private Long startTime;

        public Builder() {}

        private Builder(ExplainStateMetadata o) {
            this.name = o.name;
            this.startTime = o.startTime;
        }

        private Builder(Builder o) {
            this.name = o.name;
            this.startTime = o.startTime;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The name of the state.
         * <p>
         * API name: {@code name}
         * </p>
         */
        @Nonnull
        public final Builder name(@Nullable String value) {
            this.name = value;
            return this;
        }

        /**
         * API name: {@code start_time}
         */
        @Nonnull
        public final Builder startTime(@Nullable Long value) {
            this.startTime = value;
            return this;
        }

        /**
         * Builds a {@link ExplainStateMetadata}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ExplainStateMetadata build() {
            _checkSingleUse();

            return new ExplainStateMetadata(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ExplainStateMetadata}
     */
    public static final JsonpDeserializer<ExplainStateMetadata> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ExplainStateMetadata::setupExplainStateMetadataDeserializer
    );

    protected static void setupExplainStateMetadataDeserializer(ObjectDeserializer<ExplainStateMetadata.Builder> op) {
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
        op.add(Builder::startTime, JsonpDeserializer.longDeserializer(), "start_time");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.name);
        result = 31 * result + Objects.hashCode(this.startTime);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ExplainStateMetadata other = (ExplainStateMetadata) o;
        return Objects.equals(this.name, other.name) && Objects.equals(this.startTime, other.startTime);
    }
}
