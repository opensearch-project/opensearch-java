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
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ml.execute_agent_stream.Response

@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ExecuteAgentStreamResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ExecuteAgentStreamResponse.Builder, ExecuteAgentStreamResponse> {

    // ---------------------------------------------------------------------------------------------

    private ExecuteAgentStreamResponse(Builder builder) {}

    public static ExecuteAgentStreamResponse of(
        Function<ExecuteAgentStreamResponse.Builder, ObjectBuilder<ExecuteAgentStreamResponse>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Serialize this object to JSON.
     */
    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
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
     * Builder for {@link ExecuteAgentStreamResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ExecuteAgentStreamResponse> {

        public Builder() {}

        private Builder(ExecuteAgentStreamResponse o) {}

        private Builder(Builder o) {}

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Builds a {@link ExecuteAgentStreamResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ExecuteAgentStreamResponse build() {
            _checkSingleUse();

            return new ExecuteAgentStreamResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Singleton instance for {@link ExecuteAgentStreamResponse}.
     */
    public static final ExecuteAgentStreamResponse _INSTANCE = builder().build();

    public static final JsonpDeserializer<ExecuteAgentStreamResponse> _DESERIALIZER = JsonpDeserializer.emptyObject(
        ExecuteAgentStreamResponse._INSTANCE
    );

    @Override
    public int hashCode() {
        int result = 17;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        return true;
    }
}
