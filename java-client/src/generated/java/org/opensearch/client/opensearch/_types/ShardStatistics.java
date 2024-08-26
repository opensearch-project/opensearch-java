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

// typedef: _types.ShardStatistics

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ShardStatistics implements PlainJsonSerializable {

    private final int failed;

    private final List<ShardFailure> failures;

    @Nullable
    private final Integer skipped;

    private final int successful;

    private final int total;

    // ---------------------------------------------------------------------------------------------

    private ShardStatistics(Builder builder) {
        this.failed = ApiTypeHelper.requireNonNull(builder.failed, this, "failed");
        this.failures = ApiTypeHelper.unmodifiable(builder.failures);
        this.skipped = builder.skipped;
        this.successful = ApiTypeHelper.requireNonNull(builder.successful, this, "successful");
        this.total = ApiTypeHelper.requireNonNull(builder.total, this, "total");
    }

    public static ShardStatistics of(Function<ShardStatistics.Builder, ObjectBuilder<ShardStatistics>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code failed}
     */
    public final int failed() {
        return this.failed;
    }

    /**
     * API name: {@code failures}
     */
    public final List<ShardFailure> failures() {
        return this.failures;
    }

    /**
     * API name: {@code skipped}
     */
    @Nullable
    public final Integer skipped() {
        return this.skipped;
    }

    /**
     * Required - API name: {@code successful}
     */
    public final int successful() {
        return this.successful;
    }

    /**
     * Required - API name: {@code total}
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
            for (ShardFailure item0 : this.failures) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.skipped != null) {
            generator.writeKey("skipped");
            generator.write(this.skipped);
        }

        generator.writeKey("successful");
        generator.write(this.successful);

        generator.writeKey("total");
        generator.write(this.total);
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link ShardStatistics}.
     */
    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<ShardStatistics> {
        private Integer failed;
        @Nullable
        private List<ShardFailure> failures;
        @Nullable
        private Integer skipped;
        private Integer successful;
        private Integer total;

        /**
         * Required - API name: {@code failed}
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
        public final Builder failures(List<ShardFailure> list) {
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
        public final Builder failures(ShardFailure value, ShardFailure... values) {
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
        public final Builder failures(Function<ShardFailure.Builder, ObjectBuilder<ShardFailure>> fn) {
            return failures(fn.apply(new ShardFailure.Builder()).build());
        }

        /**
         * API name: {@code skipped}
         */
        public final Builder skipped(@Nullable Integer value) {
            this.skipped = value;
            return this;
        }

        /**
         * Required - API name: {@code successful}
         */
        public final Builder successful(int value) {
            this.successful = value;
            return this;
        }

        /**
         * Required - API name: {@code total}
         */
        public final Builder total(int value) {
            this.total = value;
            return this;
        }

        /**
         * Builds a {@link ShardStatistics}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public ShardStatistics build() {
            _checkSingleUse();

            return new ShardStatistics(this);
        }
    }
    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ShardStatistics}
     */
    public static final JsonpDeserializer<ShardStatistics> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ShardStatistics::setupShardStatisticsDeserializer
    );

    protected static void setupShardStatisticsDeserializer(ObjectDeserializer<ShardStatistics.Builder> op) {
        op.add(Builder::failed, JsonpDeserializer.integerDeserializer(), "failed");
        op.add(Builder::failures, JsonpDeserializer.arrayDeserializer(ShardFailure._DESERIALIZER), "failures");
        op.add(Builder::skipped, JsonpDeserializer.integerDeserializer(), "skipped");
        op.add(Builder::successful, JsonpDeserializer.integerDeserializer(), "successful");
        op.add(Builder::total, JsonpDeserializer.integerDeserializer(), "total");
    }
}
