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
 * A single chat message in an ML streaming request.
 */
public final class MlMessage {

    private final String role;
    private final String content;

    private MlMessage(Builder builder) {
        this.role = builder.role;
        this.content = builder.content;
    }

    /**
     * Creates a message with the given role and content.
     *
     * @param role    the message role (e.g., {@code "user"}, {@code "assistant"}, {@code "system"})
     * @param content the message content
     */
    public static MlMessage of(String role, String content) {
        return builder().role(role).content(content).build();
    }

    /**
     * The message role, or null if unset.
     */
    @Nullable
    public String role() {
        return role;
    }

    /**
     * The message content, or null if unset.
     */
    @Nullable
    public String content() {
        return content;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String role;
        private String content;

        public Builder role(String role) {
            this.role = role;
            return this;
        }

        public Builder content(String content) {
            this.content = content;
            return this;
        }

        public MlMessage build() {
            return new MlMessage(this);
        }
    }
}
