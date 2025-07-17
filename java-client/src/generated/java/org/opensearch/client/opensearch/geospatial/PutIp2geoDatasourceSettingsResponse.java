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

import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.opensearch._types.AcknowledgedResponseBase;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: geospatial.put_ip2geo_datasource_settings.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class PutIp2geoDatasourceSettingsResponse extends AcknowledgedResponseBase
    implements
        ToCopyableBuilder<PutIp2geoDatasourceSettingsResponse.Builder, PutIp2geoDatasourceSettingsResponse> {

    // ---------------------------------------------------------------------------------------------

    private PutIp2geoDatasourceSettingsResponse(Builder builder) {
        super(builder);
    }

    public static PutIp2geoDatasourceSettingsResponse of(
        Function<PutIp2geoDatasourceSettingsResponse.Builder, ObjectBuilder<PutIp2geoDatasourceSettingsResponse>> fn
    ) {
        return fn.apply(new Builder()).build();
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
     * Builder for {@link PutIp2geoDatasourceSettingsResponse}.
     */
    public static class Builder extends AcknowledgedResponseBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, PutIp2geoDatasourceSettingsResponse> {

        public Builder() {}

        private Builder(PutIp2geoDatasourceSettingsResponse o) {
            super(o);
        }

        private Builder(Builder o) {
            super(o);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        @Override
        @Nonnull
        protected Builder self() {
            return this;
        }

        /**
         * Builds a {@link PutIp2geoDatasourceSettingsResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PutIp2geoDatasourceSettingsResponse build() {
            _checkSingleUse();

            return new PutIp2geoDatasourceSettingsResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PutIp2geoDatasourceSettingsResponse}
     */
    public static final JsonpDeserializer<PutIp2geoDatasourceSettingsResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PutIp2geoDatasourceSettingsResponse::setupPutIp2geoDatasourceSettingsResponseDeserializer
    );

    protected static void setupPutIp2geoDatasourceSettingsResponseDeserializer(
        ObjectDeserializer<PutIp2geoDatasourceSettingsResponse.Builder> op
    ) {
        setupAcknowledgedResponseBaseDeserializer(op);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        return true;
    }
}
