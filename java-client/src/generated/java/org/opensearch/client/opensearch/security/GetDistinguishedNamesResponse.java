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

import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.transport.endpoints.DictionaryResponse;
import org.opensearch.client.util.ObjectBuilder;

// typedef: security.get_distinguished_names.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GetDistinguishedNamesResponse extends DictionaryResponse<String, DistinguishedNames> {
    // ---------------------------------------------------------------------------------------------

    private GetDistinguishedNamesResponse(Builder builder) {
        super(builder);
    }

    public static GetDistinguishedNamesResponse of(
        Function<GetDistinguishedNamesResponse.Builder, ObjectBuilder<GetDistinguishedNamesResponse>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link GetDistinguishedNamesResponse}.
     */
    public static class Builder extends DictionaryResponse.AbstractBuilder<String, DistinguishedNames, Builder>
        implements
            ObjectBuilder<GetDistinguishedNamesResponse> {
        @Override
        @Nonnull
        protected Builder self() {
            return this;
        }

        /**
         * Builds a {@link GetDistinguishedNamesResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public GetDistinguishedNamesResponse build() {
            _checkSingleUse();
            super.tKeySerializer(null);
            super.tValueSerializer(null);

            return new GetDistinguishedNamesResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GetDistinguishedNamesResponse}
     */
    public static final JsonpDeserializer<GetDistinguishedNamesResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GetDistinguishedNamesResponse::setupGetDistinguishedNamesResponseDeserializer
    );

    protected static void setupGetDistinguishedNamesResponseDeserializer(ObjectDeserializer<GetDistinguishedNamesResponse.Builder> op) {
        setupDictionaryResponseDeserializer(op, JsonpDeserializer.stringDeserializer(), DistinguishedNames._DESERIALIZER);
    }
}
