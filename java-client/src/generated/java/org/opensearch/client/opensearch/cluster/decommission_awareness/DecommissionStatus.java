/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

/*
 * Licensed to Elasticsearch B.V. under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch B.V. licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

/*
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
 */

//----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------

package org.opensearch.client.opensearch.cluster.decommission_awareness;

import javax.annotation.Generated;
import org.opensearch.client.json.JsonEnum;
import org.opensearch.client.json.JsonpDeserializable;

// typedef: cluster.decommission_awareness.DecommissionStatus

/**
 * An enumeration of the states during decommissioning.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public enum DecommissionStatus implements JsonEnum {
    /**
     * Decommission process is initiated, and the zone is being drained.
     */
    Draining("DRAINING"),

    /**
     * Decommission request failed.
     */
    Failed("FAILED"),

    /**
     * Decommission process has started, decommissioned nodes should be removed.
     */
    InProgress("IN_PROGRESS"),

    /**
     * Decommission process is initiated, and to-be-decommissioned leader is excluded from voting config.
     */
    Init("INIT"),

    /**
     * Decommission action completed.
     */
    Successful("SUCCESSFUL");

    private final String jsonValue;

    DecommissionStatus(String jsonValue) {
        this.jsonValue = jsonValue;
    }

    public String jsonValue() {
        return this.jsonValue;
    }

    public static final JsonEnum.Deserializer<DecommissionStatus> _DESERIALIZER = new JsonEnum.Deserializer<>(DecommissionStatus.values());
}
