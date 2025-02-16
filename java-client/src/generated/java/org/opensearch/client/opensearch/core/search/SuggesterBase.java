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
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: core.search.SuggesterBase

@Generated("org.opensearch.client.codegen.CodeGenerator")
public abstract class SuggesterBase implements PlainJsonSerializable {

    @Nullable
    private final String analyzer;

    @Nonnull
    private final String field;

    @Nullable
    private final Integer size;

    // ---------------------------------------------------------------------------------------------

    protected SuggesterBase(AbstractBuilder<?> builder) {
        this.analyzer = builder.analyzer;
        this.field = ApiTypeHelper.requireNonNull(builder.field, this, "field");
        this.size = builder.size;
    }

    /**
     * API name: {@code analyzer}
     */
    @Nullable
    public final String analyzer() {
        return this.analyzer;
    }

    /**
     * Required - API name: {@code field}
     */
    @Nonnull
    public final String field() {
        return this.field;
    }

    /**
     * API name: {@code size}
     */
    @Nullable
    public final Integer size() {
        return this.size;
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
        if (this.analyzer != null) {
            generator.writeKey("analyzer");
            generator.write(this.analyzer);
        }

        generator.writeKey("field");
        generator.write(this.field);

        if (this.size != null) {
            generator.writeKey("size");
            generator.write(this.size);
        }
    }

    // ---------------------------------------------------------------------------------------------

    protected abstract static class AbstractBuilder<BuilderT extends AbstractBuilder<BuilderT>> extends ObjectBuilderBase {
        @Nullable
        private String analyzer;
        private String field;
        @Nullable
        private Integer size;

        protected AbstractBuilder() {}

        protected AbstractBuilder(SuggesterBase o) {
            this.analyzer = o.analyzer;
            this.field = o.field;
            this.size = o.size;
        }

        protected AbstractBuilder(AbstractBuilder<BuilderT> o) {
            this.analyzer = o.analyzer;
            this.field = o.field;
            this.size = o.size;
        }

        @Nonnull
        protected abstract BuilderT self();

        /**
         * API name: {@code analyzer}
         */
        @Nonnull
        public final BuilderT analyzer(@Nullable String value) {
            this.analyzer = value;
            return self();
        }

        /**
         * Required - API name: {@code field}
         */
        @Nonnull
        public final BuilderT field(String value) {
            this.field = value;
            return self();
        }

        /**
         * API name: {@code size}
         */
        @Nonnull
        public final BuilderT size(@Nullable Integer value) {
            this.size = value;
            return self();
        }
    }

    // ---------------------------------------------------------------------------------------------

    protected static <BuilderT extends AbstractBuilder<BuilderT>> void setupSuggesterBaseDeserializer(ObjectDeserializer<BuilderT> op) {
        op.add(AbstractBuilder::analyzer, JsonpDeserializer.stringDeserializer(), "analyzer");
        op.add(AbstractBuilder::field, JsonpDeserializer.stringDeserializer(), "field");
        op.add(AbstractBuilder::size, JsonpDeserializer.integerDeserializer(), "size");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.analyzer);
        result = 31 * result + this.field.hashCode();
        result = 31 * result + Objects.hashCode(this.size);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SuggesterBase other = (SuggesterBase) o;
        return Objects.equals(this.analyzer, other.analyzer) && this.field.equals(other.field) && Objects.equals(this.size, other.size);
    }
}
