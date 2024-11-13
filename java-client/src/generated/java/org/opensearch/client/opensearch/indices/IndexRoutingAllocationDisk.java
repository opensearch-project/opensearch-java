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

// typedef: indices.IndexRoutingAllocationDisk

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IndexRoutingAllocationDisk
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<IndexRoutingAllocationDisk.Builder, IndexRoutingAllocationDisk> {

    @Nullable
    private final Boolean thresholdEnabled;

    // ---------------------------------------------------------------------------------------------

    private IndexRoutingAllocationDisk(Builder builder) {
        this.thresholdEnabled = builder.thresholdEnabled;
    }

    public static IndexRoutingAllocationDisk of(
        Function<IndexRoutingAllocationDisk.Builder, ObjectBuilder<IndexRoutingAllocationDisk>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code threshold_enabled}
     */
    @Nullable
    public final Boolean thresholdEnabled() {
        return this.thresholdEnabled;
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
        if (this.thresholdEnabled != null) {
            generator.writeKey("threshold_enabled");
            generator.write(this.thresholdEnabled);
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
     * Builder for {@link IndexRoutingAllocationDisk}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IndexRoutingAllocationDisk> {
        @Nullable
        private Boolean thresholdEnabled;

        public Builder() {}

        private Builder(IndexRoutingAllocationDisk o) {
            this.thresholdEnabled = o.thresholdEnabled;
        }

        private Builder(Builder o) {
            this.thresholdEnabled = o.thresholdEnabled;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code threshold_enabled}
         */
        @Nonnull
        public final Builder thresholdEnabled(@Nullable Boolean value) {
            this.thresholdEnabled = value;
            return this;
        }

        /**
         * Builds a {@link IndexRoutingAllocationDisk}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IndexRoutingAllocationDisk build() {
            _checkSingleUse();

            return new IndexRoutingAllocationDisk(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IndexRoutingAllocationDisk}
     */
    public static final JsonpDeserializer<IndexRoutingAllocationDisk> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IndexRoutingAllocationDisk::setupIndexRoutingAllocationDiskDeserializer
    );

    protected static void setupIndexRoutingAllocationDiskDeserializer(ObjectDeserializer<IndexRoutingAllocationDisk.Builder> op) {
        op.add(Builder::thresholdEnabled, JsonpDeserializer.booleanDeserializer(), "threshold_enabled");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.thresholdEnabled);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IndexRoutingAllocationDisk other = (IndexRoutingAllocationDisk) o;
        return Objects.equals(this.thresholdEnabled, other.thresholdEnabled);
    }
}
