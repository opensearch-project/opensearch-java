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
import java.util.List;
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

// typedef: core.search.SourceFilter

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SourceFilter implements PlainJsonSerializable, ToCopyableBuilder<SourceFilter.Builder, SourceFilter> {

    @Nonnull
    private final List<String> excludes;

    @Nonnull
    private final List<String> includes;

    // ---------------------------------------------------------------------------------------------

    private SourceFilter(Builder builder) {
        this.excludes = ApiTypeHelper.unmodifiable(builder.excludes);
        this.includes = ApiTypeHelper.unmodifiable(builder.includes);
    }

    public static SourceFilter of(Function<SourceFilter.Builder, ObjectBuilder<SourceFilter>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code excludes}
     */
    @Nonnull
    public final List<String> excludes() {
        return this.excludes;
    }

    /**
     * API name: {@code includes}
     */
    @Nonnull
    public final List<String> includes() {
        return this.includes;
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
        if (ApiTypeHelper.isDefined(this.excludes)) {
            generator.writeKey("excludes");
            generator.writeStartArray();
            for (String item0 : this.excludes) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.includes)) {
            generator.writeKey("includes");
            generator.writeStartArray();
            for (String item0 : this.includes) {
                generator.write(item0);
            }
            generator.writeEnd();
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
     * Builder for {@link SourceFilter}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, SourceFilter> {
        @Nullable
        private List<String> excludes;
        @Nullable
        private List<String> includes;

        public Builder() {}

        private Builder(SourceFilter o) {
            this.excludes = _listCopy(o.excludes);
            this.includes = _listCopy(o.includes);
        }

        private Builder(Builder o) {
            this.excludes = _listCopy(o.excludes);
            this.includes = _listCopy(o.includes);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code excludes}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>excludes</code>.
         * </p>
         */
        @Nonnull
        public final Builder excludes(List<String> list) {
            this.excludes = _listAddAll(this.excludes, list);
            return this;
        }

        /**
         * API name: {@code excludes}
         *
         * <p>
         * Adds one or more values to <code>excludes</code>.
         * </p>
         */
        @Nonnull
        public final Builder excludes(String value, String... values) {
            this.excludes = _listAdd(this.excludes, value, values);
            return this;
        }

        /**
         * API name: {@code includes}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>includes</code>.
         * </p>
         */
        @Nonnull
        public final Builder includes(List<String> list) {
            this.includes = _listAddAll(this.includes, list);
            return this;
        }

        /**
         * API name: {@code includes}
         *
         * <p>
         * Adds one or more values to <code>includes</code>.
         * </p>
         */
        @Nonnull
        public final Builder includes(String value, String... values) {
            this.includes = _listAdd(this.includes, value, values);
            return this;
        }

        /**
         * Builds a {@link SourceFilter}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SourceFilter build() {
            _checkSingleUse();

            return new SourceFilter(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SourceFilter}
     */
    public static final JsonpDeserializer<SourceFilter> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SourceFilter::setupSourceFilterDeserializer
    );

    protected static void setupSourceFilterDeserializer(ObjectDeserializer<SourceFilter.Builder> op) {
        op.add(Builder::excludes, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "excludes", "exclude");
        op.add(Builder::includes, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "includes", "include");

        op.shortcutProperty("includes");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.excludes);
        result = 31 * result + Objects.hashCode(this.includes);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SourceFilter other = (SourceFilter) o;
        return Objects.equals(this.excludes, other.excludes) && Objects.equals(this.includes, other.includes);
    }
}
