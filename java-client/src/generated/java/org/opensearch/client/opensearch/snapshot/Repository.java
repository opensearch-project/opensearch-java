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

package org.opensearch.client.opensearch.snapshot;

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

// typedef: snapshot.Repository

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Repository implements PlainJsonSerializable, ToCopyableBuilder<Repository.Builder, Repository> {

    @Nonnull
    private final RepositorySettings settings;

    @Nonnull
    private final String type;

    @Nullable
    private final String uuid;

    // ---------------------------------------------------------------------------------------------

    private Repository(Builder builder) {
        this.settings = ApiTypeHelper.requireNonNull(builder.settings, this, "settings");
        this.type = ApiTypeHelper.requireNonNull(builder.type, this, "type");
        this.uuid = builder.uuid;
    }

    public static Repository of(Function<Repository.Builder, ObjectBuilder<Repository>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code settings}
     */
    @Nonnull
    public final RepositorySettings settings() {
        return this.settings;
    }

    /**
     * Required - API name: {@code type}
     */
    @Nonnull
    public final String type() {
        return this.type;
    }

    /**
     * API name: {@code uuid}
     */
    @Nullable
    public final String uuid() {
        return this.uuid;
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
        generator.writeKey("settings");
        this.settings.serialize(generator, mapper);

        generator.writeKey("type");
        generator.write(this.type);

        if (this.uuid != null) {
            generator.writeKey("uuid");
            generator.write(this.uuid);
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
     * Builder for {@link Repository}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, Repository> {
        private RepositorySettings settings;
        private String type;
        @Nullable
        private String uuid;

        public Builder() {}

        private Builder(Repository o) {
            this.settings = o.settings;
            this.type = o.type;
            this.uuid = o.uuid;
        }

        private Builder(Builder o) {
            this.settings = o.settings;
            this.type = o.type;
            this.uuid = o.uuid;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code settings}
         */
        @Nonnull
        public final Builder settings(RepositorySettings value) {
            this.settings = value;
            return this;
        }

        /**
         * Required - API name: {@code settings}
         */
        @Nonnull
        public final Builder settings(Function<RepositorySettings.Builder, ObjectBuilder<RepositorySettings>> fn) {
            return settings(fn.apply(new RepositorySettings.Builder()).build());
        }

        /**
         * Required - API name: {@code type}
         */
        @Nonnull
        public final Builder type(String value) {
            this.type = value;
            return this;
        }

        /**
         * API name: {@code uuid}
         */
        @Nonnull
        public final Builder uuid(@Nullable String value) {
            this.uuid = value;
            return this;
        }

        /**
         * Builds a {@link Repository}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public Repository build() {
            _checkSingleUse();

            return new Repository(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link Repository}
     */
    public static final JsonpDeserializer<Repository> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        Repository::setupRepositoryDeserializer
    );

    protected static void setupRepositoryDeserializer(ObjectDeserializer<Repository.Builder> op) {
        op.add(Builder::settings, RepositorySettings._DESERIALIZER, "settings");
        op.add(Builder::type, JsonpDeserializer.stringDeserializer(), "type");
        op.add(Builder::uuid, JsonpDeserializer.stringDeserializer(), "uuid");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.settings.hashCode();
        result = 31 * result + this.type.hashCode();
        result = 31 * result + Objects.hashCode(this.uuid);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Repository other = (Repository) o;
        return this.settings.equals(other.settings) && this.type.equals(other.type) && Objects.equals(this.uuid, other.uuid);
    }
}
