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

// typedef: ism.ExplainValidationResult

/**
 * The validation result of the current action of the managed index.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ExplainValidationResult
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ExplainValidationResult.Builder, ExplainValidationResult> {

    @Nullable
    private final String validationMessage;

    @Nullable
    private final ValidationStatus validationStatus;

    // ---------------------------------------------------------------------------------------------

    private ExplainValidationResult(Builder builder) {
        this.validationMessage = builder.validationMessage;
        this.validationStatus = builder.validationStatus;
    }

    public static ExplainValidationResult of(Function<ExplainValidationResult.Builder, ObjectBuilder<ExplainValidationResult>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The validation message.
     * <p>
     * API name: {@code validation_message}
     * </p>
     */
    @Nullable
    public final String validationMessage() {
        return this.validationMessage;
    }

    /**
     * API name: {@code validation_status}
     */
    @Nullable
    public final ValidationStatus validationStatus() {
        return this.validationStatus;
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
        if (this.validationMessage != null) {
            generator.writeKey("validation_message");
            generator.write(this.validationMessage);
        }

        if (this.validationStatus != null) {
            generator.writeKey("validation_status");
            this.validationStatus.serialize(generator, mapper);
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
     * Builder for {@link ExplainValidationResult}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ExplainValidationResult> {
        @Nullable
        private String validationMessage;
        @Nullable
        private ValidationStatus validationStatus;

        public Builder() {}

        private Builder(ExplainValidationResult o) {
            this.validationMessage = o.validationMessage;
            this.validationStatus = o.validationStatus;
        }

        private Builder(Builder o) {
            this.validationMessage = o.validationMessage;
            this.validationStatus = o.validationStatus;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The validation message.
         * <p>
         * API name: {@code validation_message}
         * </p>
         */
        @Nonnull
        public final Builder validationMessage(@Nullable String value) {
            this.validationMessage = value;
            return this;
        }

        /**
         * API name: {@code validation_status}
         */
        @Nonnull
        public final Builder validationStatus(@Nullable ValidationStatus value) {
            this.validationStatus = value;
            return this;
        }

        /**
         * Builds a {@link ExplainValidationResult}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ExplainValidationResult build() {
            _checkSingleUse();

            return new ExplainValidationResult(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ExplainValidationResult}
     */
    public static final JsonpDeserializer<ExplainValidationResult> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ExplainValidationResult::setupExplainValidationResultDeserializer
    );

    protected static void setupExplainValidationResultDeserializer(ObjectDeserializer<ExplainValidationResult.Builder> op) {
        op.add(Builder::validationMessage, JsonpDeserializer.stringDeserializer(), "validation_message");
        op.add(Builder::validationStatus, ValidationStatus._DESERIALIZER, "validation_status");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.validationMessage);
        result = 31 * result + Objects.hashCode(this.validationStatus);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ExplainValidationResult other = (ExplainValidationResult) o;
        return Objects.equals(this.validationMessage, other.validationMessage)
            && Objects.equals(this.validationStatus, other.validationStatus);
    }
}
