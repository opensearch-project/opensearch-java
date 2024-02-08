package org.opensearch.client.codegen.utils;

public class Quartet<A, B, C, D> {
    private final A a;
    private final B b;
    private final C c;
    private final D d;

    private Quartet(A a, B b, C c, D d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public static <A, B, C, D> Quartet<A, B, C, D> of(A a, B b, C c, D d) {
        return new Quartet<>(a, b, c, d);
    }

    public A first() {
        return a;
    }

    public B second() {
        return b;
    }

    public C third() {
        return c;
    }

    public D fourth() {
        return d;
    }
}
