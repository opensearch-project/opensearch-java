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

package org.opensearch.client.opensearch.indices.resolve_index;

import jakarta.json.stream.JsonGenerator;
import java.util.List;
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

// typedef: indices.resolve_index.ResolveIndexDataStreamsItem

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ResolveIndexDataStreamsItem
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ResolveIndexDataStreamsItem.Builder, ResolveIndexDataStreamsItem> {

    @Nonnull
    private final List<String> backingIndices;

    @Nonnull
    private final String name;

    @Nonnull
    private final String timestampField;

    // ---------------------------------------------------------------------------------------------

    private ResolveIndexDataStreamsItem(Builder builder) {
        this.backingIndices = ApiTypeHelper.unmodifiableRequired(builder.backingIndices, this, "backingIndices");
        this.name = ApiTypeHelper.requireNonNull(builder.name, this, "name");
        this.timestampField = ApiTypeHelper.requireNonNull(builder.timestampField, this, "timestampField");
    }

    public static ResolveIndexDataStreamsItem of(
        Function<ResolveIndexDataStreamsItem.Builder, ObjectBuilder<ResolveIndexDataStreamsItem>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code backing_indices}
     */
    @Nonnull
    public final List<String> backingIndices() {
        return this.backingIndices;
    }

    /**
     * Required - API name: {@code name}
     */
    @Nonnull
    public final String name() {
        return this.name;
    }

    /**
     * Required - API name: {@code timestamp_field}
     */
    @Nonnull
    public final String timestampField() {
        return this.timestampField;
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
        generator.writeKey("backing_indices");
        generator.writeStartArray();
        for (String item0 : this.backingIndices) {
            generator.write(item0);
        }
        generator.writeEnd();

        generator.writeKey("name");
        generator.write(this.name);

        generator.writeKey("timestamp_field");
        generator.write(this.timestampField);
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
     * Builder for {@link ResolveIndexDataStreamsItem}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ResolveIndexDataStreamsItem> {
        private List<String> backingIndices;
        private String name;
        private String timestampField;

        public Builder() {}

        private Builder(ResolveIndexDataStreamsItem o) {
            this.backingIndices = _listCopy(o.backingIndices);
            this.name = o.name;
            this.timestampField = o.timestampField;
        }

        private Builder(Builder o) {
            this.backingIndices = _listCopy(o.backingIndices);
            this.name = o.name;
            this.timestampField = o.timestampField;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code backing_indices}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>backingIndices</code>.
         * </p>
         */
        @Nonnull
        public final Builder backingIndices(List<String> list) {
            this.backingIndices = _listAddAll(this.backingIndices, list);
            return this;
        }

        /**
         * Required - API name: {@code backing_indices}
         *
         * <p>
         * Adds one or more values to <code>backingIndices</code>.
         * </p>
         */
        @Nonnull
        public final Builder backingIndices(String value, String... values) {
            this.backingIndices = _listAdd(this.backingIndices, value, values);
            return this;
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
         * Required - API name: {@code timestamp_field}
         */
        @Nonnull
        public final Builder timestampField(String value) {
            this.timestampField = value;
            return this;
        }

        /**
         * Builds a {@link ResolveIndexDataStreamsItem}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ResolveIndexDataStreamsItem build() {
            _checkSingleUse();

            return new ResolveIndexDataStreamsItem(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ResolveIndexDataStreamsItem}
     */
    public static final JsonpDeserializer<ResolveIndexDataStreamsItem> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ResolveIndexDataStreamsItem::setupResolveIndexDataStreamsItemDeserializer
    );

    protected static void setupResolveIndexDataStreamsItemDeserializer(ObjectDeserializer<ResolveIndexDataStreamsItem.Builder> op) {
        op.add(Builder::backingIndices, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "backing_indices");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
        op.add(Builder::timestampField, JsonpDeserializer.stringDeserializer(), "timestamp_field");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.backingIndices.hashCode();
        result = 31 * result + this.name.hashCode();
        result = 31 * result + this.timestampField.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ResolveIndexDataStreamsItem other = (ResolveIndexDataStreamsItem) o;
        return this.backingIndices.equals(other.backingIndices)
            && this.name.equals(other.name)
            && this.timestampField.equals(other.timestampField);
    }
}
