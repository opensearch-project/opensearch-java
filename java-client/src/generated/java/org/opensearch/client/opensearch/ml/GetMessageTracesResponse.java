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

// typedef: ml.get_message_traces.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GetMessageTracesResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<GetMessageTracesResponse.Builder, GetMessageTracesResponse> {

    @Nullable
    private final Integer nextToken;

    @Nonnull
    private final List<Message> traces;

    // ---------------------------------------------------------------------------------------------

    private GetMessageTracesResponse(Builder builder) {
        this.nextToken = builder.nextToken;
        this.traces = ApiTypeHelper.unmodifiableRequired(builder.traces, this, "traces");
    }

    public static GetMessageTracesResponse of(Function<GetMessageTracesResponse.Builder, ObjectBuilder<GetMessageTracesResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code next_token}
     */
    @Nullable
    public final Integer nextToken() {
        return this.nextToken;
    }

    /**
     * Required - API name: {@code traces}
     */
    @Nonnull
    public final List<Message> traces() {
        return this.traces;
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
        if (this.nextToken != null) {
            generator.writeKey("next_token");
            generator.write(this.nextToken);
        }

        generator.writeKey("traces");
        generator.writeStartArray();
        for (Message item0 : this.traces) {
            item0.serialize(generator, mapper);
        }
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
     * Builder for {@link GetMessageTracesResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, GetMessageTracesResponse> {
        @Nullable
        private Integer nextToken;
        private List<Message> traces;

        public Builder() {}

        private Builder(GetMessageTracesResponse o) {
            this.nextToken = o.nextToken;
            this.traces = _listCopy(o.traces);
        }

        private Builder(Builder o) {
            this.nextToken = o.nextToken;
            this.traces = _listCopy(o.traces);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code next_token}
         */
        @Nonnull
        public final Builder nextToken(@Nullable Integer value) {
            this.nextToken = value;
            return this;
        }

        /**
         * Required - API name: {@code traces}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>traces</code>.
         * </p>
         */
        @Nonnull
        public final Builder traces(List<Message> list) {
            this.traces = _listAddAll(this.traces, list);
            return this;
        }

        /**
         * Required - API name: {@code traces}
         *
         * <p>
         * Adds one or more values to <code>traces</code>.
         * </p>
         */
        @Nonnull
        public final Builder traces(Message value, Message... values) {
            this.traces = _listAdd(this.traces, value, values);
            return this;
        }

        /**
         * Required - API name: {@code traces}
         *
         * <p>
         * Adds a value to <code>traces</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder traces(Function<Message.Builder, ObjectBuilder<Message>> fn) {
            return traces(fn.apply(new Message.Builder()).build());
        }

        /**
         * Builds a {@link GetMessageTracesResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetMessageTracesResponse build() {
            _checkSingleUse();

            return new GetMessageTracesResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GetMessageTracesResponse}
     */
    public static final JsonpDeserializer<GetMessageTracesResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GetMessageTracesResponse::setupGetMessageTracesResponseDeserializer
    );

    protected static void setupGetMessageTracesResponseDeserializer(ObjectDeserializer<GetMessageTracesResponse.Builder> op) {
        op.add(Builder::nextToken, JsonpDeserializer.integerDeserializer(), "next_token");
        op.add(Builder::traces, JsonpDeserializer.arrayDeserializer(Message._DESERIALIZER), "traces");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.nextToken);
        result = 31 * result + this.traces.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetMessageTracesResponse other = (GetMessageTracesResponse) o;
        return Objects.equals(this.nextToken, other.nextToken) && this.traces.equals(other.traces);
    }
}
