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

package org.opensearch.client.opensearch.snapshot;

import javax.annotation.Generated;
import org.opensearch.client.json.JsonEnum;
import org.opensearch.client.json.JsonpDeserializable;

// typedef: snapshot.SnapshotShardsStatsStage

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public enum SnapshotShardsStatsStage implements JsonEnum {
    /**
     * The number of shards in the snapshot that were successfully stored in the repository.
     */
    Done("DONE"),

    /**
     * The number of shards in the snapshot that were not successfully stored in the repository.
     */
    Failure("FAILURE"),

    /**
     * The number of shards in the snapshot that are in the finalizing stage of being stored in the repository.
     */
    Finalize("FINALIZE"),

    /**
     * The number of shards in the snapshot that are in the initializing stage of being stored in the repository.
     */
    Init("INIT"),

    /**
     * The number of shards in the snapshot that are in the started stage of being stored in the repository.
     */
    Started("STARTED");

    private final String jsonValue;

    SnapshotShardsStatsStage(String jsonValue) {
        this.jsonValue = jsonValue;
    }

    public String jsonValue() {
        return this.jsonValue;
    }

    public static final JsonEnum.Deserializer<SnapshotShardsStatsStage> _DESERIALIZER = new JsonEnum.Deserializer<>(
        SnapshotShardsStatsStage.values()
    );
}
