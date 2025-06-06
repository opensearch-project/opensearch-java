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
import java.util.Map;
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

// typedef: security.CertificateTypes

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class CertificateTypes implements PlainJsonSerializable, ToCopyableBuilder<CertificateTypes.Builder, CertificateTypes> {

    @Nonnull
    private final List<Map<String, CertificatesDetail>> http;

    @Nonnull
    private final List<Map<String, CertificatesDetail>> transport;

    // ---------------------------------------------------------------------------------------------

    private CertificateTypes(Builder builder) {
        this.http = ApiTypeHelper.unmodifiable(builder.http);
        this.transport = ApiTypeHelper.unmodifiable(builder.transport);
    }

    public static CertificateTypes of(Function<CertificateTypes.Builder, ObjectBuilder<CertificateTypes>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code http}
     */
    @Nonnull
    public final List<Map<String, CertificatesDetail>> http() {
        return this.http;
    }

    /**
     * API name: {@code transport}
     */
    @Nonnull
    public final List<Map<String, CertificatesDetail>> transport() {
        return this.transport;
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
        if (ApiTypeHelper.isDefined(this.http)) {
            generator.writeKey("http");
            generator.writeStartArray();
            for (Map<String, CertificatesDetail> item0 : this.http) {
                generator.writeStartObject();
                if (item0 != null) {
                    for (Map.Entry<String, CertificatesDetail> item1 : item0.entrySet()) {
                        generator.writeKey(item1.getKey());
                        item1.getValue().serialize(generator, mapper);
                    }
                }
                generator.writeEnd();
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.transport)) {
            generator.writeKey("transport");
            generator.writeStartArray();
            for (Map<String, CertificatesDetail> item0 : this.transport) {
                generator.writeStartObject();
                if (item0 != null) {
                    for (Map.Entry<String, CertificatesDetail> item1 : item0.entrySet()) {
                        generator.writeKey(item1.getKey());
                        item1.getValue().serialize(generator, mapper);
                    }
                }
                generator.writeEnd();
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
     * Builder for {@link CertificateTypes}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, CertificateTypes> {
        @Nullable
        private List<Map<String, CertificatesDetail>> http;
        @Nullable
        private List<Map<String, CertificatesDetail>> transport;

        public Builder() {}

        private Builder(CertificateTypes o) {
            this.http = _listCopy(o.http);
            this.transport = _listCopy(o.transport);
        }

        private Builder(Builder o) {
            this.http = _listCopy(o.http);
            this.transport = _listCopy(o.transport);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code http}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>http</code>.
         * </p>
         */
        @Nonnull
        public final Builder http(List<Map<String, CertificatesDetail>> list) {
            this.http = _listAddAll(this.http, list);
            return this;
        }

        /**
         * API name: {@code http}
         *
         * <p>
         * Adds one or more values to <code>http</code>.
         * </p>
         */
        @Nonnull
        public final Builder http(Map<String, CertificatesDetail> value, Map<String, CertificatesDetail>... values) {
            this.http = _listAdd(this.http, value, values);
            return this;
        }

        /**
         * API name: {@code transport}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>transport</code>.
         * </p>
         */
        @Nonnull
        public final Builder transport(List<Map<String, CertificatesDetail>> list) {
            this.transport = _listAddAll(this.transport, list);
            return this;
        }

        /**
         * API name: {@code transport}
         *
         * <p>
         * Adds one or more values to <code>transport</code>.
         * </p>
         */
        @Nonnull
        public final Builder transport(Map<String, CertificatesDetail> value, Map<String, CertificatesDetail>... values) {
            this.transport = _listAdd(this.transport, value, values);
            return this;
        }

        /**
         * Builds a {@link CertificateTypes}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public CertificateTypes build() {
            _checkSingleUse();

            return new CertificateTypes(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link CertificateTypes}
     */
    public static final JsonpDeserializer<CertificateTypes> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CertificateTypes::setupCertificateTypesDeserializer
    );

    protected static void setupCertificateTypesDeserializer(ObjectDeserializer<CertificateTypes.Builder> op) {
        op.add(
            Builder::http,
            JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringMapDeserializer(CertificatesDetail._DESERIALIZER)),
            "http"
        );
        op.add(
            Builder::transport,
            JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringMapDeserializer(CertificatesDetail._DESERIALIZER)),
            "transport"
        );
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.http);
        result = 31 * result + Objects.hashCode(this.transport);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CertificateTypes other = (CertificateTypes) o;
        return Objects.equals(this.http, other.http) && Objects.equals(this.transport, other.transport);
    }
}
