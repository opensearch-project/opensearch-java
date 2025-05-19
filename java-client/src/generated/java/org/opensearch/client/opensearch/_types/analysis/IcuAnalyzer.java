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

package org.opensearch.client.opensearch._types.analysis;

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

// typedef: _types.analysis.IcuAnalyzer

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IcuAnalyzer implements AnalyzerVariant, PlainJsonSerializable, ToCopyableBuilder<IcuAnalyzer.Builder, IcuAnalyzer> {

    @Nonnull
    private final IcuNormalizationType method;

    @Nonnull
    private final IcuNormalizationMode mode;

    // ---------------------------------------------------------------------------------------------

    private IcuAnalyzer(Builder builder) {
        this.method = ApiTypeHelper.requireNonNull(builder.method, this, "method");
        this.mode = ApiTypeHelper.requireNonNull(builder.mode, this, "mode");
    }

    public static IcuAnalyzer of(Function<IcuAnalyzer.Builder, ObjectBuilder<IcuAnalyzer>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Analyzer} variant kind.
     */
    @Override
    public Analyzer.Kind _analyzerKind() {
        return Analyzer.Kind.IcuAnalyzer;
    }

    /**
     * Required - API name: {@code method}
     */
    @Nonnull
    public final IcuNormalizationType method() {
        return this.method;
    }

    /**
     * Required - API name: {@code mode}
     */
    @Nonnull
    public final IcuNormalizationMode mode() {
        return this.mode;
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
        generator.write("type", "icu_analyzer");
        generator.writeKey("method");
        this.method.serialize(generator, mapper);

        generator.writeKey("mode");
        this.mode.serialize(generator, mapper);
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
     * Builder for {@link IcuAnalyzer}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IcuAnalyzer> {
        private IcuNormalizationType method;
        private IcuNormalizationMode mode;

        public Builder() {}

        private Builder(IcuAnalyzer o) {
            this.method = o.method;
            this.mode = o.mode;
        }

        private Builder(Builder o) {
            this.method = o.method;
            this.mode = o.mode;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code method}
         */
        @Nonnull
        public final Builder method(IcuNormalizationType value) {
            this.method = value;
            return this;
        }

        /**
         * Required - API name: {@code mode}
         */
        @Nonnull
        public final Builder mode(IcuNormalizationMode value) {
            this.mode = value;
            return this;
        }

        /**
         * Builds a {@link IcuAnalyzer}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IcuAnalyzer build() {
            _checkSingleUse();

            return new IcuAnalyzer(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IcuAnalyzer}
     */
    public static final JsonpDeserializer<IcuAnalyzer> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IcuAnalyzer::setupIcuAnalyzerDeserializer
    );

    protected static void setupIcuAnalyzerDeserializer(ObjectDeserializer<IcuAnalyzer.Builder> op) {
        op.add(Builder::method, IcuNormalizationType._DESERIALIZER, "method");
        op.add(Builder::mode, IcuNormalizationMode._DESERIALIZER, "mode");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.method.hashCode();
        result = 31 * result + this.mode.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IcuAnalyzer other = (IcuAnalyzer) o;
        return this.method.equals(other.method) && this.mode.equals(other.mode);
    }
}
