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
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: nodes.stats.ScriptContextStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ScriptContextStats extends ScriptStatsBase implements ToCopyableBuilder<ScriptContextStats.Builder, ScriptContextStats> {

    @Nonnull
    private final String context;

    // ---------------------------------------------------------------------------------------------

    private ScriptContextStats(Builder builder) {
        super(builder);
        this.context = ApiTypeHelper.requireNonNull(builder.context, this, "context");
    }

    public static ScriptContextStats of(Function<ScriptContextStats.Builder, ObjectBuilder<ScriptContextStats>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code context}
     */
    @Nonnull
    public final String context() {
        return this.context;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        generator.writeKey("context");
        generator.write(this.context);
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
     * Builder for {@link ScriptContextStats}.
     */
    public static class Builder extends ScriptStatsBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, ScriptContextStats> {
        private String context;

        public Builder() {}

        private Builder(ScriptContextStats o) {
            super(o);
            this.context = o.context;
        }

        private Builder(Builder o) {
            super(o);
            this.context = o.context;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        @Override
        @Nonnull
        protected Builder self() {
            return this;
        }

        /**
         * Required - API name: {@code context}
         */
        @Nonnull
        public final Builder context(String value) {
            this.context = value;
            return this;
        }

        /**
         * Builds a {@link ScriptContextStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ScriptContextStats build() {
            _checkSingleUse();

            return new ScriptContextStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ScriptContextStats}
     */
    public static final JsonpDeserializer<ScriptContextStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ScriptContextStats::setupScriptContextStatsDeserializer
    );

    protected static void setupScriptContextStatsDeserializer(ObjectDeserializer<ScriptContextStats.Builder> op) {
        setupScriptStatsBaseDeserializer(op);
        op.add(Builder::context, JsonpDeserializer.stringDeserializer(), "context");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + this.context.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ScriptContextStats other = (ScriptContextStats) o;
        return this.context.equals(other.context);
    }
}
