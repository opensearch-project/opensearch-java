/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.core.search;

import java.util.function.Function;

import javax.annotation.Nullable;

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
public class PointInTime implements JsonpSerializable {
    private final String id;

    @Nullable
    private final String keepAlive;

    private PointInTime(Builder builder) {
        this.id = ApiTypeHelper.requireNonNull(builder.id, this, "id");
        this.keepAlive = builder.keepAlive;
    }

    public static PointInTime of(Function<Builder, ObjectBuilder<PointInTime>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code id}
     */
    public final String id() {
        return this.id;
    }

    /**
     * API name: {@code keep_alive}
     */
    @Nullable
    public final String keepAlive() {
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
        generator.writeKey("id");
        generator.write(this.id);

        if (this.keepAlive != null) {
            generator.writeKey("keep_alive");
            generator.write(this.keepAlive);
        }
    }

    /**
     * Builder for {@link PointInTime}.
     */
    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<PointInTime> {

        private String id;

        @Nullable
        private String keepAlive;

        /**
         * Required - API name: {@code id}
         */
        public final Builder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * API name: {@code keep_alive}
         */
        public final Builder keepAlive(@Nullable String keepAlive) {
            this.keepAlive = keepAlive;
            return this;
        }

        /**
         * Builds a {@link PointInTime}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public PointInTime build() {
            _checkSingleUse();

            return new PointInTime(this);
        }
    }

    /**
     * Json deserializer for {@link PointInTime}
     */
    public static final JsonpDeserializer<PointInTime> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new,
            PointInTime::setupPointInTimeDeserializer);

    protected static void setupPointInTimeDeserializer(ObjectDeserializer<PointInTime.Builder> op) {

        op.add(Builder::id, JsonpDeserializer.stringDeserializer(), "id");
        op.add(Builder::keepAlive, JsonpDeserializer.stringDeserializer(), "keep_alive");
    }

}
