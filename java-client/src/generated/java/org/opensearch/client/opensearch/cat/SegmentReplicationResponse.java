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

// ----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
// ----------------------------------------------------

package org.opensearch.client.opensearch.cat;

import jakarta.json.stream.JsonGenerator;
import java.util.List;
import java.util.function.Function;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.JsonpSerializable;
import org.opensearch.client.opensearch.CatSegmentReplicationRecord;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

@JsonpDeserializable
public class SegmentReplicationResponse implements JsonpSerializable {

    private final List<CatSegmentReplicationRecord> valueBody;

    private SegmentReplicationResponse(Builder builder) {
        this.valueBody = ApiTypeHelper.unmodifiableRequired(builder.valueBody, this, "valueBody");
    }

    public static SegmentReplicationResponse of(
            Function<SegmentReplicationResponse.Builder, ObjectBuilder<SegmentReplicationResponse>>
                    fn) {
        return fn.apply(new Builder()).build();
    }
    /**
     * Response value
     *
     * <p>API name: {@code _value_body}
     */
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
        @Nullable private List<CatSegmentReplicationRecord> valueBody;

        /**
         * Response value
         *
         * <p>API name: {@code _value_body}
         *
         * <p>Adds all elements of <code>list</code> to <code>valueBody</code>.
         */
        public final Builder valueBody(List<CatSegmentReplicationRecord> list) {
            this.valueBody = _listAddAll(this.valueBody, list);
            return this;
        }

        /**
         * Response value
         *
         * <p>API name: {@code _value_body}
         *
         * <p>Adds one or more values to <code>valueBody</code>.
         */
        public final Builder valueBody(
                CatSegmentReplicationRecord value, CatSegmentReplicationRecord... values) {
            this.valueBody = _listAdd(this.valueBody, value, values);
            return this;
        }

        /**
         * Response value
         *
         * <p>API name: {@code _value_body}
         */
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
