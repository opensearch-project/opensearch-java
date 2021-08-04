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

package org.opensearch.clients.opensearch.nodes;

import org.opensearch.clients.json.DelegatingDeserializer;
import org.opensearch.clients.json.JsonpDeserializable;
import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.JsonpMapper;
import org.opensearch.clients.json.JsonpSerializable;
import org.opensearch.clients.json.ObjectBuilderDeserializer;
import org.opensearch.clients.util.ModelTypeHelper;
import org.opensearch.clients.util.ObjectBuilder;
import org.opensearch.clients.util.ObjectBuilderBase;
import jakarta.json.stream.JsonGenerator;

import java.lang.Long;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

// typedef: nodes._types.FileSystem
@JsonpDeserializable
public class FileSystem implements JsonpSerializable {
	private final List<DataPathStats> data;

	private final long timestamp;

	private final FileSystemTotal total;

	// ---------------------------------------------------------------------------------------------

	private FileSystem(Builder builder) {

		this.data = ModelTypeHelper.unmodifiableRequired(builder.data, this, "data");
		this.timestamp = ModelTypeHelper.requireNonNull(builder.timestamp, this, "timestamp");
		this.total = ModelTypeHelper.requireNonNull(builder.total, this, "total");

	}

	public static FileSystem of(Function<Builder, ObjectBuilder<FileSystem>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Required - API name: {@code data}
	 */
	public final List<DataPathStats> data() {
		return this.data;
	}

	/**
	 * Required - API name: {@code timestamp}
	 */
	public final long timestamp() {
		return this.timestamp;
	}

	/**
	 * Required - API name: {@code total}
	 */
	public final FileSystemTotal total() {
		return this.total;
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

		if (ModelTypeHelper.isDefined(this.data)) {
			generator.writeKey("data");
			generator.writeStartArray();
			for (DataPathStats item0 : this.data) {
				item0.serialize(generator, mapper);

			}
			generator.writeEnd();

		}
		generator.writeKey("timestamp");
		generator.write(this.timestamp);

		generator.writeKey("total");
		this.total.serialize(generator, mapper);

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link FileSystem}.
	 */
	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<FileSystem> {
		private List<DataPathStats> data;

		private Long timestamp;

		private FileSystemTotal total;

		/**
		 * Required - API name: {@code data}
		 */
		public final Builder data(List<DataPathStats> value) {
			this.data = value;
			return this;
		}

		/**
		 * Required - API name: {@code data}
		 */
		public final Builder data(DataPathStats... value) {
			this.data = Arrays.asList(value);
			return this;
		}

		/**
		 * Required - API name: {@code data}
		 */
		@SafeVarargs
		public final Builder data(Function<DataPathStats.Builder, ObjectBuilder<DataPathStats>>... fns) {
			this.data = new ArrayList<>(fns.length);
			for (Function<DataPathStats.Builder, ObjectBuilder<DataPathStats>> fn : fns) {
				this.data.add(fn.apply(new DataPathStats.Builder()).build());
			}
			return this;
		}

		/**
		 * Required - API name: {@code timestamp}
		 */
		public final Builder timestamp(long value) {
			this.timestamp = value;
			return this;
		}

		/**
		 * Required - API name: {@code total}
		 */
		public final Builder total(FileSystemTotal value) {
			this.total = value;
			return this;
		}

		/**
		 * Required - API name: {@code total}
		 */
		public final Builder total(Function<FileSystemTotal.Builder, ObjectBuilder<FileSystemTotal>> fn) {
			return this.total(fn.apply(new FileSystemTotal.Builder()).build());
		}

		/**
		 * Builds a {@link FileSystem}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public FileSystem build() {
			_checkSingleUse();

			return new FileSystem(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link FileSystem}
	 */
	public static final JsonpDeserializer<FileSystem> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new,
			FileSystem::setupFileSystemDeserializer, Builder::build);

	protected static void setupFileSystemDeserializer(DelegatingDeserializer<FileSystem.Builder> op) {

		op.add(Builder::data, JsonpDeserializer.arrayDeserializer(DataPathStats._DESERIALIZER), "data");
		op.add(Builder::timestamp, JsonpDeserializer.longDeserializer(), "timestamp");
		op.add(Builder::total, FileSystemTotal._DESERIALIZER, "total");

	}

}
