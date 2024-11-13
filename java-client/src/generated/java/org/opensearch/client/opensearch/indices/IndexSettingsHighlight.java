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

package org.opensearch.client.opensearch.indices;

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

// typedef: indices.IndexSettingsHighlight

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IndexSettingsHighlight
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<IndexSettingsHighlight.Builder, IndexSettingsHighlight> {

    @Nullable
    private final Integer maxAnalyzedOffset;

    // ---------------------------------------------------------------------------------------------

    private IndexSettingsHighlight(Builder builder) {
        this.maxAnalyzedOffset = builder.maxAnalyzedOffset;
    }

    public static IndexSettingsHighlight of(Function<IndexSettingsHighlight.Builder, ObjectBuilder<IndexSettingsHighlight>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code max_analyzed_offset}
     */
    @Nullable
    public final Integer maxAnalyzedOffset() {
        return this.maxAnalyzedOffset;
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
        if (this.maxAnalyzedOffset != null) {
            generator.writeKey("max_analyzed_offset");
            generator.write(this.maxAnalyzedOffset);
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
     * Builder for {@link IndexSettingsHighlight}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IndexSettingsHighlight> {
        @Nullable
        private Integer maxAnalyzedOffset;

        public Builder() {}

        private Builder(IndexSettingsHighlight o) {
            this.maxAnalyzedOffset = o.maxAnalyzedOffset;
        }

        private Builder(Builder o) {
            this.maxAnalyzedOffset = o.maxAnalyzedOffset;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code max_analyzed_offset}
         */
        @Nonnull
        public final Builder maxAnalyzedOffset(@Nullable Integer value) {
            this.maxAnalyzedOffset = value;
            return this;
        }

        /**
         * Builds a {@link IndexSettingsHighlight}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IndexSettingsHighlight build() {
            _checkSingleUse();

            return new IndexSettingsHighlight(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IndexSettingsHighlight}
     */
    public static final JsonpDeserializer<IndexSettingsHighlight> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IndexSettingsHighlight::setupIndexSettingsHighlightDeserializer
    );

    protected static void setupIndexSettingsHighlightDeserializer(ObjectDeserializer<IndexSettingsHighlight.Builder> op) {
        op.add(Builder::maxAnalyzedOffset, JsonpDeserializer.integerDeserializer(), "max_analyzed_offset");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.maxAnalyzedOffset);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IndexSettingsHighlight other = (IndexSettingsHighlight) o;
        return Objects.equals(this.maxAnalyzedOffset, other.maxAnalyzedOffset);
    }
}
