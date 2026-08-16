/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.core.search;

import jakarta.json.stream.JsonGenerator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Nonnull;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.json.UnionDeserializer;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.TaggedUnion;
import org.opensearch.client.util.TaggedUnionUtils;

// typedef: core.search.MatchedQueries

/**
 * The names of queries that matched a hit, with optional per-query scores.
 *
 * <p>
 * The server returns matched_queries in one of two shapes, and never both: an array of query names when
 * {@code include_named_queries_score} is not set, or an object mapping query names to scores when
 * {@code include_named_queries_score} is true.
 * </p>
 */
@JsonpDeserializable
public class MatchedQueries implements TaggedUnion<MatchedQueries.Kind, Object>, PlainJsonSerializable {

    /**
     * {@link MatchedQueries} variant kinds.
     */
    public enum Kind {
        Names,
        Scores
    }

    private final Kind _kind;
    private final Object _value;

    @Override
    public final Kind _kind() {
        return _kind;
    }

    @Override
    public final Object _get() {
        return _value;
    }

    private MatchedQueries(Kind kind, Object value) {
        this._kind = kind;
        this._value = value;
    }

    private MatchedQueries(Builder builder) {
        this._kind = ApiTypeHelper.requireNonNull(builder._kind, builder, "<variant kind>");
        this._value = ApiTypeHelper.requireNonNull(builder._value, builder, "<variant value>");
    }

    public static MatchedQueries of(Function<MatchedQueries.Builder, ObjectBuilder<MatchedQueries>> fn) {
        return fn.apply(new Builder()).build();
    }

    public static MatchedQueries ofNames(List<String> names) {
        return new MatchedQueries(Kind.Names, ApiTypeHelper.requireNonNull(names, MatchedQueries.class, "names"));
    }

    public static MatchedQueries ofScores(Map<String, Double> scores) {
        return new MatchedQueries(Kind.Scores, ApiTypeHelper.requireNonNull(scores, MatchedQueries.class, "scores"));
    }

    /**
     * Is this variant instance of kind {@code names}?
     */
    public boolean isNames() {
        return _kind == Kind.Names;
    }

    /**
     * Get the {@code names} variant value: the names of the queries that matched the hit, returned by the server when
     * {@code include_named_queries_score} is not set.
     *
     * @throws IllegalStateException if the current variant is not the {@code names} kind.
     */
    public List<String> names() {
        return TaggedUnionUtils.get(this, Kind.Names);
    }

    /**
     * Is this variant instance of kind {@code scores}?
     */
    public boolean isScores() {
        return _kind == Kind.Scores;
    }

    /**
     * Get the {@code scores} variant value: a map from matched query name to score, returned by the server when
     * {@code include_named_queries_score} is true.
     *
     * @throws IllegalStateException if the current variant is not the {@code scores} kind.
     */
    public Map<String, Double> scores() {
        return TaggedUnionUtils.get(this, Kind.Scores);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        switch (_kind) {
            case Names:
                generator.writeStartArray();
                for (String name : (List<String>) _value) {
                    generator.write(name);
                }
                generator.writeEnd();
                break;
            case Scores:
                generator.writeStartObject();
                for (Map.Entry<String, Double> entry : ((Map<String, Double>) _value).entrySet()) {
                    generator.writeKey(entry.getKey());
                    generator.write(entry.getValue());
                }
                generator.writeEnd();
                break;
        }
    }

    @Nonnull
    public Builder toBuilder() {
        return new Builder(this);
    }

    @Nonnull
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<MatchedQueries> {
        private Kind _kind;
        private Object _value;

        public Builder() {}

        private Builder(MatchedQueries o) {
            this._kind = o._kind;
            this._value = o._value;
        }

        public ObjectBuilder<MatchedQueries> names(List<String> v) {
            this._kind = Kind.Names;
            this._value = v;
            return this;
        }

        public ObjectBuilder<MatchedQueries> scores(Map<String, Double> v) {
            this._kind = Kind.Scores;
            this._value = v;
            return this;
        }

        @Override
        public MatchedQueries build() {
            _checkSingleUse();
            return new MatchedQueries(this);
        }
    }

    private static JsonpDeserializer<MatchedQueries> buildMatchedQueriesDeserializer() {
        return new UnionDeserializer.Builder<MatchedQueries, Kind, Object>(MatchedQueries::new, false).addMember(
            Kind.Names,
            JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer())
        ).addMember(Kind.Scores, JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.doubleDeserializer())).build();
    }

    public static final JsonpDeserializer<MatchedQueries> _DESERIALIZER = JsonpDeserializer.lazy(
        MatchedQueries::buildMatchedQueriesDeserializer
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this._kind);
        result = 31 * result + Objects.hashCode(this._value);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        MatchedQueries other = (MatchedQueries) o;
        return Objects.equals(this._kind, other._kind) && Objects.equals(this._value, other._value);
    }
}
