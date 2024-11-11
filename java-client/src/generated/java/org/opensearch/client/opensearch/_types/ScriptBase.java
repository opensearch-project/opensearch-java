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
import java.util.Map;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonData;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: _types.ScriptBase

@Generated("org.opensearch.client.codegen.CodeGenerator")
public abstract class ScriptBase implements PlainJsonSerializable {

    @Nonnull
    private final Map<String, JsonData> params;

    // ---------------------------------------------------------------------------------------------

    protected ScriptBase(AbstractBuilder<?> builder) {
        this.params = ApiTypeHelper.unmodifiable(builder.params);
    }

    /**
     * Specifies any named parameters that are passed into the script as variables. Use parameters instead of hard-coded values to decrease
     * compilation time.
     * <p>
     * API name: {@code params}
     * </p>
     */
    @Nonnull
    public final Map<String, JsonData> params() {
        return this.params;
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
        if (ApiTypeHelper.isDefined(this.params)) {
            generator.writeKey("params");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.params.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }
    }

    // ---------------------------------------------------------------------------------------------

    protected abstract static class AbstractBuilder<BuilderT extends AbstractBuilder<BuilderT>> extends ObjectBuilderBase {
        @Nullable
        private Map<String, JsonData> params;

        /**
         * Specifies any named parameters that are passed into the script as variables. Use parameters instead of hard-coded values to
         * decrease compilation time.
         * <p>
         * API name: {@code params}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>params</code>.
         * </p>
         */
        public final BuilderT params(Map<String, JsonData> map) {
            this.params = _mapPutAll(this.params, map);
            return self();
        }

        /**
         * Specifies any named parameters that are passed into the script as variables. Use parameters instead of hard-coded values to
         * decrease compilation time.
         * <p>
         * API name: {@code params}
         * </p>
         *
         * <p>
         * Adds an entry to <code>params</code>.
         * </p>
         */
        public final BuilderT params(String key, JsonData value) {
            this.params = _mapPut(this.params, key, value);
            return self();
        }

        protected abstract BuilderT self();
    }

    // ---------------------------------------------------------------------------------------------

    protected static <BuilderT extends AbstractBuilder<BuilderT>> void setupScriptBaseDeserializer(ObjectDeserializer<BuilderT> op) {
        op.add(AbstractBuilder::params, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "params");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.params);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ScriptBase other = (ScriptBase) o;
        return Objects.equals(this.params, other.params);
    }
}
