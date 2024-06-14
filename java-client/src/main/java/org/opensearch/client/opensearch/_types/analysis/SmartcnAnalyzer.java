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
import org.opensearch.client.json.JsonpSerializable;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: _types.analysis.LanguageAnalyzer

@JsonpDeserializable
public class SmartcnAnalyzer implements AnalyzerVariant, JsonpSerializable {

    // ---------------------------------------------------------------------------------------------

    private SmartcnAnalyzer(Builder builder) {

    }

    public static SmartcnAnalyzer of(Function<Builder, ObjectBuilder<SmartcnAnalyzer>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Analyzer variant kind.
     */
    @Override
    public Analyzer.Kind _analyzerKind() {
        return Analyzer.Kind.Smartcn;
    }

    /**
     * Serialize this object to JSON.
     */
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {

        generator.write("type", Analyzer.Kind.Smartcn.jsonValue());

    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link SmartcnAnalyzer}.
     */

    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<SmartcnAnalyzer> {

        /**
         * Builds a {@link SmartcnAnalyzer}.
         *
         * @throws NullPointerException
         *             if some required fields are null.
         */
        public SmartcnAnalyzer build() {
            _checkSingleUse();

            return new SmartcnAnalyzer(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SmartcnAnalyzer}
     */
    public static final JsonpDeserializer<SmartcnAnalyzer> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SmartcnAnalyzer::setupLanguageAnalyzerDeserializer
    );

    protected static void setupLanguageAnalyzerDeserializer(ObjectDeserializer<SmartcnAnalyzer.Builder> op) {

        op.ignore("type");
    }

}
