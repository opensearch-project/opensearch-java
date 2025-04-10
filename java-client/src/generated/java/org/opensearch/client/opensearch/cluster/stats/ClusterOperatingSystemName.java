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

package org.opensearch.client.opensearch.cluster.stats;

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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: cluster.stats.ClusterOperatingSystemName

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ClusterOperatingSystemName
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ClusterOperatingSystemName.Builder, ClusterOperatingSystemName> {

    private final int count;

    @Nullable
    private final String name;

    // ---------------------------------------------------------------------------------------------

    private ClusterOperatingSystemName(Builder builder) {
        this.count = ApiTypeHelper.requireNonNull(builder.count, this, "count");
        this.name = builder.name;
    }

    public static ClusterOperatingSystemName of(
        Function<ClusterOperatingSystemName.Builder, ObjectBuilder<ClusterOperatingSystemName>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - Number of selected nodes using the operating system.
     * <p>
     * API name: {@code count}
     * </p>
     */
    public final int count() {
        return this.count;
    }

    /**
     * API name: {@code name}
     */
    @Nullable
    public final String name() {
        return this.name;
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
        generator.writeKey("count");
        generator.write(this.count);

        if (this.name != null) {
            generator.writeKey("name");
            generator.write(this.name);
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
     * Builder for {@link ClusterOperatingSystemName}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ClusterOperatingSystemName> {
        private Integer count;
        @Nullable
        private String name;

        public Builder() {}

        private Builder(ClusterOperatingSystemName o) {
            this.count = o.count;
            this.name = o.name;
        }

        private Builder(Builder o) {
            this.count = o.count;
            this.name = o.name;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - Number of selected nodes using the operating system.
         * <p>
         * API name: {@code count}
         * </p>
         */
        @Nonnull
        public final Builder count(int value) {
            this.count = value;
            return this;
        }

        /**
         * API name: {@code name}
         */
        @Nonnull
        public final Builder name(@Nullable String value) {
            this.name = value;
            return this;
        }

        /**
         * Builds a {@link ClusterOperatingSystemName}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ClusterOperatingSystemName build() {
            _checkSingleUse();

            return new ClusterOperatingSystemName(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ClusterOperatingSystemName}
     */
    public static final JsonpDeserializer<ClusterOperatingSystemName> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ClusterOperatingSystemName::setupClusterOperatingSystemNameDeserializer
    );

    protected static void setupClusterOperatingSystemNameDeserializer(ObjectDeserializer<ClusterOperatingSystemName.Builder> op) {
        op.add(Builder::count, JsonpDeserializer.integerDeserializer(), "count");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Integer.hashCode(this.count);
        result = 31 * result + Objects.hashCode(this.name);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ClusterOperatingSystemName other = (ClusterOperatingSystemName) o;
        return this.count == other.count && Objects.equals(this.name, other.name);
    }
}
