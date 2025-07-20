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

package org.opensearch.client.opensearch.geospatial;

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

// typedef: geospatial.get_ip2geo_datasource.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GetIp2geoDatasourceResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<GetIp2geoDatasourceResponse.Builder, GetIp2geoDatasourceResponse> {

    @Nonnull
    private final List<DataSource> datasources;

    // ---------------------------------------------------------------------------------------------

    private GetIp2geoDatasourceResponse(Builder builder) {
        this.datasources = ApiTypeHelper.unmodifiableRequired(builder.datasources, this, "datasources");
    }

    public static GetIp2geoDatasourceResponse of(
        Function<GetIp2geoDatasourceResponse.Builder, ObjectBuilder<GetIp2geoDatasourceResponse>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code datasources}
     */
    @Nonnull
    public final List<DataSource> datasources() {
        return this.datasources;
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
        generator.writeKey("datasources");
        generator.writeStartArray();
        for (DataSource item0 : this.datasources) {
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
     * Builder for {@link GetIp2geoDatasourceResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, GetIp2geoDatasourceResponse> {
        private List<DataSource> datasources;

        public Builder() {}

        private Builder(GetIp2geoDatasourceResponse o) {
            this.datasources = _listCopy(o.datasources);
        }

        private Builder(Builder o) {
            this.datasources = _listCopy(o.datasources);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code datasources}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>datasources</code>.
         * </p>
         */
        @Nonnull
        public final Builder datasources(List<DataSource> list) {
            this.datasources = _listAddAll(this.datasources, list);
            return this;
        }

        /**
         * Required - API name: {@code datasources}
         *
         * <p>
         * Adds one or more values to <code>datasources</code>.
         * </p>
         */
        @Nonnull
        public final Builder datasources(DataSource value, DataSource... values) {
            this.datasources = _listAdd(this.datasources, value, values);
            return this;
        }

        /**
         * Required - API name: {@code datasources}
         *
         * <p>
         * Adds a value to <code>datasources</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder datasources(Function<DataSource.Builder, ObjectBuilder<DataSource>> fn) {
            return datasources(fn.apply(new DataSource.Builder()).build());
        }

        /**
         * Builds a {@link GetIp2geoDatasourceResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetIp2geoDatasourceResponse build() {
            _checkSingleUse();

            return new GetIp2geoDatasourceResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GetIp2geoDatasourceResponse}
     */
    public static final JsonpDeserializer<GetIp2geoDatasourceResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GetIp2geoDatasourceResponse::setupGetIp2geoDatasourceResponseDeserializer
    );

    protected static void setupGetIp2geoDatasourceResponseDeserializer(ObjectDeserializer<GetIp2geoDatasourceResponse.Builder> op) {
        op.add(Builder::datasources, JsonpDeserializer.arrayDeserializer(DataSource._DESERIALIZER), "datasources");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.datasources.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetIp2geoDatasourceResponse other = (GetIp2geoDatasourceResponse) o;
        return this.datasources.equals(other.datasources);
    }
}
