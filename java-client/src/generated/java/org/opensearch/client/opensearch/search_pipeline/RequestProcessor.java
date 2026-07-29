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

package org.opensearch.client.opensearch.search_pipeline;

import jakarta.json.stream.JsonGenerator;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.json.JsonData;
import org.opensearch.client.json.JsonEnum;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.JsonpSerializable;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.TaggedUnion;
import org.opensearch.client.util.TaggedUnionUtils;

// typedef: search_pipeline.RequestProcessor

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RequestProcessor implements TaggedUnion<RequestProcessor.Kind, RequestProcessorVariant>, PlainJsonSerializable {
    /**
     * {@link RequestProcessor} variant kinds.
     */
    public enum Kind implements JsonEnum {
        AgenticQueryTranslator("agentic_query_translator"),
        FilterQuery("filter_query"),
        NeuralQueryEnricher("neural_query_enricher"),
        Oversample("oversample"),
        Script("script"),
        /** A custom variant type not natively supported by this client. */
        _Custom(null);

        private final String jsonValue;

        Kind(String jsonValue) {
            this.jsonValue = jsonValue;
        }

        @Override
        public String jsonValue() {
            return jsonValue;
        }
    }

    private final Kind _kind;
    private final RequestProcessorVariant _value;
    private final String _customKind;

    @Override
    public final Kind _kind() {
        return _kind;
    }

    @Override
    public final RequestProcessorVariant _get() {
        return _value;
    }

    /**
     * Returns the actual type name when {@code _kind() == Kind._Custom}, otherwise {@code null}.
     */
    public final String _customKind() {
        return _customKind;
    }

    public RequestProcessor(RequestProcessorVariant value) {
        this._kind = ApiTypeHelper.requireNonNull(value._requestProcessorKind(), this, "<variant kind>");
        this._value = ApiTypeHelper.requireNonNull(value, this, "<variant value>");
        this._customKind = null;
    }

    private RequestProcessor(Builder builder) {
        this._kind = ApiTypeHelper.requireNonNull(builder._kind, builder, "<variant kind>");
        this._value = ApiTypeHelper.requireNonNull(builder._value, builder, "<variant value>");
        this._customKind = builder._customKind;
    }

    public static RequestProcessor of(Function<RequestProcessor.Builder, ObjectBuilder<RequestProcessor>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Is this variant instance of kind {@code agentic_query_translator}?
     */
    public boolean isAgenticQueryTranslator() {
        return _kind == Kind.AgenticQueryTranslator;
    }

    /**
     * Get the {@code agentic_query_translator} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code agentic_query_translator} kind.
     */
    public AgenticQueryTranslatorRequestProcessor agenticQueryTranslator() {
        return TaggedUnionUtils.get(this, Kind.AgenticQueryTranslator);
    }

    /**
     * Is this variant instance of kind {@code filter_query}?
     */
    public boolean isFilterQuery() {
        return _kind == Kind.FilterQuery;
    }

    /**
     * Get the {@code filter_query} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code filter_query} kind.
     */
    public FilterQueryRequestProcessor filterQuery() {
        return TaggedUnionUtils.get(this, Kind.FilterQuery);
    }

    /**
     * Is this variant instance of kind {@code neural_query_enricher}?
     */
    public boolean isNeuralQueryEnricher() {
        return _kind == Kind.NeuralQueryEnricher;
    }

    /**
     * Get the {@code neural_query_enricher} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code neural_query_enricher} kind.
     */
    public NeuralQueryEnricherRequestProcessor neuralQueryEnricher() {
        return TaggedUnionUtils.get(this, Kind.NeuralQueryEnricher);
    }

    /**
     * Is this variant instance of kind {@code oversample}?
     */
    public boolean isOversample() {
        return _kind == Kind.Oversample;
    }

    /**
     * Get the {@code oversample} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code oversample} kind.
     */
    public OversampleRequestProcessor oversample() {
        return TaggedUnionUtils.get(this, Kind.Oversample);
    }

    /**
     * Is this variant instance of kind {@code script}?
     */
    public boolean isScript() {
        return _kind == Kind.Script;
    }

    /**
     * Get the {@code script} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code script} kind.
     */
    public SearchScriptRequestProcessor script() {
        return TaggedUnionUtils.get(this, Kind.Script);
    }

    /**
     * Is this variant instance of kind {@code _custom}?
     */
    public boolean _isCustom() {
        return _kind == Kind._Custom;
    }

    /**
     * Get the raw JSON data for a custom (plugin-provided) variant type.
     *
     * @throws IllegalStateException if the current variant is not the {@code _custom} kind.
     */
    public JsonData _custom() {
        if (_kind != Kind._Custom) {
            throw new IllegalStateException("Expected variant kind '_custom' but got '" + _kind + "'");
        }
        return ((CustomVariant) _value).data();
    }

    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        generator.writeKey(_kind == Kind._Custom ? _customKind : _kind.jsonValue());
        if (_value instanceof JsonpSerializable) {
            ((JsonpSerializable) _value).serialize(generator, mapper);
        }
        generator.writeEnd();
    }

    @Nonnull
    public Builder toBuilder() {
        return new Builder(this);
    }

    @Nonnull
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<RequestProcessor> {
        private Kind _kind;
        private RequestProcessorVariant _value;
        private String _customKind;

        public Builder() {}

        private Builder(RequestProcessor o) {
            this._kind = o._kind;
            this._value = o._value;
            this._customKind = o._customKind;
        }

        public ObjectBuilder<RequestProcessor> agenticQueryTranslator(AgenticQueryTranslatorRequestProcessor v) {
            this._kind = Kind.AgenticQueryTranslator;
            this._value = v;
            return this;
        }

        public ObjectBuilder<RequestProcessor> agenticQueryTranslator(
            Function<AgenticQueryTranslatorRequestProcessor.Builder, ObjectBuilder<AgenticQueryTranslatorRequestProcessor>> fn
        ) {
            return this.agenticQueryTranslator(fn.apply(new AgenticQueryTranslatorRequestProcessor.Builder()).build());
        }

        public ObjectBuilder<RequestProcessor> filterQuery(FilterQueryRequestProcessor v) {
            this._kind = Kind.FilterQuery;
            this._value = v;
            return this;
        }

        public ObjectBuilder<RequestProcessor> filterQuery(
            Function<FilterQueryRequestProcessor.Builder, ObjectBuilder<FilterQueryRequestProcessor>> fn
        ) {
            return this.filterQuery(fn.apply(new FilterQueryRequestProcessor.Builder()).build());
        }

        public ObjectBuilder<RequestProcessor> neuralQueryEnricher(NeuralQueryEnricherRequestProcessor v) {
            this._kind = Kind.NeuralQueryEnricher;
            this._value = v;
            return this;
        }

        public ObjectBuilder<RequestProcessor> neuralQueryEnricher(
            Function<NeuralQueryEnricherRequestProcessor.Builder, ObjectBuilder<NeuralQueryEnricherRequestProcessor>> fn
        ) {
            return this.neuralQueryEnricher(fn.apply(new NeuralQueryEnricherRequestProcessor.Builder()).build());
        }

        public ObjectBuilder<RequestProcessor> oversample(OversampleRequestProcessor v) {
            this._kind = Kind.Oversample;
            this._value = v;
            return this;
        }

        public ObjectBuilder<RequestProcessor> oversample(
            Function<OversampleRequestProcessor.Builder, ObjectBuilder<OversampleRequestProcessor>> fn
        ) {
            return this.oversample(fn.apply(new OversampleRequestProcessor.Builder()).build());
        }

        public ObjectBuilder<RequestProcessor> script(SearchScriptRequestProcessor v) {
            this._kind = Kind.Script;
            this._value = v;
            return this;
        }

        public ObjectBuilder<RequestProcessor> script(
            Function<SearchScriptRequestProcessor.Builder, ObjectBuilder<SearchScriptRequestProcessor>> fn
        ) {
            return this.script(fn.apply(new SearchScriptRequestProcessor.Builder()).build());
        }

        /**
         * Set a custom (plugin-provided) variant.
         *
         * @param type the variant type name as returned by the server
         * @param data the raw JSON body of the variant result
         */
        public ObjectBuilder<RequestProcessor> _custom(String type, JsonData data) {
            this._kind = Kind._Custom;
            this._customKind = ApiTypeHelper.requireNonNull(type, this, "<custom variant type>");
            this._value = new CustomVariant(ApiTypeHelper.requireNonNull(data, this, "<custom variant data>"));
            return this;
        }

        @Override
        public RequestProcessor build() {
            _checkSingleUse();
            return new RequestProcessor(this);
        }
    }

    protected static void setupRequestProcessorDeserializer(ObjectDeserializer<Builder> op) {
        op.add(Builder::agenticQueryTranslator, AgenticQueryTranslatorRequestProcessor._DESERIALIZER, "agentic_query_translator");
        op.add(Builder::filterQuery, FilterQueryRequestProcessor._DESERIALIZER, "filter_query");
        op.add(Builder::neuralQueryEnricher, NeuralQueryEnricherRequestProcessor._DESERIALIZER, "neural_query_enricher");
        op.add(Builder::oversample, OversampleRequestProcessor._DESERIALIZER, "oversample");
        op.add(Builder::script, SearchScriptRequestProcessor._DESERIALIZER, "script");
        op.setUnknownFieldHandler(
            (builder, name, parser, mapper) -> builder._custom(name, JsonData._DESERIALIZER.deserialize(parser, mapper))
        );
    }

    public static final JsonpDeserializer<RequestProcessor> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RequestProcessor::setupRequestProcessorDeserializer,
        Builder::build
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this._kind);
        result = 31 * result + Objects.hashCode(this._value);
        result = 31 * result + Objects.hashCode(this._customKind);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RequestProcessor other = (RequestProcessor) o;
        return Objects.equals(this._kind, other._kind) && Objects.equals(this._value, other._value) && Objects.equals(this._customKind, other._customKind);
    }

    // Wrapper so JsonData fits the variant interface slot for custom/plugin types
    private static final class CustomVariant implements RequestProcessorVariant, PlainJsonSerializable {
        private final JsonData data;

        CustomVariant(JsonData data) {
            this.data = data;
        }

        public JsonData data() {
            return data;
        }

        @Override
        public Kind _requestProcessorKind() {
            return Kind._Custom;
        }

        @Override
        public void serialize(JsonGenerator generator, JsonpMapper mapper) {
            data.serialize(generator, mapper);
        }

        @Override
        public int hashCode() {
            return data.hashCode();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            return data.equals(((CustomVariant) o).data);
        }
    }
}
