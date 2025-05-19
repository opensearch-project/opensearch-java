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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: indices.IndexSettingsLifecycle

/**
 * The index lifecycle management configuration.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IndexSettingsLifecycle
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<IndexSettingsLifecycle.Builder, IndexSettingsLifecycle> {

    @Nullable
    private final Boolean indexingComplete;

    @Nonnull
    private final String name;

    @Nullable
    private final Long originationDate;

    @Nullable
    private final Boolean parseOriginationDate;

    @Nullable
    private final String rolloverAlias;

    @Nullable
    private final IndexSettingsLifecycleStep step;

    // ---------------------------------------------------------------------------------------------

    private IndexSettingsLifecycle(Builder builder) {
        this.indexingComplete = builder.indexingComplete;
        this.name = ApiTypeHelper.requireNonNull(builder.name, this, "name");
        this.originationDate = builder.originationDate;
        this.parseOriginationDate = builder.parseOriginationDate;
        this.rolloverAlias = builder.rolloverAlias;
        this.step = builder.step;
    }

    public static IndexSettingsLifecycle of(Function<IndexSettingsLifecycle.Builder, ObjectBuilder<IndexSettingsLifecycle>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code indexing_complete}
     */
    @Nullable
    public final Boolean indexingComplete() {
        return this.indexingComplete;
    }

    /**
     * Required - API name: {@code name}
     */
    @Nonnull
    public final String name() {
        return this.name;
    }

    /**
     * The timestamp used to calculate the index age for its phase transitions. Use this setting if you create a new index that contains old
     * data and want to use the original creation date to calculate the index age. Specified as a Unix epoch value in milliseconds.
     * <p>
     * API name: {@code origination_date}
     * </p>
     */
    @Nullable
    public final Long originationDate() {
        return this.originationDate;
    }

    /**
     * When <code>true</code>, parses the origination date from the index name. This origination date is used to calculate the index age for
     * its phase transitions. The index name must match the pattern <code>^.*-{date_format}-\\d+</code>, where the <code>date_format</code>
     * is <code>yyyy.MM.dd</code> and the trailing digits are optional. An index that was rolled over would normally match the full format,
     * for example <code>logs-2016.10.31-000002</code>). If the index name doesn't match the pattern, index creation fails.
     * <p>
     * API name: {@code parse_origination_date}
     * </p>
     */
    @Nullable
    public final Boolean parseOriginationDate() {
        return this.parseOriginationDate;
    }

    /**
     * The index alias to update when the index rolls over. Specify when using a policy that contains a rollover action. When the index
     * rolls over, the alias is updated to reflect that the index is no longer the write index. For more information about rolling indexes,
     * see Rollover.
     * <p>
     * API name: {@code rollover_alias}
     * </p>
     */
    @Nullable
    public final String rolloverAlias() {
        return this.rolloverAlias;
    }

    /**
     * API name: {@code step}
     */
    @Nullable
    public final IndexSettingsLifecycleStep step() {
        return this.step;
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
        if (this.indexingComplete != null) {
            generator.writeKey("indexing_complete");
            generator.write(this.indexingComplete);
        }

        generator.writeKey("name");
        generator.write(this.name);

        if (this.originationDate != null) {
            generator.writeKey("origination_date");
            generator.write(this.originationDate);
        }

        if (this.parseOriginationDate != null) {
            generator.writeKey("parse_origination_date");
            generator.write(this.parseOriginationDate);
        }

        if (this.rolloverAlias != null) {
            generator.writeKey("rollover_alias");
            generator.write(this.rolloverAlias);
        }

        if (this.step != null) {
            generator.writeKey("step");
            this.step.serialize(generator, mapper);
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
     * Builder for {@link IndexSettingsLifecycle}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IndexSettingsLifecycle> {
        @Nullable
        private Boolean indexingComplete;
        private String name;
        @Nullable
        private Long originationDate;
        @Nullable
        private Boolean parseOriginationDate;
        @Nullable
        private String rolloverAlias;
        @Nullable
        private IndexSettingsLifecycleStep step;

        public Builder() {}

        private Builder(IndexSettingsLifecycle o) {
            this.indexingComplete = o.indexingComplete;
            this.name = o.name;
            this.originationDate = o.originationDate;
            this.parseOriginationDate = o.parseOriginationDate;
            this.rolloverAlias = o.rolloverAlias;
            this.step = o.step;
        }

        private Builder(Builder o) {
            this.indexingComplete = o.indexingComplete;
            this.name = o.name;
            this.originationDate = o.originationDate;
            this.parseOriginationDate = o.parseOriginationDate;
            this.rolloverAlias = o.rolloverAlias;
            this.step = o.step;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code indexing_complete}
         */
        @Nonnull
        public final Builder indexingComplete(@Nullable Boolean value) {
            this.indexingComplete = value;
            return this;
        }

        /**
         * Required - API name: {@code name}
         */
        @Nonnull
        public final Builder name(String value) {
            this.name = value;
            return this;
        }

        /**
         * The timestamp used to calculate the index age for its phase transitions. Use this setting if you create a new index that contains
         * old data and want to use the original creation date to calculate the index age. Specified as a Unix epoch value in milliseconds.
         * <p>
         * API name: {@code origination_date}
         * </p>
         */
        @Nonnull
        public final Builder originationDate(@Nullable Long value) {
            this.originationDate = value;
            return this;
        }

        /**
         * When <code>true</code>, parses the origination date from the index name. This origination date is used to calculate the index age
         * for its phase transitions. The index name must match the pattern <code>^.*-{date_format}-\\d+</code>, where the
         * <code>date_format</code> is <code>yyyy.MM.dd</code> and the trailing digits are optional. An index that was rolled over would
         * normally match the full format, for example <code>logs-2016.10.31-000002</code>). If the index name doesn't match the pattern,
         * index creation fails.
         * <p>
         * API name: {@code parse_origination_date}
         * </p>
         */
        @Nonnull
        public final Builder parseOriginationDate(@Nullable Boolean value) {
            this.parseOriginationDate = value;
            return this;
        }

        /**
         * The index alias to update when the index rolls over. Specify when using a policy that contains a rollover action. When the index
         * rolls over, the alias is updated to reflect that the index is no longer the write index. For more information about rolling
         * indexes, see Rollover.
         * <p>
         * API name: {@code rollover_alias}
         * </p>
         */
        @Nonnull
        public final Builder rolloverAlias(@Nullable String value) {
            this.rolloverAlias = value;
            return this;
        }

        /**
         * API name: {@code step}
         */
        @Nonnull
        public final Builder step(@Nullable IndexSettingsLifecycleStep value) {
            this.step = value;
            return this;
        }

        /**
         * API name: {@code step}
         */
        @Nonnull
        public final Builder step(Function<IndexSettingsLifecycleStep.Builder, ObjectBuilder<IndexSettingsLifecycleStep>> fn) {
            return step(fn.apply(new IndexSettingsLifecycleStep.Builder()).build());
        }

        /**
         * Builds a {@link IndexSettingsLifecycle}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IndexSettingsLifecycle build() {
            _checkSingleUse();

            return new IndexSettingsLifecycle(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IndexSettingsLifecycle}
     */
    public static final JsonpDeserializer<IndexSettingsLifecycle> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IndexSettingsLifecycle::setupIndexSettingsLifecycleDeserializer
    );

    protected static void setupIndexSettingsLifecycleDeserializer(ObjectDeserializer<IndexSettingsLifecycle.Builder> op) {
        op.add(Builder::indexingComplete, JsonpDeserializer.booleanDeserializer(), "indexing_complete");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
        op.add(Builder::originationDate, JsonpDeserializer.longDeserializer(), "origination_date");
        op.add(Builder::parseOriginationDate, JsonpDeserializer.booleanDeserializer(), "parse_origination_date");
        op.add(Builder::rolloverAlias, JsonpDeserializer.stringDeserializer(), "rollover_alias");
        op.add(Builder::step, IndexSettingsLifecycleStep._DESERIALIZER, "step");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.indexingComplete);
        result = 31 * result + this.name.hashCode();
        result = 31 * result + Objects.hashCode(this.originationDate);
        result = 31 * result + Objects.hashCode(this.parseOriginationDate);
        result = 31 * result + Objects.hashCode(this.rolloverAlias);
        result = 31 * result + Objects.hashCode(this.step);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IndexSettingsLifecycle other = (IndexSettingsLifecycle) o;
        return Objects.equals(this.indexingComplete, other.indexingComplete)
            && this.name.equals(other.name)
            && Objects.equals(this.originationDate, other.originationDate)
            && Objects.equals(this.parseOriginationDate, other.parseOriginationDate)
            && Objects.equals(this.rolloverAlias, other.rolloverAlias)
            && Objects.equals(this.step, other.step);
    }
}
