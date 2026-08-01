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

/**
 * One inference result of a streamed ML response, holding the outputs the model
 * produced for this chunk.
 */
public final class MlInferenceResult {

    private final List<MlOutput> output;

    private MlInferenceResult(Builder builder) {
        this.output = Collections.unmodifiableList(new ArrayList<>(builder.output));
    }

    /**
     * The outputs of this inference result. Never null; empty when the server sent none.
     */
    public List<MlOutput> output() {
        return output;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private final List<MlOutput> output = new ArrayList<>();

        public Builder addOutput(MlOutput out) {
            this.output.add(out);
            return this;
        }

        public MlInferenceResult build() {
            return new MlInferenceResult(this);
        }
    }
}
