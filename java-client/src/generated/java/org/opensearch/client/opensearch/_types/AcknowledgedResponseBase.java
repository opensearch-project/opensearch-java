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

package org.opensearch.client.opensearch._types;

import jakarta.json.stream.JsonGenerator;
import javax.annotation.Generated;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: _types.AcknowledgedResponseBase

@Generated("org.opensearch.client.codegen.CodeGenerator")
public abstract class AcknowledgedResponseBase implements PlainJsonSerializable {

    private final boolean acknowledged;

    // ---------------------------------------------------------------------------------------------

    protected AcknowledgedResponseBase(AbstractBuilder<?> builder) {
        this.acknowledged = ApiTypeHelper.requireNonNull(builder.acknowledged, this, "acknowledged");
    }

    /**
     * Required - For a successful response, this value is always true. On failure, an exception is returned instead.
     * <p>
     * API name: {@code acknowledged}
     * </p>
     */
    public final boolean acknowledged() {
        return this.acknowledged;
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
        generator.writeKey("acknowledged");
        generator.write(this.acknowledged);
    }

    // ---------------------------------------------------------------------------------------------

    protected abstract static class AbstractBuilder<BuilderT extends AbstractBuilder<BuilderT>> extends ObjectBuilderBase {
        private Boolean acknowledged;

        /**
         * Required - For a successful response, this value is always true. On failure, an exception is returned instead.
         * <p>
         * API name: {@code acknowledged}
         * </p>
         */
        public final BuilderT acknowledged(boolean value) {
            this.acknowledged = value;
            return self();
        }

        protected abstract BuilderT self();
    }

    // ---------------------------------------------------------------------------------------------

    protected static <BuilderT extends AbstractBuilder<BuilderT>> void setupAcknowledgedResponseBaseDeserializer(
        ObjectDeserializer<BuilderT> op
    ) {
        op.add(AbstractBuilder::acknowledged, JsonpDeserializer.booleanDeserializer(), "acknowledged");
    }

    public int hashCode() {
        int result = 17;
        result = 31 * result + Boolean.hashCode(this.acknowledged);
        return result;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (this.getClass() != o.getClass()) return false;
        AcknowledgedResponseBase other = (AcknowledgedResponseBase) o;
        return this.acknowledged() == other.acknowledged()

        ;
    }
}
