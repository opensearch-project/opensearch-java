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

package org.opensearch.clients.elasticsearch.ingest;

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
import java.lang.Long;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import javax.annotation.Nullable;

// typedef: ingest._types.PipelineConfig
@JsonpDeserializable
public class PipelineConfig implements JsonpSerializable {
	@Nullable
	private final String description;

	@Nullable
	private final Long version;

	private final List<Processor> processors;

	// ---------------------------------------------------------------------------------------------

	private PipelineConfig(Builder builder) {

		this.description = builder.description;
		this.version = builder.version;
		this.processors = ModelTypeHelper.unmodifiableRequired(builder.processors, this, "processors");

	}

	public static PipelineConfig of(Function<Builder, ObjectBuilder<PipelineConfig>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * API name: {@code description}
	 */
	@Nullable
	public final String description() {
		return this.description;
	}

	/**
	 * API name: {@code version}
	 */
	@Nullable
	public final Long version() {
		return this.version;
	}

	/**
	 * Required - API name: {@code processors}
	 */
	public final List<Processor> processors() {
		return this.processors;
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

		if (this.description != null) {
			generator.writeKey("description");
			generator.write(this.description);

		}
		if (this.version != null) {
			generator.writeKey("version");
			generator.write(this.version);

		}
		if (ModelTypeHelper.isDefined(this.processors)) {
			generator.writeKey("processors");
			generator.writeStartArray();
			for (Processor item0 : this.processors) {
				item0.serialize(generator, mapper);

			}
			generator.writeEnd();

		}

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link PipelineConfig}.
	 */
	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<PipelineConfig> {
		@Nullable
		private String description;

		@Nullable
		private Long version;

		private List<Processor> processors;

		/**
		 * API name: {@code description}
		 */
		public final Builder description(@Nullable String value) {
			this.description = value;
			return this;
		}

		/**
		 * API name: {@code version}
		 */
		public final Builder version(@Nullable Long value) {
			this.version = value;
			return this;
		}

		/**
		 * Required - API name: {@code processors}
		 */
		public final Builder processors(List<Processor> value) {
			this.processors = value;
			return this;
		}

		/**
		 * Required - API name: {@code processors}
		 */
		public final Builder processors(Processor... value) {
			this.processors = Arrays.asList(value);
			return this;
		}

		/**
		 * Required - API name: {@code processors}
		 */
		@SafeVarargs
		public final Builder processors(Function<Processor.Builder, ObjectBuilder<Processor>>... fns) {
			this.processors = new ArrayList<>(fns.length);
			for (Function<Processor.Builder, ObjectBuilder<Processor>> fn : fns) {
				this.processors.add(fn.apply(new Processor.Builder()).build());
			}
			return this;
		}

		/**
		 * Builds a {@link PipelineConfig}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public PipelineConfig build() {
			_checkSingleUse();

			return new PipelineConfig(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link PipelineConfig}
	 */
	public static final JsonpDeserializer<PipelineConfig> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new,
			PipelineConfig::setupPipelineConfigDeserializer, Builder::build);

	protected static void setupPipelineConfigDeserializer(DelegatingDeserializer<PipelineConfig.Builder> op) {

		op.add(Builder::description, JsonpDeserializer.stringDeserializer(), "description");
		op.add(Builder::version, JsonpDeserializer.longDeserializer(), "version");
		op.add(Builder::processors, JsonpDeserializer.arrayDeserializer(Processor._DESERIALIZER), "processors");

	}

}
