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

package org.opensearch.client.opensearch.security;

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

// typedef: security.DistinguishedNames

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class DistinguishedNames implements PlainJsonSerializable, ToCopyableBuilder<DistinguishedNames.Builder, DistinguishedNames> {

    @Nonnull
    private final List<String> nodesDn;

    // ---------------------------------------------------------------------------------------------

    private DistinguishedNames(Builder builder) {
        this.nodesDn = ApiTypeHelper.unmodifiable(builder.nodesDn);
    }

    public static DistinguishedNames of(Function<DistinguishedNames.Builder, ObjectBuilder<DistinguishedNames>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code nodes_dn}
     */
    @Nonnull
    public final List<String> nodesDn() {
        return this.nodesDn;
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
        if (ApiTypeHelper.isDefined(this.nodesDn)) {
            generator.writeKey("nodes_dn");
            generator.writeStartArray();
            for (String item0 : this.nodesDn) {
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
     * Builder for {@link DistinguishedNames}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, DistinguishedNames> {
        @Nullable
        private List<String> nodesDn;

        public Builder() {}

        private Builder(DistinguishedNames o) {
            this.nodesDn = _listCopy(o.nodesDn);
        }

        private Builder(Builder o) {
            this.nodesDn = _listCopy(o.nodesDn);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code nodes_dn}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>nodesDn</code>.
         * </p>
         */
        @Nonnull
        public final Builder nodesDn(List<String> list) {
            this.nodesDn = _listAddAll(this.nodesDn, list);
            return this;
        }

        /**
         * API name: {@code nodes_dn}
         *
         * <p>
         * Adds one or more values to <code>nodesDn</code>.
         * </p>
         */
        @Nonnull
        public final Builder nodesDn(String value, String... values) {
            this.nodesDn = _listAdd(this.nodesDn, value, values);
            return this;
        }

        /**
         * Builds a {@link DistinguishedNames}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DistinguishedNames build() {
            _checkSingleUse();

            return new DistinguishedNames(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link DistinguishedNames}
     */
    public static final JsonpDeserializer<DistinguishedNames> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        DistinguishedNames::setupDistinguishedNamesDeserializer
    );

    protected static void setupDistinguishedNamesDeserializer(ObjectDeserializer<DistinguishedNames.Builder> op) {
        op.add(Builder::nodesDn, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "nodes_dn");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.nodesDn);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        DistinguishedNames other = (DistinguishedNames) o;
        return Objects.equals(this.nodesDn, other.nodesDn);
    }
}
