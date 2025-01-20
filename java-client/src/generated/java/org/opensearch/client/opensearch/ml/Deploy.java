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
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ml.Deploy

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Deploy implements PlainJsonSerializable, ToCopyableBuilder<Deploy.Builder, Deploy> {

    @Nullable
    private final Long mlActionFailureCount;

    @Nullable
    private final Long mlActionRequestCount;

    @Nullable
    private final Long mlExecutingTaskCount;

    // ---------------------------------------------------------------------------------------------

    private Deploy(Builder builder) {
        this.mlActionFailureCount = builder.mlActionFailureCount;
        this.mlActionRequestCount = builder.mlActionRequestCount;
        this.mlExecutingTaskCount = builder.mlExecutingTaskCount;
    }

    public static Deploy of(Function<Deploy.Builder, ObjectBuilder<Deploy>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The failure count.
     * <p>
     * API name: {@code ml_action_failure_count}
     * </p>
     */
    @Nullable
    public final Long mlActionFailureCount() {
        return this.mlActionFailureCount;
    }

    /**
     * The request count.
     * <p>
     * API name: {@code ml_action_request_count}
     * </p>
     */
    @Nullable
    public final Long mlActionRequestCount() {
        return this.mlActionRequestCount;
    }

    /**
     * The executing task count.
     * <p>
     * API name: {@code ml_executing_task_count}
     * </p>
     */
    @Nullable
    public final Long mlExecutingTaskCount() {
        return this.mlExecutingTaskCount;
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
        if (this.mlActionFailureCount != null) {
            generator.writeKey("ml_action_failure_count");
            generator.write(this.mlActionFailureCount);
        }

        if (this.mlActionRequestCount != null) {
            generator.writeKey("ml_action_request_count");
            generator.write(this.mlActionRequestCount);
        }

        if (this.mlExecutingTaskCount != null) {
            generator.writeKey("ml_executing_task_count");
            generator.write(this.mlExecutingTaskCount);
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
     * Builder for {@link Deploy}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, Deploy> {
        @Nullable
        private Long mlActionFailureCount;
        @Nullable
        private Long mlActionRequestCount;
        @Nullable
        private Long mlExecutingTaskCount;

        public Builder() {}

        private Builder(Deploy o) {
            this.mlActionFailureCount = o.mlActionFailureCount;
            this.mlActionRequestCount = o.mlActionRequestCount;
            this.mlExecutingTaskCount = o.mlExecutingTaskCount;
        }

        private Builder(Builder o) {
            this.mlActionFailureCount = o.mlActionFailureCount;
            this.mlActionRequestCount = o.mlActionRequestCount;
            this.mlExecutingTaskCount = o.mlExecutingTaskCount;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The failure count.
         * <p>
         * API name: {@code ml_action_failure_count}
         * </p>
         */
        @Nonnull
        public final Builder mlActionFailureCount(@Nullable Long value) {
            this.mlActionFailureCount = value;
            return this;
        }

        /**
         * The request count.
         * <p>
         * API name: {@code ml_action_request_count}
         * </p>
         */
        @Nonnull
        public final Builder mlActionRequestCount(@Nullable Long value) {
            this.mlActionRequestCount = value;
            return this;
        }

        /**
         * The executing task count.
         * <p>
         * API name: {@code ml_executing_task_count}
         * </p>
         */
        @Nonnull
        public final Builder mlExecutingTaskCount(@Nullable Long value) {
            this.mlExecutingTaskCount = value;
            return this;
        }

        /**
         * Builds a {@link Deploy}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public Deploy build() {
            _checkSingleUse();

            return new Deploy(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link Deploy}
     */
    public static final JsonpDeserializer<Deploy> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        Deploy::setupDeployDeserializer
    );

    protected static void setupDeployDeserializer(ObjectDeserializer<Deploy.Builder> op) {
        op.add(Builder::mlActionFailureCount, JsonpDeserializer.longDeserializer(), "ml_action_failure_count");
        op.add(Builder::mlActionRequestCount, JsonpDeserializer.longDeserializer(), "ml_action_request_count");
        op.add(Builder::mlExecutingTaskCount, JsonpDeserializer.longDeserializer(), "ml_executing_task_count");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.mlActionFailureCount);
        result = 31 * result + Objects.hashCode(this.mlActionRequestCount);
        result = 31 * result + Objects.hashCode(this.mlExecutingTaskCount);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Deploy other = (Deploy) o;
        return Objects.equals(this.mlActionFailureCount, other.mlActionFailureCount)
            && Objects.equals(this.mlActionRequestCount, other.mlActionRequestCount)
            && Objects.equals(this.mlExecutingTaskCount, other.mlExecutingTaskCount);
    }
}
