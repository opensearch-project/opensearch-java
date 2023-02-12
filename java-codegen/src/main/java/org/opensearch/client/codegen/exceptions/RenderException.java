package org.opensearch.client.codegen.exceptions;

public class RenderException extends Exception {
    public RenderException(String msg, Exception inner) {
        super(msg, inner);
    }
}
