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
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.ApiTypeHelper;

// typedef: _types.aggregations.SingleBucketAggregateBase

@Generated("org.opensearch.client.codegen.CodeGenerator")
public abstract class SingleBucketAggregateBase extends AggregateBase {

    private final long docCount;

    // ---------------------------------------------------------------------------------------------

    protected SingleBucketAggregateBase(AbstractBuilder<?> builder) {
        super(builder);
        this.docCount = ApiTypeHelper.requireNonNull(builder.docCount, this, "docCount");
    }

    /**
     * Required - API name: {@code doc_count}
     */
    public final long docCount() {
        return this.docCount;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        generator.writeKey("doc_count");
        generator.write(this.docCount);
    }

    // ---------------------------------------------------------------------------------------------

    public abstract static class AbstractBuilder<BuilderT extends AbstractBuilder<BuilderT>> extends AggregateBase.AbstractBuilder<
        BuilderT> {
        private Long docCount;

        protected AbstractBuilder() {}

        protected AbstractBuilder(SingleBucketAggregateBase o) {
            super(o);
            this.docCount = o.docCount;
        }

        protected AbstractBuilder(AbstractBuilder<BuilderT> o) {
            super(o);
            this.docCount = o.docCount;
        }

        /**
         * Required - API name: {@code doc_count}
         */
        @Nonnull
        public final BuilderT docCount(long value) {
            this.docCount = value;
            return self();
        }
    }

    // ---------------------------------------------------------------------------------------------

    protected static <BuilderT extends AbstractBuilder<BuilderT>> void setupSingleBucketAggregateBaseDeserializer(
        ObjectDeserializer<BuilderT> op
    ) {
        setupAggregateBaseDeserializer(op);
        op.add(AbstractBuilder::docCount, JsonpDeserializer.longDeserializer(), "doc_count");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Long.hashCode(this.docCount);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SingleBucketAggregateBase other = (SingleBucketAggregateBase) o;
        return this.docCount == other.docCount;
    }
}
