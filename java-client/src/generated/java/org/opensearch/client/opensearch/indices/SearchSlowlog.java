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

// typedef: indices.SearchSlowlog

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SearchSlowlog implements PlainJsonSerializable, ToCopyableBuilder<SearchSlowlog.Builder, SearchSlowlog> {

    @Nullable
    private final String level;

    @Nullable
    private final Boolean reformat;

    @Nullable
    private final SearchSlowlogThresholds threshold;

    // ---------------------------------------------------------------------------------------------

    private SearchSlowlog(Builder builder) {
        this.level = builder.level;
        this.reformat = builder.reformat;
        this.threshold = builder.threshold;
    }

    public static SearchSlowlog of(Function<SearchSlowlog.Builder, ObjectBuilder<SearchSlowlog>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code level}
     */
    @Nullable
    public final String level() {
        return this.level;
    }

    /**
     * API name: {@code reformat}
     */
    @Nullable
    public final Boolean reformat() {
        return this.reformat;
    }

    /**
     * API name: {@code threshold}
     */
    @Nullable
    public final SearchSlowlogThresholds threshold() {
        return this.threshold;
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
        if (this.level != null) {
            generator.writeKey("level");
            generator.write(this.level);
        }

        if (this.reformat != null) {
            generator.writeKey("reformat");
            generator.write(this.reformat);
        }

        if (this.threshold != null) {
            generator.writeKey("threshold");
            this.threshold.serialize(generator, mapper);
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
     * Builder for {@link SearchSlowlog}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, SearchSlowlog> {
        @Nullable
        private String level;
        @Nullable
        private Boolean reformat;
        @Nullable
        private SearchSlowlogThresholds threshold;

        public Builder() {}

        private Builder(SearchSlowlog o) {
            this.level = o.level;
            this.reformat = o.reformat;
            this.threshold = o.threshold;
        }

        private Builder(Builder o) {
            this.level = o.level;
            this.reformat = o.reformat;
            this.threshold = o.threshold;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code level}
         */
        @Nonnull
        public final Builder level(@Nullable String value) {
            this.level = value;
            return this;
        }

        /**
         * API name: {@code reformat}
         */
        @Nonnull
        public final Builder reformat(@Nullable Boolean value) {
            this.reformat = value;
            return this;
        }

        /**
         * API name: {@code threshold}
         */
        @Nonnull
        public final Builder threshold(@Nullable SearchSlowlogThresholds value) {
            this.threshold = value;
            return this;
        }

        /**
         * API name: {@code threshold}
         */
        @Nonnull
        public final Builder threshold(Function<SearchSlowlogThresholds.Builder, ObjectBuilder<SearchSlowlogThresholds>> fn) {
            return threshold(fn.apply(new SearchSlowlogThresholds.Builder()).build());
        }

        /**
         * Builds a {@link SearchSlowlog}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SearchSlowlog build() {
            _checkSingleUse();

            return new SearchSlowlog(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SearchSlowlog}
     */
    public static final JsonpDeserializer<SearchSlowlog> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SearchSlowlog::setupSearchSlowlogDeserializer
    );

    protected static void setupSearchSlowlogDeserializer(ObjectDeserializer<SearchSlowlog.Builder> op) {
        op.add(Builder::level, JsonpDeserializer.stringDeserializer(), "level");
        op.add(Builder::reformat, JsonpDeserializer.booleanDeserializer(), "reformat");
        op.add(Builder::threshold, SearchSlowlogThresholds._DESERIALIZER, "threshold");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.level);
        result = 31 * result + Objects.hashCode(this.reformat);
        result = 31 * result + Objects.hashCode(this.threshold);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SearchSlowlog other = (SearchSlowlog) o;
        return Objects.equals(this.level, other.level)
            && Objects.equals(this.reformat, other.reformat)
            && Objects.equals(this.threshold, other.threshold);
    }
}
