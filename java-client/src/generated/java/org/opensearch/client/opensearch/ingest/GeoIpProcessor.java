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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ingest.GeoIpProcessor

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GeoIpProcessor extends ProcessorBase implements ProcessorVariant, ToCopyableBuilder<GeoIpProcessor.Builder, GeoIpProcessor> {

    @Nullable
    private final String databaseFile;

    @Nonnull
    private final String field;

    @Nullable
    private final Boolean firstOnly;

    @Nullable
    private final Boolean ignoreMissing;

    @Nonnull
    private final List<String> properties;

    @Nullable
    private final String targetField;

    // ---------------------------------------------------------------------------------------------

    private GeoIpProcessor(Builder builder) {
        super(builder);
        this.databaseFile = builder.databaseFile;
        this.field = ApiTypeHelper.requireNonNull(builder.field, this, "field");
        this.firstOnly = builder.firstOnly;
        this.ignoreMissing = builder.ignoreMissing;
        this.properties = ApiTypeHelper.unmodifiable(builder.properties);
        this.targetField = builder.targetField;
    }

    public static GeoIpProcessor of(Function<GeoIpProcessor.Builder, ObjectBuilder<GeoIpProcessor>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Processor} variant kind.
     */
    @Override
    public Processor.Kind _processorKind() {
        return Processor.Kind.Geoip;
    }

    /**
     * The database filename referring to a database the module ships with (<code>GeoLite2-City.mmdb</code>,
     * <code>GeoLite2-Country.mmdb</code>, or <code>GeoLite2-ASN.mmdb</code>) or a custom database in the <code>ingest-geoip</code> config
     * directory.
     * <p>
     * API name: {@code database_file}
     * </p>
     */
    @Nullable
    public final String databaseFile() {
        return this.databaseFile;
    }

    /**
     * Required - API name: {@code field}
     */
    @Nonnull
    public final String field() {
        return this.field;
    }

    /**
     * If <code>true</code>, only the first found geoip data will be returned, even if the field contains an array.
     * <p>
     * API name: {@code first_only}
     * </p>
     */
    @Nullable
    public final Boolean firstOnly() {
        return this.firstOnly;
    }

    /**
     * If <code>true</code> and <code>field</code> does not exist, the processor quietly exits without modifying the document.
     * <p>
     * API name: {@code ignore_missing}
     * </p>
     */
    @Nullable
    public final Boolean ignoreMissing() {
        return this.ignoreMissing;
    }

    /**
     * Controls what properties are added to the <code>target_field</code> based on the geoip lookup.
     * <p>
     * API name: {@code properties}
     * </p>
     */
    @Nonnull
    public final List<String> properties() {
        return this.properties;
    }

    /**
     * API name: {@code target_field}
     */
    @Nullable
    public final String targetField() {
        return this.targetField;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.databaseFile != null) {
            generator.writeKey("database_file");
            generator.write(this.databaseFile);
        }

        generator.writeKey("field");
        generator.write(this.field);

        if (this.firstOnly != null) {
            generator.writeKey("first_only");
            generator.write(this.firstOnly);
        }

        if (this.ignoreMissing != null) {
            generator.writeKey("ignore_missing");
            generator.write(this.ignoreMissing);
        }

        if (ApiTypeHelper.isDefined(this.properties)) {
            generator.writeKey("properties");
            generator.writeStartArray();
            for (String item0 : this.properties) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.targetField != null) {
            generator.writeKey("target_field");
            generator.write(this.targetField);
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
     * Builder for {@link GeoIpProcessor}.
     */
    public static class Builder extends ProcessorBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, GeoIpProcessor> {
        @Nullable
        private String databaseFile;
        private String field;
        @Nullable
        private Boolean firstOnly;
        @Nullable
        private Boolean ignoreMissing;
        @Nullable
        private List<String> properties;
        @Nullable
        private String targetField;

        public Builder() {}

        private Builder(GeoIpProcessor o) {
            super(o);
            this.databaseFile = o.databaseFile;
            this.field = o.field;
            this.firstOnly = o.firstOnly;
            this.ignoreMissing = o.ignoreMissing;
            this.properties = _listCopy(o.properties);
            this.targetField = o.targetField;
        }

        private Builder(Builder o) {
            super(o);
            this.databaseFile = o.databaseFile;
            this.field = o.field;
            this.firstOnly = o.firstOnly;
            this.ignoreMissing = o.ignoreMissing;
            this.properties = _listCopy(o.properties);
            this.targetField = o.targetField;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        @Override
        @Nonnull
        protected Builder self() {
            return this;
        }

        /**
         * The database filename referring to a database the module ships with (<code>GeoLite2-City.mmdb</code>,
         * <code>GeoLite2-Country.mmdb</code>, or <code>GeoLite2-ASN.mmdb</code>) or a custom database in the <code>ingest-geoip</code>
         * config directory.
         * <p>
         * API name: {@code database_file}
         * </p>
         */
        @Nonnull
        public final Builder databaseFile(@Nullable String value) {
            this.databaseFile = value;
            return this;
        }

        /**
         * Required - API name: {@code field}
         */
        @Nonnull
        public final Builder field(String value) {
            this.field = value;
            return this;
        }

        /**
         * If <code>true</code>, only the first found geoip data will be returned, even if the field contains an array.
         * <p>
         * API name: {@code first_only}
         * </p>
         */
        @Nonnull
        public final Builder firstOnly(@Nullable Boolean value) {
            this.firstOnly = value;
            return this;
        }

        /**
         * If <code>true</code> and <code>field</code> does not exist, the processor quietly exits without modifying the document.
         * <p>
         * API name: {@code ignore_missing}
         * </p>
         */
        @Nonnull
        public final Builder ignoreMissing(@Nullable Boolean value) {
            this.ignoreMissing = value;
            return this;
        }

        /**
         * Controls what properties are added to the <code>target_field</code> based on the geoip lookup.
         * <p>
         * API name: {@code properties}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>properties</code>.
         * </p>
         */
        @Nonnull
        public final Builder properties(List<String> list) {
            this.properties = _listAddAll(this.properties, list);
            return this;
        }

        /**
         * Controls what properties are added to the <code>target_field</code> based on the geoip lookup.
         * <p>
         * API name: {@code properties}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>properties</code>.
         * </p>
         */
        @Nonnull
        public final Builder properties(String value, String... values) {
            this.properties = _listAdd(this.properties, value, values);
            return this;
        }

        /**
         * API name: {@code target_field}
         */
        @Nonnull
        public final Builder targetField(@Nullable String value) {
            this.targetField = value;
            return this;
        }

        /**
         * Builds a {@link GeoIpProcessor}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GeoIpProcessor build() {
            _checkSingleUse();

            return new GeoIpProcessor(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GeoIpProcessor}
     */
    public static final JsonpDeserializer<GeoIpProcessor> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GeoIpProcessor::setupGeoIpProcessorDeserializer
    );

    protected static void setupGeoIpProcessorDeserializer(ObjectDeserializer<GeoIpProcessor.Builder> op) {
        setupProcessorBaseDeserializer(op);
        op.add(Builder::databaseFile, JsonpDeserializer.stringDeserializer(), "database_file");
        op.add(Builder::field, JsonpDeserializer.stringDeserializer(), "field");
        op.add(Builder::firstOnly, JsonpDeserializer.booleanDeserializer(), "first_only");
        op.add(Builder::ignoreMissing, JsonpDeserializer.booleanDeserializer(), "ignore_missing");
        op.add(Builder::properties, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "properties");
        op.add(Builder::targetField, JsonpDeserializer.stringDeserializer(), "target_field");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.databaseFile);
        result = 31 * result + this.field.hashCode();
        result = 31 * result + Objects.hashCode(this.firstOnly);
        result = 31 * result + Objects.hashCode(this.ignoreMissing);
        result = 31 * result + Objects.hashCode(this.properties);
        result = 31 * result + Objects.hashCode(this.targetField);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GeoIpProcessor other = (GeoIpProcessor) o;
        return Objects.equals(this.databaseFile, other.databaseFile)
            && this.field.equals(other.field)
            && Objects.equals(this.firstOnly, other.firstOnly)
            && Objects.equals(this.ignoreMissing, other.ignoreMissing)
            && Objects.equals(this.properties, other.properties)
            && Objects.equals(this.targetField, other.targetField);
    }
}
