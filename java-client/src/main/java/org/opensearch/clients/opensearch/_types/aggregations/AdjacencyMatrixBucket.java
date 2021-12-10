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

package org.opensearch.clients.opensearch._types.aggregations;

import org.opensearch.clients.json.JsonpDeserializable;
import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.ObjectBuilderDeserializer;
import org.opensearch.clients.json.ObjectDeserializer;
import org.opensearch.clients.util.ObjectBuilder;

import java.util.function.Function;

// typedef: _types.aggregations.AdjacencyMatrixBucket

/**
 *
 * @see <a href=
 *      "https://github.com/elastic/elasticsearch-specification/tree/98036c3/specification/_types/aggregations/Aggregate.ts#L542-L542">API
 *      specification</a>
 */
@JsonpDeserializable
public class AdjacencyMatrixBucket extends MultiBucketBase {
	// ---------------------------------------------------------------------------------------------

	private AdjacencyMatrixBucket(Builder builder) {
		super(builder);

	}

	public static AdjacencyMatrixBucket of(Function<Builder, ObjectBuilder<AdjacencyMatrixBucket>> fn) {
		return fn.apply(new Builder()).build();
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link AdjacencyMatrixBucket}.
	 */

	public static class Builder extends MultiBucketBase.AbstractBuilder<Builder>
			implements
				ObjectBuilder<AdjacencyMatrixBucket> {
		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link AdjacencyMatrixBucket}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public AdjacencyMatrixBucket build() {
			_checkSingleUse();

			return new AdjacencyMatrixBucket(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link AdjacencyMatrixBucket}
	 */
	public static final JsonpDeserializer<AdjacencyMatrixBucket> _DESERIALIZER = ObjectBuilderDeserializer
			.lazy(Builder::new, AdjacencyMatrixBucket::setupAdjacencyMatrixBucketDeserializer);

	protected static void setupAdjacencyMatrixBucketDeserializer(ObjectDeserializer<AdjacencyMatrixBucket.Builder> op) {
		MultiBucketBase.setupMultiBucketBaseDeserializer(op);

	}

}
