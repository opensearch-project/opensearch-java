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

package org.opensearch.client.opensearch.geospatial;

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

// typedef: geospatial.Database

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Database implements PlainJsonSerializable, ToCopyableBuilder<Database.Builder, Database> {

    @Nonnull
    private final List<String> fields;

    @Nullable
    private final String provider;

    @Nullable
    private final String sha256Hash;

    @Nullable
    private final Long updatedAtInEpochMillis;

    @Nullable
    private final Integer validForInDays;

    // ---------------------------------------------------------------------------------------------

    private Database(Builder builder) {
        this.fields = ApiTypeHelper.unmodifiable(builder.fields);
        this.provider = builder.provider;
        this.sha256Hash = builder.sha256Hash;
        this.updatedAtInEpochMillis = builder.updatedAtInEpochMillis;
        this.validForInDays = builder.validForInDays;
    }

    public static Database of(Function<Database.Builder, ObjectBuilder<Database>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code fields}
     */
    @Nonnull
    public final List<String> fields() {
        return this.fields;
    }

    /**
     * API name: {@code provider}
     */
    @Nullable
    public final String provider() {
        return this.provider;
    }

    /**
     * API name: {@code sha256_hash}
     */
    @Nullable
    public final String sha256Hash() {
        return this.sha256Hash;
    }

    /**
     * API name: {@code updated_at_in_epoch_millis}
     */
    @Nullable
    public final Long updatedAtInEpochMillis() {
        return this.updatedAtInEpochMillis;
    }

    /**
     * API name: {@code valid_for_in_days}
     */
    @Nullable
    public final Integer validForInDays() {
        return this.validForInDays;
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
        if (ApiTypeHelper.isDefined(this.fields)) {
            generator.writeKey("fields");
            generator.writeStartArray();
            for (String item0 : this.fields) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.provider != null) {
            generator.writeKey("provider");
            generator.write(this.provider);
        }

        if (this.sha256Hash != null) {
            generator.writeKey("sha256_hash");
            generator.write(this.sha256Hash);
        }

        if (this.updatedAtInEpochMillis != null) {
            generator.writeKey("updated_at_in_epoch_millis");
            generator.write(this.updatedAtInEpochMillis);
        }

        if (this.validForInDays != null) {
            generator.writeKey("valid_for_in_days");
            generator.write(this.validForInDays);
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
     * Builder for {@link Database}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, Database> {
        @Nullable
        private List<String> fields;
        @Nullable
        private String provider;
        @Nullable
        private String sha256Hash;
        @Nullable
        private Long updatedAtInEpochMillis;
        @Nullable
        private Integer validForInDays;

        public Builder() {}

        private Builder(Database o) {
            this.fields = _listCopy(o.fields);
            this.provider = o.provider;
            this.sha256Hash = o.sha256Hash;
            this.updatedAtInEpochMillis = o.updatedAtInEpochMillis;
            this.validForInDays = o.validForInDays;
        }

        private Builder(Builder o) {
            this.fields = _listCopy(o.fields);
            this.provider = o.provider;
            this.sha256Hash = o.sha256Hash;
            this.updatedAtInEpochMillis = o.updatedAtInEpochMillis;
            this.validForInDays = o.validForInDays;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code fields}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>fields</code>.
         * </p>
         */
        @Nonnull
        public final Builder fields(List<String> list) {
            this.fields = _listAddAll(this.fields, list);
            return this;
        }

        /**
         * API name: {@code fields}
         *
         * <p>
         * Adds one or more values to <code>fields</code>.
         * </p>
         */
        @Nonnull
        public final Builder fields(String value, String... values) {
            this.fields = _listAdd(this.fields, value, values);
            return this;
        }

        /**
         * API name: {@code provider}
         */
        @Nonnull
        public final Builder provider(@Nullable String value) {
            this.provider = value;
            return this;
        }

        /**
         * API name: {@code sha256_hash}
         */
        @Nonnull
        public final Builder sha256Hash(@Nullable String value) {
            this.sha256Hash = value;
            return this;
        }

        /**
         * API name: {@code updated_at_in_epoch_millis}
         */
        @Nonnull
        public final Builder updatedAtInEpochMillis(@Nullable Long value) {
            this.updatedAtInEpochMillis = value;
            return this;
        }

        /**
         * API name: {@code valid_for_in_days}
         */
        @Nonnull
        public final Builder validForInDays(@Nullable Integer value) {
            this.validForInDays = value;
            return this;
        }

        /**
         * Builds a {@link Database}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public Database build() {
            _checkSingleUse();

            return new Database(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link Database}
     */
    public static final JsonpDeserializer<Database> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        Database::setupDatabaseDeserializer
    );

    protected static void setupDatabaseDeserializer(ObjectDeserializer<Database.Builder> op) {
        op.add(Builder::fields, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "fields");
        op.add(Builder::provider, JsonpDeserializer.stringDeserializer(), "provider");
        op.add(Builder::sha256Hash, JsonpDeserializer.stringDeserializer(), "sha256_hash");
        op.add(Builder::updatedAtInEpochMillis, JsonpDeserializer.longDeserializer(), "updated_at_in_epoch_millis");
        op.add(Builder::validForInDays, JsonpDeserializer.integerDeserializer(), "valid_for_in_days");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.fields);
        result = 31 * result + Objects.hashCode(this.provider);
        result = 31 * result + Objects.hashCode(this.sha256Hash);
        result = 31 * result + Objects.hashCode(this.updatedAtInEpochMillis);
        result = 31 * result + Objects.hashCode(this.validForInDays);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Database other = (Database) o;
        return Objects.equals(this.fields, other.fields)
            && Objects.equals(this.provider, other.provider)
            && Objects.equals(this.sha256Hash, other.sha256Hash)
            && Objects.equals(this.updatedAtInEpochMillis, other.updatedAtInEpochMillis)
            && Objects.equals(this.validForInDays, other.validForInDays);
    }
}
