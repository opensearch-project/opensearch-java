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
import java.util.List;
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

// typedef: _types.NodeStatistics

/**
 * The statistics about node operations.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NodeStatistics implements PlainJsonSerializable, ToCopyableBuilder<NodeStatistics.Builder, NodeStatistics> {

    private final int failed;

    @Nonnull
    private final List<ErrorCause> failures;

    private final int successful;

    private final int total;

    // ---------------------------------------------------------------------------------------------

    private NodeStatistics(Builder builder) {
        this.failed = ApiTypeHelper.requireNonNull(builder.failed, this, "failed");
        this.failures = ApiTypeHelper.unmodifiable(builder.failures);
        this.successful = ApiTypeHelper.requireNonNull(builder.successful, this, "successful");
        this.total = ApiTypeHelper.requireNonNull(builder.total, this, "total");
    }

    public static NodeStatistics of(Function<NodeStatistics.Builder, ObjectBuilder<NodeStatistics>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The number of nodes that rejected the request or failed to respond. If this value is not 0, then a reason for the
     * rejection or failure is included in the response.
     * <p>
     * API name: {@code failed}
     * </p>
     */
    public final int failed() {
        return this.failed;
    }

    /**
     * API name: {@code failures}
     */
    @Nonnull
    public final List<ErrorCause> failures() {
        return this.failures;
    }

    /**
     * Required - The number of nodes that responded successfully to the request.
     * <p>
     * API name: {@code successful}
     * </p>
     */
    public final int successful() {
        return this.successful;
    }

    /**
     * Required - The total number of nodes selected by the request.
     * <p>
     * API name: {@code total}
     * </p>
     */
    public final int total() {
        return this.total;
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
        generator.writeKey("failed");
        generator.write(this.failed);

        if (ApiTypeHelper.isDefined(this.failures)) {
            generator.writeKey("failures");
            generator.writeStartArray();
            for (ErrorCause item0 : this.failures) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        generator.writeKey("successful");
        generator.write(this.successful);

        generator.writeKey("total");
        generator.write(this.total);
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
     * Builder for {@link NodeStatistics}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, NodeStatistics> {
        private Integer failed;
        @Nullable
        private List<ErrorCause> failures;
        private Integer successful;
        private Integer total;

        public Builder() {}

        private Builder(NodeStatistics o) {
            this.failed = o.failed;
            this.failures = _listCopy(o.failures);
            this.successful = o.successful;
            this.total = o.total;
        }

        private Builder(Builder o) {
            this.failed = o.failed;
            this.failures = _listCopy(o.failures);
            this.successful = o.successful;
            this.total = o.total;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - The number of nodes that rejected the request or failed to respond. If this value is not 0, then a reason for the
         * rejection or failure is included in the response.
         * <p>
         * API name: {@code failed}
         * </p>
         */
        @Nonnull
        public final Builder failed(int value) {
            this.failed = value;
            return this;
        }

        /**
         * API name: {@code failures}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>failures</code>.
         * </p>
         */
        @Nonnull
        public final Builder failures(List<ErrorCause> list) {
            this.failures = _listAddAll(this.failures, list);
            return this;
        }

        /**
         * API name: {@code failures}
         *
         * <p>
         * Adds one or more values to <code>failures</code>.
         * </p>
         */
        @Nonnull
        public final Builder failures(ErrorCause value, ErrorCause... values) {
            this.failures = _listAdd(this.failures, value, values);
            return this;
        }

        /**
         * API name: {@code failures}
         *
         * <p>
         * Adds a value to <code>failures</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder failures(Function<ErrorCause.Builder, ObjectBuilder<ErrorCause>> fn) {
            return failures(fn.apply(new ErrorCause.Builder()).build());
        }

        /**
         * Required - The number of nodes that responded successfully to the request.
         * <p>
         * API name: {@code successful}
         * </p>
         */
        @Nonnull
        public final Builder successful(int value) {
            this.successful = value;
            return this;
        }

        /**
         * Required - The total number of nodes selected by the request.
         * <p>
         * API name: {@code total}
         * </p>
         */
        @Nonnull
        public final Builder total(int value) {
            this.total = value;
            return this;
        }

        /**
         * Builds a {@link NodeStatistics}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NodeStatistics build() {
            _checkSingleUse();

            return new NodeStatistics(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NodeStatistics}
     */
    public static final JsonpDeserializer<NodeStatistics> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NodeStatistics::setupNodeStatisticsDeserializer
    );

    protected static void setupNodeStatisticsDeserializer(ObjectDeserializer<NodeStatistics.Builder> op) {
        op.add(Builder::failed, JsonpDeserializer.integerDeserializer(), "failed");
        op.add(Builder::failures, JsonpDeserializer.arrayDeserializer(ErrorCause._DESERIALIZER), "failures");
        op.add(Builder::successful, JsonpDeserializer.integerDeserializer(), "successful");
        op.add(Builder::total, JsonpDeserializer.integerDeserializer(), "total");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Integer.hashCode(this.failed);
        result = 31 * result + Objects.hashCode(this.failures);
        result = 31 * result + Integer.hashCode(this.successful);
        result = 31 * result + Integer.hashCode(this.total);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NodeStatistics other = (NodeStatistics) o;
        return this.failed == other.failed
            && Objects.equals(this.failures, other.failures)
            && this.successful == other.successful
            && this.total == other.total;
    }
}
