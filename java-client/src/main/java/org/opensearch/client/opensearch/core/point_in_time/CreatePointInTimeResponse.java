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
import org.opensearch.client.opensearch._types.ShardStatistics;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

import jakarta.json.stream.JsonGenerator;

// typedef: _global.create_point_in_time.Response

@JsonpDeserializable
public class CreatePointInTimeResponse implements JsonpSerializable {

    private final String pitId;

    private final ShardStatistics shards;

    private final Long creationTime;

    private CreatePointInTimeResponse(Builder builder) {
        this.pitId = ApiTypeHelper.requireNonNull(builder.pitId, this, "pitId");
        this.shards = ApiTypeHelper.requireNonNull(builder.shards, this, "shards");
        this.creationTime = ApiTypeHelper.requireNonNull(builder.creationTime, this, "creationTime");
    }

    public static CreatePointInTimeResponse of(Function<Builder, ObjectBuilder<CreatePointInTimeResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code pit_d}
     */
    public final String pitId() {
        return this.pitId;
    }

    /**
     * Required - API name: {@code _shards}
     */
    public final ShardStatistics shards() {
        return this.shards;
    }

    /**
     * Required - API name: {@code creation_time}
     */
    public final Long creationTime() {
        return this.creationTime;
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

        generator.writeKey("pit_id");
        generator.write(this.pitId);

        generator.writeKey("_shards");
        this.shards.serialize(generator, mapper);

        generator.writeKey("creation_time");
        generator.write(this.creationTime);

    }

    /**
     * builder for {@link CreatePointInTimeResponse}
     */
    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<CreatePointInTimeResponse> {
        private String pitId;

        private ShardStatistics shards;

        private Long creationTime;

        /**
         * Required - API name: {@code pit_id}
         */
        public final Builder pitId(String pitId) {
            this.pitId = pitId;
            return this;
        }

        /**
         * Required - API name: {@code _shards}
         */
        public final Builder shards(ShardStatistics value) {
            this.shards = value;
            return this;
        }

        /**
         * Required - API name: {@code _shards}
         */
        public final Builder shards(Function<ShardStatistics.Builder, ObjectBuilder<ShardStatistics>> fn) {
            return this.shards(fn.apply(new ShardStatistics.Builder()).build());
        }

        /**
         * Required - API name: {@code creation_time}
         */
        public final Builder creationTime(Long creationTime) {
            this.creationTime = creationTime;
            return this;
        }

        /**
         * Builds a {@link CreatePointInTimeResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public CreatePointInTimeResponse build() {
            _checkSingleUse();

            return new CreatePointInTimeResponse(this);
        }
    }

    /**
     * Json deserializer for {@link CreatePointInTimeResponse}
     */
    public static final JsonpDeserializer<CreatePointInTimeResponse> _DESERIALIZER = ObjectBuilderDeserializer
            .lazy(Builder::new, CreatePointInTimeResponse::setupCreatePointInTimeResponseDeserializer);

    protected static void setupCreatePointInTimeResponseDeserializer(ObjectDeserializer<CreatePointInTimeResponse.Builder> op) {

        op.add(Builder::pitId, JsonpDeserializer.stringDeserializer(), "pit_id");
        op.add(Builder::shards,
                ShardStatistics._DESERIALIZER,
                "_shards");
        op.add(Builder::creationTime, JsonpDeserializer.longDeserializer(), "creation_time");

    }
}