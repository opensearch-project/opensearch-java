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

// typedef: security.get_certificates.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GetCertificatesResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<GetCertificatesResponse.Builder, GetCertificatesResponse> {

    @Nonnull
    private final List<CertificatesDetail> httpCertificatesList;

    @Nonnull
    private final List<CertificatesDetail> transportCertificatesList;

    // ---------------------------------------------------------------------------------------------

    private GetCertificatesResponse(Builder builder) {
        this.httpCertificatesList = ApiTypeHelper.unmodifiable(builder.httpCertificatesList);
        this.transportCertificatesList = ApiTypeHelper.unmodifiable(builder.transportCertificatesList);
    }

    public static GetCertificatesResponse of(Function<GetCertificatesResponse.Builder, ObjectBuilder<GetCertificatesResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code http_certificates_list}
     */
    @Nonnull
    public final List<CertificatesDetail> httpCertificatesList() {
        return this.httpCertificatesList;
    }

    /**
     * API name: {@code transport_certificates_list}
     */
    @Nonnull
    public final List<CertificatesDetail> transportCertificatesList() {
        return this.transportCertificatesList;
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
        if (ApiTypeHelper.isDefined(this.httpCertificatesList)) {
            generator.writeKey("http_certificates_list");
            generator.writeStartArray();
            for (CertificatesDetail item0 : this.httpCertificatesList) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.transportCertificatesList)) {
            generator.writeKey("transport_certificates_list");
            generator.writeStartArray();
            for (CertificatesDetail item0 : this.transportCertificatesList) {
                item0.serialize(generator, mapper);
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
     * Builder for {@link GetCertificatesResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, GetCertificatesResponse> {
        @Nullable
        private List<CertificatesDetail> httpCertificatesList;
        @Nullable
        private List<CertificatesDetail> transportCertificatesList;

        public Builder() {}

        private Builder(GetCertificatesResponse o) {
            this.httpCertificatesList = _listCopy(o.httpCertificatesList);
            this.transportCertificatesList = _listCopy(o.transportCertificatesList);
        }

        private Builder(Builder o) {
            this.httpCertificatesList = _listCopy(o.httpCertificatesList);
            this.transportCertificatesList = _listCopy(o.transportCertificatesList);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code http_certificates_list}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>httpCertificatesList</code>.
         * </p>
         */
        @Nonnull
        public final Builder httpCertificatesList(List<CertificatesDetail> list) {
            this.httpCertificatesList = _listAddAll(this.httpCertificatesList, list);
            return this;
        }

        /**
         * API name: {@code http_certificates_list}
         *
         * <p>
         * Adds one or more values to <code>httpCertificatesList</code>.
         * </p>
         */
        @Nonnull
        public final Builder httpCertificatesList(CertificatesDetail value, CertificatesDetail... values) {
            this.httpCertificatesList = _listAdd(this.httpCertificatesList, value, values);
            return this;
        }

        /**
         * API name: {@code http_certificates_list}
         *
         * <p>
         * Adds a value to <code>httpCertificatesList</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder httpCertificatesList(Function<CertificatesDetail.Builder, ObjectBuilder<CertificatesDetail>> fn) {
            return httpCertificatesList(fn.apply(new CertificatesDetail.Builder()).build());
        }

        /**
         * API name: {@code transport_certificates_list}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>transportCertificatesList</code>.
         * </p>
         */
        @Nonnull
        public final Builder transportCertificatesList(List<CertificatesDetail> list) {
            this.transportCertificatesList = _listAddAll(this.transportCertificatesList, list);
            return this;
        }

        /**
         * API name: {@code transport_certificates_list}
         *
         * <p>
         * Adds one or more values to <code>transportCertificatesList</code>.
         * </p>
         */
        @Nonnull
        public final Builder transportCertificatesList(CertificatesDetail value, CertificatesDetail... values) {
            this.transportCertificatesList = _listAdd(this.transportCertificatesList, value, values);
            return this;
        }

        /**
         * API name: {@code transport_certificates_list}
         *
         * <p>
         * Adds a value to <code>transportCertificatesList</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder transportCertificatesList(Function<CertificatesDetail.Builder, ObjectBuilder<CertificatesDetail>> fn) {
            return transportCertificatesList(fn.apply(new CertificatesDetail.Builder()).build());
        }

        /**
         * Builds a {@link GetCertificatesResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetCertificatesResponse build() {
            _checkSingleUse();

            return new GetCertificatesResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GetCertificatesResponse}
     */
    public static final JsonpDeserializer<GetCertificatesResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GetCertificatesResponse::setupGetCertificatesResponseDeserializer
    );

    protected static void setupGetCertificatesResponseDeserializer(ObjectDeserializer<GetCertificatesResponse.Builder> op) {
        op.add(
            Builder::httpCertificatesList,
            JsonpDeserializer.arrayDeserializer(CertificatesDetail._DESERIALIZER),
            "http_certificates_list"
        );
        op.add(
            Builder::transportCertificatesList,
            JsonpDeserializer.arrayDeserializer(CertificatesDetail._DESERIALIZER),
            "transport_certificates_list"
        );
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.httpCertificatesList);
        result = 31 * result + Objects.hashCode(this.transportCertificatesList);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetCertificatesResponse other = (GetCertificatesResponse) o;
        return Objects.equals(this.httpCertificatesList, other.httpCertificatesList)
            && Objects.equals(this.transportCertificatesList, other.transportCertificatesList);
    }
}
