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

package org.opensearch.client.opensearch.cat.fielddata;

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

// typedef: cat.fielddata.FielddataRecord

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class FielddataRecord implements PlainJsonSerializable, ToCopyableBuilder<FielddataRecord.Builder, FielddataRecord> {

    @Nullable
    private final String field;

    @Nullable
    private final String host;

    @Nullable
    private final String id;

    @Nullable
    private final String ip;

    @Nullable
    private final String node;

    @Nullable
    private final String size;

    // ---------------------------------------------------------------------------------------------

    private FielddataRecord(Builder builder) {
        this.field = builder.field;
        this.host = builder.host;
        this.id = builder.id;
        this.ip = builder.ip;
        this.node = builder.node;
        this.size = builder.size;
    }

    public static FielddataRecord of(Function<FielddataRecord.Builder, ObjectBuilder<FielddataRecord>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * field name
     * <p>
     * API name: {@code field}
     * </p>
     */
    @Nullable
    public final String field() {
        return this.field;
    }

    /**
     * hostname
     * <p>
     * API name: {@code host}
     * </p>
     */
    @Nullable
    public final String host() {
        return this.host;
    }

    /**
     * node id
     * <p>
     * API name: {@code id}
     * </p>
     */
    @Nullable
    public final String id() {
        return this.id;
    }

    /**
     * IP address
     * <p>
     * API name: {@code ip}
     * </p>
     */
    @Nullable
    public final String ip() {
        return this.ip;
    }

    /**
     * node name
     * <p>
     * API name: {@code node}
     * </p>
     */
    @Nullable
    public final String node() {
        return this.node;
    }

    /**
     * field data usage
     * <p>
     * API name: {@code size}
     * </p>
     */
    @Nullable
    public final String size() {
        return this.size;
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
        if (this.field != null) {
            generator.writeKey("field");
            generator.write(this.field);
        }

        if (this.host != null) {
            generator.writeKey("host");
            generator.write(this.host);
        }

        if (this.id != null) {
            generator.writeKey("id");
            generator.write(this.id);
        }

        if (this.ip != null) {
            generator.writeKey("ip");
            generator.write(this.ip);
        }

        if (this.node != null) {
            generator.writeKey("node");
            generator.write(this.node);
        }

        if (this.size != null) {
            generator.writeKey("size");
            generator.write(this.size);
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
     * Builder for {@link FielddataRecord}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, FielddataRecord> {
        @Nullable
        private String field;
        @Nullable
        private String host;
        @Nullable
        private String id;
        @Nullable
        private String ip;
        @Nullable
        private String node;
        @Nullable
        private String size;

        public Builder() {}

        private Builder(FielddataRecord o) {
            this.field = o.field;
            this.host = o.host;
            this.id = o.id;
            this.ip = o.ip;
            this.node = o.node;
            this.size = o.size;
        }

        private Builder(Builder o) {
            this.field = o.field;
            this.host = o.host;
            this.id = o.id;
            this.ip = o.ip;
            this.node = o.node;
            this.size = o.size;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * field name
         * <p>
         * API name: {@code field}
         * </p>
         */
        @Nonnull
        public final Builder field(@Nullable String value) {
            this.field = value;
            return this;
        }

        /**
         * hostname
         * <p>
         * API name: {@code host}
         * </p>
         */
        @Nonnull
        public final Builder host(@Nullable String value) {
            this.host = value;
            return this;
        }

        /**
         * node id
         * <p>
         * API name: {@code id}
         * </p>
         */
        @Nonnull
        public final Builder id(@Nullable String value) {
            this.id = value;
            return this;
        }

        /**
         * IP address
         * <p>
         * API name: {@code ip}
         * </p>
         */
        @Nonnull
        public final Builder ip(@Nullable String value) {
            this.ip = value;
            return this;
        }

        /**
         * node name
         * <p>
         * API name: {@code node}
         * </p>
         */
        @Nonnull
        public final Builder node(@Nullable String value) {
            this.node = value;
            return this;
        }

        /**
         * field data usage
         * <p>
         * API name: {@code size}
         * </p>
         */
        @Nonnull
        public final Builder size(@Nullable String value) {
            this.size = value;
            return this;
        }

        /**
         * Builds a {@link FielddataRecord}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public FielddataRecord build() {
            _checkSingleUse();

            return new FielddataRecord(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link FielddataRecord}
     */
    public static final JsonpDeserializer<FielddataRecord> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        FielddataRecord::setupFielddataRecordDeserializer
    );

    protected static void setupFielddataRecordDeserializer(ObjectDeserializer<FielddataRecord.Builder> op) {
        op.add(Builder::field, JsonpDeserializer.stringDeserializer(), "field");
        op.add(Builder::host, JsonpDeserializer.stringDeserializer(), "host");
        op.add(Builder::id, JsonpDeserializer.stringDeserializer(), "id");
        op.add(Builder::ip, JsonpDeserializer.stringDeserializer(), "ip");
        op.add(Builder::node, JsonpDeserializer.stringDeserializer(), "node");
        op.add(Builder::size, JsonpDeserializer.stringDeserializer(), "size");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.field);
        result = 31 * result + Objects.hashCode(this.host);
        result = 31 * result + Objects.hashCode(this.id);
        result = 31 * result + Objects.hashCode(this.ip);
        result = 31 * result + Objects.hashCode(this.node);
        result = 31 * result + Objects.hashCode(this.size);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        FielddataRecord other = (FielddataRecord) o;
        return Objects.equals(this.field, other.field)
            && Objects.equals(this.host, other.host)
            && Objects.equals(this.id, other.id)
            && Objects.equals(this.ip, other.ip)
            && Objects.equals(this.node, other.node)
            && Objects.equals(this.size, other.size);
    }
}
