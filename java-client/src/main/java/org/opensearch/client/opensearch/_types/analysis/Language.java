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

import org.opensearch.client.json.JsonEnum;
import org.opensearch.client.json.JsonpDeserializable;

import java.util.Arrays;

@JsonpDeserializable
public enum Language implements JsonEnum {
    Arabic("arabic"),

    Armenian("armenian"),

    Basque("basque"),

    Brazilian("brazilian"),

    Bulgarian("bulgarian"),

    Catalan("catalan"),

    Chinese("chinese"),

    Cjk("cjk"),

    Czech("czech"),

    Danish("danish"),

    Dutch("dutch"),

    English("english"),

    Estonian("estonian"),

    Finnish("finnish"),

    French("french"),

    Galician("galician"),

    German("german"),

    Greek("greek"),

    Hindi("hindi"),

    Hungarian("hungarian"),

    Indonesian("indonesian"),

    Irish("irish"),

    Italian("italian"),

    Latvian("latvian"),

    Norwegian("norwegian"),

    Persian("persian"),

    Portuguese("portuguese"),

    Romanian("romanian"),

    Russian("russian"),

    Sorani("sorani"),

    Spanish("spanish"),

    Swedish("swedish"),

    Turkish("turkish"),

    Thai("thai"),
    ;

    private final String jsonValue;

    Language(String jsonValue) {
        this.jsonValue = jsonValue;
    }

    public String jsonValue() {
        return this.jsonValue;
    }

    public static final JsonEnum.Deserializer<Language> _DESERIALIZER = new JsonEnum.Deserializer<>(Language.values());
}
