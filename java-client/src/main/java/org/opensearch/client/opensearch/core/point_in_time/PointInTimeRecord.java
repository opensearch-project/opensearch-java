/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.core.point_in_time;

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

// typedef: _global.point_in_time.PointInTimeRecord
@JsonpDeserializable
public class PointInTimeRecord implements JsonpSerializable {

    private final String pitId;

    private final Long creationTime;

    private final Long keepAlive;

    private PointInTimeRecord(Builder builder) {
        this.pitId = builder.pitId;
        this.creationTime = builder.creationTime;
        this.keepAlive = builder.keepAlive;
    }

    public static PointInTimeRecord of(Function<Builder, ObjectBuilder<PointInTimeRecord>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code pit_id}
     */
    public final String pitId() {
        return this.pitId;
    }

    /**
     * API name: {@code creation_time}
     */
    public final Long creationTime() {
        return this.creationTime;
    }

    /**
     * API name: {@code keep_alive}
     */
    public final Long keepAlive() {
        return this.keepAlive;
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
        if (this.creationTime != null) {
            generator.writeKey("creation_time");
            generator.write(this.creationTime);

        }
        if (this.keepAlive != null) {
            generator.writeKey("keep_alive");
            generator.write(this.keepAlive);

        }
    }

    /**
     * Builder for {@link PointInTimeRecord}.
     */
    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<PointInTimeRecord> {
        private String pitId;

        private Long creationTime;

        private Long keepAlive;

        /**
         * API name: {@code pit_id}
         */
        public final Builder pitId(String pitId) {
            this.pitId = pitId;
            return this;
        }

        /**
         * API name: {@code creation_time}
         */
        public final Builder creationTime(Long creationTime) {
            this.creationTime = creationTime;
            return this;
        }

        /**
         * API name: {@code keep_alive}
         */
        public final Builder keepAlive(Long keepAlive) {
            this.keepAlive = keepAlive;
            return this;
        }

        /**
         * Builds a {@link PointInTimeRecord}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public PointInTimeRecord build() {
            _checkSingleUse();

            return new PointInTimeRecord(this);
        }
    }

    /**
     * Json deserializer for {@link PointInTimeRecord}
     */
    public static final JsonpDeserializer<PointInTimeRecord> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
            Builder::new,
            PointInTimeRecord::setupPointInTimeRecordDeserializer);

    protected static void setupPointInTimeRecordDeserializer(
            ObjectDeserializer<PointInTimeRecord.Builder> op) {

        op.add(Builder::pitId, JsonpDeserializer.stringDeserializer(), "pit_id");
        op.add(Builder::creationTime, JsonpDeserializer.longDeserializer(), "creation_time");
        op.add(Builder::keepAlive, JsonpDeserializer.longDeserializer(), "keep_alive");

    }
}
