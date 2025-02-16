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

// typedef: core.search.FetchProfile

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class FetchProfile implements PlainJsonSerializable, ToCopyableBuilder<FetchProfile.Builder, FetchProfile> {

    @Nonnull
    private final FetchProfileBreakdown breakdown;

    @Nonnull
    private final List<FetchProfile> children;

    @Nullable
    private final FetchProfileDebug debug;

    @Nonnull
    private final String description;

    private final long timeInNanos;

    @Nonnull
    private final String type;

    // ---------------------------------------------------------------------------------------------

    private FetchProfile(Builder builder) {
        this.breakdown = ApiTypeHelper.requireNonNull(builder.breakdown, this, "breakdown");
        this.children = ApiTypeHelper.unmodifiable(builder.children);
        this.debug = builder.debug;
        this.description = ApiTypeHelper.requireNonNull(builder.description, this, "description");
        this.timeInNanos = ApiTypeHelper.requireNonNull(builder.timeInNanos, this, "timeInNanos");
        this.type = ApiTypeHelper.requireNonNull(builder.type, this, "type");
    }

    public static FetchProfile of(Function<FetchProfile.Builder, ObjectBuilder<FetchProfile>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code breakdown}
     */
    @Nonnull
    public final FetchProfileBreakdown breakdown() {
        return this.breakdown;
    }

    /**
     * API name: {@code children}
     */
    @Nonnull
    public final List<FetchProfile> children() {
        return this.children;
    }

    /**
     * API name: {@code debug}
     */
    @Nullable
    public final FetchProfileDebug debug() {
        return this.debug;
    }

    /**
     * Required - API name: {@code description}
     */
    @Nonnull
    public final String description() {
        return this.description;
    }

    /**
     * Required - API name: {@code time_in_nanos}
     */
    public final long timeInNanos() {
        return this.timeInNanos;
    }

    /**
     * Required - API name: {@code type}
     */
    @Nonnull
    public final String type() {
        return this.type;
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
        generator.writeKey("breakdown");
        this.breakdown.serialize(generator, mapper);

        if (ApiTypeHelper.isDefined(this.children)) {
            generator.writeKey("children");
            generator.writeStartArray();
            for (FetchProfile item0 : this.children) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.debug != null) {
            generator.writeKey("debug");
            this.debug.serialize(generator, mapper);
        }

        generator.writeKey("description");
        generator.write(this.description);

        generator.writeKey("time_in_nanos");
        generator.write(this.timeInNanos);

        generator.writeKey("type");
        generator.write(this.type);
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
     * Builder for {@link FetchProfile}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, FetchProfile> {
        private FetchProfileBreakdown breakdown;
        @Nullable
        private List<FetchProfile> children;
        @Nullable
        private FetchProfileDebug debug;
        private String description;
        private Long timeInNanos;
        private String type;

        public Builder() {}

        private Builder(FetchProfile o) {
            this.breakdown = o.breakdown;
            this.children = _listCopy(o.children);
            this.debug = o.debug;
            this.description = o.description;
            this.timeInNanos = o.timeInNanos;
            this.type = o.type;
        }

        private Builder(Builder o) {
            this.breakdown = o.breakdown;
            this.children = _listCopy(o.children);
            this.debug = o.debug;
            this.description = o.description;
            this.timeInNanos = o.timeInNanos;
            this.type = o.type;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code breakdown}
         */
        @Nonnull
        public final Builder breakdown(FetchProfileBreakdown value) {
            this.breakdown = value;
            return this;
        }

        /**
         * Required - API name: {@code breakdown}
         */
        @Nonnull
        public final Builder breakdown(Function<FetchProfileBreakdown.Builder, ObjectBuilder<FetchProfileBreakdown>> fn) {
            return breakdown(fn.apply(new FetchProfileBreakdown.Builder()).build());
        }

        /**
         * API name: {@code children}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>children</code>.
         * </p>
         */
        @Nonnull
        public final Builder children(List<FetchProfile> list) {
            this.children = _listAddAll(this.children, list);
            return this;
        }

        /**
         * API name: {@code children}
         *
         * <p>
         * Adds one or more values to <code>children</code>.
         * </p>
         */
        @Nonnull
        public final Builder children(FetchProfile value, FetchProfile... values) {
            this.children = _listAdd(this.children, value, values);
            return this;
        }

        /**
         * API name: {@code children}
         *
         * <p>
         * Adds a value to <code>children</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder children(Function<FetchProfile.Builder, ObjectBuilder<FetchProfile>> fn) {
            return children(fn.apply(new FetchProfile.Builder()).build());
        }

        /**
         * API name: {@code debug}
         */
        @Nonnull
        public final Builder debug(@Nullable FetchProfileDebug value) {
            this.debug = value;
            return this;
        }

        /**
         * API name: {@code debug}
         */
        @Nonnull
        public final Builder debug(Function<FetchProfileDebug.Builder, ObjectBuilder<FetchProfileDebug>> fn) {
            return debug(fn.apply(new FetchProfileDebug.Builder()).build());
        }

        /**
         * Required - API name: {@code description}
         */
        @Nonnull
        public final Builder description(String value) {
            this.description = value;
            return this;
        }

        /**
         * Required - API name: {@code time_in_nanos}
         */
        @Nonnull
        public final Builder timeInNanos(long value) {
            this.timeInNanos = value;
            return this;
        }

        /**
         * Required - API name: {@code type}
         */
        @Nonnull
        public final Builder type(String value) {
            this.type = value;
            return this;
        }

        /**
         * Builds a {@link FetchProfile}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public FetchProfile build() {
            _checkSingleUse();

            return new FetchProfile(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link FetchProfile}
     */
    public static final JsonpDeserializer<FetchProfile> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        FetchProfile::setupFetchProfileDeserializer
    );

    protected static void setupFetchProfileDeserializer(ObjectDeserializer<FetchProfile.Builder> op) {
        op.add(Builder::breakdown, FetchProfileBreakdown._DESERIALIZER, "breakdown");
        op.add(Builder::children, JsonpDeserializer.arrayDeserializer(FetchProfile._DESERIALIZER), "children");
        op.add(Builder::debug, FetchProfileDebug._DESERIALIZER, "debug");
        op.add(Builder::description, JsonpDeserializer.stringDeserializer(), "description");
        op.add(Builder::timeInNanos, JsonpDeserializer.longDeserializer(), "time_in_nanos");
        op.add(Builder::type, JsonpDeserializer.stringDeserializer(), "type");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.breakdown.hashCode();
        result = 31 * result + Objects.hashCode(this.children);
        result = 31 * result + Objects.hashCode(this.debug);
        result = 31 * result + this.description.hashCode();
        result = 31 * result + Long.hashCode(this.timeInNanos);
        result = 31 * result + this.type.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        FetchProfile other = (FetchProfile) o;
        return this.breakdown.equals(other.breakdown)
            && Objects.equals(this.children, other.children)
            && Objects.equals(this.debug, other.debug)
            && this.description.equals(other.description)
            && this.timeInNanos == other.timeInNanos
            && this.type.equals(other.type);
    }
}
