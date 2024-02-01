/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

// ----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
// ----------------------------------------------------

package org.opensearch.client.opensearch._types;

import org.opensearch.client.json.JsonEnum;
import org.opensearch.client.json.JsonpDeserializable;

@JsonpDeserializable
public enum ExpandWildcard implements JsonEnum {
    All("all"),
    Open("open"),
    Closed("closed"),
    Hidden("hidden"),
    None("none"),
    ;

    private final String jsonValue;
    private final String[] aliases;

    ExpandWildcard(String jsonValue, String... aliases) {
        this.jsonValue = jsonValue;
        this.aliases = aliases;
    }

    public String jsonValue() {
        return this.jsonValue;
    }

    public String[] aliases() {
        return this.aliases;
    }

    public static final JsonEnum.Deserializer<ExpandWildcard> _DESERIALIZER =
            new JsonEnum.Deserializer<>(ExpandWildcard.values());
}
