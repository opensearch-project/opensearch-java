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

import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.opensearch._types.analysis.Analyzer;
import org.opensearch.client.opensearch._types.analysis.TokenFilterDefinition;
import org.opensearch.client.opensearch._types.analysis.TokenizerBuilders;
import org.opensearch.client.opensearch._types.analysis.TokenizerDefinition;
import org.opensearch.client.opensearch.core.TermvectorsResponse;
import org.opensearch.client.opensearch._types.mapping.FieldMapping;
import org.opensearch.client.opensearch._types.mapping.Property;
import org.opensearch.client.opensearch._types.mapping.TermVectorOption;
import org.opensearch.client.opensearch._types.mapping.TextProperty;
import org.opensearch.client.opensearch.experiments.api.FooRequest;
import org.opensearch.client.opensearch.indices.GetFieldMappingResponse;
import org.opensearch.client.opensearch.indices.IndexSettings;
import org.opensearch.client.opensearch.indices.IndexSettingsMapping;
import org.opensearch.client.opensearch.indices.Translog;
import org.opensearch.client.opensearch.indices.get_field_mapping.TypeFieldMappings;
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

    @Test
    public void testSmartcn_Analyzer() {
        final Analyzer analyzer = new Analyzer.Builder()
            .smartcn()
            .build();

        assertTrue(analyzer.isSmartcn());

        String str = toJson(analyzer);
        assertEquals("{\"type\":\"smartcn\"}", str);

        Analyzer analyzer2 = fromJson(str, Analyzer._DESERIALIZER);
        assertTrue(analyzer2.isSmartcn());
    }

    @Test
    public void testSmartcn_Tokenizer() {
        final TokenizerDefinition tokenizerDefinition = TokenizerBuilders.definition().smartcn(b -> b).build();

        String str = toJson(tokenizerDefinition);
        assertEquals("{\"type\":\"smartcn_tokenizer\"}", str);

        TokenizerDefinition tokenizerDefinition2 = fromJson(str, TokenizerDefinition._DESERIALIZER);
    }

    @Test
    public void testSmartcn_StopFilter() {
        final TokenFilterDefinition analyzer = new TokenFilterDefinition.Builder()
            .smartcn_stop(b -> b)
            .build();

        String str = toJson(analyzer);
        assertEquals("{\"type\":\"smartcn_stop\"}", str);

        TokenFilterDefinition analyzer2 = fromJson(str, TokenFilterDefinition._DESERIALIZER);
    }
    @Test
    public void testCjk_Analyzer() {
        final Analyzer analyzer = new Analyzer.Builder()
            .cjk(b -> b
                .stopwords(List.of("a", "b", "c"))
                .stopwordsPath("path")
            )
            .build();

        assertTrue(analyzer.isCjk());

        String str = toJson(analyzer);
        assertEquals("{\"type\":\"cjk\",\"stopwords\":[\"a\",\"b\",\"c\"],\"stopwords_path\":\"path\"}", str);

        Analyzer analyzer2 = fromJson(str, Analyzer._DESERIALIZER);
        assertTrue(analyzer2.isCjk());
        assertEquals(analyzer.cjk().stopwords(), analyzer2.cjk().stopwords());
        assertEquals(analyzer.cjk().stopwordsPath(), analyzer2.cjk().stopwordsPath());
    }

    @Test
    public void testFieldMappingResponse() {
        final String indexName = "indexName";
        final String field1Name = "field1";
        final String field1Analyzer = "my_analyzer";
        final FieldMapping field1 = FieldMapping.of(fmb -> fmb
            .fullName(field1Name)
            .mapping(field1Name, pb -> pb
                .text(tpb -> tpb
                    .store(true)
                    .termVector(TermVectorOption.WithPositionsOffsets)
                    .analyzer(field1Analyzer)
                    .positionIncrementGap(10))
            )
        );
        final String field3Name = "field3";
        // Build aFieldMappingResponse with several fields
        final GetFieldMappingResponse response = GetFieldMappingResponse.of(b -> b
            .putResult(indexName, TypeFieldMappings.of(tfmb -> tfmb
                    .putMappings(field1Name, field1)
                    .putMappings("field2", fmb -> fmb
                        .fullName("field2")
                        .mapping("field2", pb -> pb
                            .text(tpb -> tpb
                                .store(true)
                                .termVector(TermVectorOption.WithPositionsOffsets)
                                .analyzer("another_analyzer")
                                .positionIncrementGap(10))
                        )
                    )
                    .putMappings(field3Name, fmb -> fmb
                        .fullName(field3Name)
                        .mapping(field3Name, pb -> pb
                            .text(tpb -> tpb
                                .store(true)
                                .termVector(TermVectorOption.WithPositionsOffsets)
                                .analyzer("this_analyzer")
                                .positionIncrementGap(10))
                        )
                    )
                )
            )
        );
        String str = toJson(response);
        assertEquals("{\"indexName\":{\"mappings\":{\"field1\":{\"full_name\":\"field1\",\"mapping\""
            +":{\"field1\":{\"type\":\"text\",\"store\":true,\"analyzer\":\"my_analyzer\"," +
            "\"position_increment_gap\":10,\"term_vector\":\"with_positions_offsets\"}}},"
            +"\"field3\":{\"full_name\":\"field3\",\"mapping\":{\"field3\":{\"type\":\"text\",\"store\":true," +
            "\"analyzer\":\"this_analyzer\",\"position_increment_gap\":10,\"term_vector\":\"with_positions_offsets\"}}},"
            +"\"field2\":{\"full_name\":\"field2\",\"mapping\":{\"field2\":{\"type\":\"text\",\"store\":true,"
            +"\"analyzer\":\"another_analyzer\",\"position_increment_gap\":10,\"term_vector\":\"with_positions_offsets\"}}}}}}", str);

        final GetFieldMappingResponse response2 = fromJson(str, GetFieldMappingResponse._DESERIALIZER);
        final TypeFieldMappings typeFieldMappings = response2.get(indexName);
        assertNotNull(typeFieldMappings);
        final Map<String, FieldMapping> mappings = typeFieldMappings.mappings();
        assertFalse(mappings.isEmpty());
        final FieldMapping field1_des = mappings.get(field1Name);
        assertNotNull(field1_des);
        assertEquals(field1Name, field1_des.fullName());
        final Property field1Prop = field1_des.mapping().get(field1Name);
        assertNotNull(field1Prop);
        final TextProperty textProperty = field1Prop.text();
        assertNotNull(textProperty);
        assertEquals(field1Analyzer, textProperty.analyzer());

        assertNotNull(mappings.get(field3Name));
    }
 
    @Test
    public void testTermvectorsResponseOptionals() {
        // Build a response without any optionals
        final TermvectorsResponse response = TermvectorsResponse.of(b -> b
            .index("index")
            .id("id")
            .version(1)
            .found(true)
            .took(0)
            .termVectors("key1", tvb -> tvb
                .terms("term1", tb -> tb
                    .score(0.3)
                )
            )
        );

        String str = toJson(response);
        assertEquals("{\"found\":true,\"_id\":\"id\",\"_index\":\"index\","
            +"\"term_vectors\":{\"key1\":{\"terms\":{\"term1\":{\"score\":0.3}}}},\"took\":0,\"_version\":1}", str);

        final TermvectorsResponse response2 = fromJson(str, TermvectorsResponse._DESERIALIZER);
        assertEquals(response.index(), response2.index());
    }

}
