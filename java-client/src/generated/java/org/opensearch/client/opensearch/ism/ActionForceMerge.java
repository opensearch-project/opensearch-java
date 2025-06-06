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

// typedef: ism.ActionForceMerge

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ActionForceMerge implements PlainJsonSerializable, ToCopyableBuilder<ActionForceMerge.Builder, ActionForceMerge> {

    @Nullable
    private final Integer maxNumSegments;

    // ---------------------------------------------------------------------------------------------

    private ActionForceMerge(Builder builder) {
        this.maxNumSegments = builder.maxNumSegments;
    }

    public static ActionForceMerge of(Function<ActionForceMerge.Builder, ObjectBuilder<ActionForceMerge>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The maximum number of segments to merge to.
     * <p>
     * API name: {@code max_num_segments}
     * </p>
     */
    @Nullable
    public final Integer maxNumSegments() {
        return this.maxNumSegments;
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
        if (this.maxNumSegments != null) {
            generator.writeKey("max_num_segments");
            generator.write(this.maxNumSegments);
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
     * Builder for {@link ActionForceMerge}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ActionForceMerge> {
        @Nullable
        private Integer maxNumSegments;

        public Builder() {}

        private Builder(ActionForceMerge o) {
            this.maxNumSegments = o.maxNumSegments;
        }

        private Builder(Builder o) {
            this.maxNumSegments = o.maxNumSegments;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The maximum number of segments to merge to.
         * <p>
         * API name: {@code max_num_segments}
         * </p>
         */
        @Nonnull
        public final Builder maxNumSegments(@Nullable Integer value) {
            this.maxNumSegments = value;
            return this;
        }

        /**
         * Builds a {@link ActionForceMerge}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ActionForceMerge build() {
            _checkSingleUse();

            return new ActionForceMerge(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ActionForceMerge}
     */
    public static final JsonpDeserializer<ActionForceMerge> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ActionForceMerge::setupActionForceMergeDeserializer
    );

    protected static void setupActionForceMergeDeserializer(ObjectDeserializer<ActionForceMerge.Builder> op) {
        op.add(Builder::maxNumSegments, JsonpDeserializer.integerDeserializer(), "max_num_segments");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.maxNumSegments);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ActionForceMerge other = (ActionForceMerge) o;
        return Objects.equals(this.maxNumSegments, other.maxNumSegments);
    }
}
