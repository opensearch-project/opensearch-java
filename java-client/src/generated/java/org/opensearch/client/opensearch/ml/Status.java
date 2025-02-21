/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

//----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------

package org.opensearch.client.opensearch.ml;

import javax.annotation.Generated;
import org.opensearch.client.json.JsonEnum;
import org.opensearch.client.json.JsonpDeserializable;

// typedef: ml.Status

/**
 * The status.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public enum Status implements JsonEnum {
    Cancelled("CANCELLED"),

    Completed("COMPLETED"),

    CompletedWithError("COMPLETED_WITH_ERROR"),

    Created("CREATED"),

    Failed("FAILED"),

    Running("RUNNING");

    private final String jsonValue;

    Status(String jsonValue) {
        this.jsonValue = jsonValue;
    }

    public String jsonValue() {
        return this.jsonValue;
    }

    public static final JsonEnum.Deserializer<Status> _DESERIALIZER = new JsonEnum.Deserializer<>(Status.values());
}
