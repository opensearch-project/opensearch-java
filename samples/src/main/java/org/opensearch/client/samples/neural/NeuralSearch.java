/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.samples.neural;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.opensearch.client.json.JsonData;
import org.opensearch.client.opensearch.OpenSearchClient;
import org.opensearch.client.opensearch._types.OpenSearchException;
import org.opensearch.client.opensearch._types.Refresh;
import org.opensearch.client.opensearch._types.query_dsl.NeuralQuery;
import org.opensearch.client.opensearch._types.query_dsl.Query;
import org.opensearch.client.opensearch.core.SearchRequest;
import org.opensearch.client.opensearch.core.bulk.BulkOperation;
import org.opensearch.client.opensearch.ingest.Processor;
import org.opensearch.client.opensearch.ingest.PutPipelineRequest;
import org.opensearch.client.opensearch.ingest.TextEmbeddingProcessor;
import org.opensearch.client.opensearch.ml.DeleteModelGroupRequest;
import org.opensearch.client.opensearch.ml.DeleteModelRequest;
import org.opensearch.client.opensearch.ml.DeleteTaskRequest;
import org.opensearch.client.opensearch.ml.DeployModelRequest;
import org.opensearch.client.opensearch.ml.GetTaskRequest;
import org.opensearch.client.opensearch.ml.ModelFormat;
import org.opensearch.client.opensearch.ml.ModelGroupAccessMode;
import org.opensearch.client.opensearch.ml.RegisterModelRequest;
import org.opensearch.client.opensearch.ml.UndeployModelRequest;
import org.opensearch.client.samples.SampleClient;

/**
 * Run with: {@code ./gradlew :samples:run -Dsamples.mainClass=neural.NeuralSearch}
 */
public class NeuralSearch {
    private static final String SAMPLE_NAME = "neural-search";
    private static final String RESOURCE_NAME_PREFIX = "java-" + SAMPLE_NAME;
    private static final String ML_MODEL_GROUP_NAME = RESOURCE_NAME_PREFIX + "-model-group";
    private static final String INGEST_PIPELINE_NAME = RESOURCE_NAME_PREFIX + "-ingest-pipeline";
    private static final String INDEX_NAME = RESOURCE_NAME_PREFIX + "-index";

    private static final Logger LOGGER = LogManager.getLogger(NeuralSearch.class);

    public static void main(String[] args) {
        OpenSearchClient client = null;
        String modelGroupId = null;
        String modelRegistrationTaskId = null;
        String modelId = null;
        String modelDeployTaskId = null;
        boolean createdIngestPipeline = false;
        boolean createdIndex = false;

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
                        .accessMode(ModelGroupAccessMode.Public)
                );
            if (!"CREATED".equals(groupRegistration.status())) throw new Exception(
                "Expected ML model group to be CREATED, was: " + groupRegistration.status()
            );
            modelGroupId = groupRegistration.modelGroupId();
            LOGGER.info("ML model group `{}` id: {}", ML_MODEL_GROUP_NAME, modelGroupId);

            LOGGER.info("Registering ML model");
            var modelRegistration = client.ml()
                .registerModel(
                    new RegisterModelRequest.Builder().name("huggingface/sentence-transformers/msmarco-distilbert-base-tas-b")
                        .version("1.0.1")
                        .modelGroupId(modelGroupId)
                        .modelFormat(ModelFormat.TorchScript)
                        .build()
                );
            if (!"CREATED".equals(modelRegistration.status())) throw new Exception(
                "Expected ML model registration task to be CREATED, was: " + modelRegistration.status()
            );
            modelRegistrationTaskId = modelRegistration.taskId();
            LOGGER.info("ML model registration task: {}", modelRegistrationTaskId);

            LOGGER.info("Waiting for ML model registration to complete");
            registerWait: while (true) {
                var modelRegistrationTask = client.ml().getTask(new GetTaskRequest.Builder().taskId(modelRegistrationTaskId).build());
                LOGGER.info("ML model registration: {}", modelRegistrationTask.state());
                switch (modelRegistrationTask.state()) {
                    case Completed:
                        modelId = modelRegistrationTask.modelId();
                        break registerWait;
                    case Failed:
                        throw new Exception("ML model registration failed: " + modelRegistrationTask.error());
                    default:
                        // noinspection BusyWait
                        Thread.sleep(10_000);
                }
            }
            LOGGER.info("ML model registered: {}", modelId);

            LOGGER.info("Deploying ML model");
            var modelDeploy = client.ml().deployModel(new DeployModelRequest.Builder().modelId(modelId).build());
            if (!"CREATED".equals(modelDeploy.status())) throw new Exception(
                "Expected ML model deploy task to be CREATED, was: " + modelDeploy.status()
            );
            modelDeployTaskId = modelDeploy.taskId();
            LOGGER.info("ML model deploy task: {}", modelDeployTaskId);

            LOGGER.info("Waiting for ML model deployment to complete");
            deployWait: while (true) {
                var modelDeployTask = client.ml().getTask(new GetTaskRequest.Builder().taskId(modelDeployTaskId).build());
                LOGGER.info("ML model deployment: {}", modelDeployTask.state());
                switch (modelDeployTask.state()) {
                    case Completed:
                        break deployWait;
                    case Failed:
                        throw new Exception("ML model deployment failed: " + modelDeployTask.error());
                    default:
                        // noinspection BusyWait
                        Thread.sleep(10_000);
                }
            }
            LOGGER.info("ML model deployed");

            LOGGER.info("Creating ingest pipeline: {}", INGEST_PIPELINE_NAME);
            client.ingest()
                .putPipeline(
                    new PutPipelineRequest.Builder().id(INGEST_PIPELINE_NAME)
                        .description("A test_embedding ingest pipeline for the opensearch-java " + SAMPLE_NAME + " sample")
                        .processors(
                            new Processor.Builder().textEmbedding(
                                new TextEmbeddingProcessor.Builder().modelId(modelId).fieldMap("text", "passageEmbedding").build()
                            ).build()
                        )
                        .build()
                );
            createdIngestPipeline = true;
            LOGGER.info("Created ingest pipeline");

            LOGGER.info("Creating index: {}", INDEX_NAME);
            client.indices()
                .create(
                    i -> i.index(INDEX_NAME)
                        .settings(s -> s.index(is -> is.knn(true)).defaultPipeline(INGEST_PIPELINE_NAME))
                        .mappings(
                            m -> m.properties("id", p -> p.text(t -> t))
                                .properties("text", p -> p.text(t -> t))
                                .properties(
                                    "passageEmbedding",
                                    p -> p.knnVector(
                                        kv -> kv.dimension(768).method(kvm -> kvm.engine("lucene").spaceType("l2").name("hnsw"))
                                    )
                                )
                        )
                );
            createdIndex = true;
            LOGGER.info("Created index");

            LOGGER.info("Indexing documents");
            var documents = new NeuralSearchDoc[] {
                new NeuralSearchDoc(
                    "4319130149.jpg",
                    "A West Virginia university women 's basketball team , officials , and a small gathering of fans are in a West Virginia arena ."
                ),
                new NeuralSearchDoc("1775029934.jpg", "A wild animal races across an uncut field with a minimal amount of trees ."),
                new NeuralSearchDoc(
                    "2664027527.jpg",
                    "People line the stands which advertise Freemont 's orthopedics , a cowboy rides a light brown bucking bronco ."
                ),
                new NeuralSearchDoc("4427058951.jpg", "A man who is riding a wild horse in the rodeo is very near to falling off ."),
                new NeuralSearchDoc(
                    "2691147709.jpg",
                    "A rodeo cowboy , wearing a cowboy hat , is being thrown off of a wild white horse ."
                ) };
            var bulk = client.bulk(
                b -> b.index(INDEX_NAME)
                    .operations(
                        Arrays.stream(documents)
                            .map(d -> new BulkOperation.Builder().index(i -> i.id(d.getId()).document(d)).build())
                            .collect(Collectors.toList())
                    )
                    .refresh(Refresh.WaitFor)
            );
            LOGGER.info("Indexed {} documents", bulk.items().stream().filter(i -> i.error() == null).count());

            LOGGER.info("Performing neural search for text 'wild west'");
            var search = client.search(
                new SearchRequest.Builder().index(INDEX_NAME)
                    .source(sc -> sc.filter(sf -> sf.excludes("passageEmbedding")))
                    .query(
                        new Query.Builder().neural(
                            new NeuralQuery.Builder().field("passageEmbedding").queryText("wild west").modelId(modelId).k(5).build()
                        ).build()
                    )
                    .build(),
                NeuralSearchDoc.class
            );
            LOGGER.info("Found {} documents", search.hits().hits().size());
            for (var hit : search.hits().hits()) {
                LOGGER.info(
                    "- Document id: {}, score: {}, text: {}",
                    hit.id(),
                    hit.score(),
                    Objects.requireNonNull(hit.source()).getText()
                );
            }
        } catch (Exception e) {
            LOGGER.error("Unexpected exception", e);
        } finally {
            LOGGER.info("-- CLEANING UP --");

            if (createdIndex) {
                try {
                    LOGGER.info("Deleting index: {}", INDEX_NAME);
                    client.indices().delete(d -> d.index(INDEX_NAME));
                    LOGGER.info("Deleted index");
                } catch (Exception ignored) {}
            }

            if (createdIngestPipeline) {
                try {
                    LOGGER.info("Deleting ingest pipeline: {}", INGEST_PIPELINE_NAME);
                    client.ingest().deletePipeline(d -> d.id(INGEST_PIPELINE_NAME));
                    LOGGER.info("Deleted ingest pipeline");
                } catch (Exception ignored) {}
            }

            if (modelDeployTaskId != null) {
                try {
                    LOGGER.info("Deleting ML model deploy task: {}", modelDeployTaskId);
                    var taskDeleted = client.ml().deleteTask(new DeleteTaskRequest.Builder().taskId(modelDeployTaskId).build());
                    LOGGER.info("Deleted ML model deploy task: {}", taskDeleted.result());
                } catch (Exception ignored) {}
            }

            if (modelId != null) {
                while (true) {
                    try {
                        LOGGER.info("Deleting ML model: {}", modelId);
                        var modelDeleted = client.ml().deleteModel(new DeleteModelRequest.Builder().modelId(modelId).build());
                        LOGGER.info("Deleted ML model: {}", modelDeleted.result());
                        break;
                    } catch (OpenSearchException ex) {
                        var reason = ex.error() != null ? ex.error().reason() : null;

                        if (reason == null || !reason.contains("Try undeploy")) break;

                        try {
                            LOGGER.info("Un-deploying ML model: {}", modelId);
                            client.ml().undeployModel(new UndeployModelRequest.Builder().modelId(modelId).build());
                            LOGGER.info("Un-deployed ML model");
                        } catch (Exception ignored) {}

                        try {
                            // noinspection BusyWait
                            Thread.sleep(10_000);
                        } catch (InterruptedException ignored) {}
                    } catch (IOException ignored) {}
                }
            }

            if (modelRegistrationTaskId != null) {
                try {
                    LOGGER.info("Deleting ML model registration task: {}", modelRegistrationTaskId);
                    var taskDeleted = client.ml().deleteTask(new DeleteTaskRequest.Builder().taskId(modelRegistrationTaskId).build());
                    LOGGER.info("Deleted ML model registration task: {}", taskDeleted.result());
                } catch (Exception ignored) {}
            }

            if (modelGroupId != null) {
                try {
                    LOGGER.info("Deleting ML model group: {}", modelGroupId);
                    var groupDeleted = client.ml()
                        .deleteModelGroup(new DeleteModelGroupRequest.Builder().modelGroupId(modelGroupId).build());
                    LOGGER.info("Deleted ML model group: {}", groupDeleted.result());
                } catch (Exception ignored) {}
            }
        }
    }

    private static class NeuralSearchDoc {
        private String id;
        private String text;
        private float[] passageEmbedding;

        public NeuralSearchDoc() {}

        public NeuralSearchDoc(String id, String text) {
            this.id = id;
            this.text = text;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public float[] getPassageEmbedding() {
            return passageEmbedding;
        }

        public void setPassageEmbedding(float[] passageEmbedding) {
            this.passageEmbedding = passageEmbedding;
        }
    }
}
