/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.ml;

import java.util.Arrays;
import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class PredictTest extends ModelTestCase {

    // Scenario: predict_model request for an embedding model. Expected: POST to the model's _predict path with text_docs as the body.
    @Test
    public void testPredictModelRequest() {
        PredictModelRequest request = PredictModelRequest.of(r -> r.modelId("my/model").textDocs("hello", "world"));

        assertEquals("POST", PredictModelRequest._ENDPOINT.method(request));
        assertEquals("/_plugins/_ml/models/my%2Fmodel/_predict", PredictModelRequest._ENDPOINT.requestUrl(request));
        assertEquals("{\"text_docs\":[\"hello\",\"world\"]}", toJson(request));
    }

    // Scenario: predict_model response carrying an embedding tensor. Expected: output name, type, shape and data are all readable.
    @Test
    public void testPredictModelResponse() {
        String json = "{\"inference_results\":[{\"output\":[{\"name\":\"sentence_embedding\",\"data_type\":\"FLOAT32\","
            + "\"shape\":[3],\"data\":[0.5,-1.25,2.0]}]}]}";

        PredictModelResponse response = fromJson(json, PredictModelResponse.class);

        PredictModelOutput output = response.inferenceResults().get(0).output().get(0);
        assertEquals("sentence_embedding", output.name());
        assertEquals("FLOAT32", output.dataType());
        assertEquals(Arrays.asList(3L), output.shape());
        assertEquals(Arrays.asList(0.5, -1.25, 2.0), output.data());
    }

    // Scenario: predict request for an algorithm and trained model. Expected: POST to _predict/{algorithm}/{model} with text_docs as body.
    @Test
    public void testPredictRequest() {
        PredictRequest request = PredictRequest.of(r -> r.algorithmName("kmeans").modelId("m1").textDocs("hello"));

        assertEquals("POST", PredictRequest._ENDPOINT.method(request));
        assertEquals("/_plugins/_ml/_predict/kmeans/m1", PredictRequest._ENDPOINT.requestUrl(request));
        assertEquals("{\"text_docs\":[\"hello\"]}", toJson(request));
    }
}
