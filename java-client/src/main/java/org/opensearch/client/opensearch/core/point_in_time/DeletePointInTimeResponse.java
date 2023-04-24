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
public class DeletePointInTimeResponse implements JsonpSerializable {
    private final List<DeletePointInTimeRecord> pits;

    private DeletePointInTimeResponse(Builder builder) {
        this.pits = ApiTypeHelper.unmodifiableRequired(builder.pits, this, "pits");
    }
    
    public static DeletePointInTimeResponse of(Function<Builder, ObjectBuilder<DeletePointInTimeResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - Response value.
     * <p>
     * API name: {@code pits}
     */
    public final List<DeletePointInTimeRecord> pits() {
        return this.pits;
    }

    /**
     * Serialize this value to JSON.
     */
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartArray();
        for (DeletePointInTimeRecord item0 : this.pits) {
            item0.serialize(generator, mapper);

        }
        generator.writeEnd();

    }

    /**
     * Builder for {@link DeletePointInTimeResponse}.
     */

    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<DeletePointInTimeResponse> {
        private List<DeletePointInTimeRecord> pits;

        /**
         * Required - Response value.
         * <p>
         * API name: {@code pits}
         * <p>
         * Adds all elements of <code>list</code> to <code>pits</code>.
         */
        public final Builder pits(List<DeletePointInTimeRecord> list) {
            this.pits = _listAddAll(this.pits, list);
            return this;
        }

        /**
         * Required - Response value.
         * <p>
         * API name: {@code pits}
         * <p>
         * Adds one or more values to <code>pits</code>.
         */
        public final Builder pits(DeletePointInTimeRecord value, DeletePointInTimeRecord... values) {
            this.pits = _listAdd(this.pits, value, values);
            return this;
        }

        /**
         * Required - Response value.
         * <p>
         * API name: {@code pits}
         * <p>
         * Adds a value to <code>pits</code> using a builder lambda.
         */
        public final Builder pits(Function<DeletePointInTimeRecord.Builder, ObjectBuilder<DeletePointInTimeRecord>> fn) {
            return pits(fn.apply(new DeletePointInTimeRecord.Builder()).build());
        }

        /**
         * Builds a {@link DeletePointInTimeResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public DeletePointInTimeResponse build() {
            _checkSingleUse();

            return new DeletePointInTimeResponse(this);
        }
    }

    public static final JsonpDeserializer<DeletePointInTimeResponse> _DESERIALIZER = ObjectBuilderDeserializer
            .lazy(Builder::new, DeletePointInTimeResponse::createDeletePointInTimeResponseDeserializer);

    protected static void createDeletePointInTimeResponseDeserializer(
            ObjectDeserializer<DeletePointInTimeResponse.Builder> op) {

        JsonpDeserializer<List<DeletePointInTimeRecord>> valueDeserializer = JsonpDeserializer
                .arrayDeserializer(DeletePointInTimeRecord._DESERIALIZER);

        op.add(Builder::pits, valueDeserializer, "pits");
    }
}
