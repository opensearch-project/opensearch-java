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

// typedef: _types.OpenSearchVersionInfo

/**
 * The version information for OpenSearch.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class OpenSearchVersionInfo
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<OpenSearchVersionInfo.Builder, OpenSearchVersionInfo> {

    @Nonnull
    private final String buildDate;

    @Nullable
    private final String buildFlavor;

    @Nonnull
    private final String buildHash;

    private final boolean buildSnapshot;

    @Nonnull
    private final String buildType;

    @Nonnull
    private final String distribution;

    @Nonnull
    private final String luceneVersion;

    @Nonnull
    private final String minimumIndexCompatibilityVersion;

    @Nonnull
    private final String minimumWireCompatibilityVersion;

    @Nonnull
    private final String number;

    // ---------------------------------------------------------------------------------------------

    private OpenSearchVersionInfo(Builder builder) {
        this.buildDate = ApiTypeHelper.requireNonNull(builder.buildDate, this, "buildDate");
        this.buildFlavor = builder.buildFlavor;
        this.buildHash = ApiTypeHelper.requireNonNull(builder.buildHash, this, "buildHash");
        this.buildSnapshot = ApiTypeHelper.requireNonNull(builder.buildSnapshot, this, "buildSnapshot");
        this.buildType = ApiTypeHelper.requireNonNull(builder.buildType, this, "buildType");
        this.distribution = ApiTypeHelper.requireNonNull(builder.distribution, this, "distribution");
        this.luceneVersion = ApiTypeHelper.requireNonNull(builder.luceneVersion, this, "luceneVersion");
        this.minimumIndexCompatibilityVersion = ApiTypeHelper.requireNonNull(
            builder.minimumIndexCompatibilityVersion,
            this,
            "minimumIndexCompatibilityVersion"
        );
        this.minimumWireCompatibilityVersion = ApiTypeHelper.requireNonNull(
            builder.minimumWireCompatibilityVersion,
            this,
            "minimumWireCompatibilityVersion"
        );
        this.number = ApiTypeHelper.requireNonNull(builder.number, this, "number");
    }

    public static OpenSearchVersionInfo of(Function<OpenSearchVersionInfo.Builder, ObjectBuilder<OpenSearchVersionInfo>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - When the version was built.
     * <p>
     * API name: {@code build_date}
     * </p>
     */
    @Nonnull
    public final String buildDate() {
        return this.buildDate;
    }

    /**
     * The flavor of the build.
     * <p>
     * API name: {@code build_flavor}
     * </p>
     */
    @Nullable
    public final String buildFlavor() {
        return this.buildFlavor;
    }

    /**
     * Required - The hash of the build.
     * <p>
     * API name: {@code build_hash}
     * </p>
     */
    @Nonnull
    public final String buildHash() {
        return this.buildHash;
    }

    /**
     * Required - Whether this is a snapshot build.
     * <p>
     * API name: {@code build_snapshot}
     * </p>
     */
    public final boolean buildSnapshot() {
        return this.buildSnapshot;
    }

    /**
     * Required - The type of the build.
     * <p>
     * API name: {@code build_type}
     * </p>
     */
    @Nonnull
    public final String buildType() {
        return this.buildType;
    }

    /**
     * Required - The distribution name.
     * <p>
     * API name: {@code distribution}
     * </p>
     */
    @Nonnull
    public final String distribution() {
        return this.distribution;
    }

    /**
     * Required - The version of Lucene being used.
     * <p>
     * API name: {@code lucene_version}
     * </p>
     */
    @Nonnull
    public final String luceneVersion() {
        return this.luceneVersion;
    }

    /**
     * Required - The minimum compatible index version.
     * <p>
     * API name: {@code minimum_index_compatibility_version}
     * </p>
     */
    @Nonnull
    public final String minimumIndexCompatibilityVersion() {
        return this.minimumIndexCompatibilityVersion;
    }

    /**
     * Required - The minimum compatible wire protocol version.
     * <p>
     * API name: {@code minimum_wire_compatibility_version}
     * </p>
     */
    @Nonnull
    public final String minimumWireCompatibilityVersion() {
        return this.minimumWireCompatibilityVersion;
    }

    /**
     * Required - The version number.
     * <p>
     * API name: {@code number}
     * </p>
     */
    @Nonnull
    public final String number() {
        return this.number;
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
        generator.writeKey("build_date");
        generator.write(this.buildDate);

        if (this.buildFlavor != null) {
            generator.writeKey("build_flavor");
            generator.write(this.buildFlavor);
        }

        generator.writeKey("build_hash");
        generator.write(this.buildHash);

        generator.writeKey("build_snapshot");
        generator.write(this.buildSnapshot);

        generator.writeKey("build_type");
        generator.write(this.buildType);

        generator.writeKey("distribution");
        generator.write(this.distribution);

        generator.writeKey("lucene_version");
        generator.write(this.luceneVersion);

        generator.writeKey("minimum_index_compatibility_version");
        generator.write(this.minimumIndexCompatibilityVersion);

        generator.writeKey("minimum_wire_compatibility_version");
        generator.write(this.minimumWireCompatibilityVersion);

        generator.writeKey("number");
        generator.write(this.number);
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
     * Builder for {@link OpenSearchVersionInfo}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, OpenSearchVersionInfo> {
        private String buildDate;
        @Nullable
        private String buildFlavor;
        private String buildHash;
        private Boolean buildSnapshot;
        private String buildType;
        private String distribution;
        private String luceneVersion;
        private String minimumIndexCompatibilityVersion;
        private String minimumWireCompatibilityVersion;
        private String number;

        public Builder() {}

        private Builder(OpenSearchVersionInfo o) {
            this.buildDate = o.buildDate;
            this.buildFlavor = o.buildFlavor;
            this.buildHash = o.buildHash;
            this.buildSnapshot = o.buildSnapshot;
            this.buildType = o.buildType;
            this.distribution = o.distribution;
            this.luceneVersion = o.luceneVersion;
            this.minimumIndexCompatibilityVersion = o.minimumIndexCompatibilityVersion;
            this.minimumWireCompatibilityVersion = o.minimumWireCompatibilityVersion;
            this.number = o.number;
        }

        private Builder(Builder o) {
            this.buildDate = o.buildDate;
            this.buildFlavor = o.buildFlavor;
            this.buildHash = o.buildHash;
            this.buildSnapshot = o.buildSnapshot;
            this.buildType = o.buildType;
            this.distribution = o.distribution;
            this.luceneVersion = o.luceneVersion;
            this.minimumIndexCompatibilityVersion = o.minimumIndexCompatibilityVersion;
            this.minimumWireCompatibilityVersion = o.minimumWireCompatibilityVersion;
            this.number = o.number;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - When the version was built.
         * <p>
         * API name: {@code build_date}
         * </p>
         */
        @Nonnull
        public final Builder buildDate(String value) {
            this.buildDate = value;
            return this;
        }

        /**
         * The flavor of the build.
         * <p>
         * API name: {@code build_flavor}
         * </p>
         */
        @Nonnull
        public final Builder buildFlavor(@Nullable String value) {
            this.buildFlavor = value;
            return this;
        }

        /**
         * Required - The hash of the build.
         * <p>
         * API name: {@code build_hash}
         * </p>
         */
        @Nonnull
        public final Builder buildHash(String value) {
            this.buildHash = value;
            return this;
        }

        /**
         * Required - Whether this is a snapshot build.
         * <p>
         * API name: {@code build_snapshot}
         * </p>
         */
        @Nonnull
        public final Builder buildSnapshot(boolean value) {
            this.buildSnapshot = value;
            return this;
        }

        /**
         * Required - The type of the build.
         * <p>
         * API name: {@code build_type}
         * </p>
         */
        @Nonnull
        public final Builder buildType(String value) {
            this.buildType = value;
            return this;
        }

        /**
         * Required - The distribution name.
         * <p>
         * API name: {@code distribution}
         * </p>
         */
        @Nonnull
        public final Builder distribution(String value) {
            this.distribution = value;
            return this;
        }

        /**
         * Required - The version of Lucene being used.
         * <p>
         * API name: {@code lucene_version}
         * </p>
         */
        @Nonnull
        public final Builder luceneVersion(String value) {
            this.luceneVersion = value;
            return this;
        }

        /**
         * Required - The minimum compatible index version.
         * <p>
         * API name: {@code minimum_index_compatibility_version}
         * </p>
         */
        @Nonnull
        public final Builder minimumIndexCompatibilityVersion(String value) {
            this.minimumIndexCompatibilityVersion = value;
            return this;
        }

        /**
         * Required - The minimum compatible wire protocol version.
         * <p>
         * API name: {@code minimum_wire_compatibility_version}
         * </p>
         */
        @Nonnull
        public final Builder minimumWireCompatibilityVersion(String value) {
            this.minimumWireCompatibilityVersion = value;
            return this;
        }

        /**
         * Required - The version number.
         * <p>
         * API name: {@code number}
         * </p>
         */
        @Nonnull
        public final Builder number(String value) {
            this.number = value;
            return this;
        }

        /**
         * Builds a {@link OpenSearchVersionInfo}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public OpenSearchVersionInfo build() {
            _checkSingleUse();

            return new OpenSearchVersionInfo(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link OpenSearchVersionInfo}
     */
    public static final JsonpDeserializer<OpenSearchVersionInfo> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        OpenSearchVersionInfo::setupOpenSearchVersionInfoDeserializer
    );

    protected static void setupOpenSearchVersionInfoDeserializer(ObjectDeserializer<OpenSearchVersionInfo.Builder> op) {
        op.add(Builder::buildDate, JsonpDeserializer.stringDeserializer(), "build_date");
        op.add(Builder::buildFlavor, JsonpDeserializer.stringDeserializer(), "build_flavor");
        op.add(Builder::buildHash, JsonpDeserializer.stringDeserializer(), "build_hash");
        op.add(Builder::buildSnapshot, JsonpDeserializer.booleanDeserializer(), "build_snapshot");
        op.add(Builder::buildType, JsonpDeserializer.stringDeserializer(), "build_type");
        op.add(Builder::distribution, JsonpDeserializer.stringDeserializer(), "distribution");
        op.add(Builder::luceneVersion, JsonpDeserializer.stringDeserializer(), "lucene_version");
        op.add(Builder::minimumIndexCompatibilityVersion, JsonpDeserializer.stringDeserializer(), "minimum_index_compatibility_version");
        op.add(Builder::minimumWireCompatibilityVersion, JsonpDeserializer.stringDeserializer(), "minimum_wire_compatibility_version");
        op.add(Builder::number, JsonpDeserializer.stringDeserializer(), "number");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.buildDate.hashCode();
        result = 31 * result + Objects.hashCode(this.buildFlavor);
        result = 31 * result + this.buildHash.hashCode();
        result = 31 * result + Boolean.hashCode(this.buildSnapshot);
        result = 31 * result + this.buildType.hashCode();
        result = 31 * result + this.distribution.hashCode();
        result = 31 * result + this.luceneVersion.hashCode();
        result = 31 * result + this.minimumIndexCompatibilityVersion.hashCode();
        result = 31 * result + this.minimumWireCompatibilityVersion.hashCode();
        result = 31 * result + this.number.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        OpenSearchVersionInfo other = (OpenSearchVersionInfo) o;
        return this.buildDate.equals(other.buildDate)
            && Objects.equals(this.buildFlavor, other.buildFlavor)
            && this.buildHash.equals(other.buildHash)
            && this.buildSnapshot == other.buildSnapshot
            && this.buildType.equals(other.buildType)
            && this.distribution.equals(other.distribution)
            && this.luceneVersion.equals(other.luceneVersion)
            && this.minimumIndexCompatibilityVersion.equals(other.minimumIndexCompatibilityVersion)
            && this.minimumWireCompatibilityVersion.equals(other.minimumWireCompatibilityVersion)
            && this.number.equals(other.number);
    }
}
