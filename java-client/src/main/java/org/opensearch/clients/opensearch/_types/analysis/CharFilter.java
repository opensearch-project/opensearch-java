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

package org.opensearch.clients.opensearch._types.analysis;

import org.opensearch.clients.json.DelegatingDeserializer;
import org.opensearch.clients.json.JsonpDeserializable;
import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.JsonpMapper;
import org.opensearch.clients.json.JsonpSerializable;
import org.opensearch.clients.json.ObjectBuilderDeserializer;
import org.opensearch.clients.util.ModelTypeHelper;
import org.opensearch.clients.util.ObjectBuilder;
import org.opensearch.clients.util.ObjectBuilderBase;
import org.opensearch.clients.util.TaggedUnion;
import org.opensearch.clients.util.TaggedUnionUtils;
import jakarta.json.stream.JsonGenerator;

import java.util.function.Function;

// typedef: _types.analysis.CharFilter
@JsonpDeserializable
public class CharFilter implements TaggedUnion<CharFilterVariant>, JsonpSerializable {

	public static final String HTML_STRIP = "html_strip";
	public static final String ICU_NORMALIZER = "icu_normalizer";
	public static final String KUROMOJI_ITERATION_MARK = "kuromoji_iteration_mark";
	public static final String MAPPING = "mapping";
	public static final String PATTERN_REPLACE = "pattern_replace";

	// Tagged union implementation

	private final String _type;
	private final CharFilterVariant _value;

	@Override
	public final String _type() {
		return _type;
	}

	@Override
	public final CharFilterVariant _get() {
		return _value;
	}

	public CharFilter(CharFilterVariant value) {

		this._type = ModelTypeHelper.requireNonNull(value._variantType(), this, "<variant type>");
		this._value = ModelTypeHelper.requireNonNull(value, this, "<variant value>");

	}

	private CharFilter(Builder builder) {

		this._type = ModelTypeHelper.requireNonNull(builder._type, builder, "<variant type>");
		this._value = ModelTypeHelper.requireNonNull(builder._value, builder, "<variant value>");

	}

	public static CharFilter of(Function<Builder, ObjectBuilder<CharFilter>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Get the {@code html_strip} variant value.
	 *
	 * @throws IllegalStateException
	 *             if the current variant is not of the {@code html_strip} kind.
	 */
	public HtmlStripCharFilter htmlStrip() {
		return TaggedUnionUtils.get(this, HTML_STRIP);
	}

	/**
	 * Get the {@code icu_normalizer} variant value.
	 *
	 * @throws IllegalStateException
	 *             if the current variant is not of the {@code icu_normalizer} kind.
	 */
	public IcuNormalizationCharFilter icuNormalizer() {
		return TaggedUnionUtils.get(this, ICU_NORMALIZER);
	}

	/**
	 * Get the {@code kuromoji_iteration_mark} variant value.
	 *
	 * @throws IllegalStateException
	 *             if the current variant is not of the
	 *             {@code kuromoji_iteration_mark} kind.
	 */
	public KuromojiIterationMarkCharFilter kuromojiIterationMark() {
		return TaggedUnionUtils.get(this, KUROMOJI_ITERATION_MARK);
	}

	/**
	 * Get the {@code mapping} variant value.
	 *
	 * @throws IllegalStateException
	 *             if the current variant is not of the {@code mapping} kind.
	 */
	public MappingCharFilter mapping() {
		return TaggedUnionUtils.get(this, MAPPING);
	}

	/**
	 * Get the {@code pattern_replace} variant value.
	 *
	 * @throws IllegalStateException
	 *             if the current variant is not of the {@code pattern_replace}
	 *             kind.
	 */
	public PatternReplaceCharFilter patternReplace() {
		return TaggedUnionUtils.get(this, PATTERN_REPLACE);
	}

	@Override
	public void serialize(JsonGenerator generator, JsonpMapper mapper) {

		mapper.serialize(_value, generator);

	}

	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<CharFilter> {
		private String _type;
		private CharFilterVariant _value;

		public Builder htmlStrip(HtmlStripCharFilter v) {
			this._type = HTML_STRIP;
			this._value = v;
			return this;
		}

		public Builder htmlStrip(Function<HtmlStripCharFilter.Builder, ObjectBuilder<HtmlStripCharFilter>> f) {
			return this.htmlStrip(f.apply(new HtmlStripCharFilter.Builder()).build());
		}

		public Builder icuNormalizer(IcuNormalizationCharFilter v) {
			this._type = ICU_NORMALIZER;
			this._value = v;
			return this;
		}

		public Builder icuNormalizer(
				Function<IcuNormalizationCharFilter.Builder, ObjectBuilder<IcuNormalizationCharFilter>> f) {
			return this.icuNormalizer(f.apply(new IcuNormalizationCharFilter.Builder()).build());
		}

		public Builder kuromojiIterationMark(KuromojiIterationMarkCharFilter v) {
			this._type = KUROMOJI_ITERATION_MARK;
			this._value = v;
			return this;
		}

		public Builder kuromojiIterationMark(
				Function<KuromojiIterationMarkCharFilter.Builder, ObjectBuilder<KuromojiIterationMarkCharFilter>> f) {
			return this.kuromojiIterationMark(f.apply(new KuromojiIterationMarkCharFilter.Builder()).build());
		}

		public Builder mapping(MappingCharFilter v) {
			this._type = MAPPING;
			this._value = v;
			return this;
		}

		public Builder mapping(Function<MappingCharFilter.Builder, ObjectBuilder<MappingCharFilter>> f) {
			return this.mapping(f.apply(new MappingCharFilter.Builder()).build());
		}

		public Builder patternReplace(PatternReplaceCharFilter v) {
			this._type = PATTERN_REPLACE;
			this._value = v;
			return this;
		}

		public Builder patternReplace(
				Function<PatternReplaceCharFilter.Builder, ObjectBuilder<PatternReplaceCharFilter>> f) {
			return this.patternReplace(f.apply(new PatternReplaceCharFilter.Builder()).build());
		}

		public CharFilter build() {
			_checkSingleUse();
			return new CharFilter(this);
		}

	}

	protected static void setupCharFilterDeserializer(DelegatingDeserializer<Builder> op) {

		op.add(Builder::htmlStrip, HtmlStripCharFilter._DESERIALIZER, "html_strip");
		op.add(Builder::icuNormalizer, IcuNormalizationCharFilter._DESERIALIZER, "icu_normalizer");
		op.add(Builder::kuromojiIterationMark, KuromojiIterationMarkCharFilter._DESERIALIZER,
				"kuromoji_iteration_mark");
		op.add(Builder::mapping, MappingCharFilter._DESERIALIZER, "mapping");
		op.add(Builder::patternReplace, PatternReplaceCharFilter._DESERIALIZER, "pattern_replace");

		op.setTypeProperty("type");

	}

	public static final JsonpDeserializer<CharFilter> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new,
			CharFilter::setupCharFilterDeserializer, Builder::build);
}
