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

// typedef: core.search.PhraseSuggestCollateQuery

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class PhraseSuggestCollateQuery
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<PhraseSuggestCollateQuery.Builder, PhraseSuggestCollateQuery> {

    @Nullable
    private final String id;

    @Nullable
    private final String source;

    // ---------------------------------------------------------------------------------------------

    private PhraseSuggestCollateQuery(Builder builder) {
        this.id = builder.id;
        this.source = builder.source;
    }

    public static PhraseSuggestCollateQuery of(Function<PhraseSuggestCollateQuery.Builder, ObjectBuilder<PhraseSuggestCollateQuery>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code id}
     */
    @Nullable
    public final String id() {
        return this.id;
    }

    /**
     * API name: {@code source}
     */
    @Nullable
    public final String source() {
        return this.source;
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

        if (this.source != null) {
            generator.writeKey("source");
            generator.write(this.source);
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
     * Builder for {@link PhraseSuggestCollateQuery}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, PhraseSuggestCollateQuery> {
        @Nullable
        private String id;
        @Nullable
        private String source;

        public Builder() {}

        private Builder(PhraseSuggestCollateQuery o) {
            this.id = o.id;
            this.source = o.source;
        }

        private Builder(Builder o) {
            this.id = o.id;
            this.source = o.source;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code id}
         */
        @Nonnull
        public final Builder id(@Nullable String value) {
            this.id = value;
            return this;
        }

        /**
         * API name: {@code source}
         */
        @Nonnull
        public final Builder source(@Nullable String value) {
            this.source = value;
            return this;
        }

        /**
         * Builds a {@link PhraseSuggestCollateQuery}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PhraseSuggestCollateQuery build() {
            _checkSingleUse();

            return new PhraseSuggestCollateQuery(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PhraseSuggestCollateQuery}
     */
    public static final JsonpDeserializer<PhraseSuggestCollateQuery> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PhraseSuggestCollateQuery::setupPhraseSuggestCollateQueryDeserializer
    );

    protected static void setupPhraseSuggestCollateQueryDeserializer(ObjectDeserializer<PhraseSuggestCollateQuery.Builder> op) {
        op.add(Builder::id, JsonpDeserializer.stringDeserializer(), "id");
        op.add(Builder::source, JsonpDeserializer.stringDeserializer(), "source");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.id);
        result = 31 * result + Objects.hashCode(this.source);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PhraseSuggestCollateQuery other = (PhraseSuggestCollateQuery) o;
        return Objects.equals(this.id, other.id) && Objects.equals(this.source, other.source);
    }
}
