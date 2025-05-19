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
import java.util.Map;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
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

// typedef: ingest.processor_grok.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ProcessorGrokResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ProcessorGrokResponse.Builder, ProcessorGrokResponse> {

    @Nonnull
    private final Map<String, String> patterns;

    // ---------------------------------------------------------------------------------------------

    private ProcessorGrokResponse(Builder builder) {
        this.patterns = ApiTypeHelper.unmodifiableRequired(builder.patterns, this, "patterns");
    }

    public static ProcessorGrokResponse of(Function<ProcessorGrokResponse.Builder, ObjectBuilder<ProcessorGrokResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code patterns}
     */
    @Nonnull
    public final Map<String, String> patterns() {
        return this.patterns;
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
        generator.writeKey("patterns");
        generator.writeStartObject();
        for (Map.Entry<String, String> item0 : this.patterns.entrySet()) {
            generator.writeKey(item0.getKey());
            generator.write(item0.getValue());
        }
        generator.writeEnd();
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
     * Builder for {@link ProcessorGrokResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ProcessorGrokResponse> {
        private Map<String, String> patterns;

        public Builder() {}

        private Builder(ProcessorGrokResponse o) {
            this.patterns = _mapCopy(o.patterns);
        }

        private Builder(Builder o) {
            this.patterns = _mapCopy(o.patterns);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code patterns}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>patterns</code>.
         * </p>
         */
        @Nonnull
        public final Builder patterns(Map<String, String> map) {
            this.patterns = _mapPutAll(this.patterns, map);
            return this;
        }

        /**
         * Required - API name: {@code patterns}
         *
         * <p>
         * Adds an entry to <code>patterns</code>.
         * </p>
         */
        @Nonnull
        public final Builder patterns(String key, String value) {
            this.patterns = _mapPut(this.patterns, key, value);
            return this;
        }

        /**
         * Builds a {@link ProcessorGrokResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ProcessorGrokResponse build() {
            _checkSingleUse();

            return new ProcessorGrokResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ProcessorGrokResponse}
     */
    public static final JsonpDeserializer<ProcessorGrokResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ProcessorGrokResponse::setupProcessorGrokResponseDeserializer
    );

    protected static void setupProcessorGrokResponseDeserializer(ObjectDeserializer<ProcessorGrokResponse.Builder> op) {
        op.add(Builder::patterns, JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.stringDeserializer()), "patterns");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.patterns.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ProcessorGrokResponse other = (ProcessorGrokResponse) o;
        return this.patterns.equals(other.patterns);
    }
}
