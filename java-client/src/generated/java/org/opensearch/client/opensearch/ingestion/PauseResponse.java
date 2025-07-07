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

package org.opensearch.client.opensearch.ingestion;

import jakarta.json.stream.JsonGenerator;
import java.util.List;
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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ingestion.pause.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class PauseResponse implements PlainJsonSerializable, ToCopyableBuilder<PauseResponse.Builder, PauseResponse> {

    private final boolean acknowledged;

    @Nullable
    private final String error;

    @Nonnull
    private final List<IngestionStateShardFailure> failures;

    private final boolean shardsAcknowledged;

    // ---------------------------------------------------------------------------------------------

    private PauseResponse(Builder builder) {
        this.acknowledged = ApiTypeHelper.requireNonNull(builder.acknowledged, this, "acknowledged");
        this.error = builder.error;
        this.failures = ApiTypeHelper.unmodifiable(builder.failures);
        this.shardsAcknowledged = ApiTypeHelper.requireNonNull(builder.shardsAcknowledged, this, "shardsAcknowledged");
    }

    public static PauseResponse of(Function<PauseResponse.Builder, ObjectBuilder<PauseResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - Indicates if the pause request has been acknowledged.
     * <p>
     * API name: {@code acknowledged}
     * </p>
     */
    public final boolean acknowledged() {
        return this.acknowledged;
    }

    /**
     * API name: {@code error}
     */
    @Nullable
    public final String error() {
        return this.error;
    }

    /**
     * API name: {@code failures}
     */
    @Nonnull
    public final List<IngestionStateShardFailure> failures() {
        return this.failures;
    }

    /**
     * Required - Indicates if the pause request has been acknowledged by individual shards.
     * <p>
     * API name: {@code shards_acknowledged}
     * </p>
     */
    public final boolean shardsAcknowledged() {
        return this.shardsAcknowledged;
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
        generator.writeKey("acknowledged");
        generator.write(this.acknowledged);

        if (this.error != null) {
            generator.writeKey("error");
            generator.write(this.error);
        }

        if (ApiTypeHelper.isDefined(this.failures)) {
            generator.writeKey("failures");
            generator.writeStartArray();
            for (IngestionStateShardFailure item0 : this.failures) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        generator.writeKey("shards_acknowledged");
        generator.write(this.shardsAcknowledged);
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
     * Builder for {@link PauseResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, PauseResponse> {
        private Boolean acknowledged;
        @Nullable
        private String error;
        @Nullable
        private List<IngestionStateShardFailure> failures;
        private Boolean shardsAcknowledged;

        public Builder() {}

        private Builder(PauseResponse o) {
            this.acknowledged = o.acknowledged;
            this.error = o.error;
            this.failures = _listCopy(o.failures);
            this.shardsAcknowledged = o.shardsAcknowledged;
        }

        private Builder(Builder o) {
            this.acknowledged = o.acknowledged;
            this.error = o.error;
            this.failures = _listCopy(o.failures);
            this.shardsAcknowledged = o.shardsAcknowledged;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - Indicates if the pause request has been acknowledged.
         * <p>
         * API name: {@code acknowledged}
         * </p>
         */
        @Nonnull
        public final Builder acknowledged(boolean value) {
            this.acknowledged = value;
            return this;
        }

        /**
         * API name: {@code error}
         */
        @Nonnull
        public final Builder error(@Nullable String value) {
            this.error = value;
            return this;
        }

        /**
         * API name: {@code failures}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>failures</code>.
         * </p>
         */
        @Nonnull
        public final Builder failures(List<IngestionStateShardFailure> list) {
            this.failures = _listAddAll(this.failures, list);
            return this;
        }

        /**
         * API name: {@code failures}
         *
         * <p>
         * Adds one or more values to <code>failures</code>.
         * </p>
         */
        @Nonnull
        public final Builder failures(IngestionStateShardFailure value, IngestionStateShardFailure... values) {
            this.failures = _listAdd(this.failures, value, values);
            return this;
        }

        /**
         * API name: {@code failures}
         *
         * <p>
         * Adds a value to <code>failures</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder failures(Function<IngestionStateShardFailure.Builder, ObjectBuilder<IngestionStateShardFailure>> fn) {
            return failures(fn.apply(new IngestionStateShardFailure.Builder()).build());
        }

        /**
         * Required - Indicates if the pause request has been acknowledged by individual shards.
         * <p>
         * API name: {@code shards_acknowledged}
         * </p>
         */
        @Nonnull
        public final Builder shardsAcknowledged(boolean value) {
            this.shardsAcknowledged = value;
            return this;
        }

        /**
         * Builds a {@link PauseResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PauseResponse build() {
            _checkSingleUse();

            return new PauseResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PauseResponse}
     */
    public static final JsonpDeserializer<PauseResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PauseResponse::setupPauseResponseDeserializer
    );

    protected static void setupPauseResponseDeserializer(ObjectDeserializer<PauseResponse.Builder> op) {
        op.add(Builder::acknowledged, JsonpDeserializer.booleanDeserializer(), "acknowledged");
        op.add(Builder::error, JsonpDeserializer.stringDeserializer(), "error");
        op.add(Builder::failures, JsonpDeserializer.arrayDeserializer(IngestionStateShardFailure._DESERIALIZER), "failures");
        op.add(Builder::shardsAcknowledged, JsonpDeserializer.booleanDeserializer(), "shards_acknowledged");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Boolean.hashCode(this.acknowledged);
        result = 31 * result + Objects.hashCode(this.error);
        result = 31 * result + Objects.hashCode(this.failures);
        result = 31 * result + Boolean.hashCode(this.shardsAcknowledged);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PauseResponse other = (PauseResponse) o;
        return this.acknowledged == other.acknowledged
            && Objects.equals(this.error, other.error)
            && Objects.equals(this.failures, other.failures)
            && this.shardsAcknowledged == other.shardsAcknowledged;
    }
}
