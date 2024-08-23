/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.samples.neural;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.opensearch.client.json.JsonData;
import org.opensearch.client.opensearch.OpenSearchClient;
import org.opensearch.client.opensearch.ml.DeleteModelGroupRequest;
import org.opensearch.client.samples.SampleClient;

/**
 * Run with: <c>./gradlew :samples:run -Dsamples.mainClass=neural.NeuralSearch</c>
 */
public class NeuralSearch {
    private static final String SAMPLE_NAME = "neural-search";
    private static final String RESOURCE_NAME_PREFIX = "csharp-" + SAMPLE_NAME;
    private static final String ML_MODEL_GROUP_NAME = RESOURCE_NAME_PREFIX + "-model-group";
    private static final String INGEST_PIPELINE_NAME = RESOURCE_NAME_PREFIX + "-ingest-pipeline";
    private static final String INDEX_NAME = RESOURCE_NAME_PREFIX + "-index";

    private static final Logger LOGGER = LogManager.getLogger(NeuralSearch.class);

    public static void main(String[] args) {
        OpenSearchClient client = null;
        String modelGroupId = null;

        try {
            client = SampleClient.create();

            var version = client.info().version();
            LOGGER.info("Server: {}@{}", version.distribution(), version.number());

            LOGGER.info("Temporarily configuring the cluster to allow local running of the ML model");
            client.cluster()
                .putSettings(
                    p -> p.transient_("plugins.ml_commons.only_run_on_ml_node", JsonData.of(false))
                        .transient_("plugins.ml_commons.model_access_control_enabled", JsonData.of(true))
                        .transient_("plugins.ml_commons.native_memory_threshold", JsonData.of(99))
                );

            LOGGER.info("Registering ML model group");
            var groupRegistration = client.ml()
                .registerModelGroup(
                    r -> r.name(ML_MODEL_GROUP_NAME)
                        .description("A model group for the opensearch-java " + SAMPLE_NAME + " sample")
                        .accessMode("public")
                );
            if (!"CREATED".equals(groupRegistration.status())) throw new Exception(
                "Expected ML Model Group to be CREATED, was: " + groupRegistration.status()
            );
            modelGroupId = groupRegistration.modelGroupId();
            LOGGER.info("ML Model Group `{}` id: {}", ML_MODEL_GROUP_NAME, modelGroupId);

            // TODO: Register ML Model
        } catch (Exception e) {
            LOGGER.error("Unexpected exception", e);
        } finally {
            // TODO: Delete ML Model

            if (modelGroupId != null) {
                try {
                    LOGGER.info("Deleting ML Model Group: {}", modelGroupId);
                    var groupDeleted = client.ml().deleteModelGroup(new DeleteModelGroupRequest.Builder().modelGroupId(modelGroupId).build());
                    LOGGER.info("Deleted ML Model Group: {}", groupDeleted.result());
                } catch (Exception ignored) {}
            }
        }
    }
}
