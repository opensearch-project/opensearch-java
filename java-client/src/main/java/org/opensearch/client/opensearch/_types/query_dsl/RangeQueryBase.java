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

package org.opensearch.client.opensearch._types.query_dsl;

import jakarta.json.stream.JsonGenerator;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectDeserializer;

// typedef: _types.query_dsl.RangeQueryBase

public abstract class RangeQueryBase extends QueryBase {
    @Nullable
    private final RangeRelation relation;

    // ---------------------------------------------------------------------------------------------

    protected RangeQueryBase(AbstractBuilder<?> builder) {
        super(builder);

        this.relation = builder.relation;

    }

    /**
     * API name: {@code relation}
     */
    @Nullable
    public final RangeRelation relation() {
        return this.relation;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {

        super.serializeInternal(generator, mapper);
        if (this.relation != null) {
            generator.writeKey("relation");
            this.relation.serialize(generator, mapper);
        }

    }

    public abstract static class AbstractBuilder<BuilderT extends AbstractBuilder<BuilderT>> extends QueryBase.AbstractBuilder<BuilderT> {
        @Nullable
        private RangeRelation relation;

        /**
         * API name: {@code relation}
         */
        public final BuilderT relation(@Nullable RangeRelation value) {
            this.relation = value;
            return self();
        }

    }

    // ---------------------------------------------------------------------------------------------
    protected static <BuilderT extends AbstractBuilder<BuilderT>> void setupRangeQueryBaseDeserializer(ObjectDeserializer<BuilderT> op) {
        setupQueryBaseDeserializer(op);
        op.add(AbstractBuilder::relation, RangeRelation._DESERIALIZER, "relation");

    }

}
