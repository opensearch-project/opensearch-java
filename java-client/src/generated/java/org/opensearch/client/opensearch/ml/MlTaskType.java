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

// typedef: ml.MlTaskType

/**
 * Task type.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public enum MlTaskType implements JsonEnum {
    BatchIngest("BATCH_INGEST"),

    BatchPrediction("BATCH_PREDICTION"),

    DeployModel("DEPLOY_MODEL"),

    Execution("EXECUTION"),

    Prediction("PREDICTION"),

    RegisterModel("REGISTER_MODEL"),

    Training("TRAINING"),

    TrainingAndPrediction("TRAINING_AND_PREDICTION");

    private final String jsonValue;

    MlTaskType(String jsonValue) {
        this.jsonValue = jsonValue;
    }

    public String jsonValue() {
        return this.jsonValue;
    }

    public static final JsonEnum.Deserializer<MlTaskType> _DESERIALIZER = new JsonEnum.Deserializer<>(MlTaskType.values());
}
