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

package org.opensearch.client.opensearch.core.search;

import jakarta.json.stream.JsonGenerator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonData;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.JsonpSerializer;
import org.opensearch.client.json.JsonpUtils;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: core.search.CompletionSuggestOption

@Generated("org.opensearch.client.codegen.CodeGenerator")
public class CompletionSuggestOption<TDocument>
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<CompletionSuggestOption.Builder<TDocument>, CompletionSuggestOption<TDocument>> {

    @Nullable
    private final Boolean collateMatch;

    @Nonnull
    private final Map<String, List<Context>> contexts;

    @Nonnull
    private final Map<String, JsonData> fields;

    @Nullable
    private final String id;

    @Nullable
    private final String index;

    @Nullable
    private final String routing;

    @Nullable
    private final Float score;

    @Nullable
    private final TDocument source;

    @Nullable
    private final JsonpSerializer<TDocument> tDocumentSerializer;

    @Nonnull
    private final String text;

    // ---------------------------------------------------------------------------------------------

    private CompletionSuggestOption(Builder<TDocument> builder) {
        this.collateMatch = builder.collateMatch;
        this.contexts = ApiTypeHelper.unmodifiable(builder.contexts);
        this.fields = ApiTypeHelper.unmodifiable(builder.fields);
        this.id = builder.id;
        this.index = builder.index;
        this.routing = builder.routing;
        this.score = builder.score;
        this.source = builder.source;
        this.tDocumentSerializer = builder.tDocumentSerializer;
        this.text = ApiTypeHelper.requireNonNull(builder.text, this, "text");
    }

    public static <TDocument> CompletionSuggestOption<TDocument> of(
        Function<CompletionSuggestOption.Builder<TDocument>, ObjectBuilder<CompletionSuggestOption<TDocument>>> fn
    ) {
        return fn.apply(new Builder<>()).build();
    }

    /**
     * API name: {@code collate_match}
     */
    @Nullable
    public final Boolean collateMatch() {
        return this.collateMatch;
    }

    /**
     * API name: {@code contexts}
     */
    @Nonnull
    public final Map<String, List<Context>> contexts() {
        return this.contexts;
    }

    /**
     * API name: {@code fields}
     */
    @Nonnull
    public final Map<String, JsonData> fields() {
        return this.fields;
    }

    /**
     * API name: {@code _id}
     */
    @Nullable
    public final String id() {
        return this.id;
    }

    /**
     * API name: {@code _index}
     */
    @Nullable
    public final String index() {
        return this.index;
    }

    /**
     * API name: {@code _routing}
     */
    @Nullable
    public final String routing() {
        return this.routing;
    }

    /**
     * API name: {@code _score}
     */
    @Nullable
    public final Float score() {
        return this.score;
    }

    /**
     * API name: {@code _source}
     */
    @Nullable
    public final TDocument source() {
        return this.source;
    }

    /**
     * Serializer for {@code TDocument}. If not set, an attempt will be made to find a serializer from the JSON context.
     */
    @Nullable
    public final JsonpSerializer<TDocument> tDocumentSerializer() {
        return this.tDocumentSerializer;
    }

    /**
     * Required - API name: {@code text}
     */
    @Nonnull
    public final String text() {
        return this.text;
    }

    /**
     * Serialize this object to JSON.
     */
    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        if (this.collateMatch != null) {
            generator.writeKey("collate_match");
            generator.write(this.collateMatch);
        }

        if (ApiTypeHelper.isDefined(this.contexts)) {
            generator.writeKey("contexts");
            generator.writeStartObject();
            for (Map.Entry<String, List<Context>> item0 : this.contexts.entrySet()) {
                generator.writeKey(item0.getKey());
                generator.writeStartArray();
                if (item0.getValue() != null) {
                    for (Context item1 : item0.getValue()) {
                        item1.serialize(generator, mapper);
                    }
                }
                generator.writeEnd();
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.fields)) {
            generator.writeKey("fields");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.fields.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.id != null) {
            generator.writeKey("_id");
            generator.write(this.id);
        }

        if (this.index != null) {
            generator.writeKey("_index");
            generator.write(this.index);
        }

        if (this.routing != null) {
            generator.writeKey("_routing");
            generator.write(this.routing);
        }

        if (this.score != null) {
            generator.writeKey("_score");
            generator.write(this.score);
        }

        if (this.source != null) {
            generator.writeKey("_source");
            JsonpUtils.serialize(this.source, generator, tDocumentSerializer, mapper);
        }

        generator.writeKey("text");
        generator.write(this.text);
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    @Nonnull
    public Builder<TDocument> toBuilder() {
        return new Builder<>(this);
    }

    @Nonnull
    public static <TDocument> Builder builder() {
        return new Builder<>();
    }

    /**
     * Builder for {@link CompletionSuggestOption}.
     */
    public static class Builder<TDocument> extends ObjectBuilderBase
        implements
            CopyableBuilder<Builder<TDocument>, CompletionSuggestOption<TDocument>> {
        @Nullable
        private Boolean collateMatch;
        @Nullable
        private Map<String, List<Context>> contexts;
        @Nullable
        private Map<String, JsonData> fields;
        @Nullable
        private String id;
        @Nullable
        private String index;
        @Nullable
        private String routing;
        @Nullable
        private Float score;
        @Nullable
        private TDocument source;
        @Nullable
        private JsonpSerializer<TDocument> tDocumentSerializer;
        private String text;

        public Builder() {}

        private Builder(CompletionSuggestOption<TDocument> o) {
            this.collateMatch = o.collateMatch;
            this.contexts = _mapCopy(o.contexts);
            this.fields = _mapCopy(o.fields);
            this.id = o.id;
            this.index = o.index;
            this.routing = o.routing;
            this.score = o.score;
            this.source = o.source;
            this.tDocumentSerializer = o.tDocumentSerializer;
            this.text = o.text;
        }

        private Builder(Builder<TDocument> o) {
            this.collateMatch = o.collateMatch;
            this.contexts = _mapCopy(o.contexts);
            this.fields = _mapCopy(o.fields);
            this.id = o.id;
            this.index = o.index;
            this.routing = o.routing;
            this.score = o.score;
            this.source = o.source;
            this.tDocumentSerializer = o.tDocumentSerializer;
            this.text = o.text;
        }

        @Override
        @Nonnull
        public Builder<TDocument> copy() {
            return new Builder<>(this);
        }

        /**
         * API name: {@code collate_match}
         */
        @Nonnull
        public final Builder<TDocument> collateMatch(@Nullable Boolean value) {
            this.collateMatch = value;
            return this;
        }

        /**
         * API name: {@code contexts}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>contexts</code>.
         * </p>
         */
        @Nonnull
        public final Builder<TDocument> contexts(Map<String, List<Context>> map) {
            this.contexts = _mapPutAll(this.contexts, map);
            return this;
        }

        /**
         * API name: {@code contexts}
         *
         * <p>
         * Adds an entry to <code>contexts</code>.
         * </p>
         */
        @Nonnull
        public final Builder<TDocument> contexts(String key, List<Context> value) {
            this.contexts = _mapPut(this.contexts, key, value);
            return this;
        }

        /**
         * API name: {@code fields}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>fields</code>.
         * </p>
         */
        @Nonnull
        public final Builder<TDocument> fields(Map<String, JsonData> map) {
            this.fields = _mapPutAll(this.fields, map);
            return this;
        }

        /**
         * API name: {@code fields}
         *
         * <p>
         * Adds an entry to <code>fields</code>.
         * </p>
         */
        @Nonnull
        public final Builder<TDocument> fields(String key, JsonData value) {
            this.fields = _mapPut(this.fields, key, value);
            return this;
        }

        /**
         * API name: {@code _id}
         */
        @Nonnull
        public final Builder<TDocument> id(@Nullable String value) {
            this.id = value;
            return this;
        }

        /**
         * API name: {@code _index}
         */
        @Nonnull
        public final Builder<TDocument> index(@Nullable String value) {
            this.index = value;
            return this;
        }

        /**
         * API name: {@code _routing}
         */
        @Nonnull
        public final Builder<TDocument> routing(@Nullable String value) {
            this.routing = value;
            return this;
        }

        /**
         * API name: {@code _score}
         */
        @Nonnull
        public final Builder<TDocument> score(@Nullable Float value) {
            this.score = value;
            return this;
        }

        /**
         * API name: {@code _source}
         */
        @Nonnull
        public final Builder<TDocument> source(@Nullable TDocument value) {
            this.source = value;
            return this;
        }

        /**
         * Serializer for {@code TDocument}. If not set, an attempt will be made to find a serializer from the JSON context.
         */
        @Nonnull
        public final Builder<TDocument> tDocumentSerializer(@Nullable JsonpSerializer<TDocument> value) {
            this.tDocumentSerializer = value;
            return this;
        }

        /**
         * Required - API name: {@code text}
         */
        @Nonnull
        public final Builder<TDocument> text(String value) {
            this.text = value;
            return this;
        }

        /**
         * Builds a {@link CompletionSuggestOption}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public CompletionSuggestOption<TDocument> build() {
            _checkSingleUse();

            return new CompletionSuggestOption<>(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Create a JSON deserializer for CompletionSuggestOption.
     */
    public static <TDocument> JsonpDeserializer<CompletionSuggestOption<TDocument>> createCompletionSuggestOptionDeserializer(
        JsonpDeserializer<TDocument> tDocumentDeserializer
    ) {
        return ObjectBuilderDeserializer.createForObject(
            Builder<TDocument>::new,
            op -> CompletionSuggestOption.setupCompletionSuggestOptionDeserializer(op, tDocumentDeserializer)
        );
    }

    protected static <TDocument> void setupCompletionSuggestOptionDeserializer(
        ObjectDeserializer<CompletionSuggestOption.Builder<TDocument>> op,
        JsonpDeserializer<TDocument> tDocumentDeserializer
    ) {
        op.add(Builder::collateMatch, JsonpDeserializer.booleanDeserializer(), "collate_match");
        op.add(
            Builder::contexts,
            JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.arrayDeserializer(Context._DESERIALIZER)),
            "contexts"
        );
        op.add(Builder::fields, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "fields");
        op.add(Builder::id, JsonpDeserializer.stringDeserializer(), "_id");
        op.add(Builder::index, JsonpDeserializer.stringDeserializer(), "_index");
        op.add(Builder::routing, JsonpDeserializer.stringDeserializer(), "_routing");
        op.add(Builder::score, JsonpDeserializer.floatDeserializer(), "_score");
        op.add(Builder::source, tDocumentDeserializer, "_source");
        op.add(Builder::text, JsonpDeserializer.stringDeserializer(), "text");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.collateMatch);
        result = 31 * result + Objects.hashCode(this.contexts);
        result = 31 * result + Objects.hashCode(this.fields);
        result = 31 * result + Objects.hashCode(this.id);
        result = 31 * result + Objects.hashCode(this.index);
        result = 31 * result + Objects.hashCode(this.routing);
        result = 31 * result + Objects.hashCode(this.score);
        result = 31 * result + Objects.hashCode(this.source);
        result = 31 * result + this.text.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CompletionSuggestOption<?> other = (CompletionSuggestOption<?>) o;
        return Objects.equals(this.collateMatch, other.collateMatch)
            && Objects.equals(this.contexts, other.contexts)
            && Objects.equals(this.fields, other.fields)
            && Objects.equals(this.id, other.id)
            && Objects.equals(this.index, other.index)
            && Objects.equals(this.routing, other.routing)
            && Objects.equals(this.score, other.score)
            && Objects.equals(this.source, other.source)
            && this.text.equals(other.text);
    }
}
