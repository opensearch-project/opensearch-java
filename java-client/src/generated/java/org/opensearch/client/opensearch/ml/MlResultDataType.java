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

// typedef: ml.MlResultDataType

/**
 * The result data type.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public enum MlResultDataType implements JsonEnum {
    Boolean("BOOLEAN"),

    Float16("FLOAT16"),

    Float32("FLOAT32"),

    Float64("FLOAT64"),

    Int32("INT32"),

    Int64("INT64"),

    Int8("INT8"),

    String("STRING"),

    Uint8("UINT8"),

    Unknown("UNKNOWN");

    private final String jsonValue;

    MlResultDataType(String jsonValue) {
        this.jsonValue = jsonValue;
    }

    public String jsonValue() {
        return this.jsonValue;
    }

    public static final JsonEnum.Deserializer<MlResultDataType> _DESERIALIZER = new JsonEnum.Deserializer<>(MlResultDataType.values());
}
