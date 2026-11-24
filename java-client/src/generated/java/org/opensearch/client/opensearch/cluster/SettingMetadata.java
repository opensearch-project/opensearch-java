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

package org.opensearch.client.opensearch.cluster;

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

// typedef: cluster.SettingMetadata

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SettingMetadata implements PlainJsonSerializable, ToCopyableBuilder<SettingMetadata.Builder, SettingMetadata> {

    private final boolean dynamic;

    // ---------------------------------------------------------------------------------------------

    private SettingMetadata(Builder builder) {
        this.dynamic = ApiTypeHelper.requireNonNull(builder.dynamic, this, "dynamic");
    }

    public static SettingMetadata of(Function<SettingMetadata.Builder, ObjectBuilder<SettingMetadata>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - Whether the setting is dynamic. A dynamic setting can be updated on a running cluster; a static setting requires a node
     * restart to change.
     * <p>
     * API name: {@code dynamic}
     * </p>
     */
    public final boolean dynamic() {
        return this.dynamic;
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
        generator.writeKey("dynamic");
        generator.write(this.dynamic);
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
     * Builder for {@link SettingMetadata}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, SettingMetadata> {
        private Boolean dynamic;

        public Builder() {}

        private Builder(SettingMetadata o) {
            this.dynamic = o.dynamic;
        }

        private Builder(Builder o) {
            this.dynamic = o.dynamic;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - Whether the setting is dynamic. A dynamic setting can be updated on a running cluster; a static setting requires a
         * node restart to change.
         * <p>
         * API name: {@code dynamic}
         * </p>
         */
        @Nonnull
        public final Builder dynamic(boolean value) {
            this.dynamic = value;
            return this;
        }

        /**
         * Builds a {@link SettingMetadata}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SettingMetadata build() {
            _checkSingleUse();

            return new SettingMetadata(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SettingMetadata}
     */
    public static final JsonpDeserializer<SettingMetadata> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SettingMetadata::setupSettingMetadataDeserializer
    );

    protected static void setupSettingMetadataDeserializer(ObjectDeserializer<SettingMetadata.Builder> op) {
        op.add(Builder::dynamic, JsonpDeserializer.booleanDeserializer(), "dynamic");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Boolean.hashCode(this.dynamic);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SettingMetadata other = (SettingMetadata) o;
        return this.dynamic == other.dynamic;
    }
}
