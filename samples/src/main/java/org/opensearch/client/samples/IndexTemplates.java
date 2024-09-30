/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.samples;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.opensearch.cluster.PutComponentTemplateRequest;
import org.opensearch.client.opensearch.indices.CreateIndexRequest;
import org.opensearch.client.opensearch.indices.DeleteIndexRequest;
import org.opensearch.client.opensearch.indices.DeleteIndexTemplateRequest;
import org.opensearch.client.opensearch.indices.GetIndicesSettingsRequest;
import org.opensearch.client.opensearch.indices.GetIndicesSettingsResponse;
import org.opensearch.client.opensearch.indices.GetMappingRequest;
import org.opensearch.client.opensearch.indices.GetMappingResponse;
import org.opensearch.client.opensearch.indices.PutIndexTemplateRequest;

/**
 * Run with: <c>./gradlew :samples:run -Dsamples.mainClass=IndexTemplates</c>
 */
public class IndexTemplates {
    private static final Logger LOGGER = LogManager.getLogger(IndexTemplates.class);

    public static void main(String[] args) {
        try {
            var client = SampleClient.create();
            var version = client.info().version();
            LOGGER.info("Server: {}@{}", version.distribution(), version.number());

            final var indexTemplateName = "my-index-template";

            if (client.indices().existsIndexTemplate(t -> t.name(indexTemplateName)).value()) {
                DeleteIndexTemplateRequest deleteIndexTemplateRequest = DeleteIndexTemplateRequest.of(i -> i.name(indexTemplateName));
                LOGGER.info("Deleting index template {}", indexTemplateName);
                client.indices().deleteIndexTemplate(deleteIndexTemplateRequest);
            }

            // Create an index template composed of two component templates, one for index settings, and one for mappings
            final var indexSettingsComponentTemplate = "index-settings";
            PutComponentTemplateRequest putComponentTemplateRequest = PutComponentTemplateRequest.of(
                c -> c.name(indexSettingsComponentTemplate)
                    .settings(
                        s -> s.numberOfShards("2")
                            .numberOfReplicas("1")
                            .indexing(
                                i -> i.slowlog(
                                    sl -> sl.level("info")
                                        .reformat(true)
                                        .threshold(th -> th.index(ith -> ith.warn(Time.of(t -> t.time("2s")))))
                                )
                            )
                            .search(
                                se -> se.slowlog(sl -> sl.level("info").threshold(th -> th.query(q -> q.warn(Time.of(t -> t.time("2s"))))))
                            )
                    )
            );
            LOGGER.info("Creating component template {}", indexSettingsComponentTemplate);
            client.cluster().putComponentTemplate(putComponentTemplateRequest);

            final var indexMappingsComponentTemplate = "index-mappings";
            putComponentTemplateRequest = PutComponentTemplateRequest.of(
                c -> c.name(indexMappingsComponentTemplate).mappings(m -> m.properties("age", p -> p.integer(i -> i)))
            );
            LOGGER.info("Creating component template {}", indexMappingsComponentTemplate);
            client.cluster().putComponentTemplate(putComponentTemplateRequest);

            PutIndexTemplateRequest putIndexTemplateRequest = PutIndexTemplateRequest.of(
                it -> it.name(indexTemplateName)
                    .indexPatterns("my-index-*")
                    .composedOf(List.of(indexSettingsComponentTemplate, indexMappingsComponentTemplate))
            );

            LOGGER.info("Creating index template {}", indexTemplateName);
            client.indices().putIndexTemplate(putIndexTemplateRequest);

            final var indexName = "my-index-1";
            if (client.indices().exists(r -> r.index(indexName)).value()) {
                LOGGER.info("Deleting index {}", indexName);
                client.indices().delete(DeleteIndexRequest.of(d -> d.index(indexName)));
            }

            LOGGER.info("Creating index {}", indexName);
            client.indices().create(CreateIndexRequest.of(c -> c.index(indexName)));

            GetMappingResponse getMappingResponse = client.indices().getMapping(GetMappingRequest.of(m -> m.index(indexName)));
            // mappings for the index should contain those defined in component template
            LOGGER.info("Mappings {} found for index {}", getMappingResponse.result().get(indexName).mappings(), indexName);

            GetIndicesSettingsResponse getSettingsResponse = client.indices()
                .getSettings(GetIndicesSettingsRequest.of(m -> m.index(indexName)));
            // settings for the index should contain those defined in component template
            LOGGER.info("Settings {} found for index {}", getSettingsResponse.result().get(indexName).settings(), indexName);

            LOGGER.info("Deleting index {}", indexName);
            client.indices().delete(DeleteIndexRequest.of(d -> d.index(indexName)));
        } catch (Exception e) {
            LOGGER.error("Unexpected exception", e);
        }
    }
}
