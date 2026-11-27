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

package org.opensearch.client.opensearch.ism;

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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ism.ActionSnapshot

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ActionSnapshot implements PlainJsonSerializable, ToCopyableBuilder<ActionSnapshot.Builder, ActionSnapshot> {

    @Nonnull
    private final String repository;

    @Nonnull
    private final String snapshot;

    // ---------------------------------------------------------------------------------------------

    private ActionSnapshot(Builder builder) {
        this.repository = ApiTypeHelper.requireNonNull(builder.repository, this, "repository");
        this.snapshot = ApiTypeHelper.requireNonNull(builder.snapshot, this, "snapshot");
    }

    public static ActionSnapshot of(Function<ActionSnapshot.Builder, ObjectBuilder<ActionSnapshot>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The repository to store the snapshot.
     * <p>
     * API name: {@code repository}
     * </p>
     */
    @Nonnull
    public final String repository() {
        return this.repository;
    }

    /**
     * Required - The name of the snapshot.
     * <p>
     * API name: {@code snapshot}
     * </p>
     */
    @Nonnull
    public final String snapshot() {
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
        generator.writeKey("repository");
        generator.write(this.repository);

        generator.writeKey("snapshot");
        generator.write(this.snapshot);
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
     * Builder for {@link ActionSnapshot}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ActionSnapshot> {
        private String repository;
        private String snapshot;

        public Builder() {}

        private Builder(ActionSnapshot o) {
            this.repository = o.repository;
            this.snapshot = o.snapshot;
        }

        private Builder(Builder o) {
            this.repository = o.repository;
            this.snapshot = o.snapshot;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - The repository to store the snapshot.
         * <p>
         * API name: {@code repository}
         * </p>
         */
        @Nonnull
        public final Builder repository(String value) {
            this.repository = value;
            return this;
        }

        /**
         * Required - The name of the snapshot.
         * <p>
         * API name: {@code snapshot}
         * </p>
         */
        @Nonnull
        public final Builder snapshot(String value) {
            this.snapshot = value;
            return this;
        }

        /**
         * Builds a {@link ActionSnapshot}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ActionSnapshot build() {
            _checkSingleUse();

            return new ActionSnapshot(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ActionSnapshot}
     */
    public static final JsonpDeserializer<ActionSnapshot> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ActionSnapshot::setupActionSnapshotDeserializer
    );

    protected static void setupActionSnapshotDeserializer(ObjectDeserializer<ActionSnapshot.Builder> op) {
        op.add(Builder::repository, JsonpDeserializer.stringDeserializer(), "repository");
        op.add(Builder::snapshot, JsonpDeserializer.stringDeserializer(), "snapshot");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.repository.hashCode();
        result = 31 * result + this.snapshot.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ActionSnapshot other = (ActionSnapshot) o;
        return this.repository.equals(other.repository) && this.snapshot.equals(other.snapshot);
    }
}
