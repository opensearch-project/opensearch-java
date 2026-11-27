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

// typedef: cluster.SettingMetadata

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SettingMetadata implements PlainJsonSerializable, ToCopyableBuilder<SettingMetadata.Builder, SettingMetadata> {

    @Nullable
    private final String default_;

    @Nullable
    private final String description;

    private final boolean dynamic;

    @Nullable
    private final SettingValidation validation;

    // ---------------------------------------------------------------------------------------------

    private SettingMetadata(Builder builder) {
        this.default_ = builder.default_;
        this.description = builder.description;
        this.dynamic = ApiTypeHelper.requireNonNull(builder.dynamic, this, "dynamic");
        this.validation = builder.validation;
    }

    public static SettingMetadata of(Function<SettingMetadata.Builder, ObjectBuilder<SettingMetadata>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The default value declared in the setting definition, in the string form that the Cluster Settings API accepts. Omitted for secure
     * (keystore) settings and for settings that declare an empty default. Some defaults are computed by the node that responds to the
     * request.
     * <p>
     * API name: {@code default}
     * </p>
     */
    @Nullable
    public final String default_() {
        return this.default_;
    }

    /**
     * The description declared in the setting definition. Omitted when the definition does not include a description.
     * <p>
     * API name: {@code description}
     * </p>
     */
    @Nullable
    public final String description() {
        return this.description;
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
     * API name: {@code validation}
     */
    @Nullable
    public final SettingValidation validation() {
        return this.validation;
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
        if (this.default_ != null) {
            generator.writeKey("default");
            generator.write(this.default_);
        }

        if (this.description != null) {
            generator.writeKey("description");
            generator.write(this.description);
        }

        generator.writeKey("dynamic");
        generator.write(this.dynamic);

        if (this.validation != null) {
            generator.writeKey("validation");
            this.validation.serialize(generator, mapper);
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
     * Builder for {@link SettingMetadata}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, SettingMetadata> {
        @Nullable
        private String default_;
        @Nullable
        private String description;
        private Boolean dynamic;
        @Nullable
        private SettingValidation validation;

        public Builder() {}

        private Builder(SettingMetadata o) {
            this.default_ = o.default_;
            this.description = o.description;
            this.dynamic = o.dynamic;
            this.validation = o.validation;
        }

        private Builder(Builder o) {
            this.default_ = o.default_;
            this.description = o.description;
            this.dynamic = o.dynamic;
            this.validation = o.validation;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The default value declared in the setting definition, in the string form that the Cluster Settings API accepts. Omitted for
         * secure (keystore) settings and for settings that declare an empty default. Some defaults are computed by the node that responds
         * to the request.
         * <p>
         * API name: {@code default}
         * </p>
         */
        @Nonnull
        public final Builder default_(@Nullable String value) {
            this.default_ = value;
            return this;
        }

        /**
         * The description declared in the setting definition. Omitted when the definition does not include a description.
         * <p>
         * API name: {@code description}
         * </p>
         */
        @Nonnull
        public final Builder description(@Nullable String value) {
            this.description = value;
            return this;
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
         * API name: {@code validation}
         */
        @Nonnull
        public final Builder validation(@Nullable SettingValidation value) {
            this.validation = value;
            return this;
        }

        /**
         * API name: {@code validation}
         */
        @Nonnull
        public final Builder validation(Function<SettingValidation.Builder, ObjectBuilder<SettingValidation>> fn) {
            return validation(fn.apply(new SettingValidation.Builder()).build());
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
        op.add(Builder::default_, JsonpDeserializer.stringDeserializer(), "default");
        op.add(Builder::description, JsonpDeserializer.stringDeserializer(), "description");
        op.add(Builder::dynamic, JsonpDeserializer.booleanDeserializer(), "dynamic");
        op.add(Builder::validation, SettingValidation._DESERIALIZER, "validation");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.default_);
        result = 31 * result + Objects.hashCode(this.description);
        result = 31 * result + Boolean.hashCode(this.dynamic);
        result = 31 * result + Objects.hashCode(this.validation);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SettingMetadata other = (SettingMetadata) o;
        return Objects.equals(this.default_, other.default_)
            && Objects.equals(this.description, other.description)
            && this.dynamic == other.dynamic
            && Objects.equals(this.validation, other.validation);
    }
}
