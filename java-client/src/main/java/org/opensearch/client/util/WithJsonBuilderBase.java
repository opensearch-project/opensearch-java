/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

/*
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
 */

package org.opensearch.client.util;

import jakarta.json.stream.JsonParser;
import java.io.InputStream;
import org.opensearch.client.json.DelegatingDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.JsonpMapperBase;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.jsonb.JsonbJsonpMapper;

/** Base interface to set JSON properties **/
public interface WithJsonBuilderBase<B> {

    B get();

    /** Updates object with newly provided JSON properties
     @param parser the JsonParser parser
     @param mapper the JsonpMapper mapper used to deserialize values
     @return object
     **/
    default B withJson(JsonParser parser, JsonpMapper mapper) {
        var deserializer = JsonpMapperBase.findDeserializer(getClass().getEnclosingClass());
        @SuppressWarnings("unchecked")
        ObjectDeserializer<B> objectDeserializer = (ObjectDeserializer<B>) DelegatingDeserializer.unwrap(deserializer);
        assert objectDeserializer != null;
        return objectDeserializer.deserialize(get(), parser, mapper, parser.next());
    }

    /** Updates object with newly provided JSON properties
     @param inputStream the stream to read from
     @return this object
     * **/
    default B withJson(InputStream inputStream) {
        JsonbJsonpMapper mapper = new JsonbJsonpMapper();
        JsonParser parser = mapper.jsonProvider().createParser(inputStream);
        return withJson(parser, mapper);
    }

}
