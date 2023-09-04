/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.indices;

import jakarta.json.stream.JsonGenerator;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.JsonpSerializable;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

import javax.annotation.Nullable;
import java.util.function.Function;


@JsonpDeserializable
public class Translog implements JsonpSerializable {

    @Nullable
    private final String durability;

    @Nullable
    private final String flushThresholdSize;

    @Nullable
    private final Time syncInterval;

    private Translog(Builder builder) {

        this.durability = builder.durability;
        this.flushThresholdSize = builder.flushThresholdSize;
        this.syncInterval = builder.syncInterval;

    }

    public static Translog of(Function<Builder, ObjectBuilder<Translog>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code durability}
     */
    @Nullable
    public final String durability() {
        return this.durability;
    }

    /**
     * API name: {@code flush_threshold_size}
     */
    @Nullable
    public final String flushThresholdSize() {
        return this.flushThresholdSize;
    }

    /**
     * API name: {@code sync_interval}
     */
    @Nullable
    public final Time syncInterval() {
        return this.syncInterval;
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

        if (this.durability != null) {
            generator.writeKey("durability");
            generator.write(this.durability);

        }
        if (this.flushThresholdSize != null) {
            generator.writeKey("flush_threshold_size");
            generator.write(this.flushThresholdSize);

        }
        if (this.syncInterval != null) {
            generator.writeKey("sync_interval");
            this.syncInterval.serialize(generator, mapper);

        }

    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link Translog}.
     */
    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<Translog> {

        @Nullable
        private String durability;

        @Nullable
        private String flushThresholdSize;

        @Nullable
        private Time syncInterval;

        /**
         * API name: {@code durability}
         */
        public final Translog.Builder durability(@Nullable String value) {
            this.durability = value;
            return this;
        }

        /**
         * API name: {@code flush_threshold_size}
         */
        public final Translog.Builder flushThresholdSize(@Nullable String value) {
            this.flushThresholdSize = value;
            return this;
        }

        /**
         * API name: {@code sync_interval}
         */
        public final Translog.Builder syncInterval(@Nullable Time value) {
            this.syncInterval = value;
            return this;
        }

        /**
         * Builds a {@link Translog}.
         *
         * @throws NullPointerException
         *             if some of the required fields are null.
         */
        public Translog build() {
            _checkSingleUse();

            return new Translog(this);
        }
    }

    /**
     * Json deserializer for {@link Translog}
     */
    public static final JsonpDeserializer<Translog> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new,
            Translog::setupTranslogDeserializer);

    protected static void setupTranslogDeserializer(ObjectDeserializer<Translog.Builder> op) {

        op.add(Translog.Builder::durability, JsonpDeserializer.stringDeserializer(), "durability");
        op.add(Translog.Builder::flushThresholdSize, JsonpDeserializer.stringDeserializer(), "flush_threshold_size");
        op.add(Translog.Builder::syncInterval, Time._DESERIALIZER, "sync_interval");

    }

}
