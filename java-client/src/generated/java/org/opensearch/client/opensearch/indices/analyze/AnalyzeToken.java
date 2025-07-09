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

package org.opensearch.client.opensearch.indices.analyze;

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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: indices.analyze.AnalyzeToken

/**
 * The basic token information.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class AnalyzeToken implements PlainJsonSerializable, ToCopyableBuilder<AnalyzeToken.Builder, AnalyzeToken> {

    private final int endOffset;

    private final int position;

    @Nullable
    private final Integer positionLength;

    private final int startOffset;

    @Nonnull
    private final String token;

    @Nonnull
    private final String type;

    // ---------------------------------------------------------------------------------------------

    private AnalyzeToken(Builder builder) {
        this.endOffset = ApiTypeHelper.requireNonNull(builder.endOffset, this, "endOffset");
        this.position = ApiTypeHelper.requireNonNull(builder.position, this, "position");
        this.positionLength = builder.positionLength;
        this.startOffset = ApiTypeHelper.requireNonNull(builder.startOffset, this, "startOffset");
        this.token = ApiTypeHelper.requireNonNull(builder.token, this, "token");
        this.type = ApiTypeHelper.requireNonNull(builder.type, this, "type");
    }

    public static AnalyzeToken of(Function<AnalyzeToken.Builder, ObjectBuilder<AnalyzeToken>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The ending character offset of the token.
     * <p>
     * API name: {@code end_offset}
     * </p>
     */
    public final int endOffset() {
        return this.endOffset;
    }

    /**
     * Required - The position of the token.
     * <p>
     * API name: {@code position}
     * </p>
     */
    public final int position() {
        return this.position;
    }

    /**
     * The length of the token position.
     * <p>
     * API name: {@code positionLength}
     * </p>
     */
    @Nullable
    public final Integer positionLength() {
        return this.positionLength;
    }

    /**
     * Required - The starting character offset of the token.
     * <p>
     * API name: {@code start_offset}
     * </p>
     */
    public final int startOffset() {
        return this.startOffset;
    }

    /**
     * Required - The token string.
     * <p>
     * API name: {@code token}
     * </p>
     */
    @Nonnull
    public final String token() {
        return this.token;
    }

    /**
     * Required - The type of the token.
     * <p>
     * API name: {@code type}
     * </p>
     */
    @Nonnull
    public final String type() {
        return this.type;
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
        generator.writeKey("end_offset");
        generator.write(this.endOffset);

        generator.writeKey("position");
        generator.write(this.position);

        if (this.positionLength != null) {
            generator.writeKey("positionLength");
            generator.write(this.positionLength);
        }

        generator.writeKey("start_offset");
        generator.write(this.startOffset);

        generator.writeKey("token");
        generator.write(this.token);

        generator.writeKey("type");
        generator.write(this.type);
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
     * Builder for {@link AnalyzeToken}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, AnalyzeToken> {
        private Integer endOffset;
        private Integer position;
        @Nullable
        private Integer positionLength;
        private Integer startOffset;
        private String token;
        private String type;

        public Builder() {}

        private Builder(AnalyzeToken o) {
            this.endOffset = o.endOffset;
            this.position = o.position;
            this.positionLength = o.positionLength;
            this.startOffset = o.startOffset;
            this.token = o.token;
            this.type = o.type;
        }

        private Builder(Builder o) {
            this.endOffset = o.endOffset;
            this.position = o.position;
            this.positionLength = o.positionLength;
            this.startOffset = o.startOffset;
            this.token = o.token;
            this.type = o.type;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - The ending character offset of the token.
         * <p>
         * API name: {@code end_offset}
         * </p>
         */
        @Nonnull
        public final Builder endOffset(int value) {
            this.endOffset = value;
            return this;
        }

        /**
         * Required - The position of the token.
         * <p>
         * API name: {@code position}
         * </p>
         */
        @Nonnull
        public final Builder position(int value) {
            this.position = value;
            return this;
        }

        /**
         * The length of the token position.
         * <p>
         * API name: {@code positionLength}
         * </p>
         */
        @Nonnull
        public final Builder positionLength(@Nullable Integer value) {
            this.positionLength = value;
            return this;
        }

        /**
         * Required - The starting character offset of the token.
         * <p>
         * API name: {@code start_offset}
         * </p>
         */
        @Nonnull
        public final Builder startOffset(int value) {
            this.startOffset = value;
            return this;
        }

        /**
         * Required - The token string.
         * <p>
         * API name: {@code token}
         * </p>
         */
        @Nonnull
        public final Builder token(String value) {
            this.token = value;
            return this;
        }

        /**
         * Required - The type of the token.
         * <p>
         * API name: {@code type}
         * </p>
         */
        @Nonnull
        public final Builder type(String value) {
            this.type = value;
            return this;
        }

        /**
         * Builds a {@link AnalyzeToken}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public AnalyzeToken build() {
            _checkSingleUse();

            return new AnalyzeToken(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link AnalyzeToken}
     */
    public static final JsonpDeserializer<AnalyzeToken> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        AnalyzeToken::setupAnalyzeTokenDeserializer
    );

    protected static void setupAnalyzeTokenDeserializer(ObjectDeserializer<AnalyzeToken.Builder> op) {
        op.add(Builder::endOffset, JsonpDeserializer.integerDeserializer(), "end_offset");
        op.add(Builder::position, JsonpDeserializer.integerDeserializer(), "position");
        op.add(Builder::positionLength, JsonpDeserializer.integerDeserializer(), "positionLength");
        op.add(Builder::startOffset, JsonpDeserializer.integerDeserializer(), "start_offset");
        op.add(Builder::token, JsonpDeserializer.stringDeserializer(), "token");
        op.add(Builder::type, JsonpDeserializer.stringDeserializer(), "type");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Integer.hashCode(this.endOffset);
        result = 31 * result + Integer.hashCode(this.position);
        result = 31 * result + Objects.hashCode(this.positionLength);
        result = 31 * result + Integer.hashCode(this.startOffset);
        result = 31 * result + this.token.hashCode();
        result = 31 * result + this.type.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        AnalyzeToken other = (AnalyzeToken) o;
        return this.endOffset == other.endOffset
            && this.position == other.position
            && Objects.equals(this.positionLength, other.positionLength)
            && this.startOffset == other.startOffset
            && this.token.equals(other.token)
            && this.type.equals(other.type);
    }
}
