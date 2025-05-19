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

// typedef: ingest.CircleProcessor

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class CircleProcessor extends ProcessorBase
    implements
        ProcessorVariant,
        ToCopyableBuilder<CircleProcessor.Builder, CircleProcessor> {

    private final double errorDistance;

    @Nonnull
    private final String field;

    @Nullable
    private final Boolean ignoreMissing;

    @Nonnull
    private final ShapeType shapeType;

    @Nullable
    private final String targetField;

    // ---------------------------------------------------------------------------------------------

    private CircleProcessor(Builder builder) {
        super(builder);
        this.errorDistance = ApiTypeHelper.requireNonNull(builder.errorDistance, this, "errorDistance");
        this.field = ApiTypeHelper.requireNonNull(builder.field, this, "field");
        this.ignoreMissing = builder.ignoreMissing;
        this.shapeType = ApiTypeHelper.requireNonNull(builder.shapeType, this, "shapeType");
        this.targetField = builder.targetField;
    }

    public static CircleProcessor of(Function<CircleProcessor.Builder, ObjectBuilder<CircleProcessor>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Processor} variant kind.
     */
    @Override
    public Processor.Kind _processorKind() {
        return Processor.Kind.Circle;
    }

    /**
     * Required - The difference between the resulting inscribed distance from center to side and the circle's radius (measured in meters
     * for <code>geo_shape</code>, unit-less for <code>shape</code>).
     * <p>
     * API name: {@code error_distance}
     * </p>
     */
    public final double errorDistance() {
        return this.errorDistance;
    }

    /**
     * Required - API name: {@code field}
     */
    @Nonnull
    public final String field() {
        return this.field;
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
     * Required - API name: {@code shape_type}
     */
    @Nonnull
    public final ShapeType shapeType() {
        return this.shapeType;
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
        generator.writeKey("error_distance");
        generator.write(this.errorDistance);

        generator.writeKey("field");
        generator.write(this.field);

        if (this.ignoreMissing != null) {
            generator.writeKey("ignore_missing");
            generator.write(this.ignoreMissing);
        }

        generator.writeKey("shape_type");
        this.shapeType.serialize(generator, mapper);

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
     * Builder for {@link CircleProcessor}.
     */
    public static class Builder extends ProcessorBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, CircleProcessor> {
        private Double errorDistance;
        private String field;
        @Nullable
        private Boolean ignoreMissing;
        private ShapeType shapeType;
        @Nullable
        private String targetField;

        public Builder() {}

        private Builder(CircleProcessor o) {
            super(o);
            this.errorDistance = o.errorDistance;
            this.field = o.field;
            this.ignoreMissing = o.ignoreMissing;
            this.shapeType = o.shapeType;
            this.targetField = o.targetField;
        }

        private Builder(Builder o) {
            super(o);
            this.errorDistance = o.errorDistance;
            this.field = o.field;
            this.ignoreMissing = o.ignoreMissing;
            this.shapeType = o.shapeType;
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
         * Required - The difference between the resulting inscribed distance from center to side and the circle's radius (measured in
         * meters for <code>geo_shape</code>, unit-less for <code>shape</code>).
         * <p>
         * API name: {@code error_distance}
         * </p>
         */
        @Nonnull
        public final Builder errorDistance(double value) {
            this.errorDistance = value;
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
         * Required - API name: {@code shape_type}
         */
        @Nonnull
        public final Builder shapeType(ShapeType value) {
            this.shapeType = value;
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
         * Builds a {@link CircleProcessor}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public CircleProcessor build() {
            _checkSingleUse();

            return new CircleProcessor(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link CircleProcessor}
     */
    public static final JsonpDeserializer<CircleProcessor> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CircleProcessor::setupCircleProcessorDeserializer
    );

    protected static void setupCircleProcessorDeserializer(ObjectDeserializer<CircleProcessor.Builder> op) {
        setupProcessorBaseDeserializer(op);
        op.add(Builder::errorDistance, JsonpDeserializer.doubleDeserializer(), "error_distance");
        op.add(Builder::field, JsonpDeserializer.stringDeserializer(), "field");
        op.add(Builder::ignoreMissing, JsonpDeserializer.booleanDeserializer(), "ignore_missing");
        op.add(Builder::shapeType, ShapeType._DESERIALIZER, "shape_type");
        op.add(Builder::targetField, JsonpDeserializer.stringDeserializer(), "target_field");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Double.hashCode(this.errorDistance);
        result = 31 * result + this.field.hashCode();
        result = 31 * result + Objects.hashCode(this.ignoreMissing);
        result = 31 * result + this.shapeType.hashCode();
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
        CircleProcessor other = (CircleProcessor) o;
        return this.errorDistance == other.errorDistance
            && this.field.equals(other.field)
            && Objects.equals(this.ignoreMissing, other.ignoreMissing)
            && this.shapeType.equals(other.shapeType)
            && Objects.equals(this.targetField, other.targetField);
    }
}
