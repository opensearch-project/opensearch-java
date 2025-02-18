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

package org.opensearch.client.opensearch.search_pipeline;

import jakarta.json.stream.JsonGenerator;
import java.util.List;
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

// typedef: search_pipeline.RerankContext

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RerankContext implements PlainJsonSerializable, ToCopyableBuilder<RerankContext.Builder, RerankContext> {

    @Nonnull
    private final List<String> documentFields;

    // ---------------------------------------------------------------------------------------------

    private RerankContext(Builder builder) {
        this.documentFields = ApiTypeHelper.unmodifiableRequired(builder.documentFields, this, "documentFields");
    }

    public static RerankContext of(Function<RerankContext.Builder, ObjectBuilder<RerankContext>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code document_fields}
     */
    @Nonnull
    public final List<String> documentFields() {
        return this.documentFields;
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
        generator.writeKey("document_fields");
        generator.writeStartArray();
        for (String item0 : this.documentFields) {
            generator.write(item0);
        }
        generator.writeEnd();
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
     * Builder for {@link RerankContext}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, RerankContext> {
        private List<String> documentFields;

        public Builder() {}

        private Builder(RerankContext o) {
            this.documentFields = _listCopy(o.documentFields);
        }

        private Builder(Builder o) {
            this.documentFields = _listCopy(o.documentFields);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code document_fields}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>documentFields</code>.
         * </p>
         */
        @Nonnull
        public final Builder documentFields(List<String> list) {
            this.documentFields = _listAddAll(this.documentFields, list);
            return this;
        }

        /**
         * Required - API name: {@code document_fields}
         *
         * <p>
         * Adds one or more values to <code>documentFields</code>.
         * </p>
         */
        @Nonnull
        public final Builder documentFields(String value, String... values) {
            this.documentFields = _listAdd(this.documentFields, value, values);
            return this;
        }

        /**
         * Builds a {@link RerankContext}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RerankContext build() {
            _checkSingleUse();

            return new RerankContext(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RerankContext}
     */
    public static final JsonpDeserializer<RerankContext> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RerankContext::setupRerankContextDeserializer
    );

    protected static void setupRerankContextDeserializer(ObjectDeserializer<RerankContext.Builder> op) {
        op.add(Builder::documentFields, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "document_fields");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.documentFields.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RerankContext other = (RerankContext) o;
        return this.documentFields.equals(other.documentFields);
    }
}
