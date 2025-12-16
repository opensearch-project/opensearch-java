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

package org.opensearch.client.opensearch._helpers.bulk;

import java.util.List;
import org.opensearch.client.opensearch.core.BulkRequest;
import org.opensearch.client.opensearch.core.BulkResponse;
import org.opensearch.client.opensearch.core.bulk.BulkOperation;

/**
 * A listener that is called by a {@link BulkIngester} to allow monitoring requests sent and their result.
 *
 * @param <Context> application-defined contextual data that can be associated to a bulk operation.
 */
public interface BulkListener<Context> {

    /**
     * Called before a bulk request is sent. <b>Note:</b> documents in {@code request} operations have been
     * converted to {@link org.opensearch.client.util.BinaryData}.
     *
     * @param executionId the id of this request, unique for the {@link BulkIngester} that created it.
     * @param request the bulk request that will be sent, with documents in binary form.
     * @param contexts application-defined data that was passed in {@link BulkIngester#add(BulkOperation, Object)}.
     */
    void beforeBulk(long executionId, BulkRequest request, List<Context> contexts);

    /**
     * Called after a bulk request has been processed. OpenSearch accepted the request, but {@code response} the response may
     * contain both successful and failure response items.
     *
     * @param executionId the id of this request, unique for the {@link BulkIngester} that created it.
     * @param request the bulk request that will be sent, with documents in binary form.
     * @param contexts application-defined data that was passed in {@link BulkIngester#add(BulkOperation, Object)}.
     * @param response the response received from OpenSearch.
     */
    void afterBulk(long executionId, BulkRequest request, List<Context> contexts, BulkResponse response);

    /**
     * Called when a bulk request could not be sent to OpenSearch.
     *
     * @param executionId the id of this request, unique for the {@link BulkIngester} that created it.
     * @param request the bulk request that will be sent, with documents in binary form.
     * @param contexts application-defined data that was passed in {@link BulkIngester#add(BulkOperation, Object)}.
     * @param failure the failure that occurred when sending the request to OpenSearch.
     */
    void afterBulk(long executionId, BulkRequest request, List<Context> contexts, Throwable failure);
}
