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

import javax.annotation.Generated;

/**
 * Builders for {@link ResponseProcessor} variants.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ResponseProcessorBuilders {
    private ResponseProcessorBuilders() {}

    /**
     * Creates a builder for the {@link CollapseResponseProcessor collapse} {@code ResponseProcessor} variant.
     */
    public static CollapseResponseProcessor.Builder collapse() {
        return new CollapseResponseProcessor.Builder();
    }

    /**
     * Creates a builder for the {@link PersonalizeSearchRankingResponseProcessor personalize_search_ranking} {@code ResponseProcessor}
     * variant.
     */
    public static PersonalizeSearchRankingResponseProcessor.Builder personalizeSearchRanking() {
        return new PersonalizeSearchRankingResponseProcessor.Builder();
    }

    /**
     * Creates a builder for the {@link RenameFieldResponseProcessor rename_field} {@code ResponseProcessor} variant.
     */
    public static RenameFieldResponseProcessor.Builder renameField() {
        return new RenameFieldResponseProcessor.Builder();
    }

    /**
     * Creates a builder for the {@link RerankResponseProcessor rerank} {@code ResponseProcessor} variant.
     */
    public static RerankResponseProcessor.Builder rerank() {
        return new RerankResponseProcessor.Builder();
    }

    /**
     * Creates a builder for the {@link RetrievalAugmentedGenerationResponseProcessor retrieval_augmented_generation}
     * {@code ResponseProcessor} variant.
     */
    public static RetrievalAugmentedGenerationResponseProcessor.Builder retrievalAugmentedGeneration() {
        return new RetrievalAugmentedGenerationResponseProcessor.Builder();
    }

    /**
     * Creates a builder for the {@link SortResponseProcessor sort} {@code ResponseProcessor} variant.
     */
    public static SortResponseProcessor.Builder sort() {
        return new SortResponseProcessor.Builder();
    }

    /**
     * Creates a builder for the {@link SplitResponseProcessor split} {@code ResponseProcessor} variant.
     */
    public static SplitResponseProcessor.Builder split() {
        return new SplitResponseProcessor.Builder();
    }

    /**
     * Creates a builder for the {@link TruncateHitsResponseProcessor truncate_hits} {@code ResponseProcessor} variant.
     */
    public static TruncateHitsResponseProcessor.Builder truncateHits() {
        return new TruncateHitsResponseProcessor.Builder();
    }
}
