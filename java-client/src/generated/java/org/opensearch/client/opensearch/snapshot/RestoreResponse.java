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

package org.opensearch.client.opensearch.snapshot;

import jakarta.json.stream.JsonGenerator;
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
import org.opensearch.client.opensearch.snapshot.restore.SnapshotRestore;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: snapshot.restore.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RestoreResponse implements PlainJsonSerializable, ToCopyableBuilder<RestoreResponse.Builder, RestoreResponse> {

    @Nullable
    private final Boolean accepted;

    @Nullable
    private final SnapshotRestore snapshot;

    // ---------------------------------------------------------------------------------------------

    private RestoreResponse(Builder builder) {
        this.accepted = builder.accepted;
        this.snapshot = builder.snapshot;
    }

    public static RestoreResponse of(Function<RestoreResponse.Builder, ObjectBuilder<RestoreResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Returns <code>true</code> if the restore was accepted. Present when the request had <code>wait_for_completion</code> set to
     * <code>false</code>.
     * <p>
     * API name: {@code accepted}
     * </p>
     */
    @Nullable
    public final Boolean accepted() {
        return this.accepted;
    }

    /**
     * API name: {@code snapshot}
     */
    @Nullable
    public final SnapshotRestore snapshot() {
        return this.snapshot;
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
        if (this.accepted != null) {
            generator.writeKey("accepted");
            generator.write(this.accepted);
        }

        if (this.snapshot != null) {
            generator.writeKey("snapshot");
            this.snapshot.serialize(generator, mapper);
        }
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
     * Builder for {@link RestoreResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, RestoreResponse> {
        @Nullable
        private Boolean accepted;
        @Nullable
        private SnapshotRestore snapshot;

        public Builder() {}

        private Builder(RestoreResponse o) {
            this.accepted = o.accepted;
            this.snapshot = o.snapshot;
        }

        private Builder(Builder o) {
            this.accepted = o.accepted;
            this.snapshot = o.snapshot;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Returns <code>true</code> if the restore was accepted. Present when the request had <code>wait_for_completion</code> set to
         * <code>false</code>.
         * <p>
         * API name: {@code accepted}
         * </p>
         */
        @Nonnull
        public final Builder accepted(@Nullable Boolean value) {
            this.accepted = value;
            return this;
        }

        /**
         * API name: {@code snapshot}
         */
        @Nonnull
        public final Builder snapshot(@Nullable SnapshotRestore value) {
            this.snapshot = value;
            return this;
        }

        /**
         * API name: {@code snapshot}
         */
        @Nonnull
        public final Builder snapshot(Function<SnapshotRestore.Builder, ObjectBuilder<SnapshotRestore>> fn) {
            return snapshot(fn.apply(new SnapshotRestore.Builder()).build());
        }

        /**
         * Builds a {@link RestoreResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RestoreResponse build() {
            _checkSingleUse();

            return new RestoreResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RestoreResponse}
     */
    public static final JsonpDeserializer<RestoreResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RestoreResponse::setupRestoreResponseDeserializer
    );

    protected static void setupRestoreResponseDeserializer(ObjectDeserializer<RestoreResponse.Builder> op) {
        op.add(Builder::accepted, JsonpDeserializer.booleanDeserializer(), "accepted");
        op.add(Builder::snapshot, SnapshotRestore._DESERIALIZER, "snapshot");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.accepted);
        result = 31 * result + Objects.hashCode(this.snapshot);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RestoreResponse other = (RestoreResponse) o;
        return Objects.equals(this.accepted, other.accepted) && Objects.equals(this.snapshot, other.snapshot);
    }
}
