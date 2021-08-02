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

package org.opensearch.clients.opensearch.snapshot;

import jakarta.json.stream.JsonGenerator;
import org.opensearch.clients.json.DelegatingDeserializer;
import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.JsonpMapper;
import org.opensearch.clients.json.ObjectBuilderDeserializer;
import org.opensearch.clients.json.ToJsonp;
import org.opensearch.clients.util.ObjectBuilder;

import java.util.Objects;

// typedef: snapshot._types.FileCountSnapshotStats
public final class FileCountSnapshotStats implements ToJsonp {
	private final Number fileCount;

	private final Number sizeInBytes;

	// ---------------------------------------------------------------------------------------------

	protected FileCountSnapshotStats(Builder builder) {

		this.fileCount = Objects.requireNonNull(builder.fileCount, "file_count");
		this.sizeInBytes = Objects.requireNonNull(builder.sizeInBytes, "size_in_bytes");

	}

	/**
	 * API name: {@code file_count}
	 */
	public Number fileCount() {
		return this.fileCount;
	}

	/**
	 * API name: {@code size_in_bytes}
	 */
	public Number sizeInBytes() {
		return this.sizeInBytes;
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

		generator.writeKey("file_count");
		generator.write(this.fileCount.doubleValue());

		generator.writeKey("size_in_bytes");
		generator.write(this.sizeInBytes.doubleValue());

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link FileCountSnapshotStats}.
	 */
	public static class Builder implements ObjectBuilder<FileCountSnapshotStats> {
		private Number fileCount;

		private Number sizeInBytes;

		/**
		 * API name: {@code file_count}
		 */
		public Builder fileCount(Number value) {
			this.fileCount = value;
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
		 * Builds a {@link FileCountSnapshotStats}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public FileCountSnapshotStats build() {

			return new FileCountSnapshotStats(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for FileCountSnapshotStats
	 */
	public static final JsonpDeserializer<FileCountSnapshotStats> DESERIALIZER = ObjectBuilderDeserializer
			.createForObject(Builder::new, FileCountSnapshotStats::setupFileCountSnapshotStatsDeserializer);

	protected static void setupFileCountSnapshotStatsDeserializer(
			DelegatingDeserializer<FileCountSnapshotStats.Builder> op) {

		op.add(Builder::fileCount, JsonpDeserializer.numberDeserializer(), "file_count");
		op.add(Builder::sizeInBytes, JsonpDeserializer.numberDeserializer(), "size_in_bytes");

	}

}
