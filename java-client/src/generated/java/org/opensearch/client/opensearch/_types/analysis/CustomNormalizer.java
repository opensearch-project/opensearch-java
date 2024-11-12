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

package org.opensearch.client.opensearch._types.analysis;

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
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: _types.analysis.CustomNormalizer

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class CustomNormalizer implements NormalizerVariant, PlainJsonSerializable {

    @Nonnull
    private final List<String> charFilter;

    @Nonnull
    private final List<String> filter;

    // ---------------------------------------------------------------------------------------------

    private CustomNormalizer(Builder builder) {
        this.charFilter = ApiTypeHelper.unmodifiable(builder.charFilter);
        this.filter = ApiTypeHelper.unmodifiable(builder.filter);
    }

    public static CustomNormalizer of(Function<CustomNormalizer.Builder, ObjectBuilder<CustomNormalizer>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Normalizer} variant kind.
     */
    @Override
    public Normalizer.Kind _normalizerKind() {
        return Normalizer.Kind.Custom;
    }

    /**
     * API name: {@code char_filter}
     */
    @Nonnull
    public final List<String> charFilter() {
        return this.charFilter;
    }

    /**
     * API name: {@code filter}
     */
    @Nonnull
    public final List<String> filter() {
        return this.filter;
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
        generator.write("type", "custom");
        if (ApiTypeHelper.isDefined(this.charFilter)) {
            generator.writeKey("char_filter");
            generator.writeStartArray();
            for (String item0 : this.charFilter) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.filter)) {
            generator.writeKey("filter");
            generator.writeStartArray();
            for (String item0 : this.filter) {
                generator.write(item0);
            }
            generator.writeEnd();
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link CustomNormalizer}.
     */
    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<CustomNormalizer> {
        @Nullable
        private List<String> charFilter;
        @Nullable
        private List<String> filter;

        /**
         * API name: {@code char_filter}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>charFilter</code>.
         * </p>
         */
        public final Builder charFilter(List<String> list) {
            this.charFilter = _listAddAll(this.charFilter, list);
            return this;
        }

        /**
         * API name: {@code char_filter}
         *
         * <p>
         * Adds one or more values to <code>charFilter</code>.
         * </p>
         */
        public final Builder charFilter(String value, String... values) {
            this.charFilter = _listAdd(this.charFilter, value, values);
            return this;
        }

        /**
         * API name: {@code filter}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>filter</code>.
         * </p>
         */
        public final Builder filter(List<String> list) {
            this.filter = _listAddAll(this.filter, list);
            return this;
        }

        /**
         * API name: {@code filter}
         *
         * <p>
         * Adds one or more values to <code>filter</code>.
         * </p>
         */
        public final Builder filter(String value, String... values) {
            this.filter = _listAdd(this.filter, value, values);
            return this;
        }

        /**
         * Builds a {@link CustomNormalizer}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public CustomNormalizer build() {
            _checkSingleUse();

            return new CustomNormalizer(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link CustomNormalizer}
     */
    public static final JsonpDeserializer<CustomNormalizer> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CustomNormalizer::setupCustomNormalizerDeserializer
    );

    protected static void setupCustomNormalizerDeserializer(ObjectDeserializer<CustomNormalizer.Builder> op) {
        op.add(Builder::charFilter, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "char_filter");
        op.add(Builder::filter, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "filter");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.charFilter);
        result = 31 * result + Objects.hashCode(this.filter);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CustomNormalizer other = (CustomNormalizer) o;
        return Objects.equals(this.charFilter, other.charFilter) && Objects.equals(this.filter, other.filter);
    }
}
