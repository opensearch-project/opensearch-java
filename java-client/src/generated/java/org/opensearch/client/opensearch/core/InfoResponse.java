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

package org.opensearch.client.opensearch.core;

import jakarta.json.stream.JsonGenerator;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.opensearch._types.OpenSearchVersionInfo;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: info.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class InfoResponse implements PlainJsonSerializable, ToCopyableBuilder<InfoResponse.Builder, InfoResponse> {

    @Nonnull
    private final String clusterName;

    @Nonnull
    private final String clusterUuid;

    @Nonnull
    private final String name;

    @Nonnull
    private final String tagline;

    @Nonnull
    private final OpenSearchVersionInfo version;

    // ---------------------------------------------------------------------------------------------

    private InfoResponse(Builder builder) {
        this.clusterName = ApiTypeHelper.requireNonNull(builder.clusterName, this, "clusterName");
        this.clusterUuid = ApiTypeHelper.requireNonNull(builder.clusterUuid, this, "clusterUuid");
        this.name = ApiTypeHelper.requireNonNull(builder.name, this, "name");
        this.tagline = ApiTypeHelper.requireNonNull(builder.tagline, this, "tagline");
        this.version = ApiTypeHelper.requireNonNull(builder.version, this, "version");
    }

    public static InfoResponse of(Function<InfoResponse.Builder, ObjectBuilder<InfoResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code cluster_name}
     */
    @Nonnull
    public final String clusterName() {
        return this.clusterName;
    }

    /**
     * Required - API name: {@code cluster_uuid}
     */
    @Nonnull
    public final String clusterUuid() {
        return this.clusterUuid;
    }

    /**
     * Required - API name: {@code name}
     */
    @Nonnull
    public final String name() {
        return this.name;
    }

    /**
     * Required - API name: {@code tagline}
     */
    @Nonnull
    public final String tagline() {
        return this.tagline;
    }

    /**
     * Required - API name: {@code version}
     */
    @Nonnull
    public final OpenSearchVersionInfo version() {
        return this.version;
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
        generator.writeKey("cluster_name");
        generator.write(this.clusterName);

        generator.writeKey("cluster_uuid");
        generator.write(this.clusterUuid);

        generator.writeKey("name");
        generator.write(this.name);

        generator.writeKey("tagline");
        generator.write(this.tagline);

        generator.writeKey("version");
        this.version.serialize(generator, mapper);
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
     * Builder for {@link InfoResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, InfoResponse> {
        private String clusterName;
        private String clusterUuid;
        private String name;
        private String tagline;
        private OpenSearchVersionInfo version;

        public Builder() {}

        private Builder(InfoResponse o) {
            this.clusterName = o.clusterName;
            this.clusterUuid = o.clusterUuid;
            this.name = o.name;
            this.tagline = o.tagline;
            this.version = o.version;
        }

        private Builder(Builder o) {
            this.clusterName = o.clusterName;
            this.clusterUuid = o.clusterUuid;
            this.name = o.name;
            this.tagline = o.tagline;
            this.version = o.version;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code cluster_name}
         */
        @Nonnull
        public final Builder clusterName(String value) {
            this.clusterName = value;
            return this;
        }

        /**
         * Required - API name: {@code cluster_uuid}
         */
        @Nonnull
        public final Builder clusterUuid(String value) {
            this.clusterUuid = value;
            return this;
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
         * Required - API name: {@code tagline}
         */
        @Nonnull
        public final Builder tagline(String value) {
            this.tagline = value;
            return this;
        }

        /**
         * Required - API name: {@code version}
         */
        @Nonnull
        public final Builder version(OpenSearchVersionInfo value) {
            this.version = value;
            return this;
        }

        /**
         * Required - API name: {@code version}
         */
        @Nonnull
        public final Builder version(Function<OpenSearchVersionInfo.Builder, ObjectBuilder<OpenSearchVersionInfo>> fn) {
            return version(fn.apply(new OpenSearchVersionInfo.Builder()).build());
        }

        /**
         * Builds a {@link InfoResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public InfoResponse build() {
            _checkSingleUse();

            return new InfoResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link InfoResponse}
     */
    public static final JsonpDeserializer<InfoResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        InfoResponse::setupInfoResponseDeserializer
    );

    protected static void setupInfoResponseDeserializer(ObjectDeserializer<InfoResponse.Builder> op) {
        op.add(Builder::clusterName, JsonpDeserializer.stringDeserializer(), "cluster_name");
        op.add(Builder::clusterUuid, JsonpDeserializer.stringDeserializer(), "cluster_uuid");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
        op.add(Builder::tagline, JsonpDeserializer.stringDeserializer(), "tagline");
        op.add(Builder::version, OpenSearchVersionInfo._DESERIALIZER, "version");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.clusterName.hashCode();
        result = 31 * result + this.clusterUuid.hashCode();
        result = 31 * result + this.name.hashCode();
        result = 31 * result + this.tagline.hashCode();
        result = 31 * result + this.version.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        InfoResponse other = (InfoResponse) o;
        return this.clusterName.equals(other.clusterName)
            && this.clusterUuid.equals(other.clusterUuid)
            && this.name.equals(other.name)
            && this.tagline.equals(other.tagline)
            && this.version.equals(other.version);
    }
}
