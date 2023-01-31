package org.opensearch.client.codegen.core;

import org.jetbrains.annotations.Nullable;
import org.opensearch.client.codegen.OpenSearchJavaSettings;
import software.amazon.smithy.codegen.core.Symbol;
import software.amazon.smithy.codegen.core.SymbolProvider;
import software.amazon.smithy.model.Model;
import software.amazon.smithy.model.knowledge.HttpBindingIndex;
import software.amazon.smithy.model.shapes.Shape;

import java.util.Optional;

public class RenderingContext<T extends Shape> implements CodegenContext {
    private final Model model;
    private final SymbolProvider symbolProvider;
    private final HttpBindingIndex httpBindingIndex;
    private final OpenSearchJavaSettings settings;
    private final JavaWriter writer;
    private final T shape;
    private final Symbol symbol;

    public RenderingContext(CodegenContext other, JavaWriter writer, @Nullable T shape) {
        this(other, writer, shape, null);
    }

    public RenderingContext(CodegenContext other, JavaWriter writer, @Nullable T shape, Symbol symbol) {
        this.model = other.getModel();
        this.symbolProvider = other.getSymbolProvider();
        this.httpBindingIndex = other.getHttpBindingIndex();
        this.settings = other.getSettings();
        this.writer = writer;
        this.shape = shape;
        this.symbol = symbol != null ? symbol : this.symbolProvider.toSymbol(shape);
    }

    @Override
    public Model getModel() {
        return model;
    }

    @Override
    public SymbolProvider getSymbolProvider() {
        return symbolProvider;
    }

    @Override
    public HttpBindingIndex getHttpBindingIndex() {
        return httpBindingIndex;
    }

    @Override
    public OpenSearchJavaSettings getSettings() {
        return settings;
    }

    public JavaWriter getWriter() {
        return writer;
    }

    public Optional<T> getShape() {
        return Optional.ofNullable(shape);
    }

    public Symbol getSymbol() {
        return symbol;
    }
}
