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

import java.util.Arrays;
import java.util.Map;
import org.junit.Test;
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.opensearch._types.analysis.Analyzer;
import org.opensearch.client.opensearch._types.analysis.TokenFilterDefinition;
import org.opensearch.client.opensearch._types.analysis.TokenizerBuilders;
import org.opensearch.client.opensearch._types.analysis.TokenizerDefinition;
import org.opensearch.client.opensearch._types.mapping.FieldMapping;
import org.opensearch.client.opensearch._types.mapping.Property;
import org.opensearch.client.opensearch._types.mapping.TermVectorOption;
import org.opensearch.client.opensearch._types.mapping.TextProperty;
import org.opensearch.client.opensearch.core.TermvectorsResponse;
import org.opensearch.client.opensearch.experiments.api.FooRequest;
import org.opensearch.client.opensearch.indices.GetFieldMappingResponse;
import org.opensearch.client.opensearch.indices.IndexSettings;
import org.opensearch.client.opensearch.indices.IndexSettingsIndexing;
import org.opensearch.client.opensearch.indices.IndexSettingsMapping;
import org.opensearch.client.opensearch.indices.IndexSettingsSearch;
import org.opensearch.client.opensearch.indices.TranslogDurability;
import org.opensearch.client.opensearch.indices.get_field_mapping.TypeFieldMappings;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class ParsingTests extends ModelTestCase {

    @Test
    public void testFoo() {

        FooRequest foo = FooRequest.builder().name("z").value(1).indices("a", "b", "c").bar(b -> b.name("Raise the bar")).build();

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

        final IndexSettings indexSettings = IndexSettings.of(
            _1 -> _1.translog(
                tr -> tr.syncInterval(Time.of(t -> t.time("10s"))).durability(TranslogDurability.Async).flushThresholdSize("256mb")
            )
        );

        final String str = toJson(indexSettings);
        assertEquals("{\"translog\":{\"durability\":\"ASYNC\",\"flush_threshold_size\":\"256mb\",\"sync_interval\":\"10s\"}}", str);

        IndexSettings deserialized = fromJson(str, IndexSettings._DESERIALIZER);
        assertEquals(indexSettings.translog().syncInterval().time(), deserialized.translog().syncInterval().time());
        assertEquals(indexSettings.translog().durability(), deserialized.translog().durability());
        assertEquals(indexSettings.translog().flushThresholdSize(), deserialized.translog().flushThresholdSize());

        final String deprecatedForm = "{\"translog\":{\"sync_interval\":\"10s\"},\"translog.durability\":\"async\",\"translog"
            + ".flush_threshold_size\":\"256mb\"}";
        IndexSettings deprecatedDeserialized = fromJson(deprecatedForm, IndexSettings._DESERIALIZER);
        assertEquals(indexSettings.translog().syncInterval().time(), deprecatedDeserialized.translog().syncInterval().time());
        assertEquals(indexSettings.translog().durability(), deprecatedDeserialized.translogDurability());
        assertEquals(indexSettings.translog().flushThresholdSize(), deprecatedDeserialized.translogFlushThresholdSize());
    }

    @Test
    public void testIndexSettingsMappingParsing() {

        final IndexSettingsMapping mapping = IndexSettingsMapping.of(
            b -> b.totalFields(d -> d.limit(1L))
                .depth(d -> d.limit(2L))
                .nestedFields(d -> d.limit(3L))
                .nestedObjects(d -> d.limit(4L))
                .fieldNameLength(d -> d.limit(5L))
        );

        final String str = toJson(mapping);
        assertEquals(
            "{\"depth\":{\"limit\":2},\"field_name_length\":{\"limit\":5},\"nested_fields\":{\"limit\":3},\"nested_objects\":{\"limit\":4},\"total_fields\":{\"limit\":1}}",
            str
        );

        final IndexSettingsMapping deserialized = fromJson(str, IndexSettingsMapping._DESERIALIZER);
        assertEquals(mapping.totalFields().limit(), deserialized.totalFields().limit());
        assertEquals(mapping.depth().limit(), deserialized.depth().limit());
        assertEquals(mapping.nestedFields().limit(), deserialized.nestedFields().limit());
        assertEquals(mapping.nestedObjects().limit(), deserialized.nestedObjects().limit());
        assertEquals(mapping.fieldNameLength().limit(), deserialized.fieldNameLength().limit());
    }

    @Test
    public void testSmartcn_Analyzer() {
        final Analyzer analyzer = new Analyzer.Builder().smartcn(s -> s).build();

        assertTrue(analyzer.isSmartcn());

        String str = toJson(analyzer);
        assertEquals("{\"type\":\"smartcn\"}", str);

        Analyzer analyzer2 = fromJson(str, Analyzer._DESERIALIZER);
        assertTrue(analyzer2.isSmartcn());
    }

    @Test
    public void testSmartcn_Tokenizer() {
        final TokenizerDefinition tokenizerDefinition = TokenizerBuilders.definition().smartcnTokenizer(b -> b).build();

        String str = toJson(tokenizerDefinition);
        assertEquals("{\"type\":\"smartcn_tokenizer\"}", str);

        TokenizerDefinition tokenizerDefinition2 = fromJson(str, TokenizerDefinition._DESERIALIZER);
    }

    @Test
    public void testSmartcn_StopFilter() {
        final TokenFilterDefinition analyzer = new TokenFilterDefinition.Builder().smartcnStop(b -> b).build();

        String str = toJson(analyzer);
        assertEquals("{\"type\":\"smartcn_stop\"}", str);

        TokenFilterDefinition analyzer2 = fromJson(str, TokenFilterDefinition._DESERIALIZER);
    }

    @Test
    public void testCjk_Analyzer() {
        final Analyzer analyzer = new Analyzer.Builder().cjk(b -> b.stopwords(Arrays.asList("a", "b", "c")).stopwordsPath("path")).build();

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
        final FieldMapping field1 = FieldMapping.of(
            fmb -> fmb.fullName(field1Name)
                .mapping(
                    field1Name,
                    pb -> pb.text(
                        tpb -> tpb.store(true)
                            .termVector(TermVectorOption.WithPositionsOffsets)
                            .analyzer(field1Analyzer)
                            .positionIncrementGap(10)
                    )
                )
        );
        final String field3Name = "field3";
        // Build aFieldMappingResponse with several fields
        final GetFieldMappingResponse response = GetFieldMappingResponse.of(
            b -> b.putResult(
                indexName,
                TypeFieldMappings.of(
                    tfmb -> tfmb.putMappings(field1Name, field1)
                        .putMappings(
                            "field2",
                            fmb -> fmb.fullName("field2")
                                .mapping(
                                    "field2",
                                    pb -> pb.text(
                                        tpb -> tpb.store(true)
                                            .termVector(TermVectorOption.WithPositionsOffsets)
                                            .analyzer("another_analyzer")
                                            .positionIncrementGap(10)
                                    )
                                )
                        )
                        .putMappings(
                            field3Name,
                            fmb -> fmb.fullName(field3Name)
                                .mapping(
                                    field3Name,
                                    pb -> pb.text(
                                        tpb -> tpb.store(true)
                                            .termVector(TermVectorOption.WithPositionsOffsets)
                                            .analyzer("this_analyzer")
                                            .positionIncrementGap(10)
                                    )
                                )
                        )
                )
            )
        );
        String str = toJson(response);
        assertEquals(
            "{\"indexName\":{\"mappings\":{\"field1\":{\"full_name\":\"field1\",\"mapping\""
                + ":{\"field1\":{\"type\":\"text\",\"store\":true,\"analyzer\":\"my_analyzer\","
                + "\"position_increment_gap\":10,\"term_vector\":\"with_positions_offsets\"}}},"
                + "\"field3\":{\"full_name\":\"field3\",\"mapping\":{\"field3\":{\"type\":\"text\",\"store\":true,"
                + "\"analyzer\":\"this_analyzer\",\"position_increment_gap\":10,\"term_vector\":\"with_positions_offsets\"}}},"
                + "\"field2\":{\"full_name\":\"field2\",\"mapping\":{\"field2\":{\"type\":\"text\",\"store\":true,"
                + "\"analyzer\":\"another_analyzer\",\"position_increment_gap\":10,\"term_vector\":\"with_positions_offsets\"}}}}}}",
            str
        );

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
        final TermvectorsResponse response = TermvectorsResponse.of(
            b -> b.index("index")
                .id("id")
                .version(1)
                .found(true)
                .took(0)
                .termVectors("key1", tvb -> tvb.terms("term1", tb -> tb.score(0.3)))
        );

        String str = toJson(response);
        assertEquals(
            "{\"found\":true,\"_id\":\"id\",\"_index\":\"index\","
                + "\"term_vectors\":{\"key1\":{\"terms\":{\"term1\":{\"score\":0.3}}}},\"took\":0,\"_version\":1}",
            str
        );

        final TermvectorsResponse response2 = fromJson(str, TermvectorsResponse._DESERIALIZER);
        assertEquals(response.index(), response2.index());
    }

    @Test
    public void testIndexSettingsIndexing() {

        final IndexSettingsIndexing indexing = IndexSettingsIndexing.of(
            is -> is.slowlog(
                s -> s.level("info")
                    .source(0)
                    .threshold(
                        t -> t.index(
                            it -> it.debug(Time.of(ti -> ti.time("500ms")))
                                .info(Time.of(ti -> ti.time("1000ms")))
                                .trace(Time.of(ti -> ti.time("200ms")))
                                .warn(Time.of(ti -> ti.time("5000ms")))
                        )
                    )
            )
        );

        final String str = toJson(indexing);
        assertEquals(
            "{\"slowlog\":{\"level\":\"info\",\"source\":0,\"threshold\":{\"index\":{\"debug\":\"500ms\",\"info\":\"1000ms\",\"trace\":\"200ms\",\"warn\":\"5000ms\"}}}}",
            str
        );

        final IndexSettingsIndexing deserialized = fromJson(str, IndexSettingsIndexing._DESERIALIZER);
        assertEquals(indexing.slowlog().level(), deserialized.slowlog().level());
        assertEquals(indexing.slowlog().source(), deserialized.slowlog().source());
        assertEquals(indexing.slowlog().threshold().index().debug().time(), deserialized.slowlog().threshold().index().debug().time());
        assertEquals(indexing.slowlog().threshold().index().info().time(), deserialized.slowlog().threshold().index().info().time());
        assertEquals(indexing.slowlog().threshold().index().trace().time(), deserialized.slowlog().threshold().index().trace().time());
        assertEquals(indexing.slowlog().threshold().index().warn().time(), deserialized.slowlog().threshold().index().warn().time());

    }

    @Test
    public void testIndexSettingsSearch() {

        final IndexSettingsSearch search = IndexSettingsSearch.of(
            is -> is.slowlog(
                s -> s.level("info")
                    .threshold(
                        t -> t.query(
                            it -> it.debug(Time.of(ti -> ti.time("500ms")))
                                .info(Time.of(ti -> ti.time("1000ms")))
                                .trace(Time.of(ti -> ti.time("200ms")))
                                .warn(Time.of(ti -> ti.time("5000ms")))
                        )
                            .fetch(
                                it -> it.debug(Time.of(ti -> ti.time("5ms")))
                                    .info(Time.of(ti -> ti.time("10ms")))
                                    .trace(Time.of(ti -> ti.time("2ms")))
                                    .warn(Time.of(ti -> ti.time("50ms")))
                            )
                    )
            ).idle(id -> id.after(a -> a.time("5s")))
        );

        final String str = toJson(search);
        assertEquals(
            "{\"idle\":{\"after\":\"5s\"},\"slowlog\":{\"level\":\"info\",\"threshold\":{\"fetch\":{\"debug\":\"5ms\",\"info\":\"10ms\",\"trace\":\"2ms\",\"warn\":\"50ms\"},\"query\":{\"debug\":\"500ms\",\"info\":\"1000ms\",\"trace\":\"200ms\",\"warn\":\"5000ms\"}}}}",
            str
        );

        final IndexSettingsSearch deserialized = fromJson(str, IndexSettingsSearch._DESERIALIZER);
        assertEquals(search.slowlog().level(), deserialized.slowlog().level());
        assertEquals(search.slowlog().threshold().query().debug().time(), deserialized.slowlog().threshold().query().debug().time());
        assertEquals(search.slowlog().threshold().query().info().time(), deserialized.slowlog().threshold().query().info().time());
        assertEquals(search.slowlog().threshold().query().trace().time(), deserialized.slowlog().threshold().query().trace().time());
        assertEquals(search.slowlog().threshold().query().warn().time(), deserialized.slowlog().threshold().query().warn().time());
        assertEquals(search.slowlog().threshold().fetch().debug().time(), deserialized.slowlog().threshold().fetch().debug().time());
        assertEquals(search.slowlog().threshold().fetch().info().time(), deserialized.slowlog().threshold().fetch().info().time());
        assertEquals(search.slowlog().threshold().fetch().trace().time(), deserialized.slowlog().threshold().fetch().trace().time());
        assertEquals(search.slowlog().threshold().fetch().warn().time(), deserialized.slowlog().threshold().fetch().warn().time());
        assertEquals(search.idle().after().time(), deserialized.idle().after().time());

    }
}
