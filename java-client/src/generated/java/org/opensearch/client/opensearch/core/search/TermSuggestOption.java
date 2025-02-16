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

package org.opensearch.client.opensearch.core.search;

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

// typedef: core.search.TermSuggestOption

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class TermSuggestOption implements PlainJsonSerializable, ToCopyableBuilder<TermSuggestOption.Builder, TermSuggestOption> {

    @Nullable
    private final Boolean collateMatch;

    @Nullable
    private final Long freq;

    @Nullable
    private final String highlighted;

    private final double score;

    @Nonnull
    private final String text;

    // ---------------------------------------------------------------------------------------------

    private TermSuggestOption(Builder builder) {
        this.collateMatch = builder.collateMatch;
        this.freq = builder.freq;
        this.highlighted = builder.highlighted;
        this.score = ApiTypeHelper.requireNonNull(builder.score, this, "score");
        this.text = ApiTypeHelper.requireNonNull(builder.text, this, "text");
    }

    public static TermSuggestOption of(Function<TermSuggestOption.Builder, ObjectBuilder<TermSuggestOption>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code collate_match}
     */
    @Nullable
    public final Boolean collateMatch() {
        return this.collateMatch;
    }

    /**
     * API name: {@code freq}
     */
    @Nullable
    public final Long freq() {
        return this.freq;
    }

    /**
     * API name: {@code highlighted}
     */
    @Nullable
    public final String highlighted() {
        return this.highlighted;
    }

    /**
     * Required - API name: {@code score}
     */
    public final double score() {
        return this.score;
    }

    /**
     * Required - API name: {@code text}
     */
    @Nonnull
    public final String text() {
        return this.text;
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
        if (this.collateMatch != null) {
            generator.writeKey("collate_match");
            generator.write(this.collateMatch);
        }

        if (this.freq != null) {
            generator.writeKey("freq");
            generator.write(this.freq);
        }

        if (this.highlighted != null) {
            generator.writeKey("highlighted");
            generator.write(this.highlighted);
        }

        generator.writeKey("score");
        generator.write(this.score);

        generator.writeKey("text");
        generator.write(this.text);
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
     * Builder for {@link TermSuggestOption}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, TermSuggestOption> {
        @Nullable
        private Boolean collateMatch;
        @Nullable
        private Long freq;
        @Nullable
        private String highlighted;
        private Double score;
        private String text;

        public Builder() {}

        private Builder(TermSuggestOption o) {
            this.collateMatch = o.collateMatch;
            this.freq = o.freq;
            this.highlighted = o.highlighted;
            this.score = o.score;
            this.text = o.text;
        }

        private Builder(Builder o) {
            this.collateMatch = o.collateMatch;
            this.freq = o.freq;
            this.highlighted = o.highlighted;
            this.score = o.score;
            this.text = o.text;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code collate_match}
         */
        @Nonnull
        public final Builder collateMatch(@Nullable Boolean value) {
            this.collateMatch = value;
            return this;
        }

        /**
         * API name: {@code freq}
         */
        @Nonnull
        public final Builder freq(@Nullable Long value) {
            this.freq = value;
            return this;
        }

        /**
         * API name: {@code highlighted}
         */
        @Nonnull
        public final Builder highlighted(@Nullable String value) {
            this.highlighted = value;
            return this;
        }

        /**
         * Required - API name: {@code score}
         */
        @Nonnull
        public final Builder score(double value) {
            this.score = value;
            return this;
        }

        /**
         * Required - API name: {@code text}
         */
        @Nonnull
        public final Builder text(String value) {
            this.text = value;
            return this;
        }

        /**
         * Builds a {@link TermSuggestOption}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public TermSuggestOption build() {
            _checkSingleUse();

            return new TermSuggestOption(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link TermSuggestOption}
     */
    public static final JsonpDeserializer<TermSuggestOption> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        TermSuggestOption::setupTermSuggestOptionDeserializer
    );

    protected static void setupTermSuggestOptionDeserializer(ObjectDeserializer<TermSuggestOption.Builder> op) {
        op.add(Builder::collateMatch, JsonpDeserializer.booleanDeserializer(), "collate_match");
        op.add(Builder::freq, JsonpDeserializer.longDeserializer(), "freq");
        op.add(Builder::highlighted, JsonpDeserializer.stringDeserializer(), "highlighted");
        op.add(Builder::score, JsonpDeserializer.doubleDeserializer(), "score");
        op.add(Builder::text, JsonpDeserializer.stringDeserializer(), "text");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.collateMatch);
        result = 31 * result + Objects.hashCode(this.freq);
        result = 31 * result + Objects.hashCode(this.highlighted);
        result = 31 * result + Double.hashCode(this.score);
        result = 31 * result + this.text.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        TermSuggestOption other = (TermSuggestOption) o;
        return Objects.equals(this.collateMatch, other.collateMatch)
            && Objects.equals(this.freq, other.freq)
            && Objects.equals(this.highlighted, other.highlighted)
            && this.score == other.score
            && this.text.equals(other.text);
    }
}
