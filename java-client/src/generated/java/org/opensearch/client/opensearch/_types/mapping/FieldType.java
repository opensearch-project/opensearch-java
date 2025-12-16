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

package org.opensearch.client.opensearch._types.mapping;

import javax.annotation.Generated;
import org.opensearch.client.json.JsonEnum;
import org.opensearch.client.json.JsonpDeserializable;

// typedef: _types.mapping.FieldType

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public enum FieldType implements JsonEnum {
    AggregateMetricDouble("aggregate_metric_double"),

    Alias("alias"),

    Binary("binary"),

    Boolean("boolean"),

    Byte("byte"),

    Completion("completion"),

    ConstantKeyword("constant_keyword"),

    Date("date"),

    DateNanos("date_nanos"),

    DateRange("date_range"),

    Double("double"),

    DoubleRange("double_range"),

    FlatObject("flat_object"),

    Float("float"),

    FloatRange("float_range"),

    GeoPoint("geo_point"),

    GeoShape("geo_shape"),

    HalfFloat("half_float"),

    Histogram("histogram"),

    IcuCollationKeyword("icu_collation_keyword"),

    Integer("integer"),

    IntegerRange("integer_range"),

    Ip("ip"),

    IpRange("ip_range"),

    Join("join"),

    Keyword("keyword"),

    KnnVector("knn_vector"),

    Long("long"),

    LongRange("long_range"),

    MatchOnlyText("match_only_text"),

    Murmur3("murmur3"),

    Nested("nested"),

    Object("object"),

    Percolator("percolator"),

    RankFeature("rank_feature"),

    RankFeatures("rank_features"),

    ScaledFloat("scaled_float"),

    SearchAsYouType("search_as_you_type"),

    Semantic("semantic"),

    Short("short"),

    Text("text"),

    TokenCount("token_count"),

    UnsignedLong("unsigned_long"),

    Version("version"),

    Wildcard("wildcard"),

    XyPoint("xy_point"),

    XyShape("xy_shape");

    private final String jsonValue;

    FieldType(String jsonValue) {
        this.jsonValue = jsonValue;
    }

    public String jsonValue() {
        return this.jsonValue;
    }

    public static final JsonEnum.Deserializer<FieldType> _DESERIALIZER = new JsonEnum.Deserializer<>(FieldType.values());
}
