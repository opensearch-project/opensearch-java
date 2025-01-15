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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ml.get_profile_tasks.Request

/**
 * Get a profile tasks.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class GetProfileTasksRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<GetProfileTasksRequest.Builder, GetProfileTasksRequest> {

    @Nonnull
    private final List<String> modelIds;

    @Nonnull
    private final List<String> nodeIds;

    @Nullable
    private final Boolean returnAllModels;

    @Nullable
    private final Boolean returnAllTasks;

    @Nullable
    private final String taskId;

    @Nonnull
    private final List<String> taskIds;

    // ---------------------------------------------------------------------------------------------

    private GetProfileTasksRequest(Builder builder) {
        super(builder);
        this.modelIds = ApiTypeHelper.unmodifiable(builder.modelIds);
        this.nodeIds = ApiTypeHelper.unmodifiable(builder.nodeIds);
        this.returnAllModels = builder.returnAllModels;
        this.returnAllTasks = builder.returnAllTasks;
        this.taskId = builder.taskId;
        this.taskIds = ApiTypeHelper.unmodifiable(builder.taskIds);
    }

    public static GetProfileTasksRequest of(Function<GetProfileTasksRequest.Builder, ObjectBuilder<GetProfileTasksRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code model_ids}
     */
    @Nonnull
    public final List<String> modelIds() {
        return this.modelIds;
    }

    /**
     * API name: {@code node_ids}
     */
    @Nonnull
    public final List<String> nodeIds() {
        return this.nodeIds;
    }

    /**
     * Whether to return all models.
     * <p>
     * API name: {@code return_all_models}
     * </p>
     */
    @Nullable
    public final Boolean returnAllModels() {
        return this.returnAllModels;
    }

    /**
     * Whether to return all tasks.
     * <p>
     * API name: {@code return_all_tasks}
     * </p>
     */
    @Nullable
    public final Boolean returnAllTasks() {
        return this.returnAllTasks;
    }

    /**
     * API name: {@code task_id}
     */
    @Nullable
    public final String taskId() {
        return this.taskId;
    }

    /**
     * API name: {@code task_ids}
     */
    @Nonnull
    public final List<String> taskIds() {
        return this.taskIds;
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
        if (ApiTypeHelper.isDefined(this.modelIds)) {
            generator.writeKey("model_ids");
            generator.writeStartArray();
            for (String item0 : this.modelIds) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.nodeIds)) {
            generator.writeKey("node_ids");
            generator.writeStartArray();
            for (String item0 : this.nodeIds) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.returnAllModels != null) {
            generator.writeKey("return_all_models");
            generator.write(this.returnAllModels);
        }

        if (this.returnAllTasks != null) {
            generator.writeKey("return_all_tasks");
            generator.write(this.returnAllTasks);
        }

        if (ApiTypeHelper.isDefined(this.taskIds)) {
            generator.writeKey("task_ids");
            generator.writeStartArray();
            for (String item0 : this.taskIds) {
                generator.write(item0);
            }
            generator.writeEnd();
        }
    }
    // ---------------------------------------------------------------------------------------------

    @Override
    @Nonnull
    public Builder toBuilder() {
        return new Builder(this);
    }

    @Nonnull
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builder for {@link GetProfileTasksRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, GetProfileTasksRequest> {
        @Nullable
        private List<String> modelIds;
        @Nullable
        private List<String> nodeIds;
        @Nullable
        private Boolean returnAllModels;
        @Nullable
        private Boolean returnAllTasks;
        @Nullable
        private String taskId;
        @Nullable
        private List<String> taskIds;

        public Builder() {}

        private Builder(GetProfileTasksRequest o) {
            super(o);
            this.modelIds = _listCopy(o.modelIds);
            this.nodeIds = _listCopy(o.nodeIds);
            this.returnAllModels = o.returnAllModels;
            this.returnAllTasks = o.returnAllTasks;
            this.taskId = o.taskId;
            this.taskIds = _listCopy(o.taskIds);
        }

        private Builder(Builder o) {
            super(o);
            this.modelIds = _listCopy(o.modelIds);
            this.nodeIds = _listCopy(o.nodeIds);
            this.returnAllModels = o.returnAllModels;
            this.returnAllTasks = o.returnAllTasks;
            this.taskId = o.taskId;
            this.taskIds = _listCopy(o.taskIds);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        @Override
        @Nonnull
        protected Builder self() {
            return this;
        }

        /**
         * API name: {@code model_ids}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>modelIds</code>.
         * </p>
         */
        @Nonnull
        public final Builder modelIds(List<String> list) {
            this.modelIds = _listAddAll(this.modelIds, list);
            return this;
        }

        /**
         * API name: {@code model_ids}
         *
         * <p>
         * Adds one or more values to <code>modelIds</code>.
         * </p>
         */
        @Nonnull
        public final Builder modelIds(String value, String... values) {
            this.modelIds = _listAdd(this.modelIds, value, values);
            return this;
        }

        /**
         * API name: {@code node_ids}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>nodeIds</code>.
         * </p>
         */
        @Nonnull
        public final Builder nodeIds(List<String> list) {
            this.nodeIds = _listAddAll(this.nodeIds, list);
            return this;
        }

        /**
         * API name: {@code node_ids}
         *
         * <p>
         * Adds one or more values to <code>nodeIds</code>.
         * </p>
         */
        @Nonnull
        public final Builder nodeIds(String value, String... values) {
            this.nodeIds = _listAdd(this.nodeIds, value, values);
            return this;
        }

        /**
         * Whether to return all models.
         * <p>
         * API name: {@code return_all_models}
         * </p>
         */
        @Nonnull
        public final Builder returnAllModels(@Nullable Boolean value) {
            this.returnAllModels = value;
            return this;
        }

        /**
         * Whether to return all tasks.
         * <p>
         * API name: {@code return_all_tasks}
         * </p>
         */
        @Nonnull
        public final Builder returnAllTasks(@Nullable Boolean value) {
            this.returnAllTasks = value;
            return this;
        }

        /**
         * API name: {@code task_id}
         */
        @Nonnull
        public final Builder taskId(@Nullable String value) {
            this.taskId = value;
            return this;
        }

        /**
         * API name: {@code task_ids}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>taskIds</code>.
         * </p>
         */
        @Nonnull
        public final Builder taskIds(List<String> list) {
            this.taskIds = _listAddAll(this.taskIds, list);
            return this;
        }

        /**
         * API name: {@code task_ids}
         *
         * <p>
         * Adds one or more values to <code>taskIds</code>.
         * </p>
         */
        @Nonnull
        public final Builder taskIds(String value, String... values) {
            this.taskIds = _listAdd(this.taskIds, value, values);
            return this;
        }

        /**
         * Builds a {@link GetProfileTasksRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetProfileTasksRequest build() {
            _checkSingleUse();

            return new GetProfileTasksRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GetProfileTasksRequest}
     */
    public static final JsonpDeserializer<GetProfileTasksRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GetProfileTasksRequest::setupGetProfileTasksRequestDeserializer
    );

    protected static void setupGetProfileTasksRequestDeserializer(ObjectDeserializer<GetProfileTasksRequest.Builder> op) {
        op.add(Builder::modelIds, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "model_ids");
        op.add(Builder::nodeIds, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "node_ids");
        op.add(Builder::returnAllModels, JsonpDeserializer.booleanDeserializer(), "return_all_models");
        op.add(Builder::returnAllTasks, JsonpDeserializer.booleanDeserializer(), "return_all_tasks");
        op.add(Builder::taskIds, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "task_ids");
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code ml.get_profile_tasks}".
     */
    public static final Endpoint<GetProfileTasksRequest, GetProfileTasksResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "GET",
        // Request path
        request -> {
            final int _taskId = 1 << 0;

            int propsSet = 0;

            if (request.taskId() != null) propsSet |= _taskId;

            if (propsSet == 0) {
                return "/_plugins/_ml/profile/tasks";
            }
            if (propsSet == (_taskId)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/_plugins/_ml/profile/tasks/");
                SimpleEndpoint.pathEncode(request.taskId, buf);
                return buf.toString();
            }

            throw SimpleEndpoint.noPathTemplateFound("path");
        },
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap(),
        true,
        GetProfileTasksResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.modelIds);
        result = 31 * result + Objects.hashCode(this.nodeIds);
        result = 31 * result + Objects.hashCode(this.returnAllModels);
        result = 31 * result + Objects.hashCode(this.returnAllTasks);
        result = 31 * result + Objects.hashCode(this.taskId);
        result = 31 * result + Objects.hashCode(this.taskIds);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetProfileTasksRequest other = (GetProfileTasksRequest) o;
        return Objects.equals(this.modelIds, other.modelIds)
            && Objects.equals(this.nodeIds, other.nodeIds)
            && Objects.equals(this.returnAllModels, other.returnAllModels)
            && Objects.equals(this.returnAllTasks, other.returnAllTasks)
            && Objects.equals(this.taskId, other.taskId)
            && Objects.equals(this.taskIds, other.taskIds);
    }
}
