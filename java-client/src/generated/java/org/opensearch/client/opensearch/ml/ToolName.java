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

// typedef: ml.ToolName

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public enum ToolName implements JsonEnum {
    AgentTool("AgentTool"),

    CatIndexTool("CatIndexTool"),

    ConnectorTool("ConnectorTool"),

    CreateAnomalyDetectorTool("CreateAnomalyDetectorTool"),

    IndexMappingTool("IndexMappingTool"),

    ListIndexTool("ListIndexTool"),

    LogPatternTool("LogPatternTool"),

    MlModelTool("MLModelTool"),

    NeuralSparseSearchTool("NeuralSparseSearchTool"),

    PplTool("PPLTool"),

    RagTool("RAGTool"),

    SearchAlertsTool("SearchAlertsTool"),

    SearchAnomalyDetectorsTool("SearchAnomalyDetectorsTool"),

    SearchAnomalyResultsTool("SearchAnomalyResultsTool"),

    SearchIndexTool("SearchIndexTool"),

    SearchMonitorsTool("SearchMonitorsTool"),

    VectorDbTool("VectorDBTool"),

    VisualizationTool("VisualizationTool");

    private final String jsonValue;

    ToolName(String jsonValue) {
        this.jsonValue = jsonValue;
    }

    public String jsonValue() {
        return this.jsonValue;
    }

    public static final JsonEnum.Deserializer<ToolName> _DESERIALIZER = new JsonEnum.Deserializer<>(ToolName.values());
}
