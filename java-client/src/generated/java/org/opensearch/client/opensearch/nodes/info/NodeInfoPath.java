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

package org.opensearch.client.opensearch.nodes.info;

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

// typedef: nodes.info.NodeInfoPath

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NodeInfoPath implements PlainJsonSerializable, ToCopyableBuilder<NodeInfoPath.Builder, NodeInfoPath> {

    @Nonnull
    private final List<String> data;

    @Nonnull
    private final String home;

    @Nonnull
    private final String logs;

    @Nonnull
    private final List<String> repo;

    // ---------------------------------------------------------------------------------------------

    private NodeInfoPath(Builder builder) {
        this.data = ApiTypeHelper.unmodifiable(builder.data);
        this.home = ApiTypeHelper.requireNonNull(builder.home, this, "home");
        this.logs = ApiTypeHelper.requireNonNull(builder.logs, this, "logs");
        this.repo = ApiTypeHelper.unmodifiable(builder.repo);
    }

    public static NodeInfoPath of(Function<NodeInfoPath.Builder, ObjectBuilder<NodeInfoPath>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code data}
     */
    @Nonnull
    public final List<String> data() {
        return this.data;
    }

    /**
     * Required - API name: {@code home}
     */
    @Nonnull
    public final String home() {
        return this.home;
    }

    /**
     * Required - API name: {@code logs}
     */
    @Nonnull
    public final String logs() {
        return this.logs;
    }

    /**
     * API name: {@code repo}
     */
    @Nonnull
    public final List<String> repo() {
        return this.repo;
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
        if (ApiTypeHelper.isDefined(this.data)) {
            generator.writeKey("data");
            generator.writeStartArray();
            for (String item0 : this.data) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        generator.writeKey("home");
        generator.write(this.home);

        generator.writeKey("logs");
        generator.write(this.logs);

        if (ApiTypeHelper.isDefined(this.repo)) {
            generator.writeKey("repo");
            generator.writeStartArray();
            for (String item0 : this.repo) {
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
     * Builder for {@link NodeInfoPath}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, NodeInfoPath> {
        @Nullable
        private List<String> data;
        private String home;
        private String logs;
        @Nullable
        private List<String> repo;

        public Builder() {}

        private Builder(NodeInfoPath o) {
            this.data = _listCopy(o.data);
            this.home = o.home;
            this.logs = o.logs;
            this.repo = _listCopy(o.repo);
        }

        private Builder(Builder o) {
            this.data = _listCopy(o.data);
            this.home = o.home;
            this.logs = o.logs;
            this.repo = _listCopy(o.repo);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code data}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>data</code>.
         * </p>
         */
        @Nonnull
        public final Builder data(List<String> list) {
            this.data = _listAddAll(this.data, list);
            return this;
        }

        /**
         * API name: {@code data}
         *
         * <p>
         * Adds one or more values to <code>data</code>.
         * </p>
         */
        @Nonnull
        public final Builder data(String value, String... values) {
            this.data = _listAdd(this.data, value, values);
            return this;
        }

        /**
         * Required - API name: {@code home}
         */
        @Nonnull
        public final Builder home(String value) {
            this.home = value;
            return this;
        }

        /**
         * Required - API name: {@code logs}
         */
        @Nonnull
        public final Builder logs(String value) {
            this.logs = value;
            return this;
        }

        /**
         * API name: {@code repo}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>repo</code>.
         * </p>
         */
        @Nonnull
        public final Builder repo(List<String> list) {
            this.repo = _listAddAll(this.repo, list);
            return this;
        }

        /**
         * API name: {@code repo}
         *
         * <p>
         * Adds one or more values to <code>repo</code>.
         * </p>
         */
        @Nonnull
        public final Builder repo(String value, String... values) {
            this.repo = _listAdd(this.repo, value, values);
            return this;
        }

        /**
         * Builds a {@link NodeInfoPath}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NodeInfoPath build() {
            _checkSingleUse();

            return new NodeInfoPath(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NodeInfoPath}
     */
    public static final JsonpDeserializer<NodeInfoPath> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NodeInfoPath::setupNodeInfoPathDeserializer
    );

    protected static void setupNodeInfoPathDeserializer(ObjectDeserializer<NodeInfoPath.Builder> op) {
        op.add(Builder::data, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "data");
        op.add(Builder::home, JsonpDeserializer.stringDeserializer(), "home");
        op.add(Builder::logs, JsonpDeserializer.stringDeserializer(), "logs");
        op.add(Builder::repo, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "repo");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.data);
        result = 31 * result + this.home.hashCode();
        result = 31 * result + this.logs.hashCode();
        result = 31 * result + Objects.hashCode(this.repo);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NodeInfoPath other = (NodeInfoPath) o;
        return Objects.equals(this.data, other.data)
            && this.home.equals(other.home)
            && this.logs.equals(other.logs)
            && Objects.equals(this.repo, other.repo);
    }
}
