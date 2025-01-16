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

// typedef: ml.get_all_messages.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GetAllMessagesResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<GetAllMessagesResponse.Builder, GetAllMessagesResponse> {

    @Nonnull
    private final List<Message> messages;

    @Nullable
    private final Integer nextToken;

    // ---------------------------------------------------------------------------------------------

    private GetAllMessagesResponse(Builder builder) {
        this.messages = ApiTypeHelper.unmodifiableRequired(builder.messages, this, "messages");
        this.nextToken = builder.nextToken;
    }

    public static GetAllMessagesResponse of(Function<GetAllMessagesResponse.Builder, ObjectBuilder<GetAllMessagesResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code messages}
     */
    @Nonnull
    public final List<Message> messages() {
        return this.messages;
    }

    /**
     * The index of the next message after the last message in the returned list.
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
        generator.writeKey("messages");
        generator.writeStartArray();
        for (Message item0 : this.messages) {
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
     * Builder for {@link GetAllMessagesResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, GetAllMessagesResponse> {
        private List<Message> messages;
        @Nullable
        private Integer nextToken;

        public Builder() {}

        private Builder(GetAllMessagesResponse o) {
            this.messages = _listCopy(o.messages);
            this.nextToken = o.nextToken;
        }

        private Builder(Builder o) {
            this.messages = _listCopy(o.messages);
            this.nextToken = o.nextToken;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code messages}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>messages</code>.
         * </p>
         */
        @Nonnull
        public final Builder messages(List<Message> list) {
            this.messages = _listAddAll(this.messages, list);
            return this;
        }

        /**
         * Required - API name: {@code messages}
         *
         * <p>
         * Adds one or more values to <code>messages</code>.
         * </p>
         */
        @Nonnull
        public final Builder messages(Message value, Message... values) {
            this.messages = _listAdd(this.messages, value, values);
            return this;
        }

        /**
         * Required - API name: {@code messages}
         *
         * <p>
         * Adds a value to <code>messages</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder messages(Function<Message.Builder, ObjectBuilder<Message>> fn) {
            return messages(fn.apply(new Message.Builder()).build());
        }

        /**
         * The index of the next message after the last message in the returned list.
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
         * Builds a {@link GetAllMessagesResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetAllMessagesResponse build() {
            _checkSingleUse();

            return new GetAllMessagesResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GetAllMessagesResponse}
     */
    public static final JsonpDeserializer<GetAllMessagesResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GetAllMessagesResponse::setupGetAllMessagesResponseDeserializer
    );

    protected static void setupGetAllMessagesResponseDeserializer(ObjectDeserializer<GetAllMessagesResponse.Builder> op) {
        op.add(Builder::messages, JsonpDeserializer.arrayDeserializer(Message._DESERIALIZER), "messages");
        op.add(Builder::nextToken, JsonpDeserializer.integerDeserializer(), "next_token");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.messages.hashCode();
        result = 31 * result + Objects.hashCode(this.nextToken);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetAllMessagesResponse other = (GetAllMessagesResponse) o;
        return this.messages.equals(other.messages) && Objects.equals(this.nextToken, other.nextToken);
    }
}
