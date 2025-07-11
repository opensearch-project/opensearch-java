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

package org.opensearch.client.opensearch.core.search;

import jakarta.json.stream.JsonGenerator;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: core.search.SuggestBase

@Generated("org.opensearch.client.codegen.CodeGenerator")
public abstract class SuggestBase implements PlainJsonSerializable {

    private final int length;

    private final int offset;

    @Nonnull
    private final String text;

    // ---------------------------------------------------------------------------------------------

    protected SuggestBase(AbstractBuilder<?> builder) {
        this.length = ApiTypeHelper.requireNonNull(builder.length, this, "length");
        this.offset = ApiTypeHelper.requireNonNull(builder.offset, this, "offset");
        this.text = ApiTypeHelper.requireNonNull(builder.text, this, "text");
    }

    /**
     * Required - API name: {@code length}
     */
    public final int length() {
        return this.length;
    }

    /**
     * Required - API name: {@code offset}
     */
    public final int offset() {
        return this.offset;
    }

    /**
     * Required - API name: {@code text}
     */
    @Nonnull
    public final String text() {
        return this.text;
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
        generator.writeKey("length");
        generator.write(this.length);

        generator.writeKey("offset");
        generator.write(this.offset);

        generator.writeKey("text");
        generator.write(this.text);
    }

    // ---------------------------------------------------------------------------------------------

    public abstract static class AbstractBuilder<BuilderT extends AbstractBuilder<BuilderT>> extends ObjectBuilderBase {
        private Integer length;
        private Integer offset;
        private String text;

        protected AbstractBuilder() {}

        protected AbstractBuilder(SuggestBase o) {
            this.length = o.length;
            this.offset = o.offset;
            this.text = o.text;
        }

        protected AbstractBuilder(AbstractBuilder<BuilderT> o) {
            this.length = o.length;
            this.offset = o.offset;
            this.text = o.text;
        }

        @Nonnull
        protected abstract BuilderT self();

        /**
         * Required - API name: {@code length}
         */
        @Nonnull
        public final BuilderT length(int value) {
            this.length = value;
            return self();
        }

        /**
         * Required - API name: {@code offset}
         */
        @Nonnull
        public final BuilderT offset(int value) {
            this.offset = value;
            return self();
        }

        /**
         * Required - API name: {@code text}
         */
        @Nonnull
        public final BuilderT text(String value) {
            this.text = value;
            return self();
        }
    }

    // ---------------------------------------------------------------------------------------------

    protected static <BuilderT extends AbstractBuilder<BuilderT>> void setupSuggestBaseDeserializer(ObjectDeserializer<BuilderT> op) {
        op.add(AbstractBuilder::length, JsonpDeserializer.integerDeserializer(), "length");
        op.add(AbstractBuilder::offset, JsonpDeserializer.integerDeserializer(), "offset");
        op.add(AbstractBuilder::text, JsonpDeserializer.stringDeserializer(), "text");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Integer.hashCode(this.length);
        result = 31 * result + Integer.hashCode(this.offset);
        result = 31 * result + this.text.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SuggestBase other = (SuggestBase) o;
        return this.length == other.length && this.offset == other.offset && this.text.equals(other.text);
    }
}
