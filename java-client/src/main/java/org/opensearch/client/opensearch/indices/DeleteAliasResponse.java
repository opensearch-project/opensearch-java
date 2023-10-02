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

package org.opensearch.client.opensearch.indices;

import java.util.function.Function;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.opensearch._types.AcknowledgedResponseBase;
import org.opensearch.client.util.ObjectBuilder;

// typedef: indices.delete_alias.Response

@JsonpDeserializable
public class DeleteAliasResponse extends AcknowledgedResponseBase {
    // ---------------------------------------------------------------------------------------------

    private DeleteAliasResponse(Builder builder) {
        super(builder);

    }

    public static DeleteAliasResponse of(Function<Builder, ObjectBuilder<DeleteAliasResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link DeleteAliasResponse}.
     */

    public static class Builder extends AcknowledgedResponseBase.AbstractBuilder<Builder> implements ObjectBuilder<DeleteAliasResponse> {
        @Override
        protected Builder self() {
            return this;
        }

        /**
         * Builds a {@link DeleteAliasResponse}.
         *
         * @throws NullPointerException
         *             if some of the required fields are null.
         */
        public DeleteAliasResponse build() {
            _checkSingleUse();

            return new DeleteAliasResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link DeleteAliasResponse}
     */
    public static final JsonpDeserializer<DeleteAliasResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        DeleteAliasResponse::setupDeleteAliasResponseDeserializer
    );

    protected static void setupDeleteAliasResponseDeserializer(ObjectDeserializer<DeleteAliasResponse.Builder> op) {
        AcknowledgedResponseBase.setupAcknowledgedResponseBaseDeserializer(op);

    }

}
