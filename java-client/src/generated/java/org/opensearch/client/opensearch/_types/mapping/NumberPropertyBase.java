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

package org.opensearch.client.opensearch._types.mapping;

import jakarta.json.stream.JsonGenerator;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectDeserializer;

// typedef: _types.mapping.NumberPropertyBase

@Generated("org.opensearch.client.codegen.CodeGenerator")
public abstract class NumberPropertyBase extends DocValuesPropertyBase {

    @Nullable
    private final Double boost;

    @Nullable
    private final Boolean coerce;

    @Nullable
    private final Boolean ignoreMalformed;

    @Nullable
    private final Boolean index;

    // ---------------------------------------------------------------------------------------------

    protected NumberPropertyBase(AbstractBuilder<?> builder) {
        super(builder);
        this.boost = builder.boost;
        this.coerce = builder.coerce;
        this.ignoreMalformed = builder.ignoreMalformed;
        this.index = builder.index;
    }

    /**
     * API name: {@code boost}
     */
    @Nullable
    public final Double boost() {
        return this.boost;
    }

    /**
     * API name: {@code coerce}
     */
    @Nullable
    public final Boolean coerce() {
        return this.coerce;
    }

    /**
     * API name: {@code ignore_malformed}
     */
    @Nullable
    public final Boolean ignoreMalformed() {
        return this.ignoreMalformed;
    }

    /**
     * API name: {@code index}
     */
    @Nullable
    public final Boolean index() {
        return this.index;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.boost != null) {
            generator.writeKey("boost");
            generator.write(this.boost);
        }

        if (this.coerce != null) {
            generator.writeKey("coerce");
            generator.write(this.coerce);
        }

        if (this.ignoreMalformed != null) {
            generator.writeKey("ignore_malformed");
            generator.write(this.ignoreMalformed);
        }

        if (this.index != null) {
            generator.writeKey("index");
            generator.write(this.index);
        }
    }

    // ---------------------------------------------------------------------------------------------

    public abstract static class AbstractBuilder<BuilderT extends AbstractBuilder<BuilderT>> extends DocValuesPropertyBase.AbstractBuilder<
        BuilderT> {
        @Nullable
        private Double boost;
        @Nullable
        private Boolean coerce;
        @Nullable
        private Boolean ignoreMalformed;
        @Nullable
        private Boolean index;

        protected AbstractBuilder() {}

        protected AbstractBuilder(NumberPropertyBase o) {
            super(o);
            this.boost = o.boost;
            this.coerce = o.coerce;
            this.ignoreMalformed = o.ignoreMalformed;
            this.index = o.index;
        }

        protected AbstractBuilder(AbstractBuilder<BuilderT> o) {
            super(o);
            this.boost = o.boost;
            this.coerce = o.coerce;
            this.ignoreMalformed = o.ignoreMalformed;
            this.index = o.index;
        }

        /**
         * API name: {@code boost}
         */
        @Nonnull
        public final BuilderT boost(@Nullable Double value) {
            this.boost = value;
            return self();
        }

        /**
         * API name: {@code coerce}
         */
        @Nonnull
        public final BuilderT coerce(@Nullable Boolean value) {
            this.coerce = value;
            return self();
        }

        /**
         * API name: {@code ignore_malformed}
         */
        @Nonnull
        public final BuilderT ignoreMalformed(@Nullable Boolean value) {
            this.ignoreMalformed = value;
            return self();
        }

        /**
         * API name: {@code index}
         */
        @Nonnull
        public final BuilderT index(@Nullable Boolean value) {
            this.index = value;
            return self();
        }
    }

    // ---------------------------------------------------------------------------------------------

    protected static <BuilderT extends AbstractBuilder<BuilderT>> void setupNumberPropertyBaseDeserializer(
        ObjectDeserializer<BuilderT> op
    ) {
        setupDocValuesPropertyBaseDeserializer(op);
        op.add(AbstractBuilder::boost, JsonpDeserializer.doubleDeserializer(), "boost");
        op.add(AbstractBuilder::coerce, JsonpDeserializer.booleanDeserializer(), "coerce");
        op.add(AbstractBuilder::ignoreMalformed, JsonpDeserializer.booleanDeserializer(), "ignore_malformed");
        op.add(AbstractBuilder::index, JsonpDeserializer.booleanDeserializer(), "index");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.boost);
        result = 31 * result + Objects.hashCode(this.coerce);
        result = 31 * result + Objects.hashCode(this.ignoreMalformed);
        result = 31 * result + Objects.hashCode(this.index);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NumberPropertyBase other = (NumberPropertyBase) o;
        return Objects.equals(this.boost, other.boost)
            && Objects.equals(this.coerce, other.coerce)
            && Objects.equals(this.ignoreMalformed, other.ignoreMalformed)
            && Objects.equals(this.index, other.index);
    }
}
