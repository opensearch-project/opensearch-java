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

package org.opensearch.client.opensearch.indices;

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
import org.opensearch.client.opensearch._types.ShardsOperationResponseBase;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: indices.forcemerge.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ForcemergeResponse extends ShardsOperationResponseBase
    implements
        ToCopyableBuilder<ForcemergeResponse.Builder, ForcemergeResponse> {

    @Nullable
    private final String task;

    // ---------------------------------------------------------------------------------------------

    private ForcemergeResponse(Builder builder) {
        super(builder);
        this.task = builder.task;
    }

    public static ForcemergeResponse of(Function<ForcemergeResponse.Builder, ObjectBuilder<ForcemergeResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Task contains a task id returned when <code>wait_for_completion=false</code>, you can use the <code>task_id</code> to get the status
     * of the task at _tasks/&lt;task_id&gt;.
     * <p>
     * API name: {@code task}
     * </p>
     */
    @Nullable
    public final String task() {
        return this.task;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.task != null) {
            generator.writeKey("task");
            generator.write(this.task);
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
     * Builder for {@link ForcemergeResponse}.
     */
    public static class Builder extends ShardsOperationResponseBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, ForcemergeResponse> {
        @Nullable
        private String task;

        public Builder() {}

        private Builder(ForcemergeResponse o) {
            super(o);
            this.task = o.task;
        }

        private Builder(Builder o) {
            super(o);
            this.task = o.task;
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
         * Task contains a task id returned when <code>wait_for_completion=false</code>, you can use the <code>task_id</code> to get the
         * status of the task at _tasks/&lt;task_id&gt;.
         * <p>
         * API name: {@code task}
         * </p>
         */
        @Nonnull
        public final Builder task(@Nullable String value) {
            this.task = value;
            return this;
        }

        /**
         * Builds a {@link ForcemergeResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ForcemergeResponse build() {
            _checkSingleUse();

            return new ForcemergeResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ForcemergeResponse}
     */
    public static final JsonpDeserializer<ForcemergeResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ForcemergeResponse::setupForcemergeResponseDeserializer
    );

    protected static void setupForcemergeResponseDeserializer(ObjectDeserializer<ForcemergeResponse.Builder> op) {
        setupShardsOperationResponseBaseDeserializer(op);
        op.add(Builder::task, JsonpDeserializer.stringDeserializer(), "task");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.task);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ForcemergeResponse other = (ForcemergeResponse) o;
        return Objects.equals(this.task, other.task);
    }
}
