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

// typedef: indices.open.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class OpenResponse implements PlainJsonSerializable, ToCopyableBuilder<OpenResponse.Builder, OpenResponse> {

    @Nullable
    private final Boolean acknowledged;

    @Nonnull
    private final Map<String, JsonData> metadata;

    @Nullable
    private final Boolean shardsAcknowledged;

    @Nullable
    private final String task;

    // ---------------------------------------------------------------------------------------------

    private OpenResponse(Builder builder) {
        this.acknowledged = builder.acknowledged;
        this.metadata = ApiTypeHelper.unmodifiable(builder.metadata);
        this.shardsAcknowledged = builder.shardsAcknowledged;
        this.task = builder.task;
    }

    public static OpenResponse of(Function<OpenResponse.Builder, ObjectBuilder<OpenResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code acknowledged}
     */
    @Nullable
    public final Boolean acknowledged() {
        return this.acknowledged;
    }

    @Nonnull
    public final Map<String, JsonData> metadata() {
        return this.metadata;
    }

    /**
     * API name: {@code shards_acknowledged}
     */
    @Nullable
    public final Boolean shardsAcknowledged() {
        return this.shardsAcknowledged;
    }

    /**
     * API name: {@code task}
     */
    @Nullable
    public final String task() {
        return this.task;
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
        for (Map.Entry<String, JsonData> item0 : this.metadata.entrySet()) {
            generator.writeKey(item0.getKey());
            item0.getValue().serialize(generator, mapper);
        }
        if (this.acknowledged != null) {
            generator.writeKey("acknowledged");
            generator.write(this.acknowledged);
        }

        if (this.shardsAcknowledged != null) {
            generator.writeKey("shards_acknowledged");
            generator.write(this.shardsAcknowledged);
        }

        if (this.task != null) {
            generator.writeKey("task");
            generator.write(this.task);
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
     * Builder for {@link OpenResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, OpenResponse> {
        @Nullable
        private Boolean acknowledged;
        @Nullable
        private Map<String, JsonData> metadata;
        @Nullable
        private Boolean shardsAcknowledged;
        @Nullable
        private String task;

        public Builder() {}

        private Builder(OpenResponse o) {
            this.acknowledged = o.acknowledged;
            this.metadata = _mapCopy(o.metadata);
            this.shardsAcknowledged = o.shardsAcknowledged;
            this.task = o.task;
        }

        private Builder(Builder o) {
            this.acknowledged = o.acknowledged;
            this.metadata = _mapCopy(o.metadata);
            this.shardsAcknowledged = o.shardsAcknowledged;
            this.task = o.task;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code acknowledged}
         */
        @Nonnull
        public final Builder acknowledged(@Nullable Boolean value) {
            this.acknowledged = value;
            return this;
        }

        /**
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>metadata</code>.
         * </p>
         */
        @Nonnull
        public final Builder metadata(Map<String, JsonData> map) {
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
        public final Builder metadata(String key, JsonData value) {
            this.metadata = _mapPut(this.metadata, key, value);
            return this;
        }

        /**
         * API name: {@code shards_acknowledged}
         */
        @Nonnull
        public final Builder shardsAcknowledged(@Nullable Boolean value) {
            this.shardsAcknowledged = value;
            return this;
        }

        /**
         * API name: {@code task}
         */
        @Nonnull
        public final Builder task(@Nullable String value) {
            this.task = value;
            return this;
        }

        /**
         * Builds a {@link OpenResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public OpenResponse build() {
            _checkSingleUse();

            return new OpenResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link OpenResponse}
     */
    public static final JsonpDeserializer<OpenResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        OpenResponse::setupOpenResponseDeserializer
    );

    protected static void setupOpenResponseDeserializer(ObjectDeserializer<OpenResponse.Builder> op) {
        op.add(Builder::acknowledged, JsonpDeserializer.booleanDeserializer(), "acknowledged");
        op.add(Builder::shardsAcknowledged, JsonpDeserializer.booleanDeserializer(), "shards_acknowledged");
        op.add(Builder::task, JsonpDeserializer.stringDeserializer(), "task");
        op.setUnknownFieldHandler((builder, name, parser, mapper) -> {
            if (builder.metadata == null) {
                builder.metadata = new HashMap<>();
            }
            builder.metadata.put(name, JsonData._DESERIALIZER.deserialize(parser, mapper));
        });
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.acknowledged);
        result = 31 * result + Objects.hashCode(this.metadata);
        result = 31 * result + Objects.hashCode(this.shardsAcknowledged);
        result = 31 * result + Objects.hashCode(this.task);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        OpenResponse other = (OpenResponse) o;
        return Objects.equals(this.acknowledged, other.acknowledged)
            && Objects.equals(this.metadata, other.metadata)
            && Objects.equals(this.shardsAcknowledged, other.shardsAcknowledged)
            && Objects.equals(this.task, other.task);
    }
}
