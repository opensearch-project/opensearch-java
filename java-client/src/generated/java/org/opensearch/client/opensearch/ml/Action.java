/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

//----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------

package org.opensearch.client.opensearch.ml;

import jakarta.json.stream.JsonGenerator;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: ml.Action

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Action implements PlainJsonSerializable {

    @Nullable
    private final String actionType;

    @Nullable
    private final Headers headers;

    @Nullable
    private final String method;

    @Nullable
    private final String postProcessFunction;

    @Nullable
    private final String preProcessFunction;

    @Nullable
    private final String requestBody;

    @Nullable
    private final String url;

    // ---------------------------------------------------------------------------------------------

    private Action(Builder builder) {
        this.actionType = builder.actionType;
        this.headers = builder.headers;
        this.method = builder.method;
        this.postProcessFunction = builder.postProcessFunction;
        this.preProcessFunction = builder.preProcessFunction;
        this.requestBody = builder.requestBody;
        this.url = builder.url;
    }

    public static Action of(Function<Action.Builder, ObjectBuilder<Action>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code action_type}
     */
    @Nullable
    public final String actionType() {
        return this.actionType;
    }

    /**
     * API name: {@code headers}
     */
    @Nullable
    public final Headers headers() {
        return this.headers;
    }

    /**
     * API name: {@code method}
     */
    @Nullable
    public final String method() {
        return this.method;
    }

    /**
     * API name: {@code post_process_function}
     */
    @Nullable
    public final String postProcessFunction() {
        return this.postProcessFunction;
    }

    /**
     * API name: {@code pre_process_function}
     */
    @Nullable
    public final String preProcessFunction() {
        return this.preProcessFunction;
    }

    /**
     * API name: {@code request_body}
     */
    @Nullable
    public final String requestBody() {
        return this.requestBody;
    }

    /**
     * API name: {@code url}
     */
    @Nullable
    public final String url() {
        return this.url;
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
        if (this.actionType != null) {
            generator.writeKey("action_type");
            generator.write(this.actionType);
        }

        if (this.headers != null) {
            generator.writeKey("headers");
            this.headers.serialize(generator, mapper);
        }

        if (this.method != null) {
            generator.writeKey("method");
            generator.write(this.method);
        }

        if (this.postProcessFunction != null) {
            generator.writeKey("post_process_function");
            generator.write(this.postProcessFunction);
        }

        if (this.preProcessFunction != null) {
            generator.writeKey("pre_process_function");
            generator.write(this.preProcessFunction);
        }

        if (this.requestBody != null) {
            generator.writeKey("request_body");
            generator.write(this.requestBody);
        }

        if (this.url != null) {
            generator.writeKey("url");
            generator.write(this.url);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link Action}.
     */
    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<Action> {
        @Nullable
        private String actionType;
        @Nullable
        private Headers headers;
        @Nullable
        private String method;
        @Nullable
        private String postProcessFunction;
        @Nullable
        private String preProcessFunction;
        @Nullable
        private String requestBody;
        @Nullable
        private String url;

        /**
         * API name: {@code action_type}
         */
        public final Builder actionType(@Nullable String value) {
            this.actionType = value;
            return this;
        }

        /**
         * API name: {@code headers}
         */
        public final Builder headers(@Nullable Headers value) {
            this.headers = value;
            return this;
        }

        /**
         * API name: {@code headers}
         */
        public final Builder headers(Function<Headers.Builder, ObjectBuilder<Headers>> fn) {
            return headers(fn.apply(new Headers.Builder()).build());
        }

        /**
         * API name: {@code method}
         */
        public final Builder method(@Nullable String value) {
            this.method = value;
            return this;
        }

        /**
         * API name: {@code post_process_function}
         */
        public final Builder postProcessFunction(@Nullable String value) {
            this.postProcessFunction = value;
            return this;
        }

        /**
         * API name: {@code pre_process_function}
         */
        public final Builder preProcessFunction(@Nullable String value) {
            this.preProcessFunction = value;
            return this;
        }

        /**
         * API name: {@code request_body}
         */
        public final Builder requestBody(@Nullable String value) {
            this.requestBody = value;
            return this;
        }

        /**
         * API name: {@code url}
         */
        public final Builder url(@Nullable String value) {
            this.url = value;
            return this;
        }

        /**
         * Builds a {@link Action}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public Action build() {
            _checkSingleUse();

            return new Action(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link Action}
     */
    public static final JsonpDeserializer<Action> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        Action::setupActionDeserializer
    );

    protected static void setupActionDeserializer(ObjectDeserializer<Action.Builder> op) {
        op.add(Builder::actionType, JsonpDeserializer.stringDeserializer(), "action_type");
        op.add(Builder::headers, Headers._DESERIALIZER, "headers");
        op.add(Builder::method, JsonpDeserializer.stringDeserializer(), "method");
        op.add(Builder::postProcessFunction, JsonpDeserializer.stringDeserializer(), "post_process_function");
        op.add(Builder::preProcessFunction, JsonpDeserializer.stringDeserializer(), "pre_process_function");
        op.add(Builder::requestBody, JsonpDeserializer.stringDeserializer(), "request_body");
        op.add(Builder::url, JsonpDeserializer.stringDeserializer(), "url");
    }

    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.actionType);
        result = 31 * result + Objects.hashCode(this.headers);
        result = 31 * result + Objects.hashCode(this.method);
        result = 31 * result + Objects.hashCode(this.postProcessFunction);
        result = 31 * result + Objects.hashCode(this.preProcessFunction);
        result = 31 * result + Objects.hashCode(this.requestBody);
        result = 31 * result + Objects.hashCode(this.url);
        return result;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Action other = (Action) o;
        return Objects.equals(this.actionType, other.actionType)
            && Objects.equals(this.headers, other.headers)
            && Objects.equals(this.method, other.method)
            && Objects.equals(this.postProcessFunction, other.postProcessFunction)
            && Objects.equals(this.preProcessFunction, other.preProcessFunction)
            && Objects.equals(this.requestBody, other.requestBody)
            && Objects.equals(this.url, other.url);
    }
}
