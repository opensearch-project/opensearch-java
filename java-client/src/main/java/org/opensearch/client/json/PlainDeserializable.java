/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.json;

import jakarta.json.stream.JsonParser;
import java.io.InputStream;
import java.io.Reader;

/** Base interface to set JSON properties **/

public interface PlainDeserializable<B> {

    B self();

    /** Updates object with newly provided JSON properties
     @param parser the JsonParser parser
     @param mapper the JsonpMapper mapper used to deserialize values
     @return this object
     **/

    default B withJson(JsonParser parser, JsonpMapper mapper) {
        JsonpDeserializer<?> deserializer = JsonpMapperBase.findDeserializer(this.getClass().getEnclosingClass());
        @SuppressWarnings("unchecked")
        ObjectDeserializer<B> objectDeserializer = (ObjectDeserializer<B>) DelegatingDeserializer.unwrap(deserializer);
        assert objectDeserializer != null;
        return objectDeserializer.deserialize(self(), parser, mapper, parser.next());
    }

    /** Updates object with newly provided JSON properties
     @param inputStream the stream to read from
     @return this object
      * **/
    default B withJson(InputStream inputStream) {
        JsonpMapper defaultMapper = JsonpUtils.DEFAULT_JSONP_MAPPER;
        JsonParser parser = defaultMapper.jsonProvider().createParser(inputStream);
        return withJson(parser, defaultMapper);
    }

    /** Updates object with newly provided JSON properties
     @param reader the stream to read from
     @return this object
      * **/
    default B withJson(Reader reader) {
        JsonpMapper defaultMapper = JsonpUtils.DEFAULT_JSONP_MAPPER;
        JsonParser parser = defaultMapper.jsonProvider().createParser(reader);
        return withJson(parser, defaultMapper);
    }

}
