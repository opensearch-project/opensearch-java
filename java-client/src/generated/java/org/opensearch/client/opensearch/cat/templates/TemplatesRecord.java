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

package org.opensearch.client.opensearch.cat.templates;

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

// typedef: cat.templates.TemplatesRecord

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class TemplatesRecord implements PlainJsonSerializable, ToCopyableBuilder<TemplatesRecord.Builder, TemplatesRecord> {

    @Nullable
    private final String composedOf;

    @Nullable
    private final String indexPatterns;

    @Nullable
    private final String name;

    @Nullable
    private final String order;

    @Nullable
    private final String version;

    // ---------------------------------------------------------------------------------------------

    private TemplatesRecord(Builder builder) {
        this.composedOf = builder.composedOf;
        this.indexPatterns = builder.indexPatterns;
        this.name = builder.name;
        this.order = builder.order;
        this.version = builder.version;
    }

    public static TemplatesRecord of(Function<TemplatesRecord.Builder, ObjectBuilder<TemplatesRecord>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The component templates that comprise the index template.
     * <p>
     * API name: {@code composed_of}
     * </p>
     */
    @Nullable
    public final String composedOf() {
        return this.composedOf;
    }

    /**
     * The template index patterns.
     * <p>
     * API name: {@code index_patterns}
     * </p>
     */
    @Nullable
    public final String indexPatterns() {
        return this.indexPatterns;
    }

    /**
     * API name: {@code name}
     */
    @Nullable
    public final String name() {
        return this.name;
    }

    /**
     * The template application order or priority number.
     * <p>
     * API name: {@code order}
     * </p>
     */
    @Nullable
    public final String order() {
        return this.order;
    }

    /**
     * The template version.
     * <p>
     * API name: {@code version}
     * </p>
     */
    @Nullable
    public final String version() {
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
        if (this.composedOf != null) {
            generator.writeKey("composed_of");
            generator.write(this.composedOf);
        }

        if (this.indexPatterns != null) {
            generator.writeKey("index_patterns");
            generator.write(this.indexPatterns);
        }

        if (this.name != null) {
            generator.writeKey("name");
            generator.write(this.name);
        }

        if (this.order != null) {
            generator.writeKey("order");
            generator.write(this.order);
        }

        if (this.version != null) {
            generator.writeKey("version");
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
     * Builder for {@link TemplatesRecord}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, TemplatesRecord> {
        @Nullable
        private String composedOf;
        @Nullable
        private String indexPatterns;
        @Nullable
        private String name;
        @Nullable
        private String order;
        @Nullable
        private String version;

        public Builder() {}

        private Builder(TemplatesRecord o) {
            this.composedOf = o.composedOf;
            this.indexPatterns = o.indexPatterns;
            this.name = o.name;
            this.order = o.order;
            this.version = o.version;
        }

        private Builder(Builder o) {
            this.composedOf = o.composedOf;
            this.indexPatterns = o.indexPatterns;
            this.name = o.name;
            this.order = o.order;
            this.version = o.version;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The component templates that comprise the index template.
         * <p>
         * API name: {@code composed_of}
         * </p>
         */
        @Nonnull
        public final Builder composedOf(@Nullable String value) {
            this.composedOf = value;
            return this;
        }

        /**
         * The template index patterns.
         * <p>
         * API name: {@code index_patterns}
         * </p>
         */
        @Nonnull
        public final Builder indexPatterns(@Nullable String value) {
            this.indexPatterns = value;
            return this;
        }

        /**
         * API name: {@code name}
         */
        @Nonnull
        public final Builder name(@Nullable String value) {
            this.name = value;
            return this;
        }

        /**
         * The template application order or priority number.
         * <p>
         * API name: {@code order}
         * </p>
         */
        @Nonnull
        public final Builder order(@Nullable String value) {
            this.order = value;
            return this;
        }

        /**
         * The template version.
         * <p>
         * API name: {@code version}
         * </p>
         */
        @Nonnull
        public final Builder version(@Nullable String value) {
            this.version = value;
            return this;
        }

        /**
         * Builds a {@link TemplatesRecord}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public TemplatesRecord build() {
            _checkSingleUse();

            return new TemplatesRecord(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link TemplatesRecord}
     */
    public static final JsonpDeserializer<TemplatesRecord> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        TemplatesRecord::setupTemplatesRecordDeserializer
    );

    protected static void setupTemplatesRecordDeserializer(ObjectDeserializer<TemplatesRecord.Builder> op) {
        op.add(Builder::composedOf, JsonpDeserializer.stringDeserializer(), "composed_of");
        op.add(Builder::indexPatterns, JsonpDeserializer.stringDeserializer(), "index_patterns");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
        op.add(Builder::order, JsonpDeserializer.stringDeserializer(), "order");
        op.add(Builder::version, JsonpDeserializer.stringDeserializer(), "version");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.composedOf);
        result = 31 * result + Objects.hashCode(this.indexPatterns);
        result = 31 * result + Objects.hashCode(this.name);
        result = 31 * result + Objects.hashCode(this.order);
        result = 31 * result + Objects.hashCode(this.version);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        TemplatesRecord other = (TemplatesRecord) o;
        return Objects.equals(this.composedOf, other.composedOf)
            && Objects.equals(this.indexPatterns, other.indexPatterns)
            && Objects.equals(this.name, other.name)
            && Objects.equals(this.order, other.order)
            && Objects.equals(this.version, other.version);
    }
}
