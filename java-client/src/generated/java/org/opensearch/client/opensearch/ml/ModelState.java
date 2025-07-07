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

// typedef: ml.ModelState

/**
 * The model state.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public enum ModelState implements JsonEnum {
    DeployFailed("DEPLOY_FAILED"),

    Deployed("DEPLOYED"),

    Deploying("DEPLOYING"),

    PartiallyDeployed("PARTIALLY_DEPLOYED"),

    Registered("REGISTERED"),

    Registering("REGISTERING"),

    Undeployed("UNDEPLOYED");

    private final String jsonValue;

    ModelState(String jsonValue) {
        this.jsonValue = jsonValue;
    }

    public String jsonValue() {
        return this.jsonValue;
    }

    public static final JsonEnum.Deserializer<ModelState> _DESERIALIZER = new JsonEnum.Deserializer<>(ModelState.values());
}
