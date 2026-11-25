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

package org.opensearch.client.opensearch.ism;

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

// typedef: ism.ActionPublishFieldDomains

/**
 * The publish field domains action configuration.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ActionPublishFieldDomains
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ActionPublishFieldDomains.Builder, ActionPublishFieldDomains> {

    @Nonnull
    private final List<FieldDomain> fields;

    // ---------------------------------------------------------------------------------------------

    private ActionPublishFieldDomains(Builder builder) {
        this.fields = ApiTypeHelper.unmodifiableRequired(builder.fields, this, "fields");
    }

    public static ActionPublishFieldDomains of(Function<ActionPublishFieldDomains.Builder, ObjectBuilder<ActionPublishFieldDomains>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The fields to compute the value domains for.
     * <p>
     * API name: {@code fields}
     * </p>
     */
    @Nonnull
    public final List<FieldDomain> fields() {
        return this.fields;
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
        generator.writeKey("fields");
        generator.writeStartArray();
        for (FieldDomain item0 : this.fields) {
            item0.serialize(generator, mapper);
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
     * Builder for {@link ActionPublishFieldDomains}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ActionPublishFieldDomains> {
        private List<FieldDomain> fields;

        public Builder() {}

        private Builder(ActionPublishFieldDomains o) {
            this.fields = _listCopy(o.fields);
        }

        private Builder(Builder o) {
            this.fields = _listCopy(o.fields);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - The fields to compute the value domains for.
         * <p>
         * API name: {@code fields}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>fields</code>.
         * </p>
         */
        @Nonnull
        public final Builder fields(List<FieldDomain> list) {
            this.fields = _listAddAll(this.fields, list);
            return this;
        }

        /**
         * Required - The fields to compute the value domains for.
         * <p>
         * API name: {@code fields}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>fields</code>.
         * </p>
         */
        @Nonnull
        public final Builder fields(FieldDomain value, FieldDomain... values) {
            this.fields = _listAdd(this.fields, value, values);
            return this;
        }

        /**
         * Required - The fields to compute the value domains for.
         * <p>
         * API name: {@code fields}
         * </p>
         *
         * <p>
         * Adds a value to <code>fields</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder fields(Function<FieldDomain.Builder, ObjectBuilder<FieldDomain>> fn) {
            return fields(fn.apply(new FieldDomain.Builder()).build());
        }

        /**
         * Builds a {@link ActionPublishFieldDomains}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ActionPublishFieldDomains build() {
            _checkSingleUse();

            return new ActionPublishFieldDomains(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ActionPublishFieldDomains}
     */
    public static final JsonpDeserializer<ActionPublishFieldDomains> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ActionPublishFieldDomains::setupActionPublishFieldDomainsDeserializer
    );

    protected static void setupActionPublishFieldDomainsDeserializer(ObjectDeserializer<ActionPublishFieldDomains.Builder> op) {
        op.add(Builder::fields, JsonpDeserializer.arrayDeserializer(FieldDomain._DESERIALIZER), "fields");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.fields.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ActionPublishFieldDomains other = (ActionPublishFieldDomains) o;
        return this.fields.equals(other.fields);
    }
}
