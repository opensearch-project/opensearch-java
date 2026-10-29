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

package org.opensearch.client.opensearch._helpers.bulk;

import java.io.OutputStream;
import java.util.Iterator;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonEnum;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.JsonpSerializer;
import org.opensearch.client.opensearch.core.bulk.BulkOperation;
import org.opensearch.client.opensearch.core.bulk.BulkOperationBase;
import org.opensearch.client.opensearch.core.bulk.CreateOperation;
import org.opensearch.client.opensearch.core.bulk.DeleteOperation;
import org.opensearch.client.opensearch.core.bulk.IndexOperation;
import org.opensearch.client.opensearch.core.bulk.UpdateOperation;
import org.opensearch.client.opensearch.core.bulk.UpdateOperationData;
import org.opensearch.client.util.BinaryData;
import org.opensearch.client.util.ContentType;
import org.opensearch.client.util.NoCopyByteArrayOutputStream;

/**
 * A bulk operation whose size has been calculated and content turned to a binary blob (to compute its size).
 * <p>
 * This class wraps a {@link RetryableBulkOperation} and calculates the estimated byte size that the operation
 * will occupy in the bulk request payload. For operations with documents (create, index, update), the document
 * content is converted to {@link BinaryData} to enable efficient size calculation and avoid re-serialization.
 * <p>
 * This is an internal utility class used by {@link BulkIngester} to track buffered operation sizes.
 */
class IngesterOperation<Context> {
    private final RetryableBulkOperation<Context> repeatableOp;
    private final long size;

    IngesterOperation(RetryableBulkOperation<Context> repeatableOp, long size) {
        this.repeatableOp = repeatableOp;
        this.size = size;
    }

    /**
     * Create an IngesterOperation from a retryable bulk operation, calculating its size.
     *
     * @param repeatableOp the retryable bulk operation to wrap
     * @param mapper       the JSON mapper for serialization
     * @return an IngesterOperation with calculated size
     */
    public static <Context> IngesterOperation<Context> of(RetryableBulkOperation<Context> repeatableOp, JsonpMapper mapper) {
        switch (repeatableOp.operation()._kind()) {
            case Create:
                return createOperation(repeatableOp, mapper);
            case Index:
                return indexOperation(repeatableOp, mapper);
            case Update:
                return updateOperation(repeatableOp, mapper);
            case Delete:
                return deleteOperation(repeatableOp);
            default:
                throw new IllegalStateException("Unknown bulk operation type " + repeatableOp.operation()._kind());
        }
    }

    /**
     * Get the wrapped retryable bulk operation.
     *
     * @return the retryable bulk operation
     */
    public RetryableBulkOperation<Context> repeatableOperation() {
        return this.repeatableOp;
    }

    /**
     * Get the estimated size in bytes of this operation.
     *
     * @return the operation size in bytes
     */
    public long size() {
        return this.size;
    }

    public BulkOperation operation() {
        return repeatableOp.operation();
    }

    public Context context() {
        return repeatableOp.context();
    }

    public boolean isSendable() {
        return repeatableOp.isSendable();
    }

    public boolean canRetry() {
        return repeatableOp.canRetry();
    }

    public Iterator<Long> retries() {
        return repeatableOp.retries();
    }

    private static <Context> IngesterOperation<Context> createOperation(RetryableBulkOperation<Context> repeatableOp, JsonpMapper mapper) {
        CreateOperation<?> create = repeatableOp.operation().create();
        RetryableBulkOperation<Context> newOperation;

        long size = basePropertiesSize(create);

        if (create.document() instanceof BinaryData) {
            newOperation = repeatableOp;
            size += ((BinaryData) create.document()).size();

        } else {
            BinaryData binaryDoc = BinaryData.of(create.document(), mapper);
            size += binaryDoc.size();
            newOperation = new RetryableBulkOperation<>(BulkOperation.of(bo -> bo.create(idx -> {
                copyCreateProperties(create, idx);
                return idx.document(binaryDoc);
            })), repeatableOp.context(), repeatableOp.retries());
        }

        return new IngesterOperation<>(newOperation, size);
    }

    private static <Context> IngesterOperation<Context> indexOperation(RetryableBulkOperation<Context> repeatableOp, JsonpMapper mapper) {
        IndexOperation<?> index = repeatableOp.operation().index();
        RetryableBulkOperation<Context> newOperation;

        long size = basePropertiesSize(index);

        if (index.document() instanceof BinaryData) {
            newOperation = repeatableOp;
            size += ((BinaryData) index.document()).size();

        } else {
            BinaryData binaryDoc = BinaryData.of(index.document(), mapper);
            size += binaryDoc.size();
            newOperation = new RetryableBulkOperation<>(BulkOperation.of(bo -> bo.index(idx -> {
                copyIndexProperties(index, idx);
                return idx.document(binaryDoc);
            })), repeatableOp.context(), repeatableOp.retries());
        }

        return new IngesterOperation<>(newOperation, size);
    }

    private static <Context> IngesterOperation<Context> updateOperation(RetryableBulkOperation<Context> repeatableOp, JsonpMapper mapper) {
        return updateOperation(repeatableOp, repeatableOp.operation().update(), mapper);
    }

    private static <Context, TDocument> IngesterOperation<Context> updateOperation(
        RetryableBulkOperation<Context> repeatableOp,
        UpdateOperation<TDocument> update,
        JsonpMapper mapper
    ) {
        final var data = update.data();
        final var binaryDoc = toBinaryData(data.document(), data.tDocumentSerializer(), mapper);
        final var binaryUpsert = toBinaryData(data.upsert(), data.tDocumentSerializer(), mapper);

        // Metadata line, estimated the same way as for index/create operations
        long size = basePropertiesSize(update) + size("require_alias", update.requireAlias()) + size(
            "retry_on_conflict",
            update.retryOnConflict()
        );

        // Data line: the documents are measured exactly via their binary form, the remainder (flags, script, _source)
        // is small and measured by serializing it without the documents.
        size += dataRemainderSize(data, mapper);
        if (binaryDoc != null) {
            size += size("doc", binaryDoc);
        }
        if (binaryUpsert != null) {
            size += size("upsert", binaryUpsert);
        }

        final RetryableBulkOperation<Context> newOperation;
        if ((Object) binaryDoc == data.document() && (Object) binaryUpsert == data.upsert()) {
            // Documents are absent or already binary: nothing to convert
            newOperation = repeatableOp;
        } else {
            newOperation = new RetryableBulkOperation<>(BulkOperation.of(bo -> bo.update(upd -> {
                copyUpdateProperties(update, upd);
                return upd.document(binaryDoc).upsert(binaryUpsert);
            })), repeatableOp.context(), repeatableOp.retries());
        }

        return new IngesterOperation<>(newOperation, size);
    }

    @Nullable
    private static <TDocument> BinaryData toBinaryData(
        @Nullable TDocument value,
        @Nullable JsonpSerializer<TDocument> serializer,
        JsonpMapper mapper
    ) {
        if (value == null) {
            return null;
        }
        if (value instanceof BinaryData) {
            return (BinaryData) value;
        }
        if (serializer == null) {
            return BinaryData.of(value, mapper);
        }

        final var out = new NoCopyByteArrayOutputStream();
        try (final var generator = mapper.jsonProvider().createGenerator(out)) {
            serializer.serialize(value, generator, mapper);
        }
        return BinaryData.of(out.array(), 0, out.size(), ContentType.APPLICATION_JSON);
    }

    /**
     * Size of the update data line without {@code doc} and {@code upsert}, including the enclosing braces.
     */
    private static long dataRemainderSize(UpdateOperationData<?> data, JsonpMapper mapper) {
        if (data.docAsUpsert() == null
            && data.scriptedUpsert() == null
            && data.detectNoop() == null
            && data.script() == null
            && data.source() == null) {
            return 2; // {}
        }

        final var remainder = new UpdateOperationData.Builder<Void>().docAsUpsert(data.docAsUpsert())
            .scriptedUpsert(data.scriptedUpsert())
            .detectNoop(data.detectNoop())
            .script(data.script())
            .source(data.source())
            .build();

        final var out = new CountingOutputStream();
        try (final var generator = mapper.jsonProvider().createGenerator(out)) {
            remainder.serialize(generator, mapper);
        }
        return out.count;
    }

    private static <Context> IngesterOperation<Context> deleteOperation(RetryableBulkOperation<Context> repeatableOp) {
        DeleteOperation delete = repeatableOp.operation().delete();
        return new IngesterOperation<>(repeatableOp, basePropertiesSize(delete));
    }

    private static void copyBaseProperties(BulkOperationBase op, BulkOperationBase.AbstractBuilder<?> builder) {
        builder.id(op.id())
            .index(op.index())
            .ifPrimaryTerm(op.ifPrimaryTerm())
            .ifSeqNo(op.ifSeqNo())
            .routing(op.routing())
            .version(op.version())
            .versionType(op.versionType());
    }

    private static void copyIndexProperties(IndexOperation<?> op, IndexOperation.Builder<?> builder) {
        copyBaseProperties(op, builder);
        builder.pipeline(op.pipeline());
        builder.requireAlias(op.requireAlias());
    }

    private static void copyCreateProperties(CreateOperation<?> op, CreateOperation.Builder<?> builder) {
        copyBaseProperties(op, builder);
        builder.pipeline(op.pipeline());
        builder.requireAlias(op.requireAlias());
    }

    private static void copyUpdateProperties(UpdateOperation<?> op, UpdateOperation.Builder<?> builder) {
        copyBaseProperties(op, builder);
        builder.requireAlias(op.requireAlias());
        builder.retryOnConflict(op.retryOnConflict());

        final var data = op.data();
        builder.docAsUpsert(data.docAsUpsert());
        builder.scriptedUpsert(data.scriptedUpsert());
        builder.detectNoop(data.detectNoop());
        builder.script(data.script());
        builder.source(data.source());
    }

    private static long size(String name, BinaryData value) {
        return name.length() + value.size() + 4; // 4 added chars for "name":value,
    }

    private static int size(String name, @Nullable Boolean value) {
        if (value != null) {
            return name.length() + 12; // 12 added chars for "name":"false",
        } else {
            return 0;
        }
    }

    private static int size(String name, @Nullable String value) {
        if (value != null) {
            return name.length() + value.length() + 6; // 6 added chars for "name":"value",
        } else {
            return 0;
        }
    }

    private static int size(String name, @Nullable Long value) {
        if (value != null) {
            // Borrowed from Long.toUnsignedString0, shift = 3 (base 10 is closer to 3 than 4)
            int mag = Integer.SIZE - Long.numberOfLeadingZeros(value);
            int chars = Math.max(((mag + (3 - 1)) / 3), 1);
            return name.length() + chars + 4; // 4 added chars for "name":,
        } else {
            return 0;
        }
    }

    private static int size(String name, @Nullable Integer value) {
        if (value != null) {
            // Borrowed from Integer.toUnsignedString0, shift = 3 (base 10 is closer to 3 than 4)
            int mag = Integer.SIZE - Integer.numberOfLeadingZeros(value);
            int chars = Math.max(((mag + (3 - 1)) / 3), 1);
            return name.length() + chars + 4;
        } else {
            return 0;
        }
    }

    private static int size(String name, @Nullable JsonEnum value) {
        if (value != null) {
            return name.length() + value.jsonValue().length() + 6;
        } else {
            return 0;
        }
    }

    private static int basePropertiesSize(BulkOperationBase op) {
        return size("id", op.id()) + size("index", op.index()) + size("if_primary_term", op.ifPrimaryTerm()) + size(
            "if_seq_no",
            op.ifSeqNo()
        ) + size("routing", op.routing()) + size("version", op.version()) + size("version_type", op.versionType()) + 4; // Open/closing
                                                                                                                        // brace, 2 newlines
    }

    private static final class CountingOutputStream extends OutputStream {
        private long count;

        @Override
        public void write(int b) {
            count++;
        }

        @Override
        public void write(byte[] b, int off, int len) {
            count += len;
        }
    }
}
