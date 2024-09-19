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

package org.opensearch.client.opensearch.dangling_indices;

import java.util.function.Function;
import javax.annotation.Generated;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.opensearch._types.AcknowledgedResponseBase;
import org.opensearch.client.util.ObjectBuilder;

// typedef: dangling_indices.delete_dangling_index.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class DeleteDanglingIndexResponse extends AcknowledgedResponseBase {

    // ---------------------------------------------------------------------------------------------

    private DeleteDanglingIndexResponse(Builder builder) {
        super(builder);
    }

    public static DeleteDanglingIndexResponse of(
        Function<DeleteDanglingIndexResponse.Builder, ObjectBuilder<DeleteDanglingIndexResponse>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link DeleteDanglingIndexResponse}.
     */
    public static class Builder extends AcknowledgedResponseBase.AbstractBuilder<Builder>
        implements
            ObjectBuilder<DeleteDanglingIndexResponse> {
        @Override
        protected Builder self() {
            return this;
        }

        /**
         * Builds a {@link DeleteDanglingIndexResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public DeleteDanglingIndexResponse build() {
            _checkSingleUse();

            return new DeleteDanglingIndexResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link DeleteDanglingIndexResponse}
     */
    public static final JsonpDeserializer<DeleteDanglingIndexResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        DeleteDanglingIndexResponse::setupDeleteDanglingIndexResponseDeserializer
    );

    protected static void setupDeleteDanglingIndexResponseDeserializer(ObjectDeserializer<DeleteDanglingIndexResponse.Builder> op) {
        AcknowledgedResponseBase.setupAcknowledgedResponseBaseDeserializer(op);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode());
    }

    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (this.getClass() != o.getClass()) return false;
        DeleteDanglingIndexResponse other = (DeleteDanglingIndexResponse) o;
        return true;
    }
}
