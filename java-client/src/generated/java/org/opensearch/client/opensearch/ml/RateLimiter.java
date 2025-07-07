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
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
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

// typedef: ml.RateLimiter

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RateLimiter implements PlainJsonSerializable, ToCopyableBuilder<RateLimiter.Builder, RateLimiter> {

    private final double limit;

    @Nonnull
    private final RateLimiterUnit unit;

    // ---------------------------------------------------------------------------------------------

    private RateLimiter(Builder builder) {
        this.limit = ApiTypeHelper.requireNonNull(builder.limit, this, "limit");
        this.unit = ApiTypeHelper.requireNonNull(builder.unit, this, "unit");
    }

    public static RateLimiter of(Function<RateLimiter.Builder, ObjectBuilder<RateLimiter>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The maximum limit.
     * <p>
     * API name: {@code limit}
     * </p>
     */
    public final double limit() {
        return this.limit;
    }

    /**
     * Required - The unit of time.
     * <p>
     * API name: {@code unit}
     * </p>
     */
    @Nonnull
    public final RateLimiterUnit unit() {
        return this.unit;
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
        generator.writeKey("limit");
        generator.write(this.limit);

        generator.writeKey("unit");
        this.unit.serialize(generator, mapper);
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
     * Builder for {@link RateLimiter}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, RateLimiter> {
        private Double limit;
        private RateLimiterUnit unit;

        public Builder() {}

        private Builder(RateLimiter o) {
            this.limit = o.limit;
            this.unit = o.unit;
        }

        private Builder(Builder o) {
            this.limit = o.limit;
            this.unit = o.unit;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - The maximum limit.
         * <p>
         * API name: {@code limit}
         * </p>
         */
        @Nonnull
        public final Builder limit(double value) {
            this.limit = value;
            return this;
        }

        /**
         * Required - The unit of time.
         * <p>
         * API name: {@code unit}
         * </p>
         */
        @Nonnull
        public final Builder unit(RateLimiterUnit value) {
            this.unit = value;
            return this;
        }

        /**
         * Builds a {@link RateLimiter}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RateLimiter build() {
            _checkSingleUse();

            return new RateLimiter(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RateLimiter}
     */
    public static final JsonpDeserializer<RateLimiter> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RateLimiter::setupRateLimiterDeserializer
    );

    protected static void setupRateLimiterDeserializer(ObjectDeserializer<RateLimiter.Builder> op) {
        op.add(Builder::limit, JsonpDeserializer.doubleDeserializer(), "limit");
        op.add(Builder::unit, RateLimiterUnit._DESERIALIZER, "unit");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Double.hashCode(this.limit);
        result = 31 * result + this.unit.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RateLimiter other = (RateLimiter) o;
        return this.limit == other.limit && this.unit.equals(other.unit);
    }
}
