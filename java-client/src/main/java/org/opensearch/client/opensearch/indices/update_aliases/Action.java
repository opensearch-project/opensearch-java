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

package org.opensearch.client.opensearch.indices.update_aliases;

import org.opensearch.client.json.DelegatingDeserializer;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.JsonpSerializable;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.util.ModelTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.TaggedUnion;
import org.opensearch.client.util.TaggedUnionUtils;
import jakarta.json.stream.JsonGenerator;

import java.lang.Object;
import java.util.function.Function;

// typedef: indices.update_aliases.Action
@JsonpDeserializable
public class Action implements TaggedUnion<Object>, JsonpSerializable {

	public static final String ADD = "add";
	public static final String REMOVE = "remove";
	public static final String REMOVE_INDEX = "remove_index";

	// Tagged union implementation

	private final String _type;
	private final Object _value;

	@Override
	public final String _type() {
		return _type;
	}

	@Override
	public final Object _get() {
		return _value;
	}

	public Action(ActionVariant value) {

		this._type = ModelTypeHelper.requireNonNull(value._variantType(), this, "<variant type>");
		this._value = ModelTypeHelper.requireNonNull(value, this, "<variant value>");

	}

	private Action(Builder builder) {

		this._type = ModelTypeHelper.requireNonNull(builder._type, builder, "<variant type>");
		this._value = ModelTypeHelper.requireNonNull(builder._value, builder, "<variant value>");

	}

	public static Action of(Function<Builder, ObjectBuilder<Action>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Get the {@code add} variant value.
	 *
	 * @throws IllegalStateException
	 *             if the current variant is not of the {@code add} kind.
	 */
	public AddAction add() {
		return TaggedUnionUtils.get(this, ADD);
	}

	/**
	 * Get the {@code remove} variant value.
	 *
	 * @throws IllegalStateException
	 *             if the current variant is not of the {@code remove} kind.
	 */
	public RemoveAction remove() {
		return TaggedUnionUtils.get(this, REMOVE);
	}

	/**
	 * Get the {@code remove_index} variant value.
	 *
	 * @throws IllegalStateException
	 *             if the current variant is not of the {@code remove_index} kind.
	 */
	public RemoveIndexAction removeIndex() {
		return TaggedUnionUtils.get(this, REMOVE_INDEX);
	}

	@Override
	@SuppressWarnings("unchecked")
	public void serialize(JsonGenerator generator, JsonpMapper mapper) {
		generator.writeStartObject();

		generator.writeKey(_type);
		if (_value instanceof JsonpSerializable) {
			((JsonpSerializable) _value).serialize(generator, mapper);
		}

		generator.writeEnd();
	}

	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<Action> {
		private String _type;
		private Object _value;

		public Builder add(AddAction v) {
			this._type = ADD;
			this._value = v;
			return this;
		}

		public Builder add(Function<AddAction.Builder, ObjectBuilder<AddAction>> f) {
			return this.add(f.apply(new AddAction.Builder()).build());
		}

		public Builder remove(RemoveAction v) {
			this._type = REMOVE;
			this._value = v;
			return this;
		}

		public Builder remove(Function<RemoveAction.Builder, ObjectBuilder<RemoveAction>> f) {
			return this.remove(f.apply(new RemoveAction.Builder()).build());
		}

		public Builder removeIndex(RemoveIndexAction v) {
			this._type = REMOVE_INDEX;
			this._value = v;
			return this;
		}

		public Builder removeIndex(Function<RemoveIndexAction.Builder, ObjectBuilder<RemoveIndexAction>> f) {
			return this.removeIndex(f.apply(new RemoveIndexAction.Builder()).build());
		}

		public Action build() {
			_checkSingleUse();
			return new Action(this);
		}

	}

	protected static void setupActionDeserializer(DelegatingDeserializer<Builder> op) {

		op.add(Builder::add, AddAction._DESERIALIZER, "add");
		op.add(Builder::remove, RemoveAction._DESERIALIZER, "remove");
		op.add(Builder::removeIndex, RemoveIndexAction._DESERIALIZER, "remove_index");

	}

	public static final JsonpDeserializer<Action> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new,
			Action::setupActionDeserializer, Builder::build);
}
