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

package org.opensearch.client.opensearch.cluster;

import jakarta.json.stream.JsonGenerator;
import org.opensearch.client.json.DelegatingDeserializer;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ToJsonp;
import org.opensearch.client.util.ObjectBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

// typedef: cluster._types.ClusterStateDeletedSnapshots
public final class ClusterStateDeletedSnapshots implements ToJsonp {
	private final List<String> snapshotDeletions;

	// ---------------------------------------------------------------------------------------------

	protected ClusterStateDeletedSnapshots(Builder builder) {

		this.snapshotDeletions = Objects.requireNonNull(builder.snapshotDeletions, "snapshot_deletions");

	}

	/**
	 * API name: {@code snapshot_deletions}
	 */
	public List<String> snapshotDeletions() {
		return this.snapshotDeletions;
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

		generator.writeKey("snapshot_deletions");
		generator.writeStartArray();
		for (String item0 : this.snapshotDeletions) {
			generator.write(item0);

		}
		generator.writeEnd();

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link ClusterStateDeletedSnapshots}.
	 */
	public static class Builder implements ObjectBuilder<ClusterStateDeletedSnapshots> {
		private List<String> snapshotDeletions;

		/**
		 * API name: {@code snapshot_deletions}
		 */
		public Builder snapshotDeletions(List<String> value) {
			this.snapshotDeletions = value;
			return this;
		}

		/**
		 * API name: {@code snapshot_deletions}
		 */
		public Builder snapshotDeletions(String... value) {
			this.snapshotDeletions = Arrays.asList(value);
			return this;
		}

		/**
		 * Add a value to {@link #snapshotDeletions(List)}, creating the list if needed.
		 */
		public Builder addSnapshotDeletions(String value) {
			if (this.snapshotDeletions == null) {
				this.snapshotDeletions = new ArrayList<>();
			}
			this.snapshotDeletions.add(value);
			return this;
		}

		/**
		 * Builds a {@link ClusterStateDeletedSnapshots}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public ClusterStateDeletedSnapshots build() {

			return new ClusterStateDeletedSnapshots(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for ClusterStateDeletedSnapshots
	 */
	public static final JsonpDeserializer<ClusterStateDeletedSnapshots> DESERIALIZER = ObjectBuilderDeserializer
			.createForObject(Builder::new, ClusterStateDeletedSnapshots::setupClusterStateDeletedSnapshotsDeserializer);

	protected static void setupClusterStateDeletedSnapshotsDeserializer(
			DelegatingDeserializer<ClusterStateDeletedSnapshots.Builder> op) {

		op.add(Builder::snapshotDeletions, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()),
				"snapshot_deletions");

	}

}
