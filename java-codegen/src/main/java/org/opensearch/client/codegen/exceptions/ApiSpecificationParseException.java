package org.opensearch.client.codegen.exceptions;

public class ApiSpecificationParseException extends Exception {
    public ApiSpecificationParseException(String msg, Exception inner) {
        super(msg, inner);
    }
}
