package org.opensearch.client.opensearch;

import org.opensearch.client.opensearch._types.*;

import org.opensearch.client.transport.*;
import org.opensearch.client.transport.endpoints.*;
import org.opensearch.client.util.*;

import java.util.*;
import java.util.function.Function;
import javax.annotation.*;

/** Returns a document */
public class GetDocumentDocRequest extends RequestBase {
    private final String source;
    private final String sourceExcludes;
    private final String sourceIncludes;
    private final String preference;
    private final boolean realtime;
    private final boolean refresh;
    private final String routing;
    private final boolean storedFields;
    private final int version;
    private final VersionType versionType;

    public GetDocumentDocRequest(Builder builder) {
        this.source = builder.source;
        this.sourceExcludes = builder.sourceExcludes;
        this.sourceIncludes = builder.sourceIncludes;
        this.preference = builder.preference;
        this.realtime = builder.realtime;
        this.refresh = builder.refresh;
        this.routing = builder.routing;
        this.storedFields = builder.storedFields;
        this.version = builder.version;
        this.versionType = builder.versionType;
    }

    public static GetDocumentDocRequest of(
            Function<Builder, ObjectBuilder<GetDocumentDocRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    public final String source() {
        return this.source;
    }

    public final String sourceExcludes() {
        return this.sourceExcludes;
    }

    public final String sourceIncludes() {
        return this.sourceIncludes;
    }

    public final String preference() {
        return this.preference;
    }

    public final boolean realtime() {
        return this.realtime;
    }

    public final boolean refresh() {
        return this.refresh;
    }

    public final String routing() {
        return this.routing;
    }

    public final boolean storedFields() {
        return this.storedFields;
    }

    public final int version() {
        return this.version;
    }

    public final VersionType versionType() {
        return this.versionType;
    }

    /** Builder for {@link GetDocumentDocRequest}. */
    public static class Builder extends ObjectBuilderBase
            implements ObjectBuilder<GetDocumentDocRequest> {
        private String source;
        private String sourceExcludes;
        private String sourceIncludes;
        private String preference;
        private boolean realtime;
        private boolean refresh;
        private String routing;
        private boolean storedFields;
        private int version;
        private VersionType versionType;

        public final Builder source(String value) {
            this.source = value;
            return this;
        }

        public final Builder sourceExcludes(String value) {
            this.sourceExcludes = value;
            return this;
        }

        public final Builder sourceIncludes(String value) {
            this.sourceIncludes = value;
            return this;
        }

        public final Builder preference(String value) {
            this.preference = value;
            return this;
        }

        public final Builder realtime(boolean value) {
            this.realtime = value;
            return this;
        }

        public final Builder refresh(boolean value) {
            this.refresh = value;
            return this;
        }

        public final Builder routing(String value) {
            this.routing = value;
            return this;
        }

        public final Builder storedFields(boolean value) {
            this.storedFields = value;
            return this;
        }

        public final Builder version(int value) {
            this.version = value;
            return this;
        }

        public final Builder versionType(VersionType value) {
            this.versionType = value;
            return this;
        }

        public final Builder versionType(
                Function<VersionType.Builder, ObjectBuilder<VersionType>> fn) {
            return versionType(fn.apply(new VersionType.Builder()).build());
        }

        /**
         * Builds a {@link GetDocumentDocRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public GetDocumentDocRequest build() {
            _checkSingleUse();

            return new GetDocumentDocRequest(this);
        }
    }

    public static final Endpoint<GetDocumentDocRequest, GetDocumentDocResponse, ErrorResponse>
            _ENDPOINT =
                    new SimpleEndpoint<>(
                            // Request method
                            request -> {
                                return "get";
                            },
                            // Request path
                            request -> {
                                return "/{index}/_doc/{id}";
                            },
                            // Request parameters
                            request -> {
                                Map<String, String> params = new HashMap<>();
                                if (request.source != null) {
                                    params.put("_source", request.source);
                                }
                                if (request.sourceExcludes != null) {
                                    params.put("_source_excludes", request.sourceExcludes);
                                }
                                if (request.sourceIncludes != null) {
                                    params.put("_source_includes", request.sourceIncludes);
                                }
                                if (request.preference != null) {
                                    params.put("preference", request.preference);
                                }
                                if (request.realtime != null) {
                                    params.put("realtime", String.valueOf(request.realtime));
                                }
                                if (request.refresh != null) {
                                    params.put("refresh", String.valueOf(request.refresh));
                                }
                                if (request.routing != null) {
                                    params.put("routing", request.routing);
                                }
                                if (request.storedFields != null) {
                                    params.put(
                                            "stored_fields", String.valueOf(request.storedFields));
                                }
                                if (request.version != null) {
                                    params.put("version", String.valueOf(request.version));
                                }
                                if (request.versionType != null) {
                                    params.put("version_type", request.versionType.jsonValue());
                                }
                                return params;
                            },
                            SimpleEndpoint.emptyMap(),
                            false,
                            GetDocumentDocResponse._DESERIALIZER);
}
