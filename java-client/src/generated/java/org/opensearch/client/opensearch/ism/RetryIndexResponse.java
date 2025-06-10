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

// typedef: ism.retry_index.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RetryIndexResponse implements PlainJsonSerializable, ToCopyableBuilder<RetryIndexResponse.Builder, RetryIndexResponse> {

    @Nonnull
    private final List<FailedIndex> failedIndices;

    @Nullable
    private final Boolean failures;

    @Nullable
    private final Number updatedIndices;

    // ---------------------------------------------------------------------------------------------

    private RetryIndexResponse(Builder builder) {
        this.failedIndices = ApiTypeHelper.unmodifiable(builder.failedIndices);
        this.failures = builder.failures;
        this.updatedIndices = builder.updatedIndices;
    }

    public static RetryIndexResponse of(Function<RetryIndexResponse.Builder, ObjectBuilder<RetryIndexResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The list of indices that failed to update.
     * <p>
     * API name: {@code failed_indices}
     * </p>
     */
    @Nonnull
    public final List<FailedIndex> failedIndices() {
        return this.failedIndices;
    }

    /**
     * Whether there were any failures.
     * <p>
     * API name: {@code failures}
     * </p>
     */
    @Nullable
    public final Boolean failures() {
        return this.failures;
    }

    /**
     * The number of updated indices.
     * <p>
     * API name: {@code updated_indices}
     * </p>
     */
    @Nullable
    public final Number updatedIndices() {
        return this.updatedIndices;
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
        if (ApiTypeHelper.isDefined(this.failedIndices)) {
            generator.writeKey("failed_indices");
            generator.writeStartArray();
            for (FailedIndex item0 : this.failedIndices) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.failures != null) {
            generator.writeKey("failures");
            generator.write(this.failures);
        }

        if (this.updatedIndices != null) {
            generator.writeKey("updated_indices");
            generator.write(this.updatedIndices.doubleValue());
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
     * Builder for {@link RetryIndexResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, RetryIndexResponse> {
        @Nullable
        private List<FailedIndex> failedIndices;
        @Nullable
        private Boolean failures;
        @Nullable
        private Number updatedIndices;

        public Builder() {}

        private Builder(RetryIndexResponse o) {
            this.failedIndices = _listCopy(o.failedIndices);
            this.failures = o.failures;
            this.updatedIndices = o.updatedIndices;
        }

        private Builder(Builder o) {
            this.failedIndices = _listCopy(o.failedIndices);
            this.failures = o.failures;
            this.updatedIndices = o.updatedIndices;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The list of indices that failed to update.
         * <p>
         * API name: {@code failed_indices}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>failedIndices</code>.
         * </p>
         */
        @Nonnull
        public final Builder failedIndices(List<FailedIndex> list) {
            this.failedIndices = _listAddAll(this.failedIndices, list);
            return this;
        }

        /**
         * The list of indices that failed to update.
         * <p>
         * API name: {@code failed_indices}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>failedIndices</code>.
         * </p>
         */
        @Nonnull
        public final Builder failedIndices(FailedIndex value, FailedIndex... values) {
            this.failedIndices = _listAdd(this.failedIndices, value, values);
            return this;
        }

        /**
         * The list of indices that failed to update.
         * <p>
         * API name: {@code failed_indices}
         * </p>
         *
         * <p>
         * Adds a value to <code>failedIndices</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder failedIndices(Function<FailedIndex.Builder, ObjectBuilder<FailedIndex>> fn) {
            return failedIndices(fn.apply(new FailedIndex.Builder()).build());
        }

        /**
         * Whether there were any failures.
         * <p>
         * API name: {@code failures}
         * </p>
         */
        @Nonnull
        public final Builder failures(@Nullable Boolean value) {
            this.failures = value;
            return this;
        }

        /**
         * The number of updated indices.
         * <p>
         * API name: {@code updated_indices}
         * </p>
         */
        @Nonnull
        public final Builder updatedIndices(@Nullable Number value) {
            this.updatedIndices = value;
            return this;
        }

        /**
         * Builds a {@link RetryIndexResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RetryIndexResponse build() {
            _checkSingleUse();

            return new RetryIndexResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RetryIndexResponse}
     */
    public static final JsonpDeserializer<RetryIndexResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RetryIndexResponse::setupRetryIndexResponseDeserializer
    );

    protected static void setupRetryIndexResponseDeserializer(ObjectDeserializer<RetryIndexResponse.Builder> op) {
        op.add(Builder::failedIndices, JsonpDeserializer.arrayDeserializer(FailedIndex._DESERIALIZER), "failed_indices");
        op.add(Builder::failures, JsonpDeserializer.booleanDeserializer(), "failures");
        op.add(Builder::updatedIndices, JsonpDeserializer.numberDeserializer(), "updated_indices");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.failedIndices);
        result = 31 * result + Objects.hashCode(this.failures);
        result = 31 * result + Objects.hashCode(this.updatedIndices);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RetryIndexResponse other = (RetryIndexResponse) o;
        return Objects.equals(this.failedIndices, other.failedIndices)
            && Objects.equals(this.failures, other.failures)
            && Objects.equals(this.updatedIndices, other.updatedIndices);
    }
}
