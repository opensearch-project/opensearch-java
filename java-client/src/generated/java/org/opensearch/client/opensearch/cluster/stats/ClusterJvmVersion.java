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

// typedef: cluster.stats.ClusterJvmVersion

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ClusterJvmVersion implements PlainJsonSerializable, ToCopyableBuilder<ClusterJvmVersion.Builder, ClusterJvmVersion> {

    private final boolean bundledJdk;

    private final int count;

    private final boolean usingBundledJdk;

    @Nonnull
    private final String version;

    @Nonnull
    private final String vmName;

    @Nonnull
    private final String vmVendor;

    @Nonnull
    private final String vmVersion;

    // ---------------------------------------------------------------------------------------------

    private ClusterJvmVersion(Builder builder) {
        this.bundledJdk = ApiTypeHelper.requireNonNull(builder.bundledJdk, this, "bundledJdk");
        this.count = ApiTypeHelper.requireNonNull(builder.count, this, "count");
        this.usingBundledJdk = ApiTypeHelper.requireNonNull(builder.usingBundledJdk, this, "usingBundledJdk");
        this.version = ApiTypeHelper.requireNonNull(builder.version, this, "version");
        this.vmName = ApiTypeHelper.requireNonNull(builder.vmName, this, "vmName");
        this.vmVendor = ApiTypeHelper.requireNonNull(builder.vmVendor, this, "vmVendor");
        this.vmVersion = ApiTypeHelper.requireNonNull(builder.vmVersion, this, "vmVersion");
    }

    public static ClusterJvmVersion of(Function<ClusterJvmVersion.Builder, ObjectBuilder<ClusterJvmVersion>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - Always <code>true</code>. All distributions come with a bundled Java Development Kit (JDK).
     * <p>
     * API name: {@code bundled_jdk}
     * </p>
     */
    public final boolean bundledJdk() {
        return this.bundledJdk;
    }

    /**
     * Required - Total number of selected nodes using JVM.
     * <p>
     * API name: {@code count}
     * </p>
     */
    public final int count() {
        return this.count;
    }

    /**
     * Required - If <code>true</code>, a bundled JDK is in use by JVM.
     * <p>
     * API name: {@code using_bundled_jdk}
     * </p>
     */
    public final boolean usingBundledJdk() {
        return this.usingBundledJdk;
    }

    /**
     * Required - API name: {@code version}
     */
    @Nonnull
    public final String version() {
        return this.version;
    }

    /**
     * Required - Name of the JVM.
     * <p>
     * API name: {@code vm_name}
     * </p>
     */
    @Nonnull
    public final String vmName() {
        return this.vmName;
    }

    /**
     * Required - Vendor of the JVM.
     * <p>
     * API name: {@code vm_vendor}
     * </p>
     */
    @Nonnull
    public final String vmVendor() {
        return this.vmVendor;
    }

    /**
     * Required - API name: {@code vm_version}
     */
    @Nonnull
    public final String vmVersion() {
        return this.vmVersion;
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
        generator.writeKey("bundled_jdk");
        generator.write(this.bundledJdk);

        generator.writeKey("count");
        generator.write(this.count);

        generator.writeKey("using_bundled_jdk");
        generator.write(this.usingBundledJdk);

        generator.writeKey("version");
        generator.write(this.version);

        generator.writeKey("vm_name");
        generator.write(this.vmName);

        generator.writeKey("vm_vendor");
        generator.write(this.vmVendor);

        generator.writeKey("vm_version");
        generator.write(this.vmVersion);
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
     * Builder for {@link ClusterJvmVersion}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ClusterJvmVersion> {
        private Boolean bundledJdk;
        private Integer count;
        private Boolean usingBundledJdk;
        private String version;
        private String vmName;
        private String vmVendor;
        private String vmVersion;

        public Builder() {}

        private Builder(ClusterJvmVersion o) {
            this.bundledJdk = o.bundledJdk;
            this.count = o.count;
            this.usingBundledJdk = o.usingBundledJdk;
            this.version = o.version;
            this.vmName = o.vmName;
            this.vmVendor = o.vmVendor;
            this.vmVersion = o.vmVersion;
        }

        private Builder(Builder o) {
            this.bundledJdk = o.bundledJdk;
            this.count = o.count;
            this.usingBundledJdk = o.usingBundledJdk;
            this.version = o.version;
            this.vmName = o.vmName;
            this.vmVendor = o.vmVendor;
            this.vmVersion = o.vmVersion;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - Always <code>true</code>. All distributions come with a bundled Java Development Kit (JDK).
         * <p>
         * API name: {@code bundled_jdk}
         * </p>
         */
        @Nonnull
        public final Builder bundledJdk(boolean value) {
            this.bundledJdk = value;
            return this;
        }

        /**
         * Required - Total number of selected nodes using JVM.
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
         * Required - If <code>true</code>, a bundled JDK is in use by JVM.
         * <p>
         * API name: {@code using_bundled_jdk}
         * </p>
         */
        @Nonnull
        public final Builder usingBundledJdk(boolean value) {
            this.usingBundledJdk = value;
            return this;
        }

        /**
         * Required - API name: {@code version}
         */
        @Nonnull
        public final Builder version(String value) {
            this.version = value;
            return this;
        }

        /**
         * Required - Name of the JVM.
         * <p>
         * API name: {@code vm_name}
         * </p>
         */
        @Nonnull
        public final Builder vmName(String value) {
            this.vmName = value;
            return this;
        }

        /**
         * Required - Vendor of the JVM.
         * <p>
         * API name: {@code vm_vendor}
         * </p>
         */
        @Nonnull
        public final Builder vmVendor(String value) {
            this.vmVendor = value;
            return this;
        }

        /**
         * Required - API name: {@code vm_version}
         */
        @Nonnull
        public final Builder vmVersion(String value) {
            this.vmVersion = value;
            return this;
        }

        /**
         * Builds a {@link ClusterJvmVersion}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ClusterJvmVersion build() {
            _checkSingleUse();

            return new ClusterJvmVersion(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ClusterJvmVersion}
     */
    public static final JsonpDeserializer<ClusterJvmVersion> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ClusterJvmVersion::setupClusterJvmVersionDeserializer
    );

    protected static void setupClusterJvmVersionDeserializer(ObjectDeserializer<ClusterJvmVersion.Builder> op) {
        op.add(Builder::bundledJdk, JsonpDeserializer.booleanDeserializer(), "bundled_jdk");
        op.add(Builder::count, JsonpDeserializer.integerDeserializer(), "count");
        op.add(Builder::usingBundledJdk, JsonpDeserializer.booleanDeserializer(), "using_bundled_jdk");
        op.add(Builder::version, JsonpDeserializer.stringDeserializer(), "version");
        op.add(Builder::vmName, JsonpDeserializer.stringDeserializer(), "vm_name");
        op.add(Builder::vmVendor, JsonpDeserializer.stringDeserializer(), "vm_vendor");
        op.add(Builder::vmVersion, JsonpDeserializer.stringDeserializer(), "vm_version");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Boolean.hashCode(this.bundledJdk);
        result = 31 * result + Integer.hashCode(this.count);
        result = 31 * result + Boolean.hashCode(this.usingBundledJdk);
        result = 31 * result + this.version.hashCode();
        result = 31 * result + this.vmName.hashCode();
        result = 31 * result + this.vmVendor.hashCode();
        result = 31 * result + this.vmVersion.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ClusterJvmVersion other = (ClusterJvmVersion) o;
        return this.bundledJdk == other.bundledJdk
            && this.count == other.count
            && this.usingBundledJdk == other.usingBundledJdk
            && this.version.equals(other.version)
            && this.vmName.equals(other.vmName)
            && this.vmVendor.equals(other.vmVendor)
            && this.vmVersion.equals(other.vmVersion);
    }
}
