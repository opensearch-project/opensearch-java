/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch._types.query_dsl;

import jakarta.json.stream.JsonGenerator;
import java.util.function.Function;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

@JsonpDeserializable
public class RescoreContext implements PlainJsonSerializable {
    @Nullable
    private final Float oversampleFactor;

    private RescoreContext(Builder builder) {
        this.oversampleFactor = builder.oversampleFactor;
    }

    public static RescoreContext of(Function<Builder, ObjectBuilder<RescoreContext>> fn) {
        return fn.apply(new Builder()).build();
    }

    @Nullable
    public Float oversampleFactor() {
        return this.oversampleFactor;
    }

    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        if (this.oversampleFactor != null) {
            generator.writeKey("oversample_factor");
            generator.write(this.oversampleFactor);
        }
    }

    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<RescoreContext> {
        @Nullable
        private Float oversampleFactor;

        public Builder oversampleFactor(@Nullable Float value) {
            this.oversampleFactor = value;
            return this;
        }

        @Override
        public RescoreContext build() {
            _checkSingleUse();
            return new RescoreContext(this);
        }
    }

    public static final JsonpDeserializer<RescoreContext> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RescoreContext::setupRescoreContextDeserializer
    );

    protected static void setupRescoreContextDeserializer(ObjectDeserializer<Builder> op) {
        op.add(Builder::oversampleFactor, JsonpDeserializer.floatDeserializer(), "oversample_factor");
    }
}
