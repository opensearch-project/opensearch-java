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

package org.opensearch.client.opensearch.core.search;

import jakarta.json.stream.JsonGenerator;
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

// typedef: core.search.SuggestFuzziness

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SuggestFuzziness implements PlainJsonSerializable, ToCopyableBuilder<SuggestFuzziness.Builder, SuggestFuzziness> {

    @Nonnull
    private final String fuzziness;

    private final int minLength;

    private final int prefixLength;

    private final boolean transpositions;

    private final boolean unicodeAware;

    // ---------------------------------------------------------------------------------------------

    private SuggestFuzziness(Builder builder) {
        this.fuzziness = ApiTypeHelper.requireNonNull(builder.fuzziness, this, "fuzziness");
        this.minLength = ApiTypeHelper.requireNonNull(builder.minLength, this, "minLength");
        this.prefixLength = ApiTypeHelper.requireNonNull(builder.prefixLength, this, "prefixLength");
        this.transpositions = ApiTypeHelper.requireNonNull(builder.transpositions, this, "transpositions");
        this.unicodeAware = ApiTypeHelper.requireNonNull(builder.unicodeAware, this, "unicodeAware");
    }

    public static SuggestFuzziness of(Function<SuggestFuzziness.Builder, ObjectBuilder<SuggestFuzziness>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code fuzziness}
     */
    @Nonnull
    public final String fuzziness() {
        return this.fuzziness;
    }

    /**
     * Required - API name: {@code min_length}
     */
    public final int minLength() {
        return this.minLength;
    }

    /**
     * Required - API name: {@code prefix_length}
     */
    public final int prefixLength() {
        return this.prefixLength;
    }

    /**
     * Required - API name: {@code transpositions}
     */
    public final boolean transpositions() {
        return this.transpositions;
    }

    /**
     * Required - API name: {@code unicode_aware}
     */
    public final boolean unicodeAware() {
        return this.unicodeAware;
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
        generator.writeKey("fuzziness");
        generator.write(this.fuzziness);

        generator.writeKey("min_length");
        generator.write(this.minLength);

        generator.writeKey("prefix_length");
        generator.write(this.prefixLength);

        generator.writeKey("transpositions");
        generator.write(this.transpositions);

        generator.writeKey("unicode_aware");
        generator.write(this.unicodeAware);
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
     * Builder for {@link SuggestFuzziness}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, SuggestFuzziness> {
        private String fuzziness;
        private Integer minLength;
        private Integer prefixLength;
        private Boolean transpositions;
        private Boolean unicodeAware;

        public Builder() {}

        private Builder(SuggestFuzziness o) {
            this.fuzziness = o.fuzziness;
            this.minLength = o.minLength;
            this.prefixLength = o.prefixLength;
            this.transpositions = o.transpositions;
            this.unicodeAware = o.unicodeAware;
        }

        private Builder(Builder o) {
            this.fuzziness = o.fuzziness;
            this.minLength = o.minLength;
            this.prefixLength = o.prefixLength;
            this.transpositions = o.transpositions;
            this.unicodeAware = o.unicodeAware;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code fuzziness}
         */
        @Nonnull
        public final Builder fuzziness(String value) {
            this.fuzziness = value;
            return this;
        }

        /**
         * Required - API name: {@code min_length}
         */
        @Nonnull
        public final Builder minLength(int value) {
            this.minLength = value;
            return this;
        }

        /**
         * Required - API name: {@code prefix_length}
         */
        @Nonnull
        public final Builder prefixLength(int value) {
            this.prefixLength = value;
            return this;
        }

        /**
         * Required - API name: {@code transpositions}
         */
        @Nonnull
        public final Builder transpositions(boolean value) {
            this.transpositions = value;
            return this;
        }

        /**
         * Required - API name: {@code unicode_aware}
         */
        @Nonnull
        public final Builder unicodeAware(boolean value) {
            this.unicodeAware = value;
            return this;
        }

        /**
         * Builds a {@link SuggestFuzziness}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SuggestFuzziness build() {
            _checkSingleUse();

            return new SuggestFuzziness(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SuggestFuzziness}
     */
    public static final JsonpDeserializer<SuggestFuzziness> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SuggestFuzziness::setupSuggestFuzzinessDeserializer
    );

    protected static void setupSuggestFuzzinessDeserializer(ObjectDeserializer<SuggestFuzziness.Builder> op) {
        op.add(Builder::fuzziness, JsonpDeserializer.stringDeserializer(), "fuzziness");
        op.add(Builder::minLength, JsonpDeserializer.integerDeserializer(), "min_length");
        op.add(Builder::prefixLength, JsonpDeserializer.integerDeserializer(), "prefix_length");
        op.add(Builder::transpositions, JsonpDeserializer.booleanDeserializer(), "transpositions");
        op.add(Builder::unicodeAware, JsonpDeserializer.booleanDeserializer(), "unicode_aware");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.fuzziness.hashCode();
        result = 31 * result + Integer.hashCode(this.minLength);
        result = 31 * result + Integer.hashCode(this.prefixLength);
        result = 31 * result + Boolean.hashCode(this.transpositions);
        result = 31 * result + Boolean.hashCode(this.unicodeAware);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SuggestFuzziness other = (SuggestFuzziness) o;
        return this.fuzziness.equals(other.fuzziness)
            && this.minLength == other.minLength
            && this.prefixLength == other.prefixLength
            && this.transpositions == other.transpositions
            && this.unicodeAware == other.unicodeAware;
    }
}
