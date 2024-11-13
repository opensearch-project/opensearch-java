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

package org.opensearch.client.opensearch.indices;

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

// typedef: indices.IndexSettingsSearchConcurrent

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IndexSettingsSearchConcurrent
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<IndexSettingsSearchConcurrent.Builder, IndexSettingsSearchConcurrent> {

    @Nullable
    private final Integer maxSliceCount;

    // ---------------------------------------------------------------------------------------------

    private IndexSettingsSearchConcurrent(Builder builder) {
        this.maxSliceCount = builder.maxSliceCount;
    }

    public static IndexSettingsSearchConcurrent of(
        Function<IndexSettingsSearchConcurrent.Builder, ObjectBuilder<IndexSettingsSearchConcurrent>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code max_slice_count}
     */
    @Nullable
    public final Integer maxSliceCount() {
        return this.maxSliceCount;
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
        if (this.maxSliceCount != null) {
            generator.writeKey("max_slice_count");
            generator.write(this.maxSliceCount);
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
     * Builder for {@link IndexSettingsSearchConcurrent}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IndexSettingsSearchConcurrent> {
        @Nullable
        private Integer maxSliceCount;

        public Builder() {}

        private Builder(IndexSettingsSearchConcurrent o) {
            this.maxSliceCount = o.maxSliceCount;
        }

        private Builder(Builder o) {
            this.maxSliceCount = o.maxSliceCount;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code max_slice_count}
         */
        @Nonnull
        public final Builder maxSliceCount(@Nullable Integer value) {
            this.maxSliceCount = value;
            return this;
        }

        /**
         * Builds a {@link IndexSettingsSearchConcurrent}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IndexSettingsSearchConcurrent build() {
            _checkSingleUse();

            return new IndexSettingsSearchConcurrent(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IndexSettingsSearchConcurrent}
     */
    public static final JsonpDeserializer<IndexSettingsSearchConcurrent> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IndexSettingsSearchConcurrent::setupIndexSettingsSearchConcurrentDeserializer
    );

    protected static void setupIndexSettingsSearchConcurrentDeserializer(ObjectDeserializer<IndexSettingsSearchConcurrent.Builder> op) {
        op.add(Builder::maxSliceCount, JsonpDeserializer.integerDeserializer(), "max_slice_count");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.maxSliceCount);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IndexSettingsSearchConcurrent other = (IndexSettingsSearchConcurrent) o;
        return Objects.equals(this.maxSliceCount, other.maxSliceCount);
    }
}
