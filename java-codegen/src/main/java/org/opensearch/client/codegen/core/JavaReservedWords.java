package org.opensearch.client.codegen.core;

import software.amazon.smithy.codegen.core.ReservedWords;
import software.amazon.smithy.codegen.core.ReservedWordsBuilder;

public class JavaReservedWords {
    private static final String[] HARD_RESERVED_WORDS = {
            "null"
    };
    private static final ReservedWords INSTANCE;

    static {
        ReservedWordsBuilder builder = new ReservedWordsBuilder();
        for (String word : HARD_RESERVED_WORDS) {
            builder.put(word, "_" + word);
        }
        INSTANCE = builder.build();
    }

    public static ReservedWords instance() {
        return INSTANCE;
    }
}
