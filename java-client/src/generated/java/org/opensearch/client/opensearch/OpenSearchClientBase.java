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

package org.opensearch.client.opensearch;

import java.io.IOException;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import org.opensearch.client.ApiClient;
import org.opensearch.client.opensearch._types.OpenSearchException;
import org.opensearch.client.opensearch.cluster.OpenSearchClusterClient;
import org.opensearch.client.opensearch.core.InfoRequest;
import org.opensearch.client.opensearch.core.InfoResponse;
import org.opensearch.client.opensearch.dangling_indices.OpenSearchDanglingIndicesClient;
import org.opensearch.client.opensearch.indices.OpenSearchIndicesClient;
import org.opensearch.client.opensearch.ml.OpenSearchMlClient;
import org.opensearch.client.opensearch.nodes.OpenSearchNodesClient;
import org.opensearch.client.opensearch.snapshot.OpenSearchSnapshotClient;
import org.opensearch.client.opensearch.tasks.OpenSearchTasksClient;
import org.opensearch.client.transport.OpenSearchTransport;
import org.opensearch.client.transport.TransportOptions;

/**
 * Client for the namespace.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public abstract class OpenSearchClientBase<Self extends OpenSearchClientBase<Self>> extends ApiClient<OpenSearchTransport, Self> {
    public OpenSearchClientBase(OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    // ----- Child clients

    public OpenSearchClusterClient cluster() {
        return new OpenSearchClusterClient(this.transport, this.transportOptions);
    }

    public OpenSearchDanglingIndicesClient danglingIndices() {
        return new OpenSearchDanglingIndicesClient(this.transport, this.transportOptions);
    }

    public OpenSearchIndicesClient indices() {
        return new OpenSearchIndicesClient(this.transport, this.transportOptions);
    }

    public OpenSearchMlClient ml() {
        return new OpenSearchMlClient(this.transport, this.transportOptions);
    }

    public OpenSearchNodesClient nodes() {
        return new OpenSearchNodesClient(this.transport, this.transportOptions);
    }

    public OpenSearchSnapshotClient snapshot() {
        return new OpenSearchSnapshotClient(this.transport, this.transportOptions);
    }

    public OpenSearchTasksClient tasks() {
        return new OpenSearchTasksClient(this.transport, this.transportOptions);
    }

    // ----- Endpoint: info

    /**
     * Returns basic information about the cluster.
     */
    public InfoResponse info() throws IOException, OpenSearchException {
        return this.transport.performRequest(InfoRequest._INSTANCE, InfoRequest._ENDPOINT, this.transportOptions);
    }
}
