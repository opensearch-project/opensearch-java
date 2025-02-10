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

// typedef: ml.ExecuteAnomalyLocalizationResponse

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ExecuteAnomalyLocalizationResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ExecuteAnomalyLocalizationResponse.Builder, ExecuteAnomalyLocalizationResponse> {

    @Nullable
    private final String name;

    @Nullable
    private final Result result;

    // ---------------------------------------------------------------------------------------------

    private ExecuteAnomalyLocalizationResponse(Builder builder) {
        this.name = builder.name;
        this.result = builder.result;
    }

    public static ExecuteAnomalyLocalizationResponse of(
        Function<ExecuteAnomalyLocalizationResponse.Builder, ObjectBuilder<ExecuteAnomalyLocalizationResponse>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code name}
     */
    @Nullable
    public final String name() {
        return this.name;
    }

    /**
     * API name: {@code result}
     */
    @Nullable
    public final Result result() {
        return this.result;
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
        if (this.name != null) {
            generator.writeKey("name");
            generator.write(this.name);
        }

        if (this.result != null) {
            generator.writeKey("result");
            this.result.serialize(generator, mapper);
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
     * Builder for {@link ExecuteAnomalyLocalizationResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ExecuteAnomalyLocalizationResponse> {
        @Nullable
        private String name;
        @Nullable
        private Result result;

        public Builder() {}

        private Builder(ExecuteAnomalyLocalizationResponse o) {
            this.name = o.name;
            this.result = o.result;
        }

        private Builder(Builder o) {
            this.name = o.name;
            this.result = o.result;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code name}
         */
        @Nonnull
        public final Builder name(@Nullable String value) {
            this.name = value;
            return this;
        }

        /**
         * API name: {@code result}
         */
        @Nonnull
        public final Builder result(@Nullable Result value) {
            this.result = value;
            return this;
        }

        /**
         * API name: {@code result}
         */
        @Nonnull
        public final Builder result(Function<Result.Builder, ObjectBuilder<Result>> fn) {
            return result(fn.apply(new Result.Builder()).build());
        }

        /**
         * Builds a {@link ExecuteAnomalyLocalizationResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ExecuteAnomalyLocalizationResponse build() {
            _checkSingleUse();

            return new ExecuteAnomalyLocalizationResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ExecuteAnomalyLocalizationResponse}
     */
    public static final JsonpDeserializer<ExecuteAnomalyLocalizationResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ExecuteAnomalyLocalizationResponse::setupExecuteAnomalyLocalizationResponseDeserializer
    );

    protected static void setupExecuteAnomalyLocalizationResponseDeserializer(
        ObjectDeserializer<ExecuteAnomalyLocalizationResponse.Builder> op
    ) {
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
        op.add(Builder::result, Result._DESERIALIZER, "result");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.name);
        result = 31 * result + Objects.hashCode(this.result);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ExecuteAnomalyLocalizationResponse other = (ExecuteAnomalyLocalizationResponse) o;
        return Objects.equals(this.name, other.name) && Objects.equals(this.result, other.result);
    }
}
