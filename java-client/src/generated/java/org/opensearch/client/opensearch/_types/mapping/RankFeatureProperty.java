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

package org.opensearch.client.opensearch._types.mapping;

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
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.mapping.RankFeatureProperty

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RankFeatureProperty extends PropertyBase
    implements
        PropertyVariant,
        ToCopyableBuilder<RankFeatureProperty.Builder, RankFeatureProperty> {

    @Nullable
    private final Boolean positiveScoreImpact;

    // ---------------------------------------------------------------------------------------------

    private RankFeatureProperty(Builder builder) {
        super(builder);
        this.positiveScoreImpact = builder.positiveScoreImpact;
    }

    public static RankFeatureProperty of(Function<RankFeatureProperty.Builder, ObjectBuilder<RankFeatureProperty>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Property} variant kind.
     */
    @Override
    public Property.Kind _propertyKind() {
        return Property.Kind.RankFeature;
    }

    /**
     * API name: {@code positive_score_impact}
     */
    @Nullable
    public final Boolean positiveScoreImpact() {
        return this.positiveScoreImpact;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.write("type", "rank_feature");
        super.serializeInternal(generator, mapper);
        if (this.positiveScoreImpact != null) {
            generator.writeKey("positive_score_impact");
            generator.write(this.positiveScoreImpact);
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
     * Builder for {@link RankFeatureProperty}.
     */
    public static class Builder extends PropertyBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, RankFeatureProperty> {
        @Nullable
        private Boolean positiveScoreImpact;

        public Builder() {}

        private Builder(RankFeatureProperty o) {
            super(o);
            this.positiveScoreImpact = o.positiveScoreImpact;
        }

        private Builder(Builder o) {
            super(o);
            this.positiveScoreImpact = o.positiveScoreImpact;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        @Override
        @Nonnull
        protected Builder self() {
            return this;
        }

        /**
         * API name: {@code positive_score_impact}
         */
        @Nonnull
        public final Builder positiveScoreImpact(@Nullable Boolean value) {
            this.positiveScoreImpact = value;
            return this;
        }

        /**
         * Builds a {@link RankFeatureProperty}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RankFeatureProperty build() {
            _checkSingleUse();

            return new RankFeatureProperty(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RankFeatureProperty}
     */
    public static final JsonpDeserializer<RankFeatureProperty> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RankFeatureProperty::setupRankFeaturePropertyDeserializer
    );

    protected static void setupRankFeaturePropertyDeserializer(ObjectDeserializer<RankFeatureProperty.Builder> op) {
        setupPropertyBaseDeserializer(op);
        op.add(Builder::positiveScoreImpact, JsonpDeserializer.booleanDeserializer(), "positive_score_impact");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.positiveScoreImpact);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RankFeatureProperty other = (RankFeatureProperty) o;
        return Objects.equals(this.positiveScoreImpact, other.positiveScoreImpact);
    }
}
