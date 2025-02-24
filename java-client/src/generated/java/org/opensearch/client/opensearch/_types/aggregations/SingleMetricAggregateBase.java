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

// typedef: _types.aggregations.SingleMetricAggregateBase

@Generated("org.opensearch.client.codegen.CodeGenerator")
public abstract class SingleMetricAggregateBase extends AggregateBase {

    @Nullable
    private final Double value;

    @Nullable
    private final String valueAsString;

    // ---------------------------------------------------------------------------------------------

    protected SingleMetricAggregateBase(AbstractBuilder<?> builder) {
        super(builder);
        this.value = builder.value;
        this.valueAsString = builder.valueAsString;
    }

    /**
     * The metric value. A missing value generally means that there was no data to aggregate, unless specified otherwise.
     * <p>
     * API name: {@code value}
     * </p>
     */
    @Nullable
    public final Double value() {
        return this.value;
    }

    /**
     * API name: {@code value_as_string}
     */
    @Nullable
    public final String valueAsString() {
        return this.valueAsString;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.value != null) {
            generator.writeKey("value");
            generator.write(this.value);
        }

        if (this.valueAsString != null) {
            generator.writeKey("value_as_string");
            generator.write(this.valueAsString);
        }
    }

    // ---------------------------------------------------------------------------------------------

    public abstract static class AbstractBuilder<BuilderT extends AbstractBuilder<BuilderT>> extends AggregateBase.AbstractBuilder<
        BuilderT> {
        @Nullable
        private Double value;
        @Nullable
        private String valueAsString;

        protected AbstractBuilder() {}

        protected AbstractBuilder(SingleMetricAggregateBase o) {
            super(o);
            this.value = o.value;
            this.valueAsString = o.valueAsString;
        }

        protected AbstractBuilder(AbstractBuilder<BuilderT> o) {
            super(o);
            this.value = o.value;
            this.valueAsString = o.valueAsString;
        }

        /**
         * The metric value. A missing value generally means that there was no data to aggregate, unless specified otherwise.
         * <p>
         * API name: {@code value}
         * </p>
         */
        @Nonnull
        public final BuilderT value(@Nullable Double value) {
            this.value = value;
            return self();
        }

        /**
         * API name: {@code value_as_string}
         */
        @Nonnull
        public final BuilderT valueAsString(@Nullable String value) {
            this.valueAsString = value;
            return self();
        }
    }

    // ---------------------------------------------------------------------------------------------

    protected static <BuilderT extends AbstractBuilder<BuilderT>> void setupSingleMetricAggregateBaseDeserializer(
        ObjectDeserializer<BuilderT> op
    ) {
        setupAggregateBaseDeserializer(op);
        op.add(AbstractBuilder::value, JsonpDeserializer.doubleDeserializer(), "value");
        op.add(AbstractBuilder::valueAsString, JsonpDeserializer.stringDeserializer(), "value_as_string");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.value);
        result = 31 * result + Objects.hashCode(this.valueAsString);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SingleMetricAggregateBase other = (SingleMetricAggregateBase) o;
        return Objects.equals(this.value, other.value) && Objects.equals(this.valueAsString, other.valueAsString);
    }
}
