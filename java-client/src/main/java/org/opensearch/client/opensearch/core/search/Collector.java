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

package org.opensearch.client.opensearch.core.search;

import org.opensearch.client.json.DelegatingDeserializer;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.JsonpSerializable;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.util.ModelTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import jakarta.json.stream.JsonGenerator;
import java.lang.Long;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import javax.annotation.Nullable;

// typedef: _global.search._types.Collector
@JsonpDeserializable
public class Collector implements JsonpSerializable {
	private final String name;

	private final String reason;

	private final long timeInNanos;

	private final List<Collector> children;

	// ---------------------------------------------------------------------------------------------

	private Collector(Builder builder) {

		this.name = ModelTypeHelper.requireNonNull(builder.name, this, "name");
		this.reason = ModelTypeHelper.requireNonNull(builder.reason, this, "reason");
		this.timeInNanos = ModelTypeHelper.requireNonNull(builder.timeInNanos, this, "timeInNanos");
		this.children = ModelTypeHelper.unmodifiable(builder.children);

	}

	public static Collector of(Function<Builder, ObjectBuilder<Collector>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Required - API name: {@code name}
	 */
	public final String name() {
		return this.name;
	}

	/**
	 * Required - API name: {@code reason}
	 */
	public final String reason() {
		return this.reason;
	}

	/**
	 * Required - API name: {@code time_in_nanos}
	 */
	public final long timeInNanos() {
		return this.timeInNanos;
	}

	/**
	 * API name: {@code children}
	 */
	public final List<Collector> children() {
		return this.children;
	}

	/**
	 * Serialize this object to JSON.
	 */
	public void serialize(JsonGenerator generator, JsonpMapper mapper) {
		generator.writeStartObject();
		serializeInternal(generator, mapper);
		generator.writeEnd();
	}

	protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {

		generator.writeKey("name");
		generator.write(this.name);

		generator.writeKey("reason");
		generator.write(this.reason);

		generator.writeKey("time_in_nanos");
		generator.write(this.timeInNanos);

		if (ModelTypeHelper.isDefined(this.children)) {
			generator.writeKey("children");
			generator.writeStartArray();
			for (Collector item0 : this.children) {
				item0.serialize(generator, mapper);

			}
			generator.writeEnd();

		}

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link Collector}.
	 */
	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<Collector> {
		private String name;

		private String reason;

		private Long timeInNanos;

		@Nullable
		private List<Collector> children;

		/**
		 * Required - API name: {@code name}
		 */
		public final Builder name(String value) {
			this.name = value;
			return this;
		}

		/**
		 * Required - API name: {@code reason}
		 */
		public final Builder reason(String value) {
			this.reason = value;
			return this;
		}

		/**
		 * Required - API name: {@code time_in_nanos}
		 */
		public final Builder timeInNanos(long value) {
			this.timeInNanos = value;
			return this;
		}

		/**
		 * API name: {@code children}
		 */
		public final Builder children(@Nullable List<Collector> value) {
			this.children = value;
			return this;
		}

		/**
		 * API name: {@code children}
		 */
		public final Builder children(Collector... value) {
			this.children = Arrays.asList(value);
			return this;
		}

		/**
		 * API name: {@code children}
		 */
		@SafeVarargs
		public final Builder children(Function<Collector.Builder, ObjectBuilder<Collector>>... fns) {
			this.children = new ArrayList<>(fns.length);
			for (Function<Collector.Builder, ObjectBuilder<Collector>> fn : fns) {
				this.children.add(fn.apply(new Collector.Builder()).build());
			}
			return this;
		}

		/**
		 * Builds a {@link Collector}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public Collector build() {
			_checkSingleUse();

			return new Collector(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link Collector}
	 */
	public static final JsonpDeserializer<Collector> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new,
			Collector::setupCollectorDeserializer, Builder::build);

	protected static void setupCollectorDeserializer(DelegatingDeserializer<Collector.Builder> op) {

		op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
		op.add(Builder::reason, JsonpDeserializer.stringDeserializer(), "reason");
		op.add(Builder::timeInNanos, JsonpDeserializer.longDeserializer(), "time_in_nanos");
		op.add(Builder::children, JsonpDeserializer.arrayDeserializer(Collector._DESERIALIZER), "children");

	}

}
