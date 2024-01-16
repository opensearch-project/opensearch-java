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

import jakarta.json.stream.JsonParser;
import java.io.StringReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.jsonb.JsonbJsonpMapper;
import org.opensearch.client.opensearch.indices.IndexSettings;

public class AnalyzerKindTest extends Assert {

    /**
     *  Test if we can deserialize the language analyzers
     *  it uses reflection to avoid having to duplicate tests for all 34 currently supported languages
     *
     * @throws NoSuchMethodException if the specified method is not found through reflection
     * @throws InvocationTargetException if an exception occurs during method invocation through reflection
     * @throws IllegalAccessException if access to the method is denied through reflection
     * @throws ClassNotFoundException if a required class cannot be found
     * @throws NullPointerException if a method argument is unexpectedly null
     */
    @Test
    public void testParsingAnalyzersForLanguages() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException,
        ClassNotFoundException, NullPointerException {
        JsonpMapper mapper = new JsonbJsonpMapper();

        for (Analyzer.Kind theKind : onlyLanguageAnalyzers) {
            String type = theKind.jsonValue();
            String typeCapitalized = type.substring(0, 1).toUpperCase() + type.substring(1);
            String json = String.format(
                "{ \"index\": { \"analysis\": { \"analyzer\": { \"some_analyzer\": { \"type\": \"%s\","
                    + " \"char_filter\": [ \"html_strip\" ], \"tokenizer\": \"standard\" } } } } } ",
                type
            );

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

    private final List<Analyzer.Kind> onlyLanguageAnalyzers = List.of(
        Analyzer.Kind.Arabic,
        Analyzer.Kind.Armenian,
        Analyzer.Kind.Basque,
        Analyzer.Kind.Bengali,
        Analyzer.Kind.Brazilian,
        Analyzer.Kind.Bulgarian,
        Analyzer.Kind.Catalan,
        Analyzer.Kind.Czech,
        Analyzer.Kind.Danish,
        Analyzer.Kind.Dutch,
        Analyzer.Kind.English,
        Analyzer.Kind.Estonian,
        Analyzer.Kind.Finnish,
        Analyzer.Kind.French,
        Analyzer.Kind.Galician,
        Analyzer.Kind.German,
        Analyzer.Kind.Greek,
        Analyzer.Kind.Hindi,
        Analyzer.Kind.Hungarian,
        Analyzer.Kind.Indonesian,
        Analyzer.Kind.Irish,
        Analyzer.Kind.Italian,
        Analyzer.Kind.Latvian,
        Analyzer.Kind.Lithuanian,
        Analyzer.Kind.Norwegian,
        Analyzer.Kind.Persian,
        Analyzer.Kind.Portuguese,
        Analyzer.Kind.Romanian,
        Analyzer.Kind.Russian,
        Analyzer.Kind.Sorani,
        Analyzer.Kind.Spanish,
        Analyzer.Kind.Swedish,
        Analyzer.Kind.Turkish,
        Analyzer.Kind.Thai
    );

}
