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

package org.opensearch.client.opensearch._types.analysis;

import jakarta.json.stream.JsonGenerator;
import jakarta.json.stream.JsonParser;
import org.junit.Assert;
import org.junit.Test;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.JsonpSerializable;
import org.opensearch.client.json.jsonb.JsonbJsonpMapper;
import org.opensearch.client.opensearch.cluster.stats.CharFilterTypes;
import org.opensearch.client.opensearch.indices.IndexSettings;
import org.opensearch.client.opensearch.indices.IndexSettingsAnalysis;
import org.opensearch.core.index.Index;

import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalyzerKindTest extends Assert {

    /**
     * Test if we can deserialize the language analyzers
     * it uses reflection to avoid having to duplicate tests for all 34 currently supported languages
     *
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     */
    @Test
    public void testParsingAnalyzersForLanguages() throws NoSuchMethodException, InvocationTargetException,
            IllegalAccessException, ClassNotFoundException, NullPointerException {
        JsonpMapper mapper = new JsonbJsonpMapper();

        for (Analyzer.Kind theKind : onlyLanguageAnalyzers) {
            String type = theKind.jsonValue();
            String typeCapitalized = type.substring(0, 1).toUpperCase() + type.substring(1);
            String json = String.format("{ \"index\": { \"analysis\": { \"analyzer\": { \"some_analyzer\": { \"type\": \"%s\"," +
                    " \"char_filter\": [ \"html_strip\" ], \"tokenizer\": \"standard\" } } } } } ", type);

            JsonParser parser = mapper.jsonProvider().createParser(new StringReader(json));
            IndexSettings indexSettings = IndexSettings._DESERIALIZER.deserialize(parser, mapper);
            Analyzer someAnalyzer = indexSettings.index().analysis().analyzer().get("some_analyzer");

            // Use reflection to generically check analyzer type
            Method isMethod = someAnalyzer.getClass().getMethod("is" + typeCapitalized);
            assertTrue((boolean) isMethod.invoke(someAnalyzer));


            String analyzerClassName = typeCapitalized + "Analyzer";

            // Use reflection to generically check analyzer class
            Method getAnalyzerMethod = someAnalyzer.getClass().getMethod(type);
            Object analyzerInstance = getAnalyzerMethod.invoke(someAnalyzer);
            Package pk = analyzerInstance.getClass().getPackage();
            assertEquals(analyzerInstance.getClass(), Class.forName(pk.getName() + "." + analyzerClassName));
        }
    }

    @Test
    public void testParsingAnalyzer() {

        JsonpMapper mapper = new JsonbJsonpMapper();
        String json = "{ \"index\": { \"analysis\": { \"analyzer\": { \"some_analyzer\": { \"type\": \"english\", \"char_filter\": [ \"html_strip\" ], \"tokenizer\": \"standard\" } } } } } ";

        JsonParser parser = mapper.jsonProvider().createParser(new StringReader(json));
        IndexSettings indexSettings = IndexSettings._DESERIALIZER.deserialize(parser, mapper);
        System.out.println(toJson(indexSettings));
        assertTrue(true);
    }



//    @Test
//    public void testAnParsingAnalyzer3() {
//        Map<String, Analyzer> map2 = new HashMap<>();
//        map2.put("some_analyzer", DutchAnalyzer.of(en -> en)._toAnalyzer());
//        Map<String, Analyzer> map = new HashMap<>();
//        map.put("some_analyzersss", DutchAnalyzer.of(en -> en)._toAnalyzer());
//        IndexSettingsAnalysis settings = IndexSettingsAnalysis.of(
//                a ->
//
//                a. charFilter("htm",CharFilter.of(c->c.name("html_strip")))
//        );
//
//        System.out.println(toJson(settings));
//    }

    @Test
    public void testParsingAnalyzer2() {

        JsonpMapper mapper = new JsonbJsonpMapper();
        String json = "{ \"index\": { \"analysis\": { \"analyzer\": { \"some_analyzer\": { \"type\": \"english\", \"version\": \"2\", \"char_filter\": [ \"html_strip\" ], \"tokenizer\": \"standard\" } } } } } ";

        JsonParser parser = mapper.jsonProvider().createParser(new StringReader(json));
        IndexSettings indexSettings = IndexSettings._DESERIALIZER.deserialize(parser, mapper);
        System.out.println(toJson(indexSettings));
        assertTrue(true);
    }
    @Test
    public void testLanguage() {
        Map<String, Analyzer> map = new HashMap<>();
        map.put("some_analyzer",
                LanguageAnalyzer.of(
                                l -> l.language(Language.German).
                                        stemExclusion(new ArrayList<>())
                        )
                        ._toAnalyzer());
        IndexSettings settings = IndexSettings.of(
                it -> it.analysis(a ->
                        a.analyzer(map)

                )
        );

        System.out.println(toJson(settings));
    }

    @Test
    public void testParsingLanguageANother() {

        JsonpMapper mapper = new JsonbJsonpMapper();
        String json = "{ \"index\": {\"analysis\":{\"analyzer\":{\"some_analyzer\":{\"type\":\"language\",\"language\":\"German\",\"stem_exclusion\":[]}}}} } ";

        JsonParser parser = mapper.jsonProvider().createParser(new StringReader(json));
        IndexSettings indexSettings = IndexSettings._DESERIALIZER.deserialize(parser, mapper);
        System.out.println(toJson(indexSettings));
        assertTrue(true);
    }

//    @Test
//    public void testParsingAnalyzer3() {
//        Map<String, Analyzer> map = new HashMap<>();
//        map.put("english_analyzer", DutchAnalyzer.of(en -> en)._toAnalyzer());
//        IndexSettings settings = IndexSettings.of(
//                it -> it.analysis(a ->
//                        a.analyzer(map))
//        );
//
//        System.out.println(toJson(settings));
//    }

    @Test
    public void testPassingLanguageAnalyzer() {
        String[] v= new String[]{"", ""};
        CharFilterDefinition fd2= CharFilterDefinitionBuilders.htmlStrip().build()._toCharFilterDefinition();
//        CharFilterDefinition fd= CharFilterDefinition. of(v -> v.htmlStrip(
//                        HtmlStripCharFilter.of(h->h.self())
//                ));
        Map<String, Analyzer> map = new HashMap<>();
        map.put("some_analyzer",

                LanguageAnalyzer.of(l -> l.language(Language.German).
                                stemExclusion(new ArrayList<>()))
                        ._toAnalyzer());
        IndexSettingsAnalysis settings = IndexSettingsAnalysis.of(
                        anl -> anl
                                .analyzer(map)
                                .charFilter("kkk",CharFilter.of(a->a.name("html")))
//                                .charFilter("aaaa",CharFilter.of(i->i.definition(CharFilterDefinitionBuilders.htmlStrip().build()._toCharFilterDefinition())))
                            //    .charFilter("some_char_filter", CharFilter.of(c -> c.name("html_strip")))
        );

        System.out.println(toJson(settings));
    }

    private String toJson(JsonpSerializable obj) {
        JsonpMapper mapper = new JsonbJsonpMapper();
        StringWriter stringWriter = new StringWriter();
        try (JsonGenerator generator = mapper.jsonProvider().createGenerator(stringWriter)) {
            mapper.serialize(obj, generator);
        }
        return stringWriter.toString();
    }

    private final List<Analyzer.Kind> onlyLanguageAnalyzers = List.of(

    );

    @Test
    public void testPassingLanguageAnalyzerss() {
        Map<String, Analyzer> map = new HashMap<>();
        map.put("some_analyzer",

                LanguageAnalyzer.of(l -> l.language(Language.German).
                                stemExclusion(new ArrayList<>()))
                        ._toAnalyzer());
        IndexSettingsAnalysis settings = IndexSettingsAnalysis.of(
                anl -> anl
                        .analyzer(map)
        );

        System.out.println(toJson(settings));
    }
}

