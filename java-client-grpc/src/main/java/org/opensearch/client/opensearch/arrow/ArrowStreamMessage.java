/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.arrow;

import javax.annotation.Nullable;
import org.apache.arrow.vector.ipc.message.ArrowRecordBatch;
import org.apache.arrow.vector.types.pojo.Schema;
import org.opensearch.protobufs.SearchResponse;

/**
 * One decoded message of an Arrow search stream: the schema, a record batch, or the closing summary.
 */
final class ArrowStreamMessage implements AutoCloseable {

    enum Kind {
        SCHEMA,
        BATCH,
        SUMMARY
    }

    final Kind kind;
    @Nullable
    final Schema schema;
    @Nullable
    final ArrowRecordBatch batch;
    @Nullable
    final SearchResponse summary;
    /** Size of the Arrow IPC message carried, 0 for the summary. */
    final long payloadBytes;

    private ArrowStreamMessage(Kind kind, Schema schema, ArrowRecordBatch batch, SearchResponse summary, long payloadBytes) {
        this.kind = kind;
        this.schema = schema;
        this.batch = batch;
        this.summary = summary;
        this.payloadBytes = payloadBytes;
    }

    static ArrowStreamMessage schema(Schema schema, long payloadBytes) {
        return new ArrowStreamMessage(Kind.SCHEMA, schema, null, null, payloadBytes);
    }

    static ArrowStreamMessage batch(ArrowRecordBatch batch, long payloadBytes) {
        return new ArrowStreamMessage(Kind.BATCH, null, batch, null, payloadBytes);
    }

    static ArrowStreamMessage summary(SearchResponse summary) {
        return new ArrowStreamMessage(Kind.SUMMARY, null, null, summary, 0);
    }

    /** Releases the Arrow memory of a batch. */
    @Override
    public void close() {
        if (batch != null) {
            batch.close();
        }
    }
}
