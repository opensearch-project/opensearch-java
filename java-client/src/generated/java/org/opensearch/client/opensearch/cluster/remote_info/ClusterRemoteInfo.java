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

package org.opensearch.client.opensearch.cluster.remote_info;

import jakarta.json.stream.JsonGenerator;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.json.JsonEnum;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.TaggedUnion;
import org.opensearch.client.util.TaggedUnionUtils;

// typedef: cluster.remote_info.ClusterRemoteInfo

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ClusterRemoteInfo implements TaggedUnion<ClusterRemoteInfo.Kind, ClusterRemoteInfoVariant>, PlainJsonSerializable {
    /**
     * {@link ClusterRemoteInfo} variant kinds.
     */
    public enum Kind implements JsonEnum {
        Proxy("proxy"),
        Sniff("sniff");

        private final String jsonValue;

        Kind(String jsonValue) {
            this.jsonValue = jsonValue;
        }

        @Override
        public String jsonValue() {
            return jsonValue;
        }
    }

    private final Kind _kind;
    private final ClusterRemoteInfoVariant _value;

    @Override
    public final Kind _kind() {
        return _kind;
    }

    @Override
    public final ClusterRemoteInfoVariant _get() {
        return _value;
    }

    public ClusterRemoteInfo(ClusterRemoteInfoVariant value) {
        this._kind = ApiTypeHelper.requireNonNull(value._clusterRemoteInfoKind(), this, "<variant kind>");
        this._value = ApiTypeHelper.requireNonNull(value, this, "<variant value>");
    }

    private ClusterRemoteInfo(Builder builder) {
        this._kind = ApiTypeHelper.requireNonNull(builder._kind, builder, "<variant kind>");
        this._value = ApiTypeHelper.requireNonNull(builder._value, builder, "<variant value>");
    }

    public static ClusterRemoteInfo of(Function<ClusterRemoteInfo.Builder, ObjectBuilder<ClusterRemoteInfo>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Is this variant instance of kind {@code proxy}?
     */
    public boolean isProxy() {
        return _kind == Kind.Proxy;
    }

    /**
     * Get the {@code proxy} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code proxy} kind.
     */
    public ClusterRemoteProxyInfo proxy() {
        return TaggedUnionUtils.get(this, Kind.Proxy);
    }

    /**
     * Is this variant instance of kind {@code sniff}?
     */
    public boolean isSniff() {
        return _kind == Kind.Sniff;
    }

    /**
     * Get the {@code sniff} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code sniff} kind.
     */
    public ClusterRemoteSniffInfo sniff() {
        return TaggedUnionUtils.get(this, Kind.Sniff);
    }

    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        mapper.serialize(_value, generator);
    }

    @Nonnull
    public Builder toBuilder() {
        return new Builder(this);
    }

    @Nonnull
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<ClusterRemoteInfo> {
        private Kind _kind;
        private ClusterRemoteInfoVariant _value;

        public Builder() {}

        private Builder(ClusterRemoteInfo o) {
            this._kind = o._kind;
            this._value = o._value;
        }

        public ObjectBuilder<ClusterRemoteInfo> proxy(ClusterRemoteProxyInfo v) {
            this._kind = Kind.Proxy;
            this._value = v;
            return this;
        }

        public ObjectBuilder<ClusterRemoteInfo> proxy(Function<ClusterRemoteProxyInfo.Builder, ObjectBuilder<ClusterRemoteProxyInfo>> fn) {
            return this.proxy(fn.apply(new ClusterRemoteProxyInfo.Builder()).build());
        }

        public ObjectBuilder<ClusterRemoteInfo> sniff(ClusterRemoteSniffInfo v) {
            this._kind = Kind.Sniff;
            this._value = v;
            return this;
        }

        public ObjectBuilder<ClusterRemoteInfo> sniff(Function<ClusterRemoteSniffInfo.Builder, ObjectBuilder<ClusterRemoteSniffInfo>> fn) {
            return this.sniff(fn.apply(new ClusterRemoteSniffInfo.Builder()).build());
        }

        @Override
        public ClusterRemoteInfo build() {
            _checkSingleUse();
            return new ClusterRemoteInfo(this);
        }
    }

    protected static void setupClusterRemoteInfoDeserializer(ObjectDeserializer<Builder> op) {
        op.add(Builder::proxy, ClusterRemoteProxyInfo._DESERIALIZER, "proxy");
        op.add(Builder::sniff, ClusterRemoteSniffInfo._DESERIALIZER, "sniff");
        op.setTypeProperty("mode", null);
    }

    public static final JsonpDeserializer<ClusterRemoteInfo> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ClusterRemoteInfo::setupClusterRemoteInfoDeserializer,
        Builder::build
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this._kind);
        result = 31 * result + Objects.hashCode(this._value);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ClusterRemoteInfo other = (ClusterRemoteInfo) o;
        return Objects.equals(this._kind, other._kind) && Objects.equals(this._value, other._value);
    }
}
