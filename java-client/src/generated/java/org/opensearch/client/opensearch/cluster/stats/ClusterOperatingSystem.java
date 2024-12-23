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

// typedef: cluster.stats.ClusterOperatingSystem

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ClusterOperatingSystem
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ClusterOperatingSystem.Builder, ClusterOperatingSystem> {

    private final int allocatedProcessors;

    @Nonnull
    private final List<ClusterOperatingSystemArchitecture> architectures;

    private final int availableProcessors;

    @Nonnull
    private final OperatingSystemMemoryInfo mem;

    @Nonnull
    private final List<ClusterOperatingSystemName> names;

    @Nonnull
    private final List<ClusterOperatingSystemPrettyName> prettyNames;

    // ---------------------------------------------------------------------------------------------

    private ClusterOperatingSystem(Builder builder) {
        this.allocatedProcessors = ApiTypeHelper.requireNonNull(builder.allocatedProcessors, this, "allocatedProcessors");
        this.architectures = ApiTypeHelper.unmodifiable(builder.architectures);
        this.availableProcessors = ApiTypeHelper.requireNonNull(builder.availableProcessors, this, "availableProcessors");
        this.mem = ApiTypeHelper.requireNonNull(builder.mem, this, "mem");
        this.names = ApiTypeHelper.unmodifiableRequired(builder.names, this, "names");
        this.prettyNames = ApiTypeHelper.unmodifiableRequired(builder.prettyNames, this, "prettyNames");
    }

    public static ClusterOperatingSystem of(Function<ClusterOperatingSystem.Builder, ObjectBuilder<ClusterOperatingSystem>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - Number of processors used to calculate thread pool size across all selected nodes. This number can be set with the
     * processors setting of a node and defaults to the number of processors reported by the operating system. In both cases, this number
     * will never be larger than 32.
     * <p>
     * API name: {@code allocated_processors}
     * </p>
     */
    public final int allocatedProcessors() {
        return this.allocatedProcessors;
    }

    /**
     * Contains statistics about processor architectures (for example, x86_64 or aarch64) used by selected nodes.
     * <p>
     * API name: {@code architectures}
     * </p>
     */
    @Nonnull
    public final List<ClusterOperatingSystemArchitecture> architectures() {
        return this.architectures;
    }

    /**
     * Required - Number of processors available to JVM across all selected nodes.
     * <p>
     * API name: {@code available_processors}
     * </p>
     */
    public final int availableProcessors() {
        return this.availableProcessors;
    }

    /**
     * Required - API name: {@code mem}
     */
    @Nonnull
    public final OperatingSystemMemoryInfo mem() {
        return this.mem;
    }

    /**
     * Required - Contains statistics about operating systems used by selected nodes.
     * <p>
     * API name: {@code names}
     * </p>
     */
    @Nonnull
    public final List<ClusterOperatingSystemName> names() {
        return this.names;
    }

    /**
     * Required - Contains statistics about operating systems used by selected nodes.
     * <p>
     * API name: {@code pretty_names}
     * </p>
     */
    @Nonnull
    public final List<ClusterOperatingSystemPrettyName> prettyNames() {
        return this.prettyNames;
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
        generator.writeKey("allocated_processors");
        generator.write(this.allocatedProcessors);

        if (ApiTypeHelper.isDefined(this.architectures)) {
            generator.writeKey("architectures");
            generator.writeStartArray();
            for (ClusterOperatingSystemArchitecture item0 : this.architectures) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        generator.writeKey("available_processors");
        generator.write(this.availableProcessors);

        generator.writeKey("mem");
        this.mem.serialize(generator, mapper);

        generator.writeKey("names");
        generator.writeStartArray();
        for (ClusterOperatingSystemName item0 : this.names) {
            item0.serialize(generator, mapper);
        }
        generator.writeEnd();

        generator.writeKey("pretty_names");
        generator.writeStartArray();
        for (ClusterOperatingSystemPrettyName item0 : this.prettyNames) {
            item0.serialize(generator, mapper);
        }
        generator.writeEnd();
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
     * Builder for {@link ClusterOperatingSystem}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ClusterOperatingSystem> {
        private Integer allocatedProcessors;
        @Nullable
        private List<ClusterOperatingSystemArchitecture> architectures;
        private Integer availableProcessors;
        private OperatingSystemMemoryInfo mem;
        private List<ClusterOperatingSystemName> names;
        private List<ClusterOperatingSystemPrettyName> prettyNames;

        public Builder() {}

        private Builder(ClusterOperatingSystem o) {
            this.allocatedProcessors = o.allocatedProcessors;
            this.architectures = _listCopy(o.architectures);
            this.availableProcessors = o.availableProcessors;
            this.mem = o.mem;
            this.names = _listCopy(o.names);
            this.prettyNames = _listCopy(o.prettyNames);
        }

        private Builder(Builder o) {
            this.allocatedProcessors = o.allocatedProcessors;
            this.architectures = _listCopy(o.architectures);
            this.availableProcessors = o.availableProcessors;
            this.mem = o.mem;
            this.names = _listCopy(o.names);
            this.prettyNames = _listCopy(o.prettyNames);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - Number of processors used to calculate thread pool size across all selected nodes. This number can be set with the
         * processors setting of a node and defaults to the number of processors reported by the operating system. In both cases, this
         * number will never be larger than 32.
         * <p>
         * API name: {@code allocated_processors}
         * </p>
         */
        @Nonnull
        public final Builder allocatedProcessors(int value) {
            this.allocatedProcessors = value;
            return this;
        }

        /**
         * Contains statistics about processor architectures (for example, x86_64 or aarch64) used by selected nodes.
         * <p>
         * API name: {@code architectures}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>architectures</code>.
         * </p>
         */
        @Nonnull
        public final Builder architectures(List<ClusterOperatingSystemArchitecture> list) {
            this.architectures = _listAddAll(this.architectures, list);
            return this;
        }

        /**
         * Contains statistics about processor architectures (for example, x86_64 or aarch64) used by selected nodes.
         * <p>
         * API name: {@code architectures}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>architectures</code>.
         * </p>
         */
        @Nonnull
        public final Builder architectures(ClusterOperatingSystemArchitecture value, ClusterOperatingSystemArchitecture... values) {
            this.architectures = _listAdd(this.architectures, value, values);
            return this;
        }

        /**
         * Contains statistics about processor architectures (for example, x86_64 or aarch64) used by selected nodes.
         * <p>
         * API name: {@code architectures}
         * </p>
         *
         * <p>
         * Adds a value to <code>architectures</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder architectures(
            Function<ClusterOperatingSystemArchitecture.Builder, ObjectBuilder<ClusterOperatingSystemArchitecture>> fn
        ) {
            return architectures(fn.apply(new ClusterOperatingSystemArchitecture.Builder()).build());
        }

        /**
         * Required - Number of processors available to JVM across all selected nodes.
         * <p>
         * API name: {@code available_processors}
         * </p>
         */
        @Nonnull
        public final Builder availableProcessors(int value) {
            this.availableProcessors = value;
            return this;
        }

        /**
         * Required - API name: {@code mem}
         */
        @Nonnull
        public final Builder mem(OperatingSystemMemoryInfo value) {
            this.mem = value;
            return this;
        }

        /**
         * Required - API name: {@code mem}
         */
        @Nonnull
        public final Builder mem(Function<OperatingSystemMemoryInfo.Builder, ObjectBuilder<OperatingSystemMemoryInfo>> fn) {
            return mem(fn.apply(new OperatingSystemMemoryInfo.Builder()).build());
        }

        /**
         * Required - Contains statistics about operating systems used by selected nodes.
         * <p>
         * API name: {@code names}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>names</code>.
         * </p>
         */
        @Nonnull
        public final Builder names(List<ClusterOperatingSystemName> list) {
            this.names = _listAddAll(this.names, list);
            return this;
        }

        /**
         * Required - Contains statistics about operating systems used by selected nodes.
         * <p>
         * API name: {@code names}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>names</code>.
         * </p>
         */
        @Nonnull
        public final Builder names(ClusterOperatingSystemName value, ClusterOperatingSystemName... values) {
            this.names = _listAdd(this.names, value, values);
            return this;
        }

        /**
         * Required - Contains statistics about operating systems used by selected nodes.
         * <p>
         * API name: {@code names}
         * </p>
         *
         * <p>
         * Adds a value to <code>names</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder names(Function<ClusterOperatingSystemName.Builder, ObjectBuilder<ClusterOperatingSystemName>> fn) {
            return names(fn.apply(new ClusterOperatingSystemName.Builder()).build());
        }

        /**
         * Required - Contains statistics about operating systems used by selected nodes.
         * <p>
         * API name: {@code pretty_names}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>prettyNames</code>.
         * </p>
         */
        @Nonnull
        public final Builder prettyNames(List<ClusterOperatingSystemPrettyName> list) {
            this.prettyNames = _listAddAll(this.prettyNames, list);
            return this;
        }

        /**
         * Required - Contains statistics about operating systems used by selected nodes.
         * <p>
         * API name: {@code pretty_names}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>prettyNames</code>.
         * </p>
         */
        @Nonnull
        public final Builder prettyNames(ClusterOperatingSystemPrettyName value, ClusterOperatingSystemPrettyName... values) {
            this.prettyNames = _listAdd(this.prettyNames, value, values);
            return this;
        }

        /**
         * Required - Contains statistics about operating systems used by selected nodes.
         * <p>
         * API name: {@code pretty_names}
         * </p>
         *
         * <p>
         * Adds a value to <code>prettyNames</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder prettyNames(
            Function<ClusterOperatingSystemPrettyName.Builder, ObjectBuilder<ClusterOperatingSystemPrettyName>> fn
        ) {
            return prettyNames(fn.apply(new ClusterOperatingSystemPrettyName.Builder()).build());
        }

        /**
         * Builds a {@link ClusterOperatingSystem}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ClusterOperatingSystem build() {
            _checkSingleUse();

            return new ClusterOperatingSystem(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ClusterOperatingSystem}
     */
    public static final JsonpDeserializer<ClusterOperatingSystem> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ClusterOperatingSystem::setupClusterOperatingSystemDeserializer
    );

    protected static void setupClusterOperatingSystemDeserializer(ObjectDeserializer<ClusterOperatingSystem.Builder> op) {
        op.add(Builder::allocatedProcessors, JsonpDeserializer.integerDeserializer(), "allocated_processors");
        op.add(
            Builder::architectures,
            JsonpDeserializer.arrayDeserializer(ClusterOperatingSystemArchitecture._DESERIALIZER),
            "architectures"
        );
        op.add(Builder::availableProcessors, JsonpDeserializer.integerDeserializer(), "available_processors");
        op.add(Builder::mem, OperatingSystemMemoryInfo._DESERIALIZER, "mem");
        op.add(Builder::names, JsonpDeserializer.arrayDeserializer(ClusterOperatingSystemName._DESERIALIZER), "names");
        op.add(Builder::prettyNames, JsonpDeserializer.arrayDeserializer(ClusterOperatingSystemPrettyName._DESERIALIZER), "pretty_names");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Integer.hashCode(this.allocatedProcessors);
        result = 31 * result + Objects.hashCode(this.architectures);
        result = 31 * result + Integer.hashCode(this.availableProcessors);
        result = 31 * result + this.mem.hashCode();
        result = 31 * result + this.names.hashCode();
        result = 31 * result + this.prettyNames.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ClusterOperatingSystem other = (ClusterOperatingSystem) o;
        return this.allocatedProcessors == other.allocatedProcessors
            && Objects.equals(this.architectures, other.architectures)
            && this.availableProcessors == other.availableProcessors
            && this.mem.equals(other.mem)
            && this.names.equals(other.names)
            && this.prettyNames.equals(other.prettyNames);
    }
}
