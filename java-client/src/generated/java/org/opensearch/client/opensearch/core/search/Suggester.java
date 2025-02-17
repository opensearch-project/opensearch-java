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

package org.opensearch.client.opensearch.core.search;

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

// typedef: core.search.Suggester

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Suggester implements PlainJsonSerializable, ToCopyableBuilder<Suggester.Builder, Suggester> {

    @Nullable
    private final String text;

    // ---------------------------------------------------------------------------------------------

    private Suggester(Builder builder) {
        this.text = builder.text;
    }

    public static Suggester of(Function<Suggester.Builder, ObjectBuilder<Suggester>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The global suggest text, which avoids repetition when the same text is used in several suggesters.
     * <p>
     * API name: {@code text}
     * </p>
     */
    @Nullable
    public final String text() {
        return this.text;
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
        if (this.text != null) {
            generator.writeKey("text");
            generator.write(this.text);
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
     * Builder for {@link Suggester}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, Suggester> {
        @Nullable
        private String text;

        public Builder() {}

        private Builder(Suggester o) {
            this.text = o.text;
        }

        private Builder(Builder o) {
            this.text = o.text;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The global suggest text, which avoids repetition when the same text is used in several suggesters.
         * <p>
         * API name: {@code text}
         * </p>
         */
        @Nonnull
        public final Builder text(@Nullable String value) {
            this.text = value;
            return this;
        }

        /**
         * Builds a {@link Suggester}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public Suggester build() {
            _checkSingleUse();

            return new Suggester(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link Suggester}
     */
    public static final JsonpDeserializer<Suggester> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        Suggester::setupSuggesterDeserializer
    );

    protected static void setupSuggesterDeserializer(ObjectDeserializer<Suggester.Builder> op) {
        op.add(Builder::text, JsonpDeserializer.stringDeserializer(), "text");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.text);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Suggester other = (Suggester) o;
        return Objects.equals(this.text, other.text);
    }
}
