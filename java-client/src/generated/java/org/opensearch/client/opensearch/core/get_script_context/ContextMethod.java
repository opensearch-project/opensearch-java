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

package org.opensearch.client.opensearch.core.get_script_context;

import jakarta.json.stream.JsonGenerator;
import java.util.List;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
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

// typedef: core.get_script_context.ContextMethod

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ContextMethod implements PlainJsonSerializable, ToCopyableBuilder<ContextMethod.Builder, ContextMethod> {

    @Nonnull
    private final String name;

    @Nonnull
    private final List<ContextMethodParam> params;

    @Nonnull
    private final String returnType;

    // ---------------------------------------------------------------------------------------------

    private ContextMethod(Builder builder) {
        this.name = ApiTypeHelper.requireNonNull(builder.name, this, "name");
        this.params = ApiTypeHelper.unmodifiableRequired(builder.params, this, "params");
        this.returnType = ApiTypeHelper.requireNonNull(builder.returnType, this, "returnType");
    }

    public static ContextMethod of(Function<ContextMethod.Builder, ObjectBuilder<ContextMethod>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code name}
     */
    @Nonnull
    public final String name() {
        return this.name;
    }

    /**
     * Required - API name: {@code params}
     */
    @Nonnull
    public final List<ContextMethodParam> params() {
        return this.params;
    }

    /**
     * Required - API name: {@code return_type}
     */
    @Nonnull
    public final String returnType() {
        return this.returnType;
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
        generator.writeKey("name");
        generator.write(this.name);

        generator.writeKey("params");
        generator.writeStartArray();
        for (ContextMethodParam item0 : this.params) {
            item0.serialize(generator, mapper);
        }
        generator.writeEnd();

        generator.writeKey("return_type");
        generator.write(this.returnType);
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
     * Builder for {@link ContextMethod}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ContextMethod> {
        private String name;
        private List<ContextMethodParam> params;
        private String returnType;

        public Builder() {}

        private Builder(ContextMethod o) {
            this.name = o.name;
            this.params = _listCopy(o.params);
            this.returnType = o.returnType;
        }

        private Builder(Builder o) {
            this.name = o.name;
            this.params = _listCopy(o.params);
            this.returnType = o.returnType;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code name}
         */
        @Nonnull
        public final Builder name(String value) {
            this.name = value;
            return this;
        }

        /**
         * Required - API name: {@code params}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>params</code>.
         * </p>
         */
        @Nonnull
        public final Builder params(List<ContextMethodParam> list) {
            this.params = _listAddAll(this.params, list);
            return this;
        }

        /**
         * Required - API name: {@code params}
         *
         * <p>
         * Adds one or more values to <code>params</code>.
         * </p>
         */
        @Nonnull
        public final Builder params(ContextMethodParam value, ContextMethodParam... values) {
            this.params = _listAdd(this.params, value, values);
            return this;
        }

        /**
         * Required - API name: {@code params}
         *
         * <p>
         * Adds a value to <code>params</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder params(Function<ContextMethodParam.Builder, ObjectBuilder<ContextMethodParam>> fn) {
            return params(fn.apply(new ContextMethodParam.Builder()).build());
        }

        /**
         * Required - API name: {@code return_type}
         */
        @Nonnull
        public final Builder returnType(String value) {
            this.returnType = value;
            return this;
        }

        /**
         * Builds a {@link ContextMethod}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ContextMethod build() {
            _checkSingleUse();

            return new ContextMethod(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ContextMethod}
     */
    public static final JsonpDeserializer<ContextMethod> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ContextMethod::setupContextMethodDeserializer
    );

    protected static void setupContextMethodDeserializer(ObjectDeserializer<ContextMethod.Builder> op) {
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
        op.add(Builder::params, JsonpDeserializer.arrayDeserializer(ContextMethodParam._DESERIALIZER), "params");
        op.add(Builder::returnType, JsonpDeserializer.stringDeserializer(), "return_type");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.name.hashCode();
        result = 31 * result + this.params.hashCode();
        result = 31 * result + this.returnType.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ContextMethod other = (ContextMethod) o;
        return this.name.equals(other.name) && this.params.equals(other.params) && this.returnType.equals(other.returnType);
    }
}
