/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.json.jackson3;

import tools.jackson.core.ObjectReadContext;

class XObjectReadContext extends ObjectReadContext.Base {
    private static final XObjectReadContext DEFAULT_INSTANCE = new XObjectReadContext();

    static XObjectReadContext create() {
        return DEFAULT_INSTANCE;
    }

    private XObjectReadContext() {}
}
