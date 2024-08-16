/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

/*
 * Licensed to Elasticsearch B.V. under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch B.V. licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

/*
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
 */

//----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------

package org.opensearch.client.opensearch._types;

import jakarta.json.stream.JsonGenerator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonData;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: _types.ErrorCause

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ErrorCause implements PlainJsonSerializable {

    @Nullable
    private final ErrorCause causedBy;

    @Nullable
    private final String reason;

    private final List<ErrorCause> rootCause;

    @Nullable
    private final String stackTrace;

    private final List<ErrorCause> suppressed;

    private final String type;

    private final Map<String, JsonData> metadata;

    // ---------------------------------------------------------------------------------------------

    private ErrorCause(Builder builder) {
        this.causedBy = builder.causedBy;
        this.reason = builder.reason;
        this.rootCause = ApiTypeHelper.unmodifiable(builder.rootCause);
        this.stackTrace = builder.stackTrace;
        this.suppressed = ApiTypeHelper.unmodifiable(builder.suppressed);
        this.type = ApiTypeHelper.requireNonNull(builder.type, this, "type");
        this.metadata = ApiTypeHelper.unmodifiable(builder.metadata);
    }

    public static ErrorCause of(Function<ErrorCause.Builder, ObjectBuilder<ErrorCause>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code caused_by}
     */
    @Nullable
    public final ErrorCause causedBy() {
        return this.causedBy;
    }

    /**
     * A human-readable explanation of the error, in english
     * <p>
     * API name: {@code reason}
     * </p>
     */
    @Nullable
    public final String reason() {
        return this.reason;
    }

    /**
     * API name: {@code root_cause}
     */
    public final List<ErrorCause> rootCause() {
        return this.rootCause;
    }

    /**
     * The server stack trace. Present only if the `error_trace=true` parameter was sent with the request.
     * <p>
     * API name: {@code stack_trace}
     * </p>
     */
    @Nullable
    public final String stackTrace() {
        return this.stackTrace;
    }

    /**
     * API name: {@code suppressed}
     */
    public final List<ErrorCause> suppressed() {
        return this.suppressed;
    }

    /**
     * Required - The type of error
     * <p>
     * API name: {@code type}
     * </p>
     */
    public final String type() {
        return this.type;
    }

    /**
     * Additional details about the error.
     */
    public final Map<String, JsonData> metadata() {
        return this.metadata;
    }

    /**
     * Serialize this object to JSON.
     */
    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        for (Map.Entry<String, JsonData> item0 : this.metadata.entrySet()) {
            generator.writeKey(item0.getKey());
            item0.getValue().serialize(generator, mapper);

        }

        if (this.causedBy != null) {
            generator.writeKey("caused_by");
            this.causedBy.serialize(generator, mapper);

        }

        if (this.reason != null) {
            generator.writeKey("reason");
            generator.write(this.reason);

        }

        if (ApiTypeHelper.isDefined(this.rootCause)) {
            generator.writeKey("root_cause");
            generator.writeStartArray();
            for (ErrorCause item0 : this.rootCause) {
                item0.serialize(generator, mapper);

            }
            generator.writeEnd();

        }

        if (this.stackTrace != null) {
            generator.writeKey("stack_trace");
            generator.write(this.stackTrace);

        }

        if (ApiTypeHelper.isDefined(this.suppressed)) {
            generator.writeKey("suppressed");
            generator.writeStartArray();
            for (ErrorCause item0 : this.suppressed) {
                item0.serialize(generator, mapper);

            }
            generator.writeEnd();

        }

        generator.writeKey("type");
        generator.write(this.type);

    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link ErrorCause}.
     */
    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<ErrorCause> {
        @Nullable
        private ErrorCause causedBy;
        @Nullable
        private String reason;
        @Nullable
        private List<ErrorCause> rootCause;
        @Nullable
        private String stackTrace;
        @Nullable
        private List<ErrorCause> suppressed;
        private String type;
        @Nullable
        private Map<String, JsonData> metadata;

        /**
         * API name: {@code caused_by}
         */
        public final Builder causedBy(@Nullable ErrorCause value) {
            this.causedBy = value;
            return this;
        }

        /**
         * API name: {@code caused_by}
         */
        public final Builder causedBy(Function<ErrorCause.Builder, ObjectBuilder<ErrorCause>> fn) {
            return causedBy(fn.apply(new ErrorCause.Builder()).build());
        }

        /**
         * A human-readable explanation of the error, in english
         * <p>
         * API name: {@code reason}
         * </p>
         */
        public final Builder reason(@Nullable String value) {
            this.reason = value;
            return this;
        }

        /**
         * API name: {@code root_cause}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>rootCause</code>.
         * </p>
         */
        public final Builder rootCause(List<ErrorCause> list) {
            this.rootCause = _listAddAll(this.rootCause, list);
            return this;
        }

        /**
         * API name: {@code root_cause}
         *
         * <p>
         * Adds one or more values to <code>rootCause</code>.
         * </p>
         */
        public final Builder rootCause(ErrorCause value, ErrorCause... values) {
            this.rootCause = _listAdd(this.rootCause, value, values);
            return this;
        }

        /**
         * API name: {@code root_cause}
         *
         * <p>
         * Adds a value to <code>rootCause</code> using a builder lambda.
         * </p>
         */
        public final Builder rootCause(Function<ErrorCause.Builder, ObjectBuilder<ErrorCause>> fn) {
            return rootCause(fn.apply(new ErrorCause.Builder()).build());
        }

        /**
         * The server stack trace. Present only if the `error_trace=true` parameter was sent with the request.
         * <p>
         * API name: {@code stack_trace}
         * </p>
         */
        public final Builder stackTrace(@Nullable String value) {
            this.stackTrace = value;
            return this;
        }

        /**
         * API name: {@code suppressed}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>suppressed</code>.
         * </p>
         */
        public final Builder suppressed(List<ErrorCause> list) {
            this.suppressed = _listAddAll(this.suppressed, list);
            return this;
        }

        /**
         * API name: {@code suppressed}
         *
         * <p>
         * Adds one or more values to <code>suppressed</code>.
         * </p>
         */
        public final Builder suppressed(ErrorCause value, ErrorCause... values) {
            this.suppressed = _listAdd(this.suppressed, value, values);
            return this;
        }

        /**
         * API name: {@code suppressed}
         *
         * <p>
         * Adds a value to <code>suppressed</code> using a builder lambda.
         * </p>
         */
        public final Builder suppressed(Function<ErrorCause.Builder, ObjectBuilder<ErrorCause>> fn) {
            return suppressed(fn.apply(new ErrorCause.Builder()).build());
        }

        /**
         * Required - The type of error
         * <p>
         * API name: {@code type}
         * </p>
         */
        public final Builder type(String value) {
            this.type = value;
            return this;
        }

        /**
         * Additional details about the error.
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>metadata</code>.
         * </p>
         */
        public final Builder metadata(Map<String, JsonData> map) {
            this.metadata = _mapPutAll(this.metadata, map);
            return this;
        }

        /**
         * Additional details about the error.
         *
         * <p>
         * Adds an entry to <code>metadata</code>.
         * </p>
         */
        public final Builder metadata(String key, JsonData value) {
            this.metadata = _mapPut(this.metadata, key, value);
            return this;
        }

        /**
         * Builds a {@link ErrorCause}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public ErrorCause build() {
            _checkSingleUse();

            return new ErrorCause(this);
        }
    }
    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ErrorCause}
     */
    public static final JsonpDeserializer<ErrorCause> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ErrorCause::setupErrorCauseDeserializer
    );

    protected static void setupErrorCauseDeserializer(ObjectDeserializer<ErrorCause.Builder> op) {
        op.add(Builder::causedBy, ErrorCause._DESERIALIZER, "caused_by");
        op.add(Builder::reason, JsonpDeserializer.stringDeserializer(), "reason");
        op.add(Builder::rootCause, JsonpDeserializer.arrayDeserializer(ErrorCause._DESERIALIZER), "root_cause");
        op.add(Builder::stackTrace, JsonpDeserializer.stringDeserializer(), "stack_trace");
        op.add(Builder::suppressed, JsonpDeserializer.arrayDeserializer(ErrorCause._DESERIALIZER), "suppressed");
        op.add(Builder::type, JsonpDeserializer.stringDeserializer(), "type");
        op.setUnknownFieldHandler((builder, name, parser, mapper) -> {
            if (builder.metadata == null) {
                builder.metadata = new HashMap<>();
            }
            builder.metadata.put(name, JsonData._DESERIALIZER.deserialize(parser, mapper));
        });
    }
}
