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

package org.opensearch.client.opensearch.security;

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

// typedef: security.IndexPermission

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IndexPermission implements PlainJsonSerializable, ToCopyableBuilder<IndexPermission.Builder, IndexPermission> {

    @Nonnull
    private final List<String> allowedActions;

    @Nullable
    private final String dls;

    @Nonnull
    private final List<String> fls;

    @Nonnull
    private final List<String> indexPatterns;

    @Nonnull
    private final List<String> maskedFields;

    // ---------------------------------------------------------------------------------------------

    private IndexPermission(Builder builder) {
        this.allowedActions = ApiTypeHelper.unmodifiable(builder.allowedActions);
        this.dls = builder.dls;
        this.fls = ApiTypeHelper.unmodifiable(builder.fls);
        this.indexPatterns = ApiTypeHelper.unmodifiable(builder.indexPatterns);
        this.maskedFields = ApiTypeHelper.unmodifiable(builder.maskedFields);
    }

    public static IndexPermission of(Function<IndexPermission.Builder, ObjectBuilder<IndexPermission>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code allowed_actions}
     */
    @Nonnull
    public final List<String> allowedActions() {
        return this.allowedActions;
    }

    /**
     * API name: {@code dls}
     */
    @Nullable
    public final String dls() {
        return this.dls;
    }

    /**
     * API name: {@code fls}
     */
    @Nonnull
    public final List<String> fls() {
        return this.fls;
    }

    /**
     * API name: {@code index_patterns}
     */
    @Nonnull
    public final List<String> indexPatterns() {
        return this.indexPatterns;
    }

    /**
     * API name: {@code masked_fields}
     */
    @Nonnull
    public final List<String> maskedFields() {
        return this.maskedFields;
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
        if (ApiTypeHelper.isDefined(this.allowedActions)) {
            generator.writeKey("allowed_actions");
            generator.writeStartArray();
            for (String item0 : this.allowedActions) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.dls != null) {
            generator.writeKey("dls");
            generator.write(this.dls);
        }

        if (ApiTypeHelper.isDefined(this.fls)) {
            generator.writeKey("fls");
            generator.writeStartArray();
            for (String item0 : this.fls) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.indexPatterns)) {
            generator.writeKey("index_patterns");
            generator.writeStartArray();
            for (String item0 : this.indexPatterns) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.maskedFields)) {
            generator.writeKey("masked_fields");
            generator.writeStartArray();
            for (String item0 : this.maskedFields) {
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
     * Builder for {@link IndexPermission}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IndexPermission> {
        @Nullable
        private List<String> allowedActions;
        @Nullable
        private String dls;
        @Nullable
        private List<String> fls;
        @Nullable
        private List<String> indexPatterns;
        @Nullable
        private List<String> maskedFields;

        public Builder() {}

        private Builder(IndexPermission o) {
            this.allowedActions = _listCopy(o.allowedActions);
            this.dls = o.dls;
            this.fls = _listCopy(o.fls);
            this.indexPatterns = _listCopy(o.indexPatterns);
            this.maskedFields = _listCopy(o.maskedFields);
        }

        private Builder(Builder o) {
            this.allowedActions = _listCopy(o.allowedActions);
            this.dls = o.dls;
            this.fls = _listCopy(o.fls);
            this.indexPatterns = _listCopy(o.indexPatterns);
            this.maskedFields = _listCopy(o.maskedFields);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code allowed_actions}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>allowedActions</code>.
         * </p>
         */
        @Nonnull
        public final Builder allowedActions(List<String> list) {
            this.allowedActions = _listAddAll(this.allowedActions, list);
            return this;
        }

        /**
         * API name: {@code allowed_actions}
         *
         * <p>
         * Adds one or more values to <code>allowedActions</code>.
         * </p>
         */
        @Nonnull
        public final Builder allowedActions(String value, String... values) {
            this.allowedActions = _listAdd(this.allowedActions, value, values);
            return this;
        }

        /**
         * API name: {@code dls}
         */
        @Nonnull
        public final Builder dls(@Nullable String value) {
            this.dls = value;
            return this;
        }

        /**
         * API name: {@code fls}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>fls</code>.
         * </p>
         */
        @Nonnull
        public final Builder fls(List<String> list) {
            this.fls = _listAddAll(this.fls, list);
            return this;
        }

        /**
         * API name: {@code fls}
         *
         * <p>
         * Adds one or more values to <code>fls</code>.
         * </p>
         */
        @Nonnull
        public final Builder fls(String value, String... values) {
            this.fls = _listAdd(this.fls, value, values);
            return this;
        }

        /**
         * API name: {@code index_patterns}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>indexPatterns</code>.
         * </p>
         */
        @Nonnull
        public final Builder indexPatterns(List<String> list) {
            this.indexPatterns = _listAddAll(this.indexPatterns, list);
            return this;
        }

        /**
         * API name: {@code index_patterns}
         *
         * <p>
         * Adds one or more values to <code>indexPatterns</code>.
         * </p>
         */
        @Nonnull
        public final Builder indexPatterns(String value, String... values) {
            this.indexPatterns = _listAdd(this.indexPatterns, value, values);
            return this;
        }

        /**
         * API name: {@code masked_fields}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>maskedFields</code>.
         * </p>
         */
        @Nonnull
        public final Builder maskedFields(List<String> list) {
            this.maskedFields = _listAddAll(this.maskedFields, list);
            return this;
        }

        /**
         * API name: {@code masked_fields}
         *
         * <p>
         * Adds one or more values to <code>maskedFields</code>.
         * </p>
         */
        @Nonnull
        public final Builder maskedFields(String value, String... values) {
            this.maskedFields = _listAdd(this.maskedFields, value, values);
            return this;
        }

        /**
         * Builds a {@link IndexPermission}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IndexPermission build() {
            _checkSingleUse();

            return new IndexPermission(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IndexPermission}
     */
    public static final JsonpDeserializer<IndexPermission> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IndexPermission::setupIndexPermissionDeserializer
    );

    protected static void setupIndexPermissionDeserializer(ObjectDeserializer<IndexPermission.Builder> op) {
        op.add(Builder::allowedActions, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "allowed_actions");
        op.add(Builder::dls, JsonpDeserializer.stringDeserializer(), "dls");
        op.add(Builder::fls, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "fls");
        op.add(Builder::indexPatterns, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "index_patterns");
        op.add(Builder::maskedFields, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "masked_fields");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.allowedActions);
        result = 31 * result + Objects.hashCode(this.dls);
        result = 31 * result + Objects.hashCode(this.fls);
        result = 31 * result + Objects.hashCode(this.indexPatterns);
        result = 31 * result + Objects.hashCode(this.maskedFields);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IndexPermission other = (IndexPermission) o;
        return Objects.equals(this.allowedActions, other.allowedActions)
            && Objects.equals(this.dls, other.dls)
            && Objects.equals(this.fls, other.fls)
            && Objects.equals(this.indexPatterns, other.indexPatterns)
            && Objects.equals(this.maskedFields, other.maskedFields);
    }
}
