/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.core.pit;

import java.util.function.Function;

import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.JsonpSerializable;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

import jakarta.json.stream.JsonGenerator;

@JsonpDeserializable
public class DeletePointInTimeRecord implements JsonpSerializable {

    private final String pitId;

    private final Boolean successful;

    private DeletePointInTimeRecord(Builder builder) {
        this.pitId = builder.pitId;
        this.successful = builder.successful;
    }

    public static DeletePointInTimeRecord of(Function<Builder, ObjectBuilder<DeletePointInTimeRecord>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code pit_id}
     */
    public final String pitId() {
        return this.pitId;
    }

    /**
     * API name: {@code successful}
     */
    public final Boolean successful() {
        return this.successful;
    }

    /**
     * Serialize this object to JSON.
     */
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {

        if (this.pitId != null) {
            generator.writeKey("pit_id");
            generator.write(this.pitId);

        }
        if (this.successful != null) {
            generator.writeKey("successful");
            generator.write(this.successful);

        }
    }

    /**
     * Builder for {@link DeletePointInTimeRecord}.
     */
    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<DeletePointInTimeRecord> {
        private String pitId;

        private Boolean successful;

        /**
         * API name: {@code pit_id}
         */
        public final Builder pitId(String pitId) {
            this.pitId = pitId;
            return this;
        }

        /**
         * API name: {@code successful}
         */
        public final Builder successful(Boolean successful) {
            this.successful = successful;
            return this;
        }

        /**
         * Builds a {@link DeletePointInTimeRecord}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public DeletePointInTimeRecord build() {
            _checkSingleUse();

            return new DeletePointInTimeRecord(this);
        }
    }

    /**
     * Json deserializer for {@link DeletePointInTimeRecord}
     */
    public static final JsonpDeserializer<DeletePointInTimeRecord> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
            Builder::new,
            DeletePointInTimeRecord::setupDeletePointInTimeRecordDeserializer);

    protected static void setupDeletePointInTimeRecordDeserializer(
            ObjectDeserializer<DeletePointInTimeRecord.Builder> op) {

        op.add(Builder::pitId, JsonpDeserializer.stringDeserializer(), "pit_id");
        op.add(Builder::successful, JsonpDeserializer.booleanDeserializer(), "successful");

    }
}
