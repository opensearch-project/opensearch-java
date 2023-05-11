/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.core.search;

public interface SuggestVariant {

    Suggest.Kind _suggestionKind();

    default Suggest _toSuggestion() {
        return new Suggest(this);
    }

}