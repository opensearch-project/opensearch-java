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

package org.opensearch.client.opensearch._types.mapping;

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

// typedef: _types.mapping.SizeField

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SizeField implements PlainJsonSerializable, ToCopyableBuilder<SizeField.Builder, SizeField> {

    private final boolean enabled;

    // ---------------------------------------------------------------------------------------------

    private SizeField(Builder builder) {
        this.enabled = ApiTypeHelper.requireNonNull(builder.enabled, this, "enabled");
    }

    public static SizeField of(Function<SizeField.Builder, ObjectBuilder<SizeField>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code enabled}
     */
    public final boolean enabled() {
        return this.enabled;
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
        generator.writeKey("enabled");
        generator.write(this.enabled);
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
     * Builder for {@link SizeField}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, SizeField> {
        private Boolean enabled;

        public Builder() {}

        private Builder(SizeField o) {
            this.enabled = o.enabled;
        }

        private Builder(Builder o) {
            this.enabled = o.enabled;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code enabled}
         */
        @Nonnull
        public final Builder enabled(boolean value) {
            this.enabled = value;
            return this;
        }

        /**
         * Builds a {@link SizeField}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SizeField build() {
            _checkSingleUse();

            return new SizeField(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SizeField}
     */
    public static final JsonpDeserializer<SizeField> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SizeField::setupSizeFieldDeserializer
    );

    protected static void setupSizeFieldDeserializer(ObjectDeserializer<SizeField.Builder> op) {
        op.add(Builder::enabled, JsonpDeserializer.booleanDeserializer(), "enabled");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Boolean.hashCode(this.enabled);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SizeField other = (SizeField) o;
        return this.enabled == other.enabled;
    }
}
