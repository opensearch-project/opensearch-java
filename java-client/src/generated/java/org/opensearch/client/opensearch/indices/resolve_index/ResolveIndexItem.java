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

// typedef: indices.resolve_index.ResolveIndexItem

/**
 * The resolved information for an index.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ResolveIndexItem implements PlainJsonSerializable, ToCopyableBuilder<ResolveIndexItem.Builder, ResolveIndexItem> {

    @Nonnull
    private final List<String> aliases;

    @Nonnull
    private final List<String> attributes;

    @Nullable
    private final String dataStream;

    @Nonnull
    private final String name;

    // ---------------------------------------------------------------------------------------------

    private ResolveIndexItem(Builder builder) {
        this.aliases = ApiTypeHelper.unmodifiable(builder.aliases);
        this.attributes = ApiTypeHelper.unmodifiableRequired(builder.attributes, this, "attributes");
        this.dataStream = builder.dataStream;
        this.name = ApiTypeHelper.requireNonNull(builder.name, this, "name");
    }

    public static ResolveIndexItem of(Function<ResolveIndexItem.Builder, ObjectBuilder<ResolveIndexItem>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The list of aliases associated with the index.
     * <p>
     * API name: {@code aliases}
     * </p>
     */
    @Nonnull
    public final List<String> aliases() {
        return this.aliases;
    }

    /**
     * Required - The list of index attributes.
     * <p>
     * API name: {@code attributes}
     * </p>
     */
    @Nonnull
    public final List<String> attributes() {
        return this.attributes;
    }

    /**
     * API name: {@code data_stream}
     */
    @Nullable
    public final String dataStream() {
        return this.dataStream;
    }

    /**
     * Required - API name: {@code name}
     */
    @Nonnull
    public final String name() {
        return this.name;
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
        if (ApiTypeHelper.isDefined(this.aliases)) {
            generator.writeKey("aliases");
            generator.writeStartArray();
            for (String item0 : this.aliases) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        generator.writeKey("attributes");
        generator.writeStartArray();
        for (String item0 : this.attributes) {
            generator.write(item0);
        }
        generator.writeEnd();

        if (this.dataStream != null) {
            generator.writeKey("data_stream");
            generator.write(this.dataStream);
        }

        generator.writeKey("name");
        generator.write(this.name);
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
     * Builder for {@link ResolveIndexItem}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ResolveIndexItem> {
        @Nullable
        private List<String> aliases;
        private List<String> attributes;
        @Nullable
        private String dataStream;
        private String name;

        public Builder() {}

        private Builder(ResolveIndexItem o) {
            this.aliases = _listCopy(o.aliases);
            this.attributes = _listCopy(o.attributes);
            this.dataStream = o.dataStream;
            this.name = o.name;
        }

        private Builder(Builder o) {
            this.aliases = _listCopy(o.aliases);
            this.attributes = _listCopy(o.attributes);
            this.dataStream = o.dataStream;
            this.name = o.name;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The list of aliases associated with the index.
         * <p>
         * API name: {@code aliases}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>aliases</code>.
         * </p>
         */
        @Nonnull
        public final Builder aliases(List<String> list) {
            this.aliases = _listAddAll(this.aliases, list);
            return this;
        }

        /**
         * The list of aliases associated with the index.
         * <p>
         * API name: {@code aliases}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>aliases</code>.
         * </p>
         */
        @Nonnull
        public final Builder aliases(String value, String... values) {
            this.aliases = _listAdd(this.aliases, value, values);
            return this;
        }

        /**
         * Required - The list of index attributes.
         * <p>
         * API name: {@code attributes}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>attributes</code>.
         * </p>
         */
        @Nonnull
        public final Builder attributes(List<String> list) {
            this.attributes = _listAddAll(this.attributes, list);
            return this;
        }

        /**
         * Required - The list of index attributes.
         * <p>
         * API name: {@code attributes}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>attributes</code>.
         * </p>
         */
        @Nonnull
        public final Builder attributes(String value, String... values) {
            this.attributes = _listAdd(this.attributes, value, values);
            return this;
        }

        /**
         * API name: {@code data_stream}
         */
        @Nonnull
        public final Builder dataStream(@Nullable String value) {
            this.dataStream = value;
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
         * Builds a {@link ResolveIndexItem}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ResolveIndexItem build() {
            _checkSingleUse();

            return new ResolveIndexItem(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ResolveIndexItem}
     */
    public static final JsonpDeserializer<ResolveIndexItem> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ResolveIndexItem::setupResolveIndexItemDeserializer
    );

    protected static void setupResolveIndexItemDeserializer(ObjectDeserializer<ResolveIndexItem.Builder> op) {
        op.add(Builder::aliases, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "aliases");
        op.add(Builder::attributes, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "attributes");
        op.add(Builder::dataStream, JsonpDeserializer.stringDeserializer(), "data_stream");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.aliases);
        result = 31 * result + this.attributes.hashCode();
        result = 31 * result + Objects.hashCode(this.dataStream);
        result = 31 * result + this.name.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ResolveIndexItem other = (ResolveIndexItem) o;
        return Objects.equals(this.aliases, other.aliases)
            && this.attributes.equals(other.attributes)
            && Objects.equals(this.dataStream, other.dataStream)
            && this.name.equals(other.name);
    }
}
