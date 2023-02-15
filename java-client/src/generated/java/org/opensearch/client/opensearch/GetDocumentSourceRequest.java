package org.opensearch.client.opensearch;

import org.opensearch.client.opensearch._types.*;
import org.opensearch.client.transport.*;
import org.opensearch.client.transport.endpoints.*;
import org.opensearch.client.util.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.*;
import javax.annotation.*;

/** Returns a document. */
public class GetDocumentSourceRequest extends RequestBase {

    private final String id;

    private final String index;

    @Nullable private final String preference;

    @Nullable private final Boolean realtime;

    @Nullable private final Boolean refresh;

    @Nullable private final String routing;

    @Nullable private final String source;

    @Nullable private final String sourceExcludes;

    @Nullable private final String sourceIncludes;

    @Nullable private final Boolean storedFields;

    @Nullable private final Integer version;

    @Nullable private final VersionType versionType;

    public GetDocumentSourceRequest(Builder builder) {
        this.id = ApiTypeHelper.requireNonNull(builder.id, this, "id");
        this.index = ApiTypeHelper.requireNonNull(builder.index, this, "index");
        this.preference = builder.preference;
        this.realtime = builder.realtime;
        this.refresh = builder.refresh;
        this.routing = builder.routing;
        this.source = builder.source;
        this.sourceExcludes = builder.sourceExcludes;
        this.sourceIncludes = builder.sourceIncludes;
        this.storedFields = builder.storedFields;
        this.version = builder.version;
        this.versionType = builder.versionType;
    }

    public static GetDocumentSourceRequest of(
            Function<Builder, ObjectBuilder<GetDocumentSourceRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    public final String id() {
        return this.id;
    }

    public final String index() {
        return this.index;
    }

    public final String preference() {
        return this.preference;
    }

    public final Boolean realtime() {
        return this.realtime;
    }

    public final Boolean refresh() {
        return this.refresh;
    }

    public final String routing() {
        return this.routing;
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

    public final Boolean storedFields() {
        return this.storedFields;
    }

    public final Integer version() {
        return this.version;
    }

    public final VersionType versionType() {
        return this.versionType;
    }

    /** Builder for {@link GetDocumentSourceRequest}. */
    public static class Builder extends ObjectBuilderBase
            implements ObjectBuilder<GetDocumentSourceRequest> {
        private String id;
        private String index;
        private String preference;
        private Boolean realtime;
        private Boolean refresh;
        private String routing;
        private String source;
        private String sourceExcludes;
        private String sourceIncludes;
        private Boolean storedFields;
        private Integer version;
        private VersionType versionType;

        public final Builder id(String value) {
            this.id = value;
            return this;
        }

        public final Builder index(String value) {
            this.index = value;
            return this;
        }

        public final Builder preference(String value) {
            this.preference = value;
            return this;
        }

        public final Builder realtime(Boolean value) {
            this.realtime = value;
            return this;
        }

        public final Builder refresh(Boolean value) {
            this.refresh = value;
            return this;
        }

        public final Builder routing(String value) {
            this.routing = value;
            return this;
        }

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

        public final Builder storedFields(Boolean value) {
            this.storedFields = value;
            return this;
        }

        public final Builder version(Integer value) {
            this.version = value;
            return this;
        }

        public final Builder versionType(VersionType value) {
            this.versionType = value;
            return this;
        }

        /**
         * Builds a {@link GetDocumentSourceRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public GetDocumentSourceRequest build() {
            _checkSingleUse();

            return new GetDocumentSourceRequest(this);
        }
    }

    public static final Endpoint<GetDocumentSourceRequest, GetDocumentSourceResponse, ErrorResponse>
            _ENDPOINT =
                    new SimpleEndpoint<>(
                            // Request method
                            request -> {
                                return "get";
                            },
                            // Request path
                            request -> {
                                return "/" + request.index + "/_source/" + request.id + "";
                            },
                            // Request parameters
                            request -> {
                                Map<String, String> params = new HashMap<>();
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
                                if (request.source != null) {
                                    params.put("_source", request.source);
                                }
                                if (request.sourceExcludes != null) {
                                    params.put("_source_excludes", request.sourceExcludes);
                                }
                                if (request.sourceIncludes != null) {
                                    params.put("_source_includes", request.sourceIncludes);
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
                            GetDocumentSourceResponse._DESERIALIZER);
}
