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

package org.opensearch.client.opensearch.ism;

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

// typedef: ism.IsmTemplate

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IsmTemplate implements PlainJsonSerializable, ToCopyableBuilder<IsmTemplate.Builder, IsmTemplate> {

    @Nonnull
    private final List<String> indexPatterns;

    @Nullable
    private final Long lastUpdatedTime;

    @Nullable
    private final Number priority;

    // ---------------------------------------------------------------------------------------------

    private IsmTemplate(Builder builder) {
        this.indexPatterns = ApiTypeHelper.unmodifiable(builder.indexPatterns);
        this.lastUpdatedTime = builder.lastUpdatedTime;
        this.priority = builder.priority;
    }

    public static IsmTemplate of(Function<IsmTemplate.Builder, ObjectBuilder<IsmTemplate>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The index patterns for the ISM template.
     * <p>
     * API name: {@code index_patterns}
     * </p>
     */
    @Nonnull
    public final List<String> indexPatterns() {
        return this.indexPatterns;
    }

    /**
     * When the ISM template was last updated.
     * <p>
     * API name: {@code last_updated_time}
     * </p>
     */
    @Nullable
    public final Long lastUpdatedTime() {
        return this.lastUpdatedTime;
    }

    /**
     * The priority of the ISM template.
     * <p>
     * API name: {@code priority}
     * </p>
     */
    @Nullable
    public final Number priority() {
        return this.priority;
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
        if (ApiTypeHelper.isDefined(this.indexPatterns)) {
            generator.writeKey("index_patterns");
            generator.writeStartArray();
            for (String item0 : this.indexPatterns) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.lastUpdatedTime != null) {
            generator.writeKey("last_updated_time");
            generator.write(this.lastUpdatedTime);
        }

        if (this.priority != null) {
            generator.writeKey("priority");
            generator.write(this.priority.doubleValue());
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
     * Builder for {@link IsmTemplate}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IsmTemplate> {
        @Nullable
        private List<String> indexPatterns;
        @Nullable
        private Long lastUpdatedTime;
        @Nullable
        private Number priority;

        public Builder() {}

        private Builder(IsmTemplate o) {
            this.indexPatterns = _listCopy(o.indexPatterns);
            this.lastUpdatedTime = o.lastUpdatedTime;
            this.priority = o.priority;
        }

        private Builder(Builder o) {
            this.indexPatterns = _listCopy(o.indexPatterns);
            this.lastUpdatedTime = o.lastUpdatedTime;
            this.priority = o.priority;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The index patterns for the ISM template.
         * <p>
         * API name: {@code index_patterns}
         * </p>
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
         * The index patterns for the ISM template.
         * <p>
         * API name: {@code index_patterns}
         * </p>
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
         * When the ISM template was last updated.
         * <p>
         * API name: {@code last_updated_time}
         * </p>
         */
        @Nonnull
        public final Builder lastUpdatedTime(@Nullable Long value) {
            this.lastUpdatedTime = value;
            return this;
        }

        /**
         * The priority of the ISM template.
         * <p>
         * API name: {@code priority}
         * </p>
         */
        @Nonnull
        public final Builder priority(@Nullable Number value) {
            this.priority = value;
            return this;
        }

        /**
         * Builds a {@link IsmTemplate}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IsmTemplate build() {
            _checkSingleUse();

            return new IsmTemplate(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IsmTemplate}
     */
    public static final JsonpDeserializer<IsmTemplate> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IsmTemplate::setupIsmTemplateDeserializer
    );

    protected static void setupIsmTemplateDeserializer(ObjectDeserializer<IsmTemplate.Builder> op) {
        op.add(Builder::indexPatterns, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "index_patterns");
        op.add(Builder::lastUpdatedTime, JsonpDeserializer.longDeserializer(), "last_updated_time");
        op.add(Builder::priority, JsonpDeserializer.numberDeserializer(), "priority");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.indexPatterns);
        result = 31 * result + Objects.hashCode(this.lastUpdatedTime);
        result = 31 * result + Objects.hashCode(this.priority);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IsmTemplate other = (IsmTemplate) o;
        return Objects.equals(this.indexPatterns, other.indexPatterns)
            && Objects.equals(this.lastUpdatedTime, other.lastUpdatedTime)
            && Objects.equals(this.priority, other.priority);
    }
}
