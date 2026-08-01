/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.grpc.ml;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

/**
 * A single chunk of a streamed ML response.
 */
public final class MlStreamChunk {

    /** Name of the output that carries the incremental streamed payload. */
    private static final String RESPONSE_OUTPUT_NAME = "response";

    private final MlStreamStatus status;
    private final List<MlInferenceResult> inferenceResults;

    private MlStreamChunk(Builder builder) {
        this.status = builder.status;
        this.inferenceResults = Collections.unmodifiableList(new ArrayList<>(builder.inferenceResults));
    }

    /**
     * The status of this chunk, or null if the server did not set one.
     */
    @Nullable
    public MlStreamStatus status() {
        return status;
    }

    /**
     * The inference results of this chunk. Never null; empty when the server sent none.
     */
    public List<MlInferenceResult> inferenceResults() {
        return inferenceResults;
    }

    /**
     * The incremental text of this chunk — the {@code content} of the output named
     * {@code "response"} — or null if this chunk carries none.
     */
    @Nullable
    public String content() {
        MlOutput out = contentOutput();
        return out != null ? out.content() : null;
    }

    /**
     * Whether the server marked this as the final chunk, taken from the output named
     * {@code "response"}. Null when the server did not set the flag.
     */
    @Nullable
    public Boolean isLast() {
        MlOutput out = contentOutput();
        return out != null ? out.isLast() : null;
    }

    @Nullable
    private MlOutput contentOutput() {
        MlOutput fallback = null;
        for (MlInferenceResult result : inferenceResults) {
            for (MlOutput out : result.output()) {
                if (RESPONSE_OUTPUT_NAME.equals(out.name())) {
                    return out;
                }
                if (fallback == null && out.content() != null) {
                    fallback = out;
                }
            }
        }
        return fallback;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private MlStreamStatus status;
        private final List<MlInferenceResult> inferenceResults = new ArrayList<>();

        public Builder status(MlStreamStatus status) {
            this.status = status;
            return this;
        }

        public Builder addInferenceResult(MlInferenceResult result) {
            this.inferenceResults.add(result);
            return this;
        }

        public MlStreamChunk build() {
            return new MlStreamChunk(this);
        }
    }
}
