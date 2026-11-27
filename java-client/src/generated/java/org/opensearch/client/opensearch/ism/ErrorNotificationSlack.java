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
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
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

// typedef: ism.ErrorNotificationSlack

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ErrorNotificationSlack
    implements
        ErrorNotificationDestinationVariant,
        PlainJsonSerializable,
        ToCopyableBuilder<ErrorNotificationSlack.Builder, ErrorNotificationSlack> {

    @Nonnull
    private final String url;

    // ---------------------------------------------------------------------------------------------

    private ErrorNotificationSlack(Builder builder) {
        this.url = ApiTypeHelper.requireNonNull(builder.url, this, "url");
    }

    public static ErrorNotificationSlack of(Function<ErrorNotificationSlack.Builder, ObjectBuilder<ErrorNotificationSlack>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link ErrorNotificationDestination} variant kind.
     */
    @Override
    public ErrorNotificationDestination.Kind _errorNotificationDestinationKind() {
        return ErrorNotificationDestination.Kind.Slack;
    }

    /**
     * Required - The URL for the Slack webhook.
     * <p>
     * API name: {@code url}
     * </p>
     */
    @Nonnull
    public final String url() {
        return this.url;
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
        generator.writeKey("url");
        generator.write(this.url);
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
     * Builder for {@link ErrorNotificationSlack}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ErrorNotificationSlack> {
        private String url;

        public Builder() {}

        private Builder(ErrorNotificationSlack o) {
            this.url = o.url;
        }

        private Builder(Builder o) {
            this.url = o.url;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - The URL for the Slack webhook.
         * <p>
         * API name: {@code url}
         * </p>
         */
        @Nonnull
        public final Builder url(String value) {
            this.url = value;
            return this;
        }

        /**
         * Builds a {@link ErrorNotificationSlack}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ErrorNotificationSlack build() {
            _checkSingleUse();

            return new ErrorNotificationSlack(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ErrorNotificationSlack}
     */
    public static final JsonpDeserializer<ErrorNotificationSlack> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ErrorNotificationSlack::setupErrorNotificationSlackDeserializer
    );

    protected static void setupErrorNotificationSlackDeserializer(ObjectDeserializer<ErrorNotificationSlack.Builder> op) {
        op.add(Builder::url, JsonpDeserializer.stringDeserializer(), "url");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.url.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ErrorNotificationSlack other = (ErrorNotificationSlack) o;
        return this.url.equals(other.url);
    }
}
