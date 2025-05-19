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

package org.opensearch.client.opensearch.cat.aliases;

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

// typedef: cat.aliases.AliasesRecord

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class AliasesRecord implements PlainJsonSerializable, ToCopyableBuilder<AliasesRecord.Builder, AliasesRecord> {

    @Nullable
    private final String alias;

    @Nullable
    private final String filter;

    @Nullable
    private final String index;

    @Nullable
    private final String isWriteIndex;

    @Nullable
    private final String routingIndex;

    @Nullable
    private final String routingSearch;

    // ---------------------------------------------------------------------------------------------

    private AliasesRecord(Builder builder) {
        this.alias = builder.alias;
        this.filter = builder.filter;
        this.index = builder.index;
        this.isWriteIndex = builder.isWriteIndex;
        this.routingIndex = builder.routingIndex;
        this.routingSearch = builder.routingSearch;
    }

    public static AliasesRecord of(Function<AliasesRecord.Builder, ObjectBuilder<AliasesRecord>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * alias name
     * <p>
     * API name: {@code alias}
     * </p>
     */
    @Nullable
    public final String alias() {
        return this.alias;
    }

    /**
     * filter
     * <p>
     * API name: {@code filter}
     * </p>
     */
    @Nullable
    public final String filter() {
        return this.filter;
    }

    /**
     * API name: {@code index}
     */
    @Nullable
    public final String index() {
        return this.index;
    }

    /**
     * write index
     * <p>
     * API name: {@code is_write_index}
     * </p>
     */
    @Nullable
    public final String isWriteIndex() {
        return this.isWriteIndex;
    }

    /**
     * index routing
     * <p>
     * API name: {@code routing.index}
     * </p>
     */
    @Nullable
    public final String routingIndex() {
        return this.routingIndex;
    }

    /**
     * search routing
     * <p>
     * API name: {@code routing.search}
     * </p>
     */
    @Nullable
    public final String routingSearch() {
        return this.routingSearch;
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
        if (this.alias != null) {
            generator.writeKey("alias");
            generator.write(this.alias);
        }

        if (this.filter != null) {
            generator.writeKey("filter");
            generator.write(this.filter);
        }

        if (this.index != null) {
            generator.writeKey("index");
            generator.write(this.index);
        }

        if (this.isWriteIndex != null) {
            generator.writeKey("is_write_index");
            generator.write(this.isWriteIndex);
        }

        if (this.routingIndex != null) {
            generator.writeKey("routing.index");
            generator.write(this.routingIndex);
        }

        if (this.routingSearch != null) {
            generator.writeKey("routing.search");
            generator.write(this.routingSearch);
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
     * Builder for {@link AliasesRecord}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, AliasesRecord> {
        @Nullable
        private String alias;
        @Nullable
        private String filter;
        @Nullable
        private String index;
        @Nullable
        private String isWriteIndex;
        @Nullable
        private String routingIndex;
        @Nullable
        private String routingSearch;

        public Builder() {}

        private Builder(AliasesRecord o) {
            this.alias = o.alias;
            this.filter = o.filter;
            this.index = o.index;
            this.isWriteIndex = o.isWriteIndex;
            this.routingIndex = o.routingIndex;
            this.routingSearch = o.routingSearch;
        }

        private Builder(Builder o) {
            this.alias = o.alias;
            this.filter = o.filter;
            this.index = o.index;
            this.isWriteIndex = o.isWriteIndex;
            this.routingIndex = o.routingIndex;
            this.routingSearch = o.routingSearch;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * alias name
         * <p>
         * API name: {@code alias}
         * </p>
         */
        @Nonnull
        public final Builder alias(@Nullable String value) {
            this.alias = value;
            return this;
        }

        /**
         * filter
         * <p>
         * API name: {@code filter}
         * </p>
         */
        @Nonnull
        public final Builder filter(@Nullable String value) {
            this.filter = value;
            return this;
        }

        /**
         * API name: {@code index}
         */
        @Nonnull
        public final Builder index(@Nullable String value) {
            this.index = value;
            return this;
        }

        /**
         * write index
         * <p>
         * API name: {@code is_write_index}
         * </p>
         */
        @Nonnull
        public final Builder isWriteIndex(@Nullable String value) {
            this.isWriteIndex = value;
            return this;
        }

        /**
         * index routing
         * <p>
         * API name: {@code routing.index}
         * </p>
         */
        @Nonnull
        public final Builder routingIndex(@Nullable String value) {
            this.routingIndex = value;
            return this;
        }

        /**
         * search routing
         * <p>
         * API name: {@code routing.search}
         * </p>
         */
        @Nonnull
        public final Builder routingSearch(@Nullable String value) {
            this.routingSearch = value;
            return this;
        }

        /**
         * Builds a {@link AliasesRecord}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public AliasesRecord build() {
            _checkSingleUse();

            return new AliasesRecord(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link AliasesRecord}
     */
    public static final JsonpDeserializer<AliasesRecord> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        AliasesRecord::setupAliasesRecordDeserializer
    );

    protected static void setupAliasesRecordDeserializer(ObjectDeserializer<AliasesRecord.Builder> op) {
        op.add(Builder::alias, JsonpDeserializer.stringDeserializer(), "alias");
        op.add(Builder::filter, JsonpDeserializer.stringDeserializer(), "filter");
        op.add(Builder::index, JsonpDeserializer.stringDeserializer(), "index");
        op.add(Builder::isWriteIndex, JsonpDeserializer.stringDeserializer(), "is_write_index");
        op.add(Builder::routingIndex, JsonpDeserializer.stringDeserializer(), "routing.index");
        op.add(Builder::routingSearch, JsonpDeserializer.stringDeserializer(), "routing.search");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.alias);
        result = 31 * result + Objects.hashCode(this.filter);
        result = 31 * result + Objects.hashCode(this.index);
        result = 31 * result + Objects.hashCode(this.isWriteIndex);
        result = 31 * result + Objects.hashCode(this.routingIndex);
        result = 31 * result + Objects.hashCode(this.routingSearch);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        AliasesRecord other = (AliasesRecord) o;
        return Objects.equals(this.alias, other.alias)
            && Objects.equals(this.filter, other.filter)
            && Objects.equals(this.index, other.index)
            && Objects.equals(this.isWriteIndex, other.isWriteIndex)
            && Objects.equals(this.routingIndex, other.routingIndex)
            && Objects.equals(this.routingSearch, other.routingSearch);
    }
}
