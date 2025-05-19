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

package org.opensearch.client.opensearch.nodes.stats;

import jakarta.json.stream.JsonGenerator;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: nodes.stats.ScriptStatsBase

@Generated("org.opensearch.client.codegen.CodeGenerator")
public abstract class ScriptStatsBase implements PlainJsonSerializable {

    private final long cacheEvictions;

    private final long compilationLimitTriggered;

    private final long compilations;

    // ---------------------------------------------------------------------------------------------

    protected ScriptStatsBase(AbstractBuilder<?> builder) {
        this.cacheEvictions = ApiTypeHelper.requireNonNull(builder.cacheEvictions, this, "cacheEvictions");
        this.compilationLimitTriggered = ApiTypeHelper.requireNonNull(builder.compilationLimitTriggered, this, "compilationLimitTriggered");
        this.compilations = ApiTypeHelper.requireNonNull(builder.compilations, this, "compilations");
    }

    /**
     * Required - Total number of times the script cache has evicted old data.
     * <p>
     * API name: {@code cache_evictions}
     * </p>
     */
    public final long cacheEvictions() {
        return this.cacheEvictions;
    }

    /**
     * Required - Total number of times the script compilation circuit breaker has limited inline script compilations.
     * <p>
     * API name: {@code compilation_limit_triggered}
     * </p>
     */
    public final long compilationLimitTriggered() {
        return this.compilationLimitTriggered;
    }

    /**
     * Required - Total number of inline script compilations performed by the node.
     * <p>
     * API name: {@code compilations}
     * </p>
     */
    public final long compilations() {
        return this.compilations;
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
        generator.writeKey("cache_evictions");
        generator.write(this.cacheEvictions);

        generator.writeKey("compilation_limit_triggered");
        generator.write(this.compilationLimitTriggered);

        generator.writeKey("compilations");
        generator.write(this.compilations);
    }

    // ---------------------------------------------------------------------------------------------

    public abstract static class AbstractBuilder<BuilderT extends AbstractBuilder<BuilderT>> extends ObjectBuilderBase {
        private Long cacheEvictions;
        private Long compilationLimitTriggered;
        private Long compilations;

        protected AbstractBuilder() {}

        protected AbstractBuilder(ScriptStatsBase o) {
            this.cacheEvictions = o.cacheEvictions;
            this.compilationLimitTriggered = o.compilationLimitTriggered;
            this.compilations = o.compilations;
        }

        protected AbstractBuilder(AbstractBuilder<BuilderT> o) {
            this.cacheEvictions = o.cacheEvictions;
            this.compilationLimitTriggered = o.compilationLimitTriggered;
            this.compilations = o.compilations;
        }

        @Nonnull
        protected abstract BuilderT self();

        /**
         * Required - Total number of times the script cache has evicted old data.
         * <p>
         * API name: {@code cache_evictions}
         * </p>
         */
        @Nonnull
        public final BuilderT cacheEvictions(long value) {
            this.cacheEvictions = value;
            return self();
        }

        /**
         * Required - Total number of times the script compilation circuit breaker has limited inline script compilations.
         * <p>
         * API name: {@code compilation_limit_triggered}
         * </p>
         */
        @Nonnull
        public final BuilderT compilationLimitTriggered(long value) {
            this.compilationLimitTriggered = value;
            return self();
        }

        /**
         * Required - Total number of inline script compilations performed by the node.
         * <p>
         * API name: {@code compilations}
         * </p>
         */
        @Nonnull
        public final BuilderT compilations(long value) {
            this.compilations = value;
            return self();
        }
    }

    // ---------------------------------------------------------------------------------------------

    protected static <BuilderT extends AbstractBuilder<BuilderT>> void setupScriptStatsBaseDeserializer(ObjectDeserializer<BuilderT> op) {
        op.add(AbstractBuilder::cacheEvictions, JsonpDeserializer.longDeserializer(), "cache_evictions");
        op.add(AbstractBuilder::compilationLimitTriggered, JsonpDeserializer.longDeserializer(), "compilation_limit_triggered");
        op.add(AbstractBuilder::compilations, JsonpDeserializer.longDeserializer(), "compilations");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Long.hashCode(this.cacheEvictions);
        result = 31 * result + Long.hashCode(this.compilationLimitTriggered);
        result = 31 * result + Long.hashCode(this.compilations);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ScriptStatsBase other = (ScriptStatsBase) o;
        return this.cacheEvictions == other.cacheEvictions
            && this.compilationLimitTriggered == other.compilationLimitTriggered
            && this.compilations == other.compilations;
    }
}
