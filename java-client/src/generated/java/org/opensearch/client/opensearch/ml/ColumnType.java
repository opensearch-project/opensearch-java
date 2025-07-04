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

// typedef: ml.ColumnType

/**
 * The column type.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public enum ColumnType implements JsonEnum {
    Boolean("BOOLEAN"),

    Double("DOUBLE"),

    Integer("INTEGER"),

    String("STRING");

    private final String jsonValue;

    ColumnType(String jsonValue) {
        this.jsonValue = jsonValue;
    }

    public String jsonValue() {
        return this.jsonValue;
    }

    public static final JsonEnum.Deserializer<ColumnType> _DESERIALIZER = new JsonEnum.Deserializer<>(ColumnType.values());
}
