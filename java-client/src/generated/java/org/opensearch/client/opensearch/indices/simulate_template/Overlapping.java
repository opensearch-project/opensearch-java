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

package org.opensearch.client.opensearch.indices.simulate_template;

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

// typedef: indices.simulate_template.Overlapping

/**
 * The configuration for overlapping index templates.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Overlapping implements PlainJsonSerializable, ToCopyableBuilder<Overlapping.Builder, Overlapping> {

    @Nonnull
    private final List<String> indexPatterns;

    @Nonnull
    private final String name;

    // ---------------------------------------------------------------------------------------------

    private Overlapping(Builder builder) {
        this.indexPatterns = ApiTypeHelper.unmodifiableRequired(builder.indexPatterns, this, "indexPatterns");
        this.name = ApiTypeHelper.requireNonNull(builder.name, this, "name");
    }

    public static Overlapping of(Function<Overlapping.Builder, ObjectBuilder<Overlapping>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The list of index patterns that may overlap with other templates.
     * <p>
     * API name: {@code index_patterns}
     * </p>
     */
    @Nonnull
    public final List<String> indexPatterns() {
        return this.indexPatterns;
    }

    /**
     * Required - API name: {@code name}
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
        generator.writeKey("index_patterns");
        generator.writeStartArray();
        for (String item0 : this.indexPatterns) {
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
     * Builder for {@link Overlapping}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, Overlapping> {
        private List<String> indexPatterns;
        private String name;

        public Builder() {}

        private Builder(Overlapping o) {
            this.indexPatterns = _listCopy(o.indexPatterns);
            this.name = o.name;
        }

        private Builder(Builder o) {
            this.indexPatterns = _listCopy(o.indexPatterns);
            this.name = o.name;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - The list of index patterns that may overlap with other templates.
         * <p>
         * API name: {@code index_patterns}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>indexPatterns</code>.
         * </p>
         */
        @Nonnull
        public final Builder indexPatterns(List<String> list) {
            this.indexPatterns = _listAddAll(this.indexPatterns, list);
            return this;
        }

        /**
         * Required - The list of index patterns that may overlap with other templates.
         * <p>
         * API name: {@code index_patterns}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>indexPatterns</code>.
         * </p>
         */
        @Nonnull
        public final Builder indexPatterns(String value, String... values) {
            this.indexPatterns = _listAdd(this.indexPatterns, value, values);
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
         * Builds a {@link Overlapping}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public Overlapping build() {
            _checkSingleUse();

            return new Overlapping(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link Overlapping}
     */
    public static final JsonpDeserializer<Overlapping> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        Overlapping::setupOverlappingDeserializer
    );

    protected static void setupOverlappingDeserializer(ObjectDeserializer<Overlapping.Builder> op) {
        op.add(Builder::indexPatterns, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "index_patterns");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.indexPatterns.hashCode();
        result = 31 * result + this.name.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Overlapping other = (Overlapping) o;
        return this.indexPatterns.equals(other.indexPatterns) && this.name.equals(other.name);
    }
}
