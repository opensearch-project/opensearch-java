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

// typedef: nodes.stats.KeyedProcessor

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class KeyedProcessor implements PlainJsonSerializable, ToCopyableBuilder<KeyedProcessor.Builder, KeyedProcessor> {

    @Nullable
    private final Processor stats;

    @Nullable
    private final String type;

    // ---------------------------------------------------------------------------------------------

    private KeyedProcessor(Builder builder) {
        this.stats = builder.stats;
        this.type = builder.type;
    }

    public static KeyedProcessor of(Function<KeyedProcessor.Builder, ObjectBuilder<KeyedProcessor>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code stats}
     */
    @Nullable
    public final Processor stats() {
        return this.stats;
    }

    /**
     * API name: {@code type}
     */
    @Nullable
    public final String type() {
        return this.type;
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
        if (this.stats != null) {
            generator.writeKey("stats");
            this.stats.serialize(generator, mapper);
        }

        if (this.type != null) {
            generator.writeKey("type");
            generator.write(this.type);
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
     * Builder for {@link KeyedProcessor}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, KeyedProcessor> {
        @Nullable
        private Processor stats;
        @Nullable
        private String type;

        public Builder() {}

        private Builder(KeyedProcessor o) {
            this.stats = o.stats;
            this.type = o.type;
        }

        private Builder(Builder o) {
            this.stats = o.stats;
            this.type = o.type;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code stats}
         */
        @Nonnull
        public final Builder stats(@Nullable Processor value) {
            this.stats = value;
            return this;
        }

        /**
         * API name: {@code stats}
         */
        @Nonnull
        public final Builder stats(Function<Processor.Builder, ObjectBuilder<Processor>> fn) {
            return stats(fn.apply(new Processor.Builder()).build());
        }

        /**
         * API name: {@code type}
         */
        @Nonnull
        public final Builder type(@Nullable String value) {
            this.type = value;
            return this;
        }

        /**
         * Builds a {@link KeyedProcessor}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public KeyedProcessor build() {
            _checkSingleUse();

            return new KeyedProcessor(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link KeyedProcessor}
     */
    public static final JsonpDeserializer<KeyedProcessor> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        KeyedProcessor::setupKeyedProcessorDeserializer
    );

    protected static void setupKeyedProcessorDeserializer(ObjectDeserializer<KeyedProcessor.Builder> op) {
        op.add(Builder::stats, Processor._DESERIALIZER, "stats");
        op.add(Builder::type, JsonpDeserializer.stringDeserializer(), "type");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.stats);
        result = 31 * result + Objects.hashCode(this.type);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        KeyedProcessor other = (KeyedProcessor) o;
        return Objects.equals(this.stats, other.stats) && Objects.equals(this.type, other.type);
    }
}
