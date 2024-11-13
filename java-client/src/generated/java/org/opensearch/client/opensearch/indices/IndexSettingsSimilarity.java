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

package org.opensearch.client.opensearch.indices;

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
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: indices.IndexSettingsSimilarity

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IndexSettingsSimilarity
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<IndexSettingsSimilarity.Builder, IndexSettingsSimilarity> {

    @Nullable
    private final IndexSettingsSimilarityBm25 bm25;

    @Nullable
    private final IndexSettingsSimilarityDfi dfi;

    @Nullable
    private final IndexSettingsSimilarityDfr dfr;

    @Nullable
    private final IndexSettingsSimilarityIb ib;

    @Nullable
    private final IndexSettingsSimilarityLmd lmd;

    @Nullable
    private final IndexSettingsSimilarityLmj lmj;

    @Nullable
    private final IndexSettingsSimilarityScriptedTfidf scriptedTfidf;

    // ---------------------------------------------------------------------------------------------

    private IndexSettingsSimilarity(Builder builder) {
        this.bm25 = builder.bm25;
        this.dfi = builder.dfi;
        this.dfr = builder.dfr;
        this.ib = builder.ib;
        this.lmd = builder.lmd;
        this.lmj = builder.lmj;
        this.scriptedTfidf = builder.scriptedTfidf;
    }

    public static IndexSettingsSimilarity of(Function<IndexSettingsSimilarity.Builder, ObjectBuilder<IndexSettingsSimilarity>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code bm25}
     */
    @Nullable
    public final IndexSettingsSimilarityBm25 bm25() {
        return this.bm25;
    }

    /**
     * API name: {@code dfi}
     */
    @Nullable
    public final IndexSettingsSimilarityDfi dfi() {
        return this.dfi;
    }

    /**
     * API name: {@code dfr}
     */
    @Nullable
    public final IndexSettingsSimilarityDfr dfr() {
        return this.dfr;
    }

    /**
     * API name: {@code ib}
     */
    @Nullable
    public final IndexSettingsSimilarityIb ib() {
        return this.ib;
    }

    /**
     * API name: {@code lmd}
     */
    @Nullable
    public final IndexSettingsSimilarityLmd lmd() {
        return this.lmd;
    }

    /**
     * API name: {@code lmj}
     */
    @Nullable
    public final IndexSettingsSimilarityLmj lmj() {
        return this.lmj;
    }

    /**
     * API name: {@code scripted_tfidf}
     */
    @Nullable
    public final IndexSettingsSimilarityScriptedTfidf scriptedTfidf() {
        return this.scriptedTfidf;
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
        if (this.bm25 != null) {
            generator.writeKey("bm25");
            this.bm25.serialize(generator, mapper);
        }

        if (this.dfi != null) {
            generator.writeKey("dfi");
            this.dfi.serialize(generator, mapper);
        }

        if (this.dfr != null) {
            generator.writeKey("dfr");
            this.dfr.serialize(generator, mapper);
        }

        if (this.ib != null) {
            generator.writeKey("ib");
            this.ib.serialize(generator, mapper);
        }

        if (this.lmd != null) {
            generator.writeKey("lmd");
            this.lmd.serialize(generator, mapper);
        }

        if (this.lmj != null) {
            generator.writeKey("lmj");
            this.lmj.serialize(generator, mapper);
        }

        if (this.scriptedTfidf != null) {
            generator.writeKey("scripted_tfidf");
            this.scriptedTfidf.serialize(generator, mapper);
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
     * Builder for {@link IndexSettingsSimilarity}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IndexSettingsSimilarity> {
        @Nullable
        private IndexSettingsSimilarityBm25 bm25;
        @Nullable
        private IndexSettingsSimilarityDfi dfi;
        @Nullable
        private IndexSettingsSimilarityDfr dfr;
        @Nullable
        private IndexSettingsSimilarityIb ib;
        @Nullable
        private IndexSettingsSimilarityLmd lmd;
        @Nullable
        private IndexSettingsSimilarityLmj lmj;
        @Nullable
        private IndexSettingsSimilarityScriptedTfidf scriptedTfidf;

        public Builder() {}

        private Builder(IndexSettingsSimilarity o) {
            this.bm25 = o.bm25;
            this.dfi = o.dfi;
            this.dfr = o.dfr;
            this.ib = o.ib;
            this.lmd = o.lmd;
            this.lmj = o.lmj;
            this.scriptedTfidf = o.scriptedTfidf;
        }

        private Builder(Builder o) {
            this.bm25 = o.bm25;
            this.dfi = o.dfi;
            this.dfr = o.dfr;
            this.ib = o.ib;
            this.lmd = o.lmd;
            this.lmj = o.lmj;
            this.scriptedTfidf = o.scriptedTfidf;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code bm25}
         */
        @Nonnull
        public final Builder bm25(@Nullable IndexSettingsSimilarityBm25 value) {
            this.bm25 = value;
            return this;
        }

        /**
         * API name: {@code bm25}
         */
        @Nonnull
        public final Builder bm25(Function<IndexSettingsSimilarityBm25.Builder, ObjectBuilder<IndexSettingsSimilarityBm25>> fn) {
            return bm25(fn.apply(new IndexSettingsSimilarityBm25.Builder()).build());
        }

        /**
         * API name: {@code dfi}
         */
        @Nonnull
        public final Builder dfi(@Nullable IndexSettingsSimilarityDfi value) {
            this.dfi = value;
            return this;
        }

        /**
         * API name: {@code dfi}
         */
        @Nonnull
        public final Builder dfi(Function<IndexSettingsSimilarityDfi.Builder, ObjectBuilder<IndexSettingsSimilarityDfi>> fn) {
            return dfi(fn.apply(new IndexSettingsSimilarityDfi.Builder()).build());
        }

        /**
         * API name: {@code dfr}
         */
        @Nonnull
        public final Builder dfr(@Nullable IndexSettingsSimilarityDfr value) {
            this.dfr = value;
            return this;
        }

        /**
         * API name: {@code dfr}
         */
        @Nonnull
        public final Builder dfr(Function<IndexSettingsSimilarityDfr.Builder, ObjectBuilder<IndexSettingsSimilarityDfr>> fn) {
            return dfr(fn.apply(new IndexSettingsSimilarityDfr.Builder()).build());
        }

        /**
         * API name: {@code ib}
         */
        @Nonnull
        public final Builder ib(@Nullable IndexSettingsSimilarityIb value) {
            this.ib = value;
            return this;
        }

        /**
         * API name: {@code ib}
         */
        @Nonnull
        public final Builder ib(Function<IndexSettingsSimilarityIb.Builder, ObjectBuilder<IndexSettingsSimilarityIb>> fn) {
            return ib(fn.apply(new IndexSettingsSimilarityIb.Builder()).build());
        }

        /**
         * API name: {@code lmd}
         */
        @Nonnull
        public final Builder lmd(@Nullable IndexSettingsSimilarityLmd value) {
            this.lmd = value;
            return this;
        }

        /**
         * API name: {@code lmd}
         */
        @Nonnull
        public final Builder lmd(Function<IndexSettingsSimilarityLmd.Builder, ObjectBuilder<IndexSettingsSimilarityLmd>> fn) {
            return lmd(fn.apply(new IndexSettingsSimilarityLmd.Builder()).build());
        }

        /**
         * API name: {@code lmj}
         */
        @Nonnull
        public final Builder lmj(@Nullable IndexSettingsSimilarityLmj value) {
            this.lmj = value;
            return this;
        }

        /**
         * API name: {@code lmj}
         */
        @Nonnull
        public final Builder lmj(Function<IndexSettingsSimilarityLmj.Builder, ObjectBuilder<IndexSettingsSimilarityLmj>> fn) {
            return lmj(fn.apply(new IndexSettingsSimilarityLmj.Builder()).build());
        }

        /**
         * API name: {@code scripted_tfidf}
         */
        @Nonnull
        public final Builder scriptedTfidf(@Nullable IndexSettingsSimilarityScriptedTfidf value) {
            this.scriptedTfidf = value;
            return this;
        }

        /**
         * API name: {@code scripted_tfidf}
         */
        @Nonnull
        public final Builder scriptedTfidf(
            Function<IndexSettingsSimilarityScriptedTfidf.Builder, ObjectBuilder<IndexSettingsSimilarityScriptedTfidf>> fn
        ) {
            return scriptedTfidf(fn.apply(new IndexSettingsSimilarityScriptedTfidf.Builder()).build());
        }

        /**
         * Builds a {@link IndexSettingsSimilarity}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IndexSettingsSimilarity build() {
            _checkSingleUse();

            return new IndexSettingsSimilarity(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IndexSettingsSimilarity}
     */
    public static final JsonpDeserializer<IndexSettingsSimilarity> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IndexSettingsSimilarity::setupIndexSettingsSimilarityDeserializer
    );

    protected static void setupIndexSettingsSimilarityDeserializer(ObjectDeserializer<IndexSettingsSimilarity.Builder> op) {
        op.add(Builder::bm25, IndexSettingsSimilarityBm25._DESERIALIZER, "bm25");
        op.add(Builder::dfi, IndexSettingsSimilarityDfi._DESERIALIZER, "dfi");
        op.add(Builder::dfr, IndexSettingsSimilarityDfr._DESERIALIZER, "dfr");
        op.add(Builder::ib, IndexSettingsSimilarityIb._DESERIALIZER, "ib");
        op.add(Builder::lmd, IndexSettingsSimilarityLmd._DESERIALIZER, "lmd");
        op.add(Builder::lmj, IndexSettingsSimilarityLmj._DESERIALIZER, "lmj");
        op.add(Builder::scriptedTfidf, IndexSettingsSimilarityScriptedTfidf._DESERIALIZER, "scripted_tfidf");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.bm25);
        result = 31 * result + Objects.hashCode(this.dfi);
        result = 31 * result + Objects.hashCode(this.dfr);
        result = 31 * result + Objects.hashCode(this.ib);
        result = 31 * result + Objects.hashCode(this.lmd);
        result = 31 * result + Objects.hashCode(this.lmj);
        result = 31 * result + Objects.hashCode(this.scriptedTfidf);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IndexSettingsSimilarity other = (IndexSettingsSimilarity) o;
        return Objects.equals(this.bm25, other.bm25)
            && Objects.equals(this.dfi, other.dfi)
            && Objects.equals(this.dfr, other.dfr)
            && Objects.equals(this.ib, other.ib)
            && Objects.equals(this.lmd, other.lmd)
            && Objects.equals(this.lmj, other.lmj)
            && Objects.equals(this.scriptedTfidf, other.scriptedTfidf);
    }
}
