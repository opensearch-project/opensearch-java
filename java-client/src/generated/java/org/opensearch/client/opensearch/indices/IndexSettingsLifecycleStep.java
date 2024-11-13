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
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: indices.IndexSettingsLifecycleStep

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IndexSettingsLifecycleStep
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<IndexSettingsLifecycleStep.Builder, IndexSettingsLifecycleStep> {

    @Nullable
    private final Time waitTimeThreshold;

    // ---------------------------------------------------------------------------------------------

    private IndexSettingsLifecycleStep(Builder builder) {
        this.waitTimeThreshold = builder.waitTimeThreshold;
    }

    public static IndexSettingsLifecycleStep of(
        Function<IndexSettingsLifecycleStep.Builder, ObjectBuilder<IndexSettingsLifecycleStep>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code wait_time_threshold}
     */
    @Nullable
    public final Time waitTimeThreshold() {
        return this.waitTimeThreshold;
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
        if (this.waitTimeThreshold != null) {
            generator.writeKey("wait_time_threshold");
            this.waitTimeThreshold.serialize(generator, mapper);
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
     * Builder for {@link IndexSettingsLifecycleStep}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IndexSettingsLifecycleStep> {
        @Nullable
        private Time waitTimeThreshold;

        public Builder() {}

        private Builder(IndexSettingsLifecycleStep o) {
            this.waitTimeThreshold = o.waitTimeThreshold;
        }

        private Builder(Builder o) {
            this.waitTimeThreshold = o.waitTimeThreshold;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code wait_time_threshold}
         */
        @Nonnull
        public final Builder waitTimeThreshold(@Nullable Time value) {
            this.waitTimeThreshold = value;
            return this;
        }

        /**
         * API name: {@code wait_time_threshold}
         */
        @Nonnull
        public final Builder waitTimeThreshold(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return waitTimeThreshold(fn.apply(new Time.Builder()).build());
        }

        /**
         * Builds a {@link IndexSettingsLifecycleStep}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IndexSettingsLifecycleStep build() {
            _checkSingleUse();

            return new IndexSettingsLifecycleStep(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IndexSettingsLifecycleStep}
     */
    public static final JsonpDeserializer<IndexSettingsLifecycleStep> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IndexSettingsLifecycleStep::setupIndexSettingsLifecycleStepDeserializer
    );

    protected static void setupIndexSettingsLifecycleStepDeserializer(ObjectDeserializer<IndexSettingsLifecycleStep.Builder> op) {
        op.add(Builder::waitTimeThreshold, Time._DESERIALIZER, "wait_time_threshold");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.waitTimeThreshold);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IndexSettingsLifecycleStep other = (IndexSettingsLifecycleStep) o;
        return Objects.equals(this.waitTimeThreshold, other.waitTimeThreshold);
    }
}
