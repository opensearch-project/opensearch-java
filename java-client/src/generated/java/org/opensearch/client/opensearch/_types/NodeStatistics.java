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

// typedef: _types.NodeStatistics

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NodeStatistics implements PlainJsonSerializable {

    private final int failed;

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
     * Required - Number of nodes that rejected the request or failed to respond. If this value is not 0, a reason for the rejection or
     * failure is included in the response.
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
    public final List<ErrorCause> failures() {
        return this.failures;
    }

    /**
     * Required - Number of nodes that responded successfully to the request.
     * <p>
     * API name: {@code successful}
     * </p>
     */
    public final int successful() {
        return this.successful;
    }

    /**
     * Required - Total number of nodes selected by the request.
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

    /**
     * Builder for {@link NodeStatistics}.
     */
    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<NodeStatistics> {
        private Integer failed;
        @Nullable
        private List<ErrorCause> failures;
        private Integer successful;
        private Integer total;

        /**
         * Required - Number of nodes that rejected the request or failed to respond. If this value is not 0, a reason for the rejection or
         * failure is included in the response.
         * <p>
         * API name: {@code failed}
         * </p>
         */
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
        public final Builder failures(Function<ErrorCause.Builder, ObjectBuilder<ErrorCause>> fn) {
            return failures(fn.apply(new ErrorCause.Builder()).build());
        }

        /**
         * Required - Number of nodes that responded successfully to the request.
         * <p>
         * API name: {@code successful}
         * </p>
         */
        public final Builder successful(int value) {
            this.successful = value;
            return this;
        }

        /**
         * Required - Total number of nodes selected by the request.
         * <p>
         * API name: {@code total}
         * </p>
         */
        public final Builder total(int value) {
            this.total = value;
            return this;
        }

        /**
         * Builds a {@link NodeStatistics}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
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

    public int hashCode() {
        return Objects.hash(this.failed, this.failures, this.successful, this.total);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (this.getClass() != o.getClass()) return false;
        NodeStatistics other = (NodeStatistics) o;
        if (!this.failed().equals(other.failed())) {
            return false;
        }
        if (!this.failures().equals(other.failures())) {
            return false;
        }
        if (!this.successful().equals(other.successful())) {
            return false;
        }
        if (!this.total().equals(other.total())) {
            return false;
        }
        return true;
    }
}
