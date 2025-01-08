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

package org.opensearch.client.opensearch.cat.count;

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

// typedef: cat.count.CountRecord

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class CountRecord implements PlainJsonSerializable, ToCopyableBuilder<CountRecord.Builder, CountRecord> {

    @Nullable
    private final String count;

    @Nullable
    private final String epoch;

    @Nullable
    private final String timestamp;

    // ---------------------------------------------------------------------------------------------

    private CountRecord(Builder builder) {
        this.count = builder.count;
        this.epoch = builder.epoch;
        this.timestamp = builder.timestamp;
    }

    public static CountRecord of(Function<CountRecord.Builder, ObjectBuilder<CountRecord>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * the document count
     * <p>
     * API name: {@code count}
     * </p>
     */
    @Nullable
    public final String count() {
        return this.count;
    }

    /**
     * API name: {@code epoch}
     */
    @Nullable
    public final String epoch() {
        return this.epoch;
    }

    /**
     * API name: {@code timestamp}
     */
    @Nullable
    public final String timestamp() {
        return this.timestamp;
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
        if (this.count != null) {
            generator.writeKey("count");
            generator.write(this.count);
        }

        if (this.epoch != null) {
            generator.writeKey("epoch");
            generator.write(this.epoch);
        }

        if (this.timestamp != null) {
            generator.writeKey("timestamp");
            generator.write(this.timestamp);
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
     * Builder for {@link CountRecord}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, CountRecord> {
        @Nullable
        private String count;
        @Nullable
        private String epoch;
        @Nullable
        private String timestamp;

        public Builder() {}

        private Builder(CountRecord o) {
            this.count = o.count;
            this.epoch = o.epoch;
            this.timestamp = o.timestamp;
        }

        private Builder(Builder o) {
            this.count = o.count;
            this.epoch = o.epoch;
            this.timestamp = o.timestamp;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * the document count
         * <p>
         * API name: {@code count}
         * </p>
         */
        @Nonnull
        public final Builder count(@Nullable String value) {
            this.count = value;
            return this;
        }

        /**
         * API name: {@code epoch}
         */
        @Nonnull
        public final Builder epoch(@Nullable String value) {
            this.epoch = value;
            return this;
        }

        /**
         * API name: {@code timestamp}
         */
        @Nonnull
        public final Builder timestamp(@Nullable String value) {
            this.timestamp = value;
            return this;
        }

        /**
         * Builds a {@link CountRecord}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public CountRecord build() {
            _checkSingleUse();

            return new CountRecord(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link CountRecord}
     */
    public static final JsonpDeserializer<CountRecord> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CountRecord::setupCountRecordDeserializer
    );

    protected static void setupCountRecordDeserializer(ObjectDeserializer<CountRecord.Builder> op) {
        op.add(Builder::count, JsonpDeserializer.stringDeserializer(), "count");
        op.add(Builder::epoch, JsonpDeserializer.stringDeserializer(), "epoch");
        op.add(Builder::timestamp, JsonpDeserializer.stringDeserializer(), "timestamp");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.count);
        result = 31 * result + Objects.hashCode(this.epoch);
        result = 31 * result + Objects.hashCode(this.timestamp);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CountRecord other = (CountRecord) o;
        return Objects.equals(this.count, other.count)
            && Objects.equals(this.epoch, other.epoch)
            && Objects.equals(this.timestamp, other.timestamp);
    }
}
