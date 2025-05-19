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
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectDeserializer;

// typedef: _types.aggregations.MovingAverageAggregationBase

@Generated("org.opensearch.client.codegen.CodeGenerator")
public abstract class MovingAverageAggregationBase extends PipelineAggregationBase {

    @Nullable
    private final Boolean minimize;

    @Nullable
    private final Integer predict;

    @Nullable
    private final Integer window;

    // ---------------------------------------------------------------------------------------------

    protected MovingAverageAggregationBase(AbstractBuilder<?> builder) {
        super(builder);
        this.minimize = builder.minimize;
        this.predict = builder.predict;
        this.window = builder.window;
    }

    /**
     * API name: {@code minimize}
     */
    @Nullable
    public final Boolean minimize() {
        return this.minimize;
    }

    /**
     * API name: {@code predict}
     */
    @Nullable
    public final Integer predict() {
        return this.predict;
    }

    /**
     * API name: {@code window}
     */
    @Nullable
    public final Integer window() {
        return this.window;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.minimize != null) {
            generator.writeKey("minimize");
            generator.write(this.minimize);
        }

        if (this.predict != null) {
            generator.writeKey("predict");
            generator.write(this.predict);
        }

        if (this.window != null) {
            generator.writeKey("window");
            generator.write(this.window);
        }
    }

    // ---------------------------------------------------------------------------------------------

    public abstract static class AbstractBuilder<BuilderT extends AbstractBuilder<BuilderT>> extends
        PipelineAggregationBase.AbstractBuilder<BuilderT> {
        @Nullable
        private Boolean minimize;
        @Nullable
        private Integer predict;
        @Nullable
        private Integer window;

        protected AbstractBuilder() {}

        protected AbstractBuilder(MovingAverageAggregationBase o) {
            super(o);
            this.minimize = o.minimize;
            this.predict = o.predict;
            this.window = o.window;
        }

        protected AbstractBuilder(AbstractBuilder<BuilderT> o) {
            super(o);
            this.minimize = o.minimize;
            this.predict = o.predict;
            this.window = o.window;
        }

        /**
         * API name: {@code minimize}
         */
        @Nonnull
        public final BuilderT minimize(@Nullable Boolean value) {
            this.minimize = value;
            return self();
        }

        /**
         * API name: {@code predict}
         */
        @Nonnull
        public final BuilderT predict(@Nullable Integer value) {
            this.predict = value;
            return self();
        }

        /**
         * API name: {@code window}
         */
        @Nonnull
        public final BuilderT window(@Nullable Integer value) {
            this.window = value;
            return self();
        }
    }

    // ---------------------------------------------------------------------------------------------

    protected static <BuilderT extends AbstractBuilder<BuilderT>> void setupMovingAverageAggregationBaseDeserializer(
        ObjectDeserializer<BuilderT> op
    ) {
        setupPipelineAggregationBaseDeserializer(op);
        op.add(AbstractBuilder::minimize, JsonpDeserializer.booleanDeserializer(), "minimize");
        op.add(AbstractBuilder::predict, JsonpDeserializer.integerDeserializer(), "predict");
        op.add(AbstractBuilder::window, JsonpDeserializer.integerDeserializer(), "window");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.minimize);
        result = 31 * result + Objects.hashCode(this.predict);
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
        MovingAverageAggregationBase other = (MovingAverageAggregationBase) o;
        return Objects.equals(this.minimize, other.minimize)
            && Objects.equals(this.predict, other.predict)
            && Objects.equals(this.window, other.window);
    }
}
