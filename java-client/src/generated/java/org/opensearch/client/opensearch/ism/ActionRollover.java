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

package org.opensearch.client.opensearch.ism;

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

// typedef: ism.ActionRollover

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ActionRollover implements PlainJsonSerializable, ToCopyableBuilder<ActionRollover.Builder, ActionRollover> {

    @Nullable
    private final Boolean copyAlias;

    @Nullable
    private final Number minDocCount;

    @Nullable
    private final String minIndexAge;

    @Nullable
    private final String minPrimaryShardSize;

    @Nullable
    private final String minSize;

    // ---------------------------------------------------------------------------------------------

    private ActionRollover(Builder builder) {
        this.copyAlias = builder.copyAlias;
        this.minDocCount = builder.minDocCount;
        this.minIndexAge = builder.minIndexAge;
        this.minPrimaryShardSize = builder.minPrimaryShardSize;
        this.minSize = builder.minSize;
    }

    public static ActionRollover of(Function<ActionRollover.Builder, ObjectBuilder<ActionRollover>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Whether to copy the alias to the new index.
     * <p>
     * API name: {@code copy_alias}
     * </p>
     */
    @Nullable
    public final Boolean copyAlias() {
        return this.copyAlias;
    }

    /**
     * The minimum document count to trigger rollover.
     * <p>
     * API name: {@code min_doc_count}
     * </p>
     */
    @Nullable
    public final Number minDocCount() {
        return this.minDocCount;
    }

    /**
     * The minimum index age to trigger rollover.
     * <p>
     * API name: {@code min_index_age}
     * </p>
     */
    @Nullable
    public final String minIndexAge() {
        return this.minIndexAge;
    }

    /**
     * The minimum primary shard size to trigger rollover.
     * <p>
     * API name: {@code min_primary_shard_size}
     * </p>
     */
    @Nullable
    public final String minPrimaryShardSize() {
        return this.minPrimaryShardSize;
    }

    /**
     * The minimum size to trigger rollover.
     * <p>
     * API name: {@code min_size}
     * </p>
     */
    @Nullable
    public final String minSize() {
        return this.minSize;
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
        if (this.copyAlias != null) {
            generator.writeKey("copy_alias");
            generator.write(this.copyAlias);
        }

        if (this.minDocCount != null) {
            generator.writeKey("min_doc_count");
            generator.write(this.minDocCount.doubleValue());
        }

        if (this.minIndexAge != null) {
            generator.writeKey("min_index_age");
            generator.write(this.minIndexAge);
        }

        if (this.minPrimaryShardSize != null) {
            generator.writeKey("min_primary_shard_size");
            generator.write(this.minPrimaryShardSize);
        }

        if (this.minSize != null) {
            generator.writeKey("min_size");
            generator.write(this.minSize);
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
     * Builder for {@link ActionRollover}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ActionRollover> {
        @Nullable
        private Boolean copyAlias;
        @Nullable
        private Number minDocCount;
        @Nullable
        private String minIndexAge;
        @Nullable
        private String minPrimaryShardSize;
        @Nullable
        private String minSize;

        public Builder() {}

        private Builder(ActionRollover o) {
            this.copyAlias = o.copyAlias;
            this.minDocCount = o.minDocCount;
            this.minIndexAge = o.minIndexAge;
            this.minPrimaryShardSize = o.minPrimaryShardSize;
            this.minSize = o.minSize;
        }

        private Builder(Builder o) {
            this.copyAlias = o.copyAlias;
            this.minDocCount = o.minDocCount;
            this.minIndexAge = o.minIndexAge;
            this.minPrimaryShardSize = o.minPrimaryShardSize;
            this.minSize = o.minSize;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Whether to copy the alias to the new index.
         * <p>
         * API name: {@code copy_alias}
         * </p>
         */
        @Nonnull
        public final Builder copyAlias(@Nullable Boolean value) {
            this.copyAlias = value;
            return this;
        }

        /**
         * The minimum document count to trigger rollover.
         * <p>
         * API name: {@code min_doc_count}
         * </p>
         */
        @Nonnull
        public final Builder minDocCount(@Nullable Number value) {
            this.minDocCount = value;
            return this;
        }

        /**
         * The minimum index age to trigger rollover.
         * <p>
         * API name: {@code min_index_age}
         * </p>
         */
        @Nonnull
        public final Builder minIndexAge(@Nullable String value) {
            this.minIndexAge = value;
            return this;
        }

        /**
         * The minimum primary shard size to trigger rollover.
         * <p>
         * API name: {@code min_primary_shard_size}
         * </p>
         */
        @Nonnull
        public final Builder minPrimaryShardSize(@Nullable String value) {
            this.minPrimaryShardSize = value;
            return this;
        }

        /**
         * The minimum size to trigger rollover.
         * <p>
         * API name: {@code min_size}
         * </p>
         */
        @Nonnull
        public final Builder minSize(@Nullable String value) {
            this.minSize = value;
            return this;
        }

        /**
         * Builds a {@link ActionRollover}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ActionRollover build() {
            _checkSingleUse();

            return new ActionRollover(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ActionRollover}
     */
    public static final JsonpDeserializer<ActionRollover> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ActionRollover::setupActionRolloverDeserializer
    );

    protected static void setupActionRolloverDeserializer(ObjectDeserializer<ActionRollover.Builder> op) {
        op.add(Builder::copyAlias, JsonpDeserializer.booleanDeserializer(), "copy_alias");
        op.add(Builder::minDocCount, JsonpDeserializer.numberDeserializer(), "min_doc_count");
        op.add(Builder::minIndexAge, JsonpDeserializer.stringDeserializer(), "min_index_age");
        op.add(Builder::minPrimaryShardSize, JsonpDeserializer.stringDeserializer(), "min_primary_shard_size");
        op.add(Builder::minSize, JsonpDeserializer.stringDeserializer(), "min_size");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.copyAlias);
        result = 31 * result + Objects.hashCode(this.minDocCount);
        result = 31 * result + Objects.hashCode(this.minIndexAge);
        result = 31 * result + Objects.hashCode(this.minPrimaryShardSize);
        result = 31 * result + Objects.hashCode(this.minSize);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ActionRollover other = (ActionRollover) o;
        return Objects.equals(this.copyAlias, other.copyAlias)
            && Objects.equals(this.minDocCount, other.minDocCount)
            && Objects.equals(this.minIndexAge, other.minIndexAge)
            && Objects.equals(this.minPrimaryShardSize, other.minPrimaryShardSize)
            && Objects.equals(this.minSize, other.minSize);
    }
}
