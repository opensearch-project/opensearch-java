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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ml.get_stats.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GetStatsResponse implements PlainJsonSerializable, ToCopyableBuilder<GetStatsResponse.Builder, GetStatsResponse> {

    @Nullable
    private final MlIndexStatus mlConfigIndexStatus;

    @Nullable
    private final Long mlConnectorCount;

    @Nullable
    private final MlIndexStatus mlConnectorIndexStatus;

    @Nullable
    private final MlIndexStatus mlControllerIndexStatus;

    @Nullable
    private final Long mlModelCount;

    @Nullable
    private final MlIndexStatus mlModelIndexStatus;

    @Nullable
    private final MlIndexStatus mlTaskIndexStatus;

    @Nonnull
    private final Map<String, NodeStatsDetails> nodes;

    // ---------------------------------------------------------------------------------------------

    private GetStatsResponse(Builder builder) {
        this.mlConfigIndexStatus = builder.mlConfigIndexStatus;
        this.mlConnectorCount = builder.mlConnectorCount;
        this.mlConnectorIndexStatus = builder.mlConnectorIndexStatus;
        this.mlControllerIndexStatus = builder.mlControllerIndexStatus;
        this.mlModelCount = builder.mlModelCount;
        this.mlModelIndexStatus = builder.mlModelIndexStatus;
        this.mlTaskIndexStatus = builder.mlTaskIndexStatus;
        this.nodes = ApiTypeHelper.unmodifiable(builder.nodes);
    }

    public static GetStatsResponse of(Function<GetStatsResponse.Builder, ObjectBuilder<GetStatsResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The config index status.
     * <p>
     * API name: {@code ml_config_index_status}
     * </p>
     */
    @Nullable
    public final MlIndexStatus mlConfigIndexStatus() {
        return this.mlConfigIndexStatus;
    }

    /**
     * The connector count.
     * <p>
     * API name: {@code ml_connector_count}
     * </p>
     */
    @Nullable
    public final Long mlConnectorCount() {
        return this.mlConnectorCount;
    }

    /**
     * The connector index status.
     * <p>
     * API name: {@code ml_connector_index_status}
     * </p>
     */
    @Nullable
    public final MlIndexStatus mlConnectorIndexStatus() {
        return this.mlConnectorIndexStatus;
    }

    /**
     * The controller index status.
     * <p>
     * API name: {@code ml_controller_index_status}
     * </p>
     */
    @Nullable
    public final MlIndexStatus mlControllerIndexStatus() {
        return this.mlControllerIndexStatus;
    }

    /**
     * The model count.
     * <p>
     * API name: {@code ml_model_count}
     * </p>
     */
    @Nullable
    public final Long mlModelCount() {
        return this.mlModelCount;
    }

    /**
     * The model index status.
     * <p>
     * API name: {@code ml_model_index_status}
     * </p>
     */
    @Nullable
    public final MlIndexStatus mlModelIndexStatus() {
        return this.mlModelIndexStatus;
    }

    /**
     * The task index status.
     * <p>
     * API name: {@code ml_task_index_status}
     * </p>
     */
    @Nullable
    public final MlIndexStatus mlTaskIndexStatus() {
        return this.mlTaskIndexStatus;
    }

    /**
     * API name: {@code nodes}
     */
    @Nonnull
    public final Map<String, NodeStatsDetails> nodes() {
        return this.nodes;
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
        if (this.mlConfigIndexStatus != null) {
            generator.writeKey("ml_config_index_status");
            this.mlConfigIndexStatus.serialize(generator, mapper);
        }

        if (this.mlConnectorCount != null) {
            generator.writeKey("ml_connector_count");
            generator.write(this.mlConnectorCount);
        }

        if (this.mlConnectorIndexStatus != null) {
            generator.writeKey("ml_connector_index_status");
            this.mlConnectorIndexStatus.serialize(generator, mapper);
        }

        if (this.mlControllerIndexStatus != null) {
            generator.writeKey("ml_controller_index_status");
            this.mlControllerIndexStatus.serialize(generator, mapper);
        }

        if (this.mlModelCount != null) {
            generator.writeKey("ml_model_count");
            generator.write(this.mlModelCount);
        }

        if (this.mlModelIndexStatus != null) {
            generator.writeKey("ml_model_index_status");
            this.mlModelIndexStatus.serialize(generator, mapper);
        }

        if (this.mlTaskIndexStatus != null) {
            generator.writeKey("ml_task_index_status");
            this.mlTaskIndexStatus.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.nodes)) {
            generator.writeKey("nodes");
            generator.writeStartObject();
            for (Map.Entry<String, NodeStatsDetails> item0 : this.nodes.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
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
     * Builder for {@link GetStatsResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, GetStatsResponse> {
        @Nullable
        private MlIndexStatus mlConfigIndexStatus;
        @Nullable
        private Long mlConnectorCount;
        @Nullable
        private MlIndexStatus mlConnectorIndexStatus;
        @Nullable
        private MlIndexStatus mlControllerIndexStatus;
        @Nullable
        private Long mlModelCount;
        @Nullable
        private MlIndexStatus mlModelIndexStatus;
        @Nullable
        private MlIndexStatus mlTaskIndexStatus;
        @Nullable
        private Map<String, NodeStatsDetails> nodes;

        public Builder() {}

        private Builder(GetStatsResponse o) {
            this.mlConfigIndexStatus = o.mlConfigIndexStatus;
            this.mlConnectorCount = o.mlConnectorCount;
            this.mlConnectorIndexStatus = o.mlConnectorIndexStatus;
            this.mlControllerIndexStatus = o.mlControllerIndexStatus;
            this.mlModelCount = o.mlModelCount;
            this.mlModelIndexStatus = o.mlModelIndexStatus;
            this.mlTaskIndexStatus = o.mlTaskIndexStatus;
            this.nodes = _mapCopy(o.nodes);
        }

        private Builder(Builder o) {
            this.mlConfigIndexStatus = o.mlConfigIndexStatus;
            this.mlConnectorCount = o.mlConnectorCount;
            this.mlConnectorIndexStatus = o.mlConnectorIndexStatus;
            this.mlControllerIndexStatus = o.mlControllerIndexStatus;
            this.mlModelCount = o.mlModelCount;
            this.mlModelIndexStatus = o.mlModelIndexStatus;
            this.mlTaskIndexStatus = o.mlTaskIndexStatus;
            this.nodes = _mapCopy(o.nodes);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The config index status.
         * <p>
         * API name: {@code ml_config_index_status}
         * </p>
         */
        @Nonnull
        public final Builder mlConfigIndexStatus(@Nullable MlIndexStatus value) {
            this.mlConfigIndexStatus = value;
            return this;
        }

        /**
         * The connector count.
         * <p>
         * API name: {@code ml_connector_count}
         * </p>
         */
        @Nonnull
        public final Builder mlConnectorCount(@Nullable Long value) {
            this.mlConnectorCount = value;
            return this;
        }

        /**
         * The connector index status.
         * <p>
         * API name: {@code ml_connector_index_status}
         * </p>
         */
        @Nonnull
        public final Builder mlConnectorIndexStatus(@Nullable MlIndexStatus value) {
            this.mlConnectorIndexStatus = value;
            return this;
        }

        /**
         * The controller index status.
         * <p>
         * API name: {@code ml_controller_index_status}
         * </p>
         */
        @Nonnull
        public final Builder mlControllerIndexStatus(@Nullable MlIndexStatus value) {
            this.mlControllerIndexStatus = value;
            return this;
        }

        /**
         * The model count.
         * <p>
         * API name: {@code ml_model_count}
         * </p>
         */
        @Nonnull
        public final Builder mlModelCount(@Nullable Long value) {
            this.mlModelCount = value;
            return this;
        }

        /**
         * The model index status.
         * <p>
         * API name: {@code ml_model_index_status}
         * </p>
         */
        @Nonnull
        public final Builder mlModelIndexStatus(@Nullable MlIndexStatus value) {
            this.mlModelIndexStatus = value;
            return this;
        }

        /**
         * The task index status.
         * <p>
         * API name: {@code ml_task_index_status}
         * </p>
         */
        @Nonnull
        public final Builder mlTaskIndexStatus(@Nullable MlIndexStatus value) {
            this.mlTaskIndexStatus = value;
            return this;
        }

        /**
         * API name: {@code nodes}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>nodes</code>.
         * </p>
         */
        @Nonnull
        public final Builder nodes(Map<String, NodeStatsDetails> map) {
            this.nodes = _mapPutAll(this.nodes, map);
            return this;
        }

        /**
         * API name: {@code nodes}
         *
         * <p>
         * Adds an entry to <code>nodes</code>.
         * </p>
         */
        @Nonnull
        public final Builder nodes(String key, NodeStatsDetails value) {
            this.nodes = _mapPut(this.nodes, key, value);
            return this;
        }

        /**
         * API name: {@code nodes}
         *
         * <p>
         * Adds a value to <code>nodes</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder nodes(String key, Function<NodeStatsDetails.Builder, ObjectBuilder<NodeStatsDetails>> fn) {
            return nodes(key, fn.apply(new NodeStatsDetails.Builder()).build());
        }

        /**
         * Builds a {@link GetStatsResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetStatsResponse build() {
            _checkSingleUse();

            return new GetStatsResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GetStatsResponse}
     */
    public static final JsonpDeserializer<GetStatsResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GetStatsResponse::setupGetStatsResponseDeserializer
    );

    protected static void setupGetStatsResponseDeserializer(ObjectDeserializer<GetStatsResponse.Builder> op) {
        op.add(Builder::mlConfigIndexStatus, MlIndexStatus._DESERIALIZER, "ml_config_index_status");
        op.add(Builder::mlConnectorCount, JsonpDeserializer.longDeserializer(), "ml_connector_count");
        op.add(Builder::mlConnectorIndexStatus, MlIndexStatus._DESERIALIZER, "ml_connector_index_status");
        op.add(Builder::mlControllerIndexStatus, MlIndexStatus._DESERIALIZER, "ml_controller_index_status");
        op.add(Builder::mlModelCount, JsonpDeserializer.longDeserializer(), "ml_model_count");
        op.add(Builder::mlModelIndexStatus, MlIndexStatus._DESERIALIZER, "ml_model_index_status");
        op.add(Builder::mlTaskIndexStatus, MlIndexStatus._DESERIALIZER, "ml_task_index_status");
        op.add(Builder::nodes, JsonpDeserializer.stringMapDeserializer(NodeStatsDetails._DESERIALIZER), "nodes");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.mlConfigIndexStatus);
        result = 31 * result + Objects.hashCode(this.mlConnectorCount);
        result = 31 * result + Objects.hashCode(this.mlConnectorIndexStatus);
        result = 31 * result + Objects.hashCode(this.mlControllerIndexStatus);
        result = 31 * result + Objects.hashCode(this.mlModelCount);
        result = 31 * result + Objects.hashCode(this.mlModelIndexStatus);
        result = 31 * result + Objects.hashCode(this.mlTaskIndexStatus);
        result = 31 * result + Objects.hashCode(this.nodes);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetStatsResponse other = (GetStatsResponse) o;
        return Objects.equals(this.mlConfigIndexStatus, other.mlConfigIndexStatus)
            && Objects.equals(this.mlConnectorCount, other.mlConnectorCount)
            && Objects.equals(this.mlConnectorIndexStatus, other.mlConnectorIndexStatus)
            && Objects.equals(this.mlControllerIndexStatus, other.mlControllerIndexStatus)
            && Objects.equals(this.mlModelCount, other.mlModelCount)
            && Objects.equals(this.mlModelIndexStatus, other.mlModelIndexStatus)
            && Objects.equals(this.mlTaskIndexStatus, other.mlTaskIndexStatus)
            && Objects.equals(this.nodes, other.nodes);
    }
}
