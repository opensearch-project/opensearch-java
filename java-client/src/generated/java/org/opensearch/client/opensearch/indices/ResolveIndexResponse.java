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

package org.opensearch.client.opensearch.indices;

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
import org.opensearch.client.opensearch.indices.resolve_index.ResolveIndexAliasItem;
import org.opensearch.client.opensearch.indices.resolve_index.ResolveIndexDataStreamsItem;
import org.opensearch.client.opensearch.indices.resolve_index.ResolveIndexItem;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: indices.resolve_index.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ResolveIndexResponse implements PlainJsonSerializable, ToCopyableBuilder<ResolveIndexResponse.Builder, ResolveIndexResponse> {

    @Nonnull
    private final List<ResolveIndexAliasItem> aliases;

    @Nonnull
    private final List<ResolveIndexDataStreamsItem> dataStreams;

    @Nonnull
    private final List<ResolveIndexItem> indices;

    // ---------------------------------------------------------------------------------------------

    private ResolveIndexResponse(Builder builder) {
        this.aliases = ApiTypeHelper.unmodifiableRequired(builder.aliases, this, "aliases");
        this.dataStreams = ApiTypeHelper.unmodifiableRequired(builder.dataStreams, this, "dataStreams");
        this.indices = ApiTypeHelper.unmodifiableRequired(builder.indices, this, "indices");
    }

    public static ResolveIndexResponse of(Function<ResolveIndexResponse.Builder, ObjectBuilder<ResolveIndexResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code aliases}
     */
    @Nonnull
    public final List<ResolveIndexAliasItem> aliases() {
        return this.aliases;
    }

    /**
     * Required - API name: {@code data_streams}
     */
    @Nonnull
    public final List<ResolveIndexDataStreamsItem> dataStreams() {
        return this.dataStreams;
    }

    /**
     * Required - API name: {@code indices}
     */
    @Nonnull
    public final List<ResolveIndexItem> indices() {
        return this.indices;
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
        generator.writeKey("aliases");
        generator.writeStartArray();
        for (ResolveIndexAliasItem item0 : this.aliases) {
            item0.serialize(generator, mapper);
        }
        generator.writeEnd();

        generator.writeKey("data_streams");
        generator.writeStartArray();
        for (ResolveIndexDataStreamsItem item0 : this.dataStreams) {
            item0.serialize(generator, mapper);
        }
        generator.writeEnd();

        generator.writeKey("indices");
        generator.writeStartArray();
        for (ResolveIndexItem item0 : this.indices) {
            item0.serialize(generator, mapper);
        }
        generator.writeEnd();
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
     * Builder for {@link ResolveIndexResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ResolveIndexResponse> {
        private List<ResolveIndexAliasItem> aliases;
        private List<ResolveIndexDataStreamsItem> dataStreams;
        private List<ResolveIndexItem> indices;

        public Builder() {}

        private Builder(ResolveIndexResponse o) {
            this.aliases = _listCopy(o.aliases);
            this.dataStreams = _listCopy(o.dataStreams);
            this.indices = _listCopy(o.indices);
        }

        private Builder(Builder o) {
            this.aliases = _listCopy(o.aliases);
            this.dataStreams = _listCopy(o.dataStreams);
            this.indices = _listCopy(o.indices);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code aliases}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>aliases</code>.
         * </p>
         */
        @Nonnull
        public final Builder aliases(List<ResolveIndexAliasItem> list) {
            this.aliases = _listAddAll(this.aliases, list);
            return this;
        }

        /**
         * Required - API name: {@code aliases}
         *
         * <p>
         * Adds one or more values to <code>aliases</code>.
         * </p>
         */
        @Nonnull
        public final Builder aliases(ResolveIndexAliasItem value, ResolveIndexAliasItem... values) {
            this.aliases = _listAdd(this.aliases, value, values);
            return this;
        }

        /**
         * Required - API name: {@code aliases}
         *
         * <p>
         * Adds a value to <code>aliases</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder aliases(Function<ResolveIndexAliasItem.Builder, ObjectBuilder<ResolveIndexAliasItem>> fn) {
            return aliases(fn.apply(new ResolveIndexAliasItem.Builder()).build());
        }

        /**
         * Required - API name: {@code data_streams}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>dataStreams</code>.
         * </p>
         */
        @Nonnull
        public final Builder dataStreams(List<ResolveIndexDataStreamsItem> list) {
            this.dataStreams = _listAddAll(this.dataStreams, list);
            return this;
        }

        /**
         * Required - API name: {@code data_streams}
         *
         * <p>
         * Adds one or more values to <code>dataStreams</code>.
         * </p>
         */
        @Nonnull
        public final Builder dataStreams(ResolveIndexDataStreamsItem value, ResolveIndexDataStreamsItem... values) {
            this.dataStreams = _listAdd(this.dataStreams, value, values);
            return this;
        }

        /**
         * Required - API name: {@code data_streams}
         *
         * <p>
         * Adds a value to <code>dataStreams</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder dataStreams(Function<ResolveIndexDataStreamsItem.Builder, ObjectBuilder<ResolveIndexDataStreamsItem>> fn) {
            return dataStreams(fn.apply(new ResolveIndexDataStreamsItem.Builder()).build());
        }

        /**
         * Required - API name: {@code indices}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>indices</code>.
         * </p>
         */
        @Nonnull
        public final Builder indices(List<ResolveIndexItem> list) {
            this.indices = _listAddAll(this.indices, list);
            return this;
        }

        /**
         * Required - API name: {@code indices}
         *
         * <p>
         * Adds one or more values to <code>indices</code>.
         * </p>
         */
        @Nonnull
        public final Builder indices(ResolveIndexItem value, ResolveIndexItem... values) {
            this.indices = _listAdd(this.indices, value, values);
            return this;
        }

        /**
         * Required - API name: {@code indices}
         *
         * <p>
         * Adds a value to <code>indices</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder indices(Function<ResolveIndexItem.Builder, ObjectBuilder<ResolveIndexItem>> fn) {
            return indices(fn.apply(new ResolveIndexItem.Builder()).build());
        }

        /**
         * Builds a {@link ResolveIndexResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ResolveIndexResponse build() {
            _checkSingleUse();

            return new ResolveIndexResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ResolveIndexResponse}
     */
    public static final JsonpDeserializer<ResolveIndexResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ResolveIndexResponse::setupResolveIndexResponseDeserializer
    );

    protected static void setupResolveIndexResponseDeserializer(ObjectDeserializer<ResolveIndexResponse.Builder> op) {
        op.add(Builder::aliases, JsonpDeserializer.arrayDeserializer(ResolveIndexAliasItem._DESERIALIZER), "aliases");
        op.add(Builder::dataStreams, JsonpDeserializer.arrayDeserializer(ResolveIndexDataStreamsItem._DESERIALIZER), "data_streams");
        op.add(Builder::indices, JsonpDeserializer.arrayDeserializer(ResolveIndexItem._DESERIALIZER), "indices");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.aliases.hashCode();
        result = 31 * result + this.dataStreams.hashCode();
        result = 31 * result + this.indices.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ResolveIndexResponse other = (ResolveIndexResponse) o;
        return this.aliases.equals(other.aliases) && this.dataStreams.equals(other.dataStreams) && this.indices.equals(other.indices);
    }
}
