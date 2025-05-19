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

package org.opensearch.client.opensearch.indices.analyze;

import jakarta.json.stream.JsonGenerator;
import java.util.List;
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

// typedef: indices.analyze.CharFilterDetail

/**
 * The character filter results.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class CharFilterDetail implements PlainJsonSerializable, ToCopyableBuilder<CharFilterDetail.Builder, CharFilterDetail> {

    @Nonnull
    private final List<String> filteredText;

    @Nonnull
    private final String name;

    // ---------------------------------------------------------------------------------------------

    private CharFilterDetail(Builder builder) {
        this.filteredText = ApiTypeHelper.unmodifiableRequired(builder.filteredText, this, "filteredText");
        this.name = ApiTypeHelper.requireNonNull(builder.name, this, "name");
    }

    public static CharFilterDetail of(Function<CharFilterDetail.Builder, ObjectBuilder<CharFilterDetail>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The text after character filtering.
     * <p>
     * API name: {@code filtered_text}
     * </p>
     */
    @Nonnull
    public final List<String> filteredText() {
        return this.filteredText;
    }

    /**
     * Required - The name of the character filter.
     * <p>
     * API name: {@code name}
     * </p>
     */
    @Nonnull
    public final String name() {
        return this.name;
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
        generator.writeKey("filtered_text");
        generator.writeStartArray();
        for (String item0 : this.filteredText) {
            generator.write(item0);
        }
        generator.writeEnd();

        generator.writeKey("name");
        generator.write(this.name);
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
     * Builder for {@link CharFilterDetail}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, CharFilterDetail> {
        private List<String> filteredText;
        private String name;

        public Builder() {}

        private Builder(CharFilterDetail o) {
            this.filteredText = _listCopy(o.filteredText);
            this.name = o.name;
        }

        private Builder(Builder o) {
            this.filteredText = _listCopy(o.filteredText);
            this.name = o.name;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - The text after character filtering.
         * <p>
         * API name: {@code filtered_text}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>filteredText</code>.
         * </p>
         */
        @Nonnull
        public final Builder filteredText(List<String> list) {
            this.filteredText = _listAddAll(this.filteredText, list);
            return this;
        }

        /**
         * Required - The text after character filtering.
         * <p>
         * API name: {@code filtered_text}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>filteredText</code>.
         * </p>
         */
        @Nonnull
        public final Builder filteredText(String value, String... values) {
            this.filteredText = _listAdd(this.filteredText, value, values);
            return this;
        }

        /**
         * Required - The name of the character filter.
         * <p>
         * API name: {@code name}
         * </p>
         */
        @Nonnull
        public final Builder name(String value) {
            this.name = value;
            return this;
        }

        /**
         * Builds a {@link CharFilterDetail}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public CharFilterDetail build() {
            _checkSingleUse();

            return new CharFilterDetail(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link CharFilterDetail}
     */
    public static final JsonpDeserializer<CharFilterDetail> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CharFilterDetail::setupCharFilterDetailDeserializer
    );

    protected static void setupCharFilterDetailDeserializer(ObjectDeserializer<CharFilterDetail.Builder> op) {
        op.add(Builder::filteredText, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "filtered_text");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.filteredText.hashCode();
        result = 31 * result + this.name.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CharFilterDetail other = (CharFilterDetail) o;
        return this.filteredText.equals(other.filteredText) && this.name.equals(other.name);
    }
}
