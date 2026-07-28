/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.grpc.ml;

import javax.annotation.Nullable;

/**
 * A single output entry of a streamed ML inference result.
 */
public final class MlOutput {

    private final String name;
    private final String result;
    private final String content;
    private final Boolean isLast;

    private MlOutput(Builder builder) {
        this.name = builder.name;
        this.result = builder.result;
        this.content = builder.content;
        this.isLast = builder.isLast;
    }

    /**
     * The output name (e.g., {@code "response"}), or null if unset.
     */
    @Nullable
    public String name() {
        return name;
    }

    /**
     * The output as a raw string, or null if unset.
     */
    @Nullable
    public String result() {
        return result;
    }

    /**
     * The incremental content of this chunk (protobuf {@code data_as_map.content}),
     * or null if unset.
     */
    @Nullable
    public String content() {
        return content;
    }

    /**
     * Whether the server marked this as the final chunk
     * (protobuf {@code data_as_map.is_last}), or null if unset.
     */
    @Nullable
    public Boolean isLast() {
        return isLast;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String name;
        private String result;
        private String content;
        private Boolean isLast;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder result(String result) {
            this.result = result;
            return this;
        }

        public Builder content(String content) {
            this.content = content;
            return this;
        }

        public Builder isLast(Boolean isLast) {
            this.isLast = isLast;
            return this;
        }

        public MlOutput build() {
            return new MlOutput(this);
        }
    }
}
