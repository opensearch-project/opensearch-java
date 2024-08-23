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

package org.opensearch.client.opensearch.ml;

import java.util.function.Function;
import javax.annotation.Generated;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: ml.delete_model_group.Request

/**
 * Deletes a model group.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class DeleteModelGroupRequest extends RequestBase {

    private final String modelGroupId;

    // ---------------------------------------------------------------------------------------------

    private DeleteModelGroupRequest(Builder builder) {
        this.modelGroupId = ApiTypeHelper.requireNonNull(builder.modelGroupId, this, "modelGroupId");
    }

    public static DeleteModelGroupRequest of(Function<DeleteModelGroupRequest.Builder, ObjectBuilder<DeleteModelGroupRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code model_group_id}
     */
    public final String modelGroupId() {
        return this.modelGroupId;
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link DeleteModelGroupRequest}.
     */
    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<DeleteModelGroupRequest> {
        private String modelGroupId;

        /**
         * Required - API name: {@code model_group_id}
         */
        public final Builder modelGroupId(String value) {
            this.modelGroupId = value;
            return this;
        }

        /**
         * Builds a {@link DeleteModelGroupRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public DeleteModelGroupRequest build() {
            _checkSingleUse();

            return new DeleteModelGroupRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code ml.delete_model_group}".
     */
    public static final Endpoint<DeleteModelGroupRequest, DeleteModelGroupResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "DELETE",
        // Request path
        request -> {
            StringBuilder buf = new StringBuilder();
            buf.append("/_plugins/_ml/model_groups/");
            SimpleEndpoint.pathEncode(request.modelGroupId, buf);
            return buf.toString();
        },
        // Request parameters
        SimpleEndpoint.emptyMap(),
        SimpleEndpoint.emptyMap(),
        false,
        DeleteModelGroupResponse._DESERIALIZER
    );
}
