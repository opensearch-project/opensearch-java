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

import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import jakarta.json.stream.JsonGenerator;
import java.lang.String;
import java.util.function.Function;

// typedef: _types.query_dsl.WrapperQuery


@JsonpDeserializable
public class WrapperQuery extends QueryBase implements QueryVariant {
    private final String query;

    // ---------------------------------------------------------------------------------------------

    private WrapperQuery(Builder builder) {
        super(builder);

        this.query = ApiTypeHelper.requireNonNull(builder.query, this, "query");

    }

    public static WrapperQuery of(Function<Builder, ObjectBuilder<WrapperQuery>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Query variant kind.
     */
    @Override
    public Query.Kind _queryKind() {
        return Query.Kind.Wrapper;
    }

    /**
     * Required - A base64 encoded query. The binary data format can be any of JSON,
     * YAML, CBOR or SMILE encodings
     * <p>
     * API name: {@code query}
     */
    public final String query() {
        return this.query;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {

        super.serializeInternal(generator, mapper);
        generator.writeKey("query");
        generator.write(this.query);

    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link WrapperQuery}.
     */

    public static class Builder extends QueryBase.AbstractBuilder<Builder> implements ObjectBuilder<WrapperQuery> {
        private String query;

        /**
         * Required - A base64 encoded query. The binary data format can be any of JSON,
         * YAML, CBOR or SMILE encodings
         * <p>
         * API name: {@code query}
         */
        public final Builder query(String value) {
            this.query = value;
            return this;
        }

        @Override
        protected Builder self() {
            return this;
        }

        /**
         * Builds a {@link WrapperQuery}.
         *
         * @throws NullPointerException
         *             if some of the required fields are null.
         */
        public WrapperQuery build() {
            _checkSingleUse();

            return new WrapperQuery(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link WrapperQuery}
     */
    public static final JsonpDeserializer<WrapperQuery> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new,
            WrapperQuery::setupWrapperQueryDeserializer);

    protected static void setupWrapperQueryDeserializer(ObjectDeserializer<WrapperQuery.Builder> op) {
        QueryBase.setupQueryBaseDeserializer(op);
        op.add(Builder::query, JsonpDeserializer.stringDeserializer(), "query");

    }

}
