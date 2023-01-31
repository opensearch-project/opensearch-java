package org.opensearch.client.codegen.model;

import software.amazon.smithy.codegen.core.Symbol;
import software.amazon.smithy.model.shapes.Shape;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class Symbols {
    private static final Map<String, String> BOXED_PRIMITIVES = new HashMap<String, String>() {{
        put("byte", "Byte");
        put("short", "Short");
        put("int", "Integer");
        put("long", "Long");
        put("float", "Float");
        put("double", "Double");
        put("boolean", "Boolean");
        put("char", "Character");
    }};
    private static final String SHAPE_KEY = "shape";
    private static final String NULLABLE_KEY = "nullable";

    public static Symbol boxed(Symbol symbol) {
        return boxed(symbol.toBuilder()).build();
    }

    public static Symbol.Builder boxed(Symbol.Builder builder) {
        Symbol symbol = builder.build();
        String namespace = symbol.getNamespace();

        if (namespace == null || namespace.isEmpty()) {
            String newName = BOXED_PRIMITIVES.get(symbol.getName());
            if (newName != null) {
                builder.name(newName);
            }
        }

        return builder;
    }

    public static Symbol.Builder nullable(Symbol.Builder builder) {
        return Symbols.boxed(builder).putProperty(NULLABLE_KEY, true);
    }

    public static boolean isNullable(Symbol symbol) {
        return symbol
                .getProperty(NULLABLE_KEY)
                .map(it -> {
                    if (it instanceof Boolean) {
                        return (boolean) it;
                    }
                    return false;
                })
                .orElse(false);
    }

    public static Shape getShape(Symbol symbol) {
        return symbol
                .getProperty(SHAPE_KEY, Shape.class)
                .orElseThrow(() -> new NoSuchElementException("Symbol is missing shape property"));
    }

    public static Symbol.Builder forShape(Shape shape, String name) {
        return Symbol
                .builder()
                .name(name)
                .putProperty(SHAPE_KEY, shape);
    }

    public static Symbol from(String namespace, String name) {
        return Symbol
                .builder()
                .name(name)
                .namespace(namespace, ".")
                .build();
    }

    public static Symbol from(Class<?> clazz) {
        return from(clazz.getPackage().getName(), clazz.getSimpleName());
    }
}
