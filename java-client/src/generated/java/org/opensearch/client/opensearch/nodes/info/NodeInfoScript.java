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

package org.opensearch.client.opensearch.nodes.info;

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

// typedef: nodes.info.NodeInfoScript

/**
 * The script execution configuration.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NodeInfoScript implements PlainJsonSerializable, ToCopyableBuilder<NodeInfoScript.Builder, NodeInfoScript> {

    @Nonnull
    private final String allowedTypes;

    @Nonnull
    private final String disableMaxCompilationsRate;

    // ---------------------------------------------------------------------------------------------

    private NodeInfoScript(Builder builder) {
        this.allowedTypes = ApiTypeHelper.requireNonNull(builder.allowedTypes, this, "allowedTypes");
        this.disableMaxCompilationsRate = ApiTypeHelper.requireNonNull(
            builder.disableMaxCompilationsRate,
            this,
            "disableMaxCompilationsRate"
        );
    }

    public static NodeInfoScript of(Function<NodeInfoScript.Builder, ObjectBuilder<NodeInfoScript>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The types of scripts allowed.
     * <p>
     * API name: {@code allowed_types}
     * </p>
     */
    @Nonnull
    public final String allowedTypes() {
        return this.allowedTypes;
    }

    /**
     * Required - The setting to disable maximum script compilation rate.
     * <p>
     * API name: {@code disable_max_compilations_rate}
     * </p>
     */
    @Nonnull
    public final String disableMaxCompilationsRate() {
        return this.disableMaxCompilationsRate;
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
        generator.writeKey("allowed_types");
        generator.write(this.allowedTypes);

        generator.writeKey("disable_max_compilations_rate");
        generator.write(this.disableMaxCompilationsRate);
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
     * Builder for {@link NodeInfoScript}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, NodeInfoScript> {
        private String allowedTypes;
        private String disableMaxCompilationsRate;

        public Builder() {}

        private Builder(NodeInfoScript o) {
            this.allowedTypes = o.allowedTypes;
            this.disableMaxCompilationsRate = o.disableMaxCompilationsRate;
        }

        private Builder(Builder o) {
            this.allowedTypes = o.allowedTypes;
            this.disableMaxCompilationsRate = o.disableMaxCompilationsRate;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - The types of scripts allowed.
         * <p>
         * API name: {@code allowed_types}
         * </p>
         */
        @Nonnull
        public final Builder allowedTypes(String value) {
            this.allowedTypes = value;
            return this;
        }

        /**
         * Required - The setting to disable maximum script compilation rate.
         * <p>
         * API name: {@code disable_max_compilations_rate}
         * </p>
         */
        @Nonnull
        public final Builder disableMaxCompilationsRate(String value) {
            this.disableMaxCompilationsRate = value;
            return this;
        }

        /**
         * Builds a {@link NodeInfoScript}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NodeInfoScript build() {
            _checkSingleUse();

            return new NodeInfoScript(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NodeInfoScript}
     */
    public static final JsonpDeserializer<NodeInfoScript> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NodeInfoScript::setupNodeInfoScriptDeserializer
    );

    protected static void setupNodeInfoScriptDeserializer(ObjectDeserializer<NodeInfoScript.Builder> op) {
        op.add(Builder::allowedTypes, JsonpDeserializer.stringDeserializer(), "allowed_types");
        op.add(Builder::disableMaxCompilationsRate, JsonpDeserializer.stringDeserializer(), "disable_max_compilations_rate");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.allowedTypes.hashCode();
        result = 31 * result + this.disableMaxCompilationsRate.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NodeInfoScript other = (NodeInfoScript) o;
        return this.allowedTypes.equals(other.allowedTypes) && this.disableMaxCompilationsRate.equals(other.disableMaxCompilationsRate);
    }
}
