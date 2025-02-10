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

// typedef: ml.execute_algorithm.Request

/**
 * Execute an algorithm.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class ExecuteAlgorithmRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ExecuteAlgorithmRequest.Builder, ExecuteAlgorithmRequest> {

    @Nonnull
    private final List<Aggregation> aggregations;

    @Nonnull
    private final String algorithmName;

    @Nonnull
    private final List<String> attributeFieldNames;

    @Nullable
    private final Long endTime;

    @Nullable
    private final String indexName;

    @Nonnull
    private final List<Number> inputData;

    @Nonnull
    private final List<List<Number>> metrics;

    @Nullable
    private final Long minTimeInterval;

    @Nullable
    private final Long numOutputs;

    @Nullable
    private final String operation;

    @Nullable
    private final Long startTime;

    @Nullable
    private final String timeFieldName;

    // ---------------------------------------------------------------------------------------------

    private ExecuteAlgorithmRequest(Builder builder) {
        super(builder);
        this.aggregations = ApiTypeHelper.unmodifiable(builder.aggregations);
        this.algorithmName = ApiTypeHelper.requireNonNull(builder.algorithmName, this, "algorithmName");
        this.attributeFieldNames = ApiTypeHelper.unmodifiable(builder.attributeFieldNames);
        this.endTime = builder.endTime;
        this.indexName = builder.indexName;
        this.inputData = ApiTypeHelper.unmodifiable(builder.inputData);
        this.metrics = ApiTypeHelper.unmodifiable(builder.metrics);
        this.minTimeInterval = builder.minTimeInterval;
        this.numOutputs = builder.numOutputs;
        this.operation = builder.operation;
        this.startTime = builder.startTime;
        this.timeFieldName = builder.timeFieldName;
    }

    public static ExecuteAlgorithmRequest of(Function<ExecuteAlgorithmRequest.Builder, ObjectBuilder<ExecuteAlgorithmRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code aggregations}
     */
    @Nonnull
    public final List<Aggregation> aggregations() {
        return this.aggregations;
    }

    /**
     * Required - API name: {@code algorithm_name}
     */
    @Nonnull
    public final String algorithmName() {
        return this.algorithmName;
    }

    /**
     * The attribute field names
     * <p>
     * API name: {@code attribute_field_names}
     * </p>
     */
    @Nonnull
    public final List<String> attributeFieldNames() {
        return this.attributeFieldNames;
    }

    /**
     * The end time.
     * <p>
     * API name: {@code end_time}
     * </p>
     */
    @Nullable
    public final Long endTime() {
        return this.endTime;
    }

    /**
     * The index name.
     * <p>
     * API name: {@code index_name}
     * </p>
     */
    @Nullable
    public final String indexName() {
        return this.indexName;
    }

    /**
     * The input data.
     * <p>
     * API name: {@code input_data}
     * </p>
     */
    @Nonnull
    public final List<Number> inputData() {
        return this.inputData;
    }

    /**
     * The metrics input.
     * <p>
     * API name: {@code metrics}
     * </p>
     */
    @Nonnull
    public final List<List<Number>> metrics() {
        return this.metrics;
    }

    /**
     * The minimum time interval.
     * <p>
     * API name: {@code min_time_interval}
     * </p>
     */
    @Nullable
    public final Long minTimeInterval() {
        return this.minTimeInterval;
    }

    /**
     * The number of outputs.
     * <p>
     * API name: {@code num_outputs}
     * </p>
     */
    @Nullable
    public final Long numOutputs() {
        return this.numOutputs;
    }

    /**
     * The calculator operation.
     * <p>
     * API name: {@code operation}
     * </p>
     */
    @Nullable
    public final String operation() {
        return this.operation;
    }

    /**
     * The start time.
     * <p>
     * API name: {@code start_time}
     * </p>
     */
    @Nullable
    public final Long startTime() {
        return this.startTime;
    }

    /**
     * The time field name.
     * <p>
     * API name: {@code time_field_name}
     * </p>
     */
    @Nullable
    public final String timeFieldName() {
        return this.timeFieldName;
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
        if (ApiTypeHelper.isDefined(this.aggregations)) {
            generator.writeKey("aggregations");
            generator.writeStartArray();
            for (Aggregation item0 : this.aggregations) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.attributeFieldNames)) {
            generator.writeKey("attribute_field_names");
            generator.writeStartArray();
            for (String item0 : this.attributeFieldNames) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.endTime != null) {
            generator.writeKey("end_time");
            generator.write(this.endTime);
        }

        if (this.indexName != null) {
            generator.writeKey("index_name");
            generator.write(this.indexName);
        }

        if (ApiTypeHelper.isDefined(this.inputData)) {
            generator.writeKey("input_data");
            generator.writeStartArray();
            for (Number item0 : this.inputData) {
                generator.write(item0.doubleValue());
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.metrics)) {
            generator.writeKey("metrics");
            generator.writeStartArray();
            for (List<Number> item0 : this.metrics) {
                generator.writeStartArray();
                for (Number item1 : item0) {
                    generator.write(item1.doubleValue());
                }
                generator.writeEnd();
            }
            generator.writeEnd();
        }

        if (this.minTimeInterval != null) {
            generator.writeKey("min_time_interval");
            generator.write(this.minTimeInterval);
        }

        if (this.numOutputs != null) {
            generator.writeKey("num_outputs");
            generator.write(this.numOutputs);
        }

        if (this.operation != null) {
            generator.writeKey("operation");
            generator.write(this.operation);
        }

        if (this.startTime != null) {
            generator.writeKey("start_time");
            generator.write(this.startTime);
        }

        if (this.timeFieldName != null) {
            generator.writeKey("time_field_name");
            generator.write(this.timeFieldName);
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
     * Builder for {@link ExecuteAlgorithmRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, ExecuteAlgorithmRequest> {
        @Nullable
        private List<Aggregation> aggregations;
        private String algorithmName;
        @Nullable
        private List<String> attributeFieldNames;
        @Nullable
        private Long endTime;
        @Nullable
        private String indexName;
        @Nullable
        private List<Number> inputData;
        @Nullable
        private List<List<Number>> metrics;
        @Nullable
        private Long minTimeInterval;
        @Nullable
        private Long numOutputs;
        @Nullable
        private String operation;
        @Nullable
        private Long startTime;
        @Nullable
        private String timeFieldName;

        public Builder() {}

        private Builder(ExecuteAlgorithmRequest o) {
            super(o);
            this.aggregations = _listCopy(o.aggregations);
            this.algorithmName = o.algorithmName;
            this.attributeFieldNames = _listCopy(o.attributeFieldNames);
            this.endTime = o.endTime;
            this.indexName = o.indexName;
            this.inputData = _listCopy(o.inputData);
            this.metrics = _listCopy(o.metrics);
            this.minTimeInterval = o.minTimeInterval;
            this.numOutputs = o.numOutputs;
            this.operation = o.operation;
            this.startTime = o.startTime;
            this.timeFieldName = o.timeFieldName;
        }

        private Builder(Builder o) {
            super(o);
            this.aggregations = _listCopy(o.aggregations);
            this.algorithmName = o.algorithmName;
            this.attributeFieldNames = _listCopy(o.attributeFieldNames);
            this.endTime = o.endTime;
            this.indexName = o.indexName;
            this.inputData = _listCopy(o.inputData);
            this.metrics = _listCopy(o.metrics);
            this.minTimeInterval = o.minTimeInterval;
            this.numOutputs = o.numOutputs;
            this.operation = o.operation;
            this.startTime = o.startTime;
            this.timeFieldName = o.timeFieldName;
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
         * API name: {@code aggregations}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>aggregations</code>.
         * </p>
         */
        @Nonnull
        public final Builder aggregations(List<Aggregation> list) {
            this.aggregations = _listAddAll(this.aggregations, list);
            return this;
        }

        /**
         * API name: {@code aggregations}
         *
         * <p>
         * Adds one or more values to <code>aggregations</code>.
         * </p>
         */
        @Nonnull
        public final Builder aggregations(Aggregation value, Aggregation... values) {
            this.aggregations = _listAdd(this.aggregations, value, values);
            return this;
        }

        /**
         * API name: {@code aggregations}
         *
         * <p>
         * Adds a value to <code>aggregations</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder aggregations(Function<Aggregation.Builder, ObjectBuilder<Aggregation>> fn) {
            return aggregations(fn.apply(new Aggregation.Builder()).build());
        }

        /**
         * Required - API name: {@code algorithm_name}
         */
        @Nonnull
        public final Builder algorithmName(String value) {
            this.algorithmName = value;
            return this;
        }

        /**
         * The attribute field names
         * <p>
         * API name: {@code attribute_field_names}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>attributeFieldNames</code>.
         * </p>
         */
        @Nonnull
        public final Builder attributeFieldNames(List<String> list) {
            this.attributeFieldNames = _listAddAll(this.attributeFieldNames, list);
            return this;
        }

        /**
         * The attribute field names
         * <p>
         * API name: {@code attribute_field_names}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>attributeFieldNames</code>.
         * </p>
         */
        @Nonnull
        public final Builder attributeFieldNames(String value, String... values) {
            this.attributeFieldNames = _listAdd(this.attributeFieldNames, value, values);
            return this;
        }

        /**
         * The end time.
         * <p>
         * API name: {@code end_time}
         * </p>
         */
        @Nonnull
        public final Builder endTime(@Nullable Long value) {
            this.endTime = value;
            return this;
        }

        /**
         * The index name.
         * <p>
         * API name: {@code index_name}
         * </p>
         */
        @Nonnull
        public final Builder indexName(@Nullable String value) {
            this.indexName = value;
            return this;
        }

        /**
         * The input data.
         * <p>
         * API name: {@code input_data}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>inputData</code>.
         * </p>
         */
        @Nonnull
        public final Builder inputData(List<Number> list) {
            this.inputData = _listAddAll(this.inputData, list);
            return this;
        }

        /**
         * The input data.
         * <p>
         * API name: {@code input_data}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>inputData</code>.
         * </p>
         */
        @Nonnull
        public final Builder inputData(Number value, Number... values) {
            this.inputData = _listAdd(this.inputData, value, values);
            return this;
        }

        /**
         * The metrics input.
         * <p>
         * API name: {@code metrics}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>metrics</code>.
         * </p>
         */
        @Nonnull
        public final Builder metrics(List<List<Number>> list) {
            this.metrics = _listAddAll(this.metrics, list);
            return this;
        }

        /**
         * The metrics input.
         * <p>
         * API name: {@code metrics}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>metrics</code>.
         * </p>
         */
        @Nonnull
        public final Builder metrics(List<Number> value, List<Number>... values) {
            this.metrics = _listAdd(this.metrics, value, values);
            return this;
        }

        /**
         * The minimum time interval.
         * <p>
         * API name: {@code min_time_interval}
         * </p>
         */
        @Nonnull
        public final Builder minTimeInterval(@Nullable Long value) {
            this.minTimeInterval = value;
            return this;
        }

        /**
         * The number of outputs.
         * <p>
         * API name: {@code num_outputs}
         * </p>
         */
        @Nonnull
        public final Builder numOutputs(@Nullable Long value) {
            this.numOutputs = value;
            return this;
        }

        /**
         * The calculator operation.
         * <p>
         * API name: {@code operation}
         * </p>
         */
        @Nonnull
        public final Builder operation(@Nullable String value) {
            this.operation = value;
            return this;
        }

        /**
         * The start time.
         * <p>
         * API name: {@code start_time}
         * </p>
         */
        @Nonnull
        public final Builder startTime(@Nullable Long value) {
            this.startTime = value;
            return this;
        }

        /**
         * The time field name.
         * <p>
         * API name: {@code time_field_name}
         * </p>
         */
        @Nonnull
        public final Builder timeFieldName(@Nullable String value) {
            this.timeFieldName = value;
            return this;
        }

        /**
         * Builds a {@link ExecuteAlgorithmRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ExecuteAlgorithmRequest build() {
            _checkSingleUse();

            return new ExecuteAlgorithmRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ExecuteAlgorithmRequest}
     */
    public static final JsonpDeserializer<ExecuteAlgorithmRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ExecuteAlgorithmRequest::setupExecuteAlgorithmRequestDeserializer
    );

    protected static void setupExecuteAlgorithmRequestDeserializer(ObjectDeserializer<ExecuteAlgorithmRequest.Builder> op) {
        op.add(Builder::aggregations, JsonpDeserializer.arrayDeserializer(Aggregation._DESERIALIZER), "aggregations");
        op.add(
            Builder::attributeFieldNames,
            JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()),
            "attribute_field_names"
        );
        op.add(Builder::endTime, JsonpDeserializer.longDeserializer(), "end_time");
        op.add(Builder::indexName, JsonpDeserializer.stringDeserializer(), "index_name");
        op.add(Builder::inputData, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.numberDeserializer()), "input_data");
        op.add(
            Builder::metrics,
            JsonpDeserializer.arrayDeserializer(JsonpDeserializer.arrayDeserializer(JsonpDeserializer.numberDeserializer())),
            "metrics"
        );
        op.add(Builder::minTimeInterval, JsonpDeserializer.longDeserializer(), "min_time_interval");
        op.add(Builder::numOutputs, JsonpDeserializer.longDeserializer(), "num_outputs");
        op.add(Builder::operation, JsonpDeserializer.stringDeserializer(), "operation");
        op.add(Builder::startTime, JsonpDeserializer.longDeserializer(), "start_time");
        op.add(Builder::timeFieldName, JsonpDeserializer.stringDeserializer(), "time_field_name");
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code ml.execute_algorithm}".
     */
    public static final Endpoint<ExecuteAlgorithmRequest, ExecuteAlgorithmResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "POST",
        // Request path
        request -> {
            StringBuilder buf = new StringBuilder();
            buf.append("/_plugins/_ml/_execute/");
            SimpleEndpoint.pathEncode(request.algorithmName, buf);
            return buf.toString();
        },
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap(),
        true,
        ExecuteAlgorithmResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.aggregations);
        result = 31 * result + this.algorithmName.hashCode();
        result = 31 * result + Objects.hashCode(this.attributeFieldNames);
        result = 31 * result + Objects.hashCode(this.endTime);
        result = 31 * result + Objects.hashCode(this.indexName);
        result = 31 * result + Objects.hashCode(this.inputData);
        result = 31 * result + Objects.hashCode(this.metrics);
        result = 31 * result + Objects.hashCode(this.minTimeInterval);
        result = 31 * result + Objects.hashCode(this.numOutputs);
        result = 31 * result + Objects.hashCode(this.operation);
        result = 31 * result + Objects.hashCode(this.startTime);
        result = 31 * result + Objects.hashCode(this.timeFieldName);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ExecuteAlgorithmRequest other = (ExecuteAlgorithmRequest) o;
        return Objects.equals(this.aggregations, other.aggregations)
            && this.algorithmName.equals(other.algorithmName)
            && Objects.equals(this.attributeFieldNames, other.attributeFieldNames)
            && Objects.equals(this.endTime, other.endTime)
            && Objects.equals(this.indexName, other.indexName)
            && Objects.equals(this.inputData, other.inputData)
            && Objects.equals(this.metrics, other.metrics)
            && Objects.equals(this.minTimeInterval, other.minTimeInterval)
            && Objects.equals(this.numOutputs, other.numOutputs)
            && Objects.equals(this.operation, other.operation)
            && Objects.equals(this.startTime, other.startTime)
            && Objects.equals(this.timeFieldName, other.timeFieldName);
    }
}
