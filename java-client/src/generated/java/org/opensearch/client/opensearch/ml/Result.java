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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ml.Result

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Result implements PlainJsonSerializable, ToCopyableBuilder<Result.Builder, Result> {

    @Nonnull
    private final List<Buckets> buckets;

    // ---------------------------------------------------------------------------------------------

    private Result(Builder builder) {
        this.buckets = ApiTypeHelper.unmodifiable(builder.buckets);
    }

    public static Result of(Function<Result.Builder, ObjectBuilder<Result>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code buckets}
     */
    @Nonnull
    public final List<Buckets> buckets() {
        return this.buckets;
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
        if (ApiTypeHelper.isDefined(this.buckets)) {
            generator.writeKey("buckets");
            generator.writeStartArray();
            for (Buckets item0 : this.buckets) {
                item0.serialize(generator, mapper);
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
     * Builder for {@link Result}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, Result> {
        @Nullable
        private List<Buckets> buckets;

        public Builder() {}

        private Builder(Result o) {
            this.buckets = _listCopy(o.buckets);
        }

        private Builder(Builder o) {
            this.buckets = _listCopy(o.buckets);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code buckets}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>buckets</code>.
         * </p>
         */
        @Nonnull
        public final Builder buckets(List<Buckets> list) {
            this.buckets = _listAddAll(this.buckets, list);
            return this;
        }

        /**
         * API name: {@code buckets}
         *
         * <p>
         * Adds one or more values to <code>buckets</code>.
         * </p>
         */
        @Nonnull
        public final Builder buckets(Buckets value, Buckets... values) {
            this.buckets = _listAdd(this.buckets, value, values);
            return this;
        }

        /**
         * API name: {@code buckets}
         *
         * <p>
         * Adds a value to <code>buckets</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder buckets(Function<Buckets.Builder, ObjectBuilder<Buckets>> fn) {
            return buckets(fn.apply(new Buckets.Builder()).build());
        }

        /**
         * Builds a {@link Result}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public Result build() {
            _checkSingleUse();

            return new Result(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link Result}
     */
    public static final JsonpDeserializer<Result> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        Result::setupResultDeserializer
    );

    protected static void setupResultDeserializer(ObjectDeserializer<Result.Builder> op) {
        op.add(Builder::buckets, JsonpDeserializer.arrayDeserializer(Buckets._DESERIALIZER), "buckets");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.buckets);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Result other = (Result) o;
        return Objects.equals(this.buckets, other.buckets);
    }
}
