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
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: _types.analysis.SmartcnAnalyzer

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SmartcnAnalyzer implements AnalyzerVariant, PlainJsonSerializable {

    // ---------------------------------------------------------------------------------------------

    private SmartcnAnalyzer(Builder builder) {}

    public static SmartcnAnalyzer of(Function<SmartcnAnalyzer.Builder, ObjectBuilder<SmartcnAnalyzer>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Analyzer} variant kind.
     */
    @Override
    public Analyzer.Kind _analyzerKind() {
        return Analyzer.Kind.Smartcn;
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
        generator.write("type", "smartcn");
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link SmartcnAnalyzer}.
     */
    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<SmartcnAnalyzer> {

        /**
         * Builds a {@link SmartcnAnalyzer}.
         *
         * @throws NullPointerException if some of the required fields are null.
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
        SmartcnAnalyzer::setupSmartcnAnalyzerDeserializer
    );

    protected static void setupSmartcnAnalyzerDeserializer(ObjectDeserializer<SmartcnAnalyzer.Builder> op) {

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = 17;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        return true;
    }
}
