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

// typedef: _types.aggregations.TermsAggregateBase

@Generated("org.opensearch.client.codegen.CodeGenerator")
public abstract class TermsAggregateBase<TBucket> extends MultiBucketAggregateBase<TBucket> {

    @Nullable
    private final Long docCountErrorUpperBound;

    @Nullable
    private final Long sumOtherDocCount;

    // ---------------------------------------------------------------------------------------------

    protected TermsAggregateBase(AbstractBuilder<TBucket, ?> builder) {
        super(builder);
        this.docCountErrorUpperBound = builder.docCountErrorUpperBound;
        this.sumOtherDocCount = builder.sumOtherDocCount;
    }

    /**
     * API name: {@code doc_count_error_upper_bound}
     */
    @Nullable
    public final Long docCountErrorUpperBound() {
        return this.docCountErrorUpperBound;
    }

    /**
     * API name: {@code sum_other_doc_count}
     */
    @Nullable
    public final Long sumOtherDocCount() {
        return this.sumOtherDocCount;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.docCountErrorUpperBound != null) {
            generator.writeKey("doc_count_error_upper_bound");
            generator.write(this.docCountErrorUpperBound);
        }

        if (this.sumOtherDocCount != null) {
            generator.writeKey("sum_other_doc_count");
            generator.write(this.sumOtherDocCount);
        }
    }

    // ---------------------------------------------------------------------------------------------

    public abstract static class AbstractBuilder<TBucket, BuilderT extends AbstractBuilder<TBucket, BuilderT>> extends
        MultiBucketAggregateBase.AbstractBuilder<TBucket, BuilderT> {
        @Nullable
        private Long docCountErrorUpperBound;
        @Nullable
        private Long sumOtherDocCount;

        protected AbstractBuilder() {}

        protected AbstractBuilder(TermsAggregateBase<TBucket> o) {
            super(o);
            this.docCountErrorUpperBound = o.docCountErrorUpperBound;
            this.sumOtherDocCount = o.sumOtherDocCount;
        }

        protected AbstractBuilder(AbstractBuilder<TBucket, BuilderT> o) {
            super(o);
            this.docCountErrorUpperBound = o.docCountErrorUpperBound;
            this.sumOtherDocCount = o.sumOtherDocCount;
        }

        /**
         * API name: {@code doc_count_error_upper_bound}
         */
        @Nonnull
        public final BuilderT docCountErrorUpperBound(@Nullable Long value) {
            this.docCountErrorUpperBound = value;
            return self();
        }

        /**
         * API name: {@code sum_other_doc_count}
         */
        @Nonnull
        public final BuilderT sumOtherDocCount(@Nullable Long value) {
            this.sumOtherDocCount = value;
            return self();
        }
    }

    // ---------------------------------------------------------------------------------------------

    protected static <TBucket, BuilderT extends AbstractBuilder<TBucket, BuilderT>> void setupTermsAggregateBaseDeserializer(
        ObjectDeserializer<BuilderT> op,
        JsonpDeserializer<TBucket> tBucketDeserializer
    ) {
        setupMultiBucketAggregateBaseDeserializer(op, tBucketDeserializer);
        op.add(AbstractBuilder::docCountErrorUpperBound, JsonpDeserializer.longDeserializer(), "doc_count_error_upper_bound");
        op.add(AbstractBuilder::sumOtherDocCount, JsonpDeserializer.longDeserializer(), "sum_other_doc_count");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.docCountErrorUpperBound);
        result = 31 * result + Objects.hashCode(this.sumOtherDocCount);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        TermsAggregateBase<?> other = (TermsAggregateBase<?>) o;
        return Objects.equals(this.docCountErrorUpperBound, other.docCountErrorUpperBound)
            && Objects.equals(this.sumOtherDocCount, other.sumOtherDocCount);
    }
}
