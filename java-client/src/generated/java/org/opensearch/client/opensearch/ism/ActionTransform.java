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
import java.util.Map;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.json.JsonData;
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

// typedef: ism.ActionTransform

/**
 * The transform action configuration.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ActionTransform implements PlainJsonSerializable, ToCopyableBuilder<ActionTransform.Builder, ActionTransform> {

    @Nonnull
    private final Map<String, JsonData> ismTransform;

    // ---------------------------------------------------------------------------------------------

    private ActionTransform(Builder builder) {
        this.ismTransform = ApiTypeHelper.unmodifiableRequired(builder.ismTransform, this, "ismTransform");
    }

    public static ActionTransform of(Function<ActionTransform.Builder, ObjectBuilder<ActionTransform>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The transform job to run on the index.
     * <p>
     * API name: {@code ism_transform}
     * </p>
     */
    @Nonnull
    public final Map<String, JsonData> ismTransform() {
        return this.ismTransform;
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
        generator.writeKey("ism_transform");
        generator.writeStartObject();
        for (Map.Entry<String, JsonData> item0 : this.ismTransform.entrySet()) {
            generator.writeKey(item0.getKey());
            item0.getValue().serialize(generator, mapper);
        }
        generator.writeEnd();
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
     * Builder for {@link ActionTransform}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ActionTransform> {
        private Map<String, JsonData> ismTransform;

        public Builder() {}

        private Builder(ActionTransform o) {
            this.ismTransform = _mapCopy(o.ismTransform);
        }

        private Builder(Builder o) {
            this.ismTransform = _mapCopy(o.ismTransform);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - The transform job to run on the index.
         * <p>
         * API name: {@code ism_transform}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>ismTransform</code>.
         * </p>
         */
        @Nonnull
        public final Builder ismTransform(Map<String, JsonData> map) {
            this.ismTransform = _mapPutAll(this.ismTransform, map);
            return this;
        }

        /**
         * Required - The transform job to run on the index.
         * <p>
         * API name: {@code ism_transform}
         * </p>
         *
         * <p>
         * Adds an entry to <code>ismTransform</code>.
         * </p>
         */
        @Nonnull
        public final Builder ismTransform(String key, JsonData value) {
            this.ismTransform = _mapPut(this.ismTransform, key, value);
            return this;
        }

        /**
         * Builds a {@link ActionTransform}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ActionTransform build() {
            _checkSingleUse();

            return new ActionTransform(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ActionTransform}
     */
    public static final JsonpDeserializer<ActionTransform> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ActionTransform::setupActionTransformDeserializer
    );

    protected static void setupActionTransformDeserializer(ObjectDeserializer<ActionTransform.Builder> op) {
        op.add(Builder::ismTransform, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "ism_transform");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.ismTransform.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ActionTransform other = (ActionTransform) o;
        return this.ismTransform.equals(other.ismTransform);
    }
}
