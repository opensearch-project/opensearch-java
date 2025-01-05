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

package org.opensearch.client.opensearch.ingest;

import jakarta.json.stream.JsonGenerator;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: ingest.ProcessorBase

@Generated("org.opensearch.client.codegen.CodeGenerator")
public abstract class ProcessorBase implements PlainJsonSerializable {

    @Nullable
    private final String description;

    @Nullable
    private final String if_;

    @Nullable
    private final Boolean ignoreFailure;

    @Nonnull
    private final List<Processor> onFailure;

    @Nullable
    private final String tag;

    // ---------------------------------------------------------------------------------------------

    protected ProcessorBase(AbstractBuilder<?> builder) {
        this.description = builder.description;
        this.if_ = builder.if_;
        this.ignoreFailure = builder.ignoreFailure;
        this.onFailure = ApiTypeHelper.unmodifiable(builder.onFailure);
        this.tag = builder.tag;
    }

    /**
     * Description of the processor. Useful for describing the purpose of the processor or its configuration.
     * <p>
     * API name: {@code description}
     * </p>
     */
    @Nullable
    public final String description() {
        return this.description;
    }

    /**
     * Conditionally execute the processor.
     * <p>
     * API name: {@code if}
     * </p>
     */
    @Nullable
    public final String if_() {
        return this.if_;
    }

    /**
     * Ignore failures for the processor.
     * <p>
     * API name: {@code ignore_failure}
     * </p>
     */
    @Nullable
    public final Boolean ignoreFailure() {
        return this.ignoreFailure;
    }

    /**
     * Handle failures for the processor.
     * <p>
     * API name: {@code on_failure}
     * </p>
     */
    @Nonnull
    public final List<Processor> onFailure() {
        return this.onFailure;
    }

    /**
     * Identifier for the processor. Useful for debugging and metrics.
     * <p>
     * API name: {@code tag}
     * </p>
     */
    @Nullable
    public final String tag() {
        return this.tag;
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
        if (this.description != null) {
            generator.writeKey("description");
            generator.write(this.description);
        }

        if (this.if_ != null) {
            generator.writeKey("if");
            generator.write(this.if_);
        }

        if (this.ignoreFailure != null) {
            generator.writeKey("ignore_failure");
            generator.write(this.ignoreFailure);
        }

        if (ApiTypeHelper.isDefined(this.onFailure)) {
            generator.writeKey("on_failure");
            generator.writeStartArray();
            for (Processor item0 : this.onFailure) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.tag != null) {
            generator.writeKey("tag");
            generator.write(this.tag);
        }
    }

    // ---------------------------------------------------------------------------------------------

    protected abstract static class AbstractBuilder<BuilderT extends AbstractBuilder<BuilderT>> extends ObjectBuilderBase {
        @Nullable
        private String description;
        @Nullable
        private String if_;
        @Nullable
        private Boolean ignoreFailure;
        @Nullable
        private List<Processor> onFailure;
        @Nullable
        private String tag;

        protected AbstractBuilder() {}

        protected AbstractBuilder(ProcessorBase o) {
            this.description = o.description;
            this.if_ = o.if_;
            this.ignoreFailure = o.ignoreFailure;
            this.onFailure = _listCopy(o.onFailure);
            this.tag = o.tag;
        }

        protected AbstractBuilder(AbstractBuilder<BuilderT> o) {
            this.description = o.description;
            this.if_ = o.if_;
            this.ignoreFailure = o.ignoreFailure;
            this.onFailure = _listCopy(o.onFailure);
            this.tag = o.tag;
        }

        @Nonnull
        protected abstract BuilderT self();

        /**
         * Description of the processor. Useful for describing the purpose of the processor or its configuration.
         * <p>
         * API name: {@code description}
         * </p>
         */
        @Nonnull
        public final BuilderT description(@Nullable String value) {
            this.description = value;
            return self();
        }

        /**
         * Conditionally execute the processor.
         * <p>
         * API name: {@code if}
         * </p>
         */
        @Nonnull
        public final BuilderT if_(@Nullable String value) {
            this.if_ = value;
            return self();
        }

        /**
         * Ignore failures for the processor.
         * <p>
         * API name: {@code ignore_failure}
         * </p>
         */
        @Nonnull
        public final BuilderT ignoreFailure(@Nullable Boolean value) {
            this.ignoreFailure = value;
            return self();
        }

        /**
         * Handle failures for the processor.
         * <p>
         * API name: {@code on_failure}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>onFailure</code>.
         * </p>
         */
        @Nonnull
        public final BuilderT onFailure(List<Processor> list) {
            this.onFailure = _listAddAll(this.onFailure, list);
            return self();
        }

        /**
         * Handle failures for the processor.
         * <p>
         * API name: {@code on_failure}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>onFailure</code>.
         * </p>
         */
        @Nonnull
        public final BuilderT onFailure(Processor value, Processor... values) {
            this.onFailure = _listAdd(this.onFailure, value, values);
            return self();
        }

        /**
         * Handle failures for the processor.
         * <p>
         * API name: {@code on_failure}
         * </p>
         *
         * <p>
         * Adds a value to <code>onFailure</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final BuilderT onFailure(Function<Processor.Builder, ObjectBuilder<Processor>> fn) {
            return onFailure(fn.apply(new Processor.Builder()).build());
        }

        /**
         * Identifier for the processor. Useful for debugging and metrics.
         * <p>
         * API name: {@code tag}
         * </p>
         */
        @Nonnull
        public final BuilderT tag(@Nullable String value) {
            this.tag = value;
            return self();
        }
    }

    // ---------------------------------------------------------------------------------------------

    protected static <BuilderT extends AbstractBuilder<BuilderT>> void setupProcessorBaseDeserializer(ObjectDeserializer<BuilderT> op) {
        op.add(AbstractBuilder::description, JsonpDeserializer.stringDeserializer(), "description");
        op.add(AbstractBuilder::if_, JsonpDeserializer.stringDeserializer(), "if");
        op.add(AbstractBuilder::ignoreFailure, JsonpDeserializer.booleanDeserializer(), "ignore_failure");
        op.add(AbstractBuilder::onFailure, JsonpDeserializer.arrayDeserializer(Processor._DESERIALIZER), "on_failure");
        op.add(AbstractBuilder::tag, JsonpDeserializer.stringDeserializer(), "tag");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.description);
        result = 31 * result + Objects.hashCode(this.if_);
        result = 31 * result + Objects.hashCode(this.ignoreFailure);
        result = 31 * result + Objects.hashCode(this.onFailure);
        result = 31 * result + Objects.hashCode(this.tag);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ProcessorBase other = (ProcessorBase) o;
        return Objects.equals(this.description, other.description)
            && Objects.equals(this.if_, other.if_)
            && Objects.equals(this.ignoreFailure, other.ignoreFailure)
            && Objects.equals(this.onFailure, other.onFailure)
            && Objects.equals(this.tag, other.tag);
    }
}
