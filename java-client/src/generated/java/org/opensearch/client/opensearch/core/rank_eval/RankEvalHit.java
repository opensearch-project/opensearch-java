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
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: core.rank_eval.RankEvalHit

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RankEvalHit implements PlainJsonSerializable, ToCopyableBuilder<RankEvalHit.Builder, RankEvalHit> {

    @Nonnull
    private final String id;

    @Nonnull
    private final String index;

    private final double score;

    // ---------------------------------------------------------------------------------------------

    private RankEvalHit(Builder builder) {
        this.id = ApiTypeHelper.requireNonNull(builder.id, this, "id");
        this.index = ApiTypeHelper.requireNonNull(builder.index, this, "index");
        this.score = ApiTypeHelper.requireNonNull(builder.score, this, "score");
    }

    public static RankEvalHit of(Function<RankEvalHit.Builder, ObjectBuilder<RankEvalHit>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code _id}
     */
    @Nonnull
    public final String id() {
        return this.id;
    }

    /**
     * Required - API name: {@code _index}
     */
    @Nonnull
    public final String index() {
        return this.index;
    }

    /**
     * Required - API name: {@code _score}
     */
    public final double score() {
        return this.score;
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
        generator.writeKey("_id");
        generator.write(this.id);

        generator.writeKey("_index");
        generator.write(this.index);

        generator.writeKey("_score");
        generator.write(this.score);
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    @Nonnull
    public Builder toBuilder() {
        return new Builder(this);
    }

    @Nonnull
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builder for {@link RankEvalHit}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, RankEvalHit> {
        private String id;
        private String index;
        private Double score;

        public Builder() {}

        private Builder(RankEvalHit o) {
            this.id = o.id;
            this.index = o.index;
            this.score = o.score;
        }

        private Builder(Builder o) {
            this.id = o.id;
            this.index = o.index;
            this.score = o.score;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code _id}
         */
        @Nonnull
        public final Builder id(String value) {
            this.id = value;
            return this;
        }

        /**
         * Required - API name: {@code _index}
         */
        @Nonnull
        public final Builder index(String value) {
            this.index = value;
            return this;
        }

        /**
         * Required - API name: {@code _score}
         */
        @Nonnull
        public final Builder score(double value) {
            this.score = value;
            return this;
        }

        /**
         * Builds a {@link RankEvalHit}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RankEvalHit build() {
            _checkSingleUse();

            return new RankEvalHit(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RankEvalHit}
     */
    public static final JsonpDeserializer<RankEvalHit> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RankEvalHit::setupRankEvalHitDeserializer
    );

    protected static void setupRankEvalHitDeserializer(ObjectDeserializer<RankEvalHit.Builder> op) {
        op.add(Builder::id, JsonpDeserializer.stringDeserializer(), "_id");
        op.add(Builder::index, JsonpDeserializer.stringDeserializer(), "_index");
        op.add(Builder::score, JsonpDeserializer.doubleDeserializer(), "_score");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.id.hashCode();
        result = 31 * result + this.index.hashCode();
        result = 31 * result + Double.hashCode(this.score);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RankEvalHit other = (RankEvalHit) o;
        return this.id.equals(other.id) && this.index.equals(other.index) && this.score == other.score;
    }
}
