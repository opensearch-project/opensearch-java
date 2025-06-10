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
import java.util.HashMap;
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

// typedef: ism.ErrorNotificationDestination

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ErrorNotificationDestination
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ErrorNotificationDestination.Builder, ErrorNotificationDestination> {

    @Nullable
    private final Integer lastUpdateTime;

    @Nonnull
    private final Map<String, Map<String, JsonData>> metadata;

    @Nullable
    private final String name;

    // ---------------------------------------------------------------------------------------------

    private ErrorNotificationDestination(Builder builder) {
        this.lastUpdateTime = builder.lastUpdateTime;
        this.metadata = ApiTypeHelper.unmodifiable(builder.metadata);
        this.name = builder.name;
    }

    public static ErrorNotificationDestination of(
        Function<ErrorNotificationDestination.Builder, ObjectBuilder<ErrorNotificationDestination>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * When the notification destination was last updated.
     * <p>
     * API name: {@code last_update_time}
     * </p>
     */
    @Nullable
    public final Integer lastUpdateTime() {
        return this.lastUpdateTime;
    }

    @Nonnull
    public final Map<String, Map<String, JsonData>> metadata() {
        return this.metadata;
    }

    /**
     * The name of the notification destination.
     * <p>
     * API name: {@code name}
     * </p>
     */
    @Nullable
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
        for (Map.Entry<String, Map<String, JsonData>> item0 : this.metadata.entrySet()) {
            generator.writeKey(item0.getKey());
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item1 : item0.getValue().entrySet()) {
                generator.writeKey(item1.getKey());
                item1.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }
        if (this.lastUpdateTime != null) {
            generator.writeKey("last_update_time");
            generator.write(this.lastUpdateTime);
        }

        if (this.name != null) {
            generator.writeKey("name");
            generator.write(this.name);
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
     * Builder for {@link ErrorNotificationDestination}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ErrorNotificationDestination> {
        @Nullable
        private Integer lastUpdateTime;
        @Nullable
        private Map<String, Map<String, JsonData>> metadata;
        @Nullable
        private String name;

        public Builder() {}

        private Builder(ErrorNotificationDestination o) {
            this.lastUpdateTime = o.lastUpdateTime;
            this.metadata = _mapCopy(o.metadata);
            this.name = o.name;
        }

        private Builder(Builder o) {
            this.lastUpdateTime = o.lastUpdateTime;
            this.metadata = _mapCopy(o.metadata);
            this.name = o.name;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * When the notification destination was last updated.
         * <p>
         * API name: {@code last_update_time}
         * </p>
         */
        @Nonnull
        public final Builder lastUpdateTime(@Nullable Integer value) {
            this.lastUpdateTime = value;
            return this;
        }

        /**
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>metadata</code>.
         * </p>
         */
        @Nonnull
        public final Builder metadata(Map<String, Map<String, JsonData>> map) {
            this.metadata = _mapPutAll(this.metadata, map);
            return this;
        }

        /**
         *
         * <p>
         * Adds an entry to <code>metadata</code>.
         * </p>
         */
        @Nonnull
        public final Builder metadata(String key, Map<String, JsonData> value) {
            this.metadata = _mapPut(this.metadata, key, value);
            return this;
        }

        /**
         * The name of the notification destination.
         * <p>
         * API name: {@code name}
         * </p>
         */
        @Nonnull
        public final Builder name(@Nullable String value) {
            this.name = value;
            return this;
        }

        /**
         * Builds a {@link ErrorNotificationDestination}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ErrorNotificationDestination build() {
            _checkSingleUse();

            return new ErrorNotificationDestination(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ErrorNotificationDestination}
     */
    public static final JsonpDeserializer<ErrorNotificationDestination> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ErrorNotificationDestination::setupErrorNotificationDestinationDeserializer
    );

    protected static void setupErrorNotificationDestinationDeserializer(ObjectDeserializer<ErrorNotificationDestination.Builder> op) {
        op.add(Builder::lastUpdateTime, JsonpDeserializer.integerDeserializer(), "last_update_time");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
        op.setUnknownFieldHandler((builder, name, parser, mapper) -> {
            if (builder.metadata == null) {
                builder.metadata = new HashMap<>();
            }
            builder.metadata.put(name, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER).deserialize(parser, mapper));
        });
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.lastUpdateTime);
        result = 31 * result + Objects.hashCode(this.metadata);
        result = 31 * result + Objects.hashCode(this.name);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ErrorNotificationDestination other = (ErrorNotificationDestination) o;
        return Objects.equals(this.lastUpdateTime, other.lastUpdateTime)
            && Objects.equals(this.metadata, other.metadata)
            && Objects.equals(this.name, other.name);
    }
}
