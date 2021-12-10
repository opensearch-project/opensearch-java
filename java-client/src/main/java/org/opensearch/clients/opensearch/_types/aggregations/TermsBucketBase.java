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

import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.JsonpMapper;
import org.opensearch.clients.json.ObjectDeserializer;
import jakarta.json.stream.JsonGenerator;
import javax.annotation.Nullable;

// typedef: _types.aggregations.TermsBucketBase

/**
 *
 * @see <a href=
 *      "https://github.com/elastic/elasticsearch-specification/tree/98036c3/specification/_types/aggregations/Aggregate.ts#L375-L377">API
 *      specification</a>
 */

public abstract class TermsBucketBase extends MultiBucketBase {
	@Nullable
	private final Long docCountError;

	// ---------------------------------------------------------------------------------------------

	protected TermsBucketBase(AbstractBuilder<?> builder) {
		super(builder);

		this.docCountError = builder.docCountError;

	}

	/**
	 * API name: {@code doc_count_error}
	 */
	@Nullable
	public final Long docCountError() {
		return this.docCountError;
	}

	protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {

		super.serializeInternal(generator, mapper);
		if (this.docCountError != null) {
			generator.writeKey("doc_count_error");
			generator.write(this.docCountError);

		}

	}

	protected abstract static class AbstractBuilder<BuilderT extends AbstractBuilder<BuilderT>>
			extends
				MultiBucketBase.AbstractBuilder<BuilderT> {
		@Nullable
		private Long docCountError;

		/**
		 * API name: {@code doc_count_error}
		 */
		public final BuilderT docCountError(@Nullable Long value) {
			this.docCountError = value;
			return self();
		}

	}

	// ---------------------------------------------------------------------------------------------
	protected static <BuilderT extends AbstractBuilder<BuilderT>> void setupTermsBucketBaseDeserializer(
			ObjectDeserializer<BuilderT> op) {
		MultiBucketBase.setupMultiBucketBaseDeserializer(op);
		op.add(AbstractBuilder::docCountError, JsonpDeserializer.longDeserializer(), "doc_count_error");

	}

}
