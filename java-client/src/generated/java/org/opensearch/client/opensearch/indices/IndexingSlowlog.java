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

// typedef: indices.IndexingSlowlog

/**
 * The configuration for indexing slow log.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IndexingSlowlog implements PlainJsonSerializable, ToCopyableBuilder<IndexingSlowlog.Builder, IndexingSlowlog> {

    @Nullable
    private final String level;

    @Nullable
    private final Boolean reformat;

    @Nullable
    private final Integer source;

    @Nullable
    private final IndexingSlowlogThresholds threshold;

    // ---------------------------------------------------------------------------------------------

    private IndexingSlowlog(Builder builder) {
        this.level = builder.level;
        this.reformat = builder.reformat;
        this.source = builder.source;
        this.threshold = builder.threshold;
    }

    public static IndexingSlowlog of(Function<IndexingSlowlog.Builder, ObjectBuilder<IndexingSlowlog>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The log level for slow indexing operations.
     * <p>
     * API name: {@code level}
     * </p>
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
     * API name: {@code source}
     */
    @Nullable
    public final Integer source() {
        return this.source;
    }

    /**
     * API name: {@code threshold}
     */
    @Nullable
    public final IndexingSlowlogThresholds threshold() {
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

        if (this.source != null) {
            generator.writeKey("source");
            generator.write(this.source);
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
     * Builder for {@link IndexingSlowlog}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IndexingSlowlog> {
        @Nullable
        private String level;
        @Nullable
        private Boolean reformat;
        @Nullable
        private Integer source;
        @Nullable
        private IndexingSlowlogThresholds threshold;

        public Builder() {}

        private Builder(IndexingSlowlog o) {
            this.level = o.level;
            this.reformat = o.reformat;
            this.source = o.source;
            this.threshold = o.threshold;
        }

        private Builder(Builder o) {
            this.level = o.level;
            this.reformat = o.reformat;
            this.source = o.source;
            this.threshold = o.threshold;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The log level for slow indexing operations.
         * <p>
         * API name: {@code level}
         * </p>
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
         * API name: {@code source}
         */
        @Nonnull
        public final Builder source(@Nullable Integer value) {
            this.source = value;
            return this;
        }

        /**
         * API name: {@code threshold}
         */
        @Nonnull
        public final Builder threshold(@Nullable IndexingSlowlogThresholds value) {
            this.threshold = value;
            return this;
        }

        /**
         * API name: {@code threshold}
         */
        @Nonnull
        public final Builder threshold(Function<IndexingSlowlogThresholds.Builder, ObjectBuilder<IndexingSlowlogThresholds>> fn) {
            return threshold(fn.apply(new IndexingSlowlogThresholds.Builder()).build());
        }

        /**
         * Builds a {@link IndexingSlowlog}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IndexingSlowlog build() {
            _checkSingleUse();

            return new IndexingSlowlog(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IndexingSlowlog}
     */
    public static final JsonpDeserializer<IndexingSlowlog> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IndexingSlowlog::setupIndexingSlowlogDeserializer
    );

    protected static void setupIndexingSlowlogDeserializer(ObjectDeserializer<IndexingSlowlog.Builder> op) {
        op.add(Builder::level, JsonpDeserializer.stringDeserializer(), "level");
        op.add(Builder::reformat, JsonpDeserializer.booleanDeserializer(), "reformat");
        op.add(Builder::source, JsonpDeserializer.integerDeserializer(), "source");
        op.add(Builder::threshold, IndexingSlowlogThresholds._DESERIALIZER, "threshold");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.level);
        result = 31 * result + Objects.hashCode(this.reformat);
        result = 31 * result + Objects.hashCode(this.source);
        result = 31 * result + Objects.hashCode(this.threshold);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IndexingSlowlog other = (IndexingSlowlog) o;
        return Objects.equals(this.level, other.level)
            && Objects.equals(this.reformat, other.reformat)
            && Objects.equals(this.source, other.source)
            && Objects.equals(this.threshold, other.threshold);
    }
}
