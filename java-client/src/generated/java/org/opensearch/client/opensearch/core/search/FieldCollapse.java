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

// typedef: core.search.FieldCollapse

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class FieldCollapse implements PlainJsonSerializable, ToCopyableBuilder<FieldCollapse.Builder, FieldCollapse> {

    @Nonnull
    private final String field;

    @Nonnull
    private final List<InnerHits> innerHits;

    @Nullable
    private final Integer maxConcurrentGroupSearches;

    // ---------------------------------------------------------------------------------------------

    private FieldCollapse(Builder builder) {
        this.field = ApiTypeHelper.requireNonNull(builder.field, this, "field");
        this.innerHits = ApiTypeHelper.unmodifiable(builder.innerHits);
        this.maxConcurrentGroupSearches = builder.maxConcurrentGroupSearches;
    }

    public static FieldCollapse of(Function<FieldCollapse.Builder, ObjectBuilder<FieldCollapse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code field}
     */
    @Nonnull
    public final String field() {
        return this.field;
    }

    /**
     * The number of inner hits and their sort order.
     * <p>
     * API name: {@code inner_hits}
     * </p>
     */
    @Nonnull
    public final List<InnerHits> innerHits() {
        return this.innerHits;
    }

    /**
     * The number of concurrent requests that are allowed to be retrieved by the <code>inner_hits</code> parameter per group.
     * <p>
     * API name: {@code max_concurrent_group_searches}
     * </p>
     */
    @Nullable
    public final Integer maxConcurrentGroupSearches() {
        return this.maxConcurrentGroupSearches;
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
        generator.writeKey("field");
        generator.write(this.field);

        if (ApiTypeHelper.isDefined(this.innerHits)) {
            generator.writeKey("inner_hits");
            generator.writeStartArray();
            for (InnerHits item0 : this.innerHits) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.maxConcurrentGroupSearches != null) {
            generator.writeKey("max_concurrent_group_searches");
            generator.write(this.maxConcurrentGroupSearches);
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
     * Builder for {@link FieldCollapse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, FieldCollapse> {
        private String field;
        @Nullable
        private List<InnerHits> innerHits;
        @Nullable
        private Integer maxConcurrentGroupSearches;

        public Builder() {}

        private Builder(FieldCollapse o) {
            this.field = o.field;
            this.innerHits = _listCopy(o.innerHits);
            this.maxConcurrentGroupSearches = o.maxConcurrentGroupSearches;
        }

        private Builder(Builder o) {
            this.field = o.field;
            this.innerHits = _listCopy(o.innerHits);
            this.maxConcurrentGroupSearches = o.maxConcurrentGroupSearches;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code field}
         */
        @Nonnull
        public final Builder field(String value) {
            this.field = value;
            return this;
        }

        /**
         * The number of inner hits and their sort order.
         * <p>
         * API name: {@code inner_hits}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>innerHits</code>.
         * </p>
         */
        @Nonnull
        public final Builder innerHits(List<InnerHits> list) {
            this.innerHits = _listAddAll(this.innerHits, list);
            return this;
        }

        /**
         * The number of inner hits and their sort order.
         * <p>
         * API name: {@code inner_hits}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>innerHits</code>.
         * </p>
         */
        @Nonnull
        public final Builder innerHits(InnerHits value, InnerHits... values) {
            this.innerHits = _listAdd(this.innerHits, value, values);
            return this;
        }

        /**
         * The number of inner hits and their sort order.
         * <p>
         * API name: {@code inner_hits}
         * </p>
         *
         * <p>
         * Adds a value to <code>innerHits</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder innerHits(Function<InnerHits.Builder, ObjectBuilder<InnerHits>> fn) {
            return innerHits(fn.apply(new InnerHits.Builder()).build());
        }

        /**
         * The number of concurrent requests that are allowed to be retrieved by the <code>inner_hits</code> parameter per group.
         * <p>
         * API name: {@code max_concurrent_group_searches}
         * </p>
         */
        @Nonnull
        public final Builder maxConcurrentGroupSearches(@Nullable Integer value) {
            this.maxConcurrentGroupSearches = value;
            return this;
        }

        /**
         * Builds a {@link FieldCollapse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public FieldCollapse build() {
            _checkSingleUse();

            return new FieldCollapse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link FieldCollapse}
     */
    public static final JsonpDeserializer<FieldCollapse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        FieldCollapse::setupFieldCollapseDeserializer
    );

    protected static void setupFieldCollapseDeserializer(ObjectDeserializer<FieldCollapse.Builder> op) {
        op.add(Builder::field, JsonpDeserializer.stringDeserializer(), "field");
        op.add(Builder::innerHits, JsonpDeserializer.arrayDeserializer(InnerHits._DESERIALIZER), "inner_hits");
        op.add(Builder::maxConcurrentGroupSearches, JsonpDeserializer.integerDeserializer(), "max_concurrent_group_searches");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.field.hashCode();
        result = 31 * result + Objects.hashCode(this.innerHits);
        result = 31 * result + Objects.hashCode(this.maxConcurrentGroupSearches);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        FieldCollapse other = (FieldCollapse) o;
        return this.field.equals(other.field)
            && Objects.equals(this.innerHits, other.innerHits)
            && Objects.equals(this.maxConcurrentGroupSearches, other.maxConcurrentGroupSearches);
    }
}
