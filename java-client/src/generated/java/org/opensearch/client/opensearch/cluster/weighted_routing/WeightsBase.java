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

package org.opensearch.client.opensearch.cluster.weighted_routing;

import jakarta.json.stream.JsonGenerator;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: cluster.weighted_routing.WeightsBase

@Generated("org.opensearch.client.codegen.CodeGenerator")
public abstract class WeightsBase implements PlainJsonSerializable {

    @Nullable
    private final Long version;

    @Nonnull
    private final Map<String, String> weights;

    // ---------------------------------------------------------------------------------------------

    protected WeightsBase(AbstractBuilder<?> builder) {
        this.version = builder.version;
        this.weights = ApiTypeHelper.unmodifiable(builder.weights);
    }

    /**
     * API name: {@code _version}
     */
    @Nullable
    public final Long version() {
        return this.version;
    }

    /**
     * API name: {@code weights}
     */
    @Nonnull
    public final Map<String, String> weights() {
        return this.weights;
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
        if (this.version != null) {
            generator.writeKey("_version");
            generator.write(this.version);
        }

        if (ApiTypeHelper.isDefined(this.weights)) {
            generator.writeKey("weights");
            generator.writeStartObject();
            for (Map.Entry<String, String> item0 : this.weights.entrySet()) {
                generator.writeKey(item0.getKey());
                generator.write(item0.getValue());
            }
            generator.writeEnd();
        }
    }

    // ---------------------------------------------------------------------------------------------

    public abstract static class AbstractBuilder<BuilderT extends AbstractBuilder<BuilderT>> extends ObjectBuilderBase {
        @Nullable
        private Long version;
        @Nullable
        private Map<String, String> weights;

        protected AbstractBuilder() {}

        protected AbstractBuilder(WeightsBase o) {
            this.version = o.version;
            this.weights = _mapCopy(o.weights);
        }

        protected AbstractBuilder(AbstractBuilder<BuilderT> o) {
            this.version = o.version;
            this.weights = _mapCopy(o.weights);
        }

        @Nonnull
        protected abstract BuilderT self();

        /**
         * API name: {@code _version}
         */
        @Nonnull
        public final BuilderT version(@Nullable Long value) {
            this.version = value;
            return self();
        }

        /**
         * API name: {@code weights}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>weights</code>.
         * </p>
         */
        @Nonnull
        public final BuilderT weights(Map<String, String> map) {
            this.weights = _mapPutAll(this.weights, map);
            return self();
        }

        /**
         * API name: {@code weights}
         *
         * <p>
         * Adds an entry to <code>weights</code>.
         * </p>
         */
        @Nonnull
        public final BuilderT weights(String key, String value) {
            this.weights = _mapPut(this.weights, key, value);
            return self();
        }
    }

    // ---------------------------------------------------------------------------------------------

    protected static <BuilderT extends AbstractBuilder<BuilderT>> void setupWeightsBaseDeserializer(ObjectDeserializer<BuilderT> op) {
        op.add(AbstractBuilder::version, JsonpDeserializer.longDeserializer(), "_version");
        op.add(AbstractBuilder::weights, JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.stringDeserializer()), "weights");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.version);
        result = 31 * result + Objects.hashCode(this.weights);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        WeightsBase other = (WeightsBase) o;
        return Objects.equals(this.version, other.version) && Objects.equals(this.weights, other.weights);
    }
}
