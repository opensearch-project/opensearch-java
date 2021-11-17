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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

// typedef: snapshot.status.Response
@JsonpDeserializable
public class StatusResponse implements JsonpSerializable {
	private final List<Status> snapshots;

	// ---------------------------------------------------------------------------------------------

	private StatusResponse(Builder builder) {

		this.snapshots = ModelTypeHelper.unmodifiableRequired(builder.snapshots, this, "snapshots");

	}

	public static StatusResponse of(Function<Builder, ObjectBuilder<StatusResponse>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Required - API name: {@code snapshots}
	 */
	public final List<Status> snapshots() {
		return this.snapshots;
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

		if (ModelTypeHelper.isDefined(this.snapshots)) {
			generator.writeKey("snapshots");
			generator.writeStartArray();
			for (Status item0 : this.snapshots) {
				item0.serialize(generator, mapper);

			}
			generator.writeEnd();

		}

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link StatusResponse}.
	 */
	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<StatusResponse> {
		private List<Status> snapshots;

		/**
		 * Required - API name: {@code snapshots}
		 */
		public final Builder snapshots(List<Status> value) {
			this.snapshots = value;
			return this;
		}

		/**
		 * Required - API name: {@code snapshots}
		 */
		public final Builder snapshots(Status... value) {
			this.snapshots = Arrays.asList(value);
			return this;
		}

		/**
		 * Required - API name: {@code snapshots}
		 */
		@SafeVarargs
		public final Builder snapshots(Function<Status.Builder, ObjectBuilder<Status>>... fns) {
			this.snapshots = new ArrayList<>(fns.length);
			for (Function<Status.Builder, ObjectBuilder<Status>> fn : fns) {
				this.snapshots.add(fn.apply(new Status.Builder()).build());
			}
			return this;
		}

		/**
		 * Builds a {@link StatusResponse}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public StatusResponse build() {
			_checkSingleUse();

			return new StatusResponse(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link StatusResponse}
	 */
	public static final JsonpDeserializer<StatusResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new,
			StatusResponse::setupStatusResponseDeserializer, Builder::build);

	protected static void setupStatusResponseDeserializer(DelegatingDeserializer<StatusResponse.Builder> op) {

		op.add(Builder::snapshots, JsonpDeserializer.arrayDeserializer(Status._DESERIALIZER), "snapshots");

	}

}
