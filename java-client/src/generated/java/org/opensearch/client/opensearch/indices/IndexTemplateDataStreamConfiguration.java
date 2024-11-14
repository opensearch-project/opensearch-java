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
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: indices.IndexTemplateDataStreamConfiguration

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IndexTemplateDataStreamConfiguration implements PlainJsonSerializable {

    @Nullable
    private final Boolean allowCustomRouting;

    @Nullable
    private final Boolean hidden;

    @Nullable
    private final DataStreamTimestampField timestampField;

    // ---------------------------------------------------------------------------------------------

    private IndexTemplateDataStreamConfiguration(Builder builder) {
        this.allowCustomRouting = builder.allowCustomRouting;
        this.hidden = builder.hidden;
        this.timestampField = builder.timestampField;
    }

    public static IndexTemplateDataStreamConfiguration of(
        Function<IndexTemplateDataStreamConfiguration.Builder, ObjectBuilder<IndexTemplateDataStreamConfiguration>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * If true, the data stream supports custom routing.
     * <p>
     * API name: {@code allow_custom_routing}
     * </p>
     */
    @Nullable
    public final Boolean allowCustomRouting() {
        return this.allowCustomRouting;
    }

    /**
     * If true, the data stream is hidden.
     * <p>
     * API name: {@code hidden}
     * </p>
     */
    @Nullable
    public final Boolean hidden() {
        return this.hidden;
    }

    /**
     * API name: {@code timestamp_field}
     */
    @Nullable
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

        if (this.hidden != null) {
            generator.writeKey("hidden");
            generator.write(this.hidden);
        }

        if (this.timestampField != null) {
            generator.writeKey("timestamp_field");
            this.timestampField.serialize(generator, mapper);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link IndexTemplateDataStreamConfiguration}.
     */
    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<IndexTemplateDataStreamConfiguration> {
        @Nullable
        private Boolean allowCustomRouting;
        @Nullable
        private Boolean hidden;
        @Nullable
        private DataStreamTimestampField timestampField;

        /**
         * If true, the data stream supports custom routing.
         * <p>
         * API name: {@code allow_custom_routing}
         * </p>
         */
        public final Builder allowCustomRouting(@Nullable Boolean value) {
            this.allowCustomRouting = value;
            return this;
        }

        /**
         * If true, the data stream is hidden.
         * <p>
         * API name: {@code hidden}
         * </p>
         */
        public final Builder hidden(@Nullable Boolean value) {
            this.hidden = value;
            return this;
        }

        /**
         * API name: {@code timestamp_field}
         */
        public final Builder timestampField(@Nullable DataStreamTimestampField value) {
            this.timestampField = value;
            return this;
        }

        /**
         * API name: {@code timestamp_field}
         */
        public final Builder timestampField(Function<DataStreamTimestampField.Builder, ObjectBuilder<DataStreamTimestampField>> fn) {
            return timestampField(fn.apply(new DataStreamTimestampField.Builder()).build());
        }

        /**
         * Builds a {@link IndexTemplateDataStreamConfiguration}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public IndexTemplateDataStreamConfiguration build() {
            _checkSingleUse();

            return new IndexTemplateDataStreamConfiguration(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IndexTemplateDataStreamConfiguration}
     */
    public static final JsonpDeserializer<IndexTemplateDataStreamConfiguration> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IndexTemplateDataStreamConfiguration::setupIndexTemplateDataStreamConfigurationDeserializer
    );

    protected static void setupIndexTemplateDataStreamConfigurationDeserializer(
        ObjectDeserializer<IndexTemplateDataStreamConfiguration.Builder> op
    ) {
        op.add(Builder::allowCustomRouting, JsonpDeserializer.booleanDeserializer(), "allow_custom_routing");
        op.add(Builder::hidden, JsonpDeserializer.booleanDeserializer(), "hidden");
        op.add(Builder::timestampField, DataStreamTimestampField._DESERIALIZER, "timestamp_field");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.allowCustomRouting);
        result = 31 * result + Objects.hashCode(this.hidden);
        result = 31 * result + Objects.hashCode(this.timestampField);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IndexTemplateDataStreamConfiguration other = (IndexTemplateDataStreamConfiguration) o;
        return Objects.equals(this.allowCustomRouting, other.allowCustomRouting)
            && Objects.equals(this.hidden, other.hidden)
            && Objects.equals(this.timestampField, other.timestampField);
    }
}
