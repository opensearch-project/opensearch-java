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
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonData;
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

// typedef: ism.ErrorNotification

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ErrorNotification implements PlainJsonSerializable, ToCopyableBuilder<ErrorNotification.Builder, ErrorNotification> {

    @Nullable
    private final Channel channel;

    @Nullable
    private final ErrorNotificationDestination destination;

    @Nonnull
    private final Map<String, JsonData> messageTemplate;

    // ---------------------------------------------------------------------------------------------

    private ErrorNotification(Builder builder) {
        this.channel = builder.channel;
        this.destination = builder.destination;
        this.messageTemplate = ApiTypeHelper.unmodifiable(builder.messageTemplate);
    }

    public static ErrorNotification of(Function<ErrorNotification.Builder, ObjectBuilder<ErrorNotification>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code channel}
     */
    @Nullable
    public final Channel channel() {
        return this.channel;
    }

    /**
     * API name: {@code destination}
     */
    @Nullable
    public final ErrorNotificationDestination destination() {
        return this.destination;
    }

    /**
     * The template for error notification messages.
     * <p>
     * API name: {@code message_template}
     * </p>
     */
    @Nonnull
    public final Map<String, JsonData> messageTemplate() {
        return this.messageTemplate;
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
        if (this.channel != null) {
            generator.writeKey("channel");
            this.channel.serialize(generator, mapper);
        }

        if (this.destination != null) {
            generator.writeKey("destination");
            this.destination.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.messageTemplate)) {
            generator.writeKey("message_template");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.messageTemplate.entrySet()) {
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
     * Builder for {@link ErrorNotification}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ErrorNotification> {
        @Nullable
        private Channel channel;
        @Nullable
        private ErrorNotificationDestination destination;
        @Nullable
        private Map<String, JsonData> messageTemplate;

        public Builder() {}

        private Builder(ErrorNotification o) {
            this.channel = o.channel;
            this.destination = o.destination;
            this.messageTemplate = _mapCopy(o.messageTemplate);
        }

        private Builder(Builder o) {
            this.channel = o.channel;
            this.destination = o.destination;
            this.messageTemplate = _mapCopy(o.messageTemplate);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code channel}
         */
        @Nonnull
        public final Builder channel(@Nullable Channel value) {
            this.channel = value;
            return this;
        }

        /**
         * API name: {@code channel}
         */
        @Nonnull
        public final Builder channel(Function<Channel.Builder, ObjectBuilder<Channel>> fn) {
            return channel(fn.apply(new Channel.Builder()).build());
        }

        /**
         * API name: {@code destination}
         */
        @Nonnull
        public final Builder destination(@Nullable ErrorNotificationDestination value) {
            this.destination = value;
            return this;
        }

        /**
         * API name: {@code destination}
         */
        @Nonnull
        public final Builder destination(Function<ErrorNotificationDestination.Builder, ObjectBuilder<ErrorNotificationDestination>> fn) {
            return destination(fn.apply(new ErrorNotificationDestination.Builder()).build());
        }

        /**
         * The template for error notification messages.
         * <p>
         * API name: {@code message_template}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>messageTemplate</code>.
         * </p>
         */
        @Nonnull
        public final Builder messageTemplate(Map<String, JsonData> map) {
            this.messageTemplate = _mapPutAll(this.messageTemplate, map);
            return this;
        }

        /**
         * The template for error notification messages.
         * <p>
         * API name: {@code message_template}
         * </p>
         *
         * <p>
         * Adds an entry to <code>messageTemplate</code>.
         * </p>
         */
        @Nonnull
        public final Builder messageTemplate(String key, JsonData value) {
            this.messageTemplate = _mapPut(this.messageTemplate, key, value);
            return this;
        }

        /**
         * Builds a {@link ErrorNotification}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ErrorNotification build() {
            _checkSingleUse();

            return new ErrorNotification(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ErrorNotification}
     */
    public static final JsonpDeserializer<ErrorNotification> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ErrorNotification::setupErrorNotificationDeserializer
    );

    protected static void setupErrorNotificationDeserializer(ObjectDeserializer<ErrorNotification.Builder> op) {
        op.add(Builder::channel, Channel._DESERIALIZER, "channel");
        op.add(Builder::destination, ErrorNotificationDestination._DESERIALIZER, "destination");
        op.add(Builder::messageTemplate, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "message_template");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.channel);
        result = 31 * result + Objects.hashCode(this.destination);
        result = 31 * result + Objects.hashCode(this.messageTemplate);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ErrorNotification other = (ErrorNotification) o;
        return Objects.equals(this.channel, other.channel)
            && Objects.equals(this.destination, other.destination)
            && Objects.equals(this.messageTemplate, other.messageTemplate);
    }
}
