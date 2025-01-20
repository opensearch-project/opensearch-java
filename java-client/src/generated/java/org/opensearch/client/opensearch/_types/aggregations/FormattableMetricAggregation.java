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

// typedef: _types.aggregations.FormattableMetricAggregation

@Generated("org.opensearch.client.codegen.CodeGenerator")
public abstract class FormattableMetricAggregation extends MetricAggregationBase {

    @Nullable
    private final String format;

    // ---------------------------------------------------------------------------------------------

    protected FormattableMetricAggregation(AbstractBuilder<?> builder) {
        super(builder);
        this.format = builder.format;
    }

    /**
     * API name: {@code format}
     */
    @Nullable
    public final String format() {
        return this.format;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.format != null) {
            generator.writeKey("format");
            generator.write(this.format);
        }
    }

    // ---------------------------------------------------------------------------------------------

    protected abstract static class AbstractBuilder<BuilderT extends AbstractBuilder<BuilderT>> extends
        MetricAggregationBase.AbstractBuilder<BuilderT> {
        @Nullable
        private String format;

        protected AbstractBuilder() {}

        protected AbstractBuilder(FormattableMetricAggregation o) {
            super(o);
            this.format = o.format;
        }

        protected AbstractBuilder(AbstractBuilder<BuilderT> o) {
            super(o);
            this.format = o.format;
        }

        /**
         * API name: {@code format}
         */
        @Nonnull
        public final BuilderT format(@Nullable String value) {
            this.format = value;
            return self();
        }
    }

    // ---------------------------------------------------------------------------------------------

    protected static <BuilderT extends AbstractBuilder<BuilderT>> void setupFormattableMetricAggregationDeserializer(
        ObjectDeserializer<BuilderT> op
    ) {
        setupMetricAggregationBaseDeserializer(op);
        op.add(AbstractBuilder::format, JsonpDeserializer.stringDeserializer(), "format");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.format);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        FormattableMetricAggregation other = (FormattableMetricAggregation) o;
        return Objects.equals(this.format, other.format);
    }
}
