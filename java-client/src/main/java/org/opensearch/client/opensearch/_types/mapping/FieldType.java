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

package org.opensearch.client.opensearch._types.mapping;

import org.opensearch.client.json.JsonEnum;
import org.opensearch.client.json.JsonpDeserializable;

@JsonpDeserializable
public enum FieldType implements JsonEnum {
    None("none"),

    GeoPoint("geo_point"),

    GeoShape("geo_shape"),

    Ip("ip"),

    Binary("binary"),

    Keyword("keyword"),

    Text("text"),

    SearchAsYouType("search_as_you_type"),

    Date("date"),

    DateNanos("date_nanos"),

    Boolean("boolean"),

    Completion("completion"),

    Nested("nested"),

    Object("object"),

    Murmur3("murmur3"),

    TokenCount("token_count"),

    Percolator("percolator"),

    Integer("integer"),

    Long("long"),

    Short("short"),

    Byte("byte"),

    Float("float"),

    HalfFloat("half_float"),

    ScaledFloat("scaled_float"),

    Double("double"),

    IntegerRange("integer_range"),

    FloatRange("float_range"),

    LongRange("long_range"),

    DoubleRange("double_range"),

    DateRange("date_range"),

    IpRange("ip_range"),

    Alias("alias"),

    Join("join"),

    RankFeature("rank_feature"),

    RankFeatures("rank_features"),

    FlatObject("flat_object"),

    XyShape("xy_shape"),

    Histogram("histogram"),

    ConstantKeyword("constant_keyword"),

    AggregateMetricDouble("aggregate_metric_double"),

    KnnVector("knn_vector"),;

    private final String jsonValue;

    FieldType(String jsonValue) {
        this.jsonValue = jsonValue;
    }

    public String jsonValue() {
        return this.jsonValue;
    }

    public static final JsonEnum.Deserializer<FieldType> _DESERIALIZER = new JsonEnum.Deserializer<>(FieldType.values());
}
