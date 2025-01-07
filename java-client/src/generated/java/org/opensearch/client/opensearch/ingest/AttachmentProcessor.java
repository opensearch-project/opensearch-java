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

package org.opensearch.client.opensearch.ingest;

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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ingest.AttachmentProcessor

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class AttachmentProcessor extends ProcessorBase
    implements
        ProcessorVariant,
        ToCopyableBuilder<AttachmentProcessor.Builder, AttachmentProcessor> {

    @Nonnull
    private final String field;

    @Nullable
    private final Boolean ignoreMissing;

    @Nullable
    private final Long indexedChars;

    @Nullable
    private final String indexedCharsField;

    @Nonnull
    private final List<String> properties;

    @Nullable
    private final String resourceName;

    @Nullable
    private final String targetField;

    // ---------------------------------------------------------------------------------------------

    private AttachmentProcessor(Builder builder) {
        super(builder);
        this.field = ApiTypeHelper.requireNonNull(builder.field, this, "field");
        this.ignoreMissing = builder.ignoreMissing;
        this.indexedChars = builder.indexedChars;
        this.indexedCharsField = builder.indexedCharsField;
        this.properties = ApiTypeHelper.unmodifiable(builder.properties);
        this.resourceName = builder.resourceName;
        this.targetField = builder.targetField;
    }

    public static AttachmentProcessor of(Function<AttachmentProcessor.Builder, ObjectBuilder<AttachmentProcessor>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Processor} variant kind.
     */
    @Override
    public Processor.Kind _processorKind() {
        return Processor.Kind.Attachment;
    }

    /**
     * Required - API name: {@code field}
     */
    @Nonnull
    public final String field() {
        return this.field;
    }

    /**
     * If <code>true</code> and field does not exist, the processor quietly exits without modifying the document.
     * <p>
     * API name: {@code ignore_missing}
     * </p>
     */
    @Nullable
    public final Boolean ignoreMissing() {
        return this.ignoreMissing;
    }

    /**
     * The number of chars being used for extraction to prevent huge fields. Use <code>-1</code> for no limit.
     * <p>
     * API name: {@code indexed_chars}
     * </p>
     */
    @Nullable
    public final Long indexedChars() {
        return this.indexedChars;
    }

    /**
     * API name: {@code indexed_chars_field}
     */
    @Nullable
    public final String indexedCharsField() {
        return this.indexedCharsField;
    }

    /**
     * Array of properties to select to be stored. Can be <code>content</code>, <code>title</code>, <code>name</code>, <code>author</code>,
     * <code>keywords</code>, <code>date</code>, <code>content_type</code>, <code>content_length</code>, <code>language</code>.
     * <p>
     * API name: {@code properties}
     * </p>
     */
    @Nonnull
    public final List<String> properties() {
        return this.properties;
    }

    /**
     * Field containing the name of the resource to decode. If specified, the processor passes this resource name to the underlying Tika
     * library to enable Resource Name Based Detection.
     * <p>
     * API name: {@code resource_name}
     * </p>
     */
    @Nullable
    public final String resourceName() {
        return this.resourceName;
    }

    /**
     * API name: {@code target_field}
     */
    @Nullable
    public final String targetField() {
        return this.targetField;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        generator.writeKey("field");
        generator.write(this.field);

        if (this.ignoreMissing != null) {
            generator.writeKey("ignore_missing");
            generator.write(this.ignoreMissing);
        }

        if (this.indexedChars != null) {
            generator.writeKey("indexed_chars");
            generator.write(this.indexedChars);
        }

        if (this.indexedCharsField != null) {
            generator.writeKey("indexed_chars_field");
            generator.write(this.indexedCharsField);
        }

        if (ApiTypeHelper.isDefined(this.properties)) {
            generator.writeKey("properties");
            generator.writeStartArray();
            for (String item0 : this.properties) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.resourceName != null) {
            generator.writeKey("resource_name");
            generator.write(this.resourceName);
        }

        if (this.targetField != null) {
            generator.writeKey("target_field");
            generator.write(this.targetField);
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
     * Builder for {@link AttachmentProcessor}.
     */
    public static class Builder extends ProcessorBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, AttachmentProcessor> {
        private String field;
        @Nullable
        private Boolean ignoreMissing;
        @Nullable
        private Long indexedChars;
        @Nullable
        private String indexedCharsField;
        @Nullable
        private List<String> properties;
        @Nullable
        private String resourceName;
        @Nullable
        private String targetField;

        public Builder() {}

        private Builder(AttachmentProcessor o) {
            super(o);
            this.field = o.field;
            this.ignoreMissing = o.ignoreMissing;
            this.indexedChars = o.indexedChars;
            this.indexedCharsField = o.indexedCharsField;
            this.properties = _listCopy(o.properties);
            this.resourceName = o.resourceName;
            this.targetField = o.targetField;
        }

        private Builder(Builder o) {
            super(o);
            this.field = o.field;
            this.ignoreMissing = o.ignoreMissing;
            this.indexedChars = o.indexedChars;
            this.indexedCharsField = o.indexedCharsField;
            this.properties = _listCopy(o.properties);
            this.resourceName = o.resourceName;
            this.targetField = o.targetField;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        @Override
        @Nonnull
        protected Builder self() {
            return this;
        }

        /**
         * Required - API name: {@code field}
         */
        @Nonnull
        public final Builder field(String value) {
            this.field = value;
            return this;
        }

        /**
         * If <code>true</code> and field does not exist, the processor quietly exits without modifying the document.
         * <p>
         * API name: {@code ignore_missing}
         * </p>
         */
        @Nonnull
        public final Builder ignoreMissing(@Nullable Boolean value) {
            this.ignoreMissing = value;
            return this;
        }

        /**
         * The number of chars being used for extraction to prevent huge fields. Use <code>-1</code> for no limit.
         * <p>
         * API name: {@code indexed_chars}
         * </p>
         */
        @Nonnull
        public final Builder indexedChars(@Nullable Long value) {
            this.indexedChars = value;
            return this;
        }

        /**
         * API name: {@code indexed_chars_field}
         */
        @Nonnull
        public final Builder indexedCharsField(@Nullable String value) {
            this.indexedCharsField = value;
            return this;
        }

        /**
         * Array of properties to select to be stored. Can be <code>content</code>, <code>title</code>, <code>name</code>,
         * <code>author</code>, <code>keywords</code>, <code>date</code>, <code>content_type</code>, <code>content_length</code>,
         * <code>language</code>.
         * <p>
         * API name: {@code properties}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>properties</code>.
         * </p>
         */
        @Nonnull
        public final Builder properties(List<String> list) {
            this.properties = _listAddAll(this.properties, list);
            return this;
        }

        /**
         * Array of properties to select to be stored. Can be <code>content</code>, <code>title</code>, <code>name</code>,
         * <code>author</code>, <code>keywords</code>, <code>date</code>, <code>content_type</code>, <code>content_length</code>,
         * <code>language</code>.
         * <p>
         * API name: {@code properties}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>properties</code>.
         * </p>
         */
        @Nonnull
        public final Builder properties(String value, String... values) {
            this.properties = _listAdd(this.properties, value, values);
            return this;
        }

        /**
         * Field containing the name of the resource to decode. If specified, the processor passes this resource name to the underlying Tika
         * library to enable Resource Name Based Detection.
         * <p>
         * API name: {@code resource_name}
         * </p>
         */
        @Nonnull
        public final Builder resourceName(@Nullable String value) {
            this.resourceName = value;
            return this;
        }

        /**
         * API name: {@code target_field}
         */
        @Nonnull
        public final Builder targetField(@Nullable String value) {
            this.targetField = value;
            return this;
        }

        /**
         * Builds a {@link AttachmentProcessor}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public AttachmentProcessor build() {
            _checkSingleUse();

            return new AttachmentProcessor(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link AttachmentProcessor}
     */
    public static final JsonpDeserializer<AttachmentProcessor> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        AttachmentProcessor::setupAttachmentProcessorDeserializer
    );

    protected static void setupAttachmentProcessorDeserializer(ObjectDeserializer<AttachmentProcessor.Builder> op) {
        setupProcessorBaseDeserializer(op);
        op.add(Builder::field, JsonpDeserializer.stringDeserializer(), "field");
        op.add(Builder::ignoreMissing, JsonpDeserializer.booleanDeserializer(), "ignore_missing");
        op.add(Builder::indexedChars, JsonpDeserializer.longDeserializer(), "indexed_chars");
        op.add(Builder::indexedCharsField, JsonpDeserializer.stringDeserializer(), "indexed_chars_field");
        op.add(Builder::properties, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "properties");
        op.add(Builder::resourceName, JsonpDeserializer.stringDeserializer(), "resource_name");
        op.add(Builder::targetField, JsonpDeserializer.stringDeserializer(), "target_field");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + this.field.hashCode();
        result = 31 * result + Objects.hashCode(this.ignoreMissing);
        result = 31 * result + Objects.hashCode(this.indexedChars);
        result = 31 * result + Objects.hashCode(this.indexedCharsField);
        result = 31 * result + Objects.hashCode(this.properties);
        result = 31 * result + Objects.hashCode(this.resourceName);
        result = 31 * result + Objects.hashCode(this.targetField);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        AttachmentProcessor other = (AttachmentProcessor) o;
        return this.field.equals(other.field)
            && Objects.equals(this.ignoreMissing, other.ignoreMissing)
            && Objects.equals(this.indexedChars, other.indexedChars)
            && Objects.equals(this.indexedCharsField, other.indexedCharsField)
            && Objects.equals(this.properties, other.properties)
            && Objects.equals(this.resourceName, other.resourceName)
            && Objects.equals(this.targetField, other.targetField);
    }
}
