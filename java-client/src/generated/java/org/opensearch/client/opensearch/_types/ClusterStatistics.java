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
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
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

// typedef: _types.ClusterStatistics

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ClusterStatistics implements PlainJsonSerializable, ToCopyableBuilder<ClusterStatistics.Builder, ClusterStatistics> {

    private final int skipped;

    private final int successful;

    private final int total;

    // ---------------------------------------------------------------------------------------------

    private ClusterStatistics(Builder builder) {
        this.skipped = ApiTypeHelper.requireNonNull(builder.skipped, this, "skipped");
        this.successful = ApiTypeHelper.requireNonNull(builder.successful, this, "successful");
        this.total = ApiTypeHelper.requireNonNull(builder.total, this, "total");
    }

    public static ClusterStatistics of(Function<ClusterStatistics.Builder, ObjectBuilder<ClusterStatistics>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code skipped}
     */
    public final int skipped() {
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
        generator.writeKey("skipped");
        generator.write(this.skipped);

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
     * Builder for {@link ClusterStatistics}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ClusterStatistics> {
        private Integer skipped;
        private Integer successful;
        private Integer total;

        public Builder() {}

        private Builder(ClusterStatistics o) {
            this.skipped = o.skipped;
            this.successful = o.successful;
            this.total = o.total;
        }

        private Builder(Builder o) {
            this.skipped = o.skipped;
            this.successful = o.successful;
            this.total = o.total;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code skipped}
         */
        @Nonnull
        public final Builder skipped(int value) {
            this.skipped = value;
            return this;
        }

        /**
         * Required - API name: {@code successful}
         */
        @Nonnull
        public final Builder successful(int value) {
            this.successful = value;
            return this;
        }

        /**
         * Required - API name: {@code total}
         */
        @Nonnull
        public final Builder total(int value) {
            this.total = value;
            return this;
        }

        /**
         * Builds a {@link ClusterStatistics}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ClusterStatistics build() {
            _checkSingleUse();

            return new ClusterStatistics(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ClusterStatistics}
     */
    public static final JsonpDeserializer<ClusterStatistics> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ClusterStatistics::setupClusterStatisticsDeserializer
    );

    protected static void setupClusterStatisticsDeserializer(ObjectDeserializer<ClusterStatistics.Builder> op) {
        op.add(Builder::skipped, JsonpDeserializer.integerDeserializer(), "skipped");
        op.add(Builder::successful, JsonpDeserializer.integerDeserializer(), "successful");
        op.add(Builder::total, JsonpDeserializer.integerDeserializer(), "total");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Integer.hashCode(this.skipped);
        result = 31 * result + Integer.hashCode(this.successful);
        result = 31 * result + Integer.hashCode(this.total);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ClusterStatistics other = (ClusterStatistics) o;
        return this.skipped == other.skipped && this.successful == other.successful && this.total == other.total;
    }
}
