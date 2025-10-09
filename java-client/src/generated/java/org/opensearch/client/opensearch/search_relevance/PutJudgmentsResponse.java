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

// typedef: search_relevance.put_judgments.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class PutJudgmentsResponse implements PlainJsonSerializable, ToCopyableBuilder<PutJudgmentsResponse.Builder, PutJudgmentsResponse> {

    @Nullable
    private final String judgmentId;

    // ---------------------------------------------------------------------------------------------

    private PutJudgmentsResponse(Builder builder) {
        this.judgmentId = builder.judgmentId;
    }

    public static PutJudgmentsResponse of(Function<PutJudgmentsResponse.Builder, ObjectBuilder<PutJudgmentsResponse>> fn) {
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
     * Builder for {@link PutJudgmentsResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, PutJudgmentsResponse> {
        @Nullable
        private String judgmentId;

        public Builder() {}

        private Builder(PutJudgmentsResponse o) {
            this.judgmentId = o.judgmentId;
        }

        private Builder(Builder o) {
            this.judgmentId = o.judgmentId;
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
         * Builds a {@link PutJudgmentsResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PutJudgmentsResponse build() {
            _checkSingleUse();

            return new PutJudgmentsResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PutJudgmentsResponse}
     */
    public static final JsonpDeserializer<PutJudgmentsResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PutJudgmentsResponse::setupPutJudgmentsResponseDeserializer
    );

    protected static void setupPutJudgmentsResponseDeserializer(ObjectDeserializer<PutJudgmentsResponse.Builder> op) {
        op.add(Builder::judgmentId, JsonpDeserializer.stringDeserializer(), "judgment_id");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.judgmentId);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PutJudgmentsResponse other = (PutJudgmentsResponse) o;
        return Objects.equals(this.judgmentId, other.judgmentId);
    }
}
