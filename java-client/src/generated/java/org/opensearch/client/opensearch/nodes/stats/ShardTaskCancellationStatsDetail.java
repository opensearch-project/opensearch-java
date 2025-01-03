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

package org.opensearch.client.opensearch.nodes.stats;

import jakarta.json.stream.JsonGenerator;
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
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: nodes.stats.ShardTaskCancellationStatsDetail

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ShardTaskCancellationStatsDetail
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ShardTaskCancellationStatsDetail.Builder, ShardTaskCancellationStatsDetail> {

    @Nullable
    private final Long currentCountPostCancel;

    @Nullable
    private final Long totalCountPostCancel;

    // ---------------------------------------------------------------------------------------------

    private ShardTaskCancellationStatsDetail(Builder builder) {
        this.currentCountPostCancel = builder.currentCountPostCancel;
        this.totalCountPostCancel = builder.totalCountPostCancel;
    }

    public static ShardTaskCancellationStatsDetail of(
        Function<ShardTaskCancellationStatsDetail.Builder, ObjectBuilder<ShardTaskCancellationStatsDetail>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code current_count_post_cancel}
     */
    @Nullable
    public final Long currentCountPostCancel() {
        return this.currentCountPostCancel;
    }

    /**
     * API name: {@code total_count_post_cancel}
     */
    @Nullable
    public final Long totalCountPostCancel() {
        return this.totalCountPostCancel;
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
        if (this.currentCountPostCancel != null) {
            generator.writeKey("current_count_post_cancel");
            generator.write(this.currentCountPostCancel);
        }

        if (this.totalCountPostCancel != null) {
            generator.writeKey("total_count_post_cancel");
            generator.write(this.totalCountPostCancel);
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
     * Builder for {@link ShardTaskCancellationStatsDetail}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ShardTaskCancellationStatsDetail> {
        @Nullable
        private Long currentCountPostCancel;
        @Nullable
        private Long totalCountPostCancel;

        public Builder() {}

        private Builder(ShardTaskCancellationStatsDetail o) {
            this.currentCountPostCancel = o.currentCountPostCancel;
            this.totalCountPostCancel = o.totalCountPostCancel;
        }

        private Builder(Builder o) {
            this.currentCountPostCancel = o.currentCountPostCancel;
            this.totalCountPostCancel = o.totalCountPostCancel;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code current_count_post_cancel}
         */
        @Nonnull
        public final Builder currentCountPostCancel(@Nullable Long value) {
            this.currentCountPostCancel = value;
            return this;
        }

        /**
         * API name: {@code total_count_post_cancel}
         */
        @Nonnull
        public final Builder totalCountPostCancel(@Nullable Long value) {
            this.totalCountPostCancel = value;
            return this;
        }

        /**
         * Builds a {@link ShardTaskCancellationStatsDetail}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ShardTaskCancellationStatsDetail build() {
            _checkSingleUse();

            return new ShardTaskCancellationStatsDetail(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ShardTaskCancellationStatsDetail}
     */
    public static final JsonpDeserializer<ShardTaskCancellationStatsDetail> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ShardTaskCancellationStatsDetail::setupShardTaskCancellationStatsDetailDeserializer
    );

    protected static void setupShardTaskCancellationStatsDetailDeserializer(
        ObjectDeserializer<ShardTaskCancellationStatsDetail.Builder> op
    ) {
        op.add(Builder::currentCountPostCancel, JsonpDeserializer.longDeserializer(), "current_count_post_cancel");
        op.add(Builder::totalCountPostCancel, JsonpDeserializer.longDeserializer(), "total_count_post_cancel");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.currentCountPostCancel);
        result = 31 * result + Objects.hashCode(this.totalCountPostCancel);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ShardTaskCancellationStatsDetail other = (ShardTaskCancellationStatsDetail) o;
        return Objects.equals(this.currentCountPostCancel, other.currentCountPostCancel)
            && Objects.equals(this.totalCountPostCancel, other.totalCountPostCancel);
    }
}
