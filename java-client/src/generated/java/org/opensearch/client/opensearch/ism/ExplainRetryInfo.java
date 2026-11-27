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

package org.opensearch.client.opensearch.ism;

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

// typedef: ism.ExplainRetryInfo

/**
 * The retry information of the managed index.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ExplainRetryInfo implements PlainJsonSerializable, ToCopyableBuilder<ExplainRetryInfo.Builder, ExplainRetryInfo> {

    @Nullable
    private final Integer consumedRetries;

    @Nullable
    private final Boolean failed;

    // ---------------------------------------------------------------------------------------------

    private ExplainRetryInfo(Builder builder) {
        this.consumedRetries = builder.consumedRetries;
        this.failed = builder.failed;
    }

    public static ExplainRetryInfo of(Function<ExplainRetryInfo.Builder, ObjectBuilder<ExplainRetryInfo>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The number of retries the policy has consumed.
     * <p>
     * API name: {@code consumed_retries}
     * </p>
     */
    @Nullable
    public final Integer consumedRetries() {
        return this.consumedRetries;
    }

    /**
     * Whether the policy has failed.
     * <p>
     * API name: {@code failed}
     * </p>
     */
    @Nullable
    public final Boolean failed() {
        return this.failed;
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
        if (this.consumedRetries != null) {
            generator.writeKey("consumed_retries");
            generator.write(this.consumedRetries);
        }

        if (this.failed != null) {
            generator.writeKey("failed");
            generator.write(this.failed);
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
     * Builder for {@link ExplainRetryInfo}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ExplainRetryInfo> {
        @Nullable
        private Integer consumedRetries;
        @Nullable
        private Boolean failed;

        public Builder() {}

        private Builder(ExplainRetryInfo o) {
            this.consumedRetries = o.consumedRetries;
            this.failed = o.failed;
        }

        private Builder(Builder o) {
            this.consumedRetries = o.consumedRetries;
            this.failed = o.failed;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The number of retries the policy has consumed.
         * <p>
         * API name: {@code consumed_retries}
         * </p>
         */
        @Nonnull
        public final Builder consumedRetries(@Nullable Integer value) {
            this.consumedRetries = value;
            return this;
        }

        /**
         * Whether the policy has failed.
         * <p>
         * API name: {@code failed}
         * </p>
         */
        @Nonnull
        public final Builder failed(@Nullable Boolean value) {
            this.failed = value;
            return this;
        }

        /**
         * Builds a {@link ExplainRetryInfo}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ExplainRetryInfo build() {
            _checkSingleUse();

            return new ExplainRetryInfo(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ExplainRetryInfo}
     */
    public static final JsonpDeserializer<ExplainRetryInfo> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ExplainRetryInfo::setupExplainRetryInfoDeserializer
    );

    protected static void setupExplainRetryInfoDeserializer(ObjectDeserializer<ExplainRetryInfo.Builder> op) {
        op.add(Builder::consumedRetries, JsonpDeserializer.integerDeserializer(), "consumed_retries");
        op.add(Builder::failed, JsonpDeserializer.booleanDeserializer(), "failed");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.consumedRetries);
        result = 31 * result + Objects.hashCode(this.failed);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ExplainRetryInfo other = (ExplainRetryInfo) o;
        return Objects.equals(this.consumedRetries, other.consumedRetries) && Objects.equals(this.failed, other.failed);
    }
}
