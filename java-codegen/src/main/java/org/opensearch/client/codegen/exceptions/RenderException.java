/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.exceptions;

public class RenderException extends Exception {
    public RenderException(String msg, Exception inner) {
        super(msg, inner);
    }
}
