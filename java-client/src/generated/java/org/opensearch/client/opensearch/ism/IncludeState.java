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

// typedef: ism.IncludeState

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IncludeState implements PlainJsonSerializable, ToCopyableBuilder<IncludeState.Builder, IncludeState> {

    @Nullable
    private final String state;

    // ---------------------------------------------------------------------------------------------

    private IncludeState(Builder builder) {
        this.state = builder.state;
    }

    public static IncludeState of(Function<IncludeState.Builder, ObjectBuilder<IncludeState>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The name of the state to include.
     * <p>
     * API name: {@code state}
     * </p>
     */
    @Nullable
    public final String state() {
        return this.state;
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
        if (this.state != null) {
            generator.writeKey("state");
            generator.write(this.state);
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
     * Builder for {@link IncludeState}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IncludeState> {
        @Nullable
        private String state;

        public Builder() {}

        private Builder(IncludeState o) {
            this.state = o.state;
        }

        private Builder(Builder o) {
            this.state = o.state;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The name of the state to include.
         * <p>
         * API name: {@code state}
         * </p>
         */
        @Nonnull
        public final Builder state(@Nullable String value) {
            this.state = value;
            return this;
        }

        /**
         * Builds a {@link IncludeState}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IncludeState build() {
            _checkSingleUse();

            return new IncludeState(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IncludeState}
     */
    public static final JsonpDeserializer<IncludeState> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IncludeState::setupIncludeStateDeserializer
    );

    protected static void setupIncludeStateDeserializer(ObjectDeserializer<IncludeState.Builder> op) {
        op.add(Builder::state, JsonpDeserializer.stringDeserializer(), "state");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.state);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IncludeState other = (IncludeState) o;
        return Objects.equals(this.state, other.state);
    }
}
