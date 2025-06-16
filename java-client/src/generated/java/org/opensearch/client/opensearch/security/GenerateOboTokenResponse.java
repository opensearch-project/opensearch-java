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

package org.opensearch.client.opensearch.security;

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

// typedef: security.generate_obo_token.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GenerateOboTokenResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<GenerateOboTokenResponse.Builder, GenerateOboTokenResponse> {

    @Nullable
    private final String authenticationToken;

    @Nullable
    private final String durationSeconds;

    @Nullable
    private final String user;

    // ---------------------------------------------------------------------------------------------

    private GenerateOboTokenResponse(Builder builder) {
        this.authenticationToken = builder.authenticationToken;
        this.durationSeconds = builder.durationSeconds;
        this.user = builder.user;
    }

    public static GenerateOboTokenResponse of(Function<GenerateOboTokenResponse.Builder, ObjectBuilder<GenerateOboTokenResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The generated OBO token.
     * <p>
     * API name: {@code authenticationToken}
     * </p>
     */
    @Nullable
    public final String authenticationToken() {
        return this.authenticationToken;
    }

    /**
     * The duration of the token.
     * <p>
     * API name: {@code durationSeconds}
     * </p>
     */
    @Nullable
    public final String durationSeconds() {
        return this.durationSeconds;
    }

    /**
     * The name of the entity requesting token.
     * <p>
     * API name: {@code user}
     * </p>
     */
    @Nullable
    public final String user() {
        return this.user;
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
        if (this.authenticationToken != null) {
            generator.writeKey("authenticationToken");
            generator.write(this.authenticationToken);
        }

        if (this.durationSeconds != null) {
            generator.writeKey("durationSeconds");
            generator.write(this.durationSeconds);
        }

        if (this.user != null) {
            generator.writeKey("user");
            generator.write(this.user);
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
     * Builder for {@link GenerateOboTokenResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, GenerateOboTokenResponse> {
        @Nullable
        private String authenticationToken;
        @Nullable
        private String durationSeconds;
        @Nullable
        private String user;

        public Builder() {}

        private Builder(GenerateOboTokenResponse o) {
            this.authenticationToken = o.authenticationToken;
            this.durationSeconds = o.durationSeconds;
            this.user = o.user;
        }

        private Builder(Builder o) {
            this.authenticationToken = o.authenticationToken;
            this.durationSeconds = o.durationSeconds;
            this.user = o.user;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The generated OBO token.
         * <p>
         * API name: {@code authenticationToken}
         * </p>
         */
        @Nonnull
        public final Builder authenticationToken(@Nullable String value) {
            this.authenticationToken = value;
            return this;
        }

        /**
         * The duration of the token.
         * <p>
         * API name: {@code durationSeconds}
         * </p>
         */
        @Nonnull
        public final Builder durationSeconds(@Nullable String value) {
            this.durationSeconds = value;
            return this;
        }

        /**
         * The name of the entity requesting token.
         * <p>
         * API name: {@code user}
         * </p>
         */
        @Nonnull
        public final Builder user(@Nullable String value) {
            this.user = value;
            return this;
        }

        /**
         * Builds a {@link GenerateOboTokenResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GenerateOboTokenResponse build() {
            _checkSingleUse();

            return new GenerateOboTokenResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GenerateOboTokenResponse}
     */
    public static final JsonpDeserializer<GenerateOboTokenResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GenerateOboTokenResponse::setupGenerateOboTokenResponseDeserializer
    );

    protected static void setupGenerateOboTokenResponseDeserializer(ObjectDeserializer<GenerateOboTokenResponse.Builder> op) {
        op.add(Builder::authenticationToken, JsonpDeserializer.stringDeserializer(), "authenticationToken");
        op.add(Builder::durationSeconds, JsonpDeserializer.stringDeserializer(), "durationSeconds");
        op.add(Builder::user, JsonpDeserializer.stringDeserializer(), "user");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.authenticationToken);
        result = 31 * result + Objects.hashCode(this.durationSeconds);
        result = 31 * result + Objects.hashCode(this.user);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GenerateOboTokenResponse other = (GenerateOboTokenResponse) o;
        return Objects.equals(this.authenticationToken, other.authenticationToken)
            && Objects.equals(this.durationSeconds, other.durationSeconds)
            && Objects.equals(this.user, other.user);
    }
}
