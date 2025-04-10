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

// typedef: cluster.stats.ClusterOperatingSystemPrettyName

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ClusterOperatingSystemPrettyName
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ClusterOperatingSystemPrettyName.Builder, ClusterOperatingSystemPrettyName> {

    private final int count;

    @Nullable
    private final String prettyName;

    // ---------------------------------------------------------------------------------------------

    private ClusterOperatingSystemPrettyName(Builder builder) {
        this.count = ApiTypeHelper.requireNonNull(builder.count, this, "count");
        this.prettyName = builder.prettyName;
    }

    public static ClusterOperatingSystemPrettyName of(
        Function<ClusterOperatingSystemPrettyName.Builder, ObjectBuilder<ClusterOperatingSystemPrettyName>> fn
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
     * API name: {@code pretty_name}
     */
    @Nullable
    public final String prettyName() {
        return this.prettyName;
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

        if (this.prettyName != null) {
            generator.writeKey("pretty_name");
            generator.write(this.prettyName);
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
     * Builder for {@link ClusterOperatingSystemPrettyName}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ClusterOperatingSystemPrettyName> {
        private Integer count;
        @Nullable
        private String prettyName;

        public Builder() {}

        private Builder(ClusterOperatingSystemPrettyName o) {
            this.count = o.count;
            this.prettyName = o.prettyName;
        }

        private Builder(Builder o) {
            this.count = o.count;
            this.prettyName = o.prettyName;
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
         * API name: {@code pretty_name}
         */
        @Nonnull
        public final Builder prettyName(@Nullable String value) {
            this.prettyName = value;
            return this;
        }

        /**
         * Builds a {@link ClusterOperatingSystemPrettyName}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ClusterOperatingSystemPrettyName build() {
            _checkSingleUse();

            return new ClusterOperatingSystemPrettyName(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ClusterOperatingSystemPrettyName}
     */
    public static final JsonpDeserializer<ClusterOperatingSystemPrettyName> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ClusterOperatingSystemPrettyName::setupClusterOperatingSystemPrettyNameDeserializer
    );

    protected static void setupClusterOperatingSystemPrettyNameDeserializer(
        ObjectDeserializer<ClusterOperatingSystemPrettyName.Builder> op
    ) {
        op.add(Builder::count, JsonpDeserializer.integerDeserializer(), "count");
        op.add(Builder::prettyName, JsonpDeserializer.stringDeserializer(), "pretty_name");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Integer.hashCode(this.count);
        result = 31 * result + Objects.hashCode(this.prettyName);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ClusterOperatingSystemPrettyName other = (ClusterOperatingSystemPrettyName) o;
        return this.count == other.count && Objects.equals(this.prettyName, other.prettyName);
    }
}
