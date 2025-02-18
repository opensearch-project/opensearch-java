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
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectDeserializer;

// typedef: _types.mapping.DocValuesPropertyBase

@Generated("org.opensearch.client.codegen.CodeGenerator")
public abstract class DocValuesPropertyBase extends CorePropertyBase {

    @Nullable
    private final Boolean docValues;

    // ---------------------------------------------------------------------------------------------

    protected DocValuesPropertyBase(AbstractBuilder<?> builder) {
        super(builder);
        this.docValues = builder.docValues;
    }

    /**
     * API name: {@code doc_values}
     */
    @Nullable
    public final Boolean docValues() {
        return this.docValues;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.docValues != null) {
            generator.writeKey("doc_values");
            generator.write(this.docValues);
        }
    }

    // ---------------------------------------------------------------------------------------------

    protected abstract static class AbstractBuilder<BuilderT extends AbstractBuilder<BuilderT>> extends CorePropertyBase.AbstractBuilder<
        BuilderT> {
        @Nullable
        private Boolean docValues;

        protected AbstractBuilder() {}

        protected AbstractBuilder(DocValuesPropertyBase o) {
            super(o);
            this.docValues = o.docValues;
        }

        protected AbstractBuilder(AbstractBuilder<BuilderT> o) {
            super(o);
            this.docValues = o.docValues;
        }

        /**
         * API name: {@code doc_values}
         */
        @Nonnull
        public final BuilderT docValues(@Nullable Boolean value) {
            this.docValues = value;
            return self();
        }

    }

    // ---------------------------------------------------------------------------------------------

    protected static <BuilderT extends AbstractBuilder<BuilderT>> void setupDocValuesPropertyBaseDeserializer(
        ObjectDeserializer<BuilderT> op
    ) {
        setupCorePropertyBaseDeserializer(op);
        op.add(AbstractBuilder::docValues, JsonpDeserializer.booleanDeserializer(), "doc_values");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.docValues);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        DocValuesPropertyBase other = (DocValuesPropertyBase) o;
        return Objects.equals(this.docValues, other.docValues);
    }
}
