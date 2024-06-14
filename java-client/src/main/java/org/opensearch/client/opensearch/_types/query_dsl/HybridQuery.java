/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch._types.query_dsl;

import jakarta.json.stream.JsonGenerator;
import java.util.List;
import java.util.function.Function;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;

public class HybridQuery extends QueryBase implements QueryVariant {
    private final List<Query> queries;

    private HybridQuery(HybridQuery.Builder builder) {
        super(builder);
        this.queries = ApiTypeHelper.unmodifiable(builder.queries);
    }

    public static HybridQuery of(Function<HybridQuery.Builder, ObjectBuilder<HybridQuery>> fn) {
        return fn.apply(new HybridQuery.Builder()).build();
    }

    /**
     * Required - list of search queries.
     *
     * @return list of queries provided under hybrid clause.
     */
    public final List<Query> queries() {
        return this.queries;
    }

    @Override
    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        generator.writeKey("queries");
        generator.writeStartArray();
        for (Query item0 : this.queries) {
            item0.serialize(generator, mapper);
        }
        generator.writeEnd();
    }

    @Override
    public Query.Kind _queryKind() {
        return Query.Kind.Hybrid;
    }

    public HybridQuery.Builder toBuilder() {
        return new HybridQuery.Builder().queries(queries);
    }

    public static class Builder extends QueryBase.AbstractBuilder<HybridQuery.Builder> implements ObjectBuilder<HybridQuery> {
        private List<Query> queries;

        /**
         * API name: {@code hybrid}
         * <p>
         * Adds all elements of <code>list</code> to <code>hybrid</code>.
         */
        public final HybridQuery.Builder queries(List<Query> list) {
            this.queries = _listAddAll(this.queries, list);
            return this;
        }

        /**
         * API name: {@code hybrid}
         * <p>
         * Adds one or more values to <code>hybrid</code>.
         */
        public final HybridQuery.Builder queries(Query value, Query... values) {
            this.queries = _listAdd(this.queries, value, values);
            return this;
        }

        /**
         * API name: {@code hybrid}
         * <p>
         * Adds a value to <code>hybrid</code> using a builder lambda.
         */
        public final HybridQuery.Builder queries(Function<Query.Builder, ObjectBuilder<Query>> fn) {
            return queries(fn.apply(new Query.Builder()).build());
        }

        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public HybridQuery build() {
            _checkSingleUse();
            return new HybridQuery(this);
        }
    }

    public static final JsonpDeserializer<HybridQuery> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        HybridQuery.Builder::new,
        HybridQuery::setupHybridQueryDeserializer
    );

    protected static void setupHybridQueryDeserializer(ObjectDeserializer<HybridQuery.Builder> op) {
        setupQueryBaseDeserializer(op);
        op.add(HybridQuery.Builder::queries, JsonpDeserializer.arrayDeserializer(Query._DESERIALIZER), "queries");
    }
}
