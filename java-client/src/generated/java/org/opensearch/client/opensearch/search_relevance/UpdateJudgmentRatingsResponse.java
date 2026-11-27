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

// typedef: search_relevance.update_judgment_ratings.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class UpdateJudgmentRatingsResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<UpdateJudgmentRatingsResponse.Builder, UpdateJudgmentRatingsResponse> {

    @Nullable
    private final String judgmentId;

    @Nullable
    private final String result;

    // ---------------------------------------------------------------------------------------------

    private UpdateJudgmentRatingsResponse(Builder builder) {
        this.judgmentId = builder.judgmentId;
        this.result = builder.result;
    }

    public static UpdateJudgmentRatingsResponse of(
        Function<UpdateJudgmentRatingsResponse.Builder, ObjectBuilder<UpdateJudgmentRatingsResponse>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code judgment_id}
     */
    @Nullable
    public final String judgmentId() {
        return this.judgmentId;
    }

    /**
     * API name: {@code result}
     */
    @Nullable
    public final String result() {
        return this.result;
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
        if (this.judgmentId != null) {
            generator.writeKey("judgment_id");
            generator.write(this.judgmentId);
        }

        if (this.result != null) {
            generator.writeKey("result");
            generator.write(this.result);
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
     * Builder for {@link UpdateJudgmentRatingsResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, UpdateJudgmentRatingsResponse> {
        @Nullable
        private String judgmentId;
        @Nullable
        private String result;

        public Builder() {}

        private Builder(UpdateJudgmentRatingsResponse o) {
            this.judgmentId = o.judgmentId;
            this.result = o.result;
        }

        private Builder(Builder o) {
            this.judgmentId = o.judgmentId;
            this.result = o.result;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code judgment_id}
         */
        @Nonnull
        public final Builder judgmentId(@Nullable String value) {
            this.judgmentId = value;
            return this;
        }

        /**
         * API name: {@code result}
         */
        @Nonnull
        public final Builder result(@Nullable String value) {
            this.result = value;
            return this;
        }

        /**
         * Builds a {@link UpdateJudgmentRatingsResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public UpdateJudgmentRatingsResponse build() {
            _checkSingleUse();

            return new UpdateJudgmentRatingsResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link UpdateJudgmentRatingsResponse}
     */
    public static final JsonpDeserializer<UpdateJudgmentRatingsResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        UpdateJudgmentRatingsResponse::setupUpdateJudgmentRatingsResponseDeserializer
    );

    protected static void setupUpdateJudgmentRatingsResponseDeserializer(ObjectDeserializer<UpdateJudgmentRatingsResponse.Builder> op) {
        op.add(Builder::judgmentId, JsonpDeserializer.stringDeserializer(), "judgment_id");
        op.add(Builder::result, JsonpDeserializer.stringDeserializer(), "result");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.judgmentId);
        result = 31 * result + Objects.hashCode(this.result);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        UpdateJudgmentRatingsResponse other = (UpdateJudgmentRatingsResponse) o;
        return Objects.equals(this.judgmentId, other.judgmentId) && Objects.equals(this.result, other.result);
    }
}
