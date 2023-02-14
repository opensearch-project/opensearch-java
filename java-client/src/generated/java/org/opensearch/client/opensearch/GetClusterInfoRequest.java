package org.opensearch.client.opensearch;

import org.opensearch.client.opensearch._types.*;
import org.opensearch.client.transport.*;
import org.opensearch.client.transport.endpoints.*;
import org.opensearch.client.util.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.*;
import javax.annotation.*;

/** Returns whether the cluster is running. */
public class GetClusterInfoRequest extends RequestBase {

    public GetClusterInfoRequest(Builder builder) {}

    public static GetClusterInfoRequest of(
            Function<Builder, ObjectBuilder<GetClusterInfoRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /** Builder for {@link GetClusterInfoRequest}. */
    public static class Builder extends ObjectBuilderBase
            implements ObjectBuilder<GetClusterInfoRequest> {

        /**
         * Builds a {@link GetClusterInfoRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public GetClusterInfoRequest build() {
            _checkSingleUse();

            return new GetClusterInfoRequest(this);
        }
    }

    public static final Endpoint<GetClusterInfoRequest, GetClusterInfoResponse, ErrorResponse>
            _ENDPOINT =
                    new SimpleEndpoint<>(
                            // Request method
                            request -> {
                                return "get";
                            },
                            // Request path
                            request -> {
                                return "/";
                            },
                            // Request parameters
                            request -> {
                                Map<String, String> params = new HashMap<>();
                                return params;
                            },
                            SimpleEndpoint.emptyMap(),
                            false,
                            GetClusterInfoResponse._DESERIALIZER);
}
