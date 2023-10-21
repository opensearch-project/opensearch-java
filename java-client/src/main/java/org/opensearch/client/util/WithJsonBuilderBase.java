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


package org.opensearch.client.util;

import jakarta.json.stream.JsonParser;
import org.opensearch.client.json.DelegatingDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.JsonpMapperBase;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.jsonb.JsonbJsonpMapper;

import java.io.InputStream;


/** Base interface to set JSON properties **/
public interface WithJsonBuilderBase<B> {

    abstract B get();

    /** Updates object with newly provided JSON properties
     @param parser the JsonParser parser
     @param mapper the JsonpMapper mapper used to deserialize values
     @return object
     **/
    default B withJson(JsonParser parser, JsonpMapper mapper){
        var deserializer = JsonpMapperBase.findDeserializer(getClass().getEnclosingClass());
        @SuppressWarnings("unchecked")
        ObjectDeserializer<B> objectDeserializer = (ObjectDeserializer<B>) DelegatingDeserializer.unwrap(deserializer);
        assert objectDeserializer != null;
        return objectDeserializer.deserialize(get(),parser,mapper,parser.next());
    }

    /** Updates object with newly provided JSON properties
     @param inputStream the stream to read from
     @return this object
     * **/
    default B withJson(InputStream inputStream){
        JsonbJsonpMapper mapper = new JsonbJsonpMapper();
        JsonParser parser = mapper.jsonProvider().createParser(inputStream);
        return withJson(parser,mapper);
    }

}
