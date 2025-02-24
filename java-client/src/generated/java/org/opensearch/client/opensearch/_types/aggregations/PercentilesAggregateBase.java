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
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;

// typedef: _types.aggregations.PercentilesAggregateBase

@Generated("org.opensearch.client.codegen.CodeGenerator")
public abstract class PercentilesAggregateBase extends AggregateBase {

    @Nonnull
    private final Percentiles values;

    // ---------------------------------------------------------------------------------------------

    protected PercentilesAggregateBase(AbstractBuilder<?> builder) {
        super(builder);
        this.values = ApiTypeHelper.requireNonNull(builder.values, this, "values");
    }

    /**
     * Required - API name: {@code values}
     */
    @Nonnull
    public final Percentiles values() {
        return this.values;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        generator.writeKey("values");
        this.values.serialize(generator, mapper);
    }

    // ---------------------------------------------------------------------------------------------

    public abstract static class AbstractBuilder<BuilderT extends AbstractBuilder<BuilderT>> extends AggregateBase.AbstractBuilder<
        BuilderT> {
        private Percentiles values;

        protected AbstractBuilder() {}

        protected AbstractBuilder(PercentilesAggregateBase o) {
            super(o);
            this.values = o.values;
        }

        protected AbstractBuilder(AbstractBuilder<BuilderT> o) {
            super(o);
            this.values = o.values;
        }

        /**
         * Required - API name: {@code values}
         */
        @Nonnull
        public final BuilderT values(Percentiles value) {
            this.values = value;
            return self();
        }

        /**
         * Required - API name: {@code values}
         */
        @Nonnull
        public final BuilderT values(Function<Percentiles.Builder, ObjectBuilder<Percentiles>> fn) {
            return values(fn.apply(new Percentiles.Builder()).build());
        }
    }

    // ---------------------------------------------------------------------------------------------

    protected static <BuilderT extends AbstractBuilder<BuilderT>> void setupPercentilesAggregateBaseDeserializer(
        ObjectDeserializer<BuilderT> op
    ) {
        setupAggregateBaseDeserializer(op);
        op.add(AbstractBuilder::values, Percentiles._DESERIALIZER, "values");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + this.values.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PercentilesAggregateBase other = (PercentilesAggregateBase) o;
        return this.values.equals(other.values);
    }
}
