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

package org.opensearch.client.opensearch.cat.master;

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

// typedef: cat.master.MasterRecord

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class MasterRecord implements PlainJsonSerializable, ToCopyableBuilder<MasterRecord.Builder, MasterRecord> {

    @Nullable
    private final String host;

    @Nullable
    private final String id;

    @Nullable
    private final String ip;

    @Nullable
    private final String node;

    // ---------------------------------------------------------------------------------------------

    private MasterRecord(Builder builder) {
        this.host = builder.host;
        this.id = builder.id;
        this.ip = builder.ip;
        this.node = builder.node;
    }

    public static MasterRecord of(Function<MasterRecord.Builder, ObjectBuilder<MasterRecord>> fn) {
        return fn.apply(new Builder()).build();
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
     * Serialize this object to JSON.
     */
    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
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
     * Builder for {@link MasterRecord}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, MasterRecord> {
        @Nullable
        private String host;
        @Nullable
        private String id;
        @Nullable
        private String ip;
        @Nullable
        private String node;

        public Builder() {}

        private Builder(MasterRecord o) {
            this.host = o.host;
            this.id = o.id;
            this.ip = o.ip;
            this.node = o.node;
        }

        private Builder(Builder o) {
            this.host = o.host;
            this.id = o.id;
            this.ip = o.ip;
            this.node = o.node;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
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
         * Builds a {@link MasterRecord}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public MasterRecord build() {
            _checkSingleUse();

            return new MasterRecord(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link MasterRecord}
     */
    public static final JsonpDeserializer<MasterRecord> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        MasterRecord::setupMasterRecordDeserializer
    );

    protected static void setupMasterRecordDeserializer(ObjectDeserializer<MasterRecord.Builder> op) {
        op.add(Builder::host, JsonpDeserializer.stringDeserializer(), "host");
        op.add(Builder::id, JsonpDeserializer.stringDeserializer(), "id");
        op.add(Builder::ip, JsonpDeserializer.stringDeserializer(), "ip");
        op.add(Builder::node, JsonpDeserializer.stringDeserializer(), "node");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.host);
        result = 31 * result + Objects.hashCode(this.id);
        result = 31 * result + Objects.hashCode(this.ip);
        result = 31 * result + Objects.hashCode(this.node);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        MasterRecord other = (MasterRecord) o;
        return Objects.equals(this.host, other.host)
            && Objects.equals(this.id, other.id)
            && Objects.equals(this.ip, other.ip)
            && Objects.equals(this.node, other.node);
    }
}
