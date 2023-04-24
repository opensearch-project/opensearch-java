/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.core.point_in_time;

import java.util.List;
import java.util.function.Function;

import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.JsonpSerializable;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

import jakarta.json.stream.JsonGenerator;

@JsonpDeserializable
public class ListAllPointInTimeResponse implements JsonpSerializable {
    private final List<PointInTimeRecord> pits;

    private ListAllPointInTimeResponse(Builder builder) {
        this.pits = ApiTypeHelper.unmodifiableRequired(builder.pits, this, "pits");
    }
    
    public static ListAllPointInTimeResponse of(Function<Builder, ObjectBuilder<ListAllPointInTimeResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - Response value.
     * <p>
     * API name: {@code _value_body}
     */
    public final List<PointInTimeRecord> pits() {
        return this.pits;
    }

    /**
     * Serialize this value to JSON.
     */
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartArray();
        for (PointInTimeRecord item0 : this.pits) {
            item0.serialize(generator, mapper);

        }
        generator.writeEnd();

    }

    /**
     * Builder for {@link ListAllPointInTimeResponse}.
     */

    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<ListAllPointInTimeResponse> {
        private List<PointInTimeRecord> pits;

        /**
         * Required - Response value.
         * <p>
         * API name: {@code _value_body}
         * <p>
         * Adds all elements of <code>list</code> to <code>pits</code>.
         */
        public final Builder pits(List<PointInTimeRecord> list) {
            this.pits = _listAddAll(this.pits, list);
            return this;
        }

        /**
         * Required - Response value.
         * <p>
         * API name: {@code _value_body}
         * <p>
         * Adds one or more values to <code>pits</code>.
         */
        public final Builder pits(PointInTimeRecord value, PointInTimeRecord... values) {
            this.pits = _listAdd(this.pits, value, values);
            return this;
        }

        /**
         * Required - Response value.
         * <p>
         * API name: {@code _value_body}
         * <p>
         * Adds a value to <code>pits</code> using a builder lambda.
         */
        public final Builder pits(Function<PointInTimeRecord.Builder, ObjectBuilder<PointInTimeRecord>> fn) {
            return pits(fn.apply(new PointInTimeRecord.Builder()).build());
        }

        /**
         * Builds a {@link ListAllPointInTimeResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public ListAllPointInTimeResponse build() {
            _checkSingleUse();

            return new ListAllPointInTimeResponse(this);
        }
    }

    public static final JsonpDeserializer<ListAllPointInTimeResponse> _DESERIALIZER = ObjectBuilderDeserializer
            .lazy(Builder::new, ListAllPointInTimeResponse::createListAllPointInTimeResponseDeserializer);

    protected static  void createListAllPointInTimeResponseDeserializer(
            ObjectDeserializer<ListAllPointInTimeResponse.Builder> op) {

        JsonpDeserializer<List<PointInTimeRecord>> valueDeserializer = JsonpDeserializer
                .arrayDeserializer(PointInTimeRecord._DESERIALIZER);
                
        op.add(Builder::pits, valueDeserializer, "pits");
    }
}
