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
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: ml.deploy_model.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class DeployModelResponse implements PlainJsonSerializable {

    private final String status;

    private final String taskId;

    @Nullable
    private final String taskType;

    // ---------------------------------------------------------------------------------------------

    private DeployModelResponse(Builder builder) {
        this.status = ApiTypeHelper.requireNonNull(builder.status, this, "status");
        this.taskId = ApiTypeHelper.requireNonNull(builder.taskId, this, "taskId");
        this.taskType = builder.taskType;
    }

    public static DeployModelResponse of(Function<DeployModelResponse.Builder, ObjectBuilder<DeployModelResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code status}
     */
    public final String status() {
        return this.status;
    }

    /**
     * Required - API name: {@code task_id}
     */
    public final String taskId() {
        return this.taskId;
    }

    /**
     * API name: {@code task_type}
     */
    @Nullable
    public final String taskType() {
        return this.taskType;
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
        generator.writeKey("status");
        generator.write(this.status);

        generator.writeKey("task_id");
        generator.write(this.taskId);

        if (this.taskType != null) {
            generator.writeKey("task_type");
            generator.write(this.taskType);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link DeployModelResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<DeployModelResponse> {
        private String status;
        private String taskId;
        @Nullable
        private String taskType;

        /**
         * Required - API name: {@code status}
         */
        public final Builder status(String value) {
            this.status = value;
            return this;
        }

        /**
         * Required - API name: {@code task_id}
         */
        public final Builder taskId(String value) {
            this.taskId = value;
            return this;
        }

        /**
         * API name: {@code task_type}
         */
        public final Builder taskType(@Nullable String value) {
            this.taskType = value;
            return this;
        }

        /**
         * Builds a {@link DeployModelResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public DeployModelResponse build() {
            _checkSingleUse();

            return new DeployModelResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link DeployModelResponse}
     */
    public static final JsonpDeserializer<DeployModelResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        DeployModelResponse::setupDeployModelResponseDeserializer
    );

    protected static void setupDeployModelResponseDeserializer(ObjectDeserializer<DeployModelResponse.Builder> op) {
        op.add(Builder::status, JsonpDeserializer.stringDeserializer(), "status");
        op.add(Builder::taskId, JsonpDeserializer.stringDeserializer(), "task_id");
        op.add(Builder::taskType, JsonpDeserializer.stringDeserializer(), "task_type");
    }
}
