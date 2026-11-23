/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.samples.util

class IndexData(var title: String? = null, var text: String? = null) {
    override fun toString(): String {
        return "IndexData{title='$title', text='$text'}"
    }
}
