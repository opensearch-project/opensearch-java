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

// typedef: core.search.Collector

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Collector implements PlainJsonSerializable, ToCopyableBuilder<Collector.Builder, Collector> {

    @Nonnull
    private final List<Collector> children;

    @Nonnull
    private final String name;

    @Nonnull
    private final String reason;

    private final long timeInNanos;

    // ---------------------------------------------------------------------------------------------

    private Collector(Builder builder) {
        this.children = ApiTypeHelper.unmodifiable(builder.children);
        this.name = ApiTypeHelper.requireNonNull(builder.name, this, "name");
        this.reason = ApiTypeHelper.requireNonNull(builder.reason, this, "reason");
        this.timeInNanos = ApiTypeHelper.requireNonNull(builder.timeInNanos, this, "timeInNanos");
    }

    public static Collector of(Function<Collector.Builder, ObjectBuilder<Collector>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code children}
     */
    @Nonnull
    public final List<Collector> children() {
        return this.children;
    }

    /**
     * Required - API name: {@code name}
     */
    @Nonnull
    public final String name() {
        return this.name;
    }

    /**
     * Required - API name: {@code reason}
     */
    @Nonnull
    public final String reason() {
        return this.reason;
    }

    /**
     * Required - API name: {@code time_in_nanos}
     */
    public final long timeInNanos() {
        return this.timeInNanos;
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
        if (ApiTypeHelper.isDefined(this.children)) {
            generator.writeKey("children");
            generator.writeStartArray();
            for (Collector item0 : this.children) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        generator.writeKey("name");
        generator.write(this.name);

        generator.writeKey("reason");
        generator.write(this.reason);

        generator.writeKey("time_in_nanos");
        generator.write(this.timeInNanos);
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
     * Builder for {@link Collector}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, Collector> {
        @Nullable
        private List<Collector> children;
        private String name;
        private String reason;
        private Long timeInNanos;

        public Builder() {}

        private Builder(Collector o) {
            this.children = _listCopy(o.children);
            this.name = o.name;
            this.reason = o.reason;
            this.timeInNanos = o.timeInNanos;
        }

        private Builder(Builder o) {
            this.children = _listCopy(o.children);
            this.name = o.name;
            this.reason = o.reason;
            this.timeInNanos = o.timeInNanos;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code children}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>children</code>.
         * </p>
         */
        @Nonnull
        public final Builder children(List<Collector> list) {
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
        public final Builder children(Collector value, Collector... values) {
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
        public final Builder children(Function<Collector.Builder, ObjectBuilder<Collector>> fn) {
            return children(fn.apply(new Collector.Builder()).build());
        }

        /**
         * Required - API name: {@code name}
         */
        @Nonnull
        public final Builder name(String value) {
            this.name = value;
            return this;
        }

        /**
         * Required - API name: {@code reason}
         */
        @Nonnull
        public final Builder reason(String value) {
            this.reason = value;
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
         * Builds a {@link Collector}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public Collector build() {
            _checkSingleUse();

            return new Collector(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link Collector}
     */
    public static final JsonpDeserializer<Collector> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        Collector::setupCollectorDeserializer
    );

    protected static void setupCollectorDeserializer(ObjectDeserializer<Collector.Builder> op) {
        op.add(Builder::children, JsonpDeserializer.arrayDeserializer(Collector._DESERIALIZER), "children");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
        op.add(Builder::reason, JsonpDeserializer.stringDeserializer(), "reason");
        op.add(Builder::timeInNanos, JsonpDeserializer.longDeserializer(), "time_in_nanos");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.children);
        result = 31 * result + this.name.hashCode();
        result = 31 * result + this.reason.hashCode();
        result = 31 * result + Long.hashCode(this.timeInNanos);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Collector other = (Collector) o;
        return Objects.equals(this.children, other.children)
            && this.name.equals(other.name)
            && this.reason.equals(other.reason)
            && this.timeInNanos == other.timeInNanos;
    }
}
