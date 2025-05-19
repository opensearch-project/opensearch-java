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

package org.opensearch.client.opensearch.core.pit;

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
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: core.pit.PitDetail

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class PitDetail implements PlainJsonSerializable, ToCopyableBuilder<PitDetail.Builder, PitDetail> {

    @Nullable
    private final Long creationTime;

    @Nullable
    private final Long keepAlive;

    @Nullable
    private final String pitId;

    // ---------------------------------------------------------------------------------------------

    private PitDetail(Builder builder) {
        this.creationTime = builder.creationTime;
        this.keepAlive = builder.keepAlive;
        this.pitId = builder.pitId;
    }

    public static PitDetail of(Function<PitDetail.Builder, ObjectBuilder<PitDetail>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code creation_time}
     */
    @Nullable
    public final Long creationTime() {
        return this.creationTime;
    }

    /**
     * API name: {@code keep_alive}
     */
    @Nullable
    public final Long keepAlive() {
        return this.keepAlive;
    }

    /**
     * API name: {@code pit_id}
     */
    @Nullable
    public final String pitId() {
        return this.pitId;
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
        if (this.creationTime != null) {
            generator.writeKey("creation_time");
            generator.write(this.creationTime);
        }

        if (this.keepAlive != null) {
            generator.writeKey("keep_alive");
            generator.write(this.keepAlive);
        }

        if (this.pitId != null) {
            generator.writeKey("pit_id");
            generator.write(this.pitId);
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
     * Builder for {@link PitDetail}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, PitDetail> {
        @Nullable
        private Long creationTime;
        @Nullable
        private Long keepAlive;
        @Nullable
        private String pitId;

        public Builder() {}

        private Builder(PitDetail o) {
            this.creationTime = o.creationTime;
            this.keepAlive = o.keepAlive;
            this.pitId = o.pitId;
        }

        private Builder(Builder o) {
            this.creationTime = o.creationTime;
            this.keepAlive = o.keepAlive;
            this.pitId = o.pitId;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code creation_time}
         */
        @Nonnull
        public final Builder creationTime(@Nullable Long value) {
            this.creationTime = value;
            return this;
        }

        /**
         * API name: {@code keep_alive}
         */
        @Nonnull
        public final Builder keepAlive(@Nullable Long value) {
            this.keepAlive = value;
            return this;
        }

        /**
         * API name: {@code pit_id}
         */
        @Nonnull
        public final Builder pitId(@Nullable String value) {
            this.pitId = value;
            return this;
        }

        /**
         * Builds a {@link PitDetail}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PitDetail build() {
            _checkSingleUse();

            return new PitDetail(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PitDetail}
     */
    public static final JsonpDeserializer<PitDetail> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PitDetail::setupPitDetailDeserializer
    );

    protected static void setupPitDetailDeserializer(ObjectDeserializer<PitDetail.Builder> op) {
        op.add(Builder::creationTime, JsonpDeserializer.longDeserializer(), "creation_time");
        op.add(Builder::keepAlive, JsonpDeserializer.longDeserializer(), "keep_alive");
        op.add(Builder::pitId, JsonpDeserializer.stringDeserializer(), "pit_id");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.creationTime);
        result = 31 * result + Objects.hashCode(this.keepAlive);
        result = 31 * result + Objects.hashCode(this.pitId);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PitDetail other = (PitDetail) o;
        return Objects.equals(this.creationTime, other.creationTime)
            && Objects.equals(this.keepAlive, other.keepAlive)
            && Objects.equals(this.pitId, other.pitId);
    }
}
