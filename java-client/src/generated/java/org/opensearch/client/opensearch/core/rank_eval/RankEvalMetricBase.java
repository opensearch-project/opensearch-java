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

package org.opensearch.client.opensearch.core.rank_eval;

import jakarta.json.stream.JsonGenerator;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: core.rank_eval.RankEvalMetricBase

@Generated("org.opensearch.client.codegen.CodeGenerator")
public abstract class RankEvalMetricBase implements PlainJsonSerializable {

    @Nullable
    private final Integer k;

    // ---------------------------------------------------------------------------------------------

    protected RankEvalMetricBase(AbstractBuilder<?> builder) {
        this.k = builder.k;
    }

    /**
     * Sets the maximum number of documents retrieved per query. This value replaces the <code>size</code> parameter in the query.
     * <p>
     * API name: {@code k}
     * </p>
     */
    @Nullable
    public final Integer k() {
        return this.k;
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
        if (this.k != null) {
            generator.writeKey("k");
            generator.write(this.k);
        }
    }

    // ---------------------------------------------------------------------------------------------

    public abstract static class AbstractBuilder<BuilderT extends AbstractBuilder<BuilderT>> extends ObjectBuilderBase {
        @Nullable
        private Integer k;

        protected AbstractBuilder() {}

        protected AbstractBuilder(RankEvalMetricBase o) {
            this.k = o.k;
        }

        protected AbstractBuilder(AbstractBuilder<BuilderT> o) {
            this.k = o.k;
        }

        @Nonnull
        protected abstract BuilderT self();

        /**
         * Sets the maximum number of documents retrieved per query. This value replaces the <code>size</code> parameter in the query.
         * <p>
         * API name: {@code k}
         * </p>
         */
        @Nonnull
        public final BuilderT k(@Nullable Integer value) {
            this.k = value;
            return self();
        }
    }

    // ---------------------------------------------------------------------------------------------

    protected static <BuilderT extends AbstractBuilder<BuilderT>> void setupRankEvalMetricBaseDeserializer(
        ObjectDeserializer<BuilderT> op
    ) {
        op.add(AbstractBuilder::k, JsonpDeserializer.integerDeserializer(), "k");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.k);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RankEvalMetricBase other = (RankEvalMetricBase) o;
        return Objects.equals(this.k, other.k);
    }
}
