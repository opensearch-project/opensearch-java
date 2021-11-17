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

//----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------

package org.opensearch.clients.elasticsearch.core.reindex_rethrottle;

import org.opensearch.clients.elasticsearch._types.BaseNode;
import org.opensearch.clients.json.DelegatingDeserializer;
import org.opensearch.clients.json.JsonpDeserializable;
import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.JsonpMapper;
import org.opensearch.clients.json.ObjectBuilderDeserializer;
import org.opensearch.clients.util.MapBuilder;
import org.opensearch.clients.util.ModelTypeHelper;
import org.opensearch.clients.util.ObjectBuilder;
import jakarta.json.stream.JsonGenerator;
import java.lang.String;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;

// typedef: _global.reindex_rethrottle.ReindexNode
@JsonpDeserializable
public class ReindexNode extends BaseNode {
	private final Map<String, ReindexTask> tasks;

	// ---------------------------------------------------------------------------------------------

	private ReindexNode(Builder builder) {
		super(builder);

		this.tasks = ModelTypeHelper.unmodifiableRequired(builder.tasks, this, "tasks");

	}

	public static ReindexNode of(Function<Builder, ObjectBuilder<ReindexNode>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Required - API name: {@code tasks}
	 */
	public final Map<String, ReindexTask> tasks() {
		return this.tasks;
	}

	protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {

		super.serializeInternal(generator, mapper);
		if (ModelTypeHelper.isDefined(this.tasks)) {
			generator.writeKey("tasks");
			generator.writeStartObject();
			for (Map.Entry<String, ReindexTask> item0 : this.tasks.entrySet()) {
				generator.writeKey(item0.getKey());
				item0.getValue().serialize(generator, mapper);

			}
			generator.writeEnd();

		}

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link ReindexNode}.
	 */
	public static class Builder extends BaseNode.AbstractBuilder<Builder> implements ObjectBuilder<ReindexNode> {
		private Map<String, ReindexTask> tasks;

		/**
		 * Required - API name: {@code tasks}
		 */
		public final Builder tasks(Map<String, ReindexTask> value) {
			this.tasks = value;
			return this;
		}

		/**
		 * Set {@link #tasks(Map)} to a singleton map.
		 */
		public Builder tasks(String key, Function<ReindexTask.Builder, ObjectBuilder<ReindexTask>> fn) {
			return this.tasks(Collections.singletonMap(key, fn.apply(new ReindexTask.Builder()).build()));
		}

		public final Builder tasks(
				Function<MapBuilder<String, ReindexTask, ReindexTask.Builder>, ObjectBuilder<Map<String, ReindexTask>>> fn) {
			return tasks(fn.apply(new MapBuilder<>(ReindexTask.Builder::new)).build());
		}

		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link ReindexNode}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public ReindexNode build() {
			_checkSingleUse();

			return new ReindexNode(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link ReindexNode}
	 */
	public static final JsonpDeserializer<ReindexNode> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new,
			ReindexNode::setupReindexNodeDeserializer, Builder::build);

	protected static void setupReindexNodeDeserializer(DelegatingDeserializer<ReindexNode.Builder> op) {
		BaseNode.setupBaseNodeDeserializer(op);
		op.add(Builder::tasks, JsonpDeserializer.stringMapDeserializer(ReindexTask._DESERIALIZER), "tasks");

	}

}
