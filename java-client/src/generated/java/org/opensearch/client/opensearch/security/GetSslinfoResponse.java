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

// typedef: security.get_sslinfo.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GetSslinfoResponse implements PlainJsonSerializable, ToCopyableBuilder<GetSslinfoResponse.Builder, GetSslinfoResponse> {

    @Nonnull
    private final List<String> localCertificatesList;

    @Nonnull
    private final String peerCertificates;

    @Nonnull
    private final List<String> peerCertificatesList;

    @Nullable
    private final String principal;

    @Nullable
    private final String sslCipher;

    @Nullable
    private final Boolean sslOpensslAvailable;

    @Nullable
    private final String sslOpensslNonAvailableCause;

    @Nullable
    private final Boolean sslOpensslSupportsHostnameValidation;

    @Nullable
    private final Boolean sslOpensslSupportsKeyManagerFactory;

    @Nullable
    private final String sslOpensslVersion;

    @Nullable
    private final String sslOpensslVersionString;

    @Nullable
    private final String sslProtocol;

    @Nullable
    private final String sslProviderHttp;

    @Nonnull
    private final String sslProviderTransportClient;

    @Nonnull
    private final String sslProviderTransportServer;

    // ---------------------------------------------------------------------------------------------

    private GetSslinfoResponse(Builder builder) {
        this.localCertificatesList = ApiTypeHelper.unmodifiable(builder.localCertificatesList);
        this.peerCertificates = ApiTypeHelper.requireNonNull(builder.peerCertificates, this, "peerCertificates");
        this.peerCertificatesList = ApiTypeHelper.unmodifiable(builder.peerCertificatesList);
        this.principal = builder.principal;
        this.sslCipher = builder.sslCipher;
        this.sslOpensslAvailable = builder.sslOpensslAvailable;
        this.sslOpensslNonAvailableCause = builder.sslOpensslNonAvailableCause;
        this.sslOpensslSupportsHostnameValidation = builder.sslOpensslSupportsHostnameValidation;
        this.sslOpensslSupportsKeyManagerFactory = builder.sslOpensslSupportsKeyManagerFactory;
        this.sslOpensslVersion = builder.sslOpensslVersion;
        this.sslOpensslVersionString = builder.sslOpensslVersionString;
        this.sslProtocol = builder.sslProtocol;
        this.sslProviderHttp = builder.sslProviderHttp;
        this.sslProviderTransportClient = ApiTypeHelper.requireNonNull(
            builder.sslProviderTransportClient,
            this,
            "sslProviderTransportClient"
        );
        this.sslProviderTransportServer = ApiTypeHelper.requireNonNull(
            builder.sslProviderTransportServer,
            this,
            "sslProviderTransportServer"
        );
    }

    public static GetSslinfoResponse of(Function<GetSslinfoResponse.Builder, ObjectBuilder<GetSslinfoResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * A list of domain names from local certificates.
     * <p>
     * API name: {@code local_certificates_list}
     * </p>
     */
    @Nonnull
    public final List<String> localCertificatesList() {
        return this.localCertificatesList;
    }

    /**
     * Required - The number of certificates.
     * <p>
     * API name: {@code peer_certificates}
     * </p>
     */
    @Nonnull
    public final String peerCertificates() {
        return this.peerCertificates;
    }

    /**
     * A list of domain names from peer certificates.
     * <p>
     * API name: {@code peer_certificates_list}
     * </p>
     */
    @Nonnull
    public final List<String> peerCertificatesList() {
        return this.peerCertificatesList;
    }

    /**
     * The user's principal.
     * <p>
     * API name: {@code principal}
     * </p>
     */
    @Nullable
    public final String principal() {
        return this.principal;
    }

    /**
     * The cipher for this SSL setup.
     * <p>
     * API name: {@code ssl_cipher}
     * </p>
     */
    @Nullable
    public final String sslCipher() {
        return this.sslCipher;
    }

    /**
     * Whether OpenSSL is available.
     * <p>
     * API name: {@code ssl_openssl_available}
     * </p>
     */
    @Nullable
    public final Boolean sslOpensslAvailable() {
        return this.sslOpensslAvailable;
    }

    /**
     * The reason OpenSSL is unavailable.
     * <p>
     * API name: {@code ssl_openssl_non_available_cause}
     * </p>
     */
    @Nullable
    public final String sslOpensslNonAvailableCause() {
        return this.sslOpensslNonAvailableCause;
    }

    /**
     * Whether the hostname validation is supported.
     * <p>
     * API name: {@code ssl_openssl_supports_hostname_validation}
     * </p>
     */
    @Nullable
    public final Boolean sslOpensslSupportsHostnameValidation() {
        return this.sslOpensslSupportsHostnameValidation;
    }

    /**
     * Whether <code>KMF</code> is supported.
     * <p>
     * API name: {@code ssl_openssl_supports_key_manager_factory}
     * </p>
     */
    @Nullable
    public final Boolean sslOpensslSupportsKeyManagerFactory() {
        return this.sslOpensslSupportsKeyManagerFactory;
    }

    /**
     * Version of OpenSSL.
     * <p>
     * API name: {@code ssl_openssl_version}
     * </p>
     */
    @Nullable
    public final String sslOpensslVersion() {
        return this.sslOpensslVersion;
    }

    /**
     * The full version string for the OpenSSL version.
     * <p>
     * API name: {@code ssl_openssl_version_string}
     * </p>
     */
    @Nullable
    public final String sslOpensslVersionString() {
        return this.sslOpensslVersionString;
    }

    /**
     * The protocol for this SSL setup.
     * <p>
     * API name: {@code ssl_protocol}
     * </p>
     */
    @Nullable
    public final String sslProtocol() {
        return this.sslProtocol;
    }

    /**
     * Returns the HTTP provider's name.
     * <p>
     * API name: {@code ssl_provider_http}
     * </p>
     */
    @Nullable
    public final String sslProviderHttp() {
        return this.sslProviderHttp;
    }

    /**
     * Required - Returns the transport client's name.
     * <p>
     * API name: {@code ssl_provider_transport_client}
     * </p>
     */
    @Nonnull
    public final String sslProviderTransportClient() {
        return this.sslProviderTransportClient;
    }

    /**
     * Required - Returns the transport server's name.
     * <p>
     * API name: {@code ssl_provider_transport_server}
     * </p>
     */
    @Nonnull
    public final String sslProviderTransportServer() {
        return this.sslProviderTransportServer;
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
        if (ApiTypeHelper.isDefined(this.localCertificatesList)) {
            generator.writeKey("local_certificates_list");
            generator.writeStartArray();
            for (String item0 : this.localCertificatesList) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        generator.writeKey("peer_certificates");
        generator.write(this.peerCertificates);

        if (ApiTypeHelper.isDefined(this.peerCertificatesList)) {
            generator.writeKey("peer_certificates_list");
            generator.writeStartArray();
            for (String item0 : this.peerCertificatesList) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.principal != null) {
            generator.writeKey("principal");
            generator.write(this.principal);
        }

        if (this.sslCipher != null) {
            generator.writeKey("ssl_cipher");
            generator.write(this.sslCipher);
        }

        if (this.sslOpensslAvailable != null) {
            generator.writeKey("ssl_openssl_available");
            generator.write(this.sslOpensslAvailable);
        }

        if (this.sslOpensslNonAvailableCause != null) {
            generator.writeKey("ssl_openssl_non_available_cause");
            generator.write(this.sslOpensslNonAvailableCause);
        }

        if (this.sslOpensslSupportsHostnameValidation != null) {
            generator.writeKey("ssl_openssl_supports_hostname_validation");
            generator.write(this.sslOpensslSupportsHostnameValidation);
        }

        if (this.sslOpensslSupportsKeyManagerFactory != null) {
            generator.writeKey("ssl_openssl_supports_key_manager_factory");
            generator.write(this.sslOpensslSupportsKeyManagerFactory);
        }

        if (this.sslOpensslVersion != null) {
            generator.writeKey("ssl_openssl_version");
            generator.write(this.sslOpensslVersion);
        }

        if (this.sslOpensslVersionString != null) {
            generator.writeKey("ssl_openssl_version_string");
            generator.write(this.sslOpensslVersionString);
        }

        if (this.sslProtocol != null) {
            generator.writeKey("ssl_protocol");
            generator.write(this.sslProtocol);
        }

        if (this.sslProviderHttp != null) {
            generator.writeKey("ssl_provider_http");
            generator.write(this.sslProviderHttp);
        }

        generator.writeKey("ssl_provider_transport_client");
        generator.write(this.sslProviderTransportClient);

        generator.writeKey("ssl_provider_transport_server");
        generator.write(this.sslProviderTransportServer);
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
     * Builder for {@link GetSslinfoResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, GetSslinfoResponse> {
        @Nullable
        private List<String> localCertificatesList;
        private String peerCertificates;
        @Nullable
        private List<String> peerCertificatesList;
        @Nullable
        private String principal;
        @Nullable
        private String sslCipher;
        @Nullable
        private Boolean sslOpensslAvailable;
        @Nullable
        private String sslOpensslNonAvailableCause;
        @Nullable
        private Boolean sslOpensslSupportsHostnameValidation;
        @Nullable
        private Boolean sslOpensslSupportsKeyManagerFactory;
        @Nullable
        private String sslOpensslVersion;
        @Nullable
        private String sslOpensslVersionString;
        @Nullable
        private String sslProtocol;
        @Nullable
        private String sslProviderHttp;
        private String sslProviderTransportClient;
        private String sslProviderTransportServer;

        public Builder() {}

        private Builder(GetSslinfoResponse o) {
            this.localCertificatesList = _listCopy(o.localCertificatesList);
            this.peerCertificates = o.peerCertificates;
            this.peerCertificatesList = _listCopy(o.peerCertificatesList);
            this.principal = o.principal;
            this.sslCipher = o.sslCipher;
            this.sslOpensslAvailable = o.sslOpensslAvailable;
            this.sslOpensslNonAvailableCause = o.sslOpensslNonAvailableCause;
            this.sslOpensslSupportsHostnameValidation = o.sslOpensslSupportsHostnameValidation;
            this.sslOpensslSupportsKeyManagerFactory = o.sslOpensslSupportsKeyManagerFactory;
            this.sslOpensslVersion = o.sslOpensslVersion;
            this.sslOpensslVersionString = o.sslOpensslVersionString;
            this.sslProtocol = o.sslProtocol;
            this.sslProviderHttp = o.sslProviderHttp;
            this.sslProviderTransportClient = o.sslProviderTransportClient;
            this.sslProviderTransportServer = o.sslProviderTransportServer;
        }

        private Builder(Builder o) {
            this.localCertificatesList = _listCopy(o.localCertificatesList);
            this.peerCertificates = o.peerCertificates;
            this.peerCertificatesList = _listCopy(o.peerCertificatesList);
            this.principal = o.principal;
            this.sslCipher = o.sslCipher;
            this.sslOpensslAvailable = o.sslOpensslAvailable;
            this.sslOpensslNonAvailableCause = o.sslOpensslNonAvailableCause;
            this.sslOpensslSupportsHostnameValidation = o.sslOpensslSupportsHostnameValidation;
            this.sslOpensslSupportsKeyManagerFactory = o.sslOpensslSupportsKeyManagerFactory;
            this.sslOpensslVersion = o.sslOpensslVersion;
            this.sslOpensslVersionString = o.sslOpensslVersionString;
            this.sslProtocol = o.sslProtocol;
            this.sslProviderHttp = o.sslProviderHttp;
            this.sslProviderTransportClient = o.sslProviderTransportClient;
            this.sslProviderTransportServer = o.sslProviderTransportServer;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * A list of domain names from local certificates.
         * <p>
         * API name: {@code local_certificates_list}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>localCertificatesList</code>.
         * </p>
         */
        @Nonnull
        public final Builder localCertificatesList(List<String> list) {
            this.localCertificatesList = _listAddAll(this.localCertificatesList, list);
            return this;
        }

        /**
         * A list of domain names from local certificates.
         * <p>
         * API name: {@code local_certificates_list}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>localCertificatesList</code>.
         * </p>
         */
        @Nonnull
        public final Builder localCertificatesList(String value, String... values) {
            this.localCertificatesList = _listAdd(this.localCertificatesList, value, values);
            return this;
        }

        /**
         * Required - The number of certificates.
         * <p>
         * API name: {@code peer_certificates}
         * </p>
         */
        @Nonnull
        public final Builder peerCertificates(String value) {
            this.peerCertificates = value;
            return this;
        }

        /**
         * A list of domain names from peer certificates.
         * <p>
         * API name: {@code peer_certificates_list}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>peerCertificatesList</code>.
         * </p>
         */
        @Nonnull
        public final Builder peerCertificatesList(List<String> list) {
            this.peerCertificatesList = _listAddAll(this.peerCertificatesList, list);
            return this;
        }

        /**
         * A list of domain names from peer certificates.
         * <p>
         * API name: {@code peer_certificates_list}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>peerCertificatesList</code>.
         * </p>
         */
        @Nonnull
        public final Builder peerCertificatesList(String value, String... values) {
            this.peerCertificatesList = _listAdd(this.peerCertificatesList, value, values);
            return this;
        }

        /**
         * The user's principal.
         * <p>
         * API name: {@code principal}
         * </p>
         */
        @Nonnull
        public final Builder principal(@Nullable String value) {
            this.principal = value;
            return this;
        }

        /**
         * The cipher for this SSL setup.
         * <p>
         * API name: {@code ssl_cipher}
         * </p>
         */
        @Nonnull
        public final Builder sslCipher(@Nullable String value) {
            this.sslCipher = value;
            return this;
        }

        /**
         * Whether OpenSSL is available.
         * <p>
         * API name: {@code ssl_openssl_available}
         * </p>
         */
        @Nonnull
        public final Builder sslOpensslAvailable(@Nullable Boolean value) {
            this.sslOpensslAvailable = value;
            return this;
        }

        /**
         * The reason OpenSSL is unavailable.
         * <p>
         * API name: {@code ssl_openssl_non_available_cause}
         * </p>
         */
        @Nonnull
        public final Builder sslOpensslNonAvailableCause(@Nullable String value) {
            this.sslOpensslNonAvailableCause = value;
            return this;
        }

        /**
         * Whether the hostname validation is supported.
         * <p>
         * API name: {@code ssl_openssl_supports_hostname_validation}
         * </p>
         */
        @Nonnull
        public final Builder sslOpensslSupportsHostnameValidation(@Nullable Boolean value) {
            this.sslOpensslSupportsHostnameValidation = value;
            return this;
        }

        /**
         * Whether <code>KMF</code> is supported.
         * <p>
         * API name: {@code ssl_openssl_supports_key_manager_factory}
         * </p>
         */
        @Nonnull
        public final Builder sslOpensslSupportsKeyManagerFactory(@Nullable Boolean value) {
            this.sslOpensslSupportsKeyManagerFactory = value;
            return this;
        }

        /**
         * Version of OpenSSL.
         * <p>
         * API name: {@code ssl_openssl_version}
         * </p>
         */
        @Nonnull
        public final Builder sslOpensslVersion(@Nullable String value) {
            this.sslOpensslVersion = value;
            return this;
        }

        /**
         * The full version string for the OpenSSL version.
         * <p>
         * API name: {@code ssl_openssl_version_string}
         * </p>
         */
        @Nonnull
        public final Builder sslOpensslVersionString(@Nullable String value) {
            this.sslOpensslVersionString = value;
            return this;
        }

        /**
         * The protocol for this SSL setup.
         * <p>
         * API name: {@code ssl_protocol}
         * </p>
         */
        @Nonnull
        public final Builder sslProtocol(@Nullable String value) {
            this.sslProtocol = value;
            return this;
        }

        /**
         * Returns the HTTP provider's name.
         * <p>
         * API name: {@code ssl_provider_http}
         * </p>
         */
        @Nonnull
        public final Builder sslProviderHttp(@Nullable String value) {
            this.sslProviderHttp = value;
            return this;
        }

        /**
         * Required - Returns the transport client's name.
         * <p>
         * API name: {@code ssl_provider_transport_client}
         * </p>
         */
        @Nonnull
        public final Builder sslProviderTransportClient(String value) {
            this.sslProviderTransportClient = value;
            return this;
        }

        /**
         * Required - Returns the transport server's name.
         * <p>
         * API name: {@code ssl_provider_transport_server}
         * </p>
         */
        @Nonnull
        public final Builder sslProviderTransportServer(String value) {
            this.sslProviderTransportServer = value;
            return this;
        }

        /**
         * Builds a {@link GetSslinfoResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetSslinfoResponse build() {
            _checkSingleUse();

            return new GetSslinfoResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GetSslinfoResponse}
     */
    public static final JsonpDeserializer<GetSslinfoResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GetSslinfoResponse::setupGetSslinfoResponseDeserializer
    );

    protected static void setupGetSslinfoResponseDeserializer(ObjectDeserializer<GetSslinfoResponse.Builder> op) {
        op.add(
            Builder::localCertificatesList,
            JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()),
            "local_certificates_list"
        );
        op.add(Builder::peerCertificates, JsonpDeserializer.stringDeserializer(), "peer_certificates");
        op.add(
            Builder::peerCertificatesList,
            JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()),
            "peer_certificates_list"
        );
        op.add(Builder::principal, JsonpDeserializer.stringDeserializer(), "principal");
        op.add(Builder::sslCipher, JsonpDeserializer.stringDeserializer(), "ssl_cipher");
        op.add(Builder::sslOpensslAvailable, JsonpDeserializer.booleanDeserializer(), "ssl_openssl_available");
        op.add(Builder::sslOpensslNonAvailableCause, JsonpDeserializer.stringDeserializer(), "ssl_openssl_non_available_cause");
        op.add(
            Builder::sslOpensslSupportsHostnameValidation,
            JsonpDeserializer.booleanDeserializer(),
            "ssl_openssl_supports_hostname_validation"
        );
        op.add(
            Builder::sslOpensslSupportsKeyManagerFactory,
            JsonpDeserializer.booleanDeserializer(),
            "ssl_openssl_supports_key_manager_factory"
        );
        op.add(Builder::sslOpensslVersion, JsonpDeserializer.stringDeserializer(), "ssl_openssl_version");
        op.add(Builder::sslOpensslVersionString, JsonpDeserializer.stringDeserializer(), "ssl_openssl_version_string");
        op.add(Builder::sslProtocol, JsonpDeserializer.stringDeserializer(), "ssl_protocol");
        op.add(Builder::sslProviderHttp, JsonpDeserializer.stringDeserializer(), "ssl_provider_http");
        op.add(Builder::sslProviderTransportClient, JsonpDeserializer.stringDeserializer(), "ssl_provider_transport_client");
        op.add(Builder::sslProviderTransportServer, JsonpDeserializer.stringDeserializer(), "ssl_provider_transport_server");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.localCertificatesList);
        result = 31 * result + this.peerCertificates.hashCode();
        result = 31 * result + Objects.hashCode(this.peerCertificatesList);
        result = 31 * result + Objects.hashCode(this.principal);
        result = 31 * result + Objects.hashCode(this.sslCipher);
        result = 31 * result + Objects.hashCode(this.sslOpensslAvailable);
        result = 31 * result + Objects.hashCode(this.sslOpensslNonAvailableCause);
        result = 31 * result + Objects.hashCode(this.sslOpensslSupportsHostnameValidation);
        result = 31 * result + Objects.hashCode(this.sslOpensslSupportsKeyManagerFactory);
        result = 31 * result + Objects.hashCode(this.sslOpensslVersion);
        result = 31 * result + Objects.hashCode(this.sslOpensslVersionString);
        result = 31 * result + Objects.hashCode(this.sslProtocol);
        result = 31 * result + Objects.hashCode(this.sslProviderHttp);
        result = 31 * result + this.sslProviderTransportClient.hashCode();
        result = 31 * result + this.sslProviderTransportServer.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetSslinfoResponse other = (GetSslinfoResponse) o;
        return Objects.equals(this.localCertificatesList, other.localCertificatesList)
            && this.peerCertificates.equals(other.peerCertificates)
            && Objects.equals(this.peerCertificatesList, other.peerCertificatesList)
            && Objects.equals(this.principal, other.principal)
            && Objects.equals(this.sslCipher, other.sslCipher)
            && Objects.equals(this.sslOpensslAvailable, other.sslOpensslAvailable)
            && Objects.equals(this.sslOpensslNonAvailableCause, other.sslOpensslNonAvailableCause)
            && Objects.equals(this.sslOpensslSupportsHostnameValidation, other.sslOpensslSupportsHostnameValidation)
            && Objects.equals(this.sslOpensslSupportsKeyManagerFactory, other.sslOpensslSupportsKeyManagerFactory)
            && Objects.equals(this.sslOpensslVersion, other.sslOpensslVersion)
            && Objects.equals(this.sslOpensslVersionString, other.sslOpensslVersionString)
            && Objects.equals(this.sslProtocol, other.sslProtocol)
            && Objects.equals(this.sslProviderHttp, other.sslProviderHttp)
            && this.sslProviderTransportClient.equals(other.sslProviderTransportClient)
            && this.sslProviderTransportServer.equals(other.sslProviderTransportServer);
    }
}
