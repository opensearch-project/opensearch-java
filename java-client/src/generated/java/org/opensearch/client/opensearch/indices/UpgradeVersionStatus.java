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

// typedef: indices.UpgradeVersionStatus

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class UpgradeVersionStatus implements PlainJsonSerializable, ToCopyableBuilder<UpgradeVersionStatus.Builder, UpgradeVersionStatus> {

    @Nullable
    private final String oldestLuceneSegmentVersion;

    @Nullable
    private final String upgradeVersion;

    // ---------------------------------------------------------------------------------------------

    private UpgradeVersionStatus(Builder builder) {
        this.oldestLuceneSegmentVersion = builder.oldestLuceneSegmentVersion;
        this.upgradeVersion = builder.upgradeVersion;
    }

    public static UpgradeVersionStatus of(Function<UpgradeVersionStatus.Builder, ObjectBuilder<UpgradeVersionStatus>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code oldest_lucene_segment_version}
     */
    @Nullable
    public final String oldestLuceneSegmentVersion() {
        return this.oldestLuceneSegmentVersion;
    }

    /**
     * API name: {@code upgrade_version}
     */
    @Nullable
    public final String upgradeVersion() {
        return this.upgradeVersion;
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
        if (this.oldestLuceneSegmentVersion != null) {
            generator.writeKey("oldest_lucene_segment_version");
            generator.write(this.oldestLuceneSegmentVersion);
        }

        if (this.upgradeVersion != null) {
            generator.writeKey("upgrade_version");
            generator.write(this.upgradeVersion);
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
     * Builder for {@link UpgradeVersionStatus}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, UpgradeVersionStatus> {
        @Nullable
        private String oldestLuceneSegmentVersion;
        @Nullable
        private String upgradeVersion;

        public Builder() {}

        private Builder(UpgradeVersionStatus o) {
            this.oldestLuceneSegmentVersion = o.oldestLuceneSegmentVersion;
            this.upgradeVersion = o.upgradeVersion;
        }

        private Builder(Builder o) {
            this.oldestLuceneSegmentVersion = o.oldestLuceneSegmentVersion;
            this.upgradeVersion = o.upgradeVersion;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code oldest_lucene_segment_version}
         */
        @Nonnull
        public final Builder oldestLuceneSegmentVersion(@Nullable String value) {
            this.oldestLuceneSegmentVersion = value;
            return this;
        }

        /**
         * API name: {@code upgrade_version}
         */
        @Nonnull
        public final Builder upgradeVersion(@Nullable String value) {
            this.upgradeVersion = value;
            return this;
        }

        /**
         * Builds a {@link UpgradeVersionStatus}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public UpgradeVersionStatus build() {
            _checkSingleUse();

            return new UpgradeVersionStatus(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link UpgradeVersionStatus}
     */
    public static final JsonpDeserializer<UpgradeVersionStatus> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        UpgradeVersionStatus::setupUpgradeVersionStatusDeserializer
    );

    protected static void setupUpgradeVersionStatusDeserializer(ObjectDeserializer<UpgradeVersionStatus.Builder> op) {
        op.add(Builder::oldestLuceneSegmentVersion, JsonpDeserializer.stringDeserializer(), "oldest_lucene_segment_version");
        op.add(Builder::upgradeVersion, JsonpDeserializer.stringDeserializer(), "upgrade_version");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.oldestLuceneSegmentVersion);
        result = 31 * result + Objects.hashCode(this.upgradeVersion);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        UpgradeVersionStatus other = (UpgradeVersionStatus) o;
        return Objects.equals(this.oldestLuceneSegmentVersion, other.oldestLuceneSegmentVersion)
            && Objects.equals(this.upgradeVersion, other.upgradeVersion);
    }
}
