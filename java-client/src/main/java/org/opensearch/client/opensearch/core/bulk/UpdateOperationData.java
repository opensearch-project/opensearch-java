/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.core.bulk;

import jakarta.json.stream.JsonGenerator;
import java.util.function.Function;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.JsonpSerializable;
import org.opensearch.client.json.JsonpSerializer;
import org.opensearch.client.json.JsonpUtils;
import org.opensearch.client.opensearch._types.Script;
import org.opensearch.client.opensearch.core.search.SourceConfig;
import org.opensearch.client.util.ObjectBuilder;

public class UpdateOperationData<TDocument> implements JsonpSerializable {
    @Nullable
    private final TDocument document;

    @Nullable
    private final Boolean docAsUpsert;

    @Nullable
    private final Boolean scriptedUpsert;

    @Nullable
    private final Boolean detectNoop;

    @Nullable
    private final TDocument upsert;

    @Nullable
    private final Script script;

    @Nullable
    private final JsonpSerializer<TDocument> tDocumentSerializer;

    @Nullable
    private final SourceConfig source;

    private UpdateOperationData(Builder<TDocument> builder) {
        this.document = builder.document;
        this.docAsUpsert = builder.docAsUpsert;
        this.scriptedUpsert = builder.scriptedUpsert;
        this.detectNoop = builder.detectNoop;
        this.script = builder.script;
        this.upsert = builder.upsert;
        this.tDocumentSerializer = builder.tDocumentSerializer;
        this.source = builder.source;
    }

    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        if (this.docAsUpsert != null) {
            generator.writeKey("doc_as_upsert");
            generator.write(this.docAsUpsert);
        }

        if (this.scriptedUpsert != null) {
            generator.writeKey("scripted_upsert");
            generator.write(scriptedUpsert);
        }

        if (this.detectNoop != null) {
            generator.writeKey("detect_noop");
            generator.write(detectNoop);
        }

        if (this.document != null) {
            generator.writeKey("doc");
            JsonpUtils.serialize(document, generator, tDocumentSerializer, mapper);
        }

        if (this.upsert != null) {
            generator.writeKey("upsert");
            JsonpUtils.serialize(upsert, generator, tDocumentSerializer, mapper);
        }

        if (this.script != null) {
            generator.writeKey("script");
            this.script.serialize(generator, mapper);
        }

        if (this.source != null) {
            generator.writeKey("_source");
            this.source.serialize(generator, mapper);
        }
    }

    /**
     * Builder for {@link UpdateOperationData}.
     */
    public static class Builder<TDocument> extends BulkOperationBase.AbstractBuilder<Builder<TDocument>>
        implements
            ObjectBuilder<UpdateOperationData<TDocument>> {

        @Nullable
        private TDocument document;

        @Nullable
        private JsonpSerializer<TDocument> tDocumentSerializer;

        @Nullable
        private Boolean docAsUpsert;

        @Nullable
        private Boolean scriptedUpsert;

        @Nullable
        private Boolean detectNoop;

        @Nullable
        private TDocument upsert;

        @Nullable
        private Script script;

        @Nullable
        private SourceConfig source;

        /**
         * API name: {@code document}
         */
        public final Builder<TDocument> document(TDocument value) {
            this.document = value;
            return this;
        }

        /**
         * API name: {@code docAsUpsert}
         */
        public final Builder<TDocument> docAsUpsert(@Nullable Boolean value) {
            this.docAsUpsert = value;
            return this;
        }

        /**
         * API name: {@code scripted_upsert}
         */
        public final Builder<TDocument> scriptedUpsert(@Nullable Boolean value) {
            this.scriptedUpsert = value;
            return this;
        }

        /**
         * API name: {@code detect_noop}
         */
        public final Builder<TDocument> detectNoop(@Nullable Boolean value) {
            this.detectNoop = value;
            return this;
        }

        /**
         * API name: {@code upsert}
         */
        public final Builder<TDocument> upsert(@Nullable TDocument value) {
            this.upsert = value;
            return this;
        }

        /**
         * API name: {@code script}
         */
        public final Builder<TDocument> script(@Nullable Script value) {
            this.script = value;
            return this;
        }

        /**
         * API name: {@code _source}
         */
        public final Builder<TDocument> source(@Nullable SourceConfig value) {
            this.source = value;
            return this;
        }

        /**
         * API name: {@code _source}
         */
        public final Builder<TDocument> source(Function<SourceConfig.Builder, ObjectBuilder<SourceConfig>> fn) {
            return this.source(fn.apply(new SourceConfig.Builder()).build());
        }

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
         * Builds a {@link UpdateOperationData}.
         *
         * @throws NullPointerException
         *             if some of the required fields are null.
         */
        public UpdateOperationData<TDocument> build() {
            _checkSingleUse();

            return new UpdateOperationData<TDocument>(this);
        }
    }
}
