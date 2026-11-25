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

// typedef: ism.ErrorNotificationChime

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ErrorNotificationChime
    implements
        ErrorNotificationDestinationVariant,
        PlainJsonSerializable,
        ToCopyableBuilder<ErrorNotificationChime.Builder, ErrorNotificationChime> {

    @Nonnull
    private final String url;

    // ---------------------------------------------------------------------------------------------

    private ErrorNotificationChime(Builder builder) {
        this.url = ApiTypeHelper.requireNonNull(builder.url, this, "url");
    }

    public static ErrorNotificationChime of(Function<ErrorNotificationChime.Builder, ObjectBuilder<ErrorNotificationChime>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link ErrorNotificationDestination} variant kind.
     */
    @Override
    public ErrorNotificationDestination.Kind _errorNotificationDestinationKind() {
        return ErrorNotificationDestination.Kind.Chime;
    }

    /**
     * Required - The URL for the Chime webhook.
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
     * Builder for {@link ErrorNotificationChime}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ErrorNotificationChime> {
        private String url;

        public Builder() {}

        private Builder(ErrorNotificationChime o) {
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
         * Required - The URL for the Chime webhook.
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
         * Builds a {@link ErrorNotificationChime}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ErrorNotificationChime build() {
            _checkSingleUse();

            return new ErrorNotificationChime(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ErrorNotificationChime}
     */
    public static final JsonpDeserializer<ErrorNotificationChime> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ErrorNotificationChime::setupErrorNotificationChimeDeserializer
    );

    protected static void setupErrorNotificationChimeDeserializer(ObjectDeserializer<ErrorNotificationChime.Builder> op) {
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
        ErrorNotificationChime other = (ErrorNotificationChime) o;
        return this.url.equals(other.url);
    }
}
