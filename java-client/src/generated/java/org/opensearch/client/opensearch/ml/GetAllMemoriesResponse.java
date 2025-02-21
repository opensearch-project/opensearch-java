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
import java.util.List;
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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ml.get_all_memories.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GetAllMemoriesResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<GetAllMemoriesResponse.Builder, GetAllMemoriesResponse> {

    @Nonnull
    private final List<Memory> memories;

    @Nullable
    private final Integer nextToken;

    // ---------------------------------------------------------------------------------------------

    private GetAllMemoriesResponse(Builder builder) {
        this.memories = ApiTypeHelper.unmodifiableRequired(builder.memories, this, "memories");
        this.nextToken = builder.nextToken;
    }

    public static GetAllMemoriesResponse of(Function<GetAllMemoriesResponse.Builder, ObjectBuilder<GetAllMemoriesResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code memories}
     */
    @Nonnull
    public final List<Memory> memories() {
        return this.memories;
    }

    /**
     * The index of the next memory after the last memory in the returned list.
     * <p>
     * API name: {@code next_token}
     * </p>
     */
    @Nullable
    public final Integer nextToken() {
        return this.nextToken;
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
        generator.writeKey("memories");
        generator.writeStartArray();
        for (Memory item0 : this.memories) {
            item0.serialize(generator, mapper);
        }
        generator.writeEnd();

        if (this.nextToken != null) {
            generator.writeKey("next_token");
            generator.write(this.nextToken);
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
     * Builder for {@link GetAllMemoriesResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, GetAllMemoriesResponse> {
        private List<Memory> memories;
        @Nullable
        private Integer nextToken;

        public Builder() {}

        private Builder(GetAllMemoriesResponse o) {
            this.memories = _listCopy(o.memories);
            this.nextToken = o.nextToken;
        }

        private Builder(Builder o) {
            this.memories = _listCopy(o.memories);
            this.nextToken = o.nextToken;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code memories}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>memories</code>.
         * </p>
         */
        @Nonnull
        public final Builder memories(List<Memory> list) {
            this.memories = _listAddAll(this.memories, list);
            return this;
        }

        /**
         * Required - API name: {@code memories}
         *
         * <p>
         * Adds one or more values to <code>memories</code>.
         * </p>
         */
        @Nonnull
        public final Builder memories(Memory value, Memory... values) {
            this.memories = _listAdd(this.memories, value, values);
            return this;
        }

        /**
         * Required - API name: {@code memories}
         *
         * <p>
         * Adds a value to <code>memories</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder memories(Function<Memory.Builder, ObjectBuilder<Memory>> fn) {
            return memories(fn.apply(new Memory.Builder()).build());
        }

        /**
         * The index of the next memory after the last memory in the returned list.
         * <p>
         * API name: {@code next_token}
         * </p>
         */
        @Nonnull
        public final Builder nextToken(@Nullable Integer value) {
            this.nextToken = value;
            return this;
        }

        /**
         * Builds a {@link GetAllMemoriesResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetAllMemoriesResponse build() {
            _checkSingleUse();

            return new GetAllMemoriesResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GetAllMemoriesResponse}
     */
    public static final JsonpDeserializer<GetAllMemoriesResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GetAllMemoriesResponse::setupGetAllMemoriesResponseDeserializer
    );

    protected static void setupGetAllMemoriesResponseDeserializer(ObjectDeserializer<GetAllMemoriesResponse.Builder> op) {
        op.add(Builder::memories, JsonpDeserializer.arrayDeserializer(Memory._DESERIALIZER), "memories");
        op.add(Builder::nextToken, JsonpDeserializer.integerDeserializer(), "next_token");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.memories.hashCode();
        result = 31 * result + Objects.hashCode(this.nextToken);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetAllMemoriesResponse other = (GetAllMemoriesResponse) o;
        return this.memories.equals(other.memories) && Objects.equals(this.nextToken, other.nextToken);
    }
}
