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

package org.opensearch.client.opensearch.core.search;

import jakarta.json.stream.JsonGenerator;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: _global.search._types.SuggesterBase

public abstract class SuggesterBase implements PlainJsonSerializable {
    private final String field;

    @Nullable
    private final String analyzer;

    @Nullable
    private final Integer size;

    // ---------------------------------------------------------------------------------------------

    protected SuggesterBase(AbstractBuilder<?> builder) {

        this.field = ApiTypeHelper.requireNonNull(builder.field, this, "field");
        this.analyzer = builder.analyzer;
        this.size = builder.size;

    }

    /**
     * Required - API name: {@code field}
     */
    public final String field() {
        return this.field;
    }

    /**
     * API name: {@code analyzer}
     */
    @Nullable
    public final String analyzer() {
        return this.analyzer;
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
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {

        generator.writeKey("field");
        generator.write(this.field);

        if (this.analyzer != null) {
            generator.writeKey("analyzer");
            generator.write(this.analyzer);

        }
        if (this.size != null) {
            generator.writeKey("size");
            generator.write(this.size);

        }

    }

    public abstract static class AbstractBuilder<BuilderT extends AbstractBuilder<BuilderT>> extends ObjectBuilderBase {
        private String field;

        @Nullable
        private String analyzer;

        @Nullable
        private Integer size;

        /**
         * Required - API name: {@code field}
         */
        public final BuilderT field(String value) {
            this.field = value;
            return self();
        }

        /**
         * API name: {@code analyzer}
         */
        public final BuilderT analyzer(@Nullable String value) {
            this.analyzer = value;
            return self();
        }

        /**
         * API name: {@code size}
         */
        public final BuilderT size(@Nullable Integer value) {
            this.size = value;
            return self();
        }

        protected abstract BuilderT self();

    }

    // ---------------------------------------------------------------------------------------------
    protected static <BuilderT extends AbstractBuilder<BuilderT>> void setupSuggesterBaseDeserializer(ObjectDeserializer<BuilderT> op) {

        op.add(AbstractBuilder::field, JsonpDeserializer.stringDeserializer(), "field");
        op.add(AbstractBuilder::analyzer, JsonpDeserializer.stringDeserializer(), "analyzer");
        op.add(AbstractBuilder::size, JsonpDeserializer.integerDeserializer(), "size");

    }

}
