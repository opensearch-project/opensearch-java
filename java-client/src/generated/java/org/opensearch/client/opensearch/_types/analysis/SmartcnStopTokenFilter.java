/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

//----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------

package org.opensearch.client.opensearch._types.analysis;

import jakarta.json.stream.JsonGenerator;
import java.util.function.Function;
import javax.annotation.Generated;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.ObjectBuilder;

// typedef: _types.analysis.SmartcnStopTokenFilter

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SmartcnStopTokenFilter extends TokenFilterBase implements TokenFilterDefinitionVariant {

    // ---------------------------------------------------------------------------------------------

    private SmartcnStopTokenFilter(Builder builder) {
        super(builder);
    }

    public static SmartcnStopTokenFilter of(Function<SmartcnStopTokenFilter.Builder, ObjectBuilder<SmartcnStopTokenFilter>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link TokenFilterDefinition} variant kind.
     */
    @Override
    public TokenFilterDefinition.Kind _tokenFilterDefinitionKind() {
        return TokenFilterDefinition.Kind.SmartcnStop;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.write("type", "smartcn_stop");
        super.serializeInternal(generator, mapper);
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link SmartcnStopTokenFilter}.
     */
    public static class Builder extends TokenFilterBase.AbstractBuilder<Builder> implements ObjectBuilder<SmartcnStopTokenFilter> {

        @Override
        protected Builder self() {
            return this;
        }

        /**
         * Builds a {@link SmartcnStopTokenFilter}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public SmartcnStopTokenFilter build() {
            _checkSingleUse();

            return new SmartcnStopTokenFilter(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SmartcnStopTokenFilter}
     */
    public static final JsonpDeserializer<SmartcnStopTokenFilter> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SmartcnStopTokenFilter::setupSmartcnStopTokenFilterDeserializer
    );

    protected static void setupSmartcnStopTokenFilterDeserializer(ObjectDeserializer<SmartcnStopTokenFilter.Builder> op) {
        setupTokenFilterBaseDeserializer(op);

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
