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
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.analysis.PhoneAnalyzer

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class PhoneAnalyzer extends PhoneAnalyzerBase implements AnalyzerVariant, ToCopyableBuilder<PhoneAnalyzer.Builder, PhoneAnalyzer> {

    // ---------------------------------------------------------------------------------------------

    private PhoneAnalyzer(Builder builder) {
        super(builder);
    }

    public static PhoneAnalyzer of(Function<PhoneAnalyzer.Builder, ObjectBuilder<PhoneAnalyzer>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Analyzer} variant kind.
     */
    @Override
    public Analyzer.Kind _analyzerKind() {
        return Analyzer.Kind.Phone;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.write("type", "phone");
        super.serializeInternal(generator, mapper);
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
     * Builder for {@link PhoneAnalyzer}.
     */
    public static class Builder extends PhoneAnalyzerBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, PhoneAnalyzer> {

        public Builder() {}

        private Builder(PhoneAnalyzer o) {
            super(o);
        }

        private Builder(Builder o) {
            super(o);
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
         * Builds a {@link PhoneAnalyzer}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PhoneAnalyzer build() {
            _checkSingleUse();

            return new PhoneAnalyzer(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PhoneAnalyzer}
     */
    public static final JsonpDeserializer<PhoneAnalyzer> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PhoneAnalyzer::setupPhoneAnalyzerDeserializer
    );

    protected static void setupPhoneAnalyzerDeserializer(ObjectDeserializer<PhoneAnalyzer.Builder> op) {
        setupPhoneAnalyzerBaseDeserializer(op);

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        return true;
    }
}
