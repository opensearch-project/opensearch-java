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

// typedef: indices.IndexSettingsStarTreeField

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IndexSettingsStarTreeField
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<IndexSettingsStarTreeField.Builder, IndexSettingsStarTreeField> {

    @Nullable
    private final IndexSettingsStarTreeFieldDefault default_;

    @Nullable
    private final Integer maxBaseMetrics;

    @Nullable
    private final Integer maxDateIntervals;

    @Nullable
    private final Integer maxDimensions;

    // ---------------------------------------------------------------------------------------------

    private IndexSettingsStarTreeField(Builder builder) {
        this.default_ = builder.default_;
        this.maxBaseMetrics = builder.maxBaseMetrics;
        this.maxDateIntervals = builder.maxDateIntervals;
        this.maxDimensions = builder.maxDimensions;
    }

    public static IndexSettingsStarTreeField of(
        Function<IndexSettingsStarTreeField.Builder, ObjectBuilder<IndexSettingsStarTreeField>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code default}
     */
    @Nullable
    public final IndexSettingsStarTreeFieldDefault default_() {
        return this.default_;
    }

    /**
     * API name: {@code max_base_metrics}
     */
    @Nullable
    public final Integer maxBaseMetrics() {
        return this.maxBaseMetrics;
    }

    /**
     * API name: {@code max_date_intervals}
     */
    @Nullable
    public final Integer maxDateIntervals() {
        return this.maxDateIntervals;
    }

    /**
     * API name: {@code max_dimensions}
     */
    @Nullable
    public final Integer maxDimensions() {
        return this.maxDimensions;
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
        if (this.default_ != null) {
            generator.writeKey("default");
            this.default_.serialize(generator, mapper);
        }

        if (this.maxBaseMetrics != null) {
            generator.writeKey("max_base_metrics");
            generator.write(this.maxBaseMetrics);
        }

        if (this.maxDateIntervals != null) {
            generator.writeKey("max_date_intervals");
            generator.write(this.maxDateIntervals);
        }

        if (this.maxDimensions != null) {
            generator.writeKey("max_dimensions");
            generator.write(this.maxDimensions);
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
     * Builder for {@link IndexSettingsStarTreeField}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IndexSettingsStarTreeField> {
        @Nullable
        private IndexSettingsStarTreeFieldDefault default_;
        @Nullable
        private Integer maxBaseMetrics;
        @Nullable
        private Integer maxDateIntervals;
        @Nullable
        private Integer maxDimensions;

        public Builder() {}

        private Builder(IndexSettingsStarTreeField o) {
            this.default_ = o.default_;
            this.maxBaseMetrics = o.maxBaseMetrics;
            this.maxDateIntervals = o.maxDateIntervals;
            this.maxDimensions = o.maxDimensions;
        }

        private Builder(Builder o) {
            this.default_ = o.default_;
            this.maxBaseMetrics = o.maxBaseMetrics;
            this.maxDateIntervals = o.maxDateIntervals;
            this.maxDimensions = o.maxDimensions;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code default}
         */
        @Nonnull
        public final Builder default_(@Nullable IndexSettingsStarTreeFieldDefault value) {
            this.default_ = value;
            return this;
        }

        /**
         * API name: {@code default}
         */
        @Nonnull
        public final Builder default_(
            Function<IndexSettingsStarTreeFieldDefault.Builder, ObjectBuilder<IndexSettingsStarTreeFieldDefault>> fn
        ) {
            return default_(fn.apply(new IndexSettingsStarTreeFieldDefault.Builder()).build());
        }

        /**
         * API name: {@code max_base_metrics}
         */
        @Nonnull
        public final Builder maxBaseMetrics(@Nullable Integer value) {
            this.maxBaseMetrics = value;
            return this;
        }

        /**
         * API name: {@code max_date_intervals}
         */
        @Nonnull
        public final Builder maxDateIntervals(@Nullable Integer value) {
            this.maxDateIntervals = value;
            return this;
        }

        /**
         * API name: {@code max_dimensions}
         */
        @Nonnull
        public final Builder maxDimensions(@Nullable Integer value) {
            this.maxDimensions = value;
            return this;
        }

        /**
         * Builds a {@link IndexSettingsStarTreeField}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IndexSettingsStarTreeField build() {
            _checkSingleUse();

            return new IndexSettingsStarTreeField(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IndexSettingsStarTreeField}
     */
    public static final JsonpDeserializer<IndexSettingsStarTreeField> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IndexSettingsStarTreeField::setupIndexSettingsStarTreeFieldDeserializer
    );

    protected static void setupIndexSettingsStarTreeFieldDeserializer(ObjectDeserializer<IndexSettingsStarTreeField.Builder> op) {
        op.add(Builder::default_, IndexSettingsStarTreeFieldDefault._DESERIALIZER, "default");
        op.add(Builder::maxBaseMetrics, JsonpDeserializer.integerDeserializer(), "max_base_metrics");
        op.add(Builder::maxDateIntervals, JsonpDeserializer.integerDeserializer(), "max_date_intervals");
        op.add(Builder::maxDimensions, JsonpDeserializer.integerDeserializer(), "max_dimensions");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.default_);
        result = 31 * result + Objects.hashCode(this.maxBaseMetrics);
        result = 31 * result + Objects.hashCode(this.maxDateIntervals);
        result = 31 * result + Objects.hashCode(this.maxDimensions);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IndexSettingsStarTreeField other = (IndexSettingsStarTreeField) o;
        return Objects.equals(this.default_, other.default_)
            && Objects.equals(this.maxBaseMetrics, other.maxBaseMetrics)
            && Objects.equals(this.maxDateIntervals, other.maxDateIntervals)
            && Objects.equals(this.maxDimensions, other.maxDimensions);
    }
}
