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

// typedef: indices.IndexSettingsSearchConcurrentSegmentSearch

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IndexSettingsSearchConcurrentSegmentSearch
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<IndexSettingsSearchConcurrentSegmentSearch.Builder, IndexSettingsSearchConcurrentSegmentSearch> {

    @Nullable
    private final Boolean enabled;

    @Nullable
    private final String mode;

    // ---------------------------------------------------------------------------------------------

    private IndexSettingsSearchConcurrentSegmentSearch(Builder builder) {
        this.enabled = builder.enabled;
        this.mode = builder.mode;
    }

    public static IndexSettingsSearchConcurrentSegmentSearch of(
        Function<IndexSettingsSearchConcurrentSegmentSearch.Builder, ObjectBuilder<IndexSettingsSearchConcurrentSegmentSearch>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code enabled}
     */
    @Nullable
    public final Boolean enabled() {
        return this.enabled;
    }

    /**
     * API name: {@code mode}
     */
    @Nullable
    public final String mode() {
        return this.mode;
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
        if (this.enabled != null) {
            generator.writeKey("enabled");
            generator.write(this.enabled);
        }

        if (this.mode != null) {
            generator.writeKey("mode");
            generator.write(this.mode);
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
     * Builder for {@link IndexSettingsSearchConcurrentSegmentSearch}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IndexSettingsSearchConcurrentSegmentSearch> {
        @Nullable
        private Boolean enabled;
        @Nullable
        private String mode;

        public Builder() {}

        private Builder(IndexSettingsSearchConcurrentSegmentSearch o) {
            this.enabled = o.enabled;
            this.mode = o.mode;
        }

        private Builder(Builder o) {
            this.enabled = o.enabled;
            this.mode = o.mode;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code enabled}
         */
        @Nonnull
        public final Builder enabled(@Nullable Boolean value) {
            this.enabled = value;
            return this;
        }

        /**
         * API name: {@code mode}
         */
        @Nonnull
        public final Builder mode(@Nullable String value) {
            this.mode = value;
            return this;
        }

        /**
         * Builds a {@link IndexSettingsSearchConcurrentSegmentSearch}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IndexSettingsSearchConcurrentSegmentSearch build() {
            _checkSingleUse();

            return new IndexSettingsSearchConcurrentSegmentSearch(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IndexSettingsSearchConcurrentSegmentSearch}
     */
    public static final JsonpDeserializer<IndexSettingsSearchConcurrentSegmentSearch> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IndexSettingsSearchConcurrentSegmentSearch::setupIndexSettingsSearchConcurrentSegmentSearchDeserializer
    );

    protected static void setupIndexSettingsSearchConcurrentSegmentSearchDeserializer(
        ObjectDeserializer<IndexSettingsSearchConcurrentSegmentSearch.Builder> op
    ) {
        op.add(Builder::enabled, JsonpDeserializer.booleanDeserializer(), "enabled");
        op.add(Builder::mode, JsonpDeserializer.stringDeserializer(), "mode");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.enabled);
        result = 31 * result + Objects.hashCode(this.mode);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IndexSettingsSearchConcurrentSegmentSearch other = (IndexSettingsSearchConcurrentSegmentSearch) o;
        return Objects.equals(this.enabled, other.enabled) && Objects.equals(this.mode, other.mode);
    }
}