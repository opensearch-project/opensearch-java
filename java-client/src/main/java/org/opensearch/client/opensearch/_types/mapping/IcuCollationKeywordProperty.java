/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch._types.mapping;

import jakarta.json.stream.JsonGenerator;
import java.util.function.Function;
import javax.annotation.Nullable;
import org.opensearch.client.json.*;
import org.opensearch.client.util.ObjectBuilder;

// typedef: _types.mapping.ICUCollationKeywordProperty

@JsonpDeserializable
public class IcuCollationKeywordProperty extends DocValuesPropertyBase implements PropertyVariant {

    @Nullable
    private final Boolean index;

    @Nullable
    private final String nullValue;

    // ---------------------------------------------------------------------------------------------

    private IcuCollationKeywordProperty(Builder builder) {
        super(builder);

        this.index = builder.index;
        this.nullValue = builder.nullValue;
    }

    public static IcuCollationKeywordProperty of(Function<Builder, ObjectBuilder<IcuCollationKeywordProperty>> fn) {
        return fn.apply(new Builder()).build();
    }

    @Override
    public Property.Kind _propertyKind() {
        return Property.Kind.IcuCollationKeyword;
    }

    /**
     * API name: {@code index}
     */
    @Nullable
    public final Boolean index() {
        return this.index;
    }

    /**
     * API name: {@code null_value}
     */
    @Nullable
    public final String nullValue() {
        return this.nullValue;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.write("type", "icu_collation_keyword");
        super.serializeInternal(generator, mapper);
        if (this.index != null) {
            generator.writeKey("index");
            generator.write(this.index);
        }
        if (this.nullValue != null) {
            generator.writeKey("null_value");
            generator.write(this.nullValue);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link IcuCollationKeywordProperty}.
     */

    public static class Builder extends DocValuesPropertyBase.AbstractBuilder<Builder>
        implements
            ObjectBuilder<IcuCollationKeywordProperty> {
        @Nullable
        private Boolean index;

        @Nullable
        private String nullValue;

        /**
         * API name: {@code index}
         */
        public final Builder index(@Nullable Boolean value) {
            this.index = value;
            return this;
        }

        /**
         * API name: {@code null_value}
         */
        public final Builder nullValue(@Nullable String value) {
            this.nullValue = value;
            return this;
        }

        @Override
        protected Builder self() {
            return this;
        }

        /**
         * Builds a {@link IcuCollationKeywordProperty}.
         *
         * @throws NullPointerException
         *             if some of the required fields are null.
         */
        public IcuCollationKeywordProperty build() {
            _checkSingleUse();
            return new IcuCollationKeywordProperty(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IcuCollationKeywordProperty}
     */
    public static final JsonpDeserializer<IcuCollationKeywordProperty> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IcuCollationKeywordProperty::setupIcuCollationKeywordPropertyDeserializer
    );

    protected static void setupIcuCollationKeywordPropertyDeserializer(ObjectDeserializer<IcuCollationKeywordProperty.Builder> op) {
        DocValuesPropertyBase.setupDocValuesPropertyBaseDeserializer(op);
        op.add(Builder::index, JsonpDeserializer.booleanDeserializer(), "index");
        op.add(Builder::nullValue, JsonpDeserializer.stringDeserializer(), "null_value");
    }
}
