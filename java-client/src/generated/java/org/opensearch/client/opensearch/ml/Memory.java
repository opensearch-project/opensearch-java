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
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: ml.Memory

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Memory implements PlainJsonSerializable {

    @Nullable
    private final String type;

    // ---------------------------------------------------------------------------------------------

    private Memory(Builder builder) {
        this.type = builder.type;
    }

    public static Memory of(Function<Memory.Builder, ObjectBuilder<Memory>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code type}
     */
    @Nullable
    public final String type() {
        return this.type;
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
        if (this.type != null) {
            generator.writeKey("type");
            generator.write(this.type);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link Memory}.
     */
    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<Memory> {
        @Nullable
        private String type;

        /**
         * API name: {@code type}
         */
        public final Builder type(@Nullable String value) {
            this.type = value;
            return this;
        }

        /**
         * Builds a {@link Memory}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public Memory build() {
            _checkSingleUse();

            return new Memory(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link Memory}
     */
    public static final JsonpDeserializer<Memory> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        Memory::setupMemoryDeserializer
    );

    protected static void setupMemoryDeserializer(ObjectDeserializer<Memory.Builder> op) {
        op.add(Builder::type, JsonpDeserializer.stringDeserializer(), "type");
    }

    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.type);
        return result;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (this.getClass() != o.getClass()) return false;
        Memory other = (Memory) o;
        return Objects.equals(this.type, other.type);
    }
}
