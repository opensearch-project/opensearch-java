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

import javax.annotation.Nullable;

import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.JsonpSerializable;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

import jakarta.json.stream.JsonGenerator;

// typedef: _global.delete_point_in_time.Request

/**
 * Deletes PITs on the OpenSearch cluster
 * 
 */
public class DeletePointInTimeRequest extends RequestBase implements JsonpSerializable {

    @Nullable
    private List<String> pitId;

    public DeletePointInTimeRequest(Builder builder) {
        this.pitId = builder.pitId;
    }

    public static DeletePointInTimeRequest of(Function<Builder, ObjectBuilder<DeletePointInTimeRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * A list of Pit IDs to be deleted
     * <p>
     * API name - {@code pit_id}
     */
    @Nullable
    public final List<String> pitId() {
        return this.pitId;
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

        if (ApiTypeHelper.isDefined(this.pitId)) {
            generator.writeKey("pit_id");
            generator.writeStartArray();
            for (String item0 : this.pitId) {
                generator.write(item0);
            }
            generator.writeEnd();

        }

    }

    /**
     * Builder for {@link DeletePointInTimeRequest}
     */
    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<DeletePointInTimeRequest> {
        private List<String> pitId;

        /**
         * A list of Pit IDs to be deleted
         * <p>
         * API name - {@code pit_id}
         */
        public final Builder pitId(@Nullable List<String> pitId) {
            this.pitId = pitId;
            return this;
        }

        /**
         * Builds a {@link DeletePointInTimeRequest}.
         * 
         * @throws NullPointerException if some of the required fields are null.
         */
        public DeletePointInTimeRequest build() {
            _checkSingleUse();
            return new DeletePointInTimeRequest(this);
        }
    }

    /**
     * Endpoint "{@code delete_point_in_time}"
     */
    public static final Endpoint<DeletePointInTimeRequest, DeletePointInTimeResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
            // Request Method
            request -> {
                return "DELETE";
            },

            // Request Path
            request -> {
                final int _all = 1 << 0;

                int propsSet = 0;

                if (request.pitId() == null) {
                    propsSet |= _all;
                }
                if (propsSet == 0) {
                    return "/_search/point_in_time";
                } else {
                    return "/_search/point_in_time/_all";
                }
            },
            SimpleEndpoint.emptyMap(), SimpleEndpoint.emptyMap(), true, DeletePointInTimeResponse._DESERIALIZER);

}
