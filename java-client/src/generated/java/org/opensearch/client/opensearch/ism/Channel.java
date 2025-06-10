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

package org.opensearch.client.opensearch.ism;

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

// typedef: ism.Channel

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Channel implements PlainJsonSerializable, ToCopyableBuilder<Channel.Builder, Channel> {

    @Nullable
    private final String id;

    // ---------------------------------------------------------------------------------------------

    private Channel(Builder builder) {
        this.id = builder.id;
    }

    public static Channel of(Function<Channel.Builder, ObjectBuilder<Channel>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The ID of the notification channel.
     * <p>
     * API name: {@code id}
     * </p>
     */
    @Nullable
    public final String id() {
        return this.id;
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
        if (this.id != null) {
            generator.writeKey("id");
            generator.write(this.id);
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
     * Builder for {@link Channel}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, Channel> {
        @Nullable
        private String id;

        public Builder() {}

        private Builder(Channel o) {
            this.id = o.id;
        }

        private Builder(Builder o) {
            this.id = o.id;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The ID of the notification channel.
         * <p>
         * API name: {@code id}
         * </p>
         */
        @Nonnull
        public final Builder id(@Nullable String value) {
            this.id = value;
            return this;
        }

        /**
         * Builds a {@link Channel}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public Channel build() {
            _checkSingleUse();

            return new Channel(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link Channel}
     */
    public static final JsonpDeserializer<Channel> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        Channel::setupChannelDeserializer
    );

    protected static void setupChannelDeserializer(ObjectDeserializer<Channel.Builder> op) {
        op.add(Builder::id, JsonpDeserializer.stringDeserializer(), "id");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.id);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Channel other = (Channel) o;
        return Objects.equals(this.id, other.id);
    }
}
