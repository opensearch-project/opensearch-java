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
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ingest.SetSecurityUserProcessor

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SetSecurityUserProcessor extends ProcessorBase
    implements
        ProcessorVariant,
        ToCopyableBuilder<SetSecurityUserProcessor.Builder, SetSecurityUserProcessor> {

    @Nonnull
    private final String field;

    @Nonnull
    private final List<String> properties;

    // ---------------------------------------------------------------------------------------------

    private SetSecurityUserProcessor(Builder builder) {
        super(builder);
        this.field = ApiTypeHelper.requireNonNull(builder.field, this, "field");
        this.properties = ApiTypeHelper.unmodifiable(builder.properties);
    }

    public static SetSecurityUserProcessor of(Function<SetSecurityUserProcessor.Builder, ObjectBuilder<SetSecurityUserProcessor>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Processor} variant kind.
     */
    @Override
    public Processor.Kind _processorKind() {
        return Processor.Kind.SetSecurityUser;
    }

    /**
     * Required - API name: {@code field}
     */
    @Nonnull
    public final String field() {
        return this.field;
    }

    /**
     * Controls what user related properties are added to the field.
     * <p>
     * API name: {@code properties}
     * </p>
     */
    @Nonnull
    public final List<String> properties() {
        return this.properties;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        generator.writeKey("field");
        generator.write(this.field);

        if (ApiTypeHelper.isDefined(this.properties)) {
            generator.writeKey("properties");
            generator.writeStartArray();
            for (String item0 : this.properties) {
                generator.write(item0);
            }
            generator.writeEnd();
        }
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
     * Builder for {@link SetSecurityUserProcessor}.
     */
    public static class Builder extends ProcessorBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, SetSecurityUserProcessor> {
        private String field;
        @Nullable
        private List<String> properties;

        public Builder() {}

        private Builder(SetSecurityUserProcessor o) {
            super(o);
            this.field = o.field;
            this.properties = _listCopy(o.properties);
        }

        private Builder(Builder o) {
            super(o);
            this.field = o.field;
            this.properties = _listCopy(o.properties);
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
         * Required - API name: {@code field}
         */
        @Nonnull
        public final Builder field(String value) {
            this.field = value;
            return this;
        }

        /**
         * Controls what user related properties are added to the field.
         * <p>
         * API name: {@code properties}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>properties</code>.
         * </p>
         */
        @Nonnull
        public final Builder properties(List<String> list) {
            this.properties = _listAddAll(this.properties, list);
            return this;
        }

        /**
         * Controls what user related properties are added to the field.
         * <p>
         * API name: {@code properties}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>properties</code>.
         * </p>
         */
        @Nonnull
        public final Builder properties(String value, String... values) {
            this.properties = _listAdd(this.properties, value, values);
            return this;
        }

        /**
         * Builds a {@link SetSecurityUserProcessor}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SetSecurityUserProcessor build() {
            _checkSingleUse();

            return new SetSecurityUserProcessor(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SetSecurityUserProcessor}
     */
    public static final JsonpDeserializer<SetSecurityUserProcessor> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SetSecurityUserProcessor::setupSetSecurityUserProcessorDeserializer
    );

    protected static void setupSetSecurityUserProcessorDeserializer(ObjectDeserializer<SetSecurityUserProcessor.Builder> op) {
        setupProcessorBaseDeserializer(op);
        op.add(Builder::field, JsonpDeserializer.stringDeserializer(), "field");
        op.add(Builder::properties, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "properties");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + this.field.hashCode();
        result = 31 * result + Objects.hashCode(this.properties);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SetSecurityUserProcessor other = (SetSecurityUserProcessor) o;
        return this.field.equals(other.field) && Objects.equals(this.properties, other.properties);
    }
}
