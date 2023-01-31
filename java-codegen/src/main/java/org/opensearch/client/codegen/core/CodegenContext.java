package org.opensearch.client.codegen.core;

import org.opensearch.client.codegen.OpenSearchJavaSettings;
import software.amazon.smithy.codegen.core.SymbolProvider;
import software.amazon.smithy.model.Model;
import software.amazon.smithy.model.knowledge.HttpBindingIndex;

public interface CodegenContext {
    Model getModel();

    SymbolProvider getSymbolProvider();

    HttpBindingIndex getHttpBindingIndex();

    OpenSearchJavaSettings getSettings();
}
