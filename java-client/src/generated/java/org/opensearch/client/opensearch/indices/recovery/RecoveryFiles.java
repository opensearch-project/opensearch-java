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

// typedef: indices.recovery.RecoveryFiles

/**
 * The file-level recovery statistics.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RecoveryFiles implements PlainJsonSerializable, ToCopyableBuilder<RecoveryFiles.Builder, RecoveryFiles> {

    @Nonnull
    private final List<FileDetails> details;

    @Nonnull
    private final String percent;

    private final long recovered;

    private final long reused;

    private final long total;

    // ---------------------------------------------------------------------------------------------

    private RecoveryFiles(Builder builder) {
        this.details = ApiTypeHelper.unmodifiable(builder.details);
        this.percent = ApiTypeHelper.requireNonNull(builder.percent, this, "percent");
        this.recovered = ApiTypeHelper.requireNonNull(builder.recovered, this, "recovered");
        this.reused = ApiTypeHelper.requireNonNull(builder.reused, this, "reused");
        this.total = ApiTypeHelper.requireNonNull(builder.total, this, "total");
    }

    public static RecoveryFiles of(Function<RecoveryFiles.Builder, ObjectBuilder<RecoveryFiles>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The detailed information about recovered files.
     * <p>
     * API name: {@code details}
     * </p>
     */
    @Nonnull
    public final List<FileDetails> details() {
        return this.details;
    }

    /**
     * Required - API name: {@code percent}
     */
    @Nonnull
    public final String percent() {
        return this.percent;
    }

    /**
     * Required - The number of recovered files.
     * <p>
     * API name: {@code recovered}
     * </p>
     */
    public final long recovered() {
        return this.recovered;
    }

    /**
     * Required - The number of reused files.
     * <p>
     * API name: {@code reused}
     * </p>
     */
    public final long reused() {
        return this.reused;
    }

    /**
     * Required - The total number of files.
     * <p>
     * API name: {@code total}
     * </p>
     */
    public final long total() {
        return this.total;
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
        if (ApiTypeHelper.isDefined(this.details)) {
            generator.writeKey("details");
            generator.writeStartArray();
            for (FileDetails item0 : this.details) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        generator.writeKey("percent");
        generator.write(this.percent);

        generator.writeKey("recovered");
        generator.write(this.recovered);

        generator.writeKey("reused");
        generator.write(this.reused);

        generator.writeKey("total");
        generator.write(this.total);
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
     * Builder for {@link RecoveryFiles}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, RecoveryFiles> {
        @Nullable
        private List<FileDetails> details;
        private String percent;
        private Long recovered;
        private Long reused;
        private Long total;

        public Builder() {}

        private Builder(RecoveryFiles o) {
            this.details = _listCopy(o.details);
            this.percent = o.percent;
            this.recovered = o.recovered;
            this.reused = o.reused;
            this.total = o.total;
        }

        private Builder(Builder o) {
            this.details = _listCopy(o.details);
            this.percent = o.percent;
            this.recovered = o.recovered;
            this.reused = o.reused;
            this.total = o.total;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The detailed information about recovered files.
         * <p>
         * API name: {@code details}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>details</code>.
         * </p>
         */
        @Nonnull
        public final Builder details(List<FileDetails> list) {
            this.details = _listAddAll(this.details, list);
            return this;
        }

        /**
         * The detailed information about recovered files.
         * <p>
         * API name: {@code details}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>details</code>.
         * </p>
         */
        @Nonnull
        public final Builder details(FileDetails value, FileDetails... values) {
            this.details = _listAdd(this.details, value, values);
            return this;
        }

        /**
         * The detailed information about recovered files.
         * <p>
         * API name: {@code details}
         * </p>
         *
         * <p>
         * Adds a value to <code>details</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder details(Function<FileDetails.Builder, ObjectBuilder<FileDetails>> fn) {
            return details(fn.apply(new FileDetails.Builder()).build());
        }

        /**
         * Required - API name: {@code percent}
         */
        @Nonnull
        public final Builder percent(String value) {
            this.percent = value;
            return this;
        }

        /**
         * Required - The number of recovered files.
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
         * Required - The number of reused files.
         * <p>
         * API name: {@code reused}
         * </p>
         */
        @Nonnull
        public final Builder reused(long value) {
            this.reused = value;
            return this;
        }

        /**
         * Required - The total number of files.
         * <p>
         * API name: {@code total}
         * </p>
         */
        @Nonnull
        public final Builder total(long value) {
            this.total = value;
            return this;
        }

        /**
         * Builds a {@link RecoveryFiles}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RecoveryFiles build() {
            _checkSingleUse();

            return new RecoveryFiles(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RecoveryFiles}
     */
    public static final JsonpDeserializer<RecoveryFiles> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RecoveryFiles::setupRecoveryFilesDeserializer
    );

    protected static void setupRecoveryFilesDeserializer(ObjectDeserializer<RecoveryFiles.Builder> op) {
        op.add(Builder::details, JsonpDeserializer.arrayDeserializer(FileDetails._DESERIALIZER), "details");
        op.add(Builder::percent, JsonpDeserializer.stringDeserializer(), "percent");
        op.add(Builder::recovered, JsonpDeserializer.longDeserializer(), "recovered");
        op.add(Builder::reused, JsonpDeserializer.longDeserializer(), "reused");
        op.add(Builder::total, JsonpDeserializer.longDeserializer(), "total");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.details);
        result = 31 * result + this.percent.hashCode();
        result = 31 * result + Long.hashCode(this.recovered);
        result = 31 * result + Long.hashCode(this.reused);
        result = 31 * result + Long.hashCode(this.total);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RecoveryFiles other = (RecoveryFiles) o;
        return Objects.equals(this.details, other.details)
            && this.percent.equals(other.percent)
            && this.recovered == other.recovered
            && this.reused == other.reused
            && this.total == other.total;
    }
}
