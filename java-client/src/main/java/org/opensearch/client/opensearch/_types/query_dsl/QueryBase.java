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

package org.opensearch.client.opensearch._types.query_dsl;

import jakarta.json.stream.JsonGenerator;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: _types.query_dsl.QueryBase

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
     * API name: {@code boost}
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

    protected <BuilderT extends AbstractBuilder<BuilderT>> BuilderT toBuilder(BuilderT builder) {
        return builder.queryName(queryName).boost(boost);
    }

    public abstract static class AbstractBuilder<BuilderT extends AbstractBuilder<BuilderT>> extends ObjectBuilderBase {
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

        /**
         * API name: {@code boost}
         */
        public final BuilderT boost(@Nullable Float value) {
            this.boost = value;
            return self();
        }

        /**
         * API name: {@code _name}
         */
        public final BuilderT queryName(@Nullable String value) {
            this.queryName = value;
            return self();
        }

        protected abstract BuilderT self();

    }

    // ---------------------------------------------------------------------------------------------
    protected static <BuilderT extends AbstractBuilder<BuilderT>> void setupQueryBaseDeserializer(ObjectDeserializer<BuilderT> op) {

        op.add(AbstractBuilder::boost, JsonpDeserializer.floatDeserializer(), "boost");
        op.add(AbstractBuilder::queryName, JsonpDeserializer.stringDeserializer(), "_name");

    }

}
