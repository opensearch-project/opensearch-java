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

package org.opensearch.client.opensearch.search_pipeline;

import jakarta.json.stream.JsonGenerator;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.json.JsonEnum;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.JsonpSerializable;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.TaggedUnion;
import org.opensearch.client.util.TaggedUnionUtils;

// typedef: search_pipeline.ResponseProcessor

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ResponseProcessor implements TaggedUnion<ResponseProcessor.Kind, ResponseProcessorVariant>, PlainJsonSerializable {
    /**
     * {@link ResponseProcessor} variant kinds.
     */
    public enum Kind implements JsonEnum {
        Collapse("collapse"),
        PersonalizeSearchRanking("personalize_search_ranking"),
        RenameField("rename_field"),
        Rerank("rerank"),
        RetrievalAugmentedGeneration("retrieval_augmented_generation"),
        Sort("sort"),
        Split("split"),
        TruncateHits("truncate_hits");

        private final String jsonValue;

        Kind(String jsonValue) {
            this.jsonValue = jsonValue;
        }

        @Override
        public String jsonValue() {
            return jsonValue;
        }
    }

    private final Kind _kind;
    private final ResponseProcessorVariant _value;

    @Override
    public final Kind _kind() {
        return _kind;
    }

    @Override
    public final ResponseProcessorVariant _get() {
        return _value;
    }

    public ResponseProcessor(ResponseProcessorVariant value) {
        this._kind = ApiTypeHelper.requireNonNull(value._responseProcessorKind(), this, "<variant kind>");
        this._value = ApiTypeHelper.requireNonNull(value, this, "<variant value>");
    }

    private ResponseProcessor(Builder builder) {
        this._kind = ApiTypeHelper.requireNonNull(builder._kind, builder, "<variant kind>");
        this._value = ApiTypeHelper.requireNonNull(builder._value, builder, "<variant value>");
    }

    public static ResponseProcessor of(Function<ResponseProcessor.Builder, ObjectBuilder<ResponseProcessor>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Is this variant instance of kind {@code collapse}?
     */
    public boolean isCollapse() {
        return _kind == Kind.Collapse;
    }

    /**
     * Get the {@code collapse} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code collapse} kind.
     */
    public CollapseResponseProcessor collapse() {
        return TaggedUnionUtils.get(this, Kind.Collapse);
    }

    /**
     * Is this variant instance of kind {@code personalize_search_ranking}?
     */
    public boolean isPersonalizeSearchRanking() {
        return _kind == Kind.PersonalizeSearchRanking;
    }

    /**
     * Get the {@code personalize_search_ranking} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code personalize_search_ranking} kind.
     */
    public PersonalizeSearchRankingResponseProcessor personalizeSearchRanking() {
        return TaggedUnionUtils.get(this, Kind.PersonalizeSearchRanking);
    }

    /**
     * Is this variant instance of kind {@code rename_field}?
     */
    public boolean isRenameField() {
        return _kind == Kind.RenameField;
    }

    /**
     * Get the {@code rename_field} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code rename_field} kind.
     */
    public RenameFieldResponseProcessor renameField() {
        return TaggedUnionUtils.get(this, Kind.RenameField);
    }

    /**
     * Is this variant instance of kind {@code rerank}?
     */
    public boolean isRerank() {
        return _kind == Kind.Rerank;
    }

    /**
     * Get the {@code rerank} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code rerank} kind.
     */
    public RerankResponseProcessor rerank() {
        return TaggedUnionUtils.get(this, Kind.Rerank);
    }

    /**
     * Is this variant instance of kind {@code retrieval_augmented_generation}?
     */
    public boolean isRetrievalAugmentedGeneration() {
        return _kind == Kind.RetrievalAugmentedGeneration;
    }

    /**
     * Get the {@code retrieval_augmented_generation} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code retrieval_augmented_generation} kind.
     */
    public RetrievalAugmentedGenerationResponseProcessor retrievalAugmentedGeneration() {
        return TaggedUnionUtils.get(this, Kind.RetrievalAugmentedGeneration);
    }

    /**
     * Is this variant instance of kind {@code sort}?
     */
    public boolean isSort() {
        return _kind == Kind.Sort;
    }

    /**
     * Get the {@code sort} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code sort} kind.
     */
    public SortResponseProcessor sort() {
        return TaggedUnionUtils.get(this, Kind.Sort);
    }

    /**
     * Is this variant instance of kind {@code split}?
     */
    public boolean isSplit() {
        return _kind == Kind.Split;
    }

    /**
     * Get the {@code split} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code split} kind.
     */
    public SplitResponseProcessor split() {
        return TaggedUnionUtils.get(this, Kind.Split);
    }

    /**
     * Is this variant instance of kind {@code truncate_hits}?
     */
    public boolean isTruncateHits() {
        return _kind == Kind.TruncateHits;
    }

    /**
     * Get the {@code truncate_hits} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code truncate_hits} kind.
     */
    public TruncateHitsResponseProcessor truncateHits() {
        return TaggedUnionUtils.get(this, Kind.TruncateHits);
    }

    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        generator.writeKey(_kind.jsonValue());
        if (_value instanceof JsonpSerializable) {
            ((JsonpSerializable) _value).serialize(generator, mapper);
        }
        generator.writeEnd();
    }

    @Nonnull
    public Builder toBuilder() {
        return new Builder(this);
    }

    @Nonnull
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<ResponseProcessor> {
        private Kind _kind;
        private ResponseProcessorVariant _value;

        public Builder() {}

        private Builder(ResponseProcessor o) {
            this._kind = o._kind;
            this._value = o._value;
        }

        public ObjectBuilder<ResponseProcessor> collapse(CollapseResponseProcessor v) {
            this._kind = Kind.Collapse;
            this._value = v;
            return this;
        }

        public ObjectBuilder<ResponseProcessor> collapse(
            Function<CollapseResponseProcessor.Builder, ObjectBuilder<CollapseResponseProcessor>> fn
        ) {
            return this.collapse(fn.apply(new CollapseResponseProcessor.Builder()).build());
        }

        public ObjectBuilder<ResponseProcessor> personalizeSearchRanking(PersonalizeSearchRankingResponseProcessor v) {
            this._kind = Kind.PersonalizeSearchRanking;
            this._value = v;
            return this;
        }

        public ObjectBuilder<ResponseProcessor> personalizeSearchRanking(
            Function<PersonalizeSearchRankingResponseProcessor.Builder, ObjectBuilder<PersonalizeSearchRankingResponseProcessor>> fn
        ) {
            return this.personalizeSearchRanking(fn.apply(new PersonalizeSearchRankingResponseProcessor.Builder()).build());
        }

        public ObjectBuilder<ResponseProcessor> renameField(RenameFieldResponseProcessor v) {
            this._kind = Kind.RenameField;
            this._value = v;
            return this;
        }

        public ObjectBuilder<ResponseProcessor> renameField(
            Function<RenameFieldResponseProcessor.Builder, ObjectBuilder<RenameFieldResponseProcessor>> fn
        ) {
            return this.renameField(fn.apply(new RenameFieldResponseProcessor.Builder()).build());
        }

        public ObjectBuilder<ResponseProcessor> rerank(RerankResponseProcessor v) {
            this._kind = Kind.Rerank;
            this._value = v;
            return this;
        }

        public ObjectBuilder<ResponseProcessor> rerank(
            Function<RerankResponseProcessor.Builder, ObjectBuilder<RerankResponseProcessor>> fn
        ) {
            return this.rerank(fn.apply(new RerankResponseProcessor.Builder()).build());
        }

        public ObjectBuilder<ResponseProcessor> retrievalAugmentedGeneration(RetrievalAugmentedGenerationResponseProcessor v) {
            this._kind = Kind.RetrievalAugmentedGeneration;
            this._value = v;
            return this;
        }

        public ObjectBuilder<ResponseProcessor> retrievalAugmentedGeneration(
            Function<RetrievalAugmentedGenerationResponseProcessor.Builder, ObjectBuilder<RetrievalAugmentedGenerationResponseProcessor>> fn
        ) {
            return this.retrievalAugmentedGeneration(fn.apply(new RetrievalAugmentedGenerationResponseProcessor.Builder()).build());
        }

        public ObjectBuilder<ResponseProcessor> sort(SortResponseProcessor v) {
            this._kind = Kind.Sort;
            this._value = v;
            return this;
        }

        public ObjectBuilder<ResponseProcessor> sort(Function<SortResponseProcessor.Builder, ObjectBuilder<SortResponseProcessor>> fn) {
            return this.sort(fn.apply(new SortResponseProcessor.Builder()).build());
        }

        public ObjectBuilder<ResponseProcessor> split(SplitResponseProcessor v) {
            this._kind = Kind.Split;
            this._value = v;
            return this;
        }

        public ObjectBuilder<ResponseProcessor> split(Function<SplitResponseProcessor.Builder, ObjectBuilder<SplitResponseProcessor>> fn) {
            return this.split(fn.apply(new SplitResponseProcessor.Builder()).build());
        }

        public ObjectBuilder<ResponseProcessor> truncateHits(TruncateHitsResponseProcessor v) {
            this._kind = Kind.TruncateHits;
            this._value = v;
            return this;
        }

        public ObjectBuilder<ResponseProcessor> truncateHits(
            Function<TruncateHitsResponseProcessor.Builder, ObjectBuilder<TruncateHitsResponseProcessor>> fn
        ) {
            return this.truncateHits(fn.apply(new TruncateHitsResponseProcessor.Builder()).build());
        }

        @Override
        public ResponseProcessor build() {
            _checkSingleUse();
            return new ResponseProcessor(this);
        }
    }

    protected static void setupResponseProcessorDeserializer(ObjectDeserializer<Builder> op) {
        op.add(Builder::collapse, CollapseResponseProcessor._DESERIALIZER, "collapse");
        op.add(Builder::personalizeSearchRanking, PersonalizeSearchRankingResponseProcessor._DESERIALIZER, "personalize_search_ranking");
        op.add(Builder::renameField, RenameFieldResponseProcessor._DESERIALIZER, "rename_field");
        op.add(Builder::rerank, RerankResponseProcessor._DESERIALIZER, "rerank");
        op.add(
            Builder::retrievalAugmentedGeneration,
            RetrievalAugmentedGenerationResponseProcessor._DESERIALIZER,
            "retrieval_augmented_generation"
        );
        op.add(Builder::sort, SortResponseProcessor._DESERIALIZER, "sort");
        op.add(Builder::split, SplitResponseProcessor._DESERIALIZER, "split");
        op.add(Builder::truncateHits, TruncateHitsResponseProcessor._DESERIALIZER, "truncate_hits");
    }

    public static final JsonpDeserializer<ResponseProcessor> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ResponseProcessor::setupResponseProcessorDeserializer,
        Builder::build
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this._kind);
        result = 31 * result + Objects.hashCode(this._value);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ResponseProcessor other = (ResponseProcessor) o;
        return Objects.equals(this._kind, other._kind) && Objects.equals(this._value, other._value);
    }
}
