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
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.JsonpSerializable;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.json.UnionDeserializer;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.TaggedUnion;
import org.opensearch.client.util.TaggedUnionUtils;

@JsonpDeserializable
public class KnnQueryRescore implements TaggedUnion<KnnQueryRescore.Kind, Object>, PlainJsonSerializable {
    public enum Kind {
        Enable,
        Context
    }

    private final Kind _kind;
    private final Object _value;

    @Override
    public Kind _kind() {
        return _kind;
    }

    @Override
    public Object _get() {
        return _value;
    }

    private KnnQueryRescore(Kind kind, Object value) {
        this._kind = kind;
        this._value = value;
    }

    private KnnQueryRescore(Builder builder) {
        this._kind = ApiTypeHelper.requireNonNull(builder._kind, builder, "<variant kind>");
        this._value = ApiTypeHelper.requireNonNull(builder._value, builder, "<variant value>");
    }

    public static KnnQueryRescore of(Function<Builder, ObjectBuilder<KnnQueryRescore>> fn) {
        return fn.apply(new Builder()).build();
    }

    public boolean isEnable() {
        return _kind == Kind.Enable;
    }

    public Boolean enable() {
        return TaggedUnionUtils.get(this, Kind.Enable);
    }

    public boolean isContext() {
        return _kind == Kind.Context;
    }

    public RescoreContext context() {
        return TaggedUnionUtils.get(this, Kind.Context);
    }

    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        if (_value instanceof JsonpSerializable) {
            ((JsonpSerializable) _value).serialize(generator, mapper);
        } else {
            switch (_kind) {
                case Enable:
                    generator.write((Boolean) _value);
                    break;
            }
        }
    }

    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<KnnQueryRescore> {
        private Kind _kind;
        private Object _value;

        public ObjectBuilder<KnnQueryRescore> enable(Boolean v) {
            this._kind = Kind.Enable;
            this._value = v;
            return this;
        }

        public ObjectBuilder<KnnQueryRescore> context(RescoreContext v) {
            this._kind = Kind.Context;
            this._value = v;
            return this;
        }

        @Override
        public KnnQueryRescore build() {
            _checkSingleUse();
            return new KnnQueryRescore(this);
        }
    }

    private static JsonpDeserializer<KnnQueryRescore> buildKnnQueryRescoreDeserializer() {
        return new UnionDeserializer.Builder<KnnQueryRescore, Kind, Object>(KnnQueryRescore::new, false).addMember(
            Kind.Enable,
            JsonpDeserializer.booleanDeserializer()
        ).addMember(Kind.Context, RescoreContext._DESERIALIZER).build();
    }

    public static final JsonpDeserializer<KnnQueryRescore> _DESERIALIZER = JsonpDeserializer.lazy(
        KnnQueryRescore::buildKnnQueryRescoreDeserializer
    );
}
