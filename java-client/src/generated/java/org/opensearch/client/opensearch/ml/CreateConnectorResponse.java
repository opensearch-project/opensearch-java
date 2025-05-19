/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

//----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------

package org.opensearch.client.opensearch.ml;

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

// typedef: ml.create_connector.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class CreateConnectorResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<CreateConnectorResponse.Builder, CreateConnectorResponse> {

    @Nullable
    private final String connectorId;

    // ---------------------------------------------------------------------------------------------

    private CreateConnectorResponse(Builder builder) {
        this.connectorId = builder.connectorId;
    }

    public static CreateConnectorResponse of(Function<CreateConnectorResponse.Builder, ObjectBuilder<CreateConnectorResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code connector_id}
     */
    @Nullable
    public final String connectorId() {
        return this.connectorId;
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
        if (this.connectorId != null) {
            generator.writeKey("connector_id");
            generator.write(this.connectorId);
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
     * Builder for {@link CreateConnectorResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, CreateConnectorResponse> {
        @Nullable
        private String connectorId;

        public Builder() {}

        private Builder(CreateConnectorResponse o) {
            this.connectorId = o.connectorId;
        }

        private Builder(Builder o) {
            this.connectorId = o.connectorId;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code connector_id}
         */
        @Nonnull
        public final Builder connectorId(@Nullable String value) {
            this.connectorId = value;
            return this;
        }

        /**
         * Builds a {@link CreateConnectorResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public CreateConnectorResponse build() {
            _checkSingleUse();

            return new CreateConnectorResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link CreateConnectorResponse}
     */
    public static final JsonpDeserializer<CreateConnectorResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CreateConnectorResponse::setupCreateConnectorResponseDeserializer
    );

    protected static void setupCreateConnectorResponseDeserializer(ObjectDeserializer<CreateConnectorResponse.Builder> op) {
        op.add(Builder::connectorId, JsonpDeserializer.stringDeserializer(), "connector_id");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.connectorId);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CreateConnectorResponse other = (CreateConnectorResponse) o;
        return Objects.equals(this.connectorId, other.connectorId);
    }
}
