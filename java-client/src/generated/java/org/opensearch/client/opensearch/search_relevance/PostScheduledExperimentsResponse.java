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

// typedef: search_relevance.post_scheduled_experiments.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class PostScheduledExperimentsResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<PostScheduledExperimentsResponse.Builder, PostScheduledExperimentsResponse> {

    @Nullable
    private final String jobId;

    @Nullable
    private final String jobResult;

    // ---------------------------------------------------------------------------------------------

    private PostScheduledExperimentsResponse(Builder builder) {
        this.jobId = builder.jobId;
        this.jobResult = builder.jobResult;
    }

    public static PostScheduledExperimentsResponse of(
        Function<PostScheduledExperimentsResponse.Builder, ObjectBuilder<PostScheduledExperimentsResponse>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code job_id}
     */
    @Nullable
    public final String jobId() {
        return this.jobId;
    }

    /**
     * API name: {@code job_result}
     */
    @Nullable
    public final String jobResult() {
        return this.jobResult;
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
        if (this.jobId != null) {
            generator.writeKey("job_id");
            generator.write(this.jobId);
        }

        if (this.jobResult != null) {
            generator.writeKey("job_result");
            generator.write(this.jobResult);
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
     * Builder for {@link PostScheduledExperimentsResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, PostScheduledExperimentsResponse> {
        @Nullable
        private String jobId;
        @Nullable
        private String jobResult;

        public Builder() {}

        private Builder(PostScheduledExperimentsResponse o) {
            this.jobId = o.jobId;
            this.jobResult = o.jobResult;
        }

        private Builder(Builder o) {
            this.jobId = o.jobId;
            this.jobResult = o.jobResult;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code job_id}
         */
        @Nonnull
        public final Builder jobId(@Nullable String value) {
            this.jobId = value;
            return this;
        }

        /**
         * API name: {@code job_result}
         */
        @Nonnull
        public final Builder jobResult(@Nullable String value) {
            this.jobResult = value;
            return this;
        }

        /**
         * Builds a {@link PostScheduledExperimentsResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PostScheduledExperimentsResponse build() {
            _checkSingleUse();

            return new PostScheduledExperimentsResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PostScheduledExperimentsResponse}
     */
    public static final JsonpDeserializer<PostScheduledExperimentsResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PostScheduledExperimentsResponse::setupPostScheduledExperimentsResponseDeserializer
    );

    protected static void setupPostScheduledExperimentsResponseDeserializer(
        ObjectDeserializer<PostScheduledExperimentsResponse.Builder> op
    ) {
        op.add(Builder::jobId, JsonpDeserializer.stringDeserializer(), "job_id");
        op.add(Builder::jobResult, JsonpDeserializer.stringDeserializer(), "job_result");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.jobId);
        result = 31 * result + Objects.hashCode(this.jobResult);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PostScheduledExperimentsResponse other = (PostScheduledExperimentsResponse) o;
        return Objects.equals(this.jobId, other.jobId) && Objects.equals(this.jobResult, other.jobResult);
    }
}
