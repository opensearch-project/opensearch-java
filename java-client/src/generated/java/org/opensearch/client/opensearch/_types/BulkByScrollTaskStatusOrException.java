/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

/*
 * Licensed to Elasticsearch B.V. under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch B.V. licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

/*
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
 */

//----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------

package org.opensearch.client.opensearch._types;

import jakarta.json.stream.JsonGenerator;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
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

// typedef: _types.BulkByScrollTaskStatusOrException

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class BulkByScrollTaskStatusOrException
    implements
        TaggedUnion<BulkByScrollTaskStatusOrException.Kind, Object>,
        PlainJsonSerializable {
    public enum Kind {
        Status,
        Exception
    }

    private final Kind _kind;
    private final Object _value;

    @Override
    public final Kind _kind() {
        return _kind;
    }

    @Override
    public final Object _get() {
        return _value;
    }

    private BulkByScrollTaskStatusOrException(Kind kind, Object value) {
        this._kind = kind;
        this._value = value;
    }

    private BulkByScrollTaskStatusOrException(Builder builder) {
        this._kind = ApiTypeHelper.requireNonNull(builder._kind, builder, "<variant kind>");
        this._value = ApiTypeHelper.requireNonNull(builder._value, builder, "<variant value>");
    }

    public static BulkByScrollTaskStatusOrException of(
        Function<BulkByScrollTaskStatusOrException.Builder, ObjectBuilder<BulkByScrollTaskStatusOrException>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Is this variant instance of kind {@code status}?
     */
    public boolean isStatus() {
        return _kind == Kind.Status;
    }

    /**
     * Get the {@code status} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code status} kind.
     */
    public BulkByScrollTaskStatus status() {
        return TaggedUnionUtils.get(this, Kind.Status);
    }

    /**
     * Is this variant instance of kind {@code exception}?
     */
    public boolean isException() {
        return _kind == Kind.Exception;
    }

    /**
     * Get the {@code exception} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code exception} kind.
     */
    public ErrorCause exception() {
        return TaggedUnionUtils.get(this, Kind.Exception);
    }

    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        if (_value instanceof JsonpSerializable) {
            ((JsonpSerializable) _value).serialize(generator, mapper);
        }
    }

    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<BulkByScrollTaskStatusOrException> {
        private Kind _kind;
        private Object _value;

        public ObjectBuilder<BulkByScrollTaskStatusOrException> status(BulkByScrollTaskStatus v) {
            this._kind = Kind.Status;
            this._value = v;
            return this;
        }

        public ObjectBuilder<BulkByScrollTaskStatusOrException> status(
            Function<BulkByScrollTaskStatus.Builder, ObjectBuilder<BulkByScrollTaskStatus>> fn
        ) {
            return this.status(fn.apply(new BulkByScrollTaskStatus.Builder()).build());
        }

        public ObjectBuilder<BulkByScrollTaskStatusOrException> exception(ErrorCause v) {
            this._kind = Kind.Exception;
            this._value = v;
            return this;
        }

        public ObjectBuilder<BulkByScrollTaskStatusOrException> exception(Function<ErrorCause.Builder, ObjectBuilder<ErrorCause>> fn) {
            return this.exception(fn.apply(new ErrorCause.Builder()).build());
        }

        @Override
        public BulkByScrollTaskStatusOrException build() {
            _checkSingleUse();
            return new BulkByScrollTaskStatusOrException(this);
        }
    }

    private static JsonpDeserializer<BulkByScrollTaskStatusOrException> buildBulkByScrollTaskStatusOrExceptionDeserializer() {
        return new UnionDeserializer.Builder<BulkByScrollTaskStatusOrException, Kind, Object>(BulkByScrollTaskStatusOrException::new, false)
            .addMember(Kind.Status, BulkByScrollTaskStatus._DESERIALIZER)
            .addMember(Kind.Exception, ErrorCause._DESERIALIZER)
            .build();
    }

    public static final JsonpDeserializer<BulkByScrollTaskStatusOrException> _DESERIALIZER = JsonpDeserializer.lazy(
        BulkByScrollTaskStatusOrException::buildBulkByScrollTaskStatusOrExceptionDeserializer
    );

    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this._kind);
        result = 31 * result + Objects.hashCode(this._value);
        return result;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        BulkByScrollTaskStatusOrException other = (BulkByScrollTaskStatusOrException) o;
        return Objects.equals(this._kind, other._kind) && Objects.equals(this._value, other._value);
    }
}
