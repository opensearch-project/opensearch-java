/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.indices;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: indices.delete_data_stream.Request

/**
 * Deletes one or more data streams and their backing indices.
 */
public class DeleteDataStreamRequest extends RequestBase {

    private final List<String> name;

    // ---------------------------------------------------------------------------------------------

    private DeleteDataStreamRequest(Builder builder) {
        this.name = ApiTypeHelper.unmodifiableRequired(builder.name, this, "name");
    }

    public static DeleteDataStreamRequest of(Function<Builder, ObjectBuilder<DeleteDataStreamRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - Comma-separated list of data streams to delete.
     * <p>
     * API name: {@code name}
     */
    public final List<String> name() {
        return this.name;
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link DeleteDataStreamRequest}.
     */
    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<DeleteDataStreamRequest> {

        private List<String> name;

        /**
         * Required - Comma-separated list of data streams to delete.
         * <p>
         * API name: {@code name}
         * <p>
         * Adds all elements of <code>list</code> to <code>name</code>.
         */
        public final Builder name(List<String> list) {
            this.name = _listAddAll(this.name, list);
            return this;
        }

        /**
         * Required - Comma-separated list of data streams to delete.
         * <p>
         * API name: {@code name}
         * <p>
         * Adds one or more values to <code>name</code>.
         */
        public final Builder name(String value, String... values) {
            this.name = _listAdd(this.name, value, values);
            return this;
        }

        public DeleteDataStreamRequest build() {
            _checkSingleUse();

            return new DeleteDataStreamRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code indices.delete_data_stream}".
     */
    public static final Endpoint<DeleteDataStreamRequest, DeleteDataStreamResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> { return "DELETE"; },

        // Request path
        request -> {
            final int _name = 1 << 0;
            int propsSet = 0;
            propsSet |= _name;

            if (propsSet == (_name)) {
                StringBuilder sbd = new StringBuilder();
                sbd.append("/_data_stream");
                sbd.append("/");
                SimpleEndpoint.pathEncode(request.name.stream().map(v -> v).collect(Collectors.joining(",")), sbd);
                return sbd.toString();
            }
            throw SimpleEndpoint.noPathTemplateFound("path");
        },

        // Request parameters
        SimpleEndpoint.emptyMap(),

        SimpleEndpoint.emptyMap(),
        false,
        DeleteDataStreamResponse._DESERIALIZER
    );

}
