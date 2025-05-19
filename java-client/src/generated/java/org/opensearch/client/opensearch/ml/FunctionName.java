/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

//----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------

package org.opensearch.client.opensearch.ml;

import javax.annotation.Generated;
import org.opensearch.client.json.JsonEnum;
import org.opensearch.client.json.JsonpDeserializable;

// typedef: ml.FunctionName

/**
 * The function name.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public enum FunctionName implements JsonEnum {
    AdLibsvm("AD_LIBSVM"),

    Agent("AGENT"),

    AnomalyLocalization("ANOMALY_LOCALIZATION"),

    BatchRcf("BATCH_RCF"),

    Connector("CONNECTOR"),

    FitRcf("FIT_RCF"),

    Kmeans("KMEANS"),

    LinearRegression("LINEAR_REGRESSION"),

    LocalSampleCalculator("LOCAL_SAMPLE_CALCULATOR"),

    LogisticRegression("LOGISTIC_REGRESSION"),

    MetricsCorrelation("METRICS_CORRELATION"),

    QuestionAnswering("QUESTION_ANSWERING"),

    RcfSummarize("RCF_SUMMARIZE"),

    Remote("REMOTE"),

    SampleAlgo("SAMPLE_ALGO"),

    SparseEncoding("SPARSE_ENCODING"),

    SparseTokenize("SPARSE_TOKENIZE"),

    TextEmbedding("TEXT_EMBEDDING"),

    TextSimilarity("TEXT_SIMILARITY");

    private final String jsonValue;

    FunctionName(String jsonValue) {
        this.jsonValue = jsonValue;
    }

    public String jsonValue() {
        return this.jsonValue;
    }

    public static final JsonEnum.Deserializer<FunctionName> _DESERIALIZER = new JsonEnum.Deserializer<>(FunctionName.values());
}
