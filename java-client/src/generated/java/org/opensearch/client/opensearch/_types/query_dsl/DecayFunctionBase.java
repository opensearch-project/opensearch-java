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

package org.opensearch.client.opensearch._types.query_dsl;

import jakarta.json.stream.JsonGenerator;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: _types.query_dsl.DecayFunctionBase

@Generated("org.opensearch.client.codegen.CodeGenerator")
public abstract class DecayFunctionBase implements PlainJsonSerializable {

    @Nullable
    private final MultiValueMode multiValueMode;

    // ---------------------------------------------------------------------------------------------

    protected DecayFunctionBase(AbstractBuilder<?> builder) {
        this.multiValueMode = builder.multiValueMode;
    }

    /**
     * API name: {@code multi_value_mode}
     */
    @Nullable
    public final MultiValueMode multiValueMode() {
        return this.multiValueMode;
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
        if (this.multiValueMode != null) {
            generator.writeKey("multi_value_mode");
            this.multiValueMode.serialize(generator, mapper);
        }
    }

    // ---------------------------------------------------------------------------------------------

    protected abstract static class AbstractBuilder<BuilderT extends AbstractBuilder<BuilderT>> extends ObjectBuilderBase {
        @Nullable
        private MultiValueMode multiValueMode;

        protected AbstractBuilder() {}

        protected AbstractBuilder(DecayFunctionBase o) {
            this.multiValueMode = o.multiValueMode;
        }

        protected AbstractBuilder(AbstractBuilder<BuilderT> o) {
            this.multiValueMode = o.multiValueMode;
        }

        @Nonnull
        protected abstract BuilderT self();

        /**
         * API name: {@code multi_value_mode}
         */
        @Nonnull
        public final BuilderT multiValueMode(@Nullable MultiValueMode value) {
            this.multiValueMode = value;
            return self();
        }
    }

    // ---------------------------------------------------------------------------------------------

    protected static <BuilderT extends AbstractBuilder<BuilderT>> void setupDecayFunctionBaseDeserializer(ObjectDeserializer<BuilderT> op) {
        op.add(AbstractBuilder::multiValueMode, MultiValueMode._DESERIALIZER, "multi_value_mode");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.multiValueMode);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        DecayFunctionBase other = (DecayFunctionBase) o;
        return Objects.equals(this.multiValueMode, other.multiValueMode);
    }
}
