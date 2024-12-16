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

// typedef: indices.UpgradeStatus

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class UpgradeStatus implements PlainJsonSerializable, ToCopyableBuilder<UpgradeStatus.Builder, UpgradeStatus> {

    @Nullable
    private final Long sizeInBytes;

    @Nullable
    private final Long sizeToUpgradeAncientInBytes;

    @Nullable
    private final Long sizeToUpgradeInBytes;

    // ---------------------------------------------------------------------------------------------

    private UpgradeStatus(Builder builder) {
        this.sizeInBytes = builder.sizeInBytes;
        this.sizeToUpgradeAncientInBytes = builder.sizeToUpgradeAncientInBytes;
        this.sizeToUpgradeInBytes = builder.sizeToUpgradeInBytes;
    }

    public static UpgradeStatus of(Function<UpgradeStatus.Builder, ObjectBuilder<UpgradeStatus>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code size_in_bytes}
     */
    @Nullable
    public final Long sizeInBytes() {
        return this.sizeInBytes;
    }

    /**
     * API name: {@code size_to_upgrade_ancient_in_bytes}
     */
    @Nullable
    public final Long sizeToUpgradeAncientInBytes() {
        return this.sizeToUpgradeAncientInBytes;
    }

    /**
     * API name: {@code size_to_upgrade_in_bytes}
     */
    @Nullable
    public final Long sizeToUpgradeInBytes() {
        return this.sizeToUpgradeInBytes;
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
        if (this.sizeInBytes != null) {
            generator.writeKey("size_in_bytes");
            generator.write(this.sizeInBytes);
        }

        if (this.sizeToUpgradeAncientInBytes != null) {
            generator.writeKey("size_to_upgrade_ancient_in_bytes");
            generator.write(this.sizeToUpgradeAncientInBytes);
        }

        if (this.sizeToUpgradeInBytes != null) {
            generator.writeKey("size_to_upgrade_in_bytes");
            generator.write(this.sizeToUpgradeInBytes);
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
     * Builder for {@link UpgradeStatus}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, UpgradeStatus> {
        @Nullable
        private Long sizeInBytes;
        @Nullable
        private Long sizeToUpgradeAncientInBytes;
        @Nullable
        private Long sizeToUpgradeInBytes;

        public Builder() {}

        private Builder(UpgradeStatus o) {
            this.sizeInBytes = o.sizeInBytes;
            this.sizeToUpgradeAncientInBytes = o.sizeToUpgradeAncientInBytes;
            this.sizeToUpgradeInBytes = o.sizeToUpgradeInBytes;
        }

        private Builder(Builder o) {
            this.sizeInBytes = o.sizeInBytes;
            this.sizeToUpgradeAncientInBytes = o.sizeToUpgradeAncientInBytes;
            this.sizeToUpgradeInBytes = o.sizeToUpgradeInBytes;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code size_in_bytes}
         */
        @Nonnull
        public final Builder sizeInBytes(@Nullable Long value) {
            this.sizeInBytes = value;
            return this;
        }

        /**
         * API name: {@code size_to_upgrade_ancient_in_bytes}
         */
        @Nonnull
        public final Builder sizeToUpgradeAncientInBytes(@Nullable Long value) {
            this.sizeToUpgradeAncientInBytes = value;
            return this;
        }

        /**
         * API name: {@code size_to_upgrade_in_bytes}
         */
        @Nonnull
        public final Builder sizeToUpgradeInBytes(@Nullable Long value) {
            this.sizeToUpgradeInBytes = value;
            return this;
        }

        /**
         * Builds a {@link UpgradeStatus}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public UpgradeStatus build() {
            _checkSingleUse();

            return new UpgradeStatus(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link UpgradeStatus}
     */
    public static final JsonpDeserializer<UpgradeStatus> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        UpgradeStatus::setupUpgradeStatusDeserializer
    );

    protected static void setupUpgradeStatusDeserializer(ObjectDeserializer<UpgradeStatus.Builder> op) {
        op.add(Builder::sizeInBytes, JsonpDeserializer.longDeserializer(), "size_in_bytes");
        op.add(Builder::sizeToUpgradeAncientInBytes, JsonpDeserializer.longDeserializer(), "size_to_upgrade_ancient_in_bytes");
        op.add(Builder::sizeToUpgradeInBytes, JsonpDeserializer.longDeserializer(), "size_to_upgrade_in_bytes");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.sizeInBytes);
        result = 31 * result + Objects.hashCode(this.sizeToUpgradeAncientInBytes);
        result = 31 * result + Objects.hashCode(this.sizeToUpgradeInBytes);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        UpgradeStatus other = (UpgradeStatus) o;
        return Objects.equals(this.sizeInBytes, other.sizeInBytes)
            && Objects.equals(this.sizeToUpgradeAncientInBytes, other.sizeToUpgradeAncientInBytes)
            && Objects.equals(this.sizeToUpgradeInBytes, other.sizeToUpgradeInBytes);
    }
}
