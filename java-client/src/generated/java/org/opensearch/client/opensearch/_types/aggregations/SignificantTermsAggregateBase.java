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

// typedef: _types.aggregations.SignificantTermsAggregateBase

@Generated("org.opensearch.client.codegen.CodeGenerator")
public abstract class SignificantTermsAggregateBase<TBucket> extends MultiBucketAggregateBase<TBucket> {

    @Nullable
    private final Long bgCount;

    @Nullable
    private final Long docCount;

    // ---------------------------------------------------------------------------------------------

    protected SignificantTermsAggregateBase(AbstractBuilder<TBucket, ?> builder) {
        super(builder);
        this.bgCount = builder.bgCount;
        this.docCount = builder.docCount;
    }

    /**
     * API name: {@code bg_count}
     */
    @Nullable
    public final Long bgCount() {
        return this.bgCount;
    }

    /**
     * API name: {@code doc_count}
     */
    @Nullable
    public final Long docCount() {
        return this.docCount;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.bgCount != null) {
            generator.writeKey("bg_count");
            generator.write(this.bgCount);
        }

        if (this.docCount != null) {
            generator.writeKey("doc_count");
            generator.write(this.docCount);
        }
    }

    // ---------------------------------------------------------------------------------------------

    public abstract static class AbstractBuilder<TBucket, BuilderT extends AbstractBuilder<TBucket, BuilderT>> extends
        MultiBucketAggregateBase.AbstractBuilder<TBucket, BuilderT> {
        @Nullable
        private Long bgCount;
        @Nullable
        private Long docCount;

        protected AbstractBuilder() {}

        protected AbstractBuilder(SignificantTermsAggregateBase<TBucket> o) {
            super(o);
            this.bgCount = o.bgCount;
            this.docCount = o.docCount;
        }

        protected AbstractBuilder(AbstractBuilder<TBucket, BuilderT> o) {
            super(o);
            this.bgCount = o.bgCount;
            this.docCount = o.docCount;
        }

        /**
         * API name: {@code bg_count}
         */
        @Nonnull
        public final BuilderT bgCount(@Nullable Long value) {
            this.bgCount = value;
            return self();
        }

        /**
         * API name: {@code doc_count}
         */
        @Nonnull
        public final BuilderT docCount(@Nullable Long value) {
            this.docCount = value;
            return self();
        }
    }

    // ---------------------------------------------------------------------------------------------

    protected static <TBucket, BuilderT extends AbstractBuilder<TBucket, BuilderT>> void setupSignificantTermsAggregateBaseDeserializer(
        ObjectDeserializer<BuilderT> op,
        JsonpDeserializer<TBucket> tBucketDeserializer
    ) {
        setupMultiBucketAggregateBaseDeserializer(op, tBucketDeserializer);
        op.add(AbstractBuilder::bgCount, JsonpDeserializer.longDeserializer(), "bg_count");
        op.add(AbstractBuilder::docCount, JsonpDeserializer.longDeserializer(), "doc_count");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.bgCount);
        result = 31 * result + Objects.hashCode(this.docCount);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SignificantTermsAggregateBase<?> other = (SignificantTermsAggregateBase<?>) o;
        return Objects.equals(this.bgCount, other.bgCount) && Objects.equals(this.docCount, other.docCount);
    }
}
