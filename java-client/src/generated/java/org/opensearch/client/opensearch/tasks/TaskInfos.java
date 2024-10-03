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

package org.opensearch.client.opensearch.tasks;

import jakarta.json.stream.JsonGenerator;
import java.util.List;
import java.util.Map;
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

// typedef: tasks.TaskInfos

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class TaskInfos implements TaggedUnion<TaskInfos.Kind, Object>, PlainJsonSerializable {
    /**
     * {@link TaskInfos} variant kinds.
     */
    public enum Kind {
        GroupedByNone,
        GroupedByParents
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

    private TaskInfos(Kind kind, Object value) {
        this._kind = kind;
        this._value = value;
    }

    private TaskInfos(Builder builder) {
        this._kind = ApiTypeHelper.requireNonNull(builder._kind, builder, "<variant kind>");
        this._value = ApiTypeHelper.requireNonNull(builder._value, builder, "<variant value>");
    }

    public static TaskInfos of(Function<TaskInfos.Builder, ObjectBuilder<TaskInfos>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Is this variant instance of kind {@code grouped_by_none}?
     */
    public boolean isGroupedByNone() {
        return _kind == Kind.GroupedByNone;
    }

    /**
     * Get the {@code grouped_by_none} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code grouped_by_none} kind.
     */
    public List<TaskInfo> groupedByNone() {
        return TaggedUnionUtils.get(this, Kind.GroupedByNone);
    }

    /**
     * Is this variant instance of kind {@code grouped_by_parents}?
     */
    public boolean isGroupedByParents() {
        return _kind == Kind.GroupedByParents;
    }

    /**
     * Get the {@code grouped_by_parents} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code grouped_by_parents} kind.
     */
    public Map<String, TaskGroup> groupedByParents() {
        return TaggedUnionUtils.get(this, Kind.GroupedByParents);
    }

    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        if (_value instanceof JsonpSerializable) {
            ((JsonpSerializable) _value).serialize(generator, mapper);
        } else {
            switch (_kind) {
                case GroupedByNone:
                    generator.writeStartArray();
                    for (TaskInfo item0 : ((List<TaskInfo>) this._value)) {
                        item0.serialize(generator, mapper);
                    }
                    generator.writeEnd();
                    break;
                case GroupedByParents:
                    generator.writeStartObject();
                    for (Map.Entry<String, TaskGroup> item0 : ((Map<String, TaskGroup>) this._value).entrySet()) {
                        generator.writeKey(item0.getKey());
                        item0.getValue().serialize(generator, mapper);
                    }
                    generator.writeEnd();
                    break;
            }
        }
    }

    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<TaskInfos> {
        private Kind _kind;
        private Object _value;

        public ObjectBuilder<TaskInfos> groupedByNone(List<TaskInfo> v) {
            this._kind = Kind.GroupedByNone;
            this._value = v;
            return this;
        }

        public ObjectBuilder<TaskInfos> groupedByParents(Map<String, TaskGroup> v) {
            this._kind = Kind.GroupedByParents;
            this._value = v;
            return this;
        }

        @Override
        public TaskInfos build() {
            _checkSingleUse();
            return new TaskInfos(this);
        }
    }

    private static JsonpDeserializer<TaskInfos> buildTaskInfosDeserializer() {
        return new UnionDeserializer.Builder<TaskInfos, Kind, Object>(TaskInfos::new, false).addMember(
            Kind.GroupedByNone,
            JsonpDeserializer.arrayDeserializer(TaskInfo._DESERIALIZER)
        ).addMember(Kind.GroupedByParents, JsonpDeserializer.stringMapDeserializer(TaskGroup._DESERIALIZER)).build();
    }

    public static final JsonpDeserializer<TaskInfos> _DESERIALIZER = JsonpDeserializer.lazy(TaskInfos::buildTaskInfosDeserializer);

    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this._kind);
        result = 31 * result + Objects.hashCode(this._value);
        return result;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        TaskInfos other = (TaskInfos) o;
        return Objects.equals(this._kind, other._kind) && Objects.equals(this._value, other._value);
    }
}
