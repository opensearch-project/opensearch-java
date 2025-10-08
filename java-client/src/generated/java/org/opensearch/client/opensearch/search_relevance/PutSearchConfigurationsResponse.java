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

// typedef: search_relevance.put_search_configurations.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class PutSearchConfigurationsResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<PutSearchConfigurationsResponse.Builder, PutSearchConfigurationsResponse> {

    @Nullable
    private final String searchConfigurationId;

    @Nullable
    private final String searchConfigurationResult;

    // ---------------------------------------------------------------------------------------------

    private PutSearchConfigurationsResponse(Builder builder) {
        this.searchConfigurationId = builder.searchConfigurationId;
        this.searchConfigurationResult = builder.searchConfigurationResult;
    }

    public static PutSearchConfigurationsResponse of(
        Function<PutSearchConfigurationsResponse.Builder, ObjectBuilder<PutSearchConfigurationsResponse>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code search_configuration_id}
     */
    @Nullable
    public final String searchConfigurationId() {
        return this.searchConfigurationId;
    }

    /**
     * API name: {@code search_configuration_result}
     */
    @Nullable
    public final String searchConfigurationResult() {
        return this.searchConfigurationResult;
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
        if (this.searchConfigurationId != null) {
            generator.writeKey("search_configuration_id");
            generator.write(this.searchConfigurationId);
        }

        if (this.searchConfigurationResult != null) {
            generator.writeKey("search_configuration_result");
            generator.write(this.searchConfigurationResult);
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
     * Builder for {@link PutSearchConfigurationsResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, PutSearchConfigurationsResponse> {
        @Nullable
        private String searchConfigurationId;
        @Nullable
        private String searchConfigurationResult;

        public Builder() {}

        private Builder(PutSearchConfigurationsResponse o) {
            this.searchConfigurationId = o.searchConfigurationId;
            this.searchConfigurationResult = o.searchConfigurationResult;
        }

        private Builder(Builder o) {
            this.searchConfigurationId = o.searchConfigurationId;
            this.searchConfigurationResult = o.searchConfigurationResult;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code search_configuration_id}
         */
        @Nonnull
        public final Builder searchConfigurationId(@Nullable String value) {
            this.searchConfigurationId = value;
            return this;
        }

        /**
         * API name: {@code search_configuration_result}
         */
        @Nonnull
        public final Builder searchConfigurationResult(@Nullable String value) {
            this.searchConfigurationResult = value;
            return this;
        }

        /**
         * Builds a {@link PutSearchConfigurationsResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PutSearchConfigurationsResponse build() {
            _checkSingleUse();

            return new PutSearchConfigurationsResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PutSearchConfigurationsResponse}
     */
    public static final JsonpDeserializer<PutSearchConfigurationsResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PutSearchConfigurationsResponse::setupPutSearchConfigurationsResponseDeserializer
    );

    protected static void setupPutSearchConfigurationsResponseDeserializer(ObjectDeserializer<PutSearchConfigurationsResponse.Builder> op) {
        op.add(Builder::searchConfigurationId, JsonpDeserializer.stringDeserializer(), "search_configuration_id");
        op.add(Builder::searchConfigurationResult, JsonpDeserializer.stringDeserializer(), "search_configuration_result");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.searchConfigurationId);
        result = 31 * result + Objects.hashCode(this.searchConfigurationResult);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PutSearchConfigurationsResponse other = (PutSearchConfigurationsResponse) o;
        return Objects.equals(this.searchConfigurationId, other.searchConfigurationId)
            && Objects.equals(this.searchConfigurationResult, other.searchConfigurationResult);
    }
}
