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
import java.util.Map;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.opensearch._types.AcknowledgedResponseBase;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: indices.rollover.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RolloverResponse extends AcknowledgedResponseBase implements ToCopyableBuilder<RolloverResponse.Builder, RolloverResponse> {

    @Nonnull
    private final Map<String, Boolean> conditions;

    private final boolean dryRun;

    @Nonnull
    private final String newIndex;

    @Nonnull
    private final String oldIndex;

    private final boolean rolledOver;

    private final boolean shardsAcknowledged;

    // ---------------------------------------------------------------------------------------------

    private RolloverResponse(Builder builder) {
        super(builder);
        this.conditions = ApiTypeHelper.unmodifiableRequired(builder.conditions, this, "conditions");
        this.dryRun = ApiTypeHelper.requireNonNull(builder.dryRun, this, "dryRun");
        this.newIndex = ApiTypeHelper.requireNonNull(builder.newIndex, this, "newIndex");
        this.oldIndex = ApiTypeHelper.requireNonNull(builder.oldIndex, this, "oldIndex");
        this.rolledOver = ApiTypeHelper.requireNonNull(builder.rolledOver, this, "rolledOver");
        this.shardsAcknowledged = ApiTypeHelper.requireNonNull(builder.shardsAcknowledged, this, "shardsAcknowledged");
    }

    public static RolloverResponse of(Function<RolloverResponse.Builder, ObjectBuilder<RolloverResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code conditions}
     */
    @Nonnull
    public final Map<String, Boolean> conditions() {
        return this.conditions;
    }

    /**
     * Required - API name: {@code dry_run}
     */
    public final boolean dryRun() {
        return this.dryRun;
    }

    /**
     * Required - API name: {@code new_index}
     */
    @Nonnull
    public final String newIndex() {
        return this.newIndex;
    }

    /**
     * Required - API name: {@code old_index}
     */
    @Nonnull
    public final String oldIndex() {
        return this.oldIndex;
    }

    /**
     * Required - API name: {@code rolled_over}
     */
    public final boolean rolledOver() {
        return this.rolledOver;
    }

    /**
     * Required - API name: {@code shards_acknowledged}
     */
    public final boolean shardsAcknowledged() {
        return this.shardsAcknowledged;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        generator.writeKey("conditions");
        generator.writeStartObject();
        for (Map.Entry<String, Boolean> item0 : this.conditions.entrySet()) {
            generator.writeKey(item0.getKey());
            generator.write(item0.getValue());
        }
        generator.writeEnd();

        generator.writeKey("dry_run");
        generator.write(this.dryRun);

        generator.writeKey("new_index");
        generator.write(this.newIndex);

        generator.writeKey("old_index");
        generator.write(this.oldIndex);

        generator.writeKey("rolled_over");
        generator.write(this.rolledOver);

        generator.writeKey("shards_acknowledged");
        generator.write(this.shardsAcknowledged);
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
     * Builder for {@link RolloverResponse}.
     */
    public static class Builder extends AcknowledgedResponseBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, RolloverResponse> {
        private Map<String, Boolean> conditions;
        private Boolean dryRun;
        private String newIndex;
        private String oldIndex;
        private Boolean rolledOver;
        private Boolean shardsAcknowledged;

        public Builder() {}

        private Builder(RolloverResponse o) {
            super(o);
            this.conditions = _mapCopy(o.conditions);
            this.dryRun = o.dryRun;
            this.newIndex = o.newIndex;
            this.oldIndex = o.oldIndex;
            this.rolledOver = o.rolledOver;
            this.shardsAcknowledged = o.shardsAcknowledged;
        }

        private Builder(Builder o) {
            super(o);
            this.conditions = _mapCopy(o.conditions);
            this.dryRun = o.dryRun;
            this.newIndex = o.newIndex;
            this.oldIndex = o.oldIndex;
            this.rolledOver = o.rolledOver;
            this.shardsAcknowledged = o.shardsAcknowledged;
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
         * Required - API name: {@code conditions}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>conditions</code>.
         * </p>
         */
        @Nonnull
        public final Builder conditions(Map<String, Boolean> map) {
            this.conditions = _mapPutAll(this.conditions, map);
            return this;
        }

        /**
         * Required - API name: {@code conditions}
         *
         * <p>
         * Adds an entry to <code>conditions</code>.
         * </p>
         */
        @Nonnull
        public final Builder conditions(String key, Boolean value) {
            this.conditions = _mapPut(this.conditions, key, value);
            return this;
        }

        /**
         * Required - API name: {@code dry_run}
         */
        @Nonnull
        public final Builder dryRun(boolean value) {
            this.dryRun = value;
            return this;
        }

        /**
         * Required - API name: {@code new_index}
         */
        @Nonnull
        public final Builder newIndex(String value) {
            this.newIndex = value;
            return this;
        }

        /**
         * Required - API name: {@code old_index}
         */
        @Nonnull
        public final Builder oldIndex(String value) {
            this.oldIndex = value;
            return this;
        }

        /**
         * Required - API name: {@code rolled_over}
         */
        @Nonnull
        public final Builder rolledOver(boolean value) {
            this.rolledOver = value;
            return this;
        }

        /**
         * Required - API name: {@code shards_acknowledged}
         */
        @Nonnull
        public final Builder shardsAcknowledged(boolean value) {
            this.shardsAcknowledged = value;
            return this;
        }

        /**
         * Builds a {@link RolloverResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RolloverResponse build() {
            _checkSingleUse();

            return new RolloverResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RolloverResponse}
     */
    public static final JsonpDeserializer<RolloverResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RolloverResponse::setupRolloverResponseDeserializer
    );

    protected static void setupRolloverResponseDeserializer(ObjectDeserializer<RolloverResponse.Builder> op) {
        setupAcknowledgedResponseBaseDeserializer(op);
        op.add(Builder::conditions, JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.booleanDeserializer()), "conditions");
        op.add(Builder::dryRun, JsonpDeserializer.booleanDeserializer(), "dry_run");
        op.add(Builder::newIndex, JsonpDeserializer.stringDeserializer(), "new_index");
        op.add(Builder::oldIndex, JsonpDeserializer.stringDeserializer(), "old_index");
        op.add(Builder::rolledOver, JsonpDeserializer.booleanDeserializer(), "rolled_over");
        op.add(Builder::shardsAcknowledged, JsonpDeserializer.booleanDeserializer(), "shards_acknowledged");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + this.conditions.hashCode();
        result = 31 * result + Boolean.hashCode(this.dryRun);
        result = 31 * result + this.newIndex.hashCode();
        result = 31 * result + this.oldIndex.hashCode();
        result = 31 * result + Boolean.hashCode(this.rolledOver);
        result = 31 * result + Boolean.hashCode(this.shardsAcknowledged);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RolloverResponse other = (RolloverResponse) o;
        return this.conditions.equals(other.conditions)
            && this.dryRun == other.dryRun
            && this.newIndex.equals(other.newIndex)
            && this.oldIndex.equals(other.oldIndex)
            && this.rolledOver == other.rolledOver
            && this.shardsAcknowledged == other.shardsAcknowledged;
    }
}
