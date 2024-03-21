/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.exceptions;

public class JavaFormatterException extends Exception {
    public JavaFormatterException(String message) {
        super(message);
    }

    public JavaFormatterException(String message, Throwable cause) {
        super(message, cause);
    }
}
