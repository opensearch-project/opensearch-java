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
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: security.CertificatesDetail

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class CertificatesDetail implements PlainJsonSerializable, ToCopyableBuilder<CertificatesDetail.Builder, CertificatesDetail> {

    @Nullable
    private final String issuerDn;

    @Nullable
    private final String notAfter;

    @Nullable
    private final String notBefore;

    @Nullable
    private final String san;

    @Nullable
    private final String subjectDn;

    // ---------------------------------------------------------------------------------------------

    private CertificatesDetail(Builder builder) {
        this.issuerDn = builder.issuerDn;
        this.notAfter = builder.notAfter;
        this.notBefore = builder.notBefore;
        this.san = builder.san;
        this.subjectDn = builder.subjectDn;
    }

    public static CertificatesDetail of(Function<CertificatesDetail.Builder, ObjectBuilder<CertificatesDetail>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code issuer_dn}
     */
    @Nullable
    public final String issuerDn() {
        return this.issuerDn;
    }

    /**
     * API name: {@code not_after}
     */
    @Nullable
    public final String notAfter() {
        return this.notAfter;
    }

    /**
     * API name: {@code not_before}
     */
    @Nullable
    public final String notBefore() {
        return this.notBefore;
    }

    /**
     * API name: {@code san}
     */
    @Nullable
    public final String san() {
        return this.san;
    }

    /**
     * API name: {@code subject_dn}
     */
    @Nullable
    public final String subjectDn() {
        return this.subjectDn;
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
        if (this.issuerDn != null) {
            generator.writeKey("issuer_dn");
            generator.write(this.issuerDn);
        }

        if (this.notAfter != null) {
            generator.writeKey("not_after");
            generator.write(this.notAfter);
        }

        if (this.notBefore != null) {
            generator.writeKey("not_before");
            generator.write(this.notBefore);
        }

        if (this.san != null) {
            generator.writeKey("san");
            generator.write(this.san);
        }

        if (this.subjectDn != null) {
            generator.writeKey("subject_dn");
            generator.write(this.subjectDn);
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
     * Builder for {@link CertificatesDetail}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, CertificatesDetail> {
        @Nullable
        private String issuerDn;
        @Nullable
        private String notAfter;
        @Nullable
        private String notBefore;
        @Nullable
        private String san;
        @Nullable
        private String subjectDn;

        public Builder() {}

        private Builder(CertificatesDetail o) {
            this.issuerDn = o.issuerDn;
            this.notAfter = o.notAfter;
            this.notBefore = o.notBefore;
            this.san = o.san;
            this.subjectDn = o.subjectDn;
        }

        private Builder(Builder o) {
            this.issuerDn = o.issuerDn;
            this.notAfter = o.notAfter;
            this.notBefore = o.notBefore;
            this.san = o.san;
            this.subjectDn = o.subjectDn;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code issuer_dn}
         */
        @Nonnull
        public final Builder issuerDn(@Nullable String value) {
            this.issuerDn = value;
            return this;
        }

        /**
         * API name: {@code not_after}
         */
        @Nonnull
        public final Builder notAfter(@Nullable String value) {
            this.notAfter = value;
            return this;
        }

        /**
         * API name: {@code not_before}
         */
        @Nonnull
        public final Builder notBefore(@Nullable String value) {
            this.notBefore = value;
            return this;
        }

        /**
         * API name: {@code san}
         */
        @Nonnull
        public final Builder san(@Nullable String value) {
            this.san = value;
            return this;
        }

        /**
         * API name: {@code subject_dn}
         */
        @Nonnull
        public final Builder subjectDn(@Nullable String value) {
            this.subjectDn = value;
            return this;
        }

        /**
         * Builds a {@link CertificatesDetail}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public CertificatesDetail build() {
            _checkSingleUse();

            return new CertificatesDetail(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link CertificatesDetail}
     */
    public static final JsonpDeserializer<CertificatesDetail> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CertificatesDetail::setupCertificatesDetailDeserializer
    );

    protected static void setupCertificatesDetailDeserializer(ObjectDeserializer<CertificatesDetail.Builder> op) {
        op.add(Builder::issuerDn, JsonpDeserializer.stringDeserializer(), "issuer_dn");
        op.add(Builder::notAfter, JsonpDeserializer.stringDeserializer(), "not_after");
        op.add(Builder::notBefore, JsonpDeserializer.stringDeserializer(), "not_before");
        op.add(Builder::san, JsonpDeserializer.stringDeserializer(), "san");
        op.add(Builder::subjectDn, JsonpDeserializer.stringDeserializer(), "subject_dn");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.issuerDn);
        result = 31 * result + Objects.hashCode(this.notAfter);
        result = 31 * result + Objects.hashCode(this.notBefore);
        result = 31 * result + Objects.hashCode(this.san);
        result = 31 * result + Objects.hashCode(this.subjectDn);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CertificatesDetail other = (CertificatesDetail) o;
        return Objects.equals(this.issuerDn, other.issuerDn)
            && Objects.equals(this.notAfter, other.notAfter)
            && Objects.equals(this.notBefore, other.notBefore)
            && Objects.equals(this.san, other.san)
            && Objects.equals(this.subjectDn, other.subjectDn);
    }
}
