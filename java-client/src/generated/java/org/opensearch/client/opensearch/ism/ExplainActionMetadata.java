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

// typedef: ism.ExplainActionMetadata

/**
 * The current action of the managed index.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ExplainActionMetadata
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ExplainActionMetadata.Builder, ExplainActionMetadata> {

    @Nonnull
    private final Map<String, JsonData> actionProperties;

    @Nullable
    private final Integer consumedRetries;

    @Nullable
    private final Boolean failed;

    @Nullable
    private final Integer index;

    @Nullable
    private final Long lastRetryTime;

    @Nullable
    private final String name;

    @Nullable
    private final Long startTime;

    // ---------------------------------------------------------------------------------------------

    private ExplainActionMetadata(Builder builder) {
        this.actionProperties = ApiTypeHelper.unmodifiable(builder.actionProperties);
        this.consumedRetries = builder.consumedRetries;
        this.failed = builder.failed;
        this.index = builder.index;
        this.lastRetryTime = builder.lastRetryTime;
        this.name = builder.name;
        this.startTime = builder.startTime;
    }

    public static ExplainActionMetadata of(Function<ExplainActionMetadata.Builder, ObjectBuilder<ExplainActionMetadata>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The properties of the action.
     * <p>
     * API name: {@code action_properties}
     * </p>
     */
    @Nonnull
    public final Map<String, JsonData> actionProperties() {
        return this.actionProperties;
    }

    /**
     * The number of retries the action has consumed.
     * <p>
     * API name: {@code consumed_retries}
     * </p>
     */
    @Nullable
    public final Integer consumedRetries() {
        return this.consumedRetries;
    }

    /**
     * Whether the action has failed.
     * <p>
     * API name: {@code failed}
     * </p>
     */
    @Nullable
    public final Boolean failed() {
        return this.failed;
    }

    /**
     * The position of the action in the state.
     * <p>
     * API name: {@code index}
     * </p>
     */
    @Nullable
    public final Integer index() {
        return this.index;
    }

    /**
     * API name: {@code last_retry_time}
     */
    @Nullable
    public final Long lastRetryTime() {
        return this.lastRetryTime;
    }

    /**
     * The name of the action.
     * <p>
     * API name: {@code name}
     * </p>
     */
    @Nullable
    public final String name() {
        return this.name;
    }

    /**
     * API name: {@code start_time}
     */
    @Nullable
    public final Long startTime() {
        return this.startTime;
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
        if (ApiTypeHelper.isDefined(this.actionProperties)) {
            generator.writeKey("action_properties");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.actionProperties.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.consumedRetries != null) {
            generator.writeKey("consumed_retries");
            generator.write(this.consumedRetries);
        }

        if (this.failed != null) {
            generator.writeKey("failed");
            generator.write(this.failed);
        }

        if (this.index != null) {
            generator.writeKey("index");
            generator.write(this.index);
        }

        if (this.lastRetryTime != null) {
            generator.writeKey("last_retry_time");
            generator.write(this.lastRetryTime);
        }

        if (this.name != null) {
            generator.writeKey("name");
            generator.write(this.name);
        }

        if (this.startTime != null) {
            generator.writeKey("start_time");
            generator.write(this.startTime);
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
     * Builder for {@link ExplainActionMetadata}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ExplainActionMetadata> {
        @Nullable
        private Map<String, JsonData> actionProperties;
        @Nullable
        private Integer consumedRetries;
        @Nullable
        private Boolean failed;
        @Nullable
        private Integer index;
        @Nullable
        private Long lastRetryTime;
        @Nullable
        private String name;
        @Nullable
        private Long startTime;

        public Builder() {}

        private Builder(ExplainActionMetadata o) {
            this.actionProperties = _mapCopy(o.actionProperties);
            this.consumedRetries = o.consumedRetries;
            this.failed = o.failed;
            this.index = o.index;
            this.lastRetryTime = o.lastRetryTime;
            this.name = o.name;
            this.startTime = o.startTime;
        }

        private Builder(Builder o) {
            this.actionProperties = _mapCopy(o.actionProperties);
            this.consumedRetries = o.consumedRetries;
            this.failed = o.failed;
            this.index = o.index;
            this.lastRetryTime = o.lastRetryTime;
            this.name = o.name;
            this.startTime = o.startTime;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The properties of the action.
         * <p>
         * API name: {@code action_properties}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>actionProperties</code>.
         * </p>
         */
        @Nonnull
        public final Builder actionProperties(Map<String, JsonData> map) {
            this.actionProperties = _mapPutAll(this.actionProperties, map);
            return this;
        }

        /**
         * The properties of the action.
         * <p>
         * API name: {@code action_properties}
         * </p>
         *
         * <p>
         * Adds an entry to <code>actionProperties</code>.
         * </p>
         */
        @Nonnull
        public final Builder actionProperties(String key, JsonData value) {
            this.actionProperties = _mapPut(this.actionProperties, key, value);
            return this;
        }

        /**
         * The number of retries the action has consumed.
         * <p>
         * API name: {@code consumed_retries}
         * </p>
         */
        @Nonnull
        public final Builder consumedRetries(@Nullable Integer value) {
            this.consumedRetries = value;
            return this;
        }

        /**
         * Whether the action has failed.
         * <p>
         * API name: {@code failed}
         * </p>
         */
        @Nonnull
        public final Builder failed(@Nullable Boolean value) {
            this.failed = value;
            return this;
        }

        /**
         * The position of the action in the state.
         * <p>
         * API name: {@code index}
         * </p>
         */
        @Nonnull
        public final Builder index(@Nullable Integer value) {
            this.index = value;
            return this;
        }

        /**
         * API name: {@code last_retry_time}
         */
        @Nonnull
        public final Builder lastRetryTime(@Nullable Long value) {
            this.lastRetryTime = value;
            return this;
        }

        /**
         * The name of the action.
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
         * API name: {@code start_time}
         */
        @Nonnull
        public final Builder startTime(@Nullable Long value) {
            this.startTime = value;
            return this;
        }

        /**
         * Builds a {@link ExplainActionMetadata}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ExplainActionMetadata build() {
            _checkSingleUse();

            return new ExplainActionMetadata(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ExplainActionMetadata}
     */
    public static final JsonpDeserializer<ExplainActionMetadata> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ExplainActionMetadata::setupExplainActionMetadataDeserializer
    );

    protected static void setupExplainActionMetadataDeserializer(ObjectDeserializer<ExplainActionMetadata.Builder> op) {
        op.add(Builder::actionProperties, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "action_properties");
        op.add(Builder::consumedRetries, JsonpDeserializer.integerDeserializer(), "consumed_retries");
        op.add(Builder::failed, JsonpDeserializer.booleanDeserializer(), "failed");
        op.add(Builder::index, JsonpDeserializer.integerDeserializer(), "index");
        op.add(Builder::lastRetryTime, JsonpDeserializer.longDeserializer(), "last_retry_time");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
        op.add(Builder::startTime, JsonpDeserializer.longDeserializer(), "start_time");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.actionProperties);
        result = 31 * result + Objects.hashCode(this.consumedRetries);
        result = 31 * result + Objects.hashCode(this.failed);
        result = 31 * result + Objects.hashCode(this.index);
        result = 31 * result + Objects.hashCode(this.lastRetryTime);
        result = 31 * result + Objects.hashCode(this.name);
        result = 31 * result + Objects.hashCode(this.startTime);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ExplainActionMetadata other = (ExplainActionMetadata) o;
        return Objects.equals(this.actionProperties, other.actionProperties)
            && Objects.equals(this.consumedRetries, other.consumedRetries)
            && Objects.equals(this.failed, other.failed)
            && Objects.equals(this.index, other.index)
            && Objects.equals(this.lastRetryTime, other.lastRetryTime)
            && Objects.equals(this.name, other.name)
            && Objects.equals(this.startTime, other.startTime);
    }
}
