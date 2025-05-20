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
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonData;
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

// typedef: ml.ToolAttributes

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ToolAttributes implements PlainJsonSerializable, ToCopyableBuilder<ToolAttributes.Builder, ToolAttributes> {

    @Nonnull
    private final Map<String, JsonData> attributes;

    @Nullable
    private final String inputSchema;

    @Nullable
    private final Boolean strict;

    // ---------------------------------------------------------------------------------------------

    private ToolAttributes(Builder builder) {
        this.attributes = ApiTypeHelper.unmodifiable(builder.attributes);
        this.inputSchema = builder.inputSchema;
        this.strict = builder.strict;
    }

    public static ToolAttributes of(Function<ToolAttributes.Builder, ObjectBuilder<ToolAttributes>> fn) {
        return fn.apply(new Builder()).build();
    }

    @Nonnull
    public final Map<String, JsonData> attributes() {
        return this.attributes;
    }

    /**
     * API name: {@code input_schema}
     */
    @Nullable
    public final String inputSchema() {
        return this.inputSchema;
    }

    /**
     * API name: {@code strict}
     */
    @Nullable
    public final Boolean strict() {
        return this.strict;
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
        for (Map.Entry<String, JsonData> item0 : this.attributes.entrySet()) {
            generator.writeKey(item0.getKey());
            item0.getValue().serialize(generator, mapper);
        }
        if (this.inputSchema != null) {
            generator.writeKey("input_schema");
            generator.write(this.inputSchema);
        }

        if (this.strict != null) {
            generator.writeKey("strict");
            generator.write(this.strict);
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
     * Builder for {@link ToolAttributes}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ToolAttributes> {
        @Nullable
        private Map<String, JsonData> attributes;
        @Nullable
        private String inputSchema;
        @Nullable
        private Boolean strict;

        public Builder() {}

        private Builder(ToolAttributes o) {
            this.attributes = _mapCopy(o.attributes);
            this.inputSchema = o.inputSchema;
            this.strict = o.strict;
        }

        private Builder(Builder o) {
            this.attributes = _mapCopy(o.attributes);
            this.inputSchema = o.inputSchema;
            this.strict = o.strict;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>attributes</code>.
         * </p>
         */
        @Nonnull
        public final Builder attributes(Map<String, JsonData> map) {
            this.attributes = _mapPutAll(this.attributes, map);
            return this;
        }

        /**
         *
         * <p>
         * Adds an entry to <code>attributes</code>.
         * </p>
         */
        @Nonnull
        public final Builder attributes(String key, JsonData value) {
            this.attributes = _mapPut(this.attributes, key, value);
            return this;
        }

        /**
         * API name: {@code input_schema}
         */
        @Nonnull
        public final Builder inputSchema(@Nullable String value) {
            this.inputSchema = value;
            return this;
        }

        /**
         * API name: {@code strict}
         */
        @Nonnull
        public final Builder strict(@Nullable Boolean value) {
            this.strict = value;
            return this;
        }

        /**
         * Builds a {@link ToolAttributes}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ToolAttributes build() {
            _checkSingleUse();

            return new ToolAttributes(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ToolAttributes}
     */
    public static final JsonpDeserializer<ToolAttributes> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ToolAttributes::setupToolAttributesDeserializer
    );

    protected static void setupToolAttributesDeserializer(ObjectDeserializer<ToolAttributes.Builder> op) {
        op.add(Builder::inputSchema, JsonpDeserializer.stringDeserializer(), "input_schema");
        op.add(Builder::strict, JsonpDeserializer.booleanDeserializer(), "strict");
        op.setUnknownFieldHandler((builder, name, parser, mapper) -> {
            if (builder.attributes == null) {
                builder.attributes = new HashMap<>();
            }
            builder.attributes.put(name, JsonData._DESERIALIZER.deserialize(parser, mapper));
        });
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.attributes);
        result = 31 * result + Objects.hashCode(this.inputSchema);
        result = 31 * result + Objects.hashCode(this.strict);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ToolAttributes other = (ToolAttributes) o;
        return Objects.equals(this.attributes, other.attributes)
            && Objects.equals(this.inputSchema, other.inputSchema)
            && Objects.equals(this.strict, other.strict);
    }
}
