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
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
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

// typedef: core.rank_eval.RankEvalHitItem

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RankEvalHitItem implements PlainJsonSerializable, ToCopyableBuilder<RankEvalHitItem.Builder, RankEvalHitItem> {

    @Nonnull
    private final RankEvalHit hit;

    @Nullable
    private final Integer rating;

    // ---------------------------------------------------------------------------------------------

    private RankEvalHitItem(Builder builder) {
        this.hit = ApiTypeHelper.requireNonNull(builder.hit, this, "hit");
        this.rating = builder.rating;
    }

    public static RankEvalHitItem of(Function<RankEvalHitItem.Builder, ObjectBuilder<RankEvalHitItem>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code hit}
     */
    @Nonnull
    public final RankEvalHit hit() {
        return this.hit;
    }

    /**
     * API name: {@code rating}
     */
    @Nullable
    public final Integer rating() {
        return this.rating;
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
        generator.writeKey("hit");
        this.hit.serialize(generator, mapper);

        if (this.rating != null) {
            generator.writeKey("rating");
            generator.write(this.rating);
        }
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
     * Builder for {@link RankEvalHitItem}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, RankEvalHitItem> {
        private RankEvalHit hit;
        @Nullable
        private Integer rating;

        public Builder() {}

        private Builder(RankEvalHitItem o) {
            this.hit = o.hit;
            this.rating = o.rating;
        }

        private Builder(Builder o) {
            this.hit = o.hit;
            this.rating = o.rating;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code hit}
         */
        @Nonnull
        public final Builder hit(RankEvalHit value) {
            this.hit = value;
            return this;
        }

        /**
         * Required - API name: {@code hit}
         */
        @Nonnull
        public final Builder hit(Function<RankEvalHit.Builder, ObjectBuilder<RankEvalHit>> fn) {
            return hit(fn.apply(new RankEvalHit.Builder()).build());
        }

        /**
         * API name: {@code rating}
         */
        @Nonnull
        public final Builder rating(@Nullable Integer value) {
            this.rating = value;
            return this;
        }

        /**
         * Builds a {@link RankEvalHitItem}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RankEvalHitItem build() {
            _checkSingleUse();

            return new RankEvalHitItem(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RankEvalHitItem}
     */
    public static final JsonpDeserializer<RankEvalHitItem> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RankEvalHitItem::setupRankEvalHitItemDeserializer
    );

    protected static void setupRankEvalHitItemDeserializer(ObjectDeserializer<RankEvalHitItem.Builder> op) {
        op.add(Builder::hit, RankEvalHit._DESERIALIZER, "hit");
        op.add(Builder::rating, JsonpDeserializer.integerDeserializer(), "rating");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.hit.hashCode();
        result = 31 * result + Objects.hashCode(this.rating);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RankEvalHitItem other = (RankEvalHitItem) o;
        return this.hit.equals(other.hit) && Objects.equals(this.rating, other.rating);
    }
}
