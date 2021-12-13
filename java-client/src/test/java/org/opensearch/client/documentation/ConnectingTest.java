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

package org.opensearch.client.documentation;

import org.opensearch.client.opensearch.OpenSearchClient;
import org.opensearch.client.opensearch.core.SearchResponse;
import org.opensearch.client.opensearch.core.search.Hit;
import org.opensearch.client.json.jackson.JacksonJsonpMapper;
import org.opensearch.client.transport.OpensearchTransport;
import org.opensearch.client.transport.rest_client.RestClientTransport;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.junit.Ignore;
import org.junit.Test;

public class ConnectingTest {

    private static class Product{}

    @Ignore // we don't have a running ES
    @Test
    public void createClient() throws Exception {
        //tag::create-client
        // Create the low-level client
        RestClient restClient = RestClient.builder(
            new HttpHost("localhost", 9200)).build();

        // Create the transport with a Jackson mapper
        OpensearchTransport transport = new RestClientTransport(
            restClient, new JacksonJsonpMapper());

        // And create the API client
        OpenSearchClient client = new OpenSearchClient(transport);
        //end::create-client

        //tag::first-request
        SearchResponse<Product> search = client.search(s -> s
            .index("products")
            .query(q -> q
                .term(t -> t
                    .field("name")
                    .value(v -> v.stringValue("bicycle"))
                )),
            Product.class);

        for (Hit<Product> hit: search.hits().hits()) {
            processProduct(hit.source());
        }
        //end::first-request
    }

    private void processProduct(Product p) {}

}
