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

// typedef: ml.MlStatName

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public enum MlStatName implements JsonEnum {
    MlConfigIndexStatus("ml_config_index_status"),

    MlConnectorCount("ml_connector_count"),

    MlConnectorIndexStatus("ml_connector_index_status"),

    MlControllerIndexStatus("ml_controller_index_status"),

    MlModelCount("ml_model_count"),

    MlModelIndexStatus("ml_model_index_status"),

    MlTaskIndexStatus("ml_task_index_status");

    private final String jsonValue;

    MlStatName(String jsonValue) {
        this.jsonValue = jsonValue;
    }

    public String jsonValue() {
        return this.jsonValue;
    }

    public static final JsonEnum.Deserializer<MlStatName> _DESERIALIZER = new JsonEnum.Deserializer<>(MlStatName.values());
}
