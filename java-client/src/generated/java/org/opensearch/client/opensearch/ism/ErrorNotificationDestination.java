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
import org.opensearch.client.json.JsonEnum;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.JsonpSerializable;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.TaggedUnion;
import org.opensearch.client.util.TaggedUnionUtils;

// typedef: ism.ErrorNotificationDestination

/**
 * The notification destination. Requires exactly one of <code>chime</code>, <code>slack</code> or <code>custom_webhook</code>.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ErrorNotificationDestination
    implements
        TaggedUnion<ErrorNotificationDestination.Kind, ErrorNotificationDestinationVariant>,
        PlainJsonSerializable {
    /**
     * {@link ErrorNotificationDestination} variant kinds.
     */
    public enum Kind implements JsonEnum {
        Chime("chime"),
        CustomWebhook("custom_webhook"),
        Slack("slack");

        private final String jsonValue;

        Kind(String jsonValue) {
            this.jsonValue = jsonValue;
        }

        @Override
        public String jsonValue() {
            return jsonValue;
        }
    }

    private final Kind _kind;
    private final ErrorNotificationDestinationVariant _value;

    @Override
    public final Kind _kind() {
        return _kind;
    }

    @Override
    public final ErrorNotificationDestinationVariant _get() {
        return _value;
    }

    public ErrorNotificationDestination(ErrorNotificationDestinationVariant value) {
        this._kind = ApiTypeHelper.requireNonNull(value._errorNotificationDestinationKind(), this, "<variant kind>");
        this._value = ApiTypeHelper.requireNonNull(value, this, "<variant value>");
    }

    private ErrorNotificationDestination(Builder builder) {
        this._kind = ApiTypeHelper.requireNonNull(builder._kind, builder, "<variant kind>");
        this._value = ApiTypeHelper.requireNonNull(builder._value, builder, "<variant value>");
    }

    public static ErrorNotificationDestination of(
        Function<ErrorNotificationDestination.Builder, ObjectBuilder<ErrorNotificationDestination>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Is this variant instance of kind {@code chime}?
     */
    public boolean isChime() {
        return _kind == Kind.Chime;
    }

    /**
     * Get the {@code chime} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code chime} kind.
     */
    public ErrorNotificationChime chime() {
        return TaggedUnionUtils.get(this, Kind.Chime);
    }

    /**
     * Is this variant instance of kind {@code custom_webhook}?
     */
    public boolean isCustomWebhook() {
        return _kind == Kind.CustomWebhook;
    }

    /**
     * Get the {@code custom_webhook} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code custom_webhook} kind.
     */
    public ErrorNotificationCustomWebhook customWebhook() {
        return TaggedUnionUtils.get(this, Kind.CustomWebhook);
    }

    /**
     * Is this variant instance of kind {@code slack}?
     */
    public boolean isSlack() {
        return _kind == Kind.Slack;
    }

    /**
     * Get the {@code slack} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code slack} kind.
     */
    public ErrorNotificationSlack slack() {
        return TaggedUnionUtils.get(this, Kind.Slack);
    }

    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        generator.writeKey(_kind.jsonValue());
        if (_value instanceof JsonpSerializable) {
            ((JsonpSerializable) _value).serialize(generator, mapper);
        }
        generator.writeEnd();
    }

    @Nonnull
    public Builder toBuilder() {
        return new Builder(this);
    }

    @Nonnull
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<ErrorNotificationDestination> {
        private Kind _kind;
        private ErrorNotificationDestinationVariant _value;

        public Builder() {}

        private Builder(ErrorNotificationDestination o) {
            this._kind = o._kind;
            this._value = o._value;
        }

        public ObjectBuilder<ErrorNotificationDestination> chime(ErrorNotificationChime v) {
            this._kind = Kind.Chime;
            this._value = v;
            return this;
        }

        public ObjectBuilder<ErrorNotificationDestination> chime(
            Function<ErrorNotificationChime.Builder, ObjectBuilder<ErrorNotificationChime>> fn
        ) {
            return this.chime(fn.apply(new ErrorNotificationChime.Builder()).build());
        }

        public ObjectBuilder<ErrorNotificationDestination> customWebhook(ErrorNotificationCustomWebhook v) {
            this._kind = Kind.CustomWebhook;
            this._value = v;
            return this;
        }

        public ObjectBuilder<ErrorNotificationDestination> customWebhook(
            Function<ErrorNotificationCustomWebhook.Builder, ObjectBuilder<ErrorNotificationCustomWebhook>> fn
        ) {
            return this.customWebhook(fn.apply(new ErrorNotificationCustomWebhook.Builder()).build());
        }

        public ObjectBuilder<ErrorNotificationDestination> slack(ErrorNotificationSlack v) {
            this._kind = Kind.Slack;
            this._value = v;
            return this;
        }

        public ObjectBuilder<ErrorNotificationDestination> slack(
            Function<ErrorNotificationSlack.Builder, ObjectBuilder<ErrorNotificationSlack>> fn
        ) {
            return this.slack(fn.apply(new ErrorNotificationSlack.Builder()).build());
        }

        @Override
        public ErrorNotificationDestination build() {
            _checkSingleUse();
            return new ErrorNotificationDestination(this);
        }
    }

    protected static void setupErrorNotificationDestinationDeserializer(ObjectDeserializer<Builder> op) {
        op.add(Builder::chime, ErrorNotificationChime._DESERIALIZER, "chime");
        op.add(Builder::customWebhook, ErrorNotificationCustomWebhook._DESERIALIZER, "custom_webhook");
        op.add(Builder::slack, ErrorNotificationSlack._DESERIALIZER, "slack");
    }

    public static final JsonpDeserializer<ErrorNotificationDestination> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ErrorNotificationDestination::setupErrorNotificationDestinationDeserializer,
        Builder::build
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this._kind);
        result = 31 * result + Objects.hashCode(this._value);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ErrorNotificationDestination other = (ErrorNotificationDestination) o;
        return Objects.equals(this._kind, other._kind) && Objects.equals(this._value, other._value);
    }
}
