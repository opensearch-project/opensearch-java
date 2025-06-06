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

// typedef: ism.ActionIndexPriority

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ActionIndexPriority implements PlainJsonSerializable, ToCopyableBuilder<ActionIndexPriority.Builder, ActionIndexPriority> {

    @Nullable
    private final Number priority;

    // ---------------------------------------------------------------------------------------------

    private ActionIndexPriority(Builder builder) {
        this.priority = builder.priority;
    }

    public static ActionIndexPriority of(Function<ActionIndexPriority.Builder, ObjectBuilder<ActionIndexPriority>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The priority to set for the index.
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
     * Builder for {@link ActionIndexPriority}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ActionIndexPriority> {
        @Nullable
        private Number priority;

        public Builder() {}

        private Builder(ActionIndexPriority o) {
            this.priority = o.priority;
        }

        private Builder(Builder o) {
            this.priority = o.priority;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The priority to set for the index.
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
         * Builds a {@link ActionIndexPriority}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ActionIndexPriority build() {
            _checkSingleUse();

            return new ActionIndexPriority(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ActionIndexPriority}
     */
    public static final JsonpDeserializer<ActionIndexPriority> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ActionIndexPriority::setupActionIndexPriorityDeserializer
    );

    protected static void setupActionIndexPriorityDeserializer(ObjectDeserializer<ActionIndexPriority.Builder> op) {
        op.add(Builder::priority, JsonpDeserializer.numberDeserializer(), "priority");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.priority);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ActionIndexPriority other = (ActionIndexPriority) o;
        return Objects.equals(this.priority, other.priority);
    }
}
