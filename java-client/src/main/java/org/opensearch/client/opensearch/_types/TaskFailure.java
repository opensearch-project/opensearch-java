/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch._types;

// typedef: _types.TaskFailure

import jakarta.json.stream.JsonGenerator;
import java.util.function.Function;
import javax.annotation.Nullable;
import org.opensearch.client.json.*;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

@JsonpDeserializable
public class TaskFailure implements JsonpSerializable {

    private final ErrorCause cause;

    @Nullable
    private final String id;

    @Nullable
    private final String index;

    @Nullable
    private final Integer status;

    @Nullable
    private final String type;

    // ---------------------------------------------------------------------------------------------

    private TaskFailure(Builder builder) {

        this.index = builder.index;
        this.id = builder.id;
        this.cause = ApiTypeHelper.requireNonNull(builder.cause, this, "cause");
        this.status = builder.status;
        this.type = builder.type;

    }

    public static TaskFailure of(Function<Builder, ObjectBuilder<TaskFailure>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code index}
     */
    @Nullable
    public final String index() {
        return this.index;
    }

    /**
     * API name: {@code id}
     */
    @Nullable
    public final String id() {
        return this.id;
    }

    /**
     * Required - API name: {@code cause}
     */
    public final ErrorCause cause() {
        return this.cause;
    }

    /**
     * API name: {@code status}
     */
    @Nullable
    public final Integer status() {
        return this.status;
    }

    /**
     * API name: {@code type}
     */
    @Nullable
    public final String type() {
        return this.type;
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

        if (this.index != null) {
            generator.writeKey("index");
            generator.write(this.index);

        }
        if (this.id != null) {
            generator.writeKey("id");
            generator.write(this.id);
        }

        generator.writeKey("cause");
        this.cause.serialize(generator, mapper);

        if (this.status != null) {
            generator.writeKey("status");
            generator.write(this.status);
        }
        if (this.type != null) {
            generator.writeKey("type");
            generator.write(this.type);
        }

    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link TaskFailure}.
     */

    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<TaskFailure> {
        @Nullable
        private String index;

        @Nullable
        private String id;

        private ErrorCause cause;

        @Nullable
        private Integer status;

        @Nullable
        private String type;

        /**
         * API name: {@code index}
         */
        public final Builder index(@Nullable String value) {
            this.index = value;
            return this;
        }

        /**
         * API name: {@code id}
         */
        public final Builder id(@Nullable String value) {
            this.id = value;
            return this;
        }

        /**
         * Required - API name: {@code cause}
         */
        public final Builder cause(ErrorCause value) {
            this.cause = value;
            return this;
        }

        /**
         * Required - API name: {@code cause}
         */
        public final Builder cause(Function<ErrorCause.Builder, ObjectBuilder<ErrorCause>> fn) {
            return this.cause(fn.apply(new ErrorCause.Builder()).build());
        }

        /**
         * API name: {@code status}
         */
        public final Builder status(@Nullable Integer value) {
            this.status = value;
            return this;
        }

        /**
         * API name: {@code type}
         */
        public final Builder type(@Nullable String value) {
            this.type = value;
            return this;
        }

        /**
         * Builds a {@link TaskFailure}.
         *
         * @throws NullPointerException
         *             if some of the required fields are null.
         */
        public TaskFailure build() {
            _checkSingleUse();

            return new TaskFailure(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link TaskFailure}
     */
    public static final JsonpDeserializer<TaskFailure> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        TaskFailure::setupTaskFailureDeserializer
    );

    protected static void setupTaskFailureDeserializer(ObjectDeserializer<Builder> op) {

        op.add(Builder::index, JsonpDeserializer.stringDeserializer(), "index");
        op.add(Builder::id, JsonpDeserializer.stringDeserializer(), "id");
        op.add(Builder::cause, ErrorCause._DESERIALIZER, "cause");
        op.add(Builder::status, JsonpDeserializer.integerDeserializer(), "status");
        op.add(Builder::type, JsonpDeserializer.stringDeserializer(), "type");

    }

}
