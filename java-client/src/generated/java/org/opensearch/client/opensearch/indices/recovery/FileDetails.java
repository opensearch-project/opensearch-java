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

package org.opensearch.client.opensearch.indices.recovery;

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

// typedef: indices.recovery.FileDetails

/**
 * The details of a recovered file.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class FileDetails implements PlainJsonSerializable, ToCopyableBuilder<FileDetails.Builder, FileDetails> {

    private final long length;

    @Nonnull
    private final String name;

    private final long recovered;

    // ---------------------------------------------------------------------------------------------

    private FileDetails(Builder builder) {
        this.length = ApiTypeHelper.requireNonNull(builder.length, this, "length");
        this.name = ApiTypeHelper.requireNonNull(builder.name, this, "name");
        this.recovered = ApiTypeHelper.requireNonNull(builder.recovered, this, "recovered");
    }

    public static FileDetails of(Function<FileDetails.Builder, ObjectBuilder<FileDetails>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The length of the file in bytes.
     * <p>
     * API name: {@code length}
     * </p>
     */
    public final long length() {
        return this.length;
    }

    /**
     * Required - The name of the file.
     * <p>
     * API name: {@code name}
     * </p>
     */
    @Nonnull
    public final String name() {
        return this.name;
    }

    /**
     * Required - The number of bytes recovered.
     * <p>
     * API name: {@code recovered}
     * </p>
     */
    public final long recovered() {
        return this.recovered;
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
        generator.writeKey("length");
        generator.write(this.length);

        generator.writeKey("name");
        generator.write(this.name);

        generator.writeKey("recovered");
        generator.write(this.recovered);
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
     * Builder for {@link FileDetails}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, FileDetails> {
        private Long length;
        private String name;
        private Long recovered;

        public Builder() {}

        private Builder(FileDetails o) {
            this.length = o.length;
            this.name = o.name;
            this.recovered = o.recovered;
        }

        private Builder(Builder o) {
            this.length = o.length;
            this.name = o.name;
            this.recovered = o.recovered;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - The length of the file in bytes.
         * <p>
         * API name: {@code length}
         * </p>
         */
        @Nonnull
        public final Builder length(long value) {
            this.length = value;
            return this;
        }

        /**
         * Required - The name of the file.
         * <p>
         * API name: {@code name}
         * </p>
         */
        @Nonnull
        public final Builder name(String value) {
            this.name = value;
            return this;
        }

        /**
         * Required - The number of bytes recovered.
         * <p>
         * API name: {@code recovered}
         * </p>
         */
        @Nonnull
        public final Builder recovered(long value) {
            this.recovered = value;
            return this;
        }

        /**
         * Builds a {@link FileDetails}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public FileDetails build() {
            _checkSingleUse();

            return new FileDetails(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link FileDetails}
     */
    public static final JsonpDeserializer<FileDetails> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        FileDetails::setupFileDetailsDeserializer
    );

    protected static void setupFileDetailsDeserializer(ObjectDeserializer<FileDetails.Builder> op) {
        op.add(Builder::length, JsonpDeserializer.longDeserializer(), "length");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
        op.add(Builder::recovered, JsonpDeserializer.longDeserializer(), "recovered");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Long.hashCode(this.length);
        result = 31 * result + this.name.hashCode();
        result = 31 * result + Long.hashCode(this.recovered);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        FileDetails other = (FileDetails) o;
        return this.length == other.length && this.name.equals(other.name) && this.recovered == other.recovered;
    }
}
