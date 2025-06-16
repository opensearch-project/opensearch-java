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

// typedef: security.CertificatesPerNode

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class CertificatesPerNode implements PlainJsonSerializable, ToCopyableBuilder<CertificatesPerNode.Builder, CertificatesPerNode> {

    @Nonnull
    private final Map<String, CertificateTypes> certificates;

    @Nullable
    private final String name;

    // ---------------------------------------------------------------------------------------------

    private CertificatesPerNode(Builder builder) {
        this.certificates = ApiTypeHelper.unmodifiable(builder.certificates);
        this.name = builder.name;
    }

    public static CertificatesPerNode of(Function<CertificatesPerNode.Builder, ObjectBuilder<CertificatesPerNode>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code certificates}
     */
    @Nonnull
    public final Map<String, CertificateTypes> certificates() {
        return this.certificates;
    }

    /**
     * The name of the node.
     * <p>
     * API name: {@code name}
     * </p>
     */
    @Nullable
    public final String name() {
        return this.name;
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
        if (ApiTypeHelper.isDefined(this.certificates)) {
            generator.writeKey("certificates");
            generator.writeStartObject();
            for (Map.Entry<String, CertificateTypes> item0 : this.certificates.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.name != null) {
            generator.writeKey("name");
            generator.write(this.name);
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
     * Builder for {@link CertificatesPerNode}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, CertificatesPerNode> {
        @Nullable
        private Map<String, CertificateTypes> certificates;
        @Nullable
        private String name;

        public Builder() {}

        private Builder(CertificatesPerNode o) {
            this.certificates = _mapCopy(o.certificates);
            this.name = o.name;
        }

        private Builder(Builder o) {
            this.certificates = _mapCopy(o.certificates);
            this.name = o.name;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code certificates}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>certificates</code>.
         * </p>
         */
        @Nonnull
        public final Builder certificates(Map<String, CertificateTypes> map) {
            this.certificates = _mapPutAll(this.certificates, map);
            return this;
        }

        /**
         * API name: {@code certificates}
         *
         * <p>
         * Adds an entry to <code>certificates</code>.
         * </p>
         */
        @Nonnull
        public final Builder certificates(String key, CertificateTypes value) {
            this.certificates = _mapPut(this.certificates, key, value);
            return this;
        }

        /**
         * API name: {@code certificates}
         *
         * <p>
         * Adds a value to <code>certificates</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder certificates(String key, Function<CertificateTypes.Builder, ObjectBuilder<CertificateTypes>> fn) {
            return certificates(key, fn.apply(new CertificateTypes.Builder()).build());
        }

        /**
         * The name of the node.
         * <p>
         * API name: {@code name}
         * </p>
         */
        @Nonnull
        public final Builder name(@Nullable String value) {
            this.name = value;
            return this;
        }

        /**
         * Builds a {@link CertificatesPerNode}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public CertificatesPerNode build() {
            _checkSingleUse();

            return new CertificatesPerNode(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link CertificatesPerNode}
     */
    public static final JsonpDeserializer<CertificatesPerNode> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CertificatesPerNode::setupCertificatesPerNodeDeserializer
    );

    protected static void setupCertificatesPerNodeDeserializer(ObjectDeserializer<CertificatesPerNode.Builder> op) {
        op.add(Builder::certificates, JsonpDeserializer.stringMapDeserializer(CertificateTypes._DESERIALIZER), "certificates");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.certificates);
        result = 31 * result + Objects.hashCode(this.name);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CertificatesPerNode other = (CertificatesPerNode) o;
        return Objects.equals(this.certificates, other.certificates) && Objects.equals(this.name, other.name);
    }
}
