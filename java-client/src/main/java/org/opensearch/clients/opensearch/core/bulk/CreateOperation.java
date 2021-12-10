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

package org.opensearch.clients.opensearch.core.bulk;

import org.opensearch.clients.json.JsonpSerializer;
import org.opensearch.clients.json.NdJsonpSerializable;
import org.opensearch.clients.util.ApiTypeHelper;
import org.opensearch.clients.util.ObjectBuilder;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Function;
import javax.annotation.Nullable;

// typedef: _global.bulk.CreateOperation

/**
 *
 * @see <a href=
 *      "https://github.com/elastic/elasticsearch-specification/tree/98036c3/specification/_global/bulk/types.ts#L74-L74">API
 *      specification</a>
 */

public class CreateOperation<TDocument> extends WriteOperation implements NdJsonpSerializable, BulkOperationVariant {
	private final TDocument document;

	@Nullable
	private final JsonpSerializer<TDocument> tDocumentSerializer;

	// ---------------------------------------------------------------------------------------------

	private CreateOperation(Builder<TDocument> builder) {
		super(builder);
		this.document = ApiTypeHelper.requireNonNull(builder.document, this, "document");

		this.tDocumentSerializer = builder.tDocumentSerializer;

	}

	public static <TDocument> CreateOperation<TDocument> of(
			Function<Builder<TDocument>, ObjectBuilder<CreateOperation<TDocument>>> fn) {
		return fn.apply(new Builder<>()).build();
	}

	/**
	 * BulkOperation variant kind.
	 */
	@Override
	public BulkOperation.Kind _bulkOperationKind() {
		return BulkOperation.Kind.Create;
	}

	/**
	 * Required - API name: {@code document}
	 */
	public final TDocument document() {
		return this.document;
	}

	@Override
	public Iterator<?> _serializables() {
		return Arrays.asList(this, this.document).iterator();
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link CreateOperation}.
	 */

	public static class Builder<TDocument> extends WriteOperation.AbstractBuilder<Builder<TDocument>>
			implements
				ObjectBuilder<CreateOperation<TDocument>> {
		private TDocument document;

		/**
		 * Required - API name: {@code document}
		 */
		public final Builder<TDocument> document(TDocument value) {
			this.document = value;
			return this;
		}

		@Nullable
		private JsonpSerializer<TDocument> tDocumentSerializer;

		/**
		 * Serializer for TDocument. If not set, an attempt will be made to find a
		 * serializer from the JSON context.
		 */
		public final Builder<TDocument> tDocumentSerializer(@Nullable JsonpSerializer<TDocument> value) {
			this.tDocumentSerializer = value;
			return this;
		}

		@Override
		protected Builder<TDocument> self() {
			return this;
		}

		/**
		 * Builds a {@link CreateOperation}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public CreateOperation<TDocument> build() {
			_checkSingleUse();

			return new CreateOperation<TDocument>(this);
		}
	}

}
