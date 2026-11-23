/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.samples.json;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.opensearch.client.opensearch.OpenSearchClient;
import org.opensearch.client.opensearch.indices.PutIndexTemplateRequest;
import org.opensearch.client.opensearch.indices.PutIndexTemplateResponse;
import org.opensearch.client.samples.SampleClient;
import org.opensearch.client.samples.Search;

public class SerializationBasics {

    private static final Logger LOGGER = LogManager.getLogger(Search.class);

    private static OpenSearchClient client;

    public static void main(String[] args) {
        try {
            client = SampleClient.create();

            var version = client.info().version();
            LOGGER.info("Server: {}@{}.", version.distribution(), version.number());

            final var indexTemplateName = "my-index";
            final var indexSettingsComponentTemplate = "index-settings";
            final var indexMappingsComponentTemplate = "index-mappings";

            // Create Index Template Request for index 'my-index'.
            PutIndexTemplateRequest putIndexTemplateRequest = PutIndexTemplateRequest.of(
                it -> it.name(indexTemplateName)
                    .indexPatterns("my-index-*")
                    .composedOf(List.of(indexSettingsComponentTemplate, indexMappingsComponentTemplate))
            );

            LOGGER.info("Creating index template {}.", indexTemplateName);

            // Use toJsonString method to log Request and Response string.
            LOGGER.debug("Index Template Request: {}.", putIndexTemplateRequest.toJsonString());
            PutIndexTemplateResponse response = client.indices().putIndexTemplate(putIndexTemplateRequest);
            LOGGER.info("Index Template Response: {}.", response.toJsonString());

        } catch (Exception e) {
            LOGGER.error("Exception occurred.", e);
        }
    }
}
