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

package org.opensearch.client.opensearch.experiments;

import org.junit.Test;
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.opensearch.experiments.api.FooRequest;
import org.opensearch.client.opensearch.indices.IndexSettings;
import org.opensearch.client.opensearch.indices.IndexSettingsMapping;
import org.opensearch.client.opensearch.indices.Translog;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class ParsingTests extends ModelTestCase {

  @Test
  public void testFoo() {

    FooRequest foo = FooRequest.builder()
            .name("z")
            .value(1)
            .indices("a", "b", "c")
            .bar(b -> b
                    .name("Raise the bar")
            )
            .build();

    String str = toJson(foo);
    assertEquals("{\"name\":\"z\",\"value\":1,\"indices\":[\"a\",\"b\",\"c\"],\"bar\":{\"name\":\"Raise the bar\"}}", str);

    FooRequest foo2 = fromJson(str, FooRequest.parser());
    assertEquals(foo.name(), foo2.name());
    assertEquals(foo.value(), foo2.value());
    assertNull(foo2.size());
    assertEquals(foo.indices(), foo2.indices());
    assertEquals("Raise the bar", foo.bar().name());
  }

  @Test
  public void testIndexSettingsTranslogOptionsParsing() {

    var indexSettings = IndexSettings.of(_1 -> _1.translog(Translog.of(tr -> tr
            .syncInterval(Time.of(t -> t.time("10s")))
            .durability("async")
            .flushThresholdSize("256mb"))));

    var str = toJson(indexSettings);
    assertEquals("{\"translog\":{\"durability\":\"async\",\"flush_threshold_size\":\"256mb\"," +
            "\"sync_interval\":\"10s\"}}", str);

    IndexSettings deserialized = fromJson(str, IndexSettings._DESERIALIZER);
    assertEquals(indexSettings.translog().syncInterval().time(), deserialized.translog().syncInterval().time());
    assertEquals(indexSettings.translog().durability(), deserialized.translog().durability());
    assertEquals(indexSettings.translog().flushThresholdSize(), deserialized.translog().flushThresholdSize());

    var deprecatedForm = "{\"translog\":{\"sync_interval\":\"10s\"},\"translog.durability\":\"async\",\"translog" +
            ".flush_threshold_size\":\"256mb\"}";
    IndexSettings deprecatedDeserialized = fromJson(deprecatedForm, IndexSettings._DESERIALIZER);
    assertEquals(indexSettings.translog().syncInterval().time(), deprecatedDeserialized.translog().syncInterval().time());
    assertEquals(indexSettings.translog().durability(), deprecatedDeserialized.translog().durability());
    assertEquals(indexSettings.translog().flushThresholdSize(), deprecatedDeserialized.translog().flushThresholdSize());
  }

  @Test
  public void testIndexSettingsMappingParsing() {

    var mapping = IndexSettingsMapping.of(b -> b
            .totalFields(d -> d.limit(1L))
            .depth(d -> d.limit(2L))
            .nestedFields(d -> d.limit(3L))
            .nestedObjects(d -> d.limit(4L))
            .fieldNameLength(d -> d.limit(5L)));

    var str = toJson(mapping);
    assertEquals("{\"total_fields\":{\"limit\":1},\"depth\":{\"limit\":2},\"nested_fields\":{\"limit\":3}," +
                 "\"nested_objects\":{\"limit\":4},\"field_name_length\":{\"limit\":5}}", str);

    var deserialized = fromJson(str, IndexSettingsMapping._DESERIALIZER);
    assertEquals(mapping.totalFields().limit(), deserialized.totalFields().limit());
    assertEquals(mapping.depth().limit(), deserialized.depth().limit());
    assertEquals(mapping.nestedFields().limit(), deserialized.nestedFields().limit());
    assertEquals(mapping.nestedObjects().limit(), deserialized.nestedObjects().limit());
    assertEquals(mapping.fieldNameLength().limit(), deserialized.fieldNameLength().limit());
  }

}
