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

package org.opensearch.clients.elasticsearch.snapshot;

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

import java.util.function.Function;

// typedef: snapshot._types.SnapshotShardsStatus
@JsonpDeserializable
public class SnapshotShardsStatus implements JsonpSerializable {
	private final ShardsStatsStage stage;

	private final ShardsStatsSummary stats;

	// ---------------------------------------------------------------------------------------------

	private SnapshotShardsStatus(Builder builder) {

		this.stage = ModelTypeHelper.requireNonNull(builder.stage, this, "stage");
		this.stats = ModelTypeHelper.requireNonNull(builder.stats, this, "stats");

	}

	public static SnapshotShardsStatus of(Function<Builder, ObjectBuilder<SnapshotShardsStatus>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Required - API name: {@code stage}
	 */
	public final ShardsStatsStage stage() {
		return this.stage;
	}

	/**
	 * Required - API name: {@code stats}
	 */
	public final ShardsStatsSummary stats() {
		return this.stats;
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

		generator.writeKey("stage");
		this.stage.serialize(generator, mapper);
		generator.writeKey("stats");
		this.stats.serialize(generator, mapper);

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link SnapshotShardsStatus}.
	 */
	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<SnapshotShardsStatus> {
		private ShardsStatsStage stage;

		private ShardsStatsSummary stats;

		/**
		 * Required - API name: {@code stage}
		 */
		public final Builder stage(ShardsStatsStage value) {
			this.stage = value;
			return this;
		}

		/**
		 * Required - API name: {@code stats}
		 */
		public final Builder stats(ShardsStatsSummary value) {
			this.stats = value;
			return this;
		}

		/**
		 * Required - API name: {@code stats}
		 */
		public final Builder stats(Function<ShardsStatsSummary.Builder, ObjectBuilder<ShardsStatsSummary>> fn) {
			return this.stats(fn.apply(new ShardsStatsSummary.Builder()).build());
		}

		/**
		 * Builds a {@link SnapshotShardsStatus}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public SnapshotShardsStatus build() {
			_checkSingleUse();

			return new SnapshotShardsStatus(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link SnapshotShardsStatus}
	 */
	public static final JsonpDeserializer<SnapshotShardsStatus> _DESERIALIZER = ObjectBuilderDeserializer
			.lazy(Builder::new, SnapshotShardsStatus::setupSnapshotShardsStatusDeserializer, Builder::build);

	protected static void setupSnapshotShardsStatusDeserializer(
			DelegatingDeserializer<SnapshotShardsStatus.Builder> op) {

		op.add(Builder::stage, ShardsStatsStage._DESERIALIZER, "stage");
		op.add(Builder::stats, ShardsStatsSummary._DESERIALIZER, "stats");

	}

}
