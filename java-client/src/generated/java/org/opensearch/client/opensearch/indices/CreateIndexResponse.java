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
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: indices.create.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class CreateIndexResponse implements PlainJsonSerializable {

    private final boolean acknowledged;

    @Nonnull
    private final String index;

    private final boolean shardsAcknowledged;

    // ---------------------------------------------------------------------------------------------

    private CreateIndexResponse(Builder builder) {
        this.acknowledged = ApiTypeHelper.requireNonNull(builder.acknowledged, this, "acknowledged");
        this.index = ApiTypeHelper.requireNonNull(builder.index, this, "index");
        this.shardsAcknowledged = ApiTypeHelper.requireNonNull(builder.shardsAcknowledged, this, "shardsAcknowledged");
    }

    public static CreateIndexResponse of(Function<CreateIndexResponse.Builder, ObjectBuilder<CreateIndexResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code acknowledged}
     */
    public final boolean acknowledged() {
        return this.acknowledged;
    }

    /**
     * Required - API name: {@code index}
     */
    @Nonnull
    public final String index() {
        return this.index;
    }

    /**
     * Required - API name: {@code shards_acknowledged}
     */
    public final boolean shardsAcknowledged() {
        return this.shardsAcknowledged;
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
        generator.writeKey("acknowledged");
        generator.write(this.acknowledged);

        generator.writeKey("index");
        generator.write(this.index);

        generator.writeKey("shards_acknowledged");
        generator.write(this.shardsAcknowledged);
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link CreateIndexResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<CreateIndexResponse> {
        private Boolean acknowledged;
        private String index;
        private Boolean shardsAcknowledged;

        /**
         * Required - API name: {@code acknowledged}
         */
        public final Builder acknowledged(boolean value) {
            this.acknowledged = value;
            return this;
        }

        /**
         * Required - API name: {@code index}
         */
        public final Builder index(String value) {
            this.index = value;
            return this;
        }

        /**
         * Required - API name: {@code shards_acknowledged}
         */
        public final Builder shardsAcknowledged(boolean value) {
            this.shardsAcknowledged = value;
            return this;
        }

        /**
         * Builds a {@link CreateIndexResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public CreateIndexResponse build() {
            _checkSingleUse();

            return new CreateIndexResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link CreateIndexResponse}
     */
    public static final JsonpDeserializer<CreateIndexResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CreateIndexResponse::setupCreateIndexResponseDeserializer
    );

    protected static void setupCreateIndexResponseDeserializer(ObjectDeserializer<CreateIndexResponse.Builder> op) {
        op.add(Builder::acknowledged, JsonpDeserializer.booleanDeserializer(), "acknowledged");
        op.add(Builder::index, JsonpDeserializer.stringDeserializer(), "index");
        op.add(Builder::shardsAcknowledged, JsonpDeserializer.booleanDeserializer(), "shards_acknowledged");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Boolean.hashCode(this.acknowledged);
        result = 31 * result + this.index.hashCode();
        result = 31 * result + Boolean.hashCode(this.shardsAcknowledged);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CreateIndexResponse other = (CreateIndexResponse) o;
        return this.acknowledged == other.acknowledged
            && this.index.equals(other.index)
            && this.shardsAcknowledged == other.shardsAcknowledged;
    }
}
