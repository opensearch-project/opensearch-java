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
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: indices.RetentionLease

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RetentionLease implements PlainJsonSerializable, ToCopyableBuilder<RetentionLease.Builder, RetentionLease> {

    @Nonnull
    private final Time period;

    // ---------------------------------------------------------------------------------------------

    private RetentionLease(Builder builder) {
        this.period = ApiTypeHelper.requireNonNull(builder.period, this, "period");
    }

    public static RetentionLease of(Function<RetentionLease.Builder, ObjectBuilder<RetentionLease>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code period}
     */
    @Nonnull
    public final Time period() {
        return this.period;
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
        generator.writeKey("period");
        this.period.serialize(generator, mapper);
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
     * Builder for {@link RetentionLease}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, RetentionLease> {
        private Time period;

        public Builder() {}

        private Builder(RetentionLease o) {
            this.period = o.period;
        }

        private Builder(Builder o) {
            this.period = o.period;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code period}
         */
        @Nonnull
        public final Builder period(Time value) {
            this.period = value;
            return this;
        }

        /**
         * Required - API name: {@code period}
         */
        @Nonnull
        public final Builder period(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return period(fn.apply(new Time.Builder()).build());
        }

        /**
         * Builds a {@link RetentionLease}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RetentionLease build() {
            _checkSingleUse();

            return new RetentionLease(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RetentionLease}
     */
    public static final JsonpDeserializer<RetentionLease> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RetentionLease::setupRetentionLeaseDeserializer
    );

    protected static void setupRetentionLeaseDeserializer(ObjectDeserializer<RetentionLease.Builder> op) {
        op.add(Builder::period, Time._DESERIALIZER, "period");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.period.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RetentionLease other = (RetentionLease) o;
        return this.period.equals(other.period);
    }
}
