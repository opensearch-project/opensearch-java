/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.exceptions;

import java.util.List;

public class ApiSpecificationParseException extends RuntimeException {
    public ApiSpecificationParseException(String msg, Exception inner) {
        super(msg, inner);
    }

    public ApiSpecificationParseException(String msg, List<String> errors) {
        super(msg + "\n-" + String.join("\n-", errors));
    }
}
