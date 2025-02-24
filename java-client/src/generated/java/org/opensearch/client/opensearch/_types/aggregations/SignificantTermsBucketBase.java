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

// typedef: _types.aggregations.SignificantTermsBucketBase

@Generated("org.opensearch.client.codegen.CodeGenerator")
public abstract class SignificantTermsBucketBase extends MultiBucketBase {

    private final long bgCount;

    private final double score;

    // ---------------------------------------------------------------------------------------------

    protected SignificantTermsBucketBase(AbstractBuilder<?> builder) {
        super(builder);
        this.bgCount = ApiTypeHelper.requireNonNull(builder.bgCount, this, "bgCount");
        this.score = ApiTypeHelper.requireNonNull(builder.score, this, "score");
    }

    /**
     * Required - API name: {@code bg_count}
     */
    public final long bgCount() {
        return this.bgCount;
    }

    /**
     * Required - API name: {@code score}
     */
    public final double score() {
        return this.score;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        generator.writeKey("bg_count");
        generator.write(this.bgCount);

        generator.writeKey("score");
        generator.write(this.score);
    }

    // ---------------------------------------------------------------------------------------------

    public abstract static class AbstractBuilder<BuilderT extends AbstractBuilder<BuilderT>> extends MultiBucketBase.AbstractBuilder<
        BuilderT> {
        private Long bgCount;
        private Double score;

        protected AbstractBuilder() {}

        protected AbstractBuilder(SignificantTermsBucketBase o) {
            super(o);
            this.bgCount = o.bgCount;
            this.score = o.score;
        }

        protected AbstractBuilder(AbstractBuilder<BuilderT> o) {
            super(o);
            this.bgCount = o.bgCount;
            this.score = o.score;
        }

        /**
         * Required - API name: {@code bg_count}
         */
        @Nonnull
        public final BuilderT bgCount(long value) {
            this.bgCount = value;
            return self();
        }

        /**
         * Required - API name: {@code score}
         */
        @Nonnull
        public final BuilderT score(double value) {
            this.score = value;
            return self();
        }
    }

    // ---------------------------------------------------------------------------------------------

    protected static <BuilderT extends AbstractBuilder<BuilderT>> void setupSignificantTermsBucketBaseDeserializer(
        ObjectDeserializer<BuilderT> op
    ) {
        setupMultiBucketBaseDeserializer(op);
        op.add(AbstractBuilder::bgCount, JsonpDeserializer.longDeserializer(), "bg_count");
        op.add(AbstractBuilder::score, JsonpDeserializer.doubleDeserializer(), "score");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Long.hashCode(this.bgCount);
        result = 31 * result + Double.hashCode(this.score);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SignificantTermsBucketBase other = (SignificantTermsBucketBase) o;
        return this.bgCount == other.bgCount && this.score == other.score;
    }
}
