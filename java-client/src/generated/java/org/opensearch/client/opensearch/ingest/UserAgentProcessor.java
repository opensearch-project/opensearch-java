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

// typedef: ingest.UserAgentProcessor

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class UserAgentProcessor extends ProcessorBase
    implements
        ProcessorVariant,
        ToCopyableBuilder<UserAgentProcessor.Builder, UserAgentProcessor> {

    @Nonnull
    private final String field;

    @Nullable
    private final Boolean ignoreMissing;

    @Nonnull
    private final List<UserAgentProperty> options;

    @Nullable
    private final String regexFile;

    @Nullable
    private final String targetField;

    // ---------------------------------------------------------------------------------------------

    private UserAgentProcessor(Builder builder) {
        super(builder);
        this.field = ApiTypeHelper.requireNonNull(builder.field, this, "field");
        this.ignoreMissing = builder.ignoreMissing;
        this.options = ApiTypeHelper.unmodifiable(builder.options);
        this.regexFile = builder.regexFile;
        this.targetField = builder.targetField;
    }

    public static UserAgentProcessor of(Function<UserAgentProcessor.Builder, ObjectBuilder<UserAgentProcessor>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Processor} variant kind.
     */
    @Override
    public Processor.Kind _processorKind() {
        return Processor.Kind.UserAgent;
    }

    /**
     * Required - API name: {@code field}
     */
    @Nonnull
    public final String field() {
        return this.field;
    }

    /**
     * If <code>true</code> and <code>field</code> does not exist, the processor quietly exits without modifying the document.
     * <p>
     * API name: {@code ignore_missing}
     * </p>
     */
    @Nullable
    public final Boolean ignoreMissing() {
        return this.ignoreMissing;
    }

    /**
     * API name: {@code options}
     */
    @Nonnull
    public final List<UserAgentProperty> options() {
        return this.options;
    }

    /**
     * The name of the file in the <code>config/ingest-user-agent</code> directory containing the regular expressions for parsing the user
     * agent string. Both the directory and the file have to be created before starting OpenSearch. If not specified, ingest-user-agent will
     * use the <code>regexes.yaml</code> from uap-core it ships with.
     * <p>
     * API name: {@code regex_file}
     * </p>
     */
    @Nullable
    public final String regexFile() {
        return this.regexFile;
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

        if (ApiTypeHelper.isDefined(this.options)) {
            generator.writeKey("options");
            generator.writeStartArray();
            for (UserAgentProperty item0 : this.options) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.regexFile != null) {
            generator.writeKey("regex_file");
            generator.write(this.regexFile);
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
     * Builder for {@link UserAgentProcessor}.
     */
    public static class Builder extends ProcessorBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, UserAgentProcessor> {
        private String field;
        @Nullable
        private Boolean ignoreMissing;
        @Nullable
        private List<UserAgentProperty> options;
        @Nullable
        private String regexFile;
        @Nullable
        private String targetField;

        public Builder() {}

        private Builder(UserAgentProcessor o) {
            super(o);
            this.field = o.field;
            this.ignoreMissing = o.ignoreMissing;
            this.options = _listCopy(o.options);
            this.regexFile = o.regexFile;
            this.targetField = o.targetField;
        }

        private Builder(Builder o) {
            super(o);
            this.field = o.field;
            this.ignoreMissing = o.ignoreMissing;
            this.options = _listCopy(o.options);
            this.regexFile = o.regexFile;
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
         * If <code>true</code> and <code>field</code> does not exist, the processor quietly exits without modifying the document.
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
         * API name: {@code options}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>options</code>.
         * </p>
         */
        @Nonnull
        public final Builder options(List<UserAgentProperty> list) {
            this.options = _listAddAll(this.options, list);
            return this;
        }

        /**
         * API name: {@code options}
         *
         * <p>
         * Adds one or more values to <code>options</code>.
         * </p>
         */
        @Nonnull
        public final Builder options(UserAgentProperty value, UserAgentProperty... values) {
            this.options = _listAdd(this.options, value, values);
            return this;
        }

        /**
         * The name of the file in the <code>config/ingest-user-agent</code> directory containing the regular expressions for parsing the
         * user agent string. Both the directory and the file have to be created before starting OpenSearch. If not specified,
         * ingest-user-agent will use the <code>regexes.yaml</code> from uap-core it ships with.
         * <p>
         * API name: {@code regex_file}
         * </p>
         */
        @Nonnull
        public final Builder regexFile(@Nullable String value) {
            this.regexFile = value;
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
         * Builds a {@link UserAgentProcessor}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public UserAgentProcessor build() {
            _checkSingleUse();

            return new UserAgentProcessor(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link UserAgentProcessor}
     */
    public static final JsonpDeserializer<UserAgentProcessor> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        UserAgentProcessor::setupUserAgentProcessorDeserializer
    );

    protected static void setupUserAgentProcessorDeserializer(ObjectDeserializer<UserAgentProcessor.Builder> op) {
        setupProcessorBaseDeserializer(op);
        op.add(Builder::field, JsonpDeserializer.stringDeserializer(), "field");
        op.add(Builder::ignoreMissing, JsonpDeserializer.booleanDeserializer(), "ignore_missing");
        op.add(Builder::options, JsonpDeserializer.arrayDeserializer(UserAgentProperty._DESERIALIZER), "options");
        op.add(Builder::regexFile, JsonpDeserializer.stringDeserializer(), "regex_file");
        op.add(Builder::targetField, JsonpDeserializer.stringDeserializer(), "target_field");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + this.field.hashCode();
        result = 31 * result + Objects.hashCode(this.ignoreMissing);
        result = 31 * result + Objects.hashCode(this.options);
        result = 31 * result + Objects.hashCode(this.regexFile);
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
        UserAgentProcessor other = (UserAgentProcessor) o;
        return this.field.equals(other.field)
            && Objects.equals(this.ignoreMissing, other.ignoreMissing)
            && Objects.equals(this.options, other.options)
            && Objects.equals(this.regexFile, other.regexFile)
            && Objects.equals(this.targetField, other.targetField);
    }
}
