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

package org.opensearch.client.opensearch.indices.add_block;

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

// typedef: indices.add_block.IndicesBlockStatus

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IndicesBlockStatus implements PlainJsonSerializable, ToCopyableBuilder<IndicesBlockStatus.Builder, IndicesBlockStatus> {

    private final boolean blocked;

    @Nonnull
    private final String name;

    // ---------------------------------------------------------------------------------------------

    private IndicesBlockStatus(Builder builder) {
        this.blocked = ApiTypeHelper.requireNonNull(builder.blocked, this, "blocked");
        this.name = ApiTypeHelper.requireNonNull(builder.name, this, "name");
    }

    public static IndicesBlockStatus of(Function<IndicesBlockStatus.Builder, ObjectBuilder<IndicesBlockStatus>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code blocked}
     */
    public final boolean blocked() {
        return this.blocked;
    }

    /**
     * Required - API name: {@code name}
     */
    @Nonnull
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
        generator.writeKey("blocked");
        generator.write(this.blocked);

        generator.writeKey("name");
        generator.write(this.name);
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
     * Builder for {@link IndicesBlockStatus}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IndicesBlockStatus> {
        private Boolean blocked;
        private String name;

        public Builder() {}

        private Builder(IndicesBlockStatus o) {
            this.blocked = o.blocked;
            this.name = o.name;
        }

        private Builder(Builder o) {
            this.blocked = o.blocked;
            this.name = o.name;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code blocked}
         */
        @Nonnull
        public final Builder blocked(boolean value) {
            this.blocked = value;
            return this;
        }

        /**
         * Required - API name: {@code name}
         */
        @Nonnull
        public final Builder name(String value) {
            this.name = value;
            return this;
        }

        /**
         * Builds a {@link IndicesBlockStatus}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IndicesBlockStatus build() {
            _checkSingleUse();

            return new IndicesBlockStatus(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IndicesBlockStatus}
     */
    public static final JsonpDeserializer<IndicesBlockStatus> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IndicesBlockStatus::setupIndicesBlockStatusDeserializer
    );

    protected static void setupIndicesBlockStatusDeserializer(ObjectDeserializer<IndicesBlockStatus.Builder> op) {
        op.add(Builder::blocked, JsonpDeserializer.booleanDeserializer(), "blocked");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Boolean.hashCode(this.blocked);
        result = 31 * result + this.name.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IndicesBlockStatus other = (IndicesBlockStatus) o;
        return this.blocked == other.blocked && this.name.equals(other.name);
    }
}
