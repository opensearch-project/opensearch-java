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
 * Parameters for an ML streaming request, mirroring the {@code parameters} object
 * of the REST ML predict and agent execute APIs.
 */
public final class MlParameters {

    private final List<MlMessage> messages;
    private final String inputs;
    private final String question;
    private final String llmInterface;

    private MlParameters(Builder builder) {
        this.messages = Collections.unmodifiableList(new ArrayList<>(builder.messages));
        this.inputs = builder.inputs;
        this.question = builder.question;
        this.llmInterface = builder.llmInterface;
    }

    /**
     * The chat messages. Never null; empty when unset.
     */
    public List<MlMessage> messages() {
        return messages;
    }

    /**
     * The raw {@code inputs} value, or null if unset.
     */
    @Nullable
    public String inputs() {
        return inputs;
    }

    /**
     * The {@code question} value, or null if unset.
     */
    @Nullable
    public String question() {
        return question;
    }

    /**
     * The LLM interface identifier (protobuf field {@code _llm_interface}),
     * or null if unset.
     */
    @Nullable
    public String llmInterface() {
        return llmInterface;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private final List<MlMessage> messages = new ArrayList<>();
        private String inputs;
        private String question;
        private String llmInterface;

        /**
         * Appends a single chat message.
         */
        public Builder addMessage(MlMessage message) {
            this.messages.add(message);
            return this;
        }

        /**
         * Appends a single chat message built from a role and content.
         */
        public Builder addMessage(String role, String content) {
            return addMessage(MlMessage.of(role, content));
        }

        public Builder inputs(String inputs) {
            this.inputs = inputs;
            return this;
        }

        public Builder question(String question) {
            this.question = question;
            return this;
        }

        /**
         * Sets the LLM interface identifier, e.g. {@code "openai/v1/chat/completions"}.
         * Maps to the protobuf {@code _llm_interface} field.
         */
        public Builder llmInterface(String llmInterface) {
            this.llmInterface = llmInterface;
            return this;
        }

        public MlParameters build() {
            return new MlParameters(this);
        }
    }
}
