/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

/**
 * Arrow streaming search: search results as Apache Arrow record batches read from doc values, streamed over the gRPC
 * transport's {@code SearchService/ServerStreamSearch} method. See {@link org.opensearch.client.opensearch.arrow.OpenSearchArrowClient}.
 */
package org.opensearch.client.opensearch.arrow;
