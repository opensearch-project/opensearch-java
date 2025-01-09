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

package org.opensearch.client.opensearch.core;

import jakarta.json.stream.JsonGenerator;
import java.util.Map;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.json.JsonData;
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

// typedef: render_search_template.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RenderSearchTemplateResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<RenderSearchTemplateResponse.Builder, RenderSearchTemplateResponse> {

    @Nonnull
    private final Map<String, JsonData> templateOutput;

    // ---------------------------------------------------------------------------------------------

    private RenderSearchTemplateResponse(Builder builder) {
        this.templateOutput = ApiTypeHelper.unmodifiableRequired(builder.templateOutput, this, "templateOutput");
    }

    public static RenderSearchTemplateResponse of(
        Function<RenderSearchTemplateResponse.Builder, ObjectBuilder<RenderSearchTemplateResponse>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code template_output}
     */
    @Nonnull
    public final Map<String, JsonData> templateOutput() {
        return this.templateOutput;
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
        generator.writeKey("template_output");
        generator.writeStartObject();
        for (Map.Entry<String, JsonData> item0 : this.templateOutput.entrySet()) {
            generator.writeKey(item0.getKey());
            item0.getValue().serialize(generator, mapper);
        }
        generator.writeEnd();
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
     * Builder for {@link RenderSearchTemplateResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, RenderSearchTemplateResponse> {
        private Map<String, JsonData> templateOutput;

        public Builder() {}

        private Builder(RenderSearchTemplateResponse o) {
            this.templateOutput = _mapCopy(o.templateOutput);
        }

        private Builder(Builder o) {
            this.templateOutput = _mapCopy(o.templateOutput);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code template_output}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>templateOutput</code>.
         * </p>
         */
        @Nonnull
        public final Builder templateOutput(Map<String, JsonData> map) {
            this.templateOutput = _mapPutAll(this.templateOutput, map);
            return this;
        }

        /**
         * Required - API name: {@code template_output}
         *
         * <p>
         * Adds an entry to <code>templateOutput</code>.
         * </p>
         */
        @Nonnull
        public final Builder templateOutput(String key, JsonData value) {
            this.templateOutput = _mapPut(this.templateOutput, key, value);
            return this;
        }

        /**
         * Builds a {@link RenderSearchTemplateResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RenderSearchTemplateResponse build() {
            _checkSingleUse();

            return new RenderSearchTemplateResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RenderSearchTemplateResponse}
     */
    public static final JsonpDeserializer<RenderSearchTemplateResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RenderSearchTemplateResponse::setupRenderSearchTemplateResponseDeserializer
    );

    protected static void setupRenderSearchTemplateResponseDeserializer(ObjectDeserializer<RenderSearchTemplateResponse.Builder> op) {
        op.add(Builder::templateOutput, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "template_output");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.templateOutput.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RenderSearchTemplateResponse other = (RenderSearchTemplateResponse) o;
        return this.templateOutput.equals(other.templateOutput);
    }
}
