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

package org.opensearch.client.opensearch.search_relevance;

import jakarta.json.stream.JsonGenerator;
import java.util.List;
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

// typedef: search_relevance.validate_experiments.Response

/**
 * Describes whether an experiment's inputs have drifted from the fingerprint recorded at execution time.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ValidateExperimentsResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ValidateExperimentsResponse.Builder, ValidateExperimentsResponse> {

    @Nonnull
    private final List<String> driftedInputs;

    @Nonnull
    private final String message;

    @Nonnull
    private final ExperimentValidationStatus status;

    // ---------------------------------------------------------------------------------------------

    private ValidateExperimentsResponse(Builder builder) {
        this.driftedInputs = ApiTypeHelper.unmodifiableRequired(builder.driftedInputs, this, "driftedInputs");
        this.message = ApiTypeHelper.requireNonNull(builder.message, this, "message");
        this.status = ApiTypeHelper.requireNonNull(builder.status, this, "status");
    }

    public static ValidateExperimentsResponse of(
        Function<ValidateExperimentsResponse.Builder, ObjectBuilder<ValidateExperimentsResponse>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The list of inputs that have drifted.
     * <p>
     * API name: {@code drifted_inputs}
     * </p>
     */
    @Nonnull
    public final List<String> driftedInputs() {
        return this.driftedInputs;
    }

    /**
     * Required - A human-readable message describing the validation result.
     * <p>
     * API name: {@code message}
     * </p>
     */
    @Nonnull
    public final String message() {
        return this.message;
    }

    /**
     * Required - API name: {@code status}
     */
    @Nonnull
    public final ExperimentValidationStatus status() {
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
        generator.writeKey("drifted_inputs");
        generator.writeStartArray();
        for (String item0 : this.driftedInputs) {
            generator.write(item0);
        }
        generator.writeEnd();

        generator.writeKey("message");
        generator.write(this.message);

        generator.writeKey("status");
        this.status.serialize(generator, mapper);
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
     * Builder for {@link ValidateExperimentsResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ValidateExperimentsResponse> {
        private List<String> driftedInputs;
        private String message;
        private ExperimentValidationStatus status;

        public Builder() {}

        private Builder(ValidateExperimentsResponse o) {
            this.driftedInputs = _listCopy(o.driftedInputs);
            this.message = o.message;
            this.status = o.status;
        }

        private Builder(Builder o) {
            this.driftedInputs = _listCopy(o.driftedInputs);
            this.message = o.message;
            this.status = o.status;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - The list of inputs that have drifted.
         * <p>
         * API name: {@code drifted_inputs}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>driftedInputs</code>.
         * </p>
         */
        @Nonnull
        public final Builder driftedInputs(List<String> list) {
            this.driftedInputs = _listAddAll(this.driftedInputs, list);
            return this;
        }

        /**
         * Required - The list of inputs that have drifted.
         * <p>
         * API name: {@code drifted_inputs}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>driftedInputs</code>.
         * </p>
         */
        @Nonnull
        public final Builder driftedInputs(String value, String... values) {
            this.driftedInputs = _listAdd(this.driftedInputs, value, values);
            return this;
        }

        /**
         * Required - A human-readable message describing the validation result.
         * <p>
         * API name: {@code message}
         * </p>
         */
        @Nonnull
        public final Builder message(String value) {
            this.message = value;
            return this;
        }

        /**
         * Required - API name: {@code status}
         */
        @Nonnull
        public final Builder status(ExperimentValidationStatus value) {
            this.status = value;
            return this;
        }

        /**
         * Builds a {@link ValidateExperimentsResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ValidateExperimentsResponse build() {
            _checkSingleUse();

            return new ValidateExperimentsResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ValidateExperimentsResponse}
     */
    public static final JsonpDeserializer<ValidateExperimentsResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ValidateExperimentsResponse::setupValidateExperimentsResponseDeserializer
    );

    protected static void setupValidateExperimentsResponseDeserializer(ObjectDeserializer<ValidateExperimentsResponse.Builder> op) {
        op.add(Builder::driftedInputs, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "drifted_inputs");
        op.add(Builder::message, JsonpDeserializer.stringDeserializer(), "message");
        op.add(Builder::status, ExperimentValidationStatus._DESERIALIZER, "status");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.driftedInputs.hashCode();
        result = 31 * result + this.message.hashCode();
        result = 31 * result + this.status.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ValidateExperimentsResponse other = (ValidateExperimentsResponse) o;
        return this.driftedInputs.equals(other.driftedInputs) && this.message.equals(other.message) && this.status.equals(other.status);
    }
}
