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

package org.opensearch.clients.opensearch.indices.stats;

import jakarta.json.stream.JsonGenerator;
import org.opensearch.clients.json.DelegatingDeserializer;
import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.JsonpMapper;
import org.opensearch.clients.json.ObjectBuilderDeserializer;
import org.opensearch.clients.json.ToJsonp;
import org.opensearch.clients.util.ObjectBuilder;

import javax.annotation.Nullable;
import java.util.Objects;

// typedef: indices.stats.ShardFileSizeInfo
public final class ShardFileSizeInfo implements ToJsonp {
	private final String description;

	private final Number sizeInBytes;

	@Nullable
	private final Number minSizeInBytes;

	@Nullable
	private final Number maxSizeInBytes;

	@Nullable
	private final Number averageSizeInBytes;

	@Nullable
	private final Number count;

	// ---------------------------------------------------------------------------------------------

	protected ShardFileSizeInfo(Builder builder) {

		this.description = Objects.requireNonNull(builder.description, "description");
		this.sizeInBytes = Objects.requireNonNull(builder.sizeInBytes, "size_in_bytes");
		this.minSizeInBytes = builder.minSizeInBytes;
		this.maxSizeInBytes = builder.maxSizeInBytes;
		this.averageSizeInBytes = builder.averageSizeInBytes;
		this.count = builder.count;

	}

	/**
	 * API name: {@code description}
	 */
	public String description() {
		return this.description;
	}

	/**
	 * API name: {@code size_in_bytes}
	 */
	public Number sizeInBytes() {
		return this.sizeInBytes;
	}

	/**
	 * API name: {@code min_size_in_bytes}
	 */
	@Nullable
	public Number minSizeInBytes() {
		return this.minSizeInBytes;
	}

	/**
	 * API name: {@code max_size_in_bytes}
	 */
	@Nullable
	public Number maxSizeInBytes() {
		return this.maxSizeInBytes;
	}

	/**
	 * API name: {@code average_size_in_bytes}
	 */
	@Nullable
	public Number averageSizeInBytes() {
		return this.averageSizeInBytes;
	}

	/**
	 * API name: {@code count}
	 */
	@Nullable
	public Number count() {
		return this.count;
	}

	/**
	 * Serialize this object to JSON.
	 */
	public void toJsonp(JsonGenerator generator, JsonpMapper mapper) {
		generator.writeStartObject();
		toJsonpInternal(generator, mapper);
		generator.writeEnd();
	}

	protected void toJsonpInternal(JsonGenerator generator, JsonpMapper mapper) {

		generator.writeKey("description");
		generator.write(this.description);

		generator.writeKey("size_in_bytes");
		generator.write(this.sizeInBytes.doubleValue());

		if (this.minSizeInBytes != null) {

			generator.writeKey("min_size_in_bytes");
			generator.write(this.minSizeInBytes.doubleValue());

		}
		if (this.maxSizeInBytes != null) {

			generator.writeKey("max_size_in_bytes");
			generator.write(this.maxSizeInBytes.doubleValue());

		}
		if (this.averageSizeInBytes != null) {

			generator.writeKey("average_size_in_bytes");
			generator.write(this.averageSizeInBytes.doubleValue());

		}
		if (this.count != null) {

			generator.writeKey("count");
			generator.write(this.count.doubleValue());

		}

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link ShardFileSizeInfo}.
	 */
	public static class Builder implements ObjectBuilder<ShardFileSizeInfo> {
		private String description;

		private Number sizeInBytes;

		@Nullable
		private Number minSizeInBytes;

		@Nullable
		private Number maxSizeInBytes;

		@Nullable
		private Number averageSizeInBytes;

		@Nullable
		private Number count;

		/**
		 * API name: {@code description}
		 */
		public Builder description(String value) {
			this.description = value;
			return this;
		}

		/**
		 * API name: {@code size_in_bytes}
		 */
		public Builder sizeInBytes(Number value) {
			this.sizeInBytes = value;
			return this;
		}

		/**
		 * API name: {@code min_size_in_bytes}
		 */
		public Builder minSizeInBytes(@Nullable Number value) {
			this.minSizeInBytes = value;
			return this;
		}

		/**
		 * API name: {@code max_size_in_bytes}
		 */
		public Builder maxSizeInBytes(@Nullable Number value) {
			this.maxSizeInBytes = value;
			return this;
		}

		/**
		 * API name: {@code average_size_in_bytes}
		 */
		public Builder averageSizeInBytes(@Nullable Number value) {
			this.averageSizeInBytes = value;
			return this;
		}

		/**
		 * API name: {@code count}
		 */
		public Builder count(@Nullable Number value) {
			this.count = value;
			return this;
		}

		/**
		 * Builds a {@link ShardFileSizeInfo}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public ShardFileSizeInfo build() {

			return new ShardFileSizeInfo(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for ShardFileSizeInfo
	 */
	public static final JsonpDeserializer<ShardFileSizeInfo> DESERIALIZER = ObjectBuilderDeserializer
			.createForObject(Builder::new, ShardFileSizeInfo::setupShardFileSizeInfoDeserializer);

	protected static void setupShardFileSizeInfoDeserializer(DelegatingDeserializer<ShardFileSizeInfo.Builder> op) {

		op.add(Builder::description, JsonpDeserializer.stringDeserializer(), "description");
		op.add(Builder::sizeInBytes, JsonpDeserializer.numberDeserializer(), "size_in_bytes");
		op.add(Builder::minSizeInBytes, JsonpDeserializer.numberDeserializer(), "min_size_in_bytes");
		op.add(Builder::maxSizeInBytes, JsonpDeserializer.numberDeserializer(), "max_size_in_bytes");
		op.add(Builder::averageSizeInBytes, JsonpDeserializer.numberDeserializer(), "average_size_in_bytes");
		op.add(Builder::count, JsonpDeserializer.numberDeserializer(), "count");

	}

}
