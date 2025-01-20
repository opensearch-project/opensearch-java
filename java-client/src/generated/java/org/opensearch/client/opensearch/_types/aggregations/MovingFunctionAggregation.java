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

package org.opensearch.client.opensearch._types.aggregations;

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
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.aggregations.MovingFunctionAggregation

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class MovingFunctionAggregation extends PipelineAggregationBase
    implements
        AggregationVariant,
        ToCopyableBuilder<MovingFunctionAggregation.Builder, MovingFunctionAggregation> {

    @Nullable
    private final String script;

    @Nullable
    private final Integer shift;

    @Nullable
    private final Integer window;

    // ---------------------------------------------------------------------------------------------

    private MovingFunctionAggregation(Builder builder) {
        super(builder);
        this.script = builder.script;
        this.shift = builder.shift;
        this.window = builder.window;
    }

    public static MovingFunctionAggregation of(Function<MovingFunctionAggregation.Builder, ObjectBuilder<MovingFunctionAggregation>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Aggregation} variant kind.
     */
    @Override
    public Aggregation.Kind _aggregationKind() {
        return Aggregation.Kind.MovingFn;
    }

    /**
     * The script that should be executed on each window of data.
     * <p>
     * API name: {@code script}
     * </p>
     */
    @Nullable
    public final String script() {
        return this.script;
    }

    /**
     * By default, the window consists of the last n values excluding the current bucket. Increasing <code>shift</code> by 1, moves the
     * starting window position by 1 to the right.
     * <p>
     * API name: {@code shift}
     * </p>
     */
    @Nullable
    public final Integer shift() {
        return this.shift;
    }

    /**
     * The size of window to &quot;slide&quot; across the histogram.
     * <p>
     * API name: {@code window}
     * </p>
     */
    @Nullable
    public final Integer window() {
        return this.window;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.script != null) {
            generator.writeKey("script");
            generator.write(this.script);
        }

        if (this.shift != null) {
            generator.writeKey("shift");
            generator.write(this.shift);
        }

        if (this.window != null) {
            generator.writeKey("window");
            generator.write(this.window);
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
     * Builder for {@link MovingFunctionAggregation}.
     */
    public static class Builder extends PipelineAggregationBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, MovingFunctionAggregation> {
        @Nullable
        private String script;
        @Nullable
        private Integer shift;
        @Nullable
        private Integer window;

        public Builder() {}

        private Builder(MovingFunctionAggregation o) {
            super(o);
            this.script = o.script;
            this.shift = o.shift;
            this.window = o.window;
        }

        private Builder(Builder o) {
            super(o);
            this.script = o.script;
            this.shift = o.shift;
            this.window = o.window;
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
         * The script that should be executed on each window of data.
         * <p>
         * API name: {@code script}
         * </p>
         */
        @Nonnull
        public final Builder script(@Nullable String value) {
            this.script = value;
            return this;
        }

        /**
         * By default, the window consists of the last n values excluding the current bucket. Increasing <code>shift</code> by 1, moves the
         * starting window position by 1 to the right.
         * <p>
         * API name: {@code shift}
         * </p>
         */
        @Nonnull
        public final Builder shift(@Nullable Integer value) {
            this.shift = value;
            return this;
        }

        /**
         * The size of window to &quot;slide&quot; across the histogram.
         * <p>
         * API name: {@code window}
         * </p>
         */
        @Nonnull
        public final Builder window(@Nullable Integer value) {
            this.window = value;
            return this;
        }

        /**
         * Builds a {@link MovingFunctionAggregation}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public MovingFunctionAggregation build() {
            _checkSingleUse();

            return new MovingFunctionAggregation(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link MovingFunctionAggregation}
     */
    public static final JsonpDeserializer<MovingFunctionAggregation> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        MovingFunctionAggregation::setupMovingFunctionAggregationDeserializer
    );

    protected static void setupMovingFunctionAggregationDeserializer(ObjectDeserializer<MovingFunctionAggregation.Builder> op) {
        setupPipelineAggregationBaseDeserializer(op);
        op.add(Builder::script, JsonpDeserializer.stringDeserializer(), "script");
        op.add(Builder::shift, JsonpDeserializer.integerDeserializer(), "shift");
        op.add(Builder::window, JsonpDeserializer.integerDeserializer(), "window");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.script);
        result = 31 * result + Objects.hashCode(this.shift);
        result = 31 * result + Objects.hashCode(this.window);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        MovingFunctionAggregation other = (MovingFunctionAggregation) o;
        return Objects.equals(this.script, other.script)
            && Objects.equals(this.shift, other.shift)
            && Objects.equals(this.window, other.window);
    }
}
