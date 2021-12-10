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

package org.opensearch.clients.opensearch.cat.help;

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
import java.util.function.Function;

// typedef: cat.help.HelpRecord

/**
 *
 * @see <a href=
 *      "https://github.com/elastic/elasticsearch-specification/tree/98036c3/specification/cat/help/types.ts#L20-L22">API
 *      specification</a>
 */
@JsonpDeserializable
public class HelpRecord implements JsonpSerializable {
	private final String endpoint;

	// ---------------------------------------------------------------------------------------------

	private HelpRecord(Builder builder) {

		this.endpoint = ApiTypeHelper.requireNonNull(builder.endpoint, this, "endpoint");

	}

	public static HelpRecord of(Function<Builder, ObjectBuilder<HelpRecord>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Required - API name: {@code endpoint}
	 */
	public final String endpoint() {
		return this.endpoint;
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

		generator.writeKey("endpoint");
		generator.write(this.endpoint);

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link HelpRecord}.
	 */

	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<HelpRecord> {
		private String endpoint;

		/**
		 * Required - API name: {@code endpoint}
		 */
		public final Builder endpoint(String value) {
			this.endpoint = value;
			return this;
		}

		/**
		 * Builds a {@link HelpRecord}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public HelpRecord build() {
			_checkSingleUse();

			return new HelpRecord(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link HelpRecord}
	 */
	public static final JsonpDeserializer<HelpRecord> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new,
			HelpRecord::setupHelpRecordDeserializer);

	protected static void setupHelpRecordDeserializer(ObjectDeserializer<HelpRecord.Builder> op) {

		op.add(Builder::endpoint, JsonpDeserializer.stringDeserializer(), "endpoint");

	}

}
