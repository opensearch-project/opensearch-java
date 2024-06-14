/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch._types.analysis;

import jakarta.json.stream.JsonGenerator;
import java.util.function.Function;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.ObjectBuilder;

// typedef: _types.analysis.ReverseTokenFilter

@JsonpDeserializable
public class SmartcnStopTokenFilter extends TokenFilterBase implements TokenFilterDefinitionVariant {
    // ---------------------------------------------------------------------------------------------

    private SmartcnStopTokenFilter(Builder builder) {
        super(builder);

    }

    public static SmartcnStopTokenFilter of(Function<Builder, ObjectBuilder<SmartcnStopTokenFilter>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * TokenFilterDefinition variant kind.
     */
    @Override
    public TokenFilterDefinition.Kind _tokenFilterDefinitionKind() {
        return TokenFilterDefinition.Kind.SmartcnStop;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {

        generator.write("type", TokenFilterDefinition.Kind.SmartcnStop.jsonValue());
        super.serializeInternal(generator, mapper);

    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link SmartcnStopTokenFilter}.
     */

    public static class Builder extends AbstractBuilder<Builder> implements ObjectBuilder<SmartcnStopTokenFilter> {
        @Override
        protected Builder self() {
            return this;
        }

        /**
         * Builds a {@link SmartcnStopTokenFilter}.
         *
         * @throws NullPointerException
         *             if some required fields are null.
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

}
