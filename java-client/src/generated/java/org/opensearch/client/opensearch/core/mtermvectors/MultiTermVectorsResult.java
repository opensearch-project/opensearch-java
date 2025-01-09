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

package org.opensearch.client.opensearch.core.mtermvectors;

import jakarta.json.stream.JsonGenerator;
import java.util.Map;
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
import org.opensearch.client.opensearch._types.ErrorCause;
import org.opensearch.client.opensearch.core.termvectors.TermVector;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: core.mtermvectors.TermVectorsResult

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class MultiTermVectorsResult
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<MultiTermVectorsResult.Builder, MultiTermVectorsResult> {

    @Nullable
    private final ErrorCause error;

    @Nullable
    private final Boolean found;

    @Nonnull
    private final String id;

    @Nonnull
    private final String index;

    @Nonnull
    private final Map<String, TermVector> termVectors;

    @Nullable
    private final Long took;

    @Nullable
    private final Long version;

    // ---------------------------------------------------------------------------------------------

    private MultiTermVectorsResult(Builder builder) {
        this.error = builder.error;
        this.found = builder.found;
        this.id = ApiTypeHelper.requireNonNull(builder.id, this, "id");
        this.index = ApiTypeHelper.requireNonNull(builder.index, this, "index");
        this.termVectors = ApiTypeHelper.unmodifiable(builder.termVectors);
        this.took = builder.took;
        this.version = builder.version;
    }

    public static MultiTermVectorsResult of(Function<MultiTermVectorsResult.Builder, ObjectBuilder<MultiTermVectorsResult>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code error}
     */
    @Nullable
    public final ErrorCause error() {
        return this.error;
    }

    /**
     * API name: {@code found}
     */
    @Nullable
    public final Boolean found() {
        return this.found;
    }

    /**
     * Required - API name: {@code _id}
     */
    @Nonnull
    public final String id() {
        return this.id;
    }

    /**
     * Required - API name: {@code _index}
     */
    @Nonnull
    public final String index() {
        return this.index;
    }

    /**
     * API name: {@code term_vectors}
     */
    @Nonnull
    public final Map<String, TermVector> termVectors() {
        return this.termVectors;
    }

    /**
     * API name: {@code took}
     */
    @Nullable
    public final Long took() {
        return this.took;
    }

    /**
     * API name: {@code _version}
     */
    @Nullable
    public final Long version() {
        return this.version;
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
        if (this.error != null) {
            generator.writeKey("error");
            this.error.serialize(generator, mapper);
        }

        if (this.found != null) {
            generator.writeKey("found");
            generator.write(this.found);
        }

        generator.writeKey("_id");
        generator.write(this.id);

        generator.writeKey("_index");
        generator.write(this.index);

        if (ApiTypeHelper.isDefined(this.termVectors)) {
            generator.writeKey("term_vectors");
            generator.writeStartObject();
            for (Map.Entry<String, TermVector> item0 : this.termVectors.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.took != null) {
            generator.writeKey("took");
            generator.write(this.took);
        }

        if (this.version != null) {
            generator.writeKey("_version");
            generator.write(this.version);
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
     * Builder for {@link MultiTermVectorsResult}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, MultiTermVectorsResult> {
        @Nullable
        private ErrorCause error;
        @Nullable
        private Boolean found;
        private String id;
        private String index;
        @Nullable
        private Map<String, TermVector> termVectors;
        @Nullable
        private Long took;
        @Nullable
        private Long version;

        public Builder() {}

        private Builder(MultiTermVectorsResult o) {
            this.error = o.error;
            this.found = o.found;
            this.id = o.id;
            this.index = o.index;
            this.termVectors = _mapCopy(o.termVectors);
            this.took = o.took;
            this.version = o.version;
        }

        private Builder(Builder o) {
            this.error = o.error;
            this.found = o.found;
            this.id = o.id;
            this.index = o.index;
            this.termVectors = _mapCopy(o.termVectors);
            this.took = o.took;
            this.version = o.version;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code error}
         */
        @Nonnull
        public final Builder error(@Nullable ErrorCause value) {
            this.error = value;
            return this;
        }

        /**
         * API name: {@code error}
         */
        @Nonnull
        public final Builder error(Function<ErrorCause.Builder, ObjectBuilder<ErrorCause>> fn) {
            return error(fn.apply(new ErrorCause.Builder()).build());
        }

        /**
         * API name: {@code found}
         */
        @Nonnull
        public final Builder found(@Nullable Boolean value) {
            this.found = value;
            return this;
        }

        /**
         * Required - API name: {@code _id}
         */
        @Nonnull
        public final Builder id(String value) {
            this.id = value;
            return this;
        }

        /**
         * Required - API name: {@code _index}
         */
        @Nonnull
        public final Builder index(String value) {
            this.index = value;
            return this;
        }

        /**
         * API name: {@code term_vectors}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>termVectors</code>.
         * </p>
         */
        @Nonnull
        public final Builder termVectors(Map<String, TermVector> map) {
            this.termVectors = _mapPutAll(this.termVectors, map);
            return this;
        }

        /**
         * API name: {@code term_vectors}
         *
         * <p>
         * Adds an entry to <code>termVectors</code>.
         * </p>
         */
        @Nonnull
        public final Builder termVectors(String key, TermVector value) {
            this.termVectors = _mapPut(this.termVectors, key, value);
            return this;
        }

        /**
         * API name: {@code term_vectors}
         *
         * <p>
         * Adds a value to <code>termVectors</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder termVectors(String key, Function<TermVector.Builder, ObjectBuilder<TermVector>> fn) {
            return termVectors(key, fn.apply(new TermVector.Builder()).build());
        }

        /**
         * API name: {@code took}
         */
        @Nonnull
        public final Builder took(@Nullable Long value) {
            this.took = value;
            return this;
        }

        /**
         * API name: {@code _version}
         */
        @Nonnull
        public final Builder version(@Nullable Long value) {
            this.version = value;
            return this;
        }

        /**
         * Builds a {@link MultiTermVectorsResult}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public MultiTermVectorsResult build() {
            _checkSingleUse();

            return new MultiTermVectorsResult(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link MultiTermVectorsResult}
     */
    public static final JsonpDeserializer<MultiTermVectorsResult> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        MultiTermVectorsResult::setupMultiTermVectorsResultDeserializer
    );

    protected static void setupMultiTermVectorsResultDeserializer(ObjectDeserializer<MultiTermVectorsResult.Builder> op) {
        op.add(Builder::error, ErrorCause._DESERIALIZER, "error");
        op.add(Builder::found, JsonpDeserializer.booleanDeserializer(), "found");
        op.add(Builder::id, JsonpDeserializer.stringDeserializer(), "_id");
        op.add(Builder::index, JsonpDeserializer.stringDeserializer(), "_index");
        op.add(Builder::termVectors, JsonpDeserializer.stringMapDeserializer(TermVector._DESERIALIZER), "term_vectors");
        op.add(Builder::took, JsonpDeserializer.longDeserializer(), "took");
        op.add(Builder::version, JsonpDeserializer.longDeserializer(), "_version");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.error);
        result = 31 * result + Objects.hashCode(this.found);
        result = 31 * result + this.id.hashCode();
        result = 31 * result + this.index.hashCode();
        result = 31 * result + Objects.hashCode(this.termVectors);
        result = 31 * result + Objects.hashCode(this.took);
        result = 31 * result + Objects.hashCode(this.version);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        MultiTermVectorsResult other = (MultiTermVectorsResult) o;
        return Objects.equals(this.error, other.error)
            && Objects.equals(this.found, other.found)
            && this.id.equals(other.id)
            && this.index.equals(other.index)
            && Objects.equals(this.termVectors, other.termVectors)
            && Objects.equals(this.took, other.took)
            && Objects.equals(this.version, other.version);
    }
}
