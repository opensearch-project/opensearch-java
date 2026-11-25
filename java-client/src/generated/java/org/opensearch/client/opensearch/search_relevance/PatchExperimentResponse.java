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

// typedef: search_relevance.patch_experiment.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class PatchExperimentResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<PatchExperimentResponse.Builder, PatchExperimentResponse> {

    @Nullable
    private final String experimentId;

    @Nullable
    private final String experimentResult;

    // ---------------------------------------------------------------------------------------------

    private PatchExperimentResponse(Builder builder) {
        this.experimentId = builder.experimentId;
        this.experimentResult = builder.experimentResult;
    }

    public static PatchExperimentResponse of(Function<PatchExperimentResponse.Builder, ObjectBuilder<PatchExperimentResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The ID of the updated experiment.
     * <p>
     * API name: {@code experiment_id}
     * </p>
     */
    @Nullable
    public final String experimentId() {
        return this.experimentId;
    }

    /**
     * The lowercase write result of the update, for example <code>updated</code>.
     * <p>
     * API name: {@code experiment_result}
     * </p>
     */
    @Nullable
    public final String experimentResult() {
        return this.experimentResult;
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
        if (this.experimentId != null) {
            generator.writeKey("experiment_id");
            generator.write(this.experimentId);
        }

        if (this.experimentResult != null) {
            generator.writeKey("experiment_result");
            generator.write(this.experimentResult);
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
     * Builder for {@link PatchExperimentResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, PatchExperimentResponse> {
        @Nullable
        private String experimentId;
        @Nullable
        private String experimentResult;

        public Builder() {}

        private Builder(PatchExperimentResponse o) {
            this.experimentId = o.experimentId;
            this.experimentResult = o.experimentResult;
        }

        private Builder(Builder o) {
            this.experimentId = o.experimentId;
            this.experimentResult = o.experimentResult;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The ID of the updated experiment.
         * <p>
         * API name: {@code experiment_id}
         * </p>
         */
        @Nonnull
        public final Builder experimentId(@Nullable String value) {
            this.experimentId = value;
            return this;
        }

        /**
         * The lowercase write result of the update, for example <code>updated</code>.
         * <p>
         * API name: {@code experiment_result}
         * </p>
         */
        @Nonnull
        public final Builder experimentResult(@Nullable String value) {
            this.experimentResult = value;
            return this;
        }

        /**
         * Builds a {@link PatchExperimentResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PatchExperimentResponse build() {
            _checkSingleUse();

            return new PatchExperimentResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PatchExperimentResponse}
     */
    public static final JsonpDeserializer<PatchExperimentResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PatchExperimentResponse::setupPatchExperimentResponseDeserializer
    );

    protected static void setupPatchExperimentResponseDeserializer(ObjectDeserializer<PatchExperimentResponse.Builder> op) {
        op.add(Builder::experimentId, JsonpDeserializer.stringDeserializer(), "experiment_id");
        op.add(Builder::experimentResult, JsonpDeserializer.stringDeserializer(), "experiment_result");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.experimentId);
        result = 31 * result + Objects.hashCode(this.experimentResult);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PatchExperimentResponse other = (PatchExperimentResponse) o;
        return Objects.equals(this.experimentId, other.experimentId) && Objects.equals(this.experimentResult, other.experimentResult);
    }
}
