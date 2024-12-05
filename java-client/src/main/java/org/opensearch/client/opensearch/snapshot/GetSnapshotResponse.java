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
import java.util.Collections;
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
import org.opensearch.client.opensearch.snapshot.get.SnapshotResponseItem;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: snapshot.get.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GetSnapshotResponse implements PlainJsonSerializable {

    @Nonnull
    private final List<SnapshotInfo> snapshots;

    // ---------------------------------------------------------------------------------------------

    private GetSnapshotResponse(Builder builder) {
        this.snapshots = ApiTypeHelper.unmodifiableRequired(builder.snapshots, this, "snapshots");
    }

    public static GetSnapshotResponse of(Function<GetSnapshotResponse.Builder, ObjectBuilder<GetSnapshotResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * This method is left for compatibility. Always returns an empty list.
     */
    @Deprecated
    public final List<SnapshotResponseItem> responses() {
        return Collections.emptyList();
    }

    /**
     * Required - API name: {@code snapshots}
     */
    @Nonnull
    public final List<SnapshotInfo> snapshots() {
        return this.snapshots;
    }

    /**
     * * This method is left for compatibility.
     * <p>
     * API name: {@code total}
     */
    @Deprecated
    public final int total() {
        return this.snapshots.size();
    }

    /**
     * This method is left for compatibility. Always returns 0.
     * <p>
     * API name: {@code remaining}
     */
    @Deprecated
    public final int remaining() {
        return 0;
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
        generator.writeKey("snapshots");
        generator.writeStartArray();
        for (SnapshotInfo item0 : this.snapshots) {
            item0.serialize(generator, mapper);
        }
        generator.writeEnd();
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link GetSnapshotResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<GetSnapshotResponse> {
        private List<SnapshotInfo> snapshots;

        /**
         * Required - API name: {@code snapshots}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>snapshots</code>.
         * </p>
         */
        @Nonnull
        public final Builder snapshots(List<SnapshotInfo> list) {
            this.snapshots = _listAddAll(this.snapshots, list);
            return this;
        }

        /**
         * Required - API name: {@code snapshots}
         *
         * <p>
         * Adds one or more values to <code>snapshots</code>.
         * </p>
         */
        @Nonnull
        public final Builder snapshots(SnapshotInfo value, SnapshotInfo... values) {
            this.snapshots = _listAdd(this.snapshots, value, values);
            return this;
        }

        /**
         * Required - API name: {@code snapshots}
         *
         * <p>
         * Adds a value to <code>snapshots</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder snapshots(Function<SnapshotInfo.Builder, ObjectBuilder<SnapshotInfo>> fn) {
            return snapshots(fn.apply(new SnapshotInfo.Builder()).build());
        }

        /**
         * Builds a {@link GetSnapshotResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetSnapshotResponse build() {
            _checkSingleUse();

            return new GetSnapshotResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GetSnapshotResponse}
     */
    public static final JsonpDeserializer<GetSnapshotResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GetSnapshotResponse::setupGetSnapshotResponseDeserializer
    );

    protected static void setupGetSnapshotResponseDeserializer(ObjectDeserializer<GetSnapshotResponse.Builder> op) {
        op.add(Builder::snapshots, JsonpDeserializer.arrayDeserializer(SnapshotInfo._DESERIALIZER), "snapshots");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.snapshots.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetSnapshotResponse other = (GetSnapshotResponse) o;
        return this.snapshots.equals(other.snapshots);
    }
}
