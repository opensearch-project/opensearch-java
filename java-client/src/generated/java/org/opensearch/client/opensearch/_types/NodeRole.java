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

package org.opensearch.client.opensearch._types;

import javax.annotation.Generated;
import org.opensearch.client.json.JsonEnum;
import org.opensearch.client.json.JsonpDeserializable;

// typedef: _types.NodeRole

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public enum NodeRole implements JsonEnum {
    /**
     * The node can act as a client node.
     */
    Client("client"),

    /**
     * The node can act as a cluster manager.
     */
    ClusterManager("cluster_manager"),

    /**
     * The node only performs coordination tasks.
     */
    CoordinatingOnly("coordinating_only"),

    /**
     * The node can store data.
     */
    Data("data"),

    /**
     * The node can store cold data.
     */
    DataCold("data_cold"),

    /**
     * The node can store content data.
     */
    DataContent("data_content"),

    /**
     * The node can store frozen data.
     */
    DataFrozen("data_frozen"),

    /**
     * The node can store hot data.
     */
    DataHot("data_hot"),

    /**
     * The node can store warm data.
     */
    DataWarm("data_warm"),

    /**
     * The node can perform ingest operations.
     */
    Ingest("ingest"),

    @Deprecated
    Master("master"),

    /**
     * The node can perform machine learning operations.
     */
    Ml("ml"),

    /**
     * The node can act as a remote cluster client.
     */
    RemoteClusterClient("remote_cluster_client"),

    /**
     * The node can perform transform operations.
     */
    Transform("transform"),

    /**
     * The node can only vote in cluster decisions.
     */
    VotingOnly("voting_only");

    private final String jsonValue;

    NodeRole(String jsonValue) {
        this.jsonValue = jsonValue;
    }

    public String jsonValue() {
        return this.jsonValue;
    }

    public static final JsonEnum.Deserializer<NodeRole> _DESERIALIZER = new JsonEnum.Deserializer<>(NodeRole.values());
}
