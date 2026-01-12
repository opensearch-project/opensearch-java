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

// typedef: ml.add_agentic_memory.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class AddAgenticMemoryResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<AddAgenticMemoryResponse.Builder, AddAgenticMemoryResponse> {

    @Nullable
    private final String sessionId;

    @Nullable
    private final String workingMemoryId;

    // ---------------------------------------------------------------------------------------------

    private AddAgenticMemoryResponse(Builder builder) {
        this.sessionId = builder.sessionId;
        this.workingMemoryId = builder.workingMemoryId;
    }

    public static AddAgenticMemoryResponse of(Function<AddAgenticMemoryResponse.Builder, ObjectBuilder<AddAgenticMemoryResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Session ID associated with the memory.
     * <p>
     * API name: {@code session_id}
     * </p>
     */
    @Nullable
    public final String sessionId() {
        return this.sessionId;
    }

    /**
     * The ID for the creating working memory entry.
     * <p>
     * API name: {@code working_memory_id}
     * </p>
     */
    @Nullable
    public final String workingMemoryId() {
        return this.workingMemoryId;
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
        if (this.sessionId != null) {
            generator.writeKey("session_id");
            generator.write(this.sessionId);
        }

        if (this.workingMemoryId != null) {
            generator.writeKey("working_memory_id");
            generator.write(this.workingMemoryId);
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
     * Builder for {@link AddAgenticMemoryResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, AddAgenticMemoryResponse> {
        @Nullable
        private String sessionId;
        @Nullable
        private String workingMemoryId;

        public Builder() {}

        private Builder(AddAgenticMemoryResponse o) {
            this.sessionId = o.sessionId;
            this.workingMemoryId = o.workingMemoryId;
        }

        private Builder(Builder o) {
            this.sessionId = o.sessionId;
            this.workingMemoryId = o.workingMemoryId;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Session ID associated with the memory.
         * <p>
         * API name: {@code session_id}
         * </p>
         */
        @Nonnull
        public final Builder sessionId(@Nullable String value) {
            this.sessionId = value;
            return this;
        }

        /**
         * The ID for the creating working memory entry.
         * <p>
         * API name: {@code working_memory_id}
         * </p>
         */
        @Nonnull
        public final Builder workingMemoryId(@Nullable String value) {
            this.workingMemoryId = value;
            return this;
        }

        /**
         * Builds a {@link AddAgenticMemoryResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public AddAgenticMemoryResponse build() {
            _checkSingleUse();

            return new AddAgenticMemoryResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link AddAgenticMemoryResponse}
     */
    public static final JsonpDeserializer<AddAgenticMemoryResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        AddAgenticMemoryResponse::setupAddAgenticMemoryResponseDeserializer
    );

    protected static void setupAddAgenticMemoryResponseDeserializer(ObjectDeserializer<AddAgenticMemoryResponse.Builder> op) {
        op.add(Builder::sessionId, JsonpDeserializer.stringDeserializer(), "session_id");
        op.add(Builder::workingMemoryId, JsonpDeserializer.stringDeserializer(), "working_memory_id");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.sessionId);
        result = 31 * result + Objects.hashCode(this.workingMemoryId);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        AddAgenticMemoryResponse other = (AddAgenticMemoryResponse) o;
        return Objects.equals(this.sessionId, other.sessionId) && Objects.equals(this.workingMemoryId, other.workingMemoryId);
    }
}
