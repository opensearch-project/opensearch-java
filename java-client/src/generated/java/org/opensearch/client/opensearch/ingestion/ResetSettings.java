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

package org.opensearch.client.opensearch.ingestion;

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

// typedef: ingestion.ResetSettings

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ResetSettings implements PlainJsonSerializable, ToCopyableBuilder<ResetSettings.Builder, ResetSettings> {

    @Nonnull
    private final ResetMode mode;

    private final int shard;

    @Nonnull
    private final String value;

    // ---------------------------------------------------------------------------------------------

    private ResetSettings(Builder builder) {
        this.mode = ApiTypeHelper.requireNonNull(builder.mode, this, "mode");
        this.shard = ApiTypeHelper.requireNonNull(builder.shard, this, "shard");
        this.value = ApiTypeHelper.requireNonNull(builder.value, this, "value");
    }

    public static ResetSettings of(Function<ResetSettings.Builder, ObjectBuilder<ResetSettings>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - Reset mode to be used.
     * <p>
     * API name: {@code mode}
     * </p>
     */
    @Nonnull
    public final ResetMode mode() {
        return this.mode;
    }

    /**
     * Required - The shard ID to reset.
     * <p>
     * API name: {@code shard}
     * </p>
     */
    public final int shard() {
        return this.shard;
    }

    /**
     * Required - The offset or timestamp value to be used to reset the consumer.
     * <p>
     * API name: {@code value}
     * </p>
     */
    @Nonnull
    public final String value() {
        return this.value;
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
        generator.writeKey("mode");
        this.mode.serialize(generator, mapper);

        generator.writeKey("shard");
        generator.write(this.shard);

        generator.writeKey("value");
        generator.write(this.value);
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
     * Builder for {@link ResetSettings}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ResetSettings> {
        private ResetMode mode;
        private Integer shard;
        private String value;

        public Builder() {}

        private Builder(ResetSettings o) {
            this.mode = o.mode;
            this.shard = o.shard;
            this.value = o.value;
        }

        private Builder(Builder o) {
            this.mode = o.mode;
            this.shard = o.shard;
            this.value = o.value;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - Reset mode to be used.
         * <p>
         * API name: {@code mode}
         * </p>
         */
        @Nonnull
        public final Builder mode(ResetMode value) {
            this.mode = value;
            return this;
        }

        /**
         * Required - The shard ID to reset.
         * <p>
         * API name: {@code shard}
         * </p>
         */
        @Nonnull
        public final Builder shard(int value) {
            this.shard = value;
            return this;
        }

        /**
         * Required - The offset or timestamp value to be used to reset the consumer.
         * <p>
         * API name: {@code value}
         * </p>
         */
        @Nonnull
        public final Builder value(String value) {
            this.value = value;
            return this;
        }

        /**
         * Builds a {@link ResetSettings}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ResetSettings build() {
            _checkSingleUse();

            return new ResetSettings(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ResetSettings}
     */
    public static final JsonpDeserializer<ResetSettings> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ResetSettings::setupResetSettingsDeserializer
    );

    protected static void setupResetSettingsDeserializer(ObjectDeserializer<ResetSettings.Builder> op) {
        op.add(Builder::mode, ResetMode._DESERIALIZER, "mode");
        op.add(Builder::shard, JsonpDeserializer.integerDeserializer(), "shard");
        op.add(Builder::value, JsonpDeserializer.stringDeserializer(), "value");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.mode.hashCode();
        result = 31 * result + Integer.hashCode(this.shard);
        result = 31 * result + this.value.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ResetSettings other = (ResetSettings) o;
        return this.mode.equals(other.mode) && this.shard == other.shard && this.value.equals(other.value);
    }
}
