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

package org.opensearch.clients.elasticsearch.cluster.allocation_explain;

import org.opensearch.clients.json.JsonpDeserializable;
import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.JsonpMapper;
import org.opensearch.clients.json.JsonpSerializable;
import org.opensearch.clients.json.ObjectBuilderDeserializer;
import org.opensearch.clients.json.ObjectDeserializer;
import org.opensearch.clients.util.ApiTypeHelper;
import org.opensearch.clients.util.ObjectBuilder;
import org.opensearch.clients.util.ObjectBuilderBase;
import jakarta.json.stream.JsonGenerator;
import java.lang.String;
import java.util.function.Function;

// typedef: cluster.allocation_explain.AllocationDecision

/**
 *
 * @see <a href=
 *      "https://github.com/elastic/elasticsearch-specification/tree/98036c3/specification/cluster/allocation_explain/types.ts#L26-L30">API
 *      specification</a>
 */
@JsonpDeserializable
public class AllocationDecision implements JsonpSerializable {
	private final String decider;

	private final AllocationExplainDecision decision;

	private final String explanation;

	// ---------------------------------------------------------------------------------------------

	private AllocationDecision(Builder builder) {

		this.decider = ApiTypeHelper.requireNonNull(builder.decider, this, "decider");
		this.decision = ApiTypeHelper.requireNonNull(builder.decision, this, "decision");
		this.explanation = ApiTypeHelper.requireNonNull(builder.explanation, this, "explanation");

	}

	public static AllocationDecision of(Function<Builder, ObjectBuilder<AllocationDecision>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Required - API name: {@code decider}
	 */
	public final String decider() {
		return this.decider;
	}

	/**
	 * Required - API name: {@code decision}
	 */
	public final AllocationExplainDecision decision() {
		return this.decision;
	}

	/**
	 * Required - API name: {@code explanation}
	 */
	public final String explanation() {
		return this.explanation;
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

		generator.writeKey("decider");
		generator.write(this.decider);

		generator.writeKey("decision");
		this.decision.serialize(generator, mapper);
		generator.writeKey("explanation");
		generator.write(this.explanation);

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link AllocationDecision}.
	 */

	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<AllocationDecision> {
		private String decider;

		private AllocationExplainDecision decision;

		private String explanation;

		/**
		 * Required - API name: {@code decider}
		 */
		public final Builder decider(String value) {
			this.decider = value;
			return this;
		}

		/**
		 * Required - API name: {@code decision}
		 */
		public final Builder decision(AllocationExplainDecision value) {
			this.decision = value;
			return this;
		}

		/**
		 * Required - API name: {@code explanation}
		 */
		public final Builder explanation(String value) {
			this.explanation = value;
			return this;
		}

		/**
		 * Builds a {@link AllocationDecision}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public AllocationDecision build() {
			_checkSingleUse();

			return new AllocationDecision(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link AllocationDecision}
	 */
	public static final JsonpDeserializer<AllocationDecision> _DESERIALIZER = ObjectBuilderDeserializer
			.lazy(Builder::new, AllocationDecision::setupAllocationDecisionDeserializer);

	protected static void setupAllocationDecisionDeserializer(ObjectDeserializer<AllocationDecision.Builder> op) {

		op.add(Builder::decider, JsonpDeserializer.stringDeserializer(), "decider");
		op.add(Builder::decision, AllocationExplainDecision._DESERIALIZER, "decision");
		op.add(Builder::explanation, JsonpDeserializer.stringDeserializer(), "explanation");

	}

}
