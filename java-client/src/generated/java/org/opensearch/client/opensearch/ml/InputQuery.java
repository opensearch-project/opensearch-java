/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

//----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------

package org.opensearch.client.opensearch.ml;

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
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.opensearch._types.query_dsl.Query;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ml.InputQuery

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class InputQuery implements PlainJsonSerializable, ToCopyableBuilder<InputQuery.Builder, InputQuery> {

    @Nullable
    private final Query query;

    @Nullable
    private final Long size;

    @Nonnull
    private final List<String> source;

    // ---------------------------------------------------------------------------------------------

    private InputQuery(Builder builder) {
        this.query = builder.query;
        this.size = builder.size;
        this.source = ApiTypeHelper.unmodifiable(builder.source);
    }

    public static InputQuery of(Function<InputQuery.Builder, ObjectBuilder<InputQuery>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code query}
     */
    @Nullable
    public final Query query() {
        return this.query;
    }

    /**
     * The size of the query.
     * <p>
     * API name: {@code size}
     * </p>
     */
    @Nullable
    public final Long size() {
        return this.size;
    }

    /**
     * The source fields
     * <p>
     * API name: {@code _source}
     * </p>
     */
    @Nonnull
    public final List<String> source() {
        return this.source;
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
        if (this.query != null) {
            generator.writeKey("query");
            this.query.serialize(generator, mapper);
        }

        if (this.size != null) {
            generator.writeKey("size");
            generator.write(this.size);
        }

        if (ApiTypeHelper.isDefined(this.source)) {
            generator.writeKey("_source");
            generator.writeStartArray();
            for (String item0 : this.source) {
                generator.write(item0);
            }
            generator.writeEnd();
        }
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
     * Builder for {@link InputQuery}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, InputQuery> {
        @Nullable
        private Query query;
        @Nullable
        private Long size;
        @Nullable
        private List<String> source;

        public Builder() {}

        private Builder(InputQuery o) {
            this.query = o.query;
            this.size = o.size;
            this.source = _listCopy(o.source);
        }

        private Builder(Builder o) {
            this.query = o.query;
            this.size = o.size;
            this.source = _listCopy(o.source);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code query}
         */
        @Nonnull
        public final Builder query(@Nullable Query value) {
            this.query = value;
            return this;
        }

        /**
         * API name: {@code query}
         */
        @Nonnull
        public final Builder query(Function<Query.Builder, ObjectBuilder<Query>> fn) {
            return query(fn.apply(new Query.Builder()).build());
        }

        /**
         * The size of the query.
         * <p>
         * API name: {@code size}
         * </p>
         */
        @Nonnull
        public final Builder size(@Nullable Long value) {
            this.size = value;
            return this;
        }

        /**
         * The source fields
         * <p>
         * API name: {@code _source}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>source</code>.
         * </p>
         */
        @Nonnull
        public final Builder source(List<String> list) {
            this.source = _listAddAll(this.source, list);
            return this;
        }

        /**
         * The source fields
         * <p>
         * API name: {@code _source}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>source</code>.
         * </p>
         */
        @Nonnull
        public final Builder source(String value, String... values) {
            this.source = _listAdd(this.source, value, values);
            return this;
        }

        /**
         * Builds a {@link InputQuery}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public InputQuery build() {
            _checkSingleUse();

            return new InputQuery(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link InputQuery}
     */
    public static final JsonpDeserializer<InputQuery> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        InputQuery::setupInputQueryDeserializer
    );

    protected static void setupInputQueryDeserializer(ObjectDeserializer<InputQuery.Builder> op) {
        op.add(Builder::query, Query._DESERIALIZER, "query");
        op.add(Builder::size, JsonpDeserializer.longDeserializer(), "size");
        op.add(Builder::source, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "_source");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.query);
        result = 31 * result + Objects.hashCode(this.size);
        result = 31 * result + Objects.hashCode(this.source);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        InputQuery other = (InputQuery) o;
        return Objects.equals(this.query, other.query)
            && Objects.equals(this.size, other.size)
            && Objects.equals(this.source, other.source);
    }
}
