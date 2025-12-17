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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: core.search.Highlight

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Highlight extends HighlightBase implements ToCopyableBuilder<Highlight.Builder, Highlight> {

    @Nullable
    private final HighlighterEncoder encoder;

    @Nonnull
    private final List<HighlightField> fields;

    // ---------------------------------------------------------------------------------------------

    private Highlight(Builder builder) {
        super(builder);
        this.encoder = builder.encoder;
        this.fields = ApiTypeHelper.unmodifiableRequired(builder.fields, this, "fields");
    }

    public static Highlight of(Function<Highlight.Builder, ObjectBuilder<Highlight>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code encoder}
     */
    @Nullable
    public final HighlighterEncoder encoder() {
        return this.encoder;
    }

    /**
     * Required - API name: {@code fields}
     */
    @Nonnull
    public final List<HighlightField> fields() {
        return this.fields;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.encoder != null) {
            generator.writeKey("encoder");
            this.encoder.serialize(generator, mapper);
        }

        generator.writeKey("fields");
        generator.writeStartArray();
        for (HighlightField item0 : this.fields) {
            item0.serialize(generator, mapper);
        }
        generator.writeEnd();
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
     * Builder for {@link Highlight}.
     */
    public static class Builder extends HighlightBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, Highlight> {
        @Nullable
        private HighlighterEncoder encoder;
        private List<HighlightField> fields;

        public Builder() {}

        private Builder(Highlight o) {
            super(o);
            this.encoder = o.encoder;
            this.fields = _listCopy(o.fields);
        }

        private Builder(Builder o) {
            super(o);
            this.encoder = o.encoder;
            this.fields = _listCopy(o.fields);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        @Override
        @Nonnull
        protected Builder self() {
            return this;
        }

        /**
         * API name: {@code encoder}
         */
        @Nonnull
        public final Builder encoder(@Nullable HighlighterEncoder value) {
            this.encoder = value;
            return this;
        }

        /**
         * Required - API name: {@code fields}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>fields</code>.
         * </p>
         */
        @Nonnull
        public final Builder fields(List<HighlightField> list) {
            this.fields = _listAddAll(this.fields, list);
            return this;
        }

        /**
         * Required - API name: {@code fields}
         *
         * <p>
         * Adds one or more values to <code>fields</code>.
         * </p>
         */
        @Nonnull
        public final Builder fields(HighlightField value, HighlightField... values) {
            this.fields = _listAdd(this.fields, value, values);
            return this;
        }

        /**
         * Required - API name: {@code fields}
         *
         * <p>
         * Adds a value to <code>fields</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder fields(Function<HighlightField.Builder, ObjectBuilder<HighlightField>> fn) {
            return fields(fn.apply(new HighlightField.Builder()).build());
        }

        /**
         * Builds a {@link Highlight}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public Highlight build() {
            _checkSingleUse();

            return new Highlight(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link Highlight}
     */
    public static final JsonpDeserializer<Highlight> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        Highlight::setupHighlightDeserializer
    );

    protected static void setupHighlightDeserializer(ObjectDeserializer<Highlight.Builder> op) {
        setupHighlightBaseDeserializer(op);
        op.add(Builder::encoder, HighlighterEncoder._DESERIALIZER, "encoder");
        op.add(Builder::fields, JsonpDeserializer.arrayDeserializer(HighlightField._DESERIALIZER), "fields");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.encoder);
        result = 31 * result + this.fields.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Highlight other = (Highlight) o;
        return Objects.equals(this.encoder, other.encoder) && this.fields.equals(other.fields);
    }
}
