package org.opensearch.client.codegen.core;

import org.opensearch.client.codegen.OpenSearchJavaSettings;
import software.amazon.smithy.codegen.core.SymbolProvider;
import software.amazon.smithy.model.Model;
import software.amazon.smithy.model.knowledge.HttpBindingIndex;

public class GenerationContext implements CodegenContext {
    private final Model model;
    private final SymbolProvider symbolProvider;
    private final HttpBindingIndex httpBindingIndex;
    private final OpenSearchJavaSettings settings;

    public GenerationContext(Model model, SymbolProvider symbolProvider, HttpBindingIndex httpBindingIndex, OpenSearchJavaSettings settings) {
        this.model = model;
        this.symbolProvider = symbolProvider;
        this.httpBindingIndex = httpBindingIndex;
        this.settings = settings;
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
}
