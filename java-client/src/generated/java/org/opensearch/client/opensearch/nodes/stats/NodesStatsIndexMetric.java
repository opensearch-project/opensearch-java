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

package org.opensearch.client.opensearch.nodes.stats;

import javax.annotation.Generated;
import org.opensearch.client.json.JsonEnum;
import org.opensearch.client.json.JsonpDeserializable;

// typedef: nodes.stats.IndexMetric

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public enum NodesStatsIndexMetric implements JsonEnum {
    All("_all"),

    Completion("completion"),

    Docs("docs"),

    Fielddata("fielddata"),

    Flush("flush"),

    Get("get"),

    Indexing("indexing"),

    Merge("merge"),

    QueryCache("query_cache"),

    Recovery("recovery"),

    Refresh("refresh"),

    RequestCache("request_cache"),

    Search("search"),

    Segments("segments"),

    Store("store"),

    Suggest("suggest"),

    Translog("translog"),

    Warmer("warmer");

    private final String jsonValue;

    NodesStatsIndexMetric(String jsonValue) {
        this.jsonValue = jsonValue;
    }

    public String jsonValue() {
        return this.jsonValue;
    }

    public static final JsonEnum.Deserializer<NodesStatsIndexMetric> _DESERIALIZER = new JsonEnum.Deserializer<>(
        NodesStatsIndexMetric.values()
    );
}
