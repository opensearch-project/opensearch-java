/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.json;

import jakarta.json.stream.JsonGenerator;
import java.io.IOException;
import java.io.StringWriter;
import java.io.UncheckedIOException;

public interface PlainJsonSerializable extends JsonpSerializable {

    /**
     * A default method which returns string representation for the instances of classes
     * implementing JsonpSerializable interface.<br>
     * Usage : Eg for SearchRequest.class<pre>{@code SearchRequest implements PlainJsonSerializable{..}
     * SearchRequest searchRequest = SearchRequest.of(request -> request...);
     * String searchRequestString = searchRequest.writeValueAsString();}</pre>  <br>
     *
     */
    default String toJsonString() {
        try (StringWriter writer = new StringWriter()) {
            try (JsonGenerator generator = JsonpUtils.DEFAULT_PROVIDER.createGenerator(writer)) {
                serialize(generator, JsonpUtils.DEFAULT_JSONP_MAPPER);
            }
            return writer.toString();
        } catch (IOException ex) {
            throw new UncheckedIOException(ex);
        }
    }

}
