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
import org.opensearch.client.opensearch.*;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import jakarta.json.stream.JsonGenerator;
import java.util.List;
import java.util.function.Function;

@JsonpDeserializable
public class SegmentReplicationResponse implements JsonpSerializable {

    private final List<CatSegmentReplicationRecord> valueBody;

    public SegmentReplicationResponse(Builder builder) {
        this.valueBody = ApiTypeHelper.unmodifiableRequired(builder.valueBody, this, "valueBody");
    }

    public static SegmentReplicationResponse of(
            Function<Builder, ObjectBuilder<SegmentReplicationResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    public final List<CatSegmentReplicationRecord> valueBody() {
        return this.valueBody;
    }

    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartArray();
        for (CatSegmentReplicationRecord item0 : this.valueBody) {
            item0.serialize(generator, mapper);
        }
        generator.writeEnd();
    }

    /** Builder for {@link SegmentReplicationResponse}. */
    public static class Builder extends ObjectBuilderBase
            implements ObjectBuilder<SegmentReplicationResponse> {
        private List<CatSegmentReplicationRecord> valueBody;

        public final Builder valueBody(List<CatSegmentReplicationRecord> list) {
            this.valueBody = _listAddAll(this.valueBody, list);
            return this;
        }

        public final Builder valueBody(
                CatSegmentReplicationRecord value, CatSegmentReplicationRecord... values) {
            this.valueBody = _listAdd(this.valueBody, value, values);
            return this;
        }

        public final Builder valueBody(
                Function<
                                CatSegmentReplicationRecord.Builder,
                                ObjectBuilder<CatSegmentReplicationRecord>>
                        fn) {
            return valueBody(fn.apply(new CatSegmentReplicationRecord.Builder()).build());
        }

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
            createSegmentReplicationResponseDeserializer();

    protected static JsonpDeserializer<SegmentReplicationResponse>
            createSegmentReplicationResponseDeserializer() {
        JsonpDeserializer<List<CatSegmentReplicationRecord>> valueDeserializer =
                JsonpDeserializer.arrayDeserializer(CatSegmentReplicationRecord._DESERIALIZER);

        return JsonpDeserializer.of(
                valueDeserializer.acceptedEvents(),
                (parser, mapper) ->
                        new Builder()
                                .valueBody(valueDeserializer.deserialize(parser, mapper))
                                .build());
    }
}
