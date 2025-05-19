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

// typedef: ingest.simulate.Ingest

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Ingest implements PlainJsonSerializable, ToCopyableBuilder<Ingest.Builder, Ingest> {

    @Nullable
    private final String pipeline;

    @Nonnull
    private final String timestamp;

    // ---------------------------------------------------------------------------------------------

    private Ingest(Builder builder) {
        this.pipeline = builder.pipeline;
        this.timestamp = ApiTypeHelper.requireNonNull(builder.timestamp, this, "timestamp");
    }

    public static Ingest of(Function<Ingest.Builder, ObjectBuilder<Ingest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code pipeline}
     */
    @Nullable
    public final String pipeline() {
        return this.pipeline;
    }

    /**
     * Required - API name: {@code timestamp}
     */
    @Nonnull
    public final String timestamp() {
        return this.timestamp;
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
        if (this.pipeline != null) {
            generator.writeKey("pipeline");
            generator.write(this.pipeline);
        }

        generator.writeKey("timestamp");
        generator.write(this.timestamp);
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
        private String pipeline;
        private String timestamp;

        public Builder() {}

        private Builder(Ingest o) {
            this.pipeline = o.pipeline;
            this.timestamp = o.timestamp;
        }

        private Builder(Builder o) {
            this.pipeline = o.pipeline;
            this.timestamp = o.timestamp;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code pipeline}
         */
        @Nonnull
        public final Builder pipeline(@Nullable String value) {
            this.pipeline = value;
            return this;
        }

        /**
         * Required - API name: {@code timestamp}
         */
        @Nonnull
        public final Builder timestamp(String value) {
            this.timestamp = value;
            return this;
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
        op.add(Builder::pipeline, JsonpDeserializer.stringDeserializer(), "pipeline");
        op.add(Builder::timestamp, JsonpDeserializer.stringDeserializer(), "timestamp");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.pipeline);
        result = 31 * result + this.timestamp.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Ingest other = (Ingest) o;
        return Objects.equals(this.pipeline, other.pipeline) && this.timestamp.equals(other.timestamp);
    }
}
