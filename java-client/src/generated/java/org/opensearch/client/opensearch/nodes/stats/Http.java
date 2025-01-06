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

package org.opensearch.client.opensearch.nodes.stats;

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

// typedef: nodes.stats.Http

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Http implements PlainJsonSerializable, ToCopyableBuilder<Http.Builder, Http> {

    @Nullable
    private final Long currentOpen;

    @Nullable
    private final Long totalOpened;

    // ---------------------------------------------------------------------------------------------

    private Http(Builder builder) {
        this.currentOpen = builder.currentOpen;
        this.totalOpened = builder.totalOpened;
    }

    public static Http of(Function<Http.Builder, ObjectBuilder<Http>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Current number of open HTTP connections for the node.
     * <p>
     * API name: {@code current_open}
     * </p>
     */
    @Nullable
    public final Long currentOpen() {
        return this.currentOpen;
    }

    /**
     * Total number of HTTP connections opened for the node.
     * <p>
     * API name: {@code total_opened}
     * </p>
     */
    @Nullable
    public final Long totalOpened() {
        return this.totalOpened;
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
        if (this.currentOpen != null) {
            generator.writeKey("current_open");
            generator.write(this.currentOpen);
        }

        if (this.totalOpened != null) {
            generator.writeKey("total_opened");
            generator.write(this.totalOpened);
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
     * Builder for {@link Http}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, Http> {
        @Nullable
        private Long currentOpen;
        @Nullable
        private Long totalOpened;

        public Builder() {}

        private Builder(Http o) {
            this.currentOpen = o.currentOpen;
            this.totalOpened = o.totalOpened;
        }

        private Builder(Builder o) {
            this.currentOpen = o.currentOpen;
            this.totalOpened = o.totalOpened;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Current number of open HTTP connections for the node.
         * <p>
         * API name: {@code current_open}
         * </p>
         */
        @Nonnull
        public final Builder currentOpen(@Nullable Long value) {
            this.currentOpen = value;
            return this;
        }

        /**
         * Total number of HTTP connections opened for the node.
         * <p>
         * API name: {@code total_opened}
         * </p>
         */
        @Nonnull
        public final Builder totalOpened(@Nullable Long value) {
            this.totalOpened = value;
            return this;
        }

        /**
         * Builds a {@link Http}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public Http build() {
            _checkSingleUse();

            return new Http(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link Http}
     */
    public static final JsonpDeserializer<Http> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new, Http::setupHttpDeserializer);

    protected static void setupHttpDeserializer(ObjectDeserializer<Http.Builder> op) {
        op.add(Builder::currentOpen, JsonpDeserializer.longDeserializer(), "current_open");
        op.add(Builder::totalOpened, JsonpDeserializer.longDeserializer(), "total_opened");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.currentOpen);
        result = 31 * result + Objects.hashCode(this.totalOpened);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Http other = (Http) o;
        return Objects.equals(this.currentOpen, other.currentOpen) && Objects.equals(this.totalOpened, other.totalOpened);
    }
}
