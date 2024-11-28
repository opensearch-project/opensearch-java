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

package org.opensearch.client.opensearch._types.query_dsl;

import jakarta.json.stream.JsonGenerator;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: _types.query_dsl.QueryBase

@Generated("org.opensearch.client.codegen.CodeGenerator")
public abstract class QueryBase implements PlainJsonSerializable {

    @Nullable
    private final Float boost;

    @Nullable
    private final String queryName;

    // ---------------------------------------------------------------------------------------------

    protected QueryBase(AbstractBuilder<?> builder) {
        this.boost = builder.boost;
        this.queryName = builder.queryName;
    }

    /**
     * Floating point number used to decrease or increase the relevance scores of the query. Boost values are relative to the default value
     * of 1.0. A boost value between 0 and 1.0 decreases the relevance score. A value greater than 1.0 increases the relevance score.
     * <p>
     * API name: {@code boost}
     * </p>
     */
    @Nullable
    public final Float boost() {
        return this.boost;
    }

    /**
     * API name: {@code _name}
     */
    @Nullable
    public final String queryName() {
        return this.queryName;
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
        if (this.boost != null) {
            generator.writeKey("boost");
            generator.write(this.boost);
        }

        if (this.queryName != null) {
            generator.writeKey("_name");
            generator.write(this.queryName);
        }
    }

    // ---------------------------------------------------------------------------------------------

    protected abstract static class AbstractBuilder<BuilderT extends AbstractBuilder<BuilderT>> extends ObjectBuilderBase {
        @Nullable
        private Float boost;
        @Nullable
        private String queryName;

        protected AbstractBuilder() {}

        protected AbstractBuilder(QueryBase o) {
            this.boost = o.boost;
            this.queryName = o.queryName;
        }

        protected AbstractBuilder(AbstractBuilder<BuilderT> o) {
            this.boost = o.boost;
            this.queryName = o.queryName;
        }

        @Nonnull
        protected abstract BuilderT self();

        /**
         * Floating point number used to decrease or increase the relevance scores of the query. Boost values are relative to the default
         * value of 1.0. A boost value between 0 and 1.0 decreases the relevance score. A value greater than 1.0 increases the relevance
         * score.
         * <p>
         * API name: {@code boost}
         * </p>
         */
        @Nonnull
        public final BuilderT boost(@Nullable Float value) {
            this.boost = value;
            return self();
        }

        /**
         * API name: {@code _name}
         */
        @Nonnull
        public final BuilderT queryName(@Nullable String value) {
            this.queryName = value;
            return self();
        }
    }

    // ---------------------------------------------------------------------------------------------

    protected static <BuilderT extends AbstractBuilder<BuilderT>> void setupQueryBaseDeserializer(ObjectDeserializer<BuilderT> op) {
        op.add(AbstractBuilder::boost, JsonpDeserializer.floatDeserializer(), "boost");
        op.add(AbstractBuilder::queryName, JsonpDeserializer.stringDeserializer(), "_name");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.boost);
        result = 31 * result + Objects.hashCode(this.queryName);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        QueryBase other = (QueryBase) o;
        return Objects.equals(this.boost, other.boost) && Objects.equals(this.queryName, other.queryName);
    }
}
