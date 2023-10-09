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

package org.opensearch.client.opensearch._types.aggregations;

import java.util.function.Function;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.ObjectBuilder;

// typedef: _types.aggregations.CumulativeCardinalityAggregation

@JsonpDeserializable
public class CumulativeCardinalityAggregation extends PipelineAggregationBase implements AggregationVariant {
    // ---------------------------------------------------------------------------------------------

    private CumulativeCardinalityAggregation(Builder builder) {
        super(builder);

    }

    public static CumulativeCardinalityAggregation of(Function<Builder, ObjectBuilder<CumulativeCardinalityAggregation>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Aggregation variant kind.
     */
    @Override
    public Aggregation.Kind _aggregationKind() {
        return Aggregation.Kind.CumulativeCardinality;
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link CumulativeCardinalityAggregation}.
     */

    public static class Builder extends PipelineAggregationBase.AbstractBuilder<Builder>
        implements
            ObjectBuilder<CumulativeCardinalityAggregation> {
        @Override
        protected Builder self() {
            return this;
        }

        /**
         * Builds a {@link CumulativeCardinalityAggregation}.
         *
         * @throws NullPointerException
         *             if some of the required fields are null.
         */
        public CumulativeCardinalityAggregation build() {
            _checkSingleUse();

            return new CumulativeCardinalityAggregation(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link CumulativeCardinalityAggregation}
     */
    public static final JsonpDeserializer<CumulativeCardinalityAggregation> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CumulativeCardinalityAggregation::setupCumulativeCardinalityAggregationDeserializer
    );

    protected static void setupCumulativeCardinalityAggregationDeserializer(
        ObjectDeserializer<CumulativeCardinalityAggregation.Builder> op
    ) {
        PipelineAggregationBase.setupPipelineAggregationBaseDeserializer(op);

    }

}
