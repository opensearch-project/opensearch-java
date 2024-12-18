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

package org.opensearch.client.opensearch.indices;

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

// typedef: indices.update_aliases.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class UpdateAliasesResponse extends AcknowledgedResponseBase
    implements
        ToCopyableBuilder<UpdateAliasesResponse.Builder, UpdateAliasesResponse> {

    // ---------------------------------------------------------------------------------------------

    private UpdateAliasesResponse(Builder builder) {
        super(builder);
    }

    public static UpdateAliasesResponse of(Function<UpdateAliasesResponse.Builder, ObjectBuilder<UpdateAliasesResponse>> fn) {
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
     * Builder for {@link UpdateAliasesResponse}.
     */
    public static class Builder extends AcknowledgedResponseBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, UpdateAliasesResponse> {

        public Builder() {}

        private Builder(UpdateAliasesResponse o) {
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
         * Builds a {@link UpdateAliasesResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public UpdateAliasesResponse build() {
            _checkSingleUse();

            return new UpdateAliasesResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link UpdateAliasesResponse}
     */
    public static final JsonpDeserializer<UpdateAliasesResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        UpdateAliasesResponse::setupUpdateAliasesResponseDeserializer
    );

    protected static void setupUpdateAliasesResponseDeserializer(ObjectDeserializer<UpdateAliasesResponse.Builder> op) {
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