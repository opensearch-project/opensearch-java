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

// typedef: indices.analyze.ExplainAnalyzeToken

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ExplainAnalyzeToken implements PlainJsonSerializable, ToCopyableBuilder<ExplainAnalyzeToken.Builder, ExplainAnalyzeToken> {

    @Nonnull
    private final String bytes;

    private final int endOffset;

    @Nullable
    private final Boolean keyword;

    private final int position;

    private final int positionLength;

    private final int startOffset;

    private final int termFrequency;

    @Nonnull
    private final String token;

    @Nonnull
    private final String type;

    // ---------------------------------------------------------------------------------------------

    private ExplainAnalyzeToken(Builder builder) {
        this.bytes = ApiTypeHelper.requireNonNull(builder.bytes, this, "bytes");
        this.endOffset = ApiTypeHelper.requireNonNull(builder.endOffset, this, "endOffset");
        this.keyword = builder.keyword;
        this.position = ApiTypeHelper.requireNonNull(builder.position, this, "position");
        this.positionLength = ApiTypeHelper.requireNonNull(builder.positionLength, this, "positionLength");
        this.startOffset = ApiTypeHelper.requireNonNull(builder.startOffset, this, "startOffset");
        this.termFrequency = ApiTypeHelper.requireNonNull(builder.termFrequency, this, "termFrequency");
        this.token = ApiTypeHelper.requireNonNull(builder.token, this, "token");
        this.type = ApiTypeHelper.requireNonNull(builder.type, this, "type");
    }

    public static ExplainAnalyzeToken of(Function<ExplainAnalyzeToken.Builder, ObjectBuilder<ExplainAnalyzeToken>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code bytes}
     */
    @Nonnull
    public final String bytes() {
        return this.bytes;
    }

    /**
     * Required - API name: {@code end_offset}
     */
    public final int endOffset() {
        return this.endOffset;
    }

    /**
     * API name: {@code keyword}
     */
    @Nullable
    public final Boolean keyword() {
        return this.keyword;
    }

    /**
     * Required - API name: {@code position}
     */
    public final int position() {
        return this.position;
    }

    /**
     * Required - API name: {@code positionLength}
     */
    public final int positionLength() {
        return this.positionLength;
    }

    /**
     * Required - API name: {@code start_offset}
     */
    public final int startOffset() {
        return this.startOffset;
    }

    /**
     * Required - API name: {@code termFrequency}
     */
    public final int termFrequency() {
        return this.termFrequency;
    }

    /**
     * Required - API name: {@code token}
     */
    @Nonnull
    public final String token() {
        return this.token;
    }

    /**
     * Required - API name: {@code type}
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
        generator.writeKey("bytes");
        generator.write(this.bytes);

        generator.writeKey("end_offset");
        generator.write(this.endOffset);

        if (this.keyword != null) {
            generator.writeKey("keyword");
            generator.write(this.keyword);
        }

        generator.writeKey("position");
        generator.write(this.position);

        generator.writeKey("positionLength");
        generator.write(this.positionLength);

        generator.writeKey("start_offset");
        generator.write(this.startOffset);

        generator.writeKey("termFrequency");
        generator.write(this.termFrequency);

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
     * Builder for {@link ExplainAnalyzeToken}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ExplainAnalyzeToken> {
        private String bytes;
        private Integer endOffset;
        @Nullable
        private Boolean keyword;
        private Integer position;
        private Integer positionLength;
        private Integer startOffset;
        private Integer termFrequency;
        private String token;
        private String type;

        public Builder() {}

        private Builder(ExplainAnalyzeToken o) {
            this.bytes = o.bytes;
            this.endOffset = o.endOffset;
            this.keyword = o.keyword;
            this.position = o.position;
            this.positionLength = o.positionLength;
            this.startOffset = o.startOffset;
            this.termFrequency = o.termFrequency;
            this.token = o.token;
            this.type = o.type;
        }

        private Builder(Builder o) {
            this.bytes = o.bytes;
            this.endOffset = o.endOffset;
            this.keyword = o.keyword;
            this.position = o.position;
            this.positionLength = o.positionLength;
            this.startOffset = o.startOffset;
            this.termFrequency = o.termFrequency;
            this.token = o.token;
            this.type = o.type;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code bytes}
         */
        @Nonnull
        public final Builder bytes(String value) {
            this.bytes = value;
            return this;
        }

        /**
         * Required - API name: {@code end_offset}
         */
        @Nonnull
        public final Builder endOffset(int value) {
            this.endOffset = value;
            return this;
        }

        /**
         * API name: {@code keyword}
         */
        @Nonnull
        public final Builder keyword(@Nullable Boolean value) {
            this.keyword = value;
            return this;
        }

        /**
         * Required - API name: {@code position}
         */
        @Nonnull
        public final Builder position(int value) {
            this.position = value;
            return this;
        }

        /**
         * Required - API name: {@code positionLength}
         */
        @Nonnull
        public final Builder positionLength(int value) {
            this.positionLength = value;
            return this;
        }

        /**
         * Required - API name: {@code start_offset}
         */
        @Nonnull
        public final Builder startOffset(int value) {
            this.startOffset = value;
            return this;
        }

        /**
         * Required - API name: {@code termFrequency}
         */
        @Nonnull
        public final Builder termFrequency(int value) {
            this.termFrequency = value;
            return this;
        }

        /**
         * Required - API name: {@code token}
         */
        @Nonnull
        public final Builder token(String value) {
            this.token = value;
            return this;
        }

        /**
         * Required - API name: {@code type}
         */
        @Nonnull
        public final Builder type(String value) {
            this.type = value;
            return this;
        }

        /**
         * Builds a {@link ExplainAnalyzeToken}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ExplainAnalyzeToken build() {
            _checkSingleUse();

            return new ExplainAnalyzeToken(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ExplainAnalyzeToken}
     */
    public static final JsonpDeserializer<ExplainAnalyzeToken> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ExplainAnalyzeToken::setupExplainAnalyzeTokenDeserializer
    );

    protected static void setupExplainAnalyzeTokenDeserializer(ObjectDeserializer<ExplainAnalyzeToken.Builder> op) {
        op.add(Builder::bytes, JsonpDeserializer.stringDeserializer(), "bytes");
        op.add(Builder::endOffset, JsonpDeserializer.integerDeserializer(), "end_offset");
        op.add(Builder::keyword, JsonpDeserializer.booleanDeserializer(), "keyword");
        op.add(Builder::position, JsonpDeserializer.integerDeserializer(), "position");
        op.add(Builder::positionLength, JsonpDeserializer.integerDeserializer(), "positionLength");
        op.add(Builder::startOffset, JsonpDeserializer.integerDeserializer(), "start_offset");
        op.add(Builder::termFrequency, JsonpDeserializer.integerDeserializer(), "termFrequency");
        op.add(Builder::token, JsonpDeserializer.stringDeserializer(), "token");
        op.add(Builder::type, JsonpDeserializer.stringDeserializer(), "type");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.bytes.hashCode();
        result = 31 * result + Integer.hashCode(this.endOffset);
        result = 31 * result + Objects.hashCode(this.keyword);
        result = 31 * result + Integer.hashCode(this.position);
        result = 31 * result + Integer.hashCode(this.positionLength);
        result = 31 * result + Integer.hashCode(this.startOffset);
        result = 31 * result + Integer.hashCode(this.termFrequency);
        result = 31 * result + this.token.hashCode();
        result = 31 * result + this.type.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ExplainAnalyzeToken other = (ExplainAnalyzeToken) o;
        return this.bytes.equals(other.bytes)
            && this.endOffset == other.endOffset
            && Objects.equals(this.keyword, other.keyword)
            && this.position == other.position
            && this.positionLength == other.positionLength
            && this.startOffset == other.startOffset
            && this.termFrequency == other.termFrequency
            && this.token.equals(other.token)
            && this.type.equals(other.type);
    }
}
