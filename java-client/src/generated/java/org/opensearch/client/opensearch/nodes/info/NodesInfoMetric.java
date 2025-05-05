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

//----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------

package org.opensearch.client.opensearch.nodes.info;

import javax.annotation.Generated;
import org.opensearch.client.json.JsonEnum;
import org.opensearch.client.json.JsonpDeserializable;

// typedef: nodes.info.Metric

/**
 * The nodes metrics to retrieve.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public enum NodesInfoMetric implements JsonEnum {
    /**
     * Returns all metrics.
     */
    All("_all"),

    /**
     * Returns aggregation information.
     */
    Aggregations("aggregations"),

    /**
     * Returns HTTP connection information.
     */
    Http("http"),

    /**
     * Returns indices stats and settings.
     */
    Indices("indices"),

    /**
     * Returns ingest pipeline information.
     */
    Ingest("ingest"),

    /**
     * Returns JVM stats, process information, and memory usage.
     */
    Jvm("jvm"),

    /**
     * Returns operating system information and stats.
     */
    Os("os"),

    /**
     * Returns installed plugins information.
     */
    Plugins("plugins"),

    /**
     * Returns process statistics.
     */
    Process("process"),

    /**
     * Returns search pipeline configurations.
     */
    SearchPipelines("search_pipelines"),

    /**
     * Returns node settings information.
     */
    Settings("settings"),

    /**
     * Returns thread pool information.
     */
    ThreadPool("thread_pool"),

    /**
     * Returns transport layer information.
     */
    Transport("transport");

    private final String jsonValue;

    NodesInfoMetric(String jsonValue) {
        this.jsonValue = jsonValue;
    }

    public String jsonValue() {
        return this.jsonValue;
    }

    public static final JsonEnum.Deserializer<NodesInfoMetric> _DESERIALIZER = new JsonEnum.Deserializer<>(NodesInfoMetric.values());
}
