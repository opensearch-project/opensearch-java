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

package org.opensearch.client.opensearch.core.explain;

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
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: core.explain.Explanation

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Explanation implements PlainJsonSerializable, ToCopyableBuilder<Explanation.Builder, Explanation> {

    @Nonnull
    private final String description;

    @Nonnull
    private final List<Explanation> details;

    @Nonnull
    private final Number value;

    // ---------------------------------------------------------------------------------------------

    private Explanation(Builder builder) {
        this.description = ApiTypeHelper.requireNonNull(builder.description, this, "description");
        this.details = ApiTypeHelper.unmodifiable(builder.details);
        this.value = ApiTypeHelper.requireNonNull(builder.value, this, "value");
    }

    public static Explanation of(Function<Explanation.Builder, ObjectBuilder<Explanation>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code description}
     */
    @Nonnull
    public final String description() {
        return this.description;
    }

    /**
     * API name: {@code details}
     */
    @Nonnull
    public final List<Explanation> details() {
        return this.details;
    }

    /**
     * Required - API name: {@code value}
     */
    @Nonnull
    public final Number value() {
        return this.value;
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
        generator.writeKey("description");
        generator.write(this.description);

        if (ApiTypeHelper.isDefined(this.details)) {
            generator.writeKey("details");
            generator.writeStartArray();
            for (Explanation item0 : this.details) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        generator.writeKey("value");
        generator.write(this.value.doubleValue());
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
     * Builder for {@link Explanation}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, Explanation> {
        private String description;
        @Nullable
        private List<Explanation> details;
        private Number value;

        public Builder() {}

        private Builder(Explanation o) {
            this.description = o.description;
            this.details = _listCopy(o.details);
            this.value = o.value;
        }

        private Builder(Builder o) {
            this.description = o.description;
            this.details = _listCopy(o.details);
            this.value = o.value;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code description}
         */
        @Nonnull
        public final Builder description(String value) {
            this.description = value;
            return this;
        }

        /**
         * API name: {@code details}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>details</code>.
         * </p>
         */
        @Nonnull
        public final Builder details(List<Explanation> list) {
            this.details = _listAddAll(this.details, list);
            return this;
        }

        /**
         * API name: {@code details}
         *
         * <p>
         * Adds one or more values to <code>details</code>.
         * </p>
         */
        @Nonnull
        public final Builder details(Explanation value, Explanation... values) {
            this.details = _listAdd(this.details, value, values);
            return this;
        }

        /**
         * API name: {@code details}
         *
         * <p>
         * Adds a value to <code>details</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder details(Function<Explanation.Builder, ObjectBuilder<Explanation>> fn) {
            return details(fn.apply(new Explanation.Builder()).build());
        }

        /**
         * Required - API name: {@code value}
         */
        @Nonnull
        public final Builder value(Number value) {
            this.value = value;
            return this;
        }

        /**
         * Builds a {@link Explanation}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public Explanation build() {
            _checkSingleUse();

            return new Explanation(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link Explanation}
     */
    public static final JsonpDeserializer<Explanation> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        Explanation::setupExplanationDeserializer
    );

    protected static void setupExplanationDeserializer(ObjectDeserializer<Explanation.Builder> op) {
        op.add(Builder::description, JsonpDeserializer.stringDeserializer(), "description");
        op.add(Builder::details, JsonpDeserializer.arrayDeserializer(Explanation._DESERIALIZER), "details");
        op.add(Builder::value, JsonpDeserializer.numberDeserializer(), "value");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.description.hashCode();
        result = 31 * result + Objects.hashCode(this.details);
        result = 31 * result + this.value.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Explanation other = (Explanation) o;
        return this.description.equals(other.description) && Objects.equals(this.details, other.details) && this.value.equals(other.value);
    }
}
