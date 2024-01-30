/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

// ----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
// ----------------------------------------------------

package org.opensearch.client.opensearch.cat;

import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.JsonpSerializable;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.opensearch.*;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import jakarta.json.stream.JsonGenerator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import javax.annotation.Nullable;

@JsonpDeserializable
public class SegmentReplicationResponse implements JsonpSerializable {

    public SegmentReplicationResponse(Builder builder) {}

    public static SegmentReplicationResponse of(
            Function<Builder, ObjectBuilder<SegmentReplicationResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {}

    /** Builder for {@link SegmentReplicationResponse}. */
    public static class Builder extends ObjectBuilderBase
            implements ObjectBuilder<SegmentReplicationResponse> {

        /**
         * Builds a {@link SegmentReplicationResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public SegmentReplicationResponse build() {
            _checkSingleUse();

            return new SegmentReplicationResponse(this);
        }
    }

    public static final JsonpDeserializer<SegmentReplicationResponse> _DESERIALIZER =
            ObjectBuilderDeserializer.lazy(
                    Builder::new,
                    SegmentReplicationResponse::setupSegmentReplicationResponseDeserializer);

    protected static void setupSegmentReplicationResponseDeserializer(
            ObjectDeserializer<SegmentReplicationResponse.Builder> op) {}
}
