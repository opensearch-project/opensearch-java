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
import org.opensearch.client.opensearch._types.SuggestMode;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: core.search.DirectGenerator

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class DirectGenerator implements PlainJsonSerializable, ToCopyableBuilder<DirectGenerator.Builder, DirectGenerator> {

    @Nonnull
    private final String field;

    @Nullable
    private final Integer maxEdits;

    @Nullable
    private final Float maxInspections;

    @Nullable
    private final Float maxTermFreq;

    @Nullable
    private final Float minDocFreq;

    @Nullable
    private final Integer minWordLength;

    @Nullable
    private final String postFilter;

    @Nullable
    private final String preFilter;

    @Nullable
    private final Integer prefixLength;

    @Nullable
    private final Integer size;

    @Nullable
    private final SuggestMode suggestMode;

    // ---------------------------------------------------------------------------------------------

    private DirectGenerator(Builder builder) {
        this.field = ApiTypeHelper.requireNonNull(builder.field, this, "field");
        this.maxEdits = builder.maxEdits;
        this.maxInspections = builder.maxInspections;
        this.maxTermFreq = builder.maxTermFreq;
        this.minDocFreq = builder.minDocFreq;
        this.minWordLength = builder.minWordLength;
        this.postFilter = builder.postFilter;
        this.preFilter = builder.preFilter;
        this.prefixLength = builder.prefixLength;
        this.size = builder.size;
        this.suggestMode = builder.suggestMode;
    }

    public static DirectGenerator of(Function<DirectGenerator.Builder, ObjectBuilder<DirectGenerator>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code field}
     */
    @Nonnull
    public final String field() {
        return this.field;
    }

    /**
     * API name: {@code max_edits}
     */
    @Nullable
    public final Integer maxEdits() {
        return this.maxEdits;
    }

    /**
     * API name: {@code max_inspections}
     */
    @Nullable
    public final Float maxInspections() {
        return this.maxInspections;
    }

    /**
     * API name: {@code max_term_freq}
     */
    @Nullable
    public final Float maxTermFreq() {
        return this.maxTermFreq;
    }

    /**
     * API name: {@code min_doc_freq}
     */
    @Nullable
    public final Float minDocFreq() {
        return this.minDocFreq;
    }

    /**
     * API name: {@code min_word_length}
     */
    @Nullable
    public final Integer minWordLength() {
        return this.minWordLength;
    }

    /**
     * API name: {@code post_filter}
     */
    @Nullable
    public final String postFilter() {
        return this.postFilter;
    }

    /**
     * API name: {@code pre_filter}
     */
    @Nullable
    public final String preFilter() {
        return this.preFilter;
    }

    /**
     * API name: {@code prefix_length}
     */
    @Nullable
    public final Integer prefixLength() {
        return this.prefixLength;
    }

    /**
     * API name: {@code size}
     */
    @Nullable
    public final Integer size() {
        return this.size;
    }

    /**
     * API name: {@code suggest_mode}
     */
    @Nullable
    public final SuggestMode suggestMode() {
        return this.suggestMode;
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
        generator.writeKey("field");
        generator.write(this.field);

        if (this.maxEdits != null) {
            generator.writeKey("max_edits");
            generator.write(this.maxEdits);
        }

        if (this.maxInspections != null) {
            generator.writeKey("max_inspections");
            generator.write(this.maxInspections);
        }

        if (this.maxTermFreq != null) {
            generator.writeKey("max_term_freq");
            generator.write(this.maxTermFreq);
        }

        if (this.minDocFreq != null) {
            generator.writeKey("min_doc_freq");
            generator.write(this.minDocFreq);
        }

        if (this.minWordLength != null) {
            generator.writeKey("min_word_length");
            generator.write(this.minWordLength);
        }

        if (this.postFilter != null) {
            generator.writeKey("post_filter");
            generator.write(this.postFilter);
        }

        if (this.preFilter != null) {
            generator.writeKey("pre_filter");
            generator.write(this.preFilter);
        }

        if (this.prefixLength != null) {
            generator.writeKey("prefix_length");
            generator.write(this.prefixLength);
        }

        if (this.size != null) {
            generator.writeKey("size");
            generator.write(this.size);
        }

        if (this.suggestMode != null) {
            generator.writeKey("suggest_mode");
            this.suggestMode.serialize(generator, mapper);
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
     * Builder for {@link DirectGenerator}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, DirectGenerator> {
        private String field;
        @Nullable
        private Integer maxEdits;
        @Nullable
        private Float maxInspections;
        @Nullable
        private Float maxTermFreq;
        @Nullable
        private Float minDocFreq;
        @Nullable
        private Integer minWordLength;
        @Nullable
        private String postFilter;
        @Nullable
        private String preFilter;
        @Nullable
        private Integer prefixLength;
        @Nullable
        private Integer size;
        @Nullable
        private SuggestMode suggestMode;

        public Builder() {}

        private Builder(DirectGenerator o) {
            this.field = o.field;
            this.maxEdits = o.maxEdits;
            this.maxInspections = o.maxInspections;
            this.maxTermFreq = o.maxTermFreq;
            this.minDocFreq = o.minDocFreq;
            this.minWordLength = o.minWordLength;
            this.postFilter = o.postFilter;
            this.preFilter = o.preFilter;
            this.prefixLength = o.prefixLength;
            this.size = o.size;
            this.suggestMode = o.suggestMode;
        }

        private Builder(Builder o) {
            this.field = o.field;
            this.maxEdits = o.maxEdits;
            this.maxInspections = o.maxInspections;
            this.maxTermFreq = o.maxTermFreq;
            this.minDocFreq = o.minDocFreq;
            this.minWordLength = o.minWordLength;
            this.postFilter = o.postFilter;
            this.preFilter = o.preFilter;
            this.prefixLength = o.prefixLength;
            this.size = o.size;
            this.suggestMode = o.suggestMode;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code field}
         */
        @Nonnull
        public final Builder field(String value) {
            this.field = value;
            return this;
        }

        /**
         * API name: {@code max_edits}
         */
        @Nonnull
        public final Builder maxEdits(@Nullable Integer value) {
            this.maxEdits = value;
            return this;
        }

        /**
         * API name: {@code max_inspections}
         */
        @Nonnull
        public final Builder maxInspections(@Nullable Float value) {
            this.maxInspections = value;
            return this;
        }

        /**
         * API name: {@code max_term_freq}
         */
        @Nonnull
        public final Builder maxTermFreq(@Nullable Float value) {
            this.maxTermFreq = value;
            return this;
        }

        /**
         * API name: {@code min_doc_freq}
         */
        @Nonnull
        public final Builder minDocFreq(@Nullable Float value) {
            this.minDocFreq = value;
            return this;
        }

        /**
         * API name: {@code min_word_length}
         */
        @Nonnull
        public final Builder minWordLength(@Nullable Integer value) {
            this.minWordLength = value;
            return this;
        }

        /**
         * API name: {@code post_filter}
         */
        @Nonnull
        public final Builder postFilter(@Nullable String value) {
            this.postFilter = value;
            return this;
        }

        /**
         * API name: {@code pre_filter}
         */
        @Nonnull
        public final Builder preFilter(@Nullable String value) {
            this.preFilter = value;
            return this;
        }

        /**
         * API name: {@code prefix_length}
         */
        @Nonnull
        public final Builder prefixLength(@Nullable Integer value) {
            this.prefixLength = value;
            return this;
        }

        /**
         * API name: {@code size}
         */
        @Nonnull
        public final Builder size(@Nullable Integer value) {
            this.size = value;
            return this;
        }

        /**
         * API name: {@code suggest_mode}
         */
        @Nonnull
        public final Builder suggestMode(@Nullable SuggestMode value) {
            this.suggestMode = value;
            return this;
        }

        /**
         * Builds a {@link DirectGenerator}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DirectGenerator build() {
            _checkSingleUse();

            return new DirectGenerator(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link DirectGenerator}
     */
    public static final JsonpDeserializer<DirectGenerator> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        DirectGenerator::setupDirectGeneratorDeserializer
    );

    protected static void setupDirectGeneratorDeserializer(ObjectDeserializer<DirectGenerator.Builder> op) {
        op.add(Builder::field, JsonpDeserializer.stringDeserializer(), "field");
        op.add(Builder::maxEdits, JsonpDeserializer.integerDeserializer(), "max_edits");
        op.add(Builder::maxInspections, JsonpDeserializer.floatDeserializer(), "max_inspections");
        op.add(Builder::maxTermFreq, JsonpDeserializer.floatDeserializer(), "max_term_freq");
        op.add(Builder::minDocFreq, JsonpDeserializer.floatDeserializer(), "min_doc_freq");
        op.add(Builder::minWordLength, JsonpDeserializer.integerDeserializer(), "min_word_length");
        op.add(Builder::postFilter, JsonpDeserializer.stringDeserializer(), "post_filter");
        op.add(Builder::preFilter, JsonpDeserializer.stringDeserializer(), "pre_filter");
        op.add(Builder::prefixLength, JsonpDeserializer.integerDeserializer(), "prefix_length");
        op.add(Builder::size, JsonpDeserializer.integerDeserializer(), "size");
        op.add(Builder::suggestMode, SuggestMode._DESERIALIZER, "suggest_mode");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.field.hashCode();
        result = 31 * result + Objects.hashCode(this.maxEdits);
        result = 31 * result + Objects.hashCode(this.maxInspections);
        result = 31 * result + Objects.hashCode(this.maxTermFreq);
        result = 31 * result + Objects.hashCode(this.minDocFreq);
        result = 31 * result + Objects.hashCode(this.minWordLength);
        result = 31 * result + Objects.hashCode(this.postFilter);
        result = 31 * result + Objects.hashCode(this.preFilter);
        result = 31 * result + Objects.hashCode(this.prefixLength);
        result = 31 * result + Objects.hashCode(this.size);
        result = 31 * result + Objects.hashCode(this.suggestMode);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        DirectGenerator other = (DirectGenerator) o;
        return this.field.equals(other.field)
            && Objects.equals(this.maxEdits, other.maxEdits)
            && Objects.equals(this.maxInspections, other.maxInspections)
            && Objects.equals(this.maxTermFreq, other.maxTermFreq)
            && Objects.equals(this.minDocFreq, other.minDocFreq)
            && Objects.equals(this.minWordLength, other.minWordLength)
            && Objects.equals(this.postFilter, other.postFilter)
            && Objects.equals(this.preFilter, other.preFilter)
            && Objects.equals(this.prefixLength, other.prefixLength)
            && Objects.equals(this.size, other.size)
            && Objects.equals(this.suggestMode, other.suggestMode);
    }
}
