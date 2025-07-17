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

package org.opensearch.client.opensearch.ltr;

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

// typedef: ltr.StoreStat

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class StoreStat implements PlainJsonSerializable, ToCopyableBuilder<StoreStat.Builder, StoreStat> {

    @Nullable
    private final Integer featureCount;

    @Nullable
    private final Integer featuresetCount;

    @Nullable
    private final Integer modelCount;

    @Nullable
    private final String status;

    // ---------------------------------------------------------------------------------------------

    private StoreStat(Builder builder) {
        this.featureCount = builder.featureCount;
        this.featuresetCount = builder.featuresetCount;
        this.modelCount = builder.modelCount;
        this.status = builder.status;
    }

    public static StoreStat of(Function<StoreStat.Builder, ObjectBuilder<StoreStat>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code feature_count}
     */
    @Nullable
    public final Integer featureCount() {
        return this.featureCount;
    }

    /**
     * API name: {@code featureset_count}
     */
    @Nullable
    public final Integer featuresetCount() {
        return this.featuresetCount;
    }

    /**
     * API name: {@code model_count}
     */
    @Nullable
    public final Integer modelCount() {
        return this.modelCount;
    }

    /**
     * API name: {@code status}
     */
    @Nullable
    public final String status() {
        return this.status;
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
        if (this.featureCount != null) {
            generator.writeKey("feature_count");
            generator.write(this.featureCount);
        }

        if (this.featuresetCount != null) {
            generator.writeKey("featureset_count");
            generator.write(this.featuresetCount);
        }

        if (this.modelCount != null) {
            generator.writeKey("model_count");
            generator.write(this.modelCount);
        }

        if (this.status != null) {
            generator.writeKey("status");
            generator.write(this.status);
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
     * Builder for {@link StoreStat}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, StoreStat> {
        @Nullable
        private Integer featureCount;
        @Nullable
        private Integer featuresetCount;
        @Nullable
        private Integer modelCount;
        @Nullable
        private String status;

        public Builder() {}

        private Builder(StoreStat o) {
            this.featureCount = o.featureCount;
            this.featuresetCount = o.featuresetCount;
            this.modelCount = o.modelCount;
            this.status = o.status;
        }

        private Builder(Builder o) {
            this.featureCount = o.featureCount;
            this.featuresetCount = o.featuresetCount;
            this.modelCount = o.modelCount;
            this.status = o.status;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code feature_count}
         */
        @Nonnull
        public final Builder featureCount(@Nullable Integer value) {
            this.featureCount = value;
            return this;
        }

        /**
         * API name: {@code featureset_count}
         */
        @Nonnull
        public final Builder featuresetCount(@Nullable Integer value) {
            this.featuresetCount = value;
            return this;
        }

        /**
         * API name: {@code model_count}
         */
        @Nonnull
        public final Builder modelCount(@Nullable Integer value) {
            this.modelCount = value;
            return this;
        }

        /**
         * API name: {@code status}
         */
        @Nonnull
        public final Builder status(@Nullable String value) {
            this.status = value;
            return this;
        }

        /**
         * Builds a {@link StoreStat}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public StoreStat build() {
            _checkSingleUse();

            return new StoreStat(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link StoreStat}
     */
    public static final JsonpDeserializer<StoreStat> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        StoreStat::setupStoreStatDeserializer
    );

    protected static void setupStoreStatDeserializer(ObjectDeserializer<StoreStat.Builder> op) {
        op.add(Builder::featureCount, JsonpDeserializer.integerDeserializer(), "feature_count");
        op.add(Builder::featuresetCount, JsonpDeserializer.integerDeserializer(), "featureset_count");
        op.add(Builder::modelCount, JsonpDeserializer.integerDeserializer(), "model_count");
        op.add(Builder::status, JsonpDeserializer.stringDeserializer(), "status");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.featureCount);
        result = 31 * result + Objects.hashCode(this.featuresetCount);
        result = 31 * result + Objects.hashCode(this.modelCount);
        result = 31 * result + Objects.hashCode(this.status);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        StoreStat other = (StoreStat) o;
        return Objects.equals(this.featureCount, other.featureCount)
            && Objects.equals(this.featuresetCount, other.featuresetCount)
            && Objects.equals(this.modelCount, other.modelCount)
            && Objects.equals(this.status, other.status);
    }
}
