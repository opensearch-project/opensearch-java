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

package org.opensearch.client.opensearch._types.mapping;

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
import org.opensearch.client.json.PlainDeserializable;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.mapping.SourceField

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SourceField implements PlainJsonSerializable, ToCopyableBuilder<SourceField.Builder, SourceField> {

    @Nullable
    private final Boolean compress;

    @Nullable
    private final String compressThreshold;

    @Nullable
    private final Boolean enabled;

    @Nonnull
    private final List<String> excludes;

    @Nonnull
    private final List<String> includes;

    // ---------------------------------------------------------------------------------------------

    private SourceField(Builder builder) {
        this.compress = builder.compress;
        this.compressThreshold = builder.compressThreshold;
        this.enabled = builder.enabled;
        this.excludes = ApiTypeHelper.unmodifiable(builder.excludes);
        this.includes = ApiTypeHelper.unmodifiable(builder.includes);
    }

    public static SourceField of(Function<SourceField.Builder, ObjectBuilder<SourceField>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code compress}
     */
    @Nullable
    public final Boolean compress() {
        return this.compress;
    }

    /**
     * API name: {@code compress_threshold}
     */
    @Nullable
    public final String compressThreshold() {
        return this.compressThreshold;
    }

    /**
     * API name: {@code enabled}
     */
    @Nullable
    public final Boolean enabled() {
        return this.enabled;
    }

    /**
     * API name: {@code excludes}
     */
    @Nonnull
    public final List<String> excludes() {
        return this.excludes;
    }

    /**
     * API name: {@code includes}
     */
    @Nonnull
    public final List<String> includes() {
        return this.includes;
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
        if (this.compress != null) {
            generator.writeKey("compress");
            generator.write(this.compress);
        }

        if (this.compressThreshold != null) {
            generator.writeKey("compress_threshold");
            generator.write(this.compressThreshold);
        }

        if (this.enabled != null) {
            generator.writeKey("enabled");
            generator.write(this.enabled);
        }

        if (ApiTypeHelper.isDefined(this.excludes)) {
            generator.writeKey("excludes");
            generator.writeStartArray();
            for (String item0 : this.excludes) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.includes)) {
            generator.writeKey("includes");
            generator.writeStartArray();
            for (String item0 : this.includes) {
                generator.write(item0);
            }
            generator.writeEnd();
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
     * Builder for {@link SourceField}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, SourceField>, PlainDeserializable<Builder> {
        @Nullable
        private Boolean compress;
        @Nullable
        private String compressThreshold;
        @Nullable
        private Boolean enabled;
        @Nullable
        private List<String> excludes;
        @Nullable
        private List<String> includes;

        public Builder() {}

        private Builder(SourceField o) {
            this.compress = o.compress;
            this.compressThreshold = o.compressThreshold;
            this.enabled = o.enabled;
            this.excludes = _listCopy(o.excludes);
            this.includes = _listCopy(o.includes);
        }

        private Builder(Builder o) {
            this.compress = o.compress;
            this.compressThreshold = o.compressThreshold;
            this.enabled = o.enabled;
            this.excludes = _listCopy(o.excludes);
            this.includes = _listCopy(o.includes);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        @Override
        @Nonnull
        public Builder self() {
            return this;
        }

        /**
         * API name: {@code compress}
         */
        @Nonnull
        public final Builder compress(@Nullable Boolean value) {
            this.compress = value;
            return this;
        }

        /**
         * API name: {@code compress_threshold}
         */
        @Nonnull
        public final Builder compressThreshold(@Nullable String value) {
            this.compressThreshold = value;
            return this;
        }

        /**
         * API name: {@code enabled}
         */
        @Nonnull
        public final Builder enabled(@Nullable Boolean value) {
            this.enabled = value;
            return this;
        }

        /**
         * API name: {@code excludes}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>excludes</code>.
         * </p>
         */
        @Nonnull
        public final Builder excludes(List<String> list) {
            this.excludes = _listAddAll(this.excludes, list);
            return this;
        }

        /**
         * API name: {@code excludes}
         *
         * <p>
         * Adds one or more values to <code>excludes</code>.
         * </p>
         */
        @Nonnull
        public final Builder excludes(String value, String... values) {
            this.excludes = _listAdd(this.excludes, value, values);
            return this;
        }

        /**
         * API name: {@code includes}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>includes</code>.
         * </p>
         */
        @Nonnull
        public final Builder includes(List<String> list) {
            this.includes = _listAddAll(this.includes, list);
            return this;
        }

        /**
         * API name: {@code includes}
         *
         * <p>
         * Adds one or more values to <code>includes</code>.
         * </p>
         */
        @Nonnull
        public final Builder includes(String value, String... values) {
            this.includes = _listAdd(this.includes, value, values);
            return this;
        }

        /**
         * Builds a {@link SourceField}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SourceField build() {
            _checkSingleUse();

            return new SourceField(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SourceField}
     */
    public static final JsonpDeserializer<SourceField> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SourceField::setupSourceFieldDeserializer
    );

    protected static void setupSourceFieldDeserializer(ObjectDeserializer<SourceField.Builder> op) {
        op.add(Builder::compress, JsonpDeserializer.booleanDeserializer(), "compress");
        op.add(Builder::compressThreshold, JsonpDeserializer.stringDeserializer(), "compress_threshold");
        op.add(Builder::enabled, JsonpDeserializer.booleanDeserializer(), "enabled");
        op.add(Builder::excludes, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "excludes");
        op.add(Builder::includes, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "includes");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.compress);
        result = 31 * result + Objects.hashCode(this.compressThreshold);
        result = 31 * result + Objects.hashCode(this.enabled);
        result = 31 * result + Objects.hashCode(this.excludes);
        result = 31 * result + Objects.hashCode(this.includes);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SourceField other = (SourceField) o;
        return Objects.equals(this.compress, other.compress)
            && Objects.equals(this.compressThreshold, other.compressThreshold)
            && Objects.equals(this.enabled, other.enabled)
            && Objects.equals(this.excludes, other.excludes)
            && Objects.equals(this.includes, other.includes);
    }
}
