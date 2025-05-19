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
import java.util.Map;
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

// typedef: ml.Node

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Node implements PlainJsonSerializable, ToCopyableBuilder<Node.Builder, Node> {

    @Nonnull
    private final Map<String, ModelProfile> models;

    @Nonnull
    private final Map<String, Task> tasks;

    // ---------------------------------------------------------------------------------------------

    private Node(Builder builder) {
        this.models = ApiTypeHelper.unmodifiable(builder.models);
        this.tasks = ApiTypeHelper.unmodifiable(builder.tasks);
    }

    public static Node of(Function<Node.Builder, ObjectBuilder<Node>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code models}
     */
    @Nonnull
    public final Map<String, ModelProfile> models() {
        return this.models;
    }

    /**
     * API name: {@code tasks}
     */
    @Nonnull
    public final Map<String, Task> tasks() {
        return this.tasks;
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
        if (ApiTypeHelper.isDefined(this.models)) {
            generator.writeKey("models");
            generator.writeStartObject();
            for (Map.Entry<String, ModelProfile> item0 : this.models.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.tasks)) {
            generator.writeKey("tasks");
            generator.writeStartObject();
            for (Map.Entry<String, Task> item0 : this.tasks.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
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
     * Builder for {@link Node}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, Node> {
        @Nullable
        private Map<String, ModelProfile> models;
        @Nullable
        private Map<String, Task> tasks;

        public Builder() {}

        private Builder(Node o) {
            this.models = _mapCopy(o.models);
            this.tasks = _mapCopy(o.tasks);
        }

        private Builder(Builder o) {
            this.models = _mapCopy(o.models);
            this.tasks = _mapCopy(o.tasks);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code models}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>models</code>.
         * </p>
         */
        @Nonnull
        public final Builder models(Map<String, ModelProfile> map) {
            this.models = _mapPutAll(this.models, map);
            return this;
        }

        /**
         * API name: {@code models}
         *
         * <p>
         * Adds an entry to <code>models</code>.
         * </p>
         */
        @Nonnull
        public final Builder models(String key, ModelProfile value) {
            this.models = _mapPut(this.models, key, value);
            return this;
        }

        /**
         * API name: {@code models}
         *
         * <p>
         * Adds a value to <code>models</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder models(String key, Function<ModelProfile.Builder, ObjectBuilder<ModelProfile>> fn) {
            return models(key, fn.apply(new ModelProfile.Builder()).build());
        }

        /**
         * API name: {@code tasks}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>tasks</code>.
         * </p>
         */
        @Nonnull
        public final Builder tasks(Map<String, Task> map) {
            this.tasks = _mapPutAll(this.tasks, map);
            return this;
        }

        /**
         * API name: {@code tasks}
         *
         * <p>
         * Adds an entry to <code>tasks</code>.
         * </p>
         */
        @Nonnull
        public final Builder tasks(String key, Task value) {
            this.tasks = _mapPut(this.tasks, key, value);
            return this;
        }

        /**
         * API name: {@code tasks}
         *
         * <p>
         * Adds a value to <code>tasks</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder tasks(String key, Function<Task.Builder, ObjectBuilder<Task>> fn) {
            return tasks(key, fn.apply(new Task.Builder()).build());
        }

        /**
         * Builds a {@link Node}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public Node build() {
            _checkSingleUse();

            return new Node(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link Node}
     */
    public static final JsonpDeserializer<Node> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new, Node::setupNodeDeserializer);

    protected static void setupNodeDeserializer(ObjectDeserializer<Node.Builder> op) {
        op.add(Builder::models, JsonpDeserializer.stringMapDeserializer(ModelProfile._DESERIALIZER), "models");
        op.add(Builder::tasks, JsonpDeserializer.stringMapDeserializer(Task._DESERIALIZER), "tasks");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.models);
        result = 31 * result + Objects.hashCode(this.tasks);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Node other = (Node) o;
        return Objects.equals(this.models, other.models) && Objects.equals(this.tasks, other.tasks);
    }
}
